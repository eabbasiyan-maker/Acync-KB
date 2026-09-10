# Async KB Provenance Hardening v1

## Status

- Knowledge base commit audited: `428cfa037b2b083f056bf2659d4430a27e4cdcbf`
- Source snapshot recorded by the knowledge documents: `2a4986c264720f6d7dff6c176d1a896e73176583`
- Source freshness: `FRESHNESS_UNKNOWN`
- Change scope: trust/provenance hardening without changing claim IDs, document IDs, catalog paths, or known-gap semantics.

This file is a governance status record. It is not human validation and does not promote any claim or document.

## Findings

### Human evidence reference

Six claims reference `arash-p0-response`. No readable artifact with that identifier or a filename variant was found in the repository or its Git history. The statements were not deleted. The three claims previously marked `trusted` were changed to `candidate` because their promotion evidence cannot be reproduced from the repository.

The four existing `known_gap` claims were preserved. A known gap records an unresolved state and must not be filled from model knowledge.

### Governance report reference

The catalog referenced `generated-knowledge/GOVERNANCE-REPORT.md`, but that file was never committed to this repository's Git history. A report with that name exists in an older supplied workspace snapshot, but it was not restored because it describes an earlier artifact set and must not be treated as a current per-document decision.

Catalog references now point to the evidence already present in each candidate document and to this status record for the unresolved promotion evidence.

### Source evidence

Structured `source_refs` lists were added to candidate documents only where the referenced files were read in the supplied source snapshot at the recorded commit. These references establish implementation evidence at that snapshot; they do not establish current production configuration, operational policy, or source freshness.

Documents that summarize governance/human gaps retain an empty `source_refs` list because source code cannot prove the missing human decision.

## Claim disposition

| Claim ID | Previous status | Current status | Reason |
|---|---|---|---|
| `async-responsibility-01` | trusted | candidate | Human promotion evidence unavailable; source cannot prove the organizational boundary |
| `async-duplicate-01` | trusted | candidate | Human promotion evidence unavailable; source supports a possible ACK/retry path but not the complete runtime claim |
| `async-consumers-providers-01` | trusted | candidate | Human promotion evidence unavailable and the word "all" is broader than source evidence |
| `async-ack-retry-gap-01` | known_gap | known_gap | Preserved |
| `async-official-contracts-gap-01` | known_gap | known_gap | Preserved |
| `async-breaking-change-gap-01` | known_gap | known_gap | Preserved |
| `async-contract-decision-gap-01` | known_gap | known_gap | Preserved |

## Compatibility

- Existing `claim.id`, `document.id`, catalog paths, claim statements, aliases, evidence objects, and known-gap statuses are unchanged.
- The existing status value `candidate`, documented by the MVP design and handled as non-trusted by the existing workflow logic, is used for downgrade.
- No new field was added to `mvp/validated-claims.yaml` or `async-knowledge-catalog.yaml`.
- Workflows that filter exact `status === 'trusted'` no longer place the three affected claims in Trusted Knowledge. Workflows that filter `status === 'known_gap'` behave as before.

## Promotion gate

A candidate claim may return to `trusted` only after a readable human evidence artifact is committed or linked through a stable, auditable reference that includes the validator, role, date, exact answer, approved scope, and review decision.
