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

# Interface Inventory

This document is candidate knowledge generated from the Async source snapshot. It inventories observable interfaces and must not be treated as the approved official contract set.

## Observable interface families

Source contains HTTP/HTTPS, WebSocket, TCP, MQTT, Queue/JMS, CoAP, REST mediation, and WebRTC-related interface implementations. Registration and management paths also exist in the server implementation.

## HTTP / WebSocket

`EmbeddedHttpServer` configures Jetty connectors, servlet contexts, filters, static resources, HTTP APIs and WebSocket `/ws`. Bundled Swagger assets exist, but the generated knowledge notes that Swagger coverage does not necessarily include every management/registration/health route configured by Jetty.

## Registration and addressing

`RegistrationManager` contains source-observed operations for peer/user/owner registration, receivers, queue registration, device registration, REST registration and CoAP registration. Peer and peer-name based addressing are visible in source. Mapping to an organizationally canonical user identity such as SSO is not established by the current source evidence.

## Queue/provider context

Human architectural context describes Provider input/output queue directions. Source database scripts and registration logic contain queue naming and input/output mappings. Environment-wide canonical conventions remain candidate unless human validated.

## Contract governance boundary

The following are registered as `known_gap` in `mvp/validated-claims.yaml`:
- the official/stable Async contract set;
- the official definition of Breaking Change;
- ADR/Decision knowledge for contract changes.

Therefore source-observed routes, payloads and protocol behavior are supporting implementation evidence, not automatically official supported contracts.

## Evidence scope

Representative source areas:
- `Async/Async/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java`
- `Async/Async/src/com/nozha/async/server/biz/RegistrationManager.java`
- handler/client packages
- VO/model payload classes
- `resources/resources/swagger.json`
- queue DB scripts and registration code

## Explicit unknowns

Which interfaces are officially supported, stable, deprecated, internal-only, or production-enabled is not fully established by the current validated dataset.
