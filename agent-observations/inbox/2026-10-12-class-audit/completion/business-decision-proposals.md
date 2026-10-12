---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: source-observed-recommendations-not-approved
truth_type: source-observed
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
business_approved: false
runtime_tested: false
promoted: false
---

# Proposed baselines for open Async business decisions

These proposals turn the 11 code observations into reviewable choices. They are recommendations only: no row is an approved product/security/operations rule until the named owner records a decision and acceptance evidence. The CSV is the decision source of record.

## Suggested disposition

- **Delivery and persistence (BD-01–05):** define externally observable states and failure behavior before promising delivery or durability. In particular, never document an asynchronous write as durable merely because a task was submitted.
- **Identity and administration (BD-06–07):** fail closed when authentication is absent or inactive; document which identity and role are accepted on each route.
- **HTTP contracts (BD-08–09):** use stable status/body semantics, with explicit compatibility handling for existing consumers.
- **Privacy and configuration (BD-10–11):** default to minimal sensitive logging; make effective environment-specific flags and owners visible at startup.

## Required owner action

For each BD row, the accountable owner should either accept the recommendation, replace it with the intended rule, or mark it not applicable. Then attach an approved contract/policy and its test evidence, record approver/date/version, and update relevant knowledge through the human-reviewed promotion path. Until then retain `PROPOSAL_FOR_OWNER_REVIEW`.
