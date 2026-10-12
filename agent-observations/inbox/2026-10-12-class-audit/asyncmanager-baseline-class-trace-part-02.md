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

# AsyncManager curated baseline — class trace part 2

Curated partial baseline only, not the entire manager source. No Production code parity or runtime validation.

### source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderRateLimitManagerServlet.java); lines: 35
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L12: `throw new HttpException("ip is required");` | L15: `throw new HttpException("provider is required");`
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderServiceRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderServiceRateLimitManagerServlet.java); lines: 35
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L12: `throw new HttpException("ip is required");` | L15: `throw new HttpException("provider is required");` | L18: `throw new HttpException("service is required");`
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/IpRateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/IpRateLimitManagerServlet.java); lines: 35
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L12: `throw new HttpException("ip is required");`
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitManagerServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitManagerServlet.java); lines: 101
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L39: `} catch (ServerException e) {` | L42: `} catch (HttpException e) {` | L45: `} catch (Exception e) {` | L71: `throw new HttpException("body is empty", HttpStatus.SC_BAD_REQUEST);` | L81: `throw new HttpException("capacity is required");` | L84: `throw new HttpException("refill interval is required");` | L87: `throw new HttpException("permanent block is required");` | L90: `throw new HttpException("count threshold is required");`
- Logger sites: L40: `logger.error("An ServerException occurred in RateLimitManagerServlet", e);` | L43: `logger.error("An HttpException occurred in RateLimitManagerServlet", e);` | L46: `logger.error("An Exception occurred in RateLimitManagerServlet", e);` | L67: `logger.info("start action={} , method={} , type={} , key={}",`
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitServlet.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitServlet.java); lines: 112
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L46: `} catch (ServerException e) {` | L49: `} catch (Exception e) {` | L70: `} catch (ServerException e) {` | L73: `} catch (HttpException e) {` | L76: `} catch (Exception e) {` | L98: `throw new HttpException("body is empty", HttpStatus.SC_BAD_REQUEST);` | L105: `throw new HttpException("key is required");`
- Logger sites: L47: `logger.error("An ServerException occurred in RateLimitServlet", e);` | L50: `logger.error("An Exception occurred in RateLimitServlet", e);` | L71: `logger.error("An ServerException occurred in RateLimitServlet", e);` | L74: `logger.error("An HttpException occurred in RateLimitServlet", e);` | L77: `logger.error("An Exception occurred in RateLimitServlet", e);` | L94: `logger.info("start action={} , method={} , type={} , key={}",`
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/vo/RequestResultVO.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/vo/RequestResultVO.java); lines: 54
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: none in heuristic scan
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/vo/ResponseVO.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/vo/ResponseVO.java); lines: 56
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: none in heuristic scan
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/server/vo/ResultVO.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/server/vo/ResultVO.java); lines: 49
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: none in heuristic scan
- Logger sites: none in heuristic scan
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.

### source-baselines/asyncmanager/src/main/java/com/async/util/JsonUtil.java
- [Curated manager-source excerpt](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/source-baselines/asyncmanager/src/main/java/com/async/util/JsonUtil.java); lines: 111
- Partial manager snapshot; this file alone cannot establish full implementation.
- Throws/catches: L31: `} catch (JsonProcessingException e) {` | L33: `throw new RuntimeException(e);` | L40: `} catch (IOException e) {` | L42: `throw new RuntimeException(e);` | L53: `} catch (IOException e) {` | L55: `throw new RuntimeException(e);` | L64: `} catch (IOException e) {` | L66: `throw new RuntimeException(e);` | L74: `} catch (IOException e) {` | L75: `throw new RuntimeException(e);` | L82: `} catch (IOException e) {` | L83: `throw new RuntimeException(e);` | L92: `} catch (IOException e) {` | L93: `throw new RuntimeException(e);`
- Logger sites: L32: `logger.warn("An exception occurred", e);` | L41: `logger.warn("An exception occurred", e);` | L48: `//            logger.debug("classOfT = {}", classOfT);` | L50: `//                logger.warn(classOfT.getSimpleName() + " - json = " + json);` | L54: `logger.warn("An exception occurred " + json, e);` | L61: `//            logger.info("type = " + type);` | L62: `//            logger.warn("json = " + json);` | L65: `logger.warn("An exception occurred", e);` | L72: `//            logger.warn("json = " + json);`
- Actual cross-cluster propagation, operator meaning, effective settings and error contracts are UNKNOWN without complete AsyncManager source/runtime.
