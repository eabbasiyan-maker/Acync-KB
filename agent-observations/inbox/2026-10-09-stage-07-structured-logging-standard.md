---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-plus-proposal
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Stage 7/27 — Proposed Logging & Structured Log Standard for Async (Non-Persist)

**Status: SUPERSEDED AS IMPLEMENTATION PLAN; READ-ONLY INTERPRETATION SCOPE ACTIVE.** This is a proposed contract, **not** a claim that current Async logs already comply. Deployed revision, Kibana field mapping, logger levels and actual ingestion are UNKNOWN. Current product scope is **Non-Persist only** (PO decision 2026-10-09; deployment configuration not independently verified).

## 1. Evidence from source (existing behavior)

- Nine observed structured types: `HttpLog`, `ServiceTimeLog`, `BeforeSendLog`, `AfterSendLog`, `PODMonitoringLog`, `ServiceCallLog`, `RateLimitLog`, `WebsocketAddressLog`, `OpenClientAddressLog`. [Source knowledge](../../generated-knowledge/observability/source-logging-semantics.md).
- Source `resources/log4j2.xml` declares `DG2`, `JSONLOG`, `HTTPLOG`, `PODLOG`, `SCJSONLOG`, `SCLOG` appenders; `ADDRESSLOG` reference lacks a same-named file appender in scanned source config. Effective runtime config UNKNOWN.
- `BeforeSendLog` precedes `client.sendMessage`; `AfterSendLog` follows local return, **not receiver ACK/delivery**. `BeforeSendLog.retryCount` is populated from message version in reviewed branch; do not relabel as verified retry attempts.
- `ServiceTimeLog` uses `lastTrackerId`; Before/After use `trackerId`. `ServiceCallLog` distinguishes proxy response status from internal classification (227); synthetic 408 is not proven destination status.
- `RateLimitLog.time=System.nanoTime()` in DEBUG branch: **not epoch time**. Jetty `threadPoolSize` log label currently contains `getQueueSize()`. Raw management request body logging appears in `ServiceCallServlet` source.
- [Correlation/data contract](../../generated-knowledge/observability/correlation-and-data-contract.md) is an earlier **proposal**, not a production schema.

## 2. Proposed canonical event contract (v0.1)

Each emitted event SHOULD be **one parseable JSON object per line** with stable field names and types. Fields marked Required apply to *new/modified standardized events*; legacy event adapters may fill `null` with explicit missing-reason and must not fabricate identifiers.

| Field | Type | Rule |
| --- | --- | --- |
| `schemaVersion` | string | Required, e.g. `async.observability/1.0`; breaking changes require version bump |
| `timestamp` | UTC ISO-8601 string | Required wall-clock event time; preserve timezone in parser |
| `level` | enum | Required: DEBUG / INFO / WARN / ERROR |
| `eventName` | stable string | Required; avoid parsing human prose as event identity |
| `eventStage` | enum/string | Required for stage events; controlled vocabulary below |
| `component` | string | Required subsystem/owner boundary |
| `environment`, `cluster`, `nodeId`, `deployedCommit` | strings | Desired trusted deployment metadata; UNKNOWN until SRE verifies; do not trust user-supplied headers |
| `traceId`, `requestId`, `trackerId`, `messageId` | strings | Optional scoped identifiers; exact generation/propagation contract deferred to Stage 8 |
| `businessId`, `provider` | strings | Optional sanitized dimensions; cardinality review required |
| `outcome` | enum | `ATTEMPTED`, `LOCAL_SUCCESS`, `ACK_CONFIRMED`, `FAILED`, `TIMEOUT`, `REJECTED`, `UNKNOWN`; `ACK_CONFIRMED` only with independent ACK evidence |
| `httpStatus`, `internalStatus`, `syntheticStatus` | integer/null | Never conflate destination status, internal mapping and generated fallback status |
| `durationMs`, `queueWaitMs` | number/null | Nonnegative when valid; invalid/unknown separately flagged; `nanoTime` only for elapsed deltas |
| `errorType`, `errorCode` | bounded strings | No raw exception message containing secrets |
| `sourceClass`, `sourceMethod` | strings | Optional for source traceability; avoid high-cardinality labels in metrics |
| `dataQuality` | enum | `VERIFIED`, `INFERRED`, `UNKNOWN`, `INVALID`; analysis metadata rather than invented runtime value |

**Timestamp rule:** never map `System.nanoTime()` to epoch; use UTC timestamp and monotonic clock *differences* for durations. Preserve original event time and ingestion time separately. Treat negative durations as invalid, not automatically zero.

**Legacy compatibility:** parse outer Log4j JSON envelope and inner structured `message` object separately; normalize `lastTrackerId` and `trackerId` only with provenance and scope. Keep old field names for a transition period and verify actual Elastic index mappings before cutover.

## 3. Stage names and event meaning (proposed)

- `HTTP_RECEIVED`, `HTTP_FINISHED`, `HTTP_TIMEOUT`, `HTTP_ERROR`
- `MESSAGE_SEND_ATTEMPT`, `MESSAGE_LOCAL_SEND_RETURNED`, `MESSAGE_SEND_FAILED`, `MESSAGE_ACK_OBSERVED` (only after explicit ACK contract), `MESSAGE_RETRY_SCHEDULED` (only with source evidence)
- `BROKER_ENQUEUE_ATTEMPT`, `BROKER_ENQUEUE_CONFIRMED`, `BROKER_CONSUME_OBSERVED`, `BROKER_ERROR` (only if instrumentation actually implemented)
- `SERVICE_CALL_STARTED`, `SERVICE_CALL_RESPONSE`, `SERVICE_CALL_TIMEOUT`, `SERVICE_CALL_ERROR`
- `WS_OPEN_OBSERVED`, `WS_CLOSE_OBSERVED`, `WS_ERROR`
- `RATE_LIMIT_REJECTED`, `PROVIDER_CONTRACT_REFRESH_FAILED`

These names are **future contract suggestions**; they are not proof that these events currently exist.

## 4. Severity and cardinality

- **ERROR:** failed operation requiring investigation; log once at the owning boundary, with bounded error code and trace context.
- **WARN:** degraded/recovered, repeated timeouts, near-saturation; do not treat all WARNs as customer-visible failures.
- **INFO:** lifecycle and outcome stage events, subject to traffic/cost and sampling policy; do not sample away failure evidence.
- **DEBUG:** diagnostic detail only, controlled by temporary settings and redaction. Essential counters/alerts must not depend on DEBUG logs.
- Avoid message bodies, raw URI query strings, arbitrary headers and full exception text in searchable dimensions. Set retention, sampling, maximum payload length and cardinality budgets with SRE/Security; numeric values UNKNOWN pending runtime baselines.

## 5. Privacy and trust boundaries

- **Never log** passwords, tokens, authorization headers, cookies, raw message content, raw management request bodies or unredacted PII.
- Use allow-listed metadata; hash/pseudonymize identifiers only under an approved reversible/irreversible policy, with access controls and retention.
- Client-supplied `X-Forwarded-For` is not authoritative `clientIp` unless trusted proxy chain is validated.
- Sanitize exceptions; prevent CR/LF injection and arbitrary structured field overrides by untrusted input.
- Cluster/node/deployment metadata must come from trusted configuration, not request payloads.
- [PR #9](https://github.com/eabbasiyan-maker/Async-Source/pull/9) addresses only part of the sensitive logging problem; Security review remains required.

## 6. Existing source gaps mapped to change gates

| Gap | Existing issue / PR | Required gate |
| --- | --- | --- |
| Send vs ACK, retry correlation | [Issue #5](https://github.com/eabbasiyan-maker/Async-Source/issues/5) | TL + QA validate stage semantics |
| Jetty queue label wrong | [PR #8](https://github.com/eabbasiyan-maker/Async-Source/pull/8) | TL + SRE parser/dashboard compatibility |
| Raw management request logging | [PR #9](https://github.com/eabbasiyan-maker/Async-Source/pull/9) | Security + QA redaction regression |
| ServiceCall elapsed time / synthetic 408 | [PR #11](https://github.com/eabbasiyan-maker/Async-Source/pull/11) | TL + QA exception-path regression |
| RateLimit DEBUG/nanoTime, ADDRESSLOG | [Issue #6](https://github.com/eabbasiyan-maker/Async-Source/issues/6) | TL + SRE effective logger/appender review |
| Runtime log routing, version, index mapping | [KB Issue #5](https://github.com/eabbasiyan-maker/Acync-KB/issues/5) | SRE runtime evidence |
| Persist-path cumulative task count | [PR #7](https://github.com/eabbasiyan-maker/Async-Source/pull/7) | Out of current Non-Persist operational scope; do not promote to operational P0 without path activation evidence |

## 7. Acceptance tests before adoption

1. **Schema:** valid JSON, stable types, version, required fields, null/UNKNOWN treatment, no ambiguous duplicate keys.
2. **Lifecycle:** one controlled Non-Persist message shows attempt and local-return; ACK only when independently evidenced; failure path is distinguishable from missing log.
3. **Correlation:** HTTP/ServiceTime and Message Before/After join with node, time-window and identifier scope; no false joins for reused trackerId.
4. **Status/clock:** ServiceCall synthetic vs destination status distinguished; `durationMs` valid or INVALID; nanoTime not parsed as epoch.
5. **Privacy:** secrets, raw body, auth header, line-break injection, user-supplied forged metadata rejected/redacted.
6. **Pipeline:** source event -> effective Log4j -> shipper -> Elasticsearch/Kibana fields; check index, retention, sampling and failure alerts.
7. **Compatibility:** legacy and new log formats can coexist without breaking Kibana/alert queries; rollback procedure agreed.
8. **Owner signoff:** TL/QA/SRE/Security approve schema, tests, rollout and privacy; no Production/Agent PASS before actual runs.

## Stage completion boundary

**Delivered:** source-grounded proposed standard and migration/test gates in the agent-observation inbox. **Not delivered:** code implementation, effective runtime configuration, Kibana validation, acceptance-test execution or human approval. Promote only reviewed claims through human-governed KB workflow.
