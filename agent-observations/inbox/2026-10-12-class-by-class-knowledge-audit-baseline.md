---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java
evidence_refs: []
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async — Class-by-Class Knowledge Audit: Scope, Baseline, First Findings

**Status:** Candidate observation for human review; NOT promoted or merged into trusted knowledge. No runtime/build tests, production logs, deployed-commit comparison, or business-owner acceptance performed. **Audited source:** `Async-Source@781e6c4`; **KB baseline:** `Acync-KB@29adc95`, 2026-10-12.

## Audit target (confirmed by PO)

Review classes with **four coordinated lenses**, not just a Java API inventory:

1. **Technical:** ownership, entry points, methods, algorithms, dependencies, configuration, storage, queue/cache, side effects, and cross-service call path.
2. **Business:** product capability, requesting actor/consumer, business rule and preconditions, allowed/blocked states, observable outcome, and downstream impact. Do not invent business intent not established by source or approved domain evidence.
3. **Error:** validations, exceptions, status codes, propagation/mapping, catch/fallback/retry/timeout, business-visible failure, and how to reproduce/diagnose.
4. **Logs & observability:** log events/call-sites and triggering conditions, levels, correlation fields, appender/runtime uncertainties, data-sensitivity risk, and RCA usefulness; do not treat logged attempts as delivery/ACK confirmation.

For each class, the eventual knowledge record needs: repository/commit/path; package/class; role; critical methods; incoming/outgoing callers; happy and exceptional flows; business meaning; exception/status matrix; log point IDs and evidence; configuration; exact source references; source-vs-intent distinctions; unresolved questions; review owner/status. Associate classes by business flow, because a business rule or error may span several classes.

## Baseline inventory and already-existing work

- **401 Java files** in the source snapshot: **268** under `src/com/nozha/**`, **128** under `src/org/**` (candidate vendored/library territory), and **5** elsewhere. `com/nozha` does not itself prove every file is first-party; confirm ownership per class. Vendor files must not be mixed with product-owned business logic.
- Existing KB includes source-derived architecture, flows, contracts, operational/security and rate-limit candidate documents. It is **not yet an exhaustive method-by-method, business-and-error trace for each class**.
- **Reuse the existing 956-event static log point registry** in `generated-knowledge/observability/registry-v1/`, covering 116 Java files; avoid rescan duplication. Its own report marks 945 entries without confirmed full trigger chains and the deployed version UNKNOWN. These are log *call sites*, not 956 verified production events.
- KB source provenance is mixed: earlier generated documents still refer to original `2a4986c` source origin, while newer observability docs refer to `Async-Source@781e6c4`. Verify content equivalence and update per-document source refs before asserting freshness.
- A missing class-level business interpretation must be recorded as **UNKNOWN / requires business-owner validation**, not inferred from package or method names.

## Initial source-reviewed class findings

### A01 — `HttpException`

- **Technical:** checked exception with constructors (empty, message, message + status, message + cause, cause). Fields `message` and `statusCode` are plain instance fields. `getMessage()` returns the field directly, and `getStatusCode()` returns the int directly.
- **Error semantics / verified source behavior:** the no-status constructors never set `statusCode`, so `getStatusCode()` yields Java's default `0`. The two cause-based constructors do not set the local `message` field, so overriding `getMessage()` yields `null` even though the superclass has exception information.
- **Cross-class impact candidate:** `RateLimitServlet` throws `new HttpException("... is required")` in multiple validation branches, then `doProviderAction` assigns `httpStatus = httpException.getStatusCode()` and calls `resp.setStatus(httpStatus)`. Thus the *source path can attempt to send status 0 on a validation failure*. Actual Jetty response / client-observed behavior is **NOT runtime verified**, so this is a source-level defect candidate, not a confirmed production incident.
- **Business meaning:** validation failure on rate-limit management requests should produce a coherent error to the operator; the intended HTTP status contract and owner are **UNKNOWN**.
- **Logs:** `RateLimitServlet` emits a WARN including `message` and `action`; the log line alone cannot establish final HTTP response status.
- **Next validation:** unit tests of every constructor, rate-limit validation per field, resulting HTTP response with embedded Jetty and applicable management API contract.
- **Source:** [HttpException L3-L37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L3-L37); [RateLimitServlet L78-L114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L78-L114); [validation constructors L129-L187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L129-L187).

### A02 — `HttpRequestLogger`

- **Technical:** Jetty `CustomRequestLog` subclass. `log(Request,Response)` constructs an `HttpLog` using request/response metadata, and uses named Log4j logger `HTTPLOG`. On a logging exception, catches `Exception` and records an SLF4J ERROR.
- **Business/operational visibility:** reports HTTP method, path, status, byte counts and optional `business_id` attribute. This is HTTP-request-level visibility; it does **not** establish a successful downstream service invocation or business transaction.
- **Log evidence:** stores `uri_query`, full `url`, `Referer`, `User-Agent`, `X-Forwarded-For` and remote-address fields. In this method no redaction step is visible. **Risk for privacy/data leakage requires review**, not evidence of actual sensitive-data exposure.
- **Error/diagnosis:** catch logs `An exception occurred in HttpRequestLogger` but does not rethrow; a missing structured access log is therefore possible when logging fails. Actual appender and production ingestion remain UNKNOWN.
- **Important distinction:** `X-Forwarded-For` is a request header, not independently verified real client IP; use proxy trust chain for real-IP requirements.
- **Source:** [HttpRequestLogger L10-L42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L10-L42); [Jetty wiring](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L337-L346); [Source log4j config](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/resources/log4j2.xml).

### A03 — `MessageCRUD` (initial risk cross-check only; NOT full class audit)

- **Technical:** facade chooses MySQL or Oracle by `Settings.DB_VENDOR`, uses fixed executor for optional async active-message persistence.
- **Source-level candidate already covered in KB:** `createAsyncActiveMessage` checks `executorService.getTaskCount()` against `ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE`; `getTaskCount` is cumulative submitted-task count, so this is not an instantaneous queued-task limit. When above threshold the method logs an ERROR instead of submitting that DB write. Exact production config and user-visible persistence impact are UNKNOWN.
- **Avoid duplicate work:** link the already existing `generated-knowledge/observability/adr-async-db-persistence-overload.md` and associated candidate PR rather than create a second contradictory ADR.
- **Source:** [MessageCRUD L18-L70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L18-L70).

## Immediate backlog and acceptance criteria

1. **Inventory:** stable class ownership/status list of all 401 Java files, distinguishing product code vs vendored/external, and module/flow mapping.
2. **Evidence-driven class audit:** for each in-scope class, class/method coverage; 4 lenses; cross-class paths; all emitted/handled errors/logs; configuration and source links. Mechanically detected references are starting points, not automatically verified semantics.
3. **Contract reconciliation:** route + HTTP method + validation + status + response schema vs Swagger and real servlet code. Maintain a distinct source/intent/runtime column.
4. **Log reuse & verification:** join classes to existing log-point IDs, inspect call-path conditions, correlation and logging configuration, and mark production delivery UNKNOWN until verified.
5. **Business ownership:** identify which behavior is contractually intended vs code-only, and record questions for PO/TL/ops when source cannot answer.
6. **Governance:** candidates live in `agent-observations/inbox/**` and move to authoritative `knowledge/**` only via reviewed PR/promotion. Do not directly promote generated observations or mark source-level candidates as production bugs.

**Completion gate:** no claims of 100% coverage until all scoped classes and nontrivial branch/error paths have been checked; the 3 examples above do not satisfy full class coverage.
