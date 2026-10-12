# Async class dossiers — review batch 02


---

### dossier-src-com-nozha-async-server-activemq-mqttincominginterceptor

<!-- source dossier: src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L1-L76
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MQTTIncomingInterceptor — source review

## Technical

Package: `com.nozha.async.server.activemq`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 76 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

intercept ([16–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L16-L75)) first reads remote address best-effort, then connection ID. Exact-class PUBLISH on device/general input prefixes consumes ByteBuf into bytes and delegates to MqttHandler; SUBSCRIBE/CONNECT/UNSUBSCRIBE forward subscription lists or will bytes except server client ID. Other packets return true. Only ClientException changes verdict false and disconnects true; origin lookup exceptions ignored.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L16): `public boolean intercept(MqttMessage packet, RemotingConnection connection) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.handler.MqttHandler`, `io.netty.handler.codec.mqtt.*`, `org.apache.activemq.artemis.core.protocol.mqtt.MQTTInterceptor`, `org.apache.activemq.artemis.spi.core.protocol.RemotingConnection`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`.
Configuration references: `MQTT_SERVER_CLIENTID`, `MQTT_SERVER_DEVICE_INPUT_QUEUE_NAME`, `MQTT_SERVER_INPUT_QUEUE_NAME`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java#L99): `.setIncomingInterceptorClassNames(singletonList(MQTTIncomingInterceptor.class.getName()))`

## Business

SOURCE_OBSERVED: Broker inbound hook gates device publication and connection/subscription registration before protocol handling. Consuming the payload buffer is a side effect; forwarding acceptance does not mean destination ACK.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

ClientException catch ([68–73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L68-L73)) logs twice, disconnects, returns false; other unchecked failures escape. Remote-address exceptions (21) disappear. Test missing registrations and malformed will payload; distinguish validation false from disconnect branch.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L21): `} catch (Exception ignore) {`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L68): `} catch (ClientException e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Second warning label clientId actually receives packet.payload(), potentially exposing content and not a client identifier.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L69) | ALOG-04E9AFC6EAD1 | WARN | `logger.warn("An exception occurred in MQTTIncomingInterceptor", e);` | `); / } / } / } catch (ClientException e) {` |
| [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L70) | ALOG-446845E67984 | WARN | `logger.warn("ClientException packetType={} clientId={}, remoteAddress={}", packet.getClass().getSimpleName(), packet.payload(), origin);` | `} / } / } catch (ClientException e) { / logger.warn("An exception occurred in MQTTIncomingInterceptor", e);` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-mqttoutoinginterceptor

<!-- source dossier: src/com/nozha/async/server/activemq/MQTTOutoingInterceptor.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTOutoingInterceptor.java#L1-L15
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MQTTOutoingInterceptor — source review

## Technical

Package: `com.nozha.async.server.activemq`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 15 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

intercept ([10–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTOutoingInterceptor.java#L10-L14)) contains an empty exact-class PUBLISH branch and always returns true; no transformation, ACK processing or additional security check.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTOutoingInterceptor.java#L10): `public boolean intercept(MqttMessage packet, RemotingConnection connection) {`

Source dependency imports: `io.netty.handler.codec.mqtt.MqttMessage`, `io.netty.handler.codec.mqtt.MqttPublishMessage`, `org.apache.activemq.artemis.core.protocol.mqtt.MQTTInterceptor`, `org.apache.activemq.artemis.spi.core.protocol.RemotingConnection`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java:100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java#L100): `.setOutgoingInterceptorClassNames(singletonList(MQTTOutoingInterceptor.class.getName()))`

## Business

SOURCE_OBSERVED: Indirect outbound broker integration placeholder. Presence does not establish outbound filtering.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path in class; null packet produces implicit NullPointerException at getClass; Artemis is the caller.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; broker outbound and MqttHandler send logging are surrounding visibility.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-securitymanager

<!-- source dossier: src/com/nozha/async/server/activemq/SecurityManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L1-L41
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# SecurityManager — source review

## Technical

Package: `com.nozha.async.server.activemq`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 41 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Both validateUser overloads ([13–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L13-L15),[33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L33-L35)) always return true. Role check with connection ([18–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L18-L30)) rejects only CONSUME of device/general input prefixes for non-server client ID; all other actions allowed. Older role-check overload ([38–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L38-L40)) always true. Roles, user/password and certificates are unused.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L13): `public boolean validateUser(String s, String s1, java.security.cert.X509Certificate[] x509Certificates) {`
- [18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L18): `public boolean validateUserAndRole(String user, String password, Set<Role> roles, CheckType checkType, String address, RemotingConnection connection) {`
- [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L33): `public boolean validateUser(String user, String password) {`
- [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/SecurityManager.java#L38): `public boolean validateUserAndRole(String user, String password, Set<Role> roles, CheckType checkType) {`

Source dependency imports: `com.nozha.Settings`, `org.apache.activemq.artemis.core.security.CheckType`, `org.apache.activemq.artemis.core.security.Role`, `org.apache.activemq.artemis.spi.core.protocol.RemotingConnection`, `org.apache.activemq.artemis.spi.core.security.ActiveMQSecurityManager2`, `java.util.Set`.
Configuration references: `MQTT_SERVER_CLIENTID`, `MQTT_SERVER_DEVICE_INPUT_QUEUE_NAME`, `MQTT_SERVER_INPUT_QUEUE_NAME`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java#L111): `, new SecurityManager()`

## Business

SOURCE_OBSERVED: Indirect broker access control: reserves input consumption to server client identifier in the connection-aware path; not evidence of authenticated identity. It is installed by EmbeddedArtemisServer.initialize.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No explicit throw/catch; false is broker rejection result. Null connection/address can propagate NullPointerException. Test consume vs send and server/nonserver IDs, including which interface overload broker invokes.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; MqttHandler connection/register warnings and broker diagnostics must supply evidence.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-asyncconsumer

<!-- source dossier: src/com/nozha/async/server/activemq/local/AsyncConsumer.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L1-L58
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# AsyncConsumer — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 58 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([19–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L19-L28)) invokes superclass initialization then lazy getConsumer ([39–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L39-L50)): creates ASYNC_QUEUE_NAME+SERVER_ID and QueueMessageListener. reconnect ([31–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L31-L37)) reconnects and creates a new consumer, sets connection exception listener but does not set a message listener on the new consumer. Declared id shadows superclass id and is never assigned.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L19): `public AsyncConsumer initialize(String id, String userName, String password, String activeAddress, boolean randomize) {`
- [31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L31): `public void reconnect() throws JMSException {`
- [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L39): `private void getConsumer() throws Exception {`

Source dependency imports: `com.nozha.Settings`, `org.apache.activemq.command.ActiveMQQueue`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.JMSException`, `javax.jms.MessageConsumer`.
Configuration references: `ASYNC_QUEUE_NAME`, `SERVER_ID`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L23): `logger.error("Exception in AsyncConsumer initializer  consumerId={}", id, e);`
- [src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L44): `logger.error("Exception in AsyncConsumer getConsumer consumerId={}", id, e);`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L22): `static ArrayList<AsyncConsumer> consumerArrayList = new ArrayList<>();`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L42): `consumerArrayList.add(new AsyncConsumer().initialize(i + "", Settings.ASYNC_QUEUE_USERNAME, Settings.ASYNC_QUEUE_PASSWORD, getAsyncActiveAddress(), false));`

## Business

SOURCE_OBSERVED: Consumes inter-server internal messages for local routing. Initialized return value does not prove consumer is connected.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

getConsumer catches Exception, logs, wraps new Exception(e); initialize suppresses it. reconnect declares JMSException but superclass connect suppresses failures. Test reconnect with a message and verify listener attachment.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L24): `} catch (Exception e) {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L45): `} catch (Exception e) {`
- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L47): `throw new Exception(e);`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Consumer ID error/reconnect fields use unassigned shadow id; initial connection info uses method parameter.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L23) | ALOG-FEFBA8D92CD9 | INFO | `logger.info("Async Consumer of Queue Connected id:{} and address:{}", id, activeAddress);` | `public AsyncConsumer initialize(String id, String userName, String password, String activeAddress, boolean randomize) { / try { / super.initialize(id, userName, password, activeAddress, randomize); / getConsumer();` |
| [25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L25) | ALOG-07C6D9F1B0E2 | ERROR | `logger.error("Exception in AsyncConsumer initializer  consumerId={}", id, e);` | `super.initialize(id, userName, password, activeAddress, randomize); / getConsumer(); / logger.info("Async Consumer of Queue Connected id:{} and address:{}", id, activeAddress); / } catch (Exception e) {` |
| [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L32) | ALOG-D16FBAB99A40 | WARN | `logger.warn("async consumer-{} start reconnected", id);` | `} / @Override / public void reconnect() throws JMSException {` |
| [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L46) | ALOG-11945664B565 | ERROR | `logger.error("Exception in AsyncConsumer getConsumer consumerId={}", id, e);` | `ActiveMQQueue inputQueue = new ActiveMQQueue(Settings.ASYNC_QUEUE_NAME + Settings.SERVER_ID); / consumer = session.createConsumer(inputQueue); / consumer.setMessageListener(new QueueMessageListener(id)); / } catch (Exception e) {` |

Registry reconciliation: 4 rows for this file; 4 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-asyncinternalmessagesender

<!-- source dossier: src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L1-L31
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# AsyncInternalMessageSender — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 31 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Static fixed ThreadPoolExecutor uses ASYNC_INTERNAL_THREAD_POOL_SIZE and percent threshold. sendMessage ([18–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L18-L30)) submits Server.MessageSender(message,true,SEND_MESSAGE_TIMEOUT), then compares active count to threshold and computes usage; submitted Future is ignored. No executor shutdown or queue bound is declared.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L18): `public static void sendMessage(Message message) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.model.Message`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.util.concurrent.Executors`, `java.util.concurrent.ThreadPoolExecutor`.
Configuration references: `ASYNC_INTERNAL_THREAD_POOL_SIZE`, `INTERNAL_MESSAGE_THREAD_MAX_USAGE`, `SEND_MESSAGE_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/biz/MessageManager.java:252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L252): `AsyncInternalMessageSender.sendMessage(message);`
- [src/com/nozha/async/server/biz/MessageManager.java:253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L253): `messageSendFrom = AsyncInternalMessageSender.class.getSimpleName();`

## Business

SOURCE_OBSERVED: Local asynchronous delivery avoids inter-server queue overhead; submission is not send completion or client ACK.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Submission/setup exceptions suppressed with message-only logging. Worker exceptions cannot be observed through discarded Future here. Test invalid pool settings, rejected submission and worker failures separately.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L27): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Pool warning is ERROR and measures active workers, not queued backlog; exception catch omits throwable stack.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L24) | ALOG-F263E3EBD3A2 | ERROR | `logger.error("Internal Message Sender ThreadPool is almost full. ActiveThreadCount={} ,MaximumPoolSize={}, usage={}% ", executorService.getActiveCount(), executorService.getMaximumPoolSize(), threadPoolUsage);` | `Server.MessageSender msgSender = Server.getInstance().new MessageSender(message, true, Settings.SEND_MESSAGE_TIMEOUT); / executorService.submit(msgSender); / if (executorService.getActiveCount() >= thresholdPoolSize) { / long threadPoolUsage = (executorService.getActiveCount() * 100L) / executorService.getMaximumPoolSize();` |
| [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L28) | ALOG-30400E1B733F | ERROR | `logger.error("error in sendMessage errorMessage:{}", e.getMessage());` | `logger.error("Internal Message Sender ThreadPool is almost full. ActiveThreadCount={} ,MaximumPoolSize={}, usage={}% ", / executorService.getActiveCount(), executorService.getMaximumPoolSize(), threadPoolUsage); / } / } catch (Exception e) {` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-asyncmanager

<!-- source dossier: src/com/nozha/async/server/activemq/local/AsyncManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L1-L65
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# AsyncManager — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 65 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([27–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L27-L46)) splits internal/rate-limit broker addresses, replaces producerMap, creates producers for every cluster server except SERVER_ID, adds configured rate-limit producers, then internal/rate-limit consumers. getProducer ([48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L48-L50)) returns nullable map entry; getRateLimitProducer ([52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L52-L54)) random selects list member. Synchronized address getters ([56–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L56-L64)) rotate last address to front and join CSV. Static ArrayLists are not cleared on reinitialize.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L27): `public static void initialize() {`
- [48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L48): `public static AsyncProducer getProducer(int receiverServer) {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L52): `public static RateLimitProducer getRateLimitProducer() {`
- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L56): `public static synchronized String getAsyncActiveAddress() {`
- [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L61): `public static synchronized String getRateLimitActiveAddress() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.activemq.ratelimit.RateLimitConsumer`, `com.nozha.async.server.activemq.ratelimit.RateLimitProducer`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.util.ArrayList`, `java.util.Arrays`, `java.util.Map`, `java.util.Random`, `java.util.concurrent.ConcurrentHashMap`.
Configuration references: `ASYNC_CLUSTER_SERVERS`, `ASYNC_QUEUE_ADDRESS`, `ASYNC_QUEUE_PASSWORD`, `ASYNC_QUEUE_USERNAME`, `CONSUMER_COUNT`, `PRODUCER_COUNT`, `RATE_LIMIT_QUEUE_ADDRESS`, `RATE_LIMIT_QUEUE_PASSWORD`, `RATE_LIMIT_QUEUE_USERNAME`, `SERVER_ID`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L105): `AsyncManager.initialize();`
- [src/com/nozha/async/server/biz/MessageManager.java:254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L254): `} else if (Settings.USE_LOCAL_ACTIVE && getServersInCluster().contains(receiverServer + "") && AsyncManager.getProducer(receiverServer) != null) {`
- [src/com/nozha/async/server/biz/MessageManager.java:255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L255): `AsyncManager.getProducer(receiverServer).sendMessage(message, receiverServer);`
- [src/com/nozha/async/server/biz/MessageManager.java:256](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L256): `messageSendFrom = AsyncManager.class.getSimpleName();`
- [src/com/nozha/async/server/ratelimit/RateLimitService.java:226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L226): `AsyncManager.getRateLimitProducer().sendMessage(config);`

## Business

SOURCE_OBSERVED: Coordinates internal broker connections and rate-limit state dissemination across nodes. Settings determine topology; producer/consumer initialization suppresses failures so end banner is not readiness.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Invalid server ID number propagates NumberFormatException; empty producer list causes nextInt(0) failure; null map before initialize fails. Child failures may remain hidden. Test initialization twice and zero producers.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Begin/end banners bracket attempted initialization, not successful health.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L28) | ALOG-F4D4B1116CCC | INFO | `logger.info("*************  Start Internal Queue Active  initialized**********");` | `static ArrayList<RateLimitProducer> rateLimitProducerArrayList = new ArrayList<>(); / static ArrayList<RateLimitConsumer> rateLimitConsumerArrayList = new ArrayList<>(); / public static void initialize() {` |
| [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L45) | ALOG-8E594D36723E | INFO | `logger.info("************* End Internal Queue Active initialized**********");` | `for (int i = 1; i <= Settings.CONSUMER_COUNT; i++) { / consumerArrayList.add(new AsyncConsumer().initialize(i + "", Settings.ASYNC_QUEUE_USERNAME, Settings.ASYNC_QUEUE_PASSWORD, getAsyncActiveAddress(), false)); / rateLimitConsumerArrayList.add(new RateLimitConsumer().initialize(i + "", Settings.RATE_LIMIT_QUEUE_USERNAME, Settings.RATE_LIMIT_QUEUE_PASSWORD, getRateLimitActiveAddress(), false)); / }` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-asyncproducer

<!-- source dossier: src/com/nozha/async/server/activemq/local/AsyncProducer.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L1-L66
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# AsyncProducer — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 66 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([21–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L21-L33)) stores target serverId, delegates failover connection, creates output queue ASYNC_QUEUE_NAME+serverId and installs exception listener. reconnect ([36–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L36-L42)) recreates producer correctly. sendMessage ([44–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L44-L65)) serializes model JSON into BytesMessage using platform default charset, sets absolute expiry, computes relative TTL, sends only positive TTL with configured persistence and priority 4. On send exception marks CREATED and requests MessageCRUD.createAsyncActiveMessage.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L21): `public AsyncProducer initialize(String serverId, String userName, String password, String activeAddress) {`
- [36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L36): `public void reconnect() throws JMSException {`
- [44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L44): `public void sendMessage(Message message, int receiverServer) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.model.Message`, `com.nozha.async.server.persistance.MessageCRUD`, `com.nozha.async.server.util.JsonUtil`, `org.apache.activemq.command.ActiveMQQueue`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.*`.
Configuration references: `ASYNC_QUEUE_NAME`, `ASYNC_QUEUE_SEND_PERSISTENT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/local/AsyncManager.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L23): `private static Map<Integer, AsyncProducer> producerMap;`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L35): `producerMap.put(Integer.parseInt(serversInCluster[i]), new AsyncProducer().initialize(serversInCluster[i], Settings.ASYNC_QUEUE_USERNAME, Settings.ASYNC_QUEUE_PASSWORD, getAsyncActiveAddress()));`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L48): `public static AsyncProducer getProducer(int receiverServer) {`

## Business

SOURCE_OBSERVED: Inter-server delivery to receiver node with persistence fallback on send failure. Expired messages are silently unsent; enqueue does not prove receiver delivery.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

initialize exceptions suppressed; send catches JMSException and all Exception, logs and restores CREATED/persistence; fallback itself can propagate. TTL<=0 has no fallback/log. Reproduce JMS outage and expired input; compare CRUD persistence overload behavior.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L29): `} catch (Exception e) {`
- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L56): `} catch (JMSException e) {`
- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L58): `message.setStatus(Message.CREATED);`
- [60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L60): `} catch (Exception e) {`
- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L62): `message.setStatus(Message.CREATED);`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Success DEBUG means JMS send invocation returned. ReceiverServer is log input, whereas queue destination is initialized serverId.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L28) | ALOG-B359E269D16D | INFO | `logger.info("Async Producer of Server:{} Connected", serverId);` | `super.initialize("producer" + serverId, userName, password, activeAddress, true); / ActiveMQQueue outputQueue = new ActiveMQQueue(Settings.ASYNC_QUEUE_NAME + serverId); / messageProducer = session.createProducer(outputQueue); / connection.setExceptionListener(new exceptionListener());` |
| [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L30) | ALOG-54DFAF45AFEE | ERROR | `logger.error("Exception in AsyncProducer initialize", e);` | `messageProducer = session.createProducer(outputQueue); / connection.setExceptionListener(new exceptionListener()); / logger.info("Async Producer of Server:{} Connected", serverId); / } catch (Exception e) {` |
| [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L37) | ALOG-695B49A82C3B | WARN | `logger.warn("async producer-{} start reconnected", id);` | `} / @Override / public void reconnect() throws JMSException {` |
| [54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L54) | ALOG-8CFFC8CF622C | DEBUG | `logger.debug("Send Message to server={} messageId={} ", receiverServer, message.getId());` | `bytesMessage.setJMSExpiration(message.getExpireDate()); / long timeToLive = (message.getExpireDate()) - System.currentTimeMillis(); / if (timeToLive > 0) { / messageProducer.send(bytesMessage, Settings.ASYNC_QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, timeToLive);` |
| [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L57) | ALOG-6618435C967C | ERROR | `logger.error("JMSException in send message to server={} messageId={} ", receiverServer, message.getId(), e);` | `messageProducer.send(bytesMessage, Settings.ASYNC_QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, timeToLive); / logger.debug("Send Message to server={} messageId={} ", receiverServer, message.getId()); / } / } catch (JMSException e) {` |
| [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L61) | ALOG-C3097423D25E | ERROR | `logger.error("Exception in send message to server={} messageId={} ", receiverServer, message.getId(), e);` | `logger.error("JMSException in send message to server={} messageId={} ", receiverServer, message.getId(), e); / message.setStatus(Message.CREATED); / MessageCRUD.createAsyncActiveMessage(message); / } catch (Exception e) {` |

Registry reconciliation: 6 rows for this file; 6 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-asyncqueueadaptor

<!-- source dossier: src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L1-L100
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# AsyncQueueAdaptor — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 100 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([28–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L28-L37)) stores identity/credentials/address/randomization and calls connect. connect ([39–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L39-L74)) closes prior connection, creates cached ActiveMQConnectionFactory failover URL with randomize/backup/timeouts/useAsyncSend/copyMessageOnSend=false, starts connection, creates nontransacted AUTO_ACKNOWLEDGE session. getSession exposes session. Abstract reconnect delegates policy to subclass; exceptionListener.onException ([85–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L85-L91)) immediately calls reconnect, catches only JMSException.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L28): `public AsyncQueueAdaptor initialize(String id, String userName, String password, String activeAddress, boolean randomize) {`
- [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L39): `public void connect() {`
- [76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L76): `public Session getSession() {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L80): `public abstract void reconnect() throws JMSException;`
- [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L85): `public void onException(JMSException e) {`

Source dependency imports: `com.nozha.Settings`, `org.apache.activemq.ActiveMQConnectionFactory`, `org.apache.commons.lang3.StringUtils`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.Connection`, `javax.jms.ExceptionListener`, `javax.jms.JMSException`, `javax.jms.Session`.
Configuration references: `ASYNC_QUEUE_CONNECTION_BACKUP`, `ASYNC_SEND_MESSAGE_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L12): `public class RateLimitConsumer extends AsyncQueueAdaptor {`
- [src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L13): `public class RateLimitProducer extends AsyncQueueAdaptor {`
- [src/com/nozha/async/server/activemq/local/AsyncConsumer.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L13): `public class AsyncConsumer extends AsyncQueueAdaptor {`
- [src/com/nozha/async/server/activemq/local/AsyncProducer.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L15): `public class AsyncProducer extends AsyncQueueAdaptor {`

## Business

SOURCE_OBSERVED: Shared local JMS coordination dependency; AUTO_ACKNOWLEDGE and asynchronous producer setting do not supply end-to-end ACK contract.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

connect catches all Exception and suppresses without attaching throwable; initialize still returns object. reconnect callback catches JMSException, logs message only; runtime failures propagate. No explicit backoff implemented in callback beyond broker failover behavior.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L71): `} catch (Exception e) {`
- [88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L88): `} catch (JMSException jmsException) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Connect error loses original exception and may leave old/stale/null session; initialized debug is not health.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L35) | ALOG-97DB93F18DFC | DEBUG | `logger.debug("AsyncQueueAdaptor initialized id={} ", id);` | `this.password = password; / this.activeAddress = activeAddress; / this.randomize = randomize; / connect();` |
| [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L70) | ALOG-D9AA94AAA5B0 | DEBUG | `logger.debug("AsyncQueueAdaptor connect id={} ", id);` | `} / connection = factory.createConnection(userName, password); / connection.start(); / session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);` |
| [72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L72) | ALOG-E808B4FEDDF6 | ERROR | `logger.error("not connect or create session for id={}", id);` | `connection.start(); / session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); / logger.debug("AsyncQueueAdaptor connect id={} ", id); / } catch (Exception e) {` |
| [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L89) | ALOG-C8BBFFF9FCAA | ERROR | `logger.error("exceptionListener can not reconnect consumerId={}, exceptionMessage={}", id, jmsException.getMessage());` | `public void onException(JMSException e) { / try { / reconnect(); / } catch (JMSException jmsException) {` |

Registry reconciliation: 4 rows for this file; 4 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-local-queuemessagelistener

<!-- source dossier: src/com/nozha/async/server/activemq/local/QueueMessageListener.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L1-L60
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# QueueMessageListener — source review

## Technical

Package: `com.nozha.async.server.activemq.local`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 60 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L24-L26)) retains consumer ID. onMessage ([29–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L29-L59)) explicitly acknowledges first, accepts BytesMessage only, reads declared body length once, processes only exact length, decodes UTF-8 model JSON, logs queue residence and threshold, submits Server.MessageSender with timeout to shared fixed pool; logs active-worker usage above threshold. Other types/partial read silently ignored. No executor shutdown.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L24): `public QueueMessageListener(String id) {`
- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L29): `public void onMessage(Message message) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.util.JsonUtil`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.BytesMessage`, `javax.jms.Message`, `javax.jms.MessageListener`, `java.nio.charset.StandardCharsets`, `java.util.concurrent.Executors`, `java.util.concurrent.ThreadPoolExecutor`.
Configuration references: `ASYNC_CONSUMER_THREAD_POOL_SIZE`, `LOCAL_ACTIVE_THREAD_MAX_USAGE`, `LOCAL_ACTIVE_TIME_IN_QUEUE_THRESHOLDS`, `SEND_MESSAGE_TIMEOUT`, `SERVER_ID`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L82): `consumer.setMessageListener(new QueueMessageListener());`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L124): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L81): `consumer.setMessageListener(new QueueMessageListener());`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L123): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L179): `consumer.setMessageListener(new QueueMessageListener());`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L273): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L47): `logger.error("Exception in QueueMessageListener onMessage  ", e);`
- [src/com/nozha/async/server/activemq/local/AsyncConsumer.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncConsumer.java#L44): `consumer.setMessageListener(new QueueMessageListener(id));`

## Business

SOURCE_OBSERVED: Internal node-to-node receive path. Broker acknowledgement precedes parsing and asynchronous send; source does not guarantee recovery for malformed or failed worker work.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

All synchronous Exception suppressed at outer catch. Partial read/type skip already acknowledged. Future ignored hides worker exceptions here. Test malformed JSON and worker failures after ACK.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L56): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Residence INFO proves receipt/parse and time calculation; saturation ERROR active workers only; neither proves client delivery.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L40) | ALOG-2FD609AE4521 | INFO | `logger.info("Local Active time in queue={} ,serverId={} ,messageId={} ,senderId={} ,receiverId={}", timeInQueue, Settings.SERVER_ID, msg.getId(), msg.getSender(), msg.getReceiver());` | `if (readBytes == bytesMessage.getBodyLength()) { / long timeInQueue = System.currentTimeMillis() - message.getJMSTimestamp(); / String text = new String(buffer, StandardCharsets.UTF_8); / com.nozha.async.server.model.Message msg = JsonUtil.getObject(text, com.nozha.async.server.model.Message.class);` |
| [43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L43) | ALOG-13910C0A3D18 | WARN | `logger.warn("Local Active time in queue more than thresholds for serverId={}, timeInQueue={}", Settings.SERVER_ID, timeInQueue);` | `com.nozha.async.server.model.Message msg = JsonUtil.getObject(text, com.nozha.async.server.model.Message.class); / logger.info("Local Active time in queue={} ,serverId={} ,messageId={} ,senderId={} ,receiverId={}", / timeInQueue, Settings.SERVER_ID, msg.getId(), msg.getSender(), msg.getReceiver()); / if (timeInQueue >= Settings.LOCAL_ACTIVE_TIME_IN_QUEUE_THRESHOLDS) {` |
| [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L51) | ALOG-141013B184DB | ERROR | `logger.error("Local Active ThreadPool is almost full. ActiveThreadCount={} ,MaximumPoolSize={}, usage={}% ,messageId={}", executorService.getActiveCount(), executorService.getMaximumPoolSize(), threadPoolUsage, msg.getId());` | `executorService.submit(msgSender); / if (executorService.getActiveCount() >= thresholdPoolSize) { / long threadPoolUsage = (executorService.getActiveCount() * 100L) / executorService.getMaximumPoolSize();` |
| [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L57) | ALOG-E0E7B7DE1D68 | ERROR | `logger.error("Exception in QueueMessageListener onMessage  ", e);` | `} / } / } / } catch (Exception e) {` |

Registry reconciliation: 4 rows for this file; 4 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-ratelimit-ratelimitconsumer

<!-- source dossier: src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L1-L49
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RateLimitConsumer — source review

## Technical

Package: `com.nozha.async.server.activemq.ratelimit`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 49 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([17–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L17-L26)) delegates connection and lazy getConsumer ([37–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L37-L48)) on RATE_LIMIT_CONSUMER_QUEUE_NAME+SERVER_ID with RateLimitMessageListener. reconnect ([29–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L29-L35)) replaces consumer and exception listener but omits listener reattachment. id shadows parent and is never assigned.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L17): `public RateLimitConsumer initialize(String id, String userName, String password, String activeAddress, boolean randomize) {`
- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L29): `public void reconnect() throws JMSException {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L37): `private void getConsumer() throws Exception {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.activemq.local.AsyncQueueAdaptor`, `org.apache.activemq.command.ActiveMQQueue`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.JMSException`, `javax.jms.MessageConsumer`.
Configuration references: `RATE_LIMIT_CONSUMER_QUEUE_NAME`, `SERVER_ID`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/local/AsyncManager.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L25): `static ArrayList<RateLimitConsumer> rateLimitConsumerArrayList = new ArrayList<>();`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L43): `rateLimitConsumerArrayList.add(new RateLimitConsumer().initialize(i + "", Settings.RATE_LIMIT_QUEUE_USERNAME, Settings.RATE_LIMIT_QUEUE_PASSWORD, getRateLimitActiveAddress(), false));`

## Business

SOURCE_OBSERVED: Cross-node rate-limit updates reach this node through broker queue; stale policies are possible if reconnect never forwards messages.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

getConsumer wraps Exception; initializer suppresses; reconnect JMSException propagates to parent listener. Test reconnection and absent queue/session.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L22): `} catch (Exception e) {`
- [43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L43): `} catch (Exception e) {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L45): `throw new Exception(e);`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Log templates incorrectly refer to AsyncConsumer; consumerId shadow null.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L21) | ALOG-ECAA449E73AE | INFO | `logger.info("Async Consumer of Queue Connected id:{} and address:{}", id, activeAddress);` | `public RateLimitConsumer initialize(String id, String userName, String password, String activeAddress, boolean randomize) { / try { / super.initialize(id, userName, password, activeAddress, randomize); / getConsumer();` |
| [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L23) | ALOG-C75F983D9B6E | ERROR | `logger.error("Exception in AsyncConsumer initializer  consumerId={}", id, e);` | `super.initialize(id, userName, password, activeAddress, randomize); / getConsumer(); / logger.info("Async Consumer of Queue Connected id:{} and address:{}", id, activeAddress); / } catch (Exception e) {` |
| [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L30) | ALOG-9F3762FCA97F | WARN | `logger.warn("async consumer-{} start reconnected", id);` | `} / @Override / public void reconnect() throws JMSException {` |
| [44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L44) | ALOG-D7DF4DC48B3E | ERROR | `logger.error("Exception in AsyncConsumer getConsumer consumerId={}", id, e);` | `ActiveMQQueue inputQueue = new ActiveMQQueue(Settings.RATE_LIMIT_CONSUMER_QUEUE_NAME + Settings.SERVER_ID); / consumer = session.createConsumer(inputQueue); / consumer.setMessageListener(new RateLimitMessageListener()); / } catch (Exception e) {` |

Registry reconciliation: 4 rows for this file; 4 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-ratelimit-ratelimitmessagelistener

<!-- source dossier: src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L1-L50
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RateLimitMessageListener — source review

## Technical

Package: `com.nozha.async.server.activemq.ratelimit`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 50 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

onMessage ([21–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L21-L49)) acknowledges first, reads complete BytesMessage once, UTF-8 decodes RateLimitConfig, retrieves existing in-memory config by limitKey and updates only temporarilyBlocked and expireTime; logs configuration and JSON RateLimitLog using nanoTime plus current count. Outer elapsed time uses wall clock. Partial reads/types ignored.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L21): `public void onMessage(Message message) {`

Source dependency imports: `com.nozha.async.server.ratelimit.RateLimitService`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.log.RateLimitLog`, `com.nozha.async.server.vo.rateLimit.RateLimitConfig`, `org.apache.logging.log4j.LogManager`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.BytesMessage`, `javax.jms.Message`, `javax.jms.MessageListener`, `java.nio.charset.StandardCharsets`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitConsumer.java#L42): `consumer.setMessageListener(new RateLimitMessageListener());`

## Business

SOURCE_OBSERVED: Disseminates temporary block/expiry changes, not full capacity/refill/count configuration replacement. Missing map entry prevents update.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Inner Exception ([40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L40-L42)) suppresses parse/map/update failure; outer Exception ([46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L46-L48)) suppresses receive/ACK errors. Acknowledged invalid update has no app retry. Test unknown limitKey, malformed JSON and partial read.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L40): `} catch (Exception e) {`
- [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L46): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

JSONLOG uses System.nanoTime, not epoch timestamp. Full text/config logged; no explicit update version or source-node identity.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L33) | ALOG-8E43FE338224 | DEBUG | `logger.debug("message received text={}", text);` | `int readBytes = bytesMessage.readBytes(buffer); / if (readBytes == bytesMessage.getBodyLength()) { / String text = new String(buffer, StandardCharsets.UTF_8); / try {` |
| [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L38) | ALOG-F269D4A63C3D | INFO | `logger.info("Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={}", inMemoryRateLimitConfig.getLimitKey(), inMemoryRateLimitConfig.getCapacity(), inMemoryRateLimitConfig.getRefillInterval(), inMemoryRateLimitConfig.getExpireTime(), inMemoryRateLimitConfig.getCountThreshold(), System.currentTimeMillis());` | `rateLimitConfig = JsonUtil.getObject(text, RateLimitConfig.class); / RateLimitConfig inMemoryRateLimitConfig = RateLimitService.getRateLimitConfigMap(rateLimitConfig.getLimitKey()); / inMemoryRateLimitConfig.setTemporarilyBlocked(rateLimitConfig.getTemporarilyBlock()); / inMemoryRateLimitConfig.setExpireTime(rateLimitConfig.getExpireTime());` |
| [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L39) | ALOG-C1DD758063A2 | DEBUG | `loggerJson.debug(new RateLimitLog(inMemoryRateLimitConfig.toString(), JsonUtil.getJson(inMemoryRateLimitConfig), System.nanoTime(), inMemoryRateLimitConfig.getCount().get()));` | `RateLimitConfig inMemoryRateLimitConfig = RateLimitService.getRateLimitConfigMap(rateLimitConfig.getLimitKey()); / inMemoryRateLimitConfig.setTemporarilyBlocked(rateLimitConfig.getTemporarilyBlock()); / inMemoryRateLimitConfig.setExpireTime(rateLimitConfig.getExpireTime()); / logger.info("Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={}", inMemoryRateLimitConfig.getLimitKey(), inMemoryRateLimitConfig.getCapacity(), inMemoryRateLimitConfig.getRefillInterval(), inMemoryRateLimitConfig.getExpireTime(), inMemoryRateLimitConfig.getCountThresh` |
| [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L41) | ALOG-F5FC8AF54E6F | ERROR | `logger.error("exception in onMessage", e);` | `inMemoryRateLimitConfig.setExpireTime(rateLimitConfig.getExpireTime()); / logger.info("Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={}", inMemoryRateLimitConfig.getLimitKey(), inMemoryRateLimitConfig.getCapacity(), inMemoryRateLimitConfig.getRefillInterval(), inMemoryRateLimitConfig.getExpireTime(), inMemoryRateLimitConfig.getCountThreshold(), System.currentTimeMillis()); / loggerJson.debug(new RateLimitLog(inMemoryRateLimitConfig.toString(), JsonUtil.getJson(inMemoryRateLimitConfig), System.nanoTime(), inMemoryRateLimitConfig.getCount(` |
| [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L45) | ALOG-44210558FB3F | DEBUG | `logger.debug("RateLimitMessageListener in async message received in {} ms", System.currentTimeMillis() - start);` | `logger.error("exception in onMessage", e); / } / } / }` |
| [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L47) | ALOG-3EE72E4FEFA5 | ERROR | `logger.error("Exception in QueueMessageListener onMessage  ", e);` | `} / } / logger.debug("RateLimitMessageListener in async message received in {} ms", System.currentTimeMillis() - start); / } catch (Exception e) {` |

Registry reconciliation: 6 rows for this file; 6 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-ratelimit-ratelimitproducer

<!-- source dossier: src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L1-L54
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RateLimitProducer — source review

## Technical

Package: `com.nozha.async.server.activemq.ratelimit`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 54 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

initialize ([19–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L19-L29)) connects and creates producer for static RATE_LIMIT_PRODUCER_QUEUE_NAME. reconnect ([32–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L32-L36)) calls connect and listener installation but does not recreate messageProducer for new session. sendMessage ([38–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L38-L53)) TTL=refillInterval/RATE_LIMIT_TTL_DOMINATOR, serializes config, writes default-charset bytes, absolute expiration now+ttl, sends configured persistence priority4 TTL.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L19): `public RateLimitProducer initialize(String producerId, String userName, String password, String activeAddress) {`
- [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L32): `public void reconnect() throws JMSException {`
- [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L38): `public void sendMessage(RateLimitConfig rateLimitConfig) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.activemq.local.AsyncQueueAdaptor`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.rateLimit.RateLimitConfig`, `org.apache.activemq.command.ActiveMQQueue`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.*`.
Configuration references: `ASYNC_QUEUE_SEND_PERSISTENT`, `RATE_LIMIT_PRODUCER_QUEUE_NAME`, `RATE_LIMIT_TTL_DOMINATOR`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/activemq/local/AsyncManager.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L24): `static ArrayList<RateLimitProducer> rateLimitProducerArrayList = new ArrayList<>();`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L39): `rateLimitProducerArrayList.add(new RateLimitProducer().initialize(String.valueOf(i), Settings.RATE_LIMIT_QUEUE_USERNAME, Settings.RATE_LIMIT_QUEUE_PASSWORD, getRateLimitActiveAddress()));`
- [src/com/nozha/async/server/activemq/local/AsyncManager.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncManager.java#L52): `public static RateLimitProducer getRateLimitProducer() {`

## Business

SOURCE_OBSERVED: Broadcasts rate-limit config changes to broker infrastructure. No downstream update acknowledgment returned.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Initializer suppresses all exceptions. send catches JMSException/Exception and only logs; no fallback or retry in class. Division by zero, null config and stale producer caught. TTL zero is passed through (broker semantics require external proof).

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L25): `} catch (Exception e) {`
- [48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L48): `} catch (JMSException e) {`
- [50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L50): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

DEBUG/error includes full config JSON and may expose limit keys; sent log does not prove consumer update.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L24) | ALOG-C5CF4855D86F | INFO | `logger.info("Async manager Producer of Server:{} Connected", producerId);` | `try { / super.initialize("producer" + producerId, userName, password, activeAddress, true); / messageProducer = session.createProducer(destination); / connection.setExceptionListener(new exceptionListener());` |
| [26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L26) | ALOG-FF14C02D15D4 | ERROR | `logger.error("Exception in AsyncManagerProducer initialize", e);` | `messageProducer = session.createProducer(destination); / connection.setExceptionListener(new exceptionListener()); / logger.info("Async manager Producer of Server:{} Connected", producerId); / } catch (Exception e) {` |
| [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L33) | ALOG-50792C23BC23 | WARN | `logger.warn("async manager producer start reconnected");` | `} / @Override / public void reconnect() throws JMSException {` |
| [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L47) | ALOG-08F6D4E920AE | DEBUG | `logger.debug("Send Message to server jsonMessage={} ", json);` | `BytesMessage bytesMessage = getSession().createBytesMessage(); / bytesMessage.writeBytes(json.getBytes()); / bytesMessage.setJMSExpiration(System.currentTimeMillis() + ttl); / messageProducer.send(bytesMessage, Settings.ASYNC_QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, ttl);` |
| [49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L49) | ALOG-E9F6194798E7 | ERROR | `logger.error("JMSException in send message to server jsonMessage={} ", json, e);` | `bytesMessage.setJMSExpiration(System.currentTimeMillis() + ttl); / messageProducer.send(bytesMessage, Settings.ASYNC_QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, ttl); / logger.debug("Send Message to server jsonMessage={} ", json); / } catch (JMSException e) {` |
| [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L51) | ALOG-6D1EA95D3EC5 | ERROR | `logger.error("Exception in send message to server jsonMessage={} ", json, e);` | `logger.debug("Send Message to server jsonMessage={} ", json); / } catch (JMSException e) { / logger.error("JMSException in send message to server jsonMessage={} ", json, e); / } catch (Exception e) {` |

Registry reconciliation: 6 rows for this file; 6 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-activemq-vo-clientinfo

<!-- source dossier: src/com/nozha/async/server/activemq/vo/ClientInfo.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L1-L47
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ClientInfo — source review

## Technical

Package: `com.nozha.async.server.activemq.vo`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 47 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Mutable DTO ([4–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L4-L38)) stores device flag, nullable peerId/deviceId/appId with direct getters/setters. toString ([42–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L42-L46)) renders peerId/deviceId/appId but omits device flag. MqttHandler deserializes this object from CONNECT will bytes and validates registration identity.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L9): `public boolean isDevice() {`
- [13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L13): `public void setDevice(boolean device) {`
- [17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L17): `public Long getPeerId() {`
- [21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L21): `public void setPeerId(Long peerId) {`
- [25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L25): `public String getDeviceId() {`
- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L29): `public void setDeviceId(String deviceId) {`
- [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L33): `public String getAppId() {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L37): `public void setAppId(String appId) {`
- [42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/vo/ClientInfo.java#L42): `public String toString() {`

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/MqttHandler.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L129): `private void register(String clientId, String connectionId, ClientInfo clientInfo) throws Exception {`
- [src/com/nozha/async/server/handler/MqttHandler.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L158): `private MqttClient registerDevice(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- [src/com/nozha/async/server/handler/MqttHandler.java:186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L186): `private MqttClient registerPeer(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- [src/com/nozha/async/server/handler/MqttHandler.java:242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L242): `ClientInfo clientInfo = null;`
- [src/com/nozha/async/server/handler/MqttHandler.java:244](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L244): `clientInfo = JsonUtil.getObject(willMessageInBytes, ClientInfo.class);`

## Business

SOURCE_OBSERVED: Indirect MQTT device/peer registration evidence envelope; not standalone authentication policy.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path in class; null IDs accepted. Caller MqttHandler rejects inconsistent registration with ServerException("invalid client").

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; MqttHandler registration/connect logs supply client/connection/peer IDs.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-biz-accessibilityservice

<!-- source dossier: src/com/nozha/async/server/biz/AccessibilityService.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-static-candidate
review_status: source-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/com/nozha/async/server/biz/AccessibilityService.java
source_sha256: 514b33292f170bf1b6caa1310da7371016927902de36efa57e72564ff9bcc15f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java
business_approved: false
runtime_tested: false
promoted: false
---

# AccessibilityService — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `AccessibilityService` (class_declaration) [src/com/nozha/async/server/biz/AccessibilityService.java:15–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L15-L82)
Loads business access list and receiver-id/name maps from AccessibilityCrud; clear/put refresh is not atomic (29–36).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
ArrayList/HashMap state has no locks; concurrent refresh/read can expose empty/partially updated collections.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/biz/AccessibilityService.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L16) |
| `businessAccessList` | `List<AccessDTO>` | [src/com/nozha/async/server/biz/AccessibilityService.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L17) |
| `peerAccessKeyMapByPeerId` | `Map<Long, List<String>>` | [src/com/nozha/async/server/biz/AccessibilityService.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L18) |
| `peerAccessKeyMapByPeerName` | `Map<String, List<String>>` | [src/com/nozha/async/server/biz/AccessibilityService.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L19) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/biz/AccessibilityService.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L3); `com.nozha.async.server.client.Client` [src/com/nozha/async/server/biz/AccessibilityService.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L4); `com.nozha.async.server.exception.AccessibilityException` [src/com/nozha/async/server/biz/AccessibilityService.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L5); `com.nozha.async.server.persistance.AccessibilityCrud` [src/com/nozha/async/server/biz/AccessibilityService.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L6); `com.nozha.async.server.util.ClientHelper` [src/com/nozha/async/server/biz/AccessibilityService.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L7); `com.nozha.async.server.vo.AccessDTO` [src/com/nozha/async/server/biz/AccessibilityService.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L8); `org.slf4j.Logger` [src/com/nozha/async/server/biz/AccessibilityService.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L9); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/biz/AccessibilityService.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L10); `java.util.*` [src/com/nozha/async/server/biz/AccessibilityService.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L12); `java.util.stream.Collectors` [src/com/nozha/async/server/biz/AccessibilityService.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L13)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L215) ` AccessibilityService.initialize();`; [src/com/nozha/async/server/biz/MessageManager.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L59) ` AccessibilityService.accessibilityValidation(client, receiver);`; [src/com/nozha/async/server/httpserver/AccessServlet.java:86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L86) ` AccessibilityService.refreshAccessList();`; [src/com/nozha/async/server/httpserver/AsyncFilter.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L53) ` allowedOrigins = AccessibilityService.getAccessListByPeerName(MediatorManager.getReceiverName(request));`; [src/com/nozha/async/server/client/HttpClient.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L58) ` AccessibilityService.accessibilityValidation(instance, MediatorManager.getReceiverName(request));`; [src/com/nozha/async/server/client/WebsocketClient.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L45) ` AccessibilityService.validateAccessibility(this, key, isKeyAvailable);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Refresh access state. | [src/com/nozha/async/server/biz/AccessibilityService.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L21-L23) |
| `public static List<String> getAccessListByPeerName(String peerName)` | Return live receiver-name access list or null. | [src/com/nozha/async/server/biz/AccessibilityService.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L25-L27) |
| `public static void refreshAccessList()` | Load two persistence lists; clear both maps; group values by peerId and non-null peerName. | [src/com/nozha/async/server/biz/AccessibilityService.java:29–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L29-L36) |
| `public static void validateAccessibility(Client client, String key, boolean isKeyAvailable) throws AccessibilityException` | Only enabled concrete client types invoke business-list validation using supplied key/availability. | [src/com/nozha/async/server/biz/AccessibilityService.java:38–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L38-L42) |
| `public static void accessibilityValidation(Client client, String peerName) throws AccessibilityException` | Only enabled client types fetch peer-name values and validate client key. | [src/com/nozha/async/server/biz/AccessibilityService.java:44–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L44-L51) |
| `public static void accessibilityValidation(Client client, long receiver) throws AccessibilityException` | Only enabled client types fetch receiver-ID values and validate client key. | [src/com/nozha/async/server/biz/AccessibilityService.java:53–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L53-L60) |
| `private static void accessValidation(List<?> accessList, Client client, String key, Long receiver, String peerName, boolean isKeyAvailable) throws AccessibilityException` | When validation enabled and nonempty list and non-null/non-literal-null key has no matching value: application-key branch logs-only unless raise flag; origin branch permits literal wildcard otherwise logs-only/throws. Else log access list size/key/type. No mismatch log in exception branch. | [src/com/nozha/async/server/biz/AccessibilityService.java:62–81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L62-L81) |

## Business
SOURCE_OBSERVED: Clients whose concrete type is enabled may be checked against business or receiver keys. Null/empty lists, null/literal-null keys, or disabled validation bypass mismatch rejection (63–64). Mismatch can log-only or throw based on application/origin flags; wildcard only bypasses origin mismatch.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
AccessibilityException exact application/origin mismatch messages at 69/75 include key, receiver, name, client type. Null AccessDTO.value can NPE in equality; no catch.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `accessValidation` | `throw new AccessibilityException("key is not permitted for key= " + key + ", receiver = " + receiver + ", peerName = " + peerName + ", clientType = " + client.getClass().getSimpleName());` | [src/com/nozha/async/server/biz/AccessibilityService.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L69) |
| throw_statement / `accessValidation` | `throw new AccessibilityException("origin is not permitted for key= " + key + ", receiver = " + receiver + ", peerName = " + peerName + ", clientType = " + client.getClass().getSimpleName());` | [src/com/nozha/async/server/biz/AccessibilityService.java:75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L75) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `accessValidation` | `("key is not permitted for key = {}, receiver = {}, peerName = {}, clientType = {}", key, receiver, peerName, client.getClass().getSimpleName())` | TRUE (Settings.IS_ACCESS_VALIDATION_ENABLE && accessList != null && !accessList.isEmpty() && key != null && !key.equals("null") && accessList.stream().noneMatch(v -> v != null && (v instanceof AccessDTO ? ((AccessDTO) v).getValue().equals(key) : v.equals(key)))) @63; TRUE (isKeyAvailable) @65; TRUE (!Settings.IS_APPLICATION_KEY_RAISE_EXCEPTION_ENABLE) @66 | ALOG-CA9D4FF2A292 | [src/com/nozha/async/server/biz/AccessibilityService.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L67) |
| INFO `logger` / `accessValidation` | `("origin is not permitted for key = {}, receiver = {}, peerName = {}, clientType = {}", key, receiver, peerName, client.getClass().getSimpleName())` | TRUE (Settings.IS_ACCESS_VALIDATION_ENABLE && accessList != null && !accessList.isEmpty() && key != null && !key.equals("null") && accessList.stream().noneMatch(v -> v != null && (v instanceof AccessDTO ? ((AccessDTO) v).getValue().equals(key) : v.equals(key)))) @63; FALSE/else (isKeyAvailable) @65; TRUE (!accessList.contains("*")) @71; TRUE (!Settings.IS_ORIGIN_RAISE_EXCEPTION_ENABLE) @72 | ALOG-10E8F12FDE47 | [src/com/nozha/async/server/biz/AccessibilityService.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L73) |
| INFO `logger` / `accessValidation` | `("access validation, accessListSize = {}, key = {}, clientType = {}", accessList != null ? accessList.size() : 0, key, client.getClass().getSimpleName())` | FALSE/else (Settings.IS_ACCESS_VALIDATION_ENABLE && accessList != null && !accessList.isEmpty() && key != null && !key.equals("null") && accessList.stream().noneMatch(v -> v != null && (v instanceof AccessDTO ? ((AccessDTO) v).getValue().equals(key) : v.equals(key)))) @63 | ALOG-3F1C49C21020 | [src/com/nozha/async/server/biz/AccessibilityService.java:79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L79) |
Registry reconciliation: 3 active calls, 3 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessAccessList. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-biz-loadmanager

<!-- source dossier: src/com/nozha/async/server/biz/LoadManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-static-candidate
review_status: source-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/com/nozha/async/server/biz/LoadManager.java
source_sha256: a13e3ac48c8595a11565e7250869eb66b0799cf72c80c6cc7adf12e735d1517d
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java
business_approved: false
runtime_tested: false
promoted: false
---

# LoadManager — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `LoadManager` (class_declaration) [src/com/nozha/async/server/biz/LoadManager.java:18–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L18-L74)
Delegates load records/counts to CacheUtil and validates open/send thresholds.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No own counter state: downstream distributed-cache behavior governs count accuracy.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/biz/LoadManager.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L19) |
| `loggerAddress` | `org.apache.logging.log4j.Logger` | [src/com/nozha/async/server/biz/LoadManager.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L20) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/biz/LoadManager.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L3); `com.nozha.async.server.client.Client` [src/com/nozha/async/server/biz/LoadManager.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L4); `com.nozha.async.server.exception.TooManyMessagesSentException` [src/com/nozha/async/server/biz/LoadManager.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L5); `com.nozha.async.server.exception.TooManyOpenedClientException` [src/com/nozha/async/server/biz/LoadManager.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L6); `com.nozha.async.server.model.Peer` [src/com/nozha/async/server/biz/LoadManager.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L7); `com.nozha.async.server.util.CacheUtil` [src/com/nozha/async/server/biz/LoadManager.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L8); `com.nozha.async.server.util.ClientHelper` [src/com/nozha/async/server/biz/LoadManager.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L9); `com.nozha.async.server.vo.log.OpenClientAddressLog` [src/com/nozha/async/server/biz/LoadManager.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L10); `org.apache.logging.log4j.LogManager` [src/com/nozha/async/server/biz/LoadManager.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L11); `org.slf4j.Logger` [src/com/nozha/async/server/biz/LoadManager.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L12); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/biz/LoadManager.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L13)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/HttpHandler.java:163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L163) ` LoadManager.validateAndSetOpeningClient(client);`; [src/com/nozha/async/server/handler/WebsocketHandler.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L116) ` LoadManager.validateAndSetOpeningClient(websocketClient);`; [src/com/nozha/async/server/handler/TcpHandler.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L99) ` LoadManager.validateAndSetOpeningClient(client);`; [src/com/nozha/async/server/biz/MessageManager.java:154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L154) ` LoadManager.validateSendMessage(client, peer);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `static void putMessage( long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout )` | Forward message counter fields/time/expiry to cache. | [src/com/nozha/async/server/biz/LoadManager.java:22–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L22-L31) |
| `static long countMessagesByReceiver(long receiverId, long toTime)` | Forward receiver count query. | [src/com/nozha/async/server/biz/LoadManager.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L33-L35) |
| `public static void validateAndSetOpeningClient(Client client) throws TooManyOpenedClientException` | Calculate concrete type and current time, compare address opening count strictly > configured cap; log structured rejection and throw, else record opening. | [src/com/nozha/async/server/biz/LoadManager.java:37–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L37-L46) |
| `static void validateSendMessage(Client client, Peer receiver) throws TooManyMessagesSentException` | Select maxCount for no peer or unnamed peer; debug cap/address. When cap>0 check peer-sender count then address count strictly >cap and throw; named peer path bypasses limits. | [src/com/nozha/async/server/biz/LoadManager.java:48–73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L48-L73) |

## Business
SOURCE_OBSERVED: Opening is rejected only when prior count is strictly greater than PEER_COUNT_TO_REFUSE, otherwise record opening. Send limit is enabled only for absent/unnamed peer; named peers leave maxCount zero (48–73).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
TooManyOpenedClientException at 42 includes address/type; TooManyMessagesSentException at 64/70 includes peer ID/address; checked errors propagate. Cache failures may return sentinel values, so enforcement depends on cache semantics.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `validateAndSetOpeningClient` | `throw new TooManyOpenedClientException("There is too many opened clients from " + client.getAddress() + " type: " + type);` | [src/com/nozha/async/server/biz/LoadManager.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L42) |
| throw_statement / `validateSendMessage` | `throw new TooManyMessagesSentException("There is too many sent messages from " + client.getPeer().getId());` | [src/com/nozha/async/server/biz/LoadManager.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L64) |
| throw_statement / `validateSendMessage` | `throw new TooManyMessagesSentException("There is too many sent messages from " + client.getAddress());` | [src/com/nozha/async/server/biz/LoadManager.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L70) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| ERROR `loggerAddress` / `validateAndSetOpeningClient` | `(new OpenClientAddressLog(client.getAddress(),type))` | TRUE (CacheUtil.countOpenedClientByRemoteAddress(client.getAddress(), now) > Settings.PEER_COUNT_TO_REFUSE) @40 | ALOG-F1BC7F5A3338 | [src/com/nozha/async/server/biz/LoadManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L41) |
| DEBUG `logger` / `validateSendMessage` | `("maxCount: {}", maxCount)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-8A7CD9D8341B | [src/com/nozha/async/server/biz/LoadManager.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L58) |
| DEBUG `logger` / `validateSendMessage` | `("client.getAddress(): {}", client.getAddress())` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-EF1176DCD524 | [src/com/nozha/async/server/biz/LoadManager.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L59) |
| DEBUG `logger` / `validateSendMessage` | `("countMessagesBySenderRemoteAddress: {}", countMsgBySender)` | TRUE (maxCount > 0) @60 | ALOG-4204D53DF7D1 | [src/com/nozha/async/server/biz/LoadManager.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L68) |
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: loggerAddress. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-biz-messagemanager

<!-- source dossier: src/com/nozha/async/server/biz/MessageManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-static-candidate
review_status: source-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/com/nozha/async/server/biz/MessageManager.java
source_sha256: a2d68b796404ad28e961ff9f7e6782daf955a2241eeb6ebfafef20d3e5d940f7
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java
business_approved: false
runtime_tested: false
promoted: false
---

# MessageManager — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `MessageManager` (class_declaration) [src/com/nozha/async/server/biz/MessageManager.java:35–603](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L35-L603), `PeerQueueItem` (class_declaration) [src/com/nozha/async/server/biz/MessageManager.java:543–602](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L543-L602), `QueueItemVO` (class_declaration) [src/com/nozha/async/server/biz/MessageManager.java:605–627](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L605-L627)
Builds/routs messages, collapse updates, status/ACK persistence, and optional per-peer JMS overload queues. QueueItemVO and PeerQueueItem are additional types in same file.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Shared JMS session across threads; maps synchronized individually, compound initialization uses synchronized factory method. Client map key retained if queueMessage fails after insertion. PeerQueueItem.loop is ordinary flag without an exposed stop; shutdown closes session/connection rather than joining threads. Binary offline persistence exclusions are in Server, not universal here.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/biz/MessageManager.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L36) |
| `factory` | `ActiveMQConnectionFactory` | [src/com/nozha/async/server/biz/MessageManager.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L38) |
| `connection` | `Connection` | [src/com/nozha/async/server/biz/MessageManager.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L39) |
| `session` | `Session` | [src/com/nozha/async/server/biz/MessageManager.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L40) |
| `peerQueueMap` | `Map<Long, PeerQueueItem>` | [src/com/nozha/async/server/biz/MessageManager.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L42) |
| `clientMap` | `Map<Long, Client>` | [src/com/nozha/async/server/biz/MessageManager.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L43) |
| `clientMapKey` | `AtomicLong` | [src/com/nozha/async/server/biz/MessageManager.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L44) |
| `serversInCluster` | `List<String>` | [src/com/nozha/async/server/biz/MessageManager.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L45) |
| `peer` | `Peer` | [src/com/nozha/async/server/biz/MessageManager.java:544](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L544) |
| `producer` | `MessageProducer` | [src/com/nozha/async/server/biz/MessageManager.java:545](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L545) |
| `consumer` | `MessageConsumer` | [src/com/nozha/async/server/biz/MessageManager.java:546](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L546) |
| `loop` | `boolean` | [src/com/nozha/async/server/biz/MessageManager.java:547](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L547) |
| `clientKey` | `long` | [src/com/nozha/async/server/biz/MessageManager.java:606](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L606) |
| `message` | `Message` | [src/com/nozha/async/server/biz/MessageManager.java:607](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L607) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/biz/MessageManager.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L3); `com.nozha.async.server.Server` [src/com/nozha/async/server/biz/MessageManager.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L4); `com.nozha.async.server.activemq.local.AsyncInternalMessageSender` [src/com/nozha/async/server/biz/MessageManager.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L5); `com.nozha.async.server.activemq.local.AsyncManager` [src/com/nozha/async/server/biz/MessageManager.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L6); `com.nozha.async.server.client.Client` [src/com/nozha/async/server/biz/MessageManager.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L7); `com.nozha.async.server.client.HttpClient` [src/com/nozha/async/server/biz/MessageManager.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L8); `com.nozha.async.server.exception.AccessibilityException` [src/com/nozha/async/server/biz/MessageManager.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L9); `com.nozha.async.server.exception.ServerException` [src/com/nozha/async/server/biz/MessageManager.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L10); `com.nozha.async.server.exception.TooManyMessagesSentException` [src/com/nozha/async/server/biz/MessageManager.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L11); `com.nozha.async.server.model.Message` [src/com/nozha/async/server/biz/MessageManager.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L12); `com.nozha.async.server.model.Peer` [src/com/nozha/async/server/biz/MessageManager.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L13); `com.nozha.async.server.persistance.ClientCRUD` [src/com/nozha/async/server/biz/MessageManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L14); `com.nozha.async.server.persistance.MessageCRUD` [src/com/nozha/async/server/biz/MessageManager.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L15); `com.nozha.async.server.persistance.PeerCRUD` [src/com/nozha/async/server/biz/MessageManager.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L16); `com.nozha.async.server.ratelimit.RateLimitService` [src/com/nozha/async/server/biz/MessageManager.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L17); `com.nozha.async.server.util.*` [src/com/nozha/async/server/biz/MessageManager.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L18); `com.nozha.async.server.vo.MessageVO` [src/com/nozha/async/server/biz/MessageManager.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L19); `com.nozha.async.server.vo.MessageWrapperVO` [src/com/nozha/async/server/biz/MessageManager.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L20); `org.apache.activemq.ActiveMQConnectionFactory` [src/com/nozha/async/server/biz/MessageManager.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L21); `org.apache.activemq.command.ActiveMQQueue` [src/com/nozha/async/server/biz/MessageManager.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L22); `org.apache.commons.lang3.StringUtils` [src/com/nozha/async/server/biz/MessageManager.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L23); `org.slf4j.Logger` [src/com/nozha/async/server/biz/MessageManager.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L24); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/biz/MessageManager.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L25); `javax.jms.*` [src/com/nozha/async/server/biz/MessageManager.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L27); `java.io.Serializable` [src/com/nozha/async/server/biz/MessageManager.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L28); `java.util.*` [src/com/nozha/async/server/biz/MessageManager.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L29); `java.util.concurrent.atomic.AtomicLong` [src/com/nozha/async/server/biz/MessageManager.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L30)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L124) ` MessageManager.connect();`; [src/com/nozha/async/server/handler/HttpHandler.java:323](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L323) ` MessageManager.createMessage(client, (MessageWrapperVO) inputContent, true);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentException, ServerException, AccessibilityException` | Parse wrapper content or embedded MessageVO. Validate explicit receiver IDs when access enabled. No recipients/devices: lookup peerName, optionally access check, create only if peer or nonzero tracker. Explicit IDs/devices: load per-recipient peer and create private message; missing peers log and omit. Devices require client peer. Return successful messages. | [src/com/nozha/async/server/biz/MessageManager.java:47–130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47-L130) |
| `private static Message getMessage( Client client, Peer peer, MessageWrapperVO messageWrapperVO, MessageVO messageVO, boolean isPrivate, boolean sync ) throws TooManyMessagesSentException, ServerException` | Reject blocked receiver; collapseId lookup uses sender peer. New message: optional WebSocket load check, copy binary/tracker/sync/private/options; default priority writes MessageVO but leaves new Message primitive priority unchanged; assign times/type/TTL/content/address/origin/status and conditional ARN. Overloaded named peer+queue branch enqueues, JMS failure DB fallback+counter. Else resolve receiver server, ID generation app or DB, -1 writes active NOT_SENT current server; local internal, local cluster producer or DB active route; log routing and WebSocket counter. Collapse branch updates sync/time/expiry/content only, persists collapse. | [src/com/nozha/async/server/biz/MessageManager.java:132–290](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L132-L290) |
| `private static void queueMessage(Client client, Peer receiver, Message message) throws JMSException` | Lookup/create per-peer queue; allocate atomic client key, store client then publish queue item; log client/receiver. | [src/com/nozha/async/server/biz/MessageManager.java:292–301](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L292-L301) |
| `private static synchronized PeerQueueItem createPeerQueueItem(Peer receiver) throws JMSException` | Synchronized double lookup; construct/start queue thread and register map once. | [src/com/nozha/async/server/biz/MessageManager.java:303–312](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L303-L312) |
| `private static boolean isQueueEnabled()` | Return factory non-null, not broker health. | [src/com/nozha/async/server/biz/MessageManager.java:314–316](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L314-L316) |
| `private static long getTtl(Long messageTTL, int peerTTL)` | Null or zero message TTL maps MAX_TTL; positive peerTTL caps; positive result caps MAX_TTL; negative TTL survives unless positive peer cap applies. | [src/com/nozha/async/server/biz/MessageManager.java:318–331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L318-L331) |
| `public static void handleCreatedPendingMessageNotSent(Message message)` | CREATED receiver!=0→NOT_SENT, receiver0 archive; PENDING retry now; other status diagnostic only. | [src/com/nozha/async/server/biz/MessageManager.java:333–346](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L333-L346) |
| `public static void handleMessageNotSent(Message message)` | CREATED receiver0 archive; nonzero CREATED status change is commented/no-op; PENDING retry now. | [src/com/nozha/async/server/biz/MessageManager.java:348–359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L348-L359) |
| `public static void doMessageSent(Message message)` | PEER_REMOVED/-3, peers/7, ACK-needed/4 and sender-ACK-needed/5→PENDING; other types set SENT and archive. | [src/com/nozha/async/server/biz/MessageManager.java:361–374](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L361-L374) |
| `public static boolean doMessageSent(Message message, boolean fromActive)` | Only fromActive and ACK-required types: PENDING, version increment, synchronous active DB create; return whether create returned non-null; ordinary active type is not archived here. | [src/com/nozha/async/server/biz/MessageManager.java:376–391](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L376-L391) |
| `public static void doMessagesSent(Set<Message> messages)` | For set members same ACK-required types change PENDING; others set SENT then bulk archive filtered list. | [src/com/nozha/async/server/biz/MessageManager.java:393–409](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L393-L409) |
| `public static List<Message> loadMessageByStatus(int status, int serverMessageToSendCount)` | PENDING uses dedicated pending loader, other status generic loader. | [src/com/nozha/async/server/biz/MessageManager.java:411–419](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L411-L419) |
| `public static List<Message> loadNotSentMessages(long receiverId)` | Delegate receiver NOT_SENT lookup. | [src/com/nozha/async/server/biz/MessageManager.java:421–423](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L421-L423) |
| `@Deprecated public static void collapseMessages()` | Deprecated persistence collapse delegation. | [src/com/nozha/async/server/biz/MessageManager.java:425–428](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L425-L428) |
| `public static void deleteExpiredMessages()` | Delegate expired-message deletion. | [src/com/nozha/async/server/biz/MessageManager.java:430–432](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L430-L432) |
| `public static Message ackMessage(Client client, MessageWrapperVO messageWrapperVO)` | Deserialize wrapper content MessageVO; archive ACK matching client peer ID and messageId. | [src/com/nozha/async/server/biz/MessageManager.java:434–437](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L434-L437) |
| `public static void connect()` | Only configured nonempty queue address; lazily choose multicast discovery or comma TCP failover with timeouts/randomize/async/no-copy; create/start connection, client-ack session/listener; JMSException error suppressed. | [src/com/nozha/async/server/biz/MessageManager.java:439–506](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L439-L506) |
| `public static void close()` | Close non-null JMS session then connection; ignore JMSException separately. | [src/com/nozha/async/server/biz/MessageManager.java:519–532](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L519-L532) |
| `public static List<String> getServersInCluster()` | Lazy cache cluster-server comma list without trim, return same list. | [src/com/nozha/async/server/biz/MessageManager.java:534–540](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L534-L540) |
| `PeerQueueItem(Peer peer) throws JMSException` | Create rcv_msg_<server>_n_<peerName> queue, shared-session producer and consumer. | [src/com/nozha/async/server/biz/MessageManager.java:549–554](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L549-L554) |
| `@Override public void run()` | Loop while receiver load <= max; timed JMS receive. Bytes→deserialize QueueItemVO, remove client association, DB create/counter/post-action; acknowledge any non-null JMS message including nonbytes. Sleep between overload checks; Throwable WARN and continue. | [src/com/nozha/async/server/biz/MessageManager.java:556–591](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L556-L591) |
| `void queueMessage(long clientKey, Message message) throws JMSException` | Serialize client key+message as JSON using platform default bytes into JMS BytesMessage and producer.send. | [src/com/nozha/async/server/biz/MessageManager.java:593–600](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L593-L600) |
| `QueueItemVO()` | Empty QueueItemVO constructor. | [src/com/nozha/async/server/biz/MessageManager.java:609–610](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L609-L610) |
| `long getClientKey()` | Read client association key. | [src/com/nozha/async/server/biz/MessageManager.java:612–614](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L612-L614) |
| `void setClientKey(long clientKey)` | Assign client key. | [src/com/nozha/async/server/biz/MessageManager.java:616–618](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L616-L618) |
| `public Message getMessage()` | Return stored value/reference: message. No validation or copying. | [src/com/nozha/async/server/biz/MessageManager.java:620–622](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L620-L622) |
| `public void setMessage(Message message)` | Assign this.message = message. No validation or copying. | [src/com/nozha/async/server/biz/MessageManager.java:624–626](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L624-L626) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: recipient IDs/device IDs are private; name/tracker path nonprivate. Missing recipient silently omits that output. ACK-needed types remain PENDING after send while ordinary messages become SENT/archive. Overloaded named peers can queue; queue failure falls back DB creation.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Provider block throws ServerException with receiver/name/uniqueId (142–143); access/load and ID-generation checked errors propagate. JMS queue failure warns and falls back DB. connect suppresses JMSException; close suppresses cleanup failures. PeerQueueItem catches Throwable and loops; messages are acknowledged after DB/post-action handling.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `getMessage` | `throw new ServerException("receiver is blocked, peerId=" + receiver + " peerName=" + (peer.getName() != null ? peer.getName() : "") + " uniqueId=" + (messageWrapperVO.getUniqueId() != null ? messageWrapperVO.getUniqueId() : ""));` | [src/com/nozha/async/server/biz/MessageManager.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L142) |
| catch_clause / `getMessage` | `} catch (JMSException e) {` | [src/com/nozha/async/server/biz/MessageManager.java:223](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L223) |
| catch_clause / `connect` | `} catch (JMSException e) {` | [src/com/nozha/async/server/biz/MessageManager.java:502](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L502) |
| catch_clause / `close` | `} catch (JMSException ignored) {` | [src/com/nozha/async/server/biz/MessageManager.java:523](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L523) |
| catch_clause / `close` | `} catch (JMSException ignored) {` | [src/com/nozha/async/server/biz/MessageManager.java:529](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L529) |
| catch_clause / `run` | `} catch (Throwable e) {` | [src/com/nozha/async/server/biz/MessageManager.java:587](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L587) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `createMessage` | `("peer does not exists. peerName={}", messageVO.getPeerName())` | TRUE ((receivers == null \\|\\| receivers.length == 0) && (receiverDevices == null \\|\\| receiverDevices.length == 0)) @62; FALSE/else (peer != null \\|\\| (messageWrapperVO.getTrackerId() != null && messageWrapperVO.getTrackerId() != 0)) @71 | ALOG-AE6CF51DA574 | [src/com/nozha/async/server/biz/MessageManager.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L84) |
| INFO `logger` / `createMessage` | `("peer does not exists. peerId={}", receiver)` | FALSE/else ((receivers == null \\|\\| receivers.length == 0) && (receiverDevices == null \\|\\| receiverDevices.length == 0)) @62; TRUE (receivers != null) @87; LOOP for (long receiver : receivers) @88; FALSE/else (peer != null) @90 | ALOG-6F069BD14A07 | [src/com/nozha/async/server/biz/MessageManager.java:103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L103) |
| INFO `logger` / `createMessage` | `("peer does not exists. device id={} , senderId={}", receiverDevice, senderId)` | FALSE/else ((receivers == null \\|\\| receivers.length == 0) && (receiverDevices == null \\|\\| receiverDevices.length == 0)) @62; TRUE (receiverDevices != null) @107; LOOP for (String receiverDevice : receiverDevices) @109; FALSE/else (peer != null) @111 | ALOG-91F8D832CBCD | [src/com/nozha/async/server/biz/MessageManager.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L124) |
| INFO `logger` / `getMessage` | `("queue trackerId={}", messageWrapperVO.getTrackerId())` | TRUE (collapseMessage == null) @152; TRUE (peer != null && peer.getName() != null && peer.getMaxMessageCount() > 0 && isQueueEnabled() && (msgCount = LoadManager.countMessagesByReceiver(receiver, System.currentTimeMillis())) > peer.getMaxMessageCount() ) @214; TRUE (messageWrapperVO.getTrackerId() != null && messageWrapperVO.getTrackerId() != 0) @218 | ALOG-EEC25CE4C355 | [src/com/nozha/async/server/biz/MessageManager.java:219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L219) |
| DEBUG `logger` / `getMessage` | `("peer name: {} id: {} over loaded. count: {}. trying to queue messages", peer.getName(), peer.getId(), msgCount)` | TRUE (collapseMessage == null) @152; TRUE (peer != null && peer.getName() != null && peer.getMaxMessageCount() > 0 && isQueueEnabled() && (msgCount = LoadManager.countMessagesByReceiver(receiver, System.currentTimeMillis())) > peer.getMaxMessageCount() ) @214 | ALOG-23BDFA609A76 | [src/com/nozha/async/server/biz/MessageManager.java:221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L221) |
| WARN `logger` / `getMessage` | `("An exception occurred in queueMessage ", e)` | TRUE (collapseMessage == null) @152; TRUE (peer != null && peer.getName() != null && peer.getMaxMessageCount() > 0 && isQueueEnabled() && (msgCount = LoadManager.countMessagesByReceiver(receiver, System.currentTimeMillis())) > peer.getMaxMessageCount() ) @214; CATCH catch (JMSException e) @223 | ALOG-0A2AD298419B | [src/com/nozha/async/server/biz/MessageManager.java:224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L224) |
| INFO `logger` / `getMessage` | `("messageId={}, uniqueId={}, trackerId={}, from={} ,receiverServerId={} ,senderId={} ,receiverId={}, currentTimeMillis={}", message.getId(), messageWrapperVO.getUniqueId(), messageWrapperVO.getTrackerId(), messageSendFrom, receiverServer, message.getSender(), message.getReceiver(), System.currentTimeMillis())` | TRUE (collapseMessage == null) @152; FALSE/else (peer != null && peer.getName() != null && peer.getMaxMessageCount() > 0 && isQueueEnabled() && (msgCount = LoadManager.countMessagesByReceiver(receiver, System.currentTimeMillis())) > peer.getMaxMessageCount() ) @214; FALSE/else (receiverServer == -1) @244 | ALOG-41343CC10AB4 | [src/com/nozha/async/server/biz/MessageManager.java:261–269](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L261-L269) |
| INFO `logger` / `queueMessage` | `("message put in queue for client={} receiver={}", client.getId(), receiver.getId())` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-5E6A2E921FD2 | [src/com/nozha/async/server/biz/MessageManager.java:300](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L300) |
| INFO `logger` / `createPeerQueueItem` | `("peer load control queue is configured: {}", receiver.getId())` | TRUE (peerQueueItem == null) @305 | ALOG-C2AA8D3C5D79 | [src/com/nozha/async/server/biz/MessageManager.java:309](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L309) |
| INFO `logger` / `handleCreatedPendingMessageNotSent` | `("handleCreatedPendingMessageNotSent messageId={}, messageStatus={}, messageReceiver={}", message.getId(), message.getStatus(), message.getReceiver())` | FALSE/else (message.getStatus() == Message.CREATED) @334; FALSE/else (message.getStatus() == Message.PENDING) @341 | ALOG-59988654B084 | [src/com/nozha/async/server/biz/MessageManager.java:344](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L344) |
| WARN `logger` / `connect` | `("An exception occurred in connection", exception)` | TRUE (Settings.SERVER_PEER_QUEUE_ADDRESS != null && !Objects.equals("", Settings.SERVER_PEER_QUEUE_ADDRESS)) @440 | ALOG-8CAF504F3F68 | [src/com/nozha/async/server/biz/MessageManager.java:490](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L490) |
| INFO `logger` / `connect` | `("load control queue connected")` | TRUE (Settings.SERVER_PEER_QUEUE_ADDRESS != null && !Objects.equals("", Settings.SERVER_PEER_QUEUE_ADDRESS)) @440 | ALOG-346A653C8A51 | [src/com/nozha/async/server/biz/MessageManager.java:491](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L491) |
| ERROR `logger` / `connect` | `("An exception occurred in connect to active for MessageManager", e)` | TRUE (Settings.SERVER_PEER_QUEUE_ADDRESS != null && !Objects.equals("", Settings.SERVER_PEER_QUEUE_ADDRESS)) @440; CATCH catch (JMSException e) @502 | ALOG-8C66F8A871EC | [src/com/nozha/async/server/biz/MessageManager.java:503](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L503) |
| WARN `logger` / `run` | `("An exception occurred in PeerQueueItem thread", e)` | LOOP while (loop) @558; CATCH catch (Throwable e) @587 | ALOG-8AC383BE4B17 | [src/com/nozha/async/server/biz/MessageManager.java:588](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L588) |
Registry reconciliation: 14 active calls, 14 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-biz-registrationmanager

<!-- source dossier: src/com/nozha/async/server/biz/RegistrationManager.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-static-candidate
review_status: source-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/com/nozha/async/server/biz/RegistrationManager.java
source_sha256: 60b15670ef83b9f06d7bc79f8e42b5227e49685f77c9482831244d67f501f47b
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java
business_approved: false
runtime_tested: false
promoted: false
---

# RegistrationManager — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `RegistrationManager` (class_declaration) [src/com/nozha/async/server/biz/RegistrationManager.java:25–320](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L25-L320)
Registration, membership, receiver selection and transport registration persistence coordinator.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No transaction across peer/client/device actions. generateOwnerName is random times current epoch, no uniqueness check. Calls UserAuthentication no-op. Multi-CoAP unregistration queries DeviceCRUD peer IDs (282), which differs from single CoapCRUD lookup.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/biz/RegistrationManager.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L26) |
Dependencies are imports (some may be unused): `com.fasterxml.jackson.core.type.TypeReference` [src/com/nozha/async/server/biz/RegistrationManager.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L3); `com.nozha.Settings` [src/com/nozha/async/server/biz/RegistrationManager.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L4); `com.nozha.async.server.Server` [src/com/nozha/async/server/biz/RegistrationManager.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L5); `com.nozha.async.server.client.Client` [src/com/nozha/async/server/biz/RegistrationManager.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L6); `com.nozha.async.server.exception.BusinessException` [src/com/nozha/async/server/biz/RegistrationManager.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L7); `com.nozha.async.server.exception.ClientException` [src/com/nozha/async/server/biz/RegistrationManager.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L8); `com.nozha.async.server.exception.ServerException` [src/com/nozha/async/server/biz/RegistrationManager.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L9); `com.nozha.async.server.handler.QueueHandler` [src/com/nozha/async/server/biz/RegistrationManager.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L10); `com.nozha.async.server.model.*` [src/com/nozha/async/server/biz/RegistrationManager.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L11); `com.nozha.async.server.persistance.*` [src/com/nozha/async/server/biz/RegistrationManager.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L12); `com.nozha.async.server.util.CacheUtil` [src/com/nozha/async/server/biz/RegistrationManager.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L13); `com.nozha.async.server.util.JsonUtil` [src/com/nozha/async/server/biz/RegistrationManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L14); `com.nozha.async.server.util.MessageType` [src/com/nozha/async/server/biz/RegistrationManager.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L15); `com.nozha.async.server.vo.*` [src/com/nozha/async/server/biz/RegistrationManager.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L16); `org.slf4j.Logger` [src/com/nozha/async/server/biz/RegistrationManager.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L17); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/biz/RegistrationManager.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L18); `java.util.*` [src/com/nozha/async/server/biz/RegistrationManager.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L20)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L392) ` RegistrationManager.getPeersNotSeenDuration(client, messageWrapperVO);`; [src/com/nozha/async/server/handler/TcpHandler.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L130) ` Peer peer = RegistrationManager.checkPeer(peerInfoVO);`; [src/com/nozha/async/server/httpserver/UnregisterServlet.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L43) ` removedClient.addAll(RegistrationManager.unregisterCoap(clientsId));`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L122) ` peer = RegistrationManager.registerPeerForOwner(peerInfo);`; [src/com/nozha/async/server/vo/ClientMessage.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L41) ` if (message.isPrvt() && message.getSender() != 0 && RegistrationManager.isPeerRegistrationExists(message.getReceiver(), message.getSender()`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static Peer registerPeerForUser(PeerInfoVO peerInfo) throws Exception` | Delegate new/existing user identity registration with owner=false. | [src/com/nozha/async/server/biz/RegistrationManager.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L28-L30) |
| `public static Peer registerPeerForOwner(PeerInfoVO peerInfo) throws Exception` | Delegate registration with owner=true. | [src/com/nozha/async/server/biz/RegistrationManager.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L32-L34) |
| `private static Peer registerPeer(PeerInfoVO peerInfo, boolean owner) throws Exception` | Reject empty device/app; invoke no-op authenticate; create peer if pair absent and optionally generate owner name, else load user peer or reject owner. Log changed nonzero requested peer ID. | [src/com/nozha/async/server/biz/RegistrationManager.java:36–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L36-L71) |
| `private static String generateOwnerName()` | Return decimal pseudo-random long scaled by current epoch; collision prevention absent here. | [src/com/nozha/async/server/biz/RegistrationManager.java:73–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L73-L76) |
| `public static Peer checkPeer(PeerInfoVO peerInfoVO) throws BusinessException` | Renew branch removes server peer, DB peer and nonzero client mapping; load by supplied ID, fallback app/device lookup, otherwise register user. Wrap only registration exceptions; return resulting peer. | [src/com/nozha/async/server/biz/RegistrationManager.java:78–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L78-L112) |
| `public static Peer loadPeer(long token) throws BusinessException` | Load peer by token/ID; throw BusinessException if missing. | [src/com/nozha/async/server/biz/RegistrationManager.java:114–120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L114-L120) |
| `public static void registerInPeer(MessageWrapperVO messageWrapperVO, long registeringId) throws BusinessException` | Deserialize owner name; require named owner and registering peer; log, insert membership if absent, update Server memory membership, create private type SERVER_REGISTER notification with registration TTL. | [src/com/nozha/async/server/biz/RegistrationManager.java:122–151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L122-L151) |
| `public static void registerReceiver(Client client, MessageWrapperVO messageWrapperVO) throws BusinessException` | Deserialize name, require peer, assign client receiverPeer then log. | [src/com/nozha/async/server/biz/RegistrationManager.java:153–161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L153-L161) |
| `public static void registerQueue(MessageWrapperVO messageWrapperVO)` | Deserialize QueueRegistration and invoke QueueHandler.register. | [src/com/nozha/async/server/biz/RegistrationManager.java:163–165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L163-L165) |
| `public static void getRegisteredPeers(Client client, MessageWrapperVO messageWrapperVO)` | Deserialize MessageVO and device-ID list; query memberships, project id/deviceId, persist private GET_REGISTERED_PEERS reply with sender 0, request messageId and SERVER_TTL. | [src/com/nozha/async/server/biz/RegistrationManager.java:167–193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L167-L193) |
| `public static void getPeersNotSeenDuration(Client client, MessageWrapperVO messageWrapperVO)` | Deserialize peer-ID list; include only last-seen values not null/-1; calculate current epoch minus last seen; persist private GET_PEERS_NOT_SEEN_DURATION reply with request messageId. | [src/com/nozha/async/server/biz/RegistrationManager.java:195–222](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L195-L222) |
| `public static void createQueueRegistration(QueueRegistration queueRegistration) throws ServerException` | Stamp now and persist QueueRegistration. | [src/com/nozha/async/server/biz/RegistrationManager.java:224–227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L224-L227) |
| `public static void createDeviceRegistration(DeviceRegistration deviceRegistration) throws ServerException` | Stamp now and persist DeviceRegistration. | [src/com/nozha/async/server/biz/RegistrationManager.java:229–232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L229-L232) |
| `public static void createRestRegistration(RestRegistration restRegistration) throws ServerException` | Stamp now and persist RestRegistration. | [src/com/nozha/async/server/biz/RegistrationManager.java:234–237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L234-L237) |
| `public static void createCoapRegistration(CoapRegistration coapRegistration) throws ServerException` | Stamp now and persist CoapRegistration. | [src/com/nozha/async/server/biz/RegistrationManager.java:239–242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L239-L242) |
| `public static List<String> unregisterDevice(List<String> clientsId)` | Single ID delegates boolean removal and conditionally returns ID; multi-ID query DeviceCRUD peer IDs, empty yields empty; otherwise delete registrations and peers and return all inputs. | [src/com/nozha/async/server/biz/RegistrationManager.java:244–259](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L244-L259) |
| `public static boolean unregisterDevice(String clientId)` | Load device registration before try; remove registration then peer if removal true; return conjunction; any Exception inside try returns false. | [src/com/nozha/async/server/biz/RegistrationManager.java:261–273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L261-L273) |
| `public static List<String> unregisterCoap(List<String> clientsId)` | Single CoAP ID delegates boolean method; multi-ID branch uses DeviceCRUD.getPeerIdsByClientId then CoapCRUD deletion and PeerCRUD deletion; empty peer IDs yields empty. | [src/com/nozha/async/server/biz/RegistrationManager.java:275–290](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L275-L290) |
| `public static boolean unregisterCoap(String clientId)` | Load CoAP registration before try; remove then remove peer; return conjunction; suppress any Exception inside try into false. | [src/com/nozha/async/server/biz/RegistrationManager.java:292–304](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L292-L304) |
| `public static boolean isPeerRegistrationExists(long userPeerId, long ownerPeerId)` | Check Server membership cache first, otherwise persistence lookup; cache positive result only. | [src/com/nozha/async/server/biz/RegistrationManager.java:306–319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L306-L319) |

## Business
SOURCE_OBSERVED: Registers app/device identity; owner creation only for a new app/device pair. Renew removes old peer/client mapping; membership creates a private SERVER_REGISTER response; list/last-seen requests create private asynchronous replies.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
ClientException: empty app/device reports device id is empty; existing owner pair reports owner not exists. checkPeer wraps registration failures in BusinessException. Missing named owner/peer or invalid token throws BusinessException. Single unregistration suppresses Exception into false; bulk branch propagates failures and can report all input IDs although persistence outcome per ID is not checked.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `registerPeer` | `throw new ClientException("device id is empty");` | [src/com/nozha/async/server/biz/RegistrationManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L41) |
| throw_statement / `registerPeer` | `throw new ClientException("owner not exists");` | [src/com/nozha/async/server/biz/RegistrationManager.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L63) |
| catch_clause / `checkPeer` | `} catch (Exception e) {` | [src/com/nozha/async/server/biz/RegistrationManager.java:96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L96) |
| throw_statement / `checkPeer` | `throw new BusinessException(e);` | [src/com/nozha/async/server/biz/RegistrationManager.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L98) |
| catch_clause / `checkPeer` | `} catch (Exception e) {` | [src/com/nozha/async/server/biz/RegistrationManager.java:105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L105) |
| throw_statement / `checkPeer` | `throw new BusinessException(e);` | [src/com/nozha/async/server/biz/RegistrationManager.java:107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L107) |
| throw_statement / `loadPeer` | `throw new BusinessException("invalid peer info: token=" + token);` | [src/com/nozha/async/server/biz/RegistrationManager.java:117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L117) |
| throw_statement / `registerInPeer` | `throw new BusinessException("owner does not exists for " + registeringId + " in " + registrationRequestVO.getName());` | [src/com/nozha/async/server/biz/RegistrationManager.java:126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L126) |
| throw_statement / `registerInPeer` | `throw new BusinessException("peer does not exists");` | [src/com/nozha/async/server/biz/RegistrationManager.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L130) |
| throw_statement / `registerReceiver` | `throw new BusinessException("peer does not exists for " + registrationRequestVO.getName());` | [src/com/nozha/async/server/biz/RegistrationManager.java:157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L157) |
| catch_clause / `unregisterDevice` | `} catch (Exception ignore) {` | [src/com/nozha/async/server/biz/RegistrationManager.java:270](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L270) |
| catch_clause / `unregisterCoap` | `} catch (Exception ignore) {` | [src/com/nozha/async/server/biz/RegistrationManager.java:301](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L301) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `registerPeer` | `("peer id changed from {} to {}", peerInfo.getPeerId(), peer.getId())` | TRUE (peerInfo.getPeerId() != 0 && peer.getId() != peerInfo.getPeerId()) @66 | ALOG-7BC010A485EF | [src/com/nozha/async/server/biz/RegistrationManager.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L67) |
| INFO `logger` / `checkPeer` | `("renew peer, appId={}, deviceId={}", peerInfoVO.getAppId(), peerInfoVO.getDeviceId())` | TRUE (peerInfoVO.isRenew()) @79 | ALOG-9C085FFF3E36 | [src/com/nozha/async/server/biz/RegistrationManager.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L80) |
| WARN `logger` / `checkPeer` | `("An exception occurred in registerPeerForUser peerId=" + peerInfoVO.getPeerId(), e)` | TRUE (peerInfoVO.getPeerId() != 0) @88; TRUE (peer == null) @90; FALSE/else (PeerCRUD.isPeerExists(peerInfoVO.getAppId(), peerInfoVO.getDeviceId())) @91; CATCH catch (Exception e) @96 | ALOG-A1D85890F16F | [src/com/nozha/async/server/biz/RegistrationManager.java:97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L97) |
| WARN `logger` / `checkPeer` | `("An exception occurred in registerPeerForUser", e)` | FALSE/else (peerInfoVO.getPeerId() != 0) @88; CATCH catch (Exception e) @105 | ALOG-0C730522FD57 | [src/com/nozha/async/server/biz/RegistrationManager.java:106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L106) |
| INFO `logger` / `registerInPeer` | `("server reg: userPeerId={}, ownerPeerId={} ,peerRegistrationMapSize={}", registeringId, ownerId, Server.getInstance().getPeerRegistrationMapSize())` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-7295C5DDC603 | [src/com/nozha/async/server/biz/RegistrationManager.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L132) |
| INFO `logger` / `registerInPeer` | `("registration exists, userPeerId={} ,ownerPeerId={}", registeringId, ownerId)` | TRUE (PeerCRUD.isPeerRegistrationExists(pr)) @136 | ALOG-07A1F3FED817 | [src/com/nozha/async/server/biz/RegistrationManager.java:137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L137) |
| INFO `logger` / `registerReceiver` | `("receiver registered: peerId={} ,receiverRegistrationMapSize={}", peer.getId(), Server.getInstance().getPeerRegistrationMapSize())` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-567F92339F40 | [src/com/nozha/async/server/biz/RegistrationManager.java:160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L160) |
Registry reconciliation: 7 active calls, 7 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-biz-servicecallservice

<!-- source dossier: src/com/nozha/async/server/biz/ServiceCallService.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-reviewed-static-candidate
review_status: source-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/com/nozha/async/server/biz/ServiceCallService.java
source_sha256: 58fe072a294757c2192abda8be92728c1fddba06e81f0af76ffc3f73e2127ec1
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java
business_approved: false
runtime_tested: false
promoted: false
---

# ServiceCallService — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `ServiceCallService` (class_declaration) [src/com/nozha/async/server/biz/ServiceCallService.java:11–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L11-L44)
Holds dispatcher key→peerName map and blocker key set; initialize replaces both from ServiceCallCrud (16–19).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Initial dispatcher is ConcurrentHashMap but loaded implementation is external; blocker is initially unsynchronized HashSet and all setters mutate shared static state.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `serviceCallDispatcherMap` | `Map<String, String>` | [src/com/nozha/async/server/biz/ServiceCallService.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L13) |
| `serviceCallBlockerSet` | `Set<String>` | [src/com/nozha/async/server/biz/ServiceCallService.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L14) |
Dependencies are imports (some may be unused): `com.nozha.async.server.model.ServiceCallConfig` [src/com/nozha/async/server/biz/ServiceCallService.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L3); `com.nozha.async.server.persistance.ServiceCallCrud` [src/com/nozha/async/server/biz/ServiceCallService.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L4); `java.util.HashSet` [src/com/nozha/async/server/biz/ServiceCallService.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L6); `java.util.Map` [src/com/nozha/async/server/biz/ServiceCallService.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L7); `java.util.Set` [src/com/nozha/async/server/biz/ServiceCallService.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L8); `java.util.concurrent.ConcurrentHashMap` [src/com/nozha/async/server/biz/ServiceCallService.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L9)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:211](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L211) ` ServiceCallService.initialize();`; [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L89) ` ServiceCallService.updateServiceCallDispatcherMap(serviceCallConfig);`; [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L64) ` if (ServiceCallService.getServiceCallBlocker(productId) \|\|`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L84) ` String dispatchPeerName = ServiceCallService.getServiceCallDispatcher(scProductId + "#" + businessId);`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L58) ` String dispatchPeerName = ServiceCallService.getServiceCallDispatcher(scProductId + "#" + businessId);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Load both dispatcher and blocker collections from persistence; assignments are sequential, not an atomic refresh. | [src/com/nozha/async/server/biz/ServiceCallService.java:16–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L16-L19) |
| `public static String getServiceCallDispatcher(String key)` | Return map value for key. | [src/com/nozha/async/server/biz/ServiceCallService.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L21-L23) |
| `public static boolean getServiceCallBlocker(String key)` | Return false for null key; otherwise test blocker membership. | [src/com/nozha/async/server/biz/ServiceCallService.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L25-L27) |
| `public static void updateServiceCallDispatcherMap(ServiceCallConfig serviceCallConfig)` | Put config key→peerName into dispatcher map. | [src/com/nozha/async/server/biz/ServiceCallService.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L29-L31) |
| `public static void deleteServiceCallDispatcher(String key)` | Remove dispatcher key. | [src/com/nozha/async/server/biz/ServiceCallService.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L33-L35) |
| `public static void updateServiceCallConfig(ServiceCallConfig serviceCallConfig)` | Add config key into blocker set. | [src/com/nozha/async/server/biz/ServiceCallService.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L37-L39) |
| `public static void deleteServiceCallBlocker(String key)` | Remove blocker key. | [src/com/nozha/async/server/biz/ServiceCallService.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L41-L43) |

## Business
SOURCE_OBSERVED: Indirect service-call routing and blocking configuration; getter returns absent mapping/null, blocker explicitly rejects null key.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No local catch, validation or status mapping. Persistence failures propagate; null keys/DTOs may fail downstream collection operations.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:211](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L211), [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L89), [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L64), [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L84), [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L58).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
