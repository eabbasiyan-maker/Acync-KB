---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 2a4986c264720f6d7dff6c176d1a896e73176583
---

# System Architecture Observed in Source

## Status

AI-generated candidate knowledge. Source observations are source-confirmed; human context remains candidate and is not formally promoted.

## Component map

```text
HTTP / WebSocket / TCP / MQTT / Queue / CoAP / WebRTC
                         |
                 protocol handlers
                         |
                       Server
            +------------+-------------+
            |            |             |
      registration   message logic   mediation/rate limits
            |            |             |
         CRUD facades and cache abstractions
            |                          |
      MySQL / Oracle            Aerospike / Redis /
                               memory / Caffeine
```

Supporting integrations observed in source include Artemis/ActiveMQ, RabbitMQ, Kafka, ZooKeeper, outbound HTTP services, GStreamer/WebRTC and TURN configuration.

## Declared architecture context

Human architectural context describes Async as the POD ESB/Messaging Backbone. Source code corroborates a multi-protocol messaging/router shape but does not by itself establish the official organizational charter.

## Runtime coordinator

`Server` is the main coordinator. Source observations show initialization of protocol handlers, HTTP, optional Artemis/CoAP, rate-limit/service-call/accessibility components, and optional Kafka anomaly reporting.

## Interface layer

`EmbeddedHttpServer` uses Jetty connectors and servlet contexts for HTTP/HTTPS, static content, HTTP APIs, filters, WebSocket `/ws`, and optional virtual-host REST routing. Protocol handlers implement a common handler boundary and bridge protocol-specific clients to Server processing.

## Business and orchestration layer

Source observations identify `MessageManager`, `RegistrationManager`, `AccessibilityService`, `ServiceCallService`, and rate-limit implementations as core orchestration/business components.

## Persistence and cache layer

Source includes MySQL and Oracle persistence implementations and cache implementations for Aerospike, Redis, Caffeine, and process memory.

## Messaging mechanisms

Source contains embedded Artemis/ActiveMQ support, peer JMS queue handling, message coordination, registration/routing, and multiple protocol handlers. Which branches are enabled in production remains unknown unless validated separately.

## Human runtime context

Human input reports five clusters in total and component node totals for Async Core, Async Chat, SSO, WebRTC, and IoT. These values are operational context, not source-proven deployment topology.

## Explicit boundary

Trusted claim maintained separately in `mvp/validated-claims.yaml`: Async is responsible for connection and message transport and not the Business Logic of provider/consumer services.
