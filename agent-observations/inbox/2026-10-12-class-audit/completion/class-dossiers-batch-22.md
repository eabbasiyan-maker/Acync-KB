# Async Java class dossiers — candidate batch 22


---

<!-- source dossier: src/org/springframework/util/xml/XMLEventStreamWriter.md -->

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
source_path: src/org/springframework/util/xml/XMLEventStreamWriter.java
source_refs:
  - "src/org/springframework/util/xml/XMLEventStreamWriter.java:1-276"
owner: REQUIRES_HUMAN_VALIDATION
---

# XMLEventStreamWriter

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/XMLEventStreamWriter.java:1–276`.

StreamWriter facade holds eventWriter/factory, stack of future EndElement and pending empty flag (`src/org/springframework/util/xml/XMLEventStreamWriter.java:43–57`). Namespace/prefix/context/flush delegate; getProperty unsupported (61–87,266–267). StartDocument defaults UTF-8 when only version passed. startElement adds StartElement then EndElement to stack; emptyElement defers closing so attributes/namespaces can still attach (`src/org/springframework/util/xml/XMLEventStreamWriter.java:92–158`). writeEndElement first closes pending empty then pops enclosing stack. Attribute events add directly; namespace reconstructs stack tail with accumulated Namespace events (`src/org/springframework/util/xml/XMLEventStreamWriter.java:161–208`). Text/CDATA/comment/PI/DTD/entity/endDocument close pending empty then add events; close closes pending empty and delegates (`src/org/springframework/util/xml/XMLEventStreamWriter.java:212–273`). No auto-close all open elements at endDocument.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:54` `public XMLEventStreamWriter(XMLEventWriter eventWriter, XMLEventFactory eventFactory) {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:61` `public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:66` `public NamespaceContext getNamespaceContext() {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:71` `public void setPrefix(String prefix, String uri) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:76` `public String getPrefix(String uri) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:81` `public void setDefaultNamespace(String uri) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:86` `public Object getProperty(String name) throws IllegalArgumentException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:92` `public void writeStartDocument() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:98` `public void writeStartDocument(String version) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:104` `public void writeStartDocument(String encoding, String version) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:110` `public void writeStartElement(String localName) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:116` `public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:122` `public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:127` `private void doWriteStartElement(StartElement startElement) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:133` `public void writeEmptyElement(String localName) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:140` `public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:147` `public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:153` `private void closeEmptyElementIfNecessary() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:161` `public void writeEndElement() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:169` `public void writeAttribute(String localName, String value) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:174` `public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:179` `public void writeAttribute(String prefix, String namespaceURI, String localName, String value)`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:186` `public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:191` `public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:196` `private void doWriteNamespace(Namespace namespace) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:212` `public void writeCharacters(String text) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:218` `public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:224` `public void writeCData(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:230` `public void writeComment(String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:236` `public void writeProcessingInstruction(String target) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:242` `public void writeProcessingInstruction(String target, String data) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:248` `public void writeDTD(String dtd) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:254` `public void writeEntityRef(String name) throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:260` `public void writeEndDocument() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:266` `public void flush() throws XMLStreamException {`
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:271` `public void close() throws XMLStreamException {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/xml/StaxUtils.java:318,327`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — XMLStreamExceptions propagate; end-element/namespace before start can IndexOutOfBoundsException; property IllegalArgumentException. Partial writer output not rolled back; close does not flush open stack.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/XMLEventStreamWriter.java:87–87` `throw new IllegalArgumentException();`

Candidate source risk, not production incident: Unbalanced writer calls fail through unchecked stack bounds; endDocument does not emit outstanding end elements.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/XMLEventStreamWriter.java:1–276` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/util/xml/XmlValidationModeDetector.md -->

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
source_path: src/org/springframework/util/xml/XmlValidationModeDetector.java
source_refs:
  - "src/org/springframework/util/xml/XmlValidationModeDetector.java:1-209"
owner: REQUIRES_HUMAN_VALIDATION
---

# XmlValidationModeDetector

## Technical

SOURCE_OBSERVED — package `org.springframework.util.xml`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/util/xml/XmlValidationModeDetector.java:1–209`.

detectValidationMode resets inComment then reads lines using platform-default InputStreamReader and try-with-resources (`src/org/springframework/util/xml/XmlValidationModeDetector.java:91–118`). consumeCommentTokens recursively removes comment spans; helper commentToken toggles state, opening-tag test requires letter after < (`src/org/springframework/util/xml/XmlValidationModeDetector.java:125–206`). First noncomment DOCTYPE yields DTD=2; first opening element or EOF without doctype yields XSD=3; conversion failure returns AUTO=1. NONE=0 defined but not produced. Stream is closed, class state not thread safe.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:91` `public int detectValidationMode(InputStream inputStream) throws IOException {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:125` `private boolean hasDoctype(String content) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:136` `private boolean hasOpeningTag(String content) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:150` `private String consumeCommentTokens(String line) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:174` `private String consume(String line) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:183` `private int startComment(String line) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:191` `private int endComment(String line) {`
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:201` `private int commentToken(String line, String token, boolean inCommentIfPresent) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

INFERENCE — generic dependency role is the algorithm/interface described in Technical; impact on Async users cannot be established without a runtime or first-party calling path. No proven product retries/SLA/configuration policy may be inferred from this helper.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — CharConversionException returns AUTO, other IOException propagated; recursion/invalid input failures uncaught. Detection only sees contains DOCTYPE heuristic, not XML parse/schema validation.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/util/xml/XmlValidationModeDetector.java:114–114` `catch (CharConversionException ex) {`

Candidate source risk, not production incident: Detection consumes/closes input; platform charset and comment heuristic matter for ambiguous documents.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/util/xml/XmlValidationModeDetector.java:1–209` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

No direct first-party consumer found, so caller observability/runtime log route UNKNOWN. Other source references in Business provide specific callers/dependencies to inspect; exceptions/return sentinel/callback outcomes must be measured at those boundaries. Reproduce algorithm with branch-specific input, capture thrown cause or returned state, and search caller job/request time plus IDs only if caller supplies them; no local payload/ID privacy fields or appender evidence.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/CaptureTheRestPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:1-125"
owner: REQUIRES_HUMAN_VALIDATION
---

# CaptureTheRestPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:1–125`.

Constructor extracts variable name from {*name} descriptor (`src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:45–47`). matches requires separator or path exhausted, records remainder as consumed in prefix mode and optionally joins all decoded segments/raw separators from current index while merging matrix parameters across segments (`src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:52–96`). Captures zero-length remainder allowed. Normalized length 1, capture count 1, wildcard count 0; getChars hardcodes slash descriptor (`src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:100–122`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:52` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:85` `private String pathToString(int fromSegment, List<Element> pathElements) {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:100` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:105` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:110` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:115` `public int getCaptureCount() {`
- `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:121` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:167,206,231`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:261,325`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch; extraction map/path failures propagate. Parser ensures terminal standalone use; direct malformed descriptors can bounds fail.

**No explicit throw/catch/assert statements.**

Candidate source risk, not production incident: getChars uses slash regardless of configured dot separator; affects computePatternString diagnostic representation.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:1–125` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/CaptureVariablePathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/CaptureVariablePathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:1-166"
owner: REQUIRES_HUMAN_VALIDATION
---

# CaptureVariablePathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:1–166`.

Constructor splits first colon to name/optional regex; regex DOTALL and optional CASE_INSENSITIVE (`src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:46–65`). matches rejects exhausted/empty candidate; constraint requires groupCount zero and full matcher success (`src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:70–91`). Consumes one segment, delegates remaining chain or permits one trailing separator; prefix mode records index. Only on full success extracting mode binds candidate plus its matrix params (`src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:93–119`). Name/chars/accessor metadata normalized length 1, capture count/score 1 (`src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:123–163`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:70` `public boolean matches(int pathIndex, PathPattern.MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:123` `public String getVariableName() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:128` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:133` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:145` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:150` `public int getCaptureCount() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:155` `public int getScore() {`
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:161` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:331,340`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — PatternSyntaxException propagates constructor to parser wrapping; capturing regex groups IllegalArgumentException at match even before successful regex match. No match returns false, not error; no HTTP status.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:85–86` `throw new IllegalArgumentException( "No capture groups allowed in the constraint regex: " + this.constraintPattern.pattern());`

Candidate source risk, not production incident: Regex capturing groups are rejected at matching time, not necessarily parse time.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:1–166` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/InternalPathPatternParser.md -->

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
source_path: src/org/springframework/web/util/pattern/InternalPathPatternParser.java
source_refs:
  - "src/org/springframework/web/util/pattern/InternalPathPatternParser.java:1-426"
owner: REQUIRES_HUMAN_VALIDATION
---

# InternalPathPatternParser

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:1–426`.

Per-parse mutable character cursor/state; parse validates nonnull, resets chain/names/counters, scans separators/?/*/capture braces, validates Java identifier names allowing hyphen after start (`src/org/springframework/web/util/pattern/InternalPathPatternParser.java:94–188`). skipCaptureRegex respects backslash and nested quantifier braces, rejects missing/empty regex and unescaped separator (`src/org/springframework/web/util/pattern/InternalPathPatternParser.java:199–235`). peekDoubleWildcard recognizes terminal separator+** only (`src/org/springframework/web/util/pattern/InternalPathPatternParser.java:241–254`). push links doubly linked chain; {*rest} replaces previous Separator element and must be standalone terminal (`src/org/springframework/web/util/pattern/InternalPathPatternParser.java:260–297`). createPathElement chooses capture-rest, variable, compound regex, single wildcard, question/literal; wraps sole capture PatternSyntaxException with corrected position; records duplicate capture names (312–377,388–423). parse returns PathPattern snapshot; outer parser creates new parser per call.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:94` `public PathPattern parse(String pathPattern) throws PatternParseException {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:199` `private void skipCaptureRegex() {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:241` `private boolean peekDoubleWildcard() {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:260` `private void pushPathElement(PathElement newPathElement) {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:300` `private char[] getPathElementText() {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:312` `private PathElement createPathElement() {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:388` `private int findRegexStart(char[] data, int offset) {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:402` `private void resetPathElementState() {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:415` `private void recordCapturedVariable(int pos, String variableName) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPatternParser.java:110`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — PatternParseException codes: nested capture, missing open/close, illegal identifier chars, data after rest, empty constraint, standalone-rest and double capture; unexpected previous node IllegalStateException. Compound RegexPathElement compilation can propagate raw PatternSyntaxException rather than sole-capture wrapping.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:95–95` `Assert.notNull(pathPattern, "Path pattern must not be null");`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:130–131` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.ILLEGAL_NESTED_CAPTURE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:143–144` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.MISSING_OPEN_CAPTURE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:148–149` `throw new PatternParseException(this.pos + 1, this.pathPatternData, PatternMessage.NO_MORE_DATA_EXPECTED_AFTER_CAPTURE_THE_REST);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:170–172` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.ILLEGAL_CHARACTER_AT_START_OF_CAPTURE_DESCRIPTOR, Character.toString(ch));`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:177–179` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.ILLEGAL_CHARACTER_IN_CAPTURE_DESCRIPTOR, Character.toString(ch));`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:218–219` `throw new PatternParseException(regexStart, this.pathPatternData, PatternMessage.MISSING_REGEX_CONSTRAINT);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:226–227` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.MISSING_CLOSE_CAPTURE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:233–234` `throw new PatternParseException(this.pos - 1, this.pathPatternData, PatternMessage.MISSING_CLOSE_CAPTURE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:250–251` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.NO_MORE_DATA_EXPECTED_AFTER_CAPTURE_THE_REST);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:282–282` `throw new IllegalStateException("Expected SeparatorPathElement but was " + this.currentPE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:314–314` `throw new PatternParseException(this.pos, this.pathPatternData, PatternMessage.MISSING_CLOSE_CAPTURE);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:334–334` `catch (PatternSyntaxException pse) {`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:335–337` `throw new PatternParseException(pse, findRegexStart(this.pathPatternData, this.pathElementStart) + pse.getIndex(), this.pathPatternData, PatternMessage.REGEX_PATTERN_SYNTAX_EXCEPTION);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:345–346` `throw new PatternParseException(this.pathElementStart, this.pathPatternData, PatternMessage.CAPTURE_ALL_IS_STANDALONE_CONSTRUCT);`
- `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:420–421` `throw new PatternParseException(pos, this.pathPatternData, PatternMessage.ILLEGAL_DOUBLE_CAPTURE, variableName);`

Candidate source risk, not production incident: Duplicate detection recordCapturedVariable does not include capture-rest variable; test /{x}/{*x} for overwritten binding.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:1–426` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/LiteralPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/LiteralPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/LiteralPathElement.java:1-127"
owner: REQUIRES_HUMAN_VALIDATION
---

# LiteralPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/LiteralPathElement.java:1–127`.

Constructor stores literal char array directly if case sensitive or copies lowercased chars if insensitive (`src/org/springframework/web/util/pattern/LiteralPathElement.java:40–54`). matches requires PathSegment, exact decoded length and char-by-char comparison; consumes one then recursively checks next, or records prefix end/full path/optional trailing separator (`src/org/springframework/web/util/pattern/LiteralPathElement.java:58–108`). Normalized length is text length, getChars exposes stored array and toString formats literal (`src/org/springframework/web/util/pattern/LiteralPathElement.java:112–124`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/LiteralPathElement.java:40` `public LiteralPathElement(int pos, char[] literalText, boolean caseSensitive, char separator) {`
- `src/org/springframework/web/util/pattern/LiteralPathElement.java:58` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/LiteralPathElement.java:112` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/LiteralPathElement.java:117` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/LiteralPathElement.java:123` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:372`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch; invalid direct constructor params NPE; mismatch false. Mutable exposed char array can alter compiled match state.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/LiteralPathElement.java:1–127` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/PathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/PathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/PathElement.java:1-110"
owner: REQUIRES_HUMAN_VALIDATION
---

# PathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/PathElement.java:1–110`.

Abstract chain node holds original position, separator and nullable next/prev links (`src/org/springframework/web/util/pattern/PathElement.java:33–61`). matches/getNormalizedLength/getChars abstract; default capture/wildcard/score zero; terminal test next==null (`src/org/springframework/web/util/pattern/PathElement.java:71–107`). Constants wildcard weight100 and capture weight1 determine specificity downstream. Shared NO_PARAMETERS is mutable empty MultiValueMap, normally wrapped by match context.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/PathElement.java:71` `public abstract boolean matches(int candidatePos, MatchingContext matchingContext);`
- `src/org/springframework/web/util/pattern/PathElement.java:77` `public abstract int getNormalizedLength();`
- `src/org/springframework/web/util/pattern/PathElement.java:79` `public abstract char[] getChars();`
- `src/org/springframework/web/util/pattern/PathElement.java:84` `public int getCaptureCount() {`
- `src/org/springframework/web/util/pattern/PathElement.java:91` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/PathElement.java:98` `public int getScore() {`
- `src/org/springframework/web/util/pattern/PathElement.java:106` `protected final boolean isNoMorePattern() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:121,153,162,304,481,495,504`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:75,79,260,269,312,317`; `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:30`; `src/org/springframework/web/util/pattern/LiteralPathElement.java:31`; `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:34`; `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:33`; `src/org/springframework/web/util/pattern/WildcardPathElement.java:31`; `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:26`; `src/org/springframework/web/util/pattern/SeparatorPathElement.java:29`; `src/org/springframework/web/util/pattern/RegexPathElement.java:38`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class; subclasses/parser own validation. No path/user status mapping.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/PathElement.java:1–110` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/PathPattern.md -->

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
source_path: src/org/springframework/web/util/pattern/PathPattern.java
source_refs:
  - "src/org/springframework/web/util/pattern/PathPattern.java:1-736"
owner: REQUIRES_HUMAN_VALIDATION
---

# PathPattern

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/PathPattern.java:1–736`.

Constructor snapshots parser options/case/trailing setting and traverses chain to count captures/normalized length/score, catchall and trailing separator wildcard (`src/org/springframework/web/util/pattern/PathPattern.java:153–174`). Specificity nullsLast orders noncatchall before catchall, longer catchall then score then longer normalized length (`src/org/springframework/web/util/pattern/PathPattern.java:94–101`). matches and matchAndExtract allocate per-call MatchingContext; empty-pattern/empty-path branches allow configured separator and rest binding; results boolean/null or match maps (`src/org/springframework/web/util/pattern/PathPattern.java:200–239`). matchStartOfPath sets prefix mode and returns matched/remaining subpaths plus extracted maps (`src/org/springframework/web/util/pattern/PathPattern.java:250–276`). extractPathWithinPattern starts first wildcard/capture, trims separators and collapses duplicates, preserves options (`src/org/springframework/web/util/pattern/PathPattern.java:298–358`). compareTo adds lexical tie-break. combine handles empty/matching second/trailing */concat/file extension wildcard conflicts, reparses using retained mutable parser (`src/org/springframework/web/util/pattern/PathPattern.java:367–428`). Equality includes string/separator/case but excludes trailing setting; metadata/diagnostics (`src/org/springframework/web/util/pattern/PathPattern.java:432–545`). Nested immutable-view DTOs hold URI and matrix maps and matched/remaining paths (`src/org/springframework/web/util/pattern/PathPattern.java:553–644`). MatchingContext stores candidate list and extraction HashMaps per operation; lazy map init and unmodifiable matrix wrappers, checks separator/decoded values (`src/org/springframework/web/util/pattern/PathPattern.java:652–733`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/PathPattern.java:181` `public String getPatternString() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:191` `public boolean hasPatternSyntax() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:200` `public boolean matches(PathContainer pathContainer) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:224` `public PathMatchInfo matchAndExtract(PathContainer pathContainer) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:250` `public PathRemainingMatchInfo matchStartOfPath(PathContainer pathContainer) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:298` `public PathContainer extractPathWithinPattern(PathContainer path) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:367` `public int compareTo(@Nullable PathPattern otherPattern) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:376` `public PathPattern combine(PathPattern pattern2string) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:432` `public boolean equals(@Nullable Object other) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:443` `public int hashCode() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:448` `public String toString() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:516` `private String concat(String path1, String path2) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:535` `private boolean hasLength(@Nullable PathContainer container) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:539` `private static int scoreByNormalizedLength(PathPattern pattern) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:543` `private boolean pathContainerIsJustSeparator(PathContainer pathContainer) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:570` `public Map<String, String> getUriVariables() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:578` `public Map<String, MultiValueMap<String, String>> getMatrixVariables() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:583` `public String toString() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:619` `public PathContainer getPathMatched() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:626` `public PathContainer getPathRemaining() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:634` `public Map<String, String> getUriVariables() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:641` `public Map<String, MultiValueMap<String, String>> getMatrixVariables() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:675` `public MatchingContext(PathContainer pathContainer, boolean extractVariables) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:682` `public void setMatchAllowExtraPath() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:686` `public boolean isMatchOptionalTrailingSeparator() {`
- `src/org/springframework/web/util/pattern/PathPattern.java:690` `public void set(String key, String value, MultiValueMap<String,String> parameters) {`
- `src/org/springframework/web/util/pattern/PathPattern.java:704` `public PathMatchInfo getPathMatchResult() {`

Package-private metric accessors return already computed constructor state: getScore() returns weighted score, isCatchAll() returns catchAll flag, getNormalizedLength() returns accumulated normalized chain length, getCapturedVariableCount() returns capture total. getSeparator() reads this.pathOptions.separator(), not the retained parser's later options (`src/org/springframework/web/util/pattern/PathPattern.java:453–477`). toChainString() walks head → next, joins each node.toString() with a space and returns empty string for empty chain; computePatternString() independently walks same chain and appends each node.getChars() without separators beyond those carried by nodes; getHeadSection() exposes nullable head reference without copy (`src/org/springframework/web/util/pattern/PathPattern.java:479–505`). These diagnostic traversals do not match a candidate or extract variables. Nested MatchingContext.isSeparator(index) does direct list get and instanceof Separator; out-of-range/negative indices throw list bounds errors. pathElementValue(index) reads element only when index < pathLength, returns PathSegment.valueToMatch(), otherwise empty string for separator/end; a negative index still satisfies the upper-bound condition and can bounds-fail (`src/org/springframework/web/util/pattern/PathPattern.java:718–733`).

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/mediation/generic/vo/Service.java:4` `import org.springframework.web.util.pattern.PathPattern;`
- `src/com/nozha/async/server/mediation/generic/vo/Service.java:14` `private final PathPattern pathPattern;`
- `src/com/nozha/async/server/mediation/generic/vo/Service.java:57` `public PathPattern getPathPattern() {`

Service creates pathPattern from declared descriptor path (src/com/nozha/async/server/mediation/generic/vo/Service.java:20–26). RestHandler.getServiceFromPath and ServiceDefinitionProvider.getService use parsed URI path, filter matches, then extract variables to prefer fewer captures (RestHandler.java:103–116; ServiceDefinitionProvider.java:488–536). Method-aware provider selection throws MediationException HTTP405 when path matches but method does not. This dependency controls descriptor selection, not its own standalone business policy.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:40,86,95`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:94,188`; `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:21`; `src/org/springframework/web/util/pattern/LiteralPathElement.java:22`; `src/org/springframework/web/util/pattern/CaptureTheRestPathElement.java:25`; `src/org/springframework/web/util/pattern/CaptureVariablePathElement.java:70`; `src/org/springframework/web/util/pattern/PathPatternParser.java:109`; `src/org/springframework/web/util/pattern/WildcardPathElement.java:21`; `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:34`; `src/org/springframework/web/util/pattern/SeparatorPathElement.java:19`; `src/org/springframework/web/util/pattern/PathElement.java:22`; `src/org/springframework/web/util/pattern/RegexPathElement.java:25`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Incompatible explicit extensions IllegalArgumentException Cannot combine patterns; parser/element validation propagates. No local catch/status/retry; malformed routes fail consumers. Public matches/null handling partly accommodates null, but matchStartOfPath head-null returns DTO with potentially null remaining.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/PathPattern.java:425–426` `throw new IllegalArgumentException( "Cannot combine patterns: " + this.patternString + " and " + pattern2string);`

Candidate source risk, not production incident: equals ignores optional trailing separator; combine reparses with mutable parser reference, so changing parser after compile changes future combinations.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/PathPattern.java:1–736` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/PathPatternParser.md -->

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
source_path: src/org/springframework/web/util/pattern/PathPatternParser.java
source_refs:
  - "src/org/springframework/web/util/pattern/PathPatternParser.java:1-144"
owner: REQUIRES_HUMAN_VALIDATION
---

# PathPatternParser

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/PathPatternParser.java:1–144`.

Mutable parser configuration defaults optional trailing separator=true, caseSensitive=true, HTTP_PATH slash decoded (`src/org/springframework/web/util/pattern/PathPatternParser.java:37–41`). Setters/getters store/read values with no synchronization/validation (`src/org/springframework/web/util/pattern/PathPatternParser.java:53–95`). parse creates new InternalPathPatternParser each call (`src/org/springframework/web/util/pattern/PathPatternParser.java:109–110`), avoiding shared per-parse state. defaultInstance anonymous subclass rejects every configuration setter with UnsupportedOperationException (`src/org/springframework/web/util/pattern/PathPatternParser.java:122–142`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/PathPatternParser.java:53` `public void setMatchOptionalTrailingSeparator(boolean matchOptionalTrailingSeparator) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:60` `public boolean isMatchOptionalTrailingSeparator() {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:68` `public void setCaseSensitive(boolean caseSensitive) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:75` `public boolean isCaseSensitive() {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:86` `public void setPathOptions(PathContainer.Options pathOptions) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:94` `public PathContainer.Options getPathOptions() {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:109` `public PathPattern parse(String pathPattern) throws PatternParseException {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:125` `public void setMatchOptionalTrailingSeparator(boolean matchOptionalTrailingSeparator) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:130` `public void setCaseSensitive(boolean caseSensitive) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:135` `public void setPathOptions(PathContainer.Options pathOptions) {`
- `src/org/springframework/web/util/pattern/PathPatternParser.java:139` `private void raiseError() {`

## Business

SOURCE_OBSERVED — direct first-party integration references:
- `src/com/nozha/async/server/mediation/generic/vo/Service.java:5` `import org.springframework.web.util.pattern.PathPatternParser;`
- `src/com/nozha/async/server/mediation/generic/vo/Service.java:21` `this.pathPattern = PathPatternParser.defaultInstance.parse(path);`

Service creates pathPattern from declared descriptor path (src/com/nozha/async/server/mediation/generic/vo/Service.java:20–26). RestHandler.getServiceFromPath and ServiceDefinitionProvider.getService use parsed URI path, filter matches, then extract variables to prefer fewer captures (RestHandler.java:103–116; ServiceDefinitionProvider.java:488–536). Method-aware provider selection throws MediationException HTTP405 when path matches but method does not. This dependency controls descriptor selection, not its own standalone business policy.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/util/AntPathMatcher.java:738`; `src/org/springframework/web/util/pattern/PathPattern.java:108,153`; `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:38,49,57,58`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:36,86`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — PatternParseException and invalid/null path errors from internal parser propagate. Null pathOptions accepted setter then parsing NPE. Shared default mutation rejected exact read-only message; no retry/status.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/PathPatternParser.java:140–141` `throw new UnsupportedOperationException( "This is a read-only, shared instance that cannot be modified");`

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/PathPatternParser.java:1–144` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/PathPatternRouteMatcher.md -->

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
source_path: src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java
source_refs:
  - "src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:1-127"
owner: REQUIRES_HUMAN_VALIDATION
---

# PathPatternRouteMatcher

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:1–127`.

Default constructs dot MESSAGE_ROUTE parser and disables optional trailing separator; injected parser validated (`src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:48–60`). parseRoute wraps parsed PathContainer; isPattern/combine/match/matchAndExtract delegate cached PathPattern, extraction returns URI variables or null (`src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:64–87`). Comparator ignores route parameter and compares compiled patterns. ConcurrentHashMap.computeIfAbsent caches unbounded string pattern keys; route must internal PathContainerRoute via Assert instance check (`src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:91–101`). DTO exposes original route (`src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:105–124`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:48` `public PathPatternRouteMatcher() {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:57` `public PathPatternRouteMatcher(PathPatternParser parser) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:64` `public Route parseRoute(String routeValue) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:69` `public boolean isPattern(String route) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:74` `public String combine(String pattern1, String pattern2) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:79` `public boolean match(String pattern, Route route) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:85` `public Map<String, String> matchAndExtract(String pattern, Route route) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:91` `public Comparator<String> getPatternComparator(Route route) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:95` `private PathPattern getPathPattern(String pattern) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:99` `private PathContainer getPathContainer(Route route) {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:116` `public String value() {`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:122` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Assert null parser/wrong Route type; parser and combine exceptions propagate; null key ConcurrentHashMap failure. No eviction/recovery/HTTP mapping.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:58–58` `Assert.notNull(parser, "PathPatternParser must not be null");`
- `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:100–100` `Assert.isInstanceOf(PathContainerRoute.class, route);`

Candidate source risk, not production incident: Cache unbounded; mutable injected parser can create mixed configuration entries and parseRoute mismatch.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/PathPatternRouteMatcher.java:1–127` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/PatternParseException.md -->

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
source_path: src/org/springframework/web/util/pattern/PatternParseException.java
source_refs:
  - "src/org/springframework/web/util/pattern/PatternParseException.java:1-121"
owner: REQUIRES_HUMAN_VALIDATION
---

# PatternParseException

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/PatternParseException.java:1–121`.

IllegalArgumentException subclass constructors store position/pattern/messageType/inserts and optional cause; getMessage formats message every call (`src/org/springframework/web/util/pattern/PatternParseException.java:39–61`). toDetailedString shows original pattern, position caret and message; getters expose position/type and inserts array (`src/org/springframework/web/util/pattern/PatternParseException.java:68–88`). PatternMessage enum defines 12 parser error templates, formatMessage uses MessageFormat (`src/org/springframework/web/util/pattern/PatternParseException.java:95–117`). No status code translation/log emission; diagnostic may contain user pattern.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/PatternParseException.java:60` `public String getMessage() {`
- `src/org/springframework/web/util/pattern/PatternParseException.java:68` `public String toDetailedString() {`
- `src/org/springframework/web/util/pattern/PatternParseException.java:79` `public int getPosition() {`
- `src/org/springframework/web/util/pattern/PatternParseException.java:83` `public PatternMessage getMessageType() {`
- `src/org/springframework/web/util/pattern/PatternParseException.java:87` `public Object[] getInserts() {`
- `src/org/springframework/web/util/pattern/PatternParseException.java:116` `public String formatMessage(Object... inserts) {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:25,94,130,143,148,170,177,218,226,233,250,314,335,345,420`; `src/org/springframework/web/util/pattern/PathPatternParser.java:109`; `src/org/springframework/web/util/pattern/RegexPathElement.java:91,92,103,104`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — This class represents parse failure; no catch/recovery itself. Invalid arrays/types can fail formatting; getters expose inserts without defensive copy. Error vocabulary includes missing braces/nesting/adjacency/identifier/rest/regex/duplicates.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/PatternParseException.java:1–121` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/RegexPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/RegexPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/RegexPathElement.java:1-213"
owner: REQUIRES_HUMAN_VALIDATION
---

# RegexPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/RegexPathElement.java:1–213`.

Constructor compiles segment regex; buildPattern scans glob ?/*/{var[:regex]}, quotes literal spans, substitutes . / .* / capturing variable regex and records names with duplicate checks; DOTALL optional CASE_INSENSITIVE, wildcard after dot not counted (`src/org/springframework/web/util/pattern/RegexPathElement.java:56–125`). matches full candidate segment regex, then next chain or terminal/prefix/trailing branch, requires nonempty captures (`src/org/springframework/web/util/pattern/RegexPathElement.java:129–156`). Extraction checks regex group count equals defined names and assigns each group; only final variable receives matrix params (`src/org/springframework/web/util/pattern/RegexPathElement.java:158–175`). Metadata normalizes variable name lengths, capture/wildcard weight scoring, returns original char array/name list (`src/org/springframework/web/util/pattern/RegexPathElement.java:179–210`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/RegexPathElement.java:64` `public Pattern buildPattern(char[] regex, char[] completePattern) {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:117` `public List<String> getVariableNames() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:121` `private String quote(String s, int start, int end) {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:129` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:179` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:188` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:193` `public int getCaptureCount() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:198` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:203` `public int getScore() {`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:209` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:348,363`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — Duplicate names PatternParseException; invalid regex PatternSyntaxException. Capture-group mismatch IllegalArgumentException explaining noncapturing groups, but only extracting mode after match. No-match false.

Explicit failure/validation/recovery statements (exact source expressions):
- `src/org/springframework/web/util/pattern/RegexPathElement.java:91–92` `throw new PatternParseException(this.pos, completePattern, PatternParseException.PatternMessage.ILLEGAL_DOUBLE_CAPTURE, variableName);`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:103–104` `throw new PatternParseException(this.pos, completePattern, PatternParseException.PatternMessage.ILLEGAL_DOUBLE_CAPTURE, variableName);`
- `src/org/springframework/web/util/pattern/RegexPathElement.java:161–164` `throw new IllegalArgumentException("The number of capturing groups in the pattern segment " + this.pattern + " does not match the number of URI template variables it defines, " + "which can occur if capturing groups are used in a URI template regex. " + "Use non-capturing groups instead.");`

Candidate source risk, not production incident: matches may succeed but matchAndExtract throw on extra capturing groups, affecting first-party routes that sort by extracted variables.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/RegexPathElement.java:1–213` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/SeparatorPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/SeparatorPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/SeparatorPathElement.java:1-76"
owner: REQUIRES_HUMAN_VALIDATION
---

# SeparatorPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/SeparatorPathElement.java:1–76`.

matches requires existing Separator element; terminal returns full equality or records consumed prefix; otherwise advances and calls next (`src/org/springframework/web/util/pattern/SeparatorPathElement.java:41–57`). Normalized length1, chars configured separator, string diagnostic (`src/org/springframework/web/util/pattern/SeparatorPathElement.java:61–73`). No checking separator character inside match, relies candidate parse options.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/SeparatorPathElement.java:41` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/SeparatorPathElement.java:61` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/SeparatorPathElement.java:66` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/SeparatorPathElement.java:72` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:170`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:118,268,282`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch; mismatch false. Caller must align pattern/candidate separator options.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/SeparatorPathElement.java:1–76` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:1-138"
owner: REQUIRES_HUMAN_VALIDATION
---

# SingleCharWildcardedPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:1–138`.

Constructor stores/copies lowercase literal chars, length/question count/case (`src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:41–57`). matches requires decoded PathSegment same length; compares each literal while ? matches any char, handles case mode; consume/next or prefix/full/one trailing separator (`src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:61–115`). wildcard count question count, normalized length original, stored chars returned (`src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:118–135`). Uses default PathElement score zero, unlike star weight.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:41` `public SingleCharWildcardedPathElement(`
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:61` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:118` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:123` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:128` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:134` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:368`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No explicit throw/catch; mismatch false. Direct malformed/null params propagate; getChars exposes mutable array.

**No explicit throw/catch/assert statements.**

Candidate source risk, not production incident: Question marks affect wildcard count but not score; specificity hasPatternSyntax separately checks ?.

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/SingleCharWildcardedPathElement.java:1–138` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/WildcardPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/WildcardPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/WildcardPathElement.java:1-110"
owner: REQUIRES_HUMAN_VALIDATION
---

# WildcardPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/WildcardPathElement.java:1–110`.

matches optionally consumes one PathSegment; separators rejected. Terminal star can accept no segment at exhausted path, prefix stores current index; optional trailing separator requires nonempty consumed segment. Nonterminal requires nonempty segment then calls next (`src/org/springframework/web/util/pattern/WildcardPathElement.java:44–81`). normalized length1, wildcard count1, score100, chars * (`src/org/springframework/web/util/pattern/WildcardPathElement.java:85–107`).

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:33` `public WildcardPathElement(int pos, char separator) {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:44` `public boolean matches(int pathIndex, MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:85` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:90` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:95` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:100` `public int getScore() {`
- `src/org/springframework/web/util/pattern/WildcardPathElement.java:106` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:170`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:360`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct throw/catch; mismatch false. No own decoding/validation; context PathContainer supplies values.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/WildcardPathElement.java:1–110` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.


---

<!-- source dossier: src/org/springframework/web/util/pattern/WildcardTheRestPathElement.md -->

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
source_path: src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java
source_refs:
  - "src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:1-66"
owner: REQUIRES_HUMAN_VALIDATION
---

# WildcardTheRestPathElement

## Technical

SOURCE_OBSERVED — package `org.springframework.web.util.pattern`; ownership: candidate bundled Spring Framework utility, evidenced by package/native or Spring API imports, not independently approved upstream provenance. Reviewed complete source `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:1–66`.

matches rejects remaining nonseparator first element; otherwise consumes all remainder in prefix mode and returns true including empty remainder (`src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:34–42`). normalized length1, wildcard count1, chars separator+**, diagnostic (`src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:46–63`). Catchall handling/scoring resides PathPattern; no variable capture.

Method/declaration evidence (overloads and nested hooks included; behavior grouped above):
- `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:34` `public boolean matches(int pathIndex, PathPattern.MatchingContext matchingContext) {`
- `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:46` `public int getNormalizedLength() {`
- `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:51` `public char[] getChars() {`
- `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:56` `public int getWildcardCount() {`
- `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:62` `public String toString() {`

## Business

SOURCE_OBSERVED — searched all first-party `src/com/nozha/**/*.java` for exact class/type token, excluding comments and unrelated JetBrains Nullable. No direct first-party reference found. Runtime use UNKNOWN: reflection, native registration and external dependency callers are not excluded by this search.

Indirect source path is Service constructor → PathPatternParser.parse → InternalPathPatternParser/PathPattern → element matches, and PathContainer.parsePath → DefaultPathContainer. First-party descriptor routing uses this pipeline in RestHandler.java:103–116 and ServiceDefinitionProvider.java:488–536. Its rules affect accepted route shapes/extraction, but no separate Async-owned policy or SLA is established.

Other source references (lexical evidence, not proof of execution): `src/org/springframework/web/util/pattern/PathPattern.java:167,206,231`; `src/org/springframework/web/util/pattern/InternalPathPatternParser.java:114`.

APPROVED_INTENT: absent; owner decision/human approval UNKNOWN. Business lens source-reviewed only; no runtime validation, production incident, contractual SLA or trusted promotion claimed.

## Errors

SOURCE_OBSERVED — No direct error path in class; parser restricts rest to terminal use. No HTTP mapping/retry.

**No explicit throw/catch/assert statements.**

Reproduction/validation: exercise the named failing input or callback/state branch from Technical and the statements above; for native WebRTC require compatible GStreamer/JNA and signaling peer. Static review performed; no executable test/runtime reproduction in this dossier. Use caller handling to determine business-visible impact; unhandled utility errors do not automatically imply a particular HTTP response.

## Logs and RCA

**NO_LOG_IN_CLASS** — complete executable source `src/org/springframework/web/util/pattern/WildcardTheRestPathElement.java:1–66` has no direct logging call. Registry rows for this source: 0; expected zero, no discrepancy.

Caller observability: RestHandler.getService URI parse catch logs DEBUG Exception for uri:{} at src/com/nozha/async/server/handler/RestHandler.java:92 (raw URI may expose query/path identifiers); it covers URI syntax fallback, not this matching engine errors. ServiceDefinitionProvider.getService matching loop :488–536 has no direct match-result log. Reproduce declared descriptor pattern and decoded path locally; inspect extraction/group constraints and caller exception handling, correlate available request log IDs externally. No local correlation/appender/proven success signal.

Static registry reconciliation completed; source logs are candidate evidence only and no production log occurrence or logging configuration activation is claimed.
