---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed # Applies to source observations only; human-expert context remains candidate.
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
source_refs:
  - Async/Async/pom.xml
  - Async/Async/src/com/nozha/async/server/Server.java
  - Async/Async/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java
evidence_refs: []
last_validated_commit: 2a4986c264720f6d7dff6c176d1a896e73176583
next_review_due: REQUIRES_HUMAN_VALIDATION
---

# Async Candidate Overview

## Scope and trust boundary

This document combines behavior observable in the supplied source snapshot with separately attributed human architectural and operational evidence. It is AI-generated candidate knowledge with declared trust `untrusted-content`. `source-confirmed` applies only to source observations; it does not promote human evidence or mean acceptance, promotion, or effective trust. The integrated artifact has not received a recorded TL/TM/PM approval.

## Declared product and domain context

**DECLARED ARCHITECTURAL / DOMAIN CONTEXT — HUMAN_EXPERT_INPUT:** Masoud, acting as Senior Architect, describes POD as a service-oriented digital ecosystem in which applications, services, providers, and consumers interact through a central communication layer. He identifies Async as that ecosystem's ESB and Messaging Backbone—not merely an API Gateway—and assigns it conceptual roles including Message Router, Protocol Bridge, Push Gateway, Queue Bridge, and Service Bus connecting Clients, Peers, Providers, and Consumers.

Human Evidence:
- Source: `Human Input/masoud-esb-context.md`
- Expert: Masoud
- Expert Role: Senior Architect
- Evidence Type: `HUMAN_EXPERT_INPUT`
- Material statements: sections 1–2. Sections 8–11 of that file are analysis instructions/templates and are not treated as architecture facts.

**SOURCE OBSERVATION:** The multi-protocol handlers, message routing, registration, queue clients, provider mediation, and push-to-connected-client code corroborate the implementation shape of several declared roles. This does not independently prove the POD business boundary or official product charter. Evidence: `Server.initialize`, `Server.read`, `Server.MessageSender`; handler/client packages; `RegistrationManager`; `MediatorManager`; `RestHandler`.

**STATUS:** Candidate declared context. Supported/unsupported use cases, adjacent-system boundaries, business criticality, organizational approval, and canonical terminology remain **REQUIRES_HUMAN_VALIDATION** with documentary evidence.

### Candidate human-expert terminology

| Term | Declared context | Source reconciliation |
|---|---|---|
| POD | Service-oriented ecosystem connected through a central communication layer | Organizational/domain definition is not established by repository source |
| Async / ESB | POD's messaging backbone and service bus | Source corroborates multi-transport routing/mediation mechanics; official ESB designation comes from human evidence |
| Peer | An entity able to send or receive messages; examples include apps, devices, services, Providers, Consumers, Bots, and external systems | Source `Peer` has numeric ID, name, device/application attributes and registration/routing use; the full category list is human context |
| `peerId` / `peerName` | Peer identity and name used for addressing/registration | Source has `Peer.id`/`Peer.name` and corresponding VO/model fields; mapping to a POD user or SSO identity is not established |
| Client | A connected application/device endpoint using a supported protocol | Source has protocol-specific `Client` implementations and connected-client routing |
| Provider / Consumer | Service-side provider and requester/recipient roles | Provider configuration/mediation exists; actual organizations and canonical consumer registry remain unknown |
| Subject / Thread and chat terms | Cross-service conversation context described for Chat flows | `ChatMessageVO`, `ChatHistoryMessage`, `subjectId`, `typeCode`, and `systemMetadata` were not found in Async source and must not be treated as Async implementation |

This table is not an approved organizational glossary. HK-02 remains open for canonical definitions, aliases, and legacy-term status.

## Current organizational usage context

**CURRENT HUMAN OPERATIONAL / PRODUCT EVIDENCE — HUMAN_INPUT:** Elham reports that Async is used as an ecosystem-wide communication path: POD teams that need to communicate with another team use/pass through Async. This describes organizational usage scope; it is not an exhaustive consumer registry and does not mean every POD team uses every Async interface.

Human Evidence:
- Source: `C:/Users/Elham/.codex/attachments/8950c7ff-a42b-41e2-9414-459c58c9fbe0/pasted-text.txt`
- Provider: Elham
- Context: Current operational/product knowledge of Async
- Evidence Type: `HUMAN_INPUT`

**STATUS:** This strengthens the declared ESB/Messaging Backbone role from Masoud's earlier context. Actual interface consumers, supported boundaries, product/service owner, business criticality, and an authoritative service charter remain open.

## Observable system description

**VERIFIED_FROM_SOURCE** — Async is a Maven-built Java server whose packaged entry point is `com.nozha.async.server.Server`. The artifact coordinates client registration, message creation and delivery, protocol handlers, persistence, rate limiting, and embedded network servers.

Evidence:
- Path: `Async/Async/pom.xml`; component: Maven project; symbols: `artifactId`, assembly `mainClass`.
- Path: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbols: `main`, `initialize`, `read`, `sendMessage`.

**INFERRED_FROM_CODE** — The code implements a multi-transport messaging service. This is an implementation-level characterization, not a statement of product purpose or business intent. Evidence: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbols: `initialize`, `read`; protocol implementations under `Async/Async/src/com/nozha/async/server/handler/`.

Evidence:
- Path: `Async/Async/src/com/nozha/async/server/handler/`; components: `WebsocketHandler`, `HttpHandler`, `QueueHandler`, `MqttHandler`, `TcpHandler`, `CoapHandler`, `WebrtcHandler`, `RestHandler`.
- Path: `Async/Async/src/com/nozha/async/server/client/`; component family: protocol-specific `Client` implementations.

## Major capabilities visible in code

- **VERIFIED_FROM_SOURCE** — Accepts HTTP and WebSocket traffic through an embedded Jetty server. Evidence: `EmbeddedHttpServer.run`, `configureHttp`, `configureWebSocket` in `Async/Async/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java`.
- **VERIFIED_FROM_SOURCE** — Registers peers, devices, receivers, queues, REST endpoints, and CoAP endpoints. Evidence: `RegistrationManager.registerPeerForUser`, `registerPeerForOwner`, `registerReceiver`, `createQueueRegistration`, `createDeviceRegistration`, `createRestRegistration`, `createCoapRegistration` in `Async/Async/src/com/nozha/async/server/biz/RegistrationManager.java`.
- **VERIFIED_FROM_SOURCE** — Creates, persists or queues, dispatches, acknowledges, retries, and expires messages. Evidence: `MessageManager.createMessage`, `ackMessage`, `loadMessageByStatus`, `deleteExpiredMessages` in `Async/Async/src/com/nozha/async/server/biz/MessageManager.java`; sender threads in `Server.java`.
- **VERIFIED_FROM_SOURCE** — Supports relational persistence through MySQL and Oracle implementations. Evidence: `ConnectionFactory` and `persistance/impl/MySQL*`, `persistance/impl/Oracle*`.
- **VERIFIED_FROM_SOURCE** — Integration implementation classes or dependencies exist for Artemis/ActiveMQ, MQTT, RabbitMQ, Kafka, Redis, Aerospike, ZooKeeper, CoAP/DTLS, WebRTC/GStreamer, and outbound HTTP mediation. This establishes code presence, not effective deployment. Evidence: `Async/Async/pom.xml`; integration-specific classes under `src/com/nozha/async/server/{activemq,client,coapserver,ratelimit,util}`; `Server.initialize` for conditionally initialized integrations.
- **VERIFIED_FROM_SOURCE** — Contains business-, provider-, service-, and IP-oriented rate-limit implementations. Evidence: classes under `src/com/nozha/async/server/ratelimit/` and `Server.initialize`.

## Repository organization

| Area | Observable responsibility |
|---|---|
| `httpserver/` | Jetty connectors, servlet routes, WebSocket mapping, filtering, health and Swagger endpoints |
| `biz/` | Message, registration, accessibility, service-call, and load logic |
| `handler/` | Protocol-neutral dispatch boundary and protocol-specific handlers |
| `client/` | Protocol-specific outbound/session abstractions |
| `persistance/` | CRUD facades, connection factory, MySQL and Oracle implementations |
| `model/`, `vo/` | Stored entities and wire/request/response representations |
| `activemq/`, `mosquette/` | Embedded broker implementations and internal queue mechanisms |
| `coapserver/` | CoAP and DTLS server/resources |
| `mediation/` | Generic and specialized HTTP request/response mediation |
| `ratelimit/` | Rate-limit computation and Kafka publication |
| `util/` | Caching, configuration resolution, serialization, logging, and helpers |

## Entry points

- **VERIFIED_FROM_SOURCE** — Production/package entry point: `Server.main`.
- **VERIFIED_FROM_SOURCE** — Standalone `main` methods also occur in broker, sample client, utility, and persistence classes.
- **UNKNOWN** — Which auxiliary entry points are supported operational tools rather than examples or manual diagnostics.

Evidence:
- Path: `Async/Async/pom.xml`; component: Maven assembly configuration; symbol: `mainClass`.
- Path: `Async/Async/src/com/nozha/async/server/Server.java`; component: `Server`; symbol: `main`.
- Path: `Async/Async/src/`; components: Java classes containing `public static void main`, inventoried during generation; operational status remains unknown.

## Build and documentation status

- **VERIFIED_FROM_SOURCE** — Maven configuration is present in `Async/Async/pom.xml`.
- **VERIFIED_FROM_SOURCE** — Legacy direct-Java launch scripts exist in `run.sh` and `run.bat`.
- **VERIFIED_FROM_SOURCE** — The repository README is empty.
- **VERIFIED_FROM_SOURCE** — Swagger JSON and bundled Swagger UI assets exist.
- **VERIFIED_FROM_SOURCE** — No conventional Java test tree or Java test classes were found during generation.
- **REQUIRES_HUMAN_VALIDATION** — Supported JDK, authoritative build command, supported launch method, and release procedure.

## Deep-dive navigation

- **VERIFIED_FROM_SOURCE** - Observable HTTP routes, action/verb behavior, protocol addresses, payload classes, access checks, and Swagger mismatches are recorded in `contracts/interface-inventory.md`. The bundled Swagger 2.0 file has 165 operations but omits the Async management/registration/health routes registered in Jetty. Evidence: `EmbeddedHttpServer.registerServlets`; `resources/resources/swagger.json`; `SwaggerUiServlet`; `mediation/generic/ServiceDefinitionProvider`.
- **VERIFIED_FROM_SOURCE** - The message path is branch-dependent: it may use in-process delivery, an inter-server ActiveMQ queue, a peer JMS load queue, or relational polling. Status, retry, ACK, expiry, and transaction observations are recorded in `flows/message-delivery-flow.md`. Evidence: `MessageManager.getMessage`; `Server.MessageSender`; vendor `MessageCRUD` implementations.
- **VERIFIED_FROM_SOURCE** - Runtime feature switches, integration lifecycle/failure behavior, data/schema evidence, build/test evidence, and health semantics are recorded in `operations/runtime-and-integrations.md`. Evidence: `Settings`, `Server.initialize`, handler/broker/cache/CRUD classes, `pom.xml`, `resources/db-scripts/`.
- **VERIFIED_FROM_SOURCE** - Conditional servlet/Keylead checks, permissive broker authentication implementations, transport-security code, CORS/access validation, and sensitive-material categories are recorded in `security/security-implementation.md`. Evidence: named security document source references.

**UNKNOWN** - Whether all observed branches, protocols, and interfaces are enabled or supported in any production environment.

Evidence:
- Paths: `Async/Async/pom.xml`, `run.sh`, `run.bat`, `README.md`, `resources/resources/swagger.json`, `resources/www/apidocs/`.
- Search scope: extracted `Async/Async/` tree for conventional `test`/`tests` paths and `*Test.java`/`*IT.java`; absence is limited to this snapshot and search method.

## Explicit unknowns

Source does not establish product purpose or business intent. Senior Architect and operational input supplies candidate context for Async as POD's ESB/Messaging Backbone, bounded multi-protocol rationale, reported topology totals, and organizational usage. Approved scope, owners, actual consumers, exact topology mapping/resilience design, service objectives beyond the reported absence of a formal delivery SLA, supported environment details, deeper decision history, production configuration, and canonical glossary status remain **UNKNOWN** or **REQUIRES_HUMAN_VALIDATION**.
