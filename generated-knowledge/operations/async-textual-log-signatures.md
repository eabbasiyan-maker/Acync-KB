---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
promotion_status: review-required
created_at: 2026-10-09
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/tree/781e6c4c61706a798883818982f72fb8fa53a661
  - https://github.com/eabbasiyan-maker/Acync-KB/blob/main/mvp/validated-claims.yaml
evidence_refs: []
---

# Async textual logs and incident signatures — audit v0.2

**Status:** New unreviewed source-derived candidate observations. A product stakeholder approved the v0.1 baseline for candidate retrieval; this v0.2 expansion has NOT undergone independent human review or production runtime validation. Do not promote findings to trusted operational guarantees automatically.

## 1. Audit scope and methodology

- Local snapshot: supplied Async source archive containing 401 Java files.
- Scan: Java source search for conventional logger method calls at INFO/WARN/ERROR/DEBUG/TRACE/FATAL levels. Commented-out code was excluded from scanning; code paths, integrations, logger filters and live log ingestion were NOT executed.
- Result: **953 statically detected logger call sites across 116 Java files**: WARN 398, ERROR 261, INFO 191, DEBUG 102, TRACE 1.
- The scan identifies call sites rather than unique event types, production log records or actual error frequency. It can omit nonconventional logging and cannot distinguish unreachable code from live paths.
- Audit-level grouping by source directory is descriptive only: persistence-related 334 call sites, protocol-handler 162, message-delivery/Server 66, client 72, HTTP 46, mediation 46, rate-limit 41, message-broker 34; other paths remain.
- Manual live GitHub SHA comparison confirmed that selected files (Server.java, HttpHandler.java, MessageCRUD.java, RateLimitService.java, ServiceCallServlet.java, Settings.java) exactly match the supplied archive. **The entire source archive was not byte-for-byte compared with the GitHub tree.**
- Source baseline: `eabbasiyan-maker/Async-Source@781e6c4c61706a798883818982f72fb8fa53a661`. Production deployed commit is unknown.

## 2. Operational signature map

These signatures are *exact source text fragments or source-observed concepts*, not assertions that the corresponding Kibana pipeline currently ingests them.

### A. HTTP request handling and mediation
- `httpHandler parsRequest more than threshold` — request parsing duration exceeded `Settings.HTTP_THRESHOLD_TIME`; not necessarily total request latency. [HttpHandler.java:145-150]
- `httpHandler mediateReceive more than threshold` — receiving mediation plus the checked section exceeded the same threshold. [HttpHandler.java:166-171]
- `httpHandler async context start more than threshold` — elapsed time from scheduling asynchronous context to callback execution exceeded threshold; useful as a possible scheduling-delay indicator, not proof of saturation. [HttpHandler.java:179-190]
- `TooManyOpenedClientException` — branch specific to open-client control, not generic HTTP timeout. [HttpHandler.java:248]
- `MediationException` / `AccessibilityException` — distinct failure categories; HTTP status is branch-dependent. [HttpHandler.java:262-288]
- `ServiceTimeLog` — structured context and time at request finalization, conditional on start-time and branch.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/HttpHandler.java

### B. Message delivery and client resolution
- `client not registered new msg` — selected receiver not found as registered in the inspected delivery path. Check alternate persistence or queue path before declaring loss. [Server.java:770-803]
- `try to save message to data base` — attempted fallback/creation path; not proof a DB write succeeded. [Server.java:795-803]
- `BeforeSendLog` → `client.sendMessage` → `AfterSendLog` — conditional attempt and successful return from send call. Not an end-user ACK or business consumption guarantee. [Server.java:808-842]
- `PersistenceException occurred while sending message`, `ServerException occurred in messageSender` — exception-specific failure path. [Server.java:850-871]
- `interrupt send message` / `timeout send message` — interrupt or timeout-related branch; correlate trackerId, messageId, peerId and return status. [Server.java:888-906]
- `client not registered` in postponed/pending message handling — may represent an offline/delayed receiver, not necessarily product failure. [Server.java:1149, 1206]

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/Server.java

### C. WebSocket and connection lifecycle
- `WebsocketAddressLog` — connection snapshot when a new WebSocket opens; includes address, registered/unregistered client map counts. [WebsocketHandler.java:120]
- `close peerId` — close event with statusCode and reason; not automatically abnormal without close-code interpretation. [WebsocketHandler.java:147]
- `socket send message exception` — failure in sending to an attached WebSocket client. [WebsocketHandler.java:92-94]
- `on error in websocket` / `removed websocket peer on error` — error and cleanup; distinguish trigger from the follow-on cleanup. [WebsocketHandler.java:186-189]
- `OpenClientAddressLog` — branch enforcing opening-client limits; not proof of malicious traffic.

Sources:
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/WebsocketHandler.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/biz/LoadManager.java

### D. Broker and inter-server messaging
- `async consumer-{} start reconnected` — reconnect attempt/event in consumer path; does NOT itself establish successful reconnection or permanent broker failure. [AsyncConsumer.java:32]
- `async producer-{} start reconnected` — analogous producer path. [AsyncProducer.java:37]
- `JMSException in send message to server` — outgoing inter-server message path hit JMS exception; correlate serverId and messageId. [AsyncProducer.java:57]
- `not connect or create session for id` — broker session/connection problem. [AsyncQueueAdaptor.java:72]
- `Internal Message Sender ThreadPool is almost full` — observed high thread utilization after enqueueing `MessageSender`. [AsyncInternalMessageSender.java:21-26]

Source files:
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/activemq/AsyncProducer.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/activemq/AsyncConsumer.java

### E. DB persistence, capacity and retry
- `Async DB ThreadPool task size more than threshold` — branch omits submit of `createActiveMessage` task (see P0 below). [MessageCRUD.java:50-56]
- `Async DB ThreadPool is almost full` — active-thread utilization threshold; not a queue depth measure. [MessageCRUD.java:57-60]
- Persistence-specific WARN/ERROR from Oracle/MySQL CRUD implementations require grouping by DB vendor; source code presence does not establish an enabled production vendor or failing query.
- Connection errors, unsuccessful writes, fallback and retransmission should be distinguished from final persistence or delivery state.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/persistance/MessageCRUD.java

### F. Rate Limit and request rejection
- `Request blocked due to rate limit` — temporary block branch throws MediationException with 429. [RateLimitService.java:216-218]
- `provider is blocked` — permanent block branch throws MediationException with 451. [RateLimitService.java:212-214]
- `service is blocked` — service/provider-specific blocking path; not identical to the count-based temporary block. [RateLimitService.java:138]
- `RateLimitLog` is emitted at DEBUG in the inspected branch; its `time` is `System.nanoTime()`, not epoch time. [RateLimitService.java:229]
- User-visible HTTP status depends on the exception's handling path. Distinguish rejection cause, observed response and configured rule.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/ratelimit/RateLimitService.java

### G. Service Call proxy
- `service call connection pool used more than 60 percent` — warning is based on `(connectionCount-idleCount)/connectionCount`, not a 60% CPU/memory alert. [ServiceCallProxy.java:121-127]
- `exception in proxy service call uuid` — IOException catch block. [ServiceCallProxy.java:188-195]
- `ServiceCallLog.status` and `serviceCallStatusCode` are different concepts; `227` is an internal classification, not destination HTTP response 227.
- The IOException log may record elapsed time using zero-initialized local variables, making reported failed-call latency misleading.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/ServiceCallProxy.java

### H. Configuration / API descriptor lifecycle
- `swagger file is not valid` and `Can not get/update swagger file` can indicate a problem with service descriptor reload; check last working version and provider-specific scope.
- `version not found in Swagger` and `info tag not found in Swagger` are descriptor validation signals, NOT direct proof of a failed user request.
- Correlate descriptor logs with ServiceCall/HTTP path and release changes.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java

## 3. High-priority code-risk candidate: cumulative TaskCount in DB executor (P0 to triage)

**Location:** `MessageCRUD.createAsyncActiveMessage(Message message)`, lines 50–60, with `Settings.ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE = 500` default in `Settings.java`.

**Source evidence:**
1. `executorService` is a static `ThreadPoolExecutor` created through `Executors.newFixedThreadPool(...)`.
2. The branch compares `executorService.getTaskCount() > Settings.ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE`.
3. On true, it logs ERROR and skips `executorService.submit(() -> messageCRUDInterface.createActiveMessage(message))`.
4. According to official `ThreadPoolExecutor.getTaskCount()` Javadoc, this is an approximate cumulative total of tasks ever scheduled, **not** the number currently queued. It does not reset when work completes.
5. Thus, once the cumulative count passes the threshold, subsequent calls following this enabled path can keep skipping task submission even when the current workload is low.

**Scope and uncertainty:** This only occurs when `Settings.IS_INSERT_TO_DB_ENABLE` is true and execution reaches `createAsyncActiveMessage`; the scanned `Server.java` branch reaches it conditionally for an active-path message with no binary content. No production version, config value, event frequency or observed data-loss incident was supplied. The effect on downstream recovery needs runtime verification.

**Proposed triage:** Confirm deployed code and feature flag immediately; search Kibana for the exact ERROR signature across all nodes; compare behavior before/after threshold with active, completed and queued task counts; inspect affected `messageId` against persisted records and delivery status, without assuming every such log is a lost message.

**Proposed remediation (not a code change):** Select the correct saturation metric (`getQueue().size()`, active thread count) and explicit bounded-queue/backpressure/rejection strategy, preserving persistence guarantees. Add unit/load regression tests that exceed 500 completed tasks then submit more while idle. Ensure failure to enqueue cannot silently masquerade as successful persistence.

**References:**
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/persistance/MessageCRUD.java#L19-L62
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/Settings.java#L345-L353
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html#getTaskCount()

## 4. Secondary review candidates

- **P1 — Incorrect Jetty metric name:** `JettyQueueSizeLogger` logs `threadPoolSize` but reads `getQueueSize()`; any Kibana panel using that label can be misleading.
- **P1 — ServiceCall failure duration:** inspect exception path for uninitialized elapsed-time variables; split success/error latency in dashboards.
- **P1 — Sensitive information in logs:** `ServiceCallServlet` INFO logs the entire raw management request body via `logger.info("start {} {}", action, body)`. Review actual accepted schema for secrets and redact sensitive fields if present. `HttpHandler` masks token characters before logging in one mediation exception branch, but safe masking depends on the helper/config; do not claim plain token leakage from that code alone.
- **P2 — Missing ADDRESSLOG appender:** `log4j2.xml` refers to ADDRESSLOG logger/appender while no matching appender is defined in that inspected file; runtime overrides are unverified.
- **P2 — Missing or filtered DEBUG telemetry:** debug-level RateLimitLog may not appear in production; logger sampling/filter levels must be verified.

## 5. Minimal analysis playbooks

**HTTP slowness:** Align timestamp/timezone, environment, host and request identifier. Compare `HttpLog` request/response, `ServiceTimeLog.time`, the three HttpHandler threshold WARN signatures, optional POD ARN stages, Zabbix Jetty queue/threads, CPU/GC and downstream service latency. Mark each causal hypothesis as unverified until corroborated.

**Delayed or missing message:** Collect messageId, trackerId, receiver peerId, node and ARN if any. Compare `BeforeSendLog`, `AfterSendLog`, Server's receiver/client lookup, timeout/interrupt WARN, persistence path and producer/consumer errors. Validate ACK/Retry semantics with the owner; do not equate send completion with destination consumption.

**Service Call failure:** Identify `uuid` and `businessId`; compare ServiceCallLog internal vs HTTP statuses and SCLOG IOException. Separate destination response code from synthetic status and use independent time measurements for failed calls.

**Rate Limit spike:** Identify exact blocking branch, key type (IP/business/provider/service), applicable rule and actual HTTP status. Compare HTTP request rates by trustworthy origin, and check manager-side settings and cluster targeting. Do not infer attack merely from increased blocks.

**Queue/DB saturation:** Separate queue depth, concurrent active tasks, cumulative completed/scheduled task counts and throughput. Do not assume log labels correctly describe the underlying getters.

## 6. Production readiness unknowns

- Deployed Async source commit and cluster/node feature flags.
- Actual Kibana data views/index mappings, log pipeline, masking and logger levels.
- Zabbix host↔node association, item keys, collection frequency and alert thresholds.
- Normal baseline by service, node, hour of day and traffic load.
- Official ACK and Retry/Resend semantics, verified current production database and broker setup.

## 7. Governance

This document supports review and analyst retrieval at `trust: candidate` only when cataloged and merged. Newly found P0/P1 issues are **suspected code risks requiring owner review**, not confirmed live incidents. Never import them as `trusted` claims without appropriate human verification; do not modify `mvp/validated-claims.yaml` on this basis.
