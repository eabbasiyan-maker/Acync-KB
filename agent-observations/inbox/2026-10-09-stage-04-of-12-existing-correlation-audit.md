---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
verification: github-documents-reviewed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Stage 4/12 — Existing-ID correlation audit, Non-Persist, read-only

Scope: interpret current Async logs only. No new correlation IDs, source changes, logger changes, or runtime changes.

## Existing correlation paths

- Message local send: BeforeSendLog -> client.sendMessage -> AfterSendLog. Existing identifiers: messageId, trackerId, client, with hostname as additional scope in existing diagnostic tool. AfterSend proves local method return, not ACK or delivery.
- HTTP timeout: textual HttpClient.onTimeout trackerId joins ServiceTimeLog.lastTrackerId with hostname and bounded time tolerance. ServiceTimeLog status 408 is not sufficient by itself to attribute timeout cause.
- HTTP/ServiceCall: uuid, businessId, provider are candidates for joins; propagation and uniqueness are not fully verified.
- POD: ARN and ARNStep identify optional stages when logging is enabled; absence is not evidence of missing processing.
- WebSocket: open/close/error event shapes lack a verified consistent connection join key.
- Broker: historical EmbeddedBroker class is absent from supplied source; end-to-end broker correlation UNKNOWN.

## Prior historical evidence (not rerun)

- 2026-08-18: 6,685 BeforeSend/AfterSend pairs by messageId/trackerId/client; one After-only.
- 28/28 observed textual onTimeout events matched 408 ServiceTimeLog by trackerId/lastTrackerId in historical sample; 122 other 408 events not explained by these joins.
- Existing offline diagnostic uses hostname and one-to-one pairing for 408, bounded lag; 8 synthetic unit checks previously passed.
- Historical text and structured windows differ, so do not interpret aggregate pair counts as end-to-end delivery rates.

## Mandatory analyst rules

1. Match by identifiers plus node/host and time scope, not trackerId alone.
2. Preserve event source and timestamps, avoid double-use of one log event for multiple claims.
3. Label confidence and contradictions; ambiguous joins remain UNKNOWN.
4. Distinguish send attempt, local send return, receiver ACK and business completion.
5. Do not equate synthetic ServiceCall 408 with destination HTTP status.
6. Do not copy raw identifiers, payloads or tokens into reports.
7. Source evidence, historical samples, and production runtime evidence are separate categories.

## Pending validation

TL: ID lifecycle/reuse and ACK/retry semantics. SRE: deployed version, effective logger routing, Kibana field mappings, host/cluster and timestamp correctness. QA: run representative real-Agent correlation scenarios. Until then, production end-to-end tracing is NOT VERIFIED.

References:
- generated-knowledge/observability/correlation-and-data-contract.md
- generated-knowledge/observability/source-reviewed-critical-signatures.md
- generated-knowledge/observability/historical-qa-results.md
- generated-knowledge/observability/tools/async-log-diagnose-README.md

Status: candidate audit completed from existing GitHub documentation; no fresh test run.
