---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
verification: source-reviewed-static-candidate
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
business_approved: false
runtime_tested: false
promoted: false
---

# TL and developer review kit

## How to use the class knowledge for a change

For each Story/Bug, start from the changed behavior and trace four hops: **entry point → decision/business rule → side effect/state → response, error and log**. Record both callers and dependencies. A class dossier is evidence about that class; the flow map is the starting point for cross-class impact. Verify the pinned source SHA matches the branch being changed before relying on line-specific conclusions.

### Impact record template

| Field | Required answer |
|---|---|
| Change | User-visible or operational behavior being changed |
| Entry points | HTTP route, WebSocket callback, broker listener, scheduler or direct caller |
| Decision owners | Classes/methods that validate, route or select policy |
| Side effects | DB/cache/queue/network write and state transition |
| Consumers/contracts | Client, peer service, persistence implementation; approved expectation and owner |
| Failure paths | Exception/status, catch/suppression, retry/recovery and partial effects |
| Observability | Exact log site, fields, guard, correlation key and what it does not prove |
| Tests | Existing test, missing case, expected state/response/log; execution result |
| Unknowns | Deployment flag/schema, owner intent or untested runtime behavior |

## Worked example: avoid silently skipping active-message persistence

**Change hypothesis:** replace the cumulative executor task counter as the admission signal for active DB writes. This is an implementation risk candidate, not a confirmed production loss.

- **Entry/decision:** `MessageCRUD.createAsyncActiveMessage` gates on `IS_INSERT_TO_DB_ENABLE`, compares `getTaskCount()` with `ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE`, then submits work. At the threshold branch it logs and returns without submitting. Source: [MessageCRUD.java:L50-L63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L50-L63).
- **Callers/effect:** the core flow reaches this facade from routing and sender paths; inspect [MessageManager](flows-core.md) and [Server message sender](flows-core.md). DB vendor implementations and feature flags affect the actual result.
- **Business rule to confirm:** is an active write best-effort, must it be durable before send, or should overload reject/block/retry? The code alone does not decide the approved contract.
- **Failure and logs:** a local method return does not prove submission or persistence. The branch log can identify rejected submission, while worker exceptions are not necessarily observed by the caller. Confirm exact registry site in the dossier before writing an alert.
- **Tests to add/run:** zero, below, at and above threshold; executor reused after completed tasks; disabled flag; worker SQL failure; assert submission count, DB state and caller-visible behavior. Current application runtime evidence is **NOT RUN**.
- **Impact set:** `MessageCRUD` → callers in `MessageManager`/`Server` → selected MySQL/Oracle implementation → message status/retry/send result. Check both relational implementations and async/non-persist paths.

## Minimum review rule

Do not approve a source-backed change proposal until its impact record identifies the exact changed methods, callers, persistence/transport effects, failure response, relevant logs and runnable tests. Mark any unapproved business rule `OWNER_DECISION_REQUIRED`; never turn a code observation into a delivery promise.

## Evidence limitation

The 401 dossiers are grouped in 22 Markdown files in PR #21. Dossier-to-dossier links and coverage-matrix references resolve to the actual PR batch files and stable anchors. `dossier-quality-gaps.csv` tracks method-detail placeholders separately.
