---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: high
verification: environment-inventory-and-test-plan-reviewed
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
business_approved: false
runtime_tested: false
promoted: false
---

# Async validation execution handoff

## Current verified execution constraints

- Available source is a Java/Maven project, but this workspace has no `mvn` executable or Maven wrapper.
- The supplied project POM declares internal dependencies/repositories; this workspace has no verified credentials or reachable application environment for them.
- No `src/test` tree was found in the supplied Async project snapshot.
- No running Async, Jetty, Oracle/MySQL, or broker integration test environment was supplied.

Therefore no Async application validation scenario is marked passed. Static dossier checks do not satisfy these tests.

## Minimum environment to start execution

1. Confirm the target source/build SHA and supported JDK/Maven versions with the Async TL.
2. Provide the approved Maven settings/credentials for required internal dependencies.
3. Provide an isolated Async test deployment/configuration, non-production DB and broker, and disposable test data.
4. Provide a controllable downstream Service Call fixture, test TLS certificates, and a captured/sanitized test logger where required.
5. For behavior whose expected result is owner-dependent, close the linked BD decision first; do not invent an expected contract in a test.

## Scenario prerequisites

| Scenario | Required execution fixture | Contract dependency |
|---|---|---|
| VT-01 TLS certificate/hostname | local HTTPS test endpoint with trusted, expired and mismatched certificates; ServiceCallProxy config | TLS failure mapping (BD-09) |
| VT-02 active-save threshold | isolated Async, controllable executor and DB state assertions | overload/persistence policy (BD-05) |
| VT-03 async worker DB exception | fault-injecting DB/JDBC fixture and task/error observation | write-failure recovery (BD-05) |
| VT-04 Oracle cleanup | disposable Oracle schema and seeded expiry/sender rows | expiry/retention semantics (BD-03) |
| VT-05 JDBC bindings | disposable MySQL and Oracle schemas; SQL trace or row assertions | query contract/schema version |
| VT-06 ACK receiver | Async plus transport clients and isolated DB; test valid/invalid sender | ACK contract (BD-01) |
| VT-07 retry boundary | controllable clock or test scheduler, DB and receiver fixture | retry policy/TTL (BD-02, BD-03) |
| VT-08 registration authentication | isolated registration routes, identity provider/auth toggles and DB | auth/role contract (BD-06) |
| VT-09 rate-limit boundaries | servlet/app runtime with controllable clock/counter and consumer assertion | response contract (BD-08) |
| VT-10 Service Call failures | downstream HTTP fixture for timeout, non-200 and connection reset | error mapping (BD-09) |
| VT-11 log masking | test appender and synthetic secret/body/query values | privacy policy (BD-10) |
| VT-12 health versus dependency outage | Async runtime and independently stoppable DB/broker | liveness/readiness contract |
| VT-13 mediator concurrency | concurrent request harness, distinct bodies/headers, deterministic barrier | request isolation behavior |
| VT-14 flags | multiple isolated startup configs and captured effective config/branch outputs | flag ownership/defaults (BD-11) |

## DoD for each run

Record scenario ID, build SHA, JDK/config profile, fixture versions, exact input/setup, expected result and its approved source, actual result, logs/state evidence, pass/fail, issue ID for failure, and rerun after a fix. Keep secrets out of evidence. Change `NOT_RUN` only after an actual execution artifact exists.
