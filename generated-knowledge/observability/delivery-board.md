---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: mixed-see-section-status
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Async Observability — Delivery Board, PM handoff and Definition of Done

**Managed scope:** progress from code-only log registry to evidence-grounded Log RCA Analyst. State assessed on **2026-10-09**. No asynchronous work is claimed. A task may be DONE for *artifact creation* but BLOCKED for *runtime validation*. Owners below are roles rather than assigned individuals.

## Workstreams and handoff status

| Workstream | Status | Evidence/deliverable | Next external gate | Role owner |
| --- | --- | --- | --- | --- |
| W0 — 956-point logging registry | **DONE / Candidate** | Registry CSV and gap report; PR #3 merged into main | Runtime verification for trust promotion | PO + TL |
| W1 — priority source-signature deep audit | **DONE for selected critical paths** | Critical source traces (core message, HTTP, DB, Rate Limit, WS, ServiceCall, Swagger); full 956 registry remains heuristic/UNKNOWN where not reviewed | TL sign-off on code-risk/trigger, enrich remaining items by risk | Async TL |
| W2 — cross-log correlation schema | **DESIGNED / partial test** | Correlation/data contract and historical timeout/message join tests | Verify actual Kibana field mapping and node/cluster | SRE + TL |
| W3 — historical evidence and reproducible QA | **DONE for 2026-08-18 historical sample** | Privacy-preserving validator + 17 automated source/historical checks PASS | Additional incident windows for regression; no live inference | QA + PO |
| W4 — monitoring observability gaps | **BACKLOG PREPARED** | Priority matrix, test plans and root-cause hypotheses in gap report | Engineering triage and implementation PRs | TL + SRE + Security |
| W5 — Production Kibana and Zabbix validation | **BLOCKED — EXTERNAL EVIDENCE** | Inputs/acceptance checklist available | Live mappings, deployed versions, node list, baselines, redacted correlated examples | SRE/Operations |
| W6 — Log Analyst Agent QC | **TEST SUITE DESIGNED, AGENT NOT RUN** | 15 source/evidence/safety test scenarios and suggested rubric | Agent access, eval cases, human approval | QA + PO |
| W7 — production code and dashboard fixes | **BLOCKED — OWNER APPROVAL** | Source-based investigation candidates | TL changes/tests, rollout and SRE confirmation; do not change Production without change-control | TL + SRE |

## Priority / why this order

1. **P0: investigate DB async persistence submission gate** before dashboard polish; potential impact to message persistence if path enabled. Do not claim actual loss.
2. **P1: improve end-to-end stage correlation and version parity**, because without identifying exact deployed code and join keys, an RCA may misattribute causes.
3. **P1: validate alert-worthy anomalies** (HTTP 408/500 latency, Oracle duplicates, broker and Swagger refresh) with live baselines; these historical rates are not current.
4. **P1: correct instrumentation ambiguities** (Jetty queue label, ServiceCall duration/status, sensitive request logging).
5. **P2: harden secondary channels** (`ADDRESSLOG`, RateLimit DEBUG/nanoTime, WebSocket counters, schema/masking), once critical paths are trusted.

## Definition of Done (entire project)

- [x] Source Log Registry has reconciled prior 953 and new total 956; source path+line checked against provided archive.
- [x] Source-driven semantics for priority incident signatures and distinctions between local Send, status, ACK and business outcome documented.
- [x] Historical offline smoke checks reproducible and privacy-safe; 17 tests passed.
- [x] Correlation contract, runtime evidence checklist, gap backlog and Agent QC scenarios authored.
- [ ] Deployed revision and current effective logging configuration confirmed for each target cluster.
- [ ] Required Kibana fields/joins and Zabbix item keys validated with representative data and explicit Normal vs Incident baselines.
- [ ] P0 code risk triaged by TL with test evidence, remediation acceptance and safe deployment decision.
- [ ] P1 source risks/telemetry/PII reviewed and fixed or formally accepted.
- [ ] Agent QC executed and independently approved against 15 scenarios; no critical errors or leakage.
- [ ] KB candidate claims selectively promoted to trusted by authorized Human Owner; no bulk promotion.

## Dependencies and decision rights

**Can close with sources supplied:** static inventory, source-grounded priority flow mapping, proposed correlation standard, reusable queries and offline historical validation.

**Cannot truthfully close without external action:** runtime observability, actual Production alert thresholds and code release, Incident root cause, current SLO, Agent evaluation, security review and trusted KB promotion.

**No fabricated deadline, team assignment or production sign-off.** Follow-up scope is actionable through task tracker Issues, not an assertion that work will happen unobserved in the background.