# Existing KB document update record

The draft `proposed-existing-docs.patch` was malformed and did not apply. Its candidate additions were reviewed and applied individually to the existing documents in Draft PR #21 branch `audit/class-by-class-baseline-20261012`; no trusted claim was promoted. The catalog’s nine dangling `GOVERNANCE-REPORT.md` evidence references were replaced with an explicit note that human promotion decisions are not recorded there and `mvp/validated-claims.yaml` governs official trust/gaps.

Updated existing documents: overview; system architecture; HTTP mediation boundary; startup flow; message delivery flow; interface inventory; security implementation; runtime/integrations; source logging semantics; logger registry index; knowledge gaps; and `async-knowledge-catalog.yaml`.

All candidate source observations remain `untrusted-content` and require owner review. `mvp/validated-claims.yaml` was not changed.
