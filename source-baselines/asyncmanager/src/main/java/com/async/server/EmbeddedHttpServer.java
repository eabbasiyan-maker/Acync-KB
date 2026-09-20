package com.async.server;


import com.async.util.ResourceHelper;
import com.async.util.Settings;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.alpn.server.ALPNServerConnectionFactory;
import org.eclipse.jetty.ee10.servlet.*;
import org.eclipse.jetty.http2.HTTP2Cipher;
import org.eclipse.jetty.http2.server.HTTP2CServerConnectionFactory;
import org.eclipse.jetty.http2.server.HTTP2ServerConnectionFactory;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLServerSocketFactory;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by h.mehrara on 1/27/2015.
 */
public class EmbeddedHttpServer {
    private static final Logger logger = LoggerFactory.getLogger(EmbeddedHttpServer.class);
    private static EmbeddedHttpServer instance;


    private Server server;
    private QueuedThreadPool pool;
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(Settings.HTTP_QUEUE_SIZE);

    public static void initialize() throws Exception {
        instance = new EmbeddedHttpServer();
        instance.run();
        logger.info("EmbeddedHttpServer initialized");
    }

    public static void unInitialize() {
        if (instance != null) {
            instance.shutdown();
            logger.info("EmbeddedHttpServer unInitialized");
        }
    }

    public void run() throws Exception {
        //noinspection unchecked
        pool = new QueuedThreadPool(
                Settings.HTTP_MAX_THREAD,
                Settings.HTTP_MIN_THREAD,
                Settings.HTTP_IDLE_TIMEOUT,
                queue);
        pool.setDetailedDump(false);
        server = new Server(pool);
        HttpConfiguration http_config = new HttpConfiguration();
        http_config.setSecureScheme("https");
        http_config.setSecurePort(Settings.HTTPS_PORT);
        http_config.setOutputBufferSize(Settings.HTTP_OUT_PUT_BUFFER_SIZE);
        http_config.setSendServerVersion(false);
        http_config.setSendXPoweredBy(false);

        // The ConnectionFactory for HTTP/1.1.
        HttpConnectionFactory http11 = new HttpConnectionFactory(http_config);

        // The ConnectionFactory for clear-text HTTP/2.
        HTTP2CServerConnectionFactory h2c = new HTTP2CServerConnectionFactory(http_config);

        List<Connector> connectors = new ArrayList<>();
        ServerConnector httpConnector = new ServerConnector(server, http11, h2c);
        httpConnector.setPort(Settings.HTTP_PORT);
        httpConnector.setIdleTimeout(Settings.HTTP_IDLE_TIMEOUT);
        connectors.add(httpConnector);
        logger.info("Async HTTP connector started. HTTP port: {}", Settings.HTTP_PORT);

        // Prepare ssl
        File keyFile = ResourceHelper.getInstance().getOrCreateFile(Settings.KEYSTORE_PATH);
        if (keyFile != null && keyFile.exists()) {
            try {
                // print available ciphers
                SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                String[] defaultCiphers = ssf.getDefaultCipherSuites();
                String[] availableCiphers = ssf.getSupportedCipherSuites();
                TreeMap ciphers = new TreeMap();
                for (String availableCipher : availableCiphers) {
                    ciphers.put(availableCipher, Boolean.FALSE);
                }
                for (String defaultCipher : defaultCiphers) {
                    ciphers.put(defaultCipher, Boolean.TRUE);
                }
                System.out.println("*** Available ciphers ***\nDefault\tCipher");
                for (Object o : ciphers.entrySet()) {
                    Map.Entry cipher = (Map.Entry) o;
                    if (Boolean.TRUE.equals(cipher.getValue())) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                    System.out.print('\t');
                    System.out.println(cipher.getKey());
                }

                SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
                sslContextFactory.setKeyStorePath(keyFile.getAbsolutePath());
                sslContextFactory.setKeyStorePassword(Settings.KEYSTORE_PASSWORD);
                sslContextFactory.setIncludeCipherSuites(Settings.HTTPS_INCLUDE_CIPHER);
                sslContextFactory.setExcludeCipherSuites(Settings.HTTPS_EXCLUDE_CIPHER);
                sslContextFactory.setIncludeProtocols(Settings.HTTPS_INCLUDE_PROTOCOLS);
                sslContextFactory.setExcludeProtocols(Settings.HTTPS_EXCLUDE_PROTOCOLS);
                sslContextFactory.setCipherComparator(HTTP2Cipher.COMPARATOR);
                sslContextFactory.setRenegotiationAllowed(false);   //prevent attack

                HttpConfiguration httpsConfig = new HttpConfiguration();
                // Add the SecureRequestCustomizer because TLS is used.
                SecureRequestCustomizer secureRequestCustomizer = new SecureRequestCustomizer();
                secureRequestCustomizer.setSniHostCheck(false);
                httpsConfig.addCustomizer(secureRequestCustomizer);
                httpsConfig.setSendServerVersion(false);

                // The ConnectionFactory for HTTP/1.1.
                HttpConnectionFactory http1_1 = new HttpConnectionFactory(httpsConfig);

                // The ConnectionFactory for HTTP/2.
                HTTP2ServerConnectionFactory h2 = new HTTP2ServerConnectionFactory(httpsConfig);

                // The ALPN ConnectionFactory.
                ALPNServerConnectionFactory alpn = new ALPNServerConnectionFactory();
                // The default protocol to use in case there is no negotiation.
                alpn.setDefaultProtocol(http1_1.getProtocol());
                // The ConnectionFactory for TLS.
                SslConnectionFactory tls = new SslConnectionFactory(sslContextFactory, alpn.getProtocol());

                // The ServerConnector instance.
                ServerConnector httpsConnector = new ServerConnector(server, tls, alpn, h2, http1_1);

                httpsConnector.setAcceptQueueSize(Settings.HTTP_POOL_SIZE);
                httpsConnector.setIdleTimeout(Settings.HTTP_IDLE_TIMEOUT);
                httpsConnector.setPort(Settings.HTTPS_PORT);
                connectors.add(httpsConnector);
                logger.info("Async HTTPS connector started. HTTPS port: {}", Settings.HTTPS_PORT);
                logger.info("SSL keystore path: {}", keyFile.getAbsolutePath());
            } catch (Exception ex) {
                logger.error("Can not initialize SSL", ex);
            }
        } else {
            logger.warn("Async HTTPS not initialized because keystore is not available: {}", Settings.KEYSTORE_PATH);
        }

        server.setConnectors(connectors.toArray(new Connector[0]));
        server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", 1000000000);

        // Static files
        ServletHolder wwwServlet;
        URI wwwUri = null;
        File wwwFile = new File("www");
        if (wwwFile.exists()) {
            wwwUri = wwwFile.toURI().normalize();
        } else {
            URL wwwJar = EmbeddedHttpServer.class.getClassLoader().getResource("www");
            if (wwwJar != null) {
                wwwUri = wwwJar.toURI().normalize();
            }
        }

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        if (wwwUri != null) {
            wwwServlet = new ServletHolder("www", DefaultServlet.class);
            wwwServlet.setInitParameter("dirAllowed", "false");
            context.setBaseResource(context.newResource(wwwUri));
            context.setWelcomeFiles(new String[]{"index.html"});
            logger.info("WWW root path: " + wwwUri);
        }
        context.addFilter(new FilterHolder(AsyncManagerFilter.class), "/*", EnumSet.of(DispatcherType.REQUEST));
        context.addServlet(new ServletHolder("async-manager-health-check", AsyncManagerCheckServlet.class), "/healthcheck/*");
        context.addServlet(new ServletHolder("provider-rate-limit", ProviderRateLimitServlet.class), "/rate-limit/provider/*");
        context.addServlet(new ServletHolder("business-rate-limit", BusinessRateLimitServlet.class), "/rate-limit/business/*");
        context.addServlet(new ServletHolder("ip-rate-limit", IPAddressRateLimitServlet.class), "/rate-limit/ip/*");
        context.addServlet(new ServletHolder("service-call-dispatcher", ServiceCallDispatcherServlet.class), "/service-call-dispatcher/*");
        context.addServlet(new ServletHolder("service-call-blocker", ServiceCallBlockerServlet.class), "/service-call-blocker/*");
        context.addServlet(new ServletHolder("rate-limit", RateLimitServlet.class), "/v2/rate-limit/*");
        context.addServlet(new ServletHolder("ip-rate-limit-v2", IpRateLimitManagerServlet.class), "/v2/rate-limit/ip/*");
        context.addServlet(new ServletHolder("ip-provider-rate-limit-v2", IpProviderRateLimitManagerServlet.class), "/v2/rate-limit/ip/provider/*");
        context.addServlet(new ServletHolder("ip-provider-service-rate-limit-v2", IpProviderServiceRateLimitManagerServlet.class), "/v2/rate-limit/ip/provider/service/*");
        context.addServlet(new ServletHolder("business-rate-limit-v2", BusinessRateLimitManagerServlet.class), "/v2/rate-limit/business/*");
        context.addServlet(new ServletHolder("business-provider-rate-limit-v2", BusinessProviderRateLimitManagerServlet.class), "/v2/rate-limit/business/provider/*");
        context.addServlet(new ServletHolder("business-provider-service-rate-limit-v2", BusinessProviderServiceRateLimitManagerServlet.class), "/v2/rate-limit/business/provider/service/*");
        context.addServlet(new ServletHolder("business-access", BusinessAccessServlet.class), "/business-access/*");
        context.addServlet(new ServletHolder("peer-access", PeerAccessServlet.class), "/peer-access/*");
        context.addServlet(new ServletHolder("message-saver", MessageSaverManagerServlet.class), "/message-saver/*");
        context.setSessionHandler(new SessionHandler());
        ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
        // Main context
        GzipHandler gzipHandler = new GzipHandler();
        gzipHandler.setMinGzipSize(245);
        gzipHandler.setHandler(context);
        contextHandlerCollection.addHandler(gzipHandler);

        server.setHandler(contextHandlerCollection);
        server.start();
        server.dump(System.out);
    }

    public void shutdown() {
        try {
            server.stop();
        } catch (Exception e) {
            logger.warn("An exception occurred", e);
        }
    }
}
