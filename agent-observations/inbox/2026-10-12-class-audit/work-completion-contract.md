---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: user-requirement-and-git-baseline
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Work execution contract — Complete Async KB, every Java class, four knowledge lenses

## Scope and source of truth

- Target **all 401 Java files** in `eabbasiyan-maker/Async-Source`, pinned commit `781e6c4c61706a798883818982f72fb8fa53a661`. Re-verify latest branch and selected deployed SHA before treating the snapshot as current production code.
- Target knowledge repository `eabbasiyan-maker/Acync-KB`. **Reuse**, cross-check and reconcile existing 25 candidate KB Markdown documents, `mvp/validated-claims.yaml`, and 956 existing log-point registry, rather than duplicating or assuming correctness.
- Existing draft [PR #21](https://github.com/eabbasiyan-maker/Acync-KB/pull/21) provides indexed source locations, candidate findings and gap inventory. It is evidence scaffolding, **not** completed knowledge.
- Separate 268 product-namespace Java files from 128 candidate bundled vendor files and 5 ownership-undetermined Java files. For vendor code, document role and product impact as an integration dependency, not fabricated Async-owned business rules. Curated AsyncManager baseline is only 18 files and must not be represented as full AsyncManager coverage.
- Follow Enterprise Agent Knowledge Architecture v1.5: enforce evidence-derived truth, read-only candidate inspection until PR/human-review promotion, source refs, trust distinction, preservation of intentional/operational conflicts, and no direct trusted-KB promotion.

## Mandatory four-lens specification, **for each and every Java file/class**

1. **Technical knowledge:** package, class/interface/type, owner guess + evidence, responsibilities, method-by-method significant behavior with source line citations, inputs/output/side effects, upstream callers/downstream dependencies, data model, state changes, DB/cache/queue/network, configuration flags and concurrency/timeouts.
2. **Business knowledge:** product capability/use case, triggering actor, business preconditions, rules, accepted/rejected cases, actual effect on user/consumer, SLA or contract implications if proven, links to business flows and owner decision. If the file is a DTO/helper/vendor class, explain its **indirect role** without inventing a standalone business policy. Separate `SOURCE_OBSERVED`, `APPROVED_INTENT`, `INFERENCE`, `UNKNOWN`.
3. **Error knowledge:** input validation; exact exceptions (class, message/code, throw and catch location); failure/timeout/retry/recovery branches; propagated versus suppressed errors; internal vs HTTP/business status mapping; potential business-visible impact; test/reproduction ideas. Do not assert that an observed source risk happened in prod without runtime proof. Explicitly say 'no direct error path in class' if none, and follow callers.
4. **Logging & RCA knowledge:** every owned log call site, severity/template/structured fields, code guard and triggering branch, correlation and privacy fields, exception logging, configured appender if source-evidenced, what log definitively proves/does not prove, gap in visibility, reproducible search/triage steps. Reconcile each class with previous 956 registry and report discrepancies. If no log, say **NO_LOG_IN_CLASS** and list observability via callers if evidenced.

## Quality acceptance / DoD

- A **class coverage matrix for all 401 Java files** with file path, code SHA, class evidence link, technical/business/error/log presence and quality, unknowns, review status; no rows skipped.
- A separate **cross-class business-flow map**, tracing Request → Handler → Service → Persistence/Queue → Response, including rate limit, service call, identity/registration, delivery & ACK/Retry, non-persist, errors and log correlation. At minimum, document each runnable feature and contracts evidenced by code.
- No decorative boilerplate: write specific behaviors and concrete source citations; 'UNKNOWN' cannot be counted as completed business or runtime validation. Quality-gate for missing sections, template-only text, or unsupported claims.
- At least a **static code-path review** for all first-party classes, prioritizing security/data loss/request routing; run feasible unit/sandbox integration tests where accessible, and clearly label environment unavailable otherwise.
- Create **draft PR(s)** with proposed docs and coverage tracker; respect governance requiring owner/TL review before promoted/trusted claims or merge to main.
- Final Persian report: exact coverage counts by status (**indexed**, **source-verified**, **business-approved**, **runtime-tested**, **promoted**) and by four dimensions, validated findings and risk rankings, remaining evidence gaps, links to precise Git commits/PRs, test outcomes and honest limits. Do NOT claim 100% complete until criteria truly met.

## Priority red flags to investigate, not prejudge production

- `ServiceCallProxy` permissive TLS hostname/certificate verification.
- `HttpException` no-status constructors and `RateLimitServlet` error mapping.
- `MessageCRUD.createAsyncActiveMessage` cumulative `getTaskCount` condition.
- `ServiceCallServlet` and `RateLimitServlet` request body logs; full URL/query logging; message preview.
- `AfterSendLog` vs ACK; actual official retry and resend semantics.
- Service Call synthetic 408/internal 227, duration and downstream vs response status; HealthCheck vs readiness; `RateLimitLog` nanoTime.

**Non-negotiable:** existence of a 4-section document is **not** equal to having validated four kinds of knowledge. Make each claim traceable or label evidence gap.
