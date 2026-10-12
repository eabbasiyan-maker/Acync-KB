---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-indexed-and-selective-source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Candidate class dossiers — index and review status

This package contains one source-grounded dossier for each of the 401 Java files in `Async-Source@781e6c4c61706a798883818982f72fb8fa53a661`. Dossiers describe source behavior, inferred/indirect business role, error paths, and logs/RCA; they do not assert approved business policy or production behavior.

## Coverage

- Java files: **401 / 401**; declared types: **501** (some files contain nested types; six files have no executable type declaration).
- AST inventory: **4145** method/constructor declarations, **1215** explicit throw/catch evidence items, **968** log items (inventory method is documented in `java-ast-evidence.json`).
- Namespaces: product (`src/com/nozha/**`) **268**; Spring utility vendor candidates **118**; other vendor/sample/undetermined **15**.
- Every dossier has Technical, Business, Errors, and Logs/RCA sections. Status means source reviewed; it does not mean business-approved, runtime-tested, or promoted.
- Review gates: **0 business-approved, 0 application-runtime-tested, 0 promoted**.

## Navigation

- `class-coverage-matrix.csv` — exact 401-file coverage ledger, source SHA, AST counts, four dimension statuses, unknowns and dossier path.
- `class-dossiers-batch-*.md` — 22 Markdown files; each dossier has a stable source-path heading and direct internal links. The coverage matrix points to each dossier anchor.
- `flows-core.md`, `flows-http-mediation.md` — cross-class flows with source citations and explicit unknowns.
- `log-registry-reconciliation.json` — reconciliation with the historical logger registry; distinguish executable, commented and separately detected logger calls.
- `source-provenance.json`, `java-ast-evidence.json`, `source-counterexamples.json` — provenance, static inventory and isolated checks.
- `existing-document-update-record.md` records source-backed supplements applied to existing candidate docs and the Catalog. The original malformed patch was superseded; trusted status was not promoted.

## Review boundaries

Read `work-completion-contract.md` and `final-audit-delivery-summary.md` first. Treat source observations as candidate truth. For DTO/helper/vendor classes, Business describes the indirect integration role or explicit absence of a first-party business rule. Unknown owner intent, active deployed configuration, actual consumer impact and production log ingestion remain visible per dossier.
