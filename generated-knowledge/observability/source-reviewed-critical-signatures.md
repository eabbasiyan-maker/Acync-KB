---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async — Critical Log Semantics & Correlation Map (Source Review v1)

**Purpose:** Focused human-readable semantic review of the operationally critical logging paths in the supplied Async source archive. Source-local facts are separate from inferences. Archive vs deployed binary version is **UNKNOWN**. This is **candidate reference material** for human review, not a trusted production guarantee.

Source permalink base: `https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/`.

## Message Delivery (P0/P1)

- **ALOG-935D432F44CE | `Server.java:786` | WARN `client not registered new msg`.** Emitted when recipient resolution returned no client, after tracker/client-map lookup. The following fallback attempts DB save only if `message.getId()!=0 && message.getReceiver()!=0`; for `fromActive` this further requires `binaryContent==null` to invoke `MessageCRUD.createAsyncActiveMessage`. **Do not equate with lost message.** IDs: message ID, tracker ID, receiver, server ID. Source: `src/com/nozha/async/server/Server.java:755-804`.
- **ALOG-EA217CF03EAD | `Server.java:809` | INFO `BeforeSendLog`.** Inside the client-found branch, `message.getId()!=0`; before `MessageManager.doMessageSent`, `startTimer`, payload creation and `client.sendMessage`. `retryCount` constructor receives `message.getVersion()` (interpretation as actual retry count not proven). IDs: messageId/trackerId/client/sender/receiver/ARN. **May log even if send later fails.** Source: `Server.java:805-825`.
- **ALOG-9257352129C9 | `Server.java:831` | INFO `AfterSendLog`.** Only after returning from `client.sendMessage(payload)` in this branch; under `message.getId()!=0`. `writeMessageTime = currentTime-startSendMessage`, not receiver ACK. IDs same core join key as BeforeSend. **Does not prove eventual delivery or consumption.** Source: `Server.java:825-848`.
- **Server.java:859 / :869 | WARN PersistenceException / ServerException.** These branches can attempt message status recovery and re-enqueue via `MessageCRUD.createAsyncActiveMessage`, subject to `binaryContent`, `pendingMessageWriteBefore` and `fromActive`. When correlating send exceptions do not assert that recovery/persistence succeeded without DB evidence. Source: `Server.java:850-870`.
- **ALOG-D10FCB5AE889 | `MessageCRUD.java:53` | ERROR cumulative task count threshold.** When `Settings.IS_INSERT_TO_DB_ENABLE` is true and `executorService.getTaskCount() > Settings.ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE`, ERROR is logged and `submit` skipped in this method. `getTaskCount()` is a cumulative approximate count of tasks scheduled; it is **not** instantaneous queued work. **Code-risk candidate P0 for immediate engineering triage**; deployed-code parity and actual data loss UNKNOWN. Source: `src/com/nozha/async/server/persistance/MessageCRUD.java:18-62`, `src/com/nozha/Settings.java:348-349`.
- **ALOG-0753369E793E | `MessageCRUD.java:59` | ERROR active-count utilization.** The condition compares active count with `thresholdPoolSize` after a submission decision, not queue length. This is a distinct signal from cumulative task threshold. Source: `MessageCRUD.java:57-61`.
- **ALOG-F263E3EBD3A2 | `AsyncInternalMessageSender.java:24` | ERROR pool utilization.** Triggered if active thread count exceeds configured utilization after task submission. This does **not** measure actual queue depth. Source: `src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java:18-28`.

## HTTP handling, latency and result codes

- **ALOG-661971303632 | `HttpHandler.java:439` | INFO `ServiceTimeLog`.** In the `finally` block when `startTime != null`. Duration is `currentTime-startTime`; `clientTime` is `currentTime-clientMessage.getTime()` or zero. `status` is current `resp.getStatus()`, not automatically a downstream HTTP status. Correlation: `lastTrackerId`, `uuid`, business/provider/host, ARN. Source: `src/com/nozha/async/server/handler/HttpHandler.java:428-456`.
- **ALOG-EC3BB7CB5A99 | `HttpHandler.java:150` | WARN parse threshold.** Triggered by `diffTime` exceeding `Settings.HTTP_THRESHOLD_TIME`; this is a stage, not end-to-end latency. Source: `HttpHandler.java:140-155`.
- **ALOG-F853286E1EA3 | `HttpHandler.java:171` | WARN mediateReceive threshold.** Triggered by the local measured section exceeding HTTP threshold; compare with other stage timing cautiously. Source: `HttpHandler.java:159-176`.
- **ALOG-AFF031C9B84F | `HttpHandler.java:188` | WARN async context scheduling.** Callback checks elapsed wall-clock since prior scheduling; may reflect queue/scheduling delay. This alone does not prove Jetty exhaustion. Source: `HttpHandler.java:177-190`.
- **ALOG-C82DA1024003 | `HttpClient.java:73` | ERROR `http request onTimeout`.** `AsyncListener.onTimeout` callback of `request.startAsync()` after HTTP client creation; includes peer name, last tracker ID, address and request `timeout` attribute; then removes client with timeout status. Initial timeout set from `Settings.DEFAULT_HTTP_IDLE_TIMEOUT` and may be overridden later by `HttpHandler`. Presence of this log supports a timeout callback, **not by itself the final response status**. Source: `src/com/nozha/async/server/client/HttpClient.java:55-81`; `HttpHandler.java:182`.
- **ALOG-7961D5472658 | `HttpClient.java:80` | ERROR `http request onError`.** AsyncListener.onError callback; not the same as onTimeout, even though both destroy/clean up the client. Source: `HttpClient.java:77-81`.
- **ALOG-C6226B3E78A1 | `JettyQueueSizeLogger.java:27` | INFO misleading threadPoolSize.** First value is actually `threadPool.getQueueSize()`; second and third are `getUtilizedThreads()` and `getUtilizationRate()`. Do not use first value as configured pool size. Source: `src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:24-28`.

## Oracle, Service Call, Provider Contracts

- **ALOG-9EB16CE5286F | `OracleClientCRUD.java:62` | ERROR addClient database exception.** In `catch(SQLException)` during `INSERT INTO client_map(peer_id,tracker_id,server_id)`; thrown exception is logged and `PersistanceException` propagated. In a historical sample ORA-00001 appeared 100 times; the source call-site itself does not imply Oracle is enabled in current production. Source: `src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java:43-68`.
- **ALOG-EF65A696D928 | `OracleClientCRUD.java:66` | WARN slow addClient.** Logged only after a **successful** try block if end-to-end method time exceeds `Settings.DATABASE_THRESHOLD_TIME`; `connectionTime` is part of elapsed total. Errors take the catch-and-throw path and do not reach this WARN. Source: `OracleClientCRUD.java:43-68`.
- **ALOG-CF3FA018533C | `ServiceDefinitionProvider.java:156` | ERROR unable to get/update Swagger.** Caught exception in the provider download/refresh loop. The caller may retain an older descriptor; source evidence needed to prove service unavailability. Source: `src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:130-157`.
- **ALOG-8DF2C8AFDB6E | `ServiceDefinitionProvider.java:153` | WARN invalid Swagger.** Happens in branch `newProvider == null` after candidate document load; not necessarily an unreachable provider network. Source: `ServiceDefinitionProvider.java:135-156`.
- **ALOG-D671D0636775 | `ServiceCallProxy.java:127` | WARN connection pool utilization >60%.** `usage=(connectionCount-idleConnectionCount)/connectionCount`; **not CPU** and not a generic thread-pool saturation warning. Source: `src/com/nozha/async/server/handler/ServiceCallProxy.java:120-127`.
- **`ServiceCallProxy.java:147` and `:190` | INFO `ServiceCallLog`.** Successful HTTP response path logs actual response code and internal `serviceCallStatusCode` mapping (0 on 200, 227 otherwise). IOException path sets status 408 and may compute `time=now-requestStartTime` before the `now`/`requestStartTime` variables have been assigned (initialized to 0). Distinguish synthetic 408 from destination response and invalid latency; do not assume the caller received HTTP 408. Source: `ServiceCallProxy.java:140-200`.
- **`ServiceCallServlet.java:82` | INFO raw management request body.** After nonempty request body read, logs entire body before parsing to `ServiceCallConfig`; masking and actual sensitivity need Schema + runtime checks. Treat as sensitive-data exposure candidate for review; do not copy raw logged bodies into KB. Source: `src/com/nozha/async/server/httpserver/ServiceCallServlet.java:75-84`.

## Rate Limit and WebSocket

- **ALOG-B21406E5E09A | `RateLimitService.java:217` | INFO temporary-block.** In `countRequestsAndSendToAsyncManager` when a config exists, temporary block flag is true and current time is before expireTime, logs then throws `MediationException(...,429)`. Final HTTP status relies on exception handling. Source: `src/com/nozha/async/server/ratelimit/RateLimitService.java:210-218`.
- **ALOG-FE9AA774D2CC | `RateLimitService.java:213` | INFO permanent-block.** Config exists and `getPermanentBlock()` true, logs and throws `MediationException(...,451)`. Unlike 429 threshold branch, this is permanent blocking. Source: `RateLimitService.java:210-214`.
- **ALOG-F71D4CF12110 | `RateLimitService.java:229` | DEBUG `RateLimitLog`.** Emitted while rate-limit config exists after increment. Field `time=System.nanoTime()` is monotonic counter, **not epoch timestamp**. With INFO Root, DEBUG may be filtered without explicit overrides. Source: `RateLimitService.java:209-231`, `resources/log4j2.xml:59-78`.
- **ALOG-BEE858552C14 | `WebsocketHandler.java:120` | INFO `WebsocketAddressLog`.** On `onOpen`, after `WebsocketClient` construction and optional opening-client validation, both maps are updated, then a snapshot is logged **before** ping. This does not prove successful ping, long-lived connection, or authentication. `ADDRESSLOG` AppenderRef has no corresponding RollingFile in scanned config. Source: `src/com/nozha/async/server/handler/WebsocketHandler.java:109-122`, `resources/log4j2.xml:62-64`.
- **ALOG-132F0B526B9F | `WebsocketHandler.java:147` | INFO close.** Logged if `webSocket != null` and removed Client has non-null Peer. Includes close code and reason; not all normal closes necessarily produce this event. Source: `WebsocketHandler.java:142-154`.
- **ALOG-A2726E34F80E | `WebsocketHandler.java:186` | WARN error.** `onError` branch; a subsequent `removed websocket peer` INFO may reflect cleanup rather than independent failure. Source: `WebsocketHandler.java:181-192`.
- **PODLogUtil.java:52,58,64,70 | INFO `PODMonitoringLog`.** GET/SEND Request/Response stage events. Required ARN and POD logger configuration may prevent emission; ARN/ARNStep enable stage correlation, not guaranteed presence in every request. Source: `src/com/nozha/async/server/util/PODLogUtil.java:1-89`.

## Runtime source-version mismatch discovered by joining historic logs with source classes

The historical textual sample contains **4,032 events** whose `source.class` is `com.nozha.async.server.activemq.classic.EmbeddedBroker`. That class does **not** exist in the supplied 401-Java source archive; all 4,032 events are from that missing class. Thus this runtime log family **cannot be source-traced** in the supplied snapshot. 118 `invalid queue name` occurrences belong to this missing class. Their frequency is historical only; do not fabricate an `EmbeddedBroker` source path or infer its exact trigger from the current archive. Collect the deployed artifact/source revision of that date for audit, or mark UNKNOWN. **This demonstrates why source-only mapping and historical evidence must be separated.**

## Review status

Source-local conditions listed above were manually inspected in the archive. Full caller chain, deployment feature flag, log shipping and release parity remain unresolved. The complete remaining registry keeps exact trigger/cause UNKNOWN until source-level or runtime validation. For every case: absent log in the old 6/20-minute samples ≠ absent code risk.