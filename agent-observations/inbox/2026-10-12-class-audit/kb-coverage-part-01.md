# KB lexical source-name presence audit — part 1/2
**Method:** case-sensitive word-boundary class-name presence across existing KB Markdown; a name mention does NOT establish full correct class/method/error/business/log documentation. Existing KB MAIN snapshot 2026-10-12. No changed trusted documents.

### generated-knowledge/architecture/http-mediation-and-integration-boundary.md
- Class-name matches (11): ServiceCallProxy, MediateChain, MediatorManager, GenericReceivingHttpMediator, GenericSendingHttpMediator, ServiceDefinitionProvider, GenericRequest, GenericResponse, Service, MessageVO, MessageWrapperVO
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit MISSING; next_review_due MISSING; source_refs true; stale governance report reference false

### generated-knowledge/architecture/system-architecture.md
- Class-name matches (6): Server, AccessibilityService, MessageManager, RegistrationManager, ServiceCallService, EmbeddedHttpServer
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/contracts/interface-inventory.md
- Class-name matches (3): RegistrationManager, EmbeddedHttpServer, Peer
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/flows/message-delivery-flow.md
- Class-name matches (4): Server, MessageManager, Client, Message
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/flows/startup-flow.md
- Class-name matches (6): Settings, Server, MessageManager, EmbeddedHttpServer, ZooKeeperProvider, ZookeeperUtil
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due REQUIRES_HUMAN_VALIDATION; source_refs true; stale governance report reference false

### generated-knowledge/gaps/human-knowledge-backlog.md
- Class-name matches (0): none
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/gaps/knowledge-gaps.md
- Class-name matches (0): none
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 2a4986c264720f6d7dff6c176d1a896e73176583; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/adr-async-db-persistence-overload.md
- Class-name matches (5): Server, AsyncProducer, MessageManager, MessageCRUD, AfterSendLog
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 781e6c4c61706a798883818982f72fb8fa53a661; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/agent-qc-cases.md
- Class-name matches (5): HttpClient, MessageCRUD, RateLimitLog, ServiceCallLog, ServiceTimeLog
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit MISSING; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/correlation-and-data-contract.md
- Class-name matches (15): HttpClient, PersistanceException, ServerException, HttpHandler, ServiceCallProxy, HttpLog, Service, Message, Peer, AfterSendLog, BeforeSendLog, RateLimitLog, ServiceCallLog, ServiceTimeLog, WebsocketAddressLog
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit 781e6c4c61706a798883818982f72fb8fa53a661; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/delivery-board.md
- Class-name matches (0): none
- doc_class/trust: untrusted-content; lifecycle living; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit MISSING; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/historical-qa-results.md
- Class-name matches (4): HttpClient, AfterSendLog, BeforeSendLog, ServiceTimeLog
- doc_class/trust: untrusted-content; lifecycle snapshot; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit MISSING; next_review_due MISSING; source_refs false; stale governance report reference false

### generated-knowledge/observability/historical-runtime-evidence-2026-08-18.md
- Class-name matches (7): Payload, JettyQueueSizeLogger, Message, OracleClientCRUD, AfterSendLog, BeforeSendLog, ServiceTimeLog
- doc_class/trust: untrusted-content; lifecycle snapshot; owner REQUIRES_HUMAN_VALIDATION; last_validated_commit UNKNOWN_DEPLOYED_VERSION; next_review_due MISSING; source_refs true; stale governance report reference false
