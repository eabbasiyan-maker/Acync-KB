---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
owner: REQUIRES_HUMAN_VALIDATION
---
# Run 03/06 — Source-reference audit

KB baseline: 29adc954415cbe9880769763f7f0ab839891a480. Source mirror baseline: 781e6c4c61706a798883818982f72fb8fa53a661.

- FAIL: HTTP mediation document has five moving-branch Source references. All five files were found in the pinned mirror commit; this does not validate every claim.
- FAIL: the older source commit 2a4986c264720f6d7dff6c176d1a896e73176583 is not resolvable in the authorized mirror. Original history unknown.
- FAIL: two legacy interface paths do not resolve in the mirror; both normalized paths do.
- PASS: official contract and breaking-change known gaps remain separate from candidate source descriptions.

Proposal: after human claim-level review, pin the mediation references; normalize mirror paths without overwriting historical provenance; never infer production behavior. No protected files changed. Skill runtime not tested. Next: Q&A on source mismatch and known gaps.
