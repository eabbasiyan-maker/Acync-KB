package com.async.manager;

import com.async.activemq.anomaly.AnomalyConsumer;
import com.async.activemq.ratelimit.RateLimitConsumer;
import com.async.activemq.ratelimit.RateLimitProducer;
import com.async.exception.HttpException;
import com.async.object.AsyncServer;
import com.async.object.ServiceCallConfig;
import com.async.persistance.AsyncCRUD;
import com.async.ratelimit.DataGather;
import com.async.ratelimit.ProviderRateDefinition;
import com.async.ratelimit.RateLimitService;
import com.async.ratelimit.dto.BlockCountDto;
import com.async.ratelimit.dto.RateLimitConfigDto;
import com.async.server.vo.BusinessAccessDTO;
import com.async.server.vo.PeerAccessDTO;
import com.async.server.vo.RequestResultVO;
import com.async.server.vo.ResponseVO;
import com.async.util.JsonUtil;
import com.async.util.Settings;
import com.async.util.nosql.CacheCRUDInterface;
import com.async.util.nosql.aerospike.AerospikeCRUD;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.*;
import org.apache.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class AsyncManager {

    private static final Logger logger = LoggerFactory.getLogger(AsyncManager.class);
    public static ScheduledExecutorService timeOutProcedureExecutor = Executors.newSingleThreadScheduledExecutor();
    private static final ScheduledExecutorService asyncHealthCheckExecutor = Executors.newSingleThreadScheduledExecutor();
    public static ConcurrentHashMap<Integer, AsyncServer> asyncServers = new ConcurrentHashMap<>();
    private static final CacheCRUDInterface cacheCRUDInterface = new AerospikeCRUD();
    private static final List<String> anomalyActiveAddress = Settings.ANOMALY_QUEUE_ADDRESS;
    private static final List<String> rateLimitActiveAddress = Settings.RATE_LIMIT_QUEUE_ADDRESS;
    private static final ArrayList<AnomalyConsumer> anomalyConsumerArrayList = new ArrayList<>();
    public static Boolean isMainManager = false;
    private static OkHttpClient asyncClientForHealthCheck;
    private static OkHttpClient asyncClientForSendAction;
    static ArrayList<RateLimitProducer> rateLimitProducerArrayList = new ArrayList<>();
    static ArrayList<RateLimitConsumer> rateLimitConsumerArrayList = new ArrayList<>();

    private static void removeClients(int serverId) {
        if (Settings.REMOVE_CLIENT_MAP) {
            logger.warn("start to delete clients from serverId={}", serverId);

            //delete clients from client_map table
            AsyncCRUD.deleteClients(serverId);

            //delete serverId from aerospike client cache
            cacheCRUDInterface.invalidateClientCacheByServerId(serverId);

            //delete memory cache from other async servers
            try {
                asyncServers.forEach((asyncServerId, asyncServer) -> {
                    if (asyncServer.isAlive()) {
                        Request request = new Request.Builder().url(asyncServer.getUrl() + "/cache?serverId=" + serverId).delete().build();
                        Call asyncCall = asyncClientForHealthCheck.newCall(request);
                        asyncCall.enqueue(new Callback() {
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                //todo manage failed requests
                                logger.error("Exception in remove client cache from asynServer= {} for serverId={}  ", asyncServerId, serverId, e);
                            }

                            @Override
                            public void onResponse(@NotNull Call call, @NotNull Response response) {
                                if (response.code() == 200)
                                    logger.warn("remove client cache from asynServer= {} for serverId={}  ", asyncServerId, serverId);
                                else
                                    logger.error("Exception in remove client cache from asynServer= {} for serverId={} statusCode={} message={} ", asyncServerId, serverId, response.code(), response.message());
                                Objects.requireNonNull(response.body()).close();
                            }
                        });
                    }
                });
            } catch (Exception e) {
                logger.error("Exception in remove client cache for serverId={} ", serverId, e);
            }
        }
    }

    public static void checkAsyncServers() {
        if (isMainManager) {
            try {
                asyncServers.forEach((serverId, asyncServer) -> {
                    logger.debug("start check async serverId={}", serverId);
                    Request request = new Request.Builder().url(asyncServer.getUrl() + "/healthcheck/").build();
                    Call asyncCall = asyncClientForHealthCheck.newCall(request);
                    boolean isAlive;
                    try {
                        Response response = asyncCall.execute();
                        isAlive = response.code() == 200;
                        if (asyncServer.isAlive() != isAlive) {
                            asyncServer.setAlive(isAlive);
                            logger.debug("Async Server status : serverId={} , isAlive={}", serverId, isAlive);
                            if (!isAlive) {
                                asyncServer.incrementRetryCount();
                                if (asyncServer.getRetryCount() == Settings.ASYNC_CHECK_MAX_RETRY_COUNT) {
                                    removeClients(serverId);
                                }
                            } else {
                                asyncServer.setRetryCount(0);
                                logger.info("Async Server check success for serverId={}", serverId);
                            }
                        }
                        if (!isAlive)
                            logger.error("Async Server check failed for serverId={} , retryCount={} , response code={}",
                                    serverId, asyncServer.getRetryCount(), response.code());
                        else
                            logger.debug("Async Server check success for serverId={}", serverId);
                        Objects.requireNonNull(response.body()).close();
                    } catch (IOException e) {
                        asyncServer.setAlive(false);
                        asyncServer.incrementRetryCount();
                        logger.error("Async Server check failed for serverId={} , retryCount={}",
                                serverId, asyncServer.getRetryCount(), e);
                        if (asyncServer.getRetryCount() == Settings.ASYNC_CHECK_MAX_RETRY_COUNT) {
                            removeClients(serverId);
                        }
                    }
                });
            } catch (Exception e) {
                logger.error("Exception in check Async servers ", e);
            }
        }
    }

    public static void executeTimeOutsProcedures() {
        if (isMainManager) {
            logger.info("try to execute TIMEOUT stored procedures");
            AsyncCRUD.executeProcedure("TIMEOUT_MESSAGES", System.currentTimeMillis());
            AsyncCRUD.executeProcedure("TIMEOUT_MESSAGES_PENDING", System.currentTimeMillis());
            AsyncCRUD.executeProcedure("TIMEOUT_PEERS", System.currentTimeMillis());
            logger.info("end of execute TIMEOUT stored procedures");
        }
    }

    public static void setIsMainManager(boolean isMain) {
        if (isMain != isMainManager) {
            logger.warn("ManagerId={} status changed to {} ", Settings.MANAGER_ID, isMain ? " Main Manager" : " Worker");
        }
        isMainManager = isMain;
    }

    private static void loadCoreAsyncServers(List<String> asyncServerIds, List<String> asyncURLlist) {
        if (asyncServerIds != null && asyncURLlist != null) {
            for (int i = 0; i < asyncServerIds.size(); i++) {
                asyncServers.put(Integer.parseInt(asyncServerIds.get(i)), new AsyncServer(Integer.parseInt(asyncServerIds.get(i)), asyncURLlist.get(i), System.currentTimeMillis(), "core"));
            }
        }
    }

    private static void loadChatAsyncServers(List<String> asyncServerIds, List<String> asyncURLlist) {
        if (asyncServerIds != null && asyncURLlist != null) {
            for (int i = 0; i < asyncServerIds.size(); i++) {
                asyncServers.put(Integer.parseInt(asyncServerIds.get(i)), new AsyncServer(Integer.parseInt(asyncServerIds.get(i)), asyncURLlist.get(i), System.currentTimeMillis(), "chat"));
            }
        }
    }

    private static void loadSsoAsyncServers(List<String> asyncServerIds, List<String> asyncURLlist) {
        if (asyncServerIds != null && asyncURLlist != null) {
            for (int i = 0; i < asyncServerIds.size(); i++) {
                asyncServers.put(Integer.parseInt(asyncServerIds.get(i)), new AsyncServer(Integer.parseInt(asyncServerIds.get(i)), asyncURLlist.get(i), System.currentTimeMillis(), "sso"));
            }
        }
    }


    public static void initialize() throws SQLException {
        loadCoreAsyncServers(Settings.CORE_SERVER_IDS, Settings.CORE_SERVER_URLS);
        loadChatAsyncServers(Settings.CHAT_SERVER_IDS, Settings.CHAT_SERVER_URLS);
        loadSsoAsyncServers(Settings.SSO_SERVER_IDS, Settings.SSO_SERVER_URLS);
        ConnectionPool connectionPool = new ConnectionPool(Settings.REST_MAX_IDLE_CONNECTION, Settings.REST_DEFAULT_KEEP_ALIVE_TIMEOUT, TimeUnit.MILLISECONDS);
        asyncClientForSendAction = new OkHttpClient.Builder().connectionPool(connectionPool).callTimeout(Settings.ASYNC_ACTION_TIME_OUT, TimeUnit.MILLISECONDS).build();
        if (Settings.HAS_RATE_LIMIT) {
            ProviderRateDefinition.initialize();
            DataGather.initialize();
            RateLimitService.initialize();
            logger.info("*************  Start Internal Queue Active  initialized**********");
            initializeRateLimitProducerAndConsumer();
            initializeAnomalyConsumer();
            logger.info("************* End Internal Queue Active initialized**********");
        }
        if (Settings.CHECK_ASYNC) {
            asyncHealthCheckExecutor.scheduleAtFixedRate(AsyncManager::checkAsyncServers, Settings.ASYNC_CHECK_INITIAL_DELAY_MS, Settings.ASYNC_CHECK_PERIOD_MS, TimeUnit.MILLISECONDS);
            asyncClientForHealthCheck = new OkHttpClient.Builder().connectTimeout(Settings.ASYNC_CHECK_TIME_OUT, TimeUnit.MILLISECONDS).build();
        }
        if (Settings.EXECUTE_TIMOUT_PROCEDURES)
            timeOutProcedureExecutor.scheduleAtFixedRate(AsyncManager::executeTimeOutsProcedures, Settings.EXECUTE_TIMOUT_PROCEDURES_INITIAL_DELAY_MS, Settings.EXECUTE_TIMOUT_PROCEDURES_PERIOD_MS, TimeUnit.MILLISECONDS);
        logger.info("AsyncManager initialized ");
    }

    private static void initializeRateLimitProducerAndConsumer() {
        for (int i = 1; i <= Settings.RATE_LIMIT_PRODUCER_COUNT; i++) {
            rateLimitProducerArrayList.add(new RateLimitProducer().initialize(String.valueOf(i), Settings.RATE_LIMIT_QUEUE_USERNAME, Settings.RATE_LIMIT_QUEUE_PASSWORD, getRateLimitActiveAddress()));
        }
        for (int i = 1; i <= Settings.RATE_LIMIT_CONSUMER_COUNT; i++) {
            rateLimitConsumerArrayList.add(new RateLimitConsumer().initialize(i + "", Settings.RATE_LIMIT_QUEUE_USERNAME, Settings.RATE_LIMIT_QUEUE_PASSWORD, getRateLimitActiveAddress(), false));
        }
        logger.info("rate limit Consumer initialized");
    }

    private static void initializeAnomalyConsumer() {
        for (int i = 1; i <= Settings.ANOMALY_CONSUMER_COUNT; i++) {
            anomalyConsumerArrayList.add(new AnomalyConsumer().initialize(i + "", Settings.ANOMALY_QUEUE_USERNAME, Settings.ANOMALY_QUEUE_PASSWORD, getAnomalyActiveAddress(), false));
        }
        logger.info("anomaly Consumer initialized");
    }

    public static synchronized String getAnomalyActiveAddress() {
        anomalyActiveAddress.add(0, anomalyActiveAddress.remove(anomalyActiveAddress.size() - 1));
        return String.join(",", anomalyActiveAddress);
    }

    public static synchronized String getRateLimitActiveAddress() {
        rateLimitActiveAddress.add(0, rateLimitActiveAddress.remove(rateLimitActiveAddress.size() - 1));
        return String.join(",", rateLimitActiveAddress);
    }

    public static RateLimitProducer getProducer() {
        return rateLimitProducerArrayList.get(new Random().nextInt(Settings.RATE_LIMIT_PRODUCER_COUNT));
    }

    public static void unInitialize() {
        try {
            asyncHealthCheckExecutor.shutdown();
            timeOutProcedureExecutor.shutdown();
            logger.info("AsyncManager unInitialized ");
        } catch (Exception e) {
            logger.error("Exception in AsyncManager unInitialize", e);
        }
    }

    public static ConcurrentHashMap<Integer, AsyncServer> getAsyncServers() {
        return asyncServers;
    }

    public static List<AsyncServer> getAsyncServers(Boolean isAlive) {
        return asyncServers.values().stream().filter(asyncServer -> asyncServer.isAlive() == isAlive).collect(Collectors.toList());
    }

    public static List<AsyncServer> getAsyncServers(HttpServletRequest req) {
        List<AsyncServer> asyncServers;
        if (req.getParameter("serverId") != null) {
            List<String> serverIds = Arrays.stream(req.getParameterValues("serverId")).collect(Collectors.toList());
            asyncServers = getAsyncServers(serverIds);
        } else if (req.getParameter("cluster") != null) {
            List<String> cluster = Arrays.stream(req.getParameterValues("cluster")).collect(Collectors.toList());
            asyncServers = getAsyncServersByCluster(cluster);
        } else {
            asyncServers = getAsyncServers(true);
        }
        return asyncServers;
    }

    public static List<AsyncServer> getAsyncServers(List<String> serverIds) {
        return asyncServers.values().stream().filter(asyncServer -> serverIds.contains(asyncServer.getServerId() + "")).collect(Collectors.toList());
    }

    public static List<AsyncServer> getAsyncServersByCluster(List<String> cluster) {
        return asyncServers.values().stream().filter(asyncServer -> cluster.contains(asyncServer.getCluster())).collect(Collectors.toList());
    }

    public static List<ResponseVO<Object>> sendActionToAsyncServers(String method, PeerAccessDTO peerAccessDTO, String token, List<AsyncServer> asyncServers, String action) throws InterruptedException, HttpException {
        RequestBody requestBody = RequestBody.create(JsonUtil.getJson(peerAccessDTO), MediaType.parse("application/json; charset=utf-8"));
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        if (method.equals("post")) {
            builder.post(requestBody);
        } else if (method.equals("delete")) {
            builder.delete(requestBody);
        }
        List<ResponseVO<Object>> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send to async serverId={}, method={}, businessID={}, peerId={} ",
                    asyncServer.getServerId(), method, peerAccessDTO.getBusinessId(), peerAccessDTO.getPeerId());
            Request request = builder.url(asyncServer.getUrl() + "/access/" + action).build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    ResponseVO<Object> resultVO = ResponseVO.error(HttpStatus.SC_REQUEST_TIMEOUT, e.getMessage());
                    resultList.add(resultVO);
                    logger.error("Exception in send to async serverId={} ,method={} ,businessId={} ,peerId={} ",
                            asyncServer.getServerId(), method, peerAccessDTO.getBusinessId(), peerAccessDTO.getPeerId(), e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in send to async serverId={} ,method={} ,businessId={} ,peerId={} ",
                                asyncServer.getServerId(), method, peerAccessDTO.getBusinessId(), peerAccessDTO.getPeerId(), e);
                    }
                    ResponseVO<Object> resultVO;
                    if (response.code() == HttpStatus.SC_OK) {
                        resultVO = ResponseVO.ok(peerAccessDTO);
                        logger.info("done successfully by serverId={}, method={}, businessId={}, peerId={} ",
                                asyncServer.getServerId(), method, peerAccessDTO.getBusinessId(), peerAccessDTO.getPeerId());
                    } else {
                        resultVO = ResponseVO.error(response.code(), message);
                        logger.warn("Exception in do action by serverId={} , method={} , businessId={}, peerId={} ",
                                asyncServer.getServerId(), method, peerAccessDTO.getBusinessId(), peerAccessDTO.getPeerId());
                    }
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty()) {
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        }
        return resultList;
    }

    public static List<ResponseVO<Object>> sendActionToAsyncServers(String method, BusinessAccessDTO businessAccessDTO, String token, List<AsyncServer> asyncServers, String action) throws InterruptedException, HttpException {
        RequestBody requestBody = RequestBody.create(JsonUtil.getJson(businessAccessDTO), MediaType.parse("application/json; charset=utf-8"));
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        if (method.equals("post")) {
            builder.post(requestBody);
        } else if (method.equals("put")) {
            builder.put(requestBody);
        } else if (method.equals("delete")) {
            builder.delete(requestBody);
        }
        List<ResponseVO<Object>> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send to async serverId={}, method={}, businessID={} ",
                    asyncServer.getServerId(), method, businessAccessDTO.getBusinessId());
            Request request = builder.url(asyncServer.getUrl() + "/access/" + action).build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    ResponseVO<Object> resultVO = ResponseVO.error(HttpStatus.SC_REQUEST_TIMEOUT, e.getMessage());
                    resultList.add(resultVO);
                    logger.error("Exception in send to async serverId={} ,method={} ,businessId={} ",
                            asyncServer.getServerId(), method, businessAccessDTO.getBusinessId(), e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in send to async serverId={} ,method={} ,businessId={} ",
                                asyncServer.getServerId(), method, businessAccessDTO.getBusinessId(), e);
                    }
                    ResponseVO<Object> resultVO;
                    if (response.code() == HttpStatus.SC_OK) {
                        resultVO = ResponseVO.ok(businessAccessDTO);
                        logger.info("done successfully by serverId={}, method={}, businessId={} ",
                                asyncServer.getServerId(), method, businessAccessDTO.getBusinessId());
                    } else {
                        resultVO = ResponseVO.error(response.code(), message);
                        logger.warn("Exception in do action by serverId={} , method={} , businessId={} ",
                                asyncServer.getServerId(), method, businessAccessDTO.getBusinessId());
                    }
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty()) {
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        }
        return resultList;
    }

    public static List<RequestResultVO> sendActionToAsyncServers(String method, ServiceCallConfig serviceCallConfig, String token, List<AsyncServer> asyncServers, String action) throws InterruptedException, HttpException {
        RequestBody requestBody = RequestBody.create(JsonUtil.getJson(serviceCallConfig), MediaType.parse("application/json; charset=utf-8"));
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        if (method.equals("post")) {
            builder.post(requestBody);
        } else if (method.equals("delete")) {
            builder.delete(requestBody);
        }
        List<RequestResultVO> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send to async serverId={} , method={} , productId={} , peerName={} , businessId={} ",
                    asyncServer.getServerId(), method, serviceCallConfig.getProductId(), serviceCallConfig.getPeerName(), serviceCallConfig.getBusinessId());
            Request request = builder.url(asyncServer.getUrl() + "/service-call-configurator/" + action).build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), false, e.getMessage(), HttpStatus.SC_REQUEST_TIMEOUT);
                    resultList.add(resultVO);
                    logger.error("Exception in send to async serverId={} , method={} , productId={} , peerName={} , businessId={} ",
                            asyncServer.getServerId(), method, serviceCallConfig.getProductId(), serviceCallConfig.getPeerName(), serviceCallConfig.getBusinessId(), e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in send to async serverId={} , method={} , productId={} , peerName={} , businessId={} ",
                                asyncServer.getServerId(), method, serviceCallConfig.getProductId(), serviceCallConfig.getPeerName(), serviceCallConfig.getBusinessId(), e);
                    }
                    boolean isSuccess;
                    if (response.code() == HttpStatus.SC_OK) {
                        isSuccess = true;
                        logger.info("done successfully by serverId={} , method={} , productId={} , peerName={} , businessId={} ",
                                asyncServer.getServerId(), method, serviceCallConfig.getProductId(), serviceCallConfig.getPeerName(), serviceCallConfig.getBusinessId());
                    } else {
                        isSuccess = false;
                        logger.warn("Exception in do action by serverId={} , method={} , productId={} , peerName={} , businessId={} ",
                                asyncServer.getServerId(), method, serviceCallConfig.getProductId(), serviceCallConfig.getPeerName(), serviceCallConfig.getBusinessId());
                    }
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), isSuccess, message, response.code());
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty()) {
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        }
        return resultList;
    }

    public static List<RequestResultVO> sendActionToAsyncServers(String pathInfo, String method, BlockCountDto blockCountDto, String token, List<AsyncServer> asyncServers) throws InterruptedException, HttpException {
        RequestBody requestBody = RequestBody.create(JsonUtil.getJson(blockCountDto), MediaType.parse("application/json; charset=utf-8"));
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        if (method.equals("post"))
            builder.post(requestBody);
        else if (method.equals("delete"))
            builder.delete(requestBody);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        List<RequestResultVO> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send {} to async serverId={} , method={} , provider={} , path={} , businessId={} , ip={} , count={} ",
                    pathInfo, asyncServer.getServerId(), method, blockCountDto.getProvider(), blockCountDto.getPath(),
                    blockCountDto.getBusinessId(), blockCountDto.getIp(), blockCountDto.getCount());
            Request request = builder.url(asyncServer.getUrl() + pathInfo).build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), false, e.getMessage(), HttpStatus.SC_REQUEST_TIMEOUT);
                    resultList.add(resultVO);
                    logger.error("Exception in send {} to serverId={} , method={} , provider={} , path={} , businessId={} , ip={} , count={} ",
                            pathInfo, asyncServer.getServerId(), method, blockCountDto.getProvider(), blockCountDto.getPath(),
                            blockCountDto.getBusinessId(), blockCountDto.getIp(), blockCountDto.getCount(), e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in get response body, pathInfo={} serverId={} , method={} , provider={} , path={} , businessId={} , ip={} , count={} ",
                                pathInfo, asyncServer.getServerId(), method, blockCountDto.getProvider(), blockCountDto.getPath(),
                                blockCountDto.getBusinessId(), blockCountDto.getIp(), blockCountDto.getCount(), e);
                    }
                    boolean isSuccess;
                    if (response.code() == HttpStatus.SC_OK) {
                        isSuccess = true;
                        logger.warn("{} done successfully by serverId={} , method={} , provider={} , path={} , businessId={} , ip={} , count={}  ",
                                pathInfo, asyncServer.getServerId(), method, blockCountDto.getProvider(), blockCountDto.getPath(),
                                blockCountDto.getBusinessId(), blockCountDto.getIp(), blockCountDto.getCount());
                    } else {
                        isSuccess = false;
                        logger.error("Exception in do {} by serverId={} statusCode={} message={} , method={} , provider={} , path={} , businessId={} , ip={} , count={} ",
                                pathInfo, asyncServer.getServerId(), response.code(), message, method, blockCountDto.getProvider(), blockCountDto.getPath(),
                                blockCountDto.getBusinessId(), blockCountDto.getIp(), blockCountDto.getCount());
                    }
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), isSuccess, message, response.code());
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty())
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        return resultList;
    }

    public static List<RequestResultVO> sendActionToAsyncServers(String method, RateLimitConfigDto rateLimitConfigDto, String token, List<AsyncServer> asyncServers, String action) throws InterruptedException, HttpException {
        RequestBody requestBody = RequestBody.create(JsonUtil.getJson(rateLimitConfigDto), MediaType.parse("application/json; charset=utf-8"));
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        if (method.equals("post")) {
            builder.post(requestBody);
        } else if (method.equals("delete")) {
            builder.delete(requestBody);
        }
        List<RequestResultVO> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send to async serverId={} , method={} , type={} , key={} , capacity={} , refillInterval={} ",
                    asyncServer.getServerId(), method, rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getRefillInterval());
            Request request = builder.url(asyncServer.getUrl() + "/v2/rate-limit/" + action).build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), false, e.getMessage(), HttpStatus.SC_REQUEST_TIMEOUT);
                    resultList.add(resultVO);
                    logger.error("Exception in send to async serverId={} , method={} , type={} , key={} , capacity={} , refillInterval={} ",
                            asyncServer.getServerId(), method, rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getRefillInterval(), e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in send to async serverId={} , method={} , type={} , key={} , capacity={} , refillInterval={} ",
                                asyncServer.getServerId(), method, rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getRefillInterval(), e);
                    }
                    boolean isSuccess;
                    if (response.code() == HttpStatus.SC_OK) {
                        isSuccess = true;
                        logger.info("done successfully by serverId={} , method={} , type={} , key={} , capacity={} , refillInterval={} ",
                                asyncServer.getServerId(), method, rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getRefillInterval());
                    } else {
                        isSuccess = false;
                        logger.warn("Exception in do action by serverId={} , method={} , type={} , key={} , capacity={} , refillInterval={} ",
                                asyncServer.getServerId(), method, rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getRefillInterval());
                    }
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), isSuccess, message, response.code());
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty()) {
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        }
        return resultList;
    }

    public static List<RequestResultVO> sendActionToAsyncServers(String method, boolean config, String token, List<AsyncServer> asyncServers, String action) throws InterruptedException, HttpException {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", token);
        CountDownLatch latch = new CountDownLatch(asyncServers.size());
        List<RequestResultVO> resultList = new ArrayList<>();
        asyncServers.forEach(asyncServer -> {
            logger.info("send to async serverId={} , method={} , insertToDB={} ", asyncServer.getServerId(), method, config);
            String fullPath = asyncServer.getUrl() + "/message-saver/" + action;
            HttpUrl parsedUrl = HttpUrl.parse(fullPath);
            if (parsedUrl == null) {
                logger.error("Invalid URL format for async server: {}", fullPath);
                resultList.add(new RequestResultVO(asyncServer.getServerId(), false, "Invalid URL", HttpStatus.SC_INTERNAL_SERVER_ERROR));
                latch.countDown();
                return;
            }
            HttpUrl url = parsedUrl.newBuilder()
                    .addQueryParameter("insertToDB", String.valueOf(config))
                    .build();
            Request request = builder
                    .url(url)
                    .put(RequestBody.create("", MediaType.parse("application/json")))
                    .build();
            OkHttpClient okHttpClient = asyncClientForSendAction.newBuilder().build();
            Call asyncCall = okHttpClient.newCall(request);
            asyncCall.enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), false, e.getMessage(), HttpStatus.SC_REQUEST_TIMEOUT);
                    resultList.add(resultVO);
                    logger.error("Exception in send to async serverId={} , method={} , insertToDB={} ", asyncServer.getServerId(), method, config, e);
                    latch.countDown();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    String message = response.message();
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            message = responseBody.string();
                            responseBody.close();
                        }
                    } catch (IOException e) {
                        logger.error("Exception in send to async serverId={} , method={} ,insertToDB={} ", asyncServer.getServerId(), method, config, e);
                    }
                    boolean isSuccess;
                    if (response.code() == HttpStatus.SC_OK) {
                        isSuccess = true;
                        logger.info("done successfully by serverId={} , method={} , insertToDB={} ", asyncServer.getServerId(), method, config);
                    } else {
                        isSuccess = false;
                        logger.warn("Exception in do action by serverId={} , method={} , insertToDB={} ", asyncServer.getServerId(), method, config);
                    }
                    RequestResultVO resultVO = new RequestResultVO(asyncServer.getServerId(), isSuccess, message, response.code());
                    resultList.add(resultVO);
                    latch.countDown();
                }
            });
        });
        boolean result = latch.await(Settings.ASYNC_ACTION_LATCH_AWAIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (!result && resultList.isEmpty()) {
            throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);
        }
        return resultList;
    }
}
