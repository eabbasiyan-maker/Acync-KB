package com.async.ratelimit;

public enum RateLimitType {
    BUSINESS("business"),
    BUSINESS_PROVIDER("business_provider"),
    BUSINESS_PROVIDER_SERVICE("business_provider_service"),
    IP("ip"),
    IP_PROVIDER("ip_provider"),
    IP_PROVIDER_SERVICE("ip_provider_service");

    private final String value;

    RateLimitType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}