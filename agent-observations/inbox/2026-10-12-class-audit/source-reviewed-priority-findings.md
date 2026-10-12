---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async — prioritized four-lens findings from source review

**Evidence boundary:** Java source at `Async-Source@781e6c4c61706a798883818982f72fb8fa53a661`. These are review-worthy code behaviors and hypotheses, **not** verified Production incidents, customer impact or approved business rules. The candidate risk rank below is for prioritizing tests, not incident severity. All identified operational behavior must be rechecked against actual deployed SHA/config.

## P0 candidate: permissive TLS in outbound ServiceCallProxy

- **Source-confirmed:** the `X509TrustManager.checkServerTrusted` method returns without checking any certificate, and an `OkHttpClient.Builder` installs it with `NoopHostnameVerifier.INSTANCE`. [ServiceCallProxy L31–L70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L31-L70).
- **Technical failure mode:** HTTPS identity/chain verification is bypassed for connections made through this OkHttp client; TLS encryption alone does not authenticate the destination.
- **Business risk (conditional):** if this path is enabled in a sensitive flow, server impersonation could expose/alter requests. Source contains fields with payment context, e.g. `SourceCardNumber`, `DestinationCardNumber`, `Amount` and an `ApiKey` header sent to `Settings.ESB_END_POINT`. [L94–L117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L94-L117).
- **Unknown:** production endpoint, routing/exposure, real traffic and whether this implementation is deployed or exercised.
- **Recommended:** TL+Security review before enabling/continuing this integration; unit/integration test rejects untrusted and mismatched certificates; use valid trust store and hostname verification, with no unsafe bypass in prod.

## P1 candidate: invalid HTTP status on Rate Limit validation

- **Source-confirmed:** `HttpException(String message)` leaves primitive `statusCode` as 0. [HttpException L3–L37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L3-L37).
- `RateLimitServlet.validateRequestParameters` and Delete validations throw `new HttpException("... is required")` without status. [L128–L187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L128-L187).
- `RateLimitServlet.doProviderAction` catches it, uses `httpException.getStatusCode()` and calls `resp.setStatus(httpStatus)`. [L78–L114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L78-L114).
- **Business:** malformed management request should fail predictably; official 400/422 contract is unknown. **Risk:** response code 0 or Jetty-dependent handling, not runtime-confirmed.
- **Test:** all insert/update/delete required fields, body invalid/empty/JSON malformed; compare response, status and logs. Fix contract under owner approval.

## P1 candidate: cumulative task-count suppresses new async persistence

- `MessageCRUD.createAsyncActiveMessage` compares `ThreadPoolExecutor.getTaskCount()` (cumulative scheduled tasks) against `ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE`; after threshold it logs ERROR but does not `submit` the active-message persistence task. [MessageCRUD L50–L63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L50-L63).
- **Business risk:** loss of this asynchronous DB write path *if* `IS_INSERT_TO_DB_ENABLE` and the threshold path are active. Actual external delivery/durability is not proven.
- **Important:** already documented as a candidate in `generated-knowledge/observability/adr-async-db-persistence-overload.md`; avoid a conflicting duplicate ADR.
- **Test:** deterministic repeated submissions, pool saturation, storage/readback before/after threshold and restart; confirm expected fail-safe behavior with TL.

## P1 review: sensitive payload/metadata logging

- `ServiceCallServlet` logs raw management body at INFO. [L75–L84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L75-L84).
- `RateLimitServlet` logs raw management body at INFO and ERROR. [L78–L105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L78-L105).
- `HttpRequestLogger` writes query string/full URL plus forwarded IP and referrer into `HttpLog` without visible local masking. [L19–L39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L19-L39).
- `HttpHandler` puts `msgPreview` into `ServiceTimeLog`. [L426–L454](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L426-L454).
- **Risk:** possible secrets, tokens and PII in retained/queryable logs. **No observed Production leak established.** Review schema, origin of values, redaction at producer and shipper, retention, access and synthetic canary tests.

## P1 review: ServiceCall error/result mismatch

- On returned response, `ServiceCallProxy` records real downstream HTTP status in `ServiceCallLog`; maps non-200 to internal `227`. [L140–L173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L140-L173).
- In `IOException` catch it logs synthetic `408` and internal `227`; time variables initialized to 0 and populated **after** the synchronous request so an early network failure yields misleading `0 - 0` duration. [L136–L145 and L188–L202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L136-L202).
- The method writes wrapped `ResultSrv` to `resp.getWriter()`, but no explicit `resp.setStatus` occurs inside the reviewed `sendRequest` method. This may decouple HTTP response status from internal error; final servlet/container output **not tested**. [L120–L223](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L120-L223).
- The exception message `e.getMessage()` enters `ResultSrv.result` and may expose internal details to caller. [L196–L215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L196-L215).
- **Test:** downstream returns 200/400/500, connection failure, read timeout, empty body; assert client HTTP code, body contract and ServiceCallLog fields and duration.

## P1 knowledge contract: ACK is not local send completion

- `MessageManager.ackMessage` decodes a `MessageVO` and invokes `MessageCRUD.archiveAckMsg(client.getPeer().getId(), messageVO.getMessageId())`. [L434–L437](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L434-L437).
- `BeforeSendLog` records before `client.sendMessage`; `AfterSendLog` is written after local return, not an independent destination receipt. See [Server send branch](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L800-L850).
- **Unknown:** official retry/resend, idempotency and ACK contract in every route. This was already registered as a Known Gap in `mvp/validated-claims.yaml`. No promises of exactly-once or end-to-end delivery.

## P2 review: misleading health status if used for readiness

- `HealthCheckServlet.doGet` responds `200` with `{"message":"ok SERVER_ID"}` and includes a request ID header; `POST/PUT/DELETE` delegate to `doGet`. No DB/broker/backend connectivity check is visible in this servlet. [L22–L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L22-L46).
- **Meaning:** liveness/HTTP handler reachability, not a full readiness guarantee; actual production orchestrator usage UNKNOWN. Do not use 200 as proof the Async messaging/persistence business flow is healthy.

## P2 review: Rate Limit event timestamps and diagnostic quality

- `RateLimitService` explicitly throws `MediationException` with codes 451 for provider block and 429 for service/rate block. [L130–L145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L130-L145), [L212–L230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L212-L230). These are internal exception codes until mapped by boundary code.
- It emits a `RateLimitLog` with `System.nanoTime()` in a DEBUG call. That monotonic-origin value is **not an epoch timestamp**; the DEBUG event may not be emitted into Production collection. [L212–L230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L212-L230).
- The catch branch around asynchronous service counting logs an ERROR **without the exception instance**, limiting stack RCA. [L145–L155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L145-L155).

## Next proof gates (not safe to skip)

1. Reconcile deployed Git SHA and environment flags before making claims about affected clusters.
2. Validate contract/business intent with TL/PO; source behaviors are not necessarily expected rules.
3. Run deterministic unit + Jetty integration + broker/database tests in Sandbox, with synthetic masked log inspection and correlated request IDs.
4. Register results as observations with raw sensitive evidence kept out of the knowledge repository.
5. Human-reviewed promotion only; `mvp/validated-claims.yaml` should not be modified automatically.

