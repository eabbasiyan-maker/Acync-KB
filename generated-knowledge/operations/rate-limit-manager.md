---
doc_class: fact
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
source_refs:
  - source-baselines/asyncmanager/src/main/java/com/async/server/EmbeddedHttpServer.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/RateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/BusinessRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/BusinessProviderServiceRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/IpRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/IpProviderServiceRateLimitManagerServlet.java
  - source-baselines/asyncmanager/src/main/java/com/async/manager/AsyncManager.java
  - source-baselines/asyncmanager/src/main/java/com/async/ratelimit/dto/RateLimitConfigDto.java
  - source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitService.java
  - source-baselines/asyncmanager/src/main/java/com/async/ratelimit/RateLimitType.java
  - source-baselines/asyncmanager/src/main/java/com/async/server/vo/RequestResultVO.java
  - source-baselines/asyncmanager/evidence/rate-limit-guide-observations.md
last_validated_commit: 82a2887c5a67a640145b4428e50a292b7a425b93
---

# Async Manager — دانش کاندید Rate Limit

این سند دانش کاندید است. «تأییدشده از سورس» فقط رفتار مشاهده‌شده در snapshot کد را بیان می‌کند؛ فعال‌بودن در محیط، قرارداد رسمی، مالکیت، مصرف‌کنندگان و قصد طراحی تأیید نشده‌اند.

## مرز منبع

**تأییدشده از سورس** — این کد متعلق به پروژهٔ مستقل AsyncManager و package ریشهٔ `com.async` است؛ با سورس Async موجود در KB با package ریشهٔ `com.nozha.async` یکی نیست. Snapshot از branch `production`، commit `82a2887c5a67a640145b4428e50a292b7a425b93` (۲۷ ژوئیهٔ ۲۰۲۶) گرفته شده است. پوشهٔ `source-baselines/asyncmanager/` شامل ۱۸ فایل Java مرتبط است، نه کل repository؛ از آن نمی‌توان دربارهٔ حذف فایل‌های دیگر نتیجه گرفت. فایل‌های build، تنظیمات runtime، خروجی build و keystore وارد نشده‌اند.

## سطح‌های محدودیت و limitKey

| type | ورودی هویتی | limitKey |
|---|---|---|
| `business` | `businessId` | `{businessId}` |
| `business_provider` | `businessId`, `provider` | `{businessId}-{provider}` |
| `business_provider_service` | `businessId`, `provider`, `service` | `{businessId}-{provider}-{service}` |
| `ip` | `ip` | `{ip}` |
| `ip_provider` | `ip`, `provider` | `{ip}-{provider}` |
| `ip_provider_service` | `ip`, `provider`, `service` | `{ip}-{provider}-{service}` |

**تأییدشده از سورس** — `EmbeddedHttpServer` شش POST route را به شش Servlet تخصصی متصل می‌کند. هر Servlet نوع محدودیت را تعیین می‌کند، فیلدهای هویتی غیرمرتبط را پاک می‌کند و کلید را می‌سازد. `RateLimitManagerServlet` پایهٔ مشترک POST است؛ `RateLimitServlet` handler جداگانهٔ GET و DELETE برای ریشهٔ `/v2/rate-limit/*` است.

## مسیرهای API مشاهده‌شده

Base path: `/v2/rate-limit/`

| روش | مسیر | رفتار |
|---|---|---|
| GET | `/` | خواندن تنظیم‌ها با فیلترهای اختیاری `type`, `ip`, `provider`, `service`, `businessId` |
| DELETE | `/` | حذف با بدنهٔ دارای `limitKey` |
| POST | `/business/` | محدودیت کسب‌وکار |
| POST | `/business/provider/` | محدودیت کسب‌وکار و Provider |
| POST | `/business/provider/service/` | محدودیت کسب‌وکار، Provider و Service |
| POST | `/ip/` | محدودیت IP |
| POST | `/ip/provider/` | محدودیت IP و Provider |
| POST | `/ip/provider/service/` | محدودیت IP، Provider و Service |

**تأییدشده از سورس** — handlerها `RateLimitService.checkToken(req)` را فراخوانی می‌کنند. POST نوع و کلید را از مسیر تعیین می‌کند، `expireTime = now + refillInterval` و `temporarilyBlock = false` می‌سازد، در مخزن محلی Manager ثبت/به‌روزرسانی می‌کند و سپس عملیات را به Async nodeهای انتخاب‌شده می‌فرستد. GET در همین پروژه از `RateLimitService.loadRateLimitConfig(...)` می‌خواند؛ fan-out خواندن در این handler مشاهده نمی‌شود.

## انتخاب node و نتیجهٔ fan-out

**تأییدشده از سورس** — در POST و DELETE:
- وجود `serverId`، nodeهای مشخص‌شده را انتخاب می‌کند.
- در نبود `serverId` و وجود `cluster`، nodeهای آن clusterها انتخاب می‌شوند.
- در نبود هر دو، nodeهای alive انتخاب می‌شوند.

برای هر node یک `RequestResultVO` با `serverId`, `success`, `response`, `statusCode` ساخته می‌شود. در timeout اگر هیچ نتیجه‌ای جمع نشده باشد ۴۰۸ برگردانده می‌شود؛ اگر نتیجهٔ جزئی جمع شده باشد، همان فهرست جزئی می‌تواند پاسخ باشد. وقتی handler فهرست نتایج را برمی‌گرداند، status سطح HTTP برابر ۲۰۰ است؛ بنابراین نتیجهٔ هر node باید جداگانه بررسی شود.

## ترتیب ثبت و حذف

**تأییدشده از سورس** — POST تنظیم را در Manager ذخیره می‌کند و بعد fan-out را انجام می‌دهد. DELETE ابتدا تنظیم محلی Manager را حذف می‌کند و بعد درخواست حذف را به nodeهای انتخاب‌شده می‌فرستد.

**استنباط نیازمند تأیید** — اگر فقط subset از nodeها انتخاب شود یا fan-out بخشی از شکست‌ها را داشته باشد، وضعیت Manager و nodeها ممکن است یکسان نماند. این snapshot تضمین rollback، retry یا reconciliation را اثبات نمی‌کند.

## تفاوت‌های کد و راهنمای سرویس

موارد زیر از مقایسهٔ snapshot کد با راهنمای ارائه‌شدهٔ Rate Limit استخراج شده‌اند؛ تعارض‌ها حل‌شده فرض نمی‌شوند:

1. راهنما `totalCapacity` را برای قانون غیردائم لازم می‌داند. validator عمومی POST در `RateLimitManagerServlet`، `capacity`, `refillInterval`, `permanentBlock` و `countThreshold` را بررسی می‌کند، اما `totalCapacity` را در همان validator اجباری نمی‌کند.
2. کد queryهای `serverId` و `cluster` را برای انتخاب node می‌پذیرد؛ راهنما این پارامترها را فهرست نکرده است.
3. راهنما ارسال به همهٔ nodeها را توصیف می‌کند؛ کد به‌طور پیش‌فرض nodeهای alive را انتخاب می‌کند و امکان انتخاب subset را نیز دارد.
4. راهنما دریافت قوانین را مستند می‌کند؛ GET در Manager از مخزن محلی می‌خواند و در همان مسیر fan-out مشاهده نمی‌شود.

مرجعیت راهنما، مجازبودن عملیات subset، دامنهٔ پاسخ GET و رفتار مورد انتظار هنگام شکست جزئی باید با مالک سرویس تأیید شود.

## ناشناخته‌ها

فعال‌بودن این نسخه در production، وضعیت واقعی همهٔ nodeها، معنای نهایی ظرفیت/بازنشانی در runtime، سیاست توکن، مصرف‌کنندگان رسمی، قرارداد idempotency، و فرایند جبران اختلاف Manager و nodeها از این snapshot معلوم نمی‌شود.
