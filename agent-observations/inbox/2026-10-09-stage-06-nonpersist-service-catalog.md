---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-partial
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Stage 6/27 — Async service / operational-path cards (Non-Persist scope)

**Status:** CANDIDATE for TL/PO/SRE review. This is not promoted trusted KB, and does not claim Production coverage.

**Scope decision (PO, 2026-10-09):** current Async scope is **Non-Persist only**. The deployed flag and reachability of Persist paths are not independently verified. The `MessageCRUD.createAsyncActiveMessage` risk and PR #7 are retained as source findings **out of current operational scope**, conditional on future Persist use.

**Source baseline:** [critical source signatures](../../generated-knowledge/observability/source-reviewed-critical-signatures.md), [registry](../../generated-knowledge/observability/registry-v1/registry-index.md), [gap report](../../generated-knowledge/observability/observability-gap-report-v1.md), Async-Source commit `781e6c4c61706a798883818982f72fb8fa53a661`. Runtime deployment SHA UNKNOWN.

## Candidate service / flow cards

| Flow / subsystem | Source-confirmed observation | Correlation candidates | Not established / follow-up |
| --- | --- | --- | --- |
| Message Delivery | `Server.java:809` BeforeSend precedes `client.sendMessage`; `Server.java:831` AfterSend follows local call; `Server.java:786` recipient-not-registered warning is not proof of loss | messageId, trackerId, sender, receiver, serverId, ARN | Receiver ACK, retry stages, delivery guarantee, runtime reachability; [Source issue #5](https://github.com/eabbasiyan-maker/Async-Source/issues/5) |
| HTTP | `HttpHandler.java:439` ServiceTimeLog in finally; `HttpClient.java:73/80` timeout/error callbacks | lastTrackerId, uuid, business, provider, host | Exact end-to-end join, emitted status vs actual client response, Kibana mappings |
| Broker / Queue | `AsyncInternalMessageSender.java:24` logs executor active-utilization threshold, not queue depth | UNKNOWN for broker end-to-end | Broker/queue counters, saturation, DLQ/retry semantics and live evidence. Historical `EmbeddedBroker` logs cannot be mapped to this source snapshot |
| ServiceCall | `ServiceCallProxy.java:147/190` ServiceCallLog; IOException branch has synthetic 408 and duration ambiguity | service-call fields; full cross-request key UNKNOWN | Distinguish destination HTTP code from synthetic internal status; [PR #11](https://github.com/eabbasiyan-maker/Async-Source/pull/11) pending TL/QA |
| Jetty | `JettyQueueSizeLogger.java:27` labels `getQueueSize()` as threadPoolSize | node/cluster UNKNOWN | Parser/dashboard compatibility, actual pool size; [PR #8](https://github.com/eabbasiyan-maker/Async-Source/pull/8) |
| Rate Limit | `RateLimitService.java:213/217` permanent/temporary block branches (451/429 internal exception); `:229` DEBUG with nanoTime | business/provider/client join UNKNOWN | Effective logger level, mapping of exception to HTTP response, monotonic vs epoch timestamp |
| WebSocket | `WebsocketHandler.java:120/147/186` open/close/error logs; ADDRESSLOG appender ref lacks corresponding file appender in scanned config | peer/client candidates | Actual effective appender and connection lifecycle metrics |
| Swagger / Provider | `ServiceDefinitionProvider.java:153/156` invalid Swagger and failed refresh branches | provider identity candidate | Whether cached descriptor retained, effect on request routing, deployed behavior |
| POD stage monitoring | `PODLogUtil.java:52/58/64/70` stage logs conditional on ARN and logger setup | ARN, ARNStep | Emission coverage, operational enablement and index routing |
| Security logging | `ServiceCallServlet.java:82` raw management body log in baseline source | not for sensitive data | Privacy/schema review and [PR #9](https://github.com/eabbasiyan-maker/Async-Source/pull/9); no raw values in KB |

## Minimal schema for each approved service card

- Product/domain name and **exact owner** (UNKNOWN until assigned)
- In-scope Non-Persist path and supported protocols
- Source path, method, call chain, branch/feature-flag condition, source SHA
- Input, output, success/failure stage and **precise semantics** (Send != ACK)
- Correlation fields, aliases and join limits
- Log level, appender, redaction policy, effective runtime destination
- Metrics, unit, baseline, alert ownership, dashboard link
- Dependency map, incident investigation entry point, test evidence
- Verification state: SOURCE_CONFIRMED / RUNTIME_CONFIRMED / UNKNOWN
- Human approval and last validation date

## Stage 6 evidence and completion boundaries

- **Done:** reviewed current registry and critical source semantics; identified in-scope Non-Persist operational cards, known source facts and explicit UNKNOWNs; created this review candidate.
- **Not done:** all 956 call chains, production logger/index mapping, live metrics, formal owner assignment and human trust promotion.
- **Handoff:** TL validates service boundaries, precise call chains and ACK/Retry; SRE supplies deployed SHA, Kibana/Zabbix mappings and runtime stage samples; PO confirms Non-Persist scope; Security reviews sensitive fields. Promote only approved individual claims through governance.
