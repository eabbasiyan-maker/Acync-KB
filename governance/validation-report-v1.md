# Provenance Hardening Validation Report v1

## Scope

Validation covers the backward-compatible provenance changes on branch `fix/knowledge-provenance-hardening-v1`. Runtime execution of the reference v16 n8n workflow is outside this repository and remains pending.

## Static acceptance criteria

- YAML files parse successfully.
- Existing claim IDs and document IDs remain unique and unchanged.
- All catalog paths exist.
- All source paths added to `source_refs` exist in the supplied source snapshot.
- No existing knowledge document or claim is deleted.
- Existing claim statements, aliases and evidence objects remain unchanged.
- All four known-gap statuses remain unchanged.
- No claim with unavailable human evidence remains `trusted`.
- Catalog contains no reference to the missing `generated-knowledge/GOVERNANCE-REPORT.md`.

## Runtime limitation

The current GitHub repository does not contain the reference `Async_Knowledge_Agent_v0.16.0_RETRIEVAL_ONLY.json`. Older supplied workflows treat only exact `trusted` status as Trusted Knowledge and preserve `known_gap` behavior, so the downgrade is compatible with those consumers. Runtime PASS for v16 must still be executed in n8n before this branch is merged.

## Required runtime regression checks

1. Responsibility queries must return the claim as Candidate Knowledge, never Trusted Knowledge.
2. Duplicate/ACK queries must preserve the candidate claim and ACK/Retry known gap without turning source evidence into a production guarantee.
3. Provider/consumer queries must not emit the overgeneralized statement as trusted.
4. All four known-gap queries must remain `NOT_READY` where the gap is required.
5. Catalog loading must accept the unchanged Catalog structure and all nine existing document IDs/paths.
6. Context Package must continue separating Trusted Knowledge, Candidate Knowledge, Current Source Evidence and Known Gaps.
7. Broken evidence status must be visible through the governance artifact and must not be presented as direct technical evidence.

## Static retrieval regression matrix

The document paths, IDs, topics, aliases and claim statements used by retrieval are unchanged. The expected trust classification changed only for the three deliberately downgraded claims. Because v16 is not available in this repository, runtime selection remains `UNKNOWN` until the n8n test is executed.

| Test | Query focus | Expected after hardening | Static result | Regression status |
|---|---|---|---|---|
| RET-001 | ACK meaning / retry policy | ACK/Retry known gap; no definitive answer | PASS | No regression |
| RET-002 | resend when ACK is missing | Candidate duplicate claim + known gap | PASS | Intended trust downgrade |
| RET-003 | `MessageManager.ackMessage` | Candidate delivery/source context | PASS | No retrieval metadata change |
| RET-004 | offline persistence | Candidate delivery/runtime documents | PASS | No regression |
| RET-005 | STOMP 61613 | Insufficient validated knowledge | PASS | Existing coverage gap preserved |
| RET-006 | OpenWire redelivery | Insufficient validated knowledge | PASS | Existing coverage gap preserved |
| RET-007 | ordering guarantee | Candidate limitation; no guarantee invented | PASS | No regression |
| RET-008 | Async responsibility | Candidate claim, never Trusted Knowledge | PASS | Intended trust downgrade |
| RET-009 | all providers/consumers allowed | Candidate claim; clarification required | PASS | Intended trust downgrade |
| RET-010 | Service Call authorization boundary | Insufficient validated knowledge | PASS | Existing coverage gap preserved |
| RET-011 | Redis in production | Production state remains unknown | PASS | No regression |
| RET-012 | retry/resend owner with typo | ACK/Retry known gap if alias matching succeeds | PARTIAL | Runtime typo matching unknown |
| RET-013 | official contract / breaking change | Existing known gaps and `NOT_READY` | PASS | No regression |
| RET-014 | incident owner | Insufficient validated knowledge | PASS | Existing coverage gap preserved |

Static summary: 13 PASS, 1 PARTIAL, 0 FAIL. Runtime selection and final-output assertions remain pending for all 14 tests.
