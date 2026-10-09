---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: scope-decision-and-existing-evidence
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Async Observability — Revised roadmap: 12 stages (replaces 27-stage execution plan)

**PO scope, 2026-10-09:** Non-Persist only; read-only source, existing KB, existing logs and available Kibana/Zabbix evidence. Goal: an evidence-grounded Async Log RCA Analyst and usable incident playbooks. **No changes to Async code, existing log structure, event emission, runtime configuration, dashboards/alerts, no new source PRs, no merges or deployments.** Source defects and observability gaps may be documented as future backlog, not implemented in this phase.

This is a *proposed replacement roadmap* for PO approval; prior 27-stage artifacts remain historical, not deleted. Existing GitHub issues/PRs are preserved and not automatically closed.

## Revised 12 stages and mapping to previous 27

| New | Deliverable | Old stages | State |
| --- | --- | --- | --- |
| 1 | Inventory source/KB/logs, environment limitations and existing GitHub work | 1, 3, 5 | Initial audit done; runtime parity UNKNOWN |
| 2 | Define Non-Persist scope, critical service/flow inventory, owners and boundaries | 2, 6 | Candidate cards written; TL approval pending |
| 3 | Audit existing log types, meanings, coverage, masking and missing evidence **without modifying them** | 4, 7, 9 | Source-based interpretation guide written; runtime validation pending |
| 4 | Map existing IDs and correlation across HTTP, message, broker and ServiceCall; state join limits | 8 | Designed partially; validate with samples |
| 5 | Build evidence map: source call chain -> log signature -> likely operational meaning -> counterevidence | 10, 11, 12 | Partial source traces; UNKNOWN gaps remain |
| 6 | Collect sanitized real/historical samples and verify deployed revision, Kibana fields and Zabbix baseline **read-only** | 13, 14, 21, 22 | Blocked on SRE evidence; no dashboard/alert creation |
| 7 | Write RCA decision paths and incident playbooks (Non-Persist send/ACK, timeout, ServiceCall, broker, WS, RateLimit) | 15, 24 | Existing playbooks are candidates; refine |
| 8 | Build/validate offline, privacy-safe log analysis and join tools on provided samples | 16, 17 | Prior 17/17 historical/source and 8/8 synthetic checks PASS; expanded validation pending |
| 9 | Define and execute Agent QC scenarios for evidence, false joins, UNKNOWN, privacy, prompt injection | 17, 25 | 15 cases designed; real Agent not run |
| 10 | Fix Analyst Agent prompts, retrieval and **candidate KB content only**, using human-governed promotion | 23, 24 | Pending QC findings |
| 11 | Conduct integrated read-only evaluation with realistic incident examples and human TL/QA/SRE/PO review | 19, 21, 22, 25, 26 | Pending real evidence and owner review |
| 12 | Publish evidence-linked completion report, limitations, handoff and future engineering backlog | 27 | Pending |

## Removed from current execution scope

- Old **7** new Structured Logging schema and format change; replaced by read-only log interpretation in stage 3.
- Old **8** new Correlation ID instrumentation; replaced by existing-field correlation in stage 4.
- Old **9** Error Handling code changes; replaced by observation of existing errors.
- Old **10** Queue/Worker/Thread code modifications; read-only saturation analysis retained.
- Old **11–12** new metrics/health checks; reading existing signals retained.
- Old **13–14** creation/changes to dashboards/alerts; read-only inspection retained.
- Old **18** implementation PRs, old **19** approvals for code change, old **20** deployment; **removed** from this phase.
- Old **23** source code fixes; only Agent/KB improvements permitted within existing governance.
- Persist path issue #1 and PR #7: historical source risk / future scope, not operational P0 under PO's Non-Persist-only statement; actual deployment flag still UNKNOWN.

## Completion criteria for this phase

1. Each critical Non-Persist path has source-backed event meanings and a clearly marked UNKNOWN list.
2. Agent can build trace timelines using only actual identifiers, time windows and host/cluster constraints, without inventing ACK or successful delivery.
3. Evidence provenance is explicit: SOURCE / HISTORICAL / LIVE / UNKNOWN; no historical samples presented as current.
4. Representative normal/failure cases and 15 Agent QC cases have recorded results, not merely test designs; critical privacy/hallucination cases PASS.
5. No sensitive raw payload is copied into candidate KB, reports or Agent output.
6. Owner-reviewed limitations and future engineering backlog are recorded. If SRE cannot supply live mappings, close only the **offline-evaluated scope**, explicitly leaving live validation BLOCKED rather than falsely marking production readiness.

**Progress note:** Old stages 1–7 produced partial/candidate artifacts, not proof that the new 12 stages or entire project are complete. Stage 8 of the old plan is not to be executed as an implementation activity.
