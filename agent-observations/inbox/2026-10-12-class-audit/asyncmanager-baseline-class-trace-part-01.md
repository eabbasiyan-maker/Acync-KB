---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: medium
verification: partial-source-baseline
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: REQUIRES_HUMAN_VALIDATION
---

# AsyncManager curated baseline — class trace part 1

**Not full manager repo.** These 18 Java files are excerpts in KB `source-baselines/asyncmanager/`, not evidence of exhaustive AsyncManager coverage. Never conflate them with 401 Async-Source Java files.

### source-baselines/asyncmanager/src/main/java/com/async/manager/AsyncManager.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/manager/AsyncManager.java); lines: 664
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L86: `} catch (Exception e) {` | L122: `} catch (IOException e) {` | L132: `} catch (Exception e) {` | L240: `} catch (Exception e) {` | L312: `} catch (IOException e) {` | L333: `throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);` | L377: `} catch (IOException e) {` | L398: `throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);` | L440: `} catch (IOException e) {` | L462: `throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);` | L505: `} catch (IOException e) {` | L530: `throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);` | L571: `} catch (IOException e) {` | L593: `throw new HttpException("Async servers requests timed out", HttpStatus.SC_REQUEST_TIMEOUT);` | L640: `} catch (IOException e) {`
- Logger calls: L54: `logger.warn("start to delete clients from serverId={}", serverId);` | L72: `logger.error("Exception in remove client cache from asynServer= {} for serverId={}  ", asyncServerId, serverId` | L78: `logger.warn("remove client cache from asynServer= {} for serverId={}  ", asyncServerId, serverId);` | L80: `logger.error("Exception in remove client cache from asynServer= {} for serverId={} statusCode={} message={} ",` | L87: `logger.error("Exception in remove client cache for serverId={} ", serverId, e);` | L96: `logger.debug("start check async serverId={}", serverId);` | L105: `logger.debug("Async Server status : serverId={} , isAlive={}", serverId, isAlive);` | L113: `logger.info("Async Server check success for serverId={}", serverId);` | L117: `logger.error("Async Server check failed for serverId={} , retryCount={} , response code={}",` | L120: `logger.debug("Async Server check success for serverId={}", serverId);` | L125: `logger.error("Async Server check failed for serverId={} , retryCount={}",` | L133: `logger.error("Exception in check Async servers ", e);` | L140: `logger.info("try to execute TIMEOUT stored procedures");` | L144: `logger.info("end of execute TIMEOUT stored procedures");` | L150: `logger.warn("ManagerId={} status changed to {} ", Settings.MANAGER_ID, isMain ? " Main Manager" : " Worker");`
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/object/AsyncServer.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/object/AsyncServer.java); lines: 72
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: none scanned
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/ratelimit/dto/RateLimitConfigDto.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/ratelimit/dto/RateLimitConfigDto.java); lines: 141
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: none scanned
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitService.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitService.java); lines: 389
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L79: `throw new IOException("file not found");` | L250: `throw new ServerException("Authorization is required");` | L258: `throw new ServerException("invalid token");`
- Logger calls: L58: `logger.info("Added/Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCo` | L68: `logger.info("start action=add provider, provider={} ,factor={}", name, rateFactor);` | L72: `logger.info("provider={} saved successfully,id={} ,factor={}", name, provider.getId(), provider.getFactor());` | L74: `logger.warn("Problem in save provider={}", name);` | L78: `logger.error("file not found for save provider={}", name);` | L86: `logger.info("get multipart content");` | L91: `logger.info("fileSize = {}", fileItems.get(0).getSize());` | L95: `logger.info("start action=edit provider, provider={}", provider.getName());` | L103: `logger.info("provider={} edited successfully,factor={}", provider.getName(), provider.getFactor());` | L134: `logger.info("start delete provider={}", name);` | L138: `logger.info("provider={} deleted successfully", name);` | L318: `logger.info("rate limit task with key={} inserted.", rateLimitConfigDto.getLimitKey());` | L326: `logger.info("refresh rate limit config for key={}, capacity={}, expireTime={}", rateLimitConfigDto.getLimitKey` | L334: `logger.info("rate limit task with key={} has been removed", key);` | L349: `logger.info("rate limit with key={} has been removed", key);`
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitType.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitType.java); lines: 20
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: none scanned
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderRateLimitManagerServlet.java); lines: 35
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L12: `throw new HttpException("businessId is required");` | L15: `throw new HttpException("provider is required");`
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderServiceRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderServiceRateLimitManagerServlet.java); lines: 35
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L12: `throw new HttpException("businessId is required");` | L15: `throw new HttpException("provider is required");` | L18: `throw new HttpException("service is required");`
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/server/BusinessRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/BusinessRateLimitManagerServlet.java); lines: 35
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L12: `throw new HttpException("businessId is required");`
- Logger calls: none scanned
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.

### source-baselines/asyncmanager/src/main/java/com/async/server/EmbeddedHttpServer.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/EmbeddedHttpServer.java); lines: 217
- Method/DTO/management context must be reconciled with full original manager repository (not provided): candidate only.
- Explicit error/catch sites: L147: `} catch (Exception ex) {` | L212: `} catch (Exception e) {`
- Logger calls: L42: `logger.info("EmbeddedHttpServer initialized");` | L48: `logger.info("EmbeddedHttpServer unInitialized");` | L79: `logger.info("Async HTTP connector started. HTTP port: {}", Settings.HTTP_PORT);` | L145: `logger.info("Async HTTPS connector started. HTTPS port: {}", Settings.HTTPS_PORT);` | L146: `logger.info("SSL keystore path: {}", keyFile.getAbsolutePath());` | L148: `logger.error("Can not initialize SSL", ex);` | L151: `logger.warn("Async HTTPS not initialized because keystore is not available: {}", Settings.KEYSTORE_PATH);` | L177: `logger.info("WWW root path: " + wwwUri);` | L213: `logger.warn("An exception occurred", e);`
- Business/operational scope: Rate Limit management and synchronization, but exact running cluster mapping, actual API contract and source completeness require verification.
