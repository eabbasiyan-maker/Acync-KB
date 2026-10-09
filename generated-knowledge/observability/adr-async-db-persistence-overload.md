---
doc_class: decision-proposal
trust_level: untrusted-content
lifecycle: living
confidence: high
verification: source-and-isolated-reproduction
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
decision_status: PROPOSED_NOT_APPROVED
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# ADR — سیاست ایمن اشباع صف ثبت غیرهم‌زمان پیام در ایسینک

**وضعیت:** پیشنهاد قابل بررسی توسط TL/QA/SRE/PO؛ هیچ تصمیم نهایی، اصلاح Production یا ضمانت Delivery صادر نشده است.

## مسئله با شواهد قطعی

- `MessageCRUD.createAsyncActiveMessage` در [سورس نسخه مرجع](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L19-L62) از `Executors.newFixedThreadPool` با ThreadCount پیش‌فرض 100 استفاده می‌کند.
- اگر `IS_INSERT_TO_DB_ENABLE=true` باشد، شرط `getTaskCount() > ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE` با Threshold پیش‌فرض 500 مانع ارسال Task بعدی می‌شود؛ فقط ERROR ثبت می‌کند و شکست را به Callers گزارش نمی‌کند.
- `getTaskCount` مجموع تقریبی Taskهای برنامه‌ریزی‌شده از آغاز عمر Executor است، نه Queue Size. طبق [Java Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html#getTaskCount()) این مقدار تجمعی است.
- در تست ایزوله روی **کلاس واقعی** `MessageCRUD.java` و Stubهای DB، بعد از بیش از Threshold Task تکمیل‌شده با صف خالی، سه درخواست جدید اجرا نشدند. [PR #7](https://github.com/eabbasiyan-maker/Async-Source/pull/7) یک **اصلاح محدود کاندید** ارائه کرده و روی همان تست، Taskها مجدداً ارسال شدند.
- **مهم:** `newFixedThreadPool` به‌طور پیش‌فرض صف نامحدود دارد؛ صرف بررسی `getQueue().size()` روش صحیح کنترل ظرفیت همزمان/دائمی نیست و زیر فشار واقعی همچنان ممکن است Task بدون نتیجه قابل پیگیری کنار گذاشته شود.
- `createAsyncActiveMessage` در **هفت نقطه فراخوانی** داخل `MessageManager`، `Server` و `AsyncProducer` استفاده می‌شود؛ (۳ مورد در `Server.java`، ۲ مورد در `MessageManager.java` و ۲ مورد در `AsyncProducer.java`)؛ از جمله مسیر گیرنده Offline و مسیر جبران خطای JMS. شمارش هشت‌تایی قبلی، تعریف خود متد را هم حساب کرده بود. اثر Runtime بر پیام‌ها هنوز بررسی نشده است.

## تصمیم موردنیاز مالک فنی

**D1: تضمین پذیرش Task ثبت پیام** — در زمان اشباع، آیا درخواست باید:
- **گزینه A — Fail-Fast و Retry کنترل‌شده:** صف واقعاً Bounded، Rejection صریح با Exception/Result قابل ردیابی و تعریف مسیر Durable Retry یا نتیجه خطا به Caller. مزیت: فشار کنترل‌شده و خطا آشکار؛ ریسک: Callers فعلی برای Exceptionهای جدید، Idempotency و Retry نیازمند ممیزی‌اند.
- **گزینه B — Backpressure در Thread فراخوان:** صف Bounded و اجرای Work در Thread فراخوان با سیاست مشخص و Time Budget، بدون ثبت Silent Drop. مزیت: کاهش نرخ ورود به‌صورت طبیعی؛ ریسک: گسترش Latency و اشغال Threadهای ارتباطی در DB کند یا قطع‌شده. `CallerRunsPolicy` هنگام Shutdown می‌تواند کار را کنار بگذارد؛ به‌تنهایی ضمانت Durable نیست.
- **گزینه C — Durable Buffer قبل از Worker:** پیام قبل از ACK به Durable Queue/DB یا مسیر معتبر انتقال یابد، سپس Worker با Retry/Idempotency اقدام کند. مزیت: مرزبندی قابل دفاع Persistence؛ ریسک: تغییر معماری، Capacity Planning و پیامد Ordering/Duplicate.

**توصیه پیشنهادی (تصمیم نشده):** برای دوام بلندمدت، C یا A با Durable Retry؛ صرف `getQueue().size()`، افزایش Threshold یا CallerRuns بدون سیاست Shutdown و DB Failure را به‌عنوان ضمانت ایمنی قبول نکنیم.

**D2: قرارداد پاسخ و ACK:** تعیین شود کدام مرحله را مجازیم `PERSISTED`, `ENQUEUED`, `SENT` یا `ACKED` بنامیم؛ طبق Source فعلی `AfterSendLog` اثبات دریافت/پایداری نهایی نیست.

**D3: Exception داخل Worker:** `submit()` یک Future برمی‌گرداند که در Source فعلی بررسی نمی‌شود؛ Failure داخل `createActiveMessage` ممکن است از مسیر Exception قابل مشاهده Caller جدا بماند. تعیین Logger/Metric، Retry محدود و Dead-Letter لازم است.

**D4: Feature Flags و Version:** پیش از ادعای Production، `IS_INSERT_TO_DB_ENABLE`، نوع DB، Deploy SHA، Cluster/Node و Queue Configuration را بررسی کنید.

## Test Matrix برای QA/TL (پذیرش اصلاح نهایی)

| Case | Scenario | Outcome مورد انتظار |
| --- | --- | --- |
| QA-DB-01 | بیش از 500 Task تکمیل شده، Queue خالی، Task جدید | قبول یا Failure شفاف مطابق قرارداد؛ هرگز رد به‌دلیل شمارنده تجمعی |
| QA-DB-02 | همزمانی چند Producer و Queue در آستانه | Bounded Capacity رعایت، Oversubscription کنترل و نتیجه هر Task قابل ردیابی |
| QA-DB-03 | DB کند/قطع، بیش از ظرفیت واقعی | Backpressure/Explicit Retry/Error؛ بدون ACK یا Success کاذب |
| QA-DB-04 | Shutdown/Restart هنگام Queue غیرخالی | سرنوشت Pending مشخص؛ اثبات Recovery یا Rejection |
| QA-DB-05 | Worker با RuntimeException شکست می‌خورد | Error و MessageId امن در Log/Metric، Retry محدود، عدم پنهان شدن Failure |
| QA-DB-06 | Active/Offline/Inter-Server JMS Failure paths | اثر پاسخ Caller و Persist/ACK روی تمام Call Sites ردیابی شود |
| QA-DB-07 | Duplicate/Retry/Out of Order | Idempotency و Ordering طبق قرارداد رسمی |
| QA-DB-08 | تست طولانی روی Sandbox با نرخ واقعی | Queue Depth, Active, Completed, Rejected, DB Latency, Lost/Duplicate مشخص باشند |

## Observability contract پیشنهادی

Counters: `async_db_persist_requested_total`, `enqueued_total`, `succeeded_total`, `failed_total`, `rejected_total`, `retry_total`, `dropped_total` **در صورت تعریف دقیق**.

Gauges/Histograms: `async_db_persist_queue_depth`, `active_workers`, `oldest_task_age_ms`, `persist_latency_ms`.

For safe correlation: MessageId/TrackerId and node/cluster; never raw payload/token; labels with cardinality limits.

**SLO/Alert threshold:** UNKNOWN تا زمان داشتن Baseline واقعی Zabbix/Kibana و تأیید ذی‌نفع.

## ارتباط کارها

- [Source P0 Issue #1](https://github.com/eabbasiyan-maker/Async-Source/issues/1) — باز می‌ماند تا Resolution واقعی ظرفیت/Retry و اثر Persistence روشن شود.
- [Source PR #7](https://github.com/eabbasiyan-maker/Async-Source/pull/7) — اصلاح محدود شمارنده، نه راه‌حل کامل.
- [Acync-KB Issue #5](https://github.com/eabbasiyan-maker/Acync-KB/issues/5) — نیاز به نسخه Deploy و Metrics Logging.
- [Acync-KB Issue #6](https://github.com/eabbasiyan-maker/Acync-KB/issues/6) — نیاز به Baseline متریک‌ها.
- [Project Control Center](project-control-center.md).

**DoD این ADR:** تصمیم مورد تأیید TL/PO + Evidence تست ماتریس + Plan Rollout/Rollback + SRE/QA Approval. وضعیت فعلی: OPEN.
