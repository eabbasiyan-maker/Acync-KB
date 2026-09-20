package com.async.ratelimit;

import com.async.exception.HttpException;
import com.async.exception.ServerException;
import com.async.manager.AsyncManager;
import com.async.object.AsyncServer;
import com.async.object.Provider;
import com.async.persistance.AsyncCRUD;
import com.async.ratelimit.dto.*;
import com.async.util.KeyleadUtil;
import com.async.util.Settings;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimitService {
    private static final DiskFileItemFactory factory;
    private static final Logger logger = LoggerFactory.getLogger(RateLimitService.class);
    private static final HashMap<String, BusinessDto> business;
    private static final HashMap<String, IpAddressDto> ipAddressMap;
    private static final ScheduledExecutorService rateLimitExecutor = Executors.newSingleThreadScheduledExecutor();
    private static final Map<String, RateLimitConfigDto> rateLimitConfigMap = new ConcurrentHashMap<>();
    private static final Map<String, ScheduledFuture<?>> rateLimitTasks = new HashMap<>();

    static {
        factory = new DiskFileItemFactory();
        factory.setSizeThreshold(Settings.UPLOAD_MAX_MEM_SIZE);
        factory.setRepository(new File(Settings.UPLOADED_TEMP_DIR));
        business = AsyncCRUD.getBusiness();
        ipAddressMap = AsyncCRUD.getIpAddress();
    }

    public static void initialize() {
        List<RateLimitConfigDto> rateLimitConfigDtoList = RateLimitService.loadRateLimitConfig();
        for (RateLimitConfigDto rateLimitConfigDto : rateLimitConfigDtoList) {
            scheduleAndRegisterRateLimitRefresher(rateLimitConfigDto);
        }
    }

    public static void addToRateLimitConfigMap(String key, RateLimitConfigDto rateLimitConfig) {
        rateLimitConfigMap.put(key, rateLimitConfig);
        logger.info("Added/Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={} map size is: {}", key, rateLimitConfig.getCapacity(), rateLimitConfig.getRefillInterval(), rateLimitConfig.getExpireTime(), rateLimitConfig.getCountThreshold(), System.currentTimeMillis(), rateLimitConfigMap.size());
    }

    public static void addProvider(HttpServletRequest request, String name, Double rateFactor) throws FileUploadException, IOException, SQLException, HttpException {
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(Settings.UPLOAD_MAX_FILE_SIZE);
        List<FileItem> fileItems = upload.parseRequest(getRequestContext(request));
        if (fileItems != null && fileItems.size() > 0) {
            if (rateFactor == null)
                rateFactor = Settings.RATE_LIMIT_FACTOR;
            logger.info("start action=add provider, provider={} ,factor={}", name, rateFactor);
            Provider provider = AsyncCRUD.addProvider(name, fileItems.get(0).getInputStream(), rateFactor);
            if (provider != null) {
                ProviderRateDefinition.addProvider(provider, fileItems.get(0));
                logger.info("provider={} saved successfully,id={} ,factor={}", name, provider.getId(), provider.getFactor());
            } else
                logger.warn("Problem in save provider={}", name);
            fileItems.get(0).getInputStream().close();

        } else {
            logger.error("file not found for save provider={}", name);
            throw new IOException("file not found");
        }
    }

    public static void editProvider(HttpServletRequest request, Provider provider, Double rateFactor) throws FileUploadException, SQLException, IOException {
        FileItem file = null;
        if (ServletFileUpload.isMultipartContent(getRequestContext(request))) {
            logger.info("get multipart content");
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(Settings.UPLOAD_MAX_FILE_SIZE);
            List<FileItem> fileItems = upload.parseRequest(getRequestContext(request));
            if (fileItems != null && fileItems.size() > 0) {
                logger.info("fileSize = {}", fileItems.get(0).getSize());
                file = fileItems.get(0);
            }
        }
        logger.info("start action=edit provider, provider={}", provider.getName());
        AsyncCRUD.editProvider(provider, file != null ? file.getInputStream() : null, rateFactor);
        if (rateFactor != null)
            provider.setFactor(rateFactor);
        ProviderRateDefinition.addProvider(provider, file);
        if (file != null) {
            file.getInputStream().close();
        }
        logger.info("provider={} edited successfully,factor={}", provider.getName(), provider.getFactor());
    }

    @NotNull
    public static RequestContext getRequestContext(HttpServletRequest request) {
        return new RequestContext() {
            @Override
            public String getCharacterEncoding() {
                return request.getCharacterEncoding();
            }

            @Override
            public String getContentType() {
                return request.getContentType();
            }

            @Override
            public int getContentLength() {
                return request.getContentLength();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return request.getInputStream();
            }
        };
    }

    public static Map<String, List<ProviderPathInfo>> deleteProvider(String name) throws SQLException, InterruptedException, HttpException {
        Map<String, List<ProviderPathInfo>> blockCountList = getProviderStatus(name);
        if (blockCountList == null || blockCountList.isEmpty()) {
            logger.info("start delete provider={}", name);
            AsyncCRUD.deleteProvider(name);
            ProviderRateDefinition.removeProvider(name);
            sendDeleteProviderToAsync(name);
            logger.info("provider={} deleted successfully", name);
        }
        return blockCountList;
    }

    public static Map<String, List<ProviderPathInfo>> getProviderStatus(String name) {
        return AsyncCRUD.getProviderStatus(name);
    }

    public static void distributeBlockCounts(List<AsyncServer> asyncServers, BlockCountDto blockCountDto) {
        if (blockCountDto.getCount() < 0)
            blockCountDto.setCount(-1);
        else if (blockCountDto.getCount() > 0) {
            int block = blockCountDto.getCount() / asyncServers.size();
            blockCountDto.setCount(block);
        }
    }

    public static void blockPath(String provider, String path, int blockCount) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto(provider, path, blockCount);
            distributeBlockCounts(availableAsyncServers, blockCountDto);
            if (blockCountDto.getCount() > 0)
                AsyncManager.sendActionToAsyncServers("/rate-limit/provider/path/block/", "post", blockCountDto, getToken(), availableAsyncServers);
        }
    }

    public static void blockBusiness(String businessId, int blockCount) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto(businessId, blockCount);
            distributeBlockCounts(availableAsyncServers, blockCountDto);
            if (blockCountDto.getCount() > 0)
                AsyncManager.sendActionToAsyncServers("/rate-limit/business/blockcount/", "post", blockCountDto, getToken(), availableAsyncServers);
        }
    }

    public static void sendDeleteProviderToAsync(String provider) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto();
            blockCountDto.setProvider(provider);
            AsyncManager.sendActionToAsyncServers("/rate-limit/provider/", "delete", blockCountDto, getToken(), availableAsyncServers);
        }
    }

    private static String getToken() {
        return "Bearer " + Settings.KEYLEAD_API_TOKEN;
    }

    public static List<ProviderPathInfo> getBlockedProviders(String name) {
        return AsyncCRUD.getBlockedProviders(name);
    }

    public static List<ProviderPathInfo> getWatchedServices(String provider) {
        return AsyncCRUD.getWatchedServices(provider);
    }

    public static List<ProviderPathInfo> getBlockedServices(String provider) {
        return AsyncCRUD.getBlockedServices(provider);
    }

    public static List<Provider> getProviders() throws SQLException {
        return AsyncCRUD.getProviders();
    }


    public static List<BusinessDto> getBusinessList() {
        return AsyncCRUD.getBusinessList();
    }

    public static HashMap<String, BusinessDto> getBusiness() {
        return business;
    }

    public static void addBusiness(String businessId, String name, Long limit) throws SQLException, HttpException, InterruptedException {
        AsyncCRUD.addBusiness(businessId, name, limit);
        sendBusinessActionToAsync(businessId, name, "post");
        BusinessDto businessDto = new BusinessDto();
        businessDto.setLimit(limit);
        businessDto.setName(name);
        businessDto.setBusinessId(businessId);
        business.put(businessId, businessDto);
    }

    public static void deleteBusiness(String businessId) throws SQLException, HttpException, InterruptedException {
        AsyncCRUD.deleteBusiness(businessId);
        sendBusinessActionToAsync(businessId, null, "delete");
        business.remove(businessId);
    }

    public static void sendBusinessActionToAsync(String businessId, String name, String method) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto();
            blockCountDto.setBusinessId(businessId);
            blockCountDto.setBusinessName(name);
            AsyncManager.sendActionToAsyncServers("/rate-limit/business/", method, blockCountDto, getToken(), availableAsyncServers);
        }
    }

    public static List<BusinessDto> getBlockedBusiness(String businessId) {
        return AsyncCRUD.getBlockedBusiness(businessId);
    }

    public static List<BusinessDto> getBlockedBusinessProviders(String businessId, String provider) {
        return AsyncCRUD.getBlockedBusinessProviders(businessId, provider);
    }

    public static void checkToken(HttpServletRequest req) throws ServerException {
        if (req.getHeader("Authorization") == null || req.getHeader("Authorization").isEmpty())
            throw new ServerException("Authorization is required");
        String token = req.getHeader("Authorization");
        if (token != null && token.length() > 6) {
            token = token.substring(6).trim();
            if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {
                KeyleadUtil.checkToken(token, Settings.KEYLEAD_ADMIN_ROLE);
            }
        } else
            throw new ServerException("invalid token");
    }

    public static List<BusinessDto> getWatchBusiness(String businessId) {
        return AsyncCRUD.getWatchBusiness(businessId);
    }

    public static void sendIpActionToAsync(String ip, String method) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto();
            blockCountDto.setIp(ip);
            AsyncManager.sendActionToAsyncServers("/rate-limit/ip/", method, blockCountDto, getToken(), availableAsyncServers);
        }
    }

    public static List<IpAddressDto> getIpAddressList() {
        return AsyncCRUD.getIpAddressList();
    }

    public static List<IpAddressDto> getBlockIpAddress(String ip) {
        return AsyncCRUD.getBlockIpAddress(ip);
    }

    public static void addIpAddress(String ip, Long limit) throws HttpException, InterruptedException, SQLException {
        AsyncCRUD.addIpAddress(ip, limit);
        sendIpActionToAsync(ip, "post");
        IpAddressDto ipAddressDto = new IpAddressDto();
        ipAddressDto.setLimit(limit);
        ipAddressDto.setIp(ip);
        ipAddressMap.put(ip, ipAddressDto);
    }

    public static void deleteIpAddress(String ip) throws HttpException, InterruptedException, SQLException {
        AsyncCRUD.deleteIpAddress(ip);
        sendIpActionToAsync(ip, "delete");
        ipAddressMap.remove(ip);
    }

    public static HashMap<String, IpAddressDto> getIpAddressMap() {
        return ipAddressMap;
    }

    public static void blockIpAddress(String ip, int blockCount) throws InterruptedException, HttpException {
        List<AsyncServer> availableAsyncServers = AsyncManager.getAsyncServers(true);
        if (!availableAsyncServers.isEmpty()) {
            BlockCountDto blockCountDto = new BlockCountDto();
            blockCountDto.setIp(ip);
            blockCountDto.setCount(blockCount);
            distributeBlockCounts(availableAsyncServers, blockCountDto);
            if (blockCountDto.getCount() > 0)
                AsyncManager.sendActionToAsyncServers("/rate-limit/ip/blockcount/", "post", blockCountDto, getToken(), availableAsyncServers);
        }
    }

    private static void scheduleAndRegisterRateLimitRefresher(RateLimitConfigDto rateLimitConfigDto) {
        if (!rateLimitConfigDto.getPermanentBlock()) {
            ScheduledFuture<?> rateLimitTask = rateLimitExecutor.scheduleAtFixedRate(() -> refreshRateLimitConfig(rateLimitConfigDto), 0, rateLimitConfigDto.getRefillInterval(), TimeUnit.MILLISECONDS);
            rateLimitTasks.put(rateLimitConfigDto.getLimitKey(), rateLimitTask);
            addToRateLimitConfigMap(rateLimitConfigDto.getLimitKey(), rateLimitConfigDto);
            logger.info("rate limit task with key={} inserted.", rateLimitConfigDto.getLimitKey());
        }
    }

    private static void refreshRateLimitConfig(RateLimitConfigDto rateLimitConfigDto) {
        rateLimitConfigDto.setExpireTime(System.currentTimeMillis() + rateLimitConfigDto.getRefillInterval());
        rateLimitConfigDto.setCapacity(new AtomicLong(rateLimitConfigDto.getTotalCapacity()));
        rateLimitConfigDto.setTemporarilyBlock(Boolean.FALSE);
        logger.info("refresh rate limit config for key={}, capacity={}, expireTime={}", rateLimitConfigDto.getLimitKey(), rateLimitConfigDto.getCapacity(), rateLimitConfigDto.getExpireTime());
    }

    private static void removeTask(String key) {
        ScheduledFuture<?> oldTask = rateLimitTasks.get(key);
        if (oldTask != null) {
            oldTask.cancel(true);
            rateLimitTasks.remove(key);
            logger.info("rate limit task with key={} has been removed", key);
        }
    }

    private static void rescheduleRateLimit(RateLimitConfigDto rateLimitConfigDto) {
        removeTask(rateLimitConfigDto.getLimitKey());
        scheduleAndRegisterRateLimitRefresher(rateLimitConfigDto);
    }

    private static RateLimitConfigDto getRateLimitConfigMap(String key) {
        return rateLimitConfigMap.get(key);
    }

    public static void deleteRateLimitConfig(String key) {
        rateLimitConfigMap.remove(key);
        logger.info("rate limit with key={} has been removed", key);
        removeTask(key);
    }

    public static void insertIntoRateLimitConfig(RateLimitConfigDto rateLimitConfig) {
        AsyncCRUD.insertIntoRateLimitConfig(rateLimitConfig);
        rescheduleRateLimit(rateLimitConfig);
    }

    public static void deleteFromRateLimitConfigByKey(String key) {
        AsyncCRUD.deleteFromRateLimitConfigByKey(key);
    }

    public static List<RateLimitConfigDto> loadRateLimitConfig(String type, String ip, String provider, String service, Long businessId) {
        return AsyncCRUD.loadRateLimitConfig(type, ip, provider, service, businessId);
    }

    public static List<RateLimitConfigDto> loadRateLimitConfig() {
        return AsyncCRUD.loadRateLimitConfig();
    }

    public static void updateRateLimitConfigCapacity(RateLimitConfigDto rateLimitConfigDto) {
        RateLimitConfigDto inMemoryRateLimit = getRateLimitConfigMap(rateLimitConfigDto.getLimitKey());
        if (inMemoryRateLimit != null) {
            synchronized (inMemoryRateLimit) {
                if (!inMemoryRateLimit.getTemporarilyBlock() && !inMemoryRateLimit.getPermanentBlock()) {
                    inMemoryRateLimit.getCapacity().addAndGet(-rateLimitConfigDto.getCountThreshold());
                    inMemoryRateLimit.setCount(0L);
                    if (inMemoryRateLimit.getCapacity().get() <= 0) {
                        inMemoryRateLimit.setTemporarilyBlock(Boolean.TRUE);
                        long beforeSend = System.currentTimeMillis();
                        AsyncManager.getProducer().sendMessage(inMemoryRateLimit);
                        logger.debug("send in async manager capacity = {}, time = {} ms", inMemoryRateLimit.getCapacity(), System.currentTimeMillis() - beforeSend);
                    }
                    logger.info("Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={} map size is: {}", inMemoryRateLimit.getLimitKey(), inMemoryRateLimit.getCapacity(), inMemoryRateLimit.getRefillInterval(), inMemoryRateLimit.getExpireTime(), inMemoryRateLimit.getCountThreshold(), System.currentTimeMillis(), rateLimitConfigMap.size());
                }
            }
        }
    }
}
