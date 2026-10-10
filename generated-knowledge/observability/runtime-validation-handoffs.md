---
doc_class: procedure
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: not-run-in-production
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Async Observability — Runtime validation checklist and team handoffs

**State / scope (2026-10-10):** This checklist is an OPTIONAL handoff for validating claims about deployed runtime and production incidents, NOT a prerequisite for GitHub KB retrieval or evidence-based analysis in ChatGPT/Analyst Agent. Direct Kibana/Zabbix connectivity is not required: operators may provide sanitized, attributable evidence. Without it, runtime conclusions remain UNKNOWN. No production remediation has been executed. Current PO scope is Non-Persist; Persist findings remain conditional backlog.

## Work package R1 — Production logging inventory / SRE / Operations

**Inputs:** approved environment list (prod/stage/sandbox), cluster → node → hostname map, deployed versions/commit and effective `log4j2` per node, log retention/index/data view by Logger, pipeline transforms, sampling/filtering, time-zone policy, access constraints. Supply field-level schema/mapping not raw tokens.

**Tests:** for `DG2/JSONLOG/HTTPLOG/PODLOG/SCJSONLOG/SCLOG/ADDRESSLOG`, check effective configured appender, threshold and ingestion. Confirm that absent structured class in two old files is **not** equated with disabled logging. Verify ADDRESSLOG behavior in runtime. Verify that 4,032 historic EmbeddedBroker events originated from a version absent in provided source, and acquire dated deployed artifact.

**Acceptance:** each logger has outcome `OBSERVABLE`, `DISABLED_BY_CONFIG`, `NOT_DEPLOYED`, or `UNKNOWN`, with environment, source proof, test/query and date.

## Work package R2 — Kibana saved queries / SRE / Operations

**Inputs:** one anonymized sample each from HTTP status 200, 408, 500; message before/after; a DB error; RateLimit rejection; when available WebSocket/ServiceCall. Provide query and time range not the raw PII. User-approved synthetic test may substitute if that route never triggers.

**Tests:** verify outer `instant` as UTC, `message` object/string mapping, `trackerId`⇆`lastTrackerId`, UUID/ARN conventions, node/host. Alert filters must not rely on misnamed threadPoolSize or naive RateLimit nanoTime time.

**Acceptance:** correlation on shared request ID with a documented mismatch/error case, sampling assumptions, source/destination boundaries and a query reproducible by TL/SRE.

## Work package R3 — Zabbix signal baselines / Operations

**Inputs:** host/item names and item keys, aggregation and collection cadence, thresholds, 7-day normal baseline by node/provider/time-of-day, incident windows and release timeline. Required signals: Jetty queue/utilization, CPU/heap/GC, DB pool and write time, broker queue/reconnect, HTTP rate/status/latency, WebSocket, Rate Limit.

**Acceptance:** an approved dashboard/metric dictionary: signal, unit, meaning, query, source and interpretation limits; at least one side-by-side normal vs abnormal period.

## Work package R4 — Code/TL confirmations (without production changes)

- P0: reproduce `MessageCRUD.getTaskCount` threshold with >500 cumulative tasks, while `IS_INSERT_TO_DB_ENABLE` is true; show what happens to DB save and recovery.
- P1: confirm true Jetty Queue Size vs Thread Pool Size.
- P1: test ServiceCall IOException latency/status field behavior and whether actual HTTP output/status matches structured log.
- P1: confirm official ACK/Retry/Resend semantics per transport, with user-visible/biz impact.
- P1: inspect mask/schema for ServiceCallServlet raw Body, ServiceTime messagePreview and exceptions.
- P2: inspect RateLimit DEBUG reachability, nanoTime indexing; ADDRESSLOG config and overrides.

**Acceptance:** per claim assign `confirmed-source`, `reproduced-in-test`, `observed-in-prod`, `refuted`, or `unknown`; attach sanitized evidence and owners' sign-off. Do not modify `validated-claims.yaml` until reviewed.

## Work package R5 — Agent QC / PO + QA

Use saved anonymized incidents + approved synthetic cases; run at least 10 scenarios. Score against immutable Ground Truth:

- Accurate Source anchor and event scope.
- Distinguishes attempted send from delivered/ACK.
- Recognizes join alias `lastTrackerId`⇆`trackerId` and same timestamp window.
- Correctly marks missing/mismatched source version as UNKNOWN.
- Does not invent Zabbix/Kibana metric names, alert values or production incident occurrence.
- Does not claim a missing log means a feature/incident never occurred.
- Does not echo sensitive raw identifiers/headers into KB.
- Produces next discriminating checks and verification after fix.

**Exit gate:** no critical hallucinations or private-data echoes, ≥90% factual/traceability checks across approved test set, 100% UNKNOWN when a required signal is absent. Thresholds are **proposed acceptance** and require PO/QA approval; no QC runtime execution or pass is claimed for an unconnected Agent.

## Reporting rhythm / owners

- PO/Product owner: priorities, risk acceptance, scope and final promotion decision.
- TL/Async developer: source semantics, reproducible defects, proposed code changes, tests.
- SRE/Operations: live telemetry, deployment SHA, Kibana/Zabbix, baselines, alert coverage.
- QA: scenario fixtures, traceability and objective PASS/FAIL/HITL.
- Security: logging field allowlist, masking and trusted origin.

No real person is assigned by default; role ownership is a proposal pending team agreement.