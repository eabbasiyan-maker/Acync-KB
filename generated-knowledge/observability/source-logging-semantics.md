---
doc_class: fact
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

# Async Observability — Source Knowledge (v1)

> **حدود سند:** معنای لاگ و شرایط تولید آن در سورس Async-Source، نه فراوانی رخداد، سلامت محیط Production، SLA یا Contract رسمی. این سند «کاندید» است. هیچ داده خام، شناسه شخصی، Token یا محتویات Payload نمونه‌های لاگ در آن قرار نگرفته است.

## نقشه عملیات و رویدادها

### ورود درخواست HTTP
- `HttpRequestLogger.log` یک `HttpLog` می‌سازد: `http_method`, `uri_path`, `response_code`, `businessId`, `original_src`, `http_x_forwarded_for`, `bytes_in/out`, `req_time`, `timestamp`.
- `original_src` آدرس Remote مشاهده‌شده در سطح Jetty است؛ `http_x_forwarded_for` مقدار Header است و بدون زنجیره Proxy مورد اعتماد، «IP واقعی» تلقی نمی‌شود.
- `HttpHandler` نقاطی با WARN برای تجاوز از `HTTP_THRESHOLD_TIME` دارد: `parsRequest`، `mediateReceive` و `async context start`؛ این‌ها یکسان با End-to-End Latency نیستند.
- در مسیر نهایی `HttpHandler`، اگر `startTime` موجود باشد، `ServiceTimeLog` ثبت می‌شود. `time = currentTime - startTime` و `clientTime = currentTime - clientMessage.getTime()` (یا صفر اگر پیام Client نباشد). این دو مدت‌زمان مرزهای متفاوت دارند.

**Evidence:** [HttpRequestLogger](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java), [HttpHandler](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java), [ServiceTimeLog](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/vo/log/ServiceTimeLog.java).

### ارسال پیام
- در شاخه مشاهده‌شده `Server.java`، به شرط `message.getId() != 0`، `BeforeSendLog` قبل از `client.sendMessage(payload)` ثبت می‌شود.
- پس از بازگشت عادی متد، `AfterSendLog` ثبت می‌شود. `writeMessageTime` مدت فراخوانی Send است، نه End-to-End Delivery.
- هر دو لاگ دارای `messageId`، `trackerId`، `sender`، `receiver`، `client` و در صورت وجود `ARN/ARNStep` هستند. `BeforeSendLog.retryCount` در این مسیر از `message.getVersion()` پر می‌شود؛ بنابراین معنای رسمی Retry Count از نام فیلد قابل استنتاج نیست.
- وجود `AfterSendLog` دریافت یا Consume توسط مقصد، وجود ACK یا تضمین ترتیب تحویل را اثبات نمی‌کند.

**Evidence:** [Server.java — send branch](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L802-L848). [KB validated claims](https://github.com/eabbasiyan-maker/Acync-KB/blob/main/mvp/validated-claims.yaml): رخداد Duplicate در ACK/Resend ممکن است؛ معنای دقیق ACK و سیاست رسمی Retry هنوز Known Gap است.

### مسیر POD/Correlation
- `PODMonitoringLog` مراحل `GET-request`, `SEND-request`, `GET-response`, `SEND-response` را با `ARN` و `ARNStep` ثبت می‌کند.
- تولید این رویدادها مشروط به `Settings.POD_MONITORING_LOGGER` و در برخی مسیرها موجود بودن ARN است.
- `duration` و `totalDuration` بسته به `action` مرزهای زمانی متفاوت دارند؛ بدون بررسی مرحله نباید جمع یا مقایسه شوند.

**Evidence:** [PODLogUtil](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/util/PODLogUtil.java).

### مسیر Service Call Proxy
- `ServiceCallProxy` از Header شناسه درخواست یا UUID تازه استفاده می‌کند و در `SCJSONLOG` شیء `ServiceCallLog` ثبت می‌کند.
- `status` وضعیت HTTP دریافت‌شده یا در یک شاخه خطا مقدار قرارداده‌شده است؛ `serviceCallStatusCode=227` طبقه‌بندی داخلی خطاست، نه HTTP 227.
- در شاخه IOException، متغیرهای زمان ممکن است هنوز مقدار اولیه صفر داشته باشند؛ `ServiceCallLog.time` خطا را با احتیاط تفسیر کنید.
- `service call connection pool used more than 60 percent` از نسبت Connectionهای غیر Idle در ConnectionPool محاسبه می‌شود؛ معنای CPU Usage ندارد.

**Evidence:** [ServiceCallProxy](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java).

### اتصال و محدودیت
- `WebsocketAddressLog` در مسیر بازشدن اتصال WebSocket یک Snapshot از شمار Clientهای ثبت‌شده و ثبت‌نشده ثبت می‌کند؛ Time Series کامل Connectionها نیست.
- `OpenClientAddressLog` در مسیر محدودیت Clientهای باز صادر می‌شود؛ به‌تنهایی اثبات حمله نیست.
- `RateLimitLog` در یک مسیر با `DEBUG` ثبت می‌شود و فیلد `time` از `System.nanoTime()` می‌آید؛ Epoch نیست و قابل نمایش به‌عنوان زمان تقویمی نیست.
- در `RateLimitService` مسیر Rate Limit موقت با وضعیت `429` و Block دائمی Provider با `451` از هم متفاوت‌اند؛ نتیجه مشاهده‌شده HTTP به مسیر Exception Handling وابسته است.

**Evidence:** [WebsocketHandler](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java), [LoadManager](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/biz/LoadManager.java), [RateLimitService](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java).

## فهرست ۹ Log Type ساختاریافته در سورس

| Log type | نقش فنی/بیزینسی در مسیر مربوطه | محدودیت تفسیر |
| --- | --- | --- |
| `HttpLog` | رخداد درخواست/پاسخ HTTP | Headerهای Client لزوماً قابل اعتماد نیستند |
| `ServiceTimeLog` | زمان پردازش درخواست | `time` با `clientTime` یکی نیست |
| `BeforeSendLog` | شروع تلاش Send | تضمین ارسال موفق نیست |
| `AfterSendLog` | بازگشت موفق Send | تضمین Delivery/ACK نیست |
| `PODMonitoringLog` | مراحل Correlation | وابسته به Enablement و ARN |
| `ServiceCallLog` | نتیجه Proxy سرویس | status داخلی و HTTP متفاوت‌اند |
| `RateLimitLog` | شمارش/وضعیت مسیر Rate Limit | در مسیر بررسی‌شده DEBUG و nanoTime |
| `WebsocketAddressLog` | وضعیت اتصال هنگام Open | Snapshot است، نه موجودی واقعی همه اتصال‌ها |
| `OpenClientAddressLog` | کنترل تعداد Clientهای باز | لزوماً ترافیک مخرب نیست |

## مسیرهای Logger در فایل کانفیگ نسخه سورس
`resources/log4j2.xml` برای `DG2`, `JSONLOG`, `HTTPLOG`, `PODLOG`, `SCJSONLOG`, `SCLOG` فایل‌هایی مانند `async.log`، `async_json.log`، `async_http.log`، `pod_monitoring.log`، `sc_json.log` و `sc.log` را تعریف می‌کند. این پیکربندیِ سورس است و فعال‌بودن در محیط اجرا تأیید نشده. در فایل مشاهده‌شده، `ADDRESSLOG` استفاده شده اما Appender هم‌نام تعریف نشده است؛ نیازمند بررسی Runtime/Override است.

**Evidence:** [log4j2.xml](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/resources/log4j2.xml).

## ریسک‌های کد و نام متریک (برای Investigation، نه Incident قطعی)
- `JettyQueueSizeLogger` مقدار `threadPool.getQueueSize()` را زیر عنوان متنی `threadPoolSize` ثبت می‌کند. نمودارهای مبتنی بر این Label ممکن است معنی اشتباهی داشته باشند.
- `MessageCRUD.createAsyncActiveMessage` از `getTaskCount()` تجمعی برای محدودکردن ارسال Task استفاده می‌کند (حد پیش‌فرض ۵۰۰ در Settings). در شرایط فعال بودن `IS_INSERT_TO_DB_ENABLE` و رسیدن به این مسیر، عبور تجمعی شمارنده می‌تواند باعث Skip شدن `submit` شود. خطر بالقوه است؛ وقوع/اثر Production بررسی نشده.
- `ServiceCallServlet` در یک مسیر بدنه خام درخواست مدیریتی را در INFO ثبت می‌کند؛ احتمال قرارگرفتن فیلدهای حساس وابسته به Schema و Payload است.

**Evidence:** [JettyQueueSizeLogger](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java), [MessageCRUD](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java), [Settings](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/Settings.java), [ServiceCallServlet](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java).

## مرز دانش
- این فایل **فقط Source Knowledge** است. هیچ درصد خطا، شمار رخداد یا Baseline تاریخی/فعلی در آن وجود ندارد.
- برای وقوع واقعی در گذشته به `historical-runtime-evidence-2026-08-18.md` مراجعه کنید.
- برای روش تشخیص و رفع به `incident-investigation-playbooks.md` مراجعه کنید.
- تمام ادعاهای Runtime/Production تا دریافت نسخه Deploy، تنظیمات و Evidence معتبر `UNKNOWN` هستند.
