# Async class dossiers — review batch 16


---

### dossier-src-com-nozha-async-server-vo-messagewrappervo

<!-- source dossier: src/com/nozha/async/server/vo/MessageWrapperVO.md -->

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
source_path: src/com/nozha/async/server/vo/MessageWrapperVO.java
source_sha256: e150cd7bc57d99f33d489ef40ae739b3acf3e83c8cc4225c0eae4046c3c13c4d
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java
business_approved: false
runtime_tested: false
promoted: false
---

# MessageWrapperVO — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `MessageWrapperVO` (class_declaration) [src/com/nozha/async/server/vo/MessageWrapperVO.java:6–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L6-L70)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `type` | `int` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L7) |
| `content` | `String` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L8) |
| `trackerId` | `Long` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L9) |
| `uniqueId` | `String` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L10) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L11) |
| `ARNStep` | `int` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L12) |
| `messageVO` | `MessageVO` | [src/com/nozha/async/server/vo/MessageWrapperVO.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L13) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L319) ` MessageWrapperVO messageWrapperVO = JsonUtil.getObject(msg, MessageWrapperVO.class);`; [src/com/nozha/async/server/handler/MqttHandler.java:216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L216) ` MessageWrapperVO messageWrapperVO = new MessageWrapperVO();`; [src/com/nozha/async/server/handler/CoapHandler.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L69) ` MessageWrapperVO messageWrapperVO = getMessage(coapExchange);`; [src/com/nozha/async/server/handler/HttpHandler.java:323](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L323) ` MessageManager.createMessage(client, (MessageWrapperVO) inputContent, true);`; [src/com/nozha/async/server/handler/RestHandler.java:359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L359) ` MessageWrapperVO messageWrapperVO = generateMessageWrapperVO(clientMessage, response);`; [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47) ` public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentExcepti`; [src/com/nozha/async/server/biz/RegistrationManager.java:122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L122) ` public static void registerInPeer(MessageWrapperVO messageWrapperVO, long registeringId) throws BusinessException {`; [src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java#L51) ` private MessageWrapperVO getGenerateMessageWrapperVO(HttpContent httpContent) throws JsonProcessingException {`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L120) ` private MessageWrapperVO getGenerateMessageWrapperVO(Service service, HttpContent httpContent, String url, String peerName) throws JsonProc`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L76) ` private MessageWrapperVO generateMessageWrapperVO(HttpServletRequest httpRequest, String peerName) throws MediationException {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L15-L17) |
| `public void setType(int type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L19-L21) |
| `public String getContent()` | Return stored value/reference: content. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L23-L25) |
| `public void setContent(String content)` | Assign this.content = content. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L27-L29) |
| `public Long getTrackerId()` | Return stored value/reference: trackerId. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L31-L33) |
| `public void setTrackerId(Long trackerId)` | Assign this.trackerId = trackerId. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L35-L37) |
| `public String getUniqueId()` | Return stored value/reference: uniqueId. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:39–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L39-L41) |
| `public void setUniqueId(String uniqueId)` | Assign this.uniqueId = uniqueId. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:43–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L43-L45) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L47-L49) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L51-L53) |
| `public int getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L55-L57) |
| `public void setARNStep(int ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L59-L61) |
| `public MessageVO getMessageVO()` | Return stored value/reference: messageVO. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L63-L65) |
| `public void setMessageVO(MessageVO messageVO)` | Assign this.messageVO = messageVO. No validation or copying. | [src/com/nozha/async/server/vo/MessageWrapperVO.java:67–69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L67-L69) |

## Business
SOURCE_OBSERVED: Dispatch envelope with type/content/tracker/uniqueId/ARN/ARNStep or embedded MessageVO, consumed by Server.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L319), [src/com/nozha/async/server/handler/MqttHandler.java:216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L216), [src/com/nozha/async/server/handler/CoapHandler.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L69), [src/com/nozha/async/server/handler/HttpHandler.java:323](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L323), [src/com/nozha/async/server/handler/RestHandler.java:359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L359), [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47), [src/com/nozha/async/server/biz/RegistrationManager.java:122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L122), [src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java#L51).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: content. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-peerinfovo

<!-- source dossier: src/com/nozha/async/server/vo/PeerInfoVO.md -->

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
source_path: src/com/nozha/async/server/vo/PeerInfoVO.java
source_sha256: 2af608b69899bb836e8418d21c4a109b7d1b641c85ce5e41193815dc7979ade8
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java
business_approved: false
runtime_tested: false
promoted: false
---

# PeerInfoVO — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `PeerInfoVO` (class_declaration) [src/com/nozha/async/server/vo/PeerInfoVO.java:6–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L6-L70)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `peerId` | `long` | [src/com/nozha/async/server/vo/PeerInfoVO.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L7) |
| `deviceId` | `String` | [src/com/nozha/async/server/vo/PeerInfoVO.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L8) |
| `appId` | `String` | [src/com/nozha/async/server/vo/PeerInfoVO.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L9) |
| `username` | `String` | [src/com/nozha/async/server/vo/PeerInfoVO.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L10) |
| `password` | `String` | [src/com/nozha/async/server/vo/PeerInfoVO.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L11) |
| `refresh` | `boolean` | [src/com/nozha/async/server/vo/PeerInfoVO.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L12) |
| `renew` | `boolean` | [src/com/nozha/async/server/vo/PeerInfoVO.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L13) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:453](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L453) ` PeerInfoVO peerInfoVO = null;`; [src/com/nozha/async/server/handler/TcpHandler.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L129) ` PeerInfoVO peerInfoVO = JsonUtil.getObject(bytes, PeerInfoVO.class);`; [src/com/nozha/async/server/biz/RegistrationManager.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L28) ` public static Peer registerPeerForUser(PeerInfoVO peerInfo) throws Exception {`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L110) ` PeerInfoVO peerInfo = new PeerInfoVO();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L15-L17) |
| `public void setPeerId(long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L19-L21) |
| `public String getDeviceId()` | Return stored value/reference: deviceId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L23-L25) |
| `public void setDeviceId(String deviceId)` | Assign this.deviceId = deviceId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L27-L29) |
| `public String getAppId()` | Return stored value/reference: appId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L31-L33) |
| `public void setAppId(String appId)` | Assign this.appId = appId. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L35-L37) |
| `public String getUsername()` | Return stored value/reference: username. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:39–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L39-L41) |
| `public void setUsername(String username)` | Assign this.username = username. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:43–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L43-L45) |
| `public String getPassword()` | Return stored value/reference: password. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L47-L49) |
| `public void setPassword(String password)` | Assign this.password = password. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L51-L53) |
| `public boolean isRefresh()` | Return stored value/reference: refresh. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L55-L57) |
| `public void setRefresh(boolean refresh)` | Assign this.refresh = refresh. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L59-L61) |
| `public boolean isRenew()` | Return stored value/reference: renew. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L63-L65) |
| `public void setRenew(boolean renew)` | Assign this.renew = renew. No validation or copying. | [src/com/nozha/async/server/vo/PeerInfoVO.java:67–69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/PeerInfoVO.java#L67-L69) |

## Business
SOURCE_OBSERVED: Registration identity/credentials and refresh/renew request flags consumed by RegistrationManager and Server.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:453](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L453), [src/com/nozha/async/server/handler/TcpHandler.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L129), [src/com/nozha/async/server/biz/RegistrationManager.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L28), [src/com/nozha/async/server/httpserver/RegisterServlet.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L110).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: username, password. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-registrationrequestvo

<!-- source dossier: src/com/nozha/async/server/vo/RegistrationRequestVO.md -->

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
source_path: src/com/nozha/async/server/vo/RegistrationRequestVO.java
source_sha256: dcf8fd35ba2c2099ab9e22e40951bb685ea93e685fd1e0a3ed1f1aff6bcb278a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/RegistrationRequestVO.java
business_approved: false
runtime_tested: false
promoted: false
---

# RegistrationRequestVO — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `RegistrationRequestVO` (class_declaration) [src/com/nozha/async/server/vo/RegistrationRequestVO.java:6–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/RegistrationRequestVO.java#L6-L12)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `name` | `String` | [src/com/nozha/async/server/vo/RegistrationRequestVO.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/RegistrationRequestVO.java#L7) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/RegistrationManager.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L123) ` RegistrationRequestVO registrationRequestVO = JsonUtil.getObject(messageWrapperVO.getContent(), RegistrationRequestVO.class);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public String getName()` | Return stored value/reference: name. No validation or copying. | [src/com/nozha/async/server/vo/RegistrationRequestVO.java:9–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/RegistrationRequestVO.java#L9-L11) |

## Business
SOURCE_OBSERVED: Named peer request with getter-only shape used by membership/receiver registration.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/RegistrationManager.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L123).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-dto-peerdto

<!-- source dossier: src/com/nozha/async/server/vo/dto/PeerDto.md -->

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
source_path: src/com/nozha/async/server/vo/dto/PeerDto.java
source_sha256: 69c90fb5d519887f65ee7141b95e546f1375d4b646644b0ab55c7ee57ba29b6f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# PeerDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.dto`. Types: `PeerDto` (class_declaration) [src/com/nozha/async/server/vo/dto/PeerDto.java:3–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L3-L38)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `Long` | [src/com/nozha/async/server/vo/dto/PeerDto.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L5) |
| `name` | `String` | [src/com/nozha/async/server/vo/dto/PeerDto.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L6) |
| `deviceId` | `String` | [src/com/nozha/async/server/vo/dto/PeerDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L7) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/MqttServlet.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L46) ` List<PeerDto> peerDtos = PeerCRUD.loadPeerByInputQueueName(req.getParameter("inputQueueName"));`; [src/com/nozha/async/server/persistance/PeerCRUD.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L61) ` public static List<PeerDto> loadPeerByInputQueueName(String inputQueueName) {`; [src/com/nozha/async/server/persistance/PeerCRUDInterface.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L52) ` List<PeerDto> loadPeerByInputQueueName(String inputQueueName);`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:783](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L783) ` public List<PeerDto> loadPeerByInputQueueName(String inputQueueName) {`; [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:882](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L882) ` public List<PeerDto> loadPeerByInputQueueName(String inputQueueName) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public PeerDto(Long id, String name, String deviceId)` | Constructor forwards/stores supplied values: `this.id = id; this.name = name; this.deviceId = deviceId;`. References retained; no validation. | [src/com/nozha/async/server/vo/dto/PeerDto.java:9–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L9-L13) |
| `public Long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L15-L17) |
| `public void setId(Long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L19-L21) |
| `public String getName()` | Return stored value/reference: name. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L23-L25) |
| `public void setName(String name)` | Assign this.name = name. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L27-L29) |
| `public String getDeviceId()` | Return stored value/reference: deviceId. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L31-L33) |
| `public void setDeviceId(String deviceId)` | Assign this.deviceId = deviceId. No validation or copying. | [src/com/nozha/async/server/vo/dto/PeerDto.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/dto/PeerDto.java#L35-L37) |

## Business
SOURCE_OBSERVED: Peer projection id/name/deviceId without full credential fields.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/MqttServlet.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L46), [src/com/nozha/async/server/persistance/PeerCRUD.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L61), [src/com/nozha/async/server/persistance/PeerCRUDInterface.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L52), [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:783](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L783), [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:882](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L882).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-log-aftersendlog

<!-- source dossier: src/com/nozha/async/server/vo/log/AfterSendLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/AfterSendLog.java
source_sha256: a73540087694569b33ead96e88dc684d037c113f8b235c3c43263f70df82f42c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# AfterSendLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `AfterSendLog` (class_declaration) [src/com/nozha/async/server/vo/log/AfterSendLog.java:5–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L5-L112)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `messageId` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L6) |
| `trackerId` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L7) |
| `time` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L8) |
| `sender` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L9) |
| `receiver` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L10) |
| `client` | `String` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L11) |
| `writeMessageTime` | `Long` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L12) |
| `messageType` | `int` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L13) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L14) |
| `ARNStep` | `Integer` | [src/com/nozha/async/server/vo/log/AfterSendLog.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L15) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/AfterSendLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:831](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L831) ` loggerJson.info(new AfterSendLog(`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public AfterSendLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:17–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L17-L18) |
| `public AfterSendLog(Long sender, Long receiver, Long messageId, Long trackerId, String client, Long time, Long writeMessageTime, int messageType, String ARN, Integer ARNStep)` | Constructor forwards/stores supplied values: `this.messageId = messageId; this.trackerId = trackerId; this.time = time; this.sender = sender; this.receiver = receiver; this.client = client; this.writeMessageTime = writeMessageTime; this.messageType = messageType; this.ARN = ARN; this.ARNStep = ARNStep;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:20–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L20-L31) |
| `public Long getMessageId()` | Return stored value/reference: messageId. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L33-L35) |
| `public void setMessageId(Long messageId)` | Assign this.messageId = messageId. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L37-L39) |
| `public Long getTrackerId()` | Return stored value/reference: trackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L41-L43) |
| `public void setTrackerId(Long trackerId)` | Assign this.trackerId = trackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L45-L47) |
| `public Long getSender()` | Return stored value/reference: sender. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L49-L51) |
| `public void setSender(Long sender)` | Assign this.sender = sender. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L53-L55) |
| `public Long getReceiver()` | Return stored value/reference: receiver. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L57-L59) |
| `public void setReceiver(Long receiver)` | Assign this.receiver = receiver. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L61-L63) |
| `public String getClient()` | Return stored value/reference: client. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L65-L67) |
| `public void setClient(String client)` | Assign this.client = client. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L69-L71) |
| `public Long getWriteMessageTime()` | Return stored value/reference: writeMessageTime. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L73-L75) |
| `public void setWriteMessageTime(Long writeMessageTime)` | Assign this.writeMessageTime = writeMessageTime. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L77-L79) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L81-L83) |
| `public void setTime(Long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L85-L87) |
| `public int getMessageType()` | Return stored value/reference: messageType. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L89-L91) |
| `public void setMessageType(int messageType)` | Assign this.messageType = messageType. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L93-L95) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L97-L99) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L101-L103) |
| `public Integer getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L105-L107) |
| `public void setARNStep(Integer ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/AfterSendLog.java:109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L109-L111) |

## Business
SOURCE_OBSERVED: Structured successful client.sendMessage-return event model; emitted by Server831. Does not prove recipient ACK or durable delivery.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:831](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L831).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/Server.java:831–841](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L831-L841) INFO `(new AfterSendLog( message.getSender(), message.getReceiver(), message.getId(), message.getTrackerId(), client.getClass().getSimpleName(), (System.currentTimeMillis() - message.getTime()), (System.currentTimeMillis() - startSendMessage), message.getType(), message.getARN(), message.getARNStep()))` [ALOG-9257352129C9]

---

### dossier-src-com-nozha-async-server-vo-log-baselog

<!-- source dossier: src/com/nozha/async/server/vo/log/BaseLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/BaseLog.java
source_sha256: 5e6652a6b63bb44912a3011f9ecee8867c9d3f10de5db9e59c5a553ba07d3df1
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# BaseLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `BaseLog` (class_declaration) [src/com/nozha/async/server/vo/log/BaseLog.java:7–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L7-L39)
UTC DateTimeFormatter yyyy-MM-ddTHH:mm:ss.SSSZ, runtime class simple-name logType and construction epoch tstamp.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Immutable shared DateTimeFormatter; subclass simple-name assigned by getClass at base initialization.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `FORMATTER` | `DateTimeFormatter` | [src/com/nozha/async/server/vo/log/BaseLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L8) |
| `logType` | `String` | [src/com/nozha/async/server/vo/log/BaseLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L10) |
| `tstamp` | `String` | [src/com/nozha/async/server/vo/log/BaseLog.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L11) |
Dependencies are imports (some may be unused): `java.time.Instant` [src/com/nozha/async/server/vo/log/BaseLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L3); `java.time.ZoneId` [src/com/nozha/async/server/vo/log/BaseLog.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L4); `java.time.format.DateTimeFormatter` [src/com/nozha/async/server/vo/log/BaseLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L5)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L5) `public class ServiceTimeLog extends BaseLog implements Serializable {`; [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L5) `public class WebsocketAddressLog extends BaseLog implements Serializable {`; [src/com/nozha/async/server/vo/log/BeforeSendLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L5) `public class BeforeSendLog extends BaseLog implements Serializable {`; [src/com/nozha/async/server/vo/log/AfterSendLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L5) `public class AfterSendLog extends BaseLog implements Serializable {`; [src/com/nozha/async/server/vo/log/RateLimitLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L3) `public class RateLimitLog extends BaseLog {`; [src/com/nozha/async/server/vo/log/ServiceCallLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L5) `public class ServiceCallLog extends BaseLog implements Serializable {`; [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L5) `public class OpenClientAddressLog extends BaseLog implements Serializable {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BaseLog()` | Empty constructor; field initialization supplies subtype logType and current timestamp. | [src/com/nozha/async/server/vo/log/BaseLog.java:13–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L13-L14) |
| `public BaseLog(String logType)` | Override default class-derived logType with parameter after field initialization. | [src/com/nozha/async/server/vo/log/BaseLog.java:16–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L16-L18) |
| `public String getLogType()` | Return stored value/reference: logType. No validation or copying. | [src/com/nozha/async/server/vo/log/BaseLog.java:20–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L20-L22) |
| `public void setLogType(String logType)` | Assign this.logType = logType. No validation or copying. | [src/com/nozha/async/server/vo/log/BaseLog.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L24-L26) |
| `public String getTStamp()` | Return stored value/reference: tstamp. No validation or copying. | [src/com/nozha/async/server/vo/log/BaseLog.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L28-L30) |
| `public void setTStamp(String tstamp)` | Assign this.tstamp = tstamp. No validation or copying. | [src/com/nozha/async/server/vo/log/BaseLog.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L32-L34) |
| `private static String formatCurrentTimeMillis(long millis)` | Convert epoch ms Instant through UTC formatter. | [src/com/nozha/async/server/vo/log/BaseLog.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BaseLog.java#L36-L38) |

## Business
SOURCE_OBSERVED: Indirect structured event envelope; timestamp is construction time, can be overwritten by setter; no emitter here.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class for normal epoch; setters accept null/arbitrary values without validation.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L5), [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L5), [src/com/nozha/async/server/vo/log/BeforeSendLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L5), [src/com/nozha/async/server/vo/log/AfterSendLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/AfterSendLog.java#L5), [src/com/nozha/async/server/vo/log/RateLimitLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L3), [src/com/nozha/async/server/vo/log/ServiceCallLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L5), [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L5).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-log-beforesendlog

<!-- source dossier: src/com/nozha/async/server/vo/log/BeforeSendLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/BeforeSendLog.java
source_sha256: 1f443eb896a74750d4975ec97a935439916a5ac7501ea67aac5c0842afd52034
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# BeforeSendLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `BeforeSendLog` (class_declaration) [src/com/nozha/async/server/vo/log/BeforeSendLog.java:5–132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L5-L132)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `retryCount` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L6) |
| `messageId` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L7) |
| `trackerId` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L8) |
| `time` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L9) |
| `sender` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L10) |
| `receiver` | `Long` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L11) |
| `client` | `String` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L12) |
| `messageServerId` | `Integer` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L13) |
| `serverId` | `Integer` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L14) |
| `address` | `String` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L15) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L16) |
| `ARNStep` | `Integer` | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L17) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/BeforeSendLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:809](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L809) ` loggerJson.info(new BeforeSendLog(message.getVersion(),`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BeforeSendLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:19–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L19-L20) |
| `public BeforeSendLog(Long retryCount, Long messageId, Long trackerId, Long time, Long sender, Long receiver, String client, Integer messageServerId, Integer serverId, String address, String ARN, Integer ARNStep)` | Constructor forwards/stores supplied values: `this.retryCount = retryCount; this.messageId = messageId; this.trackerId = trackerId; this.time = time; this.sender = sender; this.receiver = receiver; this.client = client; this.messageServerId = messageServerId; this.serverId = serverId; this.address = address; this.ARN = ARN; this.ARNStep = ARNStep;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:22–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L22-L35) |
| `public Long getRetryCount()` | Return stored value/reference: retryCount. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L37-L39) |
| `public void setRetryCount(Long retryCount)` | Assign this.retryCount = retryCount. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L41-L43) |
| `public Long getMessageId()` | Return stored value/reference: messageId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L45-L47) |
| `public void setMessageId(Long messageId)` | Assign this.messageId = messageId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L49-L51) |
| `public Long getTrackerId()` | Return stored value/reference: trackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L53-L55) |
| `public void setTrackerId(Long trackerId)` | Assign this.trackerId = trackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L57-L59) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L61-L63) |
| `public void setTime(Long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L65-L67) |
| `public Long getSender()` | Return stored value/reference: sender. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L69-L71) |
| `public void setSender(Long sender)` | Assign this.sender = sender. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L73-L75) |
| `public Long getReceiver()` | Return stored value/reference: receiver. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L77-L79) |
| `public void setReceiver(Long receiver)` | Assign this.receiver = receiver. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L81-L83) |
| `public String getClient()` | Return stored value/reference: client. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L85-L87) |
| `public void setClient(String client)` | Assign this.client = client. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L89-L91) |
| `public Integer getMessageServerId()` | Return stored value/reference: messageServerId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L93-L95) |
| `public void setMessageServerId(Integer messageServerId)` | Assign this.messageServerId = messageServerId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L97-L99) |
| `public Integer getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L101-L103) |
| `public void setServerId(Integer serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L105-L107) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L109-L111) |
| `public void setAddress(String address)` | Assign this.address = address. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L113-L115) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:117–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L117-L119) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:121–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L121-L123) |
| `public Integer getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:125–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L125-L127) |
| `public void setARNStep(Integer ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/BeforeSendLog.java:129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/BeforeSendLog.java#L129-L131) |

## Business
SOURCE_OBSERVED: Structured pre-send event model with retry/version, routing and correlation fields; emitted by Server809.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:809](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L809).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: address. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/Server.java:809–820](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L809-L820) INFO `(new BeforeSendLog(message.getVersion(), message.getId(), message.getTrackerId(), (System.currentTimeMillis() - message.getTime()), message.getSender(), message.getReceiver(), client.getClass().getSimpleName(), message.getServerId(), Settings.SERVER_ID, message.getAddress(), message.getARN(), message.getARNStep()))` [ALOG-EA217CF03EAD]

---

### dossier-src-com-nozha-async-server-vo-log-openclientaddresslog

<!-- source dossier: src/com/nozha/async/server/vo/log/OpenClientAddressLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/OpenClientAddressLog.java
source_sha256: ffcaeb64797afbc4777fcfdbc6d987c8d5265f046bb883ad69e9ab2d033016b0
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# OpenClientAddressLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `OpenClientAddressLog` (class_declaration) [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:5–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L5-L33)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `address` | `String` | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L6) |
| `clientType` | `int` | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L7) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/LoadManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L41) ` loggerAddress.error(new OpenClientAddressLog(client.getAddress(),type));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public OpenClientAddressLog(String address, int clientType)` | Constructor forwards/stores supplied values: `this.address = address; this.clientType = clientType;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:9–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L9-L12) |
| `public OpenClientAddressLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:14–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L14-L15) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L17-L19) |
| `public void setAddress(String address)` | Assign this.address = address. No validation or copying. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L21-L23) |
| `public int getClientType()` | Return stored value/reference: clientType. No validation or copying. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L25-L27) |
| `public void setClientType(int clientType)` | Assign this.clientType = clientType. No validation or copying. | [src/com/nozha/async/server/vo/log/OpenClientAddressLog.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/OpenClientAddressLog.java#L29-L31) |

## Business
SOURCE_OBSERVED: Opening rejection diagnostic address/clientType model emitted by LoadManager41.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/LoadManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L41).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: address. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/biz/LoadManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L41) ERROR `(new OpenClientAddressLog(client.getAddress(),type))` [ALOG-F1BC7F5A3338]

---

### dossier-src-com-nozha-async-server-vo-log-podmonitoringlog

<!-- source dossier: src/com/nozha/async/server/vo/log/PODMonitoringLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/PODMonitoringLog.java
source_sha256: 7380d1643748b2b43f9b8439f6e46534c8a121d59f99c1c260006f6c2704319c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# PODMonitoringLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `PODMonitoringLog` (class_declaration) [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:5–125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L5-L125)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `time` | `Long` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L6) |
| `action` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L7) |
| `duration` | `Long` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L8) |
| `totalDuration` | `Long` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L9) |
| `uri` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L10) |
| `statusCode` | `Integer` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L11) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L12) |
| `ARNStep` | `Integer` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L13) |
| `srcServerIp` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L14) |
| `srcName` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L15) |
| `descName` | `String` | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L16) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/PODLogUtil.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L52) ` logger.info(new PODMonitoringLog("GET-request", ARN, ARNStep, uri, srcServerIp, Settings.POD_MONITORING_SRC_NAME, descName, null, null, nul`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public PODMonitoringLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:18–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L18-L19) |
| `public PODMonitoringLog(String action, String ARN, Integer ARNStep, String uri, String srcServerIp, String srcName, String descName, Long duration, Integer statusCode, Long totalDuration)` | Constructor forwards/stores supplied values: `this.time=System.currentTimeMillis(); this.action=action; this.ARN=ARN; this.ARNStep=ARNStep; this.uri=uri; this.srcServerIp=srcServerIp; this.srcName=srcName; this.descName=descName; this.duration=duration; this.statusCode = statusCode; this.totalDuration = totalDuration;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:21–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L21-L33) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L36-L38) |
| `public void setTime(Long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L40-L42) |
| `public String getAction()` | Return stored value/reference: action. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L44-L46) |
| `public void setAction(String action)` | Assign this.action = action. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L48-L50) |
| `public Long getDuration()` | Return stored value/reference: duration. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L52-L54) |
| `public void setDuration(Long duration)` | Assign this.duration = duration. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L56-L58) |
| `public Long getTotalDuration()` | Return stored value/reference: totalDuration. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L60-L62) |
| `public void setTotalDuration(Long totalDuration)` | Assign this.totalDuration = totalDuration. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L64-L66) |
| `public String getUri()` | Return stored value/reference: uri. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:68–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L68-L70) |
| `public void setUri(String uri)` | Assign this.uri = uri. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:72–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L72-L74) |
| `public Integer getStatusCode()` | Return stored value/reference: statusCode. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:76–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L76-L78) |
| `public void setStatusCode(Integer statusCode)` | Assign this.statusCode = statusCode. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:80–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L80-L82) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:84–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L84-L86) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:88–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L88-L90) |
| `public Integer getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L92-L94) |
| `public void setARNStep(Integer ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:96–98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L96-L98) |
| `public String getSrcServerIp()` | Return stored value/reference: srcServerIp. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:100–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L100-L102) |
| `public void setSrcServerIp(String srcServerIp)` | Assign this.srcServerIp = srcServerIp. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:104–106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L104-L106) |
| `public String getSrcName()` | Return stored value/reference: srcName. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:108–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L108-L110) |
| `public void setSrcName(String srcName)` | Assign this.srcName = srcName. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:112–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L112-L114) |
| `public String getDescName()` | Return stored value/reference: descName. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:116–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L116-L118) |
| `public void setDescName(String descName)` | Assign this.descName = descName. No validation or copying. | [src/com/nozha/async/server/vo/log/PODMonitoringLog.java:120–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/PODMonitoringLog.java#L120-L122) |

## Business
SOURCE_OBSERVED: Monitoring stage/duration/status/ARN/source/destination event model; populated timestamp current epoch in constructor, no BaseLog inheritance.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/PODLogUtil.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L52).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: uri. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/util/PODLogUtil.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L52) INFO `(new PODMonitoringLog("GET-request", ARN, ARNStep, uri, srcServerIp, Settings.POD_MONITORING_SRC_NAME, descName, null, null, null))` [ALOG-8CEE7EAC4325]; [src/com/nozha/async/server/util/PODLogUtil.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L58) INFO `(new PODMonitoringLog("SEND-request", ARN, ArnStep, null, srcServerIp, Settings.POD_MONITORING_SRC_NAME, getServiceTag(descName), null, null, null))` [ALOG-125CB954B465]; [src/com/nozha/async/server/util/PODLogUtil.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L64) INFO `(new PODMonitoringLog("GET-response", ARN, ArnStep, null, srcServerIp, Settings.POD_MONITORING_SRC_NAME, getServiceTag(descName), duration, null, null))` [ALOG-043642CF5CD0]; [src/com/nozha/async/server/util/PODLogUtil.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L70) INFO `(new PODMonitoringLog("SEND-response", ARN, ArnStep, uri, srcServerIp, Settings.POD_MONITORING_SRC_NAME, descName, null, statusCode, totalDuration))` [ALOG-5EE5E640E496]

---

### dossier-src-com-nozha-async-server-vo-log-ratelimitlog

<!-- source dossier: src/com/nozha/async/server/vo/log/RateLimitLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/RateLimitLog.java
source_sha256: 91d6eac2e94395ecbc61c21e8d740dee62f371bf7e58b3164ac251d29c42b3c9
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `RateLimitLog` (class_declaration) [src/com/nozha/async/server/vo/log/RateLimitLog.java:3–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L3-L47)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `reference` | `String` | [src/com/nozha/async/server/vo/log/RateLimitLog.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L4) |
| `message` | `String` | [src/com/nozha/async/server/vo/log/RateLimitLog.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L5) |
| `time` | `long` | [src/com/nozha/async/server/vo/log/RateLimitLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L6) |
| `count` | `long` | [src/com/nozha/async/server/vo/log/RateLimitLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L7) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimitService.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L229) ` loggerJson.debug(new RateLimitLog(config.toString(), JsonUtil.getJson(config), System.nanoTime(), count));`; [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L39) ` loggerJson.debug(new RateLimitLog(inMemoryRateLimitConfig.toString(), JsonUtil.getJson(inMemoryRateLimitConfig), System.nanoTime(), inMemor`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public RateLimitLog(String reference, String message, long time, long count)` | Constructor forwards/stores supplied values: `this.reference = reference; this.message = message; this.time = time; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:9–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L9-L14) |
| `public String getReference()` | Return stored value/reference: reference. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:16–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L16-L18) |
| `public void setReference(String reference)` | Assign this.reference = reference. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:20–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L20-L22) |
| `public String getMessage()` | Return stored value/reference: message. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L24-L26) |
| `public void setMessage(String message)` | Assign this.message = message. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L28-L30) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L32-L34) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L36-L38) |
| `public long getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L40-L42) |
| `public void setCount(long count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/log/RateLimitLog.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/RateLimitLog.java#L44-L46) |

## Business
SOURCE_OBSERVED: Rate config reference/message/time/count event model; RateLimitService229 supplies System.nanoTime, not epoch milliseconds.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimitService.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L229), [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L39).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L39) DEBUG `(new RateLimitLog(inMemoryRateLimitConfig.toString(), JsonUtil.getJson(inMemoryRateLimitConfig), System.nanoTime(), inMemoryRateLimitConfig.getCount().get()))` [ALOG-C1DD758063A2]; [src/com/nozha/async/server/ratelimit/RateLimitService.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L229) DEBUG `(new RateLimitLog(config.toString(), JsonUtil.getJson(config), System.nanoTime(), count))` [ALOG-F71D4CF12110]

---

### dossier-src-com-nozha-async-server-vo-log-servicecalllog

<!-- source dossier: src/com/nozha/async/server/vo/log/ServiceCallLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/ServiceCallLog.java
source_sha256: 877a7e4a50a04f9a7e4dd831083a797573e4942cf76d49588d61578095e0ac23
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# ServiceCallLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `ServiceCallLog` (class_declaration) [src/com/nozha/async/server/vo/log/ServiceCallLog.java:5–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L5-L59)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `time` | `Long` | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L6) |
| `status` | `Integer` | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L7) |
| `serviceCallStatusCode` | `Integer` | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L8) |
| `uuid` | `String` | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L9) |
| `businessId` | `String` | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L10) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/ServiceCallLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/ServiceCallProxy.java:147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L147) ` scJsonLogger.info(new ServiceCallLog(`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ServiceCallLog(Long time, Integer status, Integer serviceCallStatusCode, String uuid, String businessId)` | Constructor forwards/stores supplied values: `this.time = time; this.status = status; this.serviceCallStatusCode = serviceCallStatusCode; this.uuid = uuid; this.businessId = businessId;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:12–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L12-L18) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:20–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L20-L22) |
| `public void setTime(Long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L24-L26) |
| `public Integer getStatus()` | Return stored value/reference: status. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L28-L30) |
| `public void setStatus(Integer status)` | Assign this.status = status. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L32-L34) |
| `public Integer getServiceCallStatusCode()` | Return stored value/reference: serviceCallStatusCode. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L36-L38) |
| `public void setServiceCallStatusCode(Integer serviceCallStatusCode)` | Assign this.serviceCallStatusCode = serviceCallStatusCode. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L40-L42) |
| `public String getUuid()` | Return stored value/reference: uuid. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L44-L46) |
| `public void setUuid(String uuid)` | Assign this.uuid = uuid. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L48-L50) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L52-L54) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceCallLog.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceCallLog.java#L56-L58) |

## Business
SOURCE_OBSERVED: Service-call diagnostic model separates response status from downstream serviceCallStatusCode and includes uuid/businessId.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/ServiceCallProxy.java:147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L147).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/ServiceCallProxy.java:147–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L147-L152) INFO `(new ServiceCallLog( (now - requestStartTime), response.code(), response.code() == 200 ? 0 : 227, (String) req.getAttribute("UUID"), businessId))` [ALOG-363FF9A25CB8]; [src/com/nozha/async/server/handler/ServiceCallProxy.java:190–195](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L190-L195) INFO `(new ServiceCallLog( (now - requestStartTime), 408, response != null && response.code() == 200 ? 0 : 227, (String) req.getAttribute("UUID"), businessId))` [ALOG-521396233883]

---

### dossier-src-com-nozha-async-server-vo-log-servicetimelog

<!-- source dossier: src/com/nozha/async/server/vo/log/ServiceTimeLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/ServiceTimeLog.java
source_sha256: a60e87a0e77976115c3c34dbc6d8231e3940567513b8c3bdc693a844b14b2865
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# ServiceTimeLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `ServiceTimeLog` (class_declaration) [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:5–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L5-L152)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `time` | `Long` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L6) |
| `clientTime` | `Long` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L7) |
| `status` | `Integer` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L8) |
| `uri` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L9) |
| `lastTrackerId` | `Long` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L10) |
| `uuid` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L11) |
| `messagePreview` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L12) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L13) |
| `ARNStep` | `Integer` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L14) |
| `businessId` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L15) |
| `address` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L16) |
| `provider` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L17) |
| `host` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L18) |
| `origin` | `String` | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L19) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/HttpHandler.java:439](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L439) ` loggerJson.info(new ServiceTimeLog(`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ServiceTimeLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:21–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L21-L22) |
| `public ServiceTimeLog(Long time, Long clientTime, Integer status, String uri, Long lastTrackerId, String uuid, String messagePreview, String businessId, String address, String providerName, String host, String origin, String ARN, Integer ARNStep)` | Constructor forwards/stores supplied values: `this.time = time; this.clientTime = clientTime; this.status = status; this.uri = uri; this.lastTrackerId = lastTrackerId; this.uuid = uuid; this.messagePreview = messagePreview; this.businessId = businessId; this.address = address; this.provider = providerName; this.host = host; this.origin = origin; this.ARN = ARN; this.ARNStep = ARNStep;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:24–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L24-L39) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L41-L43) |
| `public void setTime(Long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L45-L47) |
| `public Long getClientTime()` | Return stored value/reference: clientTime. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L49-L51) |
| `public void setClientTime(Long clientTime)` | Assign this.clientTime = clientTime. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L53-L55) |
| `public Integer getStatus()` | Return stored value/reference: status. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L57-L59) |
| `public void setStatus(Integer status)` | Assign this.status = status. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L61-L63) |
| `public String getUri()` | Return stored value/reference: uri. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L65-L67) |
| `public void setUri(String uri)` | Assign this.uri = uri. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L69-L71) |
| `public Long getLastTrackerId()` | Return stored value/reference: lastTrackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L73-L75) |
| `public void setLastTrackerId(Long lastTrackerId)` | Assign this.lastTrackerId = lastTrackerId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L77-L79) |
| `public String getUuid()` | Return stored value/reference: uuid. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L81-L83) |
| `public void setUuid(String uuid)` | Assign this.uuid = uuid. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L85-L87) |
| `public String getMessagePreview()` | Return stored value/reference: messagePreview. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L89-L91) |
| `public void setMessagePreview(String messagePreview)` | Assign this.messagePreview = messagePreview. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L93-L95) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L97-L99) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L101-L103) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L105-L107) |
| `public void setAddress(String address)` | Assign this.address = address. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L109-L111) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L113-L115) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:117–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L117-L119) |
| `public String getHost()` | Return stored value/reference: host. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:121–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L121-L123) |
| `public void setHost(String host)` | Assign this.host = host. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:125–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L125-L127) |
| `public String getOrigin()` | Return stored value/reference: origin. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L129-L131) |
| `public void setOrigin(String origin)` | Assign this.origin = origin. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:133–135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L133-L135) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:137–139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L137-L139) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:141–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L141-L143) |
| `public Integer getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:145–147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L145-L147) |
| `public void setARNStep(Integer ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/log/ServiceTimeLog.java:149–151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java#L149-L151) |

## Business
SOURCE_OBSERVED: Response timing/status/URI/tracker/uuid/preview/business/address/provider/host/origin/ARN model; privacy includes preview and URI, emission belongs to callers.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/HttpHandler.java:439](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L439).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: uri, messagePreview, businessId, address, origin. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/HttpHandler.java:439–453](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L439-L453) INFO `(new ServiceTimeLog( currentTime - startTime, clientMessage == null ? 0 : currentTime - clientMessage.getTime(), responseStatus, requestURI, httpClient.getLastTrackerId(), uuid, msgPreview, businessId != null ? (String) businessId : "-", httpClient.getAddress(), provider != null ? (String) provider : "-", host, client.getOrigin(), clientMessage == null ? "" : clientMessage.getARN(), clientMessage == null ? 0 : clientMessage.getARNStep()))` [ALOG-661971303632]

---

### dossier-src-com-nozha-async-server-vo-log-websocketaddresslog

<!-- source dossier: src/com/nozha/async/server/vo/log/WebsocketAddressLog.md -->

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
source_path: src/com/nozha/async/server/vo/log/WebsocketAddressLog.java
source_sha256: 4fe3a1e925592a548a50aa54d8b64073b712cb1c0a4cacd5cf7545ad0e4cddce
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java
business_approved: false
runtime_tested: false
promoted: false
---

# WebsocketAddressLog — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.log`. Types: `WebsocketAddressLog` (class_declaration) [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:5–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L5-L42)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `address` | `String` | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L6) |
| `notRegisteredClientMapSize` | `long` | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L7) |
| `clientMapSize` | `long` | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L8) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/WebsocketHandler.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L120) ` loggerAddress.info(new WebsocketAddressLog(websocketClient.getAddress(), notRegisteredClientMap.size(), clientMap.size()));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public WebsocketAddressLog(String address, long notRegisteredClientMapSize, long clientMapSize)` | Constructor forwards/stores supplied values: `this.address = address; this.clientMapSize = clientMapSize; this.notRegisteredClientMapSize = notRegisteredClientMapSize;`. References retained; no validation. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:10–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L10-L14) |
| `public WebsocketAddressLog()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:16–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L16-L17) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L19-L21) |
| `public void setAddress(String address)` | Assign this.address = address. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L23-L25) |
| `public long getNotRegisteredClientMapSize()` | Return stored value/reference: notRegisteredClientMapSize. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L27-L29) |
| `public void setNotRegisteredClientMapSize(long notRegisteredClientMapSize)` | Assign this.notRegisteredClientMapSize = notRegisteredClientMapSize. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L31-L33) |
| `public long getClientMapSize()` | Return stored value/reference: clientMapSize. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L35-L37) |
| `public void setClientMapSize(long clientMapSize)` | Assign this.clientMapSize = clientMapSize. No validation or copying. | [src/com/nozha/async/server/vo/log/WebsocketAddressLog.java:39–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/WebsocketAddressLog.java#L39-L41) |

## Business
SOURCE_OBSERVED: WebSocket address and unregistered/registered map-size diagnostic model.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/WebsocketHandler.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L120).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: address. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/WebsocketHandler.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L120) INFO `(new WebsocketAddressLog(websocketClient.getAddress(), notRegisteredClientMap.size(), clientMap.size()))` [ALOG-BEE858552C14]

---

### dossier-src-com-nozha-async-server-vo-ratelimit-atomiclongdeserializer

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java
source_sha256: 03d75623d7386ca6509f56de8d492d84b316205b7956f7c097211d6fe20c3c2c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java
business_approved: false
runtime_tested: false
promoted: false
---

# AtomicLongDeserializer — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit`. Types: `AtomicLongDeserializer` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:10–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L10-L16)
Jackson text→long→AtomicLong adapter (12–15).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.fasterxml.jackson.core.JsonParser` [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L3); `com.fasterxml.jackson.databind.DeserializationContext` [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L4); `com.fasterxml.jackson.databind.JsonDeserializer` [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L5); `java.io.IOException` [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L7); `java.util.concurrent.atomic.AtomicLong` [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L20) ` @JsonDeserialize(using = AtomicLongDeserializer.class)`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public AtomicLong deserialize(JsonParser parser, DeserializationContext context) throws IOException` | Read parser text, Long.parseLong, construct AtomicLong; context unused. | [src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java:11–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/AtomicLongDeserializer.java#L11-L15) |

## Business
SOURCE_OBSERVED: Indirect deserialization of rate-limit counter state; accepts numeric text, no nonnegative/range policy beyond Long parsing.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
IOException from parser propagates; invalid/out-of-range text NumberFormatException escapes; no catch/log.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L20).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-ratelimit-ratelimitconfig

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java
source_sha256: f8be5a63d0d3e39944d405dabfb4e843826bd78584266de2fc1a15f5f1e245f5
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit`. Types: `RateLimitConfig` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:7–139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L7-L139)
Mutable nullable boxed rate config with identity dimensions, capacity/refill/expiry, block flags, threshold and AtomicLong count; Jackson custom count deserializer.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Atomic counter is mutable reference, setter may replace; other fields unsynchronized; no toString override, so reference string in RateLimitService is Java identity representation.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `type` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L8) |
| `businessId` | `Long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L9) |
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L10) |
| `service` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L11) |
| `ip` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L12) |
| `limitKey` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L13) |
| `capacity` | `Long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L14) |
| `refillInterval` | `Long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L15) |
| `expireTime` | `Long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L16) |
| `temporarilyBlock` | `Boolean` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L17) |
| `permanentBlock` | `Boolean` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L18) |
| `countThreshold` | `Long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L19) |
| `count` | `AtomicLong` | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L20) |
Dependencies are imports (some may be unused): `com.fasterxml.jackson.databind.annotation.JsonDeserialize` [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L3); `java.util.concurrent.atomic.AtomicLong` [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L5)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/RateLimitServlet.java:86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L86) ` RateLimitConfig requestConfig = JsonUtil.getObject(body, RateLimitConfig.class);`; [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L54) ` List<RateLimitConfig> loadRateLimitConfig();`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L104) ` public static List<RateLimitConfig> loadRateLimitConfig() {`; [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L13) ` public static void updateRateLimitConfigDto(RateLimitConfig rateLimitConfig) throws HttpException {`; [src/com/nozha/async/server/ratelimit/RateLimitService.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L41) ` public static Map<String, RateLimitConfig> rateLimitConfigMap = new ConcurrentHashMap<>();`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:542](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L542) ` public List<RateLimitConfig> loadRateLimitConfig() {`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:543](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L543) ` public List<RateLimitConfig> loadRateLimitConfig() {`; [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L24) ` RateLimitConfig rateLimitConfig;`; [src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L38) ` public void sendMessage(RateLimitConfig rateLimitConfig) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public RateLimitConfig()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:23–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L23-L24) |
| `public RateLimitConfig(String limitKey, Long refillInterval, Long capacity, Long expireTime, Boolean permanentBlock, Long countThreshold, AtomicLong count)` | Constructor forwards/stores supplied values: `this.limitKey = limitKey; this.refillInterval = refillInterval; this.capacity = capacity; this.expireTime = expireTime; this.permanentBlock = permanentBlock; this.countThreshold = countThreshold; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:26–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L26-L34) |
| `public String getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L36-L38) |
| `public void setType(String type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L40-L42) |
| `public Long getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L44-L46) |
| `public void setBusinessId(Long businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L48-L50) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L52-L54) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L56-L58) |
| `public String getService()` | Return stored value/reference: service. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L60-L62) |
| `public void setService(String service)` | Assign this.service = service. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L64-L66) |
| `public String getIp()` | Return stored value/reference: ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:68–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L68-L70) |
| `public void setIp(String ip)` | Assign this.ip = ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:72–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L72-L74) |
| `public String getLimitKey()` | Return stored value/reference: limitKey. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:76–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L76-L78) |
| `public void setLimitKey(String limitKey)` | Assign this.limitKey = limitKey. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:80–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L80-L82) |
| `public Long getCapacity()` | Return stored value/reference: capacity. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:84–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L84-L86) |
| `public void setCapacity(Long capacity)` | Assign this.capacity = capacity. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:88–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L88-L90) |
| `public Long getRefillInterval()` | Return stored value/reference: refillInterval. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L92-L94) |
| `public void setRefillInterval(Long refillInterval)` | Assign this.refillInterval = refillInterval. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:96–98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L96-L98) |
| `public Long getExpireTime()` | Return stored value/reference: expireTime. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:100–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L100-L102) |
| `public void setExpireTime(Long expireTime)` | Assign this.expireTime = expireTime. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:104–106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L104-L106) |
| `public Boolean getTemporarilyBlock()` | Return stored value/reference: temporarilyBlock. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:108–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L108-L110) |
| `public void setTemporarilyBlocked(Boolean temporarilyBlock)` | Assign this.temporarilyBlock = temporarilyBlock. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:112–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L112-L114) |
| `public Boolean getPermanentBlock()` | Return stored value/reference: permanentBlock. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:116–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L116-L118) |
| `public void setPermanentBlock(Boolean permanentBlock)` | Assign this.permanentBlock = permanentBlock. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:120–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L120-L122) |
| `public Long getCountThreshold()` | Return stored value/reference: countThreshold. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:124–126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L124-L126) |
| `public void setCountThreshold(Long countThreshold)` | Assign this.countThreshold = countThreshold. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:128–130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L128-L130) |
| `public AtomicLong getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:132–134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L132-L134) |
| `public void setCount(AtomicLong count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java:136–138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitConfig.java#L136-L138) |

## Business
SOURCE_OBSERVED: Indirect quota/config message consumed by RateLimitService; capacity/refill are carried values here, no token consumption/refill algorithm in this class.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class constructors/accessors; nullable count/permanent flag/threshold allowed and may NPE on RateLimitService dereference. TemporarilyBlock defaults false.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/RateLimitServlet.java:86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L86), [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L54), [src/com/nozha/async/server/persistance/RateLimitCrud.java:104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L104), [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L13), [src/com/nozha/async/server/ratelimit/RateLimitService.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L41), [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:542](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L542), [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:543](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L543), [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L24).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-ratelimit-ratelimitdto

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/RateLimitDto.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java
source_sha256: c4df2e164343c0828d29d4b6f76a468c27d1800a550f36aea6bba93a7b4ca786
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit`. Types: `RateLimitDto` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:3–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L3-L70)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `path` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L4) |
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L5) |
| `origin` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L6) |
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L7) |
| `time` | `long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L8) |
| `responseTime` | `long` | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L9) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L24) ` public static void sendMessage(RateLimitDto message) {`; [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L56) ` public void sendMessage(RateLimitDto message) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public RateLimitDto(String provider, String path, String origin, String businessId, long time, long responseTime)` | Constructor forwards/stores supplied values: `this.path = path; this.provider = provider; this.origin = origin; this.businessId = businessId; this.time = time; this.responseTime = responseTime;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:11–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L11-L18) |
| `public RateLimitDto()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:20–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L20-L21) |
| `public String getPath()` | Return stored value/reference: path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L23-L25) |
| `public void setPath(String path)` | Assign this.path = path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L27-L29) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L31-L33) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L35-L37) |
| `public String getOrigin()` | Return stored value/reference: origin. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:39–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L39-L41) |
| `public void setOrigin(String origin)` | Assign this.origin = origin. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:43–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L43-L45) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L47-L49) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L51-L53) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L55-L57) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L59-L61) |
| `public long getResponseTime()` | Return stored value/reference: responseTime. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L63-L65) |
| `public void setResponseTime(long responseTime)` | Assign this.responseTime = responseTime. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java:67–69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/RateLimitDto.java#L67-L69) |

## Business
SOURCE_OBSERVED: Rate telemetry provider/path/origin/businessId/time/responseTime envelope; RateLimitKafkaManager stamps timing.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L24), [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L56).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: origin, businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-ratelimit-resultresponse

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/ResultResponse.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/ResultResponse.java
source_sha256: 1c8a9299311fdc0b4ce620dface19665d9ff925eac6b3afd5546944741a3409f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java
business_approved: false
runtime_tested: false
promoted: false
---

# ResultResponse — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit`. Types: `ResultResponse` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:10–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L10-L84)
HTTP result envelope builds method+URI path, timestamp, status supplied by caller and UUID-server reference.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Static SimpleDateFormat shared without synchronization, concurrent constructors can corrupt formatted timestamps (12,24,32).
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `sdf` | `SimpleDateFormat` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L12) |
| `status` | `int` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L14) |
| `path` | `String` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L15) |
| `timestamp` | `String` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L16) |
| `result` | `T` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L17) |
| `message` | `String` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L18) |
| `reference` | `String` | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L19) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L3); `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L4); `java.sql.Timestamp` [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L6); `java.text.SimpleDateFormat` [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L7); `java.util.UUID` [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L121) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L112) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L63) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L187) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L158) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/AccessServlet.java:91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L91) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`; [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L178) ` ResultResponse<JsonNode> resultResponse = new ResultResponse<>(req, httpStatus, message);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ResultResponse(HttpServletRequest req, int status, T result)` | Store status/path=request method+space+URI, format current timestamp, result, and random UUID-server reference. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:21–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L21-L27) |
| `public ResultResponse(HttpServletRequest req, int status, String message)` | Same envelope metadata but store message instead of result. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:29–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L29-L35) |
| `public int getStatus()` | Return stored value/reference: status. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L37-L39) |
| `public void setStatus(int status)` | Assign this.status = status. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L41-L43) |
| `public String getPath()` | Return stored value/reference: path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L45-L47) |
| `public void setPath(String path)` | Assign this.path = path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L49-L51) |
| `public String getTimestamp()` | Return stored value/reference: timestamp. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L53-L55) |
| `public void setTimestamp(String timestamp)` | Assign this.timestamp = timestamp. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L57-L59) |
| `public T getResult()` | Return stored value/reference: result. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L61-L63) |
| `public void setResult(T result)` | Assign this.result = result. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L65-L67) |
| `public String getReference()` | Return stored value/reference: reference. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L69-L71) |
| `public void setReference(String reference)` | Assign this.reference = reference. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L73-L75) |
| `public String getMessage()` | Return stored value/reference: message. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L77-L79) |
| `public void setMessage(String message)` | Assign this.message = message. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ResultResponse.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ResultResponse.java#L81-L83) |

## Business
SOURCE_OBSERVED: Indirect customer diagnostic/result format; supplied status is data field, this class does not set HTTP response status. A fresh reference per envelope is not automatically persisted/logged.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Null request NPE; no local validation/catch. Caller owns success/error interpretation.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L121), [src/com/nozha/async/server/httpserver/RateLimitServlet.java:112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L112), [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L63), [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L187), [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L158), [src/com/nozha/async/server/httpserver/AccessServlet.java:91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L91), [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L178).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-ratelimit-business-businesscallsdto

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java
source_sha256: b734b7b4fba77078ed874e5406cf15b686e445f26352f04a4e090856bd5c9cf7
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessCallsDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.business`. Types: `BusinessCallsDto` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:5–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L5-L33)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L7) |
| `uri` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L8) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L3)
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BusinessCallsDto()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:10–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L10-L11) |
| `public BusinessCallsDto(String businessId, String uri)` | Constructor forwards/stores supplied values: `this.businessId = businessId; this.uri = uri;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:13–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L13-L16) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L18-L20) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L22-L24) |
| `public String getUri()` | Return stored value/reference: uri. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L26-L28) |
| `public void setUri(String uri)` | Assign this.uri = uri. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessCallsDto.java#L30-L32) |

## Business
SOURCE_OBSERVED: Serializable businessId/URI request observation pair.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. No source-evidenced caller emitter found by class-name scan.
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId, uri. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
