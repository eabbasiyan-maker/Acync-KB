# Async class dossiers — review batch 06


---

### dossier-src-com-nozha-async-server-handler-websockethandler

<!-- source dossier: src/com/nozha/async/server/handler/WebsocketHandler.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L1-L241
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# WebsocketHandler — source review

## Technical

Package: `com.nozha.async.server.handler`. Ownership: candidate Async product namespace; organizational owner UNKNOWN. Compilation status: **active source declaration**. Full compilation unit reviewed: 241 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Singleton maps adapter keys to clients/pending, starts pending expiry monitor. register ([55–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L55-L80)) sends DEVICE_REGISTER, removes pending and core.add; failures remove/close/throw, missing adapter removes only. sendMessage ([83–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L83-L102)) text cast, registered or registration frame gate, JSON/client send. destroy flags monitor. onOpen ([109–140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L109-L140)) remote IP, WebsocketClient access validation, optional load gate, pending/all maps, ADDRESSLOG, ping with generated device ID; rejection closes by reason. onClose removes main client, core remove only peer exists, best-effort session close; pending entry not removed here. onInbound ([159–182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L159-L182)) forwards typed Payload to core, errors remove MESSAGING/main map; absent closes NOT_REGISTERED. onError logs/removes and closes ERROR. getClients mutable map; removeClient only main map. Pending monitor ([207–241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L207-L241)) iterates synchronized map without external lock, creation timeout, removes both maps and core only if peer nonnull, sleep20s.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L41): `private WebsocketHandler() {`
- [51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L51): `public static WebsocketHandler getInstance() {`
- [55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L55): `public void register(WebsocketClient client) throws ServerException {`
- [83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L83): `public void sendMessage(Client client, OutboundPayload outboundPayload) throws ServerException {`
- [105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L105): `public void destroy() {`
- [109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L109): `public void onOpen(AsyncWebSocketAdapter webSocket, Session session) {`
- [142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L142): `public void onClose(AsyncWebSocketAdapter webSocket, int statusCode, String reason) {`
- [159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L159): `public void onInbound(AsyncWebSocketAdapter webSocket, Payload frame) {`
- [184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L184): `public void onError(AsyncWebSocketAdapter webSocket, Throwable e) {`
- [203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L203): `public void removeClient(WebsocketClient websocketClient) {`
- [215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L215): `public void run() {`

Source dependency imports: `com.nozha.Settings`, `com.nozha.async.server.Server`, `com.nozha.async.server.biz.LoadManager`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.WebsocketClient`, `com.nozha.async.server.exception.AccessibilityException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.exception.TooManyOpenedClientException`, `com.nozha.async.server.exception.WebSocketCloseReason`, `com.nozha.async.server.httpserver.AsyncWebSocketAdapter`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.MessageType`, `com.nozha.async.server.vo.ClientMessage`, `com.nozha.async.server.vo.log.WebsocketAddressLog`, `org.eclipse.jetty.websocket.api.Callback`, `org.eclipse.jetty.websocket.api.Session`, `org.apache.logging.log4j.LogManager`, `org.eclipse.jetty.websocket.core.CloseStatus`, `org.slf4j.Logger`, `org.slf4j.LoggerFactory`, `java.io.IOException`, `java.net.InetSocketAddress`, `java.util.*`.
Configuration references: `CHECK_WEBSOCKET`, `SERVER_EXPIRE_DELAY`. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:163](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L163): `handlers.add(WebsocketHandler.getInstance());`
- [src/com/nozha/async/server/httpserver/ManageServlet.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L49): `Map<Long, WebsocketClient> clients = WebsocketHandler.getInstance().getClients();`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L32): `WebsocketHandler.getInstance().onOpen(this, session);`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L38): `WebsocketHandler.getInstance().onInbound(this, new Payload.Text(message));`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L44): `WebsocketHandler.getInstance().onInbound(this, new Payload.Binary(message.readAllBytes()));`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L53): `WebsocketHandler.getInstance().onError(this, cause);`
- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L59): `WebsocketHandler.getInstance().onClose(this, statusCode, reason);`
- [src/com/nozha/async/server/client/WebsocketClient.java:91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L91): `WebsocketHandler.getInstance().register(this);`
- [src/com/nozha/async/server/client/WebsocketClient.java:127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L127): `WebsocketHandler.getInstance().sendMessage(this, outboundPayload);`
- [src/com/nozha/async/server/client/WebsocketClient.java:136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L136): `WebsocketHandler.getInstance().removeClient(this);`

Supplemental semantic review of explicit member and nested-type boundaries:

- **MonitorExpireNotRegistered.endLoop** [210–212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L210-L212): Sets the plain loop flag false without interruption or join. destroy invokes it; a sleeping monitor may remain until its 20-second sleep returns, and visibility across threads is not explicitly guaranteed.

## Business

SOURCE_OBSERVED: WebSocket peer transport supports typed inbound bytes/text but outbound handler still casts to ClientMessagePayload. Pending unauthenticated/nonregistered sockets may be removed from maps without actual session closure when peer null.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Registration/send gate ServerException("client registration not confirmed" [+id]); open TooManyOpened, Accessibility, other map different close reasons. Send Exception wrap; callbacks own async failures not propagated. onInbound catch dereferences null peer. Cleanup catches ignored Exception; monitor exception logs/continues, concurrency risk. Test binary outbound, pending null-peer expiry and concurrent pending map mutations.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L46): `} catch (Exception e) {`
- [66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L66): `} catch (Exception e) {`
- [73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L73): `} catch (Exception ignore) {`
- [75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L75): `throw new ServerException("client registration not confirmed " + peerId);`
- [91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L91): `} catch (Exception e) {`
- [95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L95): `} catch (Exception ignore) {`
- [97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L97): `throw new ServerException(e);`
- [100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L100): `throw new ServerException("client registration not confirmed");`
- [123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L123): `} catch (TooManyOpenedClientException e) {`
- [129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L129): `} catch (IOException ignored) {`
- [131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L131): `} catch (AccessibilityException e) {`
- [135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L135): `} catch (Exception e) {`
- [154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L154): `} catch (Exception ignore) {`
- [165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L165): `} catch (Exception e) {`
- [178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L178): `} catch (Exception e) {`
- [195](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L195): `} catch (Exception ignore) {`
- [235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L235): `} catch (Exception e) {`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

ADDRESSLOG configured reference has no appender definition in log4j2.xml; runtime route unproven. log correlation peer/adapter key and close reason; pending DEBUG count does not prove sockets closed.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L42) | ALOG-665C562C272A | DEBUG | `logger.debug("Websocket handler started");` | `private final Map<Long, WebsocketClient> notRegisteredClientMap = Collections.synchronizedMap(new HashMap<>()); / private final MonitorExpireNotRegistered monitorExpireAndTimeout = new MonitorExpireNotRegistered(); / private WebsocketHandler() {` |
| [47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L47) | ALOG-525952CC7FA2 | ERROR | `logger.error("An exception occurred in start WebsocketHandler ", e);` | `try { / monitorExpireAndTimeout.setName("Websocket.MonitorExpireNotRegistered"); / monitorExpireAndTimeout.start(); / } catch (Exception e) {` |
| [64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L64) | ALOG-093CE878DE1F | INFO | `logger.info("SizeOf  notRegisteredClientMap={}", notRegisteredClientMap.size());` | `Peer peer = client.getPeer(); / peerId = peer.getId(); / sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)); / notRegisteredClientMap.remove(key);` |
| [67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L67) | ALOG-5BAEFBA38163 | WARN | `logger.warn("An exception occurred for register websocket client, peerId=" + peerId, e);` | `notRegisteredClientMap.remove(key); / logger.info("SizeOf  notRegisteredClientMap={}", notRegisteredClientMap.size()); / Server.getInstance().addClient(client); / } catch (Exception e) {` |
| [92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L92) | ALOG-6B1CCD329D12 | WARN | `logger.warn("socket send message exception for peerId=" + client.getPeer().getId(), e);` | `try { / json = JsonUtil.getJson(clientMessage); / websocketClient.send(json); / } catch (Exception e) {` |
| [94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L94) | ALOG-5DD2A4D289D7 | WARN | `logger.warn("socket send message exception for peerId={} ,messageId={}", client.getPeer().getId(), clientMessage.getId());` | `websocketClient.send(json); / } catch (Exception e) { / logger.warn("socket send message exception for peerId=" + client.getPeer().getId(), e); / try {` |
| [120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L120) | ALOG-BEE858552C14 | INFO | `loggerAddress.info(new WebsocketAddressLog(websocketClient.getAddress(), notRegisteredClientMap.size(), clientMap.size()));` | `LoadManager.validateAndSetOpeningClient(websocketClient); / Long key = webSocket.getKey(); / notRegisteredClientMap.put(key, websocketClient); / clientMap.put(key, websocketClient);` |
| [124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L124) | ALOG-E998C6FD9E4A | WARN | `logger.warn("An exception occurred on open websocket , client rejected=" + hostName, e);` | `loggerAddress.info(new WebsocketAddressLog(websocketClient.getAddress(), notRegisteredClientMap.size(), clientMap.size())); / String deviceId = UUID.randomUUID().toString() + (System.currentTimeMillis() + System.nanoTime()); / websocketClient.send(JsonUtil.getJson(new ClientMessage(0, 0, "", 0, MessageType.PING, deviceId))); / } catch (TooManyOpenedClientException e) {` |
| [132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L132) | ALOG-9913316E61B3 | WARN | `logger.warn("An exception occurred in opening websocket for " + hostName + ":" + remoteAddress.getPort(), e);` | `} / } catch (IOException ignored) { / } / } catch (AccessibilityException e) {` |
| [136](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L136) | ALOG-F1CC62222B51 | WARN | `logger.warn("An exception occurred in send ping message for " + hostName + ":" + remoteAddress.getPort(), e);` | `logger.warn("An exception occurred in opening websocket for " + hostName + ":" + remoteAddress.getPort(), e); / CloseStatus status = WebSocketCloseReason.CLOSED_REJECTED_OPENING.asCloseStatus(); / session.close(status.getCode(), status.getReason(), Callback.NOOP); / } catch (Exception e) {` |
| [147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L147) | ALOG-132F0B526B9F | INFO | `logger.info("close peerId={} , key={}  and socketMapSize={} statusCode= {} reason= {}", client.getPeer().getId(), key, clientMap.size(), statusCode, reason);` | `if (webSocket != null) { / Long key = webSocket.getKey(); / WebsocketClient client = clientMap.remove(key); / if (client != null && client.getPeer() != null) {` |
| [166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L166) | ALOG-F216831392E2 | WARN | `logger.warn("An exception occurred in websocket onMessage errorMessage={}, peerId={}", e.getMessage(), websocketClient.getPeer().getId());` | `if (websocketClient != null) { / try { / Server.getInstance().read(websocketClient, frame); / } catch (Exception e) {` |
| [179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L179) | ALOG-C876A0C577FA | DEBUG | `logger.debug("socket close exception in onMessage", e);` | `CloseStatus status = WebSocketCloseReason.CLOSED_NOT_REGISTERED.asCloseStatus(); / webSocket.getSession().close(status.getCode(), status.getReason(), Callback.NOOP); / } / } catch (Exception e) {` |
| [186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L186) | ALOG-A2726E34F80E | WARN | `logger.warn("on error in websocket key={} ,message={}", key, e.getMessage());` | `} / public void onError(AsyncWebSocketAdapter webSocket, Throwable e) { / Long key = webSocket.getKey();` |
| [189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L189) | ALOG-FFC63BFFB091 | INFO | `logger.info("removed websocket peer on error peer={} ,key={} ,socketMapSize={}", removed.getPeer().getId(), key, clientMap.size());` | `Long key = webSocket.getKey(); / logger.warn("on error in websocket key={} ,message={}", key, e.getMessage()); / WebsocketClient removed = clientMap.remove(key); / if (removed != null && removed.getPeer() != null) {` |
| [226](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L226) | ALOG-E0A3E04E5A3F | DEBUG | `logger.debug("removing pending websockets: {}", toBeRemove.size());` | `if (now > websocketClient.getCreationTime() + Settings.SERVER_EXPIRE_DELAY) { / toBeRemove.add(k); / } / }` |
| [236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L236) | ALOG-BC59E8F2E5DB | WARN | `logger.warn("An exception occurred in MonitorExpireNotRegistered websocket thread", e);` | `} / } / sleep(20000); / } catch (Exception e) {` |

Registry reconciliation: 17 rows for this file; 17 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.

---

### dossier-src-com-nozha-async-server-httpserver-accessservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/AccessServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java
source_sha256: d06131a80e9d788bcd8d9941181dfa207404b97692389d839f3818f6aa8746a7
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AccessServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AccessServlet.java:25-76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L25-L76): POST /insert, PUT /update and DELETE /delete authenticate first, dispatch only exact case-insensitive suffixes, otherwise 400 plain text; authentication exceptions become 401. [src/com/nozha/async/server/httpserver/AccessServlet.java:78-95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L78-L95): UTF-8 JSON action reads complete body, nonempty body triggers refreshAccessList only; it does not parse or persist insert/update/delete body. Empty body becomes 400 ResultResponse. [src/com/nozha/async/server/httpserver/AccessServlet.java:97-120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L97-L120): token and exact suffix helpers govern these branches.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doPost` — src/com/nozha/async/server/httpserver/AccessServlet.java:24-40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L24-L40): Authenticates the request and handles only the insert route; delegates the body action and returns 400 for an unsupported suffix, while ServerException maps to 401.
- [`doPut` — src/com/nozha/async/server/httpserver/AccessServlet.java:42-58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L42-L58): Authenticates and dispatches only the update route; unsupported suffix returns 400 and authentication failure maps to 401.
- [`doDelete` — src/com/nozha/async/server/httpserver/AccessServlet.java:60-76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L60-L76): Authenticates and dispatches only the delete route; unsupported suffix returns 400 and authentication failure maps to 401.
- [`doAction` — src/com/nozha/async/server/httpserver/AccessServlet.java:78-95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L78-L95): Reads the UTF-8 body; a nonempty body triggers refreshAccessList without parsing/persisting the submitted action data, while an empty body returns a 400 ResultResponse.
- [`checkToken` — src/com/nozha/async/server/httpserver/AccessServlet.java:97-108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L97-L108): Validates the configured management token and throws ServerException when absent, too short or invalid; servlet callers convert that failure to 401.
- [`isInsertAction` — src/com/nozha/async/server/httpserver/AccessServlet.java:110-112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L110-L112): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/insert"));`.
- [`isUpdateAction` — src/com/nozha/async/server/httpserver/AccessServlet.java:114-116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L114-L116): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/update"));`.
- [`isDeleteAction` — src/com/nozha/async/server/httpserver/AccessServlet.java:118-120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L118-L120): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/delete"));`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.AccessibilityService`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L275): `context.addServlet(new ServletHolder("access", AccessServlet.class), "/access/*"); `

## Business

SOURCE_OBSERVED: Management caller can refresh access configuration, but named CRUD actions have the same refresh effect. Any nonempty payload is accepted without schema validation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Missing/empty Authorization throws ServerException("Authorization is required"); length <=6 throws "invalid token". Prefix is stripped without checking Bearer. When Keylead inactive, a nonmatching token >6 characters passes. IO/read/refresh runtime failures are not caught locally. Reproduce each suffix with empty/nonempty body and inactive Keylead, then inspect reload rather than assume CRUD mutation.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/AccessServlet.java:35-37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L35-L37): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/AccessServlet.java:53-55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L53-L55): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/AccessServlet.java:71-73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L71-L73): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/AccessServlet.java:99-101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L99-L101): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/AccessServlet.java:107-109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L107-L109): `throw new ServerException("invalid token"); } `

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO 85 executes before refresh, so proves action/body accepted, not refresh success. Full raw body is logged, without UUID or masking; correlate request log by time/path only.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/AccessServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L85) | INFO | `logger.info("start {} {}", action, body);` | ALOG-603A6ED92359 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/AccessServlet.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L85) in `doAction`: if_statement at 84: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asynccheckservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncCheckServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java
source_sha256: bbfa63eb43edbab420cab946052d55cdb4c93c89ae0ffa1040fb8da60b61550f
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncCheckServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:19-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L19-L27): GET only DEBUG logs Settings.SERVER_ID; POST calls doGet then emits second DEBUG. No response body, explicit status or dependency check. Mounted /healthcheck/* by EmbeddedHttpServer 264.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:18-21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L18-L21): Observed operation: `logger.debug("Async Check doGet serverId={}",Settings.SERVER_ID);`.
- [`doPost` — src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:23-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L23-L27): Observed operation: `doGet(req, resp); logger.debug("Async Check doPost serverId={}",Settings.SERVER_ID);`.

Direct product dependency declarations: `com.nozha.Settings`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:264](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L264): `context.addServlet(new ServletHolder("async-health-check", AsyncCheckServlet.class), "/healthcheck/*"); `

## Business

SOURCE_OBSERVED: Caller gets servlet default response; this is a reachability handler, not DB/cache/queue readiness.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct throw/catch or validation; declared ServletException/IOException are servlet contract only. Reproduce GET and POST and verify empty default 200, without interpreting dependency readiness.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

DEBUG 20 on GET and delegated POST; DEBUG 26 only POST, both serverId. Root INFO configuration suppresses these absent override. No request ID; absence is not outage proof.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L20) | DEBUG | `logger.debug("Async Check doGet serverId={}",Settings.SERVER_ID);` | ALOG-CF5A07F79A31 |
| [src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L26) | DEBUG | `logger.debug("Async Check doPost serverId={}",Settings.SERVER_ID);` | ALOG-78FBC98185C4 |

Reconciled 2 executable direct logger sites against 2 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L20) in `doGet`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/AsyncCheckServlet.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncCheckServlet.java#L26) in `doPost`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asyncerrorhandler

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncErrorHandler.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncErrorHandler.java
source_sha256: 4115b9bec7b9c1e47fdb3476f55806c616cb815a741155fc83fb6bbe47b6b7c4
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncErrorHandler — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncErrorHandler.java:6-9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncErrorHandler.java#L6-L9): constructor disables stack display and message in title on Jetty ErrorHandler; actual response generation inherited. EmbeddedHttpServer.run installs it at 60.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`AsyncErrorHandler` — src/com/nozha/async/server/httpserver/AsyncErrorHandler.java:6-9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncErrorHandler.java#L6-L9): Observed operation: `this.setShowStacks(false); this.setShowMessageInTitle(false);`.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L60): `server.setErrorHandler(new AsyncErrorHandler()); `

## Business

SOURCE_OBSERVED: Consumers receive less diagnostic detail in default Jetty error pages. This does not sanitize application JSON/messages or logs.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class; parent ErrorHandler processes upstream errors. Boundary reproduction: force servlet exception and compare title/stack display only.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HTTP status observed via HttpRequestLogger.log; installation is EmbeddedHttpServer 60.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asyncfilter

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncFilter.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java
source_sha256: fd4fbec85abfe6bfd5faf053f5bde29aab584641171580a94883a62a8243b320
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncFilter — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncFilter.java:31-46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L31-L46): init/destroy no-op; doFilter casts servlet request/response, UTF-8 input, Max-Age 86400, applies CORS then rejects TRACE with 405 or continues chain. [src/com/nozha/async/server/httpserver/AsyncFilter.java:48-66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L48-L66): validation flag looks up peer access list only for valid origin; list membership returns origin, all other cases wildcard. Disabled mode adds wildcard/methods/accepted headers unless existing wildcard. [src/com/nozha/async/server/httpserver/AsyncFilter.java:68-101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L68-L101): preferred Origin header, fallback Referer parsed as protocol://host[:explicit port], invalid/null/empty ignored; buildOrigin excludes path.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`init` — src/com/nozha/async/server/httpserver/AsyncFilter.java:30-32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L30-L32): No body operation (abstract contract or empty constructor/method).
- [`doFilter` — src/com/nozha/async/server/httpserver/AsyncFilter.java:34-46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L34-L46): Casts servlet request/response, sets UTF-8 and preflight max-age, applies CORS headers, rejects TRACE with 405, otherwise continues the filter chain.
- [`applyCorsHeaders` — src/com/nozha/async/server/httpserver/AsyncFilter.java:48-66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L48-L66): In validation mode, returns the origin only when it passes peer access-list checks; otherwise falls back to wildcard. Disabled mode emits wildcard/method/header allowances unless wildcard is already present.
- [`getOrigin` — src/com/nozha/async/server/httpserver/AsyncFilter.java:68-76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L68-L76): Prefers the Origin header and falls back to parsing Referer; missing or empty input yields no origin.
- [`isValidOrigin` — src/com/nozha/async/server/httpserver/AsyncFilter.java:78-80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L78-L80): Observed operation: `return value != null && !value.isEmpty() && !"null".equals(value);`.
- [`resolveOrigin` — src/com/nozha/async/server/httpserver/AsyncFilter.java:82-94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L82-L94): Parses Referer and returns its normalized origin; malformed URL is logged and returns null, which allows the caller’s wildcard fallback.
- [`buildOrigin` — src/com/nozha/async/server/httpserver/AsyncFilter.java:96-102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L96-L102): Builds protocol plus host and explicit port from a URL; path/query are excluded from the origin.
- [`destroy` — src/com/nozha/async/server/httpserver/AsyncFilter.java:104-106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L104-L106): No body operation (abstract contract or empty constructor/method).

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.AccessibilityService`, `com.nozha.async.server.mediation.MediatorManager`, `com.nozha.async.server.mediation.generic.ServiceDefinitionProvider`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L230): `context.addFilter(new FilterHolder(AsyncFilter.class), "/*", EnumSet.of(DispatcherType.REQUEST)); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:331](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L331): `virtualHostContext.addFilter(new FilterHolder(AsyncFilter.class), "/*", EnumSet.of(DispatcherType.REQUEST)); `

## Business

SOURCE_OBSERVED: Browser integration advertises broad methods/headers. Source allowlist miss is permissive wildcard, so this filter is not a deny mechanism. No credential header policy proven here.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Malformed Referer URL warns and returns null, leading wildcard. Cast/type and downstream IO/ServletException propagate. Reproduce unknown origin, malformed Referer, null origin and TRACE: headers precede 405.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/AsyncFilter.java:89-91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L89-L91): `} catch (MalformedURLException e) { logger.warn("An exception occurred in HttpClient set origin, referer: " + referer, e); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN 90 only MalformedURLException in Referer fallback, includes raw Referer and throwable. Potential sensitive URL/query and log injection; no correlation ID. Successful/wildcard decisions unlogged.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/AsyncFilter.java:90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L90) | WARN | `logger.warn("An exception occurred in HttpClient set origin, referer: " + referer, e);` | ALOG-8AA9A9D62219 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/AsyncFilter.java:90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncFilter.java#L90) in `resolveOrigin`: catch_clause at 89: see enclosing source; if_statement at 84: (isValidOrigin(referer)). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asyncservicecallservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java
source_sha256: 5e19625d7d2ddd3601ece3c48c0e1a48e7b086d4f9591ff2cc9f13596be6c9f8
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncServiceCallServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:30-36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L30-L36) PATCH special dispatch; GET [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:39-59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L39-L59) sets JSON and business_id from token, checks three blocker keys, normalizes URL. Proxy only when PROXY_SERVICE_CALL, exact /nzh/doServiceCall/, scProductId present and in SC_PRODUCT_IDS; else copy context virtual host attr and delegate HttpHandler. POST/PUT/DELETE/PATCH [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:72-88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L72-L88) reuse GET. checkBlockServiceCall [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:61-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L61-L69) ORs product, business, composite product#business.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`service` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:29-36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L29-L36): Observed operation: `if (req.getMethod().equalsIgnoreCase("PATCH")) { doPatch(req, resp); } else { super.service(req, resp); }`.
- [`doGet` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:38-59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L38-L59): Sets JSON response and derives business_id from the token, checks configured business/provider/service blockers, normalizes the target URL, then either proxies the exact configured Service Call route or delegates to HttpHandler with virtual-host context.
- [`checkBlockServiceCall` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:61-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L61-L69): Checks business, provider and service block keys; a match returns the configured blocked response, otherwise processing continues.
- [`doPost` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:71-74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L71-L74): Observed operation: `doGet(req, resp);`.
- [`doPut` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:76-79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L76-L79): Observed operation: `doGet(req, resp);`.
- [`doDelete` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:81-84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L81-L84): Observed operation: `doGet(req, resp);`.
- [`doPatch` — src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:86-88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L86-L88): Observed operation: `doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.biz.ServiceCallService`, `com.nozha.async.server.handler.HttpHandler`, `com.nozha.async.server.handler.ServiceCallProxy`, `com.nozha.async.server.mediation.exception.MediationException`, `com.nozha.async.server.util.KeyleadUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L237): `context.addServlet(new ServletHolder("service-call", AsyncServiceCallServlet.class), `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L239): `context.addServlet(new ServletHolder("service-call", AsyncServiceCallServlet.class), `

## Business

SOURCE_OBSERVED: Service-call consumer can be blocked before transport or routed to configured proxy versus Async peer. This is fixed endpoint selection, not general orchestration.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Block throws MediationException("provider is blocked",null,451) at 67; any locally propagated MediationException sends 451 at 56 irrespective original code. HttpHandler catches its own mediation failures, so this catch primarily covers blocker. IO/token unchecked failures propagate. Reproduce each blocker independently and proxy-eligibility boundaries.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:55-57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L55-L57): `} catch (MediationException e) { resp.sendError(451); logger.warn("An exception occurred in httpHandler error=MediationException");`
- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:67-69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L67-L69): `throw new MediationException("provider is blocked", null, 451); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN 57 occurs after sendError(451), contains no request IDs, reason, product/business or stack. Does not prove which key blocked. Use HttpHandler/HttpRequestLogger upstream correlation; downstream proxy logs differ.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L57) | WARN | `logger.warn("An exception occurred in httpHandler error=MediationException");` | ALOG-4D5DA2B21143 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L57) in `doGet`: catch_clause at 55: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md` and `source-logging-semantics.md` service-call notes: raw management bodies and proxy-vs-message boundary must stay distinct; proxy 408/227 findings belong ServiceCallProxy, not this class. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asyncservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java
source_sha256: e1ae2b55c5f6351582fc76f3c2c190f76add1969102724adb56aa4a9597bf9ac
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncServlet.java:21-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L21-L27) service sends PATCH to private doPatch, else superclass dispatch. [src/com/nozha/async/server/httpserver/AsyncServlet.java:30-35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L30-L35) doGet transfers servlet-context VIRTUALHOST_PEER_NAME to request, then HttpHandler.receiveMessage. POST/PUT/DELETE/private PATCH delegate [src/com/nozha/async/server/httpserver/AsyncServlet.java:38-54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L38-L54). Mounted REST_ENDPOINT_URI/* and virtual-host /* by EmbeddedHttpServer 262,[src/com/nozha/async/server/httpserver/AsyncServlet.java:327-329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L327-L329).

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`service` — src/com/nozha/async/server/httpserver/AsyncServlet.java:20-27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L20-L27): Observed operation: `if (req.getMethod().equalsIgnoreCase("PATCH")) { doPatch(req, resp); } else { super.service(req, resp); }`.
- [`doGet` — src/com/nozha/async/server/httpserver/AsyncServlet.java:29-35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L29-L35): Copies the virtual-host peer name from servlet context to the request, then delegates message handling to HttpHandler.receiveMessage.
- [`doPost` — src/com/nozha/async/server/httpserver/AsyncServlet.java:37-40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L37-L40): Observed operation: `doGet(req, resp);`.
- [`doPut` — src/com/nozha/async/server/httpserver/AsyncServlet.java:42-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L42-L45): Observed operation: `doGet(req, resp);`.
- [`doDelete` — src/com/nozha/async/server/httpserver/AsyncServlet.java:47-50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L47-L50): Observed operation: `doGet(req, resp);`.
- [`doPatch` — src/com/nozha/async/server/httpserver/AsyncServlet.java:52-54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L52-L54): Observed operation: `doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.async.server.handler.HttpHandler`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:262](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L262): `context.addServlet(new ServletHolder("rest-async", AsyncServlet.class), Settings.REST_ENDPOINT_URI + "/*"); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:328](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L328): `new ServletHolder("rest-async-" + peerName, AsyncServlet.class), "/*"); `

## Business

SOURCE_OBSERVED: Exposes HTTP-to-Async peer messaging, with response timing/status governed by handler and mediation, not servlet itself.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct error path in class; no local validation/catch. HttpHandler [src/com/nozha/async/server/httpserver/AsyncServlet.java:265-288](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServlet.java#L265-L288) maps MediationException to configured 307 redirect or errorCode/default503. IO servlet failures propagate. Reproduce method and virtual-host routing at handler boundary.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. HttpHandler 138-142 establishes header-derived/new UUID; 171 threshold logs, 266 failure logs. HttpRequestLogger log records status if enabled.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-asyncwebsocketadapter

<!-- source dossier: src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java
source_sha256: df2fda8ee732dd650677cd493d9e30e242767c371145c462d59e4fe30de5601c
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AsyncWebSocketAdapter — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:19-24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L19-L24) per-instance key atomically increments shared counter (initial1, first key2). [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:29-33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L29-L33) stores session then onOpen; [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:36-39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L36-L39) wraps text; [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:42-48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L42-L48) reads entire binary stream then wraps bytes; [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:51-59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L51-L59) forwards errors/close status+reason; [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:62-64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L62-L64) returns stored session. Jetty /ws mapping creates new adapter at EmbeddedHttpServer290.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`getKey` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:22-24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L22-L24): Returns `key` unchanged; no validation or side effect.
- [`onWebSocketOpen` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:28-33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L28-L33): Observed operation: `this.session = session; WebsocketHandler.getInstance().onOpen(this, session);`.
- [`onWebSocketText` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:35-39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L35-L39): Observed operation: `WebsocketHandler.getInstance().onInbound(this, new Payload.Text(message));`.
- [`onWebSocketBinary` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:41-48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L41-L48): Reads the complete binary callback stream into a byte array, wraps it as HttpContent and forwards it to the message handler; buffering duplicates payload memory and has no local size check.
- [`onWebSocketError` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:50-54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L50-L54): Observed operation: `WebsocketHandler.getInstance().onError(this, cause);`.
- [`onWebSocketClose` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:56-60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L56-L60): Observed operation: `WebsocketHandler.getInstance().onClose(this, statusCode, reason);`.
- [`getSession` — src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:62-64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L62-L64): Returns `session` unchanged; no validation or side effect.

Direct product dependency declarations: `com.nozha.async.server.handler.Payload`, `com.nozha.async.server.handler.WebsocketHandler`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/handler/WebsocketHandler.java:109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L109): `public void onOpen(AsyncWebSocketAdapter webSocket, Session session) { `
- [src/com/nozha/async/server/handler/WebsocketHandler.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L142): `public void onClose(AsyncWebSocketAdapter webSocket, int statusCode, String reason) { `
- [src/com/nozha/async/server/handler/WebsocketHandler.java:159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L159): `public void onInbound(AsyncWebSocketAdapter webSocket, Payload frame) { `
- [src/com/nozha/async/server/handler/WebsocketHandler.java:184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L184): `public void onError(AsyncWebSocketAdapter webSocket, Throwable e) { `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:290](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L290): `wsContainer.addMapping("/ws", (req, resp) -> new AsyncWebSocketAdapter()); `
- [src/com/nozha/async/server/client/WebsocketClient.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L33): `private AsyncWebSocketAdapter webSocket; `
- [src/com/nozha/async/server/client/WebsocketClient.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L39): `public WebsocketClient(AsyncWebSocketAdapter webSocket, Session session) throws Exception { `
- [src/com/nozha/async/server/client/WebsocketClient.java:94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L94): `public AsyncWebSocketAdapter getWebSocket() { `

## Business

SOURCE_OBSERVED: Bridges Jetty connection callbacks to WebsocketHandler and preserves connection identity; does not itself authenticate, register peers or ACK payloads.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Binary IOException is suppressed after printStackTrace; no close/error forwarding on that branch. Unbounded readAllBytes local to adapter relies on container max sizes. Handler failures propagate. Reproduce failing InputStream to verify lost binary callback and stderr.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java:45-47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncWebSocketAdapter.java#L45-L47): `} catch (IOException e) { e.printStackTrace(); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS for logger calls; printStackTrace at46 is unstructured stderr. WebsocketHandler receives adapter key/session for downstream connection logs; container max sizes configured 286-289.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-autoresponseservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/AutoResponseServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java
source_sha256: 5f4fdf2f42c3b1277c6f307d3628613b33a7bae44817ba9998fcf9012fa68d75
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# AutoResponseServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/AutoResponseServlet.java:23-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L23-L31) doGet sets JSON 200, closes writer before HttpHandler.sendOnly, then INFO. POST/PUT/DELETE [src/com/nozha/async/server/httpserver/AutoResponseServlet.java:34-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L34-L45) reuse GET; private PATCH48 exists but no service PATCH override. Notification bridge paths configured EmbeddedHttpServer249-259.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/AutoResponseServlet.java:22-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L22-L31): Sets JSON 200, closes the response writer, then invokes HttpHandler.sendOnly and logs; POST/PUT/DELETE reuse this GET behavior.
- [`doPost` — src/com/nozha/async/server/httpserver/AutoResponseServlet.java:33-36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L33-L36): Observed operation: `doGet(req, resp);`.
- [`doPut` — src/com/nozha/async/server/httpserver/AutoResponseServlet.java:38-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L38-L41): Observed operation: `doGet(req, resp);`.
- [`doDelete` — src/com/nozha/async/server/httpserver/AutoResponseServlet.java:43-46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L43-L46): Observed operation: `doGet(req, resp);`.
- [`doPatch` — src/com/nozha/async/server/httpserver/AutoResponseServlet.java:48-50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L48-L50): Observed operation: `doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.async.server.handler.HttpHandler`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L253): `context.addServlet(new ServletHolder("auto-response-async-" + i++, AutoResponseServlet.class), endPoint); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:254](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L254): `context.addServlet(new ServletHolder("auto-response-async-" + i++, AutoResponseServlet.class), endPoint + "/"); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:255](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L255): `context.addServlet(new ServletHolder("auto-response-async-" + i++, AutoResponseServlet.class), `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:257](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L257): `context.addServlet(new ServletHolder("auto-response-async-" + i++, AutoResponseServlet.class), `

## Business

SOURCE_OBSERVED: Callback consumer gets an early empty success response without waiting for downstream processing/delivery. Source ordering does not prove ACK or durable acceptance.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No local catch; writer failure propagates; sendOnly handles mediation itself at HttpHandler314-334. PATCH helper is not dispatched by custom service here. Reproduce failing downstream with already-closed response and verify consumer success remains independent.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO28 after sendOnly returns, includes serverName/remoteHost/servletPath, no UUID or body. Since sendOnly can suppress failures, "send ok" is not delivery proof.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/AutoResponseServlet.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L28) | INFO | `logger.info("AutoResponseServlet send ok for request. serverName={} , host={} , pathInfo={}", req.getServerName(), req.getRemoteHost(), req.getServletPath());` | ALOG-BD9CC6B254D8 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/AutoResponseServlet.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AutoResponseServlet.java#L28) in `doGet`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-businesslimitservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/BusinessLimitServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java
source_sha256: 18951c325b9ac715f267bc627873ba866e336c07f6fd71e898fe2dbf4336425d
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# BusinessLimitServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:33-64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L33-L64) GET authenticates then /limit only when HAS_BUSINESS_DATA_GATHERING snapshots counters and clears map; root returns business map, /block blocked set, /provider/block provider blocks filtered businessId. POST68-91 selects /block, /blockcount, /watch, /provider/block, root add; DELETE95-116 selects unblock/unwatch/provider unblock/root delete. doBusinessAction132-191 reads body/config, validates then switches to RateLimitBusiness operations; ResultResponse maps status. [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:194-210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L194-L210) businessId required/existing except add; provider block needs provider resolved via PeerCRUD then sets providerPeerId. [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:212-257](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L212-L257) exact suffix helpers include optional slash and DELETE aliases /block,/watch.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:32-64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L32-L64): Authenticates, then serves counters, business blocks or provider blocks by path; counter reads snapshot and clear the counter map when data gathering is enabled.
- [`doPost` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:67-91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L67-L91): Authenticates and routes block/block-count/watch/provider-block or root add operations to the body action handler; unknown suffix returns 400.
- [`doDelete` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:94-116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L94-L116): Authenticates and routes unblock/unwatch/provider-unblock or root delete operations; unknown suffix returns 400.
- [`checkToken` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:118-129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L118-L129): Enforces the configured management token when authorization is enabled; invalid/missing token becomes the servlet’s unauthorized response.
- [`doBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:132-191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L132-L191): Parses a UTF-8 BusinessLimitRequest, validates it, selects the RateLimitBusiness operation for the requested action, and serializes ResultResponse; parse/operation errors map to failure responses.
- [`checkBusinessRequestValidation` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:194-210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L194-L210): Requires a valid business ID for operations except add; provider-block additionally resolves the provider through PeerCRUD and fills providerPeerId.
- [`isBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:212-214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L212-L214): Observed operation: `return pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/");`.
- [`isLimit` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:216-219](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L216-L219): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/limit") || pathInfo.equalsIgnoreCase("/limit/"));`.
- [`isBlockBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:221-224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L221-L224): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/block") || pathInfo.equalsIgnoreCase("/block/"));`.
- [`isBlockCountBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:226-229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L226-L229): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/blockcount") || pathInfo.equalsIgnoreCase("/blockcount/"));`.
- [`isUnBlockBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:231-235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L231-L235): Recognizes the exact unblock-business path suffix (case-insensitive); other suffixes are false.
- [`isWatchBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:237-240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L237-L240): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/watch") || pathInfo.equalsIgnoreCase("/watch/"));`.
- [`isUnWatchBusinessAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:242-246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L242-L246): Recognizes the exact unwatch-business path suffix (case-insensitive); other suffixes are false.
- [`isBlockBusinessProviderAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:248-251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L248-L251): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/provider/block") || pathInfo.equalsIgnoreCase("/provider/block/"));`.
- [`isUnBlockBusinessProviderAction` — src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:253-257](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L253-L257): Recognizes the exact provider-unblock path suffix (case-insensitive); other suffixes are false.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.ratelimit.RateLimitBusiness`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.business.BusinessVo`, `com.nozha.async.server.vo.rateLimit.business.GatherBusinessDto`, `com.nozha.async.server.vo.rateLimit.business.BusinessProviderConfig`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L271): `context.addServlet(new ServletHolder("business-limit-events", BusinessLimitServlet.class), "/rate-limit/business/*"); `

## Business

SOURCE_OBSERVED: Administrative caller can add/delete/watch/block business and provider scope. GET /limit drains counters, so repeated readers do not see identical data; approved gathering semantics unknown.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Auth [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:118-129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L118-L129) conditional; HttpException400 for required businessId/provider,404 for not found. Parsing142 outside inner catch; null config/type can escape or become500 depending location. Inner HttpException forwards status/message; generic errors500 Internal error; empty body400; auth401. Reproduce counter-drain races and partial manager failure.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:59-61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L59-L61): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:86-88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L86-L88): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:111-113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L111-L113): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:120-122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L120-L122): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:128-130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L128-L130): `throw new ServerException("invalid token"); } `
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:174-176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L174-L176): `} catch (HttpException httpException) { httpStatus = httpException.getStatusCode(); message = httpException.getMessage();`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:178-180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L178-L180): `} catch (Exception e) { logger.error("An exception occurred in {} paths={}", action, body, e); httpStatus = HttpStatus.SC_INTERNAL_SERVER_ERROR;`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:196-198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L196-L198): `throw new HttpException("businessId is required", HttpStatus.SC_BAD_REQUEST); if (!action.equals("businessAdded") && !RateLimitBusiness.hasBusinessId(businessProviderConfig.getBusinessId())) throw new HttpException("businessId not found", HttpStatus.SC_NOT_FOUND);`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:198-200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L198-L200): `throw new HttpException("businessId not found", HttpStatus.SC_NOT_FOUND); if (action.equals("businessProviderBlocked") || action.equals("businessProviderUnBlocked")) { if (businessProviderConfig.getProvider() == null || businessProviderConfig.getProvider().isEmpty()) {`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:201-203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L201-L203): `throw new HttpException("provider is required", HttpStatus.SC_BAD_REQUEST); } else { Peer peer = PeerCRUD.loadPeerByName(businessProviderConfig.getProvider());`
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:205-207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L205-L207): `throw new HttpException("provider not found", HttpStatus.SC_NOT_FOUND); } businessProviderConfig.setProviderPeerId(peer.getId());`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO141 raw full body/action before parse. WARN177 expected validation with message/provider/businessId/action. ERROR179 unexpected action/body/exception. No UUID, body privacy concern, failure/success mutation is not separately verified.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L141) | INFO | `logger.info("start {} {}", action, body);` | ALOG-295D7C28E200 |
| [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L177) | WARN | `logger.warn("{} for provider={} , businessId={} , action={} ", message, requestConfig.getProvider(), requestConfig.getBusinessId(), action);` | ALOG-9D9D2B0E18C6 |
| [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L179) | ERROR | `logger.error("An exception occurred in {} paths={}", action, body, e);` | ALOG-4090D009531C |

Reconciled 3 executable direct logger sites against 3 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L141) in `doBusinessAction`: if_statement at 140: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:177](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L177) in `doBusinessAction`: catch_clause at 174: see enclosing source; if_statement at 140: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L179) in `doBusinessAction`: catch_clause at 178: see enclosing source; if_statement at 140: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/operations/rate-limit-manager.md`: separate com.async AsyncManager baseline/API, not the com.nozha.async node handler; do not merge route contracts. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-cacheservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/CacheServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java
source_sha256: eb7ca18728e1e06931cc8c38542416b568683947c9331ec82a5014c53a7a038f
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# CacheServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/CacheServlet.java:18-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L18-L29) DELETE reads serverId only for log; memory vendor invalidates ALL client cache. Non-memory branch has only commented code, no invalidation. No token check implemented (todo).

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doDelete` — src/com/nozha/async/server/httpserver/CacheServlet.java:17-29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L17-L29): Requires the management token, clears the targeted cache key from the selected cache, and maps token/service failures to an HTTP error response.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.util.CacheUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L266): `context.addServlet(new ServletHolder("cache-events", CacheServlet.class), "/cache/*"); `

## Business

SOURCE_OBSERVED: Caller may clear entire local client cache; serverId does not scope memory operation. Consumers may incur reloads after global invalidation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct throw/catch; null CACHE_VENDOR causes NPE; CacheUtil failures propagate. Reproduce memory vs non-memory and confirm global scope independent of serverId. Authentication/network boundary unknown.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN20 before vendor check/invalidation, so proves request, not removal. serverId unvalidated/no UUID; no completion/result log.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/CacheServlet.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L20) | WARN | `logger.warn("CacheServlet start remove client cache for serverId={}", serverId);` | ALOG-1D06BF2564CB |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/CacheServlet.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L20) in `doDelete`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-clientservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ClientServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java
source_sha256: f75a4291af391c8519c2c5f80561bbac276393cfcb0749bda22abbe014e232af
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ClientServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ClientServlet.java:27-54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L27-L54) GET UTF8 JSON; conditional Keylead device-admin token query check, then getClientInfo56-75 requires nonempty deviceId/appId, PeerCRUD lookup returns id/name200, missing peer404 exception, missing params400 exception. ServerException401 ResultVO, generic exception preserves preset400/404 else500. POST78-80 calls superclass doPost, not GET.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/ClientServlet.java:26-54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L26-L54): Reads the requested client identifier, delegates lookup to getClientInfo, and returns the result/not-found response as JSON.
- [`getClientInfo` — src/com/nozha/async/server/httpserver/ClientServlet.java:56-75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L56-L75): Queries client/peer registration data and builds the response fields; missing registration yields no client result rather than creating state.
- [`doPost` — src/com/nozha/async/server/httpserver/ClientServlet.java:77-80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L77-L80): Observed operation: `super.doPost(req, resp);`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.httpserver.vo.ResultVO`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:265](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L265): `context.addServlet(new ServletHolder("client-events", ClientServlet.class), "/client/*"); `

## Business

SOURCE_OBSERVED: Device administrator can discover peer identity from application/device pair; inactive identity service bypasses local token check.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Exact generic exceptions "client not found"69 and "Invalid parameter"73. Failure ResultVO contains exception message. Serialization/writer IO outside try propagates. Reproduce absent pair, missing peer, denied token and POST unsupported response.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/ClientServlet.java:39-41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L39-L41): `} catch (ServerException e) { logger.warn("An exception occurred in check token for get client info", e); rs = new ResultVO(false, e.getMessage());`
- [src/com/nozha/async/server/httpserver/ClientServlet.java:43-45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L43-L45): `}catch (Exception e) { logger.warn("An exception occurred in get client info", e); rs = new ResultVO(false, e.getMessage());`
- [src/com/nozha/async/server/httpserver/ClientServlet.java:69-71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L69-L71): `throw new Exception("client not found"); } }else {`
- [src/com/nozha/async/server/httpserver/ClientServlet.java:73-75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L73-L75): `throw new Exception("Invalid parameter"); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

WARN40 token ServerException; WARN44 generic lookup/validation error, both stack. No IDs/parameters logged explicitly; HttpRequestLogger path/query may expose query token.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/ClientServlet.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L40) | WARN | `logger.warn("An exception occurred in check token for get client info", e);` | ALOG-E5D0840BA3E9 |
| [src/com/nozha/async/server/httpserver/ClientServlet.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L44) | WARN | `logger.warn("An exception occurred in get client info", e);` | ALOG-5EC331270000 |

Reconciled 2 executable direct logger sites against 2 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/ClientServlet.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L40) in `doGet`: catch_clause at 39: see enclosing source. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ClientServlet.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L44) in `doGet`: catch_clause at 43: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-embeddedhttpserver

<!-- source dossier: src/com/nozha/async/server/httpserver/EmbeddedHttpServer.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java
source_sha256: a4de32569f69d6477de0f673fae2665797211066a30a1ec4d4127d439c20592f
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# EmbeddedHttpServer — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:44-65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L44-L65) run builds pool/server, starts daemon queue metrics, connectors, contexts/gzip/websocket/error/request logging then start and stdout dump. createThreadPool67-76 uses HTTP_MAX/MIN_THREAD,IDLE_TIMEOUT, bounded HTTP_QUEUE_SIZE queue41. configureConnectors78-90 always HTTP (HTTP1/h2c), optional HTTPS; base config92-99 suppresses versions. HTTP connector101-111 uses HTTP_PORT/idle. HTTPS113-151 reads keystore, missing/caught initialization returns null (HTTP survives), disables SNI host check, ALPN HTTP2/1, HTTPS_PORT/accept queue. ciphers153-170 print defaults/supported to stdout; SSL172-183 uses password/include/exclude ciphers/protocols, comparator, no renegotiation. main185-196 sets form size/session, resources/filters/servlets. static198-226 filesystem www or classpath, no listing, index.html; fallback RootServlet. filters229-231 REQUEST all paths. registerServlets233-282 maps payment, service-call configurator, register, optional WebRTC, manage, bridge, REST, unregister, two health paths, client/cache/mqtt/rate-limit/service/access/provider/message-saver and optional swagger; exact routes are source-defined. WebSocket284-292 uses idle/buffer/text/binary max and /ws. contexts294-315 creates configured virtual hosts plus main with gzip min245; virtual context317-334 only valid peer/hosts, AsyncServlet /*, attr/session/filter. requestLog336-346 enabled ADD_HTTP_REQUEST_LOG and HTTPLOG writer/custom logger. shutdown348-354 suppresses stop exception. getPool/getQueue356-362 return live state.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`run` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:44-65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L44-L65): Creates the bounded Jetty thread pool and queue, starts the queue-size logger, configures connectors and contexts, applies gzip/WebSocket/error/request-log handlers, then starts the server and prints its dump; startup failures propagate.
- [`createThreadPool` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:67-76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L67-L76): Builds QueuedThreadPool from configured max/min threads and idle timeout, and binds it to the bounded HTTP work queue; invalid values can fail construction.
- [`configureConnectors` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:78-90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L78-L90): Always adds the HTTP connector and adds HTTPS only when TLS initialization returns a connector; HTTP connector creation errors propagate.
- [`createBaseHttpConfiguration` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:92-99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L92-L99): Creates common HTTP settings and suppresses server/version headers before connectors use the configuration.
- [`createHttpConnector` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:101-111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L101-L111): Creates the HTTP/1.1 plus h2c connector on configured HTTP port with configured idle timeout and accept queue.
- [`createHttpsConnectorIfPossible` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:113-151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L113-L151): Loads the configured keystore and builds HTTP/2/HTTP/1.1 TLS connector; missing or failed in-try SSL initialization is logged and returns null, leaving HTTP available, while keystore resource I/O before the try may propagate.
- [`logAvailableCiphers` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:153-170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L153-L170): Prints default and supported cipher suites to stdout for diagnostics; it does not configure the TLS allowlist.
- [`createSslContextFactory` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:172-183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L172-L183): Creates the server SSL context with configured key-store credentials and cipher/protocol include/exclude lists, sorts cipher names and disables renegotiation.
- [`createMainContext` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:185-196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L185-L196): Creates the main servlet context and applies configured form-size/session behavior before static resources, filters and routes are registered.
- [`configureStaticResources` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:198-215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L198-L215): Serves the resolved www resource with directory listing disabled and index.html as welcome file; if resource resolution fails, maps RootServlet as fallback.
- [`resolveWwwUri` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:217-227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L217-L227): Resolves the configured www directory from filesystem or classpath and returns its URI; resolution/URI errors propagate to startup.
- [`registerFilters` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:229-231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L229-L231): Observed operation: `context.addFilter(new FilterHolder(AsyncFilter.class), "/*", EnumSet.of(DispatcherType.REQUEST));`.
- [`registerServlets` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:233-282](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L233-L282): Registers the product servlet routes for payment, service call, registration, management, REST, unregister, health, client/cache, MQTT, rate limits, access and provider/message saving; WebRTC and Swagger routes are conditional.
- [`configureWebSocket` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:284-292](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L284-L292): Installs the WebSocket handler at /ws with configured idle timeout and text/binary buffer limits.
- [`createContextHandlerCollection` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:294-315](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L294-L315): Builds a context collection from the main context and configured virtual-host contexts, then wraps it with gzip handling using a 245-byte minimum.
- [`createVirtualHostContext` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:317-334](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L317-L334): Creates a peer context only when peer/host configuration is usable, sets host/session attributes, maps AsyncServlet to /* and applies AsyncFilter to requests.
- [`configureRequestLog` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:336-346](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L336-L346): Enables Jetty request logging only when ADD_HTTP_REQUEST_LOG is true, wiring the configured HTTP log writer and HttpRequestLogger.
- [`shutdown` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:348-354](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L348-L354): Observed operation: `try { server.stop(); } catch (Exception e) { logger.warn("An exception occurred in shutdown http server", e); }`.
- [`getPool` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:356-358](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L356-L358): Returns `pool` unchanged; no validation or side effect.
- [`getQueue` — src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:360-362](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L360-L362): Returns `queue` unchanged; no validation or side effect.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.httpserver.log.HttpRequestLogger`, `com.nozha.async.server.mediation.MediatorManager`, `com.nozha.async.server.mediation.generic.vo.ServiceProviderConfig`, `com.nozha.async.server.util.ResourceHelper`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/Server.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L73): `private EmbeddedHttpServer httpServer; `
- [src/com/nozha/async/server/Server.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L87): `httpServer = new EmbeddedHttpServer(); `
- [src/com/nozha/async/server/Server.java:1314](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1314): `public EmbeddedHttpServer getHttpServer() { `

## Business

SOURCE_OBSERVED: Network entrypoint hosts Async APIs, static UI and transport callbacks. Optional HTTPS failure does not stop HTTP; route exposure/production config unknown. Virtual-host peer routing makes host config part of destination selection.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

run throws startup Exceptions; resolve resource/URI/connectors can abort. HTTPS IOException from ResourceHelper before try may propagate; errors inside TLS try suppressed to no HTTPS. Invalid queue/thread/timer config can fail startup before network. Missing www falls back homepage. shutdown exception suppressed. Reproduce missing keystore, bad TLS config, invalid queue interval; "started" logs precede actual server.start.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:147-149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L147-L149): `} catch (Exception ex) { logger.error("Can not initialize SSL", ex); return null;`
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:351-353](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L351-L353): `} catch (Exception e) { logger.warn("An exception occurred in shutdown http server", e); }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

Seven registry logger sites: connector creation109/144 and keystore145 are before listener start, warning116 no-keystore, error148 TLS exception,206 resource root,352 shutdown exception. Stdout ciphers164-168 and server dump64 supplement. HTTPLOG config343 format contains full request, Referer,User-Agent,XFF,cookies, but HttpRequestLogger overrides log instead of super; actual structured fields follow its implementation. Paths and URLs may be sensitive; no request correlation in startup logs.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L109) | INFO | `logger.info("Async HTTP connector started. HTTP port: {}", Settings.HTTP_PORT);` | ALOG-30981D7522FB |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L116) | WARN | `logger.warn("Async HTTPS not initialized because keystore is not available: {}", Settings.KEYSTORE_PATH);` | ALOG-D1AF21D47128 |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L144) | INFO | `logger.info("Async HTTPS connector started. HTTPS port: {}", Settings.HTTPS_PORT);` | ALOG-C8A1E60DA28B |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L145) | INFO | `logger.info("SSL keystore path: {}", keyFile.getAbsolutePath());` | ALOG-43F5A91B24DE |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L148) | ERROR | `logger.error("Can not initialize SSL", ex);` | ALOG-8B03FED62D1D |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L206) | INFO | `logger.info("WWW root path: {}", wwwUri);` | ALOG-1B8682AE9D71 |
| [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:352](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L352) | WARN | `logger.warn("An exception occurred in shutdown http server", e);` | ALOG-92E0F364E1A8 |

Reconciled 7 executable direct logger sites against 7 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L109) in `createHttpConnector`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L116) in `createHttpsConnectorIfPossible`: if_statement at 115: (keyFile == null || !keyFile.exists()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L144) in `createHttpsConnectorIfPossible`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L145) in `createHttpsConnectorIfPossible`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L148) in `createHttpsConnectorIfPossible`: catch_clause at 147: see enclosing source. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L206) in `configureStaticResources`: if_statement at 201: (wwwUri != null). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:352](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L352) in `shutdown`: catch_clause at 351: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-healthcheckservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/HealthCheckServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java
source_sha256: c9adfdd81d334d8e142a1a02e99baf6272abdbc893dbb16c4484b7a25c80c357
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# HealthCheckServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/HealthCheckServlet.java:23-32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L23-L32) GET reads CLIENT_REQUEST_ID_KEY, writes JSON message ok SERVER_ID, status200, ARN header from request ID then closes writer and INFO. POST/PUT/DELETE35-46 delegate; private PATCH49 unused by default dispatch. Mounted /health-check/* unlike /healthcheck/*.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/HealthCheckServlet.java:22-32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L22-L32): Returns the servlet’s fixed health response without probing database, broker or downstream readiness; success therefore proves route handling only.
- [`doPost` — src/com/nozha/async/server/httpserver/HealthCheckServlet.java:34-37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L34-L37): Observed operation: `doGet(req, resp);`.
- [`doPut` — src/com/nozha/async/server/httpserver/HealthCheckServlet.java:39-42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L39-L42): Observed operation: `doGet(req, resp);`.
- [`doDelete` — src/com/nozha/async/server/httpserver/HealthCheckServlet.java:44-47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L44-L47): Observed operation: `doGet(req, resp);`.
- [`doPatch` — src/com/nozha/async/server/httpserver/HealthCheckServlet.java:49-51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L49-L51): Observed operation: `doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.Settings`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:268](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L268): `context.addServlet(new ServletHolder("health-check", HealthCheckServlet.class), "/health-check/*"); `

## Business

SOURCE_OBSERVED: Liveness response affirms handler execution, not dependency readiness; echoes request identifier in ARN.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No direct throw/catch. Writer IO propagates; null/request-hostile identifier behavior is container-dependent. Header set after println could depend on response commit. Reproduce GET plus POST/PUT/DELETE and dependency outage.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO30 after writer close with serverName,remoteHost,servletPath,requestId. Supports successful local response code path, not downstream health. RequestId untrusted, no generated fallback; root logging configured INFO.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/HealthCheckServlet.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L30) | INFO | `logger.info("HealthCheckServlet send ok for request. serverName={} , host={} , pathInfo={}, X-Request-ID= {}", req.getServerName(), req.getRemoteHost(), req.getServletPath(), requestId);` | ALOG-CACAD8A39946 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/HealthCheckServlet.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/HealthCheckServlet.java#L30) in `doGet`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-ipaddresslimitservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/IPAddressLimitServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java
source_sha256: 0776cef10c92051f472404fe4d3627ab283160d24934ad9782fcf3c0ae86598c
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# IPAddressLimitServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:30-55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L30-L55) GET authenticates; /limit snapshots counters and clears, root returns configured list, /block blocked list, unknown400. POST59-78 block/blockcount/root add; DELETE82-99 unblock/root delete. token101-112 conditional admin. action115-162 UTF8 JSON body/IPAddressConfig, switch to count block/block/unblock/add/delete RateLimitIpAddress. validate165-170 requires nonempty ip and existing unless add. suffix172-195 root,limit,block,blockcount,unblock with trailing-slash aliases.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:29-55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L29-L55): Authenticates and returns IP counters, configured IP rules or blocked IPs by suffix; counter reads snapshot and clear gathered counts, and unsupported suffix returns 400.
- [`doPost` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:58-78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L58-L78): Authenticates and allows add, block, block-count actions through the request-body handler; other paths return 400.
- [`doDelete` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:81-99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L81-L99): Authenticates and dispatches unblock or delete; unrecognized paths return 400.
- [`checkToken` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:101-112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L101-L112): Checks the configured authorization token when management protection is enabled; invalid/missing credentials stop the action.
- [`doIpAddressAction` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:115-162](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L115-L162): Parses an IPAddressConfig from UTF-8 JSON, validates the address, then invokes the selected RateLimitIpAddress add/block/unblock/delete/count operation and returns its result.
- [`checkIpRequestValidation` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:165-170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L165-L170): Requires a nonempty IP address and, except for add, requires that the address already exist in the configured set.
- [`isIpAddressAction` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:172-174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L172-L174): Observed operation: `return pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/");`.
- [`isLimit` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:176-179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L176-L179): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/limit") || pathInfo.equalsIgnoreCase("/limit/"));`.
- [`isBlockIpAddressAction` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:181-184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L181-L184): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/block") || pathInfo.equalsIgnoreCase("/block/"));`.
- [`isBlockCountIpAddressAction` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:186-189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L186-L189): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/blockcount") || pathInfo.equalsIgnoreCase("/blockcount/"));`.
- [`isUnBlockIpAddressAction` — src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:191-195](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L191-L195): Recognizes the unblock path suffix, including the documented trailing-slash alias; other paths are false.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.ratelimit.RateLimitIpAddress`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.ip.GatherIpDto`, `com.nozha.async.server.vo.rateLimit.ip.IPAddressConfig`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:272](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L272): `context.addServlet(new ServletHolder("ip-limit-events", IPAddressLimitServlet.class), "/rate-limit/ip/*"); `

## Business

SOURCE_OBSERVED: Controls IP admission/watch counts; draining GET metrics can remove evidence for another reader. No syntax validation of IP address is present.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

HttpException("ip is required",400), ("ip not found",404); auth401, bad path/body400; inner generic500 Internal error. JSON parse125 is before protected validation try, so parse failures not covered by inner500 mapping. Reproduce absent IP, unknown IP, malformed JSON, GET drain and invalid text address.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:50-52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L50-L52): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:73-75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L73-L75): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:94-96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L94-L96): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:103-105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L103-L105): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:111-113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L111-L113): `throw new ServerException("invalid token"); } `
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:145-147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L145-L147): `} catch (HttpException httpException) { httpStatus = httpException.getStatusCode(); message = httpException.getMessage();`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:149-151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L149-L151): `} catch (Exception e) { logger.error("An exception occurred in {} paths={}", action, body, e); httpStatus = HttpStatus.SC_INTERNAL_SERVER_ERROR;`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:167-169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L167-L169): `throw new HttpException("ip is required", HttpStatus.SC_BAD_REQUEST); if (!action.equals("ipAddressAdded") && !RateLimitIpAddress.hasIpAddress(ipAddressConfig.getIp())) throw new HttpException("ip not found", HttpStatus.SC_NOT_FOUND);`
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:169-171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L169-L171): `throw new HttpException("ip not found", HttpStatus.SC_NOT_FOUND); } `

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO124 action/raw body before parse; WARN148 message/IP/action for HttpException; ERROR150 action/body/stack. No stable request correlation; address/body privacy risk.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L124) | INFO | `logger.info("start {} {}", action, body);` | ALOG-65075E132C5D |
| [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L148) | WARN | `logger.warn("{} for ip={} , action={} ", message, requestConfig.getIp(), action);` | ALOG-1508133F0334 |
| [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L150) | ERROR | `logger.error("An exception occurred in {} paths={}", action, body, e);` | ALOG-84B56D7C2D8A |

Reconciled 3 executable direct logger sites against 3 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L124) in `doIpAddressAction`: if_statement at 123: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L148) in `doIpAddressAction`: catch_clause at 145: see enclosing source; if_statement at 123: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L150) in `doIpAddressAction`: catch_clause at 149: see enclosing source; if_statement at 123: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/operations/rate-limit-manager.md`: separate com.async AsyncManager baseline/API, not the com.nozha.async node handler; do not merge route contracts. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-jettyqueuesizelogger

<!-- source dossier: src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java
source_sha256: 29af17bdc24c1cde8ed564ec3da077447c612c46b671eed942c77793142318d5
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# JettyQueueSizeLogger — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:15-24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L15-L24) saves pool and creates daemon Timer scheduled fixed-rate immediate/intervalMs; task run calls logQueueSize. [src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:26-28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L26-L28) INFO emits getQueueSize,getUtilizedThreads,getUtilizationRate. Timer reference not retained/cancellable.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`JettyQueueSizeLogger` — src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:15-24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L15-L24): Stores the Jetty pool and schedules a daemon Timer at fixed rate, immediately then at intervalMs; the Timer is not retained for cancellation.
- [`run` — src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:19-22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L19-L22): Observed operation: `logQueueSize();`.
- [`logQueueSize` — src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:26-28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L26-L28): Logs queue size, utilized thread count and utilization rate from the current pool; these are sampled gauges, not request latency.

Direct product dependency declarations: none. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L48): `new JettyQueueSizeLogger(pool, Settings.JETTY_QUEUE_SIZE_LOG_INTERVAL_MS); `

## Business

SOURCE_OBSERVED: Operations can observe pending queue/load; first field named threadPoolSize is queue depth, not pool size.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No local catch; invalid interval throws IllegalArgumentException, null pool may terminate task. Reproduce interval0 and known queued work to validate label semantics.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO27 each tick includes queue depth/utilized threads/utilization rate; ALOG-C6226B3E78A1 confirms prior critical signature. No request IDs appropriate for aggregate; log does not establish CPU usage or config pool size.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L27) | INFO | `logger.info("jetty threadPoolSize= {} , utilizationThread= {} , utilizationRate= {}", this.threadPool.getQueueSize(), this.threadPool.getUtilizedThreads(), this.threadPool.getUtilizationRate());` | ALOG-C6226B3E78A1 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L27) in `logQueueSize`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/observability/source-reviewed-critical-signatures.md`, `source-logging-semantics.md` and `correlation-and-data-contract.md`; preserves queue-depth label correction and request-timestamp/response-vs-business distinction. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-manageservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ManageServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java
source_sha256: e6c6bac041ac20020f268a7c9e50ff309d3aefa6fc25762751c9cd4715c3d264
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ManageServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ManageServlet.java:25-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L25-L31) GET returns HTML200 built handleManage38-151 with elapsed time and pool threads/queue. action websocket enumerates WebsocketHandler clients, peer dates/registered/creation/address; all enumerates Server per-peer clients and JVM max/total/free memory, uses live collection size then array. POST34-35 calls superclass doGet, not local handler.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/ManageServlet.java:24-31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L24-L31): Delegates the requested management action to handleManage and writes the resulting response.
- [`doPost` — src/com/nozha/async/server/httpserver/ManageServlet.java:33-36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L33-L36): Observed operation: `super.doGet(req, resp);`.
- [`handleManage` — src/com/nozha/async/server/httpserver/ManageServlet.java:38-151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L38-L151): Dispatches management operations by action/path and token, invoking their backing services and mapping success/failure to responses; the exact route matrix is recorded in the class narrative.

Direct product dependency declarations: `com.nozha.async.server.Server`, `com.nozha.async.server.client.Client`, `com.nozha.async.server.client.WebsocketClient`, `com.nozha.async.server.handler.WebsocketHandler`, `com.nozha.async.server.util.BlockingQueueMap`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L246): `context.addServlet(new ServletHolder("manage-peers", ManageServlet.class), "/manage/*"); `

## Business

SOURCE_OBSERVED: Diagnostic caller can see peer connections and addresses without local authentication. It is a live snapshot, not coherent audit/export.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No local catches or validation. Concurrent collection changes may affect array indexing carr[0]; unescaped addresses appended into HTML. Reproduce empty/changing client map and crafted address for output encoding review. Unknown network gating.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

NO_LOG_IN_CLASS. Request access log/status through EmbeddedHttpServer336-346/HttpRequestLogger; no dedicated audit trail of diagnostic viewing.

### Owned call-site registry reconciliation

NO_LOG_IN_CLASS for direct logger call sites. Helper/stderr observations and caller logging above are separate, not missing direct calls.

Reconciled 0 executable direct logger sites against 0 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

### Exact enclosing method and local guard evidence


RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-messagesaverservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/MessageSaverServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java
source_sha256: 9454abd2691d414bd276b9eb42a2db2674c55dac777165fe999db9e7a1670270
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# MessageSaverServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/MessageSaverServlet.java:23-38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L23-L38) PUT only exact /update with conditional auth40-51; bad path400/auth401. doAction57-68 sets global IS_INSERT_TO_DB_ENABLE via Boolean.parseBoolean(insertToDB), ResultResponse200/update done then log. path helper53-55 excludes trailing slash.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doPut` — src/com/nozha/async/server/httpserver/MessageSaverServlet.java:22-38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L22-L38): Requires authorization, dispatches the supported message-save action and returns its result; unsupported action or service failure becomes an error response.
- [`checkToken` — src/com/nozha/async/server/httpserver/MessageSaverServlet.java:40-51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L40-L51): Validates the configured saver token and throws/returns unauthorized on missing or invalid credentials.
- [`isUpdateAction` — src/com/nozha/async/server/httpserver/MessageSaverServlet.java:53-55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L53-L55): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/update"));`.
- [`doAction` — src/com/nozha/async/server/httpserver/MessageSaverServlet.java:57-68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L57-L68): Parses the submitted save request and calls the message persistence operation; serializes the operation result, while parse/persistence exceptions follow the servlet error mapping.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:277](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L277): `context.addServlet(new ServletHolder("message-saver", MessageSaverServlet.class), "/message-saver/*"); `

## Business

SOURCE_OBSERVED: Admin can enable/disable message DB insertion for subsequent consumers; missing/unrecognized parameter becomes false, not rejected. Node-local mutable Settings is not distributed update guarantee.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Missing Authorization/short header ServerException; response IO propagates. No boolean schema validation. Reproduce omitted insertToDB and mixed text and verify flag false; actual persistence consumers must be checked separately.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:33-35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L33-L35): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:42-44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L42-L44): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:50-52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L50-L52): `throw new ServerException("invalid token"); } `

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO67 after response flush shows resulting boolean, no actor/UUID/old value. Does not prove all in-flight writes obey new value.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L67) | INFO | `logger.info("IS_INSERT_TO_DB_ENABLE updated successfully, insertToDB {}", Settings.IS_INSERT_TO_DB_ENABLE);` | ALOG-639A0E992E56 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L67) in `doAction`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-mqttservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/MqttServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java
source_sha256: d7e0dd1dfc65050fdb342065a61dc5c22c06074eaeab1a7b6eba25cb160c9935
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# MqttServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/MqttServlet.java:28-75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L28-L75) GET only /device or /device/ requires header and nonempty inputQueueName, checkToken77-84 requires active Keylead device-admin and strips six chars, PeerCRUD returns PeerDto list. Response JSON status/data or message; isDeviceAction86-89.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/MqttServlet.java:27-75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L27-L75): Validates the request token and WebSocket/MQTT handshake inputs, then delegates connection setup; invalid inputs or handshake errors terminate with the servlet failure response.
- [`checkToken` — src/com/nozha/async/server/httpserver/MqttServlet.java:77-84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L77-L84): Validates the configured MQTT token and rejects missing/invalid credentials before handshake processing.
- [`isDeviceAction` — src/com/nozha/async/server/httpserver/MqttServlet.java:86-89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L86-L89): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/device") || pathInfo.equalsIgnoreCase("/device/"));`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.dto.PeerDto`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:267](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L267): `context.addServlet(new ServletHolder("mqtt-events", MqttServlet.class), "/mqtt/*"); `

## Business

SOURCE_OBSERVED: Device administrator lists MQTT registrations for queue name; unlike many admin endpoints inactive identity service returns unavailable.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Missing Authorization400 "Full authentication is required to access this resource", missing queue400 mandatory, invalid path400, ServerException401 Token unAuthorized, HttpException own status (inactive503 Service Unavailable), generic500 Internal server error. Too-short nonempty header causes substring failure500. UUID reference only logged, not returned. Reproduce all.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/MqttServlet.java:56-58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L56-L58): `} catch (ServerException e) { result.put("message", "Token unAuthorized"); result.put("status", HttpServletResponse.SC_UNAUTHORIZED);`
- [src/com/nozha/async/server/httpserver/MqttServlet.java:60-62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L60-L62): `} catch (HttpException e) { result.put("message", e.getMessage()); result.put("status", e.getStatusCode());`
- [src/com/nozha/async/server/httpserver/MqttServlet.java:64-66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L64-L66): `} catch (Exception e) { String reference = UUID.randomUUID().toString(); result.put("message", "Internal server error");`
- [src/com/nozha/async/server/httpserver/MqttServlet.java:82-84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L82-L84): `throw new HttpException("Service Unavailable", HttpServletResponse.SC_SERVICE_UNAVAILABLE); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

ERROR69 generic exception reference UUID+stack, no reference response field or requestId. Expected validation/auth failures not logged locally; correlation via request log/time.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/MqttServlet.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L69) | ERROR | `logger.error("An exception occurred in MqttServlet reference={}", reference, e);` | ALOG-E945C9928A2B |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/MqttServlet.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L69) in `doGet`: catch_clause at 64: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-paymentcoreservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/PaymentCoreServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java
source_sha256: ccbc2f3f7b8917a554a562728a02c5c2eebbd20bbd5f0d932fccb064b8ba9430
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# PaymentCoreServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:24-30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L24-L30) custom PATCH dispatch. doGet33-37 overrides request virtual-host destination with CORE_PAY_CALLBACK_PEER_NAME, delegates receiveMessage then logs origin. POST/PUT/DELETE/PATCH40-55 delegate. Mounted /pbc/buythePEPcallback and /*.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`service` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:23-30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L23-L30): Observed operation: `if (req.getMethod().equalsIgnoreCase("PATCH")) { doPatch(req, resp); } else { super.service(req, resp); }`.
- [`doGet` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:32-37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L32-L37): Overrides virtual-host destination with CORE_PAY_CALLBACK_PEER_NAME, delegates receiveMessage, then logs the request origin.
- [`doPost` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:39-42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L39-L42): Observed operation: `doGet(req, resp);`.
- [`doPut` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:44-47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L44-L47): Observed operation: `doGet(req, resp);`.
- [`doDelete` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:49-52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L49-L52): Observed operation: `doGet(req, resp);`.
- [`doPatch` — src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:54-56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L54-L56): Observed operation: `doGet(req, resp);`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.handler.HttpHandler`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:235](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L235): `context.addServlet(new ServletHolder("payment-core-callback", PaymentCoreServlet.class), "/pbc/buythePEPcallback"); `
- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:236](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L236): `context.addServlet(new ServletHolder("payment-core-callback", PaymentCoreServlet.class), "/pbc/buythePEPcallback/*"); `

## Business

SOURCE_OBSERVED: Routes payment callback to configured peer; no local signature/payment verification or business success interpretation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

No local catch/validation. HttpHandler mediation/access errors map downstream; configured peer presence is not checked here. Reproduce callback unknown peer and confirm final response/handler logs instead of using INFO as payment success.

### Explicit throw / catch evidence

No explicit throw/catch statement in executable class; implicit/consumer failures are described above.

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO36 raw origin after receiveMessage returns (which may start async work), no payment/request IDs or result. Proves callback handler traversal, not settlement.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L36) | INFO | `logger.info("PaymentCore request received, origin= {}", req.getHeader(Settings.ORIGIN_HEADER_NAME));` | ALOG-D9AE321CE398 |

Reconciled 1 executable direct logger sites against 1 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/PaymentCoreServlet.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/PaymentCoreServlet.java#L36) in `doGet`: No local if/catch/loop enclosure; method/caller execution still required. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-providerratelimitservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java
source_sha256: beab1df1933be65745dc975269bd8264db5dad1a8ce4c3ddbf7a6cfe269d55e0
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ProviderRateLimitServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:35-65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L35-L65) GET authenticates and returns provider blocks or GatherDto for watched/blocked paths; otherwise optional provider counters snapshots and clears each map, no bad-path guard for GET. POST69-88 path block/provider block/watch; DELETE92-113 aliases unblock/unwatch/provider unblock/root delete. action129-182 parses EndpointConfig and updates count, block provider,watch flag/remove provider; ResultResponse. validator185-210 requires provider and PeerCRUD presence, sets providerPeerId; path if present normalize/check descriptor map & contains path; blocked zero count400; path required for four path operations. helpers213-247 implement exact suffixes with optional slash and delete aliases.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:34-65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L34-L65): Authenticates and returns provider block/watch results or counter snapshots by path; counter retrieval clears gathered counters. GET has no explicit unknown-path rejection in this branch.
- [`doPost` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:68-88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L68-L88): Authenticates and dispatches block, provider-block or watch operations through the JSON body handler; unsupported suffix returns 400.
- [`doDelete` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:91-113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L91-L113): Authenticates and dispatches unblock, unwatch, provider-unblock or root provider deletion; unsupported suffix returns 400.
- [`checkToken` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:115-126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L115-L126): Validates the configured management token when authorization is enabled; failure prevents the rate-limit operation.
- [`doProviderAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:129-182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L129-L182): Parses EndpointConfig JSON and applies the selected provider/path count, block, watch or unblock operation; result is returned as ResultResponse.
- [`checkProviderRequestValidation` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:185-210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L185-L210): Requires a provider present in PeerCRUD and records its peer ID; when path is supplied it verifies the descriptor path, and path-scoped operations require a nonzero block count.
- [`isBlockAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:213-216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L213-L216): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/path/block") || pathInfo.equalsIgnoreCase("/path/block/"));`.
- [`isUnBlockAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:218-222](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L218-L222): Recognizes the exact provider-path unblock suffix, with the supported trailing-slash alias.
- [`isWatchAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:224-227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L224-L227): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/path/watch") || pathInfo.equalsIgnoreCase("/path/watch/"));`.
- [`isUnWatchAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:229-233](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L229-L233): Recognizes the exact provider watch-removal suffix, with the supported trailing-slash alias.
- [`isBlockProvidersAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:235-238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L235-L238): Observed operation: `return pathInfo != null && (pathInfo.equalsIgnoreCase("/block") || pathInfo.equalsIgnoreCase("/block/"));`.
- [`isUnBlockProvidersAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:240-244](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L240-L244): Recognizes the provider-wide unblock suffix, with the supported trailing-slash alias.
- [`isProvidersAction` — src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:246-248](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L246-L248): Observed operation: `return pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/");`.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.HttpException`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.mediation.generic.ServiceDefinitionProvider`, `com.nozha.async.server.mediation.generic.vo.Service`, `com.nozha.async.server.model.Peer`, `com.nozha.async.server.persistance.PeerCRUD`, `com.nozha.async.server.ratelimit.RateLimitService`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`, `com.nozha.async.server.vo.rateLimit.provider.GatherDto`, `com.nozha.async.server.vo.rateLimit.provider.EndpointConfig`, `com.nozha.async.server.vo.rateLimit.ResultResponse`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:270](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L270): `context.addServlet(new ServletHolder("service-limit-events", ProviderRateLimitServlet.class), "/rate-limit/provider/*"); `

## Business

SOURCE_OBSERVED: Administrative provider/path admission and watching affects future requests. Destructive GET counters means gathering is not idempotent observation.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

Auth115-126 missing/short401; validation required provider/path/invalid block count400, provider/path not found404. Inner HttpException maps code, generic500; body empty400. Parse139 outside inner catch. Negative block counts not rejected by this validator. Reproduce zero/negative count, unknown path, missing path and inactive Keylead.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:60-62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L60-L62): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:83-85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L83-L85): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:108-110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L108-L110): `} catch (ServerException e) { resp.setStatus(HttpStatus.SC_UNAUTHORIZED); resp.getWriter().write(e.getMessage());`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:117-119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L117-L119): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:125-127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L125-L127): `throw new ServerException("invalid token"); } `
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:165-167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L165-L167): `} catch (HttpException httpException) { httpStatus = httpException.getStatusCode(); message = httpException.getMessage();`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:169-171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L169-L171): `} catch (Exception e) { logger.error("An exception occurred in {} paths={}", action, body, e); httpStatus = HttpStatus.SC_INTERNAL_SERVER_ERROR;`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:187-189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L187-L189): `throw new HttpException("provider is required", HttpStatus.SC_BAD_REQUEST); } else { Peer peer = PeerCRUD.loadPeerByName(endpointConfig.getProvider());`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:191-193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L191-L193): `throw new HttpException("provider not found", HttpStatus.SC_NOT_FOUND); } endpointConfig.setProviderPeerId(peer.getId());`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:198-200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L198-L200): `throw new HttpException("provider not found", HttpStatus.SC_NOT_FOUND); } if (!providerMap.containsKey(endpointConfig.getPath()))`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:201-203](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L201-L203): `throw new HttpException("path not found", HttpStatus.SC_NOT_FOUND); if (action.equals("blocked") && endpointConfig.getCount() == 0) throw new HttpException("invalid block count", HttpStatus.SC_BAD_REQUEST);`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:203-205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L203-L205): `throw new HttpException("invalid block count", HttpStatus.SC_BAD_REQUEST);  } else {`
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:207-209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L207-L209): `throw new HttpException("path is required", HttpStatus.SC_BAD_REQUEST); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

INFO138 raw config; WARN168 expected validation includes provider/path/action; ERROR170 action/body/stack. No UUID; no separate persistence completion proof.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L138) | INFO | `logger.info("start {} {}", action, body);` | ALOG-DA18D625DA7A |
| [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L168) | WARN | `logger.warn("{} for provider={} , path={} , action={} ", message, requestConfig.getProvider(), requestConfig.getPath(), action);` | ALOG-F9D5908DB120 |
| [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L170) | ERROR | `logger.error("An exception occurred in {} paths={}", action, body, e);` | ALOG-204C6ADD39ED |

Reconciled 3 executable direct logger sites against 3 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L138) in `doProviderAction`: if_statement at 137: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L168) in `doProviderAction`: catch_clause at 165: see enclosing source; if_statement at 137: (!body.isEmpty()). Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L170) in `doProviderAction`: catch_clause at 169: see enclosing source; if_statement at 137: (!body.isEmpty()). Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Compared `generated-knowledge/operations/rate-limit-manager.md`: separate com.async AsyncManager baseline/API, not the com.nozha.async node handler; do not merge route contracts. Existing documents remain untouched candidate material, not approval evidence.

---

### dossier-src-com-nozha-async-server-httpserver-providerservicesservlet

<!-- source dossier: src/com/nozha/async/server/httpserver/ProviderServicesServlet.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java
source_sha256: ada2a248db8d4f2b6c9c711e3381ae9aef432c0f9b4b3865571a290128105bcf
business_approval: UNKNOWN
runtime_validation: NOT_RUN
promotion: NOT_PROMOTED
---

# ProviderServicesServlet — HTTP / mediation source audit

## Technical

Package `com.nozha.async.server.httpserver`; first-party ownership inferred from `com.nozha.async` namespace and imports, accountable owner UNKNOWN. Full archive file was read for this candidate audit; pinned archive provenance is reconciled by the root audit. This does not establish latest/deployed version.

[src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:23-58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L23-L58) GET conditional auth, provider and optional servicePathPart select ServiceDefinitionProvider path listing. Present result (even empty list) returns JSON200; absent provider ResultVO bad request path; null result not found. checkToken60-71. Error ResultVO writes without assigning error HTTP status.

### Method and constructor evidence

All executable declarations are listed below. Nontrivial methods are interpreted in the cited narrative above; simple storage methods list their exact observable operation. This inventory supplements semantic review and is not runtime evidence.

- [`doGet` — src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:22-58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L22-L58): Authenticates and returns provider/service metadata selected by request parameters; missing provider/service follows the not-found response path.
- [`checkToken` — src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:60-71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L60-L71): Checks the configured provider-services management token; absent or invalid authorization stops the request.

Direct product dependency declarations: `com.nozha.Settings`, `com.nozha.async.server.exception.ServerException`, `com.nozha.async.server.httpserver.vo.ResultVO`, `com.nozha.async.server.mediation.generic.ServiceDefinitionProvider`, `com.nozha.async.server.util.JsonUtil`, `com.nozha.async.server.util.KeyleadUtil`. Import presence alone does not prove runtime use. No database/queue/network effect beyond those explained above is attributed to this class.

### Upstream evidence

- [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L276): `context.addServlet(new ServletHolder("provider-services", ProviderServicesServlet.class), "/provider-services/*"); `

## Business

SOURCE_OBSERVED: Admin inspects advertised services; caller must inspect body success because malformed/auth failures can remain default200.

APPROVED_INTENT: UNKNOWN. Accountable product/security owner, actual callers, deployment enablement and SLA guarantees require human/runtime evidence. INFERENCE: ownership and potential consumer impact are inferred from the cited implementation; no production incident is asserted.

## Errors

ServerException and general Exception captured separately, content e.getMessage; missing provider/not found are ResultVO(false), not 400/404. IO final writer propagates. Case-mixed provider filtering can hit provider lookup bug downstream. Reproduce auth denied and compare body vs HTTP code.

### Explicit throw / catch evidence

- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:46-48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L46-L48): `} catch (ServerException e) { logger.error("An ServerException occurred in RateLimitManagerServlet", e); rs = new ResultVO(false, e.getMessage());`
- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:49-51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L49-L51): `} catch (Exception e) { logger.error("An Exception occurred in RateLimitManagerServlet", e); rs = new ResultVO(false, e.getMessage());`
- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:62-64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L62-L64): `throw new ServerException("Authorization is required"); String token = req.getHeader("Authorization"); if (token != null && token.length() > 6) {`
- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:70-72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L70-L72): `throw new ServerException("invalid token"); } }`

Boundary ideas above are reproducible static-review hypotheses, NOT executed tests. Runtime exception/status differences, container behavior, dependency schema and traffic effects remain UNKNOWN until tested.

## Logs and RCA

ERROR47/50 wrong literal class "RateLimitManagerServlet", each stack; actual logger belongs ProviderServicesServlet. Search logger identity, not literal class only; no request correlation or params.

### Owned call-site registry reconciliation

| Site | Level | Exact call and fields | Existing registry ID |
|---|---|---|---|
| [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L47) | ERROR | `logger.error("An ServerException occurred in RateLimitManagerServlet", e);` | ALOG-DE08DFEAB4F7 |
| [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L50) | ERROR | `logger.error("An Exception occurred in RateLimitManagerServlet", e);` | ALOG-FADFE4574B0B |

Reconciled 2 executable direct logger sites against 2 existing registry rows. No unmatched owned registry rows. Registry control-flow heuristics are not promoted to runtime facts. Commented code was excluded from executable call inventory.

Source appender evidence: `resources/log4j2.xml:59-61` AsyncRoot INFO→DG2 `async.log` (`:3-10`), named PODLOG→pod_monitoring.log (`:30-38,71-73`) where used. Actual runtime logging backend/levels/path/retention overrides UNKNOWN; DEBUG absence is not proof that branch did not run.

### Exact enclosing method and local guard evidence

- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L47) in `doGet`: catch_clause at 46: see enclosing source. Caller and prior stage conditions are explained above.
- [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L50) in `doGet`: catch_clause at 49: see enclosing source. Caller and prior stage conditions are explained above.

RCA procedure: search exact template/logger and level from site table in a bounded time/server window; match original request path/status in HTTPLOG when ADD_HTTP_REQUEST_LOG enables it, then follow caller UUID/ARN only where actually emitted. A class log proves traversal of its guarded statement, not downstream ACK, durable persistence, approved business success or complete response. Keep raw credentials, body, query, IP/user identifiers out of knowledge copies.

### Existing knowledge comparison

Compared `generated-knowledge/security/security-implementation.md`: broad conditional-access statement agrees, but exact route/token/status behavior here is more specific; security policy and production enforcement remain unknown. Existing documents remain untouched candidate material, not approval evidence.
