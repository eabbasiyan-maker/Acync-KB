# Async class dossiers — review batch 15


---

### dossier-src-com-nozha-async-server-util-trackerutil

<!-- source dossier: src/com/nozha/async/server/util/TrackerUtil.md -->

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
source_path: src/com/nozha/async/server/util/TrackerUtil.java
source_sha256: 470f8bbd47910813c94e9c2568fa3a3c54d1607a36ae4e6a6e9dea3665b271af
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/TrackerUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# TrackerUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util`. Types: `TrackerUtil` (class_declaration) [src/com/nozha/async/server/util/TrackerUtil.java:3–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/TrackerUtil.java#L3-L14)
Packs server ID into low8 bits of shifted ID (4–12).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Pure bit operations.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static long pushServerId(long id, int serverId)` | Return serverId OR (id<<8), no range checks. | [src/com/nozha/async/server/util/TrackerUtil.java:4–6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/TrackerUtil.java#L4-L6) |
| `public static long extractId(long id)` | Mask low byte off then signed right-shift8. | [src/com/nozha/async/server/util/TrackerUtil.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/TrackerUtil.java#L7-L9) |
| `public static long extractServerId(long id)` | Mask low8bits as server ID. | [src/com/nozha/async/server/util/TrackerUtil.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/TrackerUtil.java#L11-L13) |

## Business
SOURCE_OBSERVED: Indirect tracker correlation/routing codec; extract returns only8bit server ID.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; Java shifts silently truncate/overflow. serverId is not masked before OR, so values>255 can corrupt encoded ID.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. No source-evidenced caller emitter found by class-name scan.
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-configurationresolver-config-configurationresourcerepository

<!-- source dossier: src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.md -->

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
source_path: src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java
source_sha256: 59cd5ace8f82835bc8aac13554fac8acb0d78461508017104df4f1bac3523a64
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java
business_approved: false
runtime_tested: false
promoted: false
---

# ConfigurationResourceRepository — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.configurationresolver.config`. Types: `ConfigurationResourceRepository` (class_declaration) [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:10–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L10-L75)
Static classpath zookeeper.properties loader with OS-specific path and trimmed host/root/auth/secret plus numeric retry/session timeout (21–42).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
All values static final snapshots; success INFO only after all assignments.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L11) |
| `path` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L12) |
| `zookeeperRoot` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L13) |
| `host` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L14) |
| `username` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L15) |
| `password` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L16) |
| `secretKey` | `String` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L17) |
| `maxRetryAttempt` | `int` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L18) |
| `zookeeperSessionTimeoutInMs` | `int` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L19) |
Dependencies are imports (some may be unused): `com.nozha.async.server.util.ResourceHelper` [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L3); `org.slf4j.Logger` [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L4); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L5); `java.io.IOException` [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L7); `java.util.Properties` [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/Settings.java:487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L487) ` Properties zookeeperInfraProperties = ZookeeperUtil.getZNodesData(ConfigurationResourceRepository.getZookeeperRoot() + DELIMITER + "infra",`; [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L39) ` if (attempt.get() <= ConfigurationResourceRepository.getMaxRetryAttempt()) {`; [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L18) ` ZooKeeper zooKeeper = new ZooKeeper(ConfigurationResourceRepository.getHost(), ConfigurationResourceRepository.getZookeeperSessionTimeout()`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static String getPath()` | Return stored value/reference: path. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L44-L46) |
| `public static String getUsername()` | Return stored value/reference: username. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L48-L50) |
| `public static String getPassword()` | Return stored value/reference: password. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:52–54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L52-L54) |
| `public static String getHost()` | Return stored value/reference: host. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:56–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L56-L58) |
| `public static Integer getMaxRetryAttempt()` | Return stored value/reference: maxRetryAttempt. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L60-L62) |
| `public static String getZookeeperRoot()` | Return stored value/reference: zookeeperRoot. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L64-L66) |
| `public static String getSecretKey()` | Return stored value/reference: secretKey. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:68–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L68-L70) |
| `public static Integer getZookeeperSessionTimeout()` | Return stored value/reference: zookeeperSessionTimeoutInMs. No validation or copying. | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:72–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L72-L74) |

## Business
SOURCE_OBSERVED: Indirect startup configuration input for ZooKeeper connection and retry controls; no dynamic refresh.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
IOException wraps RuntimeException. Null resource/property NPE and numeric NumberFormatException are outside specific catch, can fail class initialization; no failure log here.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `INITIALIZER` | `} catch (IOException e) {` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L39) |
| throw_statement / `INITIALIZER` | `throw new RuntimeException(e);` | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L40) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("zookeeper configuration parameters initialized")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-92B7DC0C36AA | [src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java:38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/config/ConfigurationResourceRepository.java#L38) |
Registry reconciliation: 1 active calls, 1 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: username, password, secretKey. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-configurationresolver-zookeeper-zookeeperprovider

<!-- source dossier: src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.md -->

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
source_path: src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java
source_sha256: b1eeef92de75a93f39e7217b0fbd6db86516a702a0f8d5bc47f6eddd55030c2f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java
business_approved: false
runtime_tested: false
promoted: false
---

# ZooKeeperProvider — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.configurationresolver.zookeeper`. Types: `ZooKeeperProvider` (class_declaration) [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:10–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L10-L49)
Shared lazy ZooKeeper connection; digest credentials only when both configured nonempty.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Singleton/connect/get shared instance unsynchronized; races can create multiple connections; Settings closes connection via try-with-resources, later retrieval reconnects based on isAlive.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L11) |
| `instance` | `ZooKeeperProvider` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L12) |
| `zooKeeperInstance` | `ZooKeeper` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L13) |
Dependencies are imports (some may be unused): `com.nozha.async.server.util.configurationresolver.config.ConfigurationResourceRepository` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L3); `org.apache.zookeeper.ZooKeeper` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L4); `org.slf4j.Logger` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L5); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L6); `java.io.IOException` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/Settings.java:480](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L480) ` try (ZooKeeper zooKeeper = ZooKeeperProvider.getZooKeeperConnection()) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `private void connect() throws IOException` | INFO creation; obtain auth info; new ZooKeeper(host,timeout,null,true); if auth non-null add digest bytes platform charset; assign static connection and INFO successful. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:15–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L15-L23) |
| `private static String getAuthInfo()` | If username/password non-null/nonempty return colon join; else null. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:25–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L25-L31) |
| `public static ZooKeeper getZooKeeperConnection() throws IOException, InterruptedException` | INFO get; if no provider instantiate/connect, else dead state close/reconnect/INFO again; return shared connection. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:33–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L33-L44) |
| `public void close() throws InterruptedException` | Close static connection; checked interrupt propagates. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L46-L48) |

## Business
SOURCE_OBSERVED: Indirect central configuration access; log Connection Created Successfully proves object construction/auth scheduling, not completed connected session.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
connect IOException propagates. getZooKeeperConnection also InterruptedException from closing; no local catches. Failed initial connect leaves instance non-null and connection null, subsequent getState can NPE.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `connect` | `("Creating Connection to ZooKeeper")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-06FAE8C32ECB | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L16) |
| INFO `logger` / `connect` | `("Connection Created Successfully")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-1198D9FD7512 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L22) |
| INFO `logger` / `getZooKeeperConnection` | `("Get Zookeeper Connection")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-BCB5A7BECAF3 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L34) |
| INFO `logger` / `getZooKeeperConnection` | `("Connect again to Zookeeper")` | FALSE/else (instance == null) @35; TRUE (!zooKeeperInstance.getState().isAlive()) @38 | ALOG-D65CA8FC6B5A | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZooKeeperProvider.java#L41) |
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-configurationresolver-zookeeper-zookeeperutil

<!-- source dossier: src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.md -->

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
source_path: src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java
source_sha256: 53f5535d1b5ce240c7913127bc56f0cbc8cf671d97950b97093fce7418b77870
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java
business_approved: false
runtime_tested: false
promoted: false
---

# ZookeeperUtil — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.configurationresolver.zookeeper`. Types: `ZookeeperUtil` (class_declaration) [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:21–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L21-L101)
Read node properties and optionally RSA decrypt devEnc:<cipher>:<alias> values; shared retry counter.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Shared AtomicInteger retry counter across calls; recursive immediate retry no backoff. No watch used getData(path,null,null).
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L22) |
| `ENCRYPTED_MARKER` | `String` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L23) |
| `attempt` | `AtomicInteger` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L24) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L3); `com.nozha.async.server.util.configurationresolver.config.ConfigurationResourceRepository` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L4); `org.apache.zookeeper.KeeperException` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L5); `org.apache.zookeeper.ZooKeeper` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L6); `org.slf4j.Logger` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L7); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L8); `javax.crypto.Cipher` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L10); `java.io.ByteArrayInputStream` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L11); `java.io.IOException` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L12); `java.nio.charset.StandardCharsets` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L13); `java.security.KeyStore` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L14); `java.security.PrivateKey` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L15); `java.util.Base64` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L16); `java.util.Properties` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L17); `java.util.concurrent.ConcurrentHashMap` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L18); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L19)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/Settings.java:487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java#L487) ` Properties zookeeperInfraProperties = ZookeeperUtil.getZNodesData(ConfigurationResourceRepository.getZookeeperRoot() + DELIMITER + "infra",`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static Properties getZNodesData(String path, ZooKeeper zooKeeper, KeyStore keyStore)` | Create Properties, INFO path, fillMap then return. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:26–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L26-L31) |
| `private static void fillMap(ZooKeeper zooKeeper, Properties properties, String path, KeyStore keyStore)` | Merge fetched properties; catch Exception WARN; only connection loss and attempt<=max recursively retry incremented counter, else WARN max; finally ordinary tail reset0. Error not caught. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:33–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L33-L48) |
| `private static Properties getDataProperties(ZooKeeper zooKeeper, String path, KeyStore keyStore) throws IOException, InterruptedException, KeeperException` | Fetch ZooKeeper bytes; load Java Properties stream; for each value devEnc try alias/keyStore decrypt using Settings keystore password; errors WARN retain ciphertext; copy string values into properties. IO/Keeper/Interrupted ERROR; only connection loss rethrow; return others partial. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:50–92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L50-L92) |
| `public static String decryptWithPrivateKey(String encryptedText, PrivateKey privateKey) throws Exception` | Split ciphertext marker, Base64 decode field1, RSA/ECB/PKCS1Padding private-key decrypt, UTF8 return; checked Exception propagated. | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:94–100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L94-L100) |

## Business
SOURCE_OBSERVED: Indirect central startup config; partial/empty returned Properties can preserve defaults; decrypt failure keeps original encrypted value rather than rejecting configuration.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
getDataProperties catches IO/Keeper/Interrupted, ERROR then rethrow only ConnectionLossException; other failures return partial/empty. fillMap catch Exception WARN; connection-loss recursive retry while attempt<=max (inclusive, max+1 retries) else WARN and suppress; reset counter. Decryption failure WARN key and retain value.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `fillMap` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L36) |
| catch_clause / `getDataProperties` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L76) |
| catch_clause / `getDataProperties` | `} catch (IOException \| KeeperException \| InterruptedException e) {` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L85) |
| throw_statement / `getDataProperties` | `throw e;` | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L89) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `getZNodesData` | `("reading config {} from zookeeper", path)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-CCBFB669AB41 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L28) |
| WARN `logger` / `fillMap` | `("an exception occurred while retrieving data of the path {}", path, e)` | CATCH catch (Exception e) @36 | ALOG-E7F1F0C8E4A7 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L37) |
| WARN `logger` / `fillMap` | `("Retrying to get node data, attempt: {}", attempt.getAndIncrement() + 1)` | CATCH catch (Exception e) @36; TRUE (e instanceof KeeperException.ConnectionLossException) @38; TRUE (attempt.get() <= ConfigurationResourceRepository.getMaxRetryAttempt()) @39 | ALOG-9BA711F8D8B8 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L40) |
| WARN `logger` / `fillMap` | `("Won't retry to get node data, reason: maximum attempt has reached!")` | CATCH catch (Exception e) @36; TRUE (e instanceof KeeperException.ConnectionLossException) @38; FALSE/else (attempt.get() <= ConfigurationResourceRepository.getMaxRetryAttempt()) @39 | ALOG-2293B91FBF48 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L43) |
| WARN `logger` / `getDataProperties` | `("An exception occurred while trying to decrypt value of {}", keyString, e)` | lambda/callback execution (caller scheduling described in method review); TRUE (valueString.startsWith(ENCRYPTED_MARKER)) @66; CATCH catch (Exception e) @76 | ALOG-A125DBE43FD3 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L77) |
| ERROR `logger` / `getDataProperties` | `("an exception occurred while retrieving data of the path {}", path, e)` | CATCH catch (IOException \\| KeeperException \\| InterruptedException e) @85 | ALOG-C70E69A3A555 | [src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/configurationresolver/zookeeper/ZookeeperUtil.java#L87) |
Registry reconciliation: 6 active calls, 6 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-cachehealthchecker

<!-- source dossier: src/com/nozha/async/server/util/nosql/CacheHealthChecker.md -->

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
source_path: src/com/nozha/async/server/util/nosql/CacheHealthChecker.java
source_sha256: c64746e783868fb001b30b910779cf0547fb777b035de77454ca4328d6c3987a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java
business_approved: false
runtime_tested: false
promoted: false
---

# CacheHealthChecker — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql`. Types: `CacheHealthChecker` (class_declaration) [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:10–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L10-L34)
Singleton scheduled executor/future tracks one fallback instance per active cycle.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Start synchronized; stop not independently synchronized. First active fallback wins and later reports do not get separate checks. Immediate execution can race future assignment; no scheduler shutdown.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `healthCheckFuture` | `ScheduledFuture<?>` | [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L11) |
| `healthCheckLock` | `Object` | [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L12) |
| `healthCheckScheduler` | `ScheduledExecutorService` | [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L13) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L3); `java.util.concurrent.Executors` [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L5); `java.util.concurrent.ScheduledExecutorService` [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L6); `java.util.concurrent.ScheduledFuture` [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L7); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L8)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/nosql/FallBack.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L15) ` CacheHealthChecker.startHealthCheckIfNeeded(this);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void startHealthCheckIfNeeded(FallBack fallBack)` | Lock; if no future schedule immediate fixed-rate ping with HEALTH_CHECK_PERIOD ms; success reset fallback then cancel/clear future. | [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:15–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L15-L26) |
| `private static void stopHealthCheck()` | If future non-null cancel(false) and null it; no scheduler shutdown. | [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:28–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L28-L33) |

## Business
SOURCE_OBSERVED: Indirect recovery monitor: successful ping resets shared flag and stops scheduled check; no failure event log here.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
scheduleAtFixedRate can throw invalid period/rejection; ping runtime failure terminates scheduled repetition (no catch here).
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/nosql/FallBack.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L15).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-fallback

<!-- source dossier: src/com/nozha/async/server/util/nosql/FallBack.md -->

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
source_path: src/com/nozha/async/server/util/nosql/FallBack.java
source_sha256: 4c4ae6cb69a767481500c74382630afdbb9a8b2a652ca0e59c4a644fef969bd6
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java
business_approved: false
runtime_tested: false
promoted: false
---

# FallBack — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql`. Types: `FallBack` (interface_declaration) [src/com/nozha/async/server/util/nosql/FallBack.java:5–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L5-L23)
Interface holds one shared AtomicBoolean available=true; reportFailure marks false and schedules health check; reset marks true.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
All implementers share static interface field; resetting one backend can mark others available.
### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `java.util.concurrent.atomic.AtomicBoolean` [src/com/nozha/async/server/util/nosql/FallBack.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L15) ` public static void startHealthCheckIfNeeded(FallBack fallBack) {`; [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L5) `public interface ResilientCacheInterface extends CacheCRUDInterface, FallBack {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `default boolean isAvailable()` | Return shared flag. | [src/com/nozha/async/server/util/nosql/FallBack.java:9–11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L9-L11) |
| `default void reportFailure()` | Mark unavailable and ask singleton CacheHealthChecker to start for this object. | [src/com/nozha/async/server/util/nosql/FallBack.java:13–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L13-L16) |
| `default void reset()` | Mark shared flag true. | [src/com/nozha/async/server/util/nosql/FallBack.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L18-L20) |
| `boolean ping();` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/util/nosql/FallBack.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/FallBack.java#L22) |

## Business
SOURCE_OBSERVED: Indirect availability flag shared by all implementing instances/classes, not one flag per backend. No automatic cache operation fallback is implemented by this interface.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class default methods apart from scheduler failures propagated from reportFailure. ping contract implementation owns error handling.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/nosql/CacheHealthChecker.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/CacheHealthChecker.java#L15), [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L5).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-resilientcacheinterface

<!-- source dossier: src/com/nozha/async/server/util/nosql/ResilientCacheInterface.md -->

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
source_path: src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java
source_sha256: fcd741df56a4cce6ff1bb5518ad250d529318953f1ef4282021b1dcc29f51fc0
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java
business_approved: false
runtime_tested: false
promoted: false
---

# ResilientCacheInterface — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql`. Types: `ResilientCacheInterface` (interface_declaration) [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:5–6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L5-L6)
Empty interface combines CacheCRUDInterface and FallBack.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.nozha.async.server.util.CacheCRUDInterface` [src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/ResilientCacheInterface.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L24) `public class AerospikeCRUD implements ResilientCacheInterface {`; [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L11) `public class RedisCrud implements ResilientCacheInterface {`
### Method review
No active declared methods.

## Business
SOURCE_OBSERVED: Indirect cache+health contract; no resilience switching implementation here.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; inherited implementation errors/availability behavior apply.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L24), [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L11).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-aerospike-aerospikecrud

<!-- source dossier: src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.md -->

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
source_path: src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java
source_sha256: 3a53a7463a00aab6038d854effb70ce699d748ae7fa053bfb141f35d6838f348
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java
business_approved: false
runtime_tested: false
promoted: false
---

# AerospikeCRUD — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql.aerospike`. Types: `AerospikeCRUD` (class_declaration) [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:24–549](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L24-L549)
Distributed cache implementation uses factory client, namespace/set settings, typed bins and aggregation UDF count. All public normal operations gated isActive except global/per-server invalidation and ping.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Counters rely on record TTL rounded ms/1000 and server UDF/index existence; toTime parameters unused (time-range UDF comments). Aggregation ResultSet not explicitly closed. Operations create new policy objects; explicit CACHE_TX_TIMEOUT is on routing/index/seen but counter queries use new QueryPolicy defaults. No reportFailure call or fallback selection.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L26) |
Dependencies are imports (some may be unused): `com.aerospike.client.Record` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L3); `com.aerospike.client.*` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L4); `com.aerospike.client.cdt.ListOperation` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L5); `com.aerospike.client.cdt.ListReturnType` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L6); `com.aerospike.client.policy.*` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L7); `com.aerospike.client.query.Filter` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L8); `com.aerospike.client.query.IndexCollectionType` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L9); `com.aerospike.client.query.ResultSet` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L10); `com.aerospike.client.query.Statement` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L11); `com.aerospike.client.Record` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L12); `com.nozha.Settings` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L13); `com.nozha.async.server.util.nosql.ResilientCacheInterface` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L14); `org.slf4j.Logger` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L15); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L16); `java.util.List` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L18); `java.util.UUID` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L19)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/CacheUtil.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/CacheUtil.java#L15) ` private static final AerospikeCRUD aerospikeCRUD = new AerospikeCRUD();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public void putMessage(long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout)` | When active write UUID event record receiver/sender/address/type/time with REPLACE, COMMIT_MASTER and expiry expireTimeout/1000; Throwable ERROR suppressed; slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:28–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L28-L53) |
| `@Override public void openClient(String remoteAddress, int clientType, long time, long expireTimeout)` | When active write UUID opening event address/type/time with same TTL policy; Throwable ERROR suppressed; slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:55–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L55-L77) |
| `@Override public long countMessagesByReceiver(long receiverId, long toTime)` | Active receiver equality/index query count UDF; default -1, first result cast long; toTime unused; Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:79–105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L79-L105) |
| `@Override public long countMessagesBySender(long senderId, long toTime)` | Active sender equality/index count UDF; default -1; toTime unused; Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:107–133](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L107-L133) |
| `@Override public long countMessagesBySenderRemoteAddress(String remoteAddress, long toTime)` | Active senderAd equality/index count UDF; default -1; toTime unused; Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:135–161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L135-L161) |
| `@Override public long countOpenedClientByRemoteAddress(String remoteAddress, long toTime)` | Active opening address equality/index count UDF; default -1; toTime unused; Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:163–189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L163-L189) |
| `@Override public void putClientCache(long key, List<Long> serverIds)` | Active REPLACE client-route record key/serverIds with CLIENT_MAP_CACHE_TIMEOUT/1000 and socket/total CACHE_TX_TIMEOUT; ERROR suppressed/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:191–214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L191-L214) |
| `@Override public void invalidateClientCache(long key)` | Active delete client cache key; ignore returned deletion boolean; ERROR suppressed/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:216–228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L216-L228) |
| `@Override public List<Long> getClientCache(long key)` | Active get route record serverIds cast list; absent/inactive null, Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:230–248](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L230-L248) |
| `@Override public void putClientLastSeen(long key)` | Compute epoch now; active write key/Time with last-seen TTL, tx timeout and configured retry; INFO insert last seen also when inactive; Throwable ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:250–276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L250-L276) |
| `@Override public void invalidateClientLastSeen(long key)` | Active delete last-seen key; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:278–290](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L278-L290) |
| `@Override public Long getClientLastSeen(long key)` | Active get Time bin, default -1; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:292–309](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L292-L309) |
| `@Override public void putTrackerCache(long key, Long serverId)` | Active REPLACE tracker key/serverId with TRACKER_MAP_CACHE_TIMEOUT/1000 and tx timeout; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:311–334](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L311-L334) |
| `@Override public void invalidateTrackerCache(long key)` | Active delete tracker; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:336–348](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L336-L348) |
| `@Override public Long getTrackerCache(long key)` | Active get serverId bin, default null; ERROR suppressed; slow threshold INFO (not WARN). | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:350–367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L350-L367) |
| `@Override public void putClientServerIndexCache(long key, int index)` | Active REPLACE client index key/ind with configured index TTL and tx timeout; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:369–392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L369-L392) |
| `@Override public void invalidateClientServerIndexCache(long key)` | Active delete index; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:394–406](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L394-L406) |
| `@Override public Integer getClientServerIndexCache(long key)` | Active get ind bin as Long then intValue, default null; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:408–425](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L408-L425) |
| `@Override public void putProvision(String peerNameDestination, long expireTimeout)` | Active write UUID provision record destination/time with requested TTL; ERROR/slow WARN. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:427–448](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L427-L448) |
| `@Override public long countProvisionByDestination(String peerNameDestination)` | Active destination equality/index query count UDF, default -1; ERROR; slow template incorrectly action=putProvision. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:450–474](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L450-L474) |
| `@Override public void invalidateClientCacheByServerId(long serverId)` | Ungated factory getClient.execute removeByValue serverId from matching serverIds list records with write policy; logs INFO return; Throwable WARN suppressed; returned async execution task not awaited. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:477–501](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L477-L501) |
| `@Override public void invalidateAllClientCache()` | Ungated truncate entire client-cache set, INFO return; Exception INFO suppressed. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:503–511](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L503-L511) |
| `private void put(WritePolicy policy, Key key, Bin... bins) throws AerospikeException` | Direct client.put delegates and propagates AerospikeException. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:513–515](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L513-L515) |
| `private Record get(Policy policy, Key key) throws AerospikeException` | Direct client.get delegates and returns Record. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:517–519](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L517-L519) |
| `private boolean delete(WritePolicy policy, Key key) throws AerospikeException` | Direct client.delete returns boolean. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:521–523](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L521-L523) |
| `private ResultSet queryAggregate(QueryPolicy policy, Statement statement, String packageName, String functionName, Value... functionArgs) throws AerospikeException` | Direct queryAggregate returns ResultSet. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:525–527](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L525-L527) |
| `@Override public boolean ping()` | Get client; disconnected/no nodes INFO false; still perform dummy-key get with tx timeout even when disconnected; missing dummy record acceptable. AerospikeException INFO false; NPE not caught. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:529–548](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L529-L548) |

## Business
SOURCE_OBSERVED: Indirect route, last-seen and load/provision counters. Cache write errors suppressed; count failure/inactive returns -1, misses for routing/index return null, last-seen miss=-1. LoadManager compares >cap, so -1 may bypass limits; no production incident claim.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Normal public operations catch Throwable and log ERROR then return defaults; slow logs occur after failures too. Global truncate catches Exception INFO; per-server invalidation Throwable WARN. Private delegates declare AerospikeException propagated to wrappers. ping catches only AerospikeException; null client NPE can escape.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `putMessage` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L47) |
| catch_clause / `openClient` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L72) |
| catch_clause / `countMessagesByReceiver` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L99) |
| catch_clause / `countMessagesBySender` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L127) |
| catch_clause / `countMessagesBySenderRemoteAddress` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:155](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L155) |
| catch_clause / `countOpenedClientByRemoteAddress` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L183) |
| catch_clause / `putClientCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L209) |
| catch_clause / `invalidateClientCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:223](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L223) |
| catch_clause / `getClientCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:242](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L242) |
| catch_clause / `putClientLastSeen` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:271](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L271) |
| catch_clause / `invalidateClientLastSeen` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:285](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L285) |
| catch_clause / `getClientLastSeen` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:303](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L303) |
| catch_clause / `putTrackerCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:329](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L329) |
| catch_clause / `invalidateTrackerCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:343](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L343) |
| catch_clause / `getTrackerCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:361](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L361) |
| catch_clause / `putClientServerIndexCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:387](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L387) |
| catch_clause / `invalidateClientServerIndexCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:401](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L401) |
| catch_clause / `getClientServerIndexCache` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:419](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L419) |
| catch_clause / `putProvision` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:443](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L443) |
| catch_clause / `countProvisionByDestination` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:468](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L468) |
| catch_clause / `invalidateClientCacheByServerId` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:498](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L498) |
| catch_clause / `invalidateAllClientCache` | `} catch (Exception e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:508](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L508) |
| catch_clause / `ping` | `} catch (AerospikeException e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:543](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L543) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| ERROR `logger` / `putMessage` | `("An exception occurred in aerospike, putMessage for receiverId={} , senderId={} , senderRemoteAddress={} , clientType={} ", receiverId, senderId, senderRemoteAddress, clientType, e)` | CATCH catch (Throwable e) @47 | ALOG-60F4EA8C6463 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:48–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L48-L49) |
| WARN `logger` / `putMessage` | `("time more than threshold in AEROSPIKE, action=putMessage, time={}", (System.currentTimeMillis() - startTime))` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @51 | ALOG-94C72852F3D1 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L52) |
| ERROR `logger` / `openClient` | `("An exception occurred aerospike, in openClient for remoteAddress={} ,clientType={}", remoteAddress, clientType, e)` | CATCH catch (Throwable e) @72 | ALOG-8D49D26B5EEE | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L73) |
| WARN `logger` / `openClient` | `("time more than threshold in AEROSPIKE, action=openClient, time={}", (System.currentTimeMillis() - startTime))` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @75 | ALOG-EA2CB8F5F586 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L76) |
| ERROR `logger` / `countMessagesByReceiver` | `("An exception occurred in aerospike, countMessages for receiverId={} ", receiverId, e)` | CATCH catch (Throwable e) @99 | ALOG-88C628F64C7B | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:100](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L100) |
| WARN `logger` / `countMessagesByReceiver` | `("time more than threshold in AEROSPIKE, action=countMessagesByReceiver, time={}, receiverId={}", (System.currentTimeMillis() - startTime), receiverId)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @102 | ALOG-A671323EE2A9 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L103) |
| ERROR `logger` / `countMessagesBySender` | `("An exception occurred in aerospike, countMessages for senderId={}", senderId, e)` | CATCH catch (Throwable e) @127 | ALOG-456951CD8712 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L128) |
| WARN `logger` / `countMessagesBySender` | `("time more than threshold in AEROSPIKE, action=countMessagesBySender, time={}, senderId={}", (System.currentTimeMillis() - startTime), senderId)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @130 | ALOG-C3C33846F530 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L131) |
| ERROR `logger` / `countMessagesBySenderRemoteAddress` | `("An exception occurred in aerospike, countMessagesBySender for remoteAddress={}", remoteAddress, e)` | CATCH catch (Throwable e) @155 | ALOG-36C61B8AFBA0 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L156) |
| WARN `logger` / `countMessagesBySenderRemoteAddress` | `("time more than threshold in AEROSPIKE, action=countMessagesBySenderRemoteAddress, time={}, remoteAddress={}", (System.currentTimeMillis() - startTime), remoteAddress)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @158 | ALOG-9639C839BACA | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L159) |
| ERROR `logger` / `countOpenedClientByRemoteAddress` | `("An exception occurred in aerospike, countOpenedClient for remoteAddress={}", remoteAddress, e)` | CATCH catch (Throwable e) @183 | ALOG-F751A44D658A | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L184) |
| WARN `logger` / `countOpenedClientByRemoteAddress` | `("time more than threshold in AEROSPIKE, action=countOpenedClientByRemoteAddress, time={}, remoteAddress={}", (System.currentTimeMillis() - startTime), remoteAddress)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @186 | ALOG-7A92AD1010E3 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L187) |
| ERROR `logger` / `putClientCache` | `("An exception occurred in aerospike, putClientCache for key={} ", key, e)` | CATCH catch (Throwable e) @209 | ALOG-A50B8361401A | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L210) |
| WARN `logger` / `putClientCache` | `("time more than threshold in AEROSPIKE, action=putClientCache, time={}", (System.currentTimeMillis() - startTime))` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @212 | ALOG-A3824C8FB55D | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L213) |
| ERROR `logger` / `invalidateClientCache` | `("An exception occurred in aerospike, invalidateClientCache for key={}", key, e)` | CATCH catch (Throwable e) @223 | ALOG-2F975D4FD4A3 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L224) |
| WARN `logger` / `invalidateClientCache` | `("time more than threshold in AEROSPIKE, action=invalidateClientCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @226 | ALOG-A555F74CD8D1 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L227) |
| ERROR `logger` / `getClientCache` | `("An exception occurred in aerospike, getClientCache for key={}", key, e)` | CATCH catch (Throwable e) @242 | ALOG-0AAB2FC99930 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:243](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L243) |
| WARN `logger` / `getClientCache` | `("time more than threshold in AEROSPIKE, action=getClientCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @245 | ALOG-0082FBE0AA2A | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L246) |
| INFO `logger` / `putClientLastSeen` | `("insert last seen key={}", key)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-0B7FBB33EA6C | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:270](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L270) |
| ERROR `logger` / `putClientLastSeen` | `("An exception occurred in aerospike, putClientLastSeen for key={}", key, e)` | CATCH catch (Throwable e) @271 | ALOG-AB58EFA412A0 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:272](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L272) |
| WARN `logger` / `putClientLastSeen` | `("time more than threshold in AEROSPIKE, action=putClientLastSeen, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @274 | ALOG-764FC2214B53 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L275) |
| ERROR `logger` / `invalidateClientLastSeen` | `("An exception occurred in aerospike, invalidateClientLastSeen for key={}", key, e)` | CATCH catch (Throwable e) @285 | ALOG-380CAA812400 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:286](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L286) |
| WARN `logger` / `invalidateClientLastSeen` | `("time more than threshold in AEROSPIKE, action=invalidateClientLastSeen, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @288 | ALOG-84A4158EA485 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:289](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L289) |
| ERROR `logger` / `getClientLastSeen` | `("An exception occurred in aerospike, getClientLastSeen for key={}", key, e)` | CATCH catch (Throwable e) @303 | ALOG-9FCCFB1798AC | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:304](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L304) |
| WARN `logger` / `getClientLastSeen` | `("time more than threshold in AEROSPIKE, action=getClientLastSeen, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @306 | ALOG-6F301B6C90BF | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:307](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L307) |
| ERROR `logger` / `putTrackerCache` | `("An exception occurred in aerospike, putTrackerCache for key={} , serverId={}", key, serverId, e)` | CATCH catch (Throwable e) @329 | ALOG-023B48758A11 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:330](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L330) |
| WARN `logger` / `putTrackerCache` | `("time more than threshold in AEROSPIKE, action=putTrackerCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @332 | ALOG-4FC6577CC2B1 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:333](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L333) |
| ERROR `logger` / `invalidateTrackerCache` | `("An exception occurred in aerospike, invalidateTrackerCache for key={}", key, e)` | CATCH catch (Throwable e) @343 | ALOG-33848B9B50FB | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:344](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L344) |
| WARN `logger` / `invalidateTrackerCache` | `("time more than threshold in AEROSPIKE, action=invalidateTrackerCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @346 | ALOG-2095885F46B0 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:347](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L347) |
| ERROR `logger` / `getTrackerCache` | `("An exception occurred in aerospike, getTrackerCache for key={}", key, e)` | CATCH catch (Throwable e) @361 | ALOG-E49E0B85297C | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:362](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L362) |
| INFO `logger` / `getTrackerCache` | `("time more than threshold in AEROSPIKE, action=getTrackerCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @364 | ALOG-F18CF48CF6B0 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:365](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L365) |
| ERROR `logger` / `putClientServerIndexCache` | `("An exception occurred in aerospike, putClientServerIndexCache for key={}", key, e)` | CATCH catch (Throwable e) @387 | ALOG-D82BB392C637 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:388](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L388) |
| WARN `logger` / `putClientServerIndexCache` | `("time more than threshold in AEROSPIKE, action=putClientServerIndexCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @390 | ALOG-EAF0CA745790 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:391](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L391) |
| ERROR `logger` / `invalidateClientServerIndexCache` | `("An exception occurred in aerospike, invalidateClientServerIndexCache for key={}", key, e)` | CATCH catch (Throwable e) @401 | ALOG-5D4B9B288A06 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:402](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L402) |
| WARN `logger` / `invalidateClientServerIndexCache` | `("time more than threshold in AEROSPIKE, action=invalidateClientServerIndexCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @404 | ALOG-221A98E01F88 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:405](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L405) |
| ERROR `logger` / `getClientServerIndexCache` | `("An exception occurred in aerospike, getClientServerIndexCache for key={}", key, e)` | CATCH catch (Throwable e) @419 | ALOG-91A52F7AEFAA | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:420](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L420) |
| WARN `logger` / `getClientServerIndexCache` | `("time more than threshold in AEROSPIKE, action=getClientServerIndexCache, time={}, key={}", (System.currentTimeMillis() - startTime), key)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @422 | ALOG-B91487C8E430 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:423](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L423) |
| ERROR `logger` / `putProvision` | `("An exception occurred in aerospike, putProvision for destination peerName={}", peerNameDestination, e)` | CATCH catch (Throwable e) @443 | ALOG-84F836E64772 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:444](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L444) |
| WARN `logger` / `putProvision` | `("time more than threshold in AEROSPIKE, action=putProvision, time={}, peerNameDestination={}", (System.currentTimeMillis() - startTime), peerNameDestination)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @446 | ALOG-A0D43FF1E988 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:447](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L447) |
| ERROR `logger` / `countProvisionByDestination` | `("An exception occurred in aerospike, countProvisionByDestination for destination peerName={}", peerNameDestination, e)` | CATCH catch (Throwable e) @468 | ALOG-FBFCAC728317 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:469](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L469) |
| WARN `logger` / `countProvisionByDestination` | `("time more than threshold in AEROSPIKE, action=putProvision, time={}, peerNameDestination={}", (System.currentTimeMillis() - startTime), peerNameDestination)` | TRUE ((System.currentTimeMillis() - startTime) > Settings.AEROSPIKE_THRESHOLD_TIME) @471 | ALOG-A8DE765BA108 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:472](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L472) |
| INFO `logger` / `invalidateClientCacheByServerId` | `("invalidate client cache for serverId:{}", serverId)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-8A24149FDDD9 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:497](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L497) |
| WARN `logger` / `invalidateClientCacheByServerId` | `("An exception occurred invalidateClientCacheByServerId serverId={} ", serverId, e)` | CATCH catch (Throwable e) @498 | ALOG-1B1274A1F84C | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:499](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L499) |
| INFO `logger` / `invalidateAllClientCache` | `("invalidate All Client Cache ")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-44B97E92D376 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:507](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L507) |
| INFO `logger` / `invalidateAllClientCache` | `("Exception in invalidateAllClientCache", e)` | CATCH catch (Exception e) @508 | ALOG-C0940BAC33B5 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:509](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L509) |
| INFO `logger` / `ping` | `("Aerospike is not connected")` | TRUE (!client.isConnected() \\|\\| client.getNodes().length == 0) @534 | ALOG-509538B66D7B | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:535](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L535) |
| INFO `logger` / `ping` | `("Aerospike ping failed", e)` | CATCH catch (AerospikeException e) @543 | ALOG-0593CF67FE14 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:544](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L544) |
Registry reconciliation: 47 active calls, 47 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-aerospike-aerospikefactory

<!-- source dossier: src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.md -->

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
source_path: src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java
source_sha256: 151a7c54176682dde67636d631698f88297e31b4b18a78d6eef5d22ed778c542
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java
business_approved: false
runtime_tested: false
promoted: false
---

# AerospikeFactory — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql.aerospike`. Types: `AerospikeFactory` (class_declaration) [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:20–225](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L20-L225)
Static client initialization only if configured address; builds credentials/socket/total/retry defaults, seeds hosts, registers all files in UDF directory, sleeps10s; no createIndices call in initializer (63).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
getClient synchronized read, close unsynchronized write; race with calls can NPE/use closed client. Default read/write settings not necessarily applied to explicitly new policies in CRUD.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L21) |
| `client` | `AerospikeClient` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L23) |
Dependencies are imports (some may be unused): `com.aerospike.client.*` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L3); `com.aerospike.client.lua.LuaConfig` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L4); `com.aerospike.client.policy.ClientPolicy` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L5); `com.aerospike.client.query.IndexCollectionType` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L6); `com.aerospike.client.query.IndexType` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L7); `com.aerospike.client.query.Statement` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L8); `com.nozha.Settings` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L9); `org.slf4j.Logger` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L10); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L11); `java.io.File` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L13); `java.util.ArrayList` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L14); `java.util.List` [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L15)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L182) ` Class.forName("com.nozha.async.server.util.nosql.aerospike.AerospikeFactory");`; [src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeCRUD.java#L32) ` if (AerospikeFactory.isActive()) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `static Key getKey(String setName, Value value)` | Create namespace/set/value Key. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L73-L75) |
| `static synchronized AerospikeClient getClient()` | Synchronized return static client. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L77-L79) |
| `static Statement getStatement()` | New Statement with configured namespace. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:81–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L81-L85) |
| `static boolean isActive()` | Return client non-null only. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:87–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L87-L89) |
| `public static void close()` | If client exists close and clear reference. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:91–96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L91-L96) |
| `private static void createIndices()` | Only active client: six index sequences for serverIds list, receiver/sender/senderAd/address/destination. Each drop Throwable WARN then dropped INFO regardless; create+wait and created INFO. Last creation label says client_map_server_index although index is prov_cnt_index. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:98–220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L98-L220) |
| `public static void main(String[] args)` | Explicit standalone main invokes createIndices; normal initialization does not. | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:222–224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L222-L224) |

## Business
SOURCE_OBSERVED: Indirect distributed routing/counter cache. isActive means client reference non-null, not live backend health. Initialization indices-created log is misleading because invocation is commented.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
AerospikeException warns/suppresses initialization leaving null or partially initialized client; InterruptedException warns but continues. Other filesystem/null/runtime failures escape static init. Index-drop catches Throwable then logs dropped even on failure; create errors propagate.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `INITIALIZER` | `} catch (InterruptedException e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L59) |
| catch_clause / `INITIALIZER` | `} catch (AerospikeException e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L65) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L107) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L126) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L146) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L166) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:186](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L186) |
| catch_clause / `createIndices` | `} catch (Throwable e) {` | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L206) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("host to connect: {}:{}", address, Settings.AEROSPIKE_PORT)` | TRUE (Settings.AEROSPIKE_ADDRESS != null) @26; LOOP for (String address : addresses) @45 | ALOG-CC8615B08BDD | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L47) |
| WARN `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("An exception occurred", e)` | TRUE (Settings.AEROSPIKE_ADDRESS != null) @26; CATCH catch (InterruptedException e) @59 | ALOG-92BE6B742136 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L60) |
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("Aerospike is activated")` | TRUE (Settings.AEROSPIKE_ADDRESS != null) @26 | ALOG-AA7BACE99D68 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L62) |
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("Aerospike indices created")` | TRUE (Settings.AEROSPIKE_ADDRESS != null) @26 | ALOG-7402EAFC1C9C | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L64) |
| WARN `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("An exception occurred", e)` | TRUE (Settings.AEROSPIKE_ADDRESS != null) @26; CATCH catch (AerospikeException e) @65 | ALOG-A60C9BA3821F | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L66) |
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("Aerospike not activated")` | FALSE/else (Settings.AEROSPIKE_ADDRESS != null) @26 | ALOG-2FD422374F9C | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L69) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @107 | ALOG-26C03C27C70A | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L108) |
| INFO `logger` / `createIndices` | `("index cache_server_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-C3C3A654E31D | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:110](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L110) |
| INFO `logger` / `createIndices` | `("index cache_server_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-1FEC94C46117 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:118](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L118) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @126 | ALOG-4F2DF044E27B | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L127) |
| INFO `logger` / `createIndices` | `("index msg_cnt_receiver_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-BB3B5434758F | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L129) |
| INFO `logger` / `createIndices` | `("index msg_cnt_receiver_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-8429AB60EA53 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L138) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @146 | ALOG-F5373D3E3E2F | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L147) |
| INFO `logger` / `createIndices` | `("index msg_cnt_sender_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-D29618937762 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L149) |
| INFO `logger` / `createIndices` | `("index msg_cnt_sender_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-F93B217ECC78 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L158) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @166 | ALOG-F5478F25AA0B | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:167](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L167) |
| INFO `logger` / `createIndices` | `("index msg_cnt_sender_ad_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-A672363BAA97 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L169) |
| INFO `logger` / `createIndices` | `("index msg_cnt_sender_ad_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-8B12E0CF23F2 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L178) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @186 | ALOG-D961203F1711 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:187](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L187) |
| INFO `logger` / `createIndices` | `("index open_address_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-A4C6E8BDADAF | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L189) |
| INFO `logger` / `createIndices` | `("index open_address_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-5DA60DBB6097 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:198](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L198) |
| WARN `logger` / `createIndices` | `("An exception occurred", e)` | TRUE (AerospikeFactory.isActive()) @99; CATCH catch (Throwable e) @206 | ALOG-22059092F4F1 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L207) |
| INFO `logger` / `createIndices` | `("index prov_cnt_index droped")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-93E5CAA78251 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L209) |
| INFO `logger` / `createIndices` | `("index client_map_server_index created")` | TRUE (AerospikeFactory.isActive()) @99 | ALOG-A35D233F4AA7 | [src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java:218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/aerospike/AerospikeFactory.java#L218) |
Registry reconciliation: 24 active calls, 24 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-redis-redisconnectionfactory

<!-- source dossier: src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.md -->

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
source_path: src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java
source_sha256: 1a9fd448ad529bfb58cd4455f28a78a727618bbed5abef9ba80f9ebae12ef873
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java
business_approved: false
runtime_tested: false
promoted: false
---

# RedisConnectionFactory — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql.redis`. Types: `RedisConnectionFactory` (class_declaration) [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:21–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L21-L102)
Static standalone if one configured node, cluster otherwise; URLs assembled colon-delimited host:port:user:password, ByteArrayCodec and100ms timeout options.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Both INFO connection logs include constructed URL(s) with plaintext username/password (50,73). Getter synchronization is instance-level over static fields.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L22) |
| `isCluster` | `boolean` | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L24) |
| `connection` | `StatefulRedisConnection<byte[], byte[]>` | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L25) |
| `asyncCommands` | `RedisAdvancedClusterAsyncCommands<byte[], byte[]>` | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L26) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L3); `io.lettuce.core.ClientOptions` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L4); `io.lettuce.core.RedisClient` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L5); `io.lettuce.core.RedisURI` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L6); `io.lettuce.core.TimeoutOptions` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L7); `io.lettuce.core.api.StatefulRedisConnection` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L8); `io.lettuce.core.cluster.ClusterClientOptions` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L9); `io.lettuce.core.cluster.RedisClusterClient` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L10); `io.lettuce.core.cluster.api.StatefulRedisClusterConnection` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L11); `io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L12); `io.lettuce.core.codec.ByteArrayCodec` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L13); `org.slf4j.Logger` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L14); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L15); `java.time.Duration` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L17); `java.util.ArrayList` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L18); `java.util.List` [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L19)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L13) ` private static final RedisConnectionFactory redisConfig = new RedisConnectionFactory();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static List<String> buildRedisUrls()` | For each REDIS_ADDRESS index concatenate address/port/user/password using same array index; return list, no validation. | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:77–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L77-L89) |
| `public boolean isCluster()` | Return static cluster mode. | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:91–93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L91-L93) |
| `public synchronized StatefulRedisConnection<byte[], byte[]> getConnection()` | Synchronized instance getter for static standalone connection (cluster mode null). | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:95–97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L95-L97) |
| `public synchronized RedisAdvancedClusterAsyncCommands<byte[], byte[]> getAsyncCommands()` | Synchronized instance getter for static cluster async commands (standalone null). | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:99–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L99-L101) |

## Business
SOURCE_OBSERVED: Indirect Redis connection/health dependency; constructed static connection has no cleanup API here.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Empty list throws IllegalArgumentException Redis URIs list cannot be empty; arrays null/unequal or colon-containing credentials can cause NPE/bounds/parse failures before connect. Connection failures propagate from static init.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `INITIALIZER` | `throw new IllegalArgumentException("Redis URIs list cannot be empty");` | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L31) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("Connected to standalone Redis:{}", redisUris.get(0))` | TRUE (redisUris.size() == 1) @33 | ALOG-9C329D1EF39A | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L50) |
| INFO `logger` / `STATIC_OR_FIELD_INITIALIZER` | `("Connected to Redis Cluster with nodes:{} ", redisUris)` | FALSE/else (redisUris.size() == 1) @33 | ALOG-E096FFE7BB2C | [src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisConnectionFactory.java#L73) |
Registry reconciliation: 2 active calls, 2 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-util-nosql-redis-rediscrud

<!-- source dossier: src/com/nozha/async/server/util/nosql/redis/RedisCrud.md -->

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
source_path: src/com/nozha/async/server/util/nosql/redis/RedisCrud.java
source_sha256: ef99b37a6872f0581e66503da5ce5511e77cb3d7674737697adf4db5e3460d44
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java
business_approved: false
runtime_tested: false
promoted: false
---

# RedisCrud — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.util.nosql.redis`. Types: `RedisCrud` (class_declaration) [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:11–174](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L11-L174)
Redis resilient-cache implementation mostly empty or constant-return stubs (45–152); unused capacity Lua script15–42. ping is sole substantive backend operation.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Instantiates static RedisConnectionFactory; cluster ping waits Future.get without own timeout, relying client options; no reportFailure call/fallback switching.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `redisConfig` | `RedisConnectionFactory` | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L13) |
| `logger` | `Logger` | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L14) |
| `luaScript` | `String` | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L15) |
Dependencies are imports (some may be unused): `com.nozha.async.server.util.nosql.ResilientCacheInterface` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L3); `io.lettuce.core.RedisException` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L4); `org.slf4j.Logger` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L5); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L6); `java.util.List` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L8); `java.util.concurrent.ExecutionException` [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L9)
Representative source references (lexical uses, not a dynamic call graph): No external class-name use found in this Java snapshot; framework/reflection use may still exist.
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public void putMessage(long receiverId, long senderId, String senderRemoteAddress, int clientType, long time, long expireTimeout)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:44–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L44-L47) |
| `@Override public void openClient(String remoteAddress, int clientType, long time, long expireTimeout)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:49–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L49-L52) |
| `@Override public long countMessagesByReceiver(long receiverId, long toTime)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:54–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L54-L57) |
| `@Override public long countMessagesBySender(long senderId, long toTime)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:59–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L59-L62) |
| `@Override public long countMessagesBySenderRemoteAddress(String remoteAddress, long toTime)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:64–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L64-L67) |
| `@Override public long countOpenedClientByRemoteAddress(String remoteAddress, long toTime)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:69–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L69-L72) |
| `@Override public void putClientCache(long key, List<Long> serverIds)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:74–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L74-L77) |
| `@Override public void invalidateClientCache(long key)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:79–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L79-L82) |
| `@Override public List<Long> getClientCache(long key)` | Stub returns null regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:84–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L84-L87) |
| `@Override public void putTrackerCache(long key, Long serverId)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:89–92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L89-L92) |
| `@Override public void invalidateTrackerCache(long key)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:94–97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L94-L97) |
| `@Override public Long getTrackerCache(long key)` | Stub returns 0L regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:99–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L99-L102) |
| `@Override public void putClientServerIndexCache(long key, int index)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:104–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L104-L107) |
| `@Override public void invalidateClientServerIndexCache(long key)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:109–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L109-L112) |
| `@Override public Integer getClientServerIndexCache(long key)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:114–117](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L114-L117) |
| `@Override public void putClientLastSeen(long key)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:119–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L119-L122) |
| `@Override public void invalidateClientLastSeen(long key)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:124–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L124-L127) |
| `@Override public Long getClientLastSeen(long key)` | Stub returns 0L regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:129–132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L129-L132) |
| `@Override public void putProvision(String peerNameDestination, long expireTimeout)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:134–137](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L134-L137) |
| `@Override public long countProvisionByDestination(String peerNameDestination)` | Stub returns 0 regardless input; no backend read. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:139–142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L139-L142) |
| `@Override public void invalidateClientCacheByServerId(long serverId)` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:144–147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L144-L147) |
| `@Override public void invalidateAllClientCache()` | No-op; performs no backend mutation. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:149–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L149-L152) |
| `@Override public boolean ping()` | Start true; cluster async ping.get or standalone sync ping; non-PONG false/INFO; checked Redis/interruption/execution failures INFO message-only then false. | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:154–173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L154-L173) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: stub writes/invalidation do nothing; counters return0, route miss null, tracker/lastSeen0. Do not claim Redis provides Async cache parity or rate-capacity borrowing: Lua string is never invoked here.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
ping RedisException/InterruptedException/ExecutionException→INFO message then false; no interrupt restoration. Other runtime failures propagate. Non-PONG logs and false.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `ping` | `} catch (RedisException \| InterruptedException \| ExecutionException e) {` | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L168) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `ping` | `("Redis ping failed")` | TRUE (!"PONG".equals(pong)) @164 | ALOG-35BDDF9F1BDE | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:166](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L166) |
| INFO `logger` / `ping` | `("Redis ping failed: {}", e.getMessage())` | CATCH catch (RedisException \\| InterruptedException \\| ExecutionException e) @168 | ALOG-653D71346FDD | [src/com/nozha/async/server/util/nosql/redis/RedisCrud.java:170](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/nosql/redis/RedisCrud.java#L170) |
Registry reconciliation: 2 active calls, 2 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-accessdto

<!-- source dossier: src/com/nozha/async/server/vo/AccessDTO.md -->

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
source_path: src/com/nozha/async/server/vo/AccessDTO.java
source_sha256: 4cec1d9c6862f9f166858186e2f1fa45d909b4ce71b610431162b0fe07ba677b
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java
business_approved: false
runtime_tested: false
promoted: false
---

# AccessDTO — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `AccessDTO` (class_declaration) [src/com/nozha/async/server/vo/AccessDTO.java:3–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L3-L57)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `peerId` | `Long` | [src/com/nozha/async/server/vo/AccessDTO.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L4) |
| `peerName` | `String` | [src/com/nozha/async/server/vo/AccessDTO.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L5) |
| `businessId` | `Long` | [src/com/nozha/async/server/vo/AccessDTO.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L6) |
| `value` | `String` | [src/com/nozha/async/server/vo/AccessDTO.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L7) |
| `isEnable` | `Boolean` | [src/com/nozha/async/server/vo/AccessDTO.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L8) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/AccessibilityService.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L17) ` private static List<AccessDTO> businessAccessList = new ArrayList<>();`; [src/com/nozha/async/server/persistance/AccessibilityCrud.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L22) ` public static List<AccessDTO> loadAccessibility() {`; [src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java#L9) ` List<AccessDTO> loadAccessibility();`; [src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L22) ` public List<AccessDTO> loadAccessibility() {`; [src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java#L22) ` public List<AccessDTO> loadAccessibility() {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public AccessDTO(Long peerId, String peerName, Long businessId, String value, Boolean isEnable)` | Constructor forwards/stores supplied values: `this.peerId = peerId; this.peerName = peerName; this.businessId = businessId; this.value = value; this.isEnable = isEnable;`. References retained; no validation. | [src/com/nozha/async/server/vo/AccessDTO.java:10–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L10-L16) |
| `public Long getPeerId()` | Return stored value/reference: peerId. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:18–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L18-L20) |
| `public void setPeerId(Long peerId)` | Assign this.peerId = peerId. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:22–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L22-L24) |
| `public String getPeerName()` | Return stored value/reference: peerName. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:26–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L26-L28) |
| `public void setPeerName(String peerName)` | Assign this.peerName = peerName. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:30–32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L30-L32) |
| `public Long getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:34–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L34-L36) |
| `public void setBusinessId(Long businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:38–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L38-L40) |
| `public String getValue()` | Return stored value/reference: value. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:42–44](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L42-L44) |
| `public void setValue(String value)` | Assign this.value = value. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:46–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L46-L48) |
| `public Boolean getIsEnable()` | Return stored value/reference: isEnable. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:50–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L50-L52) |
| `public void setIsEnable(Boolean isEnable)` | Assign this.isEnable = isEnable. No validation or copying. | [src/com/nozha/async/server/vo/AccessDTO.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/AccessDTO.java#L54-L56) |

## Business
SOURCE_OBSERVED: Access configuration values plus peer/business identity/enabled flag; AccessibilityService groups value by receiver and compares keys, does not read isEnable in its validation.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/AccessibilityService.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/AccessibilityService.java#L17), [src/com/nozha/async/server/persistance/AccessibilityCrud.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrud.java#L22), [src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/AccessibilityCrudInterface.java#L9), [src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLAccessibilityCRUD.java#L22), [src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleAccessibilityCRUD.java#L22).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-clientmessage

<!-- source dossier: src/com/nozha/async/server/vo/ClientMessage.md -->

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
source_path: src/com/nozha/async/server/vo/ClientMessage.java
source_sha256: 58497b24b2ced38b2b63da5c893ba3645fc872bf6b6de89fdac6c36a73509539
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java
business_approved: false
runtime_tested: false
promoted: false
---

# ClientMessage — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `ClientMessage` (class_declaration) [src/com/nozha/async/server/vo/ClientMessage.java:11–140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L11-L140)
Wire projection from persisted Message; expirationDate is JsonIgnore (21), binary fallback, tracking and version-derived retryCount.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Constructor has persistence/cache reads via RegistrationManager/PeerCRUD; other accessors local.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `id` | `long` | [src/com/nozha/async/server/vo/ClientMessage.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L12) |
| `senderMessageId` | `Long` | [src/com/nozha/async/server/vo/ClientMessage.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L13) |
| `senderName` | `String` | [src/com/nozha/async/server/vo/ClientMessage.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L14) |
| `senderId` | `long` | [src/com/nozha/async/server/vo/ClientMessage.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L15) |
| `type` | `int` | [src/com/nozha/async/server/vo/ClientMessage.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L16) |
| `content` | `String` | [src/com/nozha/async/server/vo/ClientMessage.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L17) |
| `address` | `String` | [src/com/nozha/async/server/vo/ClientMessage.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L18) |
| `origin` | `String` | [src/com/nozha/async/server/vo/ClientMessage.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L19) |
| `trackerId` | `Long` | [src/com/nozha/async/server/vo/ClientMessage.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L20) |
| `expirationDate` | `long` | [src/com/nozha/async/server/vo/ClientMessage.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L21) |
| `time` | `Long` | [src/com/nozha/async/server/vo/ClientMessage.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L23) |
| `retryCount` | `int` | [src/com/nozha/async/server/vo/ClientMessage.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L24) |
| `ARN` | `String` | [src/com/nozha/async/server/vo/ClientMessage.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L26) |
| `ARNStep` | `int` | [src/com/nozha/async/server/vo/ClientMessage.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L27) |
| `binaryContent` | `byte[]` | [src/com/nozha/async/server/vo/ClientMessage.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L28) |
Dependencies are imports (some may be unused): `com.fasterxml.jackson.annotation.JsonIgnore` [src/com/nozha/async/server/vo/ClientMessage.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L3); `com.nozha.async.server.biz.RegistrationManager` [src/com/nozha/async/server/vo/ClientMessage.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L4); `com.nozha.async.server.model.Message` [src/com/nozha/async/server/vo/ClientMessage.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L5); `com.nozha.async.server.persistance.PeerCRUD` [src/com/nozha/async/server/vo/ClientMessage.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L6)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:500](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L500) ` client.sendMessage(new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.ERROR_MESSAGE, JsonUtil.getJson(Server.DESTROY_STA`; [src/com/nozha/async/server/handler/CoapHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L88) ` ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`; [src/com/nozha/async/server/handler/ClientMessagePayload.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L7) ` private final ClientMessage clientMessage;`; [src/com/nozha/async/server/handler/HttpHandler.java:340](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L340) ` ClientMessage clientMessage = null;`; [src/com/nozha/async/server/handler/RestHandler.java:322](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L322) ` ClientMessage clientMessage = ((ClientMessagePayload)outboundPayload).getClientMessage();`; [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62) ` sendMessage(client, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, JsonUtil.getJson(peerId)), 0, 0)`; [src/com/nozha/async/server/handler/TcpHandler.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L132) ` writeData(outputStream, new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.DEVICE_REGISTER, String.valueOf(peer.getId())`; [src/com/nozha/async/server/handler/OutboundPayloadFactory.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/OutboundPayloadFactory.java#L16) ` payload = new ClientMessagePayload(new ClientMessage(message), message.getExpireDate(), message.getSender());`; [src/com/nozha/async/server/util/PODLogUtil.java:74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java#L74) ` public static void logSendRequest(Logger logger, ClientMessage clientMessage, String descName) {`; [src/com/nozha/async/server/client/CoapClient.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/client/CoapClient.java#L25) ` private ClientMessage clientMessage;`; [src/com/nozha/async/server/mediation/notification/NotificationSendingHttpMediator.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationSendingHttpMediator.java#L17) ` return ((ClientMessage) ((HttpContent) object).getRequest().getAttribute("client.getClientMessage")).getContent();`; [src/com/nozha/async/server/mediation/hamsam/HamsamSendingHttpMediator.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamSendingHttpMediator.java#L23) ` String content = ((ClientMessage) httpContent.getRequest().getAttribute("client.getClientMessage")).getContent();`; [src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java#L18) ` ClientMessage clientMessage = (ClientMessage) ((HttpContent) object).getRequest().getAttribute("client.getClientMessage");`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public ClientMessage(long id, long senderMessageId, String senderName, long senderId, int type, String content)` | Assign six parameters and current epoch; remaining fields defaults. | [src/com/nozha/async/server/vo/ClientMessage.java:30–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L30-L38) |
| `public ClientMessage(Message message)` | If private nonzero sender and receiver↔sender membership set senderName from loaded peer else senderId; copy ID and nonzero senderMessageId, type; text content if non-null else binary; nonprivate address/origin; sync tracker=ID; expiry/time/retry=(int)version; non-null ARN copies ARN/step. | [src/com/nozha/async/server/vo/ClientMessage.java:40–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L40-L71) |
| `public long getId()` | Return stored value/reference: id. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:73–75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L73-L75) |
| `public Long getSenderMessageId()` | Return stored value/reference: senderMessageId. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:77–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L77-L79) |
| `public String getSenderName()` | Return stored value/reference: senderName. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:81–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L81-L83) |
| `public long getSenderId()` | Return stored value/reference: senderId. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L85-L87) |
| `public int getType()` | Return stored value/reference: type. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L89-L91) |
| `public String getContent()` | Return stored value/reference: content. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L93-L95) |
| `public String getAddress()` | Return stored value/reference: address. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L97-L99) |
| `public Long getTrackerId()` | Return stored value/reference: trackerId. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:101–103](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L101-L103) |
| `public long getExpirationDate()` | Return stored value/reference: expirationDate. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:105–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L105-L107) |
| `public Long getTime()` | Return stored value/reference: time. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:109–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L109-L111) |
| `public String getOrigin()` | Return stored value/reference: origin. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:113–115](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L113-L115) |
| `public int getRetryCount()` | Return stored value/reference: retryCount. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:117–119](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L117-L119) |
| `public String getARN()` | Return stored value/reference: ARN. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:121–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L121-L123) |
| `public void setARN(String ARN)` | Assign this.ARN = ARN. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:125–127](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L125-L127) |
| `public int getARNStep()` | Return stored value/reference: ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L129-L131) |
| `public void setARNStep(int ARNStep)` | Assign this.ARNStep = ARNStep. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:133–135](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L133-L135) |
| `public byte[] getBinaryContent()` | Return stored value/reference: binaryContent. No validation or copying. | [src/com/nozha/async/server/vo/ClientMessage.java:137–139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/ClientMessage.java#L137-L139) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: private registered sender can be projected to senderName (PeerCRUD lookup); other cases expose senderId. Nonprivate messages copy address/origin; sync messages expose trackerId=message.id. This is serialization role, not access authorization.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Message/null nested objects or null peer from loadPeer can NPE; no catch/status mapping. Cast version long→int can overflow.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:500](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L500), [src/com/nozha/async/server/handler/CoapHandler.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L88), [src/com/nozha/async/server/handler/ClientMessagePayload.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ClientMessagePayload.java#L7), [src/com/nozha/async/server/handler/HttpHandler.java:340](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L340), [src/com/nozha/async/server/handler/RestHandler.java:322](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L322), [src/com/nozha/async/server/handler/WebsocketHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L62), [src/com/nozha/async/server/handler/WebrtcHandler.java:62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebrtcHandler.java#L62), [src/com/nozha/async/server/handler/TcpHandler.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/TcpHandler.java#L132).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: content, address, origin, binaryContent. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-keyvalue

<!-- source dossier: src/com/nozha/async/server/vo/KeyValue.md -->

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
source_path: src/com/nozha/async/server/vo/KeyValue.java
source_sha256: 4a746e878278473d698991f6fd9ac1c6a1d67eb2d906d0305b821c812c0e8660
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java
business_approved: false
runtime_tested: false
promoted: false
---

# KeyValue — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `KeyValue` (class_declaration) [src/com/nozha/async/server/vo/KeyValue.java:3–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L3-L22)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `key` | `K` | [src/com/nozha/async/server/vo/KeyValue.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L4) |
| `value` | `V` | [src/com/nozha/async/server/vo/KeyValue.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L5) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/biz/RegistrationManager.java:199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L199) ` List<KeyValue<Long, Long>> result = new ArrayList<>(peerIds.size());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public K getKey()` | Return stored value/reference: key. No validation or copying. | [src/com/nozha/async/server/vo/KeyValue.java:7–9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L7-L9) |
| `public void setKey(K key)` | Assign this.key = key. No validation or copying. | [src/com/nozha/async/server/vo/KeyValue.java:11–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L11-L13) |
| `public V getValue()` | Return stored value/reference: value. No validation or copying. | [src/com/nozha/async/server/vo/KeyValue.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L15-L17) |
| `public void setValue(V value)` | Assign this.value = value. No validation or copying. | [src/com/nozha/async/server/vo/KeyValue.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/KeyValue.java#L19-L21) |

## Business
SOURCE_OBSERVED: Generic pair; RegistrationManager uses peerId→not-seen duration response.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/biz/RegistrationManager.java:199](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L199).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-vo-messagevo

<!-- source dossier: src/com/nozha/async/server/vo/MessageVO.md -->

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
source_path: src/com/nozha/async/server/vo/MessageVO.java
source_sha256: 712e06a8f1e8a4d116907b1e9aa15e37e5a33a4d6b12ef8d1064da1d9b04a010
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java
business_approved: false
runtime_tested: false
promoted: false
---

# MessageVO — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo`. Types: `MessageVO` (class_declaration) [src/com/nozha/async/server/vo/MessageVO.java:6–106](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L6-L106)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `peerName` | `String` | [src/com/nozha/async/server/vo/MessageVO.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L7) |
| `receivers` | `long[]` | [src/com/nozha/async/server/vo/MessageVO.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L8) |
| `receiverDevices` | `String[]` | [src/com/nozha/async/server/vo/MessageVO.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L9) |
| `collapseId` | `Long` | [src/com/nozha/async/server/vo/MessageVO.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L10) |
| `groupId` | `Long` | [src/com/nozha/async/server/vo/MessageVO.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L11) |
| `index` | `Integer` | [src/com/nozha/async/server/vo/MessageVO.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L12) |
| `priority` | `Integer` | [src/com/nozha/async/server/vo/MessageVO.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L13) |
| `messageId` | `Long` | [src/com/nozha/async/server/vo/MessageVO.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L14) |
| `ttl` | `Long` | [src/com/nozha/async/server/vo/MessageVO.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L15) |
| `content` | `String` | [src/com/nozha/async/server/vo/MessageVO.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L16) |
| `binaryContent` | `byte[]` | [src/com/nozha/async/server/vo/MessageVO.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L17) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:337](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L337) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/handler/MqttHandler.java:212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L212) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/handler/CoapHandler.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L108) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/handler/RestHandler.java:415](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L415) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/biz/MessageManager.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L49) ` MessageVO messageVO;`; [src/com/nozha/async/server/biz/RegistrationManager.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L168) ` MessageVO messageVO = JsonUtil.getObject(messageWrapperVO.getContent(), MessageVO.class);`; [src/com/nozha/async/server/vo/MessageWrapperVO.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L13) ` private MessageVO messageVO;`; [src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java:57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java#L57) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L123) ` MessageVO messageVO = new MessageVO();`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L80) ` MessageVO messageVO = new MessageVO();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public String getPeerName()` | Return stored value/reference: peerName. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L19-L21) |
| `public void setPeerName(String peerName)` | Assign this.peerName = peerName. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L23-L25) |
| `public long[] getReceivers()` | Return stored value/reference: receivers. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L27-L29) |
| `public void setReceivers(long[] receivers)` | Assign this.receivers = receivers. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L31-L33) |
| `public String[] getReceiverDevices()` | Return stored value/reference: receiverDevices. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L35-L37) |
| `public void setReceiverDevices(String[] receiverDevices)` | Assign this.receiverDevices = receiverDevices. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:39–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L39-L41) |
| `public Long getCollapseId()` | Return stored value/reference: collapseId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:43–45](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L43-L45) |
| `public void setCollapseId(Long collapseId)` | Assign this.collapseId = collapseId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L47-L49) |
| `public Long getGroupId()` | Return stored value/reference: groupId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:51–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L51-L53) |
| `public void setGroupId(Long groupId)` | Assign this.groupId = groupId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L55-L57) |
| `public Integer getIndex()` | Return stored value/reference: index. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:59–61](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L59-L61) |
| `public void setIndex(Integer index)` | Assign this.index = index. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:63–65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L63-L65) |
| `public Integer getPriority()` | Return stored value/reference: priority. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:67–69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L67-L69) |
| `public void setPriority(Integer priority)` | Assign this.priority = priority. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:71–73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L71-L73) |
| `public Long getMessageId()` | Return stored value/reference: messageId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:75–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L75-L77) |
| `public void setMessageId(Long messageId)` | Assign this.messageId = messageId. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:79–81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L79-L81) |
| `public Long getTtl()` | Return stored value/reference: ttl. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:83–85](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L83-L85) |
| `public void setTtl(Long ttl)` | Assign this.ttl = ttl. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:87–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L87-L89) |
| `public String getContent()` | Return stored value/reference: content. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:91–93](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L91-L93) |
| `public void setContent(String content)` | Assign this.content = content. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:95–97](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L95-L97) |
| `public byte[] getBinaryContent()` | Return stored value/reference: binaryContent. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:99–101](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L99-L101) |
| `public void setBinaryContent(byte[] binaryContent)` | Assign this.binaryContent = binaryContent. No validation or copying. | [src/com/nozha/async/server/vo/MessageVO.java:103–105](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageVO.java#L103-L105) |

## Business
SOURCE_OBSERVED: Incoming message content/binary/recipient/device/collapse/group/order/priority/sender messageId/TTL values; MessageManager owns defaults and validation.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/Server.java:337](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L337), [src/com/nozha/async/server/handler/MqttHandler.java:212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L212), [src/com/nozha/async/server/handler/CoapHandler.java:108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/CoapHandler.java#L108), [src/com/nozha/async/server/handler/RestHandler.java:415](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/RestHandler.java#L415), [src/com/nozha/async/server/biz/MessageManager.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L49), [src/com/nozha/async/server/biz/RegistrationManager.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/RegistrationManager.java#L168), [src/com/nozha/async/server/vo/MessageWrapperVO.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/MessageWrapperVO.java#L13), [src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java:57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/notification/NotificationReceivingHttpMediator.java#L57).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: content, binaryContent. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
