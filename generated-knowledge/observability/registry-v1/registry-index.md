---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async — Log Point Registry v1

**Purpose:** First-pass static registry of Logging call sites in Async Java source. **Trust:** candidate/untrusted, not production validated. All counters below concern code locations, not runtime log occurrences or complete operational guarantees.

## Coverage

- The source archive contains **401 Java files**. Conventional Logging call sites were found in **116 files**.
- Registry includes **956 log call sites** (953/953 from the previous audit plus 3 newly captured named-logger sites: two ServiceCallLog and one HttpLog). No previous inventory items were silently dropped.
- **18 call sites** belong to bundled `src/org/...` vendor/library source; keep separate from product-owned code in incident ownership discussions.
- A conservative method resolver leaves **12 UNKNOWN**; syntactic enclosing block contexts were detected for **749** log call sites. Full triggering call chains/feature flags are **not confirmed for 945** entries.
- The source references the snapshot `Async-Source@781e6c4c61706a798883818982f72fb8fa53a661`. The entire uploaded source archive was not byte-for-byte verified against the repository. Actual deployed version is UNKNOWN.

## Complete 956-row registry

[all-log-point-cards.csv](all-log-point-cards.csv) — full **33-column** record set for each log location, including source permalink, class, method guess or UNKNOWN, logger and configured target, level, structured/log message template, raw Java argument expressions, correlation candidates, branch context, confirmed or UNKNOWN trigger, candidate business interpretation, impact limits, RCA starting points and evidence status.

This CSV is the **complete inventory**. It can be filtered by subsystem and class, and exported into separate readable documents. It has not been imported as trusted claims.

## Entries by subsystem

| Subsystem | Number of log call sites |
| --- | ---: |
| database | 387 |
| protocol-handler | 162 |
| client | 72 |
| message-delivery | 66 |
| utilities | 64 |
| http | 47 |
| mediation | 46 |
| rate-limit | 41 |
| message-broker | 34 |
| business-service | 28 |
| coap | 3 |
| other | 3 |
| service-call | 2 |
| model | 1 |
| **Total** | **956** |

## Important use limits

- Source has a logging call ≠ this error was experienced in the historic sample ≠ current production incident.
- Logger/appender references indicate only source config, not guaranteed ingestion into Kibana/Zabbix.
- A nearby if/catch syntax context does not establish the complete conditions from all upstream call sites.
- Some Loggers are injected or external and their route is UNKNOWN. Default root output is an inference, not runtime proof.
- `AfterSendLog` is not end-to-end delivery confirmation; ACK/retry semantics require independent evidence.
- Sensitivity markers based on suspicious parameter names are review prompts, not proof of secret leakage.
- This static scan targets conventional logging calls; reflective/framework-generated logs may be missed.

## Related sources

- [Source Logging Semantics](../source-logging-semantics.md) — manually reviewed core structured log classes.
- [Historical Runtime Evidence](../historical-runtime-evidence-2026-08-18.md) — two dated log samples, **not today's state**.
- [Incident Investigation Playbooks](../incident-investigation-playbooks.md) — investigation methods, not trusted automatic instructions.
- [Observability Gap Report v1](../observability-gap-report-v1.md) — source-supported risks and unresolved verification.

## Governance

Keep candidate trust classification until human owners review specific semantics, source/production version parity, Appender/Log Level/Log Ingestion and real incident corroboration. Do not bulk-promote these 956 rows to `mvp/validated-claims.yaml`.
