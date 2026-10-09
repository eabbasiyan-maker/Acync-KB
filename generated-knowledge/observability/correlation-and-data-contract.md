---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async — Cross-Log Correlation and Telemetry Data Contract v1

**Goal:** distinguish a single log line from end-to-end incident evidence. Proposed normalized fields are suggestions, not claims of an existing unified schema. All Kibana paths, elastic mappings, network and cluster metadata MUST be verified with operations.

## Canonical analysis dimensions (proposed)

| Dimension | Expected sources / caution |
| --- | --- |
| `@timestamp`, `timezone`, `host`, `nodeId`, `cluster`, `environment`, `deployedCommit` | Outer JSON `instant` has `epochSecond/nanoOfSecond`; use parsed UTC, not UI local timezone. Node/cluster/version maps need operations confirmation. |
| `eventName`, `eventStage`, `level`, `loggerName`, `source.class`, `source.line`, `errorType` | Outer JSON vs inner JSON Object must be mapped separately. LogType exists only for certain structured objects. |
| `trackerId` / `lastTrackerId` | Before/After field is `trackerId`, whereas `ServiceTimeLog` uses **`lastTrackerId`**. Text HttpClient onTimeout mentions `trackerId`. **Normalize aliases before joining.** |
| `messageId`, `sender`, `receiver`, `client`, `messageServerId`, `serverId` | Sending stage; `messageId` is not always nonzero and is not proof of durable storage. Suppress raw identifiers outside a restricted observability environment. |
| `uuid`, `requestGuid` | HTTP and Service Call; verify scope and propagation in each route. May not be present in delivery-oriented logs. |
| `arn`, `arnstep`, `podAction` | Optional POD stages; presence depends on feature flag/context. |
| `provider`, `businessId`, `uri`, `httpStatus`, `internalStatus` | Use consistent internal-vs-destination status naming; 227 is an internal ServiceCall classification. |
| `durationMs`, `clientElapsedMs`, `queueWaitMs`, `clockSkewSuspected` | **Do not conflate durations.** Invalid negative durations must be flagged, not zeroed or averaged without policy. `RateLimitLog.time` may use nanoTime and must not be indexed as epoch. |

## Event flow / joins

### A. HTTP path

`HttpLog` (HTTP request/response) ↔ `ServiceTimeLog` (service finalization) ↔ `HttpClient.onTimeout/onError` (event listener). Prefer `uuid` where present, then `lastTrackerId`⇆`trackerId` plus restricted host/time/provider context. Join is NOT guaranteed one-to-one; concurrent requests, lost logs, retries and reused identifier semantics must be considered.

**Success boundary:** `ServiceTimeLog` means finalization reached that log branch; status=200 is not a general business-level contract. An onTimeout with a matching `lastTrackerId` and 408 provides stronger evidence than seeing 408 alone.

### B. Message delivery

`BeforeSendLog(messageId,trackerId,client)` → `client.sendMessage(...)` → `AfterSendLog(messageId,trackerId,client)`; on error, examine `ServerException/PersistanceException`, `client not registered`, pending/DB/broker logs. `AfterSendLog` proves only successful return from the local send call; **do not label it DELIVERED**. Receiver consumption/ACK require separate evidence and owner-approved semantics.

### C. Service Call

`HttpHandler/ServiceTimeLog(uuid,provider,businessId)` → `ServiceCallProxy/ServiceCallLog(uuid,businessId)` → `SCLOG` error/warnings. Split proxy response `status` from `serviceCallStatusCode`, and split synthetic 408 from destination status. Missing ServiceCallLog may reflect disabled SCJSON, logging filter or missing call path.

### D. WebSocket

`WebsocketAddressLog` on open (counts), textual `close` and `on error` / cleanup; connection ID / Peer ID / WebSocket key association may not be consistent across event shapes. Count of opens is not concurrent sessions. Pairing needs verified lifecycle IDs and node-scoped state.

### E. Rate Limit / Broker / DB

Rate Limit exception/rejection in INFO logs ↔ structured RateLimitLog DEBUG (optional) ↔ HTTP response. DB status/errors ↔ correlated message and node ID. Broker warning and queue metrics require queue identity and the exact executable version; historical `EmbeddedBroker` logs from missing source class **cannot be source-mapped** in archive.

## The three required analytical outputs

1. **Timeline:** one ordered sequence of correlated events, each with source and sampling/window limitations.
2. **Hypotheses:** up to three ranked by evidence. Every one includes supporting and contradicting evidence and a specific next check. Do not use fabricated probability percentages.
3. **Impact and uncertainty:** scope of confirmed affected requests/messages, whether any ACK/business completion was independently observed, UNKNOWN for missing data.

## Ready-to-use Kibana KQL examples (adapt index/data view names)

**Note:** Field paths below are *example mappings* for user validation; the original logs have nested `message` objects **in structured files** and a text string in the textual file. The exact field mapping in Elasticsearch is UNKNOWN.

```kql
message.logType : "ServiceTimeLog" and message.status : 408
```

```kql
message : "http request onTimeout" and loggerName : "com.nozha.async.server.client.HttpClient"
```

```kql
message : "Async DB ThreadPool task size more than threshold"
```

```kql
message.logType : ("BeforeSendLog" or "AfterSendLog")
```

**Kibana validation:** index/data view and field mapping; time-zone; dedup strategy; `source.class` and `source.line`; filters for environment/cluster/node; raw fields vs `.keyword`; retention/sampling; correct parsing of `instant`, `tstamp`, and `message` type.

## Zabbix minimum signal mapping (host & item keys must be supplied)

- CPU core usage, JVM process RSS/heap, GC pause/time and thread count.
- Jetty true queue size + utilized threads + actual pool size; do not rely on mislabelled `threadPoolSize`.
- DB connection-pool active/idle/wait/errors, DB insert error rates and persistence latency.
- Broker producer/consumer connected status, queue depth, enqueue/dequeue, reconnects, exception counts.
- HTTP Rate/Success/4xx/5xx/408, p95/p99 duration per provider and endpoint.
- WebSocket open/close/error rates and current active connections, opening-client rejected counters.
- Rate Limit 429/451 per key type, node and rule.

## Acceptance criteria for runtime phase

- Every monitored node is mapped to `(cluster, environment, app version, deployed commit)`.
- At least one anonymized request can be traced across HTTP and ServiceTime; one send across Before/After; one representative error across text + structured (if event exists).
- For a synthetic/approved test where no event is generated, report NOT_TESTED, not PASS.
- Every dashboard query includes filter, unit, time zone, aggregation, retention and expected source.
- Log origin cannot overwrite trusted attributes (e.g., forwarding headers); sensitivity/masking checks pass.