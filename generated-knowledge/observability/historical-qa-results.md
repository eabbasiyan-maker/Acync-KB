---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: local-test-passed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
analysis_date: 2026-10-09
---

# Async — Historical Off-Line QA / Static Source Checks

**Data classification:** OLD SAMPLE ONLY. Reproducible audit of supplied archive and user-provided logs from 2026-08-18. No current-production status; no raw payload, IP, peer ID or token copied into repository.

## Automated results (re-run locally 2026-10-09)

- **17 / 17 tests PASS** on `test_observability.py` in local environment containing `Async` source, complete 956-row CSV and both old JSONL logs.
- Source code: all 956 referenced Java source files/lines exist in provided ZIP and each referenced line contains matching log method invocation; 956 unique registry IDs, 953 old points present, 18 vendored points, 12 unknown method names.
- Parsed 15,592 JSON structured logs and 17,072 textual logs (different time windows) with no JSON decoding errors.
- Structured counts: BeforeSendLog 6,685; AfterSendLog 6,686; ServiceTimeLog 2,221. Matched 6,685 Before⇆After by composite `messageId`, `trackerId`, `client`; one After-only. **Not a delivery/ACK check**.
- 150 HTTP 408 (146 near 120 sec) and 56 HTTP 500 (49 near 30 sec). **28** HttpClient onTimeout messages in textual sample; **28/28** joined to status 408 by `trackerId` ↔ **`lastTrackerId`**. Other 122 HTTP 408 remain independently unexplained.
- 100 historic ORA-00001 in addClient, 118 `invalid queue name` warnings, 48 messages mentioning Swagger (including 46 ERROR + 2 WARN), 0 DB cumulative ThreadPool threshold signature in this sample.
- Negative computed durations observed: 726 AfterSend.time and 569 ServiceTimeLog.clientTime. Not a proof of clock skew.
- **Source-version mismatch:** 4,032 textual log records have `source.class=com.nozha.async.server.activemq.classic.EmbeddedBroker`; class absent in supplied source ZIP. Those 118 invalid queue messages originate from this unresolved source family.
- SHA-256 of input files recorded in `historical-validation.json` for reproducibility, without publishing raw logs.

## Not tested / not passed

- Kibana index mappings, live logger filters, Zabbix items, host-to-cluster mapping and deployed version.
- Runtime message loss/ACK, database write outcomes, real historical incident root cause.
- The actual LLM Analyst Agent — 15 intended evaluation cases are **designed but not executed**.
- P0 code-risk reproduction in a runnable test environment and all proposed production fixes.

## Local reproduction (no network)

```bash
export ASYNC_SOURCE_DIR=/path/to/extracted/Async
export ASYNC_REGISTRY_CSV=/path/to/all-log-point-cards.csv
export ASYNC_STRUCTURED_SAMPLE=/secure/path/to/async_json.log
export ASYNC_TEXTUAL_SAMPLE=/secure/path/to/async.log
python validate_historical.py "$ASYNC_STRUCTURED_SAMPLE" "$ASYNC_TEXTUAL_SAMPLE" --output aggregate.json
python test_observability.py
```

**Privacy rule:** keep raw samples in approved private storage; only sanitized aggregates and source locations may be proposed for KB promotion.