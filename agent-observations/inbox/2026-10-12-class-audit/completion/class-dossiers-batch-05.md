# Async class dossiers — review batch 05


---

### dossier-src-com-nozha-async-server-handler-httphandler

<!-- source dossier: src/com/nozha/async/server/handler/HttpHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L1-L481
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# HttpHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 481 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton + static upload factory ([46–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L46-L60)) memory threshold/temp repository. parseMultipartRequest uses configured max file size; RequestContext adapter delegates Jakarta request; parameter helpers prefer servlet params else FILE_ITEMS values. receiveMessage ([135–299](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L135-L299)) start time/client request UUID, multipart map/business ID, create HttpClient/accessibility, IP watch/block, optional device/app peer and opening load validation, receiving mediation then rate enforcement; nonnull input sets wait/inputJson/timeout and dispatches core.read via AsyncContext.start. Null input sendError204. Explicit branches map opened-client503, access403, mediation redirect307 or code/default503, upload503, complete/remove selectively. sendOnly ([314–336](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L314-L336)) mediates and MessageManager.createMessage without waiting; several errors log only. sendMessage ([339–473](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L339-L473)) expects ClientMessagePayload or null, resolves response metadata/ARN; waiting maps stored status or408, reply mediates output then chunks RESPONSE_CHUNK_SIZE and closes writer, previews first100 chars; ERROR_MESSAGE attempts500 after body write; absent reply stored status or500. finally completes context/removes processed/invalidate session, conditionally Kafka anomaly and JSON ServiceTimeLog/POD response; removes client only nonnull message. destroy empty.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L62): `private HttpHandler() {`
- [66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L66): `public static HttpHandler getInstance() {`
- [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L70): `private static List<FileItem> parseMultipartRequest(HttpServletRequest request) throws FileUploadException {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L77): `private static RequestContext getRequestContext(HttpServletRequest request) {`
- [80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L80): `public String getCharacterEncoding() {`
- [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L85): `public String getContentType() {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L90): `public int getContentLength() {`
- [95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L95): `public InputStream getInputStream() throws IOException {`
- [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L101): `private static String getParameter(String name, HttpServletRequest req) {`
- [117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L117): `private static String[] getParameters(String name, HttpServletRequest req) {`
- [135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L135): `public void receiveMessage(HttpServletRequest req, HttpServletResponse resp) {`
- [301](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L301): `private void parsRequest(HttpServletRequest req) throws FileUploadException {`
- [314](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L314): `public void sendOnly(HttpServletRequest req, HttpServletResponse resp) {`
- [339](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L339): `public void sendMessage(Client client, OutboundPayload outboundPayload) {`
- [476](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L476): `public void destroy() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.biz.LoadManager`, `com.nozha.async.server.biz.MessageManager`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.HttpClient`, `com.nozha.async.server.exception.*`, `com.nozha.async.server.mediation.MediatorManager`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.mediation.vo.HttpContent`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.ratelimit.BaseRateLimiter`, `com.nozha.async.server.ratelimit.RateLimitIpAddress`, `com.nozha.async.server.ratelimit.kafka.RateLimitKafkaManager`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.util.MessageType`, `com.nozha.async.server.util.PODLogUtil`, `com.nozha.async.server.util.StringUtil`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.MessageWrapperVO`, `com.nozha.async.server.vo.log.ServiceTimeLog`, `org.apache.commons.fileupload.FileItem`, `org.apache.commons.fileupload.FileUploadException`, `org.apache.commons.fileupload.RequestContext`, `org.apache.commons.fileupload.disk.DiskFileItemFactory`, `org.apache.commons.fileupload.servlet.ServletFileUpload`, `org.apache.logging.log4j.Logger`, `org.apache.logging.log4j.LogManager`, `org.jetbrains.annotations.NotNull`, `org.slf4j.LoggerFactory`, `jakarta.servlet.AsyncContext`, `jakarta.servlet.http.HttpServletRequest`, `jakarta.servlet.http.HttpServletResponse`, `java.io.File`, `java.io.IOException`, `java.io.InputStream`, `java.util.*`.
Configuration references: `CHECK_HTTP_VALID_OPEN_CLIENT`, `CLIENT_REQUEST_ID_KEY`, `HAS_ANOMALY_RATE_LIMIT`, `HTTP_THRESHOLD_TIME`, `POD_MONITORING_ARN_HEADER`, `POD_MONITORING_DESC_NAME_HTTP`, `RESPONSE_CHUNK_SIZE`, `UPLOADED_TEMP_DIR`, `UPLOAD_MAX_FILE_SIZE`, `UPLOAD_MAX_MEM_SIZE`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L169): `handlers.add(HttpHandler.getInstance());`
- [src/com/nozha/async/server/httpserver/AutoResponseServlet.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L27): `HttpHandler.getInstance().sendOnly(req, resp);`
- [src/com/nozha/async/server/httpserver/AsyncServlet.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L34): `HttpHandler.getInstance().receiveMessage(req, resp);`
- [src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L35): `HttpHandler.getInstance().receiveMessage(req, resp);`
- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L53): `HttpHandler.getInstance().receiveMessage(req, resp);`
- [src/com/nozha/async/server/client/HttpClient.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L124): `HttpHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/client/HttpClient.java:162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L162): `HttpHandler.getInstance().sendMessage(this, null);`
- [src/com/nozha/async/server/mediation/HttpMediator.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L19): `Map<String, List<FileItem>> map = (Map<String, List<FileItem>>) req.getAttribute(HttpHandler.FILE_ITEMS);`
- [src/com/nozha/async/server/mediation/HttpMediator.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/HttpMediator.java#L37): `Map<String, List<FileItem>> map = (Map<String, List<FileItem>>) req.getAttribute(HttpHandler.FILE_ITEMS);`

## Business

SOURCE_OBSERVED: Main HTTP-to-Async request/reply and fire-and-forget bridge. Client UUID/tracker/ARN ties request response, but business/provider values come from request attributes. Null mediation returns no-content; error-page mediation redirects; no approved SLA.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

TooManyOpened503, Accessibility403, Mediation307/code503, FileUpload503; sendError IOException fallbacks set status. Async core ClientException wraps RuntimeException after warning. sendOnly suppresses mediation/ServerException, prints TooManyMessages; accessibility remove may receive null client. send catches IOException/Mediation→500; finally catches completion/session/log errors and may dereference null startTime in warning. Binary outbound cast before try is uncaught; ERROR response may already committed. Zero/negative chunk size can prevent progress. Test late reply after timeout, malformed multipart, output mediator error and missing attributes.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L182): `client.getAsyncContext().setTimeout((Integer) req.getAttribute("timeout"));`
- [191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L191): `} catch (ClientException e) {`
- [194](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L194): `throw new RuntimeException(e);`
- [212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L212): `resp.sendError(HttpServletResponse.SC_NO_CONTENT);`
- [213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L213): `} catch (IOException e) {`
- [215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L215): `resp.setStatus(HttpServletResponse.SC_NO_CONTENT);`
- [247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L247): `} catch (TooManyOpenedClientException e) {`
- [251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L251): `resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);`
- [252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L252): `} catch (IOException e1) {`
- [254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L254): `resp.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);`
- [258](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L258): `} catch (Exception e1) {`
- [262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L262): `} catch (AccessibilityException e) {`
- [264](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L264): `resp.setStatus(HttpServletResponse.SC_FORBIDDEN);`
- [265](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L265): `} catch (MediationException e) {`
- [268](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L268): `resp.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);`
- [277](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L277): `resp.sendError(errorCode);`
- [278](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L278): `} catch (IOException e1) {`
- [280](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L280): `resp.setStatus(errorCode);`
- [285](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L285): `} catch (Exception e2) {`
- [289](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L289): `} catch (FileUploadException e) {`
- [293](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L293): `resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);`
- [294](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L294): `} catch (IOException e1) {`
- [296](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L296): `resp.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);`
- [325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L325): `} catch (MediationException e) {`
- [327](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L327): `} catch (AccessibilityException e) {`
- [329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L329): `resp.setStatus(HttpServletResponse.SC_FORBIDDEN);`
- [331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L331): `} catch (TooManyMessagesSentException e) {`
- [333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L333): `} catch (ServerException serverException) {`
- [361](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L361): `resp.setStatus(httpClient.getSc());`
- [364](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L364): `resp.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT);`
- [365](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L365): `} catch (IOException e) {`
- [367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L367): `resp.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);`
- [400](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L400): `resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L401): `} catch (IOException e) {`
- [403](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L403): `resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [408](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L408): `resp.setStatus(httpClient.getSc());`
- [411](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L411): `resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [412](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L412): `} catch (IOException e) {`
- [414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L414): `resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [418](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L418): `} catch (IOException | MediationException e) {`
- [421](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L421): `resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [422](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L422): `} catch (Exception e1) {`
- [424](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L424): `resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);`
- [457](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L457): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

ServiceTimeLog includes request path, tracker/UUID, response preview, business/IP/provider/host/origin/ARN; POD helper adds indirect log. Full output preview may contain sensitive content. Body close/complete log is not destination ACK.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L150) | ALOG-EC3BB7CB5A99 | WARN | `logger.warn("httpHandler parsRequest more than threshold uniqueId= {} , time= {}", uuid, diffTime);` | `parsRequest(req); / req.setAttribute("business_id", KeyleadUtil.getBusinessIdFromToken(req)); / long diffTime = System.currentTimeMillis() - time; / if (diffTime > Settings.HTTP_THRESHOLD_TIME) {` |
| [171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L171) | ALOG-F853286E1EA3 | WARN | `logger.warn("httpHandler mediateReceive more than threshold uniqueId= {} , time= {}", uuid, diffTime);` | `Object inputContent = MediatorManager.getInstance().mediateReceive(new HttpContent(req, resp), MediatorManager.HTTP_CHANNAL); / BaseRateLimiter.enforceRateLimit(req); / diffTime = System.currentTimeMillis() - time; / if (diffTime > Settings.HTTP_THRESHOLD_TIME) {` |
| [188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L188) | ALOG-AFF031C9B84F | WARN | `logger.warn("httpHandler async context start more than threshold uniqueId= {} , time= {}", finalUuid, finalDiffTime);` | `client.getAsyncContext().start(() -> { / try { / long finalDiffTime = System.currentTimeMillis() - currentTime; / if (finalDiffTime > Settings.HTTP_THRESHOLD_TIME) {` |
| [192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L192) | ALOG-2A11B090746F | WARN | `logger.warn("An exception occurred in read message in httpHandler for clientId={} , peerId={} ,uniqueId= {}", finalClient.getId(), finalClient.getPeer() != null ? finalClient.getPeer().getId() : "", finalUuid, e);` | `logger.warn("httpHandler async context start more than threshold uniqueId= {} , time= {}", finalUuid, finalDiffTime); / } / Server.getInstance().read(finalClient, inputContent, true); / } catch (ClientException e) {` |
| [214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L214) | ALOG-A675CDA13C67 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_NO_CONTENT, e);` | `//                resp.setStatus(HttpServletResponse.SC_NO_CONTENT); / try { / resp.sendError(HttpServletResponse.SC_NO_CONTENT); / } catch (IOException e) {` |
| [248](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L248) | ALOG-1624DBB1347D | WARN | `logger.warn("An exception occurred in httpHandler receive message error=TooManyOpenedClientException", e);` | `} / } / */ / } catch (TooManyOpenedClientException e) {` |
| [253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L253) | ALOG-C2321D08333A | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_SERVICE_UNAVAILABLE, e1);` | `//            resp.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); / try { / resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE); / } catch (IOException e1) {` |
| [259](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L259) | ALOG-B0EA39CB53D6 | WARN | `logger.warn("An exception occurred in complete async request (TooManyOpenedClientException)", e1);` | `} / try { / client.getAsyncContext().complete(); / } catch (Exception e1) {` |
| [263](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L263) | ALOG-A3602866D306 | WARN | `logger.warn("An exception occurred in httpHandler receive message error=AccessibilityException", e);` | `logger.warn("An exception occurred in complete async request (TooManyOpenedClientException)", e1); / } / Server.getInstance().removeClient(client, Server.DESTROY_STATUS_CLOSED); / } catch (AccessibilityException e) {` |
| [266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L266) | ALOG-1DB89FB6A8F9 | WARN | `logger.warn("An exception occurred in httpHandler error=MediationException origin={},  businessId= " + req.getAttribute("business_id") + " , token= " + StringUtil.maskString(KeyleadUtil.getToken(req)), client.getAddress(), e);` | `} catch (AccessibilityException e) { / logger.warn("An exception occurred in httpHandler receive message error=AccessibilityException", e); / resp.setStatus(HttpServletResponse.SC_FORBIDDEN); / } catch (MediationException e) {` |
| [279](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L279) | ALOG-859377D41F22 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", errorCode, e1);` | `} / try { / resp.sendError(errorCode); / } catch (IOException e1) {` |
| [286](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L286) | ALOG-99A73B815FA4 | WARN | `logger.warn("An exception occurred in complete async request. (MediationException)", e2);` | `} / try { / client.getAsyncContext().complete(); / } catch (Exception e2) {` |
| [290](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L290) | ALOG-6FDDEF38645B | WARN | `logger.warn("An exception occurred in httpHandler error=FileUploadException", e);` | `logger.warn("An exception occurred in complete async request. (MediationException)", e2); / } / Server.getInstance().removeClient(client, Server.DESTROY_STATUS_CLOSED); / } catch (FileUploadException e) {` |
| [295](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L295) | ALOG-9759FA77F432 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_SERVICE_UNAVAILABLE, e1);` | `//            resp.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); / try { / resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE); / } catch (IOException e1) {` |
| [326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L326) | ALOG-64AD47F95246 | WARN | `logger.warn("An exception occurred in httpHandler error=MediationException origin={}", client.getAddress(), e);` | `if (inputContent != null) { / MessageManager.createMessage(client, (MessageWrapperVO) inputContent, true); / } / } catch (MediationException e) {` |
| [328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L328) | ALOG-6AAE109E3E5B | WARN | `logger.warn("An exception occurred in httpHandler receive message error=AccessibilityException", e);` | `} / } catch (MediationException e) { / logger.warn("An exception occurred in httpHandler error=MediationException origin={}", client.getAddress(), e); / } catch (AccessibilityException e) {` |
| [334](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L334) | ALOG-11D1C1EA2F4E | ERROR | `logger.error(serverException.getMessage());` | `Server.getInstance().removeClient(client, Server.DESTROY_STATUS_REMOVED_MESSAGING_REJECTED); / } catch (TooManyMessagesSentException e) { / e.printStackTrace(); / } catch (ServerException serverException) {` |
| [366](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L366) | ALOG-78BFAC749645 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_REQUEST_TIMEOUT, e);` | `} else { / try { / resp.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT); / } catch (IOException e) {` |
| [402](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L402) | ALOG-7CA590D09E97 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e);` | `if (clientMessage.getType() == MessageType.ERROR_MESSAGE) { / try { / resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); / } catch (IOException e) {` |
| [413](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L413) | ALOG-3319BC2E1A2F | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e);` | `} else { / try { / resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); / } catch (IOException e) {` |
| [419](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L419) | ALOG-6ACF6DDEE751 | WARN | `logger.warn("An exception occurred in httpHandler error={}", e.getClass().getName(), e);` | `} / } / } / } catch (IOException \| MediationException e) {` |
| [423](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L423) | ALOG-74A18E9D6B98 | WARN | `logger.warn("An exception occurred in httpHandler send error code={}", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e1);` | `logger.warn("An exception occurred in httpHandler error={}", e.getClass().getName(), e); / try { / resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); / } catch (Exception e1) {` |
| [439](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L439) | ALOG-661971303632 | INFO | `loggerJson.info(new ServiceTimeLog( currentTime - startTime, clientMessage == null ? 0 : currentTime - clientMessage.getTime(), responseStatus, requestURI, httpClient.getLastTrackerId(), uuid, msgPreview, businessId != null ? (String) businessId : "-", httpClient.getAddress(), provider != null ? (String) provider : "-", host, client.getOrigin(), clientMessage == null ? "" : clientMessage.getARN(), clientMessage == null ? 0 : clientMessage.getARNStep()));` | `String path = provider + "#" + requestURI; / RateLimitKafkaManager.sendMessage((String) provider, path, client.getAddress(), (String) businessId, startTime); / } / }` |
| [459](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L459) | ALOG-01BACEC7A650 | WARN | `logger.warn("An exception occurred in complete async request. (finally) service time: {} {}, status: {}, {}, {}, {}, {}", currentTime - startTime, clientMessage == null ? "x" : currentTime - clientMessage.getTime(), responseStatus, requestURI, httpClient.getLastTrackerId(), uuid, msgPreview, e);` | `} / httpClient.getSession().invalidate(); / } catch (Exception e) { / long currentTime = System.currentTimeMillis();` |

Registry reconciliation: 24 rows for this file; 24 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [332](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L332): `e.printStackTrace();`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-messagelistener

<!-- source dossier: src/com/nozha/async/server/handler/MessageListener.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L1-L34
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MessageListener — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 34 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor retains QueueClient. byte[] onMessage ([18–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L18-L25)) UTF-8 decode then core.read; String overload ([27–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L27-L33)) core.read directly. Both suppress Exception with peer-scoped warning.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L14): `public MessageListener(QueueClient client) {`
- [18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L18): `public void onMessage(byte[] message) {`
- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L27): `public void onMessage(String message) {`

Source dependency imports: `com.nozha.async.server.Server`, `com.nozha.async.server.client.QueueClient`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.nio.charset.StandardCharsets`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/client/QueueClient.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L22): `MessageListener messageListener;`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L43): `this.messageListener = new com.nozha.async.server.handler.MessageListener(this);`
- [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L124): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L29): `this.messageListener = new MessageListener(this);`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L42): `this.messageListener = new com.nozha.async.server.handler.MessageListener(this);`
- [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L123): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L53): `this.messageListener = new com.nozha.async.server.handler.MessageListener(this);`
- [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L273): `class QueueMessageListener implements MessageListener {`
- [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L16): `public class RateLimitMessageListener implements MessageListener {`
- [src/com/nozha/async/server/activemq/local/QueueMessageListener.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/local/QueueMessageListener.java#L17): `public class QueueMessageListener implements MessageListener {`

## Business

SOURCE_OBSERVED: Indirect shared provider queue receive bridge; callers may have broker ACKed before invoking.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Catch all Exception suppresses core validation/parse failure; warning dereferences peer and can itself NPE. No retry/requeue. Test invalid UTF-8/JSON and core rejection.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L22): `} catch (Exception e) {`
- [30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L30): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

WARN proves Server.read threw, does not distinguish validation vs persistence without stack.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L23) | ALOG-F9902BBF4B53 | WARN | `logger.warn("An exception occurred in MessageListener for peerId=" + client.getPeer().getId(), e);` | `try { / String msg = new String(message, StandardCharsets.UTF_8); / Server.getInstance().read(client, msg); / } catch (Exception e) {` |
| [31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MessageListener.java#L31) | ALOG-0D0926407292 | WARN | `logger.warn("An exception occurred in MessageListener for peerId=" + client.getPeer().getId(), e);` | `public void onMessage(String message) { / try { / Server.getInstance().read(client, message); / } catch (Exception e) {` |

Registry reconciliation: 2 rows for this file; 2 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-mqtthandler

<!-- source dossier: src/com/nozha/async/server/handler/MqttHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L1-L380
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# MqttHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 380 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton constructor ([40–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L40-L61)) Paho clean session/30s keepalive/auto reconnect, username overwritten to server, hardcoded password/will, local configured broker, two + subscriptions. Paho callback messageArrived ([69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L69-L71)) intentionally ignores broker copy because Artemis interceptor processes messages; connectionLost warns/deliveryComplete empty. sendMessage ([82–105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L82-L105)) publish bytes then unbounded waitForCompletion; failures may reconnect server client. closeClient removes three maps and broker connection; closeConnection best-effort. register ([129–156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L129-L156)) device/peer selection, three map updates/replacement, rollback/remove/rethrow. registerDevice ([158–184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L158-L184)) DeviceCRUD client/peer/device/app validation then output prefix/inputQueue/deviceId; registerPeer ([186–199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L186-L199)) validates peer IDs/device/app and clientId=app-device, assigns output topic. Inbound device ([205–226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L205-L226)) makes MessageVO peerName topic suffix and type MESSAGE wrapper; general ([228–238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L228-L238)) UTF-8 core.read; unknown map false. connectionRequest ([240–255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L240-L255)) parses will ClientInfo then register→ClientException on failure. closed/removal ([257–273](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L257-L273)) remove related clients and primary. subscription ([275–337](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L275-L337)) rejects input prefixes and topics outside output address prefix, but calls register/add even after invalid verdict; devices fan out related registrations, then invalid cleanup. unsubscription ([338–379](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L338-L379)) same prefix validation then remove UNSUBSCRIBED; invalid cleanup CLOSED_BY_ERROR. destroy empty.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L40): `private MqttHandler() {`
- [64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L64): `public void connectionLost(Throwable cause) {`
- [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L69): `public void messageArrived(String topic, MqttMessage message) throws Exception {`
- [74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L74): `public void deliveryComplete(IMqttDeliveryToken token) {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L77): `public static MqttHandler getInstance() {`
- [82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L82): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L108): `public void destroy() {`
- [111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L111): `public void closeClient(MqttClient client) {`
- [120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L120): `private void closeConnection(String connectionId) {`
- [129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L129): `private void register(String clientId, String connectionId, ClientInfo clientInfo) throws Exception {`
- [158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L158): `private MqttClient registerDevice(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- [186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L186): `private MqttClient registerPeer(String clientId, String connectionId, ClientInfo clientInfo) throws ServerException {`
- [201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L201): `private String getPeerInputTopicName(Peer peer) {`
- [205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L205): `public boolean deviceMessageArrived(String topic, byte[] bytes, String clientId) throws ClientException {`
- [228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L228): `public boolean messageArrived(String topic, byte[] bytes, String clientId) throws ClientException {`
- [240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L240): `public boolean connectionRequestArrived(String clientId, String connectionId, byte[] willMessageInBytes,String origin) throws ClientException {`
- [257](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L257): `public void connectionClosed(String connectionId) {`
- [266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L266): `private void removeClientFromServer(MqttClient mqttClient, int code) {`
- [275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L275): `public boolean subscriptionRequestArrived(List<MqttTopicSubscription> topicSubscriptions, String clientId, String connectionId,String origin) {`
- [338](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L338): `public boolean unsubscriptionRequestArrived(List<String> topicUnSubscriptions, String clientId, String connectionId,String origin) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.activemq.EmbeddedArtemisServer`, `com.nozha.async.server.activemq.vo.ClientInfo`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.MqttClient`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.model.DeviceRegistration`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.persistance.DeviceCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.MessageType`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.MessageVO`, `com.nozha.async.server.vo.MessageWrapperVO`, `io.netty.handler.codec.mqtt.MqttTopicSubscription`, `org.eclipse.paho.client.mqttv3.*`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.nio.charset.StandardCharsets`, `java.util.*`.
Configuration references: `KEYLEAD_API_TOKEN`, `MQTT_PORT`, `MQTT_SERVER_CLIENTID`, `MQTT_SERVER_DEVICE_INPUT_QUEUE_NAME`, `MQTT_SERVER_DEVICE_OUTPUT_QUEUE_NAME`, `MQTT_SERVER_INPUT_QUEUE_NAME`, `MQTT_SERVER_OUTPUT_QUEUE_NAME`, `OS_SERVER_NAME`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java:964](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L964): `MqttHandler.getInstance().connectionClosed(connectionID.toString());`
- [src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java:977](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L977): `MqttHandler.getInstance().connectionClosed(connectionID.toString());`
- [src/com/nozha/async/server/Server.java:136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L136): `handlers.add(MqttHandler.getInstance());`
- [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L31): `isValid = MqttHandler.getInstance().deviceMessageArrived(topic, bytes, connection.getClientID());`
- [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L35): `isValid = MqttHandler.getInstance().messageArrived(topic, bytes, connection.getClientID());`
- [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L40): `isValid = MqttHandler.getInstance().subscriptionRequestArrived(`
- [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L50): `isValid = MqttHandler.getInstance().connectionRequestArrived(`
- [src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/MQTTIncomingInterceptor.java#L60): `isValid = MqttHandler.getInstance().unsubscriptionRequestArrived(`
- [src/com/nozha/async/server/client/MqttClient.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L46): `MqttHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/client/MqttClient.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L52): `MqttHandler.getInstance().closeClient(this);`

## Business

SOURCE_OBSERVED: MQTT device/peer message bridge and related devices sharing inputqueue; connection will bytes carry registration details. Prefix-based subscription authorization is source-observed, not approved isolation guarantee.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

invalid client ServerException at161/165/172/194; register catches removes/rethrows; connectionRequest wraps ClientException losing message. JSON will parsing outside try may propagate unchecked. send MqttException/all Exception wrap ServerException and reconnect attempt logged without original reconnect exception; wait completion no explicit timeout. subscribe ServerException only warns; failed register can still return true. unsubscription prints exceptions. Test unauthorized prefix, unrelated topic suffix and broker reconnect.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L58): `} catch (MqttException e) {`
- [88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L88): `} catch (MqttException e) {`
- [95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L95): `} catch (MqttException e1) {`
- [99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L99): `throw new ServerException(e);`
- [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L101): `catch (Exception e){`
- [103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L103): `throw new ServerException(e);`
- [124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L124): `} catch (Exception e) {`
- [149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L149): `} catch (Exception e) {`
- [154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L154): `throw e;`
- [161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L161): `throw new ServerException("invalid client");`
- [165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L165): `throw new ServerException("invalid client");`
- [172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L172): `throw new ServerException("invalid client");`
- [194](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L194): `throw new ServerException("invalid client");`
- [250](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L250): `} catch (Exception e) {`
- [252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L252): `throw new ClientException();`
- [324](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L324): `} catch (ServerException e) {`
- [366](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L366): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Connection/client IDs and remote addresses are key correlation; payload callback ignored DEBUG is expected. No broker deliveryComplete ACK log.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L57) | ALOG-0D626D824E62 | INFO | `logger.info("Async subscribed to MQTT");` | `clientForAsync.connect(connOpt); / clientForAsync.subscribe(Settings.MQTT_SERVER_DEVICE_INPUT_QUEUE_NAME + "/+", 1); / clientForAsync.subscribe(Settings.MQTT_SERVER_INPUT_QUEUE_NAME + "/+", 1);` |
| [59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L59) | ALOG-6F37C994EAB8 | ERROR | `logger.error("An exception occurred in MqttHandler error=MqttException", e);` | `clientForAsync.subscribe(Settings.MQTT_SERVER_DEVICE_INPUT_QUEUE_NAME + "/+", 1); / clientForAsync.subscribe(Settings.MQTT_SERVER_INPUT_QUEUE_NAME + "/+", 1); / logger.info("Async subscribed to MQTT"); / } catch (MqttException e) {` |
| [65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L65) | ALOG-60335A2982DE | WARN | `logger.warn("MqttClient For Async Disconnected message=" + cause.getMessage() + " \n " + cause);` | `} / @Override / public void connectionLost(Throwable cause) {` |
| [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L70) | ALOG-8058F75836EC | DEBUG | `logger.debug("message arrived and ignored.");` | `} / @Override / public void messageArrived(String topic, MqttMessage message) throws Exception {` |
| [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L85) | ALOG-5E267191BCF5 | INFO | `logger.info("Call MqttHandler Send Message topic={}",mqttClient.getTopic());` | `@Override / public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException { / try { / MqttClient mqttClient = (MqttClient) client;` |
| [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L89) | ALOG-6DE99C27C120 | WARN | `logger.warn("An exception occurred in Mqtt Send Message", e);` | `logger.info("Call MqttHandler Send Message topic={}",mqttClient.getTopic()); / MqttDeliveryToken deliveryToken = mqttClient.getTopic().publish(new MqttMessage(outboundPayload.bytes())); / deliveryToken.waitForCompletion(); / } catch (MqttException e) {` |
| [92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L92) | ALOG-51DABE4E0B8F | ERROR | `logger.error("-*************MqttClient For Async Disconnected*******-");` | `} catch (MqttException e) { / logger.warn("An exception occurred in Mqtt Send Message", e); / if(!clientForAsync.isConnected()){ / try {` |
| [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L94) | ALOG-716E77EC9EDD | ERROR | `logger.error("-*************MqttClient For Async Reconnecting*******-");` | `if(!clientForAsync.isConnected()){ / try { / logger.error("-*************MqttClient For Async Disconnected*******-"); / clientForAsync.reconnect();` |
| [96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L96) | ALOG-EE9CC1A69022 | ERROR | `logger.error("-*************MqttClient For Async Not Reconnecting*******-");` | `logger.error("-*************MqttClient For Async Disconnected*******-"); / clientForAsync.reconnect(); / logger.error("-*************MqttClient For Async Reconnecting*******-"); / } catch (MqttException e1) {` |
| [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L102) | ALOG-0374BBE72549 | WARN | `logger.warn("An exception occurred in mqtt send message", e);` | `} / throw new ServerException(e); / } / catch (Exception e){` |
| [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L122) | ALOG-6A693226E18A | WARN | `logger.warn("close mqtt connection, connectionId={}",connectionId);` | `} / private void closeConnection(String connectionId) { / try {` |
| [125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L125) | ALOG-37CCE1BCB66C | WARN | `logger.warn("An exception occurred in close mqtt connection", e);` | `try { / logger.warn("close mqtt connection, connectionId={}",connectionId); / EmbeddedArtemisServer.getInstance().closeConnection(connectionId); / } catch (Exception e) {` |
| [147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L147) | ALOG-798109AFD552 | INFO | `logger.info("client registered: clientId={} ,peerId={} ,clientConnectionMap size={}", clientId, mqttClient.getPeer().getId(),clientConnectionMap.size());` | `clientIdConnectionMap.remove(mqttClient.getClientId()); / } / clientConnectionMap.put(connectionId, mqttClient); / clientIdConnectionMap.put(mqttClient.getClientId(),connectionId);` |
| [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L150) | ALOG-19E6E1B1DE69 | WARN | `logger.warn("An exception occurred in register mqtt client, clientId={}",mqttClient!=null?mqttClient.getClientId():"", e);` | `clientIdConnectionMap.put(mqttClient.getClientId(),connectionId); / logger.info("client registered: clientId={} ,peerId={} ,clientConnectionMap size={}", / clientId, mqttClient.getPeer().getId(),clientConnectionMap.size()); / } catch (Exception e) {` |
| [223](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L223) | ALOG-F7A22048528A | WARN | `logger.warn("device not registered clientId={}", clientId);` | `Server.getInstance().read(mqttClient, messageWrapperVO); / } else { / isValid = false;` |
| [235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L235) | ALOG-CC760CFE93A8 | WARN | `logger.warn("mqtt device not registered clientId={}", clientId);` | `if (mqttClient != null) { / Server.getInstance().read(mqttClient, new String(bytes, StandardCharsets.UTF_8)); / } else { / isValid = false;` |
| [241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L241) | ALOG-AF1DA6914F27 | INFO | `logger.info("on connect - clientId={}, connectionId={} ,remoteAddress={}", clientId, connectionId,origin);` | `return isValid; / } / public boolean connectionRequestArrived(String clientId, String connectionId, byte[] willMessageInBytes,String origin) throws ClientException {` |
| [251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L251) | ALOG-630BDF2030FF | WARN | `logger.warn("An exception occurred in register mqtt clientId={} ,connectionId={}",clientId,connectionId, e);` | `try { / register(clientId, connectionId, clientInfo); / isValid = true; / } catch (Exception e) {` |
| [260](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L260) | ALOG-02289EF13EB3 | WARN | `logger.warn("client connection closed connectionId={} clientId={}", connectionId,mqttClient.getClientId());` | `public void connectionClosed(String connectionId) { / MqttClient mqttClient = clientConnectionMap.get(connectionId); / if (mqttClient != null) {` |
| [263](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L263) | ALOG-8904A8F54774 | WARN | `logger.warn("mqtt connection closed connectionId={}", connectionId);` | `if (mqttClient != null) { / logger.warn("client connection closed connectionId={} clientId={}", connectionId,mqttClient.getClientId()); / removeClientFromServer(mqttClient, Server.DESTROY_STATUS_CLOSED); / }else` |
| [276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L276) | ALOG-24432BA69185 | INFO | `logger.info("on subscribe mqtt - clientId={}, connectionId={} ,remoteAddress={}", clientId, connectionId,origin);` | `Server.getInstance().removeClient(mqttClient, code); / } / public boolean subscriptionRequestArrived(List<MqttTopicSubscription> topicSubscriptions, String clientId, String connectionId,String origin) {` |
| [318](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L318) | ALOG-C7AE60E77157 | INFO | `logger.info("mqtt related client registered in subscribe request, clientId={} peerId={}", clientId, relatedClient.getPeer().getId());` | `relatedClients.add(relatedClient); / relatedClient.register(); / Server.getInstance().addClient(relatedClient); / clientMap.put(relatedClient.getClientId(), relatedClient);` |
| [325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L325) | ALOG-E3B8F02EABFB | WARN | `logger.warn("An exception occurred in mqtt client register in subscribe request",e);` | `mqttClient.setRelatedClients(relatedClients); / } / } catch (ServerException e) {` |
| [339](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L339) | ALOG-7C0FC4EBD463 | INFO | `logger.info("on unsubscribe mqtt - clientId={}, connectionId={} ,remoteAddress={}", clientId, connectionId,origin);` | `} / return isValid; / } / public boolean unsubscriptionRequestArrived(List<String> topicUnSubscriptions, String clientId, String connectionId,String origin) {` |
| [344](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L344) | ALOG-FA6626ED0647 | DEBUG | `logger.debug("on unsubscribe to: {}", topicName);` | `boolean isValid = true; / MqttClient mqttClient = clientMap.get(clientId); / if (mqttClient != null) { / for (String topicName : topicUnSubscriptions) {` |
| [357](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L357) | ALOG-8D4D6A47453F | DEBUG | `logger.debug("check unsubscribe to: {}, {}", topicName, clientTopic);` | `else / clientTopic = Settings.MQTT_SERVER_OUTPUT_QUEUE_NAME + "/" + mqttClient.getAddress();` |

Registry reconciliation: 26 rows for this file; 26 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Live console diagnostics (outside registry logger schema):

- [367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L367): `e.printStackTrace();`

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-outboundpayload

<!-- source dossier: src/com/nozha/async/server/handler/OutboundPayload.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayload.java#L1-L11
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# OutboundPayload — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 11 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Interface ([5–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayload.java#L5-L11)) bytes(), text() throws ServerException, expiry/sender/type metadata. ClientMessagePayload JSON/type0 and RawBytesPayload raw/type1 implement. Text-only transport casts are narrower than this interface.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: `com.nozha.async.server.exception.ServerException`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:826](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L826): `OutboundPayload payload = outboundPayloadFactory.from(message);`
- [src/com/nozha/async/server/handler/RawBytesPayload.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L5): `public class RawBytesPayload implements OutboundPayload {`
- [src/com/nozha/async/server/handler/MqttHandler.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L82): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/HandlerInterface.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HandlerInterface.java#L11): `void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException;`
- [src/com/nozha/async/server/handler/CoapHandler.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L87): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/ClientMessagePayload.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L6): `public class ClientMessagePayload implements OutboundPayload {`
- [src/com/nozha/async/server/handler/QueueHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L88): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/HttpHandler.java:339](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L339): `public void sendMessage(Client client, OutboundPayload outboundPayload) {`
- [src/com/nozha/async/server/handler/RestHandler.java:320](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L320): `public void sendMessage(Client client, OutboundPayload outboundPayload) {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L83): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/WebrtcHandler.java:75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L75): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/TcpHandler.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L73): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L8): `public OutboundPayload from(Message message) {`
- [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L9): `OutboundPayload payload;`
- [src/com/nozha/async/server/client/HttpClient.java:122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L122): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- [src/com/nozha/async/server/client/QueueClient.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L40): `public void sendMessage(OutboundPayload outboundPayload) throws ServerException {`
- 12 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

Supplemental semantic review of explicit member and nested-type boundaries:

- **getExpirationDate / getSender / getType** [8–10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayload.java#L8-L10): Abstract metadata methods return an absolute expiration timestamp, sender identity and payload discriminator. The implementations supply stored expiry/sender and type0 for ClientMessagePayload versus type1 for RawBytesPayload; the interface enforces no TTL guard or validation. Queue handlers/clients apply TTL and metadata policy downstream.

## Business

SOURCE_OBSERVED: Indirect common outbound format boundary enabling binary delivery through compatible clients.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path; text allows checked ServerException to reject binary conversion; implementations/callers decide handling.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; Factory, Server and transport error boundaries are diagnostics.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-outboundpayloadfactory

<!-- source dossier: src/com/nozha/async/server/handler/OutboundPayloadFactory.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L1-L20
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# OutboundPayloadFactory — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 20 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

from ([8–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L8-L19)) rejects null model, chooses RawBytesPayload when binaryContent!=null (including empty byte array), otherwise ClientMessagePayload(new ClientMessage(message)), copying expiry/sender metadata. No transformation or defensive copy of binary bytes.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L8): `public OutboundPayload from(Message message) {`

Source dependency imports: `com.nozha.async.server.model.Message`, `com.nozha.async.server.vo.ClientMessage`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L84): `private final OutboundPayloadFactory outboundPayloadFactory = new OutboundPayloadFactory();`

## Business

SOURCE_OBSERVED: Indirect chooses message format before protocol delivery; preserves binary content rather than JSON conversion.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit IllegalArgumentException("message is null") at11; constructors and ClientMessage conversion may propagate. Test null, empty binary and dual text/binary (binary takes precedence).

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L11): `throw new IllegalArgumentException("message is null");`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; Server owns factory and downstream send/exception logs.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-payload

<!-- source dossier: src/com/nozha/async/server/handler/Payload.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/Payload.java#L1-L9
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# Payload — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 9 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Sealed interface ([3–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/Payload.java#L3-L9)) permits records Text(String) and Binary(byte[]). Records generate accessors/equality/hash/toString; byte array retained without copy/content-based equality. Jetty adapter creates inbound variants; Server dispatches by sealed variant.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L326): `public void read(Client client, Payload frame) throws Exception {`
- [src/com/nozha/async/server/Server.java:328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L328): `case Payload.Text t -> {`
- [src/com/nozha/async/server/Server.java:336](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L336): `case Payload.Binary b -> {`
- [src/com/nozha/async/server/handler/WebsocketHandler.java:159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L159): `public void onInbound(AsyncWebSocketAdapter webSocket, Payload frame) {`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L38): `WebsocketHandler.getInstance().onInbound(this, new Payload.Text(message));`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L44): `WebsocketHandler.getInstance().onInbound(this, new Payload.Binary(message.readAllBytes()));`

## Business

SOURCE_OBSERVED: Indirect distinction of inbound JSON text vs raw bytes; not independent business routing.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No direct error path or null validation; binary mutable array is exposed; caller Server determines parse/registration effects.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; AsyncWebSocketAdapter/WebsocketHandler and Server are evidenced callers.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-queuehandler

<!-- source dossier: src/com/nozha/async/server/handler/QueueHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L1-L184
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# QueueHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 184 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton constructor starts monitor; queues synchronized map. Monitor constructor/endLoop/go/run/find ([42–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L42-L85)) optionally register synchronously then poll60s, parallel register rows after lastId, advance lastId even when registration fails. sendMessage ([88–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L88-L104)) absolute expiry must>now, calls queue.send and POD helper for ClientMessagePayload else logs ignore; all Exception wrap ServerException. register ([106–140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L106-L140)) if map absent selects four QueueRegistration types, register/add/store; unknown type silently skipped, partial failures remove client. removeRegistration removes ID. reconnect ([146–176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L146-L176)) synchronized old client, while active removes core client, if deactivated re-register and breaks even if register suppresses failure; otherwise sleeps60s/retries exceptions with interrupt swallowed. destroy stops monitor flag only, not connections/executor.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L32): `private QueueHandler() {`
- [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L38): `public static QueueHandler getInstance() {`
- [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L46): `MonitorRegistrations(String name) {`
- [55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L55): `public void run() {`
- [66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L66): `private void go() {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L73): `private void findAndRegister() {`
- [88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L88): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L106): `public void register(QueueRegistration queueRegistration) {`
- [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L142): `public void removeRegistration(QueueRegistration willRemoveItem) {`
- [146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L146): `public void reconnect(QueueClient client) {`
- [179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L179): `public void destroy() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.client.*`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.model.QueueRegistration`, `com.nozha.async.server.persistance.QueueCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.PODLogUtil`, `com.nozha.async.server.vo.ClientMessage`, `org.apache.logging.log4j.LogManager`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.util.Collections`, `java.util.HashMap`, `java.util.List`, `java.util.Map`.
Configuration references: `WAIT_FOR_REGISTRATION`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L132): `handlers.add(QueueHandler.getInstance());`
- [src/com/nozha/async/server/Server.java:871](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L871): `QueueHandler.getInstance().reconnect((QueueClient) client);`
- [src/com/nozha/async/server/Server.java:1196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1196): `QueueHandler.getInstance().reconnect((QueueClient) client);`
- [src/com/nozha/async/server/handler/ExceptionListener.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ExceptionListener.java#L17): `QueueHandler.getInstance().reconnect(client);`
- [src/com/nozha/async/server/biz/RegistrationManager.java:164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L164): `QueueHandler.getInstance().register(JsonUtil.getObject(messageWrapperVO.getContent(), QueueRegistration.class));`
- [src/com/nozha/async/server/client/QueueClient.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L41): `QueueHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/client/QueueClient.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/QueueClient.java#L48): `QueueHandler.getInstance().removeRegistration(queueRegistration);`

## Business

SOURCE_OBSERVED: Provider queue restoration, message send TTL gate and reconnect lifecycle. Poll lastId prevents auto retry of earlier failed registration absent another trigger; official resilience guarantee unknown.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Registration exceptions suppressed; send expiration rejection is warn/no exception. reconnect catches Exception and retries, nested InterruptedException logs original e. Monitor catches Throwable and continues. Test missing credentials, unsupported type, register failure after ID advance and concurrent registration.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L60): `} catch (Throwable e) {`
- [100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L100): `} catch (Exception e) {`
- [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L102): `throw new ServerException(e);`
- [130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L130): `} catch (Exception e) {`
- [164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L164): `} catch (Exception e) {`
- [168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L168): `} catch (InterruptedException e1) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

POD log occurs after queue.send returns, not provider ACK; map size is queues despite clientsMapByPeer template.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L33) | ALOG-9F3385517F57 | INFO | `logger.info("start queue handler");` | `private final Map<Long, QueueClient> queues = Collections.synchronizedMap(new HashMap<>()); / private MonitorRegistrations monitorRegistrations; / private QueueHandler() {` |
| [61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L61) | ALOG-96EB09A8EC9B | WARN | `logger.warn("An exception occurred in queueHandler MonitorRegistrations thread", e);` | `try { / findAndRegister(); / sleep(60000); / } catch (Throwable e) {` |
| [74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L74) | ALOG-3B1AED30425C | INFO | `logger.info("start to register new queues");` | `start(); / } / private void findAndRegister() {` |
| [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L77) | ALOG-1B2475D866DD | INFO | `logger.info("restoring queue client : " + queueRegistration.getPeerId());` | `private void findAndRegister() { / logger.info("start to register new queues"); / List<QueueRegistration> queueRegistrations = QueueCRUD.listQueueRegistration(lastId); / queueRegistrations.stream().parallel().forEach(queueRegistration -> {` |
| [82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L82) | ALOG-F46AA0839190 | WARN | `logger.warn("SizeOf  clientsMapByPeer={} after addClient", queues.size());` | `register(queueRegistration); / }); / if (!queueRegistrations.isEmpty()) { / lastId = queueRegistrations.get(queueRegistrations.size() - 1).getId();` |
| [98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L98) | ALOG-3234F4EDD386 | WARN | `logger.warn("send ignored diff=" + (expirationDuration - System.currentTimeMillis()));` | `if (outboundPayload instanceof ClientMessagePayload) { / PODLogUtil.logSendRequest(podLogger, ((ClientMessagePayload)outboundPayload).getClientMessage(), queueClient.getPeer().getName()); / } / } else {` |
| [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L101) | ALOG-29F2B0125E26 | WARN | `logger.warn("An exception occurred in sendMessage of queueHandler", e);` | `} else { / logger.warn("send ignored diff=" + (expirationDuration - System.currentTimeMillis())); / } / } catch (Exception e) {` |
| [110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L110) | ALOG-DEDEAA1273F0 | INFO | `logger.info("registering queue: type={}, in={}, out={}, add={}", queueRegistration.getType(), queueRegistration.getInputQueueName(), queueRegistration.getOutputQueueName(), queueRegistration.getServerUrl());` | `public void register(QueueRegistration queueRegistration) { / if (!queues.containsKey(queueRegistration.getId())) { / QueueClient queueClient = null; / try {` |
| [131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L131) | ALOG-FC90EFE07F13 | WARN | `logger.warn("An exception occurred in register queue for " + "input queue=" + queueRegistration.getInputQueueName() + " exception=", e);` | `Server.getInstance().addClient(queueClient); / queues.put(queueRegistration.getId(), queueClient); / } / } catch (Exception e) {` |
| [151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L151) | ALOG-FE577F73190C | INFO | `logger.info("SizeOf  clientsMapByPeer={} before reconnect for peerid={} peername={}  queueid={}  clientid={}", queues.size(), client.getPeer().getId(), client.getPeer().getName(), client.getQueueRegistration().getId(), client.getId());` | `synchronized (client) { / if (client.isActive()) { / do { / try {` |
| [158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L158) | ALOG-4724F0CDF136 | INFO | `logger.info("SizeOf  clientsMapByPeer={} after reconnect for peerid={}  peername={}  queueid={} clientid={}", queues.size(), client.getPeer().getId(), client.getPeer().getName(), client.getQueueRegistration().getId(), client.getId());` | `Server.getInstance().removeClient(client, Server.DESTROY_STATUS_REMOVED); / } / if (!client.isActive()) { / register(client.getQueueRegistration());` |
| [165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L165) | ALOG-6D5FCF298D12 | WARN | `logger.warn("An exception occurred. Trying to reconnect peerId=" + (client.getPeer() != null ? String.valueOf(client.getPeer().getId()) : "0"), e);` | `} else { / Thread.sleep(60000); / } / } catch (Exception e) {` |
| [169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L169) | ALOG-4F0045838832 | WARN | `logger.warn("An exception occurred on sleep. Trying to reconnect", e);` | `logger.warn("An exception occurred. Trying to reconnect peerId=" + (client.getPeer() != null ? String.valueOf(client.getPeer().getId()) : "0"), e); / try { / Thread.sleep(60000); / } catch (InterruptedException e1) {` |

Registry reconciliation: 13 rows for this file; 13 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-rawbytespayload

<!-- source dossier: src/com/nozha/async/server/handler/RawBytesPayload.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L1-L40
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RawBytesPayload — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 40 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([10–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L10-L14)) retains raw array/expiry/sender. bytes ([17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L17-L19)) returns original array, text ([22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L22-L24)) explicitly rejects, metadata getters direct/type1. No defensive copy.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L10): `public RawBytesPayload(byte[] raw, long expirationDate, long sender) {`
- [17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L17): `public byte[] bytes() {`
- [22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L22): `public String text() throws ServerException {`
- [27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L27): `public long getExpirationDate() {`
- [32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L32): `public long getSender() {`
- [37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L37): `public int getType() {`

Source dependency imports: `com.nozha.async.server.exception.ServerException`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L14): `payload = new RawBytesPayload(message.getBinaryContent(), message.getExpireDate(), message.getSender());`

## Business

SOURCE_OBSERVED: Indirect binary content carrier; usable by byte-capable JMS/TCP/MQTT/client sends but text-only handler casts may reject.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit ServerException("binary payload can not be represented as text") at23. Null raw accepted; downstream write may fail. Test text rejection and array mutation.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RawBytesPayload.java#L23): `throw new ServerException("binary payload can not be represented as text");`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS; factory/core and transport error handlers provide visibility.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-resthandler

<!-- source dossier: src/com/nozha/async/server/handler/RestHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L1-L672
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# RestHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 672 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton starts registration and recovery threads; trustedDomainNames ([56–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L56-L75)) allowlisted host skips hostname validation, others normalize scheme then DefaultHostnameVerifier. getService/getServiceFromPath ([81–116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L81-L116)) parse URI or fallback, exact/path-pattern match sorted by variable count/findAny, retry trailing slash. updateProvidersFileFromUrl ([118–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L118-L143)) download/hash info.version, replace file if changed, load map, delete temp; unchanged returns null. backupAndReplace copies (no backup). downloadSwagger ([153–174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L153-L174)) connect/read timeouts/temp file/disconnect. version hash defaults0; load provider ([188–295](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L188-L295)) reads JSON, rewrites basePath/host, path-global/method parameters, security authorization, x-policy flags, supported methods and trailing slash; persist mutations; returns provider/version hash. generateServiceParameter ([297–317](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L297-L317)) reads required/name/in, array/items/schema type. sendMessage ([320–340](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L320-L340)) parses GenericRequest, randomly selects active base; IllegalArgument→400 wrapper, others/no active log only. sendingRandomServer ([342–390](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L342-L390)) per-call timeout, Swagger base URL+URI or directURI, enqueue; response core.read wrapper; failure removes bad base and retries another (including non-idempotent calls), removes client when exhausted, otherwise synthetic -1/-999 error. Wrapper helpers ([392–449](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L392-L449)) preserve tracker/senderMessage, priority1/type3, reverse sender when tracker null, response body/code/headers comma split. Request builder ([451–485](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L451-L485)) optional JSON body, validates path/method when Swagger, mutates query/path; POST/PUT/DELETE else GET (PATCH/HEAD definitions accepted but sent GET). addHeader joins list strings; parameter substitution no URL encoding/required checking. register ([534–561](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L534-L561)) create/http/swagger/add/map or update existing; failures suppress/remove. destroy stops/interrupts threads. Monitor polls configured interval, parallel rows advancing lastId. Recovery periodically new default OkHttpClient GET per inactive base; HTTP200 alone reactivates, closes body, re-adds core if first active; failure/non200 remains inactive.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L56): `private RestHandler() {`
- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L67): `public boolean validateHostName(String host, SSLSession session) {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L77): `public static RestHandler getInstance() {`
- [81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L81): `private static Service getService(Map<String, Service> services, String uri) {`
- [103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L103): `private static Service getServiceFromPath(Map<String, Service> services, String path) {`
- [145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L145): `private static void backupAndReplaceSwagger(File oldFile, File newFile) throws IOException {`
- [153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L153): `private static File downloadSwagger(String peerName, String url) throws IOException {`
- [176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L176): `private static int getSwaggerVersionHash(File swaggerFile) {`
- [188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L188): `private static ServiceProvider getUpdatedService(File providerFile, RestClient restClient) {`
- [199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L199): `private static ServiceProvider loadProviderServicesFromFile(File swaggerFile, String newBasePath) {`
- [297](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L297): `private static ServiceParameter generateServiceParameter(JsonNode parameterNode) {`
- [320](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L320): `public void sendMessage(Client client, OutboundPayload outboundPayload) {`
- [342](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L342): `private void sendingRandomServer(RestClient client, GenericRequest genericRequest, ClientMessage clientMessage, int serverNumber) {`
- [358](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L358): `public void onResponse(@NotNull Call call, @NotNull Response response) {`
- [368](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L368): `public void onFailure(@NotNull Call call, @NotNull IOException e) {`
- [392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L392): `private void sendExceptionMessage(RestClient client, ClientMessage clientMessage, String message, int statusCode) {`
- [401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L401): `private MessageWrapperVO generateMessageWrapperVO(ClientMessage clientMessage, Response response) {`
- [406](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L406): `private MessageWrapperVO generateMessageWrapperVO(ClientMessage clientMessage, String message, int statusCode) {`
- [414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L414): `private MessageWrapperVO getMessageWrapperVO(ClientMessage clientMessage, GenericResponse genericResponse) {`
- [430](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L430): `private GenericResponse getGenericResponse(Response response) {`
- [451](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L451): `private Request.Builder getRequestFromGenericRequest(RestClient client, GenericRequest genericRequest) {`
- [487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L487): `private void addHeader(Request.Builder builder, GenericRequest request) {`
- [493](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L493): `private void setBodyAndQueryParameter(ServiceMethod serviceMethod, GenericRequest genericRequest) {`
- [522](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L522): `private ServiceMethod getServiceMethod(ServiceMethod[] serviceMethods, String method) {`
- [534](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L534): `public void register(RestRegistration restRegistration) {`
- [564](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L564): `public void destroy() {`
- [575](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L575): `MonitorRegistrations(String name) {`
- [584](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L584): `public void run() {`
- [595](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L595): `private void go() {`
- [602](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L602): `private void findAndRegister() {`
- [619](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L619): `RecoverServers(String name) {`
- [628](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L628): `public void run() {`
- [641](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L641): `private void isAvailable(RestClient client, String url) {`
- [648](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L648): `public void onResponse(@NotNull Call call, @NotNull Response response) {`
- [662](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L662): `public void onFailure(@NotNull Call call, @NotNull IOException e) {`

Source dependency imports: `com.fasterxml.jackson.databind.JsonNode`, `com.fasterxml.jackson.databind.node.ObjectNode`, `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.RestClient`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.mediation.generic.vo.*`, `com.nozha.async.server.model.RestRegistration`, `com.nozha.async.server.persistance.RestCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.MessageVO`, `com.nozha.async.server.vo.MessageWrapperVO`, `okhttp3.*`, `org.apache.commons.lang3.StringUtils`, `org.apache.http.conn.ssl.DefaultHostnameVerifier`, `org.jetbrains.annotations.NotNull`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `org.springframework.http.server.PathContainer`, `jakarta.servlet.http.HttpServletResponse`, `javax.net.ssl.SSLSession`, `java.io.File`, `java.io.IOException`, `java.io.InputStream`, `java.net.HttpURLConnection`, `java.net.URI`, `java.net.URL`, `java.nio.file.Files`, `java.nio.file.Paths`, `java.nio.file.StandardCopyOption`, `java.util.*`, `java.util.concurrent.TimeUnit`.
Configuration references: `REST_TRUSTED_DOMAINS`, `SERVICE_DESCRIPTORS_FOLDER`, `SLEEP_TIME_FOR_REPAIR_SERVER`, `SLEEP_TIME_FOR_REST_REGISTRATION`, `SWAGGER_CONNECT_TIMEOUT`, `SWAGGER_READ_TIMEOUT`, `WAIT_FOR_REGISTRATION`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L139): `handlers.add(RestHandler.getInstance());`
- [src/com/nozha/async/server/client/RestClient.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L77): `newBuilder.hostnameVerifier((hostname, session) -> RestHandler.getInstance().validateHostName(hostname, session));`
- [src/com/nozha/async/server/client/RestClient.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RestClient.java#L108): `RestHandler.getInstance().sendMessage(this, outboundPayload);`

Supplemental semantic review of explicit member and nested-type boundaries:

- **MonitorRegistrations.endLoop** [579–581](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L579-L581): Sets the plain loop flag false; no interrupt/join itself. Handler.destroy separately interrupts the thread after calling it.
- **RecoverServers.endLoop** [623–625](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L623-L625): Sets the recovery plain loop flag false; outstanding asynchronous probes are not canceled by this method. Handler.destroy separately interrupts the sleeping loop.

## Business

SOURCE_OBSERVED: Async-to-REST provider bridge with optional descriptors, random bases/failover and reply envelopes. Request-method downgrade, retry of writes and malformed descriptors can change provider effects; no approved idempotency policy or failover SLA.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Unknown method/path explicit IllegalArgumentException mapped400; Swagger update wraps Exception("not register") losing cause but prior log preserves. IO download rethrows; loader catches returns null; unchanged update null map assigned, version not updated on client in this class. Request/header/index/null errors caught outer except callback errors may escape. Response IOException→null GenericResponse; ClientException response send logged only. Availability InterruptedException terminates recovery; unchecked iteration failure escapes. No active base has no reply. Test PATCH/HEAD, unchanged descriptor, malformed required field, timeout on write and exhausted bases.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L90): `} catch (Exception e) {`
- [134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L134): `} catch (Exception ex) {`
- [136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L136): `throw new Exception("not register");`
- [165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L165): `} catch (Exception e) {`
- [167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L167): `throw e;`
- [291](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L291): `} catch (Exception ex) {`
- [328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L328): `} catch (IllegalArgumentException e) {`
- [332](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L332): `} catch (Exception e) {`
- [345](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L345): `.callTimeout(genericRequest.getTimeout(), TimeUnit.MILLISECONDS)`
- [362](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L362): `} catch (ClientException e) {`
- [376](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L376): `} catch (Exception ex) {`
- [396](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L396): `} catch (ClientException e1) {`
- [444](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L444): `} catch (IOException e) {`
- [466](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L466): `throw new IllegalArgumentException("method not found");`
- [468](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L468): `throw new IllegalArgumentException("path not found");`
- [545](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L545): `} catch (Exception e) {`
- [556](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L556): `} catch (Exception e) {`
- [589](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L589): `} catch (Throwable e) {`
- [636](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L636): `} catch (InterruptedException e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Download/update full URLs can include secrets; availability200 is HTTP reachability only; configured domain trust warning says untrusted even if normal verifier accepts.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L57) | ALOG-042D9EBEB5AD | INFO | `logger.info("start restServer handler............");` | `private final Random rand = new Random(); / private List<String> trustedDomainNames = new ArrayList<>(); / private RestHandler() {` |
| [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L73) | ALOG-DABC689F7650 | WARN | `logger.warn("Untrusted domain access attempt: " + host);` | `return true; / } / host = StringUtils.removeStart(host, "https://"); / host = StringUtils.removeStart(host, "http://");` |
| [92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L92) | ALOG-244D2C6DE991 | DEBUG | `logger.debug("Exception for uri:{}", uri);` | `URI uri1 = new URI(uri); / path = uri1.getPath(); / } catch (Exception e) { / path = uri;` |
| [129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L129) | ALOG-9F7C72C2F08A | INFO | `logger.info("Swagger file updated from URL: Name={} - URL={}", client.getPeer().getName(), client.getConfigFileUrl());` | `tempSwagger = downloadSwagger(client.getPeer().getName(), client.getConfigFileUrl()); / int newVersion = getSwaggerVersionHash(tempSwagger); / if (newVersion != oldVersion) { / backupAndReplaceSwagger(mainSwagger, tempSwagger);` |
| [132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L132) | ALOG-81ABEE8ADC90 | DEBUG | `logger.debug("Version did not change. Name={}", client.getPeer().getName());` | `backupAndReplaceSwagger(mainSwagger, tempSwagger); / logger.info("Swagger file updated from URL: Name={} - URL={}", client.getPeer().getName(), client.getConfigFileUrl()); / stringServiceMap = getUpdatedService(mainSwagger, client).getUriServiceMap(); / } else {` |
| [135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L135) | ALOG-A17FCA790904 | ERROR | `logger.error("Can not get/update swagger file. Name={} - URL={}", client.getPeer().getName(), client.getConfigFileUrl(), ex);` | `} else { / logger.debug("Version did not change. Name={}", client.getPeer().getName()); / } / } catch (Exception ex) {` |
| [140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L140) | ALOG-460E323B0005 | ERROR | `logger.error("Can not remove temp swagger file: {}", tempSwagger.getAbsoluteFile());` | `throw new Exception("not register"); / } / // remove temporary swagger file / if (!tempSwagger.delete()) {` |
| [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L155) | ALOG-F91C79747B05 | DEBUG | `logger.debug("Downloading swagger. Name={} - URL={}", peerName, url);` | `} / private static File downloadSwagger(String peerName, String url) throws IOException { / File tempSwagger;` |
| [166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L166) | ALOG-3A7B6600B97A | ERROR | `logger.error("An exception occurred in download swagger Name={} - URL={}", peerName, url, e);` | `tempSwagger = File.createTempFile(peerName + "Temp", ".json"); / Files.copy(in, Paths.get(tempSwagger.toURI()), StandardCopyOption.REPLACE_EXISTING); / } / } catch (Exception e) {` |
| [172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L172) | ALOG-91D303E7FF0B | DEBUG | `logger.debug("Download completed. Name={} - URL={}", peerName, url);` | `} finally { / if (connection != null) / connection.disconnect(); / }` |
| [194](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L194) | ALOG-27C7025401DF | ERROR | `logger.error("Can not read swagger file: {}", providerFile != null ? providerFile.getAbsolutePath() : "NULL");` | `if (providerFile != null && providerFile.exists() && providerFile.canRead()) { / String swaggerUIBasePath = restClient.getConfigFileUrl(); / provider = loadProviderServicesFromFile(providerFile, swaggerUIBasePath); / } else {` |
| [287](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L287) | ALOG-88AB33548468 | DEBUG | `logger.debug("Loaded: {}", swaggerFile.getAbsolutePath());` | `// persist modifications on JsonNode / JsonUtil.writeJsonObjectToFile(jsonNode, swaggerFile); / } / serviceProvider = new ServiceProvider(tempServiceMap, swaggerFile, version.hashCode());` |
| [289](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L289) | ALOG-38D6650B9185 | ERROR | `logger.error("Can not load swagger file: {}", (swaggerFile != null ? swaggerFile.getAbsolutePath() : "null"));` | `} / serviceProvider = new ServiceProvider(tempServiceMap, swaggerFile, version.hashCode()); / logger.debug("Loaded: {}", swaggerFile.getAbsolutePath()); / } else {` |
| [292](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L292) | ALOG-0F368C3776B5 | ERROR | `logger.error("Error while reading swagger file: " + (swaggerFile != null ? swaggerFile.getAbsolutePath() : "null"), ex);` | `} else { / logger.error("Can not load swagger file: {}", (swaggerFile != null ? swaggerFile.getAbsolutePath() : "null")); / } / } catch (Exception ex) {` |
| [329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L329) | ALOG-3FA264FB8723 | ERROR | `logger.error("IllegalArgumentException in sendMessage RestClient with id:{} , peerId:{}", restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1, e);` | `GenericRequest genericRequest = JsonUtil.getObject(clientMessage.getContent(), GenericRequest.class); / int serverNumber = rand.nextInt(restClient.getActiveServers().size()); / sendingRandomServer(restClient, genericRequest, clientMessage, serverNumber); / } catch (IllegalArgumentException e) {` |
| [333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L333) | ALOG-FEE8383B0D43 | ERROR | `logger.error("not send Message to RestClient with id:{} , peerId:{}", restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1, e);` | `logger.error("IllegalArgumentException in sendMessage RestClient with id:{} , peerId:{}", / restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1, e); / sendExceptionMessage(restClient, clientMessage, e.getMessage(), HttpServletResponse.SC_BAD_REQUEST); / } catch (Exception e) {` |
| [337](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L337) | ALOG-3BEAB13E2CBA | WARN | `logger.warn("can not send message because RestClient has no active server . id:{} , peerId:{}", restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1);` | `logger.error("not send Message to RestClient with id:{} , peerId:{}", / restClient.getId(), restClient.getPeer() != null ? restClient.getPeer().getId() : -1, e); / } / } else {` |
| [363](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L363) | ALOG-1C873A3EFCD7 | ERROR | `logger.error("An exception occurred in send response restClient {} {}", client.getId(), e.getMessage());` | `MessageWrapperVO messageWrapperVO = generateMessageWrapperVO(clientMessage, response); / try { / Server.getInstance().read(client, messageWrapperVO); / } catch (ClientException e) {` |
| [377](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L377) | ALOG-95254BADFF9C | ERROR | `logger.error("An exception occurred in sendMessage restClient {} {}", client.getId(), e.getMessage());` | `if (client.getActiveServers().size() > 0) { / try { / sendMessage(client, new ClientMessagePayload(clientMessage, clientMessage.getExpirationDate(), clientMessage.getSenderId())); / } catch (Exception ex) {` |
| [397](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L397) | ALOG-B5CA06382C8D | ERROR | `logger.error("An exception occurred in sendExceptionMessage restClient clientId:{} , error:{}", client.getId(), e1.getMessage());` | `MessageWrapperVO messageWrapperVO = generateMessageWrapperVO(clientMessage, message, statusCode); / try { / Server.getInstance().read(client, messageWrapperVO); / } catch (ClientException e1) {` |
| [446](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L446) | ALOG-7E2EEE4F7EA4 | ERROR | `logger.error("not Create generic Response", e);` | `genericResponse.setHeaders(map); / body.close(); / } catch (IOException e) { / genericResponse = null;` |
| [544](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L544) | ALOG-E0100E091F11 | INFO | `logger.info("registering rest: peerId:{} ,baseurl: {} ", restClient.getPeer().getId(), restRegistration.getBaseUrl());` | `restClient.setUriServiceMap(updateProvidersFileFromUrl(restClient)); / restClient.register(); / Server.getInstance().addClient(restClient); / rests.put(restRegistration.getId(), restClient);` |
| [546](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L546) | ALOG-BC8A55A8168B | ERROR | `logger.error("An exception occurred in register rest client ", e);` | `Server.getInstance().addClient(restClient); / rests.put(restRegistration.getId(), restClient); / logger.info("registering rest: peerId:{} ,baseurl: {} ", restClient.getPeer().getId(), restRegistration.getBaseUrl()); / } catch (Exception e) {` |
| [557](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L557) | ALOG-1149812F50DE | ERROR | `logger.error("can not Update swagger file for rest client id=" + restClient.getId(), e);` | `} else if (restClient.isSwagger()) { / try { / restClient.setUriServiceMap(updateProvidersFileFromUrl(restClient)); / } catch (Exception e) {` |
| [590](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L590) | ALOG-612A08EA3A10 | WARN | `logger.warn("An exception occurred", e);` | `try { / findAndRegister(); / sleep(Settings.SLEEP_TIME_FOR_REST_REGISTRATION); / } catch (Throwable e) {` |
| [603](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L603) | ALOG-2E520F8ED9F0 | INFO | `logger.info("start to register new restServer");` | `start(); / } / private void findAndRegister() {` |
| [606](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L606) | ALOG-33DD4AB15ED7 | INFO | `logger.info("restoring rest client : " + restRegistration.getPeerId());` | `private void findAndRegister() { / logger.info("start to register new restServer"); / List<RestRegistration> restRegistrations = RestCRUD.listRestRegistration(lastId); / restRegistrations.stream().parallel().forEach(restRegistration -> {` |
| [612](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L612) | ALOG-D48A587A15F5 | INFO | `logger.info("end of register new rests");` | `}); / if (!restRegistrations.isEmpty()) { / lastId = restRegistrations.get(restRegistrations.size() - 1).getId(); / }` |
| [637](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L637) | ALOG-9597C583A000 | ERROR | `logger.error("Exception in Servers Recovers thread", e);` | `isAvailable(client, url); / })); / } / } catch (InterruptedException e) {` |
| [650](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L650) | ALOG-E69421B3EFCB | DEBUG | `logger.debug("base url: {} is available for rest client id:{}  ", url, client.getId());` | `okHttpClient.newCall(request).enqueue(new Callback() { / @Override / public void onResponse(@NotNull Call call, @NotNull Response response) { / if (response.code() == 200) {` |
| [657](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L657) | ALOG-A127322EB64A | DEBUG | `logger.debug("base url: {} is not available for rest client id:{}  ", url, client.getId());` | `if (client.getActiveServers().size() == 1) { / Server.getInstance().addClient(client); / } / } else` |
| [663](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L663) | ALOG-38DB64D6025E | DEBUG | `logger.debug("base url: {} is not available for rest client id:{}  ", url, client.getId());` | `} / @Override / public void onFailure(@NotNull Call call, @NotNull IOException e) {` |

Registry reconciliation: 32 rows for this file; 32 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-servicecallproxy

<!-- source dossier: src/com/nozha/async/server/handler/ServiceCallProxy.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L1-L225
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# ServiceCallProxy — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 225 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Public constructor ([31–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L31-L74)) installs X509TrustManager with empty check methods and NoopHostnameVerifier, fixed dispatcher/pool settings and connect/read/call timeout; catches creation errors so null HTTP client possible. getInstance ([76–81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L76-L81)) unsynchronized lazy singleton. handleDoServiceCall sets wall start/UUID then fixed request. createRequest ([94–118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L94-L118)) JSON AppName ASYNC plus mobile/cards/useragent/device/platform/IP/language/email/amount/merchant/terminal params, configured ESB URL/ApiKey, RequestGUID and POST. sendRequest ([120–224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L120-L224)) pool active share>60 warning, business token ID fallback raw _token_, synchronous execute/body read; JSON ServiceCallLog upstream status/internal0 if200 else227; ResultSrv wraps raw result, first comma header values, upstream HTTP status in body fields, writes chunks/closes writer without setting servlet status. IOException logs synthetic408/internal flag and error ResultSrv227; finally closes downstream response.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L31): `public ServiceCallProxy() {`
- [36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L36): `public void checkClientTrusted(X509Certificate[] chain, String authType) {`
- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L41): `public void checkServerTrusted(X509Certificate[] chain, String authType) {`
- [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L46): `public X509Certificate[] getAcceptedIssuers() {`
- [76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L76): `public static ServiceCallProxy getInstance() {`
- [83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L83): `public void handleDoServiceCall(HttpServletRequest req, HttpServletResponse resp) {`
- [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L94): `private Request.Builder createRequest(HttpServletRequest req) {`
- [120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L120): `private void sendRequest(Request.Builder requestBuilder, HttpServletRequest req, HttpServletResponse resp) {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.mediation.hamsam.ResultSrv`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.log.ServiceCallLog`, `okhttp3.*`, `org.apache.http.conn.ssl.NoopHostnameVerifier`, `org.apache.logging.log4j.LogManager`, `javax.net.ssl.SSLContext`, `javax.net.ssl.SSLSocketFactory`, `javax.net.ssl.TrustManager`, `javax.net.ssl.X509TrustManager`, `jakarta.servlet.http.HttpServletRequest`, `jakarta.servlet.http.HttpServletResponse`, `java.io.IOException`, `java.security.SecureRandom`, `java.security.cert.X509Certificate`, `java.util.*`, `java.util.concurrent.Executors`, `java.util.concurrent.TimeUnit`.
Configuration references: `CLIENT_REQUEST_ID_KEY`, `ESB_END_POINT`, `RESPONSE_CHUNK_SIZE`, `SERVICE_CALL_API_KEY`, `SERVICE_CALL_POOL_SIZE`, `SERVICE_CALL_REQUEST_TIMEOUT`, `SERVICE_CALL_REST_DEFAULT_KEEP_ALIVE_TIMEOUT`, `SERVICE_CALL_REST_MAX_IDLE_CONNECTION`, `SERVICE_CALL_REST_MAX_REQUEST`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L49): `ServiceCallProxy.getInstance().handleDoServiceCall(req, resp);`

## Business

SOURCE_OBSERVED: Specific card/payment-shaped ESB proxy, not arbitrary mediation workflow. Upstream non200 reports provider unavailable inside body; synthetic408 is diagnostic classification, not proven network timeout or HTTP response status.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

All constructor exceptions suppressed; TLS cert/host validation deliberately bypassed. IOException includes connection/read/write failures; now/requestStartTime assigned only after body read so failed duration often0 (or inconsistent after later writer error). Error write IOException wraps RuntimeException. Null body assert only if JVM assertions enabled, otherwise NPE uncaught. Invalid endpoint/request creation and null client are unchecked outside IO catch. No explicit retry policy beyond OkHttp defaults.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L67): `.connectTimeout(Settings.SERVICE_CALL_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L68): `.readTimeout(Settings.SERVICE_CALL_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)`
- [69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L69): `.callTimeout(Settings.SERVICE_CALL_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)`
- [71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L71): `} catch (Exception e) {`
- [188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L188): `} catch (IOException e) {`
- [217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L217): `} catch (IOException ex) {`
- [218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L218): `throw new RuntimeException(ex);`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

SCLOG pool/business ID/error, SCJSONLOG ServiceCallLog. Business ID fallback logs raw token, privacy risk; upstream code vs servlet status differs. JSON emitted before client writer succeeds.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L72) | ALOG-BC5ED39DBE3D | ERROR | `scLogger.error("exception in create instance", e);` | `.readTimeout(Settings.SERVICE_CALL_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS) / .callTimeout(Settings.SERVICE_CALL_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS) / .build(); / } catch (Exception e) {` |
| [127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L127) | ALOG-D671D0636775 | WARN | `scLogger.warn("service call connection pool used more than 60 percent currentUsage = {}", usagePercentage);` | `? ((double) (pool.connectionCount() - pool.idleConnectionCount()) / pool.connectionCount()) * 100 / : 0; / if (usagePercentage > 60) {` |
| [134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L134) | ALOG-2094AB360868 | INFO | `scLogger.info("handle service call proxy businessId= {}", businessId);` | `String businessId = KeyleadUtil.getBusinessIdFromToken(req); / if (businessId == null) { / businessId = req.getHeader("_token_"); / }` |
| [147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L147) | ALOG-363FF9A25CB8 | INFO | `scJsonLogger.info(new ServiceCallLog( (now - requestStartTime), response.code(), response.code() == 200 ? 0 : 227, (String) req.getAttribute("UUID"), businessId));` | `responseBody = response.body().string(); / now = System.currentTimeMillis(); / requestStartTime = (Long) req.getAttribute("start_time");` |
| [189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L189) | ALOG-D6BEAD436761 | ERROR | `scLogger.error("exception in proxy service call uuid= " + req.getAttribute("UUID") + " exception", e);` | `start += length; / } / resp.getWriter().close(); / } catch (IOException e) {` |
| [190](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L190) | ALOG-521396233883 | INFO | `scJsonLogger.info(new ServiceCallLog( (now - requestStartTime), 408, response != null && response.code() == 200 ? 0 : 227, (String) req.getAttribute("UUID"), businessId));` | `} / resp.getWriter().close(); / } catch (IOException e) { / scLogger.error("exception in proxy service call uuid= " + req.getAttribute("UUID") + " exception", e);` |

Registry reconciliation: 6 rows for this file; 6 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-tcphandler

<!-- source dossier: src/com/nozha/async/server/handler/TcpHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L1-L282
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# TcpHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 282 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Constructor ([44–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L44-L66)) fixed opening executor, bind TCP_LISTENING_PORT retry every2s until TCP_READ_TIMEOUT then suppress fatal; starts listener. sendMessage writes ByteUtil length prefix/raw bytes/flush. register ([90–157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L90-L157)) socket keepalive, load gate, read prefix and exact payload with timeouts/EOF invalid input, allocates before positive-length check, parse PeerInfo/checkPeer, writes DEVICE_REGISTER response, clears timeout, sets/registers peer, optional refresh, starts Reader and core add; rollback destroy/endLoop. destroy closes server/flags readers but no executor shutdown. Listener ([171–193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L171-L193)) accepts and submits register, catches IOException. Reader ([195–281](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L195-L281)) loop with TCP_CLIENT_TIMEOUT age/socket wait, read prefix/full frame at TCP_READ_TIMEOUT, EOF ends, UTF8 core.read, finally readers.remove and core.remove MESSAGING. Reader endLoop closes socket; comments disable direct seen refresh.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L44): `private TcpHandler() {`
- [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L68): `public static TcpHandler getInstance() {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L73): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L83): `private void writeData(OutputStream outputStream, byte[] bytes) throws IOException {`
- [90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L90): `public void register(Socket socket) {`
- [159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L159): `public void destroy() {`
- [178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L178): `Listener(String name) {`
- [183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L183): `public void run() {`
- [199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L199): `Reader(TcpClient client, String name) {`
- [214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L214): `public void run() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.biz.LoadManager`, `com.nozha.async.server.biz.RegistrationManager`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.TcpClient`, `com.nozha.async.server.exception.ClientException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.util.ByteUtil`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.MessageType`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.PeerInfoVO`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.io.IOException`, `java.io.InputStream`, `java.io.OutputStream`, `java.net.ServerSocket`, `java.net.Socket`, `java.nio.charset.StandardCharsets`, `java.util.Collections`, `java.util.HashMap`, `java.util.Map`, `java.util.concurrent.ExecutorService`, `java.util.concurrent.Executors`.
Configuration references: `TCP_CLIENT_TIMEOUT`, `TCP_LISTENING_PORT`, `TCP_READ_TIMEOUT`, `TCP_THREAD_POOL_SIZE`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L156): `handlers.add(TcpHandler.getInstance());`
- [src/com/nozha/async/server/client/TcpClient.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L69): `TcpHandler.getInstance().sendMessage(this, outboundPayload);`

## Business

SOURCE_OBSERVED: Custom length-prefixed TCP peer registration and messaging; framing allocation is unbounded by explicit max in class. Presence of length prefix does not establish documented wire-version stability.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit ServerException("invalid input") on EOF/length<=0; read inactivity IOException("tcp client timeout peerId="+id). Register all Exception suppressed/cleanup, reader catches IOException|ClientException then removes; unchecked negative length/OOM differ and finally still runs for runtime exceptions. Bind failure can leave singleton unusable; shutdown IO warns. Test partial frames, huge/negative length, idle socket and occupied port.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L54): `} catch (IOException e) {`
- [57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L57): `throw e;`
- [63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L63): `} catch (Exception e) {`
- [77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L77): `} catch (Exception e) {`
- [79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L79): `throw new ServerException(e);`
- [101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L101): `socket.setSoTimeout(Settings.TCP_READ_TIMEOUT);`
- [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L106): `throw new ServerException("invalid input");`
- [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L112): `throw new ServerException("invalid input");`
- [122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L122): `throw new ServerException("invalid input");`
- [127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L127): `throw new ServerException("invalid input");`
- [133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L133): `socket.setSoTimeout(0);`
- [144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L144): `} catch (Exception e) {`
- [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L150): `} catch (IOException ignored) {`
- [162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L162): `} catch (IOException e) {`
- [188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L188): `} catch (IOException e) {`
- [208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L208): `} catch (IOException e) {`
- [219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L219): `client.getSocket().setSoTimeout(Settings.TCP_CLIENT_TIMEOUT);`
- [221](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L221): `throw new IOException("tcp client timeout peerId=" + client.getPeer().getId());`
- [237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L237): `client.getSocket().setSoTimeout(Settings.TCP_READ_TIMEOUT);`
- [274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L274): `} catch (IOException | ClientException e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Reader peer logs not client/frame IDs; accept error may repeat after close until flag visible.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L51) | ALOG-28E5AAAB2836 | INFO | `logger.info("TCP Listening on: {}:{}", serverSocket.getInetAddress().getHostAddress(), serverSocket.getLocalPort());` | `long time = System.currentTimeMillis(); / do { / try { / this.serverSocket = new ServerSocket(Settings.TCP_LISTENING_PORT);` |
| [55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L55) | ALOG-FF01BFD57EBD | WARN | `logger.warn("An exception occurred in start TCP server", e);` | `logger.info("TCP Listening on: {}:{}", serverSocket.getInetAddress().getHostAddress(), serverSocket.getLocalPort()); / listener.start(); / break; / } catch (IOException e) {` |
| [60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L60) | ALOG-99D04676532A | WARN | `logger.warn("Try to retry start TCP server");` | `if (System.currentTimeMillis() - time > Settings.TCP_READ_TIMEOUT) { / throw e; / } / Thread.sleep(2000);` |
| [64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L64) | ALOG-6AF9D5A015AC | ERROR | `logger.error("An exception occurred in tcpHandler", e);` | `logger.warn("Try to retry start TCP server"); / } / } while (true); / } catch (Exception e) {` |
| [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L78) | ALOG-825528E731D0 | WARN | `logger.warn("An exception occurred in tcpHandler sendMessage", e);` | `TcpClient tcpClient = (TcpClient) client; / try { / writeData(tcpClient.getOutputStream(), outboundPayload.bytes()); / } catch (Exception e) {` |
| [145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L145) | ALOG-11A3FE22C29E | WARN | `logger.warn("An exception occurred in register of tcpHandler", e);` | `readers.put(client.getId(), reader); / reader.start(); / Server.getInstance().addClient(client); / } catch (Exception e) {` |
| [148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L148) | ALOG-A97FA96929C6 | ERROR | `logger.error("TCP Client Destroy Call 8 ");` | `} catch (Exception e) { / logger.warn("An exception occurred in register of tcpHandler", e); / if (client != null) { / try {` |
| [163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L163) | ALOG-E2DC1557D5A4 | WARN | `logger.warn("An exception occurred in destroy tcpHandler", e);` | `public void destroy() { / try { / this.serverSocket.close(); / } catch (IOException e) {` |
| [189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L189) | ALOG-5F1F99C322AD | WARN | `logger.warn("An exception occurred in tcpHandler listener thread={}",this.getName(), e);` | `try { / final Socket accept = serverSocket.accept(); / executor.execute(() -> register(accept)); / } catch (IOException e) {` |
| [209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L209) | ALOG-5DAAFA8F78DC | DEBUG | `logger.debug("An exception occurred in tcpHandler reader thread={}",this.getName(), e);` | `this.loop = false; / try { / client.getSocket().close(); / } catch (IOException e) {` |
| [275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L275) | ALOG-4AB31696309C | WARN | `logger.warn("An exception occurred for tcp client peerId=" + client.getPeer().getId(), e);` | `String msg = new String(buffer, StandardCharsets.UTF_8); / Server.getInstance().read(client, msg); / } / } catch (IOException \| ClientException e) {` |

Registry reconciliation: 11 rows for this file; 11 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-handler-webrtchandler

<!-- source dossier: src/com/nozha/async/server/handler/WebrtcHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L1-L286
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# WebrtcHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 286 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton ([27–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L27-L50)) starts pending and registered expiry monitors; three maps, configured node subdomain. register ([56–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L56-L72)) sends DEVICE_REGISTER, removes pending, core.add and registered map; failure finalize and throw. send ([75–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L75-L94)) text cast, allow registered or registration frame, JSON/channel send. destroy flags monitors. onRegister ([102–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L102-L122)) creates client before try, generated device ID, maps pending/all, await SDP answer and writes SdpAnswerResponse including subdomain; failure finalize and HTTP500. sendErrorToClient false ResultVO. get/add ICE ([132–174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L132-L174)) find client, drain synchronized ICE list into response, absent401 false content client not registered peer; exceptions only logs. onClose ([176–183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L176-L183)) removes all/registered and core CLOSED, does not remove pending there. onMessage core.read or finalize messaging on exception; get/remove maps access. Pending monitor ([211–246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L211-L246)) creation+SERVER_EXPIRE_DELAY, logs/removes pending, finalize expired every20s. Registered monitor ([249–285](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L249-L285)) lastSeen+WEBRTC_EXPIRE_TIMEOUT, finalize expired, configured sleep.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L38): `private WebrtcHandler() {`
- [52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L52): `public static WebrtcHandler getInstance() {`
- [56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L56): `public void register(WebrtcClient client) throws ServerException {`
- [75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L75): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L97): `public void destroy() {`
- [102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L102): `public void onRegister(HttpServletRequest req, HttpServletResponse resp, String offer) throws IOException {`
- [124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L124): `public void sendErrorToClient(HttpServletResponse resp, String message, int statusCode) throws IOException {`
- [132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L132): `public void onGetIceCandidate(HttpServletRequest req, HttpServletResponse resp) {`
- [154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L154): `public void onAddIceCandidate(HttpServletResponse resp, Long clientId, IceCandidate iceCandidate) {`
- [176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L176): `public void onClose(WebrtcClient client, int code, String message) {`
- [185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L185): `public void onMessage(WebrtcClient client, String msg) {`
- [205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L205): `public void removeClient(WebrtcClient webrtcClient) {`
- [220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L220): `public void run() {`
- [258](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L258): `public void run() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.WebrtcClient`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.httpserver.vo.ResultVO`, `com.nozha.async.server.model.IceCandidate`, `com.nozha.async.server.model.IceCandidatesResponse`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.model.SdpAnswerResponse`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.MessageType`, `com.nozha.async.server.vo.ClientMessage`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `jakarta.servlet.http.HttpServletRequest`, `jakarta.servlet.http.HttpServletResponse`, `java.io.IOException`, `java.nio.charset.StandardCharsets`, `java.util.*`, `java.util.concurrent.ConcurrentHashMap`.
Configuration references: `SERVER_EXPIRE_DELAY`, `SERVER_ID`, `WEBRTC_DOMAIN_POSTFIX`, `WEBRTC_DOMAIN_PREFIX`, `WEBRTC_EXPIRE_THREAD_DELAY`, `WEBRTC_EXPIRE_TIMEOUT`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L200): `handlers.add(WebrtcHandler.getInstance());`
- [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L31): `WebrtcHandler.getInstance().onGetIceCandidate(req, resp);`
- [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L42): `WebrtcHandler.getInstance().onRegister(req, resp, sdpOffer.getOffer());`
- [src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterWebrtcServlet.java#L45): `WebrtcHandler.getInstance().onAddIceCandidate(resp, addIceCandidate.getClientId(), addIceCandidate.getCandidate());`
- [src/com/nozha/async/server/client/WebrtcClient.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L71): `WebrtcHandler.getInstance().register(this);`
- [src/com/nozha/async/server/client/WebrtcClient.java:91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L91): `WebrtcHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/client/WebrtcClient.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L99): `WebrtcHandler.getInstance().removeClient(this);`
- [src/com/nozha/async/server/client/WebrtcClient.java:189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L189): `WebrtcHandler.getInstance().onMessage(this, m);`
- [src/com/nozha/async/server/client/WebrtcClient.java:219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L219): `WebrtcHandler.getInstance().onClose(this, code, message);`
- [src/com/nozha/async/server/client/WebrtcClient.java:267](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L267): `WebrtcHandler.getInstance().onClose(this, finalizeStatusCode, "onClose datachannel");`

Supplemental semantic review of explicit member and nested-type boundaries:

- **getClients** [201–203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L201-L203): Returns the live ConcurrentHashMap-backed clientMap directly, permitting caller mutation; it does not snapshot pending or registered maps or assert registration readiness.

## Business

SOURCE_OBSERVED: WebRTC HTTP bootstrap→channel registration→messages with pending/idle expiry. Client ID alone addresses ICE endpoint here; any authorization outside method unknown.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

ServerException registration not confirmed [+peerId] on registration/send gate; send wraps failure. SDP construction outside onRegister try can escape; nested response error RuntimeException. ICE bad clientId/errors logs may leave HTTP200, absent explicitly401. onMessage catch logging assumes peer nonnull and can mask original. Monitors catch Exception continue; flag nonvolatile/no join. Test late SDP, expired pending and ICE missing client.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L47): `} catch (Exception e) {`
- [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L67): `} catch (Exception e) {`
- [70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L70): `throw new ServerException("client registration not confirmed " + peerId);`
- [84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L84): `} catch (Exception e) {`
- [87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L87): `throw new ServerException(e);`
- [91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L91): `throw new ServerException("client registration not confirmed");`
- [112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L112): `} catch (Exception e) {`
- [117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L117): `} catch (Exception ex) {`
- [118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L118): `throw new RuntimeException(ex);`
- [125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L125): `resp.setStatus(statusCode);`
- [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L142): `resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);`
- [148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L148): `} catch (Exception e) {`
- [165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L165): `resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);`
- [171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L171): `} catch (Exception e) {`
- [192](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L192): `} catch (Exception e) {`
- [241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L241): `} catch (Exception e) {`
- [280](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L280): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Correlate clientId/peerId/subdomain/node and create-answer logs; creation/registration frames do not prove ICE connectivity.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L39) | ALOG-23B23A4DA220 | DEBUG | `logger.debug("webrtc handler started");` | `private final MonitorExpiredWebrtc monitorExpiredWebrtc = new MonitorExpiredWebrtc(); / private static final String subDomain = Settings.WEBRTC_DOMAIN_PREFIX + Settings.SERVER_ID + Settings.WEBRTC_DOMAIN_POSTFIX; / private WebrtcHandler() {` |
| [48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L48) | ALOG-AE1686D76CFA | ERROR | `logger.error("An exception occurred", e);` | `monitorExpiredWebrtc.setName("WebrtcHandler.MonitorExpiredWebrtc"); / monitorExpiredWebrtc.start(); / } catch (Exception e) {` |
| [64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L64) | ALOG-5D0F556697AB | INFO | `logger.info("webrtcHandler size of notRegisteredClientMap {}", notRegisteredClientMap.size());` | `Peer peer = client.getPeer(); / peerId = peer.getId(); / sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)); / notRegisteredClientMap.remove(key);` |
| [68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L68) | ALOG-6B065FD6BA9D | WARN | `logger.warn("webrtcHandler an exception occurred for peerId: " + peerId, e);` | `logger.info("webrtcHandler size of notRegisteredClientMap {}", notRegisteredClientMap.size()); / Server.getInstance().addClient(client); / registeredClientMap.put(key, client); / } catch (Exception e) {` |
| [78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L78) | ALOG-5C20A5CEA9AE | DEBUG | `logger.debug("send message before");` | `@Override / public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException { / WebrtcClient webrtcClient = (WebrtcClient) client; / ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();` |
| [85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L85) | ALOG-C66EC543C7BC | WARN | `logger.warn("webrtc send message exception for peerId: " + client.getPeer().getId(), e);` | `try { / json = JsonUtil.getJson(clientMessage); / webrtcClient.send(json); / } catch (Exception e) {` |
| [86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L86) | ALOG-756980202657 | WARN | `logger.warn("webrtc send message exception for peerId: {}, address:{}", client.getPeer().getId(), webrtcClient.getAddress());` | `json = JsonUtil.getJson(clientMessage); / webrtcClient.send(json); / } catch (Exception e) { / logger.warn("webrtc send message exception for peerId: " + client.getPeer().getId(), e);` |
| [89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L89) | ALOG-C584EF43C947 | DEBUG | `logger.debug("onSendMessage peerId:{}", client.getPeer().getId());` | `logger.warn("webrtc send message exception for peerId: " + client.getPeer().getId(), e); / logger.warn("webrtc send message exception for peerId: {}, address:{}", client.getPeer().getId(), webrtcClient.getAddress()); / throw new ServerException(e); / }` |
| [93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L93) | ALOG-BB93AB52C0E1 | DEBUG | `logger.debug("send message after");` | `logger.debug("onSendMessage peerId:{}", client.getPeer().getId()); / } else { / throw new ServerException("client registration not confirmed"); / }` |
| [106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L106) | ALOG-E0BECACF3DAD | INFO | `logger.info("onRegister webrtc clientId={} deviceId={}", webrtcClient.getId(), deviceId);` | `public void onRegister(HttpServletRequest req, HttpServletResponse resp, String offer) throws IOException { / WebrtcClient webrtcClient = new WebrtcClient(req); / try { / String deviceId = UUID.randomUUID().toString() + (System.currentTimeMillis() + System.nanoTime());` |
| [113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L113) | ALOG-8A9E7A9D4E98 | ERROR | `logger.error("An exception occurred, client rejected clientId={}", webrtcClient.getId(), e);` | `String sdpAnswer = webrtcClient.createSdpAnswer(offer); / SdpAnswerResponse sdpAnswerResponse = new SdpAnswerResponse(webrtcClient.getId(), deviceId, sdpAnswer, subDomain); / resp.getOutputStream().write(JsonUtil.getJson(sdpAnswerResponse).getBytes()); / } catch (Exception e) {` |
| [133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L133) | ALOG-19B4523345DF | DEBUG | `logger.debug("onGetIceCandidate");` | `resp.getOutputStream().write(JsonUtil.getJson(response).getBytes(StandardCharsets.UTF_8)); / } / public void onGetIceCandidate(HttpServletRequest req, HttpServletResponse resp) {` |
| [141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L141) | ALOG-966F079240BE | WARN | `logger.warn("onGetIceCandidate : clientId ={} not found in notRegisteredClientMap , serverId={}", req.getParameter("clientId"), Settings.SERVER_ID);` | `List<IceCandidate> iceCandidates = new ArrayList<>(webrtcClient.getIceCandidates()); / webrtcClient.getIceCandidates().clear(); / resp.getOutputStream().write(JsonUtil.getJson(new IceCandidatesResponse(iceCandidates)).getBytes(StandardCharsets.UTF_8)); / } else {` |
| [149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L149) | ALOG-E8324FFCDA46 | WARN | `logger.warn("An exception occurred, client rejected: ", e);` | `response.setContent("client not registered peer"); / resp.getOutputStream().write(JsonUtil.getJson(response).getBytes(StandardCharsets.UTF_8)); / } / } catch (Exception e) {` |
| [150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L150) | ALOG-2849D7A1EA27 | INFO | `logger.info("Client rejected");` | `resp.getOutputStream().write(JsonUtil.getJson(response).getBytes(StandardCharsets.UTF_8)); / } / } catch (Exception e) { / logger.warn("An exception occurred, client rejected: ", e);` |
| [155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L155) | ALOG-A4CD368C3089 | DEBUG | `logger.debug("onPutIceCandidate");` | `} / } / public void onAddIceCandidate(HttpServletResponse resp, Long clientId, IceCandidate iceCandidate) {` |
| [164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L164) | ALOG-58761224FEC5 | WARN | `logger.warn("onAddIceCandidate : clientId ={} not found in notRegisteredClientMap , serverId={}", clientId, Settings.SERVER_ID);` | `List<IceCandidate> iceCandidates = new ArrayList<>(webrtcClient.getIceCandidates()); / webrtcClient.getIceCandidates().clear(); / resp.getOutputStream().write(JsonUtil.getJson(new IceCandidatesResponse(iceCandidates)).getBytes(StandardCharsets.UTF_8)); / } else {` |
| [172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L172) | ALOG-F6A5821BFCEC | ERROR | `logger.error("An exception occurred, client rejected: clientId={} ", clientId, e);` | `response.setContent("client not registered peer"); / resp.getOutputStream().write(JsonUtil.getJson(response).getBytes(StandardCharsets.UTF_8)); / } / } catch (Exception e) {` |
| [177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L177) | ALOG-98C1BB68C70A | INFO | `logger.info("onClose: clientId:{} ,peerId: {}, code: {}", client.getId(), client.getPeer() != null ? client.getPeer().getId() : -1, code);` | `} / } / public void onClose(WebrtcClient client, int code, String message) {` |
| [188](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L188) | ALOG-6DF093DA46B0 | DEBUG | `logger.debug("message peer: {}", client.getPeer().getId());` | `public void onMessage(WebrtcClient client, String msg) { / if (client != null) { / if (client.getPeer() != null) {` |
| [193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L193) | ALOG-5AC1AFD4DAE8 | WARN | `logger.warn("onMessage exception errorMessage: {}, peerId: {}", e.getMessage(), client.getPeer().getId());` | `} / try { / Server.getInstance().read(client, msg); / } catch (Exception e) {` |
| [197](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L197) | ALOG-627831E190F1 | DEBUG | `logger.debug("not exists peer");` | `logger.warn("onMessage exception errorMessage: {}, peerId: {}", e.getMessage(), client.getPeer().getId()); / client.finalize(Server.DESTROY_STATUS_MESSAGING); / } / } else {` |
| [215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L215) | ALOG-EFA2802B9C33 | INFO | `logger.info("End MonitorExpireNotRegistered webrtc Thread");` | `private class MonitorExpireNotRegistered extends Thread { / private boolean loop = true; / void endLoop() {` |
| [230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L230) | ALOG-DA4D6F26FCB0 | INFO | `logger.info("removing pending webrtc, clientMap size: {} , pending clients: {} ", clientMap.size(), toBeRemove.size());` | `if (now > client.getCreationTime() + Settings.SERVER_EXPIRE_DELAY) { / toBeRemove.add(k); / } / });` |
| [235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L235) | ALOG-D55427634FBD | WARN | `logger.warn("remove client in pending webrtc clientId:{} , peerId:{}", k, removed.getPeer() != null ? removed.getPeer().getId() : -1);` | `toBeRemove.forEach(k -> { / WebrtcClient removed = clientMap.get(k); / notRegisteredClientMap.remove(k); / if (removed != null) {` |
| [238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L238) | ALOG-F51B5941F5A3 | WARN | `logger.warn("pending clientId:{} not found in clientMap", k);` | `if (removed != null) { / logger.warn("remove client in pending webrtc clientId:{} , peerId:{}", k, removed.getPeer() != null ? removed.getPeer().getId() : -1); / removed.finalize(Server.DESTROY_STATUS_REMOVED_EXPIRED); / } else` |
| [242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L242) | ALOG-BE9137F13173 | ERROR | `logger.error("An exception occurred MonitorExpireNotRegistered webrtc", e);` | `logger.warn("pending clientId:{} not found in clientMap", k); / }); / sleep(20000); / } catch (Exception e) {` |
| [253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L253) | ALOG-EB3BEE181681 | INFO | `logger.info("End MonitorExpiredWebrtc Thread");` | `private class MonitorExpiredWebrtc extends Thread { / private boolean loop = true; / void endLoop() {` |
| [268](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L268) | ALOG-52285DD2F083 | INFO | `logger.info("removing expired webrtc, clientMap size: {} , expired clients: {} ", clientMap.size(), toBeRemove.size());` | `if (now > client.getLastSeenTime() + Settings.WEBRTC_EXPIRE_TIMEOUT) { / toBeRemove.add(k); / } / });` |
| [272](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L272) | ALOG-586FFBBB2E91 | WARN | `logger.warn("remove client in expired webrtc peerId:{}", removed.getPeer() != null ? removed.getPeer().getId() : -1);` | `logger.info("removing expired webrtc, clientMap size: {} , expired clients: {} ", clientMap.size(), toBeRemove.size()); / toBeRemove.forEach(k -> { / WebrtcClient removed = clientMap.get(k); / if (removed != null) {` |
| [275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L275) | ALOG-010B4EE60D76 | WARN | `logger.warn("expired clientId:{} not found in clientMap", k);` | `if (removed != null) { / logger.warn("remove client in expired webrtc peerId:{}", removed.getPeer() != null ? removed.getPeer().getId() : -1); / removed.finalize(Server.DESTROY_STATUS_REMOVED_EXPIRED); / } else {` |
| [281](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L281) | ALOG-2DBF82A89A45 | ERROR | `logger.error("An exception occurred in MonitorExpiredWebrtc", e);` | `} / }); / sleep(Settings.WEBRTC_EXPIRE_THREAD_DELAY); / } catch (Exception e) {` |

Registry reconciliation: 32 rows for this file; 32 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.
