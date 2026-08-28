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

# Human Knowledge Backlog

This document is the human-validation backlog supporting the Async knowledge base. It is not an authoritative fact source by itself.

## P0 topics already answered and promoted to validated claims

Human input used for the current MVP validates:

- Async responsibility boundary: connection and message transport, not provider/consumer Business Logic.
- Duplicate may occur in ACK/Resend scenarios.
- POD service providers/consumers may use Async as the communication path.

These are represented as `trusted` claims in `mvp/validated-claims.yaml`.

## P0 topics still unresolved

The current MVP records as `known_gap`:

- exact ACK semantics and official Retry/Resend policy/owner;
- official/stable Async contracts;
- official Breaking Change definition;
- sufficient ADR/Decision knowledge for contract-change questions.

## Additional validation backlog

Lower-priority or later-phase validation includes security/authentication/authorization rules, official delivery guarantee, operational retry/TTL/retention, routing/failover behavior, production topology mapping, environment-specific configuration, SLA/ownership and canonical terminology.

## Promotion rule

Answers gathered from humans should not silently overwrite generated documents. A reviewed answer should be converted into a machine-readable claim with:

- unique `id`;
- focused `topic`;
- retrieval `aliases`;
- `status` of `trusted` or `known_gap`;
- precise `statement`;
- evidence type/source.

This keeps human validation separate from source-derived candidate knowledge and makes Runtime Retrieval deterministic.
