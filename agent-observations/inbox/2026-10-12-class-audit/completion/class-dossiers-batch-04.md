# Async Java class dossiers — candidate batch 4


---

<!-- source dossier: src/com/nozha/async/server/coapserver/CoapMessageDeliver.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L1-L116
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapMessageDeliver — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 116 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor stores root. deliverRequest ([34–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L34-L54)) resolves resource, applies observe, schedules on resource executor or invokes directly; absent resource NOT_FOUND. checkForObserveOption ([56–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L56-L75)) GET observable observe0 creates endpoint/relation, observe1 cancels token relation. findResource ([80–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L80-L95)) GET+observe obtains registered resource through CoapHandler, otherwise first segment provision routes provision child, else / child. deliverResponse ([97–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L97-L111)) validates response/exchange/request, preDeliverResponse false by default then sets response.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L30): `public CoapMessageDeliver(Resource root) {`
- [34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L34): `public void deliverRequest(final Exchange exchange) {`
- [43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L43): `public void run() {`
- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L56): `private void checkForObserveOption(Exchange exchange, Resource resource) {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L80): `private Resource findResource(Exchange exchange) {`
- [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L97): `public final void deliverResponse(Exchange exchange, Response response) {`
- [113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L113): `protected boolean preDeliverResponse(Exchange exchange, Response response) {`

Source dependency imports: `com.nozha.async.server.handler.CoapHandler`, `org.eclipse.californium.core.coap.CoAP`, `org.eclipse.californium.core.coap.Request`, `org.eclipse.californium.core.coap.Response`, `org.eclipse.californium.core.network.Exchange`, `org.eclipse.californium.core.observe.ObserveManager`, `org.eclipse.californium.core.observe.ObserveRelation`, `org.eclipse.californium.core.observe.ObservingEndpoint`, `org.eclipse.californium.core.server.MessageDeliverer`, `org.eclipse.californium.core.server.resources.Resource`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.net.InetSocketAddress`, `java.net.URI`, `java.net.URISyntaxException`, `java.util.List`, `java.util.concurrent.Executor`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L30): `CoapMessageDeliver coapMessageDeliver;`
- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L65): `coapMessageDeliver = new CoapMessageDeliver(server.getRoot());`

## Business

SOURCE_OBSERVED: Routes CoAP provision and device observations; second subscription may fail because handler returns null for existing client.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit NPE messages Response/Exchange must not be null; IllegalArgumentException("Exchange does not contain request"). Empty URI segment indexing uncaught. No request-side catch; NOT_FOUND is normal response. Test observe register/cancel and empty path.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L99): `throw new NullPointerException("Response must not be null");`
- [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L101): `throw new NullPointerException("Exchange must not be null");`
- [103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L103): `throw new IllegalArgumentException("Exchange does not contain request");`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Observe INFO means relation constructed, not data delivered; remote IP:port/resource URI expose addressing.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L62) | ALOG-55D8BAC6C65E | INFO | `LOGGER.info("Initiate an observe relation between " + request.getSourceContext().getPeerAddress().getAddress() + ":" + request.getSourceContext().getPeerAddress().getPort() + " and resource " + resource.getURI());` | `if (request.getCode() == CoAP.Code.GET) { / InetSocketAddress source = new InetSocketAddress(request.getSourceContext().getPeerAddress().getAddress(), request.getSourceContext().getPeerAddress().getPort()); / if (request.getOptions().hasObserve() && resource.isObservable()) { / if (request.getOptions().getObserve() == 0) {` |

Registry reconciliation: 1 rows for this file; 1 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/CoapResourceBase.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L1-L200
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapResourceBase — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 200 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor enables observable. POST/GET/PUT/DELETE ([23–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L23-L86)) each receives through CoapHandler, polls response, deserializes ClientMessage.content to CoapGenericResponse and responds mapped body/code. addObserver synchronized calls super then changed; observe relation add/remove just super. sleepForResponse ([104–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L104-L114)) loops plain wait flag every200ms while timeWait<=COAP_SYNC_REQUEST_TIMEOUT and swallows interruption/errors. getCodeResponse ([116–198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L116-L198)) explicitly maps named success/client/server CoAP codes including TOO_MANY_REQUESTS, defaults _UNKNOWN_SUCCESS_CODE.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L18): `public CoapResourceBase(String name) {`
- [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L23): `public void handlePOST(CoapExchange exchange) {`
- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L40): `public void handleGET(CoapExchange exchange) {`
- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L56): `public void handlePUT(CoapExchange exchange) {`
- [72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L72): `public void handleDELETE(CoapExchange exchange) {`
- [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L89): `public synchronized void addObserver(ResourceObserver observer) {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L94): `public void addObserveRelation(ObserveRelation relation) {`
- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L99): `public void removeObserveRelation(ObserveRelation relation) {`
- [104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L104): `private void sleepForResponse(CoapClient coapClient){`
- [116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L116): `private CoAP.ResponseCode getCodeResponse(String value){`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.client.CoapClient`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.handler.CoapHandler`, `com.nozha.async.server.util.JsonUtil`, `org.eclipse.californium.core.CoapResource`, `org.eclipse.californium.core.coap.CoAP`, `org.eclipse.californium.core.observe.ObserveRelation`, `org.eclipse.californium.core.server.resources.CoapExchange`, `org.eclipse.californium.core.server.resources.ResourceObserver`.
Configuration references: `COAP_SYNC_REQUEST_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L31): `CoapResourceBase coapResourceBase;`
- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L66): `coapResourceBase = new CoapResourceBase("/");`

## Business

SOURCE_OBSERVED: Adapts CoAP device requests into Async/provider reply envelopes; blocking polling consumes request execution capacity. Default unknown status is success-like, not validated business success.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

All four methods catch Exception: ClientException→NOT_FOUND with METHOD_REQUEST_REJECT - message; otherwise GATEWAY_TIMEOUT with same text. Poll expiry itself does not throw; missing reply causes later NPE mapped timeout. Interrupted wait suppressed. Test no reply, malformed envelope/status and late reply.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L29): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L30): `} catch (Exception e) {`
- [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L32): `exchange.respond(CoAP.ResponseCode.NOT_FOUND, "POST_REQUEST_REJECT - " + e.getMessage());`
- [34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L34): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT, "POST_REQUEST_REJECT - " + e.getMessage());`
- [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L46): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L47): `} catch (Exception e) {`
- [49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L49): `exchange.respond(CoAP.ResponseCode.NOT_FOUND, "GET_REQUEST_REJECT - " + e.getMessage());`
- [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L51): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT, "GET_REQUEST_REJECT - " + e.getMessage());`
- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L62): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L63): `} catch (Exception e) {`
- [65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L65): `exchange.respond(CoAP.ResponseCode.NOT_FOUND, "PUT_REQUEST_REJECT - " + e.getMessage());`
- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L67): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT, "PUT_REQUEST_REJECT - " + e.getMessage());`
- [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L78): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L79): `} catch (Exception e) {`
- [81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L81): `exchange.respond(CoAP.ResponseCode.NOT_FOUND, "DELETE_REQUEST_REJECT - " + e.getMessage());`
- [83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L83): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT, "DELETE_REQUEST_REJECT - " + e.getMessage());`
- [111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L111): `}catch (Exception e){`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; CoapHandler registration errors printStackTrace; rejection response is direct evidence.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/CoapResourceClient.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L1-L77
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapResourceClient — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 77 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([18–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L18-L34)) observable message ping and starts unbounded thread sleeping2s/changed. sendMessage sets mutable message then changed(null). POST ([44–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L44-L51)) calls handler receive, responds reject on catch then unconditionally success too. GET sends current message then resets ping. add relation super; remove relation ([64–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L64-L68)) super→disconnect callback→deprecated Thread.stop. Direct message accessors.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L18): `public CoapResourceClient(String name, ReActionClientCoap actionClientCoap) {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L37): `public void sendMessage(String message) throws ServerException {`
- [44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L44): `public void handlePOST(CoapExchange exchange) {`
- [53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L53): `public void handleGET(CoapExchange exchange) {`
- [59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L59): `public void addObserveRelation(ObserveRelation relation) {`
- [64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L64): `public void removeObserveRelation(ObserveRelation relation) {`
- [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L70): `public String getMessage() {`
- [74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L74): `public void setMessage(String message) {`

Source dependency imports: `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.handler.CoapHandler`, `org.eclipse.californium.core.CoapResource`, `org.eclipse.californium.core.observe.ObserveRelation`, `org.eclipse.californium.core.server.resources.CoapExchange`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/client/CoapClient.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L24): `private CoapResourceClient coapResourceClient;`
- [src/com/nozha/async/server/client/CoapClient.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L45): `coapResourceClient = new CoapResourceClient(clientId, new ReActionClientCoap() {`
- [src/com/nozha/async/server/client/CoapClient.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L110): `public CoapResourceClient getCoapResourceClient() {`

## Business

SOURCE_OBSERVED: Observable device outbound message slot with periodic ping; slot overwrite/reset can discard concurrent messages, no durable queue here.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

POST Exception swallowed but two responses attempted. Thread sleep/changed exceptions print stack and retry forever. remove callback failure prevents stop. No explicit live ServerException throw (40 commented). Reproduce send/GET race and POST rejection.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L28): `} catch (Exception e) {`
- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L47): `} catch (Exception e) {`
- [48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L48): `exchange.respond("POST_REQUEST_REJECT");`
- [50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L50): `exchange.respond("POST_REQUEST_SUCCESS");`
- [54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L54): `exchange.respond(message);`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS for logger calls, but heartbeat exceptions emit printStackTrace directly.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L29): `e.printStackTrace();`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/CoapResourceProvision.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L1-L179
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapResourceProvision — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 179 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor enables observable. POST/GET/PUT ([22–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L22-L55)) each invokes receiveProvision, polls, deserializes generic reply and responds code/body. DELETE ([57–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L57-L64)) always GATEWAY_TIMEOUT DELETE_REQUEST_REJECT even catch. addObserver synchronized changed and relation methods delegate. sleepForResponse ([82–92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L82-L92)) 200ms loop with <=COAP_PROVISION_TIMEOUT and suppressed exceptions. getCodeResponse ([93–175](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L93-L175)) string mapping of CoAP response enums default unknown-success.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L17): `public CoapResourceProvision(String name) {`
- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L22): `public void handlePOST(CoapExchange exchange) {`
- [34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L34): `public void handleGET(CoapExchange exchange) {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L45): `public void handlePUT(CoapExchange exchange) {`
- [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L57): `public void handleDELETE(CoapExchange exchange) {`
- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L67): `public synchronized void addObserver(ResourceObserver observer) {`
- [72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L72): `public void addObserveRelation(ObserveRelation relation) {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L77): `public void removeObserveRelation(ObserveRelation relation) {`
- [82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L82): `private void sleepForResponse(CoapClient coapClient){`
- [93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L93): `private CoAP.ResponseCode getCodeResponse(String value){`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.client.CoapClient`, `com.nozha.async.server.handler.CoapHandler`, `com.nozha.async.server.util.JsonUtil`, `org.eclipse.californium.core.CoapResource`, `org.eclipse.californium.core.coap.CoAP`, `org.eclipse.californium.core.observe.ObserveRelation`, `org.eclipse.californium.core.server.resources.CoapExchange`, `org.eclipse.californium.core.server.resources.ResourceObserver`.
Configuration references: `COAP_PROVISION_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L32): `CoapResourceProvision coapResourceProvision;`
- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L67): `coapResourceProvision = new CoapResourceProvision("provision");`

## Business

SOURCE_OBSERVED: Unregistered/provisioning request bridge constrained by destination provision counters in handler; DELETE unsupported via timeout-shaped rejection.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

All method errors become GATEWAY_TIMEOUT exposing e.getMessage; no explicit timeout throw, missing reply dereference creates caught failure. Sleep exceptions suppressed. Test overload and provider no-reply.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L27): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L28): `} catch (Exception e) {`
- [29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L29): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT,e.getMessage());`
- [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L39): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L40): `} catch (Exception e) {`
- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L41): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT,e.getMessage());`
- [50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L50): `exchange.respond(getCodeResponse(response.getStatusCode()),response.getBody());`
- [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L51): `} catch (Exception e) {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L52): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT,e.getMessage());`
- [59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L59): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT,"DELETE_REQUEST_REJECT");`
- [60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L60): `} catch (Exception e) {`
- [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L61): `exchange.respond(CoAP.ResponseCode.GATEWAY_TIMEOUT,"DELETE_REQUEST_REJECT");`
- [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L89): `}catch (Exception e){`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; response itself shows failure; receiver handler has printStackTrace only.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/CredentialsUtil.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L1-L360
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CredentialsUtil — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Bosch-derived utility with Async settings (copyright header). Compilation status: **active source declaration**. Full compilation unit reviewed: 360 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Bosch-derived DTLS utility retains vendor license ([1–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L1-L15)) but Async package/settings. Mode enum/default lists ([48–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L48-L115)) PSK/ECDHE_PSK/RPK/X509 and auth/trust options, demo PSK constants and settings stores. getOptCid recognizes CID: only. setupCid ([143–166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L143-L166)) parses length, negative/nonnumber→default6, sets SingleNodeConnectionIdGenerator and console messages. parse ([180–212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L180-L212)) ignores CID, maps exact enum, checks supported list, injects defaults when empty or sole NO_AUTH/WANT_AUTH. setupCredentials ([250–359](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L250-L359)) installs demo keys if PSK store absent; rejects NO_AUTH with trust-only modes; configures NONE/WANTED client-auth, loads keys/certs, orders RAW_PUBLIC_KEY/X509 by list order, trusts all RPKs; certificate load failure allows PSK-only fallback or throws. Trust-only modes trust all certs/RPKs. Builds verifier when trusts present. Computes cipher suites but final setter is commented.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L125): `private static String getOptCid(String arg) {`
- [143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L143): `public static void setupCid(String[] args, DtlsConnectorConfig.Builder builder) {`
- [180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L180): `public static List<Mode> parse(String[] args, List<Mode> defaults, List<Mode> supported) {`
- [250](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L250): `public static void setupCredentials(DtlsConnectorConfig.Builder config, String certificateAlias, List<Mode> modes) {`

Source dependency imports: `com.nozha.Settings`, `org.eclipse.californium.elements.config.CertificateAuthenticationMode`, `org.eclipse.californium.elements.util.SslContextUtil`, `org.eclipse.californium.scandium.config.DtlsConfig`, `org.eclipse.californium.scandium.config.DtlsConnectorConfig`, `org.eclipse.californium.scandium.dtls.CertificateType`, `org.eclipse.californium.scandium.dtls.SingleNodeConnectionIdGenerator`, `org.eclipse.californium.scandium.dtls.cipher.CipherSuite`, `org.eclipse.californium.scandium.dtls.cipher.CipherSuite.KeyExchangeAlgorithm`, `org.eclipse.californium.scandium.dtls.pskstore.AdvancedMultiPskStore`, `org.eclipse.californium.scandium.dtls.x509.SingleCertificateProvider`, `org.eclipse.californium.scandium.dtls.x509.StaticNewAdvancedCertificateVerifier`, `org.eclipse.californium.scandium.dtls.x509.StaticNewAdvancedCertificateVerifier.Builder`, `java.io.IOException`, `java.security.GeneralSecurityException`, `java.security.cert.Certificate`, `java.util.ArrayList`, `java.util.Arrays`, `java.util.List`.
Configuration references: `COAP_KEY_STORE_LOCATION`, `COAP_KEY_STORE_PASSWORD`, `COAP_TRUST_STORE_LOCATION`, `COAP_TRUST_STORE_PASSWORD`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L76): `CredentialsUtil.setupCid(args, builder);`
- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L77): `List<Mode> modes = CredentialsUtil.parse(args, CredentialsUtil.DEFAULT_SERVER_MODES, SUPPORTED_MODES);`
- [src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L78): `CredentialsUtil.setupCredentials(builder, CredentialsUtil.SERVER_NAME, modes);`

## Business

SOURCE_OBSERVED: Integration dependency for CoAP DTLS startup; demo identity/key acceptance and trust-all modes are code configuration possibilities, not approved security posture. EmbeddedCoapServer defaults enable PSK/RPK/X509.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit IllegalArgumentException for unknown argument, unsupported mode, incompatible no-auth and certificate failures without PSK. Negative/noninteger CID recovered; GeneralSecurityException/IOException print stack and allow PSK if present. Settings null passwords can fail static init. Test missing keystore with/without PSK.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L155): `} catch (NumberFormatException e) {`
- [192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L192): `} catch (IllegalArgumentException ex) {`
- [193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L193): `throw new IllegalArgumentException("Argument '" + mode + "' unkown!");`
- [200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L200): `throw new IllegalArgumentException("Mode '" + mode + "' not supported!");`
- [271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L271): `throw new IllegalArgumentException(Mode.NO_AUTH + " doesn't support " + Mode.X509_TRUST);`
- [274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L274): `throw new IllegalArgumentException(Mode.NO_AUTH + " doesn't support " + Mode.RPK_TRUST);`
- [317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L317): `} catch (GeneralSecurityException e) {`
- [323](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L323): `throw new IllegalArgumentException(e.getMessage());`
- [325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L325): `} catch (IOException e) {`
- [331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L331): `throw new IllegalArgumentException(e.getMessage());`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS logger; System.err/out and printStackTrace are live diagnostics. Exact messages enumerated in error/console inventory below.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L152): `System.err.println("'" + value + "' is negative! Use cid-lenght default " + DEFAULT_CID_LENGTH);`
- [156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L156): `System.err.println("'" + value + "' is no number! Use cid-lenght default " + DEFAULT_CID_LENGTH);`
- [160](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L160): `System.out.println("Enable cid support");`
- [162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L162): `System.out.println("Use " + cidLength + " bytes cid");`
- [318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L318): `e.printStackTrace();`
- [319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L319): `System.err.println("certificates are invalid!");`
- [321](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L321): `System.err.println("Therefore certificates are not supported!");`
- [326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L326): `e.printStackTrace();`
- [327](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L327): `System.err.println("certificates are missing!");`
- [329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CredentialsUtil.java#L329): `System.err.println("Therefore certificates are not supported!");`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/EmbeddedCoapServer.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L1-L89
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# EmbeddedCoapServer — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 89 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

run ([35–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L35-L87)) builds Configuration from Settings for UDP port, inactivity/ACK timing/retry/dedup/blocks/stage threads/lifetimes/NSTART/probing/observe. Creates CoapServer, adds / and provision resources, installs CoapMessageDeliver. Empty args means CredentialsUtil defaults (PSK/ECDHE_PSK/RPK/X509), recommended suites-only false, DTLS secure port endpoint, then server.start. No stop/shutdown method.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L35): `public void run() throws Exception {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.coapserver.CredentialsUtil.Mode`, `org.eclipse.californium.core.CoapServer`, `org.eclipse.californium.core.config.CoapConfig`, `org.eclipse.californium.core.network.CoapEndpoint`, `org.eclipse.californium.elements.config.Configuration`, `org.eclipse.californium.scandium.DTLSConnector`, `org.eclipse.californium.scandium.config.DtlsConfig`, `org.eclipse.californium.scandium.config.DtlsConnectorConfig`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.net.InetSocketAddress`, `java.util.Arrays`, `java.util.List`, `java.util.concurrent.TimeUnit`.
Configuration references: `ACK_INIT_RANDOM`, `ACK_TIMEOUT`, `ACK_TIMEOUT_SCALE`, `COAP_PORT`, `COAP_SECURE_PORT`, `CROP_ROTATION_PERIOD`, `DEDUPLICATOR`, `EXCHANGE_LIFETIME`, `LEISURE`, `MARK_AND_SWEEP_INTERVAL`, `MAX_ACK_TIMEOUT`, `MAX_MESSAGE_SIZE`, `MAX_PEER_INACTIVITY_PERIOD`, `MAX_RETRANSMIT`, `NON_LIFETIME`, `NOTIFICATION_CHECK_INTERVAL`, `NOTIFICATION_CHECK_INTERVAL_COUNT`, `NOTIFICATION_REREGISTRATION_BACKOFF`, `NSTART`, `PREFERRED_BLOCK_SIZE`, `PROBING_RATE`, `PROTOCOL_STAGE_THREAD_COUNT`, `USE_RANDOM_MID_START`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L74): `private EmbeddedCoapServer coapServer;`
- [src/com/nozha/async/server/Server.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L88): `coapServer = new EmbeddedCoapServer();`

## Business

SOURCE_OBSERVED: Makes CoAP request/provision/observe endpoints available when core feature enabled; broker acceptance not readiness of downstream providers.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

run Exception propagates DTLS/config/bind errors. End banner emitted only after start returns, but server resources may partly exist on failure. Test UDP conflict and certificate-store fallback.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

WARN start/end are operational lifecycle banners, not errors; no readiness probe or per-request logging.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L36) | ALOG-DB480495D6AA | WARN | `logger.warn("Start to RunCoap Server");` | `CoapResourceProvision coapResourceProvision; / public void run() throws Exception {` |
| [86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/EmbeddedCoapServer.java#L86) | ALOG-688EFB72B13B | WARN | `logger.warn("End to RunCoap Server");` | `.setConnector(connector); / server.addEndpoint(coapBuilder.build()); / server.start();` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/coapserver/ReActionClientCoap.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/ReActionClientCoap.java#L1-L6
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ReActionClientCoap — source review

## Technical

Package: `com.nozha.async.server.coapserver`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 6 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Interface ([3–6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/ReActionClientCoap.java#L3-L6)) defines connectClient/disConnectClient no arguments/results/throws. CoapClient installs empty connect and disconnect removal callback; CoapResourceClient calls disconnect when observation removed.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/client/CoapClient.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L45): `coapResourceClient = new CoapResourceClient(clientId, new ReActionClientCoap() {`
- [src/com/nozha/async/server/coapserver/CoapResourceClient.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L15): `private ReActionClientCoap actionClientCoap;`
- [src/com/nozha/async/server/coapserver/CoapResourceClient.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L18): `public CoapResourceClient(String name, ReActionClientCoap actionClientCoap) {`

## Business

SOURCE_OBSERVED: Indirect observer lifecycle callback contract, not a registration API by itself.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path in class; implementation runtime exceptions propagate to caller; no checked throws requirement.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; resource direct stdout and handler visibility only.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/exception/AccessibilityException.md -->

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
source_path: src/com/nozha/async/server/exception/AccessibilityException.java
source_sha256: 12209f70b068759c83b84ec2dd2f5d37d42d4b55afd6335cb84d238b126a5a16
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/AccessibilityException.java
business_approved: false
runtime_tested: false
promoted: false
---

# AccessibilityException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `AccessibilityException` (class_declaration) [src/com/nozha/async/server/exception/AccessibilityException.java:3–8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/AccessibilityException.java#L3-L8)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:506](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L506) ` } catch (AccessibilityException e) {`; [src/com/nozha/async/server/handler/HttpHandler.java:262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L262) ` } catch (AccessibilityException e) {`; [src/com/nozha/async/server/handler/WebsocketHandler.java:131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L131) ` } catch (AccessibilityException e) {`; [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47) ` public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentExcepti`; [src/com/nozha/async/server/biz/AccessibilityService.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L38) ` public static void validateAccessibility(Client client, String key, boolean isKeyAvailable) throws AccessibilityException {`; [src/com/nozha/async/server/client/HttpClient.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L52) ` public HttpClient(Thread thread, HttpServletRequest request, HttpServletResponse response) throws AccessibilityException {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public AccessibilityException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/AccessibilityException.java:5–7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/AccessibilityException.java#L5-L7) |

## Business
SOURCE_OBSERVED: Checked access-validation rejection consumed by messaging/access callers.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:506](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L506), [src/com/nozha/async/server/handler/HttpHandler.java:262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L262), [src/com/nozha/async/server/handler/WebsocketHandler.java:131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L131), [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47), [src/com/nozha/async/server/biz/AccessibilityService.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L38), [src/com/nozha/async/server/client/HttpClient.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L52).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/HttpHandler.java:263](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L263) WARN `("An exception occurred in httpHandler receive message error=AccessibilityException", e)` [ALOG-A3602866D306]; [src/com/nozha/async/server/handler/HttpHandler.java:328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L328) WARN `("An exception occurred in httpHandler receive message error=AccessibilityException", e)` [ALOG-6AAE109E3E5B]


---

<!-- source dossier: src/com/nozha/async/server/exception/BusinessException.md -->

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
source_path: src/com/nozha/async/server/exception/BusinessException.java
source_sha256: 9395a67e639ee2d4ad8b8c987ae2ff68de860ec817b9ffa826a01e35062d2991
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `BusinessException` (class_declaration) [src/com/nozha/async/server/exception/BusinessException.java:6–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java#L6-L23)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/RegistrationManager.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L78) ` public static Peer checkPeer(PeerInfoVO peerInfoVO) throws BusinessException {`; [src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java#L38) ` throw new BusinessException("server already started");`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BusinessException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/BusinessException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java#L7-L9) |
| `public BusinessException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/BusinessException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java#L11-L13) |
| `public BusinessException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/BusinessException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java#L15-L17) |
| `public BusinessException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/BusinessException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/BusinessException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Checked business-operation failure carrier used by registration/membership.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/RegistrationManager.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L78), [src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/EmbeddedArtemisServer.java#L38).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/exception/ClientException.md -->

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
source_path: src/com/nozha/async/server/exception/ClientException.java
source_sha256: b1433df69c237fe44ad5820f318562e486b540f49166bed7a8d6fa6b9a507310
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java
business_approved: false
runtime_tested: false
promoted: false
---

# ClientException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `ClientException` (class_declaration) [src/com/nozha/async/server/exception/ClientException.java:6–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java#L6-L22)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L317) ` public void read(Client client, String msg) throws ClientException {`; [src/com/nozha/async/server/handler/MqttHandler.java:205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L205) ` public boolean deviceMessageArrived(String topic, byte[] bytes, String clientId) throws ClientException {`; [src/com/nozha/async/server/handler/CoapHandler.java:156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L156) ` private CoapClient registerDevice(String clientId) throws ClientException {`; [src/com/nozha/async/server/handler/HttpHandler.java:191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L191) ` } catch (ClientException e) {`; [src/com/nozha/async/server/handler/RestHandler.java:362](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L362) ` } catch (ClientException e) {`; [src/com/nozha/async/server/handler/TcpHandler.java:274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L274) ` } catch (IOException \| ClientException e) {`; [src/com/nozha/async/server/biz/RegistrationManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L41) ` throw new ClientException("device id is empty");`; [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L68) ` } catch (ClientException e) {`; [src/com/nozha/async/server/coapserver/CoapResourceBase.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L31) ` if (e instanceof ClientException) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ClientException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/ClientException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java#L7-L9) |
| `public ClientException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/ClientException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java#L11-L13) |
| `public ClientException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/ClientException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java#L15-L17) |
| `public ClientException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/ClientException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ClientException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Checked client input/operation failure carrier.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L317), [src/com/nozha/async/server/handler/MqttHandler.java:205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L205), [src/com/nozha/async/server/handler/CoapHandler.java:156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L156), [src/com/nozha/async/server/handler/HttpHandler.java:191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L191), [src/com/nozha/async/server/handler/RestHandler.java:362](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L362), [src/com/nozha/async/server/handler/TcpHandler.java:274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L274), [src/com/nozha/async/server/biz/RegistrationManager.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L41), [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L68).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L70) WARN `("ClientException packetType={} clientId={}, remoteAddress={}", packet.getClass().getSimpleName(), packet.payload(), origin)` [ALOG-446845E67984]


---

<!-- source dossier: src/com/nozha/async/server/exception/HttpException.md -->

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
source_path: src/com/nozha/async/server/exception/HttpException.java
source_sha256: 26321922543a0791edfb8bb3e90e95cdf795ce15176845856140ac8af1fe9a03
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java
business_approved: false
runtime_tested: false
promoted: false
---

# HttpException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `HttpException` (class_declaration) [src/com/nozha/async/server/exception/HttpException.java:3–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L3-L38)
Extends Exception but shadows message and status; getMessage returns own field (31–32), getStatusCode returns primitive default0 unless two-argument status constructor used.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `message` | `String` | [src/com/nozha/async/server/exception/HttpException.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L4) |
| `statusCode` | `int` | [src/com/nozha/async/server/exception/HttpException.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L5) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L108) ` } catch (HttpException httpException) {`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L99) ` } catch (HttpException httpException) {`; [src/com/nozha/async/server/httpserver/UnregisterServlet.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L63) ` if (e instanceof HttpException) {`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L174) ` } catch (HttpException httpException) {`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L145) ` } catch (HttpException httpException) {`; [src/com/nozha/async/server/httpserver/MqttServlet.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L60) ` } catch (HttpException e) {`; [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L47) ` } catch (HttpException e) {`; [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L165) ` } catch (HttpException httpException) {`; [src/com/nozha/async/server/persistance/ServiceProviderCrud.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L23) ` public static void createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds) throws SQLException, Ht`; [src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrudInterface.java#L10) ` void createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds) throws SQLException, HttpException;`; [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L24) ` void blockProvider(String providerName, int serverId) throws HttpException;`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L44) ` public static void blockProvider(String providerName, int serverId) throws HttpException {`; [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L136) ` public static void updateBusinessProviderConfig(String businessId, long providerPeerId, String provider, int blockCount) throws HttpExcepti`; [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L13) ` public static void updateRateLimitConfigDto(RateLimitConfig rateLimitConfig) throws HttpException {`; [src/com/nozha/async/server/ratelimit/RateLimitService.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L61) ` public static void blockProvider(Long peerId, String providerName) throws HttpException {`; [src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L44) ` public void createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds) throws SQLException, HttpExcep`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L183) ` public void blockProvider(String providerName, int serverId) throws HttpException {`; [src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLServiceProviderCrud.java#L44) ` public void createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds) throws SQLException, HttpExcep`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L183) ` public void blockProvider(String providerName, int serverId) throws HttpException {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public HttpException()` | Call Exception default constructor; own message null/status0. | [src/com/nozha/async/server/exception/HttpException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L7-L9) |
| `public HttpException(String message)` | Call super(message), copy shadow message; status remains0. | [src/com/nozha/async/server/exception/HttpException.java:11–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L11-L14) |
| `public HttpException(String message, int statusCode)` | Call super(message), store shadow message/status. | [src/com/nozha/async/server/exception/HttpException.java:16–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L16-L20) |
| `public HttpException(String message, Throwable cause)` | Call super(message,cause) only; overridden getMessage still returns null/status0. | [src/com/nozha/async/server/exception/HttpException.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L22-L24) |
| `public HttpException(Throwable cause)` | Call super(cause) only; overridden getMessage null/status0. | [src/com/nozha/async/server/exception/HttpException.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L26-L28) |
| `@Override public String getMessage()` | Return stored value/reference: message. No validation or copying. | [src/com/nozha/async/server/exception/HttpException.java:30–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L30-L33) |
| `public int getStatusCode()` | Return stored value/reference: statusCode. No validation or copying. | [src/com/nozha/async/server/exception/HttpException.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/HttpException.java#L35-L37) |

## Business
SOURCE_OBSERVED: Checked HTTP-oriented failure carrier with custom status/message fields; no-status constructors leave status0.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
String constructor copies own message but status remains0. String+status sets both. Cause-only and String+cause call super but never populate shadow message; overridden getMessage returns null despite superclass message. No validation that status is legal HTTP code. Downstream RateLimitServlet mapping is caller-owned.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L108), [src/com/nozha/async/server/httpserver/RateLimitServlet.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L99), [src/com/nozha/async/server/httpserver/UnregisterServlet.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L63), [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L174), [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L145), [src/com/nozha/async/server/httpserver/MqttServlet.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L60), [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L47), [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L165).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/exception/PersistanceException.md -->

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
source_path: src/com/nozha/async/server/exception/PersistanceException.java
source_sha256: ccd3ca38f8a20d2e207bffbfbf662d67a6a964eae858015cc42336cbe1b88276
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java
business_approved: false
runtime_tested: false
promoted: false
---

# PersistanceException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `PersistanceException` (class_declaration) [src/com/nozha/async/server/exception/PersistanceException.java:6–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java#L6-L22)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:850](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L850) ` } catch (PersistanceException e) {`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L110) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L161) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L81) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L63) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L116) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L59) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L89) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleCoapCRUD.java#L53) ` throw new PersistanceException("entity has id");`; [src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleQueueCRUD.java#L89) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L145) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLCoapCRUD.java#L49) ` throw new PersistanceException("entity has id");`; [src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleDeviceCRUD.java#L53) ` throw new PersistanceException("entity has id");`; [src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRestCRUD.java#L71) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L145) ` throw new PersistanceException(e);`; [src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLDeviceCRUD.java#L50) ` throw new PersistanceException("entity has id");`; [src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java:136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L136) ` throw new PersistanceException(e);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public PersistanceException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/PersistanceException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java#L7-L9) |
| `public PersistanceException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/PersistanceException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java#L11-L13) |
| `public PersistanceException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/PersistanceException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java#L15-L17) |
| `public PersistanceException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/PersistanceException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/PersistanceException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Unchecked persistence failure carrier; spelling is part of source class identity.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:850](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L850), [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L110), [src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L161), [src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L81), [src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleClientCRUD.java#L63), [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L116), [src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLClientCRUD.java#L59), [src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLQueueCRUD.java#L89).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/exception/ServerException.md -->

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
source_path: src/com/nozha/async/server/exception/ServerException.java
source_sha256: 6b044c1f7c33292eb9cb28b4ce3963f0594fd03a75241b25d90909b37c26cabc
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java
business_approved: false
runtime_tested: false
promoted: false
---

# ServerException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `ServerException` (class_declaration) [src/com/nozha/async/server/exception/ServerException.java:6–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java#L6-L22)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:419](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L419) ` } catch (ServerException e) {`; [src/com/nozha/async/server/handler/RawBytesPayload.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L22) ` public String text() throws ServerException {`; [src/com/nozha/async/server/handler/MqttHandler.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L82) ` public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`; [src/com/nozha/async/server/handler/HandlerInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HandlerInterface.java#L11) ` void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException;`; [src/com/nozha/async/server/handler/OutboundPayload.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayload.java#L7) ` String text() throws ServerException;`; [src/com/nozha/async/server/handler/CoapHandler.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L87) ` public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`; [src/com/nozha/async/server/handler/QueueHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L88) ` public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`; [src/com/nozha/async/server/handler/HttpHandler.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L333) ` } catch (ServerException serverException) {`; [src/com/nozha/async/server/handler/WebsocketHandler.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L55) ` public void register(WebsocketClient client) throws ServerException {`; [src/com/nozha/async/server/handler/WebrtcHandler.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L56) ` public void register(WebrtcClient client) throws ServerException {`; [src/com/nozha/async/server/handler/TcpHandler.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L73) ` public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`; [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47) ` public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentExcepti`; [src/com/nozha/async/server/biz/RegistrationManager.java:224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L224) ` public static void createQueueRegistration(QueueRegistration queueRegistration) throws ServerException {`; [src/com/nozha/async/server/httpserver/ClientServlet.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L39) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L36) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L39) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L33) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/UnregisterServlet.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L58) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L59) ` } catch (ServerException e) {`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L50) ` } catch (ServerException e) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ServerException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/ServerException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java#L7-L9) |
| `public ServerException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/ServerException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java#L11-L13) |
| `public ServerException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/ServerException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java#L15-L17) |
| `public ServerException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/ServerException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/ServerException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Checked server-operation failure carrier.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:419](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L419), [src/com/nozha/async/server/handler/RawBytesPayload.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L22), [src/com/nozha/async/server/handler/MqttHandler.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L82), [src/com/nozha/async/server/handler/HandlerInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HandlerInterface.java#L11), [src/com/nozha/async/server/handler/OutboundPayload.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayload.java#L7), [src/com/nozha/async/server/handler/CoapHandler.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L87), [src/com/nozha/async/server/handler/QueueHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L88), [src/com/nozha/async/server/handler/HttpHandler.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L333).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/Server.java:420](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L420) WARN `("An ServerException occurred in send ping for receiver, peerId=" + client.getPeer().getId(), e)` [ALOG-ADF85A0549CA]; [src/com/nozha/async/server/Server.java:869](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L869) WARN `("An ServerException occurred in messageSender for receiver peerId=" + message.getReceiver() + ", messageId=" + message.getId(), e)` [ALOG-A46C07C68BE3]; [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L47) ERROR `("An ServerException occurred in RateLimitManagerServlet", e)` [ALOG-DE08DFEAB4F7]


---

<!-- source dossier: src/com/nozha/async/server/exception/TooManyMessagesSentException.md -->

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
source_path: src/com/nozha/async/server/exception/TooManyMessagesSentException.java
source_sha256: 36d12cdc2295ef6b3dbb951fab62da04ae490f878a004060fd79cf9bef49b7d3
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java
business_approved: false
runtime_tested: false
promoted: false
---

# TooManyMessagesSentException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `TooManyMessagesSentException` (class_declaration) [src/com/nozha/async/server/exception/TooManyMessagesSentException.java:6–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java#L6-L23)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:497](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L497) ` } catch (TooManyMessagesSentException e) {`; [src/com/nozha/async/server/handler/HttpHandler.java:331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L331) ` } catch (TooManyMessagesSentException e) {`; [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47) ` public static List<Message> createMessage(Client client, MessageWrapperVO messageWrapperVO, boolean sync) throws TooManyMessagesSentExcepti`; [src/com/nozha/async/server/biz/LoadManager.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L48) ` static void validateSendMessage(Client client, Peer receiver) throws TooManyMessagesSentException {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public TooManyMessagesSentException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyMessagesSentException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java#L7-L9) |
| `public TooManyMessagesSentException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyMessagesSentException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java#L11-L13) |
| `public TooManyMessagesSentException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyMessagesSentException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java#L15-L17) |
| `public TooManyMessagesSentException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyMessagesSentException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyMessagesSentException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Checked send-load rejection carrier for LoadManager→Server type -99 response.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:497](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L497), [src/com/nozha/async/server/handler/HttpHandler.java:331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L331), [src/com/nozha/async/server/biz/MessageManager.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L47), [src/com/nozha/async/server/biz/LoadManager.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L48).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/Server.java:498](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L498) WARN `("TooManyMessagesSentException for peerId={}", client.getPeer().getId())` [ALOG-45B45A114E2F]


---

<!-- source dossier: src/com/nozha/async/server/exception/TooManyOpenedClientException.md -->

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
source_path: src/com/nozha/async/server/exception/TooManyOpenedClientException.java
source_sha256: 4a60cfbcf55c11fc0fef6968e0828af9a02475b6802abed04275bb2852446cae
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java
business_approved: false
runtime_tested: false
promoted: false
---

# TooManyOpenedClientException — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `TooManyOpenedClientException` (class_declaration) [src/com/nozha/async/server/exception/TooManyOpenedClientException.java:6–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java#L6-L23)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/HttpHandler.java:247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L247) ` } catch (TooManyOpenedClientException e) {`; [src/com/nozha/async/server/handler/WebsocketHandler.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L123) ` } catch (TooManyOpenedClientException e) {`; [src/com/nozha/async/server/biz/LoadManager.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L37) ` public static void validateAndSetOpeningClient(Client client) throws TooManyOpenedClientException {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public TooManyOpenedClientException()` | Constructor forwards/stores supplied values: `super();`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyOpenedClientException.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java#L7-L9) |
| `public TooManyOpenedClientException(String message)` | Constructor forwards/stores supplied values: `super(message);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyOpenedClientException.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java#L11-L13) |
| `public TooManyOpenedClientException(String message, Throwable cause)` | Constructor forwards/stores supplied values: `super(message, cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyOpenedClientException.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java#L15-L17) |
| `public TooManyOpenedClientException(Throwable cause)` | Constructor forwards/stores supplied values: `super(cause);`. References retained; no validation. | [src/com/nozha/async/server/exception/TooManyOpenedClientException.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/TooManyOpenedClientException.java#L19-L21) |

## Business
SOURCE_OBSERVED: Checked opening-load rejection carrier for transport admission.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class beyond inherited exception construction
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/HttpHandler.java:247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L247), [src/com/nozha/async/server/handler/WebsocketHandler.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L123), [src/com/nozha/async/server/biz/LoadManager.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L37).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/HttpHandler.java:248](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L248) WARN `("An exception occurred in httpHandler receive message error=TooManyOpenedClientException", e)` [ALOG-1624DBB1347D]; [src/com/nozha/async/server/handler/HttpHandler.java:259](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L259) WARN `("An exception occurred in complete async request (TooManyOpenedClientException)", e1)` [ALOG-B0EA39CB53D6]


---

<!-- source dossier: src/com/nozha/async/server/exception/WebSocketCloseReason.md -->

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
source_path: src/com/nozha/async/server/exception/WebSocketCloseReason.java
source_sha256: 0f08ddbc89ea8508358e3fcb5196bb11f3f3074c009a28aea01a5e7f274f2e5f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java
business_approved: false
runtime_tested: false
promoted: false
---

# WebSocketCloseReason — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.exception`. Types: `WebSocketCloseReason` (enum_declaration) [src/com/nozha/async/server/exception/WebSocketCloseReason.java:9–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L9-L71)
Mutable data/type carrier; full field and per-method contract below. Defined application codes4100..4112 (11–23); map at25–35 covers removed/refreshed/write-timeout/register/messaging/error/expired/rejected-open/rejected-message. Closed/unsubscribed/service-call timeout/unlisted statuses fallback4100; read-timeout/open-error/not-registered enum values are not in this map.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `DESTROY_MAP` | `Map<Integer, WebSocketCloseReason>` | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L25) |
| `DEFAULT_REASON` | `WebSocketCloseReason` | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L37) |
| `code` | `int` | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L39) |
| `reason` | `String` | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L40) |
Dependencies are imports (some may be unused): `com.nozha.async.server.Server` [src/com/nozha/async/server/exception/WebSocketCloseReason.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L4); `org.eclipse.jetty.websocket.core.CloseStatus` [src/com/nozha/async/server/exception/WebSocketCloseReason.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L5); `java.util.Map` [src/com/nozha/async/server/exception/WebSocketCloseReason.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L7)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/WebsocketHandler.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L71) ` CloseStatus status = WebSocketCloseReason.CLOSED_BY_ERROR_IN_REGISTERING.asCloseStatus();`; [src/com/nozha/async/server/client/WebsocketClient.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L132) ` CloseStatus status = WebSocketCloseReason.mapToCloseStatus(statusCode);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `WebSocketCloseReason(int code, String reason)` | Store exact close code/reason. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:42–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L42-L45) |
| `public int code()` | Return stored value/reference: code. No validation or copying. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L47-L49) |
| `public String reason()` | Return stored value/reference: reason. No validation or copying. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L51-L53) |
| `public CloseStatus asCloseStatus()` | Construct Jetty CloseStatus with own code/reason. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L55-L57) |
| `public static WebSocketCloseReason fromDestroyStatus(int destroyStatus)` | Map Server destroy status through fixed map or fallback CLOSED_BY_SERVER4100. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L59-L61) |
| `public static CloseStatus mapToCloseStatus(int destroyStatus)` | Convert mapped enum to CloseStatus. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L63-L65) |
| `@Override public String toString()` | Render code + separator + reason. | [src/com/nozha/async/server/exception/WebSocketCloseReason.java:67–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/exception/WebSocketCloseReason.java#L67-L70) |

## Business
SOURCE_OBSERVED: Maps internal Server destroy status to WebSocket application close code/reason.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/WebsocketHandler.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L71), [src/com/nozha/async/server/client/WebsocketClient.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L132).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/handler/ChatHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ChatHandler.java#L1-L78
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ChatHandler — source review

## Technical

Package: `NONE (comment-only compilation unit)`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **COMMENT_ONLY; no executable class declaration**. Full compilation unit reviewed: 78 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Whole package/class is comments ([1–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ChatHandler.java#L1-L78)), no compiled declaration. Historical constructor/static block initializes AsyncAdaptor; fixed executor delegates JSON requests; checkRegistration synchronizes singleton and lazily loads PeerInfo/checkPeer/create/register/add client; read delegates core and destroy AsyncAdaptor.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- No live lexical external reference found in supplied Java files.

## Business

SOURCE_OBSERVED: Historical chat integration description only; must not claim enabled feature.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No executable direct error path. Historical catch BusinessException and warning are disabled text.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS (executable); historical logger.warn at63 may remain registry false positive.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/handler/ClientMessagePayload.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L1-L45
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ClientMessagePayload — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 45 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([11–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L11-L15)) retains mutable ClientMessage and expiry/sender snapshots. bytes ([22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L22-L24)) delegates text then platform-default getBytes; text ([27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L27-L29)) JsonUtil serialization. Accessors return reference/snapshots and getType0 ([42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L42-L44)). OutboundPayloadFactory chooses this when binaryContent absent.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L11): `public ClientMessagePayload(ClientMessage clientMessage, long expirationDate, long sender) {`
- [17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L17): `public ClientMessage getClientMessage() {`
- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L22): `public byte[] bytes() {`
- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L27): `public String text() {`
- [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L32): `public long getExpirationDate() {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L37): `public long getSender() {`
- [42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L42): `public int getType() {`

Source dependency imports: `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.ClientMessage`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:500](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L500): `client.sendMessage(new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.ERROR_MESSAGE, JsonUtil.getJson(Server.DESTROY_STATUS_REMOVED_MESSAGING_REJECTED)), 0,0));`
- [src/com/nozha/async/server/handler/CoapHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L88): `ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`
- [src/com/nozha/async/server/handler/QueueHandler.java:94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L94): `if (outboundPayload instanceof ClientMessagePayload) {`
- [src/com/nozha/async/server/handler/QueueHandler.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L95): `PODLogUtil.logSendRequest(podLogger, ((ClientMessagePayload)outboundPayload).getClientMessage(), queueClient.getPeer().getName());`
- [src/com/nozha/async/server/handler/HttpHandler.java:342](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L342): `clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`
- [src/com/nozha/async/server/handler/RestHandler.java:322](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L322): `ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`
- [src/com/nozha/async/server/handler/RestHandler.java:375](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L375): `sendMessage(client, new ClientMessagePayload(clientMessage, clientMessage.getExpirationDate(), clientMessage.getSenderId()));`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62): `sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0));`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L85): `ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62): `sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0));`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L77): `ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`
- [src/com/nozha/async/server/handler/TcpHandler.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L132): `writeData(outputStream, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, String.valueOf(peer.getId())), 0, 0).bytes());`
- [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L16): `payload = new ClientMessagePayload(new ClientMessage(message), message.getExpireDate(), message.getSender());`
- [src/com/nozha/async/server/client/CoapClient.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L60): `this.clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`

## Business

SOURCE_OBSERVED: Indirect normal-message envelope serialization shared across transports. Type0 is payload discriminator, not ClientMessage messageType.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct explicit throw/catch; JsonUtil behavior propagates/returns per utility; null ClientMessage allowed. Test charset compatibility and mutation after construction.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; transport send failures and Server before/after send logs are surrounding signals.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/handler/CoapHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L1-L178
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# CoapHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 178 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton synchronized clientMap. connectReceiveArrive ([45–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L45-L66)) resolves endpoint registration; existing client returns null, else creates listening client/register/add and returns resource, prints failures. receiveMessage ([68–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L68-L75)) builds wrapper, registers URI segment0 device, sets sync/wait and core.read sync. receiveProvision ([77–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L77-L83)) checks destination count, null-peer sync client using MID (argument unused), builds MID tracker wrapper and core.read. sendMessage casts ClientMessagePayload and sends content to resource; destroy empty. removeClient removes map then core. getMessageSync/getMessage ([106–126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L106-L126)) URI segment1 peer, GenericRequest JSON, wrapper type3/MID or0. GenericRequest includes request method/full URI/body/query; getUriPath skips segment0 unused; getMapParametr splits = with no encoding/index validation and overwrites duplicates. registerDevice and endpoint lookup query CoapCRUD or throw CLIENT_NOT_FOUND. provision count ([172–177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L172-L177)) rejects count>threshold then puts expiring cache record.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L37): `CoapHandler(){`
- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L41): `public static CoapHandler getInstance() {`
- [45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L45): `public CoapResource connectReceiveArrive(String endPoint){`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L68): `public CoapClient receiveMessage(CoapExchange coapExchange) throws  Exception {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L77): `public CoapClient receiveProvision(CoapExchange coapExchange) throws  Exception {`
- [87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L87): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L93): `public void destroy() {`
- [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L97): `public void removeClient(String clientId, int code) {`
- [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L106): `private MessageWrapperVO getMessageSync(CoapExchange coapExchange){`
- [117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L117): `private MessageWrapperVO getMessage(CoapExchange coapExchange){`
- [128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L128): `private GenericRequest getGenericRequestFromExchange(CoapExchange coapExchange){`
- [138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L138): `private String getUriPath(List<String> path){`
- [147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L147): `private Map<String,List<String>> getMapParametr(List<String> paramList){`
- [156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L156): `private CoapClient registerDevice(String clientId) throws ClientException {`
- [164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L164): `private CoapRegistration getCoapRegisterDevice(String endPoint) throws ClientException {`
- [172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L172): `private void isValidProvisionRequestCount(String peerName) throws Exception {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.CoapClient`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.mediation.generic.vo.GenericRequest`, `com.nozha.async.server.model.CoapRegistration`, `com.nozha.async.server.persistance.CoapCRUD`, `com.nozha.async.server.util.CacheUtil`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.MessageVO`, `com.nozha.async.server.vo.MessageWrapperVO`, `org.eclipse.californium.core.CoapResource`, `org.eclipse.californium.core.server.resources.CoapExchange`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.util.Collections`, `java.util.HashMap`, `java.util.List`, `java.util.Map`.
Configuration references: `PROVISION_COUNT_TO_REFUSE`, `PROVISION_TIME_TO_REFUSE`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L191): `handlers.add(CoapHandler.getInstance());`
- [src/com/nozha/async/server/client/CoapClient.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L53): `CoapHandler.getInstance().removeClient(clientId ,1);`
- [src/com/nozha/async/server/client/CoapClient.java:63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L63): `CoapHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L24): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L36): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceProvision.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceProvision.java#L47): `CoapClient coapClient = CoapHandler.getInstance().receiveProvision(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L25): `CoapClient coapClient = CoapHandler.getInstance().receiveMessage(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L42): `CoapClient coapClient = CoapHandler.getInstance().receiveMessage(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L58): `CoapClient coapClient = CoapHandler.getInstance().receiveMessage(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceBase.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceBase.java#L74): `CoapClient coapClient = CoapHandler.getInstance().receiveMessage(exchange);`
- [src/com/nozha/async/server/coapserver/CoapResourceClient.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapResourceClient.java#L46): `CoapHandler.getInstance().receiveMessage(exchange);`
- [src/com/nozha/async/server/coapserver/CoapMessageDeliver.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/coapserver/CoapMessageDeliver.java#L85): `current = CoapHandler.getInstance().connectReceiveArrive(exchange.getRequest().getOptions().getUriPathString());`

## Business

SOURCE_OBSERVED: CoAP device identity and provision-rate bridge to Async routing; count equality still accepted. Observer reconnection for existing client is rejected by null resource.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

CLIENT_NOT_FOUND ClientException at159/167; Exception("Count Provision Is Over Load") at175. Sync methods propagate to resources status mapping. connect catch prints and returns null; array/query indexing and payload casts may fail. No per-request retry. Test first/repeated observe and malformed query.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L62): `} catch (Exception e) {`
- [159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L159): `throw new ClientException(CLIENT_NOT_FOUND);`
- [167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L167): `throw new ClientException(CLIENT_NOT_FOUND);`
- [175](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L175): `throw new Exception("Count Provision Is Over Load");`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS despite unused logger imports; one printStackTrace connect path. Resources report failure to client.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L63): `e.printStackTrace();`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/handler/ExceptionListener.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L1-L19
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ExceptionListener — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 19 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor captures QueueClient; onException ([15–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L15-L18)) logs exception with peer/client IDs then QueueHandler.reconnect synchronously. No additional state/backoff; nullable peer dereference precedes reconnect.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L11): `public ExceptionListener(QueueClient client) {`
- [15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L15): `public void onException(Exception exception) {`

Source dependency imports: `com.nozha.async.server.client.QueueClient`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/client/QueueClient.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L23): `ExceptionListener exceptionListener;`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L44): `this.exceptionListener = new ExceptionListener(this);`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L147): `class QueueExceptionListener implements javax.jms.ExceptionListener {`
- [src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L30): `this.exceptionListener = new ExceptionListener(this);`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L43): `this.exceptionListener = new ExceptionListener(this);`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L146): `class QueueExceptionListener implements javax.jms.ExceptionListener {`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L54): `this.exceptionListener = new com.nozha.async.server.handler.ExceptionListener(this);`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:313](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L313): `class ProducerExceptionListener implements javax.jms.ExceptionListener {`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L325): `class ConsumerExceptionListener implements javax.jms.ExceptionListener {`
- [src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/AsyncQueueAdaptor.java#L82): `public class exceptionListener implements ExceptionListener {`

## Business

SOURCE_OBSERVED: Indirect JMS connection failure→provider reconnect trigger.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct catch; logging null peer may mask original error and skip reconnection. QueueHandler handles reconnect retries; test callback with partial registration.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

WARN carries original throwable; may block JMS callback on reconnect loop.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L16) | ALOG-E0A85FFB4BE4 | WARN | `logger.warn("An exception occurred for Connection of Queue Client peerId="+client.getPeer().getId()+" clientId="+client.getId()+" exception=",exception);` | `this.client = client; / } / public void onException(Exception exception) {` |

Registry reconciliation: 1 rows for this file; 1 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/com/nozha/async/server/handler/HandlerInterface.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HandlerInterface.java#L1-L13
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# HandlerInterface — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 13 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Interface ([10–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HandlerInterface.java#L10-L13)) sendMessage(Client,OutboundPayload) throws ServerException and destroy() void. Implementations determine protocol formats, guards and teardown; does not declare ACK/retry guarantees.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: `com.nozha.async.server.client.Client`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.vo.ClientMessage`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L79): `private List<HandlerInterface> handlers = new ArrayList<>();`
- [src/com/nozha/async/server/Server.java:571](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L571): `for (HandlerInterface handler : handlers) {`
- [src/com/nozha/async/server/Server.java:1358](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1358): `for (HandlerInterface handler : Server.getInstance().handlers) {`
- [src/com/nozha/async/server/Server.java:1379](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1379): `private static void exitSystem(List<HandlerInterface> handlers) throws IOException {`
- [src/com/nozha/async/server/Server.java:1380](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1380): `for (HandlerInterface handler : handlers) {`
- [src/com/nozha/async/server/handler/MqttHandler.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L27): `public class MqttHandler implements HandlerInterface, MqttCallback {`
- [src/com/nozha/async/server/handler/CoapHandler.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L30): `public class CoapHandler implements HandlerInterface{`
- [src/com/nozha/async/server/handler/QueueHandler.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L24): `public class QueueHandler implements HandlerInterface {`
- [src/com/nozha/async/server/handler/HttpHandler.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L46): `public class HttpHandler implements HandlerInterface {`
- [src/com/nozha/async/server/handler/RestHandler.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L43): `public class RestHandler implements HandlerInterface {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L32): `public class WebsocketHandler implements HandlerInterface {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L27): `public class WebrtcHandler implements HandlerInterface {`
- [src/com/nozha/async/server/handler/TcpHandler.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L35): `public class TcpHandler implements HandlerInterface {`

## Business

SOURCE_OBSERVED: Indirect common transport dispatch boundary used by Server and protocol clients.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path; declared ServerException is propagated contract, implementations sometimes suppress internally.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; implementations and core provide logs.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.
