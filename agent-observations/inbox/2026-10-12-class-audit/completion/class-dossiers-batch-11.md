# Async class dossiers — review batch 11


---

### dossier-src-com-nozha-async-server-persistance-servicecallcrud

<!-- source dossier: src/com/nozha/async/server/persistance/ServiceCallCrud.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceCallCrud.java:1-28"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceCallCrud.java:1-28"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java"
---

# ServiceCallCrud

## Technical

Source-reviewed candidate, based on the complete archived file [ServiceCallCrud.java:L1–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L1-L28). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([ServiceCallCrud.java:L13–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L13-L23)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `loadServiceCallDispatcherConfig()`: Returns the result of `serviceCallCRUDInterface.loadServiceCallDispatcher()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceCallCRUD dossier](class-dossiers-batch-11.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlservicecallcrud), [OracleServiceCallCRUD dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleservicecallcrud). [facade:L21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L21-L23)
- `loadServiceCallBlockerConfig()`: Returns the result of `serviceCallCRUDInterface.loadServiceCallBlocker()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceCallCRUD dossier](class-dossiers-batch-11.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlservicecallcrud), [OracleServiceCallCRUD dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleservicecallcrud). [facade:L25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L25-L27)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/biz/ServiceCallService.java: [ServiceCallService.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L17), [ServiceCallService.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L18).

## Business

SOURCE_OBSERVED: supplies dispatcher-key→peer-name map and blocker-key set for service-call routing decisions. Config load failures can look like absent routing/block entries because errors are swallowed. No request is forwarded in this file.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-serviceprovidercrud

<!-- source dossier: src/com/nozha/async/server/persistance/ServiceProviderCrud.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceProviderCrud.java:1-38"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceProviderCrud.java:1-38"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java"
---

# ServiceProviderCrud

## Technical

Source-reviewed candidate, based on the complete archived file [ServiceProviderCrud.java:L1–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L1-L38). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([ServiceProviderCrud.java:L15–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L15-L25)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds)`: Invokes `serviceProviderCrudInterface.createServiceProviderConfig(serviceProviderConfig,serverIds)`. Declared SQLException propagates without local conversion. Declares HttpException; no HTTP response mapping occurs here. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceProviderCrud dossier](class-dossiers-batch-12.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlserviceprovidercrud), [OracleServiceProviderCrud dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleserviceprovidercrud). [facade:L23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L23-L25)
- `getServiceProviderConfigs()`: Returns the result of `serviceProviderCrudInterface.getServiceProviderConfigs()`. Declared SQLException propagates without local conversion. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceProviderCrud dossier](class-dossiers-batch-12.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlserviceprovidercrud), [OracleServiceProviderCrud dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleserviceprovidercrud). [facade:L27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L27-L29)
- `getServiceProviderConfigs(String peerName, List<String> serverIds)`: Returns the result of `serviceProviderCrudInterface.getServiceProviderConfigs(peerName,serverIds)`. Declared SQLException propagates without local conversion. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceProviderCrud dossier](class-dossiers-batch-12.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlserviceprovidercrud), [OracleServiceProviderCrud dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleserviceprovidercrud). [facade:L31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L31-L33)
- `deleteServiceProviderConfigs(String peerName, List<String> serverIds)`: Invokes `serviceProviderCrudInterface.deleteServiceProviderConfig(peerName,serverIds)`. Declared SQLException propagates without local conversion. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLServiceProviderCrud dossier](class-dossiers-batch-12.md#dossier-src-com-nozha-async-server-persistance-impl-mysqlserviceprovidercrud), [OracleServiceProviderCrud dossier](class-dossiers-batch-13.md#dossier-src-com-nozha-async-server-persistance-impl-oracleserviceprovidercrud). [facade:L35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L35-L37)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/httpserver/ServiceProviderServlet.java: [ServiceProviderServlet.java:L40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L40), [ServiceProviderServlet.java:L79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L79), [ServiceProviderServlet.java:L127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L127).
- src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java: [ServiceDefinitionProvider.java:L61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java#L61).

## Business

SOURCE_OBSERVED: manages per-peer/per-server Swagger URLs, error pages, virtual hosts and enabled state for generic mediation/provider setup. Multi-server writes may partly commit and still return HTTP 500; users cannot infer atomic all-server application from failure status.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-serviceprovidercrudinterface

<!-- source dossier: src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java:1-17"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java:1-17"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java"
---

# ServiceProviderCrudInterface

## Technical

Source-reviewed candidate, based on the complete archived file [ServiceProviderCrudInterface.java:L1–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L1-L17). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds)`: Declares return type `void` and inputs shown in the signature. Checked error declaration: `SQLException, HttpException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L10–10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L10-L10)
- `getServiceProviderConfigs()`: Declares return type `List<ServiceProviderConfig>` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L12–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L12-L12)
- `getServiceProviderConfigs(String peerName,List<String> serverIds)`: Declares return type `List<ServiceProviderConfig>` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L14–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L14-L14)
- `deleteServiceProviderConfig(String peerName, List<String> serverIds)`: Declares return type `void` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L16-L16)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java: [OracleServiceProviderCrud.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L17).
- src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java: [MySQLServiceProviderCrud.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L17).

Consumer boundary: [ServiceProviderCrud.java:L1–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L1-L38). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: manages per-peer/per-server Swagger URLs, error pages, virtual hosts and enabled state for generic mediation/provider setup. Multi-server writes may partly commit and still return HTTP 500; users cannot infer atomic all-server application from failure status.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlaccessibilitycrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java:1-75"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java:1-75"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java"
---

# MySQLAccessibilityCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLAccessibilityCRUD.java:L1–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L1-L75). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Accessibility persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `loadAccessibility()`: Reads PEER_ACCESS joined to BUSINESS_ACCESS into AccessDTO(peer ID/name, business ID, value, enabled). Binds uppercase CLUSTER_NAME. The unparenthesized WHERE treats ALL-cluster rows as an independent alternative, allowing disabled ALL rows. [MySQLAccessibilityCRUD.java:L22–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L22-L48)
- `loadBusinessAccessibility()`: Reads business ID/value/enabled into AccessDTO with null peer identity. SQL AND/OR precedence means the WEBSOCKET filter applies only to the ALL alternative, and enable only to the cluster-specific alternative. [MySQLAccessibilityCRUD.java:L51–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L51-L74)

Relational dependencies observed in string SQL: `BUSINESS_ACCESS`, `PEER_ACCESS`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/AccessibilityCrud.java: [AccessibilityCrud.java:L16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L16).

Consumer boundary: [AccessibilityCrud.java:L1–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L1-L29). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supplies access values/enable markers for peer and business access loading; it does not itself authorize a request. SQL precedence can broaden returned candidate config. Triggering actors are config consumers through AccessibilityCrud, not a standalone end-user action.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `loadAccessibility`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLAccessibilityCRUD.java:L44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L44-L46)
- `catch (SQLException e)` in `loadBusinessAccessibility`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLAccessibilityCRUD.java:L70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L70-L72)

Predicate evidence: `IS_ENABLE = 1 and KEY_CLUSTER = ? or KEY_CLUSTER = 'ALL'` uses AND-before-OR grouping; business query additionally appends `and CLIENT_TYPE = 'WEBSOCKET'`. Test enabled/disabled × matching/ALL clusters × client types against approved intent.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

Literal grouping L30–31 is `where b.IS_ENABLE = 1 and b.KEY_CLUSTER = ? or b.KEY_CLUSTER = 'ALL'`, so SQL evaluates `(enabled AND matchingCluster) OR allCluster`. Business query L57–59 is `(enabled AND matchingCluster) OR (allCluster AND websocket)`. Disabled ALL and non-WEBSOCKET matching-cluster rows can therefore be returned under different alternatives. Whether this is desired access policy is UNKNOWN.

Evidence: [pinned full class](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java).

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLAccessibilityCRUD.java:L45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L45) **WARN**, registry `ALOG-DDAACBB0E20D`; `logger.warn("An exception occurred during load service call dispatcher config", e)`. Trigger/RCA: Caught exception in loadAccessibility; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLAccessibilityCRUD.java:L71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L71) **WARN**, registry `ALOG-89EACDC24089`; `logger.warn("An exception occurred during load service call dispatcher config", e)`. Trigger/RCA: Caught exception in loadBusinessAccessibility; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 2 active source calls, 2 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlclientcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java:1-209"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java:1-209"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java"
---

# MySQLClientCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLClientCRUD.java:L1–209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L1-L209). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Client persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS client_map (. [MySQLClientCRUD.java:L19–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L19-L38)
- `addClient(long peerId, long trackerId, int serverId)`: Inserts the peer/tracker/server tuple into client_map and commits. No upsert or duplicate suppression exists in the implementation. [MySQLClientCRUD.java:L41–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L41-L61)
- `removeClient(long peerId, int serverId)`: Deletes all client_map rows for the peer and this server, then commits; tracker is not part of the predicate. [MySQLClientCRUD.java:L64–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L64-L82)
- `removeOtherClients(long peerId, int serverId)`: Deletes client_map rows for a peer whose server differs from the supplied server; preserves that server mapping. [MySQLClientCRUD.java:L85–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L85-L103)
- `removeClients(long peerId)`: Deletes client_map mappings for the peer across all servers; commits without requiring a positive affected count. [MySQLClientCRUD.java:L106–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L106-L123)
- `removeClientByTracker(long trackerId, int serverId)`: Deletes mapping rows matching tracker and server, then commits. [MySQLClientCRUD.java:L126–144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L126-L144)
- `findReceiverServersByPeer(long receiverPeerId)`: Selects DISTINCT server_id for the receiver peer; returns a list without ordering guarantees. [MySQLClientCRUD.java:L147–166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L147-L166)
- `findReceiverServersByTracker(long trackerId)`: Selects server_id for tracker; returns one server or null, without a deterministic ordering clause. [MySQLClientCRUD.java:L169–188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L169-L188)
- `resetMapping(int serverId)`: Deletes client_map rows for the specified server and commits. [MySQLClientCRUD.java:L191–208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L191-L208)

Relational dependencies observed in string SQL: `IF`, `client_map`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/ClientCRUD.java: [ClientCRUD.java:L29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L29).

Consumer boundary: [ClientCRUD.java:L1–162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L1-L162). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: records and resolves which server currently hosts a peer/tracker, supporting local/interserver message routing. Removing stale mappings changes candidate destinations; cache fallback can preserve apparent availability without a durable mapping. No proof of exactly-once delivery follows.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLClientCRUD.java:L35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L35-L37)
- `catch (SQLException e)` in `addClient`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L57–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L57-L60)
- `catch (SQLException e)` in `removeClient`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L78–81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L78-L81)
- `catch (SQLException e)` in `removeOtherClients`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L99–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L99-L102)
- `catch (SQLException e)` in `removeClients`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L119–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L119-L122)
- `catch (SQLException e)` in `removeClientByTracker`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L140–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L140-L143)
- `catch (SQLException e)` in `findReceiverServersByPeer`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L161–164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L161-L164)
- `catch (SQLException e)` in `findReceiverServersByTracker`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L183–186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L183-L186)
- `catch (SQLException e)` in `resetMapping`: Propagates `new PersistanceException(e)`. [MySQLClientCRUD.java:L204–207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L204-L207)
- Explicit throw in `addClient`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L59)
- Explicit throw in `removeClient`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L80)
- Explicit throw in `removeOtherClients`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L101)
- Explicit throw in `removeClients`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L121)
- Explicit throw in `removeClientByTracker`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L142)
- Explicit throw in `findReceiverServersByPeer`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L163)
- Explicit throw in `findReceiverServersByTracker`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L185)
- Explicit throw in `resetMapping`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLClientCRUD.java:L206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L206)

Source-observed risks/findings (not production incidents):

- L155–158 skips first ResultSet row; a single receiver mapping returns empty list. L177–180 requires two rows and returns the second for tracker lookup.
- DDL L28–29 concatenates creation-date definition and PRIMARY KEY without a comma. initialize is private and no caller in this class invokes it.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

Literal result traversal L155–158: `if (resultSet.next()) { while (resultSet.next()) { serverIds.add(resultSet.getLong(1)); } }`. The first cursor advance has already positioned row one, and the while advance starts row two. For tracker L177–180 nested `if(resultSet.next())` likewise requires a second row. This is source-established skipped-result behavior; no production routing failure is asserted.

Evidence: [pinned full class](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java).

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLClientCRUD.java:L36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L36) **WARN**, registry `ALOG-97C89EC19CE4`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L58) **DEBUG**, registry `ALOG-D9523EC2E58F`; `logger.debug("An exception occurred", e)`. Trigger/RCA: Caught exception in addClient; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L79) **WARN**, registry `ALOG-536EDF707CA7`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removeClient; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L100) **WARN**, registry `ALOG-F9B576D133BD`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removeOtherClients; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L120) **WARN**, registry `ALOG-93F30DAE647C`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removeClients; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L141) **WARN**, registry `ALOG-18B864BDAB62`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removeClientByTracker; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L162) **WARN**, registry `ALOG-E6D523112F86`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in findReceiverServersByPeer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L184) **WARN**, registry `ALOG-E2A8B6400094`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in findReceiverServersByTracker; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLClientCRUD.java:L205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L205) **WARN**, registry `ALOG-446B0F3EA4BC`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in resetMapping; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 9 active source calls, 9 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlcoapcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java:1-237"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java:1-237"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java"
---

# MySQLCoapCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLCoapCRUD.java:L1–237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L1-L237). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Coap persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS coap_registration (. [MySQLCoapCRUD.java:L20–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L20-L44)
- `createCoapRegistration(CoapRegistration coapRegistration, Integer serverId)`: Rejects an already assigned positive ID, stores version zero and client/factory/peer/time/type/server/endpoint, mutates the input ID after insertion, and commits. MySQL uses generated keys; Oracle obtains coap_registration_seq.nextVal first. [MySQLCoapCRUD.java:L47–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L47-L89)
- `listCoapRegistration(long lastId, Integer serverId)`: Selects registrations with id > lastId and matching server, ordered by ID; reconstructs a list. No row-limit/page-size cap is present. [MySQLCoapCRUD.java:L92–125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L92-L125)
- `getCoapRegistration(String clientId)`: Client-ID lookup returns first matching registration or null. The ResultSet overload reconstructs ID/version/time/peer/client/factory/type/endpoint and propagates SQL mapping failures. [MySQLCoapCRUD.java:L128–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L128-L152)
- `getCoapRegistrationWithEndPoint(String endPoint)`: Looks up endpoint, not client ID, returns first matching registration or null; façade argument name clientId is misleading. [MySQLCoapCRUD.java:L155–179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L155-L179)
- `unregisterCoap(String clientId)`: Single-ID deletion binds the client ID and returns affected rows > 0. List deletion interpolates quoted client IDs with String.join into an IN clause, executes and commits; quoted user input is not safely parameterized. [MySQLCoapCRUD.java:L182–200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L182-L200)
- `unregisterCoap(List<String> clientsId)`: Single-ID deletion binds the client ID and returns affected rows > 0. List deletion interpolates quoted client IDs with String.join into an IN clause, executes and commits; quoted user input is not safely parameterized. [MySQLCoapCRUD.java:L203–219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L203-L219)
- `getCoapRegistration(ResultSet rs)`: Client-ID lookup returns first matching registration or null. The ResultSet overload reconstructs ID/version/time/peer/client/factory/type/endpoint and propagates SQL mapping failures. [MySQLCoapCRUD.java:L221–232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L221-L232)
- `main(String[] args)`: Invokes private schema initializer; instance main is not a standard JVM entrypoint. No production startup invocation is proven. [MySQLCoapCRUD.java:L234–236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L234-L236)

Relational dependencies observed in string SQL: `IF`, `coap_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/CoapCRUD.java: [CoapCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L18).

Consumer boundary: [CoapCRUD.java:L1–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L1-L47). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persistence for CoAP registration identity and endpoint discovery, consumed through CoapCRUD by registration/transport paths. Creation accepts unassigned registrations; unregister removes reachability metadata rather than closing network sockets here.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLCoapCRUD.java:L41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L41-L43)
- `catch (SQLException e)` in `createCoapRegistration`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L85–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L85-L88)
- `catch (SQLException e)` in `listCoapRegistration`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L121–124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L121-L124)
- `catch (SQLException e)` in `getCoapRegistration`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L148–151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L148-L151)
- `catch (SQLException e)` in `getCoapRegistrationWithEndPoint`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L175–178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L175-L178)
- `catch (SQLException e)` in `unregisterCoap`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L196–199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L196-L199)
- `catch (SQLException e)` in `unregisterCoap`: Propagates `new PersistanceException(e)`. [MySQLCoapCRUD.java:L215–218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L215-L218)
- Explicit throw in `createCoapRegistration`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L49)
- Explicit throw in `createCoapRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L87)
- Explicit throw in `listCoapRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L123)
- Explicit throw in `getCoapRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L150)
- Explicit throw in `getCoapRegistrationWithEndPoint`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L177)
- Explicit throw in `unregisterCoap`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L198)
- Explicit throw in `unregisterCoap`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLCoapCRUD.java:L217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L217)

Source-observed risks/findings (not production incidents):

- INSERT L57–58 has eight named columns but version literal plus eight placeholders; seven parameters are supplied. Source candidate for registration insert failure.
- List unregister L207 concatenates unescaped string IDs into SQL.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

Literal insertion L57–69: columns `(version, client_id, factory_name, peer_id, time, type, server_id, end_point)` have eight positions; `VALUES (0, ?, ?, ?, ?, ?, ?,?,?)` supplies nine expressions. Seven ps setters bind client/factory/peer/time/type/server/endpoint. Isolated SQL validation should distinguish column-expression count mismatch from the unbound final placeholder.

Evidence: [pinned full class](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java).

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLCoapCRUD.java:L42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L42) **WARN**, registry `ALOG-158F9D63CA9F`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L86) **WARN**, registry `ALOG-381003A6A20B`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createCoapRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L122) **WARN**, registry `ALOG-2902F403EFDA`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listCoapRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L149) **WARN**, registry `ALOG-7B87569369D0`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getCoapRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L176) **WARN**, registry `ALOG-AF8EC58AE0EA`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getCoapRegistrationWithEndPoint; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L197](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L197) **WARN**, registry `ALOG-F2458E0B7A7C`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in unregisterCoap; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLCoapCRUD.java:L216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L216) **WARN**, registry `ALOG-EB755918DA06`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in unregisterCoap; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 7 active source calls, 7 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqldevicecrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java:1-256"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java:1-256"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java"
---

# MySQLDeviceCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLDeviceCRUD.java:L1–256](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L1-L256). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Device persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS device_registration ( CREATE  INDEX device_reg_q on device_registration (input_queue_name). [MySQLDeviceCRUD.java:L20–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L20-L45)
- `createDeviceRegistration(DeviceRegistration deviceRegistration, Integer serverId)`: Rejects positive existing ID; inserts version zero, input queue, client/factory, peer, time/type and server. Returns the input object with generated/sequence ID, after commit. [MySQLDeviceCRUD.java:L48–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L48-L90)
- `listDeviceRegistration(long lastId, Integer serverId)`: Returns rows with id > lastId restricted to server and ordered by ID. This is cursor-style polling without a limit. [MySQLDeviceCRUD.java:L93–126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L93-L126)
- `getDeviceRegistration(String clientId)`: Client-ID lookup yields first matching DeviceRegistration or null. ResultSet overload reconstructs ID/version/time/peer/queue/client/factory/type. [MySQLDeviceCRUD.java:L129–153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L129-L153)
- `getDeviceRegistrationByInputQueue(String inputQueue)`: Returns every device registration whose input_queue_name matches a bound value; no server filter applies. [MySQLDeviceCRUD.java:L156–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L156-L180)
- `unregisterDevice(String clientId)`: Single client-ID deletion returns a positive affected count after commit. Batch deletion concatenates String.join of quoted client IDs into SQL and returns void; this is not parameter binding. [MySQLDeviceCRUD.java:L183–201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L183-L201)
- `unregisterDevice(List<String> clientsId)`: Single client-ID deletion returns a positive affected count after commit. Batch deletion concatenates String.join of quoted client IDs into SQL and returns void; this is not parameter binding. [MySQLDeviceCRUD.java:L204–220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L204-L220)
- `getPeerIdsByClientId(List<String> clientsId)`: Reads peer IDs for a concatenated quoted client-ID IN clause. Returns a list, without DISTINCT; caller must handle duplicates and empty/quoted lists. [MySQLDeviceCRUD.java:L223–238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L223-L238)
- `getDeviceRegistration(ResultSet rs)`: Client-ID lookup yields first matching DeviceRegistration or null. ResultSet overload reconstructs ID/version/time/peer/queue/client/factory/type. [MySQLDeviceCRUD.java:L240–251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L240-L251)
- `main(String[] args)`: Invokes private schema initializer; instance main is not a standard JVM entrypoint. No production startup invocation is proven. [MySQLDeviceCRUD.java:L253–255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L253-L255)

Relational dependencies observed in string SQL: `IF`, `device_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/DeviceCRUD.java: [DeviceCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L18).

Consumer boundary: [DeviceCRUD.java:L1–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L1-L51). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persists device client-to-peer and input-queue associations. Listing supports server registration restoration/polling; batch removal and queue lookup change which peer identities can be resolved. This class does not authenticate clients.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLDeviceCRUD.java:L42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L42-L44)
- `catch (SQLException e)` in `createDeviceRegistration`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L86–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L86-L89)
- `catch (SQLException e)` in `listDeviceRegistration`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L122–125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L122-L125)
- `catch (SQLException e)` in `getDeviceRegistration`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L149–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L149-L152)
- `catch (SQLException e)` in `getDeviceRegistrationByInputQueue`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L176–179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L176-L179)
- `catch (SQLException e)` in `unregisterDevice`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L197–200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L197-L200)
- `catch (SQLException e)` in `unregisterDevice`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L216–219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L216-L219)
- `catch (SQLException e)` in `getPeerIdsByClientId`: Propagates `new PersistanceException(e)`. [MySQLDeviceCRUD.java:L234–237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L234-L237)
- Explicit throw in `createDeviceRegistration`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L50)
- Explicit throw in `createDeviceRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L88)
- Explicit throw in `listDeviceRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L124)
- Explicit throw in `getDeviceRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L151)
- Explicit throw in `getDeviceRegistrationByInputQueue`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L178)
- Explicit throw in `unregisterDevice`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L199)
- Explicit throw in `unregisterDevice`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L218)
- Explicit throw in `getPeerIdsByClientId`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLDeviceCRUD.java:L236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L236)

Source-observed risks/findings (not production incidents):

- Batch ID SQL L208/L225 concatenates quoted client IDs; prepared statement does not make interpolated text safe.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLDeviceCRUD.java:L43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L43) **WARN**, registry `ALOG-522E20A32157`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L87) **WARN**, registry `ALOG-1BA046B29F10`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createDeviceRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L123) **WARN**, registry `ALOG-439400675CF3`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listDeviceRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L150) **WARN**, registry `ALOG-74C7EFE983DB`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getDeviceRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L177) **WARN**, registry `ALOG-EFA79FC434F8`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getDeviceRegistrationByInputQueue; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L198) **WARN**, registry `ALOG-03AB03DD7630`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in unregisterDevice; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L217) **WARN**, registry `ALOG-0BE74BBED8C0`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in unregisterDevice; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLDeviceCRUD.java:L235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L235) **WARN**, registry `ALOG-17827FC2EB73`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getPeerIdsByClientId; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 8 active source calls, 8 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlmessagecrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:1-973"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:1-973"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java"
---

# MySQLMessageCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLMessageCRUD.java:L1–973](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L1-L973). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Message persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS message ( CREATE TABLE IF NOT EXISTS message_archive ( CREATE TABLE IF NOT EXISTS message_log ( CREATE PROCEDURE `archive_message`(in_id bigint(20), in_version bigint(20), in_ignore bit(1))\n. [MySQLMessageCRUD.java:L25–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L25-L118)
- `getNextMessageId()`: Reads message_seq.nextVal from dual inside an unbounded while(!done), logging and retrying SQLException with no delay, count cap or cancellation path. MySQL uses this Oracle-style query too. [MySQLMessageCRUD.java:L121–140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L121-L140)
- `create(Message message, Integer serverId)`: Standalone creation rejects positive ID, opens transaction, delegates connection-taking insertion, commits, and sets version zero. Connection-taking insertion writes message fields, assigns ID, optionally records CREATE_OP, but leaves transaction ownership to caller. [MySQLMessageCRUD.java:L143–165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L143-L165)
- `create(Message message, Connection connection, Integer serverId)`: Standalone creation rejects positive ID, opens transaction, delegates connection-taking insertion, commits, and sets version zero. Connection-taking insertion writes message fields, assigns ID, optionally records CREATE_OP, but leaves transaction ownership to caller. [MySQLMessageCRUD.java:L168–205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L168-L205)
- `logOperation(Message message, Connection connection, int operation, int status)`: When Settings.LOGGING is true, writes message ID, current time, status and operation to relational message_log on the supplied transaction. Oracle also allocates message_log_seq ID. This is database audit, not an SLF4J success receipt. [MySQLMessageCRUD.java:L207–219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L207-L219)
- `loadCollapseMessage(long collapseId, long senderId, long receiverId)`: Finds message by collapse ID/sender/receiver; null when missing. A second result explicitly throws PersistanceException("duplicate collpase message exists!"); SQLException is logged and suppressed. [MySQLMessageCRUD.java:L222–264](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L222-L264)
- `loadMessageByStatus(int status, int count, Integer serverId)`: Loads a count-limited subset of status/server messages via partialFillMessage. MySQL uses ORDER BY time LIMIT; Oracle applies ROWNUM <= count before appended DB_MESSAGE_ORDER, so selected membership need not be globally oldest. [MySQLMessageCRUD.java:L267–318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L267-L318)
- `loadPendingMessage(int count, Integer serverId)`: Selects PENDING rows whose retry_date plus clamped (expire_date-time)/MAX_RETRY_COUNT interval is before now, bounded by MIN_RETRY_PERIOD/MAX_RETRY_PERIOD. MySQL optionally scopes server and limits after time ordering; Oracle requires server and ROWNUM plus configured ordering. [MySQLMessageCRUD.java:L321–376](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L321-L376)
- `loadMessageById(long id, Connection connection)`: Private full row lookup by ID returns null if absent; SQL error becomes PersistanceException("Could not load entity") after logging, dropping the cause from that wrapper. [MySQLMessageCRUD.java:L378–414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L378-L414)
- `partialLoadMessageById(long id, Connection connection)`: Private ACK lookup loads ID/version/sender/receiver/time/message-ID/expiry/type only. Null if absent; SQL error logs and becomes PersistanceException("Could not load entity"). [MySQLMessageCRUD.java:L416–465](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L416-L465)
- `fillMessage(ResultSet rs)`: Maps full message projection including collapse/group/index/priority/retry/content/address/origin/status/privacy/sync. Does not populate tracker_id or server_id. [MySQLMessageCRUD.java:L467–489](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L467-L489)
- `partialFillMessage(ResultSet rs)`: Maps delivery projection including tracker ID and payload/routing/status/privacy/sync, omitting collapse/group/index/priority/retry/server fields. [MySQLMessageCRUD.java:L491–514](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L491-L514)
- `archive(Message message)`: Standalone overload opens transaction, calls procedure overload with ignoreVersion=true and commits. Connection overload calls archive_message(ID,version,ignore flag), then records ARCHIVE_OP if enabled; does not independently commit. [MySQLMessageCRUD.java:L517–527](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L517-L527)
- `archiveAll(List<Message> messages)`: Standalone overload forwards a list to batch procedure calls. Each item binding/addBatch catches SQL errors and continues; executeBatch errors propagate. MySQL batch overload commits caller connection; Oracle batch overload does not explicitly commit and standalone retains connection default autoCommit. [MySQLMessageCRUD.java:L530–537](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L530-L537)
- `archiveAckMsg(long receiver, long id)`: Loads partial message, verifies receiver equality, and for MESSAGE_SENDER_ACK_NEEDED creates an ACK to original sender with remaining-relative TTL/content message ID. Marks in-memory original SENT, archives ignoring version, commits; missing/wrong receiver returns null. [MySQLMessageCRUD.java:L540–572](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L540-L572)
- `archive(Message message, Connection connection, boolean ignoreVersion)`: Standalone overload opens transaction, calls procedure overload with ignoreVersion=true and commits. Connection overload calls archive_message(ID,version,ignore flag), then records ARCHIVE_OP if enabled; does not independently commit. [MySQLMessageCRUD.java:L575–628](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L575-L628)
- `archiveAll(List<Message> messages, Connection connection, boolean ignoreVersion)`: Standalone overload forwards a list to batch procedure calls. Each item binding/addBatch catches SQL errors and continues; executeBatch errors propagate. MySQL batch overload commits caller connection; Oracle batch overload does not explicitly commit and standalone retains connection default autoCommit. [MySQLMessageCRUD.java:L631–645](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L631-L645)
- `changeStatus(Message message, int status)`: Message-object overload updates status/version by ID without optimistic version predicate; PENDING additionally sets retry_date=now. Optional operation audit precedes commit; then in-memory status/version advance. ID-only overload changes status alone without version/audit update. [MySQLMessageCRUD.java:L648–690](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L648-L690)
- `updatePendingMessageRetryTime(Message message, long time)`: Updates retry_date and increments DB version by ID, with optimistic version condition commented out. Zero rows raises PersistanceException naming ID. On success audit RETRY_OP, commit, then increment in-memory version; does not mutate in-memory retryDate. [MySQLMessageCRUD.java:L693–716](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L693-L716)
- `updateCollapsedMessage(Message message)`: One-argument overload delegates false. Main overload intends content/time/expiry/sync/version update with optimistic ID/version predicate, but SQL uses async while schema defines sync, binds slot 4 twice, slot 5 with version and never slot 6. Parameter sync is unused; zero rows also throws. [MySQLMessageCRUD.java:L719–721](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L719-L721)
- `updateCollapsedMessage(Message message, boolean sync)`: One-argument overload delegates false. Main overload intends content/time/expiry/sync/version update with optimistic ID/version predicate, but SQL uses async while schema defines sync, binds slot 4 twice, slot 5 with version and never slot 6. Parameter sync is unused; zero rows also throws. [MySQLMessageCRUD.java:L724–750](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L724-L750)
- `collapseMessages(Integer serverId)`: For this server, selects older IDs in nonzero collapse groups by sender/receiver/collapse, optionally archives/audits them as CANCELED, then deletes and commits. Group max subquery has no server filter. Oracle logging queries use message_archive.nextval/message_log.nextval rather than declared *_seq names. [MySQLMessageCRUD.java:L753–800](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L753-L800)
- `loadNotSentMessages(long receiverId)`: Reads all retained message rows for receiver, without status predicate despite method name. MySQL orders time; Oracle appends configured DB_MESSAGE_ORDER; reconstructs full message fields. [MySQLMessageCRUD.java:L803–841](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L803-L841)
- `deleteExpiredMessages(Integer serverId)`: Archives/audits expired rows if Settings.LOGGING, deletes expiry<now for server and commits; then separately removes messages/mappings associated with missing peers. This later cleanup has no server/expiry predicate and no explicit transaction controls. [MySQLMessageCRUD.java:L844–908](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L844-L908)
- `createActiveMessage(Message message)`: Inserts a message whose ID already exists in memory, records CREATE_OP if logging enabled and commits. SQL errors are logged and suppressed; returns the input message even after failed persistence. Oracle preserves input version; MySQL writes version zero. [MySQLMessageCRUD.java:L912–954](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L912-L954)
- `changeStatus(long id, int status)`: Message-object overload updates status/version by ID without optimistic version predicate; PENDING additionally sets retry_date=now. Optional operation audit precedes commit; then in-memory status/version advance. ID-only overload changes status alone without version/audit update. [MySQLMessageCRUD.java:L957–972](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L957-L972)

Relational dependencies observed in string SQL: `CLIENT_MAP`, `IF`, `PEER`, `message`, `message_archive`, `message_log`, `peer`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/MessageCRUD.java: [MessageCRUD.java:L36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L36).

Consumer boundary: [MessageCRUD.java:L1–136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L1-L136). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supports pending delivery storage, retry eligibility, collapse replacement, ACK archival and expiry maintenance. Relational rows, enqueue acceptance and transport delivery are distinct stages; source alone approves neither retention SLA nor delivery guarantee. Triggering actors are Server/MessageManager/AsyncProducer and maintenance paths.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

Reconciliation: generated-knowledge/flows/message-delivery-flow.md already separates delivery, ACK and persistence guarantees; this dossier adds concrete SQL/transaction branches. generated-knowledge/observability/adr-async-db-persistence-overload.md remains a proposed policy; its cumulative-counter observation matches MessageCRUD, but that document’s isolated test is not a runtime test performed by this audit.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLMessageCRUD.java:L115–117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L115-L117)
- `catch (SQLException e)` in `getNextMessageId`: Logs and retries indefinitely without delay/cap; no error result reaches caller. [MySQLMessageCRUD.java:L135–137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L135-L137)
- `catch (SQLException e)` in `create`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L159–162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L159-L162)
- `catch (SQLException e)` in `loadCollapseMessage`: Logs and returns current message/null; runtime duplicate exception is not caught by this SQLException handler. [MySQLMessageCRUD.java:L260–262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L260-L262)
- `catch (SQLException e)` in `loadMessageByStatus`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLMessageCRUD.java:L311–313](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L311-L313)
- `catch (SQLException e)` in `loadPendingMessage`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLMessageCRUD.java:L369–371](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L369-L371)
- `catch (SQLException e)` in `loadMessageById`: Propagates `new PersistanceException("Could not load entity")`. [MySQLMessageCRUD.java:L410–413](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L410-L413)
- `catch (SQLException e)` in `partialLoadMessageById`: Propagates `new PersistanceException("Could not load entity")`. [MySQLMessageCRUD.java:L461–464](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L461-L464)
- `catch (SQLException e)` in `archive`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLMessageCRUD.java:L524–526](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L524-L526)
- `catch (SQLException e)` in `archiveAll`: Prints stack trace directly and suppresses error; no SLF4J call in this catch. [MySQLMessageCRUD.java:L534–536](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L534-L536)
- `catch (SQLException e)` in `archiveAckMsg`: Logs and returns null; missing/wrong receiver and SQL failure can share return value. [MySQLMessageCRUD.java:L568–570](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L568-L570)
- `catch (SQLException e)` in `archiveAll`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLMessageCRUD.java:L639–641](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L639-L641)
- `catch (SQLException e)` in `changeStatus`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L686–689](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L686-L689)
- `catch (SQLException e)` in `updatePendingMessageRetryTime`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L712–715](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L712-L715)
- `catch (SQLException e)` in `updateCollapsedMessage`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L746–749](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L746-L749)
- `catch (SQLException e)` in `collapseMessages`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLMessageCRUD.java:L797–799](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L797-L799)
- `catch (SQLException e)` in `loadNotSentMessages`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLMessageCRUD.java:L837–839](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L837-L839)
- `catch (SQLException e)` in `deleteExpiredMessages`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L904–907](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L904-L907)
- `catch (SQLException e)` in `createActiveMessage`: Logs and returns original Message after SQL failure; return object does not prove commit. [MySQLMessageCRUD.java:L950–952](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L950-L952)
- `catch (SQLException e)` in `changeStatus`: Propagates `new PersistanceException(e)`. [MySQLMessageCRUD.java:L968–971](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L968-L971)
- Explicit throw in `create`: `new RuntimeException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L145)
- Explicit throw in `create`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L161)
- Explicit throw in `loadCollapseMessage`: `new PersistanceException("duplicate collpase message exists!")`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L255)
- Explicit throw in `loadMessageById`: `new PersistanceException("Could not load entity")`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L412](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L412)
- Explicit throw in `partialLoadMessageById`: `new PersistanceException("Could not load entity")`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L463](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L463)
- Explicit throw in `changeStatus`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L688](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L688)
- Explicit throw in `updatePendingMessageRetryTime`: `new PersistanceException("row was deleted or updated in another session: " + message.getId())`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L705](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L705)
- Explicit throw in `updatePendingMessageRetryTime`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L714](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L714)
- Explicit throw in `updateCollapsedMessage`: `new PersistanceException("row was deleted or updated in another session: " + message.getId())`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L739](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L739)
- Explicit throw in `updateCollapsedMessage`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L748](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L748)
- Explicit throw in `deleteExpiredMessages`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L906](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L906)
- Explicit throw in `changeStatus`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLMessageCRUD.java:L970](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L970)

Source-observed risks/findings (not production incidents):

- getNextMessageId uses Oracle sequence syntax in an unlimited tight retry loop L121–139.
- updateCollapsedMessage L729–736 uses async column, overwrites parameter 4, binds 5 as version, leaves parameter 6 unset; sync parameter unused.
- createActiveMessage L950–953 suppresses SQL failure and returns input. MyISAM DDL means explicit commits alone cannot prove transactional atomicity.
- archiveAll top-level prints stack trace L535 rather than logger; batch overload commits external connection L644 and does not close CallableStatement.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

Literal collapsed-update evidence L729–736: `UPDATE message SET version = version + 1, content = ?, time = ?, expire_date = ?, async = ? WHERE id = ? AND version = ?`; setter indices are 1,2,3,4,4,5. The second setLong(4,message.getId()) overwrites setBoolean(4,message.isSync()), and parameter 6 is unbound. Local schema declares `sync`. This is a concrete source candidate for SQL/binding failure, not a reproduced database incident.

Evidence: [pinned full class](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java).

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLMessageCRUD.java:L116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L116) **WARN**, registry `ALOG-6A7F16961CF1`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L136) **WARN**, registry `ALOG-391C8D216FE8`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getNextMessageId; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L160) **WARN**, registry `ALOG-7DF9E9D33955`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in create; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L261](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L261) **WARN**, registry `ALOG-8151D719B8AA`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadCollapseMessage; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L312](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L312) **WARN**, registry `ALOG-9EE7C3C8E74B`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadMessageByStatus; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L315](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L315) **WARN**, registry `ALOG-8731C4EBB51F`; `logger.warn("select message in loadMessageByStatus time: {}", System.currentTimeMillis() - now)`. Trigger/RCA: Elapsed wall-clock threshold guard for this operation. Measures code timing rather than proving DB saturation; timing arithmetic must be read at this source site.
- [MySQLMessageCRUD.java:L370](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L370) **WARN**, registry `ALOG-26C723A10601`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPendingMessage; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L373](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L373) **WARN**, registry `ALOG-DFF633AAB006`; `logger.warn("select message in loadPendingMessage time: {}", System.currentTimeMillis() - now)`. Trigger/RCA: Elapsed wall-clock threshold guard for this operation. Measures code timing rather than proving DB saturation; timing arithmetic must be read at this source site.
- [MySQLMessageCRUD.java:L411](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L411) **WARN**, registry `ALOG-4B2C2187771C`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadMessageById; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L462](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L462) **WARN**, registry `ALOG-BDBECFC068B9`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in partialLoadMessageById; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L525](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L525) **WARN**, registry `ALOG-AD677FB11567`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in archive; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L569](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L569) **WARN**, registry `ALOG-BD1C1BFB428D`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in archiveAckMsg; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L640](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L640) **WARN**, registry `ALOG-74A0C35FAE86`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in archiveAll; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L687](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L687) **WARN**, registry `ALOG-91DB2CE65A6F`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in changeStatus; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L713](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L713) **WARN**, registry `ALOG-BA64557F312A`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in updatePendingMessageRetryTime; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L747](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L747) **WARN**, registry `ALOG-040DA7E6B39D`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in updateCollapsedMessage; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L798](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L798) **WARN**, registry `ALOG-D8CEF1E69911`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in collapseMessages; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L838](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L838) **WARN**, registry `ALOG-8AD8E3E5E75E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadNotSentMessages; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L882](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L882) **DEBUG**, registry `ALOG-5A329C651085`; `logger.debug("{} messages expired!!!", delCount)`. Trigger/RCA: After expiry delete executeUpdate, before transaction commit; affected count is not a durable final outcome.
- [MySQLMessageCRUD.java:L886](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L886) **DEBUG**, registry `ALOG-17D8A0D075E0`; `logger.debug("delete timeout messages")`. Trigger/RCA: Operation phase in deleteExpiredMessages; log position is evidence of reaching this branch, not consumer ACK or end-to-end success.
- [MySQLMessageCRUD.java:L903](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L903) **DEBUG**, registry `ALOG-4BE37D79BC3E`; `logger.debug("delete timeout messages done")`. Trigger/RCA: Operation phase in deleteExpiredMessages; log position is evidence of reaching this branch, not consumer ACK or end-to-end success.
- [MySQLMessageCRUD.java:L905](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L905) **WARN**, registry `ALOG-45B885F70C2B`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in deleteExpiredMessages; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L951](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L951) **WARN**, registry `ALOG-A6E76B4B973E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createActiveMessage; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLMessageCRUD.java:L969](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L969) **WARN**, registry `ALOG-620F86781AD9`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in changeStatus; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 24 active source calls, 24 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlpeercrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:1-819"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:1-819"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java"
---

# MySQLPeerCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLPeerCRUD.java:L1–819](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L1-L819). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Peer persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS peer ( CREATE TABLE IF NOT EXISTS peer_registration (. [MySQLPeerCRUD.java:L30–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L30-L66)
- `removePeer(String appId, String deviceId)`: Finds ID by app/device, returning zero if absent; if found deletes user-side peer registrations, peer and messages addressed to it, then commits. Does not remove owner-side registrations in this method. [MySQLPeerCRUD.java:L69–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L69-L118)
- `isPeerExists(String appId, String deviceId)`: COUNT query by app/device or ID returns count > 0; does not apply status/server criteria. [MySQLPeerCRUD.java:L121–138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L121-L138)
- `isPeerExists(long id)`: COUNT query by app/device or ID returns count > 0; does not apply status/server criteria. [MySQLPeerCRUD.java:L141–157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L141-L157)
- `createPeer(Peer peer)`: Rejects positive ID; stores identity/name/device/app/credentials/TTL/max-message-count/client-timeout/server and current last_seen. Mutates ID from generated key or peer_seq and commits; credentials are stored directly here. [MySQLPeerCRUD.java:L160–199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L160-L199)
- `loadPeer(long id)`: Returns peer by bound ID or null, mapping identity/credentials/last_seen/TTL/message limit; client timeout/server are absent in the projection. [MySQLPeerCRUD.java:L202–221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L202-L221)
- `loadPeerReceiveInfoByDeviceIdAndServerId(long serverId, String deviceId)`: Joins registration to peer, filtering device ID and owner_peer_id=serverId (parameter is an owner identity despite name). Builds a partial peer with ID/name/TTL/message limit. [MySQLPeerCRUD.java:L224–252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L224-L252)
- `loadPeerByAppAndDevice(String deviceId, String appId)`: Returns first peer matching device and app using bound parameters, or null. [MySQLPeerCRUD.java:L255–275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L255-L275)
- `loadPeerIdByAppAndDevice(String deviceId, String appId)`: Returns nullable peer ID for bound app/device. [MySQLPeerCRUD.java:L278–298](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L278-L298)
- `loadPeerByName(String name)`: Returns first peer matching name or null; no explicit case normalization. [MySQLPeerCRUD.java:L301–320](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L301-L320)
- `fillPeer(ResultSet rs)`: Maps identity/version/time/name/device/app/username/password/last_seen/TTL/max-message-count. Does not populate server or client timeout. [MySQLPeerCRUD.java:L322–336](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L322-L336)
- `registerInPeer(PeerRegistration peerRegistration)`: Inserts owner/user identity association and commits; catches SQLIntegrityConstraintViolationException without logging or rethrow, treating every integrity failure as ignorable, not solely duplicates. [MySQLPeerCRUD.java:L339–359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L339-L359)
- `isPeerRegistrationExists(PeerRegistration peerRegistration)`: Checks association COUNT(owner,user)>0; DB failure is different from false and propagates. [MySQLPeerCRUD.java:L362–377](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L362-L377)
- `getPeerRegistrations(Peer peer, List<String> deviceIds)`: Builds bound placeholders for device IDs and returns partial user peers belonging to owner peer; empty device list produces IN (), with no guard. [MySQLPeerCRUD.java:L380–416](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L380-L416)
- `seen(Peer peer)`: Updates last_seen by ID to current wall clock; only exactly one affected row commits and mutates input. Otherwise returns null; no version increment. [MySQLPeerCRUD.java:L419–442](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L419-L442)
- `getPeerLastSeen(long peerId)`: Single-ID query returns -1 if missing, otherwise DB timestamp. Batch query skips empty list, builds bound placeholders, and returns only found IDs/timestamps. [MySQLPeerCRUD.java:L445–465](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L445-L465)
- `getPeerLastSeen(List<Long> peerIds)`: Single-ID query returns -1 if missing, otherwise DB timestamp. Batch query skips empty list, builds bound placeholders, and returns only found IDs/timestamps. [MySQLPeerCRUD.java:L468–494](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L468-L494)
- `timeoutPeers()`: Loads named owners with positive client_timeout plus DEFAULT_PEER_TIMEOUT fallback. For each owner finds stale registered peers (Oracle also NAME IS NULL); fallback finds unnamed unregistered peers. Skips TIMEOUT_EXCEPTION_PEERS and peers currently online according to Server.isOffline. Calls Server.removePeer before DB archival. In SERVER_TIMEOUT_PEER_COUNT_PER_STEP chunks loads owners, optionally copies sender/receiver messages to archive and writes CANCELED/TIMEOUT_OP audit, deletes user registrations and peer rows, creates private PEER_REMOVED JSON-ID notifications to owners with SERVER_TTL/priority, and commits. No explicit delete of those message rows occurs here; maintenance handles leftovers. SQL errors log and suppress; prior in-memory removals/earlier chunk commits remain possible. [MySQLPeerCRUD.java:L497–715](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L497-L715)
- `getServerPeersWithQueue()`: Queries named peers for Settings.SERVER_ID with max_message_count>0, but uses if(rs.next()), returning at most one peer rather than all. [MySQLPeerCRUD.java:L718–740](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L718-L740)
- `removePeerByPeerId(long peerId)`: Deletes peer row(s), returning whether any were removed. Single ID is bound; list of Long is rendered as comma-separated literals; empty lists produce IN (). These overloads do not delete associated registrations/messages. [MySQLPeerCRUD.java:L742–760](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L742-L760)
- `removePeerByPeerId(List<Long> peerIds)`: Deletes peer row(s), returning whether any were removed. Single ID is bound; list of Long is rendered as comma-separated literals; empty lists produce IN (). These overloads do not delete associated registrations/messages. [MySQLPeerCRUD.java:L763–780](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L763-L780)
- `loadPeerByInputQueueName(String inputQueueName)`: Resolves peers through DEVICE_REGISTRATION input queue; returns PeerDto(id,name,device). Oracle iterates all rows; MySQL uses if and returns at most one. [MySQLPeerCRUD.java:L783–813](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L783-L813)
- `main(String[] args)`: Invokes private schema initializer; instance main is not a standard JVM entrypoint. Prints wall-clock time to stdout first. No production startup invocation is proven. [MySQLPeerCRUD.java:L815–818](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L815-L818)

Relational dependencies observed in string SQL: `DEVICE_REGISTRATION`, `IF`, `message`, `message_archive`, `message_log`, `peer`, `peer_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/PeerCRUD.java: [PeerCRUD.java:L22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L22).

Consumer boundary: [PeerCRUD.java:L1–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L1-L118). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: durable app/device/name identity, owner/user associations and last-seen presence support registration and receiver lookup. Timeout maintenance removes offline nonexempt stale peers and produces PEER_REMOVED owner messages. TTL/count fields are stored, not an approved product policy.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLPeerCRUD.java:L63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L63-L65)
- `catch (SQLException e)` in `removePeer`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L107–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L107-L111)
- `catch (SQLException e)` in `isPeerExists`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L134–137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L134-L137)
- `catch (SQLException e)` in `isPeerExists`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L153–156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L153-L156)
- `catch (SQLException e)` in `createPeer`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L195–198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L195-L198)
- `catch (SQLException e)` in `loadPeer`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L217–220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L217-L220)
- `catch (SQLException e)` in `loadPeerReceiveInfoByDeviceIdAndServerId`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L248–251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L248-L251)
- `catch (SQLException e)` in `loadPeerByAppAndDevice`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L271–274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L271-L274)
- `catch (SQLException e)` in `loadPeerIdByAppAndDevice`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L294–297](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L294-L297)
- `catch (SQLException e)` in `loadPeerByName`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L316–319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L316-L319)
- `catch (SQLIntegrityConstraintViolationException ignore)` in `registerInPeer`: Silently suppresses integrity failure; no direct log. Other integrity causes are not distinguished from duplicate registration. [MySQLPeerCRUD.java:L354–355](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L354-L355)
- `catch (SQLException e)` in `registerInPeer`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L355–358](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L355-L358)
- `catch (SQLException e)` in `isPeerRegistrationExists`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L373–376](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L373-L376)
- `catch (SQLException e)` in `getPeerRegistrations`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L412–415](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L412-L415)
- `catch (SQLException e)` in `seen`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L438–441](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L438-L441)
- `catch (SQLException e)` in `getPeerLastSeen`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L461–464](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L461-L464)
- `catch (SQLException e)` in `getPeerLastSeen`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L488–491](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L488-L491)
- `catch (SQLException e)` in `timeoutPeers`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLPeerCRUD.java:L712–714](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L712-L714)
- `catch (SQLException e)` in `getServerPeersWithQueue`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L736–739](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L736-L739)
- `catch (SQLException e)` in `removePeerByPeerId`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L756–759](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L756-L759)
- `catch (SQLException e)` in `removePeerByPeerId`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L776–779](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L776-L779)
- `catch (SQLException e)` in `loadPeerByInputQueueName`: Propagates `new PersistanceException(e)`. [MySQLPeerCRUD.java:L808–812](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L808-L812)
- Explicit throw in `removePeer`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L110)
- Explicit throw in `isPeerExists`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L136)
- Explicit throw in `isPeerExists`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L155)
- Explicit throw in `createPeer`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L162)
- Explicit throw in `createPeer`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L197](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L197)
- Explicit throw in `loadPeer`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L219)
- Explicit throw in `loadPeerReceiveInfoByDeviceIdAndServerId`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L250](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L250)
- Explicit throw in `loadPeerByAppAndDevice`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L273)
- Explicit throw in `loadPeerIdByAppAndDevice`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L296](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L296)
- Explicit throw in `loadPeerByName`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L318)
- Explicit throw in `registerInPeer`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L357](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L357)
- Explicit throw in `isPeerRegistrationExists`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L375](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L375)
- Explicit throw in `getPeerRegistrations`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L414)
- Explicit throw in `seen`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L440](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L440)
- Explicit throw in `getPeerLastSeen`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L463](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L463)
- Explicit throw in `getPeerLastSeen`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L490](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L490)
- Explicit throw in `getServerPeersWithQueue`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L738](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L738)
- Explicit throw in `removePeerByPeerId`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L758](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L758)
- Explicit throw in `removePeerByPeerId`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L778](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L778)
- Explicit throw in `loadPeerByInputQueueName`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLPeerCRUD.java:L811](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L811)

Source-observed risks/findings (not production incidents):

- loadPeerReceiveInfo L244 assigns maxMessageCount from TTL column 3 rather than selected column 4.
- getServerPeersWithQueue L726 and loadPeerByInputQueueName L796 use if rather than while, returning at most one.
- timeout archive inserts L605/L638 omit required version column in local DDL; schema/trigger unknown.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLPeerCRUD.java:L64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L64) **WARN**, registry `ALOG-0E9B31067EF8`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L108) **ERROR**, registry `ALOG-1E7D96CFD452`; `logger.error("An exception occurred in database, removePeer for appId={} ,deviceId={}", appId, deviceId, e)`. Trigger/RCA: Caught exception in removePeer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L112) **DEBUG**, registry `ALOG-243489B69144`; `logger.debug("remove peer [{}]", peerId)`. Trigger/RCA: Operation phase in removePeer; log position is evidence of reaching this branch, not consumer ACK or end-to-end success.
- [MySQLPeerCRUD.java:L114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L114) **WARN**, registry `ALOG-3A98A500D44D`; `logger.warn("time more than threshold in DATABASE, action=removePeer, connectionTime={}, executionTime={} for appId={} ,deviceId={} ,peerId={}", connectionTime, System.currentTimeMillis() - connectionTime, appId, deviceId, peerId)`. Trigger/RCA: Elapsed wall-clock threshold guard for this operation. Measures code timing rather than proving DB saturation; timing arithmetic must be read at this source site.
- [MySQLPeerCRUD.java:L135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L135) **WARN**, registry `ALOG-F97E481CD130`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in isPeerExists; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L154) **WARN**, registry `ALOG-3DB4B6189B65`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in isPeerExists; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L196) **WARN**, registry `ALOG-DEF4E7912C55`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createPeer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L218) **WARN**, registry `ALOG-6E29BBFB1480`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPeer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L249](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L249) **WARN**, registry `ALOG-46C86DA2374E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPeerReceiveInfoByDeviceIdAndServerId; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L272](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L272) **WARN**, registry `ALOG-4D828ED965D5`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPeerByAppAndDevice; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L295](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L295) **WARN**, registry `ALOG-2BDC87C7D28E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPeerIdByAppAndDevice; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L317) **WARN**, registry `ALOG-46DFAD107A0A`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadPeerByName; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L356](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L356) **WARN**, registry `ALOG-A664AB51CA71`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in registerInPeer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L374](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L374) **WARN**, registry `ALOG-53A03326FA82`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in isPeerRegistrationExists; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L413](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L413) **WARN**, registry `ALOG-77E49F43039F`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getPeerRegistrations; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L439](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L439) **WARN**, registry `ALOG-9E4FFA0902BE`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in seen; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L462](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L462) **WARN**, registry `ALOG-F407935E7582`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getPeerLastSeen; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L489](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L489) **WARN**, registry `ALOG-44FF6DA080EE`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getPeerLastSeen; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L518](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L518) **DEBUG**, registry `ALOG-3D2D1F294098`; `logger.debug("timeout for: {}", row[0])`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L569](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L569) **DEBUG**, registry `ALOG-590A1E0A21F1`; `logger.debug("timeout peers size: {}", size)`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L587](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L587) **DEBUG**, registry `ALOG-904C08F6F069`; `logger.debug("timeout creating message")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L615](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L615) **DEBUG**, registry `ALOG-77DA8DE4DC6E`; `logger.debug("timeout insert archive receiver")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L633](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L633) **DEBUG**, registry `ALOG-E89FC9A7EDA8`; `logger.debug("timeout insert log receiver")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L648](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L648) **DEBUG**, registry `ALOG-25C87513ED06`; `logger.debug("timeout insert archive sender")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L666](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L666) **DEBUG**, registry `ALOG-D9FEDD09D76A`; `logger.debug("timeout insert log sender")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L687](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L687) **DEBUG**, registry `ALOG-ED11013D7EE8`; `logger.debug("timeout delete peer")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L706](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L706) **DEBUG**, registry `ALOG-C6604E044030`; `logger.debug("timeout before commit")`. Trigger/RCA: timeoutPeers phase marker; Settings.LOGGING gates archive/audit phase markers, other phase logs follow current batch execution. A before-commit marker does not prove commit.
- [MySQLPeerCRUD.java:L713](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L713) **WARN**, registry `ALOG-FFD4E7597299`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in timeoutPeers; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L737](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L737) **WARN**, registry `ALOG-F8770AA1143F`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in getServerPeersWithQueue; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L757](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L757) **WARN**, registry `ALOG-2AE1024ECB1F`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removePeerByPeerId; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L777](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L777) **WARN**, registry `ALOG-45B03C3BD453`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in removePeerByPeerId; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLPeerCRUD.java:L803](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L803) **WARN**, registry `ALOG-90B1C30DE558`; `logger.warn("time more than threshold in DATABASE, action=loadPeerByInputQueueName, connectionTime={}, executionTime={} for inputQueueName={}", connectionTime, (System.currentTimeMillis() - time - connectionTime), inputQueueName)`. Trigger/RCA: Elapsed wall-clock threshold guard for this operation. Measures code timing rather than proving DB saturation; timing arithmetic must be read at this source site.
- [MySQLPeerCRUD.java:L809](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L809) **ERROR**, registry `ALOG-20EB6181ABFF`; `logger.error("An exception occurred in database, loadPeerByInputQueueName inputQueueName={}", inputQueueName, e)`. Trigger/RCA: Caught exception in loadPeerByInputQueueName; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 33 active source calls, 33 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlqueuecrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java:1-234"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java:1-234"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java"
---

# MySQLQueueCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLQueueCRUD.java:L1–234](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L1-L234). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Queue persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS queue_registration (. [MySQLQueueCRUD.java:L20–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L20-L46)
- `loadQueueRegistration(QueueRegistration queueRegistration)`: Finds a registration by server URL, input/output queue names, factory and peer, using bound values. Returns first match or null. The lookup omits server_id although schema uniqueness includes it. [MySQLQueueCRUD.java:L49–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L49-L91)
- `createQueueRegistration(QueueRegistration queueRegistration, Integer serverId)`: Rejects a positive ID; inserts version zero, endpoint/queue/factory/username/password/peer/time/type/server and commits. Assigns generated key (MySQL) or sequence ID (Oracle) to input. [MySQLQueueCRUD.java:L94–139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L94-L139)
- `listQueueRegistration(Integer serverId)`: The server-only overload starts at ID zero. The cursor overload loads id > lastId for the server, ordered by ID, with no row limit. [MySQLQueueCRUD.java:L142–144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L142-L144)
- `listQueueRegistration(long lastId, Integer serverId)`: The server-only overload starts at ID zero. The cursor overload loads id > lastId for the server, ordered by ID, with no row limit. [MySQLQueueCRUD.java:L147–183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L147-L183)
- `getQueueRegistration(ResultSet rs)`: Maps the ResultSet into registration fields including credentials; returns a new registration and lets SQLException propagate. [MySQLQueueCRUD.java:L185–199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L185-L199)
- `deleteQueueRegistration(QueueRegistration queueRegistration)`: Deletes by ID AND version; zero affected rows throws PersistanceException("row was deleted or updated in another session"). Commit follows positive deletion. [MySQLQueueCRUD.java:L202–229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L202-L229)
- `main(String[] args)`: Invokes private schema initializer; instance main is not a standard JVM entrypoint. No production startup invocation is proven. [MySQLQueueCRUD.java:L231–233](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L231-L233)

Relational dependencies observed in string SQL: `IF`, `queue_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/QueueCRUD.java: [QueueCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L18).

Consumer boundary: [QueueCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L1-L43). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: stores broker URL, queue names, credentials and peer bindings for queue registration and restoration. Delete respects ID/version conflict. Persisting a broker password does not establish external broker connectivity.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLQueueCRUD.java:L43–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L43-L45)
- `catch (SQLException e)` in `loadQueueRegistration`: Propagates `new PersistanceException(e)`. [MySQLQueueCRUD.java:L87–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L87-L90)
- `catch (SQLException e)` in `createQueueRegistration`: Propagates `new PersistanceException(e)`. [MySQLQueueCRUD.java:L135–138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L135-L138)
- `catch (SQLException e)` in `listQueueRegistration`: Propagates `new PersistanceException(e)`. [MySQLQueueCRUD.java:L179–182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L179-L182)
- `catch (SQLException e)` in `deleteQueueRegistration`: Propagates `new PersistanceException(e)`. [MySQLQueueCRUD.java:L225–228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L225-L228)
- Explicit throw in `loadQueueRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L89)
- Explicit throw in `createQueueRegistration`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L96)
- Explicit throw in `createQueueRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L137)
- Explicit throw in `listQueueRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L181](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L181)
- Explicit throw in `deleteQueueRegistration`: `new PersistanceException("row was deleted or updated in another session")`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L216)
- Explicit throw in `deleteQueueRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLQueueCRUD.java:L227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L227)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLQueueCRUD.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L44) **WARN**, registry `ALOG-4BA5DC3F1CE8`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLQueueCRUD.java:L88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L88) **WARN**, registry `ALOG-715385CA2A72`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadQueueRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLQueueCRUD.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L136) **WARN**, registry `ALOG-846B25749F42`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createQueueRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLQueueCRUD.java:L180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L180) **WARN**, registry `ALOG-051F43CF528D`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listQueueRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLQueueCRUD.java:L226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L226) **WARN**, registry `ALOG-91B5721EF329`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in deleteQueueRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 5 active source calls, 5 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlratelimitcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:1-565"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:1-565"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java"
---

# MySQLRateLimitCrud

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLRateLimitCrud.java:L1–565](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L1-L565). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and RateLimit persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE SEQUENCE provider_seq  CREATE TABLE provider ( CREATE UNIQUE INDEX provider_unq_inx ON  provider (name ASC) CREATE TABLE provider_config ( CREATE UNIQUE INDEX provider_config_unq_inx ON provider_config (provider_id ASC, server_id ASC)  CREATE TABLE endpoint_config ( CREATE UNIQUE INDEX endpoint_config_unq_inx ON endpoint_config (provider_id ASC, server_id ASC, endpoint ASC) . [MySQLRateLimitCrud.java:L29–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L29-L68)
- `loadBlockedProviders(int serverId)`: Joins provider_config to provider for server and is_block=1, mapping peer ID to provider name in a ConcurrentHashMap. Duplicate peer IDs overwrite. [MySQLRateLimitCrud.java:L71–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L71-L89)
- `loadEndpointConfigs(int serverId)`: Reads server-scoped endpoint limits/watch flags; constructs EndpointConfig and keys by provider + underscore + path. The delimiter is not escaped and collisions are possible. [MySQLRateLimitCrud.java:L92–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L92-L114)
- `updateEndpointConfig(String providerName, String path, int blockCount, int serverId)`: MERGE uses provider name to resolve provider ID and server/path as composite identity. Integer overload updates block_count or inserts watch=0; boolean overload updates has_watch or inserts block_count=0. Zero rows warns; commit still occurs. [MySQLRateLimitCrud.java:L117–147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L117-L147)
- `updateEndpointConfig(String providerName, String path, boolean hasWatch, int serverId)`: MERGE uses provider name to resolve provider ID and server/path as composite identity. Integer overload updates block_count or inserts watch=0; boolean overload updates has_watch or inserts block_count=0. Zero rows warns; commit still occurs. [MySQLRateLimitCrud.java:L150–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L150-L180)
- `blockProvider(String providerName, int serverId)`: MERGE marks provider blocked per server; missing provider gives zero rows and throws HttpException("provider not found",404), before commit. [MySQLRateLimitCrud.java:L183–210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L183-L210)
- `unblockProvider(String providerName, int serverId)`: Deletes provider_config row(s) for the named provider/server, removing the config rather than toggling one flag; commits. [MySQLRateLimitCrud.java:L213–231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L213-L231)
- `loadBusinessMap()`: Reads BUSINESS.business_id/name into a ConcurrentHashMap globally; duplicate keys overwrite. [MySQLRateLimitCrud.java:L234–249](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L234-L249)
- `blockBusiness(String businessId, int serverId)`: MERGE sets is_block=1 for business/server. Oracle new rows additionally receive is_watch=0; MySQL new rows omit is_watch. Zero rows warns, with no explicit failure result. [MySQLRateLimitCrud.java:L252–277](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L252-L277)
- `unblockBusiness(String businessId, int serverId)`: Oracle updates is_block=0, preserving is_watch. MySQL deletes the entire business_config row, also removing watch configuration. [MySQLRateLimitCrud.java:L280–298](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L280-L298)
- `watchBusiness(String businessId, int serverId)`: MERGE sets is_watch=1; missing row starts with is_block=0. Its WARN/ERROR messages incorrectly refer to blockBusiness. [MySQLRateLimitCrud.java:L301–326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L301-L326)
- `unwatchBusiness(String businessId, int serverId)`: Oracle updates is_watch=0. MySQL instead updates is_block=0, leaving watch untouched. Its logs refer to unblockBusiness, obscuring the actual command. [MySQLRateLimitCrud.java:L329–348](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L329-L348)
- `loadBlockedBusiness(int serverId)`: Loads server-scoped is_block=1 business IDs into ConcurrentHashSet. [MySQLRateLimitCrud.java:L351–368](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L351-L368)
- `loadBusinessConfigs(int serverId)`: Loads business ID and is_block/is_watch for the server, producing BusinessConfig keyed by business ID. [MySQLRateLimitCrud.java:L371–391](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L371-L391)
- `loadBusinessProviderConfigs(int serverId)`: Joins business_provider_config to peer for server; produces configs keyed business ID + underscore + provider name. Its catch template says loadBusinessConfigs. [MySQLRateLimitCrud.java:L394–416](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L394-L416)
- `updateBusinessConfig(String businessId, long providerPeerId, int blockCount, int serverId)`: MERGE upserts block_count for business ID, provider peer ID and server; zero rows warns and still commits. [MySQLRateLimitCrud.java:L419–449](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L419-L449)
- `loadIpAddressConfigs(int serverId)`: Loads server-scoped IP and is_block into IPAddressConfig map keyed by IP; no normalization occurs here. [MySQLRateLimitCrud.java:L452–471](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L452-L471)
- `loadIpAddressList()`: Reads global IP_ADDRESS entries into ConcurrentHashSet, without server restriction. [MySQLRateLimitCrud.java:L474–489](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L474-L489)
- `blockIpAddress(String ip, int serverId)`: MERGE sets is_block=1 by IP/server. Oracle inserts source.ip_address; MySQL insert incorrectly references source.business_id, absent from the source projection. [MySQLRateLimitCrud.java:L492–517](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L492-L517)
- `unblockIpAddress(String ip, int serverId)`: Sets is_block=0 for IP/server, preserving the row; no affected-row validation. [MySQLRateLimitCrud.java:L520–539](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L520-L539)
- `loadRateLimitConfig()`: Reads global key/capacity/refill/permanent-block/count-threshold and creates RateLimitConfig with zero initial timestamp/counter and AtomicLong(0). Runtime usage counts are not loaded from DB. [MySQLRateLimitCrud.java:L542–564](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L542-L564)

Relational dependencies observed in string SQL: `BUSINESS`, `IP_ADDRESS`, `RATE_LIMIT_CONFIG`, `business_config`, `business_provider_config`, `endpoint_config`, `ip_address_config`, `peer`, `provider`, `provider_config`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/RateLimitCrud.java: [RateLimitCrud.java:L22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L22).

Consumer boundary: [RateLimitCrud.java:L1–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L1-L107). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: loads and changes provider/endpoint/business/IP blocking, watch state and token/config parameters per server (some catalog/config queries global). It is the storage/control-plane dependency of limiting; it does not consume tokens or reject traffic itself.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLRateLimitCrud.java:L65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L65-L67)
- `catch (SQLException e)` in `loadBlockedProviders`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L85-L87)
- `catch (SQLException e)` in `loadEndpointConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L110–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L110-L112)
- `catch (SQLException e)` in `updateEndpointConfig`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L142–146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L142-L146)
- `catch (SQLException e)` in `updateEndpointConfig`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L175–179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L175-L179)
- `catch (SQLException e)` in `blockProvider`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L206–209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L206-L209)
- `catch (SQLException e)` in `unblockProvider`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L227–230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L227-L230)
- `catch (SQLException e)` in `loadBusinessMap`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L245–247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L245-L247)
- `catch (SQLException e)` in `blockBusiness`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L273–276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L273-L276)
- `catch (SQLException e)` in `unblockBusiness`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L294–297](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L294-L297)
- `catch (SQLException e)` in `watchBusiness`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L322–325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L322-L325)
- `catch (SQLException e)` in `unwatchBusiness`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L344–347](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L344-L347)
- `catch (SQLException e)` in `loadBlockedBusiness`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L364–366](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L364-L366)
- `catch (SQLException e)` in `loadBusinessConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L387–389](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L387-L389)
- `catch (SQLException e)` in `loadBusinessProviderConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L412–414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L412-L414)
- `catch (SQLException e)` in `updateBusinessConfig`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L444–448](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L444-L448)
- `catch (SQLException e)` in `loadIpAddressConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L467–469](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L467-L469)
- `catch (SQLException e)` in `loadIpAddressList`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L485–487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L485-L487)
- `catch (SQLException e)` in `blockIpAddress`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L513–516](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L513-L516)
- `catch (SQLException e)` in `unblockIpAddress`: Propagates `new PersistanceException(e)`. [MySQLRateLimitCrud.java:L535–538](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L535-L538)
- `catch (SQLException e)` in `loadRateLimitConfig`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLRateLimitCrud.java:L560–562](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L560-L562)
- Explicit throw in `updateEndpointConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L145)
- Explicit throw in `updateEndpointConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L178)
- Explicit throw in `blockProvider`: `new HttpException("provider not found", HttpStatus.SC_NOT_FOUND)`. HTTP status is encoded in this constructor; follow servlet caller for emitted response. [MySQLRateLimitCrud.java:L202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L202)
- Explicit throw in `blockProvider`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L208)
- Explicit throw in `unblockProvider`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L229)
- Explicit throw in `blockBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L275)
- Explicit throw in `unblockBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L296](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L296)
- Explicit throw in `watchBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L324](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L324)
- Explicit throw in `unwatchBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L346](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L346)
- Explicit throw in `updateBusinessConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L447](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L447)
- Explicit throw in `blockIpAddress`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L515](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L515)
- Explicit throw in `unblockIpAddress`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRateLimitCrud.java:L537](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L537)

Source-observed risks/findings (not production incidents):

- SQL is Oracle-style MERGE/dual/NUMBER despite MySQL name; unsupported deployed dialect would affect mutation paths.
- unwatchBusiness L334 clears is_block instead of is_watch; unblockBusiness deletes row (L284), unlike Oracle preserving watch.
- blockIpAddress L501 references source.business_id although source contains ip_address; not-matched branch cannot resolve projected identifier.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

Literal mutation differences: `unwatchBusiness` L333–336 sets `bc.is_block=0`, while `watchBusiness` writes `is_watch=1`; unwatch does not clear the observed watch flag. `blockIpAddress` L497 projects `? as ip_address`, yet L501 inserts `source.business_id`, an unprojected name. These branches differ from Oracle counterpart and require vendor-specific validation, rather than assuming parity from equal interface names.

Evidence: [pinned full class](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java).

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLRateLimitCrud.java:L66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L66) **ERROR**, registry `ALOG-DDDDFB19E4C9`; `logger.error("An exception occurred in database, initialize provider endPoint tables", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L86) **ERROR**, registry `ALOG-B5593A4DC3D2`; `logger.error("An exception occurred in database,loadBlockedProviders for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBlockedProviders; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L111) **ERROR**, registry `ALOG-A06DF1F0818A`; `logger.error("An exception occurred in database,loadEndpointConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadEndpointConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L138) **WARN**, registry `ALOG-B88CBF694E91`; `logger.warn("can not updateEndpointConfig in database for provider={} ,path={} ,blockCount={} ,serverId={}", providerName, path, blockCount, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L143) **ERROR**, registry `ALOG-B7EB2A11204C`; `logger.error("An exception occurred in database,updateEndpointConfig for provider={} ,path={} ,blockCount={} ,serverId={}", providerName, path, blockCount, serverId, e)`. Trigger/RCA: Caught exception in updateEndpointConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L171) **WARN**, registry `ALOG-705305F07B26`; `logger.warn("can not updateEndpointConfig in database for provider={} ,path={} ,hasWatch={} ,serverId={}", providerName, path, hasWatch, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L176) **ERROR**, registry `ALOG-ABB1AF850C70`; `logger.error("An exception occurred in database,updateEndpointConfig for provider={} ,path={} ,hasWatch={} ,serverId={}", providerName, path, hasWatch, serverId, e)`. Trigger/RCA: Caught exception in updateEndpointConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L200) **WARN**, registry `ALOG-B15C2C383CF5`; `logger.warn("can not blockProvider in database for provider={} ,serverId={}", providerName, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L207) **ERROR**, registry `ALOG-0B5DBE6533CA`; `logger.error("An exception occurred in database,blockProvider for provider={} ,serverId={}", providerName, serverId, e)`. Trigger/RCA: Caught exception in blockProvider; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L228) **ERROR**, registry `ALOG-475B586B8282`; `logger.error("An exception occurred in database,unblockProvider for provider={} ,serverId={}", providerName, serverId, e)`. Trigger/RCA: Caught exception in unblockProvider; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L246) **ERROR**, registry `ALOG-369FA06110DC`; `logger.error("An exception occurred in database,loadBusinessMap for serverId={}", Settings.SERVER_ID, e)`. Trigger/RCA: Caught exception in loadBusinessMap; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L269](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L269) **WARN**, registry `ALOG-8162970F68BB`; `logger.warn("can not blockBusiness in database for businessId={} ,serverId={}", businessId, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L274) **ERROR**, registry `ALOG-FD46300E8E69`; `logger.error("An exception occurred in database,blockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in blockBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L295](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L295) **ERROR**, registry `ALOG-7AD48CA24E61`; `logger.error("An exception occurred in database,unblockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in unblockBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L318) **WARN**, registry `ALOG-6DF37B9698E5`; `logger.warn("can not blockBusiness in database for businessId={} ,serverId={}", businessId, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L323](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L323) **ERROR**, registry `ALOG-C6A9D0C4ACE3`; `logger.error("An exception occurred in database,blockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in watchBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L345](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L345) **ERROR**, registry `ALOG-0E484D60AF33`; `logger.error("An exception occurred in database,unblockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in unwatchBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L365](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L365) **ERROR**, registry `ALOG-17FC1112620F`; `logger.error("An exception occurred in database,loadBlockedBusiness for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBlockedBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L388](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L388) **ERROR**, registry `ALOG-A748F7E7E99A`; `logger.error("An exception occurred in database,loadBusinessConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBusinessConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L413](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L413) **ERROR**, registry `ALOG-B885ADA8BA5A`; `logger.error("An exception occurred in database,loadBusinessConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBusinessProviderConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L440](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L440) **WARN**, registry `ALOG-F1A26293A2D2`; `logger.warn("can not updateBusinessConfig in database for businessId={} ,peer_id={} ,blockCount={} ,serverId={}", businessId, providerPeerId, blockCount, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L445](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L445) **ERROR**, registry `ALOG-B3CBB53DF2FD`; `logger.error("An exception occurred in database,updateBusinessConfig for businessId={} ,peer_id={} ,blockCount={} ,serverId={}", businessId, providerPeerId, blockCount, serverId, e)`. Trigger/RCA: Caught exception in updateBusinessConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L468](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L468) **ERROR**, registry `ALOG-E89021456F16`; `logger.error("An exception occurred in database,loadIpAddressConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadIpAddressConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L486](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L486) **ERROR**, registry `ALOG-37608AD45678`; `logger.error("An exception occurred in database,loadIpAddressList for serverId={}", Settings.SERVER_ID, e)`. Trigger/RCA: Caught exception in loadIpAddressList; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L509](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L509) **WARN**, registry `ALOG-EEF1E0A01D08`; `logger.warn("can not blockIpAddress in database for ip={} ,serverId={}", ip, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [MySQLRateLimitCrud.java:L514](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L514) **ERROR**, registry `ALOG-CE550E13BF93`; `logger.error("An exception occurred in database,blockIpAddress for ip={} ,serverId={}", ip, serverId, e)`. Trigger/RCA: Caught exception in blockIpAddress; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L536](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L536) **ERROR**, registry `ALOG-945F19C2BE4F`; `logger.error("An exception occurred in database,unblockIpAddress for ip={} ,serverId={}", ip, serverId, e)`. Trigger/RCA: Caught exception in unblockIpAddress; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRateLimitCrud.java:L561](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L561) **WARN**, registry `ALOG-B528961ADC1B`; `logger.warn("An exception occurred during load rate limit config", e)`. Trigger/RCA: Caught exception in loadRateLimitConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 28 active source calls, 28 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlrestcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java:1-207"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java:1-207"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java"
---

# MySQLRestCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLRestCRUD.java:L1–207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L1-L207). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Rest persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE TABLE IF NOT EXISTS REST_REGISTRATION (. [MySQLRestCRUD.java:L20–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L20-L40)
- `loadRestRegistration(RestRegistration restRegistration)`: Looks up base URL, config-file URL and peer with bound values; first row or null. Does not scope by server. [MySQLRestCRUD.java:L43–73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L43-L73)
- `createRestRegistration(RestRegistration restRegistration, Integer serverId)`: Rejects positive ID, inserts base/config URL, peer, version, server and time; binds server from the input object rather than supplied serverId. Assigns generated key/sequence ID and commits. [MySQLRestCRUD.java:L76–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L76-L110)
- `listRestRegistration(Integer serverId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [MySQLRestCRUD.java:L113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L113-L115)
- `listRestRegistration(long lastId, Integer serverId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [MySQLRestCRUD.java:L118–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L118-L143)
- `listRestRegistration(long lastId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [MySQLRestCRUD.java:L145–169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L145-L169)
- `getRestRegistration(ResultSet rs)`: Reconstructs ID/version/time/peer/base URL/config URL/server ID from a ResultSet; SQL conversion errors propagate. [MySQLRestCRUD.java:L170–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L170-L180)
- `deleteRestRegistration(RestRegistration restRegistration)`: Deletes ID/version pair and throws PersistanceException("row was deleted or updated in another session") on zero rows, otherwise commits. [MySQLRestCRUD.java:L183–202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L183-L202)
- `main(String[] args)`: Invokes private schema initializer; static main can serve as manual JVM entrypoint. No production startup invocation is proven. [MySQLRestCRUD.java:L204–206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L204-L206)

Relational dependencies observed in string SQL: `IF`, `REST_REGISTRATION`, `rest_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

No direct class-name invocation/construction found in archived Java. Interface dispatch can still reach instances; current runtime registration is UNKNOWN.

Consumer boundary: [RestCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L1-L43). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persists REST mediation base/config URLs and peer/server associations used to restore routing. It does not fetch remote config here. Façade vendor support differs from the existence of MySQL implementation.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [MySQLRestCRUD.java:L37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L37-L39)
- `catch (SQLException e)` in `loadRestRegistration`: Propagates `new PersistanceException(e)`. [MySQLRestCRUD.java:L69–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L69-L72)
- `catch (SQLException e)` in `createRestRegistration`: Propagates `new PersistanceException(e)`. [MySQLRestCRUD.java:L106–109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L106-L109)
- `catch (SQLException e)` in `listRestRegistration`: Propagates `new PersistanceException(e)`. [MySQLRestCRUD.java:L139–142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L139-L142)
- `catch (SQLException e)` in `listRestRegistration`: Propagates `new PersistanceException(e)`. [MySQLRestCRUD.java:L165–168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L165-L168)
- `catch (SQLException e)` in `deleteRestRegistration`: Propagates `new PersistanceException(e)`. [MySQLRestCRUD.java:L198–201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L198-L201)
- Explicit throw in `loadRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L71)
- Explicit throw in `createRestRegistration`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L78)
- Explicit throw in `createRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L108)
- Explicit throw in `listRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L141)
- Explicit throw in `listRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L167)
- Explicit throw in `deleteRestRegistration`: `new PersistanceException("row was deleted or updated in another session")`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L194](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L194)
- Explicit throw in `deleteRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [MySQLRestCRUD.java:L200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L200)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLRestCRUD.java:L38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L38) **WARN**, registry `ALOG-40703BDB5F9A`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRestCRUD.java:L70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L70) **WARN**, registry `ALOG-2F65248F674A`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRestCRUD.java:L107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L107) **WARN**, registry `ALOG-19BD9FCFB08E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRestCRUD.java:L140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L140) **WARN**, registry `ALOG-A406012B8F56`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRestCRUD.java:L166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L166) **WARN**, registry `ALOG-74F0AF6B93FA`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLRestCRUD.java:L199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L199) **WARN**, registry `ALOG-31FD7CBB4653`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in deleteRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 6 active source calls, 6 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-mysqlservicecallcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
review_state: candidate
confidence: medium
sensitivity: internal
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java:1-60"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java:1-60"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java"
---

# MySQLServiceCallCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MySQLServiceCallCRUD.java:L1–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L1-L60). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and ServiceCall persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `loadServiceCallDispatcher()`: Reads all DISPATCHER_KEY/PEER_NAME rows into a HashMap, with duplicate keys replaced by later rows and no cluster/server predicate. [MySQLServiceCallCRUD.java:L21–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L21-L39)
- `loadServiceCallBlocker()`: Reads all BLOCKER_KEY rows into a HashSet; duplicate keys collapse and there is no server predicate. [MySQLServiceCallCRUD.java:L42–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L42-L59)

Relational dependencies observed in string SQL: `SERVICE_CALL_BLOCKER`, `SERVICE_CALL_DISPATCHER`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/ServiceCallCrud.java: [ServiceCallCrud.java:L15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L15).

Consumer boundary: [ServiceCallCrud.java:L1–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L1-L28). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supplies dispatcher-key→peer-name map and blocker-key set for service-call routing decisions. Config load failures can look like absent routing/block entries because errors are swallowed. No request is forwarded in this file.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `loadServiceCallDispatcher`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLServiceCallCRUD.java:L35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L35-L37)
- `catch (SQLException e)` in `loadServiceCallBlocker`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [MySQLServiceCallCRUD.java:L55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L55-L57)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MySQLServiceCallCRUD.java:L36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L36) **WARN**, registry `ALOG-D0759B604E9A`; `logger.warn("An exception occurred during load service call dispatcher config", e)`. Trigger/RCA: Caught exception in loadServiceCallDispatcher; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [MySQLServiceCallCRUD.java:L56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L56) **WARN**, registry `ALOG-654D41224E11`; `logger.warn("An exception occurred during load service call blocker config", e)`. Trigger/RCA: Caught exception in loadServiceCallBlocker; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 2 active source calls, 2 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.
