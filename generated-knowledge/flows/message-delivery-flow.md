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
- Source demonstrates that duplicate delivery can be possible around ACK/Resend behavior; the human-validated claim is maintained separately in `mvp/validated-claims.yaml`.
- Ordering is not established as a guaranteed system property by the current validated knowledge.

## ACK / retry boundary

The exact semantic meaning and lifecycle stage represented by ACK, and the official Retry/Resend policy/owner, remain a registered `known_gap` in the validated claims. Source implementation may show mechanisms but does not by itself establish the official service contract.

## Offline / persistence context

Human operational input indicates that offline messages can persist and that some message types may be excluded by configuration. Source contains persistence/status paths compatible with persisted pending delivery. Exact retention and production configuration remain unvalidated.

## Evidence scope

Primary source areas used by the generated knowledge include:
- `Async/Async/src/com/nozha/async/server/Server.java`
- `Async/Async/src/com/nozha/async/server/biz/MessageManager.java`
- persistence CRUD implementations under `Async/Async/src/com/nozha/async/server/persistance/`
- protocol handlers and client implementations under the corresponding handler/client packages

## Explicit unknowns

The current validated dataset does not establish an official delivery guarantee such as at-most-once or at-least-once, exact ACK semantics, official retry policy, retention/SLA, or ordering guarantee. These must not be invented from implementation details.
