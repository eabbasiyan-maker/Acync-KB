# Async Knowledge Base

Knowledge repository for the Async Knowledge Agent MVP.

## Runtime files

- `async-knowledge-catalog.yaml` — catalog of knowledge documents used by retrieval.
- `mvp/validated-claims.yaml` — machine-readable trusted claims and registered known gaps.
- `generated-knowledge/` — source-derived candidate knowledge documents.

## Trust model

- `trusted` claims are human-validated project facts.
- `known_gap` claims are explicitly registered unresolved topics and must not be filled with general model knowledge.
- documents under `generated-knowledge/` are supporting candidate context unless separately promoted.

## Workflow usage

The n8n workflow should read this repository from branch `main`, load the catalog and validated claims, select cataloged Markdown documents, perform retrieval, then build the Context Package and Readiness gate before calling the LLM.

## Retrieval rule

Do not classify every missing answer as `known_gap`. Only claims explicitly marked `status: known_gap` in `mvp/validated-claims.yaml` are official MVP known gaps.
