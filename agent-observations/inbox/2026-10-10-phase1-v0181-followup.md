---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: saved-workflow-code-review-and-offline-selector-simulation
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Async Observability — Phase 1 Retrieval: تکمیل ممیزی آفلاین با نسخه v0.18.1

**Reviewed 2026-10-10 | Scope: Non-Persist, read-only | Status: OFFLINE AUDIT COMPLETE; LIVE RETRIEVAL BLOCKED**

## مبنای بررسی و تفاوت نسخه‌ها

- نسخه قدیمی بررسی‌شده در PR #14: `Async Knowledge Agent - GitHub RAG + DeepSeek v0.7.0`، برگرفته از ZIP تاریخی کاربر. آن نسخه فیلتر `required_types/optional_types` داشت.
- نسخه جدیدتر موجود در Library (نه لزوماً نسخه Deploy): `Async Knowledge Agent - Retrieval Only v0.18.1 Luna.json`. شناسه ثبت‌شده در خود Export: `a1jSkU7E7UXxmqQ3`، دارای `active:true` در Export؛ **وجود این فیلد هیچ‌گاه اثبات نمی‌کند الان این نسخه در n8n اجرا می‌شود**.
- نودهای مرتبط v0.18.1: `Normalize Request`، `Select Knowledge Documents`، `Build Knowledge Report`، `Compact Dual-Evidence Handoff`.
- در v0.18.1، فیلتر صریح `allowed.has(d.type)` یا `required_types/optional_types` مربوط به v0.7 دیگر در نود `Select Knowledge Documents` دیده نشد. **در نتیجه یافته «حذف ۱۰ سند به دلیل type» صرفاً برای v0.7 معتبر است، نه برای Export جدید.**
- اختلاف نسخه‌گذاری داخل همان فایل: `Normalize Request.workflow_version='0.17.0'` در مقابل `Compact Dual-Evidence Handoff.workflow_version='0.16.0'`، با وجود عنوان `v0.18.1`. تا زمان بررسی اجرای فعال، از Version Field داخلی برای انتساب نتیجه به نسخه واحد استفاده نشود.

## نتیجه ممیزی کاتالوگ واقعی GitHub

- `Acync-KB/main`: ۲۵ سند، ۲۵ مسیر موجود و قابل Fetch، بدون شناسه یا مسیر تکراری.
- برای ۱۴ سند حوزه Observability انواع `operations(6), observation(2), procedure(4), gap(1), decision-proposal(1)` ثبت شده است؛ **همگی Candidate** هستند.
- در کاتالوگ ۲۴ سند Front Matter مناسب دارند؛ `generated-knowledge/observability/tools/async-log-diagnose-README.md` فاقد Front Matter است. این یک ناسازگاری حاکمیت سند است، نه شاهد شکست نودهای Runtime.

## مشکل جدید در Export v0.18.1: بازیابی بر اساس Metadata به‌جای محتوای سند

نود `Select Knowledge Documents` قبل از دریافت محتوای Markdown، سند را فقط از روی `id`, `path`, `type`, `domain`, `trust` امتیازدهی می‌کند و `scoreText` برای هر Keyword از عبارت `normalized.includes(q)` استفاده می‌کند. اگر هیچ سندی امتیاز مثبت نگیرد، **۴ سند اول کاتالوگ را با `fallback_only=true` برمی‌گرداند**. پس از آن، نود `Build Knowledge Report` محتوای فقط همان اسناد منتخب را Chunk و امتیازدهی می‌کند. بنابراین وجود متن دقیق درباره خطا در یک سند دیگر لزوماً باعث ورود آن به Context نمی‌شود.

### چهار آزمایش انتخاب سند بر اساس قرارداد Extracted v0.18.1

آزمون با پیاده‌سازی مستقل معادل در Python و Metadata کنترل‌شده ۲۵ سند فعلی انجام شد؛ **این اجرای کد اصلی JS در n8n نیست**.

| Case | پرسش آزمون | انتخاب baseline v0.18.1 | اسناد مورد انتظار در انتخاب baseline | انتخاب نسخه پیشنهادی |
| --- | --- | --- | --- | --- |
| R-1 | BeforeSend/AfterSend/ACK | `async-human-knowledge-backlog`, `async-observability-persistence-backpressure-adr` | هر دو سند اصلی Delivery و Logging غایب | دو سند مرجع حاضر |
| R-2 | 408 Listener Timeout | ۴ سند نخست کاتالوگ با `fallback_only=true` | Historical و Correlation غایب | هر دو حاضر |
| R-3 | Invalid Queue Name | ۴ سند نخست کاتالوگ با `fallback_only=true` | Playbook و Historical غایب | هر دو حاضر |
| R-4 | محل ۱۵ سناریو QC | `async-observability-agent-qc-cases` | حاضر | حاضر |

در R-1، کلمه کوتاه `ACK` به‌صورت substring در `bACKlog` و `bACKpressure` یافت می‌شود و نتیجه مثبت کاذب می‌سازد. در R-2 و R-3، مفاهیم مهم فقط در محتوا و/یا اسناد فاقد کلمات هم‌نام متادیتا قرار دارند؛ Retriever به آن محتوا نمی‌رسد.

**Coverage baseline: 1/4 complete expected-document sets. Proposed: 4/4.** این نمره‌ها فقط **selector offline** است، نه QC شناختی، نه پاسخ نهایی Agent و نه سنجش Production. موارد انتخاب‌شده احتمالاً همراه با اسناد دیگری خواهند بود؛ این گزارش Recall موردانتظار را می‌سنجد، نه Precision یا رتبه اول بودن را.

## راه‌حل پیشنهادی (تصمیم‌نشده؛ بدون Deploy)

۱. یک Topic Index مستقل و قابل Review با `topic_id`, `anchors`, `required_hit_count`, `document_ids` برای مفاهیم پرتکرار Non-Persist (ACK, 408/Timeout, Invalid Queue, Agent QC) اضافه شود؛ Keyها باید به مستند واقعی و Candidate/Trusted بودن آن اشاره کنند.

۲. در Scoring به‌جای Substring آزاد، ابتدا Tokenization مناسب English/Persian و Exact Token Match اعمال شود تا `ack` با `backlog/backpressure` یکی نشود؛ پسوندهای فارسی اعداد (مثل `408ها`) کنترل شوند.

۳. `fallback_only` نباید جای شواهد واقعی معرفی شود و Known Gapهای رسمی باید از فایل `mvp/validated-claims.yaml` با همان Guardrail قبلی مستقل بمانند.

۴. پیش از اصلاح Workflow فعال، نسخه Deploy و مسیر واقعی 호출 (`workflowId`) تأیید شود؛ در Run واقعی علاوه بر `retrieved_document_ids`، `fallback_only`, `selected_files_count`, `readiness/reason` و Source Evidence ثبت شوند.

۵. بعد از دریافت Actual از چهار Smoke Test، Root Cause تفکیک شود: `CATALOG`, `SELECTOR`, `LOADER`, `CHUNKING`, `READINESS`, `VERSION_MISMATCH` یا `NO_EVIDENCE`؛ سپس فقط Patch مناسب اعمال شود.

## تست‌های تکرارپذیر و محدودیت آن‌ها

- `retrieval_contract_regression.py` یک **Python port** از بخش‌های قابل مشاهده الگوریتم انتخاب در v0.18.1 است؛ `verified_catalog_minimal.yaml` نمای Metadata همان ۲۵ ورودی GitHub هنگام ممیزی است.
- ۴ Case مرجع در baseline: ۱ Case تمام اسناد مورد انتظار را دارد، ۳ Case فاقد مجموعه کامل.
- همان چهار Case با Topic Index پیشنهادی: ۴ Case تمام اسناد مورد انتظار را دارد. **۲ کنترل منفی** (عدم انطباق جعلی `ack` با `backlog`/`backpressure` و رعایت `fallback_only` برای ورودی بی‌معنا) موفق بود.
- در این Test Runner نه n8n، نه HTTP Request به GitHub، نه Source Investigator LLM و نه Knowledge Report واقعی اجرا نشده است.
- هرگونه تغییر Policy نیازمند Approval و Regression Test روی n8n فعال است.

## پذیرش فاز ۱ (Exit Gate)

| Gate | وضعیت | شاهد/مانع |
| --- | --- | --- |
| 25/25 catalog موجود و فاقد تکرار | PASS (GitHub static) | main/tree/fetch |
| ممیزی نسخه تاریخی v0.7 | DONE (archive) | PR #14 |
| بررسی نسخه جدیدتر موجود v0.18.1 | DONE (saved export) | نام/نودهای فایل Library؛ نودهای واقعی بازبینی شدند |
| بازتولید مسئله Selection و Regression پیشنهادی | PASS (offline simulation) | 1/4 → 4/4، ۲ تست منفی |
| نسخه **واقعاً فعال** n8n | BLOCKED / UNKNOWN | نیازمند Workspace export/Execution evidence؛ `active:true` در Export کافی نیست |
| ۴ اجرای واقعی Retrieval + readiness + final Agent Answer | BLOCKED / NOT RUN | بدون اتصال به n8n و Execution log |
| تأیید QA/PO/TL اصلاح Live | BLOCKED | پس از بررسی Runtime و نتیجه Test |

**حکم مدیریتی:** «فاز ۱ — کارهای قابل انجام آفلاین تمام شد؛ بسته Runtime Acceptance هنوز BLOCKED». تغییر وضعیت به «فاز ۱ کاملاً DONE» بدون چهار اجرای واقعی و شواهد نسخه فعال مجاز نیست. در این فاصله فاز ۲ می‌تواند آغاز شود، ولی وابستگی فاز ۱ در Issue #15 باز بماند.