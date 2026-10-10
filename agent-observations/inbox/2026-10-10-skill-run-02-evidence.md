---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
verification: github-source-read
owner: REQUIRES_HUMAN_VALIDATION
---

# Run 02/06 | Phase 1 | 2026-10-10

KB main pinned to 29adc954415cbe9880769763f7f0ab839891a480. PR #16 and issue #17 reviewed.

## Source routing evidence

The exact warning "service is blocked for providerName" is present in Async-Source commit 781e6c4c61706a798883818982f72fb8fa53a661, RateLimitService.checkBlockAndWatchService, line 138. It is logged when endpointConfig.isBlock() holds, followed by decrementAndCheckUnblock() and MediationException code 429.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L130-L145

EndpointConfig: blockCount -1 or positive count can be blocked; a positive count may decrement, and expiry can clear non--1 blocks. The endpoint block path uses 429 even with blockCount -1. Provider-level block uses a different 451 path.

Source: https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L69-L87

AsyncManager is distinct. The KB contains a curated 18-file com.async snapshot at commit 82a2887c5a67a640145b4428e50a292b7a425b93. Its RateLimitManagerServlet configures rules and fans out to Async nodes; it is not the established emitter of the exact warning.

Baseline: https://github.com/eabbasiyan-maker/Acync-KB/blob/29adc954415cbe9880769763f7f0ab839891a480/source-baselines/asyncmanager/project-baseline.yaml

## Manual ChatGPT + GitHub tests

- ROUTE-03 PASS: exact warning maps to Async-Source endpoint block, not AsyncManager.
- ROUTE-04 PASS: Manager configuration/fan-out maps to distinct AsyncManager source snapshot.
- ROUTE-05 PASS: hostname and alert number cannot establish deployed producer, count or impact; return UNKNOWN.

These were direct retrieval checks, NOT an installed Skill run. Second assistant BLOCKED; live production UNKNOWN.

## Candidate proposal, human review required

Add one entry for the exact warning to the existing generated-knowledge/observability/source-reviewed-critical-signatures.md, including the endpoint guard, 429 versus 451 distinction, and pinned source links. Avoid duplicate knowledge documents. Do not alter validated claims or promote automatically.

Next: immutable source reference freshness audit. Cycle: 2/6.
