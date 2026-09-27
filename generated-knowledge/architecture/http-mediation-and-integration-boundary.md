---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/MediatorManager.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/generic/GenericReceivingHttpMediator.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/generic/GenericSendingHttpMediator.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/mediation/generic/ServiceDefinitionProvider.java
  - https://github.com/eabbasiyan-maker/Async-Source/blob/main/src/com/nozha/async/server/handler/ServiceCallProxy.java
evidence_refs: []
---

# HTTP Mediation and Integration Boundary

## Status and scope

This is candidate knowledge based on direct source inspection of the current `main` snapshot in `eabbasiyan-maker/Async-Source`. It records implementation observations only. It does not establish an approved product contract, production enablement, or a general capability guarantee. Specialized mediation paths may differ from the generic path described here.

## Verified from source: generic HTTP-to-Async message mediation

For a registered REST provider, the generic receiving mediator:

1. Resolves the incoming URI and HTTP method against a service definition loaded from a Swagger/OpenAPI-style JSON descriptor.
2. Selects the destination peer/provider and applies the configured service path, timeout, and applicable blocking/rate checks.
3. Extracts the HTTP method, service URI, request body, parameters, and selected headers into a `GenericRequest`.
4. Serializes that object into a `MessageVO`, then places it in a `MessageWrapperVO` for Async delivery.

Evidence:
- `GenericReceivingHttpMediator.mediate`: resolves service and destination, then creates the message wrapper.
- `generateGenericRequest`: copies method, URI, body, parameters, and headers into the generic request.
- `ServiceDefinitionProvider.getService`: matches URI and method against provider service definitions.

This is a real **HTTP request adaptation / envelope conversion**: an HTTP request is represented in Async's message structure and routed to a peer.

## Verified from source: response mediation

The generic sending mediator reads a `GenericResponse` from the returned client message and applies its status code, headers, and body to the HTTP response. It does not establish a general response-mapping engine.

Evidence:
- `GenericSendingHttpMediator.mediate`.

## Boundary: payload field transformation

In the generic HTTP path, the body is extracted as a string and assigned to `GenericRequest.body`. The reviewed code does not show a generic, configurable field-mapping step that changes a payload such as `first_name` into `name`.

This statement is limited to the generic mediator. Async also contains specialized mediators and a dedicated Service Call proxy; these may perform endpoint-specific handling. Their existence must not be generalized into arbitrary payload transformation for every service.

## Boundary: multi-step integration workflows

`MediatorManager` executes the mediator objects in a `MediateChain`. The generic chain is selected in code by receiver and configured special cases (Hamsam, Notification, or generic/default mediation). The reviewed paths do not show a general user-defined workflow model for composing arbitrary transformation, branching, and calls to multiple services in sequence.

A dedicated `ServiceCallProxy` constructs a fixed JSON request from specific request parameters and sends it to a configured endpoint. This is a specific proxy/integration path, not evidence of a general-purpose orchestration engine.

## Recommended capability wording

For a product comparison matrix, split the broad label “message transformation and integration flow” into:

| Capability | Async source evidence |
|---|---|
| Adapt HTTP requests to Async's internal message envelope and route them to a peer | Verified in generic mediation code |
| Transform payload fields between different service contracts | Not established for the generic path; specialized endpoint-specific logic exists |
| Define and execute arbitrary multi-step service workflows | Not found in the reviewed source paths |

Do not mark the second item as a universal absence across all specialized code without a broader source audit. Do not mark the third as a formal product limitation without validating the intended product scope with the service owner.

## Evidence locations

- `GenericReceivingHttpMediator.mediate` and `generateGenericRequest`
- `GenericSendingHttpMediator.mediate`
- `ServiceDefinitionProvider.getService`
- `MediatorManager.mediate`, `getHttpMediatorsForReceive`, `getHttpMediatorsForSend`
- `ServiceCallProxy.handleDoServiceCall`, `createRequest`, `sendRequest`
