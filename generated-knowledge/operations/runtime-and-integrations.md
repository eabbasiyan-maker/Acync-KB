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

# Runtime and Integrations

This is AI-generated candidate operational knowledge derived from the supplied Async source snapshot and separately attributed human runtime context.

## Runtime configuration

Source observations show feature/configuration switches loaded through `Settings`, including protocol handlers, brokers, cache vendors, persistence vendor selection, rate limiting, accessibility, service-call components and optional integrations.

## Relational persistence

Source includes both MySQL and Oracle implementations. Human operational input states that current runtime DB is Oracle; MySQL presence in source therefore indicates implementation support/presence, not confirmed production runtime use.

## Cache implementations

Source includes Aerospike, Redis, Caffeine and process-memory cache implementations. Human context reports Redis active in Sandbox. Which cache vendor is active in other environments remains configuration-dependent unless validated.

## Broker and messaging integrations

Implementation/dependency evidence exists for Artemis/ActiveMQ, RabbitMQ, Kafka, MQTT, ZooKeeper and peer JMS queue handling. Presence in source does not establish that every integration is enabled in production.

## Network/protocol integrations

Source contains HTTP/HTTPS, WebSocket, TCP, MQTT, CoAP/DTLS, REST mediation and WebRTC/GStreamer-related implementation paths.

## Runtime topology context

Human input reports five clusters total and node totals for Async Core, Async Chat, SSO, WebRTC and IoT. Exact cluster-to-node mapping, HA/failover rules and scaling policy are not established by the current validated knowledge.

## Rate limit implementation

Source includes rate-limit classes/factories for several scopes and initialization in `Server`. This proves implementation presence only. An official operational limit/value is not established by the validated claims and must not be inferred solely from the existence of rate-limit code.

## Build / launch

The source snapshot contains Maven configuration and legacy launch scripts. Supported JDK, authoritative deployment procedure and release process require human/operational validation.

## Evidence scope

Representative sources include `Settings`, `Server.initialize`, persistence factories/implementations, cache factories, protocol handlers, broker integrations, `pom.xml` and DB scripts.

## Explicit unknowns

Production feature flags, authoritative environment topology, failover behavior, retention, retry policy, TTL policy and SLA are not fully established by the current validated dataset.
