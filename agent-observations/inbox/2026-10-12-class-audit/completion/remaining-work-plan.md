---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-and-delivery-status-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
business_approved: false
runtime_tested: false
promoted: false
---

# Remaining-work plan and Definition of Done

This plan separates source-review work from approvals and runtime evidence that require people or infrastructure. “Done” means the evidence below is attached; a status label alone is not a completion claim.

## W2 — Dossier method summaries

**Scope:** 159 method-inventory entries in 41 class dossiers were initially generic.

**DoD:** every nontrivial method states its actual purpose and important branch/side effect/failure behavior from the pinned source; trivial/empty/abstract methods are labeled accurately; exact source lines are linked; inference from callers is labeled; no template phrase remains in the method inventory; the gap register count is zero only after the corresponding dossier is source-checked.

**Execution now:** All 159 generic method-inventory entries have now been replaced with source-specific descriptions, including branch, effect or error behavior where relevant. Static consistency checks pass. The dossiers still require technical-owner review; this is not runtime or business approval.

## W3 — Story/Bug impact analysis

**Scope:** produce an impact record for each incoming change; a speculative “complete dynamic graph” is not a valid goal from static text alone.

**DoD for each change:** pin changed behavior and source baseline; name entry point, affected methods, static callers/dependencies, persistence/transport side effects, API/consumer contract, error path, relevant logs and tests with source references; distinguish static references from confirmed runtime paths; mark unapproved intent, flags, schema/version differences and untested behavior UNKNOWN; allow TL to trace from entry point to observable outcome without guessing.

**Execution now:** the existing template and `MessageCRUD` persistence example satisfy a pilot example, not every feature path. Apply the DoD to actual Stories/Bugs; expand a broader map when change scope is known.

## W4 — Business decisions

**Scope:** 11 entries in `business-decision-register.csv`.

**DoD per decision:** accountable owner is named; their decision is recorded in their own words; scope and exceptions are explicit; acceptance evidence/test is linked; effective version/date and any superseded decision are recorded; relevant knowledge is updated by an authorized reviewer. Source observation alone never satisfies this DoD.

**Execution now:** questions, proposed owner roles and evidence requests are prepared. All 11 now include a proposed baseline for owner review; none is approved because no accountable owner decision was supplied in this task. Their register status is `PROPOSAL_FOR_OWNER_REVIEW`.

## W5 — Runtime validation

**Scope:** 14 scenarios in `validation-matrix.csv`.

**DoD per scenario:** run against a recorded build/source SHA and environment; capture setup/input and expected result; attach actual status/state/log/output; mark pass/fail; link issues for failures; record rerun after fixes. Test design or static reasoning is not a run.

**Execution now:** test cases and expected evidence are prepared. All remain `NOT_RUN`; this workspace has no verified Async integration stack or owner-provided test configuration. Do not claim product/runtime pass.

## Closure rule

The package is **ready for human review**, not complete operational knowledge. Close W2 before claiming uniform method-level coverage. W3 is performed against real change scope. W4 and W5 require owner decisions and test infrastructure respectively. W2/W3 source-review work can continue without an agent.
