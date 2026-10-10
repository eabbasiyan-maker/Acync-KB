---
doc_class: observation
trust_level: untrusted-content
lifecycle: proposed
confidence: medium
verification: github-main-catalog-and-archived-workflow-contract-test
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
---

# Async Observability — فاز ۱ از ۴: ممیزی قابلیت بازیابی دانش

**تاریخ بررسی:** 2026-10-10  | **وضعیت فاز:** PARTIAL / RUNTIME BLOCKED  | **دامنه:** Non-Persist، صرفاً خواندنی

## هدف و مرز شواهد

این ممیزی می‌سنجد آیا دانش Observability در کاتالوگ GitHub موجود و از دید قرارداد نسخه *آرشیوی* Workflow قابل بازیابی است. **این نتیجه، آزمون n8n در حال اجرا، آزمون واقعی Agent، یا اثبات رفع اشکال Runtime نیست.** نسخه آزمایش‌شده از ZIP ارائه‌شده توسط PO استخراج شده است:

`kB/Async Knowledge Agent - GitHub RAG + DeepSeek v0.7.0.json`

نسخه Workflow فعال و خروجی اجرای آخر n8n تأیید نشده‌اند. بنابراین یافته‌های وابسته به کد Workflow برچسب **ARCHIVED_WORKFLOW_ONLY** دارند.

## کنترل‌های انجام‌شده روی GitHub main

- [Catalog](../../async-knowledge-catalog.yaml) — ۲۵ مدرک فهرست‌شده، ۲۵ مسیر موجود در Tree و ۲۵ فایل قابل Fetch؛ **۰** شناسه تکراری، **۰** مسیر تکراری و **۰** فایل گمشده.
- تعداد اسناد متعلق به Observability برابر **۱۴** است: `operations=6`، `observation=2`، `procedure=4`، `gap=1` و `decision-proposal=1`.
- **۲۴/۲۵** سند کاتالوگ دارای Front Matter با `trust_level: untrusted-content` هستند. مورد بدون Front Matter: `generated-knowledge/observability/tools/async-log-diagnose-README.md`؛ مسیر فایل معتبر است، اما Metadata یکنواخت نیست. به‌معنی رد شدن توسط n8n نیست.
- `mvp/validated-claims.yaml` در مسیر خودش قابل Fetch است؛ هیچ ادعای Trusted در این ممیزی تغییر نکرد.

## یافته‌های قرارداد نسخه آرشیوی v0.7.0

### R-01 — انواع سند حذف‌شده از Retrieval

در Node `Load Context Rule`، هیچ‌یک از سه Task Type (`technical-question`, `troubleshooting`, `contract-change`) انواع `procedure`، `observation`، `gap` یا `decision-proposal` را در `required_types` یا `optional_types` نمی‌پذیرد. Node `Retrieval v0.6` اسناد را با شرط `allowed.has(d.type)` حذف می‌کند **پیش از محاسبه امتیاز کلمات**.

**اثر روی کاتالوگ موجود اگر همین منطق اجرا شود:** ۱۰/۲۵ سند هرگز در `retrieved_knowledge` قرار نمی‌گیرند؛ **۸ مورد از ۱۴ سند Observability** از جمله Playbookها، گزارش Runtime تاریخی، طرح‌های QC و راهنمای تحلیل آفلاین حذف می‌شوند. فقط شش سند Observability از نوع `operations` از فیلتر نوع عبور می‌کنند؛ این به معنی رتبه گرفتن یا بازیابی قطعی آن شش سند نیست.

**نکته:** `known_gap`های رسمی در `mvp/validated-claims.yaml` یک مسیر جداگانه دارند و این محدودیت نوع سند به‌تنهایی به معنی حذف Known Gapهای رسمی نیست.

### R-02 — Readiness ممکن است حتی با سند مرتبط به NOT_READY برسد

در نسخه آرشیوی، `troubleshooting` به `flow` و `technical-question` به `architecture` به‌عنوان نوع اجباری نیاز دارند. در یک ورودی **کاملاً ساختگی** که تنها سند مرتبط از نوع `operations` باشد، خروجی `Build Context + Readiness` دقیقاً `NOT_READY/MISSING_REQUIRED_TYPE` است؛ درحالی‌که همان `operations` واقعاً در Retrieval انتخاب شده است. این رفتار برای هر سه Task Type با سند مثبت `operations` به‌عنوان کنترل آزمایش شد. **نتیجه برای داده Production یا اسناد واقعی مشخص نشده است.**

### R-03 — تورفتگی YAML توضیح‌دهنده رفتار Parser قدیمی نیست

Node `Parse Catalog YAML` نسخه آرشیوی خط‌ها را با `.trim()` می‌خواند و سپس `line.startsWith('- id:')` را بررسی می‌کند. دو ورودی ساختگی با تورفتگی صحیح و ناصحیح در این Parser **خروجی یکسان** دارند. اصلاح تورفتگی YAML در PR #13 برای Syntax استاندارد مفید است، اما **نباید به عنوان شاهد اینکه نسخه آرشیوی n8n پیش از آن Catalog را نمی‌خوانده معرفی شود.** در نسخه فعال احتمالاً Parser متفاوت است؛ بررسی لازم است.

## نتایج تست قابل بازتولید

ابزار `test_archived_retrieval_contract.py`، کد واقعی Nodeهای `Load Context Rule`، `Retrieval v0.6`، `Build Context + Readiness` و `Parse Catalog YAML` را از همان JSON Workflow آرشیوی استخراج و با Node.js و *اسناد ساختگی* اجرا می‌کند.

- **PASS** — سه Task Type؛ اسناد `operations` در Retrieval باقی می‌مانند و چهار نوع جدید حذف می‌شوند.
- **PASS** — در هر سه Task Type وقتی نوع اجباری غایب است، `NOT_READY/MISSING_REQUIRED_TYPE` تولید می‌شود.
- **PASS** — Parser آرشیوی، فهرست با تورفتگی مختلف را یکسان می‌خواند.
- **NOT RUN** — درخواست واقعی به Workflow/n8n فعال؛ ورودی/خروجی واقعی Agent؛ استفاده از نسخه احتمالی جدیدتر v0.16.0؛ Index/Runtime Live.

اجرای آفلاین محلی:

```bash
python3 test_archived_retrieval_contract.py --zip '/path/to/kB (2).zip'
```

پیش‌نیاز: Python 3.10+ و Node.js؛ **نیازی به شبکه، توکن، n8n یا Production نیست**. داده ساختگی است.

## برای بستن فاز ۱ چه لازم داریم؟

**RUNTIME BLOCKED:** به نسخه فعال Workflow در n8n و خروجی یک Run واقعی دسترسی مستقیمی در این اجرا نبود. برای تست واقعی چهار ورودی زیر لازم است (بدون هیچ Token یا Log خام):

| پرسش تست | سند مورد انتظار برای بازیابی | نتیجه فعلی |
| --- | --- | --- |
| «BeforeSend و AfterSend آیا ACK نهایی را اثبات می‌کند؟» | `async-observability-source-semantics` و `async-message-delivery-flow`؛ تفکیک UNKNOWN از ACK | NOT RUN |
| «در لاگ‌های قدیمی، همه Status 408ها قطعاً Listener Timeout بوده‌اند؟» | `async-observability-historical-2026-08-18` و `async-observability-correlation-contract` | NOT RUN |
| «برای Invalid Queue Name چه مسیر بررسی و محدودیت نسخه سورس داریم؟» | `async-observability-investigation-playbooks` و `async-observability-historical-2026-08-18` | NOT RUN |
| «۱۵ معیار QC Agent کجا ثبت شده‌اند؟» | `async-observability-agent-qc-cases` | NOT RUN |

از هر Run این پنج فیلد را بدون داده حساس ثبت کنیم: **workflow_name/version/commit**؛ `catalog_docs_count` و `selected_files_count`؛ `retrieved_knowledge[].id/type/score`؛ `readiness/reason`؛ `error_code` و زمان اجرا. نباید برای رفع ظاهری، `required_types` را بی‌بررسی حذف کنیم؛ قواعد Truth/Known Gap و Context Readiness باید حفظ شوند.

## تصمیم پیشنهادی برای TL/Owner — هنوز تصویب نشده

۱. تعیین نسخه واقعی در حال اجرا و مقایسه `Load Context Rule`، `Retrieval` و `Build Context + Readiness` با نسخه آرشیوی؛ ۲. اگر فیلتر ناسازگار در نسخه فعال هم هست، افزودن دسته‌های مرتبط به Rule با **Policy مجزا برای Candidate و Known Gap** و آزمون رگرسیون؛ ۳. بازنگری `required_types` برای سناریوی RCA بدون تنزل Guardrailهای Readiness؛ ۴. ثبت Actual/Expected چهار Smoke Test و فقط سپس اعلام PASS واقعی Retrieval.

**نتیجه مدیریتی:** Registry سالم و اسناد GitHub موجودند؛ **سلامت بازیابی Agent هنوز UNKNOWN/BLOCKED است** و اگر Logic قدیمی در Runtime باقی مانده باشد، بخش مهمی از Observability Knowledge برای Agent ناپیدا می‌ماند.