---
doc_class: observation
trust_level: untrusted-content
lifecycle: living
confidence: medium
verification: source-confirmed
truth_type: operational
owner: REQUIRES_HUMAN_VALIDATION
sensitivity: REQUIRES_HUMAN_VALIDATION
source: user-provided `راهنمای_سرویس_Rate_Limit.docx`
source_date: 2026-09-20
---

# مشاهده‌های استخراج‌شده از راهنمای Rate Limit

این فایل خلاصهٔ ساختاریافتهٔ راهنمای سرویس ارائه‌شده در این گفتگو است؛ فایل اصلی DOCX در این repository ذخیره نشده است.

- API guide نسخهٔ v2 را برای AsyncManager معرفی می‌کند و مسیر پایهٔ `/v2/rate-limit/` را مستند می‌کند.
- شش نوع محدودیت: `business`, `business_provider`, `business_provider_service`, `ip`, `ip_provider`, `ip_provider_service`.
- فیلدهای عمومی بدنه: `capacity`, `totalCapacity`, `refillInterval`, `permanentBlock`, `countThreshold`. راهنما `totalCapacity` را برای محدودیت غیردائم لازم معرفی می‌کند.
- نوع و `limitKey` در POST باید توسط سامانه از روی مسیر ساخته شوند؛ DELETE فقط `limitKey` می‌خواهد.
- GET می‌تواند با `type`, `ip`, `provider`, `service`, `businessId` فیلتر شود.
- پاسخ عملیات ثبت/حذف آرایه‌ای از نتیجه‌های node است؛ موفقیت سطح سامانه به‌تنهایی موفقیت همهٔ nodeها را ثابت نمی‌کند.
- راهنما رفتارهای اعلام‌شده شامل ۴۵۱ برای بلوک دائم، ۴۲۹ برای بلوک موقت، بازنشانی با `refillInterval` و batch گزارش مصرف با `countThreshold` را شرح می‌دهد.
- این‌ها ادعاهای راهنما هستند و به‌تنهایی فعال‌بودن همین رفتار در production را ثابت نمی‌کنند.
