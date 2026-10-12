# Async Java class dossiers — candidate batch 21


---

<!-- source dossier: src/org/springframework/util/comparator/BooleanComparator.md -->

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
source_path: src/org/springframework/util/comparator/BooleanComparator.java
source_refs:
  - "src/org/springframework/util/comparator/BooleanComparator.java:1-87"
owner: REQUIRES_HUMAN_VALIDATION
---

# BooleanComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/BooleanComparator.java:1–87`.

TRUE_LOW/TRUE_HIGH singletons store immutable trueLow flag. compare uses XOR: equal Boolean values return zero; otherwise returns -1/+1 according to trueLow (`src/org/springframework/util/comparator/BooleanComparator.java:38–67`). equals/hash/toString reflect ordering setting (`src/org/springframework/util/comparator/BooleanComparator.java:72–84`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/BooleanComparator.java:60` `public BooleanComparator(boolean trueLow) {`
- `src/org/springframework/util/comparator/BooleanComparator.java:66` `public int compare(Boolean v1, Boolean v2) {`
- `src/org/springframework/util/comparator/BooleanComparator.java:72` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/util/comparator/BooleanComparator.java:78` `public int hashCode() {`
- `src/org/springframework/util/comparator/BooleanComparator.java:83` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch; Boolean auto-unboxing causes NullPointerException for null input. No null policy except use NullSafeComparator.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/BooleanComparator.java:1–87` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/ComparableComparator.md -->

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
source_path: src/org/springframework/util/comparator/ComparableComparator.java
source_refs:
  - "src/org/springframework/util/comparator/ComparableComparator.java:1-46"
owner: REQUIRES_HUMAN_VALIDATION
---

# ComparableComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/ComparableComparator.java:1–46`.

Shared raw INSTANCE plus generic compare forwarding directly to o1.compareTo(o2) (`src/org/springframework/util/comparator/ComparableComparator.java:31–43`); no state/secondary tie-break or null handling.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/ComparableComparator.java:42` `public int compare(T o1, T o2) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/comparator/Comparators.java:36`; `src/org/springframework/util/comparator/NullSafeComparator.java:74`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch. Null first operand or incompatible Comparable input/delegate exceptions propagate.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/ComparableComparator.java:1–46` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/Comparators.md -->

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
source_path: src/org/springframework/util/comparator/Comparators.java
source_refs:
  - "src/org/springframework/util/comparator/Comparators.java:1-77"
owner: REQUIRES_HUMAN_VALIDATION
---

# Comparators

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/Comparators.java:1–77`.

comparable returns shared ComparableComparator; nullsLow/nullsHigh overloads return shared natural comparators or new NullSafeComparator wrapping supplied ordering (`src/org/springframework/util/comparator/Comparators.java:35–74`). No sorting is performed; caller applies comparator.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/Comparators.java:35` `public static <T> Comparator<T> comparable() {`
- `src/org/springframework/util/comparator/Comparators.java:45` `public static <T> Comparator<T> nullsLow() {`
- `src/org/springframework/util/comparator/Comparators.java:54` `public static <T> Comparator<T> nullsLow(Comparator<T> comparator) {`
- `src/org/springframework/util/comparator/Comparators.java:64` `public static <T> Comparator<T> nullsHigh() {`
- `src/org/springframework/util/comparator/Comparators.java:73` `public static <T> Comparator<T> nullsHigh(Comparator<T> comparator) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/comparator/CompoundComparator.java:69`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No local throws/catches; wrapped comparator constructor rejects null and compare delegates nonnull input exceptions.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/Comparators.java:1–77` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/CompoundComparator.md -->

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
source_path: src/org/springframework/util/comparator/CompoundComparator.java
source_refs:
  - "src/org/springframework/util/comparator/CompoundComparator.java:1-206"
owner: REQUIRES_HUMAN_VALIDATION
---

# CompoundComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/CompoundComparator.java:1–206`.

Deprecated mutable ordered list of InvertibleComparator delegates (`src/org/springframework/util/comparator/CompoundComparator.java:46–58`). Varargs constructor validates array then adds wrappers; add/set preserve existing invertible objects or wrap; indexed overload configures ascending (`src/org/springframework/util/comparator/CompoundComparator.java:68–129`). invertOrder all/index and setAscending/Descending mutate delegates; count returns size (`src/org/springframework/util/comparator/CompoundComparator.java:136–170`). compare requires nonempty list and returns first nonzero comparator result, otherwise zero (`src/org/springframework/util/comparator/CompoundComparator.java:176–185`). Equality/hash/string follow ordered delegates. No synchronization/copying of delegate state.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/CompoundComparator.java:56` `public CompoundComparator() {`
- `src/org/springframework/util/comparator/CompoundComparator.java:68` `public CompoundComparator(Comparator... comparators) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:85` `public void addComparator(Comparator<? extends T> comparator) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:100` `public void addComparator(Comparator<? extends T> comparator, boolean ascending) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:113` `public void setComparator(int index, Comparator<? extends T> comparator) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:128` `public void setComparator(int index, Comparator<T> comparator, boolean ascending) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:136` `public void invertOrder() {`
- `src/org/springframework/util/comparator/CompoundComparator.java:146` `public void invertOrder(int index) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:154` `public void setAscendingOrder(int index) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:162` `public void setDescendingOrder(int index) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:169` `public int getComparatorCount() {`
- `src/org/springframework/util/comparator/CompoundComparator.java:176` `public int compare(T o1, T o2) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:191` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/util/comparator/CompoundComparator.java:197` `public int hashCode() {`
- `src/org/springframework/util/comparator/CompoundComparator.java:202` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert rejects null array, underlying InvertibleComparator rejects null delegates; compare empty list fails IllegalStateException. Invalid index, delegate compare errors and concurrent mutation propagate.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/comparator/CompoundComparator.java:69–69` `Assert.notNull(comparators, "Comparators must not be null");`
- `src/org/springframework/util/comparator/CompoundComparator.java:177–178` `Assert.state(!this.comparators.isEmpty(), "No sort definitions have been added to this CompoundComparator to compare");`

Candidate source risk, not production incident: Shared invertible delegate mutation affects all holders; comparator mutation during sort is unsafe without caller coordination.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/CompoundComparator.java:1–206` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/InstanceComparator.md -->

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
source_path: src/org/springframework/util/comparator/InstanceComparator.java
source_refs:
  - "src/org/springframework/util/comparator/InstanceComparator.java:1-73"
owner: REQUIRES_HUMAN_VALIDATION
---

# InstanceComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/InstanceComparator.java:1–73`.

Constructor stores provided Class array without copy, validates array nonnull (`src/org/springframework/util/comparator/InstanceComparator.java:49–51`). getOrder scans first matching isInstance class; null or no match ranks array.length. compare uses Integer.compare of ranks, so unmatched/null objects tie (`src/org/springframework/util/comparator/InstanceComparator.java:56–70`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/InstanceComparator.java:49` `public InstanceComparator(Class<?>... instanceOrder) {`
- `src/org/springframework/util/comparator/InstanceComparator.java:56` `public int compare(T o1, T o2) {`
- `src/org/springframework/util/comparator/InstanceComparator.java:62` `private int getOrder(@Nullable T object) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch; Assert rejects null array; null entries NPE during scan. External array mutation changes ordering.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/comparator/InstanceComparator.java:50–50` `Assert.notNull(instanceOrder, "'instanceOrder' array must not be null");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/InstanceComparator.java:1–73` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/InvertibleComparator.md -->

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
source_path: src/org/springframework/util/comparator/InvertibleComparator.java
source_refs:
  - "src/org/springframework/util/comparator/InvertibleComparator.java:1-133"
owner: REQUIRES_HUMAN_VALIDATION
---

# InvertibleComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/InvertibleComparator.java:1–133`.

Deprecated wrapper validates/stores delegate and mutable ascending flag (`src/org/springframework/util/comparator/InvertibleComparator.java:51–88`). compare forwards then negates nonzero result when descending, special-casing Integer.MIN_VALUE to MAX_VALUE to avoid overflow (`src/org/springframework/util/comparator/InvertibleComparator.java:93–107`). equals includes delegate/order; hash only delegate; string shows flag (`src/org/springframework/util/comparator/InvertibleComparator.java:112–130`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/InvertibleComparator.java:51` `public InvertibleComparator(Comparator<T> comparator) {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:62` `public InvertibleComparator(Comparator<T> comparator, boolean ascending) {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:72` `public void setAscending(boolean ascending) {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:79` `public boolean isAscending() {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:87` `public void invertOrder() {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:93` `public int compare(T o1, T o2) {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:112` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:124` `public int hashCode() {`
- `src/org/springframework/util/comparator/InvertibleComparator.java:129` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/comparator/CompoundComparator.java:48,86,87,90,101,114,115,118,129,137,179`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert rejects null delegate; downstream comparator exceptions propagate. No catch/retry; mutable order is not synchronized.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/comparator/InvertibleComparator.java:52–52` `Assert.notNull(comparator, "Comparator must not be null");`
- `src/org/springframework/util/comparator/InvertibleComparator.java:63–63` `Assert.notNull(comparator, "Comparator must not be null");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/InvertibleComparator.java:1–133` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/comparator/NullSafeComparator.md -->

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
source_path: src/org/springframework/util/comparator/NullSafeComparator.java
source_refs:
  - "src/org/springframework/util/comparator/NullSafeComparator.java:1-133"
owner: REQUIRES_HUMAN_VALIDATION
---

# NullSafeComparator

## Technical

SOURCE_OBSERVED — package `org.springframework.util.comparator`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/comparator/NullSafeComparator.java:1–133`.

Shared natural NULLS_LOW/HIGH and constructor-supplied comparator are immutable references/settings (`src/org/springframework/util/comparator/NullSafeComparator.java:42–90`). compare identity (including two nulls) returns zero, one null orders according to nullsLow, two nonnull delegate (`src/org/springframework/util/comparator/NullSafeComparator.java:95–105`). Equality/hash/string include null direction.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/comparator/NullSafeComparator.java:73` `private NullSafeComparator(boolean nullsLow) {`
- `src/org/springframework/util/comparator/NullSafeComparator.java:87` `public NullSafeComparator(Comparator<T> comparator, boolean nullsLow) {`
- `src/org/springframework/util/comparator/NullSafeComparator.java:95` `public int compare(@Nullable T o1, @Nullable T o2) {`
- `src/org/springframework/util/comparator/NullSafeComparator.java:111` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/util/comparator/NullSafeComparator.java:123` `public int hashCode() {`
- `src/org/springframework/util/comparator/NullSafeComparator.java:128` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/comparator/Comparators.java:46,55,65,74`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Constructor Assert requires nonnull comparator; nonnull delegate errors propagate. Null input handled as normal ordering.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/comparator/NullSafeComparator.java:88–88` `Assert.notNull(comparator, "Non-null Comparator is required");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/comparator/NullSafeComparator.java:1–133` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.md -->

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
source_path: src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java
source_refs:
  - "src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:1-107"
owner: REQUIRES_HUMAN_VALIDATION
---

# CompletableToListenableFutureAdapter

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:1–107`.

Constructors accept CompletionStage converted to CompletableFuture or direct CompletableFuture; whenComplete sends exception/result to callback registry (`src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:45–61`). addCallback delegates registry; completable returns original future. cancel/isCancelled/isDone/get/timed get all forward (`src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:66–104`). Registry determines synchronization/callback swallowing; no executor selected here.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:45` `public CompletableToListenableFutureAdapter(CompletionStage<T> completionStage) {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:52` `public CompletableToListenableFutureAdapter(CompletableFuture<T> completableFuture) {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:66` `public void addCallback(ListenableFutureCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:71` `public void addCallback(SuccessCallback<? super T> successCallback, FailureCallback failureCallback) {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:77` `public CompletableFuture<T> completable() {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:83` `public boolean cancel(boolean mayInterruptIfRunning) {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:88` `public boolean isCancelled() {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:93` `public boolean isDone() {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:98` `public T get() throws InterruptedException, ExecutionException {`
- `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:103` `public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — get propagates InterruptedException, ExecutionException, timed TimeoutException, and cancellation. Completion errors remain Throwable delivered unchanged to registry; null inputs NPE, no validation. No retry/status mapping.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:1–107` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/DelegatingCompletableFuture.md -->

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
source_path: src/org/springframework/util/concurrent/DelegatingCompletableFuture.java
source_refs:
  - "src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:1-50"
owner: REQUIRES_HUMAN_VALIDATION
---

# DelegatingCompletableFuture

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:1–50`.

Package-private CompletableFuture holds validated Future delegate (`src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:37–39`). cancel invokes delegate.cancel, then super.cancel, returns delegate result (`src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:44–47`); delegate refusal and adapter cancellation may therefore differ.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:37` `public DelegatingCompletableFuture(Future<T> delegate) {`
- `src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:44` `public boolean cancel(boolean mayInterruptIfRunning) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/ListenableFuture.java:57`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:72`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert rejects null delegate. Delegate cancel exceptions abort before super cancellation; no catch/retry.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:38–38` `Assert.notNull(delegate, "Delegate must not be null");`

Candidate source risk, not production incident: Wrapper can become cancelled even when delegate.cancel returns false; caller must not infer underlying cancellation from wrapper state.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/DelegatingCompletableFuture.java:1–50` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/FailureCallback.md -->

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
source_path: src/org/springframework/util/concurrent/FailureCallback.java
source_refs:
  - "src/org/springframework/util/concurrent/FailureCallback.java:1-35"
owner: REQUIRES_HUMAN_VALIDATION
---

# FailureCallback

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/FailureCallback.java:1–35`.

Functional interface onFailure(Throwable) represents notification only (`src/org/springframework/util/concurrent/FailureCallback.java:25–33`); it does not catch, log, retry, map status or require nonnull cause itself.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:71`; `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:52`; `src/org/springframework/util/concurrent/SettableListenableFuture.java:80`; `src/org/springframework/util/concurrent/ListenableFuture.java:49`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:65`; `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:41,83,117,156`; `src/org/springframework/util/concurrent/ListenableFutureCallback.java:28`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/FailureCallback.java:1–35` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/FutureAdapter.md -->

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
source_path: src/org/springframework/util/concurrent/FutureAdapter.java
source_refs:
  - "src/org/springframework/util/concurrent/FutureAdapter.java:1-137"
owner: REQUIRES_HUMAN_VALIDATION
---

# FutureAdapter

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/FutureAdapter.java:1–137`.

Stores validated adaptee, result/state NEW/SUCCESS/FAILURE, mutex (`src/org/springframework/util/concurrent/FutureAdapter.java:39–55`). Status/cancel forward; get/timed get first obtain delegate then adaptInternal (`src/org/springframework/util/concurrent/FutureAdapter.java:67–90`). Under mutex adaptInternal caches first successful adapted result including null, or cached ExecutionException; adapt ExecutionException is retained, any other Throwable wrapped in ExecutionException; later calls return/throw cached result (`src/org/springframework/util/concurrent/FutureAdapter.java:95–125`). abstract adapt implements conversion; conversion runs while holding mutex.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/FutureAdapter.java:53` `protected FutureAdapter(Future<S> adaptee) {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:62` `protected Future<S> getAdaptee() {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:67` `public boolean cancel(boolean mayInterruptIfRunning) {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:72` `public boolean isCancelled() {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:77` `public boolean isDone() {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:83` `public T get() throws InterruptedException, ExecutionException {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:89` `public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:95` `final T adaptInternal(S adapteeResult) throws ExecutionException {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:132` `protected abstract T adapt(S adapteeResult) throws ExecutionException;`

Nested private State enum defines NEW, SUCCESS, FAILURE (`src/org/springframework/util/concurrent/FutureAdapter.java:135`). It discriminates this adapter's conversion cache, not delegate Future status: NEW permits adapt under mutex; SUCCESS means cached converted value (possibly null); FAILURE means cached ExecutionException. adaptInternal alone assigns terminal state and retains failure cause for future callers (`src/org/springframework/util/concurrent/FutureAdapter.java:95–125`).

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:35`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — get declares InterruptedException/ExecutionException/TimeoutException from delegate. Adapt failure retained; invariant Assert requires ExecutionException in FAILURE; invalid state IllegalStateException. All Throwable including Errors wrapped during adapt, no recovery.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/FutureAdapter.java:54–54` `Assert.notNull(adaptee, "Delegate must not be null");`
- `src/org/springframework/util/concurrent/FutureAdapter.java:101–101` `Assert.state(this.result instanceof ExecutionException, "Failure without exception");`
- `src/org/springframework/util/concurrent/FutureAdapter.java:102–102` `throw (ExecutionException) this.result;`
- `src/org/springframework/util/concurrent/FutureAdapter.java:110–110` `catch (ExecutionException ex) {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:113–113` `throw ex;`
- `src/org/springframework/util/concurrent/FutureAdapter.java:115–115` `catch (Throwable ex) {`
- `src/org/springframework/util/concurrent/FutureAdapter.java:119–119` `throw execEx;`
- `src/org/springframework/util/concurrent/FutureAdapter.java:122–122` `throw new IllegalStateException();`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/FutureAdapter.java:1–137` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/ListenableFuture.md -->

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
source_path: src/org/springframework/util/concurrent/ListenableFuture.java
source_refs:
  - "src/org/springframework/util/concurrent/ListenableFuture.java:1-62"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListenableFuture

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/ListenableFuture.java:1–62`.

Extends Future with combined/split callback registration (`src/org/springframework/util/concurrent/ListenableFuture.java:35–49`); default completable creates DelegatingCompletableFuture and wires complete/completeExceptionally (`src/org/springframework/util/concurrent/ListenableFuture.java:56–59`). No executor, callback ordering or scheduling imposed by this interface.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/ListenableFuture.java:56` `default CompletableFuture<T> completable() {`

Both addCallback overloads are abstract registration contracts with no bodies: addCallback(ListenableFutureCallback<? super T>) registers one object handling both outcomes, while addCallback(SuccessCallback<? super T>, FailureCallback) accepts separate handlers for lambda use (`src/org/springframework/util/concurrent/ListenableFuture.java:41–49`). Implementations own storage/invocation; the default completable() uses the split overload, success → complete(value), failure → completeExceptionally(cause) (`src/org/springframework/util/concurrent/ListenableFuture.java:56–59`). No execution thread, callback ordering or exception suppression is supplied by these declarations.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:34`; `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:35,41,53`; `src/org/springframework/util/concurrent/SettableListenableFuture.java:40`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:33`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in interface; failure callback completes bridge exceptionally, cancel delegates through wrapper. Implementation dictates callback exceptions.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/ListenableFuture.java:1–62` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/ListenableFutureAdapter.md -->

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
source_path: src/org/springframework/util/concurrent/ListenableFutureAdapter.java
source_refs:
  - "src/org/springframework/util/concurrent/ListenableFutureAdapter.java:1-81"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListenableFutureAdapter

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:1–81`.

Extends FutureAdapter and casts stored ListenableFuture for callback registration (`src/org/springframework/util/concurrent/ListenableFutureAdapter.java:41–54`). Combined callback splits into itself. onSuccess skips adapt for null, otherwise adaptInternal; unwraps ExecutionException cause if present or routes Throwable to failure, then calls supplied success with adapted value (`src/org/springframework/util/concurrent/ListenableFutureAdapter.java:56–76`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:41` `protected ListenableFutureAdapter(ListenableFuture<S> adaptee) {`
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:47` `public void addCallback(final ListenableFutureCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:52` `public void addCallback(final SuccessCallback<? super T> successCallback, final FailureCallback failureCallback) {`
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:56` `public void onSuccess(@Nullable S result) {`
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:75` `public void onFailure(Throwable ex) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Conversion failures route failure callback; success/failure callback throws are not locally caught. Null adaptee result bypasses conversion, unlike FutureAdapter.get; investigate consistency for null-sensitive adapt functions.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:62–62` `catch (ExecutionException ex) {`
- `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:67–67` `catch (Throwable ex) {`

Candidate source risk, not production incident: Callbacks bypass adaptation for null while get invokes adapt(null), creating potential differing views of same result.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:1–81` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/ListenableFutureCallback.md -->

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
source_path: src/org/springframework/util/concurrent/ListenableFutureCallback.java
source_refs:
  - "src/org/springframework/util/concurrent/ListenableFutureCallback.java:1-30"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListenableFutureCallback

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/ListenableFutureCallback.java:1–30`.

Combined marker interface extends SuccessCallback<T> and FailureCallback (28); inherits success nullable result and failure Throwable methods, no additional logic/state.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:66`; `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:47,54`; `src/org/springframework/util/concurrent/SettableListenableFuture.java:75`; `src/org/springframework/util/concurrent/ListenableFuture.java:41`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:60`; `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:55`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/ListenableFutureCallback.java:1–30` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.md -->

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
source_path: src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java
source_refs:
  - "src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:1-166"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListenableFutureCallbackRegistry

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:1–166`.

Stores success/failure queues, result, NEW/SUCCESS/FAILURE state and mutex (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:39–48`). add methods validate callback and under lock either queue NEW or immediately invoke matching completed branch (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:55–128`). notifySuccess/notifyFailure execute user callback while lock held and swallow every Throwable; failure asserts Throwable result (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:74–90`). success/failure update result/state then drain matching queue (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:136–159`); opposite queue is retained and terminal transitions are not guarded.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:55` `public void addCallback(ListenableFutureCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:74` `private void notifySuccess(SuccessCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:83` `private void notifyFailure(FailureCallback callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:98` `public void addSuccessCallback(SuccessCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:117` `public void addFailureCallback(FailureCallback callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:136` `public void success(@Nullable T result) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:152` `public void failure(Throwable ex) {`

Nested private State enum defines NEW, SUCCESS, FAILURE (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:164`). It selects queue-vs-immediate notification during registration and interpretation of stored Object result. success/failure set state before draining matching callbacks under mutex; no enum transition guard makes terminal states final, so direct later calls can overwrite them (`src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:55–69,136–159`).

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:38`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:35`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Callback Throwables silently swallowed. Assert null-callback and failure invariant errors are not swallowed in notifyFailure before try. No one-shot guard: direct repeated completion can overwrite result/state.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:56–56` `Assert.notNull(callback, "'callback' must not be null");`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:78–78` `catch (Throwable ex) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:84–84` `Assert.state(this.result instanceof Throwable, "No Throwable result for failure state");`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:88–88` `catch (Throwable ex) {`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:99–99` `Assert.notNull(callback, "'callback' must not be null");`
- `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:118–118` `Assert.notNull(callback, "'callback' must not be null");`

Candidate source risk, not production incident: Callback failures invisible; invocation under mutex may block registration/completion; registry retains opposite callbacks after completion.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:1–166` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/ListenableFutureTask.md -->

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
source_path: src/org/springframework/util/concurrent/ListenableFutureTask.java
source_refs:
  - "src/org/springframework/util/concurrent/ListenableFutureTask.java:1-103"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListenableFutureTask

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/ListenableFutureTask.java:1–103`.

FutureTask subclass registers callback registry; constructors accept Callable or Runnable+nullable result (`src/org/springframework/util/concurrent/ListenableFutureTask.java:43–56`). addCallback/completable bridge registry and delegation (`src/org/springframework/util/concurrent/ListenableFutureTask.java:60–75`). done obtains get result, notifies success; interruption restores interrupt and returns without notification; ExecutionException unwraps cause else uses itself; all other Throwable (including cancellation) routes failure (`src/org/springframework/util/concurrent/ListenableFutureTask.java:80–100`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:43` `public ListenableFutureTask(Callable<T> callable) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:54` `public ListenableFutureTask(Runnable runnable, @Nullable T result) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:60` `public void addCallback(ListenableFutureCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:65` `public void addCallback(SuccessCallback<? super T> successCallback, FailureCallback failureCallback) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:71` `public CompletableFuture<T> completable() {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:80` `protected void done() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/SettableListenableFuture.java:149`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Interrupted done returns without completing callback bridge; execution/cancellation failures notify registry, which suppresses callback throws. No timeout/retry here; timed get inherited.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:87–87` `catch (InterruptedException ex) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:91–91` `catch (ExecutionException ex) {`
- `src/org/springframework/util/concurrent/ListenableFutureTask.java:97–97` `catch (Throwable ex) {`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/ListenableFutureTask.java:1–103` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/SettableListenableFuture.md -->

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
source_path: src/org/springframework/util/concurrent/SettableListenableFuture.java
source_refs:
  - "src/org/springframework/util/concurrent/SettableListenableFuture.java:1-189"
owner: REQUIRES_HUMAN_VALIDATION
---

# SettableListenableFuture

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/SettableListenableFuture.java:1–189`.

Manual future backed by SettableTask with dummy Callable that must never run (`src/org/springframework/util/concurrent/SettableListenableFuture.java:42–47`). set/setException use FutureTask protected setters; setException validates cause, returns whether this call completed (`src/org/springframework/util/concurrent/SettableListenableFuture.java:57–70`). Callback/get/status/completable forward; cancel calls protected no-op interruptTask only if cancellation succeeds and interruption requested (`src/org/springframework/util/concurrent/SettableListenableFuture.java:75–146`). Inner done records volatile completingThread for noncancelled completion, invokes inherited notifications; checkCompletingThread accepts only first caller-thread match and clears marker (`src/org/springframework/util/concurrent/SettableListenableFuture.java:149–186`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:57` `public boolean set(@Nullable T value) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:68` `public boolean setException(Throwable exception) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:75` `public void addCallback(ListenableFutureCallback<? super T> callback) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:80` `public void addCallback(SuccessCallback<? super T> successCallback, FailureCallback failureCallback) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:85` `public CompletableFuture<T> completable() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:91` `public boolean cancel(boolean mayInterruptIfRunning) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:100` `public boolean isCancelled() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:105` `public boolean isDone() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:119` `public T get() throws InterruptedException, ExecutionException {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:135` `public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:145` `protected void interruptTask() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:155` `public SettableTask() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:159` `public boolean setResultValue(@Nullable T value) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:164` `public boolean setExceptionResult(Throwable exception) {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:170` `protected void done() {`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:180` `private boolean checkCompletingThread() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Dummy callable IllegalStateException if ever executed; Assert rejects null exception. get propagates interruption/execution/timeouts/cancellation. interruptTask default does no external task interrupt; terminal set returns false rather than throwing.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:43–43` `throw new IllegalStateException("Should never be called");`
- `src/org/springframework/util/concurrent/SettableListenableFuture.java:69–69` `Assert.notNull(exception, "Exception must not be null");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/SettableListenableFuture.java:1–189` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/concurrent/SuccessCallback.md -->

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
source_path: src/org/springframework/util/concurrent/SuccessCallback.java
source_refs:
  - "src/org/springframework/util/concurrent/SuccessCallback.java:1-38"
owner: REQUIRES_HUMAN_VALIDATION
---

# SuccessCallback

## Technical

SOURCE_OBSERVED — package `org.springframework.util.concurrent`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/concurrent/SuccessCallback.java:1–38`.

Functional interface onSuccess nullable result (`src/org/springframework/util/concurrent/SuccessCallback.java:28–36`); notification has no scheduling, validation or error handling.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/concurrent/CompletableToListenableFutureAdapter.java:71`; `src/org/springframework/util/concurrent/ListenableFutureAdapter.java:52`; `src/org/springframework/util/concurrent/SettableListenableFuture.java:80`; `src/org/springframework/util/concurrent/ListenableFuture.java:49`; `src/org/springframework/util/concurrent/ListenableFutureTask.java:65`; `src/org/springframework/util/concurrent/ListenableFutureCallbackRegistry.java:39,74,98,140`; `src/org/springframework/util/concurrent/ListenableFutureCallback.java:28`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class: no explicit throw/catch/assert or recovery logic. Validation, callback failures and native/delegate runtime exceptions belong to consuming implementations; caller evidence is in Business. No HTTP/business status translation is implemented here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/concurrent/SuccessCallback.java:1–38` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/function/SingletonSupplier.md -->

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
source_path: src/org/springframework/util/function/SingletonSupplier.java
source_refs:
  - "src/org/springframework/util/function/SingletonSupplier.java:1-159"
owner: REQUIRES_HUMAN_VALIDATION
---

# SingletonSupplier

## Technical

SOURCE_OBSERVED — package `org.springframework.util.function`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/function/SingletonSupplier.java:1–159`.

Stores nullable instance/default suppliers and volatile cached instance (`src/org/springframework/util/function/SingletonSupplier.java:39–81`). get uses double-checked synchronization, invokes instance supplier then default if null, caches result; null cache triggers recomputation on every later get (`src/org/springframework/util/function/SingletonSupplier.java:90–106`). obtain asserts nonnull (`src/org/springframework/util/function/SingletonSupplier.java:114–117`). of overload wraps instance/supplier; ofNullable returns null for null supplied object (`src/org/springframework/util/function/SingletonSupplier.java:126–156`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/function/SingletonSupplier.java:55` `public SingletonSupplier(@Nullable T instance, Supplier<? extends T> defaultSupplier) {`
- `src/org/springframework/util/function/SingletonSupplier.java:67` `public SingletonSupplier(@Nullable Supplier<? extends T> instanceSupplier, Supplier<? extends T> defaultSupplier) {`
- `src/org/springframework/util/function/SingletonSupplier.java:72` `private SingletonSupplier(Supplier<? extends T> supplier) {`
- `src/org/springframework/util/function/SingletonSupplier.java:77` `private SingletonSupplier(T singletonInstance) {`
- `src/org/springframework/util/function/SingletonSupplier.java:90` `public T get() {`
- `src/org/springframework/util/function/SingletonSupplier.java:114` `public T obtain() {`
- `src/org/springframework/util/function/SingletonSupplier.java:126` `public static <T> SingletonSupplier<T> of(T instance) {`
- `src/org/springframework/util/function/SingletonSupplier.java:136` `public static <T> SingletonSupplier<T> ofNullable(@Nullable T instance) {`
- `src/org/springframework/util/function/SingletonSupplier.java:145` `public static <T> SingletonSupplier<T> of(Supplier<T> supplier) {`
- `src/org/springframework/util/function/SingletonSupplier.java:155` `public static <T> SingletonSupplier<T> ofNullable(@Nullable Supplier<T> supplier) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Supplier throws propagate and cache stays uninitialized; obtain IllegalStateException No instance from Supplier. Null-producing suppliers repeat side effects.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/function/SingletonSupplier.java:116–116` `Assert.state(instance != null, "No instance from Supplier");`

Candidate source risk, not production incident: Null is not cached as terminal result; callers expecting exactly-once supplier execution need nonnull value.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/function/SingletonSupplier.java:1–159` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/function/SupplierUtils.md -->

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
source_path: src/org/springframework/util/function/SupplierUtils.java
source_refs:
  - "src/org/springframework/util/function/SupplierUtils.java:1-43"
owner: REQUIRES_HUMAN_VALIDATION
---

# SupplierUtils

## Technical

SOURCE_OBSERVED — package `org.springframework.util.function`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/function/SupplierUtils.java:1–43`.

resolve returns null for null Supplier else supplier.get (`src/org/springframework/util/function/SupplierUtils.java:39–40`); no cache, synchronization or fallback.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/function/SupplierUtils.java:39` `public static <T> T resolve(@Nullable Supplier<T> supplier) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch; supplier failures propagate unchanged.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/function/SupplierUtils.java:1–43` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/unit/DataSize.md -->

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
source_path: src/org/springframework/util/unit/DataSize.java
source_refs:
  - "src/org/springframework/util/unit/DataSize.java:1-283"
owner: REQUIRES_HUMAN_VALIDATION
---

# DataSize

## Technical

SOURCE_OBSERVED — package `org.springframework.util.unit`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/unit/DataSize.java:1–283`.

Immutable Serializable bytes long with binary units 1024^1..4 (`src/org/springframework/util/unit/DataSize.java:58–80`). ofBytes stores direct; other factories/of use Math.multiplyExact; of requires unit (`src/org/springframework/util/unit/DataSize.java:89–137`). parse trims all whitespace, matches signed decimal + zero-to-two-letter suffix, defaults unit to supplied or BYTES, parses long and creates size (174–185,274–278). Negative values allowed. to unit methods divide integer toward zero; isNegative, Long.compare, byte-based equality/hash, string decimal B (`src/org/springframework/util/unit/DataSize.java:192–261`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/unit/DataSize.java:79` `private DataSize(long bytes) {`
- `src/org/springframework/util/unit/DataSize.java:89` `public static DataSize ofBytes(long bytes) {`
- `src/org/springframework/util/unit/DataSize.java:98` `public static DataSize ofKilobytes(long kilobytes) {`
- `src/org/springframework/util/unit/DataSize.java:107` `public static DataSize ofMegabytes(long megabytes) {`
- `src/org/springframework/util/unit/DataSize.java:116` `public static DataSize ofGigabytes(long gigabytes) {`
- `src/org/springframework/util/unit/DataSize.java:125` `public static DataSize ofTerabytes(long terabytes) {`
- `src/org/springframework/util/unit/DataSize.java:135` `public static DataSize of(long amount, DataUnit unit) {`
- `src/org/springframework/util/unit/DataSize.java:154` `public static DataSize parse(CharSequence text) {`
- `src/org/springframework/util/unit/DataSize.java:174` `public static DataSize parse(CharSequence text, @Nullable DataUnit defaultUnit) {`
- `src/org/springframework/util/unit/DataSize.java:192` `public boolean isNegative() {`
- `src/org/springframework/util/unit/DataSize.java:200` `public long toBytes() {`
- `src/org/springframework/util/unit/DataSize.java:208` `public long toKilobytes() {`
- `src/org/springframework/util/unit/DataSize.java:216` `public long toMegabytes() {`
- `src/org/springframework/util/unit/DataSize.java:224` `public long toGigabytes() {`
- `src/org/springframework/util/unit/DataSize.java:232` `public long toTerabytes() {`
- `src/org/springframework/util/unit/DataSize.java:237` `public int compareTo(DataSize other) {`
- `src/org/springframework/util/unit/DataSize.java:242` `public String toString() {`
- `src/org/springframework/util/unit/DataSize.java:248` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/util/unit/DataSize.java:260` `public int hashCode() {`
- `src/org/springframework/util/unit/DataSize.java:276` `private static DataUnit determineDataUnit(String suffix, @Nullable DataUnit defaultUnit) {`

Nested static DataSizeUtils holds immutable compiled PATTERN requiring signed decimal digits followed by zero-to-two ASCII letters (`src/org/springframework/util/unit/DataSize.java:269–274`). determineDataUnit(suffix, defaultUnit) chooses supplied default or BYTES only when suffix has no length; a nonempty suffix invokes exact-case DataUnit.fromSuffix and can reject unknown suffix (`src/org/springframework/util/unit/DataSize.java:276–278`). It has no mutable parsing cursor or cache; DataSize.parse creates its own Matcher, trims whitespace and wraps resulting conversion failures (`src/org/springframework/util/unit/DataSize.java:174–185`).

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/unit/DataUnit.java:47,52,57,62,67,72,75,80`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Overflow factories ArithmeticException; parse wraps all caught Exception in IllegalArgumentException quoting original text with cause; text null Assert occurs before try. Unknown suffix from DataUnit propagates then wrapped.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/unit/DataSize.java:136–136` `Assert.notNull(unit, "Unit must not be null");`
- `src/org/springframework/util/unit/DataSize.java:175–175` `Assert.notNull(text, "Text must not be null");`
- `src/org/springframework/util/unit/DataSize.java:178–178` `Assert.state(matcher.matches(), "Does not match data size pattern");`
- `src/org/springframework/util/unit/DataSize.java:183–183` `catch (Exception ex) {`
- `src/org/springframework/util/unit/DataSize.java:184–184` `throw new IllegalArgumentException("'" + text + "' is not a valid data size", ex);`

Candidate source risk, not production incident: Whitespace is removed anywhere, so parse("1 0 KB") yields 10KB rather than rejection; test configuration expectations.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/unit/DataSize.java:1–283` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/unit/DataUnit.md -->

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
source_path: src/org/springframework/util/unit/DataUnit.java
source_refs:
  - "src/org/springframework/util/unit/DataUnit.java:1-100"
owner: REQUIRES_HUMAN_VALIDATION
---

# DataUnit

## Technical

SOURCE_OBSERVED — package `org.springframework.util.unit`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/unit/DataUnit.java:1–100`.

Enum B/KB/MB/GB/TB each carries exact binary DataSize of one unit (`src/org/springframework/util/unit/DataUnit.java:47–77`). package-private size returns unit multiplier. fromSuffix loops values and compares exact case-sensitive suffix, else IllegalArgumentException (`src/org/springframework/util/unit/DataUnit.java:91–97`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/unit/DataUnit.java:91` `public static DataUnit fromSuffix(String suffix) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/unit/DataSize.java:135,174,179,276,277,278`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Unknown/null suffix fails with Unknown data unit suffix message; no fallback. Default suffix selection belongs to DataSize parser.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/unit/DataUnit.java:97–97` `throw new IllegalArgumentException("Unknown data unit suffix '" + suffix + "'");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/unit/DataUnit.java:1–100` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/AbstractStaxHandler.md -->

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
source_path: src/org/springframework/util/xml/AbstractStaxHandler.java
source_refs:
  - "src/org/springframework/util/xml/AbstractStaxHandler.java:1-276"
owner: REQUIRES_HUMAN_VALIDATION
---

# AbstractStaxHandler

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/AbstractStaxHandler.java:1–276`.

Stateful SAX ContentHandler/LexicalHandler adapter keeps per-depth namespace-map stack and CDATA flag (`src/org/springframework/util/xml/AbstractStaxHandler.java:46–48`). startDocument resets stack; end clears it. startPrefixMapping adds current map, endPrefixMapping no-op. startElement passes QName/attributes/current mappings then pushes; end passes mappings then pops (`src/org/springframework/util/xml/AbstractStaxHandler.java:52–103`). characters builds string and selects charactersInternal or cDataInternal; whitespace, processing instructions, skipped entities, comments delegate (106–149,190–196). startDTD constructs PUBLIC/SYSTEM declaration; CDATA toggles flag, endDTD/entity callbacks no-op (`src/org/springframework/util/xml/AbstractStaxHandler.java:153–205`). toQName splits colon, namespace-declaration test recognizes xmlns, stack helpers and abstract hooks support subclasses (`src/org/springframework/util/xml/AbstractStaxHandler.java:214–274`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/AbstractStaxHandler.java:52` `public final void startDocument() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:64` `public final void endDocument() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:75` `public final void startPrefixMapping(String prefix, String uri) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:80` `public final void endPrefixMapping(String prefix) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:84` `public final void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:95` `public final void endElement(String uri, String localName, String qName) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:106` `public final void characters(char[] ch, int start, int length) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:122` `public final void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:133` `public final void processingInstruction(String target, String data) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:143` `public final void skippedEntity(String name) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:153` `public final void startDTD(String name, @Nullable String publicId, String systemId) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:176` `public final void endDTD() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:180` `public final void startCDATA() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:185` `public final void endCDATA() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:190` `public final void comment(char[] ch, int start, int length) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:200` `public void startEntity(String name) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:204` `public void endEntity(String name) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:214` `protected QName toQName(String namespaceUri, String qualifiedName) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:226` `protected boolean isNamespaceDeclaration(QName qName) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:234` `private Map<String, String> currentNamespaceMapping() {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:238` `private void newNamespaceMapping() {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:242` `private void removeNamespaceMapping() {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:246` `private void removeAllNamespaceMappings() {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:251` `protected abstract void startDocumentInternal() throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:253` `protected abstract void endDocumentInternal() throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:255` `protected abstract void startElementInternal(QName name, Attributes attributes,`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:258` `protected abstract void endElementInternal(QName name, Map<String, String> namespaceMapping)`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:261` `protected abstract void charactersInternal(String data) throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:263` `protected abstract void cDataInternal(String data) throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:265` `protected abstract void ignorableWhitespaceInternal(String data) throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:267` `protected abstract void processingInstructionInternal(String target, String data)`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:270` `protected abstract void skippedEntityInternal(String name) throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:272` `protected abstract void dtdInternal(String dtd) throws XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:274` `protected abstract void commentInternal(String comment) throws XMLStreamException;`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxStreamHandler.java:38`; `src/org/springframework/util/xml/StaxEventHandler.java:44`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Every XMLStreamException from hook is wrapped SAXException with Could not handle + callback name and cause. Namespace map mutation preceding failure is not rolled back; unbalanced callback sequence can cause index errors. No thread safety; CDATA flag is not reset in startDocument.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/AbstractStaxHandler.java:58–58` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:59–59` `throw new SAXException("Could not handle startDocument: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:69–69` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:70–70` `throw new SAXException("Could not handle endDocument: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:89–89` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:90–90` `throw new SAXException("Could not handle startElement: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:100–100` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:101–101` `throw new SAXException("Could not handle endElement: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:116–116` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:117–117` `throw new SAXException("Could not handle characters: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:126–126` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:127–128` `throw new SAXException( "Could not handle ignorableWhitespace:" + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:137–137` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:138–138` `throw new SAXException("Could not handle processingInstruction: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:147–147` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:148–148` `throw new SAXException("Could not handle skippedEntity: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:170–170` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:171–171` `throw new SAXException("Could not handle startDTD: " + ex.getMessage(), ex);`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:194–194` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxHandler.java:195–195` `throw new SAXException("Could not handle comment: " + ex.getMessage(), ex);`

Candidate source risk, not production incident: Reuse after interrupted CDATA can retain inCData; validate lifecycle if adapter reused.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/AbstractStaxHandler.java:1–276` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/AbstractStaxXMLReader.md -->

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
source_path: src/org/springframework/util/xml/AbstractStaxXMLReader.java
source_refs:
  - "src/org/springframework/util/xml/AbstractStaxXMLReader.java:1-243"
owner: REQUIRES_HUMAN_VALIDATION
---

# AbstractStaxXMLReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/AbstractStaxXMLReader.java:1–243`.

SAX features namespaces default true, namespace-prefixes false, standalone initially unavailable; get/set recognized names or delegate parent (`src/org/springframework/util/xml/AbstractStaxXMLReader.java:49–114`). toQualifiedName joins prefix/local. parse(InputSource/String) ignores argument and parses wrapped reader; XMLStreamException becomes located SAXParseException, delivered fatalError if handler else thrown (`src/org/springframework/util/xml/AbstractStaxXMLReader.java:123–178`). Prefix helpers emit only changed nonempty URI, keep LinkedHashMap and remove on end; locator adapter forwards IDs/line/column (`src/org/springframework/util/xml/AbstractStaxXMLReader.java:185–240`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:67` `public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:86` `public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:98` `protected void setStandalone(boolean standalone) {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:105` `protected boolean hasNamespacesFeature() {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:112` `protected boolean hasNamespacePrefixesFeature() {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:123` `protected String toQualifiedName(QName qName) {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:141` `public final void parse(InputSource ignored) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:152` `public final void parse(String ignored) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:156` `private void parse() throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:178` `protected abstract void parseInternal() throws SAXException, XMLStreamException;`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:185` `protected void startPrefixMapping(@Nullable String prefix, String namespace) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:201` `protected void endPrefixMapping(String prefix) throws SAXException {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:218` `public StaxLocator(Location location) {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:223` `public String getPublicId() {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:228` `public String getSystemId() {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:233` `public int getLineNumber() {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:238` `public int getColumnNumber() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxStreamXMLReader.java:46`; `src/org/springframework/util/xml/StaxEventXMLReader.java:62`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Unsupported standalone before callback SAXNotSupportedException. XML parse failure can be suppressed if supplied fatalError returns; callback SAXException propagates directly. Prefix map has no nested shadow binding stack.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:78–78` `throw new SAXNotSupportedException("startDocument() callback not completed yet");`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:160–160` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractStaxXMLReader.java:170–170` `throw saxException;`

Candidate source risk, not production incident: Nested prefix shadow restoration and swallowed fatalError need tests with concrete readers.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/AbstractStaxXMLReader.java:1–243` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/AbstractXMLEventReader.md -->

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
source_path: src/org/springframework/util/xml/AbstractXMLEventReader.java
source_refs:
  - "src/org/springframework/util/xml/AbstractXMLEventReader.java:1-79"
owner: REQUIRES_HUMAN_VALIDATION
---

# AbstractXMLEventReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/AbstractXMLEventReader.java:1–79`.

next delegates nextEvent and maps XMLStreamException to NoSuchElementException message (`src/org/springframework/util/xml/AbstractXMLEventReader.java:39–45`); remove unsupported; getProperty unsupported (`src/org/springframework/util/xml/AbstractXMLEventReader.java:49–60`). close marks boolean, checkIfClosed throws XMLStreamException if closed (`src/org/springframework/util/xml/AbstractXMLEventReader.java:64–76`). Subclasses must actually call check; no underlying stream closed by base.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:39` `public Object next() {`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:49` `public void remove() {`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:59` `public Object getProperty(String name) throws IllegalArgumentException {`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:64` `public void close() {`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:73` `protected void checkIfClosed() throws XMLStreamException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/ListBasedXMLEventReader.java:39`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Exception conversion loses cause. Unsupported remove and properties throw; closed check explicit XMLStreamException. No status/recovery.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:43–43` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:44–44` `throw new NoSuchElementException(ex.getMessage());`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:50–51` `throw new UnsupportedOperationException( "remove not supported on " + ClassUtils.getShortName(getClass()));`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:60–60` `throw new IllegalArgumentException("Property not supported: [" + name + "]");`
- `src/org/springframework/util/xml/AbstractXMLEventReader.java:75–75` `throw new XMLStreamException("XMLEventReader has been closed");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/AbstractXMLEventReader.java:1–79` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/AbstractXMLReader.md -->

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
source_path: src/org/springframework/util/xml/AbstractXMLReader.java
source_refs:
  - "src/org/springframework/util/xml/AbstractXMLReader.java:1-171"
owner: REQUIRES_HUMAN_VALIDATION
---

# AbstractXMLReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/AbstractXMLReader.java:1–171`.

Mutable SAX handler/resolver/error/lexical references with nullable getters/setters (`src/org/springframework/util/xml/AbstractXMLReader.java:44–106`). getFeature returns false for any SAX feature URI, else not recognized; setFeature permits false but true unsupported (`src/org/springframework/util/xml/AbstractXMLReader.java:116–139`). lexical-handler property getter/setter recognizes exact URI, casts supplied value; all others not recognized (`src/org/springframework/util/xml/AbstractXMLReader.java:148–168`). Does not implement concrete parsing or entity resolution.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/AbstractXMLReader.java:61` `public void setContentHandler(@Nullable ContentHandler contentHandler) {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:67` `public ContentHandler getContentHandler() {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:72` `public void setDTDHandler(@Nullable DTDHandler dtdHandler) {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:78` `public DTDHandler getDTDHandler() {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:83` `public void setEntityResolver(@Nullable EntityResolver entityResolver) {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:89` `public EntityResolver getEntityResolver() {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:94` `public void setErrorHandler(@Nullable ErrorHandler errorHandler) {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:100` `public ErrorHandler getErrorHandler() {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:105` `protected LexicalHandler getLexicalHandler() {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:116` `public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:131` `public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:148` `public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {`
- `src/org/springframework/util/xml/AbstractXMLReader.java:162` `public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/AbstractStaxXMLReader.java:47`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — SAXNotRecognizedException name for unknown feature/property; SAXNotSupportedException true feature; ClassCastException wrong lexical handler object; null name NPE. No recovery.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/AbstractXMLReader.java:121–121` `throw new SAXNotRecognizedException(name);`
- `src/org/springframework/util/xml/AbstractXMLReader.java:134–134` `throw new SAXNotSupportedException(name);`
- `src/org/springframework/util/xml/AbstractXMLReader.java:138–138` `throw new SAXNotRecognizedException(name);`
- `src/org/springframework/util/xml/AbstractXMLReader.java:153–153` `throw new SAXNotRecognizedException(name);`
- `src/org/springframework/util/xml/AbstractXMLReader.java:167–167` `throw new SAXNotRecognizedException(name);`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/AbstractXMLReader.java:1–171` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/AbstractXMLStreamReader.md -->

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
source_path: src/org/springframework/util/xml/AbstractXMLStreamReader.java
source_refs:
  - "src/org/springframework/util/xml/AbstractXMLStreamReader.java:1-204"
owner: REQUIRES_HUMAN_VALIDATION
---

# AbstractXMLStreamReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/AbstractXMLStreamReader.java:1–204`.

getElementText requires START_ELEMENT then loops events appending text/CDATA/SPACE/entity text, skips comments/PI, rejects nested element/end-document/other types (`src/org/springframework/util/xml/AbstractXMLStreamReader.java:35–64`). Attribute-name components and namespace/prefix/name/text/event predicates delegate state (`src/org/springframework/util/xml/AbstractXMLStreamReader.java:67–138`). nextTag skips whitespace/comments/PI and requires start/end element; require checks event type only, ignoring provided namespaceURI/localName (`src/org/springframework/util/xml/AbstractXMLStreamReader.java:142–160`). getAttributeValue scans name/namespace; hasNext uses END_DOCUMENT; text-copy caps length by entire source length then arraycopy (`src/org/springframework/util/xml/AbstractXMLStreamReader.java:165–201`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:35` `public String getElementText() throws XMLStreamException {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:66` `public String getAttributeLocalName(int index) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:71` `public String getAttributeNamespace(int index) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:76` `public String getAttributePrefix(int index) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:81` `public String getNamespaceURI() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:92` `public String getNamespaceURI(String prefix) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:97` `public boolean hasText() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:105` `public String getPrefix() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:116` `public boolean hasName() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:122` `public boolean isWhiteSpace() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:127` `public boolean isStartElement() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:132` `public boolean isEndElement() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:137` `public boolean isCharacters() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:142` `public int nextTag() throws XMLStreamException {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:156` `public void require(int expectedType, String namespaceURI, String localName) throws XMLStreamException {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:165` `public String getAttributeValue(@Nullable String namespaceURI, String localName) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:177` `public boolean hasNext() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:182` `public String getLocalName() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:187` `public char[] getTextCharacters() {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:192` `public int getTextCharacters(int sourceStart, char[] target, int targetStart, int length) {`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:200` `public int getTextLength() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/XMLEventStreamReader.java:44`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — XMLStreamException guards include location except require. IllegalStateException wrong namespace/prefix state. arraycopy bounds failures propagate because length cap ignores sourceStart. No recovery.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:37–37` `throw new XMLStreamException("Parser must be on START_ELEMENT to read next text", getLocation());`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:51–52` `throw new XMLStreamException("Unexpected end of document when reading element text content", getLocation());`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:55–55` `throw new XMLStreamException("Element text content may not contain START_ELEMENT", getLocation());`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:58–58` `throw new XMLStreamException("Unexpected event type " + eventType, getLocation());`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:87–87` `throw new IllegalStateException("Parser must be on START_ELEMENT or END_ELEMENT state");`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:111–111` `throw new IllegalStateException("Parser must be on START_ELEMENT or END_ELEMENT state");`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:150–150` `throw new XMLStreamException("expected start or end tag", getLocation());`
- `src/org/springframework/util/xml/AbstractXMLStreamReader.java:159–159` `throw new XMLStreamException("Expected [" + expectedType + "] but read [" + eventType + "]");`

Candidate source risk, not production incident: require does not enforce namespace/local-name; ranged text copy can overrun remaining source despite cap.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/AbstractXMLStreamReader.java:1–204` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/DomContentHandler.md -->

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
source_path: src/org/springframework/util/xml/DomContentHandler.java
source_refs:
  - "src/org/springframework/util/xml/DomContentHandler.java:1-144"
owner: REQUIRES_HUMAN_VALIDATION
---

# DomContentHandler

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/DomContentHandler.java:1–144`.

Constructed on Document or node ownerDocument; getParent uses open-element stack else root node (`src/org/springframework/util/xml/DomContentHandler.java:51–68`). startElement creates namespaced DOM element, copies attributes except any QName beginning xmlns, appends and pushes; endElement pops (`src/org/springframework/util/xml/DomContentHandler.java:72–89`). characters appends to existing last text node or creates new; processingInstruction appends PI (`src/org/springframework/util/xml/DomContentHandler.java:93–110`). Other SAX document/prefix/whitespace/entity/locator callbacks no-op (`src/org/springframework/util/xml/DomContentHandler.java:117–142`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/DomContentHandler.java:62` `private Node getParent() {`
- `src/org/springframework/util/xml/DomContentHandler.java:72` `public void startElement(String uri, String localName, String qName, Attributes attributes) {`
- `src/org/springframework/util/xml/DomContentHandler.java:88` `public void endElement(String uri, String localName, String qName) {`
- `src/org/springframework/util/xml/DomContentHandler.java:93` `public void characters(char[] ch, int start, int length) {`
- `src/org/springframework/util/xml/DomContentHandler.java:107` `public void processingInstruction(String target, String data) {`
- `src/org/springframework/util/xml/DomContentHandler.java:117` `public void setDocumentLocator(Locator locator) {`
- `src/org/springframework/util/xml/DomContentHandler.java:121` `public void startDocument() {`
- `src/org/springframework/util/xml/DomContentHandler.java:125` `public void endDocument() {`
- `src/org/springframework/util/xml/DomContentHandler.java:129` `public void startPrefixMapping(String prefix, String uri) {`
- `src/org/springframework/util/xml/DomContentHandler.java:133` `public void endPrefixMapping(String prefix) {`
- `src/org/springframework/util/xml/DomContentHandler.java:137` `public void ignorableWhitespace(char[] ch, int start, int length) {`
- `src/org/springframework/util/xml/DomContentHandler.java:141` `public void skippedEntity(String name) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/DomUtils.java:178`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch; DOMException invalid names/hierarchy propagates; unbalanced endElement IndexOutOfBoundsException. Namespace declarations and ignorable whitespace are discarded.

**No explicit throw/catch/assert statements.**

Candidate source risk, not production incident: Attribute filter startsWith xmlns also excludes similarly prefixed non-declaration names.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/DomContentHandler.java:1–144` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/DomUtils.md -->

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
source_path: src/org/springframework/util/xml/DomUtils.java
source_refs:
  - "src/org/springframework/util/xml/DomUtils.java:1-195"
owner: REQUIRES_HUMAN_VALIDATION
---

# DomUtils

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/DomUtils.java:1–195`.

Child-element helpers scan immediate child nodes only, match raw nodeName or localName and return list/first/value (`src/org/springframework/util/xml/DomUtils.java:60–136`). getTextValue accumulates direct CharacterData except Comment and EntityReference nodeValue, no recursive descendant traversal (`src/org/springframework/util/xml/DomUtils.java:148–158`). nodeNameEquals uses same matcher; createContentHandler constructs DomContentHandler (`src/org/springframework/util/xml/DomUtils.java:166–192`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/DomUtils.java:60` `public static List<Element> getChildElementsByTagName(Element ele, String... childEleNames) {`
- `src/org/springframework/util/xml/DomUtils.java:85` `public static List<Element> getChildElementsByTagName(Element ele, String childEleName) {`
- `src/org/springframework/util/xml/DomUtils.java:96` `public static Element getChildElementByTagName(Element ele, String childEleName) {`
- `src/org/springframework/util/xml/DomUtils.java:116` `public static String getChildElementValueByTagName(Element ele, String childEleName) {`
- `src/org/springframework/util/xml/DomUtils.java:126` `public static List<Element> getChildElements(Element ele) {`
- `src/org/springframework/util/xml/DomUtils.java:148` `public static String getTextValue(Element valueEle) {`
- `src/org/springframework/util/xml/DomUtils.java:166` `public static boolean nodeNameEquals(Node node, String desiredName) {`
- `src/org/springframework/util/xml/DomUtils.java:177` `public static ContentHandler createContentHandler(Node node) {`
- `src/org/springframework/util/xml/DomUtils.java:184` `private static boolean nodeNameMatch(Node node, String desiredName) {`
- `src/org/springframework/util/xml/DomUtils.java:191` `private static boolean nodeNameMatch(Node node, Collection<?> desiredNames) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert nonnull element/names/node. Missing child returns null; DOM/helper failures propagate, no status. EntityReference null nodeValue can append literal null through StringBuilder.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/DomUtils.java:61–61` `Assert.notNull(ele, "Element must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:62–62` `Assert.notNull(childEleNames, "Element names collection must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:97–97` `Assert.notNull(ele, "Element must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:98–98` `Assert.notNull(childEleName, "Element name must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:127–127` `Assert.notNull(ele, "Element must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:149–149` `Assert.notNull(valueEle, "Element must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:167–167` `Assert.notNull(node, "Node must not be null");`
- `src/org/springframework/util/xml/DomUtils.java:168–168` `Assert.notNull(desiredName, "Desired name must not be null");`

Candidate source risk, not production incident: Text extraction is shallow and excludes nested element text; consumers must select correct node depth.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/DomUtils.java:1–195` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/ListBasedXMLEventReader.md -->

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
source_path: src/org/springframework/util/xml/ListBasedXMLEventReader.java
source_refs:
  - "src/org/springframework/util/xml/ListBasedXMLEventReader.java:1-143"
owner: REQUIRES_HUMAN_VALIDATION
---

# ListBasedXMLEventReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/ListBasedXMLEventReader.java:1–143`.

Constructor validates and copies event list; cursor/currentEvent track nextEvent; hasNext checks cursor, peek returns next or null (`src/org/springframework/util/xml/ListBasedXMLEventReader.java:49–80`). getElementText checks closed/start, consumes until end and requires character events, skips ignorable whitespace (`src/org/springframework/util/xml/ListBasedXMLEventReader.java:84–104`). nextTag checks closed, skips whitespace/comment/PI, returns start/end or null on end-document, rejects unexpected events/nonwhite text (`src/org/springframework/util/xml/ListBasedXMLEventReader.java:109–134`). close sets base closed and clears events (`src/org/springframework/util/xml/ListBasedXMLEventReader.java:138–140`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:49` `public ListBasedXMLEventReader(List<XMLEvent> events) {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:56` `public boolean hasNext() {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:61` `public XMLEvent nextEvent() {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:74` `public XMLEvent peek() {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:84` `public String getElementText() throws XMLStreamException {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:109` `public XMLEvent nextTag() throws XMLStreamException {`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:138` `public void close() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:263`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Empty nextEvent NoSuchElementException; getElementText/nextTag XMLStreamException for invalid state/event; exhaustion may propagate NoSuchElementException. hasNext/peek/nextEvent do not call closed guard, but cleared list prevents next data. No recovery.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:50–50` `Assert.notNull(events, "XMLEvent List must not be null");`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:68–68` `throw new NoSuchElementException();`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:87–87` `throw new XMLStreamException("Not at START_ELEMENT: " + this.currentEvent);`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:97–97` `throw new XMLStreamException("Unexpected non-text event: " + event);`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:127–128` `throw new XMLStreamException( "Non-ignorable whitespace CDATA or CHARACTERS event: " + event);`
- `src/org/springframework/util/xml/ListBasedXMLEventReader.java:132–132` `throw new XMLStreamException("Expected START_ELEMENT or END_ELEMENT: " + event);`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/ListBasedXMLEventReader.java:1–143` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/SimpleNamespaceContext.md -->

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
source_path: src/org/springframework/util/xml/SimpleNamespaceContext.java
source_refs:
  - "src/org/springframework/util/xml/SimpleNamespaceContext.java:1-170"
owner: REQUIRES_HUMAN_VALIDATION
---

# SimpleNamespaceContext

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/SimpleNamespaceContext.java:1–170`.

Bidirectional prefix/URI maps plus separate default URI (`src/org/springframework/util/xml/SimpleNamespaceContext.java:43–47`). getNamespaceURI validates prefix, handles xml/xmlns/default specially, returns empty for unbound (`src/org/springframework/util/xml/SimpleNamespaceContext.java:51–65`). getPrefix returns first insertion-order reverse match or null; getPrefixes returns unmodifiable reverse set iterator (`src/org/springframework/util/xml/SimpleNamespaceContext.java:70–94`). setBindings binds entries; bind updates forward map and adds reverse set, default handled separately (`src/org/springframework/util/xml/SimpleNamespaceContext.java:102–130`). removeBinding deletes current mapping and empty set, default reset; clear clears both maps but leaves default URI (`src/org/springframework/util/xml/SimpleNamespaceContext.java:137–167`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:51` `public String getNamespaceURI(String prefix) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:70` `public String getPrefix(String namespaceUri) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:76` `public Iterator<String> getPrefixes(String namespaceUri) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:80` `private Set<String> getPrefixesSet(String namespaceUri) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:102` `public void setBindings(Map<String, String> bindings) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:110` `public void bindDefaultNamespaceUri(String namespaceUri) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:119` `public void bindNamespaceUri(String prefix, String namespaceUri) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:137` `public void removeBinding(@Nullable String prefix) {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:158` `public void clear() {`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:166` `public Iterator<String> getBoundPrefixes() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert prefix/URI nonnull. Null bindings map NPE. Rebinding existing prefix to new URI does not remove old reverse association; no concurrency synchronization.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:52–52` `Assert.notNull(prefix, "No prefix given");`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:81–81` `Assert.notNull(namespaceUri, "No namespaceUri given");`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:120–120` `Assert.notNull(prefix, "No prefix given");`
- `src/org/springframework/util/xml/SimpleNamespaceContext.java:121–121` `Assert.notNull(namespaceUri, "No namespaceUri given");`

Candidate source risk, not production incident: Reverse map stale after rebinding; clear leaves default namespace intact.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/SimpleNamespaceContext.java:1–170` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/SimpleSaxErrorHandler.md -->

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
source_path: src/org/springframework/util/xml/SimpleSaxErrorHandler.java
source_refs:
  - "src/org/springframework/util/xml/SimpleSaxErrorHandler.java:1-61"
owner: REQUIRES_HUMAN_VALIDATION
---

# SimpleSaxErrorHandler

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:1–61`.

Constructor stores caller-supplied Commons Log (`src/org/springframework/util/xml/SimpleSaxErrorHandler.java:41–42`). warning logs WARN with SAXParseException then returns; error and fatalError rethrow same SAXParseException (`src/org/springframework/util/xml/SimpleSaxErrorHandler.java:47–58`). No filtering/validation/status conversion.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:41` `public SimpleSaxErrorHandler(Log logger) {`
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:47` `public void warning(SAXParseException ex) throws SAXException {`
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:52` `public void error(SAXParseException ex) throws SAXException {`
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:57` `public void fatalError(SAXParseException ex) throws SAXException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Recoverable warning ignored; validation error/fatal propagated unchanged. Null logger fails on warning. This is parser-level behavior, no Async HTTP mapping.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:53–53` `throw ex;`
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:58–58` `throw ex;`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

SOURCE_OBSERVED — direct executable log inventory; registry reconciliation by source path and exact line:
- `src/org/springframework/util/xml/SimpleSaxErrorHandler.java:48` `logger.warn("Ignored XML validation warning", ex);`; registry ID `ALOG-CCF5E015D2B4`; level `WARN`, template `Ignored XML validation warning`, logged expressions `ex`.

Trigger: parser calls warning(ex); WARN ignored validation warning returns normally. Throwable passed can expose message/systemId/publicId/line/column and XML-related paths, with no request/client/trace ID fields. Error/fatal callbacks throw with no direct log. Search literal Ignored XML validation warning + parser time/host; inspect SAXParseException cause/location and calling parser configuration. Log proves callback invocation, not successful parsing or document validity.

Logger/appender: WebRTCDataChannel owns LoggerFactory class logger; XML listeners receive Commons Log externally. Registry ROOT/async.log routing is explicitly UNVERIFIED_ROUTE/assumption and is not source-proven for arbitrary supplied logger. Registry source line/template/level agrees; registry generic trigger/impact heuristics are refined above, with runtime coverage still UNKNOWN.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/SimpleTransformErrorListener.md -->

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
source_path: src/org/springframework/util/xml/SimpleTransformErrorListener.java
source_refs:
  - "src/org/springframework/util/xml/SimpleTransformErrorListener.java:1-61"
owner: REQUIRES_HUMAN_VALIDATION
---

# SimpleTransformErrorListener

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/SimpleTransformErrorListener.java:1–61`.

Constructor stores supplied Commons Log. warning logs WARN and returns; error logs ERROR and returns; fatalError throws original TransformerException (`src/org/springframework/util/xml/SimpleTransformErrorListener.java:41–58`). Severity does not determine whether transform was aborted.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:41` `public SimpleTransformErrorListener(Log logger) {`
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:47` `public void warning(TransformerException ex) throws TransformerException {`
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:52` `public void error(TransformerException ex) throws TransformerException {`
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:57` `public void fatalError(TransformerException ex) throws TransformerException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Nonfatal warning/error are deliberately not rethrown; fatal propagated unchanged. Null logger causes logging-time NPE; no retry/status.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:58–58` `throw ex;`

Candidate source risk, not production incident: ERROR message is not proof of thrown failure; method returns after logging.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

SOURCE_OBSERVED — direct executable log inventory; registry reconciliation by source path and exact line:
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:48` `logger.warn("XSLT transformation warning", ex);`; registry ID `ALOG-8BDAE155BE70`; level `WARN`, template `XSLT transformation warning`, logged expressions `ex`.
- `src/org/springframework/util/xml/SimpleTransformErrorListener.java:53` `logger.error("XSLT transformation error", ex);`; registry ID `ALOG-06F9A9947FDB`; level `ERROR`, template `XSLT transformation error`, logged expressions `ex`.

Trigger: transformer calls warning(ex) or error(ex); both return after WARN/ERROR. Throwable contains transform message/cause/locator, which may expose source paths/URIs or content fragments; no request/client/trace IDs. fatalError rethrows without direct log. Search exact XSLT transformation warning/error and correlate transform job/time through caller; inspect nested locator/cause and reproduce invalid stylesheet/input. ERROR proves callback, not aborted transformation.

Logger/appender: WebRTCDataChannel owns LoggerFactory class logger; XML listeners receive Commons Log externally. Registry ROOT/async.log routing is explicitly UNVERIFIED_ROUTE/assumption and is not source-proven for arbitrary supplied logger. Registry source line/template/level agrees; registry generic trigger/impact heuristics are refined above, with runtime coverage still UNKNOWN.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxEventHandler.md -->

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
source_path: src/org/springframework/util/xml/StaxEventHandler.java
source_refs:
  - "src/org/springframework/util/xml/StaxEventHandler.java:1-196"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxEventHandler

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxEventHandler.java:1–196`.

SAX-to-event subclass stores XMLEventFactory/newInstance and XMLEventWriter; optional factory injection (`src/org/springframework/util/xml/StaxEventHandler.java:56–69`). Locator adapter sets event factory location, forwards line/column/IDs with character offset -1 (74–78,162–193). Internal document/element/characters/CDATA/whitespace/PI/DTD/comment hooks create corresponding events and add to writer (`src/org/springframework/util/xml/StaxEventHandler.java:81–153`). Attribute helper converts QNames, skips xmlns; namespace helper creates explicit Namespace list; end element uses mappings. skippedEntity no-op (101–118,158–159).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxEventHandler.java:56` `public StaxEventHandler(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:67` `public StaxEventHandler(XMLEventWriter eventWriter, XMLEventFactory factory) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:74` `public void setDocumentLocator(@Nullable Locator locator) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:81` `protected void startDocumentInternal() throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:86` `protected void endDocumentInternal() throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:91` `protected void startElementInternal(QName name, Attributes atts,`
- `src/org/springframework/util/xml/StaxEventHandler.java:101` `private List<Namespace> getNamespaces(Map<String, String> namespaceMappings) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:108` `private List<Attribute> getAttributes(Attributes attributes) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:121` `protected void endElementInternal(QName name, Map<String, String> namespaceMapping) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:127` `protected void charactersInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:132` `protected void cDataInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:137` `protected void ignorableWhitespaceInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:142` `protected void processingInstructionInternal(String target, String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:147` `protected void dtdInternal(String dtd) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:152` `protected void commentInternal(String comment) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventHandler.java:158` `protected void skippedEntityInternal(String name) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:166` `public LocatorLocationAdapter(Locator locator) {`
- `src/org/springframework/util/xml/StaxEventHandler.java:171` `public int getLineNumber() {`
- `src/org/springframework/util/xml/StaxEventHandler.java:176` `public int getColumnNumber() {`
- `src/org/springframework/util/xml/StaxEventHandler.java:181` `public int getCharacterOffset() {`
- `src/org/springframework/util/xml/StaxEventHandler.java:186` `public String getPublicId() {`
- `src/org/springframework/util/xml/StaxEventHandler.java:191` `public String getSystemId() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:281`; `src/org/springframework/util/xml/StaxResult.java:63`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — XMLStreamException propagated to AbstractStaxHandler and wrapped SAXException with callback context. Writer/factory/null/locator failures otherwise uncaught; no flush/close done here.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxEventHandler.java:1–196` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxEventXMLReader.md -->

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
source_path: src/org/springframework/util/xml/StaxEventXMLReader.java
source_refs:
  - "src/org/springframework/util/xml/StaxEventXMLReader.java:1-348"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxEventXMLReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxEventXMLReader.java:1–348`.

Constructor peeks reader and requires start document/element, allows empty; XMLStreamException becomes IllegalStateException without cause (`src/org/springframework/util/xml/StaxEventXMLReader.java:81–91`). parseInternal iterates events with depth and synthetic document callbacks for fragment input; stops after enclosing end and fills missing end-document (`src/org/springframework/util/xml/StaxEventXMLReader.java:96–153`). Start-document exposes fixed event locator and version/encoding; start/end element use namespace flags and convert attributes (156–225,244–259,314–345). Characters choose ignorable whitespace or text and bracket CDATA; DTD/notation/entity/PI/comment forwarded only when appropriate handler exists (227–241,267–310). Namespace-prefix flag creates xmlns attributes; missing DTD type CDATA. No underlying reader close.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxEventXMLReader.java:96` `protected void parseInternal() throws SAXException, XMLStreamException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:156` `private void handleStartDocument(final XMLEvent event) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:173` `public int getColumnNumber() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:177` `public int getLineNumber() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:182` `public String getPublicId() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:187` `public String getSystemId() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:191` `public String getXMLVersion() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:196` `public String getEncoding() {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:204` `private void handleStartElement(StartElement startElement) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:227` `private void handleCharacters(Characters characters) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:244` `private void handleEndElement(EndElement endElement) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:261` `private void handleEndDocument() throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:267` `private void handleNotationDeclaration(NotationDeclaration declaration) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:273` `private void handleEntityDeclaration(EntityDeclaration entityDeclaration) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:280` `private void handleProcessingInstruction(ProcessingInstruction pi) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:286` `private void handleComment(Comment comment) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:293` `private void handleDtd(DTD dtd) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:304` `private void handleEntityReference(EntityReference reference) throws SAXException {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:314` `private Attributes getAttributes(StartElement event) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxSource.java:65`; `src/org/springframework/util/xml/StaxUtils.java:299`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Malformed state IllegalStateException; parse errors handled in base SAXParseException/fatalError; callback SAXExceptions propagate. DTD location null can NPE. No standalone setting in this subclass.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/StaxEventXMLReader.java:85–85` `throw new IllegalStateException("XMLEventReader not at start of document or element");`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:88–88` `catch (XMLStreamException ex) {`
- `src/org/springframework/util/xml/StaxEventXMLReader.java:89–89` `throw new IllegalStateException("Could not read first element: " + ex.getMessage());`

Candidate source risk, not production incident: Event-reader standalone feature remains unset; locator snapshots initial event location.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxEventXMLReader.java:1–348` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxResult.md -->

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
source_path: src/org/springframework/util/xml/StaxResult.java
source_refs:
  - "src/org/springframework/util/xml/StaxResult.java:1-124"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxResult

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxResult.java:1–124`.

SAXResult wrapper selects StaxEventHandler or StaxStreamHandler and installs both content and lexical handlers; keeps chosen writer, other getter null (`src/org/springframework/util/xml/StaxResult.java:62–103`). Setter overrides prohibit replacing handlers (`src/org/springframework/util/xml/StaxResult.java:111–121`), preserving adapter invariant.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxResult.java:62` `public StaxResult(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxResult.java:73` `public StaxResult(XMLStreamWriter streamWriter) {`
- `src/org/springframework/util/xml/StaxResult.java:89` `public XMLEventWriter getXMLEventWriter() {`
- `src/org/springframework/util/xml/StaxResult.java:101` `public XMLStreamWriter getXMLStreamWriter() {`
- `src/org/springframework/util/xml/StaxResult.java:111` `public void setHandler(ContentHandler handler) {`
- `src/org/springframework/util/xml/StaxResult.java:120` `public void setLexicalHandler(LexicalHandler handler) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:194,203,213,228,229,232,248,249,252`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — setHandler/setLexicalHandler throw UnsupportedOperationException exact method name; writer errors occur through installed handler and base wrapping; no close/flush here.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/StaxResult.java:112–112` `throw new UnsupportedOperationException("setHandler is not supported");`
- `src/org/springframework/util/xml/StaxResult.java:121–121` `throw new UnsupportedOperationException("setLexicalHandler is not supported");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxResult.java:1–124` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxSource.md -->

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
source_path: src/org/springframework/util/xml/StaxSource.java
source_refs:
  - "src/org/springframework/util/xml/StaxSource.java:1-125"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxSource

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxSource.java:1–125`.

SAXSource wrapper creates concrete event/stream XMLReader and dummy InputSource; keeps chosen reader and nullable other getter (`src/org/springframework/util/xml/StaxSource.java:64–103`). setInputSource and setXMLReader are forbidden (`src/org/springframework/util/xml/StaxSource.java:112–122`); parser consumes wrapped reader rather than dummy source.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxSource.java:112` `public void setInputSource(InputSource inputSource) {`
- `src/org/springframework/util/xml/StaxSource.java:121` `public void setXMLReader(XMLReader reader) {`

Package-private getXMLEventReader() returns eventReader reference unchanged; it is null when stream-reader constructor was selected (`src/org/springframework/util/xml/StaxSource.java:89–92`). getXMLStreamReader() analogously returns streamReader unchanged or null for the event-reader variant (`src/org/springframework/util/xml/StaxSource.java:101–104`). Getters do not consume, copy, validate, close or synchronize reader state; callers selecting wrong getter must handle null, and sharing a returned reader shares its cursor.

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:108,117,127,142,143,146,162,163,166`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Both setters UnsupportedOperationException; reader constructor rejects unsuitable state and native parse errors flow through adapter base. No source read or close here.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/StaxSource.java:113–113` `throw new UnsupportedOperationException("setInputSource is not supported");`
- `src/org/springframework/util/xml/StaxSource.java:122–122` `throw new UnsupportedOperationException("setXMLReader is not supported");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxSource.java:1–125` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxStreamHandler.md -->

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
source_path: src/org/springframework/util/xml/StaxStreamHandler.java
source_refs:
  - "src/org/springframework/util/xml/StaxStreamHandler.java:1-137"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxStreamHandler

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxStreamHandler.java:1–137`.

Stores XMLStreamWriter (`src/org/springframework/util/xml/StaxStreamHandler.java:43–44`); internal document hooks writeStart/EndDocument. startElement writes QName then each mapping writeNamespace plus setDefaultNamespace/setPrefix, then non-xmlns attributes (`src/org/springframework/util/xml/StaxStreamHandler.java:49–82`). End writes end element; character/CDATA/whitespace/PI/DTD/comment forward writer methods (`src/org/springframework/util/xml/StaxStreamHandler.java:85–116`). Locator, entity and skippedEntity are no-op (`src/org/springframework/util/xml/StaxStreamHandler.java:122–135`); no flush/close.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxStreamHandler.java:43` `public StaxStreamHandler(XMLStreamWriter streamWriter) {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:49` `protected void startDocumentInternal() throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:54` `protected void endDocumentInternal() throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:59` `protected void startElementInternal(QName name, Attributes attributes,`
- `src/org/springframework/util/xml/StaxStreamHandler.java:85` `protected void endElementInternal(QName name, Map<String, String> namespaceMapping) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:90` `protected void charactersInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:95` `protected void cDataInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:100` `protected void ignorableWhitespaceInternal(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:105` `protected void processingInstructionInternal(String target, String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:110` `protected void dtdInternal(String dtd) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:115` `protected void commentInternal(String comment) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:122` `public void setDocumentLocator(Locator locator) {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:126` `public void startEntity(String name) throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:130` `public void endEntity(String name) throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamHandler.java:134` `protected void skippedEntityInternal(String name) throws XMLStreamException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:272`; `src/org/springframework/util/xml/StaxResult.java:74`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Writer XMLStreamExceptions propagate to AbstractStaxHandler wrapping. No rollback for partially written start element/namespaces. Callback misuse/native writer errors propagate.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxStreamHandler.java:1–137` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxStreamXMLReader.md -->

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
source_path: src/org/springframework/util/xml/StaxStreamXMLReader.java
source_refs:
  - "src/org/springframework/util/xml/StaxStreamXMLReader.java:1-308"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxStreamXMLReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxStreamXMLReader.java:1–308`.

Constructor requires START_DOCUMENT/START_ELEMENT (`src/org/springframework/util/xml/StaxStreamXMLReader.java:65–70`). parseInternal uses current event, depth counter, next until end enclosing context, synthesizes document callbacks for fragment and absent end (`src/org/springframework/util/xml/StaxStreamXMLReader.java:75–132`). startDocument captures version/encoding/location and standalone only if reader sets it and content handler exists (`src/org/springframework/util/xml/StaxStreamXMLReader.java:135–180`). start/end element forwards namespaces and attributes according to features; characters brackets CDATA, comments/DTD/entities/PI emitted to relevant handlers (`src/org/springframework/util/xml/StaxStreamXMLReader.java:183–273`). Attributes normalize absent namespace/type and optionally append xmlns entries (`src/org/springframework/util/xml/StaxStreamXMLReader.java:276–305`). Reader is not closed.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:75` `protected void parseInternal() throws SAXException, XMLStreamException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:135` `private void handleStartDocument() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:149` `public int getColumnNumber() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:153` `public int getLineNumber() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:158` `public String getPublicId() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:163` `public String getSystemId() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:167` `public String getXMLVersion() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:172` `public String getEncoding() {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:183` `private void handleStartElement() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:206` `private void handleEndElement() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:225` `private void handleCharacters() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:238` `private void handleComment() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:245` `private void handleDtd() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:255` `private void handleEntityReference() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:264` `private void handleEndDocument() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:270` `private void handleProcessingInstruction() throws SAXException {`
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:276` `private Attributes getAttributes() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxSource.java:77`; `src/org/springframework/util/xml/StaxUtils.java:290`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Wrong initial event IllegalStateException text says XMLEventReader; XMLStreamExceptions become base located SAX parse error/fatal callback. SAX callbacks and DTD null-location failures uncaught.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/StaxStreamXMLReader.java:68–68` `throw new IllegalStateException("XMLEventReader not at start of document or element");`

Candidate source risk, not production incident: Standalone availability depends on installed content handler; characters does not classify SPACE as ignorableWhitespace.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxStreamXMLReader.java:1–308` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/StaxUtils.md -->

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
source_path: src/org/springframework/util/xml/StaxUtils.java
source_refs:
  - "src/org/springframework/util/xml/StaxUtils.java:1-330"
owner: REQUIRES_HUMAN_VALIDATION
---

# StaxUtils

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/StaxUtils.java:1–330`.

Defensive XMLInputFactory supplier sets SUPPORT_DTD=false, IS_SUPPORTING_EXTERNAL_ENTITIES=false and resolver returning empty InputStream (`src/org/springframework/util/xml/StaxUtils.java:56–81`); does not configure preexisting readers. Factory methods build JDK StAXSource/Result or custom SAX adapters (89–117,175–203). isStaxSource/Result recognizes both variants; getters dispatch variants and reject other type (126–168,212–254). Remaining factories construct list reader, handlers, XMLReaders, event-stream reader/writer; default event factory newFactory (`src/org/springframework/util/xml/StaxUtils.java:262–327`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/StaxUtils.java:66` `public static XMLInputFactory createDefensiveInputFactory() {`
- `src/org/springframework/util/xml/StaxUtils.java:76` `public static <T extends XMLInputFactory> T createDefensiveInputFactory(Supplier<T> instanceSupplier) {`
- `src/org/springframework/util/xml/StaxUtils.java:89` `public static Source createStaxSource(XMLStreamReader streamReader) {`
- `src/org/springframework/util/xml/StaxUtils.java:98` `public static Source createStaxSource(XMLEventReader eventReader) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxUtils.java:107` `public static Source createCustomStaxSource(XMLStreamReader streamReader) {`
- `src/org/springframework/util/xml/StaxUtils.java:116` `public static Source createCustomStaxSource(XMLEventReader eventReader) {`
- `src/org/springframework/util/xml/StaxUtils.java:126` `public static boolean isStaxSource(Source source) {`
- `src/org/springframework/util/xml/StaxUtils.java:138` `public static XMLStreamReader getXMLStreamReader(Source source) {`
- `src/org/springframework/util/xml/StaxUtils.java:158` `public static XMLEventReader getXMLEventReader(Source source) {`
- `src/org/springframework/util/xml/StaxUtils.java:175` `public static Result createStaxResult(XMLStreamWriter streamWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:184` `public static Result createStaxResult(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:193` `public static Result createCustomStaxResult(XMLStreamWriter streamWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:202` `public static Result createCustomStaxResult(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:212` `public static boolean isStaxResult(Result result) {`
- `src/org/springframework/util/xml/StaxUtils.java:224` `public static XMLStreamWriter getXMLStreamWriter(Result result) {`
- `src/org/springframework/util/xml/StaxUtils.java:244` `public static XMLEventWriter getXMLEventWriter(Result result) {`
- `src/org/springframework/util/xml/StaxUtils.java:262` `public static XMLEventReader createXMLEventReader(List<XMLEvent> events) {`
- `src/org/springframework/util/xml/StaxUtils.java:271` `public static ContentHandler createContentHandler(XMLStreamWriter streamWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:280` `public static ContentHandler createContentHandler(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:289` `public static XMLReader createXMLReader(XMLStreamReader streamReader) {`
- `src/org/springframework/util/xml/StaxUtils.java:298` `public static XMLReader createXMLReader(XMLEventReader eventReader) {`
- `src/org/springframework/util/xml/StaxUtils.java:308` `public static XMLStreamReader createEventStreamReader(XMLEventReader eventReader) throws XMLStreamException {`
- `src/org/springframework/util/xml/StaxUtils.java:317` `public static XMLStreamWriter createEventStreamWriter(XMLEventWriter eventWriter) {`
- `src/org/springframework/util/xml/StaxUtils.java:326` `public static XMLStreamWriter createEventStreamWriter(XMLEventWriter eventWriter, XMLEventFactory eventFactory) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Unsupported input-factory property may throw IllegalArgumentException; no fallback, so fail closed for unsupported provider. Getter incompatible type IllegalArgumentException quotes object. JDK source/event reader construction may XMLStreamException. No globally enforced XML security.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/StaxUtils.java:146–146` `throw new IllegalArgumentException("Source '" + source + "' is neither StaxSource nor StAXSource");`
- `src/org/springframework/util/xml/StaxUtils.java:166–166` `throw new IllegalArgumentException("Source '" + source + "' is neither StaxSource nor StAXSource");`
- `src/org/springframework/util/xml/StaxUtils.java:232–232` `throw new IllegalArgumentException("Result '" + result + "' is neither StaxResult nor StAXResult");`
- `src/org/springframework/util/xml/StaxUtils.java:252–252` `throw new IllegalArgumentException("Result '" + result + "' is neither StaxResult nor StAXResult");`

Candidate source risk, not production incident: Defensive factory protects only consumers that call it; no direct first-party usage was found.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/StaxUtils.java:1–330` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/TransformerUtils.md -->

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
source_path: src/org/springframework/util/xml/TransformerUtils.java
source_refs:
  - "src/org/springframework/util/xml/TransformerUtils.java:1-86"
owner: REQUIRES_HUMAN_VALIDATION
---

# TransformerUtils

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/TransformerUtils.java:1–86`.

enableIndenting defaults amount 2, validates transformer/amount, sets standard INDENT=yes then vendor Xalan indent-amount (`src/org/springframework/util/xml/TransformerUtils.java:49–73`). Unsupported vendor property IllegalArgumentException is ignored; standard setting remains. disableIndenting validates and sets INDENT=no (`src/org/springframework/util/xml/TransformerUtils.java:81–83`). Mutates supplied Transformer, no transformation itself.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/TransformerUtils.java:49` `public static void enableIndenting(Transformer transformer) {`
- `src/org/springframework/util/xml/TransformerUtils.java:62` `public static void enableIndenting(Transformer transformer, int indentAmount) {`
- `src/org/springframework/util/xml/TransformerUtils.java:81` `public static void disableIndenting(Transformer transformer) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert null transformer; negative indent IllegalArgumentException; standard setOutputProperty failures propagate, only Xalan property IllegalArgumentException suppressed.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/TransformerUtils.java:63–63` `Assert.notNull(transformer, "Transformer must not be null");`
- `src/org/springframework/util/xml/TransformerUtils.java:65–65` `throw new IllegalArgumentException("Invalid indent amount (must not be less than zero): " + indentAmount);`
- `src/org/springframework/util/xml/TransformerUtils.java:72–72` `catch (IllegalArgumentException ignored) {`
- `src/org/springframework/util/xml/TransformerUtils.java:82–82` `Assert.notNull(transformer, "Transformer must not be null");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/TransformerUtils.java:1–86` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/XMLEventStreamReader.md -->

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
source_path: src/org/springframework/util/xml/XMLEventStreamReader.java
source_refs:
  - "src/org/springframework/util/xml/XMLEventStreamReader.java:1-298"
owner: REQUIRES_HUMAN_VALIDATION
---

# XMLEventStreamReader

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/XMLEventStreamReader.java:1–298`.

Construct consumes first XMLEvent; next advances and returns event type, close delegates reader (51–54,277–284). getName accepts start/end element; version/standalone only start document, encoding methods always null; PI/text require appropriate event (`src/org/springframework/util/xml/XMLEventStreamReader.java:58–163`). Attribute methods require start element and count/scan iterator to requested index; namespace count/index accepts start/end, context only start; iterator counting O(n) each query (`src/org/springframework/util/xml/XMLEventStreamReader.java:168–295`). Location/property delegate; base handles text aggregation and predicates.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/XMLEventStreamReader.java:51` `public XMLEventStreamReader(XMLEventReader eventReader) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:58` `public QName getName() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:71` `public Location getLocation() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:76` `public int getEventType() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:82` `public String getVersion() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:92` `public Object getProperty(String name) throws IllegalArgumentException {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:97` `public boolean isStandalone() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:107` `public boolean standaloneSet() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:118` `public String getEncoding() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:124` `public String getCharacterEncodingScheme() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:129` `public String getPITarget() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:139` `public String getPIData() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:149` `public int getTextStart() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:154` `public String getText() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:168` `public int getAttributeCount() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:177` `public boolean isAttributeSpecified(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:182` `public QName getAttributeName(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:187` `public String getAttributeType(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:192` `public String getAttributeValue(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:197` `private Attribute getAttribute(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:216` `public NamespaceContext getNamespaceContext() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:227` `public int getNamespaceCount() {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:242` `public String getNamespacePrefix(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:247` `public String getNamespaceURI(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:252` `private Namespace getNamespace(int index) {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:277` `public int next() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:283` `public void close() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:289` `private static int countIterator(Iterator iterator) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:309`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Wrong event IllegalStateException; absent index IllegalArgumentException; reader XMLStreamException and property failure propagate. No direct catch/recovery or stale-event reset on close.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/XMLEventStreamReader.java:66–66` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:102–102` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:112–112` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:134–134` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:144–144` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:162–162` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:170–170` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:199–199` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:212–212` `throw new IllegalArgumentException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:221–221` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:236–236` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:261–261` `throw new IllegalStateException();`
- `src/org/springframework/util/xml/XMLEventStreamReader.java:273–273` `throw new IllegalArgumentException();`

Candidate source risk, not production incident: getEncoding/getCharacterEncodingScheme always null even when StartDocument has encoding metadata.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/XMLEventStreamReader.java:1–298` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.
