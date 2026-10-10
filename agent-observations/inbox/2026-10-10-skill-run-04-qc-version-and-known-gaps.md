---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
owner: REQUIRES_HUMAN_VALIDATION
---
# Run 04/06 — Phase 1 — Direct GitHub Q&A

Date: 2026-10-10. Candidate; not an installed Skill test.

KB main: 29adc954415cbe9880769763f7f0ab839891a480.
Source mirror: 781e6c4c61706a798883818982f72fb8fa53a661.

## QC-VERSION-06 — WebSocket and provenance
Question: Is /ws implemented and officially enabled in production?
Expected: Separate snapshot implementation from approved contract and deployment.
Actual: EmbeddedHttpServer.configureWebSocket registers /ws in the pinned source snapshot. Interface Inventory is candidate and cites historical commit 2a4986c264720f6d7dff6c176d1a896e73176583, which returned 404 in the authorized mirror. Production enablement and official support remain UNKNOWN. Do not silently replace the historical ref.
Result: PASS for direct ChatGPT/GitHub answer; BLOCKED for retrieval of historical mirror ref.
Evidence: https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L283-L292

## QC-GAP-07 — official contracts
Question: Are source-observed APIs the official stable Async contracts?
Expected: Retrieve async-interface-inventory plus async-official-contracts-gap-01.
Actual: No. Source implementation inventory is candidate; official contract list is explicitly a known_gap in validated claims. Human contract-owner decision required.
Result: PASS for direct ChatGPT/GitHub answer.

## QC-GAP-08 — breaking changes
Question: What exactly is the official Async Breaking Change definition?
Expected: Respect async-breaking-change-gap-01, do not invent a policy.
Actual: Definition is a registered known_gap; generic software heuristics are not an Async policy.
Result: PASS for direct ChatGPT/GitHub answer.

KB evidence:
- https://github.com/eabbasiyan-maker/Acync-KB/blob/29adc954415cbe9880769763f7f0ab839891a480/mvp/validated-claims.yaml
- https://github.com/eabbasiyan-maker/Acync-KB/blob/29adc954415cbe9880769763f7f0ab839891a480/generated-knowledge/contracts/interface-inventory.md

Summary: 3/3 manual direct-GitHub Q&A PASS. Installed Skill NOT TESTED; second host BLOCKED. No claim of production verification.

Proposal: in existing candidate Skill governance/readiness reference, add SOURCE_REF_UNAVAILABLE behavior: preserve original historical commit, separately label any newer snapshot, never promote observed routes to official contracts. Human review required; no protected files changed.

Next: privacy/prompt-injection boundary QC and Phase 1 readiness review.
