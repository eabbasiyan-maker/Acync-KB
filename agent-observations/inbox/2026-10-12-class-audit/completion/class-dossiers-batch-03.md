# Async class dossiers — review batch 03


---

### dossier-src-com-nozha-async-server-biz-userauthentication

<!-- source dossier: src/com/nozha/async/server/biz/UserAuthentication.md -->

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
source_path: src/com/nozha/async/server/biz/UserAuthentication.java
source_sha256: c21edca8573bbaea8747b92fbf4df6722a91c1fb2e94330564697445603149e2
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java
business_approved: false
runtime_tested: false
promoted: false
---

# UserAuthentication — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.biz`. Types: `UserAuthentication` (class_declaration) [src/com/nozha/async/server/biz/UserAuthentication.java:9–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java#L9-L15)
authenticate(username,password) has only a TODO (12–14); logger is declared but unused.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/biz/UserAuthentication.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java#L10) |
Dependencies are imports (some may be unused): `org.slf4j.Logger` [src/com/nozha/async/server/biz/UserAuthentication.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java#L3); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/biz/UserAuthentication.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java#L4)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/RegistrationManager.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L43) ` UserAuthentication.authenticate(peerInfo.getUsername(), peerInfo.getPassword());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void authenticate(String username, String password)` | Empty body; no validation or side effect. | [src/com/nozha/async/server/biz/UserAuthentication.java:12–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/UserAuthentication.java#L12-L14) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: RegistrationManager calls this method, but it performs no credential validation. No approved authentication intent can be inferred from its name.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; credentials accepted by this no-op are checked only if another caller path provides independent validation.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/RegistrationManager.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L43).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-client-activemqamqpqueueclient

<!-- source dossier: src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L1-L157
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ActiveMQAMQPQueueClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 157 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor calls QueueClient setup. setup ([41–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L41-L83)) installs handlers, splits host:port default80, synchronized cache by serverURL-type creates Qpid ConnectionFactoryImpl, starts connection; CLIENT_ACKNOWLEDGE session, input consumer/output producer, loads peer and installs nested listeners. send ([110–121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L110-L121)) writes payload bytes, senderId/type/produceTime, expiry and PERSISTENT priority4 only if TTL>0. close ([86–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L86-L107)) individually suppresses JMS cleanup exceptions. QueueMessageListener ([125–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L125-L143)) ACKs before BytesMessage read/length check and forwards handler; exception callback delegates.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L36): `public ActiveMQAMQPQueueClient(QueueRegistration queueRegistration) throws Exception {`
- [86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L86): `public void close() throws IOException {`
- [110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L110): `public void send(OutboundPayload outboundPayload) throws JMSException {`
- [125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L125): `public void onMessage(Message message) {`
- [148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L148): `public void onException(JMSException exception) {`
- [154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L154): `public int getType() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.ExceptionListener`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.ClientHelper`, `org.apache.activemq.ActiveMQConnectionFactory`, `org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl`, `org.apache.qpid.amqp_1_0.jms.impl.QueueImpl`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.*`, `java.io.IOException`, `java.util.Collections`, `java.util.HashMap`, `java.util.Map`.
Configuration references: `SEND_MESSAGE_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/QueueHandler.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L116): `queueClient = new ActiveMQAMQPQueueClient(queueRegistration);`
- [src/com/nozha/async/server/util/ClientHelper.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L16): `if (clientClass.getName().equals(ActiveMQAMQPQueueClient.class.getName()))          type = 0x00020;`

Supplemental semantic review of explicit member and nested-type boundaries:

- **QueueExceptionListener nested class / onException** [146–151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L146-L151): Implements JMS ExceptionListener. Its sole callback forwards the JMSException to the shared handler.ExceptionListener, which logs peer/client context then synchronously invokes QueueHandler.reconnect; it neither retries nor catches independently.

## Business

SOURCE_OBSERVED: Provider integration across AMQP JMS queues; input means provider→Async, output Async→provider. Already ACKed malformed messages are not redelivered by this code.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Length mismatch throws ServerException("Inconsistance message length"), general catch only warns; JMSException warns and calls reconnect handler. Setup exceptions propagate; send JMSException propagates. Null consumer/producer during close can produce uncaught NPE. Expired send silently skipped.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L89): `} catch (JMSException ignored) {`
- [93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L93): `} catch (JMSException ignored) {`
- [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L98): `} catch (JMSException ignored) {`
- [104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L104): `} catch (JMSException ignored) {`
- [133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L133): `throw new ServerException("Inconsistance message length");`
- [137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L137): `} catch (JMSException e) {`
- [140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L140): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Factory setup info prints an ActiveMQ factory class even though Qpid is used; peer-scoped warnings only identify local receive failure.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L53) | ALOG-BAAB1DE9B8E8 | INFO | `logger.info("{} {} {}:{}", Settings.SEND_MESSAGE_TIMEOUT, ActiveMQConnectionFactory.class.getName(), split[0], port);` | `synchronized (factoryMap) { / ConnectionFactory connectionFactory = factoryMap.get(factoryKey); / int port = split.length == 1 ? 80 : Integer.parseInt(split[1], 10); / //todo check log` |
| [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L138) | ALOG-4B5096795B8F | WARN | `logger.warn("An exception occurred in ActiveMQAMQPQueueClient onMessage JMSException for peerId=" + peer.getId(), e);` | `} / messageListener.onMessage(buffer); / } / } catch (JMSException e) {` |
| [141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L141) | ALOG-0D58A6D9F701 | WARN | `logger.warn("An exception occurred in ActiveMQAMQPQueueClient onMessage for peerId=" + peer.getId(), e);` | `} catch (JMSException e) { / logger.warn("An exception occurred in ActiveMQAMQPQueueClient onMessage JMSException for peerId=" + peer.getId(), e); / exceptionListener.onException(e); / } catch (Exception e) {` |

Registry reconciliation: 3 rows for this file; 3 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-activemqopenwirequeueclient

<!-- source dossier: src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L1-L341
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ActiveMQOpenWireQueueClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 341 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor delegates QueueClient; last-send accessors forward parent. setup ([52–188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L52-L188)) caches separate producer/consumer factories by URL/type suffix; multicast selects discovery otherwise failover host lists (port80), async send/copy off/send timeout, randomization/backup, compression and consumer prefetch. Dispatch peer changes shared consumerFactory prefetch to1. Separate started connections/sessions (consumer CLIENT_ACKNOWLEDGE, producer AUTO_ACKNOWLEDGE). close ([191–240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L191-L240)) independently closes and clears six resources. send ([243–271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L243-L271)) logs nulls without returning, creates BytesMessage, honors ignoreTTL by TTL0, permits TTL>=0, adds produceTime/sender/type and configured persistence. Nested onMessage ([275–310](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L275-L310)) ACKs before bytes check, logs residence and broker URL threshold (fallback if inspection fails), updates lastSend for bytes and forwards text too. Producer/consumer exception listeners log queue/peer/registration/client and request reconnect.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L37): `public ActiveMQOpenWireQueueClient(QueueRegistration queueRegistration) throws Exception {`
- [42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L42): `public long getLastSendMessage() {`
- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L47): `public void setLastSendMessage(long lastSendMessage) {`
- [191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L191): `public void close() throws IOException {`
- [243](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L243): `public void send(OutboundPayload outboundPayload) throws JMSException {`
- [275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L275): `public void onMessage(Message message) {`
- [315](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L315): `public void onException(JMSException exception) {`
- [327](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L327): `public void onException(JMSException exception) {`
- [338](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L338): `public int getType() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.util.ClientHelper`, `org.apache.activemq.ActiveMQConnection`, `org.apache.activemq.ActiveMQConnectionFactory`, `org.apache.activemq.command.ActiveMQQueue`, `org.apache.activemq.command.ActiveMQTextMessage`, `org.apache.commons.lang3.StringUtils`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.*`, `java.io.IOException`, `java.util.*`.
Configuration references: `DISPATCH_PEER_ID`, `QUEUE_COMPRESSION`, `QUEUE_CONNECTION_BACKUP`, `QUEUE_PREFETCH_SIZE`, `QUEUE_RANDOMIZE`, `QUEUE_SEND_PERSISTENT`, `SEND_MESSAGE_TIMEOUT`, `TIME_IN_QUEUE_THRESHOLDS`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/QueueHandler.java:113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L113): `queueClient = new ActiveMQOpenWireQueueClient(queueRegistration);`
- [src/com/nozha/async/server/util/ClientHelper.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L15): `if (clientClass.getName().equals(ActiveMQOpenWireQueueClient.class.getName()))      type = 0x00010;`

## Business

SOURCE_OBSERVED: Primary provider JMS route; TTL bypass applies in this client but QueueHandler first rejects expired absolute payload. Prefetch adjustment affects cached factory shared by registrations.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Setup closes partial resources then rethrows. Cleanup errors logged suppressed. send JMSException propagated, NPE possible after null warnings; negative TTL skipped. Length mismatch ServerException general catch suppresses; JMS receive failure invokes reconnect. Time-in-queue broker inspection exception falls back to reduced warning.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L182): `} catch (Exception e) {`
- [185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L185): `throw e;`
- [196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L196): `} catch (Exception ex) {`
- [204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L204): `} catch (Exception ex) {`
- [212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L212): `} catch (JMSException ex) {`
- [220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L220): `} catch (JMSException ex) {`
- [228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L228): `} catch (JMSException ex) {`
- [236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L236): `} catch (JMSException ex) {`
- [283](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L283): `throw new ServerException("Inconsistance message length");`
- [293](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L293): `} catch (Exception ignore) {`
- [304](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L304): `} catch (JMSException e) {`
- [307](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L307): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Null warning not a guard; queue residence before Server.read proves no completion. Exception listeners omit original JMS throwable in own error but delegated ExceptionListener logs it.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L98) | ALOG-1157C8D2E959 | INFO | `logger.info("{} {} {}", Settings.SEND_MESSAGE_TIMEOUT, ActiveMQConnectionFactory.class.getName(), StringUtils.join(urls, ","));` | `String[] split = url.split("[:]"); / int port = split.length == 1 ? 80 : Integer.parseInt(split[1], 10); / urls.add("tcp://" + split[0] + ":" + port); / }` |
| [183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L183) | ALOG-7A5B852C2662 | WARN | `logger.warn("ActiveMQOpenWireQueueClient::setup exception: ", e);` | `consumer.setMessageListener(new QueueMessageListener()); / consumerConnection.setExceptionListener(new ConsumerExceptionListener()); / producerConnection.setExceptionListener(new ProducerExceptionListener()); / } catch (Exception e) {` |
| [197](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L197) | ALOG-ED51C23C0F3D | ERROR | `logger.error("Can not close consumer", ex);` | `try { / consumer.close(); / consumer = null; / } catch (Exception ex) {` |
| [205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L205) | ALOG-BE5070FC576C | ERROR | `logger.error("Can not close producer", ex);` | `try { / producer.close(); / producer = null; / } catch (Exception ex) {` |
| [213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L213) | ALOG-CEC9F9FBF921 | ERROR | `logger.error("Can not close producerSession", ex);` | `try { / producerSession.close(); / producerSession = null; / } catch (JMSException ex) {` |
| [221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L221) | ALOG-5D4F363D0AE4 | ERROR | `logger.error("Can not close producerConnection", ex);` | `try { / producerConnection.close(); / producerConnection = null; / } catch (JMSException ex) {` |
| [229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L229) | ALOG-3D9A30149520 | ERROR | `logger.error("Can not close consumerSession", ex);` | `try { / consumerSession.close(); / consumerSession = null; / } catch (JMSException ex) {` |
| [237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L237) | ALOG-C7872A2CE6FE | ERROR | `logger.error("Can not close consumerConnection", ex);` | `try { / consumerConnection.close(); / consumerConnection = null; / } catch (JMSException ex) {` |
| [245](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L245) | ALOG-0138146856FB | WARN | `logger.warn("message is null");` | `@Override / public void send(OutboundPayload outboundPayload) throws JMSException { / if (outboundPayload == null) {` |
| [248](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L248) | ALOG-22D674638A79 | WARN | `logger.warn("producer is null");` | `if (outboundPayload == null) { / logger.warn("message is null"); / } / if (producer == null) {` |
| [251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L251) | ALOG-22D4A40874BB | WARN | `logger.warn("producerSession is null");` | `if (producer == null) { / logger.warn("producer is null"); / } / if (producerSession == null) {` |
| [268](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L268) | ALOG-97BC92B3A7A9 | WARN | `logger.warn("AMQ send ignored diff: " + timeToLive);` | `bytesMessage.setLongProperty("senderId", outboundPayload.getSender()); / bytesMessage.setIntProperty("type", outboundPayload.getType()); / producer.send(bytesMessage, Settings.QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, timeToLive); / } else {` |
| [270](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L270) | ALOG-36981D0309E0 | DEBUG | `logger.debug("AMQ send time: " + (System.currentTimeMillis() - start));` | `producer.send(bytesMessage, Settings.QUEUE_SEND_PERSISTENT ? DeliveryMode.PERSISTENT : DeliveryMode.NON_PERSISTENT, 4, timeToLive); / } else { / logger.warn("AMQ send ignored diff: " + timeToLive); / }` |
| [286](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L286) | ALOG-AAA9169FE844 | INFO | `logger.info("time in queue={}, peerId={}", timeInQueue, queueRegistration.getPeerId());` | `if (readBytes != bytesMessage.getBodyLength()) { / throw new ServerException("Inconsistance message length"); / } / long timeInQueue = System.currentTimeMillis() - message.getJMSTimestamp();` |
| [289](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L289) | ALOG-122C376D691F | WARN | `logger.warn("time in queue more than thresholds for queue: {}, peerId: {}, activemqHostname: {}, timeInQueue: {}", queueRegistration.getInputQueueName(), queueRegistration.getPeerId(), ((ActiveMQConnection) consumerConnection).getBrokerInfo().getBrokerURL(), timeInQueue);` | `long timeInQueue = System.currentTimeMillis() - message.getJMSTimestamp(); / logger.info("time in queue={}, peerId={}", timeInQueue, queueRegistration.getPeerId()); / if (timeInQueue >= Settings.TIME_IN_QUEUE_THRESHOLDS) { / try {` |
| [294](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L294) | ALOG-2C6FCD440A73 | WARN | `logger.warn("time in queue more than thresholds for queue: {}, peerId: {}, timeInQueue: {}", queueRegistration.getInputQueueName(), queueRegistration.getPeerId(), timeInQueue);` | `queueRegistration.getInputQueueName(), / queueRegistration.getPeerId(), / ((ActiveMQConnection) consumerConnection).getBrokerInfo().getBrokerURL(), timeInQueue); / } catch (Exception ignore) {` |
| [305](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L305) | ALOG-395296B2BE18 | WARN | `logger.warn("An exception occurred in ActiveMQOpenWireQueueClient onMessage JMSException for peerId=" + peer.getId(), e);` | `} else if (message instanceof ActiveMQTextMessage) { / messageListener.onMessage(((ActiveMQTextMessage) message).getText()); / } / } catch (JMSException e) {` |
| [308](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L308) | ALOG-4E1DCC715C7F | WARN | `logger.warn("An exception occurred in ActiveMQOpenWireQueueClient onMessage for peerId=" + peer.getId(), e);` | `} catch (JMSException e) { / logger.warn("An exception occurred in ActiveMQOpenWireQueueClient onMessage JMSException for peerId=" + peer.getId(), e); / exceptionListener.onException(e); / } catch (Exception e) {` |
| [316](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L316) | ALOG-273BB50BEC76 | ERROR | `logger.error("Producer Connection for OpenwireClient Exeption outputQueue={} peerId={}  registerid={} clientid={}", queueRegistration.getOutputQueueName(), peer.getId(), queueRegistration.getId(), id);` | `class ProducerExceptionListener implements javax.jms.ExceptionListener { / @Override / public void onException(JMSException exception) {` |
| [328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L328) | ALOG-6ED0E39C7A02 | ERROR | `logger.error("Consumer Connection for OpenwireClient Exeption inputQueue={} peerId={}  registerid={} clientid={}", queueRegistration.getInputQueueName(), peer.getId(), queueRegistration.getId(), id);` | `class ConsumerExceptionListener implements javax.jms.ExceptionListener { / @Override / public void onException(JMSException exception) {` |

Registry reconciliation: 20 rows for this file; 20 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-activemqstompqueueclient

<!-- source dossier: src/com/nozha/async/server/client/ActiveMQStompQueueClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L1-L158
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ActiveMQStompQueueClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 158 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor delegates QueueClient. setup ([41–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L41-L84)) synchronized factory cache keyed URL/type, host:port default80, StompJmsConnectionFactory tcp URI/credentials, ActiveMQQueue destinations, connection start CLIENT_ACKNOWLEDGE session and consumer/producer listeners. close ([87–108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L87-L108)) suppresses JMSException per resource; send ([111–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L111-L122)) BytesMessage with metadata and persistent priority4 positive TTL. Nested receive listener ACKs then checks full body length and forwards.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L36): `public ActiveMQStompQueueClient(QueueRegistration queueRegistration) throws Exception {`
- [87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L87): `public void close() throws IOException {`
- [111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L111): `public void send(OutboundPayload outboundPayload) throws JMSException {`
- [126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L126): `public void onMessage(Message message) {`
- [149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L149): `public void onException(JMSException exception) {`
- [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L155): `public int getType() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.ExceptionListener`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.ClientHelper`, `org.apache.activemq.ActiveMQConnectionFactory`, `org.apache.activemq.command.ActiveMQQueue`, `org.fusesource.stomp.jms.StompJmsConnectionFactory`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.jms.*`, `java.io.IOException`, `java.util.Collections`, `java.util.HashMap`, `java.util.Map`.
Configuration references: `SEND_MESSAGE_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/QueueHandler.java:122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L122): `queueClient = new ActiveMQStompQueueClient(queueRegistration);`
- [src/com/nozha/async/server/util/ClientHelper.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L18): `if (clientClass.getName().equals(ActiveMQStompQueueClient.class.getName()))          type = 0x00080;`

Supplemental semantic review of explicit member and nested-type boundaries:

- **QueueMessageListener nested class / onMessage** [124–145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L124-L145): Implements JMS MessageListener. Callback explicitly acknowledges first, reads only BytesMessage, rejects inconsistent read length with ServerException, then forwards bytes to the shared MessageListener. JMSException warns and delegates reconnect; other Exception warns and suppresses, so already-acknowledged parse/read failures are not requeued here.
- **QueueExceptionListener nested class / onException** [147–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L147-L152): Implements JMS ExceptionListener and forwards the original JMSException to shared handler.ExceptionListener. Logging/reconnect occurs there; no local catch or independent backoff.

## Business

SOURCE_OBSERVED: STOMP JMS provider queue bridge with same early broker ACK boundary as AMQP.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

ServerException("Inconsistance message length") general catch warns only; JMSException invokes handler reconnection. Setup/send exceptions propagate, expired send skips; close has no null guard for producer/consumer.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L90): `} catch (JMSException ignored) {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L94): `} catch (JMSException ignored) {`
- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L99): `} catch (JMSException ignored) {`
- [105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L105): `} catch (JMSException ignored) {`
- [134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L134): `throw new ServerException("Inconsistance message length");`
- [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L138): `} catch (JMSException e) {`
- [141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L141): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Factory class printed is ActiveMQConnectionFactory despite STOMP implementation; warnings peer scoped.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L53) | ALOG-2D73B35CEBFA | INFO | `logger.info("{} {} {}:{}", Settings.SEND_MESSAGE_TIMEOUT, ActiveMQConnectionFactory.class.getName(), split[0], port);` | `StompJmsConnectionFactory factory; / synchronized (factoryMap) { / ConnectionFactory connectionFactory = factoryMap.get(factoryKey); / int port = split.length == 1 ? 80 : Integer.parseInt(split[1], 10);` |
| [139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L139) | ALOG-B76CB67AAC50 | WARN | `logger.warn("An exception occurred in ActiveMQStompQueueClient onMessage JMSException for peerId=" + peer.getId(), e);` | `} / messageListener.onMessage(buffer); / } / } catch (JMSException e) {` |
| [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L142) | ALOG-02996A0960B7 | WARN | `logger.warn("An exception occurred in ActiveMQStompQueueClient onMessage for peerId=" + peer.getId(), e);` | `} catch (JMSException e) { / logger.warn("An exception occurred in ActiveMQStompQueueClient onMessage JMSException for peerId=" + peer.getId(), e); / exceptionListener.onException(e); / } catch (Exception e) {` |

Registry reconciliation: 3 rows for this file; 3 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-chatclient

<!-- source dossier: src/com/nozha/async/server/client/ChatClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ChatClient.java#L1-L58
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ChatClient — source review

## Technical

Package: `NONE (comment-only compilation unit)`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **COMMENT_ONLY; no executable class declaration**. Full compilation unit reviewed: 58 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Entire apparent package/class implementation is block-commented ([1–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ChatClient.java#L1-L58)); no compiled declaration. Historical text delegates send to ChatHandler, destroy to AsyncAdaptor.checkRegistration, sets registered flag and reports address chat/type.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- No live lexical external reference found in supplied Java files.

## Business

SOURCE_OBSERVED: Historical chat adapter illustration only. No runnable feature or approved supported chat transport established by this file.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No executable direct error path in class; historical throws declarations are comments.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; no active callers can resolve this declaration.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-client

<!-- source dossier: src/com/nozha/async/server/client/Client.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L1-L165
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# Client — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 165 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Abstract base ([24–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L24-L40)) gives AtomicLong-generated ID, peer/ciphers, creation/seen/commit/send times, tracker set and key/receiver state. Accessors do not validate or persist. getTrackerIds ([73–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L73-L78)) synchronized lazy synchronizedSet; add/has tracker preserve state. seen ([88–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L88-L110)) updates seen time; only null/unnamed peer refresh path and configured delay attempt PeerCRUD.seen; null/zero peer or missing persisted peer removes client as REMOVED_EXPIRED. Named peers bypass this persistence path. buildOrigin ([112–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L112-L118)) scheme://host[:explicitport]; isInvalidKey ([120–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L120-L122)) null or literal null. Abstract send/destroy/register/registration/address/origin/type establish protocol boundary.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L41): `public long getId() {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L45): `public Peer getPeer() {`
- [49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L49): `public void setPeer(Peer peer) {`
- [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L53): `public Cipher getEncryptCipher() {`
- [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L57): `public void setEncryptCipher(Cipher encryptCipher) {`
- [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L61): `public Cipher getDecryptCipher() {`
- [65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L65): `public void setDecryptCipher(Cipher decryptCipher) {`
- [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L69): `public long getLastSeenTime() {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L73): `public synchronized Set<Long> getTrackerIds() {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L80): `public void addTrackerId(Long trackerId) {`
- [84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L84): `public synchronized boolean hasTracker() {`
- [88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L88): `public void seen() {`
- [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L112): `protected String buildOrigin(URL url) {`
- [120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L120): `protected boolean isInvalidKey(String key) {`
- [124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L124): `public long getCreationTime() {`
- [128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L128): `abstract public void sendMessage(OutboundPayload payload) throws ServerException;`
- [130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L130): `abstract public void destroy(int statusCode) throws IOException;`
- [132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L132): `abstract public void register() throws ServerException;`
- [134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L134): `abstract public boolean isRegistered();`
- [136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L136): `abstract public String getAddress();`
- [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L138): `abstract public String getOrigin();`
- [140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L140): `abstract public int getType();`
- [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L142): `public void setLastSendMessage(long lastSendMessage) {`
- [146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L146): `public long getLastSendMessage() {`
- [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L150): `public String getKey() {`
- [154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L154): `public boolean isKeyAvailable() {`
- [158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L158): `public Peer getReceiverPeer() {`
- [162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L162): `public void setReceiverPeer(Peer receiverPeer) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.vo.ClientMessage`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `javax.crypto.Cipher`, `java.io.IOException`, `java.net.URL`, `java.util.Collections`, `java.util.HashSet`, `java.util.Set`, `java.util.concurrent.atomic.AtomicLong`.
Configuration references: `CLIENT_REFRESH_SEEN_DELAY`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L80): `private Map<Long, BlockingQueueMap<Long, Client>> clientsMapByPeer = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/Server.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L81): `private Map<Long, Client> syncedClients = new HashMap<>();`
- [src/com/nozha/async/server/Server.java:246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L246): `public void addClient(final Client client) {`
- [src/com/nozha/async/server/Server.java:247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L247): `BlockingQueueMap<Long, Client> clients = clientsMapByPeer.get(client.getPeer().getId());`
- [src/com/nozha/async/server/Server.java:264](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L264): `public void removeClient(Client client, int statusCode) {`
- [src/com/nozha/async/server/Server.java:268](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L268): `BlockingQueueMap<Long, Client> clients = clientsMapByPeer.get(client.getPeer().getId());`
- [src/com/nozha/async/server/Server.java:274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L274): `logger.error("Queue All Client Remove peerId={} and peerName={}", client.getPeer().getId(), client.getPeer().getName());`
- [src/com/nozha/async/server/Server.java:300](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L300): `BlockingQueueMap<Long, Client> clients = clientsMapByPeer.remove(peerId);`
- [src/com/nozha/async/server/Server.java:302](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L302): `for (Client client : clients.values()) {`
- [src/com/nozha/async/server/Server.java:317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L317): `public void read(Client client, String msg) throws ClientException {`
- [src/com/nozha/async/server/Server.java:326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L326): `public void read(Client client, Payload frame) throws Exception {`
- [src/com/nozha/async/server/Server.java:349](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L349): `public void read(Client client, Object object, boolean sync) throws ClientException {`
- [src/com/nozha/async/server/Server.java:359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L359): `public void read(Client client, MessageWrapperVO messageWrapperVO) throws ClientException {`
- [src/com/nozha/async/server/Server.java:363](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L363): `private void read(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws ClientException {`
- [src/com/nozha/async/server/Server.java:400](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L400): `private void ackMessage(Client client, MessageWrapperVO messageWrapperVO) {`
- [src/com/nozha/async/server/Server.java:407](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L407): `private void ping(final Client client) throws ClientException {`
- 70 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: Shared connection lifecycle/tracker correlation, indirectly supports reply routing and expiry across protocols; IDs are process-local, not global business identity.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No explicit throw/catch in concrete methods; persistence/removal failures propagate. Null state handled selectively. Named peer seen rule affects expiry interpretation; test null/missing/unnamed/named peer paths and tracker concurrency.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Seen info carries app/device IDs, removal error peer ID; neither confirms protocol close succeeded.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L95) | ALOG-0994EFE89C94 | INFO | `logger.info("peer last seen updated, appId={}, deviceId={}", peer.getAppId(), peer.getDeviceId());` | `if (lastSeenTime - lastCommitedSeenTime > Settings.CLIENT_REFRESH_SEEN_DELAY) { / boolean isDC = peer == null \|\| peer.getId() == 0; / if (!isDC) { / if (peer != null && peer.getId() != 0 && System.currentTimeMillis() - lastCommitedSeenTime > 120000) {` |
| [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L101) | ALOG-0D443DF18233 | ERROR | `logger.error("remove client in seen method peerId={}", this.peer.getId());` | `Peer peer = PeerCRUD.seen(this.peer); / if (peer != null) { / lastCommitedSeenTime = lastSeenTime; / } else {` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-coapclient

<!-- source dossier: src/com/nozha/async/server/client/CoapClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L1-L125
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 125 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Sync constructor ([31–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L31-L36)) sets null peer/sync/wait but does not use trackerId argument. Listening constructor ([41–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L41-L56)) loads peer, creates observable CoapResourceClient and disconnect callback removes client. sendMessage ([58–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L58-L65)) sync path casts ClientMessagePayload, stores message and clears plain wait flag; otherwise CoapHandler sends. destroy/register no-op, always registered, address empty/origin null; accessors expose message/resource/listen/wait/sync.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L31): `public CoapClient(long trackerId) {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L37): `public void addTrackerId(Long trackerId) {`
- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L41): `public CoapClient(long peerId, String clientId){`
- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L47): `public void connectClient() {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L52): `public void disConnectClient() {`
- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L58): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L68): `public void destroy(int statusCode) throws IOException {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L73): `public void register() throws ServerException {`
- [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L78): `public boolean isRegistered() {`
- [83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L83): `public String getAddress() {`
- [88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L88): `public String getOrigin() {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L94): `public int getType() {`
- [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L98): `public ClientMessage getClientMessage() {`
- [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L102): `public String getClientId() {`
- [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L106): `public boolean isListen() {`
- [110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L110): `public CoapResourceClient getCoapResourceClient() {`
- [114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L114): `public void setSyncClient(boolean syncClient) {`
- [118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L118): `public void setWait(boolean wait) {`
- [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L122): `public boolean isWait() {`

Source dependency imports: `com.nozha.async.server.coapserver.CoapResourceClient`, `com.nozha.async.server.coapserver.ReActionClientCoap`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.ClientMessagePayload`, `com.nozha.async.server.handler.CoapHandler`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.ClientHelper`, `com.nozha.async.server.vo.ClientMessage`, `java.io.IOException`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/CoapHandler.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L34): `private Map<String, CoapClient> clientMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/CoapHandler.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L55): `CoapClient client = new CoapClient(coapRegistration.getPeerId(),coapRegistration.getClientId());`
- [src/com/nozha/async/server/handler/CoapHandler.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L68): `public CoapClient receiveMessage(CoapExchange coapExchange) throws  Exception {`
- [src/com/nozha/async/server/handler/CoapHandler.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L70): `CoapClient client = registerDevice(coapExchange.getRequestOptions().getUriPath().get(0));`
- [src/com/nozha/async/server/handler/CoapHandler.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L77): `public CoapClient receiveProvision(CoapExchange coapExchange) throws  Exception {`
- [src/com/nozha/async/server/handler/CoapHandler.java:79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L79): `CoapClient client = new CoapClient((long)coapExchange.advanced().getCurrentRequest().getMID());`
- [src/com/nozha/async/server/handler/CoapHandler.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L89): `((CoapClient)client).getCoapResourceClient().sendMessage(clientMessage.getContent());`
- [src/com/nozha/async/server/handler/CoapHandler.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L98): `CoapClient coapClient;`
- [src/com/nozha/async/server/handler/CoapHandler.java:156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L156): `private CoapClient registerDevice(String clientId) throws ClientException {`
- [src/com/nozha/async/server/handler/CoapHandler.java:161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L161): `CoapClient coapClient = new CoapClient(deviceRegistration.getPeerId(),clientId);`
- [src/com/nozha/async/server/util/ClientHelper.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L20): `if (clientClass.getName().equals(CoapClient.class.getName()))                        type = 0x00120;`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L24): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L36): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L47): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L82): `private void sleepForResponse(CoapClient coapClient){`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L25): `CoapClient coapClient = CoapHandler.getInstance().receiveMessage(exchange);`
- 4 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: Bridges observable device messaging and request-reply CoAP; actual tracking comes from wrapper paths. Empty address limits connection diagnosis.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No catch; cast failures and downstream failures propagate; plain shared wait/message state lacks volatile/synchronization. No-op destroy does not stop heartbeat thread. Test sync payload and timeout visibility.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; CoapHandler prints connect exception and Coap resources map response failures.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-httpclient

<!-- source dossier: src/com/nozha/async/server/client/HttpClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L1-L245
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# HttpClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 245 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructors ([52–96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L52-L96)) resolve origin/key then AccessibilityService validation; full constructor captures thread/session/response, starts AsyncContext, sets processed flag and idle timeout, adds complete/timeout/error callbacks; timeout/error remove client with REQUEST_TIMEOUT. addTrackerId retains last tracker and parent set. resolveOrigin ([98–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L98-L110)) parses configured referer and fallback raw string on malformed URL; resolveKey ([112–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L112-L119)) header else origin. sendMessage clears wait then delegates HttpHandler. destroy ([128–164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L128-L164)) maps server statuses to400,409,504,406,500,417,503,403,408 or200 and sends null if still waiting. register no-op/registered true; getAddress checks proxy headers then remote addr cached; remaining accessors expose request lifecycle state.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L47): `public void addTrackerId(Long trackerId) {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L52): `public HttpClient(Thread thread, HttpServletRequest request, HttpServletResponse response) throws AccessibilityException {`
- [66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L66): `public void onComplete(AsyncEvent event) {`
- [71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L71): `public void onTimeout(AsyncEvent event) {`
- [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L78): `public void onError(AsyncEvent event) {`
- [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L85): `public void onStartAsync(AsyncEvent event) {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L90): `public HttpClient(HttpServletRequest request) throws AccessibilityException {`
- [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L98): `private void resolveOrigin() {`
- [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L112): `protected void resolveKey() {`
- [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L122): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L128): `public void destroy(int statusCode) throws IOException {`
- [167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L167): `public void register() throws ServerException {`
- [172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L172): `public boolean isRegistered() {`
- [177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L177): `public String getAddress() {`
- [193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L193): `public String getOrigin() {`
- [198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L198): `public int getType() {`
- [202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L202): `public Thread getThread() {`
- [206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L206): `public boolean isWait() {`
- [210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L210): `public void setWait(boolean wait) {`
- [214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L214): `public int getSc() {`
- [218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L218): `public HttpServletRequest getRequest() {`
- [222](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L222): `public HttpSession getSession() {`
- [226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L226): `public HttpServletResponse getResponse() {`
- [230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L230): `public AsyncContext getAsyncContext() {`
- [234](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L234): `public Long getLastTrackerId() {`
- [238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L238): `public String getProviderPeerName() {`
- [242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L242): `public void setProviderPeerName(String providerPeerName) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.biz.AccessibilityService`, `com.nozha.async.server.exception.AccessibilityException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.HttpHandler`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.mediation.MediatorManager`, `com.nozha.async.server.util.ClientHelper`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `jakarta.servlet.AsyncContext`, `jakarta.servlet.AsyncEvent`, `jakarta.servlet.AsyncListener`, `jakarta.servlet.http.HttpServletRequest`, `jakarta.servlet.http.HttpServletResponse`, `jakarta.servlet.http.HttpSession`, `java.io.IOException`, `java.net.MalformedURLException`, `java.net.URL`.
Configuration references: `DEFAULT_HTTP_IDLE_TIMEOUT`, `HTTP_PROXY_CLIENT_ADDRESS_HEADER_NAMES`, `HTTP_REFERER_HEADER_NAME`, `X_APPLICATION_KEY`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:763](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L763): `if (client instanceof HttpClient)`
- [src/com/nozha/async/server/Server.java:764](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L764): `PODLogUtil.logGetResponse(podLogger, message, ((HttpClient) client).getProviderPeerName(), System.currentTimeMillis() - client.getLastSendMessage());`
- [src/com/nozha/async/server/Server.java:899](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L899): `if (client != null && client instanceof HttpClient) {`
- [src/com/nozha/async/server/handler/HttpHandler.java:144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L144): `HttpClient client = null;`
- [src/com/nozha/async/server/handler/HttpHandler.java:154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L154): `client = new HttpClient(Thread.currentThread(), req, resp);`
- [src/com/nozha/async/server/handler/HttpHandler.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L178): `HttpClient finalClient = client;`
- [src/com/nozha/async/server/handler/HttpHandler.java:316](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L316): `HttpClient client = null;`
- [src/com/nozha/async/server/handler/HttpHandler.java:318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L318): `client = new HttpClient(req);`
- [src/com/nozha/async/server/handler/HttpHandler.java:345](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L345): `HttpClient httpClient = (HttpClient) client;`
- [src/com/nozha/async/server/biz/MessageManager.java:200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L200): `if (client instanceof HttpClient) {`
- [src/com/nozha/async/server/biz/MessageManager.java:203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L203): `((HttpClient) client).setProviderPeerName(peer.getName());`
- [src/com/nozha/async/server/httpserver/AsyncFilter.java:90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L90): `logger.warn("An exception occurred in HttpClient set origin, referer: " + referer, e);`
- [src/com/nozha/async/server/util/ClientHelper.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L12): `if (clientClass.getName().equals(HttpClient.class.getName()))                       type = 0x00002;`

## Business

SOURCE_OBSERVED: HTTP mediated request waits for Async response; accessibility precedes async start; timeout surfaced as HTTP408 through destruction mapping. Trusted proxy header assumptions unknown.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

AccessibilityException propagates constructors. Origin parse warning suppresses malformed URL. Callback error does not log AsyncEvent throwable; destroy/send can throw downstream exceptions. Null-only constructor lacks response/asyncContext, so used only sendOnly path.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L63): `this.asyncContext.setTimeout(Settings.DEFAULT_HTTP_IDLE_TIMEOUT);`
- [105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L105): `} catch (MalformedURLException e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Logs correlate last tracker/address/receiver, not UUID; timeout attribute printed may differ from effective context timeout.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L67) | ALOG-5564FC35B5CC | DEBUG | `logger.debug("http request completed trackerId={}, address={}", lastTrackerId, getAddress());` | `this.asyncContext.setTimeout(Settings.DEFAULT_HTTP_IDLE_TIMEOUT); / this.asyncContext.addListener(new AsyncListener() { / @Override / public void onComplete(AsyncEvent event) {` |
| [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L73) | ALOG-C82DA1024003 | ERROR | `logger.error("http request onTimeout peerName={}, trackerId={}, address={}, timeout={}", peerName, lastTrackerId, getAddress(), request.getAttribute("timeout"));` | `@Override / public void onTimeout(AsyncEvent event) { / String peerName = (String) request.getAttribute("RECEIVER_NAME");` |
| [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L80) | ALOG-7961D5472658 | ERROR | `logger.error("http request onError peerName={}, trackerId={}, address={}", peerName, lastTrackerId, getAddress());` | `@Override / public void onError(AsyncEvent event) { / String peerName = (String) request.getAttribute("RECEIVER_NAME");` |
| [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L106) | ALOG-DE86D77263DC | WARN | `logger.warn("An exception occurred in HttpClient set origin - (" + request.getHeader("referer") + ")", e);` | `//noinspection deprecation / URL url = new URL(originHeader); / this.origin = buildOrigin(url); / } catch (MalformedURLException e) {` |

Registry reconciliation: 4 rows for this file; 4 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-mqttclient

<!-- source dossier: src/com/nozha/async/server/client/MqttClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L1-L113
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MqttClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 113 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Two constructors ([30–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L30-L42)) load peer from device registration or peerId; device address=inputQueueName, peer address=clientId. sendMessage delegates MQTT handler. destroy ([50–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L50-L55)) closes handler client except UNSUBSCRIBED status and logs closed. register no-op/registered true. Accessors expose topic/connection/client/related clients and device flag.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L30): `public MqttClient(DeviceRegistration deviceRegistration) {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L37): `public MqttClient(long peerId, String clientId) {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L45): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L50): `public void destroy(int statusCode) throws IOException {`
- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L58): `public void register() throws ServerException {`
- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L63): `public boolean isRegistered() {`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L68): `public String getAddress() {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L73): `public String getOrigin() {`
- [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L78): `public int getType() {`
- [82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L82): `public boolean isDevice() {`
- [86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L86): `public String getClientId() {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L90): `public void setConnectionId(String connectionId) {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L94): `public String getConnectionId() {`
- [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L98): `public void setTopic(MqttTopic topic) {`
- [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L102): `public MqttTopic getTopic() {`
- [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L106): `public List<MqttClient> getRelatedClients() {`
- [110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L110): `public void setRelatedClients(List<MqttClient> relatedClients) {`

Source dependency imports: `com.nozha.async.server.Server`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.MqttHandler`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.DeviceRegistration`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.ClientHelper`, `com.nozha.async.server.vo.ClientMessage`, `org.eclipse.paho.client.mqttv3.MqttTopic`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.io.IOException`, `java.util.List`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/SimpleMqttClient.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/SimpleMqttClient.java#L16): `private MqttClient myClient;`
- [src/SimpleMqttClient.java:133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/SimpleMqttClient.java#L133): `myClient = new MqttClient(BROKER_URL, M2MIO_THING);`
- [src/com/nozha/async/server/handler/MqttHandler.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L33): `private org.eclipse.paho.client.mqttv3.MqttClient clientForAsync;`
- [src/com/nozha/async/server/handler/MqttHandler.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L34): `private final Map<String, MqttClient> clientMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/MqttHandler.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L35): `private final Map<String, MqttClient> clientConnectionMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/MqttHandler.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L51): `clientForAsync = new org.eclipse.paho.client.mqttv3.MqttClient("tcp://" + Settings.OS_SERVER_NAME+":" + Settings.MQTT_PORT, Settings.MQTT_SERVER_CLIENTID);`
- [src/com/nozha/async/server/handler/MqttHandler.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L65): `logger.warn("MqttClient For Async Disconnected message=" + cause.getMessage() + " \n " + cause);`
- [src/com/nozha/async/server/handler/MqttHandler.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L84): `MqttClient mqttClient = (MqttClient) client;`
- [src/com/nozha/async/server/handler/MqttHandler.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L92): `logger.error("-*************MqttClient For Async Disconnected*******-");`
- [src/com/nozha/async/server/handler/MqttHandler.java:94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L94): `logger.error("-*************MqttClient For Async Reconnecting*******-");`
- [src/com/nozha/async/server/handler/MqttHandler.java:96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L96): `logger.error("-*************MqttClient For Async Not Reconnecting*******-");`
- [src/com/nozha/async/server/handler/MqttHandler.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L111): `public void closeClient(MqttClient client) {`
- [src/com/nozha/async/server/handler/MqttHandler.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L130): `MqttClient mqttClient = null;`
- [src/com/nozha/async/server/handler/MqttHandler.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L158): `private MqttClient registerDevice(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- [src/com/nozha/async/server/handler/MqttHandler.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L168): `MqttClient mqttClient = new MqttClient(deviceRegistration);`
- [src/com/nozha/async/server/handler/MqttHandler.java:186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L186): `private MqttClient registerPeer(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- 11 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: Represent MQTT registered peer/device and related-device fan-out mapping. Unsubscribe intentionally leaves connection open in this method.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No catches; peer load and handler runtime failures propagate; close can suppress in handler. No validation on setters; test unsubscribed vs error teardown.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Closed info proves handler.closeClient returned, not remote TCP teardown acknowledgement.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L53) | ALOG-B874C0F715D8 | INFO | `logger.info("mqtt client closed clientId={}", clientId);` | `@Override / public void destroy(int statusCode) throws IOException { / if(statusCode!= Server.DESTROY_STATUS_UNSUBSCRIBED) { / MqttHandler.getInstance().closeClient(this);` |

Registry reconciliation: 1 rows for this file; 1 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-queueclient

<!-- source dossier: src/com/nozha/async/server/client/QueueClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L1-L104
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# QueueClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 104 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Abstract constructor ([27–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L27-L31)) loads peer, computes ignoreTTL by peer name and invokes subtype setup during construction. sendMessage delegates QueueHandler; destroy ([45–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L45-L49)) deactivate→close→removeRegistration; close failure prevents map removal. Address URL/inputqueue; origin null. active/registered/ignoreTTL accessors direct. equals/hashCode ([90–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L90-L101)) class-exact and queueRegistration-based; abstract send/setup/close leave protocol details downstream.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L27): `QueueClient(QueueRegistration queueRegistration) throws Exception {`
- [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L33): `abstract void setup(QueueRegistration queueRegistration) throws Exception;`
- [35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L35): `public QueueRegistration getQueueRegistration() {`
- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L40): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L45): `public void destroy(int statusCode) throws IOException {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L52): `public String getAddress() {`
- [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L57): `public String getOrigin() {`
- [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L61): `abstract void close() throws IOException;`
- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L63): `public void deactivate() {`
- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L67): `public boolean isActive() {`
- [72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L72): `public void register() {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L77): `public boolean isRegistered() {`
- [81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L81): `public boolean isIgnoreMessageTtl() {`
- [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L85): `public void setIgnoreMessageTtl(boolean ignoreMessageTtl) {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L90): `public boolean equals(Object o) {`
- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L99): `public int hashCode() {`
- [103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L103): `abstract public void send(OutboundPayload outboundPayload) throws Exception;`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.ExceptionListener`, `com.nozha.async.server.handler.MessageListener`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.handler.QueueHandler`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.vo.ClientMessage`, `java.io.IOException`.
Configuration references: `IGNORE_PEER_MESSAGE_TTL`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L273): `if (client instanceof QueueClient) {`
- [src/com/nozha/async/server/Server.java:777](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L777): `if (client instanceof QueueClient) {`
- [src/com/nozha/async/server/Server.java:870](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L870): `if (client instanceof QueueClient) {`
- [src/com/nozha/async/server/Server.java:871](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L871): `QueueHandler.getInstance().reconnect((QueueClient) client);`
- [src/com/nozha/async/server/Server.java:1163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1163): `if (client instanceof QueueClient) {`
- [src/com/nozha/async/server/Server.java:1195](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1195): `if (client instanceof QueueClient) {`
- [src/com/nozha/async/server/Server.java:1196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1196): `QueueHandler.getInstance().reconnect((QueueClient) client);`
- [src/com/nozha/async/server/handler/MessageListener.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L12): `private QueueClient client;`
- [src/com/nozha/async/server/handler/MessageListener.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L14): `public MessageListener(QueueClient client) {`
- [src/com/nozha/async/server/handler/ExceptionListener.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L9): `private QueueClient client;`
- [src/com/nozha/async/server/handler/ExceptionListener.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L11): `public ExceptionListener(QueueClient client) {`
- [src/com/nozha/async/server/handler/QueueHandler.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L29): `private final Map<Long, QueueClient> queues = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/QueueHandler.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L89): `QueueClient queueClient = (QueueClient) client;`
- [src/com/nozha/async/server/handler/QueueHandler.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L108): `QueueClient queueClient = null;`
- [src/com/nozha/async/server/handler/QueueHandler.java:146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L146): `public void reconnect(QueueClient client) {`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L25): `public class ActiveMQStompQueueClient extends QueueClient {`
- 3 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: Indirect shared provider registration/lifecycle; same registration defines equality and reconnect participation.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Constructor/setup/send/close exceptions propagate. Peer null can NPE before setup. No direct explicit throw/catch; destroy order can leave registration on failed close. QueueHandler logs/catches outer sends/reconnect.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; QueueHandler and subtype queue callbacks give peer/queue visibility.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-rabbitmqamqpqueueclient

<!-- source dossier: src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L1-L85
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RabbitMQAMQPQueueClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 85 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

setup ([28–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L28-L47)) stores subclass registration, credentials, recovery interval1000ms, automatic recovery true/heartbeat60, fixed vhost khash, host:port default80; creates channel, starts autoAck consumer before durable queue declarations. send ([62–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L62-L66)) publishes to default exchange/output queue with expiration string from absolute expirationDate; no sender/type properties. close suppresses channel TimeoutException and connection IOException. MyConsumer constructor delegates; handleDelivery forwards raw body. getType returns ClientHelper type.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L23): `public RabbitMQAMQPQueueClient(QueueRegistration queueRegistration) throws Exception {`
- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L62): `public void send(OutboundPayload outboundPayload) throws Exception {`
- [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L69): `MyConsumer(Channel channel) {`
- [74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L74): `public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)`
- [82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L82): `public int getType() {`

Source dependency imports: `com.nozha.async.server.handler.ExceptionListener`, `com.nozha.async.server.handler.MessageListener`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.util.ClientHelper`, `com.rabbitmq.client.*`, `java.io.IOException`, `java.util.concurrent.TimeoutException`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/QueueHandler.java:119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L119): `queueClient = new RabbitMQAMQPQueueClient(queueRegistration);`
- [src/com/nozha/async/server/util/ClientHelper.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L17): `if (clientClass.getName().equals(RabbitMQAMQPQueueClient.class.getName()))          type = 0x00040;`

## Business

SOURCE_OBSERVED: RabbitMQ provider bridge with automatic broker ACK; fixed virtual host and expiry representation are integration specifics requiring broker validation.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Setup exceptions propagate, including consume before missing queue declaration. Close channel IOException remains propagated though timeout suppressed. send publishes exception propagated; handler MessageListener suppresses parse/read failure. Absolute epoch value is supplied where Rabbit TTL convention must be verified; no runtime claim.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L53): `} catch (TimeoutException ignored) {`
- [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L57): `} catch (IOException ignored) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; QueueHandler send/register and MessageListener receive errors are evidence points.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-restclient

<!-- source dossier: src/com/nozha/async/server/client/RestClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L1-L186
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RestClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 186 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([40–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L40-L60)) normalizes absent baseUrl to empty, splits semicolon addresses, loads peer, sets version0, synchronized active/deactive lists, swagger true if config URL exists, initializes HTTP. initHttpClient ([62–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L62-L84)) uses default trust factory, requires one X509 manager, SSLContext SSL, RestHandler hostname verifier, fixed REST_IO_THREAD_COUNT Dispatcher/MAX_REQUEST and idle pool/keepalive settings. add/remove server methods mutate lists. sendMessage delegates; destroy calls empty destroyHttpClient; register no-op/true, type0/address empty/origin null. Map/version/config flags accessors expose mutable provider state.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L40): `public RestClient(RestRegistration restRegistration) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {`
- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L62): `private void initHttpClient() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {`
- [86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L86): `private void destroyHttpClient() {`
- [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L89): `public OkHttpClient getOkHttpClient() {`
- [93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L93): `public void addToDeActiveserver(String url) {`
- [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L97): `public void removeToActiveserver(String url) {`
- [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L102): `public void addTrackerId(Long trackerId) {`
- [107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L107): `public void sendMessage(OutboundPayload outboundPayload) {`
- [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L112): `public void destroy(int statusCode) throws IOException {`
- [117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L117): `public void register() {`
- [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L122): `public boolean isRegistered() {`
- [127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L127): `public String getAddress() {`
- [132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L132): `public String getOrigin() {`
- [137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L137): `public int getType() {`
- [147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L147): `setUriServiceMap(Map<String, Service> uriServiceMap) {`
- [151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L151): `public String getConfigFileUrl() {`
- [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L155): `private void setConfigFileUrl(String configFileUrl) {`
- [159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L159): `public int getVersion() {`
- [163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L163): `public void setVersion(int version) {`
- [167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L167): `public List<String> getActiveServers() {`
- [171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L171): `public List<String> getDeActiveServer() {`
- [175](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L175): `public boolean isSwagger() {`
- [179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L179): `public void setSwagger(boolean swagger) {`
- [183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L183): `public boolean hasBaseUrl() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.handler.RestHandler`, `com.nozha.async.server.mediation.generic.vo.Service`, `com.nozha.async.server.model.RestRegistration`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.vo.ClientMessage`, `okhttp3.ConnectionPool`, `okhttp3.Dispatcher`, `okhttp3.OkHttpClient`, `javax.net.ssl.SSLContext`, `javax.net.ssl.TrustManager`, `javax.net.ssl.TrustManagerFactory`, `javax.net.ssl.X509TrustManager`, `java.io.IOException`, `java.security.KeyManagementException`, `java.security.KeyStore`, `java.security.KeyStoreException`, `java.security.NoSuchAlgorithmException`, `java.util.*`, `java.util.concurrent.Executors`, `java.util.concurrent.TimeUnit`.
Configuration references: `REST_DEFAULT_KEEP_ALIVE_TIMEOUT`, `REST_IO_THREAD_COUNT`, `REST_MAX_IDLE_CONNECTION`, `REST_MAX_REQUEST`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/RestHandler.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L49): `private Map<Long, RestClient> rests = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/RestHandler.java:118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L118): `private static Map<String, Service> updateProvidersFileFromUrl(RestClient client) throws Exception {`
- [src/com/nozha/async/server/handler/RestHandler.java:188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L188): `private static ServiceProvider getUpdatedService(File providerFile, RestClient restClient) {`
- [src/com/nozha/async/server/handler/RestHandler.java:321](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L321): `RestClient restClient = (RestClient) client;`
- [src/com/nozha/async/server/handler/RestHandler.java:329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L329): `logger.error("IllegalArgumentException in sendMessage RestClient with id:{} , peerId:{}",`
- [src/com/nozha/async/server/handler/RestHandler.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L333): `logger.error("not send Message to RestClient with id:{} , peerId:{}",`
- [src/com/nozha/async/server/handler/RestHandler.java:337](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L337): `logger.warn("can not send message because RestClient has no active server . id:{} , peerId:{}",`
- [src/com/nozha/async/server/handler/RestHandler.java:342](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L342): `private void sendingRandomServer(RestClient client, GenericRequest genericRequest, ClientMessage clientMessage, int serverNumber) {`
- [src/com/nozha/async/server/handler/RestHandler.java:392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L392): `private void sendExceptionMessage(RestClient client, ClientMessage clientMessage, String message, int statusCode) {`
- [src/com/nozha/async/server/handler/RestHandler.java:451](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L451): `private Request.Builder getRequestFromGenericRequest(RestClient client, GenericRequest genericRequest) {`
- [src/com/nozha/async/server/handler/RestHandler.java:535](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L535): `RestClient restClient = rests.get(restRegistration.getId());`
- [src/com/nozha/async/server/handler/RestHandler.java:538](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L538): `restClient = new RestClient(restRegistration);`
- [src/com/nozha/async/server/handler/RestHandler.java:632](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L632): `rests.forEach((Long clientId, RestClient client) -> client.getDeActiveServer().forEach((String url) -> {`
- [src/com/nozha/async/server/handler/RestHandler.java:641](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L641): `private void isAvailable(RestClient client, String url) {`

Supplemental semantic review of explicit member and nested-type boundaries:

- **getUriServiceMap** [141–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L141-L143): Returns the current mutable URI-to-Service map directly; there is no defensive copy, reload, null guard or synchronization. RestHandler uses it for descriptor path matching; setUriServiceMap can assign null after an unchanged descriptor update.

## Business

SOURCE_OBSERVED: REST provider bridge supports multiple bases and optional Swagger definitions; no teardown of HTTP resources occurs here.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Security initialization checked exceptions propagate; unexpected trust managers explicit IllegalStateException. No error recovery within client; send handled by RestHandler. Test absent base URL, incompatible trust manager and repeated removal.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L70): `throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; RestHandler logs registration, routing and availability.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-tcpclient

<!-- source dossier: src/com/nozha/async/server/client/TcpClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L1-L76
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# TcpClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 76 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor retains socket; getOutputStream propagates socket IO. destroy ([35–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L35-L45)) attempts output/input shutdown suppressing IOException then closes socket (propagated). register boolean true; address socket IP, origin null; sendMessage delegates TcpHandler; type from ClientHelper.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L22): `public TcpClient(Socket socket) {`
- [26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L26): `public Socket getSocket() {`
- [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L30): `public OutputStream getOutputStream() throws IOException {`
- [35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L35): `public void destroy(int statusCode) throws IOException{`
- [48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L48): `public void register() {`
- [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L53): `public boolean isRegistered() {`
- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L58): `public String getAddress() {`
- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L63): `public String getOrigin() {`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L68): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L73): `public int getType() {`

Source dependency imports: `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.handler.TcpHandler`, `com.nozha.async.server.util.ClientHelper`, `com.nozha.async.server.vo.ClientMessage`, `java.io.IOException`, `java.io.OutputStream`, `java.net.Socket`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:1171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1171): `if (client instanceof TcpClient) {`
- [src/com/nozha/async/server/handler/TcpHandler.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L74): `TcpClient tcpClient = (TcpClient) client;`
- [src/com/nozha/async/server/handler/TcpHandler.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L92): `TcpClient client = null;`
- [src/com/nozha/async/server/handler/TcpHandler.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L98): `client = new TcpClient(socket);`
- [src/com/nozha/async/server/handler/TcpHandler.java:196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L196): `TcpClient client;`
- [src/com/nozha/async/server/handler/TcpHandler.java:199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L199): `Reader(TcpClient client, String name) {`
- [src/com/nozha/async/server/util/ClientHelper.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L13): `if (clientClass.getName().equals(TcpClient.class.getName()))                        type = 0x00004;`

## Business

SOURCE_OBSERVED: Connection wrapper for length-framed TCP messages; peer registration occurs in handler.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Shutdown errors suppressed, socket.close/getOutputStream IOException propagated, send handler ServerException propagated. Null socket implicit NPE.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L38): `} catch (IOException ignored) {`
- [42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L42): `} catch (IOException ignored) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; TcpHandler logs bind/register/reader/send failures.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-webrtcclient

<!-- source dossier: src/com/nozha/async/server/client/WebrtcClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L1-L286
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# WebrtcClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 286 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([43–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L43-L66)) referer origin and proxy/remote address then createWebrtcBin. register marks true before handler registration; send delegates. destroy ([95–105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L95-L105)) logs, removes handler best-effort, clears ICE and closeResources. closeResources ([108–146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L108-L146)) bus flush/remove/stop/dispose WebRTCBin then stop/dispose pipeline, catches separately; success line unconditional. send ([148–150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L148-L150)) uses AtomicReference channel. createWebrtcBin ([157–206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L157-L206)) Gst init, pipeline EOS log, TURN credentials/internal address, BALANCED, relay-only ice policy, per-client endless finalizer thread, channel open/close/error/message callbacks; close/error flags finalize, incoming messages handler; relay candidates only collected. setupPipeLogging ([208–228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L208-L228)) defines EOS/error/state callbacks but invocation commented. createSdpAnswer ([230–250](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L230-L250)) once atomic latch gate, parses offer, sets remote description, creates/sets answer and awaits SDP_ANSWER_DELAY_MS; subsequent calls return empty string. addIceCandidate forwards; finalize sets volatile flag/status, disconnect calls handler onClose. MyFinalizer ([270–285](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L270-L285)) polls every1s forever, prints interrupts, disconnects when flagged.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L43): `public WebrtcClient(HttpServletRequest request) {`
- [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L69): `public void register() throws ServerException {`
- [75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L75): `public boolean isRegistered() {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L80): `public String getAddress() {`
- [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L85): `public String getOrigin() {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L90): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L95): `public void destroy(int statusCode) throws IOException {`
- [108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L108): `private void closeResources(long peerId) {`
- [148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L148): `public void send(String json) throws Exception {`
- [153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L153): `public int getType() {`
- [157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L157): `private void createWebrtcBin() {`
- [208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L208): `private void setupPipeLogging(org.freedesktop.gstreamer.Pipeline pipe) {`
- [230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L230): `public String createSdpAnswer(String sdpOffer) throws Exception {`
- [252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L252): `public List<IceCandidate> getIceCandidates() {`
- [256](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L256): `public void addIceCandidate(int sdpMLineIndex, String candidate) {`
- [260](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L260): `public void finalize(int statusCode) {`
- [266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L266): `private void disconnect() {`
- [271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L271): `public void run() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.handler.WebrtcHandler`, `com.nozha.async.server.model.IceCandidate`, `com.nozha.async.server.util.ClientHelper`, `com.nozha.async.server.util.GstUtil`, `com.nozha.async.server.vo.ClientMessage`, `org.freedesktop.gstreamer.*`, `org.freedesktop.gstreamer.webrtc.*`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `jakarta.servlet.http.HttpServletRequest`, `java.io.IOException`, `java.net.MalformedURLException`, `java.net.URL`, `java.util.ArrayList`, `java.util.Collections`, `java.util.List`, `java.util.concurrent.CountDownLatch`, `java.util.concurrent.TimeUnit`, `java.util.concurrent.atomic.AtomicBoolean`, `java.util.concurrent.atomic.AtomicReference`.
Configuration references: `HTTP_PROXY_CLIENT_ADDRESS_HEADER_NAMES`, `HTTP_REFERER_HEADER_NAME`, `SDP_ANSWER_DELAY_MS`, `TURN_ADDRESSES`, `TURN_PASSWORD`, `TURN_USERNAME`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/WebrtcHandler.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L31): `private final Map<Long, WebrtcClient> clientMap = new ConcurrentHashMap<>();`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L32): `private final Map<Long, WebrtcClient> notRegisteredClientMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L33): `private final Map<Long, WebrtcClient> registeredClientMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L56): `public void register(WebrtcClient client) throws ServerException {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L76): `WebrtcClient webrtcClient = (WebrtcClient) client;`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L103): `WebrtcClient webrtcClient = new WebrtcClient(req);`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L135): `WebrtcClient webrtcClient = clientMap.get(Long.valueOf(req.getParameter("clientId")));`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L157): `WebrtcClient webrtcClient = clientMap.get(clientId);`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L176): `public void onClose(WebrtcClient client, int code, String message) {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L178): `WebrtcClient removed = clientMap.remove(client.getId());`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L185): `public void onMessage(WebrtcClient client, String msg) {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L201): `public Map<Long, WebrtcClient> getClients() {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L205): `public void removeClient(WebrtcClient webrtcClient) {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L232): `WebrtcClient removed = clientMap.get(k);`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:270](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L270): `WebrtcClient removed = clientMap.get(k);`
- [src/com/nozha/async/server/util/ClientHelper.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L21): `if (clientClass.getName().equals(WebrtcClient.class.getName()))                        type = 0x00400;`

## Business

SOURCE_OBSERVED: WebRTC data-channel transport with HTTP SDP/ICE bootstrap; TURN-relay-only candidate response and single-use negotiation are observed restrictions. Native resource shutdown has no official duration guarantee.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

SDP timeout explicit Exception("create SDP answer timeout"); interruption propagates there. Native/channel failures propagate or callback suppresses/logs. Cleanup catches Throwable for remove and Exception separately; once flag not reset after timeout. Finalizer never terminates, and success cleanup log can follow failure.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L51): `} catch (MalformedURLException e) {`
- [100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L100): `} catch (Throwable e) {`
- [125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L125): `} catch (Exception e) {`
- [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L138): `} catch (Exception e) {`
- [190](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L190): `} catch (Exception e) {`
- [245](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L245): `boolean result = latch.await(Settings.SDP_ANSWER_DELAY_MS, TimeUnit.MILLISECONDS);`
- [247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L247): `throw new Exception("create SDP answer timeout");`
- [275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L275): `} catch (InterruptedException e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

setupPipeLogging sites exist in unused method, not wired by create path; candidate log may expose network addresses; final success does not prove disposal.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L52) | ALOG-B003A975F921 | WARN | `logger.warn("An exception occurred - (" + request.getHeader("referer") + ")", e);` | `if (referer.getPort() != -1) { / this.origin += ":" + referer.getPort(); / } / } catch (MalformedURLException e) {` |
| [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L97) | ALOG-039F0D051CD7 | INFO | `logger.info("webrtc client destroy clientId:{}, peerId:{}, statusCode:{}", id, peerId, statusCode);` | `@Override / public void destroy(int statusCode) throws IOException { / long peerId = peer != null ? peer.getId() : -1;` |
| [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L101) | ALOG-3E73A4706A10 | ERROR | `logger.error("An exception occurred in destroy webrtc,removeClient clientId:{}, peerId:{}, statusCode:{}", id, peerId, statusCode, e);` | `logger.info("webrtc client destroy clientId:{}, peerId:{}, statusCode:{}", id, peerId, statusCode); / try { / WebrtcHandler.getInstance().removeClient(this); / } catch (Throwable e) {` |
| [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L112) | ALOG-172D1EEAC8B3 | INFO | `logger.info("step 1 pipeline bus set flushing true clientId:{}, peerId:{}", id, peerId);` | `private void closeResources(long peerId) { / if (pipeline != null) { / if (webRTCBin != null) { / try {` |
| [114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L114) | ALOG-52027D67F6E4 | INFO | `logger.info("step 2 pipeline remove webRTCBin  clientId:{}, peerId:{}", id, peerId);` | `if (webRTCBin != null) { / try { / logger.info("step 1 pipeline bus set flushing true clientId:{}, peerId:{}", id, peerId); / pipeline.getBus().setFlushing(true);` |
| [116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L116) | ALOG-2126EA351658 | INFO | `logger.info("step 3 webRTCBin close  clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 1 pipeline bus set flushing true clientId:{}, peerId:{}", id, peerId); / pipeline.getBus().setFlushing(true); / logger.info("step 2 pipeline remove webRTCBin  clientId:{}, peerId:{}", id, peerId); / pipeline.remove(webRTCBin);` |
| [118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L118) | ALOG-B2F209C16B53 | INFO | `logger.info("step 4 webRTCBin dispose  clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 2 pipeline remove webRTCBin  clientId:{}, peerId:{}", id, peerId); / pipeline.remove(webRTCBin); / logger.info("step 3 webRTCBin close  clientId:{}, peerId:{}", id, peerId); / webRTCBin.stop();` |
| [120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L120) | ALOG-8D56095351B2 | INFO | `logger.info("step 5 pipeline bus set flushing false clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 3 webRTCBin close  clientId:{}, peerId:{}", id, peerId); / webRTCBin.stop(); / logger.info("step 4 webRTCBin dispose  clientId:{}, peerId:{}", id, peerId); / webRTCBin.dispose();` |
| [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L122) | ALOG-068CD9548B14 | INFO | `logger.info("step 6 set webRTCBin to null clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 4 webRTCBin dispose  clientId:{}, peerId:{}", id, peerId); / webRTCBin.dispose(); / logger.info("step 5 pipeline bus set flushing false clientId:{}, peerId:{}", id, peerId); / pipeline.getBus().setFlushing(false);` |
| [124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L124) | ALOG-3BB7B9A57FC2 | INFO | `logger.info("step 7 webRTCBin closed clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 5 pipeline bus set flushing false clientId:{}, peerId:{}", id, peerId); / pipeline.getBus().setFlushing(false); / logger.info("step 6 set webRTCBin to null clientId:{}, peerId:{}", id, peerId); / webRTCBin = null;` |
| [126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L126) | ALOG-0D28AEDB319A | ERROR | `logger.error("An exception occurred in close webRTCBin clientId:{}, peerId:{}", id, peerId, e);` | `logger.info("step 6 set webRTCBin to null clientId:{}, peerId:{}", id, peerId); / webRTCBin = null; / logger.info("step 7 webRTCBin closed clientId:{}, peerId:{}", id, peerId); / } catch (Exception e) {` |
| [129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L129) | ALOG-E0C80EC59AF5 | WARN | `logger.warn("webRTCBin is null clientId:{}, peerId:{}", id, peerId);` | `} catch (Exception e) { / logger.error("An exception occurred in close webRTCBin clientId:{}, peerId:{}", id, peerId, e); / } / } else` |
| [131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L131) | ALOG-2DF2B0384611 | INFO | `logger.info("step 8 pipeline stop clientId:{}, peerId:{}", id, peerId);` | `} / } else / logger.warn("webRTCBin is null clientId:{}, peerId:{}", id, peerId); / try {` |
| [133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L133) | ALOG-F64A3ED6E40C | INFO | `logger.info("step 9 pipeline dispose clientId:{}, peerId:{}", id, peerId);` | `logger.warn("webRTCBin is null clientId:{}, peerId:{}", id, peerId); / try { / logger.info("step 8 pipeline stop clientId:{}, peerId:{}", id, peerId); / pipeline.stop();` |
| [135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L135) | ALOG-F01E9490A408 | INFO | `logger.info("step 10 set pipeline to null clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 8 pipeline stop clientId:{}, peerId:{}", id, peerId); / pipeline.stop(); / logger.info("step 9 pipeline dispose clientId:{}, peerId:{}", id, peerId); / pipeline.dispose();` |
| [137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L137) | ALOG-34CA03956CF1 | INFO | `logger.info("step 11 pipeline closed clientId:{}, peerId:{}", id, peerId);` | `logger.info("step 9 pipeline dispose clientId:{}, peerId:{}", id, peerId); / pipeline.dispose(); / logger.info("step 10 set pipeline to null clientId:{}, peerId:{}", id, peerId); / pipeline = null;` |
| [139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L139) | ALOG-CD1E170DBEB5 | ERROR | `logger.error("An exception occurred in close pipeline clientId:{}, peerId:{}", id, peerId, e);` | `logger.info("step 10 set pipeline to null clientId:{}, peerId:{}", id, peerId); / pipeline = null; / logger.info("step 11 pipeline closed clientId:{}, peerId:{}", id, peerId); / } catch (Exception e) {` |
| [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L142) | ALOG-B6330E1393F6 | WARN | `logger.warn("pipeline is null clientId:{}, peerId:{}", id, peerId);` | `} catch (Exception e) { / logger.error("An exception occurred in close pipeline clientId:{}, peerId:{}", id, peerId, e); / } / } else` |
| [145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L145) | ALOG-4025D98785E1 | INFO | `logger.info("step 13 successfully close resource clientId:{}, peerId:{}", id, peerId);` | `} else / logger.warn("pipeline is null clientId:{}, peerId:{}", id, peerId); / //logger.info("step 12 System gc clientId:{}, peerId:{}", id, peerId); / //System.gc();` |
| [161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L161) | ALOG-535EA50A6743 | INFO | `logger.info("Received the EOS on the playbin!!!");` | `private void createWebrtcBin() { / GstUtil.initGst(); / pipeline = new Pipeline(); / pipeline.getBus().connect((Bus.EOS) (source) -> {` |
| [176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L176) | ALOG-A75E0819E052 | INFO | `logger.info("*****ON_OPEN WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);` | `t.start(); / long pId = peer != null ? peer.getId() : -1; / webRTCBin.connect((WebRTCBin.ON_DATA_CHANNEL) (channel) -> { / channel.connect((WebRTCDataChannel.ON_OPEN) (c) -> {` |
| [179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L179) | ALOG-5B96E626BF55 | INFO | `logger.info("*****ON_CLOSE WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);` | `channel.connect((WebRTCDataChannel.ON_OPEN) (c) -> { / logger.info("*****ON_OPEN WebRTCDataChannel clientId:{}, peerId:{} ", id, pId); / }); / channel.connect((WebRTCDataChannel.ON_CLOSE) (c) -> {` |
| [183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L183) | ALOG-30E9B796D4CC | INFO | `logger.info("*****ON_ERROR WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);` | `logger.info("*****ON_CLOSE WebRTCDataChannel clientId:{}, peerId:{} ", id, pId); / doFinalize = true; / }); / channel.connect((WebRTCDataChannel.ON_ERROR) (c) -> {` |
| [187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L187) | ALOG-64C57BD5D02C | INFO | `logger.info("*****WebRTCDataChannel ,clientId:{} ,peerId:{} ", id, pId);` | `logger.info("*****ON_ERROR WebRTCDataChannel clientId:{}, peerId:{} ", id, pId); / doFinalize = true; / }); / channel.connect((c, m) -> {` |
| [191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L191) | ALOG-9169A9281572 | ERROR | `logger.error("WebrtcClient send message exception clientId:{} ,peerId:{}", id, pId, e);` | `logger.info("*****WebRTCDataChannel ,clientId:{} ,peerId:{} ", id, pId); / try { / WebrtcHandler.getInstance().onMessage(this, m); / } catch (Exception e) {` |
| [200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L200) | ALOG-C52B9C5AA846 | DEBUG | `logger.debug("ON_ICE_CANDIDATE {}", candidate);` | `pipeline.play(); / webRTCBin.connect((WebRTCBin.ON_ICE_CANDIDATE) (sdpMLineIndex, candidate) -> { / // if no relay address is found, assuming it means no TURN server` |
| [205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L205) | ALOG-15D5093A6B85 | INFO | `logger.info("end create webrtcBin clientId={}", id);` | `if (candidate.contains("relay")) { / iceCandidates.add(new IceCandidate(candidate, "", sdpMLineIndex)); / } / });` |
| [211](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L211) | ALOG-BCF45D0C62C7 | INFO | `logger.info("Reached end of stream: " + source.toString());` | `private void setupPipeLogging(org.freedesktop.gstreamer.Pipeline pipe) { / Bus bus = pipe.getBus(); / bus.connect((Bus.EOS) source -> {` |
| [217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L217) | ALOG-190792FD41C2 | ERROR | `logger.error("Data Channel closed for peerId:{}", source.getParent().getName());` | `}); / bus.connect((Bus.ERROR) (source, code, message) -> { / if (source.getParent() != null && source.getParent().getTypeName().equals(WebRTCBin.GTYPE_NAME)) {` |
| [220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L220) | ALOG-63AB0AC6F42A | DEBUG | `logger.debug("Error from source: '{}', with code: {}", source, code);` | `if (source.getParent() != null && source.getParent().getTypeName().equals(WebRTCBin.GTYPE_NAME)) { / logger.error("Data Channel closed for peerId:{}", source.getParent().getName()); / } / WebrtcHandler.getInstance().onClose(this, code, message);` |
| [225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L225) | ALOG-6F58D036CE8E | INFO | `logger.info("Pipe state changed from {} to new {}", old, current);` | `}); / bus.connect((source, old, current, pending) -> { / if (source instanceof org.freedesktop.gstreamer.Pipeline) {` |
| [240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L240) | ALOG-6299800A843C | INFO | `logger.info("create sdp answer clientId={}", id);` | `WebRTCSessionDescription description = new WebRTCSessionDescription(WebRTCSDPType.OFFER, sdpMessage); / webRTCBin.setRemoteDescription(description); / webRTCBin.createAnswer(answer -> {` |
| [261](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L261) | ALOG-08D568A17C9C | WARN | `logger.warn("finalize webrtc clientId={} code={}", id, statusCode);` | `webRTCBin.addIceCandidate(sdpMLineIndex, candidate); / } / public void finalize(int statusCode) {` |
| [279](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L279) | ALOG-73F66392302D | WARN | `logger.warn("finalize thread start to disconnect webrtc clientId={} peerId={} code={}", id, peer != null ? peer.getId() : -1, finalizeStatusCode);` | `} catch (InterruptedException e) { / e.printStackTrace(); / } / if (doFinalize) {` |

Registry reconciliation: 34 rows for this file; 34 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L276): `e.printStackTrace();`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-client-websocketclient

<!-- source dossier: src/com/nozha/async/server/client/WebsocketClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L1-L172
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# WebsocketClient — source review

## Technical

Package: `com.nozha.async.server.client`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 172 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([39–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L39-L48)) retains adapter/session, normalizes Origin, resolves application key header→query→origin and validates AccessibilityService, starts unregistered. Query extraction ([80–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L80-L86)) naïvely splits key= and takes remainder (not URL-decoded or bounded at &). register marks true then handler confirms. Address proxy headers else remote hostname cached. destroy ([131–148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L131-L148)) maps close reason, logs peer/map size, removes handler/peer registration swallowing Throwable, closes both session references and nulls. send String/bytes ([150–166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L150-L166)) checks session open, schedules Jetty text/binary callback; asynchronous callback only logs failure. type/accessors direct.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L39): `public WebsocketClient(AsyncWebSocketAdapter webSocket, Session session) throws Exception {`
- [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L51): `private void resolveOrigin(Session session) {`
- [65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L65): `private void resolveKey() {`
- [76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L76): `private String extractKeyFromHeader(Session session) {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L80): `private String extractKeyFromQuery(Session session) {`
- [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L89): `public void register() throws ServerException {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L94): `public AsyncWebSocketAdapter getWebSocket() {`
- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L99): `public boolean isRegistered() {`
- [104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L104): `public String getAddress() {`
- [121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L121): `public String getOrigin() {`
- [126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L126): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L131): `public void destroy(int statusCode) throws IOException {`
- [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L150): `public void send(String json) throws Exception {`
- [159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L159): `public void send(byte[] data) throws Exception {`
- [169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L169): `public int getType() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.biz.AccessibilityService`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.exception.WebSocketCloseReason`, `com.nozha.async.server.handler.OutboundPayload`, `com.nozha.async.server.handler.WebsocketHandler`, `com.nozha.async.server.httpserver.AsyncWebSocketAdapter`, `com.nozha.async.server.util.ClientHelper`, `org.eclipse.jetty.websocket.api.Callback`, `org.eclipse.jetty.websocket.api.Session`, `org.eclipse.jetty.websocket.core.CloseStatus`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.io.IOException`, `java.net.InetSocketAddress`, `java.net.MalformedURLException`, `java.net.URL`, `java.nio.ByteBuffer`.
Configuration references: `HTTP_PROXY_CLIENT_ADDRESS_HEADER_NAMES`, `ORIGIN_HEADER_NAME`, `X_APPLICATION_KEY`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/WebsocketHandler.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L36): `private final Map<Long, WebsocketClient> $$clientMap$$ = new HashMap<>();`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L37): `private final Map<Long, WebsocketClient> clientMap = Collections.synchronizedMap($$clientMap$$);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L38): `private final Map<Long, WebsocketClient> notRegisteredClientMap = Collections.synchronizedMap(new HashMap<>());`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L55): `public void register(WebsocketClient client) throws ServerException {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L84): `WebsocketClient websocketClient = (WebsocketClient) client;`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L112): `WebsocketClient websocketClient = null;`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L114): `websocketClient = new WebsocketClient(webSocket, session);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L145): `WebsocketClient client = clientMap.remove(key);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L161): `WebsocketClient websocketClient = clientMap.get(key);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L187): `WebsocketClient removed = clientMap.remove(key);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L199): `public Map<Long, WebsocketClient> getClients() {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L203): `public void removeClient(WebsocketClient websocketClient) {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L221): `WebsocketClient websocketClient = notRegisteredClientMap.get(k);`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L228): `WebsocketClient removed = clientMap.remove(k);`
- [src/com/nozha/async/server/httpserver/ManageServlet.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L49): `Map<Long, WebsocketClient> clients = WebsocketHandler.getInstance().getClients();`
- [src/com/nozha/async/server/httpserver/ManageServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L67): `for (Map.Entry<Long, WebsocketClient> entry : clients.entrySet()) {`
- 2 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: WebSocket browser/device connection with application-key/origin access gate and typed send overloads; callback return is not message delivery acknowledgement.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Malformed Origin falls back raw value with DEBUG. Constructors validation/registration failures propagate; send closed session throws ServerException("WebSocket session is not open for client"+id). Query key without = can index fail. destroy peer dereference before try can NPE for unregistered connection; cleanup Throwable swallowed. Async write failures not propagated.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L58): `} catch (MalformedURLException e) {`
- [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L138): `} catch (Throwable ignore) {`
- [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L155): `throw new ServerException("WebSocket session is not open for client" + getId());`
- [164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L164): `throw new ServerException("WebSocket session is not open for client" + getId());`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

send callback errors lack client ID; destroy info relies nonnull peer; origin log may be sensitive.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L47) | ALOG-5DE1DF82544A | INFO | `logger.info("origin: {} ", origin);` | `resolveOrigin(session); / resolveKey(); / AccessibilityService.validateAccessibility(this, key, isKeyAvailable); / this.registered = false;` |
| [59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L59) | ALOG-48F468F68C04 | DEBUG | `logger.debug("Invalid websocket origin: {}", originHeader, e);` | `//noinspection deprecation / URL url = new URL(originHeader); / this.origin = buildOrigin(url); / } catch (MalformedURLException e) {` |
| [133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L133) | ALOG-6001ACE8AF34 | INFO | `logger.info("websocket client destroy peerId={} , status={} , serverStatusCode={} , peerRegistrationMapSize={}", peer.getId(), status, statusCode, Server.getInstance().getPeerRegistrationMapSize());` | `@Override / public void destroy(int statusCode) throws IOException { / CloseStatus status = WebSocketCloseReason.mapToCloseStatus(statusCode);` |
| [153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L153) | ALOG-CC2482E43909 | ERROR | `}, throwable -> logger.error("can not send message exception", throwable)));` | `public void send(String json) throws Exception { / if (webSocket != null && session != null && session.isOpen()) { / webSocket.getSession().sendText(json, Callback.from(() -> {` |
| [162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L162) | ALOG-417594F8EBF6 | ERROR | `}, throwable -> logger.error("can not send message exception", throwable)));` | `public void send(byte[] data) throws Exception { / if (webSocket != null && session != null && session.isOpen()) { / webSocket.getSession().sendBinary(ByteBuffer.wrap(data), Callback.from(() -> {` |

Registry reconciliation: 5 rows for this file; 5 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-coapserver-coapgenericresponse

<!-- source dossier: src/com/nozha/async/server/coapserver/CoapGenericResponse.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L1-L24
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapGenericResponse — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 24 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

DTO ([4–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L4-L20)) direct nullable body/statusCode getters/setters. CoapResourceBase and Provision deserialize this from ClientMessage.content then map status string to CoAP code.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L7): `public String getBody() {`
- [11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L11): `public void setBody(String body) {`
- [15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L15): `public String getStatusCode() {`
- [19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapGenericResponse.java#L19): `public void setStatusCode(String statusCode) {`

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L26): `CoapGenericResponse response = JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L38): `CoapGenericResponse response = JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L49): `CoapGenericResponse response = JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L27): `CoapGenericResponse response = new CoapGenericResponse();`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L28): `response= JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L44): `CoapGenericResponse response = new CoapGenericResponse();`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L45): `response= JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L60): `CoapGenericResponse response = new CoapGenericResponse();`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L61): `response= JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L76): `CoapGenericResponse response = new CoapGenericResponse();`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L77): `response= JsonUtil.getObject(coapClient.getClientMessage().getContent(),CoapGenericResponse.class);`

## Business

SOURCE_OBSERVED: Indirect response envelope for CoAP request-reply adaptation; no independent success/error policy.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path in class; null/unknown status accepted and callers map unknown success code. Deserialization/null message failures handled at resources.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; source resource response status/body is the observable boundary.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.
