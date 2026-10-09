---
doc_class: procedure
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
next_review_due: 2026-11-09
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/tree/781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs: []
---

# Async Observability — Investigation Playbooks (v1)

> **وضعیت:** Candidate Reference؛ راهنمای تحلیل برای بازبین انسانی و تحلیل‌گر. این فایل Policy سازمانی، Trusted Instruction، دستور تغییر تنظیمات یا مجوز خودکار اصلاح Production نیست. هر تشخیص نیازمند Evidence از Environment، نسخه Deploy، لاگ و Metric است.

## قرارداد عمومی تحلیل

**ورودی‌های لازم:** تاریخ/ساعت و Timezone، محیط، Cluster/Node، نسخه Deploy، Provider/Business، Metric Unit و Aggregation، Sample Raw Log سانسورشده، تغییرات اخیر و بازه Baseline قابل مقایسه.

**هر نتیجه در پنج سطح جدا شود:**
1. `FACT_FROM_SOURCE`: نقطه و منطق واقعی در نسخه مشخص Source.
2. `OBSERVED_IN_LOG`: واقعه قابل مشاهده با شناسه/بازه زمان.
3. `HYPOTHESIS`: علت احتمالی، همراه با آزمون تمایزبخش.
4. `CONFIRMED_CAUSE`: فقط بعد از شواهد چندمنبعی کافی.
5. `UNKNOWN`: اطلاعات غایب یا مبهم؛ جایگزین حدس نشود.

**خروجی Incident:** خلاصه، Scope، شدت بیزینسی، Evidence/Links، Correlation IDs، علل رقیب، اقدام اصلاحی اولویت‌دار، ریسک تغییر، آزمون تأیید بهبود و وضعیت Unknown.

## Playbook 1 — افزایش زمان پاسخ HTTP و Statusهای 408/500

**نشانه‌ها:** بالا رفتن `ServiceTimeLog.time`، افزایش `HttpLog.response_code`، WARN مربوط به parse/mediation/context یا Timeout.

**روش تمایز:**
- اختلاف بازه و Timezone در Kibana/Zabbix را برطرف کنید؛ خط پایه قبلی را با همان Provider/URI/ساعت/Load بسنجید.
- `ServiceTimeLog` را بر اساس Provider، Status، Host و URI گروه‌بندی کنید؛ P50/P95/P99 و نرخ درخواست را جداگانه ببینید.
- `HttpHandler` Threshold WARN، `HttpClient.onTimeout` و `HttpLog` را با `uuid`، `lastTrackerId` و Time Window تطبیق دهید.
- چک کنید آیا Delay نزدیک Timeoutهای ثابت تجمع یافته و آیا Listener واقعاً همان `trackerId` را Timeout کرده است.
- Zabbix: CPU، Memory/GC، Network، Thread Utilization و **Queue Size واقعی** را کنار هم بگذارید. از `jetty threadPoolSize` به عنوان عدد Pool Size استفاده نکنید.
- با شواهد، بین Wait در Async/Jetty، Downstream/Provider، DB/Queue و Timeout Policy تمایز بگذارید.

**خروجی قابل دفاع:** سهم هر Provider از خطا، تعداد تأییدشده Timeoutهای Correlated، و Unknownهای باقی‌مانده.

## Playbook 2 — ارسال ناقص یا پیام گم‌شده

**نشانه‌ها:** `BeforeSendLog` بدون AfterSend، `client not registered`، `timeout send message`، خطای `PersistenceException/ServerException`، اختلاف Pending/Delivered.

**روش:**
- `BeforeSendLog` و `AfterSendLog` را با `messageId + trackerId + client` در همان Time Window Join کنید. رخدادهای بیرون از Window یا Skip در Log Pipeline می‌توانند False Positive بسازند.
- Class Client (HTTP/WebSocket/ReceiverQueue) و Receiver Peer، ServerId و MessageServerId را لحاظ کنید.
- مسیر Receiver Resolution، Pending/Persistence و صف بین Nodeها را از `Server/MessageManager` بررسی کنید.
- برای تأیید Delivery نهایی، ACK/Response/Receiver-side Evidence نیاز است؛ فقط AfterSend کافی نیست.
- برای Duplicate به امکان ACK/Resend توجه کنید اما **معنای رسمی ACK و Retry Policy هنوز Known Gap است**.
- الگوی `AfterSendLog.time` منفی را از Lost Delivery جدا کنید؛ `writeMessageTime` شاخص محدودتری از مدت Send-call است.

**خروجی:** مرحله آخر تأییدشده، IDهای دارای شکاف، شواهد لازم برای تعیین Loss واقعی.

## Playbook 3 — Oracle ORA-00001 در addClient

**نشانه‌ها:** `An exception occurred in database, addClient` و `ORA-00001`، مشکل اتصال یا Register Client.

**روش:**
- `thrown` و `message` را جدا بررسی کنید؛ خطای SQL می‌تواند در `thrown` باشد.
- Query و Constraint تعریف‌شده برای `client_map` و آخرین وضعیت Row را با مجوز و ابزار امن DBA بررسی کنید؛ PeerId/TrackerId خام را در KB کپی نکنید.
- بررسی هم‌زمانی Register و ورود درخواست دوباره، تعداد Worker/Nodeها، Failover یا Retryهای ثبت Client.
- با مقایسه Eventهای قبل/بعد مشخص کنید آیا درخواست Client Fail شده یا مسیر جایگزین کار کرده است.
- صرف `ORA-00001` علت Race Condition را اثبات نمی‌کند.

**خروجی:** تکرارپذیری مشکل، Conflict Key Type، تأثیر ثبت Client و پیشنهاد Idempotency/Transaction فقط در صورت تأیید علت.

## Playbook 4 — Swagger/REST Provider یا قرارداد نامعتبر

**نشانه‌ها:** `swagger file is not valid`، `Can not get/update swagger file`، DNS/connection error، `version not found in Swagger`.

**روش:**
- زمان خطا را با زمان Refresh/Startup و آخرین تغییر Endpoint/Swagger تطبیق دهید.
- تشخیص بین مشکل Network/DNS، اعتبار ساختار Swagger، Version/Info و نبود Service Definition.
- بررسی کنید نسخه قبلی Descriptor در Cache/Runtime فعال مانده یا Load سرویس واقعاً Fail شده است.
- در Kibana درخواست‌های HTTP واقعی همان Provider را پیش/پس از خطا مقایسه کنید.

**خروجی:** وضعیت دسترسی/قرارداد و اثر واقعی بر Provider، بدون تعمیم خطای Loading به همه درخواست‌ها.

## Playbook 5 — Queue/Broker و اشباع پردازش

**نشانه‌ها:** `Invalid Queue Name`، `JMSException`، Reconnect Loop، `Internal Message Sender ThreadPool is almost full`، کندی DB، افت Throughput.

**روش:**
- تفکیک کنید Logger به Queue داخلی، Producer/Consumer، Artemis/ActiveMQ یا Thread Pool اشاره دارد؛ فقط شباهت نام «Queue» کافی نیست.
- Zabbix: Queue Depth، Active Threads، Busy/Idle Connections، Broker Health، DB Connection/Latency، CPU/GC را با زمان رخداد تطبیق دهید.
- `MessageCRUD.createAsyncActiveMessage` را با توجه به `IS_INSERT_TO_DB_ENABLE` و `getTaskCount() > ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE` بررسی کنید. `getTaskCount()` **تجمعی** است و به معنای Queue Depth نیست؛ رد شدن submit یک Code-risk کاندید است.
- برای تست تغییر، فراتر از ۵۰۰ Task تکمیل‌شده Run کنید، هنگام Idle بودن Task جدید ارسال کنید و **ثبت نهایی DB** را کنترل کنید؛ Production test بدون تأیید تیم مجاز نیست.
- نبود Error متناظر در یک نمونه کوتاه، خطای کد را رد نمی‌کند.

**خروجی:** وضعیت Backpressure/Queue/DB و اثر بر Persist/Delivery با Proof قابل سنجش.

## Playbook 6 — افزایش Rate Limit / WebSocket failure

**نشانه‌ها:** افزایش 429/451 یا `Request blocked due to rate limit`؛ `OpenClientAddressLog`، `WebsocketAddressLog` و `on error in websocket`.

**روش:**
- HTTP Status ثبت‌شده را با Type و Key Rate Limit (IP/Business/Provider/Service)، Config هر Cluster و Source IP مورد اعتماد تطبیق دهید.
- RateLimitLog در مسیر بررسی‌شده DEBUG است و ممکن است اصلاً قابل مشاهده نباشد؛ `nanoTime` Timezone ندارد.
- برای WebSocket، نرخ Open/Close/Error را در کنار Connected/NotRegistered/Expired و Memory/CPU ببینید؛ Log لحظه Open یک Snapshot است.
- افزایش Block یا OpenClient به‌تنهایی اثبات Attack نیست؛ الگوی درخواست‌های معتبر و تغییرات Client/Release را بررسی کنید.

## Playbook 7 — نقص کیفیت Logging یا خطر داده حساس

**نشانه‌ها:** اختلاف عدد نمودارها، Latency منفی، نبود Log با وجود اجرای کد، MessagePreview حاوی Payload، برچسب متریک نادرست.

**روش:**
- اختلاف زمان Producer/Node، Timezone، NTP/Clock Skew و مبنای `time`/Epoch/Nano را تفکیک کنید.
- جمع تعداد رویدادها را فقط روی Window، Host، Environment و Filter مشترک انجام دهید.
- Logger Level، Appender، Log Shipper، Index Mapping، Sampling، Retention و فیلدهای Masking را کنترل کنید.
- `ServiceCallServlet` و `ServiceTimeLog.messagePreview` را برای PII/Secrets بررسی کنید؛ Raw Content و Token هرگز در Issue یا KB منتقل نشوند.
- هر Dashboard باید نام Metric، Unit، Aggregation، Query و Source-of-truth را نشان دهد.

## Validation/Evidence checklist برای فردا

- Kibana screenshot + Query/Index/DataView + Filter + Timezone + Aggregation.
- Zabbix screenshot + Item Key + Host/Node + Unit + Collect Interval.
- Sanitized JSON Log samples (Structured + Text) برای همان بازه.
- Mapping of Host-to-Cluster and deployed Release/Commit.
- Baseline عادی در همان ساعت و Load، به‌علاوه زمان Deployment/Config change.

## Cross-reference
- **معنای سورس:** `source-logging-semantics.md`
- **شواهد تاریخی:** `historical-runtime-evidence-2026-08-18.md`
- **محدودیت دانش:** `mvp/validated-claims.yaml` و بررسی Human Owner

این Playbookها Reference برای تحلیل‌اند، نه حکم قطعی درباره وجود مشکل و نه اجازه تغییر خودکار Production.
