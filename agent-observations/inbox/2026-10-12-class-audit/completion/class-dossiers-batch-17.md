# Async Java class dossiers — candidate batch 17


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java
source_sha256: 16759049474744c21e430bcaf3f1e77eb8f6985723fa771525f9ce165dcf7aa1
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.business`. Types: `BusinessConfig` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:6–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L6-L80)
Mutable BusinessConfig blocking state with AtomicInteger count, epoch expiry and ordinary metadata/boolean fields.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Setter replaces atomic count and extends expiry now+BLOCK_LIFE_TIME_MS; parameter constructors initialize expiry to now, so positive initial counts can expire immediately. Fields/check-get-decrement sequences are not jointly atomic.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L8) |
| `blockCount` | `AtomicInteger` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L9) |
| `hasWatch` | `boolean` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L10) |
| `isBlock` | `boolean` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L11) |
| `expireTime` | `long` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L12) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L3); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L4)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L42) ` Map<String, BusinessConfig> loadBusinessConfigs(int serverId);`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L80) ` public static Map<String, BusinessConfig> loadBusinessConfigs(int serverId) {`; [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L33) ` private static Map<String, BusinessConfig> businessConfigMap = new ConcurrentHashMap<>();`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:371](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L371) ` public Map<String, BusinessConfig> loadBusinessConfigs(int serverId) {`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:372](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L372) ` public Map<String, BusinessConfig> loadBusinessConfigs(int serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BusinessConfig()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:14–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L14-L15) |
| `public BusinessConfig(String businessId, boolean isBlock, boolean hasWatch)` | Constructor forwards/stores supplied values: `this.businessId = businessId; this.blockCount = new AtomicInteger(0); this.hasWatch = hasWatch; this.isBlock = isBlock; this.expireTime = System.currentTimeMillis();`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:17–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L17-L23) |
| `public BusinessConfig(String businessId, int blockCount, boolean isBlock, boolean hasWatch)` | Constructor forwards/stores supplied values: `this.businessId = businessId; this.blockCount = new AtomicInteger(blockCount); this.hasWatch = hasWatch; this.isBlock = isBlock; this.expireTime = System.currentTimeMillis();`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:25–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L25-L31) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L33-L35) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L37-L39) |
| `public AtomicInteger getBlockCount()` | Return stored value/reference: blockCount. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:41–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L41-L43) |
| `public void setBlockCount(Integer blockCount)` | Replace count with new AtomicInteger(input), set expiry=current epoch+BLOCK_LIFE_TIME_MS; null unboxing fails. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:45–48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L45-L48) |
| `public boolean hasWatch()` | Return stored value/reference: hasWatch. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:50–52](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L50-L52) |
| `public void setHasWatch(boolean hasWatch)` | Assign this.hasWatch = hasWatch. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:54–56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L54-L56) |
| `public boolean isBlock()` | If expired clear count; return permanent boolean OR count>0. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:58–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L58-L63) |
| `public boolean isHasWatch()` | Return stored value/reference: hasWatch. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L65-L67) |
| `public void setBlock(boolean isBlock)` | Assign this.isBlock = isBlock. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:69–71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L69-L71) |
| `public boolean decrementAndCheckUnblock()` | Clear expired count; if count>0 decrement and return exactly zero; otherwise false. Compound test/decrement can race. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java:73–78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessConfig.java#L73-L78) |

## Business
SOURCE_OBSERVED: Indirect admission state: separate permanent boolean OR positive temporary count blocks. Expired positive count is cleared on isBlock/check-unblock. Check-unblock decrements one blocked request and reports final decrement to0, not an independent elapsed timer.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No default-constructor count initialization; calling block methods before setter/populating constructor can NPE. Integer null count unboxing NPE. No catch/log.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L42), [src/com/nozha/async/server/persistance/RateLimitCrud.java:80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L80), [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L33), [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:371](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L371), [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:372](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L372).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java
source_sha256: e4cb233e153cb7554fcca053e8f747c46a3296162bd1cfa8cf0edfada48dd5f4
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessProviderConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.business`. Types: `BusinessProviderConfig` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:7–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L7-L89)
Mutable BusinessProviderConfig blocking state with AtomicInteger count, epoch expiry and ordinary metadata/boolean fields.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Setter replaces atomic count and extends expiry now+BLOCK_LIFE_TIME_MS; parameter constructors initialize expiry to now, so positive initial counts can expire immediately. Fields/check-get-decrement sequences are not jointly atomic.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L8) |
| `blockCount` | `AtomicInteger` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L9) |
| `count` | `int` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L10) |
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L11) |
| `providerPeerId` | `long` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L12) |
| `businessName` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L13) |
| `expireTime` | `long` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L14) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L3); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L5)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L142) ` BusinessProviderConfig requestConfig = JsonUtil.getObject(body, BusinessProviderConfig.class);`; [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L40) ` Map<String, BusinessProviderConfig> loadBusinessProviderConfigs(int serverId);`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L76) ` public static Map<String, BusinessProviderConfig> loadBusinessProviderConfigs(int serverId) {`; [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L35) ` private static Map<String, BusinessProviderConfig> businessProviderConfigMap = new ConcurrentHashMap<>();`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:394](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L394) ` public Map<String, BusinessProviderConfig> loadBusinessProviderConfigs(int serverId) {`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:395](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L395) ` public Map<String, BusinessProviderConfig> loadBusinessProviderConfigs(int serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BusinessProviderConfig()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:16–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L16-L17) |
| `public BusinessProviderConfig(String businessId, long providerPeerId, String provider, Integer blockCount)` | Constructor forwards/stores supplied values: `this.businessId = businessId; this.providerPeerId = providerPeerId; this.provider = provider; this.blockCount = new AtomicInteger(blockCount); this.expireTime = System.currentTimeMillis();`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:19–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L19-L25) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L27-L29) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:31–33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L31-L33) |
| `public AtomicInteger getBlockCount()` | Return stored value/reference: blockCount. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L35-L37) |
| `public void setBlockCount(Integer blockCount)` | Replace count with new AtomicInteger(input), set expiry=current epoch+BLOCK_LIFE_TIME_MS; null unboxing fails. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:39–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L39-L42) |
| `public int getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L44-L46) |
| `public void setCount(int count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:48–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L48-L50) |
| `public boolean isBlock()` | If expired clear count except -1 permanent sentinel; return count==-1 OR count>0. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:52–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L52-L57) |
| `public boolean decrementAndCheckUnblock()` | Clear expired count except -1; if count>0 decrement and return exactly zero; otherwise false. Compound test/decrement can race. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:59–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L59-L64) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:66–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L66-L68) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:70–72](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L70-L72) |
| `public long getProviderPeerId()` | Return stored value/reference: providerPeerId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:74–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L74-L76) |
| `public void setProviderPeerId(long providerPeerId)` | Assign this.providerPeerId = providerPeerId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:78–80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L78-L80) |
| `public String getBusinessName()` | Return stored value/reference: businessName. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:82–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L82-L84) |
| `public void setBusinessName(String businessName)` | Assign this.businessName = businessName. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java:86–88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessProviderConfig.java#L86-L88) |

## Business
SOURCE_OBSERVED: Indirect admission state: -1 count is permanent block; positive count temporary, otherwise allowed. Expired positive count is cleared on isBlock/check-unblock. Check-unblock decrements one blocked request and reports final decrement to0, not an independent elapsed timer.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No default-constructor count initialization; calling block methods before setter/populating constructor can NPE. Integer null count unboxing NPE. No catch/log.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L142), [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L40), [src/com/nozha/async/server/persistance/RateLimitCrud.java:76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L76), [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L35), [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:394](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L394), [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:395](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L395).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId, businessName. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java
source_sha256: ba5c859b821bdb04dc174aff0fc143dcf4ce612ae245077ef54ceb78d1e17347
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessVo — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.business`. Types: `BusinessVo` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:5–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L5-L39)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L6) |
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L7) |
| `count` | `Long` | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L8) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L48) ` ArrayList<BusinessVo> resultList = new ArrayList<>();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public BusinessVo(String provider, String businessId, Long count)` | Constructor forwards/stores supplied values: `this.provider = provider; this.businessId = businessId; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:10–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L10-L14) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:16–18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L16-L18) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:20–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L20-L22) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:24–26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L24-L26) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L28-L30) |
| `public Long getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L32-L34) |
| `public void setCount(Long count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/BusinessVo.java#L36-L38) |

## Business
SOURCE_OBSERVED: Serializable provider/businessId/count summary.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L48).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java
source_sha256: 57273a6ed8aac9791e0bd03ca2372268b5f880af16f6911859a21230fff65fd1
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# GatherBusinessDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.business`. Types: `GatherBusinessDto` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:5–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L5-L30)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `businessId` | `String` | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L7) |
| `count` | `Long` | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L8) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L39) ` ArrayList<GatherBusinessDto> resultList = new ArrayList<>();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public GatherBusinessDto(String businessId, Long count)` | Constructor forwards/stores supplied values: `this.businessId = businessId; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:10–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L10-L13) |
| `public String getBusinessId()` | Return stored value/reference: businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L15-L17) |
| `public void setBusinessId(String businessId)` | Assign this.businessId = businessId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L19-L21) |
| `public Long getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L23-L25) |
| `public void setCount(Long count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/business/GatherBusinessDto.java#L27-L29) |

## Business
SOURCE_OBSERVED: Serializable businessId/count aggregate.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L39).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessId. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java
source_sha256: 34fbc2f380d735d0b07131661b498b568c9049b6a91ecf22151dad4745d5b936
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# GatherIpDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.ip`. Types: `GatherIpDto` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:5–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L5-L30)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `ip` | `String` | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L7) |
| `count` | `Long` | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L8) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L36) ` ArrayList<GatherIpDto> resultList = new ArrayList<>();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public GatherIpDto(String ip, Long count)` | Constructor forwards/stores supplied values: `this.ip = ip; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:10–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L10-L13) |
| `public String getIp()` | Return stored value/reference: ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:15–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L15-L17) |
| `public void setIp(String ip)` | Assign this.ip = ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L19-L21) |
| `public Long getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:23–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L23-L25) |
| `public void setCount(Long count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java:27–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/GatherIpDto.java#L27-L29) |

## Business
SOURCE_OBSERVED: Serializable IP/count aggregate.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L36).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java
source_sha256: bfcd25fdfb2c3361b0b0c180958a8fb2a56ca39501b863f6701140dd00fdf71a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# IPAddressConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.ip`. Types: `IPAddressConfig` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:7–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L7-L67)
Mutable IPAddressConfig blocking state with AtomicInteger count, epoch expiry and ordinary metadata/boolean fields.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Setter replaces atomic count and extends expiry now+BLOCK_LIFE_TIME_MS; parameter constructors initialize expiry to now, so positive initial counts can expire immediately. Fields/check-get-decrement sequences are not jointly atomic.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `ip` | `String` | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L9) |
| `blockCount` | `AtomicInteger` | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L10) |
| `isBlock` | `boolean` | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L11) |
| `count` | `int` | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L12) |
| `expireTime` | `long` | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L13) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L3); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L5)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L125) ` IPAddressConfig requestConfig = JsonUtil.getObject(body, IPAddressConfig.class);`; [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L46) ` Map<String, IPAddressConfig> loadIpAddressConfigs(int serverId);`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L88) ` public static Map<String, IPAddressConfig> loadIpAddressConfigs(int serverId) {`; [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L28) ` private static Map<String, IPAddressConfig> ipAddressConfigMap = new ConcurrentHashMap<>();`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:452](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L452) ` public Map<String, IPAddressConfig> loadIpAddressConfigs(int serverId) {`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:453](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L453) ` public Map<String, IPAddressConfig> loadIpAddressConfigs(int serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public IPAddressConfig()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:15–16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L15-L16) |
| `public IPAddressConfig(String ip, boolean isBlock)` | Constructor forwards/stores supplied values: `this.ip = ip; this.blockCount = new AtomicInteger(0); this.isBlock = isBlock; this.expireTime = System.currentTimeMillis();`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:18–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L18-L23) |
| `public String getIp()` | Return stored value/reference: ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L25-L27) |
| `public void setIp(String ip)` | Assign this.ip = ip. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L29-L31) |
| `public AtomicInteger getBlockCount()` | Return stored value/reference: blockCount. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L33-L35) |
| `public void setBlockCount(Integer blockCount)` | Replace count with new AtomicInteger(input), set expiry=current epoch+BLOCK_LIFE_TIME_MS; null unboxing fails. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:37–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L37-L40) |
| `public boolean isBlock()` | If expired clear count; return permanent boolean OR count>0. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:42–47](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L42-L47) |
| `public void setBlock(boolean block)` | Assign this.isBlock = block. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:49–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L49-L51) |
| `public boolean decrementAndCheckUnblock()` | Clear expired count; if count>0 decrement and return exactly zero; otherwise false. Compound test/decrement can race. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:53–58](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L53-L58) |
| `public int getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:60–62](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L60-L62) |
| `public void setCount(int count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java:64–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/ip/IPAddressConfig.java#L64-L66) |

## Business
SOURCE_OBSERVED: Indirect admission state: separate permanent boolean OR positive temporary count blocks. Expired positive count is cleared on isBlock/check-unblock. Check-unblock decrements one blocked request and reports final decrement to0, not an independent elapsed timer.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No default-constructor count initialization; calling block methods before setter/populating constructor can NPE. Integer null count unboxing NPE. No catch/log.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L125), [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L46), [src/com/nozha/async/server/persistance/RateLimitCrud.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L88), [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L28), [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:452](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L452), [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:453](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L453).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java
source_sha256: ff53c04394a27ba6fb38b5016d396eb599abb401bd26fcb902de81dbecce08e9
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java
business_approved: false
runtime_tested: false
promoted: false
---

# EndpointConfig — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.provider`. Types: `EndpointConfig` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:7–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L7-L95)
Mutable EndpointConfig blocking state with AtomicInteger count, epoch expiry and ordinary metadata/boolean fields.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Setter replaces atomic count and extends expiry now+BLOCK_LIFE_TIME_MS; parameter constructors initialize expiry to now, so positive initial counts can expire immediately. Fields/check-get-decrement sequences are not jointly atomic.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L8) |
| `path` | `String` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L9) |
| `blockCount` | `AtomicInteger` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L10) |
| `hasWatch` | `boolean` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L11) |
| `count` | `int` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L12) |
| `providerPeerId` | `long` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L13) |
| `expireTime` | `long` | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L14) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L3); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L5)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L139) ` EndpointConfig requestConfig = JsonUtil.getObject(body, EndpointConfig.class);`; [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L18) ` Map<String, EndpointConfig> loadEndpointConfigs(int serverId);`; [src/com/nozha/async/server/persistance/RateLimitCrud.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L32) ` public static Map<String, EndpointConfig> loadEndpointConfigs(int serverId) {`; [src/com/nozha/async/server/ratelimit/RateLimitService.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L40) ` private static Map<String, EndpointConfig> endpointConfigMap = new ConcurrentHashMap<>();`; [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L92) ` public Map<String, EndpointConfig> loadEndpointConfigs(int serverId) {`; [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L92) ` public Map<String, EndpointConfig> loadEndpointConfigs(int serverId) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public EndpointConfig()` | Empty body; no validation or side effect. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:16–17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L16-L17) |
| `public EndpointConfig(String provider, String path, Integer blockCount, boolean hasWatch)` | Constructor forwards/stores supplied values: `this.provider = provider; this.path = path; this.blockCount = new AtomicInteger(blockCount); this.hasWatch = hasWatch; this.expireTime = System.currentTimeMillis();`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:19–25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L19-L25) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:28–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L28-L30) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:32–34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L32-L34) |
| `public String getPath()` | Return stored value/reference: path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:36–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L36-L38) |
| `public void setPath(String path)` | Assign this.path = path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:40–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L40-L42) |
| `public AtomicInteger getBlockCount()` | Return stored value/reference: blockCount. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:44–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L44-L46) |
| `public void setBlockCount(Integer blockCount)` | Replace count with new AtomicInteger(input), set expiry=current epoch+BLOCK_LIFE_TIME_MS; null unboxing fails. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:48–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L48-L51) |
| `public boolean hasWatch()` | Return stored value/reference: hasWatch. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L53-L55) |
| `public void setHasWatch(boolean hasWatch)` | Assign this.hasWatch = hasWatch. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L57-L59) |
| `public int getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:61–63](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L61-L63) |
| `public void setCount(int count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L65-L67) |
| `public boolean isBlock()` | If expired clear count except -1 permanent sentinel; return count==-1 OR count>0. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:69–74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L69-L74) |
| `public void checkPath()` | If path lacks trailing slash append it; null path NPE. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:76–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L76-L79) |
| `public boolean decrementAndCheckUnblock()` | Clear expired count except -1; if count>0 decrement and return exactly zero; otherwise false. Compound test/decrement can race. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:81–86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L81-L86) |
| `public long getProviderPeerId()` | Return stored value/reference: providerPeerId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:88–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L88-L90) |
| `public void setProviderPeerId(long providerPeerId)` | Assign this.providerPeerId = providerPeerId. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java:92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/EndpointConfig.java#L92-L94) |

## Business
SOURCE_OBSERVED: Indirect admission state: -1 count is permanent block; positive count temporary, otherwise allowed. Expired positive count is cleared on isBlock/check-unblock. Check-unblock decrements one blocked request and reports final decrement to0, not an independent elapsed timer.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No default-constructor count initialization; calling block methods before setter/populating constructor can NPE. Integer null count unboxing NPE. No catch/log.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:139](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L139), [src/com/nozha/async/server/persistance/RateLimitCrudInterface.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrudInterface.java#L18), [src/com/nozha/async/server/persistance/RateLimitCrud.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L32), [src/com/nozha/async/server/ratelimit/RateLimitService.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L40), [src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/MySQLRateLimitCrud.java#L92), [src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L92).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.md -->

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
source_path: src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java
source_sha256: 9141a60a78919fb34da0604df3feace1d1463eaaaafbbad58611de4255e4cc6a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java
business_approved: false
runtime_tested: false
promoted: false
---

# GatherDto — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.vo.rateLimit.provider`. Types: `GatherDto` (class_declaration) [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:5–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L5-L40)
Mutable data/type carrier; full field and per-method contract below.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
No explicit synchronization or defensive copying; arrays/lists/objects returned as stored references.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `provider` | `String` | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L7) |
| `path` | `String` | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L8) |
| `count` | `Long` | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L9) |
Dependencies are imports (some may be unused): `java.io.Serializable` [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L43) ` ArrayList<GatherDto> resultList = new ArrayList<>();`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public GatherDto(String provider, String path, Long count)` | Constructor forwards/stores supplied values: `this.provider = provider; this.path = path; this.count = count;`. References retained; no validation. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:11–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L11-L15) |
| `public String getProvider()` | Return stored value/reference: provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L17-L19) |
| `public void setProvider(String provider)` | Assign this.provider = provider. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L21-L23) |
| `public String getPath()` | Return stored value/reference: path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:25–27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L25-L27) |
| `public void setPath(String path)` | Assign this.path = path. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:29–31](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L29-L31) |
| `public Long getCount()` | Return stored value/reference: count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:33–35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L33-L35) |
| `public void setCount(Long count)` | Assign this.count = count. No validation or copying. | [src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java:37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/rateLimit/provider/GatherDto.java#L37-L39) |

## Business
SOURCE_OBSERVED: Serializable provider/path/count aggregate.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; assignments/getters do not validate or normalize input. Callers own rejection, serialization and failure mapping.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L43).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../../../../../../../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../../../../../../../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../../../../../../../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.


---

<!-- source dossier: src/io/moquette/broker/Server.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L1-L434
evidence_refs:
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# Server — source review

## Technical

Package: `NONE (comment-only compilation unit)`. Ownership: candidate bundled Moquette vendor file, disabled. Compilation status: **COMMENT_ONLY; no executable class declaration**. Full compilation unit reviewed: 434 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Moquette vendor license and entire package/class implementation disabled by comments ([15–434](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L15-L434)). Historical main startup/shutdown hook; startServer overloads ([73–147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L73-L147)) files/properties/IConfig delegate full startup ([149–206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L149-L206)), scheduler/interceptors/SSL/auth, H2 vs memory repos, session/postoffice/acceptor then initialized. Authorization ([208–232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L208-L232)) plugin→ACL(default deny on parse failure)→permit-all; authentication ([234–253](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L234-L253)) plugin→password file→accept-all. initInterceptors reads configured class; loadClass ([270–305](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L270-L305)) argument constructor then default fallback. internalPublish ([317–326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L317-L326)) guards initialized; stop ([328–344](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L328-L344)) closes acceptor/scheduler/H2. Port/accessor and interceptor add/remove guarded; listConnectedClients/session close/subscriptions ([409–432](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/io/moquette/broker/Server.java#L409-L432)) query historical SessionRegistry.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- No live method declaration; disabled historical text or record/interface declarations are described above.

Source dependency imports: none live.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- [src/com/nozha/async/server/Server.java:54](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L54): `public class Server {`
- [src/com/nozha/async/server/Server.java:55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L55): `private static final Logger logger = LoggerFactory.getLogger(Server.class);`
- [src/com/nozha/async/server/Server.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L71): `private static Server instance;`
- [src/com/nozha/async/server/Server.java:86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L86): `private Server() {`
- [src/com/nozha/async/server/Server.java:222](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L222): `public synchronized static Server getInstance() {`
- [src/com/nozha/async/server/Server.java:224](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L224): `instance = new Server();`
- [src/com/nozha/async/server/Server.java:500](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L500): `client.sendMessage(new ClientMessagePayload(new ClientMessage(0, 0, null, 0, MessageType.ERROR_MESSAGE, JsonUtil.getJson(Server.DESTROY_STATUS_REMOVED_MESSAGING_REJECTED)), 0,0));`
- [src/com/nozha/async/server/Server.java:1355](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1355): `Server.getInstance().initialize();`
- [src/com/nozha/async/server/Server.java:1358](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1358): `for (HandlerInterface handler : Server.getInstance().handlers) {`
- [src/com/nozha/async/server/Server.java:1367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1367): `Server.getInstance().httpServer.shutdown();`
- [src/com/nozha/async/server/Server.java:1375](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L1375): `exitSystem(Server.getInstance().handlers);`
- [src/com/nozha/async/server/handler/MqttHandler.java:152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L152): `removeClientFromServer(mqttClient, Server.DESTROY_STATUS_PEER_REGISTERING);`
- [src/com/nozha/async/server/handler/MqttHandler.java:220](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L220): `Server.getInstance().read(mqttClient, messageWrapperVO);`
- [src/com/nozha/async/server/handler/MqttHandler.java:232](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L232): `Server.getInstance().read(mqttClient, new String(bytes, StandardCharsets.UTF_8));`
- [src/com/nozha/async/server/handler/MqttHandler.java:261](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L261): `removeClientFromServer(mqttClient, Server.DESTROY_STATUS_CLOSED);`
- [src/com/nozha/async/server/handler/MqttHandler.java:269](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/MqttHandler.java#L269): `Server.getInstance().removeClient(relatedClient, code);`
- 103 additional lexical type-use references exist; the listed sample establishes integration boundaries, not exhaustive dynamic callers.

## Business

SOURCE_OBSERVED: Bundled inactive vendor broker integration dependency, not Async-owned business logic; current broker path is EmbeddedArtemisServer. Historical H2/memory behavior is not production retention proof.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

No executable direct error path; historical IllegalStateException for unstarted publish/add/remove, reflective failures return null, ACL ParseException caught deny policy, startup IO declared. Documented only as disabled source.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- No direct executable explicit throw/catch/status/timeout in class. Caller/dependency propagated and implicit failures are addressed above.

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

NO_LOG_IN_CLASS (executable); all listed registry sites are commented. Console startup/subscription prints disabled too.

**NO_LOG_IN_CLASS** (live logger calls). Console diagnostics, if any, are separate below. Caller/type-use references above identify the evidenced outer boundaries; absence of a class log cannot prove absence of failures.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|

Registry reconciliation: 0 rows for this file; 0 live level logger expressions; 0 typed external logger expressions. No unmatched registry rows at this file path. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.md -->

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
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1-L1053
evidence_refs:
  - https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java
  - kb/generated-knowledge/observability/registry-v1/all-log-point-cards.csv
business_approval: UNKNOWN
runtime_validation: NOT_EXECUTED
promotion: NOT_PROMOTED
---

# NettyAcceptor — source review

## Technical

Package: `org.apache.activemq.artemis.core.remoting.impl.netty`. Ownership: candidate bundled/customized Apache dependency (license header; Async MqttHandler callbacks). Compilation status: **active source declaration**. Full compilation unit reviewed: 1053 lines, including nested classes/comments. All behavioral claims below are SOURCE_OBSERVED at the pinned source; no runtime test or deployed version proof is asserted.

Apache Artemis vendor class customized with MqttHandler import/callbacks (43,[963–977](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L963-L977)). Static block ([115–122](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L115-L122)) disables Netty leak detection unless system properties set and logs loaded. Constructor ([247–382](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L247-L382)) configures TLS provider/stores/password codecs/CRL/ciphers/protocols/auth/hostname/SNI, native/inVM channel choice, threads, TCP buffers/backlog/watermarks, batching/direct delivery/httpUpgrade/connection cap/autostart/redirect. loadSSLContext ([384–400](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L384-L400)) checks config and selects OpenSSL/JDK factory. start ([407–548](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L407-L548)) synchronized/idempotent via channelClazz, chooses inVM/epoll/kqueue/NIO (threads CPU*3 default), bootstrap channel initializer SSL/SNI/handshake handler then protocol decoder, peer address fallback, socket options/groups, binds unless HTTP upgrade, notification/started logger and batch scheduler. test accessors/mutators expose live config/connections and keystore. transfer ([582–587](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L582-L587)) guard unavailable then decoder. reload ([590–604](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L590-L604)) disconnect/clear bound channels, reload TLS/rebind. getSslHandler ([606–678](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L606-L678)) server engine, required/wanted client auth, configured suites/protocols, strips SSLv3, host HTTPS verification/SNI matcher. Engine helpers select context with peer if valid; checkSSLConfiguration guards missing key path. startServerChannels ([709–726](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L709-L726)) split hosts, bind and wrap bundle failure. stop ([734–740](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L734-L740)) waits indefinite latch; asyncStop ([743–808](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L743-L808)) synchronized closes decoder/flusher/channel groups, logs partial closes, destroys/clears connections, stop notification, graceful event loop quiet/shutdown timeout callback. pause ([816–838](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L816-L838)) closes acceptors only. Security principal setter rejects; isUnsecurable false; createConnectionCreator builds channel handler. Nested createConnection ([910–942](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L910-L942)) connection count gate, lifecycle creation before TLS completion, handshake active flag/close; over limit close/null. Listener ([948–989](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L948-L989)) putIfAbsent duplicate reject, forwards created/destroyed/errors/ready; destroyed/exception unconditionally invokes MQTT closure for every protocol; exception forwards on new thread. BatchFlusher synchronized run/cancel iterates connection flush. Handshake handler ([1027–1038](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1027-L1038)) only logs matching message prefix, swallows other errors. getRootCause ([1041–1048](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1041-L1048)) cycle list traversal returns null for single-node throwable, otherwise deepest/cycle last; isAutoStart getter.

Significant method/lifecycle navigation (accessors are grouped in the behavior text):

- [247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L247): `public NettyAcceptor(final String name,`
- [384](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L384): `private Object loadSSLContext() {`
- [402](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L402): `public int getTcpReceiveBufferSize() {`
- [407](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L407): `public synchronized void start() throws Exception {`
- [430](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L430): `public ActiveMQThreadFactory run() {`
- [441](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L441): `public ActiveMQThreadFactory run() {`
- [452](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L452): `public ActiveMQThreadFactory run() {`
- [467](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L467): `public void initChannel(Channel channel) throws Exception {`
- [551](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L551): `public String getName() {`
- [562](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L562): `public ProtocolHandler getProtocolHandler() {`
- [567](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L567): `public void setKeyStorePath(String keyStorePath) {`
- [582](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L582): `public void transfer(Channel channel) {`
- [590](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L590): `public void reload() {`
- [606](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L606): `public SslHandler getSslHandler(ByteBufAllocator alloc, String peerHost, int peerPort) throws Exception {`
- [680](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L680): `private SSLEngine loadJdkSslEngine(String peerHost, int peerPort) throws Exception {`
- [690](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L690): `private void checkSSLConfiguration() throws IllegalArgumentException {`
- [699](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L699): `private SSLEngine loadOpenSslEngine(ByteBufAllocator alloc, String peerHost, int peerPort) throws Exception {`
- [709](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L709): `private void startServerChannels() {`
- [734](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L734): `public void stop() throws Exception {`
- [743](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L743): `public synchronized void asyncStop(Runnable callback) {`
- [811](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L811): `public boolean isStarted() {`
- [816](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L816): `public synchronized void pause() {`
- [841](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L841): `public void setNotificationService(final NotificationService notificationService) {`
- [851](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L851): `public void setDefaultActiveMQPrincipal(ActiveMQPrincipal defaultActiveMQPrincipal) {`
- [861](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L861): `public boolean isUnsecurable() {`
- [866](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L866): `public ClusterConnection getClusterConnection() {`
- [870](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L870): `public ConnectionCreator createConnectionCreator() {`
- [874](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L874): `public int getQuietPeriod() {`
- [878](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L878): `public NettyAcceptor setQuietPeriod(int quietPeriod) {`
- [883](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L883): `public int getShutdownTimeout() {`
- [887](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L887): `public NettyAcceptor setShutdownTimeout(int shutdownTimeout) {`
- [892](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L892): `private static String getProtocols(final Map<String, ProtocolManager> protocolManagers) {`
- [910](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L910): `public NettyServerConnection createConnection(final ChannelHandlerContext ctx,`
- [925](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L925): `public void operationComplete(final io.netty.util.concurrent.Future<Channel> future) throws Exception {`
- [948](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L948): `public void connectionCreated(final ActiveMQComponent component,`
- [959](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L959): `public void connectionDestroyed(final Object connectionID) {`
- [968](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L968): `public void connectionException(final Object connectionID, final ActiveMQException me) {`
- [972](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L972): `public void run() {`
- [981](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L981): `public void connectionReadyForWrites(final Object connectionID, boolean ready) {`
- [997](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L997): `public synchronized void run() {`
- [1005](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1005): `public synchronized void cancel() {`
- [1017](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1017): `public void handlerAdded(ChannelHandlerContext ctx) throws Exception {`
- [1022](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1022): `public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {`
- [1027](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1027): `public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {`
- [1041](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1041): `private Throwable getRootCause(Throwable throwable) {`
- [1050](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1050): `public boolean isAutoStart() {`

Source dependency imports: `javax.net.ssl.SNIHostName`, `javax.net.ssl.SSLContext`, `javax.net.ssl.SSLEngine`, `javax.net.ssl.SSLHandshakeException`, `javax.net.ssl.SSLParameters`, `java.net.InetSocketAddress`, `java.net.SocketAddress`, `java.security.AccessController`, `java.security.PrivilegedAction`, `java.util.ArrayList`, `java.util.Arrays`, `java.util.HashSet`, `java.util.List`, `java.util.Map`, `java.util.Set`, `java.util.concurrent.ConcurrentHashMap`, `java.util.concurrent.ConcurrentMap`, `java.util.concurrent.CountDownLatch`, `java.util.concurrent.Executor`, `java.util.concurrent.ScheduledExecutorService`, `java.util.concurrent.ScheduledFuture`, `java.util.concurrent.TimeUnit`, `java.util.concurrent.atomic.AtomicBoolean`, `com.nozha.async.server.handler.MqttHandler`, `io.netty.bootstrap.ServerBootstrap`, `io.netty.buffer.ByteBufAllocator`, `io.netty.channel.Channel`, `io.netty.channel.ChannelHandler`, `io.netty.channel.ChannelHandlerContext`, `io.netty.channel.ChannelInitializer`, `io.netty.channel.ChannelOption`, `io.netty.channel.ChannelPipeline`, `io.netty.channel.DefaultEventLoopGroup`, `io.netty.channel.EventLoopGroup`, `io.netty.channel.ServerChannel`, `io.netty.channel.WriteBufferWaterMark`, `io.netty.channel.epoll.EpollEventLoopGroup`, `io.netty.channel.epoll.EpollServerSocketChannel`, `io.netty.channel.group.ChannelGroup`, `io.netty.channel.group.ChannelGroupFuture`, `io.netty.channel.group.DefaultChannelGroup`, `io.netty.channel.kqueue.KQueueEventLoopGroup`, `io.netty.channel.kqueue.KQueueServerSocketChannel`, `io.netty.channel.local.LocalAddress`, `io.netty.channel.local.LocalServerChannel`, `io.netty.channel.nio.NioEventLoopGroup`, `io.netty.channel.socket.nio.NioServerSocketChannel`, `io.netty.handler.ssl.SslContext`, `io.netty.handler.ssl.SslHandler`, `io.netty.util.ResourceLeakDetector`, `io.netty.util.concurrent.GenericFutureListener`, `io.netty.util.concurrent.GlobalEventExecutor`, `org.apache.activemq.artemis.api.config.ActiveMQDefaultConfiguration`, `org.apache.activemq.artemis.api.core.ActiveMQException`, `org.apache.activemq.artemis.api.core.Pair`, `org.apache.activemq.artemis.api.core.SimpleString`, `org.apache.activemq.artemis.api.core.TransportConfiguration`, `org.apache.activemq.artemis.api.core.management.CoreNotificationType`, `org.apache.activemq.artemis.core.client.impl.ClientSessionFactoryImpl`, `org.apache.activemq.artemis.core.protocol.ProtocolHandler`, `org.apache.activemq.artemis.core.remoting.impl.AbstractAcceptor`, `org.apache.activemq.artemis.core.remoting.impl.ssl.SSLSupport`, `org.apache.activemq.artemis.core.security.ActiveMQPrincipal`, `org.apache.activemq.artemis.core.server.ActiveMQComponent`, `org.apache.activemq.artemis.core.server.ActiveMQMessageBundle`, `org.apache.activemq.artemis.core.server.ActiveMQServerLogger`, `org.apache.activemq.artemis.core.server.cluster.ClusterConnection`, `org.apache.activemq.artemis.core.server.management.Notification`, `org.apache.activemq.artemis.core.server.management.NotificationService`, `org.apache.activemq.artemis.spi.core.protocol.ProtocolManager`, `org.apache.activemq.artemis.spi.core.remoting.BufferHandler`, `org.apache.activemq.artemis.spi.core.remoting.Connection`, `org.apache.activemq.artemis.spi.core.remoting.ServerConnectionLifeCycleListener`, `org.apache.activemq.artemis.spi.core.remoting.ssl.OpenSSLContextFactory`, `org.apache.activemq.artemis.spi.core.remoting.ssl.OpenSSLContextFactoryProvider`, `org.apache.activemq.artemis.spi.core.remoting.ssl.SSLContextConfig`, `org.apache.activemq.artemis.spi.core.remoting.ssl.SSLContextFactoryProvider`, `org.apache.activemq.artemis.utils.ActiveMQThreadFactory`, `org.apache.activemq.artemis.utils.ConfigurationHelper`, `org.apache.activemq.artemis.utils.collections.TypedProperties`, `org.jboss.logging.Logger`.
Configuration references: no direct Settings references; dependencies may configure behavior. Current deployed values UNKNOWN.

Evidenced caller/type-use sites (source lexical references; exact runtime call graph, reflective usages and production enablement are not proven):

- No live lexical external reference found in supplied Java files.

Supplemental semantic review of explicit member and nested-type boundaries:

- **ActiveMQServerChannelHandler nested class / constructor** [900–907](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L900-L907): The private final nested class extends ActiveMQChannelHandler and implements ConnectionCreator. Constructor forwards channel group, buffer handler, lifecycle listener and failure executor to the superclass without extra validation or state mutation. createConnection (reviewed above) adds connection-limit and TLS activation behavior.
- **getConfiguration** [729–731](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L729-L731): Returns the original mutable configuration map directly, not a copy. Later external map mutation is not guaranteed to rebuild the final constructor-captured settings or existing SSL context.
- **getConnections** [557–559](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L557-L559): Returns the live ConcurrentHashMap as Map<Object,NettyServerConnection>; intended testing exposure lets caller inspect/mutate connection tracking and does not represent a stable connection count snapshot.
- **start anonymous ChannelInitializer.getPeerInfo** [488–497](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L488-L497): Parses channel.remoteAddress string by removing slashes and splitting colon, then integer port; any exception emits DEBUG and returns Pair(null,0), so engine helpers use a no-peer SSL engine. IPv6 colon syntax may enter this fallback; no input parser recovery beyond null/zero occurs.

## Business

SOURCE_OBSERVED: Broker network dependency with Async customization coupling connection destruction to MQTT client maps; supports multi-protocol acceptors but MQTT callback not conditioned on protocol. Binding/TLS/connections cap are infrastructure controls, not business delivery contract.

APPROVED_INTENT: **UNKNOWN**. Source review does not count as business approval. INFERENCE: the indirect role follows the concrete call/dependency boundary above; no independent provider business rules are assigned to DTOs/helpers/vendor classes. UNKNOWN: official interface support/deprecation, production feature settings, owning team, retention/idempotency/delivery SLA, and stakeholder acceptance. Request→handler/client→Server or external dependency→response consequences are described in Technical and Errors.

Reconciliation: `generated-knowledge/contracts/interface-inventory.md`, `flows/startup-flow.md`, `flows/message-delivery-flow.md` and architecture/security candidates provide family-level scaffolding at older/different provenance. This dossier pins concrete implementation branches; it retains their unknown official-contract/ACK/retry/SLA boundary. Comment-only chat/Moquette files cannot establish runnable transport support. Protocol send return, JMS broker ACK, Async message ACK and provider business completion remain different events. No promotion or correction of generated documents is performed here.

## Errors

Explicit missing-keystore IllegalArgumentException, SSL creation IllegalStateException wrapping, unavailable/failedBind/duplicateConnection broker bundle exceptions (external messages unknown), unsecure connections IllegalStateException. Configured cipher/protocol IllegalArgumentException logs and rethrows. TLS handler init catch logs root then rethrows but rootCause may be null due helper bug, masking error. reload await suppresses Exception; notification stop error logged; stop await interruption propagates. TLS handshake failure future.getNow may be null; handler consumes nonmatching exceptions. No controlled bound/start rollback after channelClazz set. Test ordinary no-cause Throwable in getRootCause, invalid TLS, connection cap and non-MQTT destroyed callbacks.

Exact explicit throw/catch/status/timeout evidence (live source; quoted expressions are evidence, not a claim that the failure happened):

- [392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L392): `throw new IllegalStateException("No OpenSSLContextFactory registered!");`
- [396](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L396): `} catch (Exception e) {`
- [398](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L398): `throw ise;`
- [475](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L475): `} catch (Exception e) {`
- [482](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L482): `throw e;`
- [492](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L492): `} catch (Exception e) {`
- [584](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L584): `throw ActiveMQMessageBundle.BUNDLE.acceptorUnavailable();`
- [594](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L594): `} catch (Exception ignored) {`
- [630](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L630): `} catch (IllegalArgumentException e) {`
- [632](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L632): `throw e;`
- [639](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L639): `} catch (IllegalArgumentException e) {`
- [641](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L641): `throw e;`
- [695](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L695): `throw new IllegalArgumentException("If \"" + TransportConstants.SSL_ENABLED_PROP_NAME + "\" is true then \"" + TransportConstants.KEYSTORE_PATH_PROP_NAME + "\" must be non-null unless an alternative \"" + TransportConstants.KEYSTORE_PROVIDER_PROP_NAME + "\" has been specified.");`
- [721](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L721): `} catch (Exception e) {`
- [722](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L722): `throw ActiveMQMessageBundle.BUNDLE.failedToBind(getName(), h + ":" + port, e);`
- [739](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L739): `latch.await();`
- [797](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L797): `} catch (Exception e) {`
- [852](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L852): `throw new IllegalStateException("unsecure connections not allowed");`
- [952](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L952): `throw ActiveMQMessageBundle.BUNDLE.connectionExists(connection.getID());`

Diagnosis/reproduction boundary: exercise the named branch with controlled payload/configuration and capture original exception plus return/response status, map/session state and subsequent receiver behavior. Tests are proposed only; no broker, network, database, GStreamer, or servlet integration was executed for this dossier. Explicit catch suppression does not establish data recovery; retries and mapping are limited to the source branches above.

## Logs and RCA

Includes JBoss logger and typed ActiveMQServerLogger methods; the 12 native method severity/message identifiers are resolved below from official Artemis 2.19.1 annotation source, while effective runtime classpath remains UNKNOWN. MQTT Destroyed/Exception ERROR is emitted even normal closure; loaded INFO proves customized class loading only.

Every live owned logger call site (source expression preserves template/object and field order). Exact-line registry join is per pinned source; trigger comes from reviewed method/branch above and source context, not the older registry heuristic.

| Source | Registry ID | Level | Template / object and expressions | Branch context |
|---|---|---|---|---|
| [121](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L121) | ALOG-5BB24B56B2B9 | INFO | `logger.info("***************** POD NettyAcceptor loaded ******************");` | `if (System.getProperty("io.netty.leakDetectionLevel") == null && System.getProperty("io.netty.leakDetection.level") == null) { / ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.DISABLED); / }` |
| [436](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L436) | ALOG-CDF5B505B4C9 | DEBUG | `logger.debug("Acceptor using native epoll");` | `} / })); / acceptorType = EPOLL_ACCEPTOR_TYPE;` |
| [447](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L447) | ALOG-CBA1EE41B13C | DEBUG | `logger.debug("Acceptor using native kqueue");` | `} / })); / acceptorType = KQUEUE_ACCEPTOR_TYPE;` |
| [457](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L457) | ALOG-A71D641C7B63 | DEBUG | `logger.debug("Acceptor using nio");` | `return new ActiveMQThreadFactory("activemq-netty-threads", true, ClientSessionFactoryImpl.class.getClassLoader()); / } / })); / acceptorType = NIO_ACCEPTOR_TYPE;` |
| [480](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L480) | ALOG-44A8DF034FE7 | DEBUG | `ActiveMQServerLogger.LOGGER.debug("Getting SSL handler failed", e);` | `Throwable rootCause = getRootCause(e); / ActiveMQServerLogger.LOGGER.gettingSslHandlerFailed(channel.remoteAddress().toString(), rootCause.getClass().getName() + ": " + rootCause.getMessage()); / if (ActiveMQServerLogger.LOGGER.isDebugEnabled()) {` |
| [493](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L493) | ALOG-FCB27495020D | DEBUG | `logger.debug("Failed to parse peer info for SSL engine initialization", e);` | `try { / String[] peerInfo = channel.remoteAddress().toString().replace("/", "").split(":"); / return new Pair<>(peerInfo[0], Integer.parseInt(peerInfo[1])); / } catch (Exception e) {` |
| [963](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L963) | ALOG-14CE47E8F5A7 | ERROR | `logger.error("Mqtt Destroyed is calling with connectionid =" + connectionID );` | `public void connectionDestroyed(final Object connectionID) { / if (connections.remove(connectionID) != null) { / listener.connectionDestroyed(connectionID); / }` |
| [976](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L976) | ALOG-13E013136878 | ERROR | `logger.error("Mqtt Exception is calling with connectionid =" + connectionID );` | `public void run() { / listener.connectionException(connectionID, me); / } / }.start();` |
| [1035](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1035) | ALOG-26B5F9D1CB18 | DEBUG | `ActiveMQServerLogger.LOGGER.debug("SSL handshake failed", cause);` | `ActiveMQServerLogger.LOGGER.sslHandshakeFailed(ctx.channel().remoteAddress().toString(), errorMessage); / if (ActiveMQServerLogger.LOGGER.isDebugEnabled()) {` |
| [477](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L477) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.gettingSslHandlerFailed(channel.remoteAddress().toString(), rootCause.getClass().getName() + ": " + rootCause.getMessage());` | `pipeline.addLast("ssl", getSslHandler(channel.alloc(), peerInfo.getA(), peerInfo.getB())); / pipeline.addLast("sslHandshakeExceptionHandler", new SslHandshakeExceptionHandler()); / } catch (Exception e) { / Throwable rootCause = getRootCause(e);` |
| [480](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L480) | ALOG-44A8DF034FE7 | DEBUG | `ActiveMQServerLogger.LOGGER.debug("Getting SSL handler failed", e);` | `Throwable rootCause = getRootCause(e); / ActiveMQServerLogger.LOGGER.gettingSslHandlerFailed(channel.remoteAddress().toString(), rootCause.getClass().getName() + ": " + rootCause.getMessage()); / if (ActiveMQServerLogger.LOGGER.isDebugEnabled()) {` |
| [540](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L540) | **MISSING_FROM_REGISTRY** | INFO | `ActiveMQServerLogger.LOGGER.startedAcceptor(acceptorType, host, port, protocolsString);` | `Notification notification = new Notification(null, CoreNotificationType.ACCEPTOR_STARTED, props); / notificationService.sendNotification(notification); / }` |
| [631](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L631) | **MISSING_FROM_REGISTRY** | ERROR | `ActiveMQServerLogger.LOGGER.invalidCipherSuite(SSLSupport.parseArrayIntoCommandSeparatedList(engine.getSupportedCipherSuites()));` | `if (enabledCipherSuites != null) { / try { / engine.setEnabledCipherSuites(SSLSupport.parseCommaSeparatedListIntoArray(enabledCipherSuites)); / } catch (IllegalArgumentException e) {` |
| [640](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L640) | **MISSING_FROM_REGISTRY** | ERROR | `ActiveMQServerLogger.LOGGER.invalidProtocol(SSLSupport.parseArrayIntoCommandSeparatedList(engine.getSupportedProtocols()));` | `if (enabledProtocols != null) { / try { / engine.setEnabledProtocols(SSLSupport.parseCommaSeparatedListIntoArray(enabledProtocols)); / } catch (IllegalArgumentException e) {` |
| [654](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L654) | **MISSING_FROM_REGISTRY** | INFO | `ActiveMQServerLogger.LOGGER.disallowedProtocol(s, name);` | `Set<String> set = new HashSet<>(); / for (String s : protocols) { / if (s.equalsIgnoreCase("SSLv3")/* \|\| s.equals("SSLv2Hello")*/) { / if (!warningPrinted.get()) {` |
| [772](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L772) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.nettyChannelGroupError();` | `if (channelGroup != null) { / ChannelGroupFuture future = channelGroup.close().awaitUninterruptibly(); / if (!future.isSuccess()) {` |
| [775](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L775) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.nettyChannelStillOpen(channel, channel.remoteAddress());` | `if (!future.isSuccess()) { / ActiveMQServerLogger.LOGGER.nettyChannelGroupError(); / for (Channel channel : future.group()) { / if (channel.isActive()) {` |
| [798](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L798) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.failedToSendNotification(e);` | `Notification notification = new Notification(null, CoreNotificationType.ACCEPTOR_STOPPED, props); / try { / notificationService.sendNotification(notification); / } catch (Exception e) {` |
| [829](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L829) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.nettyChannelGroupBindError();` | `// We *pause* the acceptor so no new connections are made / if (serverChannelGroup != null) { / ChannelGroupFuture future = serverChannelGroup.close().awaitUninterruptibly(); / if (!future.isSuccess()) {` |
| [832](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L832) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.nettyChannelStillBound(channel, channel.remoteAddress());` | `if (!future.isSuccess()) { / ActiveMQServerLogger.LOGGER.nettyChannelGroupBindError(); / for (Channel channel : future.group()) { / if (channel.isActive()) {` |
| [938](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L938) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.connectionLimitReached(connectionsAllowed, ctx.channel().remoteAddress().toString());` | `active = true; / } / return nc; / } else {` |
| [1032](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1032) | **MISSING_FROM_REGISTRY** | WARN | `ActiveMQServerLogger.LOGGER.sslHandshakeFailed(ctx.channel().remoteAddress().toString(), errorMessage);` | `if (cause.getMessage() != null && cause.getMessage().startsWith(SSLHandshakeException.class.getName())) { / Throwable rootCause = getRootCause(cause); / String errorMessage = rootCause.getClass().getName() + ": " + rootCause.getMessage();` |
| [1035](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1035) | ALOG-26B5F9D1CB18 | DEBUG | `ActiveMQServerLogger.LOGGER.debug("SSL handshake failed", cause);` | `ActiveMQServerLogger.LOGGER.sslHandshakeFailed(ctx.channel().remoteAddress().toString(), errorMessage); / if (ActiveMQServerLogger.LOGGER.isDebugEnabled()) {` |

Registry reconciliation: 9 rows for this file; 9 live level logger expressions; 14 typed external logger expressions. No unmatched registry rows at this file path. Missing current-expression registry line(s): 477, 540, 631, 640, 654, 772, 775, 798, 829, 832, 938, 1032. Registry trigger/route/runtime fields remain candidates; this source review does not establish historical occurrence.

Appender source evidence: `resources/log4j2.xml` defines AsyncRoot INFO→DG2 `${env:LOG_FILE_PATH}/async.log`; JSONLOG→async_json.log, HTTPLOG→async_http.log, PODLOG→pod_monitoring.log, SCLOG→sc.log, SCJSONLOG→sc_json.log. ADDRESSLOG references an undefined appender in that file. Actual SLF4J/JBoss binding, effective level and runtime deployment overrides UNKNOWN; the registry ROOT route assumption is not runtime verification. Named JSON object logs retain fields shown in source expressions; class-specific correlation and privacy caveats appear above.

Official dependency annotation reconciliation: the supplied [pom.xml:82–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/pom.xml#L82-L95) pins Artemis server/JMS/MQTT 2.19.1. The corresponding primary `ActiveMQServerLogger` declarations use `@LogMessage` and `@Message`; the table records their exact identifier and severity, with paraphrased meaning to avoid reproducing the external templates. `@Message` formatting is MESSAGE_FORMAT, and `@Cause` supplies the exception only on failedToSendNotification. The 12 native points were absent from the original registry and are additions, not replacements. Runtime dependency/classpath parity and effective logger levels/routes remain UNKNOWN.

| Local call | Method | Annotated level | Message ID | Fields and trigger meaning | Primary declaration |
|---|---|---|---|---|---|
| [477](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L477) | gettingSslHandlerFailed | WARN | 222300 | client address and deepest cause description; SSL handler construction failed | [Artemis 2.19.1:1744–1747](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L1744-L1747) |
| [540](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L540) | startedAcceptor | INFO | 221020 | acceptor type, host, port and protocol names; start bound network channels | [Artemis 2.19.1:178–180](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L178-L180) |
| [631](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L631) | invalidCipherSuite | ERROR | 224059 | supported cipher names; requested cipher configuration rejected | [Artemis 2.19.1:1997–1999](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L1997-L1999) |
| [640](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L640) | invalidProtocol | ERROR | 224060 | supported protocol names; requested protocol configuration rejected | [Artemis 2.19.1:2001–2003](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L2001-L2003) |
| [654](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L654) | disallowedProtocol | INFO | 221053 | protocol and acceptor name; SSLv3 removed from enabled protocols | [Artemis 2.19.1:323–327](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L323-L327) |
| [772](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L772) | nettyChannelGroupError | WARN | 212074 | no fields; accepted channel group close incomplete | [Artemis 2.19.1:752–754](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L752-L754) |
| [775](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L775) | nettyChannelStillOpen | WARN | 222075 | channel and remote address; active channel remains after close | [Artemis 2.19.1:756–758](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L756-L758) |
| [798](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L798) | failedToSendNotification | WARN | 222230 | Exception annotated Cause; acceptor-stop notification failed | [Artemis 2.19.1:1455–1457](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L1455-L1457) |
| [829](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L829) | nettyChannelGroupBindError | WARN | 222076 | no fields; bound server channel group close incomplete | [Artemis 2.19.1:760–762](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L760-L762) |
| [832](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L832) | nettyChannelStillBound | WARN | 222077 | channel and remote address; channel remains active during pause | [Artemis 2.19.1:764–766](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L764-L766) |
| [938](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L938) | connectionLimitReached | WARN | 222206 | configured connection limit and remote address; new connection rejected | [Artemis 2.19.1:1347–1349](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L1347-L1349) |
| [1032](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/apache/activemq/artemis/core/remoting/impl/netty/NettyAcceptor.java#L1032) | sslHandshakeFailed | WARN | 222208 | client address and cause description; matching TLS handshake error observed | [Artemis 2.19.1:1356–1359](https://github.com/apache/activemq-artemis/blob/2.19.1/artemis-server/src/main/java/org/apache/activemq/artemis/core/server/ActiveMQServerLogger.java#L1356-L1359) |

The two `ActiveMQServerLogger.LOGGER.debug` calls at local480/1035 are explicitly DEBUG in this class, guarded by isDebugEnabled, and retain their original registry reconciliation above.

RCA: search exact template fragment/class plus host and narrow time window; correlate the explicit peer/client/connection/message/UUID/tracker/ARN fields where present, then inspect the cited throw/catch and preceding control branch. Verify configured level/appender before interpreting a missing DEBUG point. Compare sender return, receiver parse, broker ACK and downstream response independently; a success/enqueue/lifecycle banner proves only that its code site was reached, never end-to-end business completion. Unlogged/ignored catches and asynchronous callback/Future boundaries require dependency/client evidence.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTC.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTC.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTC.java:1-59"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTC

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:1–59`.

Types.types returns four native type registrations with constructor factories for session descriptions, webrtcbin, data channels and RTP transceivers (`src/org/freedesktop/gstreamer/webrtc/WebRTC.java:36–55`); private outer constructor prevents utility instantiation. NativeObject type discovery is a downstream integration requirement; no transport operation here.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:33` `private WebRTC() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:39` `public Stream<NativeObject.TypeRegistration<?>> types() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect native wrapper/type vocabulary supports WebRTCBin used by WebrtcClient.createWebrtcBin (src/com/nozha/async/server/client/WebrtcClient.java:156–206). Java token absence does not rule out native type-provider registration or native enum conversion.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:1–59` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCBin.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:1-364"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCBin

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:1–364`.

Constructors create native webrtcbin elements, optionally named (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:41–57`). connect overloads forward negotiation, ICE index/candidate, channel and transceiver signals to listener callbacks (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:125–172`). createOffer/createAnswer allocate Promise, read reply offer/answer, invoke listener then dispose; native emission is asynchronous (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:182–217`). createDataChannel requires READY, receives pointer via out parameter and wraps owned channel (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:226–234`). addIceCandidate emits index/string. setLocalDescription/setRemoteDescription disown description, emit with Promise then interrupt/dispose without waiting (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:243–276`). STUN/TURN setters/getters map native properties; bundle policy emits integer; connection state converts native enum. Description getters disown result; addTransceiver emits direction/caps and wraps returned pointer (`src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:284–363`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:48` `public WebRTCBin() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:55` `public WebRTCBin(String name) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:69` `public void onNegotiationNeeded(Element elem);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:82` `public void onIceCandidate(int sdpMLineIndex, String candidate);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:92` `public void onOfferCreated(WebRTCSessionDescription offer);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:102` `public void onAnswerCreated(WebRTCSessionDescription answer);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:110` `public void onDataChannel(WebRTCDataChannel channel);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:117` `public void onNewTransceiver(WebRTCRTPTransceiver transceiver);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:125` `public void connect(final ON_NEGOTIATION_NEEDED listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:128` `public void callback(Element elem) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:139` `public void connect(final ON_ICE_CANDIDATE listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:142` `public void callback(Element elem, int sdpMLineIndex, String candidate) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:152` `public void connect(final ON_DATA_CHANNEL listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:155` `public void callback(Element elem, WebRTCDataChannel channel) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:165` `public void connect(final ON_NEW_TRANSCEIVER listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:168` `public void callback(Element elem, WebRTCRTPTransceiver transceiver) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:182` `public void createOffer(final CREATE_OFFER listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:185` `public void onChange(Promise promise) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:206` `public void createAnswer(final CREATE_ANSWER listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:209` `public void onChange(Promise promise) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:226` `public WebRTCDataChannel createDataChannel(String label) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:243` `public void addIceCandidate(int sdpMLineIndex, String candidate) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:253` `public void setLocalDescription(WebRTCSessionDescription description) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:269` `public void setRemoteDescription(WebRTCSessionDescription description) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:284` `public void setStunServer(String server) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:292` `public String getStunServer() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:303` `public void setTurnServer(String server) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:312` `public String getTurnServer() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:322` `public void setBundlePolicy(WebRTCBundlePolicy policy) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:332` `public WebRTCPeerConnectionState getConnectionState() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:341` `public WebRTCSessionDescription getLocalDescription() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:352` `public WebRTCSessionDescription getRemoteDescription() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:358` `public WebRTCRTPTransceiver addTransceiver(WebRTCTransceiverDirection direction, Caps caps) {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/client/WebrtcClient.java:34` `private WebRTCBin webRTCBin;`
- `src/com/nozha/async/server/client/WebrtcClient.java:163` `webRTCBin = (WebRTCBin) ElementFactory.make("webrtcbin", "webrtcbin");`
- `src/com/nozha/async/server/client/WebrtcClient.java:174` `webRTCBin.connect((WebRTCBin.ON_DATA_CHANNEL) (channel) -> {`
- `src/com/nozha/async/server/client/WebrtcClient.java:198` `webRTCBin.connect((WebRTCBin.ON_ICE_CANDIDATE) (sdpMLineIndex, candidate) -> {`
- `src/com/nozha/async/server/client/WebrtcClient.java:216` `if (source.getParent() != null && source.getParent().getTypeName().equals(WebRTCBin.GTYPE_NAME)) {`

WebrtcClient bridges Async JSON send/receive to native data channel and SDP answer/ICE negotiation. Actor is connected WebRTC client; this wrapper does not define authorization, billing or retry policy. WebrtcClient.send delegates sendMessage (WebrtcClient.java:149–150); createSdpAnswer awaits configured SDP_ANSWER_DELAY_MS and throws on timeout (WebrtcClient.java:230–250). Native emission is not proof of delivery/ACK.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:44,45,46`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — READY guard throws IllegalStateException with exact message; native calls/listeners propagate without catch. Promise disposal occurs after listener and is skipped if callback fails; description getters dereference potentially null native result. No error/status/retry translation.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:228–228` `throw new IllegalStateException("WebRTCBin must be in READY state to create data channel");`

Candidate source risk, not production incident: Promise callback exceptions can bypass disposal; inspect native lifecycle under a throwing listener.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:1–364` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:1-47"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCBundlePolicy

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:1–47`.

NativeEnum holds integer NONE=0, BALANCED=1, MAX_COMPAT=2, MAX_BUNDLE=3; constructor stores value and intValue returns it (`src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:30–45`). Since minor 15 annotation constrains documented native API availability.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:38` `private WebRTCBundlePolicy(int value) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:43` `public int intValue() {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/client/WebrtcClient.java:168` `webRTCBin.setBundlePolicy(WebRTCBundlePolicy.BALANCED);`

WebrtcClient bridges Async JSON send/receive to native data channel and SDP answer/ICE negotiation. Actor is connected WebRTC client; this wrapper does not define authorization, billing or retry policy. WebrtcClient.send delegates sendMessage (WebrtcClient.java:149–150); createSdpAnswer awaits configured SDP_ANSWER_DELAY_MS and throws on timeout (WebrtcClient.java:230–250). Native emission is not proof of delivery/ACK.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:322`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCBundlePolicy.java:1–47` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:1-135"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCDataChannel

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper with first-party Settings/compression modifications, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:1–135`.

Initializer forwards to GstObject. connect adapts native callbacks for error/open/close/message-string and casts channel to this wrapper (`src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:41–107`). sendMessage initially keeps input; WEBRTC_COMPRESS_MESSAGE enables compress; on Exception it keeps original then always emits send-string (`src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:113–122`). compress writes UTF-8 bytes through GZIPOutputStream into Base64OutputStream, closes both, returns UTF-8 encoded Base64 text (`src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:125–134`). No readiness guard, ACK or successful-delivery result; sends are native side effects.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:41` `public WebRTCDataChannel(Initializer init) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:49` `public void onError(WebRTCDataChannel channel);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:56` `public void onOpen(WebRTCDataChannel channel);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:63` `public void onClose(WebRTCDataChannel channel);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:70` `public void onMessage(WebRTCDataChannel channel, String message);`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:73` `public void connect(final ON_ERROR listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:76` `public void callback(GstObject channel) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:82` `public void connect(final ON_OPEN listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:85` `public void callback(GstObject channel) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:91` `public void connect(final ON_CLOSE listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:94` `public void callback(GstObject channel) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:100` `public void connect(final ON_MESSAGE_STRING listener) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:103` `public void callback(GstObject channel, String message) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:113` `public void sendMessage(String message) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:125` `public static String compress(String str) throws IOException {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/client/WebrtcClient.java:36` `private final AtomicReference<WebRTCDataChannel> webRTCDataChannel = new AtomicReference<>();`
- `src/com/nozha/async/server/client/WebrtcClient.java:175` `channel.connect((WebRTCDataChannel.ON_OPEN) (c) -> {`
- `src/com/nozha/async/server/client/WebrtcClient.java:176` `logger.info("*****ON_OPEN WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);`
- `src/com/nozha/async/server/client/WebrtcClient.java:178` `channel.connect((WebRTCDataChannel.ON_CLOSE) (c) -> {`
- `src/com/nozha/async/server/client/WebrtcClient.java:179` `logger.info("*****ON_CLOSE WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);`
- `src/com/nozha/async/server/client/WebrtcClient.java:182` `channel.connect((WebRTCDataChannel.ON_ERROR) (c) -> {`
- `src/com/nozha/async/server/client/WebrtcClient.java:183` `logger.info("*****ON_ERROR WebRTCDataChannel clientId:{}, peerId:{} ", id, pId);`
- `src/com/nozha/async/server/client/WebrtcClient.java:187` `logger.info("*****WebRTCDataChannel ,clientId:{} ,peerId:{} ", id, pId);`

WebrtcClient bridges Async JSON send/receive to native data channel and SDP answer/ICE negotiation. Actor is connected WebRTC client; this wrapper does not define authorization, billing or retry policy. WebrtcClient.send delegates sendMessage (WebrtcClient.java:149–150); createSdpAnswer awaits configured SDP_ANSWER_DELAY_MS and throws on timeout (WebrtcClient.java:230–250). Native emission is not proof of delivery/ACK.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:110,155,226,233`; `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:47,48,49`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — compress declares IOException; sendMessage catches Exception, logs fixed message, suppresses cause and falls back to original. Null input during compression is caught, but null original still reaches native emit. Native emit and callback exceptions are uncaught. No business/HTTP status mapping.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:118–118` `} catch (Exception e) {`

Candidate source risk, not production incident: Compression failure silently changes wire representation; fixed ERROR omits exception and client correlation.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

SOURCE_OBSERVED — direct executable log inventory; registry reconciliation by source path and exact line:
- `src/org/freedesktop/gstreamer/webrtc/WebRTCDataChannel.java:119` `logger.error("Exception in compress");`; registry ID `ALOG-E981FED10F0D`; level `ERROR`, template `Exception in compress`, logged expressions `UNKNOWN`.

Trigger: sendMessage called, Settings.WEBRTC_COMPRESS_MESSAGE true, compress throws caught Exception; ERROR means compression failed and fallback continues to emit original string. No throwable passed, payload, clientId, peerId or trace ID logged. This call exposes no payload but loses root cause and correlation; does not prove send-string failed or message delivered. Search literal Exception in compress at ERROR by host/time; inspect enabled flag/input and reproduce compress failure, correlate WebrtcClient send/activity and channel lifecycle by clientId/peerId; class record cannot join IDs itself.

Logger/appender: WebRTCDataChannel owns LoggerFactory class logger; XML listeners receive Commons Log externally. Registry ROOT/async.log routing is explicitly UNVERIFIED_ROUTE/assumption and is not source-proven for arbitrary supplied logger. Registry source line/template/level agrees; registry generic trigger/impact heuristics are refined above, with runtime coverage still UNKNOWN.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java:1-53"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCPeerConnectionState

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java:1–53`.

NativeEnum stores NEW=0, CONNECTING=1, CONNECTED=2, DISCONNECTED=3, FAILED=4, CLOSED=5 (`src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java:28–50`); intValue exposes mapping. This is state vocabulary, not transition orchestration.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java:49` `public int intValue() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect native wrapper/type vocabulary supports WebRTCBin used by WebrtcClient.createWebrtcBin (src/com/nozha/async/server/client/WebrtcClient.java:156–206). Java token absence does not rule out native type-provider registration or native enum conversion.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:332,333`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCPeerConnectionState.java:1–53` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java:1-34"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCRTPTransceiver

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java:1–34`.

Minimal GstObject native wrapper with GstWebRTCRTPTransceiver type name; initializer passes ownership/handle lifecycle to superclass (`src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java:28–33`). No Java transport/direction methods.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java:31` `public WebRTCRTPTransceiver(Initializer init) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect native wrapper/type vocabulary supports WebRTCBin used by WebrtcClient.createWebrtcBin (src/com/nozha/async/server/client/WebrtcClient.java:156–206). Java token absence does not rule out native type-provider registration or native enum conversion.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:117,168,358,362`; `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:50,51,52`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCRTPTransceiver.java:1–34` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:1-50"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCSDPType

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:1–50`.

NativeEnum maps OFFER=1, PRANSWER=2, ANSWER=3, ROLLBACK=4; intValue returns stored discriminator (`src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:30–48`). No validation or SDP parser here.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:38` `private WebRTCSDPType(int value) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:47` `public int intValue() {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/client/WebrtcClient.java:236` `WebRTCSessionDescription description = new WebRTCSessionDescription(WebRTCSDPType.OFFER, sdpMessage);`

WebrtcClient bridges Async JSON send/receive to native data channel and SDP answer/ICE negotiation. Actor is connected WebRTC client; this wrapper does not define authorization, billing or retry policy. WebrtcClient.send delegates sendMessage (WebrtcClient.java:149–150); createSdpAnswer awaits configured SDP_ANSWER_DELAY_MS and throws on timeout (WebrtcClient.java:230–250). Native emission is not proof of delivery/ACK.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:59`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCSDPType.java:1–50` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:1-94"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCSessionDescription

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:1–94`.

Initializer uses custom Handle and reads JNA description struct (`src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:47–51`); public constructor calls native new with SDP type and SDPMessage (`src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:59–60`). getSDPMessage reads native sdp field, copies to pointer array, invalidates temporary original wrapper and returns separately owned SDPMessage (`src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:68–78`). Handle.disposeNativeHandle frees native session-description pointer (`src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:82–90`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:59` `public WebRTCSessionDescription(WebRTCSDPType type, SDPMessage sdpMessage) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:68` `public SDPMessage getSDPMessage() {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:84` `public Handle(GPointer ptr, boolean ownsHandle) {`
- `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:89` `protected void disposeNativeHandle(GPointer ptr) {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/client/WebrtcClient.java:236` `WebRTCSessionDescription description = new WebRTCSessionDescription(WebRTCSDPType.OFFER, sdpMessage);`

WebrtcClient bridges Async JSON send/receive to native data channel and SDP answer/ICE negotiation. Actor is connected WebRTC client; this wrapper does not define authorization, billing or retry policy. WebrtcClient.send delegates sendMessage (WebrtcClient.java:149–150); createSdpAnswer awaits configured SDP_ANSWER_DELAY_MS and throws on timeout (WebrtcClient.java:230–250). Native emission is not proof of delivery/ACK.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:92,102,187,211,253,269,341,342,352,353`; `src/org/freedesktop/gstreamer/webrtc/WebRTC.java:41,42,43`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch path; native new/copy result is not explicitly checked. Failures from JNA/Natives propagate; lifetime ownership matters. Native-call error behavior and null-pointer outcomes need native runtime proof.

**No explicit throw/catch/assert statements.**

Candidate source risk, not production incident: SDP copy return status is ignored; validate pointer/copy failure with native runtime.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCSessionDescription.java:1–94` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.java
source_refs:
  - "src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.java:1-36"
owner: REQUIRES_HUMAN_VALIDATION
---

# WebRTCTransceiverDirection

## Technical

SOURCE_OBSERVED — package `org.freedesktop.gstreamer.webrtc`; ownership: candidate bundled GStreamer/JNA wrapper, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.java:1–36`.

Enum NONE, INACTIVE, SENDONLY, RECVONLY, SENDRECV plus UNKNOWN annotated DefaultEnumValue (`src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.java:27–35`); native conversion consumes ordinal/default metadata. No transition algorithm.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect native wrapper/type vocabulary supports WebRTCBin used by WebrtcClient.createWebrtcBin (src/com/nozha/async/server/client/WebrtcClient.java:156–206). Java token absence does not rule out native type-provider registration or native enum conversion.

Other source references (lexical evidence, not proof of execution): `src/org/freedesktop/gstreamer/webrtc/WebRTCBin.java:358`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/freedesktop/gstreamer/webrtc/WebRTCTransceiverDirection.java:1–36` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: WebrtcClient.createWebrtcBin channel ON_OPEN/ON_CLOSE/ON_ERROR logs at src/com/nozha/async/server/client/WebrtcClient.java:176/179/183, IDs clientId/peerId (registry ALOG-A75E0819E052, ALOG-5B96E626BF55, ALOG-30E9B796D4CC). Answer callback logs clientId at WebrtcClient.java:240. These observe callback/negotiation activity; cannot prove native delivery or ACK. ICE debug at :200 exposes candidate network address; inspect privacy before export.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/http/server/DefaultPathContainer.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/springframework/http/server/DefaultPathContainer.java
source_refs:
  - "src/org/springframework/http/server/DefaultPathContainer.java:1-311"
owner: REQUIRES_HUMAN_VALIDATION
---

# DefaultPathContainer

## Technical

SOURCE_OBSERVED — package `org.springframework.http.server`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/http/server/DefaultPathContainer.java:1–311`.

createFromUrlPath splits raw path on configured slash or dot, preserves separator elements and omits empty segment objects; empty input returns singleton (`src/org/springframework/http/server/DefaultPathContainer.java:98–130`). Decode mode UTF-8 decodes segment text before semicolon and parses matrix parameters separated by semicolon/comma, accumulating duplicate values (`src/org/springframework/http/server/DefaultPathContainer.java:133–183`). Bare no-equals parameter uses original input key despite decoding name for hasText. subPath returns identity/full or singleton/empty, checks indices, joins raw values and wraps immutable list (`src/org/springframework/http/server/DefaultPathContainer.java:185–200`). Segment factories hold raw value, decoded matching value and immutable parameter maps; no-decode mode only replaces encoded separator %2F/%2E (`src/org/springframework/http/server/DefaultPathContainer.java:228–287`). Equality/hash are raw-path based, ignoring options; char access copies string (65–94,290–307).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/http/server/DefaultPathContainer.java:59` `private DefaultPathContainer(String path, List<Element> elements) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:66` `public String value() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:71` `public List<Element> elements() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:77` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:88` `public int hashCode() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:93` `public String toString() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:98` `static PathContainer createFromUrlPath(String path, Options options) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:133` `private static PathSegment decodeAndParsePathSegment(String segment) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:148` `private static MultiValueMap<String, String> parsePathParams(String input, Charset charset) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:163` `private static void parsePathParamValues(String input, Charset charset, MultiValueMap<String, String> output) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:185` `static PathContainer subPath(PathContainer container, int fromIndex, int toIndex) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:218` `public String value() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:222` `public String encodedSequence() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:242` `static DefaultPathSegment from(String value, DefaultSeparator separator) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:251` `static DefaultPathSegment from(String value, String valueToMatch) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:258` `static DefaultPathSegment from(String value, String valueToMatch, MultiValueMap<String, String> params) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:262` `private DefaultPathSegment(String value, String valueToMatch, MultiValueMap<String, String> params) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:270` `public String value() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:275` `public String valueToMatch() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:280` `public char[] valueToMatchAsChars() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:285` `public MultiValueMap<String, String> parameters() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:290` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/http/server/DefaultPathContainer.java:301` `public int hashCode() {`
- `src/org/springframework/http/server/DefaultPathContainer.java:306` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/http/server/PathContainer.java:64,75,87`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Unsupported separator throws IllegalArgumentException. Assert index guards delegate IllegalArgumentException. UTF-8 URI decoding malformed escapes propagates. Equal start/end bypasses index checks, even if out of bounds. No retry or status mapping.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/http/server/DefaultPathContainer.java:105–105` `throw new IllegalArgumentException("Unexpected separator: '" + separator + "'");`
- `src/org/springframework/http/server/DefaultPathContainer.java:194–194` `Assert.isTrue(fromIndex >= 0 && fromIndex < elements.size(), () -> "Invalid fromIndex: " + fromIndex);`
- `src/org/springframework/http/server/DefaultPathContainer.java:195–195` `Assert.isTrue(toIndex >= 0 && toIndex <= elements.size(), () -> "Invalid toIndex: " + toIndex);`
- `src/org/springframework/http/server/DefaultPathContainer.java:196–196` `Assert.isTrue(fromIndex < toIndex, () -> "fromIndex: " + fromIndex + " should be < toIndex " + toIndex);`

Candidate source risk, not production incident: Bare encoded matrix parameter keys retain raw spelling; equality ignores decode options.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/http/server/DefaultPathContainer.java:1–311` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/http/server/PathContainer.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/springframework/http/server/PathContainer.java
source_refs:
  - "src/org/springframework/http/server/PathContainer.java:1-183"
owner: REQUIRES_HUMAN_VALIDATION
---

# PathContainer

## Technical

SOURCE_OBSERVED — package `org.springframework.http.server`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/http/server/PathContainer.java:1–183`.

Interface exposes original path and immutable-style element view; subPath overloads delegate index ranges to DefaultPathContainer (`src/org/springframework/http/server/PathContainer.java:40–65`). parsePath defaults to HTTP_PATH or accepts Options (`src/org/springframework/http/server/PathContainer.java:74–87`). PathSegment exposes decoded match string/chars and matrix parameters. Options HTTP_PATH uses slash+decode/parse, MESSAGE_ROUTE dot+no full decoding; create stores arbitrary separator/flag (`src/org/springframework/http/server/PathContainer.java:137–180`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/http/server/PathContainer.java:52` `default PathContainer subPath(int index) {`
- `src/org/springframework/http/server/PathContainer.java:63` `default PathContainer subPath(int startIndex, int endIndex) {`
- `src/org/springframework/http/server/PathContainer.java:74` `static PathContainer parsePath(String path) {`
- `src/org/springframework/http/server/PathContainer.java:86` `static PathContainer parsePath(String path, Options options) {`
- `src/org/springframework/http/server/PathContainer.java:157` `private Options(char separator, boolean decodeAndParseSegments) {`
- `src/org/springframework/http/server/PathContainer.java:162` `public char separator() {`
- `src/org/springframework/http/server/PathContainer.java:166` `public boolean shouldDecodeAndParseSegments() {`
- `src/org/springframework/http/server/PathContainer.java:178` `public static Options create(char separator, boolean decodeAndParseSegments) {`

The top-level value() returns original raw path string and elements() returns ordered Element list, not a decoded joined path (`src/org/springframework/http/server/PathContainer.java:40–45`). Nested Element.value() exposes one unmodified raw component; Separator extends Element as a marker with no extra operations and identifies parse boundaries rather than carrying matching logic (`src/org/springframework/http/server/PathContainer.java:94–107`). Nested PathSegment.valueToMatch() is decoded/sanitized matching text; valueToMatchAsChars() exposes that matching text as chars, not raw encoding; parameters() exposes unmodifiable matrix parameter map (`src/org/springframework/http/server/PathContainer.java:113–129`). These interface methods have no bodies; concrete DefaultPathContainer.DefaultPathSegment returns stored match value and creates fresh char array via toCharArray (`src/org/springframework/http/server/DefaultPathContainer.java:269–286`).

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/handler/RestHandler.java:23` `import org.springframework.http.server.PathContainer;`
- `src/com/nozha/async/server/handler/RestHandler.java:108` `final PathContainer pathContainer = PathContainer.parsePath(path);`
- `src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:13` `import org.springframework.http.server.PathContainer;`
- `src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:498` `final PathContainer pathContainer = PathContainer.parsePath(uri);`
- `src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java:516` `final PathContainer pathContainer = PathContainer.parsePath(uri);`

Service creates pathPattern from declared descriptor path (src/com/nozha/async/server/mediation/generic/vo/Service.java:20–26). RestHandler.getServiceFromPath and ServiceDefinitionProvider.getService use parsed URI path, filter matches, then extract variables to prefer fewer captures (RestHandler.java:103–116; ServiceDefinitionProvider.java:488–536). Method-aware provider selection throws MediationException HTTP405 when path matches but method does not. This dependency controls descriptor selection, not its own standalone business policy.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:26,27,28,82,111,200,224,250,265,266,298,314,336,350,353,396,535,543,597,599,604,608,619,626,654,675,729,730`; `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:23,50,65,99,107,110`; `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:19,20`; `src/org/springframework/web/util/pattern/LiteralPathElement.java:19,20,21`; `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:21,22`; `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:22`; `src/org/springframework/web/util/pattern/PathPatternParser.java:19,41,86,94,135`; `src/org/springframework/web/util/pattern/WildcardPathElement.java:19,20,49,53`; `src/org/springframework/web/util/pattern/RegexPathElement.java:24`; `src/org/springframework/http/server/DefaultPathContainer.java:42,44,81,84,98,185`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch path; delegated parsing validates supported separator and decoding; subPath validates ranges in DefaultPathContainer. Options.create itself permits unsupported separators until parse.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/http/server/PathContainer.java:1–183` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/lang/NonNull.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/springframework/lang/NonNull.java
source_refs:
  - "src/org/springframework/lang/NonNull.java:1-50"
owner: REQUIRES_HUMAN_VALIDATION
---

# NonNull

## Technical

SOURCE_OBSERVED — package `org.springframework.lang`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/lang/NonNull.java:1–50`.

Runtime-retained documented marker annotation targeting METHOD, PARAMETER and FIELD (`src/org/springframework/lang/NonNull.java:46–50`). No members, checking code, defaults, state or executable null enforcement; tooling/reflection may consume annotation metadata. The source has no JSR-305 meta-annotations beyond imports shown.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/lang/NonNull.java:1–50` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/lang/Nullable.md -->

---
doc_class: observation
truth_type: operational
sensitivity: internal
evidence_refs: []
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: source-reviewed
review_status: source-reviewed
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_path: src/org/springframework/lang/Nullable.java
source_refs:
  - "src/org/springframework/lang/Nullable.java:1-49"
owner: REQUIRES_HUMAN_VALIDATION
---

# Nullable

## Technical

SOURCE_OBSERVED — package `org.springframework.lang`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/lang/Nullable.java:1–49`.

Runtime-retained documented marker annotation targeting METHOD, PARAMETER and FIELD (`src/org/springframework/lang/Nullable.java:45–50`). No members, checking code, defaults, state or executable null enforcement; tooling/reflection may consume annotation metadata. The source has no JSR-305 meta-annotations beyond imports shown.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/PropertyPlaceholderHelper.java:28,61,87,130,228`; `src/org/springframework/util/MimeType.java:34,108,111,169,180,301,315,325,347,391,426,452`; `src/org/springframework/util/AntPathMatcher.java:28,94,126,172,211,212,436,655,720,849,862,865`; `src/org/springframework/util/LinkedCaseInsensitiveMap.java:33,58,61,64,83,112,166,178,190,191,210,211,226,242,295,345,491`; `src/org/springframework/util/NumberUtils.java:28,250`; `src/org/springframework/util/FileCopyUtils.java:31,146,216`; `src/org/springframework/util/TypeUtils.java:24,217`; `src/org/springframework/util/FileSystemUtils.java:29,57,79`; `src/org/springframework/util/SimpleRouteMatcher.java:22,78`; `src/org/springframework/util/RouteMatcher.java:22,77`; `src/org/springframework/util/ClassUtils.java:43,187,219,220,245,320,352,373,397,460,461,564,627,662,681,716,751,782,796,797,878,888,927,928,951,1065,1091,1147,1185,1186,1275,1323,1381,1400,1414`; `src/org/springframework/util/ResourceUtils.java:27,104`; `src/org/springframework/util/ReflectionUtils.java:30,217,232,233,264,265,279,280,356,416,491,511,528,536,543,591,605,606,635,655,656,704`; `src/org/springframework/util/PatternMatchUtils.java:19,38,83`; `src/org/springframework/util/StringUtils.java:38,100,120,133,156,172,193,214,361,372,384,435,482,511,512,523,524,597,598,613,614,835,862,871,948,959,971,990,991,1018,1019,1093,1094,1118,1137,1139,1175,1199,1232,1252,1288,1300,1315,1344,1354,1365,1387`; `src/org/springframework/util/StringValueResolver.java:19,42`; `src/org/springframework/util/StopWatch.java:24,64,67,179`; `src/org/springframework/util/SystemPropertyUtils.java:19,102`; `src/org/springframework/util/SerializationUtils.java:25,49,50,76,77`; `src/org/springframework/util/CollectionUtils.java:33,60,70,124,134,150,171,189,209,241,262,263,289,333,362,363,385,386,403,404,427,428,453`; `src/org/springframework/util/MultiValueMapAdapter.java:26,58,65,84,130,136,142,173`; `src/org/springframework/util/CustomizableThreadCreator.java:22,44,61,70,131,139`; `src/org/springframework/util/FastByteArrayOutputStream.java:27,333`; `src/org/springframework/util/MimeTypeUtils.java:33,175`; `src/org/springframework/util/ObjectUtils.java:26,80,99,109,134,166,167,187,252,279,317,390,430,445,460,475,490,505,520,535,550,608,633,646,657,704,728,752,776,800,824,848,872,896`; `src/org/springframework/util/ConcurrentReferenceHashMap.java:37,101,221,233,234,241,242,249,262,263,269,270,275,276,280,281,284,285,301,302,305,306,319,322,336,339,351,352,355,356,416,417,492,493,515,516,580,640,641,694,705,723,726,729,735,741,747,748,761,803,804,815,816,840,855,897,900,903,906,998,1013,1027,1030,1044,1064,1067,1081`; `src/org/springframework/util/Assert.java:23,160,177,188,199,217,228,241,261,273,287,307,319,332,351,363,376,394,406,418,440,455,468,487,499,513,535,553,571,583,599,618,632,648,667,686,705,727,731,732`; `src/org/springframework/util/MethodInvoker.java:23,44,47,50,53,56,60,71,78,90,100,112,119,214,274`; `src/org/springframework/util/StreamUtils.java:32,64,82`; `src/org/springframework/util/InstanceFilter.java:22,57,58`; `src/org/springframework/util/AutoPopulatingList.java:28,236`; `src/org/springframework/util/MultiValueMap.java:22,39,47,71,82`; `src/org/springframework/web/util/pattern/PathPattern.java:29,120,153,223,249,367,432,503,535,561,660,663`; `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:24,84`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:23,70,74,78`; `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:23,37`; `src/org/springframework/web/util/pattern/PathElement.java:19,46,50`; `src/org/springframework/util/comparator/InstanceComparator.java:21,62`; `src/org/springframework/util/comparator/BooleanComparator.java:22,72`; `src/org/springframework/util/comparator/InvertibleComparator.java:22,112`; `src/org/springframework/util/comparator/NullSafeComparator.java:21,95,111`; `src/org/springframework/util/comparator/CompoundComparator.java:24,191`; `src/org/springframework/util/function/SupplierUtils.java:21,38,39`; `src/org/springframework/util/function/SingletonSupplier.java:21,39,42,45,55,67,89,135,136,154,155`; `src/org/springframework/util/unit/DataSize.java:23,174,248,276`; `src/org/springframework/util/xml/XmlValidationModeDetector.java:25,173`; `src/org/springframework/util/xml/StaxSource.java:26,50,53,89,101`; `src/org/springframework/util/xml/SimpleNamespaceContext.java:29,69,137`; `src/org/springframework/util/xml/StaxStreamXMLReader.java:31,54,157,162,171`; `src/org/springframework/util/xml/ListBasedXMLEventReader.java:28,43,73,108`; `src/org/springframework/util/xml/AbstractXMLReader.java:28,44,47,50,53,56,61,66,72,77,83,88,94,99,104,147`; `src/org/springframework/util/xml/AbstractStaxXMLReader.java:33,60,185`; `src/org/springframework/util/xml/AbstractXMLStreamReader.java:24,164,165`; `src/org/springframework/util/xml/DomUtils.java:32,95,115`; `src/org/springframework/util/xml/XMLEventStreamReader.java:33,81,117,123`; `src/org/springframework/util/xml/StaxUtils.java:39,137,157,223,243`; `src/org/springframework/util/xml/StaxEventXMLReader.java:46,70,181,186,195`; `src/org/springframework/util/xml/StaxResult.java:26,51,54,88,100`; `src/org/springframework/util/xml/StaxEventHandler.java:35,74`; `src/org/springframework/util/xml/AbstractStaxHandler.java:33,153`; `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:21,56`; `src/org/springframework/util/concurrent/SettableListenableFuture.java:25,57,117,133,151,159`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:24,54`; `src/org/springframework/util/concurrent/SuccessCallback.java:19,36`; `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:22,45,136`; `src/org/springframework/util/concurrent/FutureAdapter.java:24,41,82,88,94,131`; `src/org/springframework/http/server/DefaultPathContainer.java:28,77,290`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/lang/Nullable.java:1–49` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/AlternativeJdkIdGenerator.md -->

---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: source-reviewed
truth_type: SOURCE_OBSERVED
owner: REQUIRES_HUMAN_VALIDATION
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
source_refs:
  - "src/org/springframework/util/AlternativeJdkIdGenerator.java:L1-L65"
source_commit: 781e6c4c61706a798883818982f72fb8fa53a661
review_status: source-reviewed
business_approval: UNKNOWN
runtime_validation: NOT_RUN
---

# AlternativeJdkIdGenerator — bundled Spring utility candidate

## Technical

Package `org.springframework.util`; bundled dependency ownership is evidenced by the Spring package and Apache/Spring source header, not Async domain ownership. Complete method-body inspection at pinned source; method declaration index below is supplemental evidence, not a runtime test.

Constructor seeds java.util.Random from eight SecureRandom bytes through BigInteger.longValue (39–44). generateId fills 16 bytes, shifts each eight-byte half in big-endian order and returns UUID without normalizing UUID version/variant bits (48–63). Random supplies thread-safe individual operations; UUID output is pseudorandom after a secure seed, not a per-call SecureRandom cryptographic contract.

All numeric line ranges above refer to [src/org/springframework/util/AlternativeJdkIdGenerator.java:L1–L65](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L1-L65). Inputs/output/state constraints are described in the behavior families; no application DB/cache/queue interaction is inferred from utility names.

Declared method/constructor cross-check (overloads and nested/private helpers retained):

- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L39): `public AlternativeJdkIdGenerator() {`
- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L48): `public UUID generateId() {`

Downstream imports (JDK and local dependency edges):

- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L19): `import java.math.BigInteger;`
- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L20): `import java.security.SecureRandom;`
- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L21): `import java.util.Random;`
- [src/org/springframework/util/AlternativeJdkIdGenerator.java:L22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/org/springframework/util/AlternativeJdkIdGenerator.java#L22): `import java.util.UUID;`

Static utility callers within bundled source (up to 12 representative source lines; complete reverse-edge inventory remains searchable by class identifier):

- No external Java caller identifier found in bundled snapshot.

## Business

SOURCE_OBSERVED: indirect dependency behavior above can support consumers that call this utility; this class does not define an Async business policy, actor, entitlement, SLA or HTTP contract. The first-party Java tree (`src/com/nozha` plus default-package Java files) was searched for the fully qualified Spring utility package and every assigned class identifier. No confirmed first-party call/import to this class was found. This is a static reference result, not proof of runtime use or non-use; dependency bytecode, reflection and configuration-driven access remain possible.

INFERENCE: any user-visible impact depends on an actual calling integration, not merely vendored source presence. APPROVED_INTENT: no owner decision was supplied. UNKNOWN: production loaded artifact/classpath, dynamic callers, feature-level effect and business approval. These unknowns do not invalidate the inspected local method semantics and are not counted as business approval/runtime testing.

## Errors

No direct explicit throw/assert/catch path in class. Delegated JDK/caller operations can still fail; absence of a local throw is not a no-failure guarantee.

Failure effect: catch/translation/suppression behavior is explained in Technical families; otherwise exceptions escape to the caller. There is no direct Async HTTP/business status mapping in this class. Caller-specific recovery/status/visibility cannot be established from the absent first-party edge. Reproduction is a proposed isolated Java harness using each documented boundary (null/empty/invalid input, state order or delegated IO/reflection failure as applicable); no runtime test or production incident is claimed.

## Logs and RCA

**NO_LOG_IN_CLASS**: no direct logger/console output site in the complete source. No prior registry rows for this source path; this agrees with source inspection.

RCA: first establish whether this exact bundled class is loaded in the deployed build and identify calling stack before relating it to an Async symptom. For emitted sites search the literal template fragment and class/logger around the failure time, then inspect adjacent caller exception and input/state; silent classes require caller stack/exception evidence or an isolated reproduction. No confirmed first-party caller log, configured appender, log retention or request correlation edge was evidenced for this utility; bundled callers listed above do not establish a product request path. No direct log proves successful user delivery, database commit or policy decision.
