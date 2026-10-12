---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed
truth_type: governance
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 2a4986c264720f6d7dff6c176d1a896e73176583
---

# Knowledge Gaps

This file records gaps observed during generation/review of the Async knowledge base. It is supporting governance context; the authoritative MVP machine-readable gap/trust decisions are maintained in `mvp/validated-claims.yaml`.

## Current P0 validated gaps

The current validated dataset explicitly records these unresolved topics:

- Exact ACK semantics and the official Retry/Resend policy/owner.
- Official/stable Async contracts.
- Official definition of Breaking Change for Async contracts.
- ADR/Decision knowledge related to contract changes for the current Golden Dataset.

## Important distinction

A missing answer is not automatically an official `known_gap`. A topic becomes a machine-readable Known Gap for the MVP only when it is explicitly registered as `status: known_gap` in `mvp/validated-claims.yaml`.

For example, source code contains rate-limit implementations, but the current validated claims do not register Rate Limit as an official Known Gap. If a user asks for an operational Rate Limit value and no validated answer exists, the workflow should report insufficient validated knowledge rather than falsely matching an unrelated known gap.

## Other unresolved / lower-priority areas

The broader generated knowledge identifies additional topics requiring validation, including security policy/permissions, retry/TTL/retention details, routing/failover, production topology mapping, supported environment configuration, operational SLA, canonical glossary and ownership information.

These broader gaps are not automatically P0 gating claims for the MVP unless promoted into `validated-claims.yaml`.

## Governance rule

- `trusted` claim: human-validated fact usable as authoritative project knowledge.
- `known_gap` claim: explicitly registered unresolved topic; Agent must not fill it using general knowledge.
- generated knowledge document: supporting context only unless separately promoted.

## Class audit versus official registered gaps

The 401-file class audit has completed source-backed candidate descriptions. Its unresolved business approvals, deployed schema/configuration, dependency runtime use, logger ingestion and end-to-end proof are tracked in the completion gap register. They are audit evidence gaps, not automatically official known_gap claims; validated-claims.yaml remains unchanged. Candidate defect findings likewise are not production incidents or approved architectural decisions.

Candidate evidence/navigation: [class dossiers and flow index](../../agent-observations/inbox/2026-10-12-class-audit/completion/README.md), [source provenance](../../agent-observations/inbox/2026-10-12-class-audit/completion/source-provenance.json), [log reconciliation](../../agent-observations/inbox/2026-10-12-class-audit/completion/log-registry-reconciliation.json). No human promotion is recorded by this supplement.
