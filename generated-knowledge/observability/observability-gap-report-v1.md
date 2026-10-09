---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
last_validated_commit: 781e6c4c61706a798883818982f72fb8fa53a661
---

# Async Observability Gap Report v1

> خروجی Static Audit است، نه ادعای رخداد Production. «کمبود پوشش» با «نقص قطعی برنامه» یکی نیست. موارد زیر برای بازبینی تخصصی و اتصال به Runtime دسته‌بندی شده‌اند.

## ۱. پوشش و کیفیت شناسنامه

- کل نقاط Logging شناخته‌شده: **956** در **116** فایل Java؛ از این تعداد **938** نقطه در کد اصلی/غیر Vendor و **18** مورد در مسیر `src/org/...` است (وجود فایل Vendored در درخت Source به معنای مسئولیت مالک محصول برای کد آن نیست).
- تطبیق فهرست قبلی: **953/953**؛ بدون حذف. موارد جدید: **3** (۲ ServiceCallLog و ۱ HttpLog).
- تشخیص نام Method از روی تحلیل محافظه‌کارانه: **12** مورد UNKNOWN.
- استخراج محافظه‌کارانه ساختارهای کنترلی اطراف فراخوانی‌ها: **749** مورد؛ **برای 945 مورد شرط کامل مسیر فراخوانی هنوز قطعی نیست.**
- پرچم بازبینی احتمالی حساس بودن محتوا: **24** نقطه (بر اساس الگوی متنی؛ نیازمند ممیزی انسانی و Schema).
- پرچم بررسی مبنای Time/Clock/Unit: **169** نقطه (بر اساس وجود کلمات مربوط به زمان، نه اثبات نقص).
- فراخوانی‌های DEBUG که ممکن است در Runtime فیلتر شوند: **102** (وابسته به تنظیمات واقعی).

## ۲. کمبودها/ریسک‌های دارای Evidence مستقیم از Source

### P0 برای Triage — رد شدن ثبت غیرهم‌زمان پیام در مسیر Database
- **Source:** `MessageCRUD.createAsyncActiveMessage` در صورت عبور `executorService.getTaskCount()` از `Settings.ASYNC_SAVE_MESSAGE_THREAD_POOL_TASK_SIZE` از `submit` عبور می‌کند.
- **ریسک:** `getTaskCount()` شمار تقریبی کل Taskهای برنامه‌ریزی‌شده را برمی‌گرداند، نه Queue Depth لحظه‌ای. ممکن است مسیر ذخیره پیام پس از یک تعداد تجمعی Task به صورت مستمر Skip شود، اگر Feature Flag مربوط فعال و مسیر قابل دسترس باشد.
- **نامعلوم:** فعال بودن این مسیر، تنظیمات Deploy، میزان ورود پیام، برخورد سایر مسیرهای Persistence و وقوع/عدم وقوع Data Loss.
- **پیشنهاد:** Review فوری TL، Unit/Load Test بیش از سقف تاریخی Task، Audit جدول پیام‌ها، افزودن Error Counter/Alert و بازطراحی Backpressure با ضمانت‌های مورد نیاز.

### P1 — عنوان غلط Metric مربوط به Jetty
- **Source:** `JettyQueueSizeLogger` مقدار `getQueueSize()` را تحت عنوان `jetty threadPoolSize` چاپ می‌کند.
- **اثر احتمالی:** Dashboard یا Alert ممکن است Queue Depth را Pool Size تفسیر کند؛ ابتدا KPIهای موجود در Kibana/Zabbix را بررسی کنید.
- **پیشنهاد:** نام Metric استاندارد و با Unit/Help دقیق ثبت شود و Pool Size واقعی در صورت نیاز جدا بیاید.

### P1 — تفاوت Send با Delivered / ACK
- **Source:** `BeforeSendLog` و `AfterSendLog` به نقاط خاص `client.sendMessage(payload)` متصل‌اند؛ AfterSend به معنای ACK/Consume نیست.
- **Gap:** Join کامل تا Receiver/ACK/Retry برای هر پروتکل از سورس و نمونه‌ها اثبات نشده؛ Semantics رسمی ACK در KB Known Gap مانده است.
- **پیشنهاد:** Event/Metricهای Stage-based با همان Correlation IDs و قرارداد روشن ACK/Delivery.

### P1 — ریسک Duration نامعتبر در ServiceCall IOException
- **Source:** مسیر خطای ServiceCallLog ممکن است از Variableهای زمان با مقدار اولیه صفر استفاده کند و Status مصنوعی با HTTP Response مقصد اشتباه شود.
- **پیشنهاد:** Timestamp آغازین را قبل از Try/Catch مقداردهی کنید؛ latency failure مستقل و consistent باشد؛ قرارداد فیلدهای internalStatus و httpStatus را تفکیک کنید.

### P1 — احتمال داده حساس در Logging
- **Source:** `ServiceCallServlet` یک مسیر INFO برای Body درخواست مدیریتی دارد، و `ServiceTimeLog` شامل `messagePreview` است.
- **ریسک:** بدون ممیزی Schema/Masking نمی‌توان گفت حتماً اطلاعات حساس افشا شده، ولی لازم است داده‌های Auth/Token/PII کنترل شوند.
- **پیشنهاد:** Field allow-list، Masking پیش از Logging، نمونه‌برداری ایمن و تست‌های خودکار ضد Leak.

### P2 — ADDRESSLOG در فایل پیکربندی بررسی‌شده مقصد متناظر ندارد
- **Source:** `resources/log4j2.xml` از `ADDRESSLOG` به‌عنوان AppenderRef نام می‌برد ولی RollingFile هم‌نام دیده نمی‌شود.
- **Limit:** Config Runtime یا Override ممکن است متفاوت باشد؛ وضعیت واقعی UNKNOWN است.

### P2 — RateLimitLog و محور زمان
- **Source:** یک مسیر RateLimitLog با `DEBUG` و `time=System.nanoTime()` ثبت می‌کند.
- **Gap:** Log ممکن است به Kibana نرسد و time مقدار Epoch نیست.
- **پیشنهاد:** جداکردن `timestampEpochMillis` از Duration/Nano و تعریف Feature Flag و Metric Counter مستقل از DEBUG.

## ۳. کمبودهای کشف‌شده در شناسنامه‌ها (نه Bug قطعی)

- **شرط کامل تولید لاگ:** صرف دانستن Call Site کافی نیست؛ باید Call Chain و Guardهای Methods و Feature Flags مشخص شوند. فعلاً صرفاً بلوک‌های if/catch اطراف نقاط شناسایی شده‌اند.
- **پوشش Correlation:** بسیاری از Logهای متنی ID مشترک ثابت ندارند؛ باید Schema رویدادها و فیلدهای MDC در سطح درخواست بررسی و استاندارد شود.
- **Log Shape:** برخی Structured Object و برخی String هستند؛ Elastic Index Mapping و Searchability باید مستقل تأیید شود.
- **حساسیت:** Risk Marker مبتنی بر اسم فیلد فقط سرنخ است؛ Data Classification و Sanitization به صورت Review الزامی است.
- **معنای Severity:** وجود WARN یا ERROR دلیل شکست بیزینسی نیست؛ ممکن است رویداد کنترل‌شده یا Recovery موفق باشد.
- **Runtime Delivery:** وجود logger در Source و تعریف FileAppender اثبات نمی‌کند که Kibana هر رویداد را ingest می‌کند؛ Log Level، Appender، Log Shipper، Filtering، Sampling و Retention باید بررسی شوند.
- **Data Quality:** Timestamp منفی در نمونه تاریخی باید با NTP، زمان Producer/Receiver و اختلاف Epoch/Nano بررسی شود.
- **Ownership:** فایل‌های `src/org/...` را جداگانه به‌عنوان Vendored/External Review نگه دارید تا Bugهای کتابخانه با منطق خود محصول اشتباه نشوند.

## ۴. روش اعتبارسنجی با Runtime

۱. زمان/Cluster/Node/Version Deploy را ثبت کن؛ نسخه GitHub و نسخه Deploy را با SHA/Build Metadata مرتبط کن.

۲. برای هر Domain ابتدا یک بازه Normal و یک بازه Anomaly انتخاب کن و تعداد Log/Event قابل انتظار و رویداد ثبت‌شده را با همان فیلتر مقایسه کن.

۳. نتایج RCA را فقط پس از اتصال دو یا چند شاهد مستقل (Log + Metric، یا Log + Source + DB/Trace) اعلام کن.

۴. پس از اصلاح، نرخ رخداد، Error Rate، Latency و نسبت موفقیت مرحله تجاری مرتبط را پیش/پس از تغییر با Baseline قابل مقایسه اندازه بگیر.

## ۵. فهرست مراجع نمونه

- [Jetty mislabeled queue](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/JettyQueueSizeLogger.java#L27) — `ALOG-C6226B3E78A1`
- [DB cumulative TaskCount](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/persistance/MessageCRUD.java#L53) — `ALOG-D10FCB5AE889`
- [BeforeSendLog](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L809) — `ALOG-EA217CF03EAD`
- [AfterSendLog](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/Server.java#L831) — `ALOG-9257352129C9`
- [ServiceTimeLog](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/HttpHandler.java#L439) — `ALOG-661971303632`
- [RateLimit nanoTime](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/ratelimit/RateLimitService.java#L229) — `ALOG-F71D4CF12110`
- [ServiceCall error](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/ServiceCallProxy.java#L190) — `ALOG-521396233883`
- [Websocket address](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/handler/WebsocketHandler.java#L120) — `ALOG-BEE858552C14`
- [Potential sensitive request body](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/ServiceCallServlet.java#L82) — `ALOG-3460022C2925`
- [HttpLog](https://github.com/eabbasiyan-maker/Async-Source/blob/781e6c4c61706a798883818982f72fb8fa53a661/src/com/nozha/async/server/httpserver/log/HttpRequestLogger.java#L37) — `ALOG-AE20C3D2B6ED`

## تصمیم Governance

این گزارش Candidate است. هیچکدام از موردهای P0/P1/P2 بدون مشاهده Runtime یا Review صاحب Code به Bug قطعی Production یا Trusted Claim تبدیل نشوند. در دو نمونه تاریخی ارسالی ممکن است مسیر مربوط به نقص اصلاً اجرا نشده باشد؛ **عدم وقوع در نمونه، رد خطر نیست**.