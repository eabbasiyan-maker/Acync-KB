---
doc_class: fact
trust_level: untrusted-content
lifecycle: snapshot
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
promotion_status: approved-for-candidate-retrieval
human_approval: 2026-10-09-chat-confirmation
runtime_validation: pending
created_at: 2026-10-09
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/tree/781e6c4c61706a798883818982f72fb8fa53a661
  - https://github.com/eabbasiyan-maker/Acync-KB/blob/ff59c66afce6560ab5acc349e08319cb983062ae/mvp/validated-claims.yaml
evidence_refs: []
---

# Async Observability & Reliability — Baseline v0.1

**Disposition:** Human-approved for candidate retrieval, still pending runtime validation. These are source-derived observations, not approved production behavior or official product contracts.

**Purpose:** First-pass reference for analyzing Kibana logs and Zabbix metrics alongside Async business workflows, Source Code, and Knowledge Base.

**Source baseline:** Async-Source at commit 781e6c4c61706a798883818982f72fb8fa53a661. An uploaded Async ZIP was also used in the originating report; only sample file identity was checked against the repository, not every ZIP file. **Knowledge baseline:** Acync-KB at commit ff59c66afce6560ab5acc349e08319cb983062ae.

**Evidence limitation:** Production deployments, actual logger enablement, Kibana/Zabbix configurations, Alert thresholds, traffic volumes, cluster mappings, release versions, metrics pipeline and real incident traces have NOT been validated. No root cause is confirmed by this static study.

## A. Partial operation-to-log flow

### HTTP / mediation / message delivery / response
1. HTTP request enters Jetty. HTTPLOG / HttpLog captures method, URL/path, response status, client-side header information and traffic sizes.
2. HttpHandler parses and processes the request; conditional rate/access checks and mediation apply.
3. For a registered REST provider, generic receiving mediation can adapt an HTTP request into an Async message envelope. Specialized mediation may behave differently.
4. In the message-send branch identified in Server.java, a BeforeSendLog is emitted before client.sendMessage; an AfterSendLog is emitted only after that call returns successfully. Both are conditional on the code branch and nonzero message id.
5. POD Monitoring, when enabled and when correlation information is available, records selected GET-request / SEND-request / GET-response / SEND-response transitions.
6. HttpHandler can record a ServiceTimeLog during final request completion under conditions including the existence of start time.

**Important:** This is a combined conceptual map of several conditional branches; NOT a promise that every REST, WebSocket, Queue, offline, retry or error request emits all of these events. AfterSendLog does not confirm that the receiver consumed the message.

Evidence:
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/HttpHandler.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/Server.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/QueueHandler.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/util/PODLogUtil.java
- https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java

### Dedicated Service Call proxy

HTTP -> ServiceCallProxy.handleDoServiceCall -> set start_time and UUID (from configured client request ID header or newly created) -> construct outbound request -> OkHttp request to configured endpoint -> SCLOG warnings/errors and SCJSONLOG ServiceCallLog outcome.

**Boundary:** This special-purpose proxy is not a universal implementation of generic mediation.

Evidence: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/ServiceCallProxy.java

## B. Structured log catalog (initial nine types)

### 1. HttpLog
- **Business/operational event:** Incoming HTTP request and response as captured by Jetty CustomRequestLog.
- **Fields of interest:** response_code, businessId, original_src, http_x_forwarded_for, uri_path, http_method, bytes_in, bytes_out, req_time, timestamp.
- **Interpretation caution:** X-Forwarded-For is a supplied HTTP header; it is not automatically a trusted actual client IP. HTTP log timestamps alone do not establish end-to-end application latency.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java

### 2. ServiceTimeLog
- **Event:** Duration and context of request handling along the HttpHandler path.
- **Fields:** time, clientTime, status, uuid, lastTrackerId, businessId, provider, origin, ARN, ARNStep, uri, address, host.
- **Caution:** time and clientTime are different concepts; logging is conditional on start time and finally-path behavior. Determine its exact time boundaries before comparing it with another latency series.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/HttpHandler.java

### 3. BeforeSendLog
- **Event:** Async begins an attempt to send a selected message to a Client.
- **Fields:** messageId, trackerId, sender, receiver, client, serverId, messageServerId, retryCount, time, ARN, ARNStep.
- **Caution:** The constructor's retryCount argument is sourced from message.getVersion() at the inspected call site. Do not equate it to the official Retry count or Retry policy without validating Version semantics. Emission in the reviewed branch is conditional on nonzero message ID.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/Server.java

### 4. AfterSendLog
- **Event:** The selected client.sendMessage invocation returned successfully at the corresponding code point.
- **Fields:** messageId, trackerId, sender, receiver, client, messageType, writeMessageTime, time, ARN, ARNStep.
- **Caution:** Does NOT prove destination ACK, message receipt, or consumption by the business service. writeMessageTime represents the send-call duration in the inspected branch, not end-to-end delivery.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/Server.java

### 5. PODMonitoringLog
- **Event:** Selected stages GET-request, SEND-request, GET-response and SEND-response, suitable for correlation by ARN/ARNStep where supplied.
- **Fields:** ARN, ARNStep, action, duration, totalDuration, statusCode, srcName, descName, uri, srcServerIp, time.
- **Caution:** Production emission depends on Settings.POD_MONITORING_LOGGER; selected paths also require an ARN. Duration and totalDuration refer to different stages depending on action.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/util/PODLogUtil.java

### 6. ServiceCallLog
- **Event:** Result of a ServiceCallProxy outbound request.
- **Fields:** uuid, businessId, time, status, serviceCallStatusCode.
- **Caution:** serviceCallStatusCode=227 is an application/internal error classification in the reviewed path, not HTTP 227. In an IOException branch, now/requestStartTime can remain zero and time can be misleading. The logged status=408 in that branch is not necessarily a genuine HTTP response returned by the destination.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/ServiceCallProxy.java

### 7. RateLimitLog
- **Event:** Counting/management of Rate Limit requests along selected code paths.
- **Fields:** reference, message, time, count.
- **Caution:** One observed call emits at DEBUG and gives time=System.nanoTime(); this is not an absolute calendar timestamp. Verify runtime logger levels before assuming such records are available.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/ratelimit/RateLimitService.java

### 8. WebsocketAddressLog
- **Event:** Snapshot of WebSocket connection state when a connection opens along the inspected path.
- **Fields:** address, notRegisteredClientMapSize, clientMapSize.
- **Caution:** This is not a continuous count or a disconnect counter; do not derive total active connections over a period merely by counting these events.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/WebsocketHandler.java

### 9. OpenClientAddressLog
- **Event:** LoadManager control detects excessive open connections for a source and records the address/client type in the inspected branch.
- **Fields:** address, clientType.
- **Caution:** This is not automatic evidence of an attack; assess configured thresholds and real traffic.
- **Source:** https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/biz/LoadManager.java

**Completeness:** These nine structured classes do not represent all possible logs. There are numerous INFO/WARN/ERROR/DEBUG textual log statements across the source that still require inventory and semantic mapping.

## C. Configured log outputs in repository

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/resources/log4j2.xml

| Logger / appender | Configured relative file |
| --- | --- |
| DG2 / AsyncRoot | async.log |
| JSONLOG | async_json.log |
| HTTPLOG | async_http.log |
| PODLOG | pod_monitoring.log |
| SCJSONLOG | sc_json.log |
| SCLOG | sc.log |

These file paths are under the configured LOG_FILE_PATH. They are NOT verified filesystem paths or active log destinations in production.

**Investigation candidate:** An AsyncLogger named ADDRESSLOG references an Appender named ADDRESSLOG, but a corresponding appender definition is not present in the inspected log4j2.xml. Confirm whether another configuration or runtime override is used before classifying this as a production defect.

## D. Five interpretation risks for Kibana/Zabbix

1. **Jetty metric label mismatch:** JettyQueueSizeLogger logs the result of threadPool.getQueueSize() under text label "jetty threadPoolSize". This value represents queue size, not thread-pool size. It also logs utilized-thread count and utilization rate. Source: https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java
2. **ServiceCall error duration distortion:** In ServiceCallProxy's IOException catch path, variables used for elapsed time may not have been initialized; some failed requests can report misleading zero time. Analyze successful and failed call latency separately.
3. **Send versus delivery:** AfterSendLog is not an acknowledgment by the destination. The KB explicitly registers exact ACK semantics and formal Retry/Resend policy as unresolved, even though duplicates in ACK/Resend scenarios have been human-confirmed.
4. **RateLimitLog clock:** System.nanoTime() is monotonic elapsed-time clock output, not an epoch timestamp. Do not graph it as a wall-clock event time.
5. **Source versus observed production:** An event missing in Kibana may be due to a disabled log level, configuration, Log Shipping, parsing, filtering, or an unexecuted branch. Absence of a record is not proof an event never happened.

Validated-claims reference: https://github.com/eabbasiyan-maker/Acync-KB/blob/main/mvp/validated-claims.yaml

## E. Preliminary incident-analysis matrix

| Symptom | First evidence to correlate | Hypotheses to test (not conclusions) |
| --- | --- | --- |
| Increased HTTP processing time | ServiceTimeLog.time by provider, URI and status; HttpLog.response_code | Slow destination, wait/queueing, Jetty load, infrastructure issues |
| Service Call errors | ServiceCallLog.status/serviceCallStatusCode/uuid plus SCLOG | Destination returned an error vs IOException/Timeout; internal status classification |
| Message not delivered | BeforeSendLog and AfterSendLog joined by messageId/trackerId; Server textual WARN/ERROR | Client unavailability, send exception, pending/persistence path, timeouts |
| Increase in connections | WebsocketAddressLog/OpenClientAddressLog and Zabbix memory/connection charts | Organic growth, unregistered clients, per-IP control, resource use |
| Jetty slowing/saturation | Actual queue size, utilized threads/rate, CPU/GC, latency and errors | Thread or queue saturation; correct the misleading label first |
| Increased Rate Limit rejections | Relevant HTTP errors, RateLimitLog if enabled, control configuration | Higher traffic, invalid threshold, anomalous request patterns |

All RCA results must distinguish a directly observed fact from a proposed causal explanation.

## F. Information required from the real monitoring environment

- Kibana panel title, query/filter, aggregation, unit (ms/s/bytes/count/percent), interval, time zone and exact time range.
- Zabbix item key, host, group, trigger definition, threshold and collection interval.
- Environment, cluster, node/host, deployed version/commit and recent release/config changes.
- Sanitized Raw Logs representing both normal and abnormal behavior in the same time window. Remove tokens, secrets, card numbers and personal data.
- Comparable prior baseline for the same hour/week/traffic profile; peak versus off-peak annotation.
- Host/Node mapping between Zabbix and Kibana for meaningful cross-tool correlation.
- Monitoring pipeline/retention and missing-event coverage.

No production alert threshold is approved in this baseline.

## G. Validation backlog and priorities

**High priority**
- Inventory all textual INFO/WARN/ERROR/DEBUG logs and group them by Message Delivery, TCP/WebSocket/HTTP, ServiceCall, Queue, Persistence, RateLimit, Startup/Config and Security.
- Get human-validated ACK semantics, Retry/Resend policy ownership and Message Version meaning; distinguish send invoked, send completed, ACK and confirmed delivery.
- Inventory actual Kibana panels, Zabbix metrics, item keys and aggregation definitions.

**Medium priority**
- Map deployed release/commit to this source baseline and check AsyncManager / per-cluster configuration differences.
- Audit correlation IDs and log emitter coverage, logger levels, retention, permissions and exposure of sensitive fields.
- Validate the suspected ADDRESSLOG configuration gap and the ServiceCall/Jetty metric interpretation pitfalls against real deployments.

## H. Analysis output contract

For every incident or anomaly:

1. Verified observation and timestamp/range.
2. Scope and technical/business impact.
3. Competing hypotheses, labeled clearly.
4. Discriminating tests and correlation evidence.
5. Confirmed / unsupported / unknown statements.
6. Remediation proposals with priority, cost/impact and risk.
7. Validation plan after the change.

**Promotion policy:** The document was approved by the product stakeholder for candidate retrieval on 2026-10-09. Candidate status is NOT trusted operational truth and is NOT production-validated. Promotion to a trusted operational claim requires independent human review of each claim, version matching, and runtime/monitoring evidence. Do not modify validated-claims.yaml based on this document alone.
