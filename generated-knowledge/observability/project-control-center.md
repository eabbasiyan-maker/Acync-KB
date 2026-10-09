---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: project-evidence-linked
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async Observability — مرکز کنترل پروژه / PM Control Center

**As of 2026-10-09** — این صفحه وضعیت واقعی مستندات، تست‌های اجراشده، وظایف ایجادشده و وابستگی‌هایی را نشان می‌دهد که بدون دسترسی محیط یا تأیید مالک فنی قابل خاتمه نیستند. هیچ تعهدی به اجرای خودکار در آینده یا وضعیت Production اعلام نمی‌شود.

## دستاوردهای انجام‌شده

- [PR #2 (merged)](https://github.com/eabbasiyan-maker/Acync-KB/pull/2) — تفکیک Source Knowledge، Historical Runtime Evidence و Incident Playbooks.
- [PR #3 (merged)](https://github.com/eabbasiyan-maker/Acync-KB/pull/3) — رجیستری **۹۵۶** نقطه Logging؛ تطبیق ۹۵۳ مورد قدیمی، کنترل مسیر و خط سورس، گزارش شکاف‌ها.
- [PR #4 (merged)](https://github.com/eabbasiyan-maker/Acync-KB/pull/4) — تحلیل عمقی **لاگ‌های حیاتی**، قرارداد Correlation، Runtime Handoff، ابزار تست تکرارپذیر و QC Agent.
- [Historical QA result](historical-qa-results.md) — **۱۷/۱۷** تست خودکار سورس و لاگ‌های **تاریخی** موفق. **آزمون خود Agent و Production انجام نشده است.**
- [Registry Index](registry-v1/registry-index.md)، [Critical Source Traces](source-reviewed-critical-signatures.md)، [Correlation Contract](correlation-and-data-contract.md)، [Runtime Checklist](runtime-validation-handoffs.md)، [15 Agent QC Cases](agent-qc-cases.md)، [Delivery Board](delivery-board.md).

## وضعیت فنی و اعتبار

| جریان | وضعیت واقعی | معنی |
| --- | --- | --- |
| موجودی Source Logging | **DONE — Candidate** | ۹۵۶ Call Site با شناسنامه اولیه و شاهد سورس |
| مسیرهای حیاتی و Correlation | **DONE — Source Design/Partial Historical Check** | رفتار Source مرور شده، روش Join تست تاریخی دارد؛ فعال‌بودن در Production هنوز تأیید نشده |
| آزمون آفلاین | **DONE — 17/17** | فقط روی Snapshot Source و دو فایل قدیمی |
| Kibana، Zabbix، Config Runtime | **BLOCKED** | دسترسی مستقیم و شواهد نسخه Deploy وجود ندارد |
| اصلاح کدهای دارای ریسک | **OPEN ENGINEERING ISSUES** | هیچ اصلاحی در Source/Production اعمال یا Deploy نشده |
| QC واقعی Agent | **BLOCKED** | سناریوها طراحی شده ولی Agent اجرا نشده |
| Trusted Promotion | **BLOCKED — Human Owner Approval** | تمام اسناد همچنان Candidate هستند |


## پیشرفت 2026-10-09 — کاندیدهای اصلاح سورس (نیازمند TL/QA/SRE)

- **[PR #7 — MessageCRUD Queue Gate](https://github.com/eabbasiyan-maker/Async-Source/pull/7):** رفع محدود مشکل `getTaskCount` تجمعی؛ تست JDK ایزوله روی کلاس واقعی: Original PASS برای بازتولید خطا، Fixed PASS برای رفع همان سناریو. مشکل Silent Drop زیر اشباع، Retry و خطای Worker **هنوز حل نشده**. **P0 Issue #1 باز است**؛ [ADR پیشنهادی](adr-async-db-persistence-overload.md) تصمیم‌های باقی‌مانده را ثبت می‌کند.
- **[PR #8 — Jetty Metric Labels](https://github.com/eabbasiyan-maker/Async-Source/pull/8):** جداسازی `queueSize` و `threadPoolSize` واقعی؛ تست JDK Stub کلاس واقعی موفق. Release Gate: سازگاری Log Parser/Kibana/Alert و تأیید Jetty 12.0.13.
- **[PR #9 — Management Log Redaction](https://github.com/eabbasiyan-maker/Async-Source/pull/9):** حذف دو ثبت مستقیم درخواست خام از `ServiceCallServlet`؛ تست ایستا 2→0 PASS. همچنان Security/QA باید سایر Exception/Preview/Channelها را تأیید کنند.
- **[PR #11 — ServiceCall Duration](https://github.com/eabbasiyan-maker/Async-Source/pull/11):** رفع محدود Duration صفر در شاخه IOException با شروع زمان قبل از فراخوانی؛ تست ایستای Original/Fixed موفق. مرز بین Destination Response و Client Write Exception و Status Synthetic هنوز نیازمند تصمیم TL است.
- **[Security Investigation #10 — TLS validation](https://github.com/eabbasiyan-maker/Async-Source/issues/10):** TrustManager با Validation خالی و NoopHostnameVerifier در ServiceCallProxy مشاهده شد. این یک ریسک قابل بررسی از سورس است؛ وضعیت Deploy واقعی UNKNOWN و فعال‌کردن اعتبارسنجی صحیح بدون آماده‌سازی Truststore ممکن است اتصال موجود را مختل کند.
- **وضعیت عملیاتی:** هیچ‌یک از PRهای سورسی #7، #8، #9 یا #11 Merge/Deploy نشده و هیچ تست Integration/Production PASS ادعا نشده است. همه Issueها بازند و تکمیل پروژه همچنان به شواهد Runtime، تصمیم Backpressure و QC واقعی Agent وابسته است.


## پیشرفت تکمیلی — Log Diagnostics v2 و تصحیح شمارش Source

- **[CLI تحلیل لاگ‌ها](tools/async-log-diagnose-README.md):** ابزار Python فقط‌خواندنی، دو نمونه JSONL Async را به شمارش‌های تجمیعی و Correlation زمان‌مند تبدیل می‌کند؛ هیچ IP، شناسه، متن Payload یا Raw Message در خروجی ذخیره نمی‌کند. هر نتیجه `SAMPLE_ONLY` است، نه RCA یا حکم Production.
- **[۸ آزمون Privacy/Correlation](tools/test_async_log_diagnose.py):** 8/8 PASS (Synthetic fixtures) شامل تکرار TrackerId در Nodeهای مختلف و زمان‌های دور، عدم Reuse یک Status 408 برای دو Timeout، خطای JSON و نشت ندادن اطلاعات خام.
- **[Historical Aggregate v2](tools/historical-aggregate-v2.json):** بازاجرای نمونه‌های ۱۸ اوت: ۱۵٬۵۹۲ JSON + ۱۷٬۰۷۲ Text، ۶٬۶۸۵ جفت Send Attempt، ۲۸ Join معتبر 408/Timeout، و ۴٬۰۳۲ رویداد EmbeddedBroker. این Snapshot قدیمی کامل‌کننده وضعیت جاری نیست.
- **تصحیح Evidence:** فراخوانی‌های واقعی `MessageCRUD.createAsyncActiveMessage` برابر **۷ مورد** در Source Snapshot هستند (Server: 3، MessageManager: 2، AsyncProducer: 2). تعریف متد در شمارش هشت‌تایی قبلی اشتباهاً لحاظ شده بود. [ADR اصلاح‌شده](adr-async-db-persistence-overload.md).
- **مرز QC:** آزمون‌های بالا روی **ابزار تحلیل محلی** اجرا شده‌اند، نه روی Agent واقعی، Kibana یا Production. Issueهای Runtime و Agent همچنان باز هستند.

## Backlog اجرایی در GitHub

### مهندسی — ریپوی Async-Source
- **P0:** [#1: بررسی توقف ثبت DB غیرهم‌زمان به دلیل getTaskCount تجمعی](https://github.com/eabbasiyan-maker/Async-Source/issues/1) — TL + QA؛ تست >۵۰۰ Task و اثر ثبت پیام.
- **P1:** [#2: اصلاح زمان و Status خطا در ServiceCall](https://github.com/eabbasiyan-maker/Async-Source/issues/2) — TL ServiceCall + QA.
- **P1:** [#3: اصلاح نام Jetty Queue/Thread metrics](https://github.com/eabbasiyan-maker/Async-Source/issues/3) — TL + SRE.
- **P1:** [#4: ممیزی Masking درخواست مدیریتی و messagePreview](https://github.com/eabbasiyan-maker/Async-Source/issues/4) — Security + TL + QA.
- **P1:** [#5: تکمیل Stageها و Correlation برای ACK/Retry](https://github.com/eabbasiyan-maker/Async-Source/issues/5) — Messaging TL + SRE + QA.
- **P2:** [#6: بررسی RateLimitLog و ADDRESSLOG](https://github.com/eabbasiyan-maker/Async-Source/issues/6) — TL + SRE.

### پایگاه دانش و اعتبارسنجی — ریپوی Acync-KB
- **R1:** [#5: نسخه Deploy، Log Routing و Kibana field mapping](https://github.com/eabbasiyan-maker/Acync-KB/issues/5) — SRE/Operations؛ **ورودی گلوگاهی**.
- **R2:** [#6: Metric Dictionary و Baseline واقعی Zabbix](https://github.com/eabbasiyan-maker/Acync-KB/issues/6) — SRE/Operations؛ **ورودی گلوگاهی**.
- **R3:** [#7: اجرای ۱۵ QC case روی Agent واقعی](https://github.com/eabbasiyan-maker/Acync-KB/issues/7) — QA/PO؛ وابسته به ورودی‌های R1/R2 و Agent.
- **R4:** [#8: ارتقای Triggerهای پرریسک از UNKNOWN با Call Chain](https://github.com/eabbasiyan-maker/Acync-KB/issues/8) — TL/KB؛ قابل انجام هم‌زمان با R1/R2.

**توجه:** Ownerها به صورت نقش پیشنهاد شده‌اند؛ هیچ فردی بدون پذیرش مسئولیت Assign نشده است. موعدهای Task باید توسط تیم تأیید شوند.

## ترتیب اجرایی و Dependency

1. **فوری:** TL مسئله P0 را Reproduce/Triage کند و هم‌زمان SRE شواهد R1 را جمع کند. **امکان وقوع خطا ≠ اثبات وقوع در Production.**
2. **پس از شناسایی نسخه و فیلدهای واقعی:** R2 و بررسی متریک‌ها، اصلاحات P1 بر اساس اثر و قابل مشاهده‌بودن.
3. **پس از وجود Evidence معتبر:** اجرای سناریوهای QC #7 و اصلاح Prompt/KB در موارد Fail.
4. **برای خاتمه:** PO/TL/SRE/QA و Security هر Claim متناسب را بررسی کنند؛ فقط Claimهای تأییدشده به سطح Trusted ارتقا یابند.

## یافته‌ای که بررسی آینده را تغییر می‌دهد

دو نمونه قدیمی از بازه‌های برابر نیستند. همچنین ۴٬۰۳۲ رویداد تاریخی مربوط به `EmbeddedBroker` اند که Source این کلاس در آرشیو ارائه‌شده نیست؛ از جمله ۱۱۸ هشدار Invalid Queue Name. بدون نسخه Deployment همان دوره، RCA این خانواده **UNKNOWN** می‌ماند.

## معیار خاتمه پروژه

- هر Environment هدف، نسخه Deploy و Logger/Index/Metric Mapping تأییدشده داشته باشد.
- Call Chain و Trace هر مسیر بحرانی با شواهد قابل تکرار پوشش داده شده باشد.
- وضعیت P0 مستند و با شواهد حل‌شده یا با Risk Acceptance امضا شده باشد.
- داشبوردهای ضروری با Unit و Alertهای قابل دفاع اعتبارسنجی شوند.
- ۱۵ سناریوی Agent اجرا، ارزیابی و HITL-approved شوند؛ Privacy/Prompt Injection بدون خطای حیاتی.
- مستندات Candidate با Approval مرحله‌ای Promote شوند، بدون Bulk Approval.

**این معیارها هنوز همگی محقق نشده‌اند.** بسته Source/Historical و تست آفلاین تمام شده؛ مراحل نیازمند محیط اجرا و Human Approval در Issueها قابل پیگیری هستند.

## Stage 5/27 — Issue/PR inventory and review gate (2026-10-09)

**Status: COMPLETE for inventory and review-state audit; engineering approvals and merges remain OPEN.**

- Existing issue inventory: Async-Source #1–#6 and #10 (7 issues); Acync-KB #5–#8 (4 issues). No duplicate issue created. This is an inventory of known relevant issues, not a declaration that every issue is resolved.
- Source PR #7 (DB persistence), #8 (Jetty metrics), #9 (sensitive management request logging), #11 (ServiceCall duration): all **OPEN, NOT MERGED, NOT DRAFT** at review time.
- GitHub review submissions: **0** for each of the four PRs. Review threads: **0** each. Returned PR discussion comments: **0** each. No recorded TL/QA/SRE/Security approval; no claim about off-GitHub approvals.
- #7 is a partial candidate fix only: cumulative getTaskCount gating corrected, but bounded queue/backpressure, worker exception reporting, retry/ACK and shutdown behavior remain unresolved; retain P0 issue #1.
- #8 requires SRE/TL validation of downstream log parser, Kibana and metric names. #9 requires Security/QA privacy validation beyond removed raw body lines. #11 requires TL/QA validation of synthetic status, exception branches and elapsed-time semantics.
- Dependency sequence: P0 #1 + PR #7 technical decision; KB #5 deployed revision and Kibana mapping; Security #10/#4 and PR #9; Source #5 correlation; KB #6 metric baselines; KB #7 Agent QC. Do not merge/deploy or close issues without owner approval and runtime evidence.
- **Stage completion means the inventory and PR-review-state audit is finished, NOT that fixes were approved, merged, tested in Production or deployed.**
