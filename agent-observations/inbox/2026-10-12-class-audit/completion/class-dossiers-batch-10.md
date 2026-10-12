# Async Java class dossiers — candidate batch 10


---

<!-- source dossier: src/com/nozha/async/server/persistance/ClientCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ClientCRUDInterface.java:1-24"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ClientCRUDInterface.java:1-24"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java"
---

# ClientCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [ClientCRUDInterface.java:L1–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L1-L24). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `addClient(long peerId, long trackerId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L9–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L9-L9)
- `removeClient(long peerId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L11-L11)
- `removeOtherClients(long peerId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L13-L13)
- `removeClients(long peerId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L15-L15)
- `removeClientByTracker(long trackerId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L17–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L17-L17)
- `findReceiverServersByPeer(long receiverPeerId)`: Declares return type `List<Long>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L19–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L19-L19)
- `findReceiverServersByTracker(long trackerId)`: Declares return type `Long` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L21–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L21-L21)
- `resetMapping(int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L23–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUDInterface.java#L23-L23)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java: [OracleClientCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L17).
- src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java: [MySQLClientCRUD.java:L16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L16).

Consumer boundary: [ClientCRUD.java:L1–162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L1-L162). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: records and resolves which server currently hosts a peer/tracker, supporting local/interserver message routing. Removing stale mappings changes candidate destinations; cache fallback can preserve apparent availability without a durable mapping. No proof of exactly-once delivery follows.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/CoapCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/CoapCRUD.java:1-47"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/CoapCRUD.java:1-47"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java"
---

# CoapCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [CoapCRUD.java:L1–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L1-L47). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([CoapCRUD.java:L16–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L16-L26)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `createCoapRegistration(CoapRegistration coapRegistration)`: Returns the result of `coapCRUDInterface.createCoapRegistration(coapRegistration, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L24-L26)
- `listCoapRegistration(long lastId)`: Returns the result of `coapCRUDInterface.listCoapRegistration(lastId, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L28-L30)
- `getCoapRegistration(String clientId)`: Returns the result of `coapCRUDInterface.getCoapRegistration(clientId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L32-L34)
- `getCoapRegistrationWithEndPoint(String clientId)`: Returns the result of `coapCRUDInterface.getCoapRegistrationWithEndPoint(clientId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L36-L38)
- `unregisterCoap(String clientId)`: Returns the result of `coapCRUDInterface.unregisterCoap(clientId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L40-L42)
- `unregisterCoap(List<String> clientsId)`: Invokes `coapCRUDInterface.unregisterCoap(clientsId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLCoapCRUD dossier](impl/MySQLCoapCRUD.md), [OracleCoapCRUD dossier](impl/OracleCoapCRUD.md). [facade:L44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L44-L46)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/handler/CoapHandler.java: [CoapHandler.java:L157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L157), [CoapHandler.java:L165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L165).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L241), [RegistrationManager.java:L285](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L285), [RegistrationManager.java:L293](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L293), [RegistrationManager.java:L296](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L296).

## Business

SOURCE_OBSERVED: persistence for CoAP registration identity and endpoint discovery, consumed through CoapCRUD by registration/transport paths. Creation accepts unassigned registrations; unregister removes reachability metadata rather than closing network sockets here.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/CoapCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/CoapCRUDInterface.java:1-17"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/CoapCRUDInterface.java:1-17"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java"
---

# CoapCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [CoapCRUDInterface.java:L1–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L1-L17). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `createCoapRegistration(CoapRegistration coapRegistration, Integer serverId)`: Declares return type `CoapRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L11-L11)
- `listCoapRegistration(long lastId, Integer serverId)`: Declares return type `List<CoapRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L12–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L12-L12)
- `getCoapRegistration(String clientId)`: Declares return type `CoapRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L13-L13)
- `getCoapRegistrationWithEndPoint(String endPoint)`: Declares return type `CoapRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L14–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L14-L14)
- `unregisterCoap(String clientId)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L15-L15)
- `unregisterCoap(List<String> clientsId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L16-L16)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java: [OracleCoapCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L18).
- src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java: [MySQLCoapCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L17).

Consumer boundary: [CoapCRUD.java:L1–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L1-L47). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persistence for CoAP registration identity and endpoint discovery, consumed through CoapCRUD by registration/transport paths. Creation accepts unassigned registrations; unregister removes reachability metadata rather than closing network sockets here.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/ConnectionFactory.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ConnectionFactory.java:1-84"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ConnectionFactory.java:1-84"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java"
---

# ConnectionFactory

## Technical

Source-reviewed candidate, based on the complete archived file [ConnectionFactory.java:L1–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L1-L84). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Static initialization [ConnectionFactory.java:L23–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L23-L62) creates c3p0 ComboPooledDataSource. MYSQL driver/url includes Unicode utf8mb4, noAccessToProcedureBodies and autoReconnect. ORACLE URL selects SID when DB_SERVICE_NAME is null, service-name form otherwise. Credentials come from Settings. Pool test table/checkout/checkin testing, min/max/acquire increment, unreturned timeout, idle testing and checkout timeout all come from DB_* Settings; autoCommitOnClose is false. PropertyVetoException warns and is swallowed, leaving a datasource that may not be usable. No branch rejects unsupported DB_VENDOR.

Method and branch review:

- `getConnection()`: Returns cpds.getConnection(), exposing SQLException to the caller. The factory does not add retry around checkout. [ConnectionFactory.java:L64–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L64-L77)
- `close()`: Closes pooled datasource if nonnull. There is no recreation guard or shutdown synchronization. [ConnectionFactory.java:L79–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L79-L83)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/Server.java: [Server.java:L1369](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1369).
- src/com/nozha/async/server/persistance/ServiceProviderCrud.java: [ServiceProviderCrud.java:L16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L16), [ServiceProviderCrud.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L18).
- src/com/nozha/async/server/persistance/RestCRUD.java: [RestCRUD.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L19).
- src/com/nozha/async/server/persistance/DeviceCRUD.java: [DeviceCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L17), [DeviceCRUD.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L19).
- src/com/nozha/async/server/persistance/AccessibilityCrud.java: [AccessibilityCrud.java:L15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L15), [AccessibilityCrud.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L17).
- src/com/nozha/async/server/persistance/CoapCRUD.java: [CoapCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L17), [CoapCRUD.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L19).
- src/com/nozha/async/server/persistance/ClientCRUD.java: [ClientCRUD.java:L28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L28), [ClientCRUD.java:L30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L30).
- src/com/nozha/async/server/persistance/PeerCRUD.java: [PeerCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L21), [PeerCRUD.java:L23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L23).
- src/com/nozha/async/server/persistance/MessageCRUD.java: [MessageCRUD.java:L35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L35), [MessageCRUD.java:L37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L37).
- src/com/nozha/async/server/persistance/RateLimitCrud.java: [RateLimitCrud.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L21), [RateLimitCrud.java:L23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L23).
- src/com/nozha/async/server/persistance/QueueCRUD.java: [QueueCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L17), [QueueCRUD.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L19).
- src/com/nozha/async/server/persistance/ServiceCallCrud.java: [ServiceCallCrud.java:L14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L14), [ServiceCallCrud.java:L16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L16).
- src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java: [RabbitMQAMQPQueueClient.java:L33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L33).
- src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java: [MySQLPeerCRUD.java:L31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L31), [MySQLPeerCRUD.java:L73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L73), [MySQLPeerCRUD.java:L123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L123), [MySQLPeerCRUD.java:L143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L143), [MySQLPeerCRUD.java:L165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L165), [MySQLPeerCRUD.java:L204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L204), [MySQLPeerCRUD.java:L225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L225), [MySQLPeerCRUD.java:L257](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L257), [MySQLPeerCRUD.java:L280](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L280), [MySQLPeerCRUD.java:L303](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L303), [MySQLPeerCRUD.java:L340](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L340), [MySQLPeerCRUD.java:L363](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L363), [MySQLPeerCRUD.java:L381](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L381), [MySQLPeerCRUD.java:L420](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L420), [MySQLPeerCRUD.java:L447](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L447), [MySQLPeerCRUD.java:L472](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L472), [MySQLPeerCRUD.java:L500](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L500), [MySQLPeerCRUD.java:L520](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L520), [MySQLPeerCRUD.java:L571](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L571), [MySQLPeerCRUD.java:L719](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L719), [MySQLPeerCRUD.java:L743](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L743), [MySQLPeerCRUD.java:L764](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L764), [MySQLPeerCRUD.java:L785](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L785).
- src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java: [MySQLMessageCRUD.java:L27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L27), [MySQLMessageCRUD.java:L125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L125), [MySQLMessageCRUD.java:L150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L150), [MySQLMessageCRUD.java:L225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L225), [MySQLMessageCRUD.java:L271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L271), [MySQLMessageCRUD.java:L325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L325), [MySQLMessageCRUD.java:L519](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L519), [MySQLMessageCRUD.java:L531](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L531), [MySQLMessageCRUD.java:L542](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L542), [MySQLMessageCRUD.java:L650](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L650), [MySQLMessageCRUD.java:L695](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L695), [MySQLMessageCRUD.java:L726](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L726), [MySQLMessageCRUD.java:L755](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L755), [MySQLMessageCRUD.java:L806](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L806), [MySQLMessageCRUD.java:L847](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L847), [MySQLMessageCRUD.java:L887](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L887), [MySQLMessageCRUD.java:L913](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L913), [MySQLMessageCRUD.java:L958](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L958).
- src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java: [OracleRestCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L21), [OracleRestCRUD.java:L54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L54), [OracleRestCRUD.java:L90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L90), [OracleRestCRUD.java:L135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L135), [OracleRestCRUD.java:L162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L162), [OracleRestCRUD.java:L200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L200).
- src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java: [OracleClientCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L21), [OracleClientCRUD.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L46), [OracleClientCRUD.java:L75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L75), [OracleClientCRUD.java:L102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L102), [OracleClientCRUD.java:L129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L129), [OracleClientCRUD.java:L154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L154), [OracleClientCRUD.java:L180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L180), [OracleClientCRUD.java:L207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L207), [OracleClientCRUD.java:L233](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L233).
- src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java: [OraclePeerCRUD.java:L31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L31), [OraclePeerCRUD.java:L79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L79), [OraclePeerCRUD.java:L129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L129), [OraclePeerCRUD.java:L154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L154), [OraclePeerCRUD.java:L180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L180), [OraclePeerCRUD.java:L228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L228), [OraclePeerCRUD.java:L254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L254), [OraclePeerCRUD.java:L292](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L292), [OraclePeerCRUD.java:L319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L319), [OraclePeerCRUD.java:L347](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L347), [OraclePeerCRUD.java:L390](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L390), [OraclePeerCRUD.java:L418](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L418), [OraclePeerCRUD.java:L442](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L442), [OraclePeerCRUD.java:L487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L487), [OraclePeerCRUD.java:L521](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L521), [OraclePeerCRUD.java:L551](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L551), [OraclePeerCRUD.java:L585](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L585), [OraclePeerCRUD.java:L606](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L606), [OraclePeerCRUD.java:L657](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L657), [OraclePeerCRUD.java:L800](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L800), [OraclePeerCRUD.java:L831](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L831), [OraclePeerCRUD.java:L858](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L858), [OraclePeerCRUD.java:L884](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L884).
- src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java: [MySQLAccessibilityCRUD.java:L24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L24), [MySQLAccessibilityCRUD.java:L53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L53).
- src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java: [OracleServiceCallCRUD.java:L23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L23), [OracleServiceCallCRUD.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L44).
- src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java: [MySQLClientCRUD.java:L20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L20), [MySQLClientCRUD.java:L42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L42), [MySQLClientCRUD.java:L65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L65), [MySQLClientCRUD.java:L86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L86), [MySQLClientCRUD.java:L107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L107), [MySQLClientCRUD.java:L127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L127), [MySQLClientCRUD.java:L149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L149), [MySQLClientCRUD.java:L171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L171), [MySQLClientCRUD.java:L192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L192).
- src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java: [MySQLQueueCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L21), [MySQLQueueCRUD.java:L53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L53), [MySQLQueueCRUD.java:L101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L101), [MySQLQueueCRUD.java:L151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L151), [MySQLQueueCRUD.java:L206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L206).
- src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java: [OracleCoapCRUD.java:L23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L23), [OracleCoapCRUD.java:L56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L56), [OracleCoapCRUD.java:L102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L102), [OracleCoapCRUD.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L136), [OracleCoapCRUD.java:L169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L169), [OracleCoapCRUD.java:L202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L202), [OracleCoapCRUD.java:L230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L230).
- src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java: [OracleAccessibilityCRUD.java:L24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java#L24), [OracleAccessibilityCRUD.java:L53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java#L53).
- src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java: [MySQLServiceCallCRUD.java:L23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L23), [MySQLServiceCallCRUD.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L44).
- src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java: [OracleQueueCRUD.java:L22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L22), [OracleQueueCRUD.java:L54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L54), [OracleQueueCRUD.java:L99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L99), [OracleQueueCRUD.java:L153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L153), [OracleQueueCRUD.java:L207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L207).
- src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java: [OracleServiceProviderCrud.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L21), [OracleServiceProviderCrud.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L46), [OracleServiceProviderCrud.java:L133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L133), [OracleServiceProviderCrud.java:L178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L178), [OracleServiceProviderCrud.java:L225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L225).
- src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java: [MySQLRateLimitCrud.java:L30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L30), [MySQLRateLimitCrud.java:L73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L73), [MySQLRateLimitCrud.java:L94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L94), [MySQLRateLimitCrud.java:L118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L118), [MySQLRateLimitCrud.java:L151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L151), [MySQLRateLimitCrud.java:L184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L184), [MySQLRateLimitCrud.java:L214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L214), [MySQLRateLimitCrud.java:L236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L236), [MySQLRateLimitCrud.java:L253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L253), [MySQLRateLimitCrud.java:L281](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L281), [MySQLRateLimitCrud.java:L302](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L302), [MySQLRateLimitCrud.java:L330](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L330), [MySQLRateLimitCrud.java:L353](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L353), [MySQLRateLimitCrud.java:L373](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L373), [MySQLRateLimitCrud.java:L396](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L396), [MySQLRateLimitCrud.java:L420](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L420), [MySQLRateLimitCrud.java:L454](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L454), [MySQLRateLimitCrud.java:L476](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L476), [MySQLRateLimitCrud.java:L493](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L493), [MySQLRateLimitCrud.java:L521](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L521), [MySQLRateLimitCrud.java:L544](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L544).
- src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java: [MySQLCoapCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L21), [MySQLCoapCRUD.java:L54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L54), [MySQLCoapCRUD.java:L96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L96), [MySQLCoapCRUD.java:L129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L129), [MySQLCoapCRUD.java:L156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L156), [MySQLCoapCRUD.java:L183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L183), [MySQLCoapCRUD.java:L204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L204).
- src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java: [MySQLServiceProviderCrud.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L21), [MySQLServiceProviderCrud.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L46), [MySQLServiceProviderCrud.java:L133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L133), [MySQLServiceProviderCrud.java:L178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L178), [MySQLServiceProviderCrud.java:L225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L225).
- src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java: [OracleDeviceCRUD.java:L22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L22), [OracleDeviceCRUD.java:L56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L56), [OracleDeviceCRUD.java:L102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L102), [OracleDeviceCRUD.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L136), [OracleDeviceCRUD.java:L169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L169), [OracleDeviceCRUD.java:L202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L202), [OracleDeviceCRUD.java:L230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L230), [OracleDeviceCRUD.java:L255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L255).
- src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java: [MySQLRestCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L21), [MySQLRestCRUD.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L44), [MySQLRestCRUD.java:L80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L80), [MySQLRestCRUD.java:L119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L119), [MySQLRestCRUD.java:L146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L146), [MySQLRestCRUD.java:L184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L184).
- src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java: [OracleRateLimitCrud.java:L30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L30), [OracleRateLimitCrud.java:L73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L73), [OracleRateLimitCrud.java:L94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L94), [OracleRateLimitCrud.java:L118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L118), [OracleRateLimitCrud.java:L151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L151), [OracleRateLimitCrud.java:L184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L184), [OracleRateLimitCrud.java:L214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L214), [OracleRateLimitCrud.java:L236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L236), [OracleRateLimitCrud.java:L253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L253), [OracleRateLimitCrud.java:L281](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L281), [OracleRateLimitCrud.java:L303](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L303), [OracleRateLimitCrud.java:L331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L331), [OracleRateLimitCrud.java:L354](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L354), [OracleRateLimitCrud.java:L374](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L374), [OracleRateLimitCrud.java:L397](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L397), [OracleRateLimitCrud.java:L421](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L421), [OracleRateLimitCrud.java:L455](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L455), [OracleRateLimitCrud.java:L477](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L477), [OracleRateLimitCrud.java:L494](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L494), [OracleRateLimitCrud.java:L522](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L522), [OracleRateLimitCrud.java:L545](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L545).
- src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java: [MySQLDeviceCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L21), [MySQLDeviceCRUD.java:L55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L55), [MySQLDeviceCRUD.java:L97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L97), [MySQLDeviceCRUD.java:L130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L130), [MySQLDeviceCRUD.java:L157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L157), [MySQLDeviceCRUD.java:L184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L184), [MySQLDeviceCRUD.java:L205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L205), [MySQLDeviceCRUD.java:L224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L224).
- src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java: [OracleMessageCRUD.java:L28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L28), [OracleMessageCRUD.java:L127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L127), [OracleMessageCRUD.java:L236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L236), [OracleMessageCRUD.java:L287](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L287), [OracleMessageCRUD.java:L338](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L338), [OracleMessageCRUD.java:L535](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L535), [OracleMessageCRUD.java:L553](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L553), [OracleMessageCRUD.java:L569](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L569), [OracleMessageCRUD.java:L687](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L687), [OracleMessageCRUD.java:L736](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L736), [OracleMessageCRUD.java:L773](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L773), [OracleMessageCRUD.java:L807](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L807), [OracleMessageCRUD.java:L863](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L863), [OracleMessageCRUD.java:L908](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L908), [OracleMessageCRUD.java:L942](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L942), [OracleMessageCRUD.java:L972](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L972), [OracleMessageCRUD.java:L1000](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L1000), [OracleMessageCRUD.java:L1027](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L1027).

## Business

SOURCE_OBSERVED: relational connection pool underlies registration, message and configuration persistence. Checkout bounds affect waiting callers but their deployed values and SLA are unknown; closing disables this datasource.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (PropertyVetoException e)` in `static initialization`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ConnectionFactory.java:L59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L59-L61)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [ConnectionFactory.java:L60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ConnectionFactory.java#L60) **WARN**, registry `ALOG-89A3B94E5C2E`; `logger.warn("An exception occurred, can not create connection factory", e)`. Trigger/RCA: Caught exception in initializer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 1 active source calls, 1 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/DeviceCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/DeviceCRUD.java:1-51"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/DeviceCRUD.java:1-51"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java"
---

# DeviceCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [DeviceCRUD.java:L1–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L1-L51). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([DeviceCRUD.java:L16–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L16-L26)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `createDeviceRegistration(DeviceRegistration deviceRegistration)`: Returns the result of `deviceCRUDInterface.createDeviceRegistration(deviceRegistration, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L24-L26)
- `listDeviceRegistration(long lastId)`: Returns the result of `deviceCRUDInterface.listDeviceRegistration(lastId, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L28-L30)
- `getDeviceRegistration(String clientId)`: Returns the result of `deviceCRUDInterface.getDeviceRegistration(clientId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L32-L34)
- `getDeviceRegistrationByInputQueue(String inputQueue)`: Returns the result of `deviceCRUDInterface.getDeviceRegistrationByInputQueue(inputQueue)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L36-L38)
- `unregisterDevice(String clientId)`: Returns the result of `deviceCRUDInterface.unregisterDevice(clientId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L40-L42)
- `unregisterDevice(List<String> clientsId)`: Invokes `deviceCRUDInterface.unregisterDevice(clientsId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L44-L46)
- `getPeerIdsByClientId(List<String> clientsId)`: Returns the result of `deviceCRUDInterface.getPeerIdsByClientId(clientsId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLDeviceCRUD dossier](impl/MySQLDeviceCRUD.md), [OracleDeviceCRUD dossier](impl/OracleDeviceCRUD.md). [facade:L48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L48-L50)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/handler/MqttHandler.java: [MqttHandler.java:L159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L159), [MqttHandler.java:L303](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L303), [MqttHandler.java:L304](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L304).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L231), [RegistrationManager.java:L251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L251), [RegistrationManager.java:L254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L254), [RegistrationManager.java:L262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L262), [RegistrationManager.java:L265](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L265), [RegistrationManager.java:L282](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L282).

## Business

SOURCE_OBSERVED: persists device client-to-peer and input-queue associations. Listing supports server registration restoration/polling; batch removal and queue lookup change which peer identities can be resolved. This class does not authenticate clients.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/DeviceCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java:1-18"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java:1-18"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java"
---

# DeviceCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [DeviceCRUDInterface.java:L1–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L1-L18). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `createDeviceRegistration(DeviceRegistration deviceRegistration, Integer serverId)`: Declares return type `DeviceRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L11-L11)
- `listDeviceRegistration(long lastId, Integer serverId)`: Declares return type `List<DeviceRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L12–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L12-L12)
- `getDeviceRegistration(String clientId)`: Declares return type `DeviceRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L13-L13)
- `getDeviceRegistrationByInputQueue(String inputQueue)`: Declares return type `List<DeviceRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L14–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L14-L14)
- `unregisterDevice(String clientId)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L15-L15)
- `unregisterDevice(List<String> clientsId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L16-L16)
- `getPeerIdsByClientId(List<String> clientsId)`: Declares return type `List<Long>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L17–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L17-L17)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java: [OracleDeviceCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L18).
- src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java: [MySQLDeviceCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L17).

Consumer boundary: [DeviceCRUD.java:L1–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L1-L51). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persists device client-to-peer and input-queue associations. Listing supports server registration restoration/polling; batch removal and queue lookup change which peer identities can be resolved. This class does not authenticate clients.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/MessageCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/MessageCRUD.java:1-136"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/MessageCRUD.java:1-136"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java"
---

# MessageCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [MessageCRUD.java:L1–136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L1-L136). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([MessageCRUD.java:L34–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L34-L44)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Constants [MessageCRUD.java:L24–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L24-L30) assign operations CREATE=1, CHANGE_STATUS=2, ARCHIVE=3, COLLAPSE=4, EXPIRED=5, TIMEOUT=6, RETRY=7 for relational audit. Executor and usage threshold are static ([MessageCRUD.java:L21–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L21-L22)), configured once, with shared asynchronous mutable Message references and no copying.

Method and branch review:

- `getNextMessageId()`: Returns the result of `messageCRUDInterface.getNextMessageId()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L42-L44)
- `create(Message message)`: Resolves receiver server with ClientCRUD.findReceiverServer then delegates; connection overload propagates SQLException and inherits caller transaction. [MessageCRUD.java:L46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L46-L48)
- `createAsyncActiveMessage(Message message)`: Only with IS_INSERT_TO_DB_ENABLE submits createActiveMessage to fixed thread pool. getTaskCount > configured threshold logs and silently does not submit; counter is cumulative, not queue occupancy. Unobserved Future separates worker exceptions from caller. Active-count >= size*usage/100 emits ERROR usage warning independently of acceptance. No shutdown method exists. [MessageCRUD.java:L50–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L50-L63)
- `createSyncActiveMessage(Message message)`: Only with IS_INSERT_TO_DB_ENABLE calls createActiveMessage; otherwise returns null. Implementation may return input after SQL failure, so nonnull is not a persistence receipt. [MessageCRUD.java:L65–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L65-L71)
- `create(Message message, Connection connection)`: Resolves receiver server with ClientCRUD.findReceiverServer then delegates; connection overload propagates SQLException and inherits caller transaction. [MessageCRUD.java:L73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L73-L75)
- `loadCollapseMessage(long collapseId, long senderId, long receiverId)`: Returns the result of `messageCRUDInterface.loadCollapseMessage(collapseId, senderId, receiverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L77-L79)
- `loadMessageByStatus(int status, int count)`: Returns the result of `messageCRUDInterface.loadMessageByStatus(status, count, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L81-L83)
- `loadPendingMessage(int count)`: Returns the result of `messageCRUDInterface.loadPendingMessage(count, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L85-L87)
- `archive(Message message)`: Invokes `messageCRUDInterface.archive(message)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L89-L91)
- `archiveAll(List<Message> messages)`: Invokes `messageCRUDInterface.archiveAll(messages)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L93-L95)
- `archiveAckMsg(long receiver, long id)`: Returns the result of `messageCRUDInterface.archiveAckMsg(receiver, id)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L97-L99)
- `archive(Message message, Connection connection, boolean ignoreVersion)`: Invokes `messageCRUDInterface.archive(message, connection, ignoreVersion)`. Passes caller-owned connection through. Declared SQLException propagates without local conversion. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L101-L103)
- `changeStatus(Message message, int status)`: Invokes `messageCRUDInterface.changeStatus(message, status)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L105-L107)
- `updatePendingMessageRetryTime(Message message, long time)`: Invokes `messageCRUDInterface.updatePendingMessageRetryTime(message, time)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L109-L111)
- `updateCollapsedMessage(Message message)`: Invokes `messageCRUDInterface.updateCollapsedMessage(message)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L113-L115)
- `updateCollapsedMessage(Message message, boolean sync)`: Invokes `messageCRUDInterface.updateCollapsedMessage(message, sync)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L117–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L117-L119)
- `collapseMessages()`: Invokes `messageCRUDInterface.collapseMessages(Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L121–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L121-L123)
- `loadNotSentMessages(long receiverId)`: Returns the result of `messageCRUDInterface.loadNotSentMessages(receiverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L125–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L125-L127)
- `deleteExpiredMessages()`: Invokes `messageCRUDInterface.deleteExpiredMessages(Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L129-L131)
- `changeStatus(long id, int status)`: Invokes `messageCRUDInterface.changeStatus(id, status)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLMessageCRUD dossier](impl/MySQLMessageCRUD.md), [OracleMessageCRUD dossier](impl/OracleMessageCRUD.md). [facade:L133–135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L133-L135)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/Server.java: [Server.java:L800](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L800), [Server.java:L853](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L853), [Server.java:L856](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L856), [Server.java:L863](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L863), [Server.java:L866](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L866).
- src/com/nozha/async/server/biz/MessageManager.java: [MessageManager.java:L150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L150), [MessageManager.java:L225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L225), [MessageManager.java:L242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L242), [MessageManager.java:L247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L247), [MessageManager.java:L258](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L258), [MessageManager.java:L259](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L259), [MessageManager.java:L287](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L287), [MessageManager.java:L336](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L336), [MessageManager.java:L338](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L338), [MessageManager.java:L342](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L342), [MessageManager.java:L353](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L353), [MessageManager.java:L357](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L357), [MessageManager.java:L367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L367), [MessageManager.java:L371](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L371), [MessageManager.java:L386](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L386), [MessageManager.java:L401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L401), [MessageManager.java:L408](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L408), [MessageManager.java:L414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L414), [MessageManager.java:L416](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L416), [MessageManager.java:L422](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L422), [MessageManager.java:L427](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L427), [MessageManager.java:L431](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L431), [MessageManager.java:L436](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L436), [MessageManager.java:L571](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L571).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L150), [RegistrationManager.java:L192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L192), [RegistrationManager.java:L221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L221).
- src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java: [MySQLPeerCRUD.java:L626](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L626), [MySQLPeerCRUD.java:L659](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L659), [MySQLPeerCRUD.java:L701](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L701).
- src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java: [MySQLMessageCRUD.java:L201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L201), [MySQLMessageCRUD.java:L558](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L558), [MySQLMessageCRUD.java:L627](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L627), [MySQLMessageCRUD.java:L681](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L681), [MySQLMessageCRUD.java:L708](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L708), [MySQLMessageCRUD.java:L742](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L742), [MySQLMessageCRUD.java:L777](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L777), [MySQLMessageCRUD.java:L868](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L868), [MySQLMessageCRUD.java:L945](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L945).
- src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java: [OraclePeerCRUD.java:L708](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L708), [OraclePeerCRUD.java:L735](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L735), [OraclePeerCRUD.java:L777](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L777).
- src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java: [OracleMessageCRUD.java:L25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L25), [OracleMessageCRUD.java:L204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L204), [OracleMessageCRUD.java:L586](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L586), [OracleMessageCRUD.java:L658](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L658), [OracleMessageCRUD.java:L718](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L718), [OracleMessageCRUD.java:L750](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L750), [OracleMessageCRUD.java:L790](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L790), [OracleMessageCRUD.java:L830](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L830), [OracleMessageCRUD.java:L928](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L928), [OracleMessageCRUD.java:L1057](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L1057).
- src/com/nozha/async/server/activemq/local/AsyncProducer.java: [AsyncProducer.java:L59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L59), [AsyncProducer.java:L63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L63).

## Business

SOURCE_OBSERVED: supports pending delivery storage, retry eligibility, collapse replacement, ACK archival and expiry maintenance. Relational rows, enqueue acceptance and transport delivery are distinct stages; source alone approves neither retention SLA nor delivery guarantee. Triggering actors are Server/MessageManager/AsyncProducer and maintenance paths.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

Reconciliation: generated-knowledge/flows/message-delivery-flow.md already separates delivery, ACK and persistence guarantees; this dossier adds concrete SQL/transaction branches. generated-knowledge/observability/adr-async-db-persistence-overload.md remains a proposed policy; its cumulative-counter observation matches MessageCRUD, but that document’s isolated test is not a runtime test performed by this audit.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Source-observed risks/findings (not production incidents):

- Cumulative getTaskCount threshold can permanently skip submissions in a long-lived executor; source confirms previous ADR candidate. Future is never inspected and no explicit rejection result exists.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [MessageCRUD.java:L53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L53) **ERROR**, registry `ALOG-D10FCB5AE889`; `logger.error("Async DB ThreadPool task size more than threshold, taskCount={}, messageId={}, sender={}, receiver={}", executorService.getTaskCount(), message.getId(), message.getSender(), message.getReceiver())`. Trigger/RCA: IS_INSERT_TO_DB_ENABLE and cumulative taskCount above ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE; submission skipped. Message/sender/receiver fields correlate the skipped attempt, not DB persistence.
- [MessageCRUD.java:L59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L59) **ERROR**, registry `ALOG-0753369E793E`; `logger.error("Async DB ThreadPool is almost full. messageId ={}, sender={}, receiver={}, ActiveThreadCount={} ,MaximumPoolSize={}, usage={}% ", message.getId(), message.getSender(), message.getReceiver(), executorService.getActiveCount(), executorService.getMaximumPoolSize(), threadPoolUsage)`. Trigger/RCA: Insertion enabled and active worker count >= configured usage threshold; emitted whether or not submission was accepted.

Reconciliation: 2 active source calls, 2 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/MessageCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/MessageCRUDInterface.java:1-49"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/MessageCRUDInterface.java:1-49"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java"
---

# MessageCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [MessageCRUDInterface.java:L1–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L1-L49). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `getNextMessageId()`: Declares return type `long` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L13-L13)
- `create(Message message, Integer serverId)`: Declares return type `Message` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L14–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L14-L14)
- `create(Message message, Connection connection, Integer serverId)`: Declares return type `Message` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L15-L15)
- `createActiveMessage(Message message)`: Declares return type `Message` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L16-L16)
- `loadCollapseMessage(long collapseId, long senderId, long receiverId)`: Declares return type `Message` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L17–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L17-L17)
- `loadMessageByStatus(int status, int count, Integer serverId)`: Declares return type `List<Message>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L19–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L19-L19)
- `loadPendingMessage(int count, Integer serverId)`: Declares return type `List<Message>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L21–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L21-L21)
- `archive(Message message)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L23–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L23-L23)
- `archiveAll(List<Message> messages)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L25–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L25-L25)
- `archiveAckMsg(long receiver, long id)`: Declares return type `Message` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L27–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L27-L27)
- `archive(Message message, Connection connection, boolean ignoreVersion)`: Declares return type `void` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L29–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L29-L29)
- `archiveAll(List<Message> messages, Connection connection, boolean ignoreVersion)`: Declares return type `void` and inputs shown in the signature. Checked error declaration: `SQLException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L31–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L31-L31)
- `changeStatus(Message message, int status)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L33–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L33-L33)
- `updatePendingMessageRetryTime(Message message, long time)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L35–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L35-L35)
- `updateCollapsedMessage(Message message)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L37–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L37-L37)
- `updateCollapsedMessage(Message message, boolean sync)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L39–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L39-L39)
- `collapseMessages(Integer serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L41–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L41-L41)
- `loadNotSentMessages(long receiverId)`: Declares return type `List<Message>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L43–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L43-L43)
- `deleteExpiredMessages(Integer serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L45–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L45-L45)
- `changeStatus(long id, int status)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L47–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L47-L47)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java: [MySQLMessageCRUD.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L21).
- src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java: [OracleMessageCRUD.java:L24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L24).

Consumer boundary: [MessageCRUD.java:L1–136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L1-L136). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supports pending delivery storage, retry eligibility, collapse replacement, ACK archival and expiry maintenance. Relational rows, enqueue acceptance and transport delivery are distinct stages; source alone approves neither retention SLA nor delivery guarantee. Triggering actors are Server/MessageManager/AsyncProducer and maintenance paths.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

Reconciliation: generated-knowledge/flows/message-delivery-flow.md already separates delivery, ACK and persistence guarantees; this dossier adds concrete SQL/transaction branches. generated-knowledge/observability/adr-async-db-persistence-overload.md remains a proposed policy; its cumulative-counter observation matches MessageCRUD, but that document’s isolated test is not a runtime test performed by this audit.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/PeerCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/PeerCRUD.java:1-118"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/PeerCRUD.java:1-118"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java"
---

# PeerCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [PeerCRUD.java:L1–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L1-L118). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([PeerCRUD.java:L20–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L20-L30)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `removePeer(String appId, String deviceId)`: Returns the result of `peerCRUDInterface.removePeer(appId, deviceId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L28-L30)
- `isPeerExists(String appId, String deviceId)`: Returns the result of `peerCRUDInterface.isPeerExists(appId, deviceId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L32-L34)
- `isPeerExists(long id)`: Returns the result of `peerCRUDInterface.isPeerExists(id)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L36-L38)
- `createPeer(Peer peer)`: Returns the result of `peerCRUDInterface.createPeer(peer)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L40-L42)
- `loadPeer(long id)`: Reads CacheUtil.getById; on miss loads vendor DB result and calls cachePeer even when null, then returns it. No local error handling. [PeerCRUD.java:L44–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L44-L51)
- `loadPeerReceiveInfoByDeviceIdAndServerId(long serverId, String deviceId)`: Returns the result of `peerCRUDInterface.loadPeerReceiveInfoByDeviceIdAndServerId(serverId, deviceId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L53-L55)
- `loadPeerByAppAndDevice(String deviceId, String appId)`: Returns the result of `peerCRUDInterface.loadPeerByAppAndDevice(deviceId, appId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L57-L59)
- `loadPeerByInputQueueName(String inputQueueName)`: Returns the result of `peerCRUDInterface.loadPeerByInputQueueName(inputQueueName)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L61-L63)
- `loadPeerIDByAppAndDevice(String deviceId, String appId)`: Returns the result of `peerCRUDInterface.loadPeerIdByAppAndDevice(deviceId, appId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L65-L67)
- `loadPeerByName(String name)`: Reads name cache; on miss loads vendor result, caches it, and returns it. No local error handling. [PeerCRUD.java:L69–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L69-L76)
- `registerInPeer(PeerRegistration peerRegistration)`: Invokes `peerCRUDInterface.registerInPeer(peerRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L78-L80)
- `isPeerRegistrationExists(PeerRegistration peerRegistration)`: Returns the result of `peerCRUDInterface.isPeerRegistrationExists(peerRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L82-L84)
- `getPeerRegistrations(Peer peer, List<String> deviceIds)`: Returns the result of `peerCRUDInterface.getPeerRegistrations(peer, deviceIds)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L86–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L86-L88)
- `seen(Peer peer)`: Writes client last-seen cache before vendor seen update; DB failure can leave cache newer than persistence. [PeerCRUD.java:L90–93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L90-L93)
- `getPeerLastSeen(long peerId)`: Returns the result of `peerCRUDInterface.getPeerLastSeen(peerId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L95–97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L95-L97)
- `getPeerLastSeen(List<Long> peerIds)`: Returns the result of `peerCRUDInterface.getPeerLastSeen(peerIds)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L99–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L99-L101)
- `timeoutPeers()`: Invokes `peerCRUDInterface.timeoutPeers()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L103–105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L103-L105)
- `getServerPeersWithQueue()`: Returns the result of `peerCRUDInterface.getServerPeersWithQueue()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L107–109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L107-L109)
- `removePeerByPeerId(long peerId)`: Returns the result of `peerCRUDInterface.removePeerByPeerId(peerId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L111–113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L111-L113)
- `removePeerByPeerId(List<Long> peerIds)`: Returns the result of `peerCRUDInterface.removePeerByPeerId(peerIds)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLPeerCRUD dossier](impl/MySQLPeerCRUD.md), [OraclePeerCRUD dossier](impl/OraclePeerCRUD.md). [facade:L115–117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L115-L117)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/Helper.java: [Helper.java:L137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L137), [Helper.java:L163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L163), [Helper.java:L192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L192), [Helper.java:L198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L198).
- src/com/nozha/async/server/Server.java: [Server.java:L254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L254), [Server.java:L1244](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1244).
- src/com/nozha/async/server/handler/HttpHandler.java: [HttpHandler.java:L159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L159).
- src/com/nozha/async/server/biz/MessageManager.java: [MessageManager.java:L66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L66), [MessageManager.java:L89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L89), [MessageManager.java:L110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L110).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L46), [RegistrationManager.java:L58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L58), [RegistrationManager.java:L61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L61), [RegistrationManager.java:L81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L81), [RegistrationManager.java:L82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L82), [RegistrationManager.java:L89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L89), [RegistrationManager.java:L91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L91), [RegistrationManager.java:L92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L92), [RegistrationManager.java:L115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L115), [RegistrationManager.java:L124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L124), [RegistrationManager.java:L129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L129), [RegistrationManager.java:L136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L136), [RegistrationManager.java:L139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L139), [RegistrationManager.java:L155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L155), [RegistrationManager.java:L171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L171), [RegistrationManager.java:L255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L255), [RegistrationManager.java:L267](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L267), [RegistrationManager.java:L286](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L286), [RegistrationManager.java:L298](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L298), [RegistrationManager.java:L314](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L314).
- src/com/nozha/async/server/httpserver/ClientServlet.java: [ClientServlet.java:L60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L60).
- src/com/nozha/async/server/httpserver/BusinessLimitServlet.java: [BusinessLimitServlet.java:L203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L203).
- src/com/nozha/async/server/httpserver/RegisterServlet.java: [RegisterServlet.java:L180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L180), [RegisterServlet.java:L217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L217), [RegisterServlet.java:L261](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L261), [RegisterServlet.java:L310](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L310), [RegisterServlet.java:L354](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L354), [RegisterServlet.java:L401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L401).
- src/com/nozha/async/server/httpserver/MqttServlet.java: [MqttServlet.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L46).
- src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java: [ProviderRateLimitServlet.java:L189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L189).
- src/com/nozha/async/server/client/QueueClient.java: [QueueClient.java:L28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L28).
- src/com/nozha/async/server/client/RestClient.java: [RestClient.java:L48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L48).
- src/com/nozha/async/server/client/CoapClient.java: [CoapClient.java:L43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L43).
- src/com/nozha/async/server/client/Client.java: [Client.java:L97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L97).
- src/com/nozha/async/server/client/ActiveMQStompQueueClient.java: [ActiveMQStompQueueClient.java:L79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L79).
- src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java: [ActiveMQAMQPQueueClient.java:L78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L78).
- src/com/nozha/async/server/client/MqttClient.java: [MqttClient.java:L32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L32), [MqttClient.java:L39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L39).
- src/com/nozha/async/server/vo/ClientMessage.java: [ClientMessage.java:L42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L42).

## Business

SOURCE_OBSERVED: durable app/device/name identity, owner/user associations and last-seen presence support registration and receiver lookup. Timeout maintenance removes offline nonexempt stale peers and produces PEER_REMOVED owner messages. TTL/count fields are stored, not an approved product policy.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/PeerCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/PeerCRUDInterface.java:1-53"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/PeerCRUDInterface.java:1-53"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java"
---

# PeerCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [PeerCRUDInterface.java:L1–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L1-L53). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `removePeer(String appId, String deviceId)`: Declares return type `long` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L14–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L14-L14)
- `isPeerExists(String appId, String deviceId)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L16-L16)
- `isPeerExists(long id)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L18–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L18-L18)
- `createPeer(Peer peer)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L20–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L20-L20)
- `loadPeer(long id)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L22–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L22-L22)
- `loadPeerReceiveInfoByDeviceIdAndServerId(long serverId, String deviceId)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L24–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L24-L24)
- `loadPeerByAppAndDevice(String deviceId, String appId)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L26–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L26-L26)
- `loadPeerIdByAppAndDevice(String deviceId, String appId)`: Declares return type `Long` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L28–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L28-L28)
- `loadPeerByName(String name)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L30–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L30-L30)
- `registerInPeer(PeerRegistration peerRegistration)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L32–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L32-L32)
- `isPeerRegistrationExists(PeerRegistration peerRegistration)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L34–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L34-L34)
- `getPeerRegistrations(Peer peer, List<String> deviceIds)`: Declares return type `List<Peer>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L36–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L36-L36)
- `seen(Peer peer)`: Declares return type `Peer` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L38–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L38-L38)
- `getPeerLastSeen(long peerId)`: Declares return type `long` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L40–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L40-L40)
- `getPeerLastSeen(List<Long> peerIds)`: Declares return type `Map<Long, Long>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L42–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L42-L42)
- `timeoutPeers()`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L44–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L44-L44)
- `getServerPeersWithQueue()`: Declares return type `List<Peer>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L46–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L46-L46)
- `removePeerByPeerId(long peerId)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L48–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L48-L48)
- `removePeerByPeerId(List<Long> peerIds)`: Declares return type `boolean` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L50–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L50-L50)
- `loadPeerByInputQueueName(String inputQueueName)`: Declares return type `List<PeerDto>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L52–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L52-L52)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java: [MySQLPeerCRUD.java:L27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L27).
- src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java: [OraclePeerCRUD.java:L27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L27).

Consumer boundary: [PeerCRUD.java:L1–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L1-L118). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: durable app/device/name identity, owner/user associations and last-seen presence support registration and receiver lookup. Timeout maintenance removes offline nonexempt stale peers and produces PEER_REMOVED owner messages. TTL/count fields are stored, not an approved product policy.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/QueueCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/QueueCRUD.java:1-43"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/QueueCRUD.java:1-43"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java"
---

# QueueCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [QueueCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L1-L43). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([QueueCRUD.java:L16–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L16-L26)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `loadQueueRegistration(QueueRegistration queueRegistration)`: Returns the result of `queueCRUDInterface.loadQueueRegistration(queueRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLQueueCRUD dossier](impl/MySQLQueueCRUD.md), [OracleQueueCRUD dossier](impl/OracleQueueCRUD.md). [facade:L24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L24-L26)
- `createQueueRegistration(QueueRegistration queueRegistration)`: Returns the result of `queueCRUDInterface.createQueueRegistration(queueRegistration, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLQueueCRUD dossier](impl/MySQLQueueCRUD.md), [OracleQueueCRUD dossier](impl/OracleQueueCRUD.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L28-L30)
- `listQueueRegistration()`: Returns the result of `queueCRUDInterface.listQueueRegistration(Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLQueueCRUD dossier](impl/MySQLQueueCRUD.md), [OracleQueueCRUD dossier](impl/OracleQueueCRUD.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L32-L34)
- `listQueueRegistration(long lastId)`: Returns the result of `queueCRUDInterface.listQueueRegistration(lastId, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLQueueCRUD dossier](impl/MySQLQueueCRUD.md), [OracleQueueCRUD dossier](impl/OracleQueueCRUD.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L36-L38)
- `deleteQueueRegistration(QueueRegistration queueRegistration)`: Invokes `queueCRUDInterface.deleteQueueRegistration(queueRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLQueueCRUD dossier](impl/MySQLQueueCRUD.md), [OracleQueueCRUD dossier](impl/OracleQueueCRUD.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L40-L42)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/Helper.java: [Helper.java:L148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L148), [Helper.java:L172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L172), [Helper.java:L208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L208), [Helper.java:L218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L218).
- src/com/nozha/async/server/handler/QueueHandler.java: [QueueHandler.java:L75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L75).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L226).

## Business

SOURCE_OBSERVED: stores broker URL, queue names, credentials and peer bindings for queue registration and restoration. Delete respects ID/version conflict. Persisting a broker password does not establish external broker connectivity.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/QueueCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/QueueCRUDInterface.java:1-20"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/QueueCRUDInterface.java:1-20"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java"
---

# QueueCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [QueueCRUDInterface.java:L1–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L1-L20). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `loadQueueRegistration(QueueRegistration queueRegistration)`: Declares return type `QueueRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L11-L11)
- `createQueueRegistration(QueueRegistration queueRegistration, Integer serverId)`: Declares return type `QueueRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L13-L13)
- `listQueueRegistration(Integer serverId)`: Declares return type `List<QueueRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L15-L15)
- `listQueueRegistration(long lastId, Integer serverId)`: Declares return type `List<QueueRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L17–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L17-L17)
- `deleteQueueRegistration(QueueRegistration queueRegistration)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L19–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L19-L19)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java: [MySQLQueueCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L17).
- src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java: [OracleQueueCRUD.java:L18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L18).

Consumer boundary: [QueueCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L1-L43). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: stores broker URL, queue names, credentials and peer bindings for queue registration and restoration. Delete respects ID/version conflict. Persisting a broker password does not establish external broker connectivity.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/RateLimitCrud.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RateLimitCrud.java:1-107"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RateLimitCrud.java:1-107"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java"
---

# RateLimitCrud

## Technical

Source-reviewed candidate, based on the complete archived file [RateLimitCrud.java:L1–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L1-L107). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([RateLimitCrud.java:L20–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L20-L30)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `loadBlockedProviders(int serverId)`: Returns the result of `rateLimitCrudInterface.loadBlockedProviders(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L28-L30)
- `loadEndpointConfigs(int serverId)`: Returns the result of `rateLimitCrudInterface.loadEndpointConfigs(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L32-L34)
- `updateEndpointConfig(String providerName, String path, int blockCount, int serverId)`: Invokes `rateLimitCrudInterface.updateEndpointConfig(providerName, path, blockCount, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L36-L38)
- `updateEndpointConfig(String providerName, String path, boolean hasWatch, int serverId)`: Invokes `rateLimitCrudInterface.updateEndpointConfig(providerName, path, hasWatch, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L40-L42)
- `blockProvider(String providerName, int serverId)`: Invokes `rateLimitCrudInterface.blockProvider(providerName, serverId)`. Declares HttpException; no HTTP response mapping occurs here. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L44-L46)
- `unblockProvider(String providerName, int serverId)`: Invokes `rateLimitCrudInterface.unblockProvider(providerName, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L48-L50)
- `loadBusinessMap()`: Returns the result of `rateLimitCrudInterface.loadBusinessMap()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L52-L54)
- `blockBusiness(String businessId, int serverId)`: Invokes `rateLimitCrudInterface.blockBusiness(businessId, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L56-L58)
- `unblockBusiness(String businessId, int serverId)`: Invokes `rateLimitCrudInterface.unblockBusiness(businessId, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L60-L62)
- `watchBusiness(String businessId, int serverId)`: Invokes `rateLimitCrudInterface.watchBusiness(businessId, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L64-L66)
- `unwatchBusiness(String businessId, int serverId)`: Invokes `rateLimitCrudInterface.unwatchBusiness(businessId, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L68–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L68-L70)
- `loadBlockedBusiness(int serverId)`: Returns the result of `rateLimitCrudInterface.loadBlockedBusiness(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L72–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L72-L74)
- `loadBusinessProviderConfigs(int serverId)`: Returns the result of `rateLimitCrudInterface.loadBusinessProviderConfigs(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L76–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L76-L78)
- `loadBusinessConfigs(int serverId)`: Returns the result of `rateLimitCrudInterface.loadBusinessConfigs(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L80–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L80-L82)
- `updateBusinessConfig(String businessId, long providerPeerId, int blockCount, int serverId)`: Invokes `rateLimitCrudInterface.updateBusinessConfig(businessId, providerPeerId, blockCount, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L84–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L84-L86)
- `loadIpAddressConfigs(int serverId)`: Returns the result of `rateLimitCrudInterface.loadIpAddressConfigs(serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L88–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L88-L90)
- `loadIpAddressList()`: Returns the result of `rateLimitCrudInterface.loadIpAddressList()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L92-L94)
- `blockIpAddress(String ip, int serverId)`: Invokes `rateLimitCrudInterface.blockIpAddress(ip, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L96–98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L96-L98)
- `unblockIpAddress(String ip, int serverId)`: Invokes `rateLimitCrudInterface.unblockIpAddress(ip, serverId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L100–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L100-L102)
- `loadRateLimitConfig()`: Returns the result of `rateLimitCrudInterface.loadRateLimitConfig()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRateLimitCrud dossier](impl/MySQLRateLimitCrud.md), [OracleRateLimitCrud dossier](impl/OracleRateLimitCrud.md). [facade:L104–106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L104-L106)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/ratelimit/RateLimitBusiness.java: [RateLimitBusiness.java:L38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L38), [RateLimitBusiness.java:L39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L39), [RateLimitBusiness.java:L40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L40), [RateLimitBusiness.java:L53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L53), [RateLimitBusiness.java:L62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L62), [RateLimitBusiness.java:L71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L71), [RateLimitBusiness.java:L80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L80), [RateLimitBusiness.java:L122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L122), [RateLimitBusiness.java:L147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L147).
- src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java: [RateLimitIpAddress.java:L33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L33), [RateLimitIpAddress.java:L34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L34), [RateLimitIpAddress.java:L49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L49), [RateLimitIpAddress.java:L58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L58).
- src/com/nozha/async/server/ratelimit/RateLimitService.java: [RateLimitService.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L44), [RateLimitService.java:L45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L45), [RateLimitService.java:L46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L46), [RateLimitService.java:L62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L62), [RateLimitService.java:L68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L68), [RateLimitService.java:L90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L90), [RateLimitService.java:L101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L101), [RateLimitService.java:L140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L140).

## Business

SOURCE_OBSERVED: loads and changes provider/endpoint/business/IP blocking, watch state and token/config parameters per server (some catalog/config queries global). It is the storage/control-plane dependency of limiting; it does not consume tokens or reject traffic itself.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/RateLimitCrudInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:1-55"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:1-55"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java"
---

# RateLimitCrudInterface

## Technical

Source-reviewed candidate, based on the complete archived file [RateLimitCrudInterface.java:L1–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L1-L55). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `loadBlockedProviders(int serverId)`: Declares return type `Map<Long, String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L16–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L16-L16)
- `loadEndpointConfigs(int serverId)`: Declares return type `Map<String, EndpointConfig>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L18–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L18-L18)
- `updateEndpointConfig(String providerName, String path, int blockCount, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L20–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L20-L20)
- `updateEndpointConfig(String providerName, String path, boolean hasWatch, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L22–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L22-L22)
- `blockProvider(String providerName, int serverId)`: Declares return type `void` and inputs shown in the signature. Checked error declaration: `HttpException;`. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L24–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L24-L24)
- `unblockProvider(String providerName, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L26–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L26-L26)
- `loadBusinessMap()`: Declares return type `Map<String, String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L28–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L28-L28)
- `blockBusiness(String businessId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L30–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L30-L30)
- `unblockBusiness(String businessId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L32–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L32-L32)
- `watchBusiness(String businessId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L34–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L34-L34)
- `unwatchBusiness(String businessId, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L36–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L36-L36)
- `loadBlockedBusiness(int serverId)`: Declares return type `Set<String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L38–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L38-L38)
- `loadBusinessProviderConfigs(int serverId)`: Declares return type `Map<String, BusinessProviderConfig>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L40–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L40-L40)
- `loadBusinessConfigs(int serverId)`: Declares return type `Map<String, BusinessConfig>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L42–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L42-L42)
- `updateBusinessConfig(String businessId, long providerPeerId, int blockCount, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L44–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L44-L44)
- `loadIpAddressConfigs(int serverId)`: Declares return type `Map<String, IPAddressConfig>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L46–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L46-L46)
- `loadIpAddressList()`: Declares return type `Set<String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L48–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L48-L48)
- `blockIpAddress(String ip, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L50–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L50-L50)
- `unblockIpAddress(String ip, int serverId)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L52–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L52-L52)
- `loadRateLimitConfig()`: Declares return type `List<RateLimitConfig>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L54–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L54-L54)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java: [MySQLRateLimitCrud.java:L26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L26).
- src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java: [OracleRateLimitCrud.java:L26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L26).

Consumer boundary: [RateLimitCrud.java:L1–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L1-L107). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: loads and changes provider/endpoint/business/IP blocking, watch state and token/config parameters per server (some catalog/config queries global). It is the storage/control-plane dependency of limiting; it does not consume tokens or reject traffic itself.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Checked SQLException/HttpException declarations carry implementation failures through contract calls. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/RestCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RestCRUD.java:1-43"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RestCRUD.java:1-43"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java"
---

# RestCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [RestCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L1-L43). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([RestCRUD.java:L15–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L15-L25)); its static reference is retained thereafter. Unsupported vendors leave it null. Only ORACLE is actually wired; MYSQL branch is commented out. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `loadRestRegistration(RestRegistration restRegistration)`: Returns the result of `restCRUDInterface.loadRestRegistration(restRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRestCRUD dossier](impl/MySQLRestCRUD.md), [OracleRestCRUD dossier](impl/OracleRestCRUD.md). [facade:L24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L24-L26)
- `createRestRegistration(RestRegistration restRegistration)`: Returns the result of `restCRUDInterface.createRestRegistration(restRegistration, Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRestCRUD dossier](impl/MySQLRestCRUD.md), [OracleRestCRUD dossier](impl/OracleRestCRUD.md). [facade:L28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L28-L30)
- `listRestRegistration()`: Returns the result of `restCRUDInterface.listRestRegistration(Settings.SERVER_ID)`. Injects current server ID. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRestCRUD dossier](impl/MySQLRestCRUD.md), [OracleRestCRUD dossier](impl/OracleRestCRUD.md). [facade:L32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L32-L34)
- `listRestRegistration(long lastId)`: Returns the result of `restCRUDInterface.listRestRegistration(lastId)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRestCRUD dossier](impl/MySQLRestCRUD.md), [OracleRestCRUD dossier](impl/OracleRestCRUD.md). [facade:L36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L36-L38)
- `deleteRestRegistration(RestRegistration restRegistration)`: Invokes `restCRUDInterface.deleteRestRegistration(restRegistration)`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLRestCRUD dossier](impl/MySQLRestCRUD.md), [OracleRestCRUD dossier](impl/OracleRestCRUD.md). [facade:L40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L40-L42)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/handler/RestHandler.java: [RestHandler.java:L604](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L604).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L236).

## Business

SOURCE_OBSERVED: persists REST mediation base/config URLs and peer/server associations used to restore routing. It does not fetch remote config here. Façade vendor support differs from the existence of MySQL implementation.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Source-observed risks/findings (not production incidents):

- MYSQL is not wired: only ORACLE initializes restCRUDInterface (L15–22); MySQL requests dereference null despite MySQLRestCRUD source existing.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/RestCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RestCRUDInterface.java:1-22"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/RestCRUDInterface.java:1-22"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java"
---

# RestCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [RestCRUDInterface.java:L1–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L1-L22). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `loadRestRegistration(RestRegistration restRegistration)`: Declares return type `RestRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L11-L11)
- `createRestRegistration(RestRegistration restRegistration, Integer serverId)`: Declares return type `RestRegistration` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L13–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L13-L13)
- `listRestRegistration(Integer serverId)`: Declares return type `List<RestRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L15–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L15-L15)
- `listRestRegistration(long lastId, Integer serverId)`: Declares return type `List<RestRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L17–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L17-L17)
- `listRestRegistration(long lastId)`: Declares return type `List<RestRegistration>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L19–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L19-L19)
- `deleteRestRegistration(RestRegistration restRegistration)`: Declares return type `void` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L21–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L21-L21)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java: [OracleRestCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L17).
- src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java: [MySQLRestCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L17).

Consumer boundary: [RestCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L1-L43). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persists REST mediation base/config URLs and peer/server associations used to restore routing. It does not fetch remote config here. Façade vendor support differs from the existence of MySQL implementation.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java:1-10"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java:1-10"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java"
---

# ServiceCallCRUDInterface

## Technical

Source-reviewed candidate, based on the complete archived file [ServiceCallCRUDInterface.java:L1–10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java#L1-L10). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `loadServiceCallDispatcher()`: Declares return type `Map<String, String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L7–7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java#L7-L7)
- `loadServiceCallBlocker()`: Declares return type `Set<String>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L9–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCRUDInterface.java#L9-L9)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java: [OracleServiceCallCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L17).
- src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java: [MySQLServiceCallCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceCallCRUD.java#L17).

Consumer boundary: [ServiceCallCrud.java:L1–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L1-L28). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supplies dispatcher-key→peer-name map and blocker-key set for service-call routing decisions. Config load failures can look like absent routing/block entries because errors are swallowed. No request is forwarded in this file.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.
