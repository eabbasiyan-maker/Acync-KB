---
doc_class: observation
trust_level: untrusted-content
lifecycle: snapshot
confidence: high
verification: runtime-observed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: internal
observed_date: 2026-08-18
analysis_date: 2026-10-09
last_validated_commit: UNKNOWN_DEPLOYED_VERSION
source_refs:
  - https://github.com/eabbasiyan-maker/Async-Source/tree/781e6c4c61706a798883818982f72fb8fa53a661
evidence_refs: []
---

# Async Observability — Historical Runtime Evidence: 2026-08-18

> **Historical only — NOT current Production Baseline.** خلاصه آماری **دو فایل لاگ واقعی ارائه‌شده توسط ذی‌نفع** که متعلق به ۱۸ اوت ۲۰۲۶ هستند. هیچ رکورد خام، Token، IP، شناسه فردی، اطلاعات کارت، Payload، Message Preview یا Stack Trace خام به این ریپو منتقل نشده است. سورس GitHub مقایسه‌ای لزوماً نسخه Deploy شده هنگام ثبت این لاگ‌ها نیست.

## Evidence provenance — بدون انتقال Raw Logs

| شاهد | SHA-256 فایل مبدأ | نوع داده | بازه زمانی UTC | رکورد |
| --- | --- | --- | --- | ---: |
| Structured log sample | `1dea172af21e2743026b5a797f2834b16c460724412fb7a89fdfcc1d22091c74` | JSON Lines؛ فیلد message یک Object | 2026-08-18 08:09:29 تا 08:30:04 | 15,592 |
| Textual log sample | `c1615ffba8c244a237459e1cb86733ef4e7de011a10e40daab16700d354af9e5` | JSON Lines؛ فیلد message متن رویداد | 2026-08-18 08:23:34 تا 08:29:26 | 17,072 |

- تاریخ/ساعت از فیلدهای `instant` یا `tstamp` خوانده شده و برای این سند UTC است.
- **بازه دو فایل برابر نیست:** یکی حدود ۲۰ دقیقه و دیگری حدود ۶ دقیقه است. مقایسه تعداد رویدادها و نتیجه‌گیری آماری بین فایل‌ها بدون محدود کردن به بازه مشترک مجاز نیست.
- هر دو فایل بدون خطای Parsing در اسکن ثبت‌شده خوانده شدند. این نشانه کامل بودن فایل در سیستم تولیدکننده یا Kibana نیست.
- `confidence: high` فقط برای بازشماری همین فایل‌هاست؛ درباره علت ریشه‌ای، اثر بیزینسی و وضعیت فعلی **اطمینان نامعلوم** است.

## Observed: Structured Event Types

| Event | count |
| --- | ---: |
| BeforeSendLog | 6,685 |
| AfterSendLog | 6,686 |
| ServiceTimeLog | 2,221 |

هیچ نوع Structured Log دیگری در **این فایل نمونه** مشاهده نشد؛ این به معنی غیرفعال بودن قطعی آن‌ها در سیستم یا سایر فایل‌ها نیست.

### Message attempt correlation
- با کلید مرکب `messageId + trackerId + client`، **۶٬۶۸۵** رکورد BeforeSend با AfterSend متناظر قابل Pair بودند.
- `BeforeSend only = 0`، `AfterSend only = 1` در این نمونه. ممکن است علت مورد اضافه، شروع فایل وسط جریان، تفاوت Logging یا Missing Event باشد؛ از این داده علت تعیین نمی‌شود.
- وجود `AfterSendLog` فقط گذر از نقطه Return در مسیر Send را تقویت می‌کند؛ تحویل به کاربر نهایی و ACK را اثبات نمی‌کند.

### ServiceTimeLog status and latency patterns

| HTTP status | رخداد | مشاهده زمانی |
| --- | ---: | --- |
| 200 | 1,947 | این نمونه به تنهایی SLA نیست |
| 201 | 1 | — |
| 301 | 14 | — |
| 400 | 1 | — |
| 401 | 46 | — |
| 404 | 6 | — |
| 408 | 150 | **۱۴۶ مورد در محدوده ۱۱۹–۱۲۱ ثانیه**؛ میانه حدود ۱۲۰٬۰۰۱ ms |
| 500 | 56 | **۴۹ مورد در محدوده ۲۹–۳۱ ثانیه**؛ میانه حدود ۳۰٬۰۲۹ ms |

**Observation:** خوشه‌شدن زمان‌ها نزدیک ۳۰ و ۱۲۰ ثانیه یک نشانه قوی برای بررسی حدهای Timeout است؛ اما از روی Status + Time به‌تنهایی مشخص نیست کدام سیستم یا لایه علت اصلی بوده است.

### Correlation across the two files
- در لاگ متنی **۲۸** رویداد `http request onTimeout` وجود دارد.
- تمام ۲۸ `trackerId` استخراج‌شده از آن‌ها با `ServiceTimeLog.status=408` در نمونه ساختاریافته تطبیق داده شدند.
- در نمونه تاریخی، مقدار `timeout=120000` در این Eventها مشاهده شده است.
- **Limit:** این ردیابی تنها ۲۸ مورد از ۱۵۰ درخواست 408 را پوشش می‌دهد؛ سایر 122 درخواست را نمی‌توان خودکار دارای همین علت دانست.

### Negative duration values — کیفیت داده
- `AfterSendLog.time`: تعداد **۷۲۶** منفی، بازه تقریبی از `-20 ms` تا صفر؛ `AfterSendLog.writeMessageTime` در این نمونه منفی نیست.
- `ServiceTimeLog.clientTime`: تعداد **۵۶۹** منفی، حداقل `-21 ms`؛ خود `ServiceTimeLog.time` منفی نیست.
- توضیح احتمالی: عدم هم‌زمانی Clockها یا اختلاف Timestamp تولیدکننده پیام و Node پردازش‌کننده. این فقط Hypothesis است و هنوز با NTP/Node ID تأیید نشده؛ از متریک دارای مدت‌زمان منفی برای میانگین بدون کنترل کیفیت استفاده نکنید.

## Observed: textual log signatures

| امضای رویداد | تعداد در همین نمونه | سطح مشاهده‌شده | Interpretation boundary |
| --- | ---: | --- | --- |
| Oracle `ORA-00001` در `addClient` | 100 | ERROR | Unique Constraint؛ هنوز معلوم نیست Race Condition یا Retry/Registration تکراری است |
| `http request onTimeout` | 28 | ERROR | با ۲۸ رخداد 408 تطبیق دارد؛ وضعیت سایر درخواست‌ها نامعلوم |
| `Invalid Queue Name` | 118 | WARN | لزوماً اثبات اختلال Broker یا Message Loss نیست |
| رویدادهای شامل `swagger` | 48 | 46 ERROR / 2 WARN | مشکل در دریافت/قرارداد ممکن است؛ تأثیر واقعی روی سرویس باید مستقل سنجیده شود |
| `jetty threadPoolSize` | 23 | INFO | برچسب در Source برخلاف getter واقعی، Queue Size را نمایش می‌دهد |
| `Async DB ThreadPool task size more than threshold` | 0 | — | نبود این امضا در یک نمونه کوتاه، ردکننده خطر کد نیست |

### Textual level distribution
`INFO = 16,579`؛ `WARN = 312`؛ `ERROR = 181`؛ `DEBUG = 0` در همین فایل متنی. این به معنای تنظیمات قطعی Logger در کل محیط نیست.

## Comparison with source-only knowledge

| قبل از لاگ واقعی (Source Knowledge) | بعد از Log Evidence |
| --- | --- |
| می‌دانستیم دو Event پیش/پس از send تعریف شده‌اند | Pair شدن ۶٬۶۸۵ جفت در یک نمونه اجرا دیده شد |
| می‌دانستیم Runtime مسیر HTTP timeout دارد | توانستیم ۲۸ Timeout را با trackerId تا Status 408 ردیابی کنیم |
| امکان Exception در `OracleClientCRUD.addClient` را می‌شناختیم | ORA-00001 به‌صورت رخداد واقعی تکرار شد |
| وجود مسیر بارگذاری Swagger در سورس روشن بود | ۴۸ رویداد مرتبط در نمونه متنی دیده شد |
| معنای `time` و `clientTime` متفاوت بود | منفی شدن برخی زمان‌ها، نیاز به کنترل کیفیت متریک را اثبات کرد |
| `JettyQueueSizeLogger` برچسب گمراه‌کننده داشت | ۲۳ خط از همان شکل Logging در نمونه وجود دارد |
| خطر استفاده از `getTaskCount()` به جای Queue Size وجود داشت | وقوع Runtime آن در نمونه **مشاهده نشد**، اما خطر کد پابرجاست |

## Unknowns & constraints
- Cluster/Node دقیق، محیط اجرا، نسخه Deploy در تاریخ لاگ، وضعیت Log Shipper و Sampling، و خطاهای حذف‌شده از بازه خارج از فایل.
- سرنوشت نهایی پیام در Receiver، معنای رسمی ACK، رفتار Retry/Resend، و منبع قطعی ایجاد مقادیر منفی.
- اینکه ۱۰۰ خطای ORA-00001 منجر به اختلال قابل مشاهده، Duplicate Mapping یا مسیر جبران شده‌اند.
- اینکه تمام خطاهای Swagger یا Queue باعث اختلال سرویس شده‌اند.
- شرایط فعلی Production در اکتبر ۲۰۲۶؛ **این فایل فقط Snapshot تاریخی است**.

## Governance and privacy
- این داده‌ها Observation هستند و **نباید به صورت Current Problem، Known Product Defect یا Trusted SLA** Promote شوند.
- برای تفسیر Source به `source-logging-semantics.md` و برای تشخیص به `incident-investigation-playbooks.md` مراجعه شود.
- بازبینی انسانی هر ادعای بیزینسی و Runtime لازم است؛ هیچ نمونه خامی در GitHub منتشر نشود.
