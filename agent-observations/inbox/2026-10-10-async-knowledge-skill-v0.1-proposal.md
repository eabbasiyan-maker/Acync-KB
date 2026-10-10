---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: local-static-test
truth_type: architectural-intent
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Proposed Async Knowledge Skill v0.1.0 — cross-runtime and KB-first

## User goal and scope decision (2026-10-10)

The PO clarified that the primary deliverable is a reusable **Skill** and maintained canonical **Async Knowledge Base**, usable in ChatGPT and any other authorized assistant. n8n is only one optional adapter, not an acceptance prerequisite. Observability/RCA is a domain of Async knowledge, not the whole initiative.

## Alignment with architecture v1.5

- Vendor-neutral `SKILL.md` procedure; do NOT copy living KB data into the Skill.
- Source of truth: `Acync-KB` catalog and human-validated claims; retrieve candidate Markdown on demand, pin commit and provenance.
- Source files are Source Evidence at a specific revision, never automatically Trusted Knowledge.
- Trust declaration in front matter is NOT Effective Trust; human Promotion is required.
- The agent writes full candidate proposals **only** into `agent-observations/inbox/**`; it does not write directly to `skills/**`, `knowledge/**`, `generated-knowledge/**`, `.agent/**`, `AGENTS.md`, or official claims.
- Human reviewer must explicitly promote this complete proposed file set to `skills/async-knowledge/` after review. This observation is NOT an approved or installed skill.
- Runtime readiness and instruction-surface governance require enforcement by host/orchestrator, not merely a prose statement.

## Redesigned project execution (four outcome-based phases)

1. **Skill + KB bootstrap**: runnable candidate package, canonical navigation, trusted/known-gap separation, 25-doc catalog integrity, static tests, explicit access model. No n8n hard gate.
2. **Coverage and evidence freshness**: prioritize Async product domains (architecture, contracts, flows, security, operations, Chat integration, Observability) and make only evidence-linked candidate proposals for missing details. Keep runtime/deployed facts UNKNOWN unless verified.
3. **Cross-consumer QC**: realistic Q&A/source-trace/RCA/update tasks in ChatGPT and at least one other authorized assistant, with exact source/KB commit, PASS/FAIL/UNKNOWN. This replaces single-platform n8n QC.
4. **Human promotion and distribution**: reviewer approval, publish installable Skill, attach GitHub access/config guidance and maintenance workflow; no unrestricted public sharing of internal knowledge.

Hourly automation should choose the highest-value executable task, report each run, summarize each six runs, and avoid repeating n8n-only tests.

## Candidate package QA (2026-10-10)

- `validate_skill.py`: PASS for name/description/relative links/canonical references; does **not** prove host installation or behavioral correctness.
- `test_validators.py`: 6/6 synthetic unit tests PASS for catalog presence, duplicate IDs, missing file, missing trusted-claims register, path traversal and invalid status.
- GitHub baseline (separate from these tests): current `Acync-KB/main` catalog had 25 document IDs with 25 present files and no duplicate ID or path.
- Sample evidence walkthrough against GitHub candidate docs: `BeforeSend` vs `AfterSend` does not establish end-to-end ACK; official `async-ack-retry-gap-01` remains a known gap.
- NOT TESTED: installation as ChatGPT Skill, other assistants, current operational Async deployment, organizational approval.

## Reviewer checklist

- [ ] Verify all instruction text conforms to Base Policy and tool permissions.
- [ ] Verify no internal confidential content becomes exposed via public GitHub/Skill sharing.
- [ ] Approve/adjust each proposed file and the routing table against latest catalog.
- [ ] Approve proposed install/distribution scope and host enforcement capability report.
- [ ] Human promotion of approved files from this inbox Observation to protected `skills/**`.
- [ ] Run realistic behavioral pilot and record outcomes before declaring production-ready.

## COMPLETE PROPOSED SKILL FILES (for human promotion only)

Each file below is the entire proposed candidate content; no data from `generated-knowledge/**` is embedded.

### `SKILL.md`
SHA-256: `71818aa43b7ef4b55e574e1b38920c3ad241e0303ee0889655ccea3d7ce8c38d`

````markdown
---
name: async-knowledge
description: "Use for evidence-grounded questions, source-code tracing, incident RCA, service behavior, contracts, architecture and controlled knowledge-update proposals about the Async communication platform. Consult the canonical Acync-KB catalog and validated claims rather than guessing or relying on memory. Works independently of n8n."
compatibility: "Requires authorized read access to Acync-KB via GitHub or a checked-out repository. Async-Source access optional; no production credentials are required."
metadata:
  version: "0.1.0-candidate"
  project: "async"
---

# Async Knowledge — portable, retrieval-first skill (candidate)

This is a **procedure**, not a copy of the knowledge base and not an authorization policy. Do not treat this candidate as an approved instruction surface until reviewed under the project's governance. The canonical knowledge is **`eabbasiyan-maker/Acync-KB`**, not this skill and not n8n. Follow higher-priority organizational policies and access controls.

## Trigger and task classification
Use when asked to explain, investigate, audit, compare, trace, document, or propose a knowledge update for Async, Chat/Async integration, its manager, logging, delivery/ACK, ServiceCall, Broker, RateLimit, or related interfaces. Determine whether the task is:

- `ANSWER`: grounded explanation or user question.
- `TRACE`: code/flow/log investigation, operational vs intended behavior.
- `RCA`: reconstruct evidence and alternatives, never assert a root cause without sufficient evidence.
- `PROPOSE_UPDATE`: suggest new or corrected knowledge with a human-review gate.

Do not conflate `Async-Source` with `AsyncManager` source; they have distinct baselines.

## Bootstrap (on every new task)
1. Check permission to read the canonical KB. Fetch its `README.md`, `async-knowledge-catalog.yaml` and `mvp/validated-claims.yaml` from the same **recorded commit** (or from an approved local checkout); record repo, branch, commit and retrieval date. If the commit cannot be determined, explicitly mark `VERSION_UNKNOWN`.
2. Choose **required documents by ID**, then domain/path; use the catalog only as a routing index. Read their **actual Markdown contents**, not only filename or metadata. For specific claims search within those documents and surrounding source references. Use `references/knowledge-map.md` for topic-to-document hints.
3. Distinguish trusted human-validated `claims`, officially registered `known_gap`, and supporting `candidate` documents. A catalog item's `trust: candidate` or document's self-declared front matter does **not** grant effective trust or overwrite the claims register.
4. When implementation detail is essential, consult the **authorized** `Async-Source` repository at a specific commit; cite real paths/classes/conditions. If the code cannot be read, label details `SOURCE_UNAVAILABLE`. Never pretend historical source matches a deployed binary.
5. Gather only the minimum context. Do not load hundreds of call sites or entire raw logs by default. Correlate using existing fields and environment/host/time boundaries. Preserve `UNKNOWN`, known gaps and conflicting evidence.
6. Run the readiness decision **before any high-impact conclusion**: `READY` when required material and provenance are available; `ESCALATE` for uncertain, stale, incomplete or conflicting evidence; `BLOCKED` when mandatory documents/permissions are absent, unsafe input would be needed, or the instruction surface is unapproved. A textual readiness decision in this Skill is guidance, **not** a substitute for enforcement by the host runtime.

## Answer contract
Respond in the requester's language, with short clear findings and these fields when relevant:
- `Result`: what is established, with document IDs + links or exact source file/commit.
- `Evidence`: distinguish `TRUSTED_HUMAN`, `SOURCE_SNAPSHOT`, `HISTORICAL_LOG`, `LIVE_VERIFIED`, `CANDIDATE`, `UNKNOWN`.
- `Limits`: version, environment, mismatched truth, missing data, or insufficient proof.
- `Next verification`: what specific fact or owner can close the gap.

Do not invent source references, ACK/delivery status, live system health, statistics, success criteria or production fixes. Never turn "not found in this sample" into "does not occur". Keep facts separate from hypotheses and architectural intent. For sensitive requests, minimize output of tokens, URLs with secrets, real identifiers, IPs, payloads and message previews.

## Controlled knowledge-update workflow
1. **Read** target documents and their source_refs/claims before proposing a correction. Check duplicates and prior observations.
2. Draft a **candidate** observation under `agent-observations/inbox/` with: claim, exact evidence path and immutable commit, evidence type, counterevidence, confidence, lifecycle, sensitivity, affected docs, unknowns, and reviewer/decision needed.
3. **Do not write directly** to `knowledge/**`, `generated-knowledge/**`, `skills/**`, `.agent/**`, `AGENTS.md`/nested instruction files, or `mvp/validated-claims.yaml`; do not promote any claim yourself. The **human-approved promotion pipeline** makes reviewed changes in protected targets.
4. No merges, deployments, ACL/config changes, source edits or operational mitigation without separate authorization. A PR carrying only an inbox proposal is not promotion.

Read `references/governance-and-readiness.md` before a high-impact answer or update. Use `references/knowledge-map.md` for routing and `references/evaluation.md` for repeatable questions.

## Cross-runtime behavior
In ChatGPT, use connected GitHub/Project Files if available; in a coding assistant use its permitted repository reader; in n8n, the same contract can be implemented as nodes. **n8n is optional**. If network/repository access is absent, ask for an authorized KB checkout or linked file and report `BLOCKED` for ungrounded facts; do not answer from unverified memory.
````

### `references/knowledge-map.md`
SHA-256: `4aba229c7fe980f36f0b1820825fcee375a7966da72204492d8b1201e605d596`

````markdown
# Navigation map — pointers, not copied knowledge

Canonical repository: `https://github.com/eabbasiyan-maker/Acync-KB`. Always reload its `async-knowledge-catalog.yaml` for the complete CURRENT document set; IDs and paths below are hints based on the 2026-10-10 catalog, not a second authoritative index.

| Asked about | Retrieve catalog IDs first |
| --- | --- |
| Product scope and purpose | `async-overview`, `async-system-architecture` |
| HTTP integration and contracts | `async-http-mediation-boundary`, `async-interface-inventory` |
| Startup / runtime | `async-startup-flow`, `async-runtime-and-integrations` |
| Messages, Send vs ACK, delivery | `async-message-delivery-flow`, `async-observability-source-semantics`, plus the official ACK `known_gap` claim |
| Rate Limit control | `asyncmanager-rate-limit-manager` (**AsyncManager only**) |
| Security behavior | `async-security-implementation`; code at pinned Source revision if required |
| Logging and call-site semantics | `async-observability-source-semantics`, `async-observability-critical-source-traces`, `async-observability-log-point-registry-v1` |
| Incident RCA / runbooks | `async-observability-investigation-playbooks`, `async-observability-correlation-contract` |
| Historical incidents and data | `async-observability-historical-2026-08-18`, `async-observability-historical-qa-results` (**historical, not live**) |
| QC/evaluation | `async-observability-agent-qc-cases` (**proposed until run**) |
| Knowledge gaps | `async-knowledge-gaps`, `async-human-knowledge-backlog`, and exact `status: known_gap` claims only |
| Production evidence dependencies | `async-observability-runtime-validation-handoffs`, `async-observability-project-control-center` |

**Retrieval rule:** Use IDs first, then read content. Do not select a document solely because a query substring matches unrelated filenames (`ack` inside `backpressure` / `backlog`). For missing content, return no-evidence/unknown instead of silently selecting arbitrary fallback documents. All repository paths are subject to access rules and their source-version limitations.
````

### `references/governance-and-readiness.md`
SHA-256: `b0b02f713ab2be64921e7dbf381905093453c160eda2ac85472a42e55b07a26d`

````markdown
# Governance and readiness — operational notes for the portable skill

Based on user-provided *Enterprise Agent Knowledge Architecture v1.5* (FROZEN / approved for pilot). These are directions to a consuming host, not technical evidence that it enforces them.

- **Authority:** organizational policy > approved instruction > selected Skill > ordinary facts, decisions and observations. A document's front matter is a declaration, not effective trust.
- **Knowledge locations:** canonical `Acync-KB` plus selected source repo; the Skill stays small and never copies knowledge contents. Separate current living, dated historical and deployed operational evidence.
- **Promotion:** agent-generated observations to `agent-observations/inbox/**` only. Human review is needed for promotion into official Knowledge or Skill paths. Do not write `knowledge/**`, `generated-knowledge/**`, `skills/**`, `AGENTS.md` (including nested), `.agent/**` or trusted claims directly.
- **Truth reconciliation:** keep operational implementation and architectural intention separately documented when inconsistent; do not silently overwrite either.
- **Readiness:** missing required document/permissions => BLOCKED; insufficient required scope or possible staleness => BLOCKED or ESCALATE by risk; conflicting high-risk claims => BLOCKED; unapproved instruction file => BLOCKED. Enforcement is the responsibility of the actual orchestrator / Git security policy, not the Skill's prose.
- **Source:** source inspection at exact commit may support code behavior, but does not independently prove running deployment, message delivery ACK, successful consumption, availability, metrics or security posture.
- **Provenance:** record task, repository, commit/branch, selected catalog IDs, read date, evidence types, relevant approvals and unresolved questions. Do not fabricate or infer inaccessible line numbers.
- **Security:** access must be authorized; respect private artifacts and repository ACLs. Do not expose raw secrets, tokens, IP addresses, sensitive request bodies, message previews, or private logs into shared files/answers.

Example compact record:

```yaml
context_manifest:
  task: "Explain why an AfterSend entry is not necessarily delivery ACK"
  knowledge_repository: eabbasiyan-maker/Acync-KB
  knowledge_commit: UNKNOWN_IF_UNAVAILABLE
  selected_document_ids:
    - async-message-delivery-flow
    - async-observability-source-semantics
  evidence_categories: [CANDIDATE, SOURCE_SNAPSHOT, UNKNOWN]
  readiness: escalate
  reasons: ["Receiver-side ACK evidence unavailable"]
```
````

### `references/evaluation.md`
SHA-256: `e3529e7777cffc28a83821d0133eb4602a274854f9cfb34cc4488b3d4c3a533a`

````markdown
# Skill acceptance and evaluation plan

**This file defines tests. It does not claim tests of any consuming LLM/ChatGPT/n8n have passed.**

## Acceptance gates
1. Format: valid Agent Skills `SKILL.md` with unique matching name, non-empty triggering description, and resolvable relative references.
2. Discovery: current catalog, validated claims and required documents are available from the same pinned repo revision; unavailable items are surfaced as BLOCKED.
3. Grounding: answer names exact knowledge IDs and accessible links/source paths, with separation of trusted human claims, source snapshot, candidate, historical and live evidence.
4. No hallucinated closure: known gaps and ACK unknowns remain unknown; no Production assertion from archives; no fabricated code/line numbers.
5. Update governance: an agent may propose under `agent-observations/inbox/**` but does not directly promote to `skills/**`, `knowledge/**`, `generated-knowledge/**`, or the trust register.
6. Portability: evaluate a ChatGPT user with GitHub access, a second authorized assistant, and an offline/no-access assistant. Last must safely BLOCK rather than invent facts.

## Pilot questions and expected behavior
- Q1: "What exactly is Async responsible for?" — cite the human-trusted `async-responsibility-01` claim from validated-claims; include source/knowledge detail only as necessary.
- Q2: "Is ACK guaranteed after an AfterSend log?" — distinguish send operation from receiver confirmation; maintain human-validated `async-ack-retry-gap-01` as official known gap.
- Q3: "Did all 408 in the old sample come from HTTP listener timeout?" — cite historical sample's 28 linked cases of 150; keep others UNKNOWN and distinguish historical from live.
- Q4: "How does AsyncManager IP rate limit work?" — consult its distinct source baseline and mark it candidate, do not confuse with Async Server logs.
- Q5: "I want to change this Skill / add missing knowledge." — produce a complete proposed observation in `agent-observations/inbox/**`, never silently promote.
- Q6: "Is production safe because a log type is absent?" — refuse inference; identify sampling/config/version counterevidence.

## Scoring
For each tested assistant/runtime record: input, exact KB commit, selected doc IDs, actual answer, expected checks, evidence quality, privacy, and PASS/FAIL/BLOCKED. Do not claim a universal or production-ready Skill from formatting checks alone.
````

### `scripts/validate_skill.py`
SHA-256: `8f56401ffa27e147a88f19c4e4d0c03874bb9633db867b13633ac6aec69c435a`

````python
#!/usr/bin/env python3
"""Zero-dependency static validation for a candidate Agent Skill folder.

Usage: python scripts/validate_skill.py [path/to/async-knowledge]
This validates the package, NOT its live knowledge retrieval or Agent behavior.
"""
from __future__ import annotations
import pathlib
import re
import sys


def main():
    root = pathlib.Path(sys.argv[1]) if len(sys.argv) > 1 else pathlib.Path(__file__).resolve().parents[1]
    errors = []
    f = root / 'SKILL.md'
    if not f.is_file():
        print('FAIL: missing SKILL.md')
        return 1
    data = f.read_text(encoding='utf8')
    match = re.match(r'\A---\r?\n(.*?)\r?\n---\r?\n', data, flags=re.S)
    if not match:
        errors.append('YAML frontmatter missing')
        front = ''
    else:
        front = match.group(1)
    name = re.search(r'^name:\s*([^\r\n]+)', front, re.M)
    value = name.group(1).strip().strip('"\'') if name else ''
    if not re.fullmatch(r'[a-z0-9]+(?:-[a-z0-9]+)*', value) or len(value) > 64 or value != root.name:
        errors.append(f'name does not match skill folder or spec: {value!r}')
    desc = re.search(r'^description:\s*(.+)', front, re.M)
    if not desc or not 1 <= len(desc.group(1).strip().strip('"\'')) <= 1024:
        errors.append('description missing or invalid length')
    if 'n8n' not in data or 'async-knowledge-catalog.yaml' not in data or 'mvp/validated-claims.yaml' not in data:
        errors.append('Bootstrap does not describe runtime-independent canonical KB')
    if 'agent-observations/inbox/' not in data:
        errors.append('Human-review observation path missing')
    paths = re.findall(r'references/[A-Za-z0-9_.-]+\.md', data)
    for path in set(paths):
        if not (root / path).is_file():
            errors.append(f'Unresolved relative reference: {path}')
    if any(p for p in root.rglob('*') if p.is_symlink()):
        errors.append('Symbolic links are not allowed in portable ZIP')
    if errors:
        for err in errors:
            print('FAIL:', err)
        return 1
    print('PASS: skill format, unique name, required pointers, governance path, and relative references')
    print('NOT TESTED: GitHub live access, truth validation, ChatGPT installation, or behavioral evaluation')
    return 0


if __name__ == '__main__':
    raise SystemExit(main())
````

### `scripts/check_kb_checkout.py`
SHA-256: `58d0b5b6dcef0a688a4ffa9e1d7d378364c070e89e734fe6b7131b04d04f113e`

````python
#!/usr/bin/env python3
"""Check a *local permitted checkout* of Acync-KB, no dependency beyond Python.

Usage: python check_kb_checkout.py /path/to/Acync-KB
Only verifies structure and file presence. This does NOT validate fact accuracy.
"""
from __future__ import annotations
import pathlib
import re
import sys


def scan(root: pathlib.Path) -> dict:
    catalog = root / 'async-knowledge-catalog.yaml'
    claims = root / 'mvp/validated-claims.yaml'
    errors = []
    if not catalog.is_file() or not claims.is_file():
        return {'status': 'BLOCKED', 'errors': ['Catalog or official claims register unavailable']}
    docs = []
    current = None
    in_docs = False
    for line in catalog.read_text(encoding='utf8').splitlines():
        line_stripped = line.strip()
        if line_stripped == 'documents:':
            in_docs = True
            continue
        if not in_docs:
            continue
        if re.match(r'^\S', line) and not line_stripped.startswith('- id:'):
            in_docs = False
            continue
        if line_stripped.startswith('- id:'):
            if current:
                docs.append(current)
            current = {'id': line_stripped.partition(':')[2].strip(' "\'')}
            continue
        if current:
            m = re.match(r'^(path|trust|type|domain):\s*(.*)$', line_stripped)
            if m:
                current[m.group(1)] = m.group(2).strip(' "\'')
    if current:
        docs.append(current)
    ids = set()
    paths = set()
    for item in docs:
        ident, rel = item.get('id', ''), item.get('path', '')
        if not ident or not rel:
            errors.append(f'ID or path missing: {ident!r}')
            continue
        if ident in ids:
            errors.append(f'Duplicate catalog id: {ident}')
        ids.add(ident)
        if rel in paths:
            errors.append(f'Duplicate catalog path: {rel}')
        paths.add(rel)
        pure = pathlib.PurePosixPath(rel)
        if pure.is_absolute() or '..' in pure.parts or '\\' in rel:
            errors.append(f'Unsafe catalog path: {ident}')
        elif not (root / pure).is_file():
            errors.append(f'Missing document: {ident} ({rel})')
    text = claims.read_text(encoding='utf8')
    statuses = re.findall(r'^\s+status:\s*(\S+)', text, re.MULTILINE)
    if not statuses:
        errors.append('No claim statuses discovered')
    elif any(s not in ('trusted', 'candidate', 'known_gap') for s in statuses):
        errors.append('Unrecognized claim status')
    return {'status': 'PASS' if not errors else 'FAIL', 'docs': len(docs), 'claims': len(statuses), 'errors': errors,
            'note': 'Structure only. No retrieval, approval, deployment, or content correctness verified.'}


def main() -> int:
    if len(sys.argv) != 2:
        print('Usage: python check_kb_checkout.py /path/to/Acync-KB', file=sys.stderr)
        return 2
    report = scan(pathlib.Path(sys.argv[1]))
    print(report)
    return 0 if report['status'] == 'PASS' else 1


if __name__ == '__main__':
    raise SystemExit(main())
````

### `scripts/test_validators.py`
SHA-256: `001fb4ae333bf756b4f15065cdc6fb6c26f3a6c591419b0d0624748cf0e94b2a`

````python
#!/usr/bin/env python3
"""Synthetic-only regression tests for candidate Skill static validators."""
from __future__ import annotations
import importlib.util
import pathlib
import tempfile
import unittest

BASE = pathlib.Path(__file__).parent
spec = importlib.util.spec_from_file_location('kb_check', BASE/'check_kb_checkout.py')
kb_check = importlib.util.module_from_spec(spec)
spec.loader.exec_module(kb_check)


class KbStructureTests(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        self.root = pathlib.Path(self.tmp.name)
        (self.root / 'mvp').mkdir()
        (self.root / 'generated-knowledge').mkdir()
        (self.root / 'generated-knowledge/overview.md').write_text('# Overview\n', encoding='utf8')
        (self.root / 'mvp/validated-claims.yaml').write_text(
            'claims:\n  - id: a\n    status: trusted\n  - id: gap\n    status: known_gap\n', encoding='utf8')
        self.catalog = self.root / 'async-knowledge-catalog.yaml'
        self.catalog.write_text('documents:\n  - id: overview\n    path: generated-knowledge/overview.md\n    type: overview\n    trust: candidate\n', encoding='utf8')

    def tearDown(self):
        self.tmp.cleanup()

    def test_present(self):
        r = kb_check.scan(self.root)
        self.assertEqual(r['status'], 'PASS')
        self.assertEqual((r['docs'], r['claims']), (1, 2))

    def test_missing_document(self):
        (self.root / 'generated-knowledge/overview.md').unlink()
        self.assertEqual(kb_check.scan(self.root)['status'], 'FAIL')

    def test_missing_claims(self):
        (self.root / 'mvp/validated-claims.yaml').unlink()
        self.assertEqual(kb_check.scan(self.root)['status'], 'BLOCKED')

    def test_duplicate_document(self):
        text = self.catalog.read_text()
        self.catalog.write_text(text + '  - id: overview\n    path: generated-knowledge/overview.md\n')
        self.assertEqual(kb_check.scan(self.root)['status'], 'FAIL')

    def test_path_traversal(self):
        text = self.catalog.read_text().replace('generated-knowledge/overview.md', '../secrets.txt')
        self.catalog.write_text(text)
        self.assertEqual(kb_check.scan(self.root)['status'], 'FAIL')

    def test_invalid_claim_status(self):
        f = self.root / 'mvp/validated-claims.yaml'
        f.write_text('claims:\n  - id: a\n    status: supertrusted\n')
        self.assertEqual(kb_check.scan(self.root)['status'], 'FAIL')


if __name__ == '__main__':
    unittest.main(verbosity=2)
````