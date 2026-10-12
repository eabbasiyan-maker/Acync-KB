# Async Java class dossiers — candidate batch 9


---

<!-- source dossier: src/com/nozha/async/server/model/CandidateDto.md -->

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
source_path: src/com/nozha/async/server/model/CandidateDto.java
source_sha256: 6d47074fce1dc9b8644192358f580be0749b3419136ccffadb7fe1f47485171c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# CandidateDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `CandidateDto` (class_declaration) [src/com/nozha/async/server/model/CandidateDto.java:5–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L5-L16)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `candidate` | `IceCandidate` | [src/com/nozha/async/server/model/CandidateDto.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L6) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/model/CandidateDto.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L3)
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public CandidateDto()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/model/CandidateDto.java:7–8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L7-L8) |
| `public IceCandidate getCandidate()` | Return stored value/reference: candidate. No validation or copying. | [src/com/nozha/async/server/model/CandidateDto.java:10–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L10-L12) |
| `public void setCandidate(IceCandidate candidate)` | Assign this.candidate = candidate. No validation or copying. | [src/com/nozha/async/server/model/CandidateDto.java:13–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L13-L15) |

## Business
SOURCE_OBSERVED: Serializable wrapper for ICE signaling candidate.
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
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/CoapRegistration.md -->

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
source_path: src/com/nozha/async/server/model/CoapRegistration.java
source_sha256: 7f538b027937c4092b61207e3df63030a087e1f2c91afc5f9495b7a095bd75d1
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java
business_approved: false
runtime_tested: false
promoted: false
---

# CoapRegistration — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `CoapRegistration` (class_declaration) [src/com/nozha/async/server/model/CoapRegistration.java:3–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L3-L85)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/model/CoapRegistration.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L4) |
| `version` | `long` | [src/com/nozha/async/server/model/CoapRegistration.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L5) |
| `time` | `long` | [src/com/nozha/async/server/model/CoapRegistration.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L6) |
| `peerId` | `long` | [src/com/nozha/async/server/model/CoapRegistration.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L7) |
| `clientId` | `String` | [src/com/nozha/async/server/model/CoapRegistration.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L8) |
| `factoryName` | `String` | [src/com/nozha/async/server/model/CoapRegistration.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L9) |
| `type` | `int` | [src/com/nozha/async/server/model/CoapRegistration.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L10) |
| `serverId` | `int` | [src/com/nozha/async/server/model/CoapRegistration.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L11) |
| `endPoint` | `String` | [src/com/nozha/async/server/model/CoapRegistration.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L12) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/CoapHandler.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L48) ` CoapRegistration coapRegistration = getCoapRegisterDevice(endPoint);`; [src/com/nozha/async/server/biz/RegistrationManager.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L239) ` public static void createCoapRegistration(CoapRegistration coapRegistration) throws ServerException {`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:355](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L355) ` CoapRegistration coapRegistration = new CoapRegistration();`; [src/com/nozha/async/server/persistance/CoapCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L11) ` CoapRegistration createCoapRegistration(CoapRegistration coapRegistration, Integer serverId);`; [src/com/nozha/async/server/persistance/CoapCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L24) ` public static CoapRegistration createCoapRegistration(CoapRegistration coapRegistration) {`; [src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L51) ` public CoapRegistration createCoapRegistration(CoapRegistration coapRegistration, Integer serverId) {`; [src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L47) ` public CoapRegistration createCoapRegistration(CoapRegistration coapRegistration, Integer serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:14–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L14-L16) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L18-L20) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L22-L24) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L26-L28) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L30-L32) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:34–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L34-L36) |
| `public long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:38–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L38-L40) |
| `public void setPeerId(long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L42-L44) |
| `public String getClientId()` | Return stored value/reference: clientId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L46-L48) |
| `public void setClientId(String clientId)` | Assign this.clientId = clientId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:50–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L50-L52) |
| `public String getFactoryName()` | Return stored value/reference: factoryName. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L54-L56) |
| `public void setFactoryName(String factoryName)` | Assign this.factoryName = factoryName. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:58–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L58-L60) |
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:62–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L62-L64) |
| `public void setType(int type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:66–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L66-L68) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L70-L72) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:74–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L74-L76) |
| `public String getEndPoint()` | Return stored value/reference: endPoint. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L78-L80) |
| `public void setEndPoint(String endPoint)` | Assign this.endPoint = endPoint. No validation or copying. | [src/com/nozha/async/server/model/CoapRegistration.java:82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CoapRegistration.java#L82-L84) |

## Business
SOURCE_OBSERVED: Carries peer/client/endpoint/factory/type/server registration identity for CoAP transport.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/CoapHandler.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L48), [src/com/nozha/async/server/biz/RegistrationManager.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L239), [src/com/nozha/async/server/httpserver/RegisterServlet.java:355](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L355), [src/com/nozha/async/server/persistance/CoapCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUDInterface.java#L11), [src/com/nozha/async/server/persistance/CoapCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/CoapCRUD.java#L24), [src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L51), [src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L47).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/DeviceRegistration.md -->

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
source_path: src/com/nozha/async/server/model/DeviceRegistration.java
source_sha256: 056157cee97e5ce268d68550711602430145331f900f18990beb80ab98bfc512
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java
business_approved: false
runtime_tested: false
promoted: false
---

# DeviceRegistration — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `DeviceRegistration` (class_declaration) [src/com/nozha/async/server/model/DeviceRegistration.java:3–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L3-L85)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/model/DeviceRegistration.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L4) |
| `version` | `long` | [src/com/nozha/async/server/model/DeviceRegistration.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L5) |
| `time` | `long` | [src/com/nozha/async/server/model/DeviceRegistration.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L6) |
| `peerId` | `long` | [src/com/nozha/async/server/model/DeviceRegistration.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L7) |
| `clientId` | `String` | [src/com/nozha/async/server/model/DeviceRegistration.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L8) |
| `inputQueueName` | `String` | [src/com/nozha/async/server/model/DeviceRegistration.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L9) |
| `factoryName` | `String` | [src/com/nozha/async/server/model/DeviceRegistration.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L10) |
| `type` | `int` | [src/com/nozha/async/server/model/DeviceRegistration.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L11) |
| `serverId` | `int` | [src/com/nozha/async/server/model/DeviceRegistration.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L12) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/MqttHandler.java:159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L159) ` DeviceRegistration deviceRegistration = DeviceCRUD.getDeviceRegistration(clientId);`; [src/com/nozha/async/server/biz/RegistrationManager.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L229) ` public static void createDeviceRegistration(DeviceRegistration deviceRegistration) throws ServerException {`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L262) ` DeviceRegistration deviceRegistration = new DeviceRegistration();`; [src/com/nozha/async/server/persistance/DeviceCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L24) ` public static DeviceRegistration createDeviceRegistration(DeviceRegistration deviceRegistration) {`; [src/com/nozha/async/server/persistance/DeviceCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L11) ` DeviceRegistration createDeviceRegistration(DeviceRegistration deviceRegistration, Integer serverId);`; [src/com/nozha/async/server/client/MqttClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L30) ` public MqttClient(DeviceRegistration deviceRegistration) {`; [src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L51) ` public DeviceRegistration createDeviceRegistration(DeviceRegistration deviceRegistration, Integer serverId) {`; [src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L48) ` public DeviceRegistration createDeviceRegistration(DeviceRegistration deviceRegistration, Integer serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:14–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L14-L16) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L18-L20) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L22-L24) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L26-L28) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L30-L32) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:34–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L34-L36) |
| `public long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:38–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L38-L40) |
| `public void setPeerId(long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L42-L44) |
| `public String getClientId()` | Return stored value/reference: clientId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L46-L48) |
| `public void setClientId(String clientId)` | Assign this.clientId = clientId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:50–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L50-L52) |
| `public String getInputQueueName()` | Return stored value/reference: inputQueueName. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L54-L56) |
| `public void setInputQueueName(String inputQueueName)` | Assign this.inputQueueName = inputQueueName. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:58–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L58-L60) |
| `public String getFactoryName()` | Return stored value/reference: factoryName. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:62–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L62-L64) |
| `public void setFactoryName(String factoryName)` | Assign this.factoryName = factoryName. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:66–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L66-L68) |
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L70-L72) |
| `public void setType(int type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:74–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L74-L76) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L78-L80) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/DeviceRegistration.java:82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/DeviceRegistration.java#L82-L84) |

## Business
SOURCE_OBSERVED: Carries peer/client/input queue/factory/type/server device transport registration identity.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/MqttHandler.java:159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L159), [src/com/nozha/async/server/biz/RegistrationManager.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L229), [src/com/nozha/async/server/httpserver/RegisterServlet.java:262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L262), [src/com/nozha/async/server/persistance/DeviceCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUD.java#L24), [src/com/nozha/async/server/persistance/DeviceCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/DeviceCRUDInterface.java#L11), [src/com/nozha/async/server/client/MqttClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L30), [src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L51), [src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L48).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/IceCandidate.md -->

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
source_path: src/com/nozha/async/server/model/IceCandidate.java
source_sha256: fc37c760a1e18f3b481621e6d62a1a6d636ca1968908e6cbe6c58d38aa86be4f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java
business_approved: false
runtime_tested: false
promoted: false
---

# IceCandidate — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `IceCandidate` (class_declaration) [src/com/nozha/async/server/model/IceCandidate.java:3–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L3-L40)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `candidate` | `String` | [src/com/nozha/async/server/model/IceCandidate.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L4) |
| `sdpMid` | `String` | [src/com/nozha/async/server/model/IceCandidate.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L5) |
| `sdpMLineIndex` | `int` | [src/com/nozha/async/server/model/IceCandidate.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L6) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/WebrtcHandler.java:137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L137) ` List<IceCandidate> iceCandidates = new ArrayList<>(webrtcClient.getIceCandidates());`; [src/com/nozha/async/server/model/AddIceCandidate.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/AddIceCandidate.java#L4) ` public IceCandidate candidate;`; [src/com/nozha/async/server/model/IceCandidatesResponse.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L6) ` public List<IceCandidate> iceCandidates;`; [src/com/nozha/async/server/model/CandidateDto.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L6) ` private IceCandidate candidate;`; [src/com/nozha/async/server/client/WebrtcClient.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L37) ` List<IceCandidate> iceCandidates = Collections.synchronizedList(new ArrayList<>());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public IceCandidate()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/model/IceCandidate.java:8–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L8-L9) |
| `public IceCandidate(String candidate, String sdpMid, int sdpMLineIndex)` | Constructor forwards/stores supplied values: `this.candidate = candidate; this.sdpMid = sdpMid; this.sdpMLineIndex = sdpMLineIndex;`. References retained; no validation. | [src/com/nozha/async/server/model/IceCandidate.java:11–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L11-L15) |
| `public String getCandidate()` | Return stored value/reference: candidate. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L17-L19) |
| `public void setCandidate(String candidate)` | Assign this.candidate = candidate. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L21-L23) |
| `public String getSdpMid()` | Return stored value/reference: sdpMid. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L25-L27) |
| `public void setSdpMid(String sdpMid)` | Assign this.sdpMid = sdpMid. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L29-L31) |
| `public int getSdpMLineIndex()` | Return stored value/reference: sdpMLineIndex. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L33-L35) |
| `public void setSdpMLineIndex(int sdpMLineIndex)` | Assign this.sdpMLineIndex = sdpMLineIndex. No validation or copying. | [src/com/nozha/async/server/model/IceCandidate.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidate.java#L37-L39) |

## Business
SOURCE_OBSERVED: Carries ICE candidate string, SDP media ID and line index in WebRTC signaling.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/WebrtcHandler.java:137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L137), [src/com/nozha/async/server/model/AddIceCandidate.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/AddIceCandidate.java#L4), [src/com/nozha/async/server/model/IceCandidatesResponse.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L6), [src/com/nozha/async/server/model/CandidateDto.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/CandidateDto.java#L6), [src/com/nozha/async/server/client/WebrtcClient.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L37).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/IceCandidatesResponse.md -->

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
source_path: src/com/nozha/async/server/model/IceCandidatesResponse.java
source_sha256: 2152d199fa464aa984d05447cfb5f55bc266dd84dc318e113bab842195a52fc0
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java
business_approved: false
runtime_tested: false
promoted: false
---

# IceCandidatesResponse — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `IceCandidatesResponse` (class_declaration) [src/com/nozha/async/server/model/IceCandidatesResponse.java:5–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L5-L11)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `iceCandidates` | `List<IceCandidate>` | [src/com/nozha/async/server/model/IceCandidatesResponse.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L6) |
Dependencies are imports (some may be unused): `java.util.List` [src/com/nozha/async/server/model/IceCandidatesResponse.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/WebrtcHandler.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L139) ` resp.getOutputStream().write(JsonUtil.getJson(new IceCandidatesResponse(iceCandidates)).getBytes(StandardCharsets.UTF_8));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public IceCandidatesResponse(List<IceCandidate> iceCandidates)` | Assign this.iceCandidates = iceCandidates. No validation or copying. | [src/com/nozha/async/server/model/IceCandidatesResponse.java:8–10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/IceCandidatesResponse.java#L8-L10) |

## Business
SOURCE_OBSERVED: Returns supplied ICE candidate list by reference.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/WebrtcHandler.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L139).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/MediatorMapping.md -->

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
source_path: src/com/nozha/async/server/model/MediatorMapping.java
source_sha256: 223773ae28d4dae71cf759af5506e1cf967193aff196186237436ca17b7cc5fc
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java
business_approved: false
runtime_tested: false
promoted: false
---

# MediatorMapping — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `MediatorMapping` (class_declaration) [src/com/nozha/async/server/model/MediatorMapping.java:6–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L6-L14)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/model/MediatorMapping.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L7) |
| `version` | `long` | [src/com/nozha/async/server/model/MediatorMapping.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L8) |
| `sendingOrReceiving` | `byte` | [src/com/nozha/async/server/model/MediatorMapping.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L9) |
| `receiverExp` | `String` | [src/com/nozha/async/server/model/MediatorMapping.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L10) |
| `urlExp` | `String` | [src/com/nozha/async/server/model/MediatorMapping.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L11) |
| `methodExp` | `String` | [src/com/nozha/async/server/model/MediatorMapping.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L12) |
| `mediationConfig` | `String` | [src/com/nozha/async/server/model/MediatorMapping.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/MediatorMapping.java#L13) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review
No active declared methods.

## Business
SOURCE_OBSERVED: Private field-only mapping data shape for sending/receiving and receiver/URL/method expressions plus mediationConfig; no public accessor/constructor behavior.
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
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/Message.md -->

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
source_path: src/com/nozha/async/server/model/Message.java
source_sha256: bf20ea8b06bfcf1d37bd7ee4e1d8b2fad6e22b7f16a399f95066a9b29ea91012
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java
business_approved: false
runtime_tested: false
promoted: false
---

# Message — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `Message` (class_declaration) [src/com/nozha/async/server/model/Message.java:8–233](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L8-L233)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `CREATED` | `int` | [src/com/nozha/async/server/model/Message.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L9) |
| `PENDING` | `int` | [src/com/nozha/async/server/model/Message.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L10) |
| `SENT` | `int` | [src/com/nozha/async/server/model/Message.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L11) |
| `NOT_SENT` | `int` | [src/com/nozha/async/server/model/Message.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L12) |
| `CANCELED` | `int` | [src/com/nozha/async/server/model/Message.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L13) |
| `DELIVERED` | `int` | [src/com/nozha/async/server/model/Message.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L14) |
| `id` | `long` | [src/com/nozha/async/server/model/Message.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L16) |
| `version` | `long` | [src/com/nozha/async/server/model/Message.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L17) |
| `sender` | `long` | [src/com/nozha/async/server/model/Message.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L18) |
| `receiver` | `long` | [src/com/nozha/async/server/model/Message.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L19) |
| `collapseId` | `long` | [src/com/nozha/async/server/model/Message.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L20) |
| `groupId` | `long` | [src/com/nozha/async/server/model/Message.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L21) |
| `time` | `long` | [src/com/nozha/async/server/model/Message.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L22) |
| `index` | `int` | [src/com/nozha/async/server/model/Message.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L23) |
| `priority` | `int` | [src/com/nozha/async/server/model/Message.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L24) |
| `messageId` | `long` | [src/com/nozha/async/server/model/Message.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L25) |
| `expireDate` | `long` | [src/com/nozha/async/server/model/Message.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L26) |
| `retryDate` | `long` | [src/com/nozha/async/server/model/Message.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L27) |
| `content` | `String` | [src/com/nozha/async/server/model/Message.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L28) |
| `address` | `String` | [src/com/nozha/async/server/model/Message.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L29) |
| `origin` | `String` | [src/com/nozha/async/server/model/Message.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L30) |
| `status` | `int` | [src/com/nozha/async/server/model/Message.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L31) |
| `type` | `int` | [src/com/nozha/async/server/model/Message.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L32) |
| `prvt` | `boolean` | [src/com/nozha/async/server/model/Message.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L33) |
| `sync` | `boolean` | [src/com/nozha/async/server/model/Message.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L34) |
| `trackerId` | `long` | [src/com/nozha/async/server/model/Message.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L35) |
| `serverId` | `int` | [src/com/nozha/async/server/model/Message.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L36) |
| `ARN` | `String` | [src/com/nozha/async/server/model/Message.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L38) |
| `ARNStep` | `int` | [src/com/nozha/async/server/model/Message.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L39) |
| `binaryContent` | `byte []` | [src/com/nozha/async/server/model/Message.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L40) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/model/Message.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/SimpleMqttClient.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/SimpleMqttClient.java#L70) ` System.out.println("\| Message: " + new String(message.getPayload()));`; [src/com/nozha/async/server/Server.java:401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L401) ` Message message = MessageManager.ackMessage(client, messageWrapperVO);`; [src/com/nozha/async/server/handler/MqttHandler.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L85) ` logger.info("Call MqttHandler Send Message topic={}",mqttClient.getTopic());`; [src/com/nozha/async/server/handler/RestHandler.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L333) ` logger.error("not send Message to RestClient with id:{} , peerId:{}",`; [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L8) ` public OutboundPayload from(Message message) {`; [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47) ` public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentExcepti`; [src/com/nozha/async/server/biz/RegistrationManager.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L142) ` Message message = new Message();`; [src/com/nozha/async/server/persistance/MessageCRUDInterface.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L14) ` Message create(Message message, Integer serverId);`; [src/com/nozha/async/server/persistance/ClientCRUD.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L111) ` public static int findReceiverServer(Message message) {`; [src/com/nozha/async/server/persistance/MessageCRUD.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L46) ` public static Message create(Message message) {`; [src/com/nozha/async/server/util/PODLogUtil.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L84) ` public static void logGetResponse(Logger logger, Message message, String descName, long duration) {`; [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L126) ` public void onMessage(Message message) {`; [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L125) ` public void onMessage(Message message) {`; [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L275) ` public void onMessage(Message message) {`; [src/com/nozha/async/server/vo/ClientMessage.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L40) ` public ClientMessage(Message message) {`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:625](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L625) ` ps.setInt(2, Message.CANCELED);`; [src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L143) ` public Message create(Message message, Integer serverId) {`; [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:707](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L707) ` ps.setInt(2, Message.CANCELED);`; [src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java:119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L119) ` public Message create(Message message, Integer serverId) {`; [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L21) ` public void onMessage(Message message) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/Message.java:42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L42-L44) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/Message.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L46-L48) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/Message.java:50–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L50-L52) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/Message.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L54-L56) |
| `public long getSender()` | Return stored value/reference: sender. No validation or copying. | [src/com/nozha/async/server/model/Message.java:58–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L58-L60) |
| `public void setSender(long sender)` | Assign this.sender = sender. No validation or copying. | [src/com/nozha/async/server/model/Message.java:62–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L62-L64) |
| `public long getReceiver()` | Return stored value/reference: receiver. No validation or copying. | [src/com/nozha/async/server/model/Message.java:66–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L66-L68) |
| `public void setReceiver(long receiver)` | Assign this.receiver = receiver. No validation or copying. | [src/com/nozha/async/server/model/Message.java:70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L70-L72) |
| `public long getCollapseId()` | Return stored value/reference: collapseId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:74–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L74-L76) |
| `public void setCollapseId(long collapseId)` | Assign this.collapseId = collapseId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L78-L80) |
| `public long getGroupId()` | Return stored value/reference: groupId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L82-L84) |
| `public void setGroupId(long groupId)` | Assign this.groupId = groupId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:86–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L86-L88) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/Message.java:90–92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L90-L92) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/Message.java:94–96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L94-L96) |
| `public int getIndex()` | Return stored value/reference: index. No validation or copying. | [src/com/nozha/async/server/model/Message.java:98–100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L98-L100) |
| `public void setIndex(int index)` | Assign this.index = index. No validation or copying. | [src/com/nozha/async/server/model/Message.java:102–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L102-L104) |
| `public int getPriority()` | Return stored value/reference: priority. No validation or copying. | [src/com/nozha/async/server/model/Message.java:106–108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L106-L108) |
| `public void setPriority(int priority)` | Assign this.priority = priority. No validation or copying. | [src/com/nozha/async/server/model/Message.java:110–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L110-L112) |
| `public long getMessageId()` | Return stored value/reference: messageId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:114–116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L114-L116) |
| `public void setMessageId(long messageId)` | Assign this.messageId = messageId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:118–120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L118-L120) |
| `public long getExpireDate()` | Return stored value/reference: expireDate. No validation or copying. | [src/com/nozha/async/server/model/Message.java:122–124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L122-L124) |
| `public void setExpireDate(long expireDate)` | Assign this.expireDate = expireDate. No validation or copying. | [src/com/nozha/async/server/model/Message.java:126–128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L126-L128) |
| `public long getRetryDate()` | Return stored value/reference: retryDate. No validation or copying. | [src/com/nozha/async/server/model/Message.java:130–132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L130-L132) |
| `public void setRetryDate(long retryDate)` | Assign this.retryDate = retryDate. No validation or copying. | [src/com/nozha/async/server/model/Message.java:134–136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L134-L136) |
| `public String getContent()` | Return stored value/reference: content. No validation or copying. | [src/com/nozha/async/server/model/Message.java:138–140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L138-L140) |
| `public void setContent(String content)` | Assign this.content = content. No validation or copying. | [src/com/nozha/async/server/model/Message.java:142–144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L142-L144) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/model/Message.java:146–148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L146-L148) |
| `public void setAddress(String address)` | Assign this.address = address. No validation or copying. | [src/com/nozha/async/server/model/Message.java:150–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L150-L152) |
| `public String getOrigin()` | Return stored value/reference: origin. No validation or copying. | [src/com/nozha/async/server/model/Message.java:154–156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L154-L156) |
| `public void setOrigin(String origin)` | Assign this.origin = origin. No validation or copying. | [src/com/nozha/async/server/model/Message.java:158–160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L158-L160) |
| `public int getStatus()` | Return stored value/reference: status. No validation or copying. | [src/com/nozha/async/server/model/Message.java:162–164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L162-L164) |
| `public void setStatus(int status)` | Assign this.status = status. No validation or copying. | [src/com/nozha/async/server/model/Message.java:166–168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L166-L168) |
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/model/Message.java:170–172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L170-L172) |
| `public void setType(int type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/model/Message.java:174–176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L174-L176) |
| `public boolean isPrvt()` | Return stored value/reference: prvt. No validation or copying. | [src/com/nozha/async/server/model/Message.java:178–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L178-L180) |
| `public void setPrvt(boolean prvt)` | Assign this.prvt = prvt. No validation or copying. | [src/com/nozha/async/server/model/Message.java:182–184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L182-L184) |
| `public boolean isSync()` | Return stored value/reference: sync. No validation or copying. | [src/com/nozha/async/server/model/Message.java:186–188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L186-L188) |
| `public void setSync(boolean sync)` | Assign this.sync = sync. No validation or copying. | [src/com/nozha/async/server/model/Message.java:190–192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L190-L192) |
| `public long getTrackerId()` | Return stored value/reference: trackerId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:194–196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L194-L196) |
| `public void setTrackerId(long trackerId)` | Assign this.trackerId = trackerId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:198–200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L198-L200) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:202–204](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L202-L204) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/Message.java:206–208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L206-L208) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/model/Message.java:210–212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L210-L212) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/model/Message.java:214–216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L214-L216) |
| `public int getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/model/Message.java:218–220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L218-L220) |
| `public void setARNStep(int ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/model/Message.java:222–224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L222-L224) |
| `public byte[] getBinaryContent()` | Return stored value/reference: binaryContent. No validation or copying. | [src/com/nozha/async/server/model/Message.java:226–228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L226-L228) |
| `public void setBinaryContent(byte[] binaryContent)` | Assign this.binaryContent = binaryContent. No validation or copying. | [src/com/nozha/async/server/model/Message.java:230–232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Message.java#L230-L232) |

## Business
SOURCE_OBSERVED: Serializable message persistence/delivery state and correlation model; status constants are CREATED1,PENDING2,SENT4,NOT_SENT8,CANCELED16,DELIVERED32; setters do not enforce transitions.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/SimpleMqttClient.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/SimpleMqttClient.java#L70), [src/com/nozha/async/server/Server.java:401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L401), [src/com/nozha/async/server/handler/MqttHandler.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L85), [src/com/nozha/async/server/handler/RestHandler.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L333), [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L8), [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47), [src/com/nozha/async/server/biz/RegistrationManager.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L142), [src/com/nozha/async/server/persistance/MessageCRUDInterface.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUDInterface.java#L14).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: content, address, origin, binaryContent. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java:24–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncInternalMessageSender.java#L24-L25) ERROR `("Internal Message Sender ThreadPool is almost full. ActiveThreadCount={} ,MaximumPoolSize={}, usage={}% ", executorService.getActiveCount(), executorService.getMaximumPoolSize(), threadPoolUsage)` [ALOG-F263E3EBD3A2]; [src/com/nozha/async/server/activemq/local/AsyncProducer.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncProducer.java#L54) DEBUG `("Send Message to server={} messageId={} ", receiverServer, message.getId())` [ALOG-8CFFC8CF622C]; [src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitProducer.java#L47) DEBUG `("Send Message to server jsonMessage={} ", json)` [ALOG-08F6D4E920AE]; [src/com/nozha/async/server/handler/MqttHandler.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L85) INFO `("Call MqttHandler Send Message topic={}",mqttClient.getTopic())` [ALOG-5E267191BCF5]; [src/com/nozha/async/server/handler/MqttHandler.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L89) WARN `("An exception occurred in Mqtt Send Message", e)` [ALOG-6DE99C27C120]; [src/com/nozha/async/server/handler/RestHandler.java:333–334](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L333-L334) ERROR `("not send Message to RestClient with id:{} , peerId:{}", restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1, e)` [ALOG-FEE8383B0D43]


---

<!-- source dossier: src/com/nozha/async/server/model/Peer.md -->

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
source_path: src/com/nozha/async/server/model/Peer.java
source_sha256: 43b9f68f6dfe8ab3051140b4508f181d3ec1307a08202f306b7266aa159a8235
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java
business_approved: false
runtime_tested: false
promoted: false
---

# Peer — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `Peer` (class_declaration) [src/com/nozha/async/server/model/Peer.java:6–124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L6-L124)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/model/Peer.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L7) |
| `version` | `long` | [src/com/nozha/async/server/model/Peer.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L8) |
| `time` | `long` | [src/com/nozha/async/server/model/Peer.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L9) |
| `lastSeen` | `long` | [src/com/nozha/async/server/model/Peer.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L10) |
| `name` | `String` | [src/com/nozha/async/server/model/Peer.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L11) |
| `clientTimeout` | `long` | [src/com/nozha/async/server/model/Peer.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L12) |
| `deviceId` | `String` | [src/com/nozha/async/server/model/Peer.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L13) |
| `appId` | `String` | [src/com/nozha/async/server/model/Peer.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L14) |
| `username` | `String` | [src/com/nozha/async/server/model/Peer.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L15) |
| `password` | `String` | [src/com/nozha/async/server/model/Peer.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L16) |
| `ttl` | `int` | [src/com/nozha/async/server/model/Peer.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L17) |
| `maxMessageCount` | `int` | [src/com/nozha/async/server/model/Peer.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L18) |
| `serverId` | `int` | [src/com/nozha/async/server/model/Peer.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L19) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/Helper.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L130) ` Peer peerEng = new Peer();`; [src/com/nozha/async/server/Server.java:456](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L456) ` Peer peer = RegistrationManager.checkPeer(peerInfoVO);`; [src/com/nozha/async/server/handler/MqttHandler.java:188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L188) ` Peer peer = mqttClient.getPeer();`; [src/com/nozha/async/server/handler/WebsocketHandler.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L60) ` Peer peer = client.getPeer();`; [src/com/nozha/async/server/handler/WebrtcHandler.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L60) ` Peer peer = client.getPeer();`; [src/com/nozha/async/server/handler/TcpHandler.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L130) ` Peer peer = RegistrationManager.checkPeer(peerInfoVO);`; [src/com/nozha/async/server/biz/MessageManager.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L64) ` Peer peer = null;`; [src/com/nozha/async/server/biz/RegistrationManager.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L28) ` public static Peer registerPeerForUser(PeerInfoVO peerInfo) throws Exception {`; [src/com/nozha/async/server/biz/LoadManager.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L48) ` static void validateSendMessage(Client client, Peer receiver) throws TooManyMessagesSentException {`; [src/com/nozha/async/server/httpserver/ClientServlet.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L60) ` Peer peer = PeerCRUD.loadPeerByAppAndDevice(deviceId, appId);`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L203) ` Peer peer = PeerCRUD.loadPeerByName(businessProviderConfig.getProvider());`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L115) ` Peer peer;`; [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L189) ` Peer peer = PeerCRUD.loadPeerByName(endpointConfig.getProvider());`; [src/com/nozha/async/server/persistance/PeerCRUD.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L40) ` public static Peer createPeer(Peer peer) {`; [src/com/nozha/async/server/persistance/PeerCRUDInterface.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L20) ` Peer createPeer(Peer peer);`; [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L11) ` Cache<Long, Peer> peerByIdCache = Caffeine.newBuilder()`; [src/com/nozha/async/server/util/CacheUtil.java:106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L106) ` public static void cachePeer(Peer peer) {`; [src/com/nozha/async/server/util/MemoryCacheCRUD.java:221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L221) ` public void cachePeer(Peer peer) {`; [src/com/nozha/async/server/client/Client.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/Client.java#L29) ` protected Peer peer;`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L160) ` public Peer createPeer(Peer peer) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L21-L23) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L25-L27) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L29-L31) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L33-L35) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L37-L39) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L41-L43) |
| `public long getLastSeen()` | Return stored value/reference: lastSeen. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L45-L47) |
| `public void setLastSeen(long lastSeen)` | Assign this.lastSeen = lastSeen. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L49-L51) |
| `public String getName()` | Return stored value/reference: name. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L53-L55) |
| `public void setName(String name)` | Assign this.name = name. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L57-L59) |
| `public long getClientTimeout()` | Return stored value/reference: clientTimeout. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L61-L63) |
| `public void setClientTimeout(long clientTimeout)` | Assign this.clientTimeout = clientTimeout. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L65-L67) |
| `public String getDeviceId()` | Return stored value/reference: deviceId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L69-L71) |
| `public void setDeviceId(String deviceId)` | Assign this.deviceId = deviceId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L73-L75) |
| `public String getAppId()` | Return stored value/reference: appId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L77-L79) |
| `public void setAppId(String appId)` | Assign this.appId = appId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L81-L83) |
| `public String getUsername()` | Return stored value/reference: username. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L85-L87) |
| `public void setUsername(String username)` | Assign this.username = username. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L89-L91) |
| `public String getPassword()` | Return stored value/reference: password. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L93-L95) |
| `public void setPassword(String password)` | Assign this.password = password. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L97-L99) |
| `public int getTtl()` | Return stored value/reference: ttl. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L101-L103) |
| `public void setTtl(int ttl)` | Assign this.ttl = ttl. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L105-L107) |
| `public int getMaxMessageCount()` | Return stored value/reference: maxMessageCount. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L109-L111) |
| `public void setMaxMessageCount(int maxMessageCount)` | Assign this.maxMessageCount = maxMessageCount. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L113-L115) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:117–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L117-L119) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/Peer.java:121–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/Peer.java#L121-L123) |

## Business
SOURCE_OBSERVED: Peer identity/credential/device/app, TTL/client timeout/message-count/server metadata; stores password String unencrypted in this object, downstream storage handling external.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/Helper.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L130), [src/com/nozha/async/server/Server.java:456](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L456), [src/com/nozha/async/server/handler/MqttHandler.java:188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L188), [src/com/nozha/async/server/handler/WebsocketHandler.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L60), [src/com/nozha/async/server/handler/WebrtcHandler.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L60), [src/com/nozha/async/server/handler/TcpHandler.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L130), [src/com/nozha/async/server/biz/MessageManager.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L64), [src/com/nozha/async/server/biz/RegistrationManager.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L28).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: username, password. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/PeerRegistration.md -->

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
source_path: src/com/nozha/async/server/model/PeerRegistration.java
source_sha256: c243bf5a86e646c6c9c71e75e25f1d18d80be2c275fa13fed5571aed8e9f3cfb
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java
business_approved: false
runtime_tested: false
promoted: false
---

# PeerRegistration — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `PeerRegistration` (class_declaration) [src/com/nozha/async/server/model/PeerRegistration.java:6–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L6-L25)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `ownerPeerId` | `long` | [src/com/nozha/async/server/model/PeerRegistration.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L7) |
| `userPeerId` | `long` | [src/com/nozha/async/server/model/PeerRegistration.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L8) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/RegistrationManager.java:133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L133) ` PeerRegistration pr = new PeerRegistration();`; [src/com/nozha/async/server/persistance/PeerCRUD.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L78) ` public static void registerInPeer(PeerRegistration peerRegistration) {`; [src/com/nozha/async/server/persistance/PeerCRUDInterface.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L32) ` void registerInPeer(PeerRegistration peerRegistration);`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:339](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L339) ` public void registerInPeer(PeerRegistration peerRegistration) {`; [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:387](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L387) ` public void registerInPeer(PeerRegistration peerRegistration) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getOwnerPeerId()` | Return stored value/reference: ownerPeerId. No validation or copying. | [src/com/nozha/async/server/model/PeerRegistration.java:10–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L10-L12) |
| `public void setOwnerPeerId(long ownerPeerId)` | Assign this.ownerPeerId = ownerPeerId. No validation or copying. | [src/com/nozha/async/server/model/PeerRegistration.java:14–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L14-L16) |
| `public long getUserPeerId()` | Return stored value/reference: userPeerId. No validation or copying. | [src/com/nozha/async/server/model/PeerRegistration.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L18-L20) |
| `public void setUserPeerId(long userPeerId)` | Assign this.userPeerId = userPeerId. No validation or copying. | [src/com/nozha/async/server/model/PeerRegistration.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/PeerRegistration.java#L22-L24) |

## Business
SOURCE_OBSERVED: Owner-user peer relationship pair used for membership lookup/persistence.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/RegistrationManager.java:133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L133), [src/com/nozha/async/server/persistance/PeerCRUD.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L78), [src/com/nozha/async/server/persistance/PeerCRUDInterface.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUDInterface.java#L32), [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:339](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L339), [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:387](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L387).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/QueueRegistration.md -->

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
source_path: src/com/nozha/async/server/model/QueueRegistration.java
source_sha256: abc697a730ba09bf60630874de438b84aec544e5e7cdd6645670ab544748eb45
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java
business_approved: false
runtime_tested: false
promoted: false
---

# QueueRegistration — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `QueueRegistration` (class_declaration) [src/com/nozha/async/server/model/QueueRegistration.java:6–156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L6-L156)
Mutable transport registration with protocol constants0 AMQP,1 OpenWire,2 Rabbit,3 Stomp; equality ignores credentials/type/serverId/id/version/time.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `ACTIVE_MQ_AMQP` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L7) |
| `ACTIVE_MQ_OPEN_WIRE` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L8) |
| `RABBIT_MQ_AMQP` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L9) |
| `ACTIVE_MQ_STOMP` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L10) |
| `id` | `long` | [src/com/nozha/async/server/model/QueueRegistration.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L11) |
| `version` | `long` | [src/com/nozha/async/server/model/QueueRegistration.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L12) |
| `time` | `long` | [src/com/nozha/async/server/model/QueueRegistration.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L13) |
| `peerId` | `long` | [src/com/nozha/async/server/model/QueueRegistration.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L14) |
| `serverUrl` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L15) |
| `inputQueueName` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L16) |
| `outputQueueName` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L17) |
| `factoryName` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L18) |
| `username` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L19) |
| `password` | `String` | [src/com/nozha/async/server/model/QueueRegistration.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L20) |
| `type` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L21) |
| `serverId` | `int` | [src/com/nozha/async/server/model/QueueRegistration.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L22) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/Helper.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L138) ` QueueRegistration queueRegistrationEng = new QueueRegistration();`; [src/com/nozha/async/server/handler/QueueHandler.java:75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L75) ` List<QueueRegistration> queueRegistrations = QueueCRUD.listQueueRegistration(lastId);`; [src/com/nozha/async/server/biz/RegistrationManager.java:164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L164) ` QueueHandler.getInstance().register(JsonUtil.getObject(messageWrapperVO.getContent(), QueueRegistration.class));`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:181](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L181) ` QueueRegistration queueRegistration = new QueueRegistration();`; [src/com/nozha/async/server/persistance/QueueCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L11) ` QueueRegistration loadQueueRegistration(QueueRegistration queueRegistration);`; [src/com/nozha/async/server/persistance/QueueCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L24) ` public static QueueRegistration loadQueueRegistration(QueueRegistration queueRegistration) {`; [src/com/nozha/async/server/client/QueueClient.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L20) ` QueueRegistration queueRegistration;`; [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L36) ` public ActiveMQStompQueueClient(QueueRegistration queueRegistration) throws Exception {`; [src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L21) ` private QueueRegistration queueRegistration;`; [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L36) ` public ActiveMQAMQPQueueClient(QueueRegistration queueRegistration) throws Exception {`; [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L37) ` public ActiveMQOpenWireQueueClient(QueueRegistration queueRegistration) throws Exception {`; [src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L49) ` public QueueRegistration loadQueueRegistration(QueueRegistration queueRegistration) {`; [src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L52) ` public QueueRegistration loadQueueRegistration(QueueRegistration queueRegistration) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L24-L26) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L28-L30) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L32-L34) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L36-L38) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L40-L42) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L44-L46) |
| `public long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L48-L50) |
| `public void setPeerId(long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L52-L54) |
| `public String getServerUrl()` | Return stored value/reference: serverUrl. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L56-L58) |
| `public void setServerUrl(String serverUrl)` | Assign this.serverUrl = serverUrl. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L60-L62) |
| `public String getInputQueueName()` | Return stored value/reference: inputQueueName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L64-L66) |
| `public void setInputQueueName(String inputQueueName)` | Assign this.inputQueueName = inputQueueName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:68–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L68-L70) |
| `public String getOutputQueueName()` | Return stored value/reference: outputQueueName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:72–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L72-L74) |
| `public void setOutputQueueName(String outputQueueName)` | Assign this.outputQueueName = outputQueueName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:76–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L76-L78) |
| `public String getFactoryName()` | Return stored value/reference: factoryName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:80–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L80-L82) |
| `public void setFactoryName(String factoryName)` | Assign this.factoryName = factoryName. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:84–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L84-L86) |
| `public String getUsername()` | Return stored value/reference: username. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:88–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L88-L90) |
| `public void setUsername(String username)` | Assign this.username = username. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L92-L94) |
| `public String getPassword()` | Return stored value/reference: password. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:96–98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L96-L98) |
| `public void setPassword(String password)` | Assign this.password = password. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:100–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L100-L102) |
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:104–106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L104-L106) |
| `public void setType(int type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:108–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L108-L110) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:112–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L112-L114) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/QueueRegistration.java:116–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L116-L118) |
| `@Override public boolean equals(Object o)` | Identity true; null/different class false; compare peerId and nullable factory/input/output/serverUrl; ignore credentials/protocol/serverId. | [src/com/nozha/async/server/model/QueueRegistration.java:120–136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L120-L136) |
| `@Override public int hashCode()` | 31-fold hash over same equality fields. | [src/com/nozha/async/server/model/QueueRegistration.java:138–146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L138-L146) |
| `@Override public String toString()` | Render peerId,inputQueueName,outputQueueName only. | [src/com/nozha/async/server/model/QueueRegistration.java:148–155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/QueueRegistration.java#L148-L155) |

## Business
SOURCE_OBSERVED: Indirect queue connection configuration and duplicate identity. Mutating equal/hash fields while in a set/map can break lookups.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; field accessors do not validate protocol, credentials, queue names or endpoint. toString omits password but names remain operationally sensitive.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/Helper.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/Helper.java#L138), [src/com/nozha/async/server/handler/QueueHandler.java:75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L75), [src/com/nozha/async/server/biz/RegistrationManager.java:164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L164), [src/com/nozha/async/server/httpserver/RegisterServlet.java:181](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L181), [src/com/nozha/async/server/persistance/QueueCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUDInterface.java#L11), [src/com/nozha/async/server/persistance/QueueCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/QueueCRUD.java#L24), [src/com/nozha/async/server/client/QueueClient.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L20), [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L36).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: username, password. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/RestRegistration.md -->

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
source_path: src/com/nozha/async/server/model/RestRegistration.java
source_sha256: d795d8d5e965aab2d4fd5cc2bacbdc16f4059954530c3dce15ec90f4ea577561
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java
business_approved: false
runtime_tested: false
promoted: false
---

# RestRegistration — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `RestRegistration` (class_declaration) [src/com/nozha/async/server/model/RestRegistration.java:6–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L6-L89)
Mutable REST registration; equality uses peerId plus nullable baseUrl; hash only peerId (valid but collision-prone).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/model/RestRegistration.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L7) |
| `baseUrl` | `String` | [src/com/nozha/async/server/model/RestRegistration.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L8) |
| `configFileUrl` | `String` | [src/com/nozha/async/server/model/RestRegistration.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L9) |
| `peerId` | `long` | [src/com/nozha/async/server/model/RestRegistration.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L10) |
| `version` | `long` | [src/com/nozha/async/server/model/RestRegistration.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L11) |
| `serverId` | `int` | [src/com/nozha/async/server/model/RestRegistration.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L12) |
| `time` | `long` | [src/com/nozha/async/server/model/RestRegistration.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L13) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/RestHandler.java:534](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L534) ` public void register(RestRegistration restRegistration) {`; [src/com/nozha/async/server/biz/RegistrationManager.java:234](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L234) ` public static void createRestRegistration(RestRegistration restRegistration) throws ServerException {`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L218) ` RestRegistration restRegistration = new RestRegistration();`; [src/com/nozha/async/server/persistance/RestCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L24) ` public static RestRegistration loadRestRegistration(RestRegistration restRegistration) {`; [src/com/nozha/async/server/persistance/RestCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L11) ` RestRegistration loadRestRegistration(RestRegistration restRegistration);`; [src/com/nozha/async/server/client/RestClient.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L40) ` public RestClient(RestRegistration restRegistration) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {`; [src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L53) ` public RestRegistration loadRestRegistration(RestRegistration restRegistration) {`; [src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L43) ` public RestRegistration loadRestRegistration(RestRegistration restRegistration) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:16–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L16-L18) |
| `public void setId(long id)` | Assign this.id = id. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L19-L21) |
| `public String getBaseUrl()` | Return stored value/reference: baseUrl. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L23-L25) |
| `public void setBaseUrl(String baseUrl)` | Assign this.baseUrl = baseUrl. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L26-L28) |
| `public String getConfigFileUrl()` | Return stored value/reference: configFileUrl. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L30-L32) |
| `public void setConfigFileUrl(String configFileUrl)` | Assign this.configFileUrl = configFileUrl. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L33-L35) |
| `public long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L37-L39) |
| `public void setPeerId(long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L40-L42) |
| `public long getVersion()` | Return stored value/reference: version. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L44-L46) |
| `public void setVersion(long version)` | Assign this.version = version. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L47-L49) |
| `public int getServerId()` | Return stored value/reference: serverId. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L51-L53) |
| `public void setServerId(int serverId)` | Assign this.serverId = serverId. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L54-L56) |
| `public long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:58–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L58-L60) |
| `public void setTime(long time)` | Assign this.time = time. No validation or copying. | [src/com/nozha/async/server/model/RestRegistration.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L61-L63) |
| `@Override public boolean equals(Object o)` | Identity true; null/class mismatch false; compare peerId/baseUrl only. | [src/com/nozha/async/server/model/RestRegistration.java:65–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L65-L74) |
| `@Override public int hashCode()` | Hash peerId high/low fold only. | [src/com/nozha/async/server/model/RestRegistration.java:76–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L76-L80) |
| `@Override public String toString()` | Render peerId and baseUrl. | [src/com/nozha/async/server/model/RestRegistration.java:82–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/RestRegistration.java#L82-L88) |

## Business
SOURCE_OBSERVED: Indirect outbound REST endpoint identity/config; configFileUrl/serverId/version are excluded from equality.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; no URL/input validation or network access.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/RestHandler.java:534](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L534), [src/com/nozha/async/server/biz/RegistrationManager.java:234](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L234), [src/com/nozha/async/server/httpserver/RegisterServlet.java:218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L218), [src/com/nozha/async/server/persistance/RestCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L24), [src/com/nozha/async/server/persistance/RestCRUDInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUDInterface.java#L11), [src/com/nozha/async/server/client/RestClient.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L40), [src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L53), [src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L43).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/SdpAnswerResponse.md -->

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
source_path: src/com/nozha/async/server/model/SdpAnswerResponse.java
source_sha256: 4b97bd34578a635c724d941561b035c76ed042a249d88fe03d8cc797d47ceb64
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java
business_approved: false
runtime_tested: false
promoted: false
---

# SdpAnswerResponse — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `SdpAnswerResponse` (class_declaration) [src/com/nozha/async/server/model/SdpAnswerResponse.java:3–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L3-L15)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `clientId` | `Long` | [src/com/nozha/async/server/model/SdpAnswerResponse.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L4) |
| `deviceId` | `String` | [src/com/nozha/async/server/model/SdpAnswerResponse.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L5) |
| `sdpAnswer` | `String` | [src/com/nozha/async/server/model/SdpAnswerResponse.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L6) |
| `subDomain` | `String` | [src/com/nozha/async/server/model/SdpAnswerResponse.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L7) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/WebrtcHandler.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L110) ` SdpAnswerResponse sdpAnswerResponse = new SdpAnswerResponse(webrtcClient.getId(), deviceId, sdpAnswer, subDomain);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public SdpAnswerResponse(Long clientId, String deviceId, String sdpAnswer,String subDomain)` | Constructor forwards/stores supplied values: `this.clientId = clientId; this.deviceId = deviceId; this.sdpAnswer = sdpAnswer; this.subDomain = subDomain;`. References retained; no validation. | [src/com/nozha/async/server/model/SdpAnswerResponse.java:9–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpAnswerResponse.java#L9-L14) |

## Business
SOURCE_OBSERVED: WebRTC answer response fields clientId/deviceId/sdpAnswer/subDomain.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/WebrtcHandler.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L110).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/SdpOffer.md -->

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
source_path: src/com/nozha/async/server/model/SdpOffer.java
source_sha256: b1991de992c319b281072b7ef322899bc1a3aefed81ac7188e2d608c00d5e9fe
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpOffer.java
business_approved: false
runtime_tested: false
promoted: false
---

# SdpOffer — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `SdpOffer` (class_declaration) [src/com/nozha/async/server/model/SdpOffer.java:3–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpOffer.java#L3-L13)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `offer` | `String` | [src/com/nozha/async/server/model/SdpOffer.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpOffer.java#L4) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L41) ` SdpOffer sdpOffer = JsonUtil.getObject(body, SdpOffer.class);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public String getOffer()` | Return stored value/reference: offer. No validation or copying. | [src/com/nozha/async/server/model/SdpOffer.java:6–8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpOffer.java#L6-L8) |
| `public void setOffer(String offer)` | Assign this.offer = offer. No validation or copying. | [src/com/nozha/async/server/model/SdpOffer.java:10–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/SdpOffer.java#L10-L12) |

## Business
SOURCE_OBSERVED: WebRTC SDP offer request payload.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L41).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/ServiceCallConfig.md -->

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
source_path: src/com/nozha/async/server/model/ServiceCallConfig.java
source_sha256: a8f85b7340def2219f7e90fec6315991479e16cc5bb3b30f24cc5f9f19699970
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# ServiceCallConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `ServiceCallConfig` (class_declaration) [src/com/nozha/async/server/model/ServiceCallConfig.java:3–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L3-L49)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `productId` | `Long` | [src/com/nozha/async/server/model/ServiceCallConfig.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L4) |
| `peerName` | `String` | [src/com/nozha/async/server/model/ServiceCallConfig.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L5) |
| `businessId` | `Long` | [src/com/nozha/async/server/model/ServiceCallConfig.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L6) |
| `key` | `String` | [src/com/nozha/async/server/model/ServiceCallConfig.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L7) |
| `type` | `String` | [src/com/nozha/async/server/model/ServiceCallConfig.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L8) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/ServiceCallService.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L29) ` public static void updateServiceCallDispatcherMap(ServiceCallConfig serviceCallConfig) {`; [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L83) ` ServiceCallConfig serviceCallConfig = JsonUtil.getObject(body, ServiceCallConfig.class);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public Long getProductId()` | Return stored value/reference: productId. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:10–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L10-L12) |
| `public void setProductId(Long productId)` | Assign this.productId = productId. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:14–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L14-L16) |
| `public String getPeerName()` | Return stored value/reference: peerName. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L18-L20) |
| `public void setPeerName(String peerName)` | Assign this.peerName = peerName. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L22-L24) |
| `public Long getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L26-L28) |
| `public void setBusinessId(Long businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L30-L32) |
| `public String getKey()` | Return stored value/reference: key. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:34–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L34-L36) |
| `public void setKey(String key)` | Assign this.key = key. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:38–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L38-L40) |
| `public String getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L42-L44) |
| `public void setType(String type)` | Assign this.type = type. No validation or copying. | [src/com/nozha/async/server/model/ServiceCallConfig.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/ServiceCallConfig.java#L46-L48) |

## Business
SOURCE_OBSERVED: Service-call routing/blocking configuration key/product/business/peer/type data; decisions are in ServiceCallService.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/ServiceCallService.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/ServiceCallService.java#L29), [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L83).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/model/TurnAddresses.md -->

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
source_path: src/com/nozha/async/server/model/TurnAddresses.java
source_sha256: 56b442aff3b9213476d78cf582d30fdebd1bd149156296767bb415004f996f4c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java
business_approved: false
runtime_tested: false
promoted: false
---

# TurnAddresses — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.model`. Types: `TurnAddresses` (class_declaration) [src/com/nozha/async/server/model/TurnAddresses.java:9–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L9-L49)
Construct equal-index external/internal TURN lists from comma inputs; synchronized getters rotate both lists, not random selection.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Synchronization covers getters; constructor pairs by external length, ignores extra internal entries.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `turnAddresses` | `ArrayList<String>` | [src/com/nozha/async/server/model/TurnAddresses.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L11) |
| `internalTurnAddresses` | `ArrayList<String>` | [src/com/nozha/async/server/model/TurnAddresses.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L12) |
| `logger` | `Logger` | [src/com/nozha/async/server/model/TurnAddresses.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L13) |
Dependencies are imports (some may be unused): `org.json.JSONObject` [src/com/nozha/async/server/model/TurnAddresses.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L3); `org.slf4j.Logger` [src/com/nozha/async/server/model/TurnAddresses.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L4); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/model/TurnAddresses.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L5); `java.util.ArrayList` [src/com/nozha/async/server/model/TurnAddresses.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L7)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/Settings.java:403](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L403) ` public static TurnAddresses TURN_ADDRESSES;`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public TurnAddresses(String turnAddress, String internalTurnAddress)` | Split two inputs; iterate external length copying paired index to both lists; INFO addresses. | [src/com/nozha/async/server/model/TurnAddresses.java:15–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L15-L26) |
| `public synchronized String getRandomInternalTurnAddresses()` | Synchronized rotate then internal first. | [src/com/nozha/async/server/model/TurnAddresses.java:28–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L28-L31) |
| `public synchronized String getRandomTurnAddresses()` | Synchronized rotate then external first. | [src/com/nozha/async/server/model/TurnAddresses.java:33–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L33-L36) |
| `public synchronized String getAllTurnAddresses()` | Synchronized rotate, JSON turns array external addresses only. | [src/com/nozha/async/server/model/TurnAddresses.java:38–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L38-L43) |
| `private void rotateTurnAddresses()` | Move last item to front in each list. | [src/com/nozha/async/server/model/TurnAddresses.java:45–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L45-L48) |

## Business
SOURCE_OBSERVED: Indirect WebRTC relay balancing; every getter rotates both sides and returns first/full ordered list; separate internal/external requests can advance pairing.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Null input NPE; internal shorter list constructor array bounds; getters rotate/remove potentially empty list; exceptions propagate. Constructor INFO full relay addresses.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `TurnAddresses` | `("Turn Address set address: {}, internalAddress: {}", this.turnAddresses, this.internalTurnAddresses)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-AC5C4E66F006 | [src/com/nozha/async/server/model/TurnAddresses.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/model/TurnAddresses.java#L25) |
Registry reconciliation: 1 active calls, 1 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: turnAddresses, internalTurnAddresses. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/mosquette/EmbeddedMQTTServer.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mosquette/EmbeddedMQTTServer.java#L1-L168
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# EmbeddedMQTTServer — source review

## Technical

Package: `NONE (comment-only compilation unit)`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **COMMENT_ONLY; no executable class declaration**. Full compilation unit reviewed: 168 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

All implementation is block comments ([1–168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mosquette/EmbeddedMQTTServer.java#L1-L168)); no compiled class. Historical PublisherListener forwards publish and connection-lost closure, other hooks delegate. start configures port/host/anonymous auth/TLS stores/persistent H2/autosave and broker interceptor; stop broker; isSubscribed topic match; closeClient broker.close. Nested historical will handling and session cleanup additionally commented.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- No live lexical external reference found in supplied Java files.

## Business

SOURCE_OBSERVED: Historical Moquette integration; current source startup uses Artemis. No live product feature from this file.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No executable direct error path; historical IOException and InterruptedException catch/throws are disabled.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS (executable). Historical warn/info may appear in registry and must be excluded from runtime inventory.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/mosquette/MyIAuthenticator.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mosquette/MyIAuthenticator.java#L1-L27
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MyIAuthenticator — source review

## Technical

Package: `NONE (comment-only compilation unit)`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **COMMENT_ONLY; no executable class declaration**. Full compilation unit reviewed: 27 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Entire apparent class commented ([1–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mosquette/MyIAuthenticator.java#L1-L27)). Historical checkValid ([12–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mosquette/MyIAuthenticator.java#L12-L25)) ultimately returns true; token validation branch itself disabled within comment.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- No live lexical external reference found in supplied Java files.

## Business

SOURCE_OBSERVED: Historical dependency only; cannot claim runtime token authentication or permissive broker authentication from this disabled file (active SecurityManager separately).

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No executable direct error path; historical ServerException catch disabled.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS (executable); historical warn is not live.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/persistance/AccessibilityCrud.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/AccessibilityCrud.java:1-29"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/AccessibilityCrud.java:1-29"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java"
---

# AccessibilityCrud

## Technical

Source-reviewed candidate, based on the complete archived file [AccessibilityCrud.java:L1–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L1-L29). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([AccessibilityCrud.java:L14–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L14-L24)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `loadAccessibility()`: Returns the result of `accessibilityCrudInterface.loadAccessibility()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLAccessibilityCRUD dossier](impl/MySQLAccessibilityCRUD.md), [OracleAccessibilityCRUD dossier](impl/OracleAccessibilityCRUD.md). [facade:L22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L22-L24)
- `loadBusinessAccessibility()`: Returns the result of `accessibilityCrudInterface.loadBusinessAccessibility()`. No local SQL, transaction management, validation or catch occurs in this method. Downstream semantics: [MySQLAccessibilityCRUD dossier](impl/MySQLAccessibilityCRUD.md), [OracleAccessibilityCRUD dossier](impl/OracleAccessibilityCRUD.md). [facade:L26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L26-L28)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/biz/AccessibilityService.java: [AccessibilityService.java:L30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L30), [AccessibilityService.java:L31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L31).

## Business

SOURCE_OBSERVED: supplies access values/enable markers for peer and business access loading; it does not itself authorize a request. SQL precedence can broaden returned candidate config. Triggering actors are config consumers through AccessibilityCrud, not a standalone end-user action.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Source-observed risks/findings (not production incidents):

- Unsupported DB vendor leaves static implementation null; first delegated operation fails with NullPointerException.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. No active SLF4J call exists; comments are excluded. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/AccessibilityCrudInterface.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java:1-12"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java:1-12"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java"
---

# AccessibilityCrudInterface

## Technical

Source-reviewed candidate, based on the complete archived file [AccessibilityCrudInterface.java:L1–12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java#L1-L12). Package `com.nozha.async.server.persistance`. This interface is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

This contract declares method signatures only: no SQL, state mutation, validation or default implementation occurs here. Values and effects below describe the operations whose actual behavior is established in vendor implementation dossiers, not guarantees enforced by this interface.

Method and branch review:

- `loadAccessibility()`: Declares return type `List<AccessDTO>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L9–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java#L9-L9)
- `loadBusinessAccessibility()`: Declares return type `List<AccessDTO>` and inputs shown in the signature. No checked exception is declared. No executable body, SQL, validation, retry, state mutation, fallback or status mapping exists in this declaration. [contract:L11–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java#L11-L11)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java: [MySQLAccessibilityCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L17).
- src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java: [OracleAccessibilityCRUD.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java#L17).

Consumer boundary: [AccessibilityCrud.java:L1–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L1-L29). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supplies access values/enable markers for peer and business access loading; it does not itself authorize a request. SQL precedence can broaden returned candidate config. Triggering actors are config consumers through AccessibilityCrud, not a standalone end-user action.

SOURCE_OBSERVED indirect role: decouples the façade and selected DB adapter; declarations alone enforce neither successful persistence nor nonnull return.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

No direct error path in class: no explicit throw/catch. Delegated/implicit failures are not converted to HTTP status here; follow the consumer boundary above. Unsupported-vendor/null dependencies and argument failures remain possible in concrete callers.


Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

**NO_LOG_IN_CLASS**. Interface declares no logger or audit operations. Observe implementation logs and the exact callers listed above; lack of a local log does not prove a successful operation.


Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.


---

<!-- source dossier: src/com/nozha/async/server/persistance/ClientCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ClientCRUD.java:1-162"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/ClientCRUD.java:1-162"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java"
---

# ClientCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [ClientCRUD.java:L1–162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L1-L162). Package `com.nozha.async.server.persistance`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Class initialization selects a single vendor implementation from Settings.DB_VENDOR ([ClientCRUD.java:L27–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L27-L37)); its static reference is retained thereafter. Unsupported vendors leave it null. Delegating calls preserve implementation return/failure behavior; server-scoped operations inject Settings.SERVER_ID where present.

Method and branch review:

- `addClient(Client client)`: Tracker-bearing clients only emit INFO for each tracker: DB/cache writes in this branch are commented out. Nontracker branch inserts peer/0/server then populates DB mapping cache; inner Exception catch synthesizes a local-server cache mapping, possibly hiding durable write failure. Outer Exception is DEBUG-suppressed. [ClientCRUD.java:L35–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L35-L68)
- `removeClient(Client client)`: For nonnull peer, warns before/after DB removal then invalidates client mapping, server-index and last-seen caches. Broad exception is logged ERROR and suppressed; later invalidations can be skipped. [ClientCRUD.java:L70–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L70-L86)
- `refreshClient(Client client)`: For nonnull peer, invalidates mapping/index caches, removes other server mappings, and caches singleton current server. Broad failure warns and is suppressed. [ClientCRUD.java:L88–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L88-L102)
- `removePeerClientMapping(long peerId)`: Invalidates peer mapping/index/last-seen caches before removing all DB mappings; no catch, so failure can leave cache invalidated. [ClientCRUD.java:L104–109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L104-L109)
- `findReceiverServer(Message message)`: For nonzero receiver consults cache then DB and caches nonempty results. One server wins; none returns -1 and INFO; multiple prefer local server only with USE_INTERNAL_MESSAGE_SENDER, otherwise SplittableRandom choice. Receiver zero with tracker uses MessageUtil.extractServerId. Exception warns and returns -1. [ClientCRUD.java:L111–145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L111-L145)
- `resetMapping()`: Removes this server DB mappings then resets cache. Exception warns and suppresses; cache cleanup may not execute after DB failure. [ClientCRUD.java:L154–161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L154-L161)

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/Server.java: [Server.java:L118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L118), [Server.java:L253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L253), [Server.java:L280](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L280), [Server.java:L287](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L287), [Server.java:L303](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L303), [Server.java:L478](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L478), [Server.java:L534](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L534), [Server.java:L1365](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1365).
- src/com/nozha/async/server/biz/MessageManager.java: [MessageManager.java:L237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L237).
- src/com/nozha/async/server/biz/RegistrationManager.java: [RegistrationManager.java:L84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L84).
- src/com/nozha/async/server/persistance/MessageCRUD.java: [MessageCRUD.java:L47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L47), [MessageCRUD.java:L74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L74).

## Business

SOURCE_OBSERVED: records and resolves which server currently hosts a peer/tracker, supporting local/interserver message routing. Removing stale mappings changes candidate destinations; cache fallback can preserve apparent availability without a durable mapping. No proof of exactly-once delivery follows.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (Exception e)` in `addClient`: Suppresses exception and falls back to current-server cache mapping; DB success is not implied. [ClientCRUD.java:L52–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L52-L62)
- `catch (Exception e)` in `addClient`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ClientCRUD.java:L65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L65-L67)
- `catch (Exception e)` in `removeClient`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ClientCRUD.java:L82–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L82-L85)
- `catch (Exception e)` in `refreshClient`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ClientCRUD.java:L98–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L98-L101)
- `catch (Exception e)` in `findReceiverServer`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ClientCRUD.java:L141–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L141-L143)
- `catch (Exception e)` in `resetMapping`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [ClientCRUD.java:L158–160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L158-L160)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [ClientCRUD.java:L44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L44) **INFO**, registry `ALOG-5748FB2EB38B`; `logger.info("put client mapping for peerId={} ,address={} ,trackerId={} ,serverId={} ", peerId, client.getAddress(), trackerId, Settings.SERVER_ID)`. Trigger/RCA: Tracker-bearing client mapping loop; actual mapping writes there are commented out.
- [ClientCRUD.java:L66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L66) **DEBUG**, registry `ALOG-FFFA87DE73C7`; `logger.debug("An exception occurred in add client for clientId=" + client.getId(), e)`. Trigger/RCA: Caught exception in addClient; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [ClientCRUD.java:L74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L74) **WARN**, registry `ALOG-94BF9D606B97`; `logger.warn("Remove Client call in client crud with peerid=" + peerId + " serverid=" + Settings.SERVER_ID)`. Trigger/RCA: Non-null peer removal phase; before/after DB/cache boundaries differ.
- [ClientCRUD.java:L76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L76) **WARN**, registry `ALOG-148E8E5C3047`; `logger.warn("Client Remove in client map with peerid=" + peerId + " serverid=" + Settings.SERVER_ID)`. Trigger/RCA: Non-null peer removal phase; before/after DB/cache boundaries differ.
- [ClientCRUD.java:L80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L80) **WARN**, registry `ALOG-06529A9F2665`; `logger.warn("Client Remove in Cache with peerid=" + peerId + " serverid=" + Settings.SERVER_ID)`. Trigger/RCA: Non-null peer removal phase; before/after DB/cache boundaries differ.
- [ClientCRUD.java:L83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L83) **ERROR**, registry `ALOG-DDADC93E3B05`; `logger.error("An exception occurred in remove client for peerId={}", client.getPeer() != null ? client.getPeer().getId() : "", e)`. Trigger/RCA: Caught exception in removeClient; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [ClientCRUD.java:L99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L99) **WARN**, registry `ALOG-4EDBCAB1C4A4`; `logger.warn("An exception occurred in refresh client for peerId={}", client.getPeer() != null ? client.getPeer().getId() : "", e)`. Trigger/RCA: Caught exception in refreshClient; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [ClientCRUD.java:L119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L119) **INFO**, registry `ALOG-55E3153D4851`; `logger.info("severId find from database for receiverId={} ,serverIds={}", receiverPeerId, serverIds)`. Trigger/RCA: Cache miss/DB resolution or zero destination list, according to template.
- [ClientCRUD.java:L128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L128) **INFO**, registry `ALOG-41DE82B9007C`; `logger.info("cannot find server for msg: trackerId={} , messageId={} , receiverId={}", message.getTrackerId(), message.getId(), receiverPeerId)`. Trigger/RCA: Cache miss/DB resolution or zero destination list, according to template.
- [ClientCRUD.java:L142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L142) **WARN**, registry `ALOG-C27990B3A39D`; `logger.warn("An exception occurred in findReceiverServer trackerId={} , messageId={}", message.getTrackerId(), message.getId(), e)`. Trigger/RCA: Caught exception in findReceiverServer; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [ClientCRUD.java:L159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L159) **WARN**, registry `ALOG-965A0B0B5A3F`; `logger.warn("An exception occurred in client crud reset mapping serverId={}", Settings.SERVER_ID, e)`. Trigger/RCA: Caught exception in resetMapping; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 11 active source calls, 11 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.
