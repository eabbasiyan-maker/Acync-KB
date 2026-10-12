# KB lexical source-name presence audit — part 2/2
**Method:** exact case-sensitive class-name lexical match, not semantic completeness. Main KB 2026-10-12; no promotion or runtime testing.

### generated-knowledge/observability/incident-investigation-playbooks.md
- Class-name matches (20): Server, MessageManager, Client, HttpClient, ServerException, HttpHandler, Payload, ServiceCallServlet, HttpLog, Service, Request, Message, Peer, MessageCRUD, AfterSendLog, BeforeSendLog, OpenClientAddressLog, RateLimitLog, ServiceTimeLog, WebsocketAddressLog
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: 2026-11-09; source_refs: true; missing-governance-reference: false

### generated-knowledge/observability/observability-gap-report-v1.md
- Class-name matches (16): Settings, Server, HttpHandler, ServiceCallProxy, WebsocketHandler, JettyQueueSizeLogger, ServiceCallServlet, HttpLog, HttpRequestLogger, MessageCRUD, RateLimitService, AfterSendLog, BeforeSendLog, RateLimitLog, ServiceCallLog, ServiceTimeLog
- trust: untrusted-content; lifecycle: snapshot; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/observability/project-control-center.md
- Class-name matches (10): Server, AsyncProducer, MessageManager, Client, Payload, ServiceCallProxy, ServiceCallServlet, Message, MessageCRUD, RateLimitLog
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/observability/registry-v1/registry-index.md
- Class-name matches (3): HttpLog, AfterSendLog, ServiceCallLog
- trust: untrusted-content; lifecycle: snapshot; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/observability/runtime-validation-handoffs.md
- Class-name matches (2): ServiceCallServlet, MessageCRUD
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: MISSING; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/observability/source-logging-semantics.md
- Class-name matches (24): Settings, Server, LoadManager, Client, HttpHandler, Payload, ServiceCallProxy, WebsocketHandler, JettyQueueSizeLogger, ServiceCallServlet, HttpLog, HttpRequestLogger, Service, MessageCRUD, RateLimitService, PODLogUtil, AfterSendLog, BeforeSendLog, OpenClientAddressLog, PODMonitoringLog, RateLimitLog, ServiceCallLog, ServiceTimeLog, WebsocketAddressLog
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: 2026-11-09; source_refs: true; missing-governance-reference: false

### generated-knowledge/observability/source-reviewed-critical-signatures.md
- Class-name matches (32): Settings, Server, AsyncInternalMessageSender, MessageManager, Client, HttpClient, WebsocketClient, PersistanceException, ServerException, HttpHandler, ServiceCallProxy, WebsocketHandler, JettyQueueSizeLogger, ServiceCallServlet, MediationException, ServiceDefinitionProvider, Service, Request, Message, Peer, ServiceCallConfig, MessageCRUD, OracleClientCRUD, RateLimitService, PODLogUtil, AfterSendLog, BeforeSendLog, PODMonitoringLog, RateLimitLog, ServiceCallLog, ServiceTimeLog, WebsocketAddressLog
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 781e6c4c61706a798883818982f72fb8fa53a661; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/observability/tools/async-log-diagnose-README.md
- Class-name matches (3): AfterSendLog, BeforeSendLog, ServiceTimeLog
- trust: MISSING; lifecycle: MISSING; owner: MISSING; commit: MISSING; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/operations/rate-limit-manager.md
- Class-name matches (6): AsyncManager, EmbeddedHttpServer, RateLimitServlet, Service, RateLimitService, RateLimitType
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 82a2887c5a67a640145b4428e50a292b7a425b93; review due: MISSING; source_refs: true; missing-governance-reference: false

### generated-knowledge/operations/runtime-and-integrations.md
- Class-name matches (2): Settings, Server
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 2a4986c264720f6d7dff6c176d1a896e73176583; review due: MISSING; source_refs: false; missing-governance-reference: false

### generated-knowledge/overview.md
- Class-name matches (22): Settings, Server, MessageManager, RegistrationManager, Client, CoapHandler, HttpHandler, MqttHandler, QueueHandler, RestHandler, TcpHandler, WebrtcHandler, WebsocketHandler, EmbeddedHttpServer, SwaggerUiServlet, MediatorManager, ServiceDefinitionProvider, Service, Message, Peer, ConnectionFactory, MessageCRUD
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 2a4986c264720f6d7dff6c176d1a896e73176583; review due: REQUIRES_HUMAN_VALIDATION; source_refs: true; missing-governance-reference: false

### generated-knowledge/security/security-implementation.md
- Class-name matches (2): AccessibilityService, EmbeddedHttpServer
- trust: untrusted-content; lifecycle: living; owner: REQUIRES_HUMAN_VALIDATION; commit: 2a4986c264720f6d7dff6c176d1a896e73176583; review due: MISSING; source_refs: false; missing-governance-reference: false
