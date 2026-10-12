# Async class dossiers — review batch 14


---

### dossier-src-com-nozha-async-server-util-blockingqueuemap

<!-- source dossier: src/com/nozha/async/server/util/BlockingQueueMap.md -->

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
source_path: src/com/nozha/async/server/util/BlockingQueueMap.java
source_sha256: 630b2b3f4ce34e44d35e19517fcc1da7e15df5e30ba29af2afe10295fe74dc50
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java
business_approved: false
runtime_tested: false
promoted: false
---

# BlockingQueueMap — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `BlockingQueueMap` (class_declaration) [src/com/nozha/async/server/util/BlockingQueueMap.java:8–133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L8-L133)
Two HashMaps free/used under lock for mutating pool operations; public read/values/freeKeySet operations are outside lock.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Timed acquire uses deadline but waits full lockTimeout, can overshoot. Returned freeKeySet is live mutable view; direct callers can bypass synchronization. put may add a key still in usedMap, duplicating logical lease.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `lock` | `Object` | [src/com/nozha/async/server/util/BlockingQueueMap.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L9) |
| `freeMap` | `HashMap<K, V>` | [src/com/nozha/async/server/util/BlockingQueueMap.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L10) |
| `usedMap` | `HashMap<K, V>` | [src/com/nozha/async/server/util/BlockingQueueMap.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L11) |
| `lockTimeout` | `long` | [src/com/nozha/async/server/util/BlockingQueueMap.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L12) |
| `splittableRandom` | `SplittableRandom` | [src/com/nozha/async/server/util/BlockingQueueMap.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L13) |
Dependencies are imports (some may be unused): `java.util.*` [src/com/nozha/async/server/util/BlockingQueueMap.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L80) ` private Map<Long, BlockingQueueMap<Long, Client>> clientsMapByPeer = Collections.synchronizedMap(new HashMap<>());`; [src/com/nozha/async/server/httpserver/ManageServlet.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L95) ` Map<Long, BlockingQueueMap<Long, Client>> clients = Server.getInstance().getClientsMapByPeer();`; [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L14) ` static BlockingQueueMap<Long, RateLimitKafkaProducer> kafkaProducers = new BlockingQueueMap<>(Settings.RATE_LIMIT_KAFKA_PRODUCER_COUNT);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BlockingQueueMap(long lockTimeout)` | Store wait interval. | [src/com/nozha/async/server/util/BlockingQueueMap.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L15-L17) |
| `public int size()` | Sum free/used sizes without lock. | [src/com/nozha/async/server/util/BlockingQueueMap.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L19-L21) |
| `public boolean isEmpty()` | Test size zero. | [src/com/nozha/async/server/util/BlockingQueueMap.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L23-L25) |
| `public boolean containsKey(K key)` | Check either map key without lock. | [src/com/nozha/async/server/util/BlockingQueueMap.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L27-L29) |
| `public boolean containsValue(V value)` | Check either map value without lock. | [src/com/nozha/async/server/util/BlockingQueueMap.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L31-L33) |
| `public V acquire()` | Lock; while value null and pool nonempty take first free entry→used; if unavailable wait configured interval; wrap interruption. Empty pool immediately null; no deadline. | [src/com/nozha/async/server/util/BlockingQueueMap.java:35–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L35-L55) |
| `public V acquire(long timeout)` | Set wall-clock deadline; lock, while nonempty before deadline randomly select free key→used, otherwise wait full configured interval; null on expiration/empty. | [src/com/nozha/async/server/util/BlockingQueueMap.java:57–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L57-L80) |
| `public V acquireNoWait(K key)` | Under lock remove requested free key, move non-null value to used; never wait. | [src/com/nozha/async/server/util/BlockingQueueMap.java:82–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L82-L91) |
| `public void release(K key)` | Under lock used→free if value exists; notifyAll even absent. | [src/com/nozha/async/server/util/BlockingQueueMap.java:93–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L93-L101) |
| `public V put(K key, V value)` | Under lock insert free key, notifyAll, return previous value. | [src/com/nozha/async/server/util/BlockingQueueMap.java:103–109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L103-L109) |
| `public V remove(K key)` | Under lock remove free first else used, notifyAll, return removed value. | [src/com/nozha/async/server/util/BlockingQueueMap.java:111–121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L111-L121) |
| `public Collection<V> values()` | Build combined list snapshot without lock over underlying maps. | [src/com/nozha/async/server/util/BlockingQueueMap.java:123–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L123-L127) |
| `public Set<K> freeKeySet()` | Return live free key set without lock. | [src/com/nozha/async/server/util/BlockingQueueMap.java:129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L129-L131) |

## Business
SOURCE_OBSERVED: Indirect shared client/Kafka producer lease mechanism; acquire returns null when pool empty or deadline elapsed.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
InterruptedException wraps RuntimeException without restoring interrupt (47–48,72–73). Invalid negative lockTimeout can fail wait; zero can wait indefinitely.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `acquire` | `} catch (InterruptedException e) {` | [src/com/nozha/async/server/util/BlockingQueueMap.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L47) |
| throw_statement / `acquire` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/BlockingQueueMap.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L48) |
| catch_clause / `acquire` | `} catch (InterruptedException e) {` | [src/com/nozha/async/server/util/BlockingQueueMap.java:72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L72) |
| throw_statement / `acquire` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/BlockingQueueMap.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/BlockingQueueMap.java#L73) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L80), [src/com/nozha/async/server/httpserver/ManageServlet.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ManageServlet.java#L95), [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L14).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-byteutil

<!-- source dossier: src/com/nozha/async/server/util/ByteUtil.md -->

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
source_path: src/com/nozha/async/server/util/ByteUtil.java
source_sha256: 6c4947a20b1185a6a9f73f7b1fbd58366f21208ffae7bfb72fd23d411321720f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# ByteUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `ByteUtil` (class_declaration) [src/com/nozha/async/server/util/ByteUtil.java:9–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L9-L76)
Big-endian fixed-width long/int byte conversions and reversed BigInteger representation; string conversions use platform charset.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
reverse and asBigInteger mutate caller-owned byte array.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `EMPTY_BYTES` | `byte[]` | [src/com/nozha/async/server/util/ByteUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L10) |
| `LONG_LENGTH` | `int` | [src/com/nozha/async/server/util/ByteUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L11) |
| `INT_LENGTH` | `int` | [src/com/nozha/async/server/util/ByteUtil.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L12) |
Dependencies are imports (some may be unused): `java.math.BigInteger` [src/com/nozha/async/server/util/ByteUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L3); `java.nio.ByteBuffer` [src/com/nozha/async/server/util/ByteUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L4)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/TcpHandler.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L84) ` outputStream.write(ByteUtil.getBytes(bytes.length));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static long getLong(byte[] bytes)` | Delegate long decode offset0. | [src/com/nozha/async/server/util/ByteUtil.java:14–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L14-L16) |
| `public static long getLong(byte[] bytes, int offset)` | Fold LONG_LENGTH bytes left by LONG_LENGTH bits masking 0xff; default gives big-endian eight-byte long. | [src/com/nozha/async/server/util/ByteUtil.java:18–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L18-L24) |
| `public static int getInt(byte[] bytes)` | Delegate int decode offset0. | [src/com/nozha/async/server/util/ByteUtil.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L26-L28) |
| `public static int getInt(byte[] bytes, int offset)` | Fold INT_LENGTH bytes left by LONG_LENGTH bits; default big-endian four-byte int. | [src/com/nozha/async/server/util/ByteUtil.java:30–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L30-L36) |
| `public static byte[] getBytes(BigInteger bi)` | Get signed BigInteger byte array then reverse order in new array. | [src/com/nozha/async/server/util/ByteUtil.java:38–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L38-L46) |
| `public static byte[] getBytes(long l)` | Allocate configured length ByteBuffer and put long big-endian. | [src/com/nozha/async/server/util/ByteUtil.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L48-L50) |
| `public static byte[] getBytes(int i)` | Allocate configured length ByteBuffer and put int big-endian. | [src/com/nozha/async/server/util/ByteUtil.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L52-L54) |
| `public static byte[] getBytes(String s)` | String bytes with default charset. | [src/com/nozha/async/server/util/ByteUtil.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L56-L58) |
| `public static void reverse(byte[] bytes)` | Swap symmetric positions in supplied byte array. | [src/com/nozha/async/server/util/ByteUtil.java:60–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L60-L66) |
| `public static BigInteger asBigInteger(byte[] bytes)` | Reverse caller array then construct signed BigInteger. | [src/com/nozha/async/server/util/ByteUtil.java:68–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L68-L71) |
| `public static String asString(byte[] bytes)` | Decode bytes via platform default charset. | [src/com/nozha/async/server/util/ByteUtil.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ByteUtil.java#L73-L75) |

## Business
SOURCE_OBSERVED: Indirect wire serialization helper, no business policy.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No local validation/catch: null arrays/String/BigInteger NPE; offset/length may cause array bounds errors. Public mutable LONG_LENGTH/INT_LENGTH can alter encoding.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/TcpHandler.java:84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L84).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-cachecrudinterface

<!-- source dossier: src/com/nozha/async/server/util/CacheCRUDInterface.md -->

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
source_path: src/com/nozha/async/server/util/CacheCRUDInterface.java
source_sha256: d32447e51fcf0ea00b45e6e716cd127a99ff67e0ff344c55c7beee16d61e54f7
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java
business_approved: false
runtime_tested: false
promoted: false
---

# CacheCRUDInterface — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `CacheCRUDInterface` (interface_declaration) [src/com/nozha/async/server/util/CacheCRUDInterface.java:8–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L8-L59)
Interface declares message/open counters, client routing, tracker routing, server index, last-seen, provisioning, server/global invalidation contracts (9–58).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `java.util.List` [src/com/nozha/async/server/util/CacheCRUDInterface.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L19) `public class MemoryCacheCRUD implements CacheCRUDInterface, CaffeineCacheCRUDInterface {`; [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L5) `public interface ResilientCacheInterface extends CacheCRUDInterface, FallBack {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `void putMessage( long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout );` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:9–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L9-L16) |
| `void openClient(String remoteAddress, int clientType, long time, long expireTimeout);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L18) |
| `long countMessagesByReceiver(long receiverId, long toTime);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L20) |
| `long countMessagesBySender(long senderId, long toTime);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L22) |
| `long countMessagesBySenderRemoteAddress(String remoteAddress, long toTime);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L24) |
| `long countOpenedClientByRemoteAddress(String remoteAddress, long toTime);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L26) |
| `void putClientCache(long key, List<Long> serverIds);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L28) |
| `void invalidateClientCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L30) |
| `List<Long> getClientCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L32) |
| `void putTrackerCache(long key, Long serverId);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L34) |
| `void invalidateTrackerCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L36) |
| `Long getTrackerCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L38) |
| `void putClientServerIndexCache(long key, int index);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L40) |
| `void invalidateClientServerIndexCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L42) |
| `Integer getClientServerIndexCache(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L44) |
| `void putClientLastSeen(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L46) |
| `void invalidateClientLastSeen(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L48) |
| `Long getClientLastSeen(long key);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L50) |
| `void putProvision(String peerNameDestination, long expireTimeout);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L52) |
| `long countProvisionByDestination(String peerNameDestination);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L54) |
| `void invalidateClientCacheByServerId(long serverId);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L56) |
| `void invalidateAllClientCache();` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CacheCRUDInterface.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheCRUDInterface.java#L58) |

## Business
SOURCE_OBSERVED: Indirect cache abstraction used in admission, identity/delivery routing and provision limits. Contract does not guarantee consistency, persistence, sentinel or errors.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; implementation semantics differ substantially (Aerospike sentinel -1, Redis stubs, memory misses null).
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L19), [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L5).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-cacheutil

<!-- source dossier: src/com/nozha/async/server/util/CacheUtil.md -->

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
source_path: src/com/nozha/async/server/util/CacheUtil.java
source_sha256: 378eb93c7fbd38cab27a9c8266f25db1daf975332abc9c26917406eaf6dc8565
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# CacheUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `CacheUtil` (class_declaration) [src/com/nozha/async/server/util/CacheUtil.java:12–124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L12-L124)
Facade instantiates AerospikeCRUD and MemoryCacheCRUD (15–16); all routing/counter/last-seen/provision operations delegate Aerospike, while peer object lookups use memory.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Static backend objects; methods do not use FallBack.available to switch to memory or Redis.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `AEROSPIKE_CACHE` | `String` | [src/com/nozha/async/server/util/CacheUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L13) |
| `aerospikeCRUD` | `AerospikeCRUD` | [src/com/nozha/async/server/util/CacheUtil.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L15) |
| `memoryCacheCRUD` | `MemoryCacheCRUD` | [src/com/nozha/async/server/util/CacheUtil.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L16) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/CacheUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L3); `com.nozha.async.server.model.Peer` [src/com/nozha/async/server/util/CacheUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L4); `com.nozha.async.server.util.nosql.aerospike.AerospikeCRUD` [src/com/nozha/async/server/util/CacheUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L5); `java.util.List` [src/com/nozha/async/server/util/CacheUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L7)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/CoapHandler.java:173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L173) ` long count = CacheUtil.countProvisionByDestination(peerName);`; [src/com/nozha/async/server/biz/RegistrationManager.java:202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L202) ` Long lastSeenTime = CacheUtil.getClientLastSeen(peerId);`; [src/com/nozha/async/server/biz/LoadManager.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L30) ` CacheUtil.putMessage(receiverId, senderId, senderRemoteAddress, clientType, time, expireTimeout);`; [src/com/nozha/async/server/httpserver/CacheServlet.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L23) ` CacheUtil.invalidateAllClientCache();`; [src/com/nozha/async/server/persistance/ClientCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L51) ` CacheUtil.putClientCache(peerId, clientCRUDInterface.findReceiverServersByPeer(peerId));`; [src/com/nozha/async/server/persistance/PeerCRUD.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L45) ` Peer peer = CacheUtil.getById(id);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void putMessage( long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout )` | Delegate exact operation `aerospikeCRUD.putMessage(receiverId, senderId, senderRemoteAddress, clientType, time, expireTimeout);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:18–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L18-L27) |
| `public static void openClient(String remoteAddress, int clientType, long time, long expireTimeout)` | Delegate exact operation `aerospikeCRUD.openClient(remoteAddress, clientType, time, expireTimeout);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L29-L31) |
| `public static long countMessagesByReceiver(long receiverId, long toTime)` | Delegate exact operation `return aerospikeCRUD.countMessagesByReceiver(receiverId, toTime);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L33-L35) |
| `public static long countMessagesBySender(long senderId, long toTime)` | Delegate exact operation `return aerospikeCRUD.countMessagesBySender(senderId, toTime);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L37-L39) |
| `public static long countMessagesBySenderRemoteAddress(String remoteAddress, long toTime)` | Delegate exact operation `return aerospikeCRUD.countMessagesBySenderRemoteAddress(remoteAddress, toTime);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L41-L43) |
| `public static long countOpenedClientByRemoteAddress(String remoteAddress, long toTime)` | Delegate exact operation `return aerospikeCRUD.countOpenedClientByRemoteAddress(remoteAddress, toTime);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:45–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L45-L47) |
| `public static void putClientCache(long key, List<Long> serverIds)` | Delegate exact operation `aerospikeCRUD.putClientCache(key, serverIds);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L49-L51) |
| `public static void invalidateClientCache(long key)` | Delegate exact operation `aerospikeCRUD.invalidateClientCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L53-L55) |
| `public static void invalidateClientCacheByServerId(long serverId)` | Delegate exact operation `aerospikeCRUD.invalidateClientCacheByServerId(serverId);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L56-L58) |
| `public static void invalidateAllClientCache()` | Delegate exact operation `aerospikeCRUD.invalidateAllClientCache();`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L59-L61) |
| `public static List<Long> getClientCache(long key)` | Delegate exact operation `return aerospikeCRUD.getClientCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L63-L65) |
| `public static void putClientLastSeen(long key)` | Delegate exact operation `aerospikeCRUD.putClientLastSeen(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:66–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L66-L68) |
| `public static void invalidateClientLastSeen(long key)` | Delegate exact operation `aerospikeCRUD.invalidateClientLastSeen(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L70-L72) |
| `public static Long getClientLastSeen(long key)` | Delegate exact operation `return aerospikeCRUD.getClientLastSeen(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:74–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L74-L76) |
| `public static void putTrackerCache(long key, Long serverId)` | Delegate exact operation `aerospikeCRUD.putTrackerCache(key, serverId);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L78-L80) |
| `public static void invalidateTrackerCache(long key)` | Delegate exact operation `aerospikeCRUD.invalidateTrackerCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L82-L84) |
| `public static Long getTrackerCache(long key)` | Delegate exact operation `return aerospikeCRUD.getTrackerCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:86–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L86-L88) |
| `public static void putClientServerIndexCache(long key, int index)` | Delegate exact operation `aerospikeCRUD.putClientServerIndexCache(key, index);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:90–92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L90-L92) |
| `public static void invalidateClientServerIndexCache(long key)` | Delegate exact operation `aerospikeCRUD.invalidateClientServerIndexCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:94–96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L94-L96) |
| `public static Integer getClientServerIndexCache(long key)` | Delegate exact operation `return aerospikeCRUD.getClientServerIndexCache(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:98–100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L98-L100) |
| `public static void putProvision(String peerNameDestination,long expireTimeout)` | Delegate exact operation `aerospikeCRUD.putProvision(peerNameDestination,expireTimeout);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L102) |
| `public static long countProvisionByDestination(String peerNameDestination)` | Delegate exact operation `return aerospikeCRUD.countProvisionByDestination(peerNameDestination);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L104) |
| `public static void cachePeer(Peer peer)` | Delegate exact operation `memoryCacheCRUD.cachePeer(peer);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:106–108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L106-L108) |
| `public static Peer getById(long id)` | Delegate exact operation `return memoryCacheCRUD.getById(id);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:110–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L110-L112) |
| `public static Peer getByName(String name)` | Delegate exact operation `return memoryCacheCRUD.getByName(name);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/CacheUtil.java:114–116](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L114-L116) |
| `public static void resetMapping(int serverId)` | If CACHE_VENDOR exactly equals aerospike invalidate current server routing; otherwise invalidate all client routing. Null vendor NPE. | [src/com/nozha/async/server/util/CacheUtil.java:118–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L118-L123) |

## Business
SOURCE_OBSERVED: Indirect load/routing/identity acceleration. CACHE_VENDOR only chooses per-server vs global reset in this class; it does not select backend for all methods.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No catch: wrappers preserve downstream returns/errors. Aerospike suppresses many failures; see its dossier rather than assume successful cache mutation.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/CoapHandler.java:173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L173), [src/com/nozha/async/server/biz/RegistrationManager.java:202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L202), [src/com/nozha/async/server/biz/LoadManager.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L30), [src/com/nozha/async/server/httpserver/CacheServlet.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/CacheServlet.java#L23), [src/com/nozha/async/server/persistance/ClientCRUD.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L51), [src/com/nozha/async/server/persistance/PeerCRUD.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/PeerCRUD.java#L45).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-caffeinecachecrudinterface

<!-- source dossier: src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.md -->

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
source_path: src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java
source_sha256: 1793952f74d4465ff3cfe25e77b2360574a9cc9878ee855e240f0522e20dc3c3
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java
business_approved: false
runtime_tested: false
promoted: false
---

# CaffeineCacheCRUDInterface — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `CaffeineCacheCRUDInterface` (interface_declaration) [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:10–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L10-L26)
Interface owns two shared cache constants keyed peer ID/name, max size MAX_PEER_CACHE_SIZE and expireAfterAccess PEER_CACHE_TTL milliseconds (11–19).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.github.benmanes.caffeine.cache.Cache` [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L3); `com.github.benmanes.caffeine.cache.Caffeine` [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L4); `com.nozha.Settings` [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L5); `com.nozha.async.server.model.Peer` [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L6); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L19) `public class MemoryCacheCRUD implements CacheCRUDInterface, CaffeineCacheCRUDInterface {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `void cachePeer(Peer peer);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L21) |
| `Peer getById(long id);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L23) |
| `Peer getByName(String name);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CaffeineCacheCRUDInterface.java#L25) |

## Business
SOURCE_OBSERVED: Indirect peer lookup acceleration; interface objects are shared across implementers, not instance-isolated.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class methods; invalid cache builder settings can fail static field initialization. Contract alone does not emit diagnostics.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L19).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-clienthelper

<!-- source dossier: src/com/nozha/async/server/util/ClientHelper.md -->

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
source_path: src/com/nozha/async/server/util/ClientHelper.java
source_sha256: 90dc4de53c72ae5f121819c7a7b80a5db7d92d153e704f8b456cf8ab3d6480cb
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java
business_approved: false
runtime_tested: false
promoted: false
---

# ClientHelper — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `ClientHelper` (class_declaration) [src/com/nozha/async/server/util/ClientHelper.java:8–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L8-L24)
Maps exact concrete class names to numeric client type codes (9–22).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.nozha.async.server.client.*` [src/com/nozha/async/server/util/ClientHelper.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/MessageManager.java:153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L153) ` if (Settings.CHECK_WEBSOCKET && ClientHelper.getType(client.getClass()) == 8)`; [src/com/nozha/async/server/biz/AccessibilityService.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L39) ` if (Settings.ENABLE_ACCESS_CLIENT_TYPES.contains(ClientHelper.getType(client.getClass()))) {`; [src/com/nozha/async/server/biz/LoadManager.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L38) ` int type = ClientHelper.getType(client.getClass());`; [src/com/nozha/async/server/client/HttpClient.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L29) ` private static final int type = ClientHelper.getType(HttpClient.class);`; [src/com/nozha/async/server/client/CoapClient.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L21) ` private static int type = ClientHelper.getType(CoapClient.class);`; [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L27) ` private static int type = ClientHelper.getType(ActiveMQStompQueueClient.class);`; [src/com/nozha/async/server/client/TcpClient.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L17) ` private static int type = ClientHelper.getType(TcpClient.class);`; [src/com/nozha/async/server/client/WebsocketClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L30) ` private static final int type = ClientHelper.getType(WebsocketClient.class);`; [src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/RabbitMQAMQPQueueClient.java#L17) ` private static int type = ClientHelper.getType(RabbitMQAMQPQueueClient.class);`; [src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQAMQPQueueClient.java#L27) ` private static int type = ClientHelper.getType(ActiveMQAMQPQueueClient.class);`; [src/com/nozha/async/server/client/MqttClient.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/MqttClient.java#L21) ` private static int type = ClientHelper.getType(MqttClient.class);`; [src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQOpenWireQueueClient.java#L25) ` private static final int type = ClientHelper.getType(ActiveMQOpenWireQueueClient.class);`; [src/com/nozha/async/server/client/WebrtcClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L30) ` private static final int type = ClientHelper.getType(WebrtcClient.class);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static int getType(Class clientClass)` | Start0; compare exact names for HTTP2, TCP4, WebSocket8, OpenWire16, AMQP32, Rabbit64, Stomp128, MQTT256, CoAP288, WebRTC1024. Independent if statements return matching type; unknown remains0. | [src/com/nozha/async/server/util/ClientHelper.java:9–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientHelper.java#L9-L23) |

## Business
SOURCE_OBSERVED: Indirect transport-specific access/load selection. Subclasses not exactly matching supported names get 0; CoAP is0x120, not a single-bit power.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Null Class NPE; no catch/status mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/MessageManager.java:153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L153), [src/com/nozha/async/server/biz/AccessibilityService.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L39), [src/com/nozha/async/server/biz/LoadManager.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java#L38), [src/com/nozha/async/server/client/HttpClient.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/HttpClient.java#L29), [src/com/nozha/async/server/client/CoapClient.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L21), [src/com/nozha/async/server/client/ActiveMQStompQueueClient.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/ActiveMQStompQueueClient.java#L27), [src/com/nozha/async/server/client/TcpClient.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/TcpClient.java#L17), [src/com/nozha/async/server/client/WebsocketClient.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebsocketClient.java#L30).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-clientpoolfactory

<!-- source dossier: src/com/nozha/async/server/util/ClientPoolFactory.md -->

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
source_path: src/com/nozha/async/server/util/ClientPoolFactory.java
source_sha256: bf4fa2839fabfd073e917f8d5789b6e278c4cf30a5cb330b1b845f20e2fbfa2a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java
business_approved: false
runtime_tested: false
promoted: false
---

# ClientPoolFactory — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `ClientPoolFactory` (class_declaration) [src/com/nozha/async/server/util/ClientPoolFactory.java:10–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L10-L33)
Commons Pool adapter; create returns null, wrap returns DefaultPooledObject subclass overriding synchronized invalidate.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
invalidate first marks parent invalid then destroys object; destruction failure leaves invalid state.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.nozha.async.server.client.Client` [src/com/nozha/async/server/util/ClientPoolFactory.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L3); `org.apache.commons.pool2.BasePooledObjectFactory` [src/com/nozha/async/server/util/ClientPoolFactory.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L4); `org.apache.commons.pool2.PooledObject` [src/com/nozha/async/server/util/ClientPoolFactory.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L5); `org.apache.commons.pool2.impl.DefaultPooledObject` [src/com/nozha/async/server/util/ClientPoolFactory.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L6); `java.io.IOException` [src/com/nozha/async/server/util/ClientPoolFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L8)
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public T create() throws Exception` | Return null; no client construction. | [src/com/nozha/async/server/util/ClientPoolFactory.java:12–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L12-L15) |
| `@Override public PooledObject<T> wrap(T socketWrapper)` | Wrap socket object in pooled holder with overridden invalidate. | [src/com/nozha/async/server/util/ClientPoolFactory.java:17–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L17-L32) |
| `@Override public synchronized void invalidate()` | Synchronized: invalidate parent, destroy wrapped client with status0; ignore IOException. | [src/com/nozha/async/server/util/ClientPoolFactory.java:20–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L20-L28) |

## Business
SOURCE_OBSERVED: Indirect client lifecycle wrapper, not a usable autonomous factory without overriding create.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
invalidate catches IOException from client.destroy(0) silently; null object or other runtime error propagates. No local log.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `invalidate` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/ClientPoolFactory.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ClientPoolFactory.java#L25) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. No source-evidenced caller emitter found by class-name scan.
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-gstutil

<!-- source dossier: src/com/nozha/async/server/util/GstUtil.md -->

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
source_path: src/com/nozha/async/server/util/GstUtil.java
source_sha256: 86daad0c7b155398e0dcbc06e8a4c00b0810dc8e6ca0e2780044156fbc4ce9c2
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# GstUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `GstUtil` (class_declaration) [src/com/nozha/async/server/util/GstUtil.java:9–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L9-L89)
Synchronized lazy native GStreamer initialization and platform path helpers.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Sets global native name formats and suppressVersionChecks=true; requests Version1.18. configurePaths invocation commented so helpers are not active initialization behavior.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `initialized` | `boolean` | [src/com/nozha/async/server/util/GstUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L10) |
Dependencies are imports (some may be unused): `com.sun.jna.Platform` [src/com/nozha/async/server/util/GstUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L3); `org.freedesktop.gstreamer.Version` [src/com/nozha/async/server/util/GstUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L4); `java.io.File` [src/com/nozha/async/server/util/GstUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L6); `java.util.stream.Stream` [src/com/nozha/async/server/util/GstUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L7)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/client/WebrtcClient.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L158) ` GstUtil.initGst();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `private GstUtil()` | Private empty constructor. | [src/com/nozha/async/server/util/GstUtil.java:12–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L12-L13) |
| `public static final synchronized void initGst()` | Only once: platform Windows/mac/default library name formats; set global properties, print before Gst.init and after, then initialized=true. | [src/com/nozha/async/server/util/GstUtil.java:15–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L15-L32) |
| `private static void configurePaths()` | Windows resolves path but environment update is commented; mac nonempty gstPath sets or appends jna.library.path. Not called by active initGst. | [src/com/nozha/async/server/util/GstUtil.java:42–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L42-L67) |
| `private static String findWindowsLocation()` | On64bit search three GStreamer env vars, first non-null append bin with slash handling; otherwise empty. | [src/com/nozha/async/server/util/GstUtil.java:76–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L76-L88) |

## Business
SOURCE_OBSERVED: Indirect WebRTC/native media dependency; only successful init sets initialized, failure can be retried by later caller.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No catch around Gst.init/native linkage; propagate. Path property/helper can encounter runtime errors.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/client/WebrtcClient.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/WebrtcClient.java#L158).
Additional direct console/stderr diagnostics (not logger registry): [src/com/nozha/async/server/util/GstUtil.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L27) `System.out.println("Loaded version is1 " + version);`; [src/com/nozha/async/server/util/GstUtil.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/GstUtil.java#L29) `System.out.println("Loaded version is2 " + version);`
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-jsonutil

<!-- source dossier: src/com/nozha/async/server/util/JsonUtil.md -->

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
source_path: src/com/nozha/async/server/util/JsonUtil.java
source_sha256: ab99c82c4dd2d0b0e93f6f9d43e6e8948a979b63531642e8e92ba8d1de116872
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# JsonUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `JsonUtil` (class_declaration) [src/com/nozha/async/server/util/JsonUtil.java:20–110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L20-L110)
Shared Jackson mapper ignores unknown fields, allows single quotes, omits null serialized fields (23–26).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Shared mapper configured once; file writes side effect. main contains only commented sample.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/JsonUtil.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L21) |
| `mapper` | `ObjectMapper` | [src/com/nozha/async/server/util/JsonUtil.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L23) |
Dependencies are imports (some may be unused): `com.fasterxml.jackson.annotation.JsonInclude` [src/com/nozha/async/server/util/JsonUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L3); `com.fasterxml.jackson.core.JsonParser` [src/com/nozha/async/server/util/JsonUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L4); `com.fasterxml.jackson.core.JsonProcessingException` [src/com/nozha/async/server/util/JsonUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L5); `com.fasterxml.jackson.core.type.TypeReference` [src/com/nozha/async/server/util/JsonUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L6); `com.fasterxml.jackson.databind.DeserializationFeature` [src/com/nozha/async/server/util/JsonUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L7); `com.fasterxml.jackson.databind.JsonNode` [src/com/nozha/async/server/util/JsonUtil.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L8); `com.fasterxml.jackson.databind.ObjectMapper` [src/com/nozha/async/server/util/JsonUtil.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L9); `org.slf4j.Logger` [src/com/nozha/async/server/util/JsonUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L10); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/JsonUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L11); `java.io.File` [src/com/nozha/async/server/util/JsonUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L13); `java.io.IOException` [src/com/nozha/async/server/util/JsonUtil.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L14); `java.nio.charset.StandardCharsets` [src/com/nozha/async/server/util/JsonUtil.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L15)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L319) ` MessageWrapperVO messageWrapperVO = JsonUtil.getObject(msg, MessageWrapperVO.class);`; [src/com/nozha/async/server/handler/ServiceCallProxy.java:111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L111) ` RequestBody formBody = RequestBody.create(JsonUtil.getJson(params), null);`; [src/com/nozha/async/server/handler/MqttHandler.java:218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L218) ` messageWrapperVO.setContent(JsonUtil.getJson(messageVO));`; [src/com/nozha/async/server/handler/CoapHandler.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L110) ` messageVO.setContent(JsonUtil.getJson(getGenericRequestFromExchange(coapExchange)));`; [src/com/nozha/async/server/handler/ClientMessagePayload.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L28) ` return JsonUtil.getJson(clientMessage);`; [src/com/nozha/async/server/handler/HttpHandler.java:176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L176) ` String inputJson = JsonUtil.getJson(inputContent);`; [src/com/nozha/async/server/handler/RestHandler.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L178) ` JsonNode jsonNode = JsonUtil.getJsonObject(swaggerFile);`; [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/TcpHandler.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L129) ` PeerInfoVO peerInfoVO = JsonUtil.getObject(bytes, PeerInfoVO.class);`; [src/com/nozha/async/server/biz/MessageManager.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L51) ` messageVO = JsonUtil.getObject(messageWrapperVO.getContent(), MessageVO.class);`; [src/com/nozha/async/server/biz/RegistrationManager.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L123) ` RegistrationRequestVO registrationRequestVO = JsonUtil.getObject(messageWrapperVO.getContent(), RegistrationRequestVO.class);`; [src/com/nozha/async/server/httpserver/ClientServlet.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L50) ` String txt = JsonUtil.getJson(rs);`; [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L83) ` ServiceCallConfig serviceCallConfig = JsonUtil.getObject(body, ServiceCallConfig.class);`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L86) ` RateLimitConfig requestConfig = JsonUtil.getObject(body, RateLimitConfig.class);`; [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L65) ` resp.getWriter().write(JsonUtil.getJson(resultResponse));`; [src/com/nozha/async/server/httpserver/UnregisterServlet.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L74) ` writer.write(JsonUtil.getJson(rs));`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L42) ` resp.getWriter().write(JsonUtil.getJson(resultList));`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L91) ` String txt = JsonUtil.getJson(rs);`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L39) ` resp.getWriter().write(JsonUtil.getJson(resultList));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static String getJson(Object obj)` | Serialize obj; catch JsonProcessingException WARN full cause and wrap RuntimeException. | [src/com/nozha/async/server/util/JsonUtil.java:28–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L28-L35) |
| `public static <T> T getObject(byte[] json, Class<T> classOfT)` | Decode UTF8 bytes then mapper.readValue target Class; IO WARN/wrap. | [src/com/nozha/async/server/util/JsonUtil.java:37–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L37-L44) |
| `public static <T> T getObject(String json, Class<T> classOfT)` | Parse String to Class; IO WARN containing entire JSON/wrap. | [src/com/nozha/async/server/util/JsonUtil.java:46–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L46-L57) |
| `public static <T> T getObject(String json, TypeReference<T> typeReference)` | Parse String using TypeReference; IO WARN/wrap. | [src/com/nozha/async/server/util/JsonUtil.java:59–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L59-L68) |
| `public static JsonNode getJsonObject(String json)` | Null JSON returns null else tree parse; IO RuntimeException without log. | [src/com/nozha/async/server/util/JsonUtil.java:70–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L70-L77) |
| `public static JsonNode getJsonObject(File jsonFile)` | Only non-null existing file tree parse else null; IO RuntimeException without log. | [src/com/nozha/async/server/util/JsonUtil.java:79–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L79-L85) |
| `public static void writeJsonObjectToFile(JsonNode jsonNode, File jsonFile)` | If file and node both non-null write JSON file; else no-op; IO RuntimeException without log. | [src/com/nozha/async/server/util/JsonUtil.java:87–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L87-L95) |
| `public static void main(String[] args)` | No active body; sample is commented. | [src/com/nozha/async/server/util/JsonUtil.java:97–109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L97-L109) |

## Business
SOURCE_OBSERVED: Indirect JSON request/config/message interchange; permissive parsing and field omission are observed wire behavior, no validation policy.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Serialization/parser IOException catches wrap RuntimeException; WARN only getJson/getObject overloads, tree/file operations have no logging. String Class overload WARN includes entire input JSON (54), potential secrets/body exposure.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `getJson` | `} catch (JsonProcessingException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L31) |
| throw_statement / `getJson` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L33) |
| catch_clause / `getObject` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L40) |
| throw_statement / `getObject` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L42) |
| catch_clause / `getObject` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L53) |
| throw_statement / `getObject` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L55) |
| catch_clause / `getObject` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L64) |
| throw_statement / `getObject` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L66) |
| catch_clause / `getJsonObject` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L74) |
| throw_statement / `getJsonObject` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L75) |
| catch_clause / `getJsonObject` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L82) |
| throw_statement / `getJsonObject` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L83) |
| catch_clause / `writeJsonObjectToFile` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/JsonUtil.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L92) |
| throw_statement / `writeJsonObjectToFile` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/JsonUtil.java:93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L93) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| WARN `logger` / `getJson` | `("An exception occurred in getJson from object", e)` | CATCH catch (JsonProcessingException e) @31 | ALOG-F627C3B4623C | [src/com/nozha/async/server/util/JsonUtil.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L32) |
| WARN `logger` / `getObject` | `("An exception occurred in getObject from json byte array", e)` | CATCH catch (IOException e) @40 | ALOG-E91F06BC57B3 | [src/com/nozha/async/server/util/JsonUtil.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L41) |
| WARN `logger` / `getObject` | `("An exception occurred in getObject from json=" + json, e)` | CATCH catch (IOException e) @53 | ALOG-92A3D07DABF2 | [src/com/nozha/async/server/util/JsonUtil.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L54) |
| WARN `logger` / `getObject` | `("An exception occurred in getObject from json", e)` | CATCH catch (IOException e) @64 | ALOG-231B7F10FEBD | [src/com/nozha/async/server/util/JsonUtil.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L65) |
Additional direct console/stderr diagnostics (not logger registry): [src/com/nozha/async/server/util/JsonUtil.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/JsonUtil.java#L98) `System.out.println();`
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-keyleadutil

<!-- source dossier: src/com/nozha/async/server/util/KeyleadUtil.md -->

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
source_path: src/com/nozha/async/server/util/KeyleadUtil.java
source_sha256: 9f5632c02896c0f018d7a7714e96d1e76de6b970138a8daed3a002c14cba908f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# KeyleadUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `KeyleadUtil` (class_declaration) [src/com/nozha/async/server/util/KeyleadUtil.java:28–169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L28-L169)
Static OAuth endpoint configuration/client credentials; role checking and request token/business-ID helpers.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Static initialization concat on null server URL can fail even though isActive exists. Client credentials snapshot Settings at class load; lookup mapping mutable only static initialization.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/KeyleadUtil.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L29) |
| `AUTHORIZATION_KEY` | `String` | [src/com/nozha/async/server/util/KeyleadUtil.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L30) |
| `TOKEN_KEY` | `String` | [src/com/nozha/async/server/util/KeyleadUtil.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L31) |
| `lookup` | `char[]` | [src/com/nozha/async/server/util/KeyleadUtil.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L32) |
| `clientCredentials` | `ClientCredentials` | [src/com/nozha/async/server/util/KeyleadUtil.java:66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L66) |
Dependencies are imports (some may be unused): `com.fanapium.keylead.client.KeyleadClient` [src/com/nozha/async/server/util/KeyleadUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L3); `com.fanapium.keylead.client.KeyleadClientFactory` [src/com/nozha/async/server/util/KeyleadUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L4); `com.fanapium.keylead.client.config.DefaultKeyleadConfig` [src/com/nozha/async/server/util/KeyleadUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L5); `com.fanapium.keylead.client.exception.TokenInitializationException` [src/com/nozha/async/server/util/KeyleadUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L6); `com.fanapium.keylead.client.exception.UserOperationException` [src/com/nozha/async/server/util/KeyleadUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L7); `com.fanapium.keylead.client.tokens.ShortlifeToken` [src/com/nozha/async/server/util/KeyleadUtil.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L8); `com.fanapium.keylead.client.tokens.Tokens` [src/com/nozha/async/server/util/KeyleadUtil.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L9); `com.fanapium.keylead.client.users.ModifiableUser` [src/com/nozha/async/server/util/KeyleadUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L10); `com.fanapium.keylead.client.users.Users` [src/com/nozha/async/server/util/KeyleadUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L11); `com.fanapium.keylead.client.vo.ClientCredentials` [src/com/nozha/async/server/util/KeyleadUtil.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L12); `com.fanapium.keylead.common.oauth.exception.OAuthException` [src/com/nozha/async/server/util/KeyleadUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L13); `com.fasterxml.jackson.databind.JsonNode` [src/com/nozha/async/server/util/KeyleadUtil.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L14); `com.nozha.Settings` [src/com/nozha/async/server/util/KeyleadUtil.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L15); `com.nozha.async.server.exception.ServerException` [src/com/nozha/async/server/util/KeyleadUtil.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L16); `org.apache.logging.log4j.util.Strings` [src/com/nozha/async/server/util/KeyleadUtil.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L17); `org.json.JSONArray` [src/com/nozha/async/server/util/KeyleadUtil.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L18); `org.json.JSONObject` [src/com/nozha/async/server/util/KeyleadUtil.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L19); `org.slf4j.Logger` [src/com/nozha/async/server/util/KeyleadUtil.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L20); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/KeyleadUtil.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L21); `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/util/KeyleadUtil.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L23)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/ServiceCallProxy.java:130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L130) ` String businessId = KeyleadUtil.getBusinessIdFromToken(req);`; [src/com/nozha/async/server/handler/HttpHandler.java:147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L147) ` req.setAttribute("business_id", KeyleadUtil.getBusinessIdFromToken(req));`; [src/com/nozha/async/server/httpserver/ClientServlet.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ClientServlet.java#L34) ` if (KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/ServiceCallServlet.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L68) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L71) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/MessageSaverServlet.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MessageSaverServlet.java#L46) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/UnregisterServlet.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/UnregisterServlet.java#L35) ` if (KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L124) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/RegisterServlet.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RegisterServlet.java#L42) ` if (KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L107) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/MqttServlet.java:78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/MqttServlet.java#L78) ` if (KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/ProviderServicesServlet.java:66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderServicesServlet.java#L66) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AsyncServiceCallServlet.java#L42) ` req.setAttribute("business_id", KeyleadUtil.getBusinessIdFromToken(req));`; [src/com/nozha/async/server/httpserver/ServiceProviderServlet.java:155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceProviderServlet.java#L155) ` if (KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/AccessServlet.java:103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/AccessServlet.java#L103) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`; [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L121) ` if (!token.equals(Settings.KEYLEAD_API_TOKEN) && KeyleadUtil.isActive()) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `private static void initLookup()` | Initialize identity char lookup then permute digit mappings. | [src/com/nozha/async/server/util/KeyleadUtil.java:44–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L44-L60) |
| `public static boolean isActive()` | Active iff KEYLEAD_SERVER_URL non-null; no network check. | [src/com/nozha/async/server/util/KeyleadUtil.java:62–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L62-L64) |
| `public static void checkToken(String token, String role) throws ServerException` | Get shortlife token before try; obtain user; if role non-null read configured metadata roles and case-insensitively require role. Missing role throws ServerException. UserOperation/OAuth WARN and wrap with token in message. | [src/com/nozha/async/server/util/KeyleadUtil.java:72–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L72-L99) |
| `private static ShortlifeToken getShortlifeToken(String token) throws ServerException` | Tokens.fromAccessToken using static client credentials; initialization/OAuth failures WARN then ServerException containing raw token. | [src/com/nozha/async/server/util/KeyleadUtil.java:101–113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L101-L113) |
| `public static void checkToken(String token) throws ServerException` | Invoke getShortlifeToken only, no role check. | [src/com/nozha/async/server/util/KeyleadUtil.java:115–117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L115-L117) |
| `public static String getBusinessIdFromToken(HttpServletRequest req)` | Authorization header then _token_; nonempty token prefix before dash strip nondigits; nonblank prefix divide remaining digits by first digit, digit-map result. Exception returns null; arithmetic/format silent, others ERROR raw token. | [src/com/nozha/async/server/util/KeyleadUtil.java:119–143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L119-L143) |
| `public static String getToken(HttpServletRequest req)` | Return Authorization unless absent/empty then _token_. | [src/com/nozha/async/server/util/KeyleadUtil.java:145–151](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L145-L151) |
| `public static void main(String[] args)` | Parse example roles and print; then head=x numeric calculation throws NumberFormatException before subsequent prints. | [src/com/nozha/async/server/util/KeyleadUtil.java:153–168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L153-L168) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: checkToken validates Keylead token and optional metadata role; business-ID extraction decodes numeric token prefix only, without invoking token verification. Consumers must not treat extracted businessId as authenticated identity by this helper alone.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
User role absent→ServerException User is not authorized. TokenInitialization/UserOperation failure→can not authenticate client. +token; OAuth→client not authenticated. +token. Raw token enters exception text and error log140. Numeric/arithmetic extraction errors suppressed without log; other exceptions log token then return null.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `checkToken` | `throw new ServerException("User is not authorized");` | [src/com/nozha/async/server/util/KeyleadUtil.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L89) |
| catch_clause / `checkToken` | `} catch (UserOperationException e) {` | [src/com/nozha/async/server/util/KeyleadUtil.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L92) |
| throw_statement / `checkToken` | `throw new ServerException("can not authenticate client. " + token, e);` | [src/com/nozha/async/server/util/KeyleadUtil.java:94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L94) |
| catch_clause / `checkToken` | `} catch (OAuthException e) {` | [src/com/nozha/async/server/util/KeyleadUtil.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L95) |
| throw_statement / `checkToken` | `throw new ServerException("client not authenticated. " + token, e);` | [src/com/nozha/async/server/util/KeyleadUtil.java:97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L97) |
| catch_clause / `getShortlifeToken` | `} catch (TokenInitializationException e) {` | [src/com/nozha/async/server/util/KeyleadUtil.java:105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L105) |
| throw_statement / `getShortlifeToken` | `throw new ServerException("can not authenticate client. " + token, e);` | [src/com/nozha/async/server/util/KeyleadUtil.java:107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L107) |
| catch_clause / `getShortlifeToken` | `} catch (OAuthException e) {` | [src/com/nozha/async/server/util/KeyleadUtil.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L108) |
| throw_statement / `getShortlifeToken` | `throw new ServerException("client not authenticated. " + token, e);` | [src/com/nozha/async/server/util/KeyleadUtil.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L110) |
| catch_clause / `getBusinessIdFromToken` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/KeyleadUtil.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L138) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| WARN `logger` / `checkToken` | `("An exception occurred in check token", e)` | CATCH catch (UserOperationException e) @92 | ALOG-C01484E8FE86 | [src/com/nozha/async/server/util/KeyleadUtil.java:93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L93) |
| WARN `logger` / `checkToken` | `("An exception occurred in check token", e)` | CATCH catch (OAuthException e) @95 | ALOG-48B22E8EDCF3 | [src/com/nozha/async/server/util/KeyleadUtil.java:96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L96) |
| WARN `logger` / `getShortlifeToken` | `("An exception occurred in getShortlifeToken", e)` | CATCH catch (TokenInitializationException e) @105 | ALOG-EB3589B5C9D1 | [src/com/nozha/async/server/util/KeyleadUtil.java:106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L106) |
| WARN `logger` / `getShortlifeToken` | `("An exception occurred in getShortlifeToken", e)` | CATCH catch (OAuthException e) @108 | ALOG-56CF9BF0C039 | [src/com/nozha/async/server/util/KeyleadUtil.java:109](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L109) |
| ERROR `logger` / `getBusinessIdFromToken` | `("An exception occurred in getBusinessId from http request token={}", token, e)` | CATCH catch (Exception e) @138; TRUE (!(e instanceof ArithmeticException \\|\\| e instanceof NumberFormatException)) @139 | ALOG-607EDE984611 | [src/com/nozha/async/server/util/KeyleadUtil.java:140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L140) |
Additional direct console/stderr diagnostics (not logger registry): [src/com/nozha/async/server/util/KeyleadUtil.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L158) `System.out.println(role.asText());`; [src/com/nozha/async/server/util/KeyleadUtil.java:167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/KeyleadUtil.java#L167) `System.out.println(businessIdBuilder);`
Registry reconciliation: 5 active calls, 5 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: TOKEN_KEY. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-lrucache

<!-- source dossier: src/com/nozha/async/server/util/LRUCache.md -->

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
source_path: src/com/nozha/async/server/util/LRUCache.java
source_sha256: 8cf7bf1c80b01d9536792baaf9989988268451ee443ee5a1c89f7b21a78e18af
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java
business_approved: false
runtime_tested: false
promoted: false
---

# LRUCache — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `LRUCache` (class_declaration) [src/com/nozha/async/server/util/LRUCache.java:6–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L6-L51)
Synchronized access-order LinkedHashMap wrapper; automatic eldest eviction when size>constructor cap.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Methods synchronized on wrapper, backing map also synchronized. getAll copies entry set into ArrayList but entries reference map entries; no TTL.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `hashTableLoadFactor` | `float` | [src/com/nozha/async/server/util/LRUCache.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L8) |
| `map` | `Map<K, V>` | [src/com/nozha/async/server/util/LRUCache.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L10) |
| `cacheSize` | `int` | [src/com/nozha/async/server/util/LRUCache.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L11) |
| `serialVersionUID` | `long` | [src/com/nozha/async/server/util/LRUCache.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L22) |
Dependencies are imports (some may be unused): `java.io.Serial` [src/com/nozha/async/server/util/LRUCache.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L3); `java.util.*` [src/com/nozha/async/server/util/LRUCache.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L4)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L21) ` private LRUCache<String, Item> itemMapForOpen = new LRUCache<>(Settings.PEER_OPENING_MAP_SIZE);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public LRUCache(int cacheSize)` | Set max size and calculate initial table capacity; synchronized access-order LinkedHashMap overrides eviction. | [src/com/nozha/async/server/util/LRUCache.java:18–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L18-L30) |
| `@Override protected boolean removeEldestEntry(Map.Entry<K, V> eldest)` | Evict eldest when backing size exceeds configured cap. | [src/com/nozha/async/server/util/LRUCache.java:25–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L25-L28) |
| `public synchronized V get(K key)` | Synchronized access-order lookup. | [src/com/nozha/async/server/util/LRUCache.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L32-L34) |
| `public synchronized V remove(K key)` | Synchronized key removal returns old value. | [src/com/nozha/async/server/util/LRUCache.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L36-L38) |
| `public synchronized void put(K key, V value)` | Synchronized insertion/update with automatic eviction. | [src/com/nozha/async/server/util/LRUCache.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L40-L42) |
| `public synchronized void clear()` | Synchronized full clear. | [src/com/nozha/async/server/util/LRUCache.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L44-L46) |
| `public synchronized Collection<Map.Entry<K, V>> getAll()` | Return new ArrayList of map entries; not a deep copy. | [src/com/nozha/async/server/util/LRUCache.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/LRUCache.java#L48-L50) |

## Business
SOURCE_OBSERVED: Indirect bounded local memory state, access moves entry to most-recent.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Invalid negative table capacity can throw constructor IllegalArgumentException; no local catches/logs.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/MemoryCacheCRUD.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L21).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-memorycachecrud

<!-- source dossier: src/com/nozha/async/server/util/MemoryCacheCRUD.md -->

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
source_path: src/com/nozha/async/server/util/MemoryCacheCRUD.java
source_sha256: c9f8d1092d42db6be498147dda8b400fc4bacbbcdcf1a892ee141ae0a2cfe96a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java
business_approved: false
runtime_tested: false
promoted: false
---

# MemoryCacheCRUD — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `MemoryCacheCRUD` (class_declaration) [src/com/nozha/async/server/util/MemoryCacheCRUD.java:19–267](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L19-L267), `Item` (class_declaration) [src/com/nozha/async/server/util/MemoryCacheCRUD.java:241–266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L241-L266)
Local LRU event-time lists plus Guava client/tracker/index/seen TTL caches and interface Caffeine peer caches.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Item synchronized list cleanup and insertion/size are separate sections; concurrent get-create-put can lose event records. Item.set stores currentTimeMillis instead of supplied time after cleanup. Logger category is Client.class, not MemoryCacheCRUD (20).
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L20) |
| `itemMapForOpen` | `LRUCache<String, Item>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L21) |
| `itemMapForMessageReceiver` | `LRUCache<Long, Item>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L22) |
| `itemMapForMessageSender` | `LRUCache<Long, Item>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L23) |
| `itemMapForMessageSenderRemoteAddress` | `LRUCache<String, Item>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L24) |
| `clientMapCache` | `Cache<Long, List<Long>>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L25) |
| `clientLastSeenCache` | `Cache<Long, Long>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L29) |
| `trackerMapCache` | `Cache<Long, Long>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L33) |
| `clientServerIndexCache` | `Cache<Long, Integer>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L37) |
| `accessTimes` | `List<Long>` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L242) |
| `expireTimeout` | `long` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:243](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L243) |
Dependencies are imports (some may be unused): `com.google.common.cache.Cache` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L3); `com.google.common.cache.CacheBuilder` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L4); `com.nozha.Settings` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L5); `com.nozha.async.server.client.Client` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L6); `com.nozha.async.server.model.Peer` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L7); `org.slf4j.Logger` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L8); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L9); `java.util.ArrayList` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L11); `java.util.Collections` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L12); `java.util.List` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L13); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/util/MemoryCacheCRUD.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L14)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/CacheUtil.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L16) ` private static final MemoryCacheCRUD memoryCacheCRUD = new MemoryCacheCRUD();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public void putMessage(long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout)` | Record receiver/sender/address via three helpers; clientType unused. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:42–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L42-L47) |
| `@Override public void openClient(String remoteAddress, int clientType, long time, long expireTimeout)` | Get/create opening Item by address, then record event. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:49–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L49-L57) |
| `private void putReceiver(long receiverId, long time, long expireTimeout)` | Get/create receiver Item then record event. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:59–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L59-L66) |
| `private void putSender(long senderId, long time, long expireTimeout)` | Get/create sender Item then record event. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:68–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L68-L75) |
| `private void putSenderRemoteAddress(String remoteAddress, long time, long expireTimeout)` | Get/create address Item then record event. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:77–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L77-L84) |
| `@Override public long countMessagesByReceiver(long receiverId, long toTime)` | Return receiver Item count(toTime), absent0. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:86–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L86-L94) |
| `@Override public long countMessagesBySender(long senderId, long toTime)` | Return sender Item count, absent0. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:96–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L96-L104) |
| `@Override public long countMessagesBySenderRemoteAddress(String senderRemoteAddress, long toTime)` | Return sender-address Item count, absent0. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:106–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L106-L114) |
| `@Override public long countOpenedClientByRemoteAddress(String remoteAddress, long toTime)` | Return opening-address Item count, absent0. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:116–124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L116-L124) |
| `@Override public void putClientCache(long key, List<Long> serverIds)` | Delegate exact operation `clientMapCache.put(key, serverIds);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:126–129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L126-L129) |
| `@Override public void invalidateClientCache(long key)` | Delegate exact operation `clientMapCache.invalidate(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:131–134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L131-L134) |
| `@Override public List<Long> getClientCache(long key)` | Delegate exact operation `return clientMapCache.asMap().get(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:136–139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L136-L139) |
| `@Override public void putTrackerCache(long key, Long serverId)` | Delegate exact operation `trackerMapCache.put(key, serverId);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:141–144](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L141-L144) |
| `@Override public void invalidateTrackerCache(long key)` | Delegate exact operation `trackerMapCache.invalidate(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:146–149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L146-L149) |
| `@Override public Long getTrackerCache(long key)` | Delegate exact operation `return trackerMapCache.asMap().get(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:151–154](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L151-L154) |
| `@Override public void putClientServerIndexCache(long key, int index)` | Delegate exact operation `clientServerIndexCache.put(key, index);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:156–159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L156-L159) |
| `@Override public void invalidateClientServerIndexCache(long key)` | Delegate exact operation `clientServerIndexCache.invalidate(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:161–164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L161-L164) |
| `@Override public Integer getClientServerIndexCache(long key)` | Delegate exact operation `return clientServerIndexCache.asMap().get(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:166–169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L166-L169) |
| `@Override public void putClientLastSeen(long key)` | Put current epoch lastSeen and INFO key. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:171–176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L171-L176) |
| `@Override public void invalidateClientLastSeen(long key)` | Delegate exact operation `clientLastSeenCache.invalidate(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:178–181](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L178-L181) |
| `@Override public Long getClientLastSeen(long key)` | Delegate exact operation `return clientLastSeenCache.asMap().get(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:183–186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L183-L186) |
| `@Override public void putProvision(String peerNameDestination, long expireTimeout)` | No-op provision write. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:188–191](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L188-L191) |
| `@Override public long countProvisionByDestination(String peerNameDestination)` | Always return0 provision count. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:193–196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L193-L196) |
| `@Override public void invalidateClientCacheByServerId(long serverId)` | For each routing list remove serverId if present; DEBUG success; catch Exception ERROR with serverId only. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:199–211](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L199-L211) |
| `@Override public void invalidateAllClientCache()` | INFO before invalidateAll client cache. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:213–217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L213-L217) |
| `@Override public void cachePeer(Peer peer)` | Ignore null peer or null/empty name; else cache same mutable Peer under ID and name. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:220–229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L220-L229) |
| `@Override public Peer getById(long id)` | Caffeine ID getIfPresent. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:231–234](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L231-L234) |
| `@Override public Peer getByName(String name)` | Caffeine name getIfPresent. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:236–239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L236-L239) |
| `Item(long expireTimeout)` | Store Item expiry timeout. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:245–247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L245-L247) |
| `void set(long time)` | Under accessTimes lock remove oldest while oldest+expiry<supplied time; append current epoch outside compound lock. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:249–256](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L249-L256) |
| `int count(long toTime)` | Under lock evict oldest against toTime; return list size outside compound lock. | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:258–265](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L258-L265) |

## Business
SOURCE_OBSERVED: Indirect counters/routing/peer lookup; provision methods are stubs. CacheUtil currently uses this implementation only for peer caching, not all routing/counters.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Invalidation by server catches Exception and emits ERROR without Throwable; partial list mutation possible. Guava/Caffeine null or invalid settings can propagate.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `invalidateClientCacheByServerId` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L208) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `putClientLastSeen` | `("*******insert Last Seen Key={}", key)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-0C483FFD28C2 | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L174) |
| DEBUG `logger` / `invalidateClientCacheByServerId` | `("invalidateClientCacheByServerId serverId={}", serverId)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-D4AB555828DA | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L207) |
| ERROR `logger` / `invalidateClientCacheByServerId` | `("Exception in invalidateClientCacheByServerId serverId={}", serverId)` | CATCH catch (Exception e) @208 | ALOG-2336D226D1E5 | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L209) |
| INFO `logger` / `invalidateAllClientCache` | `("invalidate All Client from Memory Cache ")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-695E795874F5 | [src/com/nozha/async/server/util/MemoryCacheCRUD.java:215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MemoryCacheCRUD.java#L215) |
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: itemMapForMessageSenderRemoteAddress. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-messagetype

<!-- source dossier: src/com/nozha/async/server/util/MessageType.md -->

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
source_path: src/com/nozha/async/server/util/MessageType.java
source_sha256: af27c86906f13a40bb2a905a957cd4424be6b566aea50ecb097f430a8ce312b0
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java
business_approved: false
runtime_tested: false
promoted: false
---

# MessageType — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `MessageType` (class_declaration) [src/com/nozha/async/server/util/MessageType.java:6–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L6-L23)
Byte wire dispatch constants (7–22):0 ping,1 server register,2 device register,3 message,4 ACK-needed,5 sender-ACK-needed,6 ACK,7 peer list,8 unseen duration,9 receiver register,-3 peer removed,-2 queue register,-1 not registered,-99 error.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `PING` | `byte` | [src/com/nozha/async/server/util/MessageType.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L7) |
| `SERVER_REGISTER` | `byte` | [src/com/nozha/async/server/util/MessageType.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L8) |
| `DEVICE_REGISTER` | `byte` | [src/com/nozha/async/server/util/MessageType.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L9) |
| `MESSAGE` | `byte` | [src/com/nozha/async/server/util/MessageType.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L10) |
| `MESSAGE_ACK_NEEDED` | `byte` | [src/com/nozha/async/server/util/MessageType.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L11) |
| `MESSAGE_SENDER_ACK_NEEDED` | `byte` | [src/com/nozha/async/server/util/MessageType.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L12) |
| `ACK` | `byte` | [src/com/nozha/async/server/util/MessageType.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L13) |
| `GET_REGISTERED_PEERS` | `byte` | [src/com/nozha/async/server/util/MessageType.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L14) |
| `GET_PEERS_NOT_SEEN_DURATION` | `byte` | [src/com/nozha/async/server/util/MessageType.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L15) |
| `REGISTER_RECEIVER` | `byte` | [src/com/nozha/async/server/util/MessageType.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L16) |
| `PEER_REMOVED` | `byte` | [src/com/nozha/async/server/util/MessageType.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L18) |
| `REGISTER_QUEUE` | `byte` | [src/com/nozha/async/server/util/MessageType.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L19) |
| `NOT_REGISTERED` | `byte` | [src/com/nozha/async/server/util/MessageType.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L20) |
| `ERROR_MESSAGE` | `byte` | [src/com/nozha/async/server/util/MessageType.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageType.java#L22) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:364](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L364) ` if (messageWrapperVO.getType() != MessageType.DEVICE_REGISTER) {`; [src/com/nozha/async/server/handler/MqttHandler.java:217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L217) ` messageWrapperVO.setType(MessageType.MESSAGE);`; [src/com/nozha/async/server/handler/HttpHandler.java:398](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L398) ` if (clientMessage.getType() == MessageType.ERROR_MESSAGE) {`; [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/TcpHandler.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L132) ` writeData(outputStream, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, String.valueOf(peer.getId())`; [src/com/nozha/async/server/biz/MessageManager.java:363](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L363) ` case MessageType.PEER_REMOVED:`; [src/com/nozha/async/server/biz/RegistrationManager.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L148) ` message.setType(MessageType.SERVER_REGISTER);`; [src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java:696](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLPeerCRUD.java#L696) ` message.setType(MessageType.PEER_REMOVED);`; [src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java:546](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLMessageCRUD.java#L546) ` if (message.getType() == MessageType.MESSAGE_SENDER_ACK_NEEDED) {`; [src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java:772](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OraclePeerCRUD.java#L772) ` message.setType(MessageType.PEER_REMOVED);`; [src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java:574](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L574) ` if (message.getType() == MessageType.MESSAGE_SENDER_ACK_NEEDED) {`
### Method review
No active declared methods.

## Business
SOURCE_OBSERVED: Indirect wire protocol contract used by Server dispatcher and MessageManager persistence status transitions; not HTTP status codes.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; unknown types are handled by callers.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:364](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L364), [src/com/nozha/async/server/handler/MqttHandler.java:217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L217), [src/com/nozha/async/server/handler/HttpHandler.java:398](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L398), [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62), [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62), [src/com/nozha/async/server/handler/TcpHandler.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L132), [src/com/nozha/async/server/biz/MessageManager.java:363](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L363), [src/com/nozha/async/server/biz/RegistrationManager.java:148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L148).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-messageutil

<!-- source dossier: src/com/nozha/async/server/util/MessageUtil.md -->

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
source_path: src/com/nozha/async/server/util/MessageUtil.java
source_sha256: e3023a907e6f3c1f5957bcac005fc7539c0fcd6fdbe336c2bf7beb1b6aafa7a7
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# MessageUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `MessageUtil` (class_declaration) [src/com/nozha/async/server/util/MessageUtil.java:8–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L8-L47)
Synchronized wall-clock message ID generator combining prefix+server ID, current modulo epoch and step10..99.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Static serverId snapshot at class init; synchronized within JVM only. Sleep1 on step exhaustion can still read same millisecond/clock rollback.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/MessageUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L10) |
| `lastTime` | `long` | [src/com/nozha/async/server/util/MessageUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L11) |
| `step` | `int` | [src/com/nozha/async/server/util/MessageUtil.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L12) |
| `serverId` | `long` | [src/com/nozha/async/server/util/MessageUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L13) |
| `ratio` | `long` | [src/com/nozha/async/server/util/MessageUtil.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L14) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/MessageUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L3); `com.nozha.async.server.exception.ServerException` [src/com/nozha/async/server/util/MessageUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L4); `org.slf4j.Logger` [src/com/nozha/async/server/util/MessageUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L5); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/MessageUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L6)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/MessageManager.java:240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L240) ` message.setId(MessageUtil.getNextMessageId());`; [src/com/nozha/async/server/persistance/ClientCRUD.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ClientCRUD.java#L139) ` result = (int) (MessageUtil.extractServerId(message.getTrackerId()));`; [src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java:152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleMessageCRUD.java#L152) ` nextVal = MessageUtil.getNextMessageId();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static long extractServerId(long id)` | Extract ((id/(ratio*100)) % MESSAGE_ID_PREFIX), intended server suffix. | [src/com/nozha/async/server/util/MessageUtil.java:16–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L16-L18) |
| `public synchronized static long getNextMessageId() throws ServerException` | Read current epoch; same millisecond increment step, >99 reset10/sleep1/update time; changed millisecond reset10. Compose (((serverId*ratio)+(current%ratio))*100)+step. WARN above threshold; Exception ERROR→ServerException. | [src/com/nozha/async/server/util/MessageUtil.java:20–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L20-L46) |

## Business
SOURCE_OBSERVED: Indirect message identity/correlation generation, no proof of globally unique IDs across clock rollback/duplicate server configurations.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Any Exception including sleep interrupt logs ERROR and throws ServerException exception in generate nextMessageId without cause (41–43). Slow generation WARN threshold.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `getNextMessageId` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/MessageUtil.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L41) |
| throw_statement / `getNextMessageId` | `throw new ServerException("exception in generate nextMessageId");` | [src/com/nozha/async/server/util/MessageUtil.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L43) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| WARN `logger` / `getNextMessageId` | `("time more than threshold in getNextMessageId, time= {}", System.currentTimeMillis() - startTime)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.MESSAGE_ID_THRESHOLD_TIME) @37 | ALOG-E5D0A3E98675 | [src/com/nozha/async/server/util/MessageUtil.java:38–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L38-L39) |
| ERROR `logger` / `getNextMessageId` | `("An exception occurred in getNextMessageId ", e)` | CATCH catch (Exception e) @41 | ALOG-4A55203E804C | [src/com/nozha/async/server/util/MessageUtil.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/MessageUtil.java#L42) |
Registry reconciliation: 2 active calls, 2 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-podlogutil

<!-- source dossier: src/com/nozha/async/server/util/PODLogUtil.md -->

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
source_path: src/com/nozha/async/server/util/PODLogUtil.java
source_sha256: 6f3ced4ea846994b68c37a8c7e02727191ee23680de8b16f6b1db9713e36b5ca
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# PODLogUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `PODLogUtil` (class_declaration) [src/com/nozha/async/server/util/PODLogUtil.java:16–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L16-L88)
Monitoring event helper with caller-supplied Log4j logger; static source IP lookup and configured service-name/tag map.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
All four direct emissions guarded POD_MONITORING_LOGGER; overloads only delegate for nonempty ARN. Registry logger routing cannot be determined from supplied logger parameter alone.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `srcServerIp` | `String` | [src/com/nozha/async/server/util/PODLogUtil.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L17) |
| `descNameMaps` | `Map<String, String>` | [src/com/nozha/async/server/util/PODLogUtil.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L18) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/PODLogUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L3); `com.nozha.async.server.client.HttpClient` [src/com/nozha/async/server/util/PODLogUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L4); `com.nozha.async.server.model.Message` [src/com/nozha/async/server/util/PODLogUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L5); `com.nozha.async.server.vo.ClientMessage` [src/com/nozha/async/server/util/PODLogUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L6); `com.nozha.async.server.vo.log.PODMonitoringLog` [src/com/nozha/async/server/util/PODLogUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L7); `org.apache.logging.log4j.Logger` [src/com/nozha/async/server/util/PODLogUtil.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L8); `java.net.InetAddress` [src/com/nozha/async/server/util/PODLogUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L10); `java.net.UnknownHostException` [src/com/nozha/async/server/util/PODLogUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L11); `java.util.HashMap` [src/com/nozha/async/server/util/PODLogUtil.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L12); `java.util.Locale` [src/com/nozha/async/server/util/PODLogUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L13); `java.util.Map` [src/com/nozha/async/server/util/PODLogUtil.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L14)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:764](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L764) ` PODLogUtil.logGetResponse(podLogger, message, ((HttpClient) client).getProviderPeerName(), System.currentTimeMillis() - client.getLastSendM`; [src/com/nozha/async/server/handler/QueueHandler.java:95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/QueueHandler.java#L95) ` PODLogUtil.logSendRequest(podLogger, ((ClientMessagePayload)outboundPayload).getClientMessage(), queueClient.getPeer().getName());`; [src/com/nozha/async/server/handler/HttpHandler.java:454](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L454) ` PODLogUtil.logSendResponse(podLogger, clientMessage, requestURI, responseStatus, currentTime - startTime, Settings.POD_MONITORING_DESC_NAME`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L153) ` PODLogUtil.logGetRequest(podLogger, ARN, ARNStep, messageVO.getPeerName() + url, Settings.POD_MONITORING_DESC_NAME_HTTP);`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L101) ` PODLogUtil.logGetRequest(podLogger, ARN, ARNStep, messageVO.getPeerName() + uri, Settings.POD_MONITORING_DESC_NAME_HTTP);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `private static String getServiceTag(String serviceName)` | Null service→configured HTTP description; non-null lookup lowercase fallback original name. | [src/com/nozha/async/server/util/PODLogUtil.java:40–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L40-L48) |
| `public static void logGetRequest(Logger logger, String ARN, Integer ARNStep, String uri, String descName)` | If flag emit INFO PODMonitoringLog GET-request with ARN/step/uri/source/description. | [src/com/nozha/async/server/util/PODLogUtil.java:50–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L50-L54) |
| `public static void logSendRequest(Logger logger, String ARN, int ArnStep, String descName)` | If flag emit INFO SEND-request with mapped service tag. | [src/com/nozha/async/server/util/PODLogUtil.java:56–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L56-L60) |
| `public static void logGetResponse(Logger logger, String ARN, int ArnStep, String descName, long duration)` | If flag emit INFO GET-response with duration. | [src/com/nozha/async/server/util/PODLogUtil.java:62–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L62-L66) |
| `public static void logSendResponse(Logger logger, String ARN, int ArnStep, String uri, int statusCode, long totalDuration, String descName)` | If flag emit INFO SEND-response with URI/status/totalDuration. | [src/com/nozha/async/server/util/PODLogUtil.java:68–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L68-L72) |
| `public static void logSendRequest(Logger logger, ClientMessage clientMessage, String descName)` | Require nonempty client ARN then delegate send request (client itself not guarded null). | [src/com/nozha/async/server/util/PODLogUtil.java:74–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L74-L77) |
| `public static void logSendResponse(Logger logger, ClientMessage clientMessage, String uri, int statusCode, long totalDuration, String descName)` | Require non-null client and nonempty ARN then send response. | [src/com/nozha/async/server/util/PODLogUtil.java:79–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L79-L82) |
| `public static void logGetResponse(Logger logger, Message message, String descName, long duration)` | Require non-null Message and nonempty ARN then get response. | [src/com/nozha/async/server/util/PODLogUtil.java:84–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L84-L87) |

## Business
SOURCE_OBSERVED: Indirect request/response hop observability. Event action is stage-specific, not proof of end-to-end completion or user delivery.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
UnknownHostException sets0.0.0.0; malformed service tag config catches Exception resets entire map silently. ClientMessage send-request overload does not null-check clientMessage.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `INITIALIZER` | `} catch (UnknownHostException e) {` | [src/com/nozha/async/server/util/PODLogUtil.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L23) |
| catch_clause / `INITIALIZER` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/PODLogUtil.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L35) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `logGetRequest` | `(new PODMonitoringLog("GET-request", ARN, ARNStep, uri, srcServerIp, Settings.POD_MONITORING_SRC_NAME, descName, null, null, null))` | TRUE (Settings.POD_MONITORING_LOGGER) @51 | ALOG-8CEE7EAC4325 | [src/com/nozha/async/server/util/PODLogUtil.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L52) |
| INFO `logger` / `logSendRequest` | `(new PODMonitoringLog("SEND-request", ARN, ArnStep, null, srcServerIp, Settings.POD_MONITORING_SRC_NAME, getServiceTag(descName), null, null, null))` | TRUE (Settings.POD_MONITORING_LOGGER) @57 | ALOG-125CB954B465 | [src/com/nozha/async/server/util/PODLogUtil.java:58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L58) |
| INFO `logger` / `logGetResponse` | `(new PODMonitoringLog("GET-response", ARN, ArnStep, null, srcServerIp, Settings.POD_MONITORING_SRC_NAME, getServiceTag(descName), duration, null, null))` | TRUE (Settings.POD_MONITORING_LOGGER) @63 | ALOG-043642CF5CD0 | [src/com/nozha/async/server/util/PODLogUtil.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L64) |
| INFO `logger` / `logSendResponse` | `(new PODMonitoringLog("SEND-response", ARN, ArnStep, uri, srcServerIp, Settings.POD_MONITORING_SRC_NAME, descName, null, statusCode, totalDuration))` | TRUE (Settings.POD_MONITORING_LOGGER) @69 | ALOG-5EE5E640E496 | [src/com/nozha/async/server/util/PODLogUtil.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L70) |
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-resourcehelper

<!-- source dossier: src/com/nozha/async/server/util/ResourceHelper.md -->

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
source_path: src/com/nozha/async/server/util/ResourceHelper.java
source_sha256: 03ae8ffe8399bc9b35bb181421ba77a749531d93ac7e472f2eeb2dc98e168a0f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java
business_approved: false
runtime_tested: false
promoted: false
---

# ResourceHelper — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `ResourceHelper` (class_declaration) [src/com/nozha/async/server/util/ResourceHelper.java:8–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L8-L66)
Synchronized singleton for classpath lookup and file materialization.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Temp file deleteOnExit, copy uses1024-byte buffer. No logger but stderr diagnostics are direct active output.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `instance` | `ResourceHelper` | [src/com/nozha/async/server/util/ResourceHelper.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L9) |
Dependencies are imports (some may be unused): `java.io.*` [src/com/nozha/async/server/util/ResourceHelper.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/Settings.java:486](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L486) ` keyStore.load(ResourceHelper.getInstance().getResource("/resources/async-keystore.p12"), Settings.ZOOKEEPER_KEYSTORE_PASSWORD.toCharArray()`; [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L114) ` File keyFile = ResourceHelper.getInstance().getOrCreateFile(Settings.KEYSTORE_PATH);`; [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L25) ` zookeeperProperties.load(ResourceHelper.getInstance().getResource("/resources/zookeeper.properties"));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `private ResourceHelper()` | Empty private constructor. | [src/com/nozha/async/server/util/ResourceHelper.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L11) |
| `public synchronized static ResourceHelper getInstance()` | Synchronized lazy singleton. | [src/com/nozha/async/server/util/ResourceHelper.java:13–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L13-L18) |
| `public InputStream getResource(String name)` | Return class-relative resource stream including null miss. | [src/com/nozha/async/server/util/ResourceHelper.java:20–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L20-L22) |
| `public String getResourcePath(String resourcePath)` | Lookup slash-prefixed resource URL file string, replace %20 only; null URL unguarded. | [src/com/nozha/async/server/util/ResourceHelper.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L24-L26) |
| `public File getOrCreateFile(String keyFile) throws IOException` | Existing path returned unchanged; absent lookup system then class loader; missing throws IOException. Resource exists create temp file/deleteOnExit, copy bytes, print/suppress copy errors and separately close streams with printed failures; return file regardless copy completeness. | [src/com/nozha/async/server/util/ResourceHelper.java:28–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L28-L65) |

## Business
SOURCE_OBSERVED: Indirect resource/config/keystore loading; missing optional getResource returns null; getOrCreateFile can extract embedded file into temporary filesystem.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
getOrCreateFile throws IOException Could not locate file: +keyFile when unavailable. Copy and close IOException are printStackTrace then suppressed; a partially copied temp file is still returned. getResourcePath missing URL causes NPE.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `getOrCreateFile` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/ResourceHelper.java:44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L44) |
| catch_clause / `getOrCreateFile` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/ResourceHelper.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L49) |
| catch_clause / `getOrCreateFile` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/ResourceHelper.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L55) |
| throw_statement / `getOrCreateFile` | `throw new IOException("Could not locate file: " + keyFile);` | [src/com/nozha/async/server/util/ResourceHelper.java:61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L61) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/Settings.java:486](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L486), [src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java:114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/EmbeddedHttpServer.java#L114), [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L25).
Additional direct console/stderr diagnostics (not logger registry): [src/com/nozha/async/server/util/ResourceHelper.java:45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L45) `e.printStackTrace();`; [src/com/nozha/async/server/util/ResourceHelper.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L50) `e.printStackTrace();`; [src/com/nozha/async/server/util/ResourceHelper.java:56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/ResourceHelper.java#L56) `e.printStackTrace();`
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-stringutil

<!-- source dossier: src/com/nozha/async/server/util/StringUtil.md -->

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
source_path: src/com/nozha/async/server/util/StringUtil.java
source_sha256: 392cf518a778a32052c7b7b3d7cde0ec58676347b10e2c3c0656a6f457840c70
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/StringUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# StringUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `StringUtil` (class_declaration) [src/com/nozha/async/server/util/StringUtil.java:5–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/StringUtil.java#L5-L31)
Mask helper using configurable maximum length and visible percentage.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Pure computation on input; no logging or global mutation.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/StringUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/StringUtil.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/HttpHandler.java:266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L266) ` logger.warn("An exception occurred in httpHandler error=MediationException origin={}, businessId= " + req.getAttribute("business_id") + " ,`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static String maskString(String input)` | Delegate configured size/percent. | [src/com/nozha/async/server/util/StringUtil.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/StringUtil.java#L7-L9) |
| `public static String maskString(String input, int maxSize, int visiblePercent)` | Null→null; if too long retain absolute(max/2) chars from both ends; visibleNum=absolute(length*percent/100); mask indices from visibleNum through len-visibleNum-1; return constructed string. | [src/com/nozha/async/server/util/StringUtil.java:11–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/StringUtil.java#L11-L30) |

## Business
SOURCE_OBSERVED: Indirect sensitive-token display; truncates by retaining both ends, then masks central range. Configuration can reveal entire input at high visible percent; no guarantee of cryptographic secrecy.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Null returns null. No bounds validation; negative maxSize/overflow can cause substring exceptions.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/HttpHandler.java:266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L266).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
Source-evidenced external emission of this carrier: [src/com/nozha/async/server/handler/HttpHandler.java:266](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L266) WARN `("An exception occurred in httpHandler error=MediationException origin={}, businessId= " + req.getAttribute("business_id") + " , token= " + StringUtil.maskString(KeyleadUtil.getToken(req)), client.getAddress(), e)` [ALOG-1DB89FB6A8F9]

---

### dossier-src-com-nozha-async-server-util-timeoutable

<!-- source dossier: src/com/nozha/async/server/util/Timeoutable.md -->

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
source_path: src/com/nozha/async/server/util/Timeoutable.java
source_sha256: 3ae4d761e86f721a5cd505f49fb845c509dab89c92211936d76c813bf9e2429b
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java
business_approved: false
runtime_tested: false
promoted: false
---

# Timeoutable — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `Timeoutable` (class_declaration) [src/com/nozha/async/server/util/Timeoutable.java:14–73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L14-L73)
Abstract resource timer with shared java.util.Timer, creation stack, per-object timeout/task.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
startTimer only timeout>0; multiple start calls overwrite task without canceling previous. renewTimer cancels all outstanding tasks globally; no synchronization around renewal.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/Timeoutable.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L15) |
| `timer` | `Timer` | [src/com/nozha/async/server/util/Timeoutable.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L16) |
| `trace` | `Exception` | [src/com/nozha/async/server/util/Timeoutable.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L18) |
| `task` | `TimerTask` | [src/com/nozha/async/server/util/Timeoutable.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L19) |
| `timeout` | `long` | [src/com/nozha/async/server/util/Timeoutable.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L20) |
Dependencies are imports (some may be unused): `org.slf4j.Logger` [src/com/nozha/async/server/util/Timeoutable.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L3); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/Timeoutable.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L4); `java.io.PrintWriter` [src/com/nozha/async/server/util/Timeoutable.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L6); `java.io.StringWriter` [src/com/nozha/async/server/util/Timeoutable.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L7); `java.util.Timer` [src/com/nozha/async/server/util/Timeoutable.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L8); `java.util.TimerTask` [src/com/nozha/async/server/util/Timeoutable.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L9)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:731](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L731) ` public class MessageSender extends Timeoutable implements Runnable {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public Timeoutable(final long timeout)` | Store timeout and capture synthetic Exception creation trace. | [src/com/nozha/async/server/util/Timeoutable.java:22–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L22-L25) |
| `public void startTimer()` | Positive timeout only create task, DEBUG schedule, schedule on shared timer; any Throwable renewTimer then retry schedule. | [src/com/nozha/async/server/util/Timeoutable.java:27–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L27-L44) |
| `@Override public void run()` | DEBUG fired timer then invoke abstract timeout. | [src/com/nozha/async/server/util/Timeoutable.java:30–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L30-L34) |
| `private static void renewTimer()` | Cancel shared Timer and replace it. | [src/com/nozha/async/server/util/Timeoutable.java:46–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L46-L49) |
| `protected void cancelTimerTask()` | DEBUG cancellation, null trace, attempt cancel task ignoring Throwable, null task. | [src/com/nozha/async/server/util/Timeoutable.java:51–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L51-L60) |
| `public abstract void timeout();` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/Timeoutable.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L62) |
| `public void printTrace()` | WARN timeout with retained creation exception. | [src/com/nozha/async/server/util/Timeoutable.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L64-L66) |
| `public String getPrintTrace()` | Print creation trace into StringWriter; null trace unguarded. | [src/com/nozha/async/server/util/Timeoutable.java:68–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L68-L72) |

## Business
SOURCE_OBSERVED: Indirect send timeout callback and origin trace, not guaranteed forced cancellation.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
startTimer catches Throwable from schedule, renews shared timer and retries once; retry error propagates. cancel ignores Throwable; getPrintTrace after cancel nulls trace and may NPE. Callback runtime failures can kill shared Timer thread.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `startTimer` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/Timeoutable.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L39) |
| catch_clause / `cancelTimerTask` | `} catch (Throwable ignored) {}` | [src/com/nozha/async/server/util/Timeoutable.java:57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L57) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| DEBUG `logger` / `run` | `("timeout timer for: {}", this)` | TRUE (this.timeout > 0) @28 | ALOG-F83A6E5F137F | [src/com/nozha/async/server/util/Timeoutable.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L32) |
| DEBUG `logger` / `startTimer` | `("schedule timer for: {}", task)` | TRUE (this.timeout > 0) @28 | ALOG-EFDC75CBDBA0 | [src/com/nozha/async/server/util/Timeoutable.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L36) |
| DEBUG `logger` / `cancelTimerTask` | `("cencel timer for: {}", task)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-DE507D04C480 | [src/com/nozha/async/server/util/Timeoutable.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L52) |
| WARN `logger` / `printTrace` | `("timeout: ", trace)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-47EE249BC670 | [src/com/nozha/async/server/util/Timeoutable.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L65) |
Additional direct console/stderr diagnostics (not logger registry): [src/com/nozha/async/server/util/Timeoutable.java:70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/Timeoutable.java#L70) `trace.printStackTrace(new PrintWriter(writer));`
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
