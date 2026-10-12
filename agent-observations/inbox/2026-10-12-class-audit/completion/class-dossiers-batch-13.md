# Async class dossiers — review batch 13


---

### dossier-src-com-nozha-async-server-persistance-impl-oracleratelimitcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:1-566"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java:1-566"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java"
---

# OracleRateLimitCrud

## Technical

Source-reviewed candidate, based on the complete archived file [OracleRateLimitCrud.java:L1–566](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L1-L566). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and RateLimit persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE SEQUENCE provider_seq  CREATE TABLE provider ( CREATE UNIQUE INDEX provider_unq_inx ON  provider (name ASC) CREATE TABLE provider_config ( CREATE UNIQUE INDEX provider_config_unq_inx ON provider_config (provider_id ASC, server_id ASC)  CREATE TABLE endpoint_config ( CREATE UNIQUE INDEX endpoint_config_unq_inx ON endpoint_config (provider_id ASC, server_id ASC, endpoint ASC) . [OracleRateLimitCrud.java:L29–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L29-L68)
- `loadBlockedProviders(int serverId)`: Joins provider_config to provider for server and is_block=1, mapping peer ID to provider name in a ConcurrentHashMap. Duplicate peer IDs overwrite. [OracleRateLimitCrud.java:L71–89](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L71-L89)
- `loadEndpointConfigs(int serverId)`: Reads server-scoped endpoint limits/watch flags; constructs EndpointConfig and keys by provider + underscore + path. The delimiter is not escaped and collisions are possible. [OracleRateLimitCrud.java:L92–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L92-L114)
- `updateEndpointConfig(String providerName, String path, int blockCount, int serverId)`: MERGE uses provider name to resolve provider ID and server/path as composite identity. Integer overload updates block_count or inserts watch=0; boolean overload updates has_watch or inserts block_count=0. Zero rows warns; commit still occurs. [OracleRateLimitCrud.java:L117–147](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L117-L147)
- `updateEndpointConfig(String providerName, String path, boolean hasWatch, int serverId)`: MERGE uses provider name to resolve provider ID and server/path as composite identity. Integer overload updates block_count or inserts watch=0; boolean overload updates has_watch or inserts block_count=0. Zero rows warns; commit still occurs. [OracleRateLimitCrud.java:L150–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L150-L180)
- `blockProvider(String providerName, int serverId)`: MERGE marks provider blocked per server; missing provider gives zero rows and throws HttpException("provider not found",404), before commit. [OracleRateLimitCrud.java:L183–210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L183-L210)
- `unblockProvider(String providerName, int serverId)`: Deletes provider_config row(s) for the named provider/server, removing the config rather than toggling one flag; commits. [OracleRateLimitCrud.java:L213–231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L213-L231)
- `loadBusinessMap()`: Reads BUSINESS.business_id/name into a ConcurrentHashMap globally; duplicate keys overwrite. [OracleRateLimitCrud.java:L234–249](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L234-L249)
- `blockBusiness(String businessId, int serverId)`: MERGE sets is_block=1 for business/server. Oracle new rows additionally receive is_watch=0; MySQL new rows omit is_watch. Zero rows warns, with no explicit failure result. [OracleRateLimitCrud.java:L252–277](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L252-L277)
- `unblockBusiness(String businessId, int serverId)`: Oracle updates is_block=0, preserving is_watch. MySQL deletes the entire business_config row, also removing watch configuration. [OracleRateLimitCrud.java:L280–299](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L280-L299)
- `watchBusiness(String businessId, int serverId)`: MERGE sets is_watch=1; missing row starts with is_block=0. Its WARN/ERROR messages incorrectly refer to blockBusiness. [OracleRateLimitCrud.java:L302–327](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L302-L327)
- `unwatchBusiness(String businessId, int serverId)`: Oracle updates is_watch=0. MySQL instead updates is_block=0, leaving watch untouched. Its logs refer to unblockBusiness, obscuring the actual command. [OracleRateLimitCrud.java:L330–349](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L330-L349)
- `loadBlockedBusiness(int serverId)`: Loads server-scoped is_block=1 business IDs into ConcurrentHashSet. [OracleRateLimitCrud.java:L352–369](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L352-L369)
- `loadBusinessConfigs(int serverId)`: Loads business ID and is_block/is_watch for the server, producing BusinessConfig keyed by business ID. [OracleRateLimitCrud.java:L372–392](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L372-L392)
- `loadBusinessProviderConfigs(int serverId)`: Joins business_provider_config to peer for server; produces configs keyed business ID + underscore + provider name. Its catch template says loadBusinessConfigs. [OracleRateLimitCrud.java:L395–417](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L395-L417)
- `updateBusinessConfig(String businessId, long providerPeerId, int blockCount, int serverId)`: MERGE upserts block_count for business ID, provider peer ID and server; zero rows warns and still commits. [OracleRateLimitCrud.java:L420–450](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L420-L450)
- `loadIpAddressConfigs(int serverId)`: Loads server-scoped IP and is_block into IPAddressConfig map keyed by IP; no normalization occurs here. [OracleRateLimitCrud.java:L453–472](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L453-L472)
- `loadIpAddressList()`: Reads global IP_ADDRESS entries into ConcurrentHashSet, without server restriction. [OracleRateLimitCrud.java:L475–490](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L475-L490)
- `blockIpAddress(String ip, int serverId)`: MERGE sets is_block=1 by IP/server. Oracle inserts source.ip_address; MySQL insert incorrectly references source.business_id, absent from the source projection. [OracleRateLimitCrud.java:L493–518](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L493-L518)
- `unblockIpAddress(String ip, int serverId)`: Sets is_block=0 for IP/server, preserving the row; no affected-row validation. [OracleRateLimitCrud.java:L521–540](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L521-L540)
- `loadRateLimitConfig()`: Reads global key/capacity/refill/permanent-block/count-threshold and creates RateLimitConfig with zero initial timestamp/counter and AtomicLong(0). Runtime usage counts are not loaded from DB. [OracleRateLimitCrud.java:L543–565](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L543-L565)

Relational dependencies observed in string SQL: `BUSINESS`, `IP_ADDRESS`, `RATE_LIMIT_CONFIG`, `business_config`, `business_provider_config`, `endpoint_config`, `ip_address_config`, `peer`, `provider`, `provider_config`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/RateLimitCrud.java: [RateLimitCrud.java:L24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L24).

Consumer boundary: [RateLimitCrud.java:L1–107](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RateLimitCrud.java#L1-L107). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: loads and changes provider/endpoint/business/IP blocking, watch state and token/config parameters per server (some catalog/config queries global). It is the storage/control-plane dependency of limiting; it does not consume tokens or reject traffic itself.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [OracleRateLimitCrud.java:L65–67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L65-L67)
- `catch (SQLException e)` in `loadBlockedProviders`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L85–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L85-L87)
- `catch (SQLException e)` in `loadEndpointConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L110–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L110-L112)
- `catch (SQLException e)` in `updateEndpointConfig`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L142–146](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L142-L146)
- `catch (SQLException e)` in `updateEndpointConfig`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L175–179](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L175-L179)
- `catch (SQLException e)` in `blockProvider`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L206–209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L206-L209)
- `catch (SQLException e)` in `unblockProvider`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L227–230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L227-L230)
- `catch (SQLException e)` in `loadBusinessMap`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L245–247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L245-L247)
- `catch (SQLException e)` in `blockBusiness`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L273–276](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L273-L276)
- `catch (SQLException e)` in `unblockBusiness`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L295–298](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L295-L298)
- `catch (SQLException e)` in `watchBusiness`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L323–326](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L323-L326)
- `catch (SQLException e)` in `unwatchBusiness`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L345–348](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L345-L348)
- `catch (SQLException e)` in `loadBlockedBusiness`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L365–367](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L365-L367)
- `catch (SQLException e)` in `loadBusinessConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L388–390](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L388-L390)
- `catch (SQLException e)` in `loadBusinessProviderConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L413–415](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L413-L415)
- `catch (SQLException e)` in `updateBusinessConfig`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L445–449](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L445-L449)
- `catch (SQLException e)` in `loadIpAddressConfigs`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L468–470](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L468-L470)
- `catch (SQLException e)` in `loadIpAddressList`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L486–488](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L486-L488)
- `catch (SQLException e)` in `blockIpAddress`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L514–517](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L514-L517)
- `catch (SQLException e)` in `unblockIpAddress`: Propagates `new PersistanceException(e)`. [OracleRateLimitCrud.java:L536–539](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L536-L539)
- `catch (SQLException e)` in `loadRateLimitConfig`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleRateLimitCrud.java:L561–563](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L561-L563)
- Explicit throw in `updateEndpointConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L145](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L145)
- Explicit throw in `updateEndpointConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L178](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L178)
- Explicit throw in `blockProvider`: `new HttpException("provider not found", HttpStatus.SC_NOT_FOUND)`. HTTP status is encoded in this constructor; follow servlet caller for emitted response. [OracleRateLimitCrud.java:L202](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L202)
- Explicit throw in `blockProvider`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L208)
- Explicit throw in `unblockProvider`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L229)
- Explicit throw in `blockBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L275](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L275)
- Explicit throw in `unblockBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L297](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L297)
- Explicit throw in `watchBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L325](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L325)
- Explicit throw in `unwatchBusiness`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L347](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L347)
- Explicit throw in `updateBusinessConfig`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L448](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L448)
- Explicit throw in `blockIpAddress`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L516](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L516)
- Explicit throw in `unblockIpAddress`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRateLimitCrud.java:L538](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L538)

Source-observed risks/findings (not production incidents):

- Watch/unwatch and business-provider loader error templates name different operations, so template-only incident grouping is misleading.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [OracleRateLimitCrud.java:L66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L66) **ERROR**, registry `ALOG-A6D51F1411E2`; `logger.error("An exception occurred in database, initialize provider endPoint tables", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L86](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L86) **ERROR**, registry `ALOG-EA6371304685`; `logger.error("An exception occurred in database,loadBlockedProviders for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBlockedProviders; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L111) **ERROR**, registry `ALOG-140F50F2FAD1`; `logger.error("An exception occurred in database,loadEndpointConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadEndpointConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L138) **WARN**, registry `ALOG-B0E39B3982CC`; `logger.warn("can not updateEndpointConfig in database for provider={} ,path={} ,blockCount={} ,serverId={}", providerName, path, blockCount, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L143](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L143) **ERROR**, registry `ALOG-91E7DFDA5D42`; `logger.error("An exception occurred in database,updateEndpointConfig for provider={} ,path={} ,blockCount={} ,serverId={}", providerName, path, blockCount, serverId, e)`. Trigger/RCA: Caught exception in updateEndpointConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L171](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L171) **WARN**, registry `ALOG-F7558D14452D`; `logger.warn("can not updateEndpointConfig in database for provider={} ,path={} ,hasWatch={} ,serverId={}", providerName, path, hasWatch, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L176) **ERROR**, registry `ALOG-6C8D5005CE85`; `logger.error("An exception occurred in database,updateEndpointConfig for provider={} ,path={} ,hasWatch={} ,serverId={}", providerName, path, hasWatch, serverId, e)`. Trigger/RCA: Caught exception in updateEndpointConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L200](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L200) **WARN**, registry `ALOG-B8192C489889`; `logger.warn("can not blockProvider in database for provider={} ,serverId={}", providerName, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L207](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L207) **ERROR**, registry `ALOG-1542AEDED66C`; `logger.error("An exception occurred in database,blockProvider for provider={} ,serverId={}", providerName, serverId, e)`. Trigger/RCA: Caught exception in blockProvider; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L228](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L228) **ERROR**, registry `ALOG-5BFE5179B6B9`; `logger.error("An exception occurred in database,unblockProvider for provider={} ,serverId={}", providerName, serverId, e)`. Trigger/RCA: Caught exception in unblockProvider; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L246](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L246) **ERROR**, registry `ALOG-389DA9CE96C9`; `logger.error("An exception occurred in database,loadBusinessMap for serverId={}", Settings.SERVER_ID, e)`. Trigger/RCA: Caught exception in loadBusinessMap; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L269](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L269) **WARN**, registry `ALOG-EFADD4E7491D`; `logger.warn("can not blockBusiness in database for businessId={} ,serverId={}", businessId, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L274](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L274) **ERROR**, registry `ALOG-D01055D648C8`; `logger.error("An exception occurred in database,blockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in blockBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L296](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L296) **ERROR**, registry `ALOG-38C7ACD454EB`; `logger.error("An exception occurred in database,unblockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in unblockBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L319](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L319) **WARN**, registry `ALOG-0AAEBF55645E`; `logger.warn("can not blockBusiness in database for businessId={} ,serverId={}", businessId, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L324](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L324) **ERROR**, registry `ALOG-9249B50BFF1B`; `logger.error("An exception occurred in database,blockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in watchBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L346](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L346) **ERROR**, registry `ALOG-8EE3FF8C0DFA`; `logger.error("An exception occurred in database,unblockBusiness for businessId={} ,serverId={}", businessId, serverId, e)`. Trigger/RCA: Caught exception in unwatchBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L366](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L366) **ERROR**, registry `ALOG-BDC7BAE66596`; `logger.error("An exception occurred in database,loadBlockedBusiness for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBlockedBusiness; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L389](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L389) **ERROR**, registry `ALOG-0F7911003E7F`; `logger.error("An exception occurred in database,loadBusinessConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBusinessConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L414](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L414) **ERROR**, registry `ALOG-CB1950721194`; `logger.error("An exception occurred in database,loadBusinessConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadBusinessProviderConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L441](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L441) **WARN**, registry `ALOG-C162D35EEA60`; `logger.warn("can not updateBusinessConfig in database for businessId={} ,peer_id={} ,blockCount={} ,serverId={}", businessId, providerPeerId, blockCount, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L446](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L446) **ERROR**, registry `ALOG-F1C462C52EA6`; `logger.error("An exception occurred in database,updateBusinessConfig for businessId={} ,peer_id={} ,blockCount={} ,serverId={}", businessId, providerPeerId, blockCount, serverId, e)`. Trigger/RCA: Caught exception in updateBusinessConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L469](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L469) **ERROR**, registry `ALOG-F7121C777647`; `logger.error("An exception occurred in database,loadIpAddressConfigs for serverId={}", serverId, e)`. Trigger/RCA: Caught exception in loadIpAddressConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L487](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L487) **ERROR**, registry `ALOG-62E944379433`; `logger.error("An exception occurred in database,loadIpAddressList for serverId={}", Settings.SERVER_ID, e)`. Trigger/RCA: Caught exception in loadIpAddressList; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L510](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L510) **WARN**, registry `ALOG-DBEF4227E46A`; `logger.warn("can not blockIpAddress in database for ip={} ,serverId={}", ip, serverId)`. Trigger/RCA: Affected-row count is zero in operation guard; does not by itself prove a connectivity failure.
- [OracleRateLimitCrud.java:L515](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L515) **ERROR**, registry `ALOG-EB16673945B3`; `logger.error("An exception occurred in database,blockIpAddress for ip={} ,serverId={}", ip, serverId, e)`. Trigger/RCA: Caught exception in blockIpAddress; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L537](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L537) **ERROR**, registry `ALOG-A441B48A60FA`; `logger.error("An exception occurred in database,unblockIpAddress for ip={} ,serverId={}", ip, serverId, e)`. Trigger/RCA: Caught exception in unblockIpAddress; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRateLimitCrud.java:L562](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRateLimitCrud.java#L562) **WARN**, registry `ALOG-38FAD090D8AF`; `logger.warn("An exception occurred during load rate limit config", e)`. Trigger/RCA: Caught exception in loadRateLimitConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 28 active source calls, 28 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-oraclerestcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/OracleRestCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:1-223"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java:1-223"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java"
---

# OracleRestCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [OracleRestCRUD.java:L1–223](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L1-L223). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and Rest persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE SEQUENCE rest_registration_seq create table REST_REGISTRATION\n create unique index REST_REGISTRATION_ID_UINDEX\n. [OracleRestCRUD.java:L20–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L20-L50)
- `loadRestRegistration(RestRegistration restRegistration)`: Looks up base URL, config-file URL and peer with bound values; first row or null. Does not scope by server. [OracleRestCRUD.java:L53–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L53-L83)
- `createRestRegistration(RestRegistration restRegistration, Integer serverId)`: Rejects positive ID, inserts base/config URL, peer, version, server and time; binds server from the input object rather than supplied serverId. Assigns generated key/sequence ID and commits. [OracleRestCRUD.java:L86–126](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L86-L126)
- `listRestRegistration(Integer serverId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [OracleRestCRUD.java:L129–131](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L129-L131)
- `listRestRegistration(long lastId, Integer serverId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [OracleRestCRUD.java:L134–159](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L134-L159)
- `listRestRegistration(long lastId)`: Server-only overload begins at ID zero; cursor+server filters both and orders ID; cursor-only overload deliberately reads all servers after lastId. [OracleRestCRUD.java:L161–185](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L161-L185)
- `getRestRegistration(ResultSet rs)`: Reconstructs ID/version/time/peer/base URL/config URL/server ID from a ResultSet; SQL conversion errors propagate. [OracleRestCRUD.java:L186–196](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L186-L196)
- `deleteRestRegistration(RestRegistration restRegistration)`: Deletes ID/version pair and throws PersistanceException("row was deleted or updated in another session") on zero rows, otherwise commits. [OracleRestCRUD.java:L199–218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L199-L218)
- `main(String[] args)`: Invokes private schema initializer; static main can serve as manual JVM entrypoint. No production startup invocation is proven. [OracleRestCRUD.java:L220–222](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L220-L222)

Relational dependencies observed in string SQL: `REST_REGISTRATION`, `rest_registration`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/RestCRUD.java: [RestCRUD.java:L20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L20).

Consumer boundary: [RestCRUD.java:L1–43](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/RestCRUD.java#L1-L43). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: persists REST mediation base/config URLs and peer/server associations used to restore routing. It does not fetch remote config here. Façade vendor support differs from the existence of MySQL implementation.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [OracleRestCRUD.java:L47–49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L47-L49)
- `catch (SQLException e)` in `loadRestRegistration`: Propagates `new PersistanceException(e)`. [OracleRestCRUD.java:L79–82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L79-L82)
- `catch (SQLException e)` in `createRestRegistration`: Propagates `new PersistanceException(e)`. [OracleRestCRUD.java:L122–125](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L122-L125)
- `catch (SQLException e)` in `listRestRegistration`: Propagates `new PersistanceException(e)`. [OracleRestCRUD.java:L155–158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L155-L158)
- `catch (SQLException e)` in `listRestRegistration`: Propagates `new PersistanceException(e)`. [OracleRestCRUD.java:L181–184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L181-L184)
- `catch (SQLException e)` in `deleteRestRegistration`: Propagates `new PersistanceException(e)`. [OracleRestCRUD.java:L214–217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L214-L217)
- Explicit throw in `loadRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L81)
- Explicit throw in `createRestRegistration`: `new PersistanceException("entity has id")`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L88)
- Explicit throw in `createRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L124)
- Explicit throw in `listRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L157)
- Explicit throw in `listRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L183](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L183)
- Explicit throw in `deleteRestRegistration`: `new PersistanceException("row was deleted or updated in another session")`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L210)
- Explicit throw in `deleteRestRegistration`: `new PersistanceException(e)`. No HTTP status mapping is performed at this site. [OracleRestCRUD.java:L216](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L216)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [OracleRestCRUD.java:L48](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L48) **WARN**, registry `ALOG-D71E4AFF69DC`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRestCRUD.java:L80](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L80) **WARN**, registry `ALOG-1BA028308899`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in loadRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRestCRUD.java:L123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L123) **WARN**, registry `ALOG-0CDC074CA51C`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in createRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRestCRUD.java:L156](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L156) **WARN**, registry `ALOG-0B9AE69A7375`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRestCRUD.java:L182](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L182) **WARN**, registry `ALOG-2B42A791470B`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in listRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleRestCRUD.java:L215](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleRestCRUD.java#L215) **WARN**, registry `ALOG-71F9D153C71E`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in deleteRestRegistration; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 6 active source calls, 6 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-oracleservicecallcrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java:1-60"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java:1-60"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java"
---

# OracleServiceCallCRUD

## Technical

Source-reviewed candidate, based on the complete archived file [OracleServiceCallCRUD.java:L1–60](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L1-L60). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and ServiceCall persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `loadServiceCallDispatcher()`: Reads all DISPATCHER_KEY/PEER_NAME rows into a HashMap, with duplicate keys replaced by later rows and no cluster/server predicate. [OracleServiceCallCRUD.java:L21–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L21-L39)
- `loadServiceCallBlocker()`: Reads all BLOCKER_KEY rows into a HashSet; duplicate keys collapse and there is no server predicate. [OracleServiceCallCRUD.java:L42–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L42-L59)

Relational dependencies observed in string SQL: `SERVICE_CALL_BLOCKER`, `SERVICE_CALL_DISPATCHER`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/ServiceCallCrud.java: [ServiceCallCrud.java:L17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L17).

Consumer boundary: [ServiceCallCrud.java:L1–28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceCallCrud.java#L1-L28). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: supplies dispatcher-key→peer-name map and blocker-key set for service-call routing decisions. Config load failures can look like absent routing/block entries because errors are swallowed. No request is forwarded in this file.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `loadServiceCallDispatcher`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleServiceCallCRUD.java:L35–37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L35-L37)
- `catch (SQLException e)` in `loadServiceCallBlocker`: Logs and returns the accumulated collection, possibly empty or partially filled; absence of rows and SQL failure are not distinguishable by return value. [OracleServiceCallCRUD.java:L55–57](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L55-L57)

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [OracleServiceCallCRUD.java:L36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L36) **WARN**, registry `ALOG-79814FA0364E`; `logger.warn("An exception occurred during load service call dispatcher config", e)`. Trigger/RCA: Caught exception in loadServiceCallDispatcher; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceCallCRUD.java:L56](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceCallCRUD.java#L56) **WARN**, registry `ALOG-00F90050C811`; `logger.warn("An exception occurred during load service call blocker config", e)`. Trigger/RCA: Caught exception in loadServiceCallBlocker; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 2 active source calls, 2 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-persistance-impl-oracleserviceprovidercrud

<!-- source dossier: src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.md -->

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
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java:1-241"
source_refs:
  - "inputs/kB/Async/Async/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java:1-241"
  - "https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java"
---

# OracleServiceProviderCrud

## Technical

Source-reviewed candidate, based on the complete archived file [OracleServiceProviderCrud.java:L1–241](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L1-L241). Package `com.nozha.async.server.persistance.impl`. This class is first-party persistence code by `com.nozha.async.server` namespace; author comments are historical evidence, not current accountable ownership. Pinned archive provenance was reconciled by root; this dossier does not establish deployed/runtime behavior.

Uses JDBC ConnectionFactory and ServiceProvider persistence contract. Most connection-owning mutations set autoCommit(false) and commit where shown; try-with-resources/finally closes connections. No explicit rollback/retry policy should be inferred from close. Per-method exceptions below distinguish suppressed failure from propagation. Private initializers are manual DDL helpers, not proof that production tables match these definitions.

Method and branch review:

- `initialize()`: Private DDL bootstrap creates the tables/indexes/sequences/procedure represented in this source and commits; catches SQL failures and continues to return. No automatic invocation is established merely by its existence. DDL includes CREATE SEQUENCE service_provider_config_seq create table SERVICE_PROVIDER_CONFIG (  CREATE UNIQUE INDEX SERVICE_PROVIDER_CONFIG_inx2 ON  SERVICE_PROVIDER_CONFIG (PEER_NAME,SERVER_ID). [OracleServiceProviderCrud.java:L20–40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L20-L40)
- `createServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, List<String> serverIds)`: For each server string, parses numeric ID and checks peer/server existence, updating existing row or inserting. Per-server SQL failures are collected and execution continues; successful work commits before an HTTP 500 names failed server IDs. Whole-connection SQL failures rethrow. [OracleServiceProviderCrud.java:L44–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L44-L79)
- `insertServiceProviderConfig(ServiceProviderConfig serviceProviderConfig, String serverId, Connection connection)`: Gets service_provider_config_seq.nextVal, inserts peer/swagger/error-page/virtual-hosts/enabled/server, defaults null enabled to true, and mutates the shared config ID. No independent commit. [OracleServiceProviderCrud.java:L81–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L81-L104)
- `updateServiceProviderConfig(long id, ServiceProviderConfig serviceProviderConfig, Connection connection)`: Always updates swagger_url; conditionally updates error_page, virtual_hosts and enabled when supplied. Mutates config ID; cannot explicitly clear fields whose null means omit. [OracleServiceProviderCrud.java:L106–128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L106-L128)
- `getServiceProviderConfigs()`: No-argument lookup returns only enabled rows for Settings.SERVER_ID. Filtered overload includes disabled rows, optionally restricts peer and numeric server IDs; an empty nonnull server list fails during placeholder construction. [OracleServiceProviderCrud.java:L131–152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L131-L152)
- `fillServiceProviderConfig(ResultSet rs)`: Splits virtual_hosts on comma/semicolon with surrounding whitespace, defaults missing hosts to an empty array, trims peer/swagger/error page, maps enabled only when integer equals one and sets server ID. [OracleServiceProviderCrud.java:L155–173](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L155-L173)
- `getServiceProviderConfigs(String peerName, List<String> serverIds)`: No-argument lookup returns only enabled rows for Settings.SERVER_ID. Filtered overload includes disabled rows, optionally restricts peer and numeric server IDs; an empty nonnull server list fails during placeholder construction. [OracleServiceProviderCrud.java:L176–212](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L176-L212)
- `deleteServiceProviderConfig(String peerName, List<String> serverIds)`: Deletes all configs for peer, optionally restricted to parsed server IDs. No explicit setAutoCommit/commit; depends on checked-out connection state. Empty nonnull list fails before execution. [OracleServiceProviderCrud.java:L215–240](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L215-L240)

Relational dependencies observed in string SQL: `SERVICE_PROVIDER_CONFIG`, `in`. Bound scalar values, concatenated batch lists, sequence access and transaction ownership are distinguished in the method review. No prepared-statement use is a blanket claim of injection safety.

Direct source references/callers (static/class construction or interface implementation; declaration imports alone are excluded):

- src/com/nozha/async/server/persistance/ServiceProviderCrud.java: [ServiceProviderCrud.java:L19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L19).

Consumer boundary: [ServiceProviderCrud.java:L1–38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/ServiceProviderCrud.java#L1-L38). Follow those façade callers for HTTP/transport error mapping.

## Business

SOURCE_OBSERVED: manages per-peer/per-server Swagger URLs, error pages, virtual hosts and enabled state for generic mediation/provider setup. Multi-server writes may partly commit and still return HTTP 500; users cannot infer atomic all-server application from failure status.

APPROVED_INTENT: UNKNOWN; no product-owner approval or authoritative policy was provided. INFERENCE: storage/control-plane failures may degrade the capability described above, with exact effect depending on callers and flags. UNKNOWN: deployed vendor/schema/flags, retention and delivery/ordering guarantees, authorized administrative actor, owner-approved acceptance criteria. These unknowns are not counted as business approval.

## Errors

- `catch (SQLException e)` in `initialize`: Suppresses this caught failure after any logging shown below; no caller-visible failure is produced by this catch. Previous side effects may already have occurred. [OracleServiceProviderCrud.java:L37–39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L37-L39)
- `catch (SQLException e)` in `createServiceProviderConfig`: Suppresses this SQL failure for the current server; records failed server ID, continues, later commits successes and throws HttpException 500 if any failed. [OracleServiceProviderCrud.java:L66–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L66-L70)
- `catch (SQLException e)` in `createServiceProviderConfig`: Propagates `e`. [OracleServiceProviderCrud.java:L73–76](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L73-L76)
- `catch (SQLException e)` in `getServiceProviderConfigs`: Propagates `e`. [OracleServiceProviderCrud.java:L147–150](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L147-L150)
- `catch (SQLException e)` in `getServiceProviderConfigs`: Propagates `e`. [OracleServiceProviderCrud.java:L207–210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L207-L210)
- `catch (SQLException e)` in `deleteServiceProviderConfig`: Propagates `e`. [OracleServiceProviderCrud.java:L236–239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L236-L239)
- Explicit throw in `createServiceProviderConfig`: `e`. No HTTP status mapping is performed at this site. [OracleServiceProviderCrud.java:L75](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L75)
- Explicit throw in `createServiceProviderConfig`: `new HttpException("can not save or update in serverIds=" + notSavedServerIds, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)`. HTTP status is encoded in this constructor; follow servlet caller for emitted response. [OracleServiceProviderCrud.java:L78](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L78)
- Explicit throw in `getServiceProviderConfigs`: `e`. No HTTP status mapping is performed at this site. [OracleServiceProviderCrud.java:L149](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L149)
- Explicit throw in `getServiceProviderConfigs`: `e`. No HTTP status mapping is performed at this site. [OracleServiceProviderCrud.java:L209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L209)
- Explicit throw in `deleteServiceProviderConfig`: `e`. No HTTP status mapping is performed at this site. [OracleServiceProviderCrud.java:L238](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L238)

Source-observed risks/findings (not production incidents):

- Nonempty successes commit before partial-server HttpException 500; not all-or-nothing.
- Empty serverIds causes deleteCharAt(-1); invalid numeric server string throws NumberFormatException, escaping SQLException catches.

Static reproduction ideas: use an isolated schema/stub connection to force each caught SQL failure and check returned value versus committed rows; test zero-row updates, malformed/empty batch inputs and unsupported vendor where applicable. No database, transport or production test ran for this class audit; source inspection cannot establish incident occurrence.

## Logs and RCA

Active call-site inventory below reconciles exact source lines with registry-v1/all-log-point-cards.csv. Arguments/templates are literal source evidence; no configured appender is established by this file. Registry ROOT/async.log routing assumptions remain unverified until logging configuration/runtime routing is independently checked.

- [OracleServiceProviderCrud.java:L38](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L38) **WARN**, registry `ALOG-293638B8D233`; `logger.warn("An exception occurred", e)`. Trigger/RCA: Caught exception in initialize; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceProviderCrud.java:L67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L67) **ERROR**, registry `ALOG-B4B43D7048A6`; `logger.error("An exception occurred in database,createServiceProviderConfig for peerName={} , serverId={}", serviceProviderConfig.getPeerName(), serverId, e)`. Trigger/RCA: Caught exception in createServiceProviderConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceProviderCrud.java:L74](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L74) **ERROR**, registry `ALOG-FB1C1E5515A0`; `logger.error("An exception occurred in database,createServiceProviderConfig for peerName={}", serviceProviderConfig.getPeerName(), e)`. Trigger/RCA: Caught exception in createServiceProviderConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceProviderCrud.java:L148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L148) **ERROR**, registry `ALOG-D003302D7329`; `logger.error("An exception occurred in database,getServiceProviderConfigs", e)`. Trigger/RCA: Caught exception in getServiceProviderConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceProviderCrud.java:L208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L208) **ERROR**, registry `ALOG-362DEB374010`; `logger.error("An exception occurred in database,getServiceProviderConfigs", e)`. Trigger/RCA: Caught exception in getServiceProviderConfigs; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.
- [OracleServiceProviderCrud.java:L237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/impl/OracleServiceProviderCrud.java#L237) **ERROR**, registry `ALOG-A52082035121`; `logger.error("An exception occurred in database,deleteServiceProviderConfig", e)`. Trigger/RCA: Caught exception in deleteServiceProviderConfig; exception/cause fields identify failure where supplied. Read Errors for suppression/propagation.

Reconciliation: 6 active source calls, 6 registry cards for this source; all source lines match registry cards.

Triage: select pinned vendor and operation first, search exact template plus class logger and time/node, then correlate peer/message/tracker/server IDs where actually present. Check exception cause, affected rows and transaction evidence before attributing a user-visible failure. Credentials/content/URLs reside in registration/message objects or SQL; this inventory identifies only fields explicitly logged and does not authorize exporting those records. Reused generic templates and absent success logs limit correlation; no production log/sample was compared.

---

### dossier-src-com-nozha-async-server-ratelimit-baseratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/BaseRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/BaseRateLimiter.java
source_sha256: f75b4642ba0031855d5038e55586b036c5dfe8ebc95ebd2368602250c82a22c6
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# BaseRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `BaseRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:9–24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L9-L24)
Abstract createKey request contract and static delegates for config updates/deletion/enforcement.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `com.nozha.async.server.exception.HttpException` [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L3); `com.nozha.async.server.mediation.exception.MediationException` [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L4); `com.nozha.async.server.vo.rateLimit.RateLimitConfig` [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L5); `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L7)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/handler/HttpHandler.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L168) ` BaseRateLimiter.enforceRateLimit(req);`; [src/com/nozha/async/server/httpserver/RateLimitServlet.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L92) ` BaseRateLimiter.updateRateLimitConfigDto(requestConfig);`; [src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java#L5) `public class BusinessProviderServiceRateLimiter extends BaseRateLimiter {`; [src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java#L5) `public class IpProviderServiceRateLimiter extends BaseRateLimiter {`; [src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java#L5) `public class BusinessProviderRateLimiter extends BaseRateLimiter {`; [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L8) ` private static final Map<String, BaseRateLimiter> registry = new HashMap<String, BaseRateLimiter>();`; [src/com/nozha/async/server/ratelimit/IpRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java#L5) `public class IpRateLimiter extends BaseRateLimiter {`; [src/com/nozha/async/server/ratelimit/RateLimitService.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L239) ` BaseRateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(rateLimitType.getValue());`; [src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java#L5) `public class IpProviderRateLimiter extends BaseRateLimiter {`; [src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java#L5) `public class BusinessRateLimiter extends BaseRateLimiter {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public abstract String createKey(HttpServletRequest req);` | Declaration only; implementation/caller owns behavior, return values and failure handling. | [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L11) |
| `public static void updateRateLimitConfigDto(RateLimitConfig rateLimitConfig) throws HttpException` | Delegate exact operation `RateLimitService.updateRateLimitConfigDto(rateLimitConfig);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:13–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L13-L15) |
| `public static void deleteRateLimitConfig(String key)` | Delegate exact operation `RateLimitService.deleteRateLimitConfig(key);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L17-L19) |
| `public static void enforceRateLimit(HttpServletRequest req) throws MediationException` | Delegate exact operation `RateLimitService.enforceRateLimit(req);`; preserves return/exception behavior of dependency, no local catch. | [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:21–23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L21-L23) |

## Business
SOURCE_OBSERVED: Indirect request dimension selection; enforcement remains in RateLimitService.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Delegated HttpException/MediationException contracts propagate; no local validation/catch.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/handler/HttpHandler.java:168](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L168), [src/com/nozha/async/server/httpserver/RateLimitServlet.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L92), [src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java#L5), [src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java#L5), [src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java#L5), [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L8), [src/com/nozha/async/server/ratelimit/IpRateLimiter.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java#L5), [src/com/nozha/async/server/ratelimit/RateLimitService.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L239).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-businessproviderratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java
source_sha256: ae69e215dc05a3e83433d3175af9719fac55619e8276d06bdf9502652fe3266f
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessProviderRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `BusinessProviderRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L12) ` register(RateLimitType.BUSINESS_PROVIDER.getValue(), new BusinessProviderRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null business_id, provider_name; concatenate attributes in stated order separated by hyphens; no normalization. Return key. | [src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects business_id, provider_name request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L12).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-businessproviderserviceratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java
source_sha256: ce039d0dc88881ceb2d7b9b28ff0cfbaf39d83965fa0f4d5230e1d5255c686e8
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessProviderServiceRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `BusinessProviderServiceRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L13) ` register(RateLimitType.BUSINESS_PROVIDER_SERVICE.getValue(), new BusinessProviderServiceRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null business_id, provider_name, path; concatenate attributes in stated order separated by hyphens; no normalization. Return key. | [src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessProviderServiceRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects business_id, provider_name, path request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L13).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-businessratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/BusinessRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java
source_sha256: 2efed4513cdba0140869ddeecdb2888c59aa27ad97abd71bdc8e07619cfd2210
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# BusinessRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `BusinessRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L11) ` register(RateLimitType.BUSINESS.getValue(), new BusinessRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null business_id; cast sole attribute to String. Return key. | [src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BusinessRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects business_id request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L11).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ipproviderratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java
source_sha256: 44947dc1a6823ec26d2ba086852e82d8ea817a6ef8ec240b54426a8b16224bbd
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# IpProviderRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `IpProviderRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L15) ` register(RateLimitType.IP_PROVIDER.getValue(), new IpProviderRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null ip, provider_name; concatenate attributes in stated order separated by hyphens; no normalization. Return key. | [src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects ip, provider_name request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L15).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ipproviderserviceratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java
source_sha256: 979822f363f2b83ab50525a571cef33d16419fe3b19748cb651a3c9cb745821b
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# IpProviderServiceRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `IpProviderServiceRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L16) ` register(RateLimitType.IP_PROVIDER_SERVICE.getValue(), new IpProviderServiceRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null ip, provider_name, path; concatenate attributes in stated order separated by hyphens; no normalization. Return key. | [src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpProviderServiceRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects ip, provider_name, path request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L16).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ipratelimiter

<!-- source dossier: src/com/nozha/async/server/ratelimit/IpRateLimiter.md -->

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
source_path: src/com/nozha/async/server/ratelimit/IpRateLimiter.java
source_sha256: c190d3c0176733b058acb0d014f460823a25dacca70fd46b0af7b72e4d6cf20a
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java
business_approved: false
runtime_tested: false
promoted: false
---

# IpRateLimiter — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `IpRateLimiter` (class_declaration) [src/com/nozha/async/server/ratelimit/IpRateLimiter.java:5–14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java#L5-L14)
Concrete BaseRateLimiter createKey implementation (7–13).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies
No declared active fields.
Dependencies are imports (some may be unused): `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/IpRateLimiter.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java#L3)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L14) ` register(RateLimitType.IP.getValue(), new IpRateLimiter());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `@Override public String createKey(HttpServletRequest req)` | Start empty key; require non-null ip; cast sole attribute to String. Return key. | [src/com/nozha/async/server/ratelimit/IpRateLimiter.java:6–13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/IpRateLimiter.java#L6-L13) |

## Business
SOURCE_OBSERVED: Indirect quota identity: selects ip request attributes. Missing any required attribute returns empty key, so RateLimitService.enforceRateLimit skips this dimension (235–245).
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct checked error path in class; null request NPE; single-attribute variant casts String (ClassCastException for other type), composite variants concatenate via toString. Hyphen-containing values are not escaped, allowing key ambiguity.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L14).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ratelimitbusiness

<!-- source dossier: src/com/nozha/async/server/ratelimit/RateLimitBusiness.md -->

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
source_path: src/com/nozha/async/server/ratelimit/RateLimitBusiness.java
source_sha256: 195553778ea1ac4ff43098bb4cbbd6cf8c99cabb9938fdb390e2814447748a31
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitBusiness — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `RateLimitBusiness` (class_declaration) [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:26–176](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L26-L176)
Shared business block/watch state, provider-pair blocks, business directory, expiring atomic call counters and fixed async count executor. initialize reloads maps from RateLimitCrud.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Concurrent maps do not make mutable config fields/check-decrement operations atomic. New BusinessConfig count constructor uses expiry now rather than BLOCK_LIFE_TIME_MS; count may expire on next check. Directory deletion uses prefix matching, which can collide for underscore-containing IDs.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L28) |
| `businessCallsMap` | `Cache<String, AtomicInteger>` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L29) |
| `increaseBusinessCountExecutor` | `ExecutorService` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L32) |
| `businessConfigMap` | `Map<String, BusinessConfig>` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L33) |
| `businessMap` | `Map<String, String>` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L34) |
| `businessProviderConfigMap` | `Map<String, BusinessProviderConfig>` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L35) |
Dependencies are imports (some may be unused): `com.google.common.cache.Cache` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L3); `com.google.common.cache.CacheBuilder` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L4); `com.nozha.Settings` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L5); `com.nozha.async.server.exception.HttpException` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L6); `com.nozha.async.server.mediation.exception.MediationException` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L7); `com.nozha.async.server.persistance.RateLimitCrud` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L8); `com.nozha.async.server.vo.rateLimit.business.BusinessConfig` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L9); `com.nozha.async.server.vo.rateLimit.business.BusinessProviderConfig` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L10); `org.apache.http.HttpStatus` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L11); `org.jetbrains.annotations.NotNull` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L12); `org.slf4j.Logger` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L13); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L14); `java.util.List` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L16); `java.util.Map` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L17); `java.util.Objects` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L18); `java.util.concurrent.ConcurrentHashMap` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L19); `java.util.concurrent.ExecutorService` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L20); `java.util.concurrent.Executors` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L21); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L22); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L23); `java.util.stream.Collectors` [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L24)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:209](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L209) ` RateLimitBusiness.initialize();`; [src/com/nozha/async/server/httpserver/BusinessLimitServlet.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/BusinessLimitServlet.java#L40) ` RateLimitBusiness.getBusinessCallsMap().asMap().forEach((businessId, count) -> resultList.add(new GatherBusinessDto(businessId, (long) coun`; [src/com/nozha/async/server/mediation/MediatorManager.java:90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/MediatorManager.java#L90) ` RateLimitBusiness.checkBlockAndWatchBusiness((String) businessId);`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:96](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L96) ` RateLimitBusiness.validateBlockBusinessToProvider(businessId, peerName, service.getPath(), errorPage);`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:67](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L67) ` RateLimitBusiness.validateBlockBusinessToProvider(businessId, peerName, service.getPath(), errorPage);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Reload configs, provider configs and directory then log initialized. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:37–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L37-L42) |
| `public static void blockCountBusiness(String businessId, int blockCount)` | Update existing count (sets future expiry) or create new BusinessConfig with count and isBlock/watch false (expiry now); no DB write. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:44–50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L44-L50) |
| `public static void blockBusiness(String businessId)` | Persist permanent block then set/create isBlock=true config. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:52–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L52-L59) |
| `public static void unblockBusiness(String businessId)` | Persist unblock; if config exists clear isBlock and count. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:61–68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L61-L68) |
| `public static void watchBusiness(String businessId)` | Persist watch then set/create watched config. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:70–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L70-L77) |
| `public static void unwatchBusiness(String businessId)` | Persist unwatch; clear watch only if existing. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:79–84](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L79-L84) |
| `public static void checkBlockAndWatchBusiness(String businessId) throws MediationException` | If config blocked WARN, decrement then throw429; else only watched+enabled data collection submits count increment; worker errors logged and suppressed. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:86–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L86-L104) |
| `public static Cache<String, AtomicInteger> getBusinessCallsMap()` | Expose calls cache. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:106–108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L106-L108) |
| `public static List<BusinessConfig> getBlockedBusiness()` | Filter live config values by isBlock (this may clear expired counts). | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:110–112](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L110-L112) |
| `public static void validateBlockBusinessToProvider(String businessId, String provider, String uri, String errorPage) throws MediationException` | Nonempty business ID key→config; if blocked WARN/decrement, persist zero if countdown just ended; throw423 with optional error-page query. Permanent -1 does not countdown. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:114–130](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L114-L130) |
| `public static boolean hasBusinessId(String businessId)` | Business directory membership. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:132–134](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L132-L134) |
| `public static void updateBusinessProviderConfig(String businessId, long providerPeerId, String provider, int blockCount) throws HttpException` | Existing -1 cannot become positive: HttpException400. Else set/create provider block count; persist only -1 or0. New config expiry is now. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:136–148](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L136-L148) |
| `@NotNull private static String getBusinessConfigMapKey(String businessId, String provider)` | Concatenate businessId underscore provider, no escaping. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:150–153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L150-L153) |
| `public static List<BusinessProviderConfig> getBlockedBusinessProvider(String businessId)` | Return blocked provider configs optionally exact businessId filter; isBlock may mutate expiry state. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:155–161](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L155-L161) |
| `public static Map<String, String> getBusinessMap()` | Expose mutable directory. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:163–165](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L163-L165) |
| `public static void addBusiness(String businessId, String businessName)` | Put business ID/name in memory only. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:167–169](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L167-L169) |
| `public static void deleteBusiness(String businessId)` | Remove prefix-related provider configs and business config/directory; no persistence in this method. | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:171–175](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L171-L175) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: blocked business rejects 429; business-provider rejects 423 and optional redirect query destinationLockedForBusiness; watched accepted business counted only under HAS_RATE_LIMIT+HAS_BUSINESS_DATA_GATHERING. Permanent/count block configuration is distinct from token-capacity enforcement.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
updateBusinessProviderConfig rejects converting existing -1 permanent block to positive count with HttpException 400. Count worker catches Exception and logs no throwable. Null businessId can fail containsKey/isEmpty; no validation here.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `checkBlockAndWatchBusiness` | `throw new MediationException("business is blocked for businessId: " + businessId, null, 429);` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:92](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L92) |
| catch_clause / `checkBlockAndWatchBusiness` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L98) |
| throw_statement / `validateBlockBusinessToProvider` | `throw new MediationException("business is blocked for businessId: " + businessId + ", peer: " + provider + " , uri: " + uri, errorPage != null ? errorPage.concat(errorPage.contains("?") ? "&" : "?").concat("errorCode=423&message=destinationLockedForBusiness") : null , 423);` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:124](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L124) |
| throw_statement / `updateBusinessProviderConfig` | `throw new HttpException("this business is permanently blocked for this provider.unblock first then try again. businessId=" + businessId + " provider=" + provider, HttpStatus.SC_BAD_REQUEST);` | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:140](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L140) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `initialize` | `("rateLimit business initialized")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-768FE98E73FB | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L41) |
| WARN `logger` / `checkBlockAndWatchBusiness` | `("business is blocked for businessId:{}", businessId)` | TRUE (businessConfigMap.containsKey(businessId)) @87; TRUE (businessConfig.isBlock()) @89 | ALOG-043DEF9D0F56 | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L90) |
| ERROR `logger` / `checkBlockAndWatchBusiness` | `("An exception occurred in increase business count for business={} ", businessId)` | TRUE (businessConfigMap.containsKey(businessId)) @87; FALSE/else (businessConfig.isBlock()) @89; TRUE (Settings.HAS_RATE_LIMIT && Settings.HAS_BUSINESS_DATA_GATHERING && businessConfig.hasWatch()) @93; lambda/callback execution (caller scheduling described in method review); CATCH catch (Exception e) @98 | ALOG-DC61A2714DDA | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L99) |
| WARN `logger` / `validateBlockBusinessToProvider` | `("business is blocked for businessId:{} , provider: {}", businessId, provider)` | TRUE (!businessId.isEmpty()) @115; TRUE (businessProviderConfigMap.containsKey(key)) @117; TRUE (businessConfig.isBlock()) @119 | ALOG-4E4A75DCF1EA | [src/com/nozha/async/server/ratelimit/RateLimitBusiness.java:120](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitBusiness.java#L120) |
Registry reconciliation: 4 active calls, 4 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: businessCallsMap, increaseBusinessCountExecutor, businessConfigMap, businessMap, businessProviderConfigMap. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ratelimitipaddress

<!-- source dossier: src/com/nozha/async/server/ratelimit/RateLimitIpAddress.md -->

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
source_path: src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java
source_sha256: 5a63f6bd57832977cbe71c77cd5f2a1943251eb9d5dfc4d5928071aa5c8fc8d5
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitIpAddress — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `RateLimitIpAddress` (class_declaration) [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:21–114](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L21-L114)
IP allow/watch directory and config maps loaded from persistence, expiring counter cache and fixed count executor.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Atomic counts but shared mutable config/directory implementation loaded externally; block/decrement checks are compound.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L23) |
| `ipAddressCallsMap` | `Cache<String, AtomicInteger>` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L24) |
| `increaseIpCountExecutor` | `ExecutorService` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L27) |
| `ipAddressConfigMap` | `Map<String, IPAddressConfig>` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L28) |
| `ipAddressList` | `Set<String>` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L30) |
Dependencies are imports (some may be unused): `com.google.common.cache.Cache` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L3); `com.google.common.cache.CacheBuilder` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L4); `com.nozha.Settings` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L5); `com.nozha.async.server.mediation.exception.MediationException` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L6); `com.nozha.async.server.persistance.RateLimitCrud` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L7); `com.nozha.async.server.vo.rateLimit.ip.IPAddressConfig` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L8); `org.apache.activemq.artemis.utils.collections.ConcurrentHashSet` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L9); `org.slf4j.Logger` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L10); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L11); `java.util.*` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L13); `java.util.concurrent.ConcurrentHashMap` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L14); `java.util.concurrent.ExecutorService` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L15); `java.util.concurrent.Executors` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L16); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L17); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L18); `java.util.stream.Collectors` [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L19)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:210](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L210) ` RateLimitIpAddress.initialize();`; [src/com/nozha/async/server/handler/HttpHandler.java:157](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L157) ` RateLimitIpAddress.checkBlockAndWatchIpAddress(address);`; [src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/IPAddressLimitServlet.java#L37) ` RateLimitIpAddress.getIpAddressCallsMap().asMap().forEach((ip, count) -> resultList.add(new GatherIpDto(ip, (long) count.get())));`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Load config/directory and log. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:32–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L32-L36) |
| `public static void blockCountIpAddress(String ip, int blockCount)` | Existing count update; absent config only created for listed IP and uses setter to assign expiry. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:38–46](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L38-L46) |
| `public static void blockIpAddress(String ip)` | Persist block then set/create permanent boolean block. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:48–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L48-L55) |
| `public static void unblockIpAddress(String ip)` | Persist unblock then clear block/count if config exists. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:57–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L57-L64) |
| `public static void checkBlockAndWatchIpAddress(String ip) throws MediationException` | Only nonempty listed IP: existing blocked config WARN/decrement/throw429. Accepted listed IP under HAS_RATE_LIMIT submits count increment; worker Exception log/suppression. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:66–87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L66-L87) |
| `public static Cache<String, AtomicInteger> getIpAddressCallsMap()` | Expose IP calls cache. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:89–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L89-L91) |
| `public static List<IPAddressConfig> getBlockedIpAddress()` | Filter configs through expiry-sensitive isBlock. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:93–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L93-L95) |
| `public static boolean hasIpAddress(String ip)` | Check IP directory membership. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:97–99](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L97-L99) |
| `public static Set<String> getIpAddressList()` | Expose live IP directory. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:102–104](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L102-L104) |
| `public static void addIpAddress(String ip)` | Add directory item memory only. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:106–108](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L106-L108) |
| `public static void deleteIpAddress(String ip)` | Remove config and directory item memory only. | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:110–113](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L110-L113) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: block enforcement happens only for nonempty IP present in IP directory; listed blocked IP rejects429. Listed accepted IP counted when HAS_RATE_LIMIT; unlike business path no per-IP watch flag.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
MediationException ip address is blocked for ip: +ip with429 at73. Worker Exception logs IP only, hides cause. Unknown/unlisted IP bypasses block check even if config map contains it.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `checkBlockAndWatchIpAddress` | `throw new MediationException("ip address is blocked for ip: " + ip, null, 429);` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:73](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L73) |
| catch_clause / `checkBlockAndWatchIpAddress` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L81) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `initialize` | `("rateLimit ip initialized")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-616C74EB4F03 | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L35) |
| WARN `logger` / `checkBlockAndWatchIpAddress` | `("ip address is blocked for ip:{}", ip)` | TRUE (ip != null && !ip.isEmpty() && hasIpAddress(ip)) @67; TRUE (ipAddressConfigMap.containsKey(ip)) @68; TRUE (ipAddressConfig.isBlock()) @70 | ALOG-8ADFDFFE7589 | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:71](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L71) |
| ERROR `logger` / `checkBlockAndWatchIpAddress` | `("An exception occurred in increase ip address count for ip={} ", ip)` | TRUE (ip != null && !ip.isEmpty() && hasIpAddress(ip)) @67; TRUE (Settings.HAS_RATE_LIMIT) @76; lambda/callback execution (caller scheduling described in method review); CATCH catch (Exception e) @81 | ALOG-C906B0B9A938 | [src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java:82](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitIpAddress.java#L82) |
Registry reconciliation: 3 active calls, 3 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: model fields requiring consumer/emitter privacy review: ipAddressCallsMap, ipAddressConfigMap, ipAddressList. Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ratelimitservice

<!-- source dossier: src/com/nozha/async/server/ratelimit/RateLimitService.md -->

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
source_path: src/com/nozha/async/server/ratelimit/RateLimitService.java
source_sha256: 9d1118a77416d462488f53bd04e6bf1df58dfc638546a25d4ca8ebe6ebe9edef
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitService — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `RateLimitService` (class_declaration) [src/com/nozha/async/server/ratelimit/RateLimitService.java:31–252](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L31-L252)
Provider and endpoint blocks/watch counters plus type-key RateLimitConfig map. initialize loads persistence state and rate configs; rate-limit counters send configs to AsyncManager at exact threshold.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Concurrent maps and atomic counters; threshold check+reset are separate operations and multiple calls may miss/reset counts. Counter publish requires initialized rate producer. RateLimitLog uses System.nanoTime, not epoch; config.toString uses default identity (no override).
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L33) |
| `loggerJson` | `org.apache.logging.log4j.Logger` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:34](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L34) |
| `endpointCallsMap` | `Map<String, Cache<String, AtomicInteger>>` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L35) |
| `increaseServiceCountExecutor` | `ExecutorService` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:37](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L37) |
| `blockedProviders` | `Map<Long, String>` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:39](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L39) |
| `endpointConfigMap` | `Map<String, EndpointConfig>` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:40](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L40) |
| `rateLimitConfigMap` | `Map<String, RateLimitConfig>` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L41) |
Dependencies are imports (some may be unused): `com.google.common.cache.Cache` [src/com/nozha/async/server/ratelimit/RateLimitService.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L3); `com.google.common.cache.CacheBuilder` [src/com/nozha/async/server/ratelimit/RateLimitService.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L4); `com.nozha.Settings` [src/com/nozha/async/server/ratelimit/RateLimitService.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L5); `com.nozha.async.server.activemq.local.AsyncManager` [src/com/nozha/async/server/ratelimit/RateLimitService.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L6); `com.nozha.async.server.exception.HttpException` [src/com/nozha/async/server/ratelimit/RateLimitService.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L7); `com.nozha.async.server.mediation.exception.MediationException` [src/com/nozha/async/server/ratelimit/RateLimitService.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L8); `com.nozha.async.server.persistance.RateLimitCrud` [src/com/nozha/async/server/ratelimit/RateLimitService.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L9); `com.nozha.async.server.util.JsonUtil` [src/com/nozha/async/server/ratelimit/RateLimitService.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L10); `com.nozha.async.server.vo.log.RateLimitLog` [src/com/nozha/async/server/ratelimit/RateLimitService.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L11); `com.nozha.async.server.vo.rateLimit.RateLimitConfig` [src/com/nozha/async/server/ratelimit/RateLimitService.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L12); `com.nozha.async.server.vo.rateLimit.provider.EndpointConfig` [src/com/nozha/async/server/ratelimit/RateLimitService.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L13); `org.apache.http.HttpStatus` [src/com/nozha/async/server/ratelimit/RateLimitService.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L14); `org.apache.logging.log4j.LogManager` [src/com/nozha/async/server/ratelimit/RateLimitService.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L15); `org.jetbrains.annotations.NotNull` [src/com/nozha/async/server/ratelimit/RateLimitService.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L16); `org.slf4j.Logger` [src/com/nozha/async/server/ratelimit/RateLimitService.java:17](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L17); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/ratelimit/RateLimitService.java:18](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L18); `jakarta.servlet.http.HttpServletRequest` [src/com/nozha/async/server/ratelimit/RateLimitService.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L20); `java.util.List` [src/com/nozha/async/server/ratelimit/RateLimitService.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L21); `java.util.Map` [src/com/nozha/async/server/ratelimit/RateLimitService.java:22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L22); `java.util.Objects` [src/com/nozha/async/server/ratelimit/RateLimitService.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L23); `java.util.concurrent.ConcurrentHashMap` [src/com/nozha/async/server/ratelimit/RateLimitService.java:24](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L24); `java.util.concurrent.ExecutorService` [src/com/nozha/async/server/ratelimit/RateLimitService.java:25](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L25); `java.util.concurrent.Executors` [src/com/nozha/async/server/ratelimit/RateLimitService.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L26); `java.util.concurrent.TimeUnit` [src/com/nozha/async/server/ratelimit/RateLimitService.java:27](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L27); `java.util.concurrent.atomic.AtomicInteger` [src/com/nozha/async/server/ratelimit/RateLimitService.java:28](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L28); `java.util.stream.Collectors` [src/com/nozha/async/server/ratelimit/RateLimitService.java:29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L29)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:208](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L208) ` RateLimitService.initialize();`; [src/com/nozha/async/server/biz/MessageManager.java:141](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/MessageManager.java#L141) ` if (receiver != 0 && RateLimitService.isProviderBlocked(receiver)) {`; [src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java:41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ProviderRateLimitServlet.java#L41) ` resp.getWriter().write(JsonUtil.getJson(RateLimitService.getBlockedProviders()));`; [src/com/nozha/async/server/ratelimit/BaseRateLimiter.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/BaseRateLimiter.java#L14) ` RateLimitService.updateRateLimitConfigDto(rateLimitConfig);`; [src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java:35](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/activemq/ratelimit/RateLimitMessageListener.java#L35) ` RateLimitConfig inMemoryRateLimitConfig = RateLimitService.getRateLimitConfigMap(rateLimitConfig.getLimitKey());`; [src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java:98](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/hamsam/HamsamReceivingHttpMediator.java#L98) ` RateLimitService.checkBlockAndWatchService(receiverName, peerName, service.getPath(), errorPage);`; [src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java:69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java#L69) ` RateLimitService.checkBlockAndWatchService(providerName, peerName, service.getPath(), errorPage);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Load provider/endpoint/configs; insert each rate config with details log, then initialized log. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:43–51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L43-L51) |
| `public static boolean isProviderBlocked(String providerName)` | Provider-name value membership. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:53–55](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L53-L55) |
| `public static boolean isProviderBlocked(Long peerId)` | Peer-ID key membership. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:57–59](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L57-L59) |
| `public static void blockProvider(Long peerId, String providerName) throws HttpException` | Persist block then insert ID/name memory map. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:61–64](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L61-L64) |
| `public static void unblockProvider(Long peerId, String providerName)` | Remove memory first then persist unblock. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:66–69](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L66-L69) |
| `public static void watchEndPoint(String providerName, String path, boolean hasWatch)` | Add provider calls cache if watching else remove path/provider cache; update endpoint watch and persist. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:71–77](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L71-L77) |
| `public static void updateEndpointConfig(String providerName, String path, int blockCount) throws HttpException` | Existing permanent -1 cannot become positive count: throw400; set/create config; only -1 or0 persisted. New EndpointConfig expiry is now. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:79–91](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L79-L91) |
| `public static void updateEndpointConfig(String providerName, String path, boolean hasWatch, int serverId)` | Set/create endpoint watch then persist supplied serverId. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:93–102](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L93-L102) |
| `public static void addToEndpointCallsMap(String providerName)` | If absent create Guava cache with expireAfterAccess and put; non-atomic check/put. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:104–111](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L104-L111) |
| `public static void deleteFromEndpointCallsMap(String providerName, String path)` | If provider cache exists and no other path key remove provider cache; otherwise remove only target path. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:113–123](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L113-L123) |
| `public static Map<String, Cache<String, AtomicInteger>> getEndpointCallsMap()` | Expose calls map. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:126–128](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L126-L128) |
| `public static void checkBlockAndWatchService(String providerName, String peerName, String path, String errorPage) throws MediationException` | Blocked peerName-or-provider→451. Endpoint key present and blocked: WARN/decrement and persist0 when final count consumed, throw429 plus optional error redirect. Accepted watched config under flags submits path atomic increment; worker catches/logs no throwable. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:130–158](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L130-L158) |
| `@NotNull private static String getEndpointConfigMapKey(String providerName, String path)` | Join provider underscore path without escaping. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:161–164](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L161-L164) |
| `public static List<EndpointConfig> getWatchedServices(String provider)` | Filter watched configs, optional exact provider. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:166–172](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L166-L172) |
| `public static List<EndpointConfig> getBlockedServices(String provider)` | Filter blocked configs, optional provider; isBlock can clear expired count. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:174–180](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L174-L180) |
| `public static Map<Long, String> getBlockedProviders()` | Expose blocked map. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:182–184](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L182-L184) |
| `public static void removeProvider(Long peerId, String provider)` | Delete provider-prefix endpoint configs then blocked ID; no persistence call. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:186–189](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L186-L189) |
| `public static void updateRateLimitConfigDto(RateLimitConfig rateLimitConfig)` | Insert/update by limitKey. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:191–193](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L191-L193) |
| `public static void deleteRateLimitConfig(String key)` | Remove rate config. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:195–197](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L195-L197) |
| `public static RateLimitConfig getRateLimitConfigMap(String key)` | Return config or null. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:199–201](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L199-L201) |
| `public static void addToRateLimitConfigMap(String key, RateLimitConfig rateLimitConfig)` | Put rate config then INFO key/capacity/refill/expiry/threshold/time/map size. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:203–206](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L203-L206) |
| `private static void countRequestsAndSendToAsyncManager(String key, String type) throws MediationException` | If config found: permanent451, unexpired temporary429, else clear temp flag; increment count; exact threshold→reset0/send config/debug; DEBUG structured config with monotonic nanoTime and count, plus timing logs. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:208–233](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L208-L233) |
| `public static void enforceRateLimit(HttpServletRequest req) throws MediationException` | Only IS_RATE_LIMIT_ENABLE: iterate six enum types; if type enabled get factory limiter, compute request-attribute key and count only nonempty key. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:235–247](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L235-L247) |
| `private static boolean isRateLimitTypeEnabled(RateLimitType type)` | Membership in Settings.ENABLE_RATE_LIMIT_TYPES. | [src/com/nozha/async/server/ratelimit/RateLimitService.java:249–251](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L249-L251) |

## Business
SOURCE_OBSERVED: SOURCE_OBSERVED: provider block returns451; endpoint block429 with optional Too many request redirect; type-key permanent451 or temporary-before-expiry429. Missing config/key or disabled type is accepted without counting. Threshold reached resets counter and publishes config; this is source enforcement, no proof of distributed quota guarantees.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
HttpException400 rejects turning endpoint -1 into positive count. MediationException statuses451/429 are propagated; count worker catches Exception without throwable. Nullable boxed config booleans/count/threshold may cause NPE outside catches.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `updateEndpointConfig` | `throw new HttpException("this path is permanently blocked.unblock first then try again. provider=" + providerName + " path=" + path, HttpStatus.SC_BAD_REQUEST);` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L83) |
| throw_statement / `checkBlockAndWatchService` | `throw new MediationException("provider is blocked for provider:" + providerName + " path: " + path, null, 451);` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:132](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L132) |
| throw_statement / `checkBlockAndWatchService` | `throw new MediationException("Service is blocked for uri: " + path, errorPage != null ? errorPage.concat(errorPage.contains("?") ? "&" : "?").concat("errorCode=429&message=Too many request") : null , 429);` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:142](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L142) |
| catch_clause / `checkBlockAndWatchService` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:152](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L152) |
| throw_statement / `countRequestsAndSendToAsyncManager` | `throw new MediationException("provider is blocked", null, 451);` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:214](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L214) |
| throw_statement / `countRequestsAndSendToAsyncManager` | `throw new MediationException("request blocked due to rate limit", null, 429);` | [src/com/nozha/async/server/ratelimit/RateLimitService.java:218](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L218) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `initialize` | `("rateLimit service initialized")` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-80CC3DEFBDD1 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L50) |
| WARN `logger` / `checkBlockAndWatchService` | `("service is blocked for providerName:{} , uri: {}", providerName, path)` | TRUE (endpointConfigMap.containsKey(key)) @135; TRUE (endpointConfig.isBlock()) @137 | ALOG-50392F78AA51 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:138](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L138) |
| ERROR `logger` / `checkBlockAndWatchService` | `("An exception occurred in increase service count for provider={} , uri={} ", providerName, path)` | TRUE (endpointConfigMap.containsKey(key)) @135; FALSE/else (endpointConfig.isBlock()) @137; TRUE (Settings.HAS_RATE_LIMIT && Settings.HAS_PROVIDER_DATA_GATHERING && endpointConfig.hasWatch()) @145; lambda/callback execution (caller scheduling described in method review); CATCH catch (Exception e) @152 | ALOG-8CDE8F02B8D4 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:153](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L153) |
| INFO `logger` / `addToRateLimitConfigMap` | `("Added/Updated rate limit config with key={}, capacity={}, refillInterval={}, expireTime={}, maxCount={}, now={} map size is: {}", key, rateLimitConfig.getCapacity(), rateLimitConfig.getRefillInterval(), rateLimitConfig.getExpireTime(), rateLimitConfig.getCountThreshold(), System.currentTimeMillis(), rateLimitConfigMap.size())` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-6728F4E4BF2E | [src/com/nozha/async/server/ratelimit/RateLimitService.java:205](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L205) |
| INFO `logger` / `countRequestsAndSendToAsyncManager` | `("provider is blocked for type={}, key={}", type, key)` | TRUE (config != null) @211; TRUE (config.getPermanentBlock()) @212 | ALOG-FE9AA774D2CC | [src/com/nozha/async/server/ratelimit/RateLimitService.java:213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L213) |
| INFO `logger` / `countRequestsAndSendToAsyncManager` | `("Request blocked due to rate limit: type={}, key={}", type, key)` | TRUE (config != null) @211; TRUE (config.getTemporarilyBlock() && System.currentTimeMillis() < config.getExpireTime()) @216 | ALOG-B21406E5E09A | [src/com/nozha/async/server/ratelimit/RateLimitService.java:217](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L217) |
| DEBUG `logger` / `countRequestsAndSendToAsyncManager` | `("send in async count = {}, reference = {}, time = {} ms", count, config, System.currentTimeMillis() - beforeSend)` | TRUE (config != null) @211; TRUE (count == config.getCountThreshold()) @223 | ALOG-601C04CB13F9 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:227](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L227) |
| DEBUG `loggerJson` / `countRequestsAndSendToAsyncManager` | `(new RateLimitLog(config.toString(), JsonUtil.getJson(config), System.nanoTime(), count))` | TRUE (config != null) @211 | ALOG-F71D4CF12110 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:229](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L229) |
| DEBUG `logger` / `countRequestsAndSendToAsyncManager` | `("count is = {} and reference = {}", count, config)` | TRUE (config != null) @211 | ALOG-70F095ABEF26 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:230](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L230) |
| DEBUG `logger` / `countRequestsAndSendToAsyncManager` | `("countRequestsAndSendToAsyncManager time = {} ms", System.currentTimeMillis() - start)` | TRUE (config != null) @211 | ALOG-9A0E992B5363 | [src/com/nozha/async/server/ratelimit/RateLimitService.java:231](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L231) |
Registry reconciliation: 10 active calls, 10 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ratelimittype

<!-- source dossier: src/com/nozha/async/server/ratelimit/RateLimitType.md -->

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
source_path: src/com/nozha/async/server/ratelimit/RateLimitType.java
source_sha256: 97ee13aff11aabbee1d7ad0a59c9c6d6e9cb2b27eb71d1205e8b717dcb9460b6
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitType.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitType — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `RateLimitType` (enum_declaration) [src/com/nozha/async/server/ratelimit/RateLimitType.java:3–20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitType.java#L3-L20)
Enum mapping six rate dimensions to lowercase wire strings (4–9).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.

### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `value` | `String` | [src/com/nozha/async/server/ratelimit/RateLimitType.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitType.java#L11) |
Dependencies are imports (some may be unused): 
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/httpserver/RateLimitServlet.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L129) ` if (rateLimitConfig.getType().equalsIgnoreCase(RateLimitType.BUSINESS.getValue())) {`; [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L11) ` register(RateLimitType.BUSINESS.getValue(), new BusinessRateLimiter());`; [src/com/nozha/async/server/ratelimit/RateLimitService.java:237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L237) ` for (RateLimitType rateLimitType : RateLimitType.values()) {`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `RateLimitType(String value)` | Assign this.value = value. No validation or copying. | [src/com/nozha/async/server/ratelimit/RateLimitType.java:13–15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitType.java#L13-L15) |
| `public String getValue()` | Return stored value/reference: value. No validation or copying. | [src/com/nozha/async/server/ratelimit/RateLimitType.java:17–19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitType.java#L17-L19) |

## Business
SOURCE_OBSERVED: Indirect contract used for enabled-type matching and factory registrations.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
No direct error path in class; invalid string handling occurs in RateLimiterFactory.
### Exact declared throw/catch sites
No active direct throw/catch statement. Exceptions from constructors/dependencies/input misuse, where present, are documented in method review.
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/httpserver/RateLimitServlet.java:129](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/RateLimitServlet.java#L129), [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L11), [src/com/nozha/async/server/ratelimit/RateLimitService.java:237](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L237).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-ratelimiterfactory

<!-- source dossier: src/com/nozha/async/server/ratelimit/RateLimiterFactory.md -->

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
source_path: src/com/nozha/async/server/ratelimit/RateLimiterFactory.java
source_sha256: 855583c81a74da70c2c469f6e71d528e1a2950df8ef1d30ea43015b9b4c1156e
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimiterFactory — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit`. Types: `RateLimiterFactory` (class_declaration) [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:6–30](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L6-L30)
Static HashMap registry preinstalls six concrete limiters (10–17), public register permits replacement.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
HashMap writes/read after initialization not synchronized.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `registry` | `Map<String, BaseRateLimiter>` | [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L8) |
Dependencies are imports (some may be unused): `java.util.HashMap` [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L3); `java.util.Map` [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L4)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/RateLimitService.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L239) ` BaseRateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(rateLimitType.getValue());`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void register(String type, BaseRateLimiter limiter)` | Put/replaces arbitrary type→limiter, no validation. | [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:19–21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L19-L21) |
| `public static BaseRateLimiter getRateLimiter(String type)` | Lookup type, throw exact IllegalArgumentException if null, otherwise return. | [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:23–29](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L23-L29) |

## Business
SOURCE_OBSERVED: Indirect dimension selection for configured rate enforcement.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Missing type throws IllegalArgumentException No RateLimiter registered for type: +type (26), propagates. Null registered limiter also treated missing.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| throw_statement / `getRateLimiter` | `throw new IllegalArgumentException("No RateLimiter registered for type: " + type);` | [src/com/nozha/async/server/ratelimit/RateLimiterFactory.java:26](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimiterFactory.java#L26) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.
**NO_LOG_IN_CLASS**. Logger declarations, DTO names and commented calls do not constitute active log emission. Class-name references to inspect for caller observability (not necessarily emission sites): [src/com/nozha/async/server/ratelimit/RateLimitService.java:239](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L239).
Registry reconciliation: 0 active calls, 0 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-kafka-ratelimitkafkamanager

<!-- source dossier: src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.md -->

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
source_path: src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java
source_sha256: ddb126e83c42370c8104a7e3ef279205ebcb7eb8c9612f0e8d53a18a1ad8cf57
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitKafkaManager — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit.kafka`. Types: `RateLimitKafkaManager` (class_declaration) [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:12–42](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L12-L42)
Fixed executor plus BlockingQueueMap of producers; initialize fills producer IDs 0..count-1.
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
Pool constructor receives producer count as wait interval, not send timeout; acquire uses configured wall-clock deadline but its wait interval may overshoot. No executor shutdown here.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:13](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L13) |
| `kafkaProducers` | `BlockingQueueMap<Long, RateLimitKafkaProducer>` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L14) |
| `sendMessageExecutor` | `ExecutorService` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L15) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L3); `com.nozha.async.server.util.BlockingQueueMap` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L4); `com.nozha.async.server.vo.rateLimit.RateLimitDto` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L5); `org.slf4j.Logger` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L6); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L7); `java.util.concurrent.ExecutorService` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L9); `java.util.concurrent.Executors` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L10)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/Server.java:213](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L213) ` RateLimitKafkaManager.initialize();`; [src/com/nozha/async/server/handler/HttpHandler.java:436](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L436) ` RateLimitKafkaManager.sendMessage((String) provider, path, client.getAddress(), (String) businessId, startTime);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public static void initialize()` | Construct producer per configured count and put ID into pool. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:18–22](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L18-L22) |
| `public static void sendMessage(RateLimitDto message)` | Submit async worker; timed acquire; if non-null send and then release ID; null silently no-op; catch Exception ERROR. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:24–36](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L24-L36) |
| `public static void sendMessage(String provider, String path, String address, String businessId, long startTime)` | Build RateLimitDto with provider/path/address-as-origin/businessId/current epoch and current-start elapsed; submit using DTO overload. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:38–41](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L38-L41) |

## Business
SOURCE_OBSERVED: Asynchronous rate/anomaly telemetry submission. Request caller returns before worker sends; acquisition timeout silently drops telemetry when null.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Worker catch Exception logs full cause but release is not in finally; acquisition runtime error or unsuppressed producer failure may leak producer. Producer.sendMessage itself suppresses its own Exception.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `sendMessage` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:32](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L32) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| ERROR `logger` / `sendMessage` | `("An exception occurred in send message to kafka ", e)` | lambda/callback execution (caller scheduling described in method review); CATCH catch (Exception e) @32 | ALOG-9529970796E0 | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:33](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L33) |
Registry reconciliation: 1 active calls, 1 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.

---

### dossier-src-com-nozha-async-server-ratelimit-kafka-ratelimitkafkaproducer

<!-- source dossier: src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.md -->

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
source_path: src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java
source_sha256: d7034fd16aa37fcd3265a003d2f69ffa9cfdd5c989ba9ee32bd1275061dba62c
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java
business_approved: false
runtime_tested: false
promoted: false
---

# RateLimitKafkaProducer — per-file candidate dossier

## Technical
Package: `com.nozha.async.server.ratelimit.kafka`. Types: `RateLimitKafkaProducer` (class_declaration) [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:18–95](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L18-L95)
Kafka client built from static Settings properties; ACKS=0, SASL_PLAINTEXT/SCRAM-SHA-256 and configured retries/backoffs (25–43).
Ownership: first-party namespace for com.nozha types; default-package samples/helper ownership is unconfirmed. Header author comments are historical attribution, not current accountable owner.
flush waits after async sends; never closes producer here. Credentials are assembled in JAAS string but not directly printed by this class.
### Data/state and dependencies

| Field(s) | Type | Evidence |
|---|---|---|
| `logger` | `Logger` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:19](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L19) |
| `producer` | `KafkaProducer<String, String>` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:20](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L20) |
| `id` | `Long` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:21](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L21) |
| `configProperties` | `Properties` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:23](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L23) |
Dependencies are imports (some may be unused): `com.nozha.Settings` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:3](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L3); `com.nozha.async.server.util.JsonUtil` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:4](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L4); `com.nozha.async.server.vo.rateLimit.RateLimitDto` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:5](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L5); `org.apache.kafka.clients.CommonClientConfigs` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:6](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L6); `org.apache.kafka.clients.producer.*` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:7](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L7); `org.apache.kafka.common.config.SaslConfigs` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:8](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L8); `org.apache.kafka.common.security.auth.SecurityProtocol` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:9](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L9); `org.apache.kafka.common.serialization.StringSerializer` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:10](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L10); `org.slf4j.Logger` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:11](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L11); `org.slf4j.LoggerFactory` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:12](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L12); `java.util.ArrayList` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L14); `java.util.Arrays` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:15](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L15); `java.util.Properties` [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:16](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L16)
Representative source references (lexical uses, not a dynamic call graph): [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java:14](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaManager.java#L14) ` static BlockingQueueMap<Long, RateLimitKafkaProducer> kafkaProducers = new BlockingQueueMap<>(Settings.RATE_LIMIT_KAFKA_PRODUCER_COUNT);`
### Method review

| Method/signature | Source-observed behavior | Evidence |
|---|---|---|
| `public RateLimitKafkaProducer(Long id)` | Assign ID, instantiate KafkaProducer; INFO constructed; Exception ERROR/suppressed. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:45–53](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L45-L53) |
| `public void sendMessage(RateLimitDto message)` | Serialize DTO once; send path-topic record; callback logs exception or metadata. If businessId nonempty send business-topic with analogous callback; flush; catch Exception ERROR including full JSON. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:56–90](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L56-L90) |
| `@Override public void onCompletion(RecordMetadata recordMetadata, Exception exception)` | Path callback failure WARN producer/topic/path/message/exception; success INFO metadata topic/partition/offset/timestamp. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:62–70](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L62-L70) |
| `@Override public void onCompletion(RecordMetadata recordMetadata, Exception exception)` | Business callback failure WARN businessId; success INFO metadata. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:75–83](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L75-L83) |
| `public Long getId()` | Return producer ID. | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:92–94](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L92-L94) |

## Business
SOURCE_OBSERVED: Telemetry sends path-topic record keyed path and optional business-topic record keyed nonempty businessId. Callback success does not prove broker durable acknowledgment with ACKS=0.
Actor/preconditions/effects are restricted to the observed methods above. For data carriers, the class itself has no independent admission or pricing policy; referenced callers supply decisions. APPROVED_INTENT: not supplied. Runtime/SLA evidence: not established by static review.

## Errors
Constructor suppresses Exception, possibly null producer. Send catches Exception and logs json full content/cause; callbacks WARN exception or INFO metadata; no explicit application retry beyond client configuration.
### Exact declared throw/catch sites

| Kind/method | Exact source statement/header | Evidence |
|---|---|---|
| catch_clause / `RateLimitKafkaProducer` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:50](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L50) |
| catch_clause / `sendMessage` | `} catch (Exception e) {` | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:87](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L87) |
Static reproduction: exercise each branch listed in the method review with absent/null input, configured flags, dependency failures and concurrent callers as applicable; assert returns/state/exception mapping, then inspect listed diagnostics. No runtime test was executed by this dossier author; inferred source risks are not production incidents.

## Logs and RCA
Every active logger call below is reconciled by source path/line with existing registry. Registry metadata remains candidate evidence; no assertion of production appender/routing.

| Severity/logger and method | Exact template/object + arguments | Trigger (source-reviewed branch polarity) | Registry | Evidence |
|---|---|---|---|---|
| INFO `logger` / `RateLimitKafkaProducer` | `("Kafka Producer for id={} , server={} Connected", id, Settings.SERVER_ID)` | Method/initializer invocation reaches this statement; no local conditional guard. | ALOG-2854DE9826C8 | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:49](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L49) |
| ERROR `logger` / `RateLimitKafkaProducer` | `("Exception in initialize rate limit Kafka Producer for id={} , server={}", id, Settings.SERVER_ID, e)` | CATCH catch (Exception e) @50 | ALOG-1E0D4C11311E | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:51](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L51) |
| WARN `logger` / `onCompletion` | `("error sending message to kafka. kafka producer={} ,topic={} ,path={} ,exceptionMessage={} ", id, Settings.RATE_LIMIT_PATH_TOPIC, message.getPath(), exception.getMessage(), exception)` | TRUE (exception != null) @64 | ALOG-F060B974E8C0 | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:65–66](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L65-L66) |
| INFO `logger` / `onCompletion` | `("path topic message sent to kafka successfully, topic={}, partition={}, offset={}, time={}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp())` | FALSE/else (exception != null) @64 | ALOG-2D40F8B9C270 | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:68](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L68) |
| WARN `logger` / `onCompletion` | `("error sending message to kafka. kafka producer={} ,topic={} ,businessId={} ,exceptionMessage={} ", id, Settings.RATE_LIMIT_BUSINESS_TOPIC, message.getBusinessId(), exception.getMessage(), exception)` | TRUE (message.getBusinessId() != null && !message.getBusinessId().isEmpty()) @72; TRUE (exception != null) @77 | ALOG-E2EBE8ADB21B | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:78–79](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L78-L79) |
| INFO `logger` / `onCompletion` | `("business topic message sent to kafka successfully, topic={}, partition={}, offset={}, time={}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp())` | TRUE (message.getBusinessId() != null && !message.getBusinessId().isEmpty()) @72; FALSE/else (exception != null) @77 | ALOG-3FD41B637573 | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:81](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L81) |
| ERROR `logger` / `sendMessage` | `("Exception in send message to kafka. producer id={} ,jsonMessage={} ", id, json, e)` | CATCH catch (Exception e) @87 | ALOG-C1442C57AA2C | [src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java:88](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/kafka/RateLimitKafkaProducer.java#L88) |
Registry reconciliation: 7 active calls, 7 joined registry IDs. No unmatched existing per-class registry rows.
Privacy/correlation: Exact emitted argument expressions above determine exposure; identity/IP/URI/business/key/body/token fields are sensitive when present, exception messages may include input. No universal request-ID propagation or redaction is evidenced by class declaration alone. Join explicit messageId/trackerId/uuid/ARN/ARNStep/peerId/businessId/serverId when actually logged; timestamps/host/thread are secondary context, not a unique join key.
RCA: search exact template or structured logType and level within a bounded host/time window; identify the listed method/true-or-else/catch path, then follow dependencies and companion caller logs. A catch log proves that branch was entered, not that recovery succeeded. An INFO after API return proves only that return; a before-send record proves attempted stage, and an after-send record does not replace recipient ACK. Absence of a record may be log-level/routing/sampling/no-log path; require runtime config/log samples to conclude outage or silence.
Reuse existing cross-class material: [registry](../../../../generated-knowledge/observability/registry-v1/all-log-point-cards.csv), [source logging semantics](../../../../generated-knowledge/observability/source-logging-semantics.md), [message delivery flow](../../../../generated-knowledge/flows/message-delivery-flow.md); these candidate documents are not independently promoted by this dossier.
