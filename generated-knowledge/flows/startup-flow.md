---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed # Source grounding only; not human verification or promotion.
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
source_refs:
  - Async/Async/src/com/nozha/Settings.java
  - Async/Async/src/com/nozha/async/server/Server.java
evidence_refs: []
last_validated_commit: 2a4986c264720f6d7dff6c176d1a896e73176583
next_review_due: REQUIRES_HUMAN_VALIDATION
---

# Startup Flow

This is AI-generated candidate knowledge. The sequence is source-grounded at the recorded commit but has not been executed or human-validated.

## Observed sequence

1. **VERIFIED_FROM_SOURCE** — The JVM invokes `Server.main`.
2. **VERIFIED_FROM_SOURCE** — First use of `Settings` triggers its static initialization. It connects to ZooKeeper, obtains configuration for `infra`, `configs-general`, and hostname-specific `configs-specific`, and invokes `applySettings` for each group.
3. **VERIFIED_FROM_SOURCE** — `Server.getInstance` constructs the singleton. The constructor creates HTTP and CoAP server objects and starts the created-message and pending-message sender threads; the expiration monitor starts when enabled.
4. **VERIFIED_FROM_SOURCE** — `Server.initialize` optionally initializes local ActiveMQ coordination, reloads service definitions, resets client mappings, and calls `MessageManager.connect`.
5. **VERIFIED_FROM_SOURCE** — Enabled queue, MQTT, REST, and TCP handlers are registered. Artemis starts when `HAS_MQTT` is true. WebSocket and HTTP handlers are always added by this method.
6. **VERIFIED_FROM_SOURCE** — `EmbeddedHttpServer.run` starts the Jetty-based HTTP service.
7. **VERIFIED_FROM_SOURCE** — Aerospike initialization is forced when selected as cache vendor.
8. **VERIFIED_FROM_SOURCE** — CoAP and WebRTC handlers initialize conditionally.
9. **VERIFIED_FROM_SOURCE** — Rate-limit, service-call, Kafka anomaly-reporting when enabled, and accessibility services initialize.
10. **VERIFIED_FROM_SOURCE** — `main` registers a JVM shutdown hook.

Evidence:
- Path: `Async/Async/src/com/nozha/Settings.java`; component: `Settings`; symbols: static initializer, `applySettings`.
- Path: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbols: constructor, `initialize`, `getInstance`, `main`.
- Path: `Async/Async/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java`; component: `EmbeddedHttpServer`; symbol: `run`.
- Provenance for all claims: `2a4986c264720f6d7dff6c176d1a896e73176583`.

## Shutdown and initialization failure

**VERIFIED_FROM_SOURCE** — The shutdown hook destroys registered handlers, resets client mappings, closes message/JMS resources, stops HTTP, and closes Aerospike and relational connection resources.

**VERIFIED_FROM_SOURCE** — If initialization throws, `main` calls `exitSystem`, which destroys handlers, closes message resources, waits, executes `Settings.RESTART_COMMAND`, and exits with status 1.

Evidence:
- Path: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbols: shutdown-hook lambda, `exitSystem`.

## Important qualifications

- **INFERRED_FROM_CODE** — Sender threads begin during singleton construction before the subsequent `initialize` call returns. This follows the observed call order; operational consequences were not tested. Evidence: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbols: constructor, `getInstance`, `main`, `initialize`.
- **UNKNOWN** — Whether an external supervisor also restarts the process.
- **UNKNOWN** — Expected behavior when ZooKeeper or encrypted configuration is unavailable.
- **REQUIRES_HUMAN_VALIDATION** — Supported launch command, startup readiness criteria, dependency order, and safe restart procedure.

## Initialization dependencies and partial-failure behavior

- **VERIFIED_FROM_SOURCE** - Configuration loading occurs through `Settings` static initialization before `Server.initialize` can use feature flags. ZooKeeper configuration retrieval and keystore-assisted decryption code are therefore on the startup path. Evidence: `Async/Async/src/com/nozha/Settings.java`; static initializer; `configurationresolver/zookeeper/{ZooKeeperProvider,ZookeeperUtil}.java`.
- **VERIFIED_FROM_SOURCE** - `Server.initialize` starts local ActiveMQ coordination first when enabled, then reloads provider definitions, resets client mappings, connects peer JMS, registers/starts protocol handlers and Jetty, initializes selected cache/CoAP/WebRTC components, and finally initializes rate-limit, service-call, optional Kafka, and accessibility services. Evidence: `Async/Async/src/com/nozha/async/server/Server.java`; symbol: `initialize`.
- **VERIFIED_FROM_SOURCE** - Jetty starts before the final rate-limit/service-call/accessibility initialization calls complete. No explicit readiness gate was found between those calls. Evidence: `Server.initialize`; calls to `httpServer.run` and later service initializers.
- **INFERRED_FROM_CODE** - A port may accept traffic before all final services finish initialization because `httpServer.run` precedes those initializers. This is a call-order inference and was not runtime-tested. Evidence: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbol: `initialize`.
- **VERIFIED_FROM_SOURCE** - The normal shutdown hook closes handlers, client mappings, peer JMS, Jetty, Aerospike, and JDBC pooling. The initialization-failure `exitSystem` path destroys the handlers collected so far and closes peer JMS, then launches `RESTART_COMMAND` and exits; it does not visibly call the full normal shutdown sequence. Evidence: `Server.main`, `exitSystem`.
- **UNKNOWN** - Whether external orchestration prevents early traffic, supervises restart, or performs additional cleanup.
