# Async class dossiers — review batch 07


---

### dossier-src-com-nozha-async-server-httpserver-ratelimitservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/RateLimitServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java
source_sha256: e3813fbe63d96649607263b8b9e79fb79fb81ac3f936978aeaa2b649e1000610
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# RateLimitServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/RateLimitServlet.java:29-63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L29-L63) POST exact /insertOrUpdate and DELETE /delete conditional admin auth65-76, otherwise400. doProviderAction78-116 UTF8 JSON reads raw body, parses RateLimitConfig, insert validates then resets count to AtomicLong0 and updates BaseRateLimiter; delete validates limitKey then deletes. [src/com/nozha/async/server/httpserver/RateLimitServlet.java:118-126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L118-L126) suffix helpers do not accept slash. validator128-183 checks type-specific business/IP/provider/service fields and capacity/permanentBlock; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:185-189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L185-L189) limitKey required. Unknown types not rejected here, missing type dereferenced.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doPost` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:28-44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L28-L44): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doDelete` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:47-63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L47-L63): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`checkToken` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:65-76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L65-L76): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doProviderAction` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:78-116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L78-L116): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`isInsertOrUpdateAction` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:118-121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L118-L121): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/insertOrUpdate"));`.
- [`isDeleteAction` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:123-126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L123-L126): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/delete"));`.
- [`validateRequestParameters` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:128-183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L128-L183): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`validateRequestParameterForDelete` — src/com/nozha/async/server/httpserver/RateLimitServlet.java:185-189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L185-L189): Observed operation: `if (rateLimitConfig.getLimitKey() == null || rateLimitConfig.getLimitKey().isEmpty()) { throw new HttpException("key is required"); }`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.ratelimit.BaseRateLimiter`, `com.nozha.async.server.ratelimit.RateLimitType`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.RateLimitConfig`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L274): `context.addServlet(new ServletHolder("new-rate-limit", RateLimitServlet.class), "/v2/rate-limit/*"); `

## Business

SOURCE_OBSERVED: Node rule management changes future enforcement and resets counters on update. Separate AsyncManager six-route API must not be substituted for this node API.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

HttpException validations131-187 omit status constructor => getStatusCode0 (HttpException.java6-38), passed resp.setStatus at113; cannot claim ordinary400. Null type => generic500. Parse86 outside catch, empty body400/auth401, inner unexpected500. capacity bounds/refill/total not checked locally. Reproduce missing capacity/businessId/key and inspect status0/container handling rather than infer HTTP200/400.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:39-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L39-L41): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:58-60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L58-L60): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:67-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L67-L69): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:75-77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L75-L77): `throw new ServerException("invalid token"); } `
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:99-101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L99-L101): `} catch (HttpException httpException) { httpStatus = httpException.getStatusCode(); message = httpException.getMessage();`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:103-105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L103-L105): `} catch (Exception e) { logger.error("An exception occurred in {} paths={}", action, body, e); httpStatus = HttpStatus.SC_INTERNAL_SERVER_ERROR;`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:131-133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L131-L133): `throw new HttpException("businessId is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:136-138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L136-L138): `throw new HttpException("businessId is required"); } if (rateLimitConfig.getProvider() == null || rateLimitConfig.getProvider().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:139-141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L139-L141): `throw new HttpException("provider is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:144-146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L144-L146): `throw new HttpException("businessId is required"); } if (rateLimitConfig.getProvider() == null || rateLimitConfig.getProvider().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:147-149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L147-L149): `throw new HttpException("provider is required"); } if (rateLimitConfig.getService() == null || rateLimitConfig.getService().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:150-152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L150-L152): `throw new HttpException("service is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:155-157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L155-L157): `throw new HttpException("ip is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:160-162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L160-L162): `throw new HttpException("ip is required"); } if (rateLimitConfig.getProvider() == null || rateLimitConfig.getProvider().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:163-165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L163-L165): `throw new HttpException("provider is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:168-170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L168-L170): `throw new HttpException("ip is required"); } if (rateLimitConfig.getProvider() == null || rateLimitConfig.getProvider().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:171-173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L171-L173): `throw new HttpException("provider is required"); } if (rateLimitConfig.getService() == null || rateLimitConfig.getService().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:174-176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L174-L176): `throw new HttpException("service is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:178-180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L178-L180): `throw new HttpException("capacity is required"); } if (rateLimitConfig.getPermanentBlock() == null) {`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:181-183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L181-L183): `throw new HttpException("permanent block is required"); } }`
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:187-189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L187-L189): `throw new HttpException("key is required"); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO85 action+full raw body; WARN102 validation message/action; ERROR104 action/body/throwable. Confirms prior privacy and mapping candidates, no UUID.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/RateLimitServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L85) | INFO | `logger.info("start {} {}", action, body);` | ALOG-979BE13EB475 |
| [src/com/nozha/async/server/httpserver/RateLimitServlet.java:102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L102) | WARN | `logger.warn("{} for action={} ", message, action);` | ALOG-B189B3DFCCA4 |
| [src/com/nozha/async/server/httpserver/RateLimitServlet.java:104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L104) | ERROR | `logger.error("An exception occurred in {} paths={}", action, body, e);` | ALOG-1A6FA1EFA68E |

Reconciled 3 executable direct logger sites against 3 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L85) in `doProviderAction`: if_statement at 84: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L102) in `doProviderAction`: catch_clause at 99: see enclosing source; if_statement at 84: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/RateLimitServlet.java:104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L104) in `doProviderAction`: catch_clause at 103: see enclosing source; if_statement at 84: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/operations/rate-limit-manager.md`: separate com.async AsyncManager baseline/API, not the com.nozha.async node handler; do not merge route contracts. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-registerservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/RegisterServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java
source_sha256: 14d1952e157f58f01d65821b9759c2d57e697baa72a482cb49bc48a3beb75eb1
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# RegisterServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/RegisterServlet.java:33-96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L33-L96) GET action dispatch register/Queue/Device/Coap/Coaps/IotDevice/Rest; conditional roles per action (admin Queue/Rest,device-admin Device/Coap/bulk). Unknown action yields status200 no body. POST99-100 calls super.doGet, not local GET. handleRegister103-135 uses credentials/device/app and createProject true owner auth/admin then RegistrationManager owner vs user, returns ResultVO JSON string of RegisterResponseVO. Queue137-198 parses optional TTL/max count/type/client timeout(default0), creates Peer before QueueRegistration, reverses input/output queue names, registers and returns peerId. REST199-230 creates Peer zero ttl/count/time and RestRegistration baseUrl/config URL/server; Device231-276 optional TTL/type, Peer then DeviceRegistration clientId/inputQueue/factory. bulk IoT278-322 splits deviceIds/clientIds, iterates timestamp names, concatenates basedeviceId and registration, no transaction/rollback. Coap324-368 peer then CoapRegistration endpoint/client. Coaps369-413 array device/client/endpoint parallel iteration, timestamp name, peer then registration.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/RegisterServlet.java:32-96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L32-L96): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doPost` — src/com/nozha/async/server/httpserver/RegisterServlet.java:98-101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L98-L101): Observed operation: `super.doGet(req, resp);`.
- [`handleRegister` — src/com/nozha/async/server/httpserver/RegisterServlet.java:103-135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L103-L135): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterQueue` — src/com/nozha/async/server/httpserver/RegisterServlet.java:137-198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L137-L198): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterRest` — src/com/nozha/async/server/httpserver/RegisterServlet.java:199-230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L199-L230): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterDevice` — src/com/nozha/async/server/httpserver/RegisterServlet.java:231-276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L231-L276): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterIotDevice` — src/com/nozha/async/server/httpserver/RegisterServlet.java:278-322](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L278-L322): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterCoap` — src/com/nozha/async/server/httpserver/RegisterServlet.java:324-368](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L324-L368): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`handleRegisterCoaps` — src/com/nozha/async/server/httpserver/RegisterServlet.java:369-413](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L369-L413): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.RegistrationManager`, `com.nozha.async.server.httpserver.vo.RegisterResponseVO`, `com.nozha.async.server.httpserver.vo.ResultVO`, `com.nozha.async.server.model.*`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.PeerInfoVO`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L242): `context.addServlet(new ServletHolder("register-events", RegisterServlet.class), "/register/*"); `

## Business

SOURCE_OBSERVED: Creates identity and protocol endpoints for clients/providers. GET has mutating effects; role checking conditional on active Keylead. Queue direction inversion and bulk partial creation directly affect transport binding.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

All action Exception caught84 =>500 ResultVO(false,message) even denied tokens; unknown action no error. Number parsing, missing comma arrays/null, mismatched array lengths, DB/manager failure possible. Peer insert occurs before registration; no rollback here. Reproduce failing registration after peer creation and second bulk item failure, inspect orphan/partial state.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/RegisterServlet.java:84-86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L84-L86): `} catch (Exception e) { logger.warn("An exception occurred in register servlet error={}",e.getMessage(), e); rs = new ResultVO(false, e.getMessage());`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN85 any action exception with e.message and stack, no action/peer/requestId fields. Credentials in URL/query may appear HttpRequestLogger even though no owned request-body logging.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/RegisterServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L85) | WARN | `logger.warn("An exception occurred in register servlet error={}",e.getMessage(), e);` | ALOG-F02DBDAA93E9 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/RegisterServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L85) in `doGet`: catch_clause at 84: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-registerwebrtcservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java
source_sha256: e78529c16fd03472b97f4042df3e73021bef4a782dc7988fe0316f52fe851b3a
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# RegisterWebrtcServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:21-33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L21-L33) GET /webrtc/turn[/] serializes TURN_ADDRESSES, otherwise delegates onGetIceCandidate for any URI. POST36-47 reads JSON body; /register[/] decodes SdpOffer then onRegister; /add-ice[/] decodes AddIceCandidate then handler clientId/candidate; unknown POST performs no action/body/status. Mounted only HAS_WEBRTC.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:20-33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L20-L33): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doPost` — src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:35-47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L35-L47): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.handler.WebrtcHandler`, `com.nozha.async.server.model.AddIceCandidate`, `com.nozha.async.server.model.SdpOffer`, `com.nozha.async.server.util.JsonUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:244](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L244): `context.addServlet(new ServletHolder("register-webrtc", RegisterWebrtcServlet.class), "/webrtc/*"); `

## Business

SOURCE_OBSERVED: WebRTC consumers obtain relay addresses and exchange SDP/ICE with handler; turn response may contain credentials depending TurnAddresses model/config.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

GET turn Exception warned/suppressed without explicit status/body mapping. JSON null/malformed POST/handler errors uncaught. No local token/schema validation. Reproduce unknown POST, malformed JSON, failed turn config and inspect empty/default response.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:27-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L27-L29): `} catch (Exception e) { logger.warn("An exception occurred in get turn addresses", e); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN28 only turn read/write exception, stack no ID. Other routes observable via WebrtcHandler and optional HTTPLOG; no dedicated SDP/ICE audit here.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L28) | WARN | `logger.warn("An exception occurred in get turn addresses", e);` | ALOG-FAC3A3DDC63F |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L28) in `doGet`: catch_clause at 27: see enclosing source; if_statement at 24: (req.getRequestURI().equals("/webrtc/turn") || req.getRequestURI().equals("/webrtc/turn/")). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-rootservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/RootServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RootServlet.java
source_sha256: f9e6c186b4cbbece249f126447008ee3cc4becd51339e3846dfd59dd2a662133
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# RootServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/RootServlet.java:18-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RootServlet.java#L18-L29) GET configured HTTP_ROOT_REDIRECT_URL => redirect, otherwise text/html It works page closes writer. POST32-33 calls superclass doGet, not this GET. Mounted fallback /* or /home/* when www exists.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/RootServlet.java:17-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RootServlet.java#L17-L29): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doPost` — src/com/nozha/async/server/httpserver/RootServlet.java:31-34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RootServlet.java#L31-L34): Observed operation: `super.doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.Settings`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L210): `context.addServlet(new ServletHolder("home", RootServlet.class), "/home/*"); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L213): `context.addServlet(new ServletHolder("home", RootServlet.class), "/*"); `

## Business

SOURCE_OBSERVED: Root caller sees availability landing page or configured redirect, not service readiness.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path; response IOException propagates. No redirect validation; approved redirect trust unknown. Reproduce configured/unconfigured root and POST superclass behavior.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. Optional request logger records URL/status; no dependency evidence in page.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-servicecallservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ServiceCallServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java
source_sha256: 43f845365037f8d22e311af7d9bcc7873f19c1f364e20e643ec56e10648bf1bc
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ServiceCallServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ServiceCallServlet.java:26-60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L26-L60) POST /insertOrUpdate DELETE /delete with conditional admin auth62-73; other suffix400. action75-125 reads body/config: type dispatch controls dispatcher update/delete, every other nonnull type chooses blocker update/delete. dispatch validator135-142 requires key not null and nonempty peerName; block144-148/delete150-154 require key not null (empty key accepted). response ResultResponse. helpers127-133 no slash accepted.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doPost` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:25-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L25-L41): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doDelete` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:44-60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L44-L60): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`checkToken` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:62-73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L62-L73): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doProviderAction` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:75-125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L75-L125): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`isInsertOrUpdateAction` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:127-129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L127-L129): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/insertOrUpdate"));`.
- [`isDeleteAction` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:131-133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L131-L133): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/delete"));`.
- [`validateDispatchRequestParameters` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:135-142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L135-L142): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`validateBlockRequestParameters` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:144-148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L144-L148): Observed operation: `if (serviceCallConfig.getKey() == null) { throw new HttpException("key is required"); }`.
- [`validateRequestParameterForDelete` — src/com/nozha/async/server/httpserver/ServiceCallServlet.java:150-154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L150-L154): Observed operation: `if (serviceCallConfig.getKey() == null) { throw new HttpException("key is required"); }`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.ServiceCallService`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.model.ServiceCallConfig`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L241): `context.addServlet(new ServletHolder("service-call-configurator", ServiceCallServlet.class), "/service-call-configurator/*"); `

## Business

SOURCE_OBSERVED: Admin changes service-call routing or blocker keys consumed by AsyncServiceCallServlet and receiving mediators. Destination existence/type enum not validated here.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

HttpException("key is required")/"peerName is required" no code => status0 forwarded109/122 (HttpException primitive default0). Null type => generic500; JSON parse83 outside inner catch; empty body400, auth401. Reproduce missing/empty key, missing peer/type and unsupported type, verify map mutation/status behavior.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:36-38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L36-L38): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:55-57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L55-L57): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:64-66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L64-L66): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:72-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L72-L74): `throw new ServerException("invalid token"); } `
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:108-110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L108-L110): `} catch (HttpException httpException) { httpStatus = httpException.getStatusCode(); message = httpException.getMessage();`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:112-114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L112-L114): `} catch (Exception e) { logger.error("An exception occurred in {} paths={}", action, body, e); httpStatus = HttpStatus.SC_INTERNAL_SERVER_ERROR;`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:137-139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L137-L139): `throw new HttpException("key is required"); } if (serviceCallConfig.getPeerName() == null || serviceCallConfig.getPeerName().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:140-142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L140-L142): `throw new HttpException("peerName is required"); } }`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:146-148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L146-L148): `throw new HttpException("key is required"); } }`
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:152-154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L152-L154): `throw new HttpException("key is required"); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO82 raw full management body before parse; WARN111 validation message/action; ERROR113 action/body/stack. Prior critical signature confirms privacy concern; no audit actor/UUID or before/after state.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L82) | INFO | `logger.info("start {} {}", action, body);` | ALOG-3460022C2925 |
| [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L111) | WARN | `logger.warn("{} for action={} ", message, action);` | ALOG-2CDE5A9758B8 |
| [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L113) | ERROR | `logger.error("An exception occurred in {} paths={}", action, body, e);` | ALOG-7F6737772FA8 |

Reconciled 3 executable direct logger sites against 3 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L82) in `doProviderAction`: if_statement at 81: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L111) in `doProviderAction`: catch_clause at 108: see enclosing source; if_statement at 81: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L113) in `doProviderAction`: catch_clause at 112: see enclosing source; if_statement at 81: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md` and `source-logging-semantics.md` service-call notes: raw management bodies and proxy-vs-message boundary must stay distinct; proxy 408/227 findings belong ServiceCallProxy, not this class. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-serviceproviderservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ServiceProviderServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java
source_sha256: 3bf340ed11ecf7bb791aa73915cf0d231aedf5806f7c899cbc959debb8d9ec1c
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ServiceProviderServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:30-62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L30-L62) GET active auth and optional peerName/repeated serverId filter ServiceProviderCrud configs. POST66-111 active auth then nonempty body (raw log), requires serverId values, parses ServiceProviderConfig checks peerName/swaggerUrl and persists for serverIds. DELETE115-149 requires peerName and optional serverIds then delete. checkToken151-161 requires Authorization(active Keylead admin, substring6) else503; validation163-170 fields only.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:29-62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L29-L62): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doPost` — src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:65-111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L65-L111): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doDelete` — src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:114-149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L114-L149): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`checkToken` — src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:151-161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L151-L161): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`checkValidation` — src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:163-170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L163-L170): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.mediation.generic.vo.ServiceProviderConfig`, `com.nozha.async.server.persistance.ServiceProviderCrud`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L273): `context.addServlet(new ServletHolder("services-events", ServiceProviderServlet.class), "/services/*"); `

## Business

SOURCE_OBSERVED: Management of stored descriptors controls later scheduler reload/routing; write response is persistence return, not proof that live provider map/virtual-host routes updated.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Missing header400 authentication-required; inactive503 Service Unavailable; ServerException401 Token unAuthorized; HttpException code forwarded; generic500 creates UUID reference log not response. Short header substring=>500. Required peer/swagger400; missing body/serverId400. Reproduce invalid URL accepted then scheduler fetch failure; no rollback guarantee.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:43-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L43-L45): `} catch (ServerException e) { result.put("message", "Token unAuthorized"); result.put("status", HttpServletResponse.SC_UNAUTHORIZED);`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:47-49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L47-L49): `} catch (HttpException e) { result.put("message", e.getMessage()); result.put("status", e.getStatusCode());`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:51-53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L51-L53): `} catch (Exception e) { String reference = UUID.randomUUID().toString(); result.put("message", "Internal server error");`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:92-94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L92-L94): `} catch (ServerException e) { result.put("message", "Token unAuthorized"); result.put("status", HttpServletResponse.SC_UNAUTHORIZED);`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:96-98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L96-L98): `} catch (HttpException e) { result.put("message", e.getMessage()); result.put("status", e.getStatusCode());`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:100-102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L100-L102): `} catch (Exception e) { String reference = UUID.randomUUID().toString(); result.put("message", "Internal server error");`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:124-126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L124-L126): `throw new HttpException("peerName is empty", HttpServletResponse.SC_BAD_REQUEST); if (req.getParameter("serverId") != null) serverIds = Arrays.stream(req.getParameterValues("serverId")).collect(Collectors.toList());`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:130-132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L130-L132): `} catch (ServerException e) { result.put("message", "Token unAuthorized"); result.put("status", HttpServletResponse.SC_UNAUTHORIZED);`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:134-136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L134-L136): `} catch (HttpException e) { result.put("message", e.getMessage()); result.put("status", e.getStatusCode());`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:138-140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L138-L140): `} catch (Exception e) { String reference = UUID.randomUUID().toString(); result.put("message", "Internal server error");`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:153-155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L153-L155): `throw new HttpException("Full authentication is required to access this resource", HttpServletResponse.SC_BAD_REQUEST); } if (KeyleadUtil.isActive()) {`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:159-161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L159-L161): `throw new HttpException("Service Unavailable", HttpServletResponse.SC_SERVICE_UNAVAILABLE); } }`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:165-167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L165-L167): `throw new HttpException("peerName is empty", HttpServletResponse.SC_BAD_REQUEST); } if (config.getSwaggerUrl() == null || config.getSwaggerUrl().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:168-170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L168-L170): `throw new HttpException("swaggerUrl is empty", HttpServletResponse.SC_BAD_REQUEST); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO74 raw descriptor body may include URL/config. ERROR56/105/143 GET/POST/DELETE unexpected exception UUID reference+stack; no returned ref. Expected auth/schema failures unlogged. Correlate method/time and DB/reload logs.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L56) | ERROR | `logger.error("An exception occurred in ServiceProviderServlet reference={}", reference, e);` | ALOG-3E117140915A |
| [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L74) | INFO | `logger.info("start crate/update service provider config = {}", body);` | ALOG-F3A9F667487B |
| [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L105) | ERROR | `logger.error("An exception occurred in ServiceProviderServlet reference={}", reference, e);` | ALOG-A34C80415C28 |
| [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L143) | ERROR | `logger.error("An exception occurred in ServiceProviderServlet reference={}", reference, e);` | ALOG-8519FF22679B |

Reconciled 4 executable direct logger sites against 4 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L56) in `doGet`: catch_clause at 51: see enclosing source. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L74) in `doPost`: if_statement at 73: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L105) in `doPost`: catch_clause at 100: see enclosing source. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L143) in `doDelete`: catch_clause at 138: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-swaggeruiservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/SwaggerUiServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/SwaggerUiServlet.java
source_sha256: b3ce6b1e3c357a882ffaeb037c54b70050b43248a5945d2fda28e4337ad477ba
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# SwaggerUiServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/SwaggerUiServlet.java:26-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/SwaggerUiServlet.java#L26-L74) GET action lowercase default empty; config optional urls.primaryName builds manual JSON urls /swagger/?action=get&name=provider; get name fetch map/provider swagger file, content length cast int and stream copy; unknown provider404, missing name400; default redirects /apidocs/index.html. POST77-78 super.doGet. Enabled server mounting gated SWAGGER_UI_ENABLED.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/SwaggerUiServlet.java:25-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/SwaggerUiServlet.java#L25-L74): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`doPost` — src/com/nozha/async/server/httpserver/SwaggerUiServlet.java:76-79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/SwaggerUiServlet.java#L76-L79): Observed operation: `super.doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.async.server.mediation.generic.ServiceDefinitionProvider`, `com.nozha.async.server.mediation.generic.vo.ServiceProvider`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:280](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L280): `context.addServlet(new ServletHolder("swagger", SwaggerUiServlet.class), "/swagger/*"); `

## Business

SOURCE_OBSERVED: Exposes provider descriptor documentation; absent primary provider can still appear config because put null then iterates key. Source documentation is not approved API contract.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

sendError404/400("'name' parameter absent"); file IO propagates; opened FileInputStream not explicitly closed here. Manual JSON/provider URL not escaped. Reproduce quote-bearing provider name, missing descriptor file, absent primary name and POST.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. Request log optional; ServiceDefinitionProvider log indicates descriptor loading, not successful UI read.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-unregisterservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/UnregisterServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java
source_sha256: 0720940988d330d8b2bd71830d2e921b0fc5f8a0c2377f495b0b36855f1b8e39
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# UnregisterServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/UnregisterServlet.java:29-77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L29-L77) DELETE validates parameters before optional device-admin query token check, splits clientsId, exact unregisterCoap/Device dispatch to RegistrationManager; nonempty removed list200 ResultVO joined IDs, none404. validator79-91 accumulates missing/unsupported action and missing/empty clientsId into required fields list.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doDelete` — src/com/nozha/async/server/httpserver/UnregisterServlet.java:28-77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L28-L77): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`checkRequestParamsIsValid` — src/com/nozha/async/server/httpserver/UnregisterServlet.java:79-91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L79-L91): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.RegistrationManager`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.httpserver.vo.ResultVO`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:263](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L263): `context.addServlet(new ServletHolder("unregister-events", UnregisterServlet.class), "/unregister/*"); `

## Business

SOURCE_OBSERVED: Device admin removes registered CoAP/device consumers; response reflects removed subset, not all requested IDs. Auth inactive skips token verification.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No-status HttpException validation caught as Exception instanceof and hard-mapped400; ServerException401; other500 with exception content and warning. Empty tokens/list substrings not validated here. Reproduce mixed found/missing IDs and invalid action.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:58-60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L58-L60): `} catch (ServerException e) { rs = new ResultVO(false, e.getMessage()); resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);`
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:61-63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L61-L63): `} catch (Exception e) {  if (e instanceof HttpException) {`
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:90-92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L90-L92): `throw new HttpException(errorMessage.append(String.join(", ", requiredFields)).append("]").toString()); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN67 only unexpected non-HttpException error stack; expected401/400/404 unlogged. No actor/IDs/UUID in owned log; optional query logging may contain token.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/UnregisterServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L67) | WARN | `logger.warn("An exception occurred in unregister servlet", e);` | ALOG-AD35BB3B012F |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L67) in `doDelete`: if_statement at 63: (e instanceof HttpException); catch_clause at 61: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-log-httplog

<!-- source dossier: src/com/nozha/async/server/httpserver/log/HttpLog.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java
source_sha256: 14d4ac30c9c40e7c52be2a44f4bd63ce50c7fdb182ee05e0f23ea121c7ad58ff
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# HttpLog — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver.log`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/log/HttpLog.java:7-21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L7-L21) mutable Serializable access-record schema: user agent,remote origin,bytes in/out,method,Referer,XFF,response code,wall timestamp,req_time,path/query/full URL/site/businessId. Accessors23-141 store/return exactly these fields, no normalization/validation/copy.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`getHttp_user_agent` — src/com/nozha/async/server/httpserver/log/HttpLog.java:23-25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L23-L25): Returns `http_user_agent` unchanged; no validation or side effect.
- [`setHttp_user_agent` — src/com/nozha/async/server/httpserver/log/HttpLog.java:27-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L27-L29): Assigns `this.http_user_agent = http_user_agent`; no validation or defensive copy.
- [`getOriginal_src` — src/com/nozha/async/server/httpserver/log/HttpLog.java:31-33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L31-L33): Returns `original_src` unchanged; no validation or side effect.
- [`setOriginal_src` — src/com/nozha/async/server/httpserver/log/HttpLog.java:35-37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L35-L37): Assigns `this.original_src = original_src`; no validation or defensive copy.
- [`getBytes_out` — src/com/nozha/async/server/httpserver/log/HttpLog.java:39-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L39-L41): Returns `bytes_out` unchanged; no validation or side effect.
- [`setBytes_out` — src/com/nozha/async/server/httpserver/log/HttpLog.java:43-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L43-L45): Assigns `this.bytes_out = bytes_out`; no validation or defensive copy.
- [`getBytes_in` — src/com/nozha/async/server/httpserver/log/HttpLog.java:47-49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L47-L49): Returns `bytes_in` unchanged; no validation or side effect.
- [`setBytes_in` — src/com/nozha/async/server/httpserver/log/HttpLog.java:51-53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L51-L53): Assigns `this.bytes_in = bytes_in`; no validation or defensive copy.
- [`getHttp_method` — src/com/nozha/async/server/httpserver/log/HttpLog.java:55-57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L55-L57): Returns `http_method` unchanged; no validation or side effect.
- [`setHttp_method` — src/com/nozha/async/server/httpserver/log/HttpLog.java:59-61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L59-L61): Assigns `this.http_method = http_method`; no validation or defensive copy.
- [`getHttp_referer` — src/com/nozha/async/server/httpserver/log/HttpLog.java:63-65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L63-L65): Returns `http_referer` unchanged; no validation or side effect.
- [`setHttp_referer` — src/com/nozha/async/server/httpserver/log/HttpLog.java:67-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L67-L69): Assigns `this.http_referer = http_referer`; no validation or defensive copy.
- [`getHttp_x_forwarded_for` — src/com/nozha/async/server/httpserver/log/HttpLog.java:71-73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L71-L73): Returns `http_x_forwarded_for` unchanged; no validation or side effect.
- [`setHttp_x_forwarded_for` — src/com/nozha/async/server/httpserver/log/HttpLog.java:75-77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L75-L77): Assigns `this.http_x_forwarded_for = http_x_forwarded_for`; no validation or defensive copy.
- [`getResponse_code` — src/com/nozha/async/server/httpserver/log/HttpLog.java:79-81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L79-L81): Returns `response_code` unchanged; no validation or side effect.
- [`setResponse_code` — src/com/nozha/async/server/httpserver/log/HttpLog.java:83-85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L83-L85): Assigns `this.response_code = response_code`; no validation or defensive copy.
- [`getTimestamp` — src/com/nozha/async/server/httpserver/log/HttpLog.java:87-89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L87-L89): Returns `timestamp` unchanged; no validation or side effect.
- [`setTimestamp` — src/com/nozha/async/server/httpserver/log/HttpLog.java:91-93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L91-L93): Assigns `this.timestamp = timestamp`; no validation or defensive copy.
- [`getReq_time` — src/com/nozha/async/server/httpserver/log/HttpLog.java:95-97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L95-L97): Returns `req_time` unchanged; no validation or side effect.
- [`setReq_time` — src/com/nozha/async/server/httpserver/log/HttpLog.java:99-101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L99-L101): Assigns `this.req_time = req_time`; no validation or defensive copy.
- [`getUri_path` — src/com/nozha/async/server/httpserver/log/HttpLog.java:103-105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L103-L105): Returns `uri_path` unchanged; no validation or side effect.
- [`setUri_path` — src/com/nozha/async/server/httpserver/log/HttpLog.java:107-109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L107-L109): Assigns `this.uri_path = uri_path`; no validation or defensive copy.
- [`getUri_query` — src/com/nozha/async/server/httpserver/log/HttpLog.java:111-113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L111-L113): Returns `uri_query` unchanged; no validation or side effect.
- [`setUri_query` — src/com/nozha/async/server/httpserver/log/HttpLog.java:115-117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L115-L117): Assigns `this.uri_query = uri_query`; no validation or defensive copy.
- [`getUrl` — src/com/nozha/async/server/httpserver/log/HttpLog.java:119-121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L119-L121): Returns `url` unchanged; no validation or side effect.
- [`setUrl` — src/com/nozha/async/server/httpserver/log/HttpLog.java:123-125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L123-L125): Assigns `this.url = url`; no validation or defensive copy.
- [`getSite` — src/com/nozha/async/server/httpserver/log/HttpLog.java:127-129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L127-L129): Returns `site` unchanged; no validation or side effect.
- [`setSite` — src/com/nozha/async/server/httpserver/log/HttpLog.java:131-133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L131-L133): Assigns `this.site = site`; no validation or defensive copy.
- [`getBusinessId` — src/com/nozha/async/server/httpserver/log/HttpLog.java:135-137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L135-L137): Returns `businessId` unchanged; no validation or side effect.
- [`setBusinessId` — src/com/nozha/async/server/httpserver/log/HttpLog.java:139-141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpLog.java#L139-L141): Assigns `this.businessId = businessId`; no validation or defensive copy.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L21): `HttpLog httpLog = new HttpLog(); `

## Business

SOURCE_OBSERVED: HttpRequestLogger19-37 populates log object for response visibility; req_time=Request.getTimeStamp is not duration, businessId is request attribute not verified identity.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class. Primitive defaults zero and nullable strings may represent absence rather than success. Accessor roundtrip boundary plus logger timestamp test.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HttpRequestLogger37 emits object to HTTPLOG; URI query,Referer,remote/XFF,businessId may identify people/tokens. No UUID/ARN schema field.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md`, `source-logging-semantics.md` and `correlation-and-data-contract.md`; preserves queue-depth label correction and request-timestamp/response-vs-business distinction. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-log-httprequestlogger

<!-- source dossier: src/com/nozha/async/server/httpserver/log/HttpRequestLogger.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java
source_sha256: bbad6207ff9795ff84a1692a522a17e24e7de5483a6b16b55f77780b56c89149
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# HttpRequestLogger — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver.log`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:14-16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L14-L16) delegates constructor format, but log19-41 replaces inherited log without super call. Populates HttpLog User-Agent,XFF,Referer,remoteAddr,req_time=Request.getTimeStamp,method,status,byte counts,path/query/fullURI,host,current wall timestamp,business_id then HTTPLOG info. req_time is request timestamp, not elapsed latency.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`HttpRequestLogger` — src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:14-16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L14-L16): Observed operation: `super(writer, formatString);`.
- [`log` — src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:18-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L18-L41): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:344](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L344): `RequestLog requestLog = new HttpRequestLogger(logWriter, format); `

## Business

SOURCE_OBSERVED: Records response boundary metadata for HTTP consumers; raw proxy header is not established real client address and status is not business/delivery success.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Any Exception swallowed after logger.error39; HTTP response processing continues without access record. business_id cast can fail; collector availability unknown. Reproduce nonstring business_id or failing logger to observe missing HTTP record.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:38-40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L38-L40): `} catch (Exception e) { logger.error("An exception occurred in HttpRequestLogger", e); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO37 object fields detailed above to named HTTPLOG; ERROR39 exception to class logger. No UUID/ARN field in HttpLog. Full URL/query/Referer/XFF privacy/token risk. Source resources/log4j2.xml HTTPLOG async_http.log, ROOT async.log; runtime override unverified. Prior registry ALOG-AE20C3D2B6ED plus ALOG-A04D3791FC2C match; configured Jetty format is not emitted via super here.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L37) | INFO | `httpLogger.info(httpLog);` | ALOG-AE20C3D2B6ED |
| [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L39) | ERROR | `logger.error("An exception occurred in HttpRequestLogger", e);` | ALOG-A04D3791FC2C |

Reconciled 2 executable direct logger sites against 2 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L37) in `log`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L39) in `log`: catch_clause at 38: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md`, `source-logging-semantics.md` and `correlation-and-data-contract.md`; preserves queue-depth label correction and request-timestamp/response-vs-business distinction. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-vo-registerresponsevo

<!-- source dossier: src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java
source_sha256: f47c4908d3dc829a4016f713041c70844ad60a3e301f8dd44dadc31f3d3e16ce
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# RegisterResponseVO — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver.vo`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:7-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L7-L27) default constructor and fields token long/projectName string; getToken returns token, setId(long token) writes token despite method name. Other accessor pair directly gets/sets projectName.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`RegisterResponseVO` — src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:10-11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L10-L11): No body operation (abstract contract or empty constructor/method).
- [`getToken` — src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:13-15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L13-L15): Returns `token` unchanged; no validation or side effect.
- [`getProjectName` — src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:17-19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L17-L19): Returns `projectName` unchanged; no validation or side effect.
- [`setId` — src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:21-23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L21-L23): Assigns `this.token = token`; no validation or defensive copy.
- [`setProjectName` — src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java:25-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/RegisterResponseVO.java#L25-L27): Assigns `this.projectName = projectName`; no validation or defensive copy.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/RegisterServlet.java:127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L127): `RegisterResponseVO vo = new RegisterResponseVO(); `

## Business

SOURCE_OBSERVED: RegisterServlet127-133 sets peer ID using setId, encoded response calls numeric peer identity token; owner creation also projectName. Not evidence of cryptographic auth token.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class; no validation, default token0. Boundary serialize after setId(42) to verify token field name consumer contract.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. RegisterServlet85 logs errors; HttpRequestLogger can record request URL/status but no response token field.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-vo-resultvo

<!-- source dossier: src/com/nozha/async/server/httpserver/vo/ResultVO.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java
source_sha256: fb3f2b9e8ccbff3c531e136b2cc5d08161a3e795cc71e3cf95daeaeb23167e27
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ResultVO — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver.vo`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/vo/ResultVO.java:7-32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L7-L32) mutable success boolean/content String, default and two-arg constructors, direct get/set. Content is string, not generic structured payload.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`ResultVO` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:10-11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L10-L11): No body operation (abstract contract or empty constructor/method).
- [`ResultVO` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:13-16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L13-L16): Observed operation: `this.success = success; this.content = content;`.
- [`setSuccess` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:18-20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L18-L20): Assigns `this.success = success`; no validation or defensive copy.
- [`setContent` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:22-24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L22-L24): Assigns `this.content = content`; no validation or defensive copy.
- [`isSuccess` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:26-28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L26-L28): Returns `success` unchanged; no validation or side effect.
- [`getContent` — src/com/nozha/async/server/httpserver/vo/ResultVO.java:30-32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/vo/ResultVO.java#L30-L32): Returns `content` unchanged; no validation or side effect.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/handler/WebrtcHandler.java:126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L126): `ResultVO response = new ResultVO(); `
- [src/com/nozha/async/server/handler/WebrtcHandler.java:143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L143): `ResultVO response = new ResultVO(); `
- [src/com/nozha/async/server/handler/WebrtcHandler.java:166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L166): `ResultVO response = new ResultVO(); `
- [src/com/nozha/async/server/httpserver/ClientServlet.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L41): `rs = new ResultVO(false, e.getMessage()); `
- [src/com/nozha/async/server/httpserver/ClientServlet.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L45): `rs = new ResultVO(false, e.getMessage()); `
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L52): `rs = new ResultVO(true, StringUtils.join(removedClient, ",")); `
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L55): `rs = new ResultVO(false, "Clients id not found"); `
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L59): `rs = new ResultVO(false, e.getMessage()); `
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L64): `rs = new ResultVO(false, e.getMessage()); `
- [src/com/nozha/async/server/httpserver/UnregisterServlet.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L68): `rs = new ResultVO(false, e.getMessage()); `

## Business

SOURCE_OBSERVED: Servlets such as RegisterServlet133 nest a JSON serialized response inside content string; clients inspect success and may need second decode. Independent of HTTP status.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class; null content allowed/default success false. Callers supply exception text and map HTTP separately. Boundary serialize embedded JSON and negative ResultVO with HTTP200 ProviderServicesServlet.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. Caller exceptions/HTTPLOG are evidence; object itself has no correlation/masking.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-defaultreceivinghttpmediator

<!-- source dossier: src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java
source_sha256: d9143175835e49d418520af966a89d2f6eb5b38d3c91f65fe28adc409c3e1548
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# DefaultReceivingHttpMediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java:13-20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java#L13-L20) mediate casts HttpContent, reads request data parameter, rejects null/trim-empty, otherwise returns original untrimmed string. Selected by MediatorManager119-124 for descriptor unavailable provider.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`mediate` — src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java:12-20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java#L12-L20): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.vo.HttpContent`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L120): `mediators.add(new DefaultReceivingHttpMediator()); `

## Business

SOURCE_OBSERVED: Fallback accepts already-encoded Async data envelope; it does not perform Swagger field extraction or auth.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

MediationException17 "Invalid request: " + requestURI no explicit errorCode/page. HttpHandler265-288 defaults to503. Cast/null errors unchecked. Reproduce blank/whitespace and opaque JSON string.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java:17-19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java#L17-L19): `throw new MediationException("Invalid request: " + httpContent.getRequest().getRequestURI()); } return data;`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HttpHandler266 warns mediation exception with origin/businessId/masked token and maps response; URI in exception may reveal route.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-defaultsendinghttpmediator

<!-- source dossier: src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java
source_sha256: c1a17dd6d4e9004c01eb40e0790c59ba5c42fe211bdf93d57b03fbbd1f9792fb
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# DefaultSendingHttpMediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java:14-16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java#L14-L16) returns request attribute client.getClientMessage without unwrapping content or setting HTTP status. Selected fallback in MediatorManager208-214.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`mediate` — src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java:13-16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java#L13-L16): Observed operation: `return ((HttpContent) object).getRequest().getAttribute("client.getClientMessage");`.

Direct product dependency declarations: `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.vo.HttpContent`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L209): `mediators.add(new DefaultSendingHttpMediator()); `

## Business

SOURCE_OBSERVED: Fallback response object is subsequently serialized by handler; differs from generic body/status adaptation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class; casts/null can fail, absent attr returns null. HttpHandler372 onward handles result. Reproduce absent attribute and ClientMessage object payload.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HttpHandler output/status and optional HTTPLOG are observability boundary.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-httpmediator

<!-- source dossier: src/com/nozha/async/server/mediation/HttpMediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java
source_sha256: 9b04da39ff18dd26cd0a7eace6f1f916c24cb487d095f5d8591dfcce1a8fefde
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# HttpMediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/HttpMediator.java:15-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L15-L31) getParameter prefers servlet parameter then FILE_ITEMS first item, form UTF8 bytes/nonform getString. getParameters33-53 arrays similarly all FileItems. getHeader55-57 exact servlet header; getHeaders59-69 enumerates into list or null. extractPostRequestBody71-83 Scanner UTF8 whole input, no token=>null, catches IO prints stack and returns null.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`getParameter` — src/com/nozha/async/server/mediation/HttpMediator.java:15-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L15-L31): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getParameters` — src/com/nozha/async/server/mediation/HttpMediator.java:33-53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L33-L53): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getHeader` — src/com/nozha/async/server/mediation/HttpMediator.java:55-57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L55-L57): Observed operation: `return req.getHeader(name);`.
- [`getHeaders` — src/com/nozha/async/server/mediation/HttpMediator.java:59-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L59-L69): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`extractPostRequestBody` — src/com/nozha/async/server/mediation/HttpMediator.java:71-83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L71-L83): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.async.server.handler.HttpHandler`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java#L24): `public class NotificationReceivingHttpMediator extends HttpMediator { `
- [src/com/nozha/async/server/mediation/notification/NotificationSendingHttpMediator.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationSendingHttpMediator.java#L13): `public class NotificationSendingHttpMediator extends HttpMediator { `
- [src/com/nozha/async/server/mediation/hamsam/HamsamSendingHttpMediator.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamSendingHttpMediator.java#L18): `public class HamsamSendingHttpMediator extends HttpMediator { `
- [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L39): `public class HamsamReceivingHttpMediator extends HttpMediator { `
- [src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java#L15): `public class GenericSendingHttpMediator extends HttpMediator { `
- [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L32): `public class GenericReceivingHttpMediator extends HttpMediator { `

## Business

SOURCE_OBSERVED: Shared extraction enables multipart, repeated fields and opaque body forwarding to provider. Required/type metadata not enforced by these helpers.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

IOException body suppressed to null; cast/iterator/read unchecked failures propagate. Inputs/read may consume stream; repeated body extraction cannot be assumed identical. Reproduce duplicate fields/file content and failing InputStream.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/mediation/HttpMediator.java:77-79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L77-L79): `} catch (IOException ex) {  ex.printStackTrace();`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS logger calls; printStackTrace79 is stderr only. Callers receiving mediators and HttpHandler carry request correlation, helper provides none.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-mediatechain

<!-- source dossier: src/com/nozha/async/server/mediation/MediateChain.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java
source_sha256: 93a4ba6f1dae64fc33f90586e10a51ad437aae567cb86d1914ec6cdc12a0593d
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# MediateChain — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/MediateChain.java:12-18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L12-L18) constructor stores mutable list reference; getIterator returns its iterator; package-private type used MediatorManager60-67 to sequentially replace input with each output.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`MediateChain` — src/com/nozha/async/server/mediation/MediateChain.java:12-14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L12-L14): Assigns `this.mediators = mediators`; no validation or defensive copy.
- [`getIterator` — src/com/nozha/async/server/mediation/MediateChain.java:16-18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L16-L18): Observed operation: `return mediators.iterator();`.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L39): `private static final Map<String, MediateChain> httpReceiveChainMap = Collections.synchronizedMap(new HashMap<>()); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L40): `private static final Map<String, MediateChain> httpSendChainMap = Collections.synchronizedMap(new HashMap<>()); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L51): `MediateChain mediateChain = getMediateChainForReceive(input, channelType); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L56): `MediateChain mediateChain = getMediateChainForSend(input, channelType); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L60): `private Object mediate(Object input, MediateChain mediateChain) throws MediationException { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L70): `private MediateChain getMediateChainForReceive(Object object, int channelType) throws MediationException { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L74): `MediateChain mediateChain = null; `
- [src/com/nozha/async/server/mediation/MediatorManager.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L83): `private MediateChain getHttpMediatorsForReceive(HttpContent httpContent) throws MediationException { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L93): `MediateChain mediateChain = httpReceiveChainMap.get(uri); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L123): `mediateChain = new MediateChain(mediators); `

## Business

SOURCE_OBSERVED: Internal ordered adapter pipeline; not configurable general multi-call workflow evidence.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path; null list => getIterator NPE, concurrent modification possible if external list changes. Exceptions from Mediator propagate manager. Reproduce two adapters to verify replacement order and failed second adapter.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. MediatorManager selected chain and HttpHandler exception logs provide boundary evidence.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-mediator

<!-- source dossier: src/com/nozha/async/server/mediation/Mediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/Mediator.java
source_sha256: 0e6de2a00261a9079d9e0c508dc70eca1218d3257d176a295c4aac729ca22777
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# Mediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

15 abstract mediate exception contract. Static REST_ENDPOINT_URI length/pattern17-18 fixed at class init; regex prefix endpoint/provider ending slash, provider word/hyphen. getUrl20-37 HttpContent only removes context, matching endpoint/provider prefix, forces trailing slash; other input returns null. static getUrlFromHttpRequest39-53 same normalization.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`mediate` — src/com/nozha/async/server/mediation/Mediator.java:15-15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/Mediator.java#L15-L15): No body operation (abstract contract or empty constructor/method).
- [`getUrl` — src/com/nozha/async/server/mediation/Mediator.java:20-37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/Mediator.java#L20-L37): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getUrlFromHttpRequest` — src/com/nozha/async/server/mediation/Mediator.java:39-53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/Mediator.java#L39-L53): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.vo.HttpContent`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/HttpMediator.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L14): `abstract public class HttpMediator extends Mediator { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L62): `Iterator<Mediator> it = mediateChain.getIterator(); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L95): `ArrayList<Mediator> mediators = new ArrayList<>(); `
- [src/com/nozha/async/server/mediation/MediatorManager.java:184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L184): `ArrayList<Mediator> mediators = new ArrayList<>(); `
- [src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultSendingHttpMediator.java#L11): `public class DefaultSendingHttpMediator extends Mediator { `
- [src/com/nozha/async/server/mediation/MediateChain.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L10): `private List<Mediator> mediators; `
- [src/com/nozha/async/server/mediation/MediateChain.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L12): `MediateChain(List<Mediator> mediators) { `
- [src/com/nozha/async/server/mediation/MediateChain.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediateChain.java#L16): `Iterator<Mediator> getIterator() { `
- [src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/DefaultReceivingHttpMediator.java#L9): `public class DefaultReceivingHttpMediator extends Mediator { `

## Business

SOURCE_OBSERVED: Provider route normalization defines service descriptor lookup keys and proxy eligibility. No generic body field transformation is provided by base type.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct explicit throw/catch; null requests, invalid substring, malformed configured regex can cause unchecked init/runtime exceptions. Endpoint regex not Pattern.quote; dynamic setting changes do not refresh pattern. Reproduce special chars endpoint, provider missing terminal slash, non-HttpContent input.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HttpHandler/MediatorManager caller context and request logs; normalized URI differs from original URL record.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-mediatormanager

<!-- source dossier: src/com/nozha/async/server/mediation/MediatorManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java
source_sha256: 588590ecd8e23c6d392fe7b4ff31ebd4b8c36b3047858b545863c28f7ad79e92
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# MediatorManager — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/MediatorManager.java:43-48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L43-L48) singleton trivial. mediateReceive50-53/send55-58 select chain then mediate60-68 sequentially pass output; nonHTTP channel70-81/165-176 gives no chain=>identity. Receive83-127 URI/receiver attr then business block/watch, cached uri chain; available descriptor selects Hamsam name, Notification name (may append both), otherwise generic; unavailable default. getReceiverName129-137 splits REST endpoint prefix; getUri139-151 memoizes first contextPathLength statically then prepends virtual peer from request attr. public request receiver153-163 instead reads servlet-context virtual host. Send178-216 mirror selection/cache. removeProvider218-235 collects matching lowercase key prefix from receive map then removes receive+send; on error clears both maps. Map methods synchronized individually, compound lookup/create and streams not synchronized; cached mediator instances reused concurrently.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`getInstance` — src/com/nozha/async/server/mediation/MediatorManager.java:43-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L43-L45): Returns `ourInstance` unchanged; no validation or side effect.
- [`MediatorManager` — src/com/nozha/async/server/mediation/MediatorManager.java:47-48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L47-L48): No body operation (abstract contract or empty constructor/method).
- [`mediateReceive` — src/com/nozha/async/server/mediation/MediatorManager.java:50-53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L50-L53): Observed operation: `MediateChain mediateChain = getMediateChainForReceive(input, channelType); return mediate(input, mediateChain);`.
- [`mediateSend` — src/com/nozha/async/server/mediation/MediatorManager.java:55-58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L55-L58): Observed operation: `MediateChain mediateChain = getMediateChainForSend(input, channelType); return mediate(input, mediateChain);`.
- [`mediate` — src/com/nozha/async/server/mediation/MediatorManager.java:60-68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L60-L68): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getMediateChainForReceive` — src/com/nozha/async/server/mediation/MediatorManager.java:70-81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L70-L81): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getHttpMediatorsForReceive` — src/com/nozha/async/server/mediation/MediatorManager.java:83-127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L83-L127): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getReceiverName` — src/com/nozha/async/server/mediation/MediatorManager.java:129-137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L129-L137): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getUri` — src/com/nozha/async/server/mediation/MediatorManager.java:139-151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L139-L151): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getReceiverName` — src/com/nozha/async/server/mediation/MediatorManager.java:153-163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L153-L163): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getMediateChainForSend` — src/com/nozha/async/server/mediation/MediatorManager.java:165-176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L165-L176): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getHttpMediatorsForSend` — src/com/nozha/async/server/mediation/MediatorManager.java:178-216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L178-L216): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`removeProviderFromChainMap` — src/com/nozha/async/server/mediation/MediatorManager.java:218-235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L218-L235): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.generic.GenericReceivingHttpMediator`, `com.nozha.async.server.mediation.generic.GenericSendingHttpMediator`, `com.nozha.async.server.mediation.generic.ServiceDefinitionProvider`, `com.nozha.async.server.mediation.hamsam.HamsamReceivingHttpMediator`, `com.nozha.async.server.mediation.hamsam.HamsamSendingHttpMediator`, `com.nozha.async.server.mediation.notification.NotificationReceivingHttpMediator`, `com.nozha.async.server.mediation.notification.NotificationSendingHttpMediator`, `com.nozha.async.server.mediation.vo.HttpContent`, `com.nozha.async.server.ratelimit.RateLimitBusiness`, `com.nozha.async.server.ratelimit.RateLimitService`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/handler/HttpHandler.java:167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L167): `Object inputContent = MediatorManager.getInstance().mediateReceive(new HttpContent(req, resp), MediatorManager.HTTP_CHANNAL); `
- [src/com/nozha/async/server/handler/HttpHandler.java:321](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L321): `Object inputContent = MediatorManager.getInstance().mediateReceive(new HttpContent(req, resp), MediatorManager.HTTP_CHANNAL); `
- [src/com/nozha/async/server/handler/HttpHandler.java:372](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L372): `Object outputContent = MediatorManager.getInstance().mediateSend(new HttpContent(req, resp), MediatorManager.HTTP_CHANNAL); `
- [src/com/nozha/async/server/httpserver/AsyncFilter.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L53): `allowedOrigins = AccessibilityService.getAccessListByPeerName(MediatorManager.getReceiverName(request)); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L329): `virtualHostContext.setAttribute(MediatorManager.VIRTUALHOST_PEER_NAME_KEY, peerName); `
- [src/com/nozha/async/server/client/HttpClient.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L58): `AccessibilityService.accessibilityValidation(instance, MediatorManager.getReceiverName(request)); `
- [src/com/nozha/async/server/client/HttpClient.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L95): `AccessibilityService.accessibilityValidation(instance, MediatorManager.getReceiverName(request)); `
- [src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java#L115): `MediatorManager.getInstance().removeProviderFromChainMap(oldProvider); `
- [src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java#L185): `MediatorManager.getInstance().removeProviderFromChainMap(providerName); `
- [src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java#L196): `MediatorManager.getInstance().removeProviderFromChainMap(providerName); `

## Business

SOURCE_OBSERVED: Routes HTTP requests/replies through provider-specific adaptation with per-URI caches. Descriptor changes invalidate caches through ServiceDefinitionProvider; no general runtime user workflow contract.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

MediationException propagates each adapter and business block; casts unchecked. removeProvider catches Exception logs and clears all caches. Prefix concatenation lowercases only final slash, not peerName: mixed-case eviction mismatch candidate. Static first context length differs cross context; cached stateful receiving mediators potential cross-request path/token destination contamination. Reproduce same URI concurrent different headers/body, repeated path params, mixed-case invalidation/context length.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:230-232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L230-L232): `} catch (Exception e) { logger.error("An exception occurred in removeProviderFromChainMap provider={} ", peerName, e); httpReceiveChainMap.clear();`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

ERROR231 provider+stack only failed invalidation then whole cache clear. No successful selection/cache-hit logs; correlate UUID in HttpHandler, POD receive logs where enabled. Absence cannot prove particular mediator used.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/mediation/MediatorManager.java:231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L231) | ERROR | `logger.error("An exception occurred in removeProviderFromChainMap provider={} ", peerName, e);` | ALOG-77E7349AACAF |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L231) in `removeProviderFromChainMap`: catch_clause at 230: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-exception-mediationexception

<!-- source dossier: src/com/nozha/async/server/mediation/exception/MediationException.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java
source_sha256: 5bc7ca6a592062dde58bef93154c36494cad4bfea19aa723ef993361e25606da
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# MediationException — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation.exception`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/exception/MediationException.java:9-42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L9-L42) overloads preserve message/cause; only21-25 assigns both errorPage and Integer errorCode. Page-only17-20 and31-34, ordinary/cause/default preserve null code; protected suppression/stack options40-42. getErrorPage44-46/code48-50 return optional mapping metadata.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:9-11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L9-L11): Observed operation: `super();`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:13-15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L13-L15): Observed operation: `super(message);`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:17-20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L17-L20): Observed operation: `super(message); this.errorPage = errorPage;`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:21-25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L21-L25): Observed operation: `super(message); this.errorPage = errorPage; this.errorCode=errorCode;`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:27-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L27-L29): Observed operation: `super(message, cause);`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:31-34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L31-L34): Observed operation: `super(message, cause); this.errorPage = errorPage;`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:36-38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L36-L38): Observed operation: `super(cause);`.
- [`MediationException` — src/com/nozha/async/server/mediation/exception/MediationException.java:40-42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L40-L42): Observed operation: `super(message, cause, enableSuppression, writableStackTrace);`.
- [`getErrorPage` — src/com/nozha/async/server/mediation/exception/MediationException.java:44-46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L44-L46): Returns `errorPage` unchanged; no validation or side effect.
- [`getErrorCode` — src/com/nozha/async/server/mediation/exception/MediationException.java:48-50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/exception/MediationException.java#L48-L50): Returns `errorCode` unchanged; no validation or side effect.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/handler/HttpHandler.java:265](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L265): `} catch (MediationException e) { `
- [src/com/nozha/async/server/handler/HttpHandler.java:325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L325): `} catch (MediationException e) { `
- [src/com/nozha/async/server/handler/HttpHandler.java:418](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L418): `} catch (IOException | MediationException e) { `
- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L55): `} catch (MediationException e) { `
- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L61): `private void checkBlockServiceCall(HttpServletRequest req) throws MediationException { `
- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L67): `throw new MediationException("provider is blocked", null, 451); `
- [src/com/nozha/async/server/mediation/Mediator.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/Mediator.java#L15): `public abstract Object mediate(Object object) throws MediationException; `
- [src/com/nozha/async/server/mediation/MediatorManager.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L50): `public Object mediateReceive(Object input, int channelType) throws MediationException { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L55): `public Object mediateSend(Object input, int channelType) throws MediationException { `
- [src/com/nozha/async/server/mediation/MediatorManager.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L60): `private Object mediate(Object input, MediateChain mediateChain) throws MediationException { `

## Business

SOURCE_OBSERVED: Carries routing rejection/error/redirect hints to HTTP boundary; message-only exception does not by itself mean HTTP404/405.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

This class declares exception payload, no direct throw/catch. HttpHandler265-288 prioritizes page as307 then nonzero code else503; AsyncServiceCallServlet55-57 maps catch451. No-code constructors intentionally/accidentally yield null; do not invent status. Boundary tests one instance of each constructor.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. Thrower/catcher logs own diagnosis, notably HttpHandler266 and Generic/Hamsam boundary. No correlation fields stored in exception.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-generic-genericreceivinghttpmediator

<!-- source dossier: src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java
source_sha256: 2b19070f5ad7f65b21edb5f7ab03eb052ffc196b09020d7f14f52580e0c0afaf
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# GenericReceivingHttpMediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation.generic`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:42-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L42-L74) mediate mutates providerName/uri/errorPage/service fields, method-aware descriptor lookup, unknown service exception with optional404 error page; sc2 services-do endpoints dispatcher priority composite then business then product, sets peer; business/provider checks and path/provider_name/timeout attrs. wrapper76-107 creates GenericRequest, MessageVO priority1 ttl300000, wrapper type3/UUID; optional POD ARN inherited/new, step increment, attr arn. generic109-229 finds matching method or405; includeExtraParams copies all query/headers/body plus descriptor path/formData. Restricted path copies only described form/query/header/cookie/path/body; omits missing values, no required/type validation. path231-262 lazily caches regex placeholder values on instance and never resets; maps are not copied.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`mediate` — src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:41-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L41-L74): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`generateMessageWrapperVO` — src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:76-107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L76-L107): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`generateGenericRequest` — src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:109-229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L109-L229): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.
- [`getPathParameterValue` — src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:231-262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L231-L262): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.ServiceCallService`, `com.nozha.async.server.mediation.HttpMediator`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.generic.vo.GenericRequest`, `com.nozha.async.server.mediation.generic.vo.Service`, `com.nozha.async.server.mediation.generic.vo.ServiceMethod`, `com.nozha.async.server.mediation.generic.vo.ServiceParameter`, `com.nozha.async.server.mediation.vo.HttpContent`, `com.nozha.async.server.ratelimit.RateLimitBusiness`, `com.nozha.async.server.ratelimit.RateLimitService`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.PODLogUtil`, `com.nozha.async.server.vo.MessageVO`, `com.nozha.async.server.vo.MessageWrapperVO`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L115): `mediators.add(new GenericReceivingHttpMediator()); `

## Business

SOURCE_OBSERVED: Converts HTTP contract to Async generic envelope for peer execution, preserving opaque body and repeated fields. Scope-specific blockers influence consumer admission/destination. Cached per-URI object fields are shared, so this is not safe evidence of request isolation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Unknown service49-52 message "Service not found for uri: "+uri but no integer404, so handler defaults503 unless page; unsupported method122-125405. Cookie branch201 assumes nonnull cookies, ARN-step97 parse can throw, path substring can fail; no local catch. Required fields only metadata, no enforcement. Reproduce omitted required field, absent cookies, malformed ARN-step, sequential dynamic path values and concurrent calls.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:49-51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L49-L51): `throw new MediationException( "Service not found for uri: " + uri, errorPage != null ? errorPage.concat(errorPage.contains("?") ? "&" : "?").concat("errorCode=404&message=Service not found") : null`
- [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:122-124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L122-L124): `throw new MediationException( httpRequest.getMethod() + " method is not supported for this URL", errorPage != null ? errorPage.concat(errorPage.contains("?") ? "&" : "?").concat("errorCode=405&message=" + httpRequest.getMethod() + " is not allowed") : null, HttpServletResponse.SC_METHOD_NOT_ALLOWED`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

No direct logger.info call, but owned PODLogUtil.logGetRequest101 to PODLOG guarded POD_MONITORING_LOGGER91; ARN/new UUID,step,peer+uri,HTTP desc then stores arn. Registry logger-call inventory does not include this helper invocation: discrepancy explicitly supplemental. No token/body logged by this helper here; forwarded headers/body may contain credentials. HttpHandler logs errors and UUID timing.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md` and `source-logging-semantics.md` service-call notes: raw management bodies and proxy-vs-message boundary must stay distinct; proxy 408/227 findings belong ServiceCallProxy, not this class. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-mediation-generic-genericsendinghttpmediator

<!-- source dossier: src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java
source_sha256: 0d22b89ce6e2624084e27f68fcf7d47eb94dc4469b8ae4c401e2419db8640fbe
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# GenericSendingHttpMediator — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.mediation.generic`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java:17-43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java#L17-L43) obtains ClientMessage attr and response, defaults204/null body; if nonnull content JSON-decodes GenericResponse, status provided or200, adds each repeated header, returns body.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`mediate` — src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java:16-42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java#L16-L42): Behavior, branches, inputs/outputs and dependencies interpreted in class narrative; see complete cited method body.

Direct product dependency declarations: `com.nozha.async.server.mediation.HttpMediator`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.generic.vo.GenericResponse`, `com.nozha.async.server.mediation.vo.HttpContent`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.ClientMessage`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/mediation/MediatorManager.java:204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L204): `mediators.add(new GenericSendingHttpMediator()); `

## Business

SOURCE_OBSERVED: Returned peer contract controls HTTP status/headers/body; arbitrary headers not whitelisted by this mediator. Empty/malformed content may look like no content.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Catch Exception37 prints stderr, suppresses failure, returns null; status may already have changed before header failure, so not always204 on parse/processing failure. No ClientMessage returns204; cast/null HttpContent unchecked. Reproduce malformed JSON, null header list, absent status and compare actual response.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java:37-39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java#L37-L39): `} catch (Exception ex) { ex.printStackTrace(); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS logger calls; printStackTrace38 diagnostic not registry log. HttpRequestLogger final status has no parse-failure reason. No correlation added here.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/architecture/http-mediation-and-integration-boundary.md`: HTTP envelope/opaque body/generic response and fixed selected chain observations agree; this dossier adds specialized/cached-state/exception details without claiming arbitrary transformation/workflow support. Existing documents remain untouched candidate material, not approval evidence.
