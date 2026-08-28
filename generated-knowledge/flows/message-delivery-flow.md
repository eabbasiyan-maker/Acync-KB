---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 2a4986c264720f6d7dff6c176d1a896e73176583
---

# Message Delivery Flow

This document is AI-generated candidate knowledge grounded in the supplied Async source snapshot. Source observations are not equivalent to approved operational guarantees.

## High-level path

```text
Client / Provider
      |
      v
Protocol Handler
      |
      v
Server / MessageManager
      |
      +--> receiver / registration resolution
      |
      +--> status / TTL / persistence decision
      |
      +--> local or inter-server / JMS path
      |
      v
Connected destination client / queue / persisted pending state
```

## Source-observed behavior

- Async creates messages and determines receiver/delivery handling through `MessageManager` and `Server`.
- The delivery path is branch-dependent and may use in-process delivery, inter-server ActiveMQ coordination, peer JMS queues, or relational persistence/polling depending on configuration and destination state.
- Source contains ACK handling, resend/retry-related behavior, expiration/TTL logic, pending-message processing, and status updates.
- Source contains behavior compatible with possible duplicate delivery around ACK/Resend mechanisms.
- The source snapshot does not establish ordering as a guaranteed system property.

## ACK / retry boundary

- Source contains ACK handling and Retry/Resend-related mechanisms.
- The source snapshot alone does not establish the exact semantic meaning or lifecycle stage represented by ACK.
- The source snapshot alone does not establish an official Retry/Resend policy, policy owner, retry count, or retry timing.
- Implementation observations in this document must not be interpreted as an official service contract.

## Offline / persistence context

- Source contains persistence, status, and pending-delivery paths compatible with offline/pending message handling.
- Some behavior is configuration-dependent.
- The source snapshot alone does not establish exact retention rules or production configuration.

## Evidence scope

Primary source areas used by the generated knowledge include:
- `Async/Async/src/com/nozha/async/server/Server.java`
- `Async/Async/src/com/nozha/async/server/biz/MessageManager.java`
- persistence CRUD implementations under `Async/Async/src/com/nozha/async/server/persistance/`
- protocol handlers and client implementations under the corresponding handler/client packages

## Source limitations

The supplied source snapshot alone does not establish:
- an official delivery guarantee such as at-most-once or at-least-once;
- exact ACK semantics;
- an official Retry/Resend policy;
- retention/SLA guarantees;
- an ordering guarantee.

Do not infer these properties from implementation details alone.

## Validation boundary

This Candidate document records source-derived observations only. It does not determine whether a statement is Trusted, validated, official, or a registered Known Gap. Validation status and formally registered knowledge gaps are maintained separately in `mvp/validated-claims.yaml` and must be resolved from that dataset rather than inferred from this document.