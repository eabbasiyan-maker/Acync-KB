# Cycle 1 / Turn 3 — HTTP Timeout QC
Date: 2026-10-09. Scope: Non-Persist. Candidate only.
Source revision: 781e6c4c61706a798883818982f72fb8fa53a661.
Evidence: HttpClient.java lines 55-81; HttpHandler.java lines 428-456; ServiceTimeLog.java.
Join contract: trackerId -> lastTrackerId, same trusted host/environment/provider, bounded time. A 408 alone is not a confirmed listener timeout or root cause. A timeout callback alone does not prove final HTTP status.
Executed deterministic synthetic rule tests: PASS 12/12.
HT-01: same keys/time/status 408 -> bounded correlation PASS.
HT-02: cross-host -> reject PASS.
HT-03: cross-environment -> reject PASS.
HT-04: outside 120-second proposed fixture window -> reject PASS.
HT-05: reused tracker with two 408 records -> ambiguous PASS.
HT-06: two timeout events compete for one 408 -> ambiguous PASS.
HT-07: missing trusted host -> unknown PASS.
HT-08: onError not onTimeout -> distinct PASS.
HT-09: onTimeout and final status 200 -> preserve status mismatch PASS.
HT-10: isolated 408 -> unattributed PASS.
HT-11: ServiceCallLog 408 -> different status domain PASS.
HT-12: provider mismatch -> reject PASS.
The 120-second fixture window is proposed, not a validated production setting. Historical evidence reports 28 linked timeout events out of 150 408s across samples with unequal windows; no attribution for the other 122.
Actual connected Agent executions: 0 BLOCKED. Live Kibana tests: 0 BLOCKED. Deployed SHA, field mapping, trusted host metadata, and owner approval are missing.
Next: Cycle 1 Turn 4, Broker/ServiceCall/WebSocket/RateLimit.
