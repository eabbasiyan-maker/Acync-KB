---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
verification: source-review-and-synthetic-rule-check
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---
# Cycle 1 / Turn 2 — Non-Persist message send vs ACK QC candidates
Date: 2026-10-09. Source revision: 781e6c4c61706a798883818982f72fb8fa53a661.
Status: offline rule fixtures PASS 5/5; connected Agent execution BLOCKED.

## Source evidence
- Server.java lines 805–825: BeforeSendLog emitted only for message.id != 0, before MessageManager.doMessageSent (if fromActive) and before client.sendMessage. A BeforeSendLog is an attempted send, not proof that the call completed.
- Server.java lines 825–848: AfterSendLog after normal return of client.sendMessage. It is NOT ACK, receiver delivery or business consumption. Some subsequent status update paths occur after AfterSend.
- Server.java lines 755–804: missing client emits 'client not registered' and may attempt conditional fallback. Fallback success cannot be inferred from warning.
- Server.java lines 850–870: PersistenceException/ServerException may trigger conditional recovery. Recovery success requires independent evidence.
- BeforeSendLog.retryCount is passed message.getVersion(), not a verified retry counter.
- mvp/validated-claims.yaml: async-duplicate-01 says duplicate ACK/Resend possible; async-ack-retry-gap-01 keeps exact ACK semantics and Retry/Resend policy as known_gap.
- Correlation contract: join on messageId+trackerId+client with same host/environment and bounded time. No guaranteed global uniqueness.
- AsyncInternalMessageSender.java uses a fixed-size thread pool; its saturation warning alone does not establish lost messages, retries or ACK state.

## Synthetic scenario matrix (NOT production logs)
| ID | Fixture (all IDs fictitious) | Expected | Offline rule result |
| --- | --- | --- | --- |
| MD-01 | One BeforeSend, no AfterSend, no receiver-side evidence | Attempt observed; local completion UNKNOWN; ACK/Delivery UNKNOWN | PASS |
| MD-02 | BeforeSend + AfterSend matching all keys on H1 in time window | Local send returned; ACK/Delivery UNKNOWN | PASS |
| MD-03 | BeforeSend H1 and AfterSend H2 with same IDs | Reject cross-host false join; ACK/Delivery UNKNOWN | PASS |
| MD-04 | Two Before/After pairs same keys but distinct bounded times | Two observed local attempts; duplicate delivery UNKNOWN; retry policy UNKNOWN | PASS |
| MD-05 | Internal sender pool warning only | Capacity signal; no specific message send, loss or ACK claim | PASS |

The 5/5 results are from a deterministic local classification check over these synthetic fixtures, NOT the actual Analyst Agent, and do not verify production.

## Candidate Agent evaluation prompt
For each fixture: reconstruct observed local stages; distinguish attempt, send-call return, ACK, receiver delivery, retry and duplicate; cite source anchors; show join keys and host/time boundaries; label missing ACK/Retry semantics UNKNOWN; propose one safe receiver-side check. Critical FAIL if it claims DELIVERED from AfterSend, treats message.version as proven retry count, makes a cross-host false join, or infers lost messages from thread-pool saturation.

## Gate / dependencies
Actual Agent runtime, versioned prompt and retrieval output, sanitized receiver ACK evidence and TL confirmation of ACK/Retry contracts are unavailable. No Agent PASS, production readiness, code change or trusted KB promotion claimed.
