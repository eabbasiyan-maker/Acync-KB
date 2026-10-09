# Async Observability — Safe Sample Log Diagnostics v2

**Status:** Candidate tool for source/historical evidence review, not production-validated, not a log shipper or incident triage authority. Reads only local files. Standard-library Python 3.9+.

## What it does

- Reads one `async_json` and one `async` JSONL log file with Log4j event envelopes (`instant`, `message`, `hostname`, `source`, ...).
- Counts known structured log types, log levels, HTTP statuses, negative duration fields, and a small set of fixed diagnostic signatures.
- Correlates `BeforeSendLog` and `AfterSendLog` by scoped key `(hostname, messageId, trackerId, client)` as **send attempts, not ACK**.
- Correlates textual `http request onTimeout` to structured `ServiceTimeLog(status=408)` by `(hostname, trackerId/lastTrackerId)` plus a time tolerance, pairing each 408 event at most once.
- Reports both sample start/end UTC and whether their time ranges overlap. The `SOURCE/DEPLOYED_COMMIT` and real Kibana/Zabbix configurations are **UNKNOWN**.
- Emits **only aggregate counts and SHA-256 input hashes**, no raw messages, addresses, identifiers, or payloads. Raw files are **not** stored in the repository.

## Run

```bash
python3 async_log_diagnose.py /secure/path/async_json.log /secure/path/async.log --output ./aggregate.json
python3 -m unittest -v test_async_log_diagnose.py
```

`--max-join-lag-sec 120` is the default join tolerance and may be changed. Both files can be samples or entire windows, but the output cannot establish representativeness or production failure rates.

## Historical qualification

This tool was tested with the user-provided 2026-08-18 files, which have unequal windows (~20 min and ~6 min). Observed sample totals: 15,592 structured; 17,072 textual; 6,685 send-call pairs; 28 timeout-to-408 links; 100 Oracle `addClient` ORA-00001; 118 invalid queue name; 48 Swagger-related text lines; 4,032 EmbeddedBroker class lines (source class not in provided source). None of these totals prove current incidents.

## Limits and safety

- This is not a general Kibana/Zabbix connector, logging agent or automated fault repair.
- Entire `message`, `thrown` or `messagePreview` values are never written to outputs, not even in examples. Source log lines and unusual logType strings are not passed through.
- `sha256` is an input fingerprint; avoid treating it as proof of completeness or originality.
- Invalid JSON causes an exception containing only the failing line number; no raw input is echoed.
- Pairing Before/After does not verify temporal ordering or delivery/ACK, and `ServiceTimeLog(status=408)` can reflect more than one timeout cause.
- For Production use, SRE/QA must review sensitive-data handling in infrastructure (file permissions, output retention), effective logger configs, timezone/clock source and field mapping.
- No tests on the actual Observability Agent or real-time Production data have been performed.

## Evidence and review

`test_async_log_diagnose.py` contains eight isolated synthetic-data regression tests, including repeated tracker ID across hosts/times, privacy and invalid JSON. Results: 8/8 PASS on 2026-10-09; this is a unit test, not user-acceptance sign-off.

Sources: Async-Source source commit `781e6c4c61706a798883818982f72fb8fa53a661` and Async-KB candidate documents `source-logging-semantics.md`, `historical-runtime-evidence-2026-08-18.md` and `correlation-and-data-contract.md`.