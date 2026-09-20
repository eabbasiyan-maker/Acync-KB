package com.async.ratelimit.dto;

import com.async.ratelimit.AtomicLongDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.concurrent.atomic.AtomicLong;

public class RateLimitConfigDto {

    private String type;
    private Long businessId;
    private String provider;
    private String service;
    private String ip;
    private String limitKey;
    @JsonDeserialize(using = AtomicLongDeserializer.class)
    private AtomicLong capacity;
    private Long totalCapacity;
    private Long refillInterval;
    private Long expireTime;
    private Boolean permanentBlock;
    private Boolean temporarilyBlock;
    private Long countThreshold;
    private Long count;

    public RateLimitConfigDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provide) {
        this.provider = provide;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLimitKey() {
        return limitKey;
    }

    public void setLimitKey(String limitKey) {
        this.limitKey = limitKey;
    }

    public AtomicLong getCapacity() {
        return capacity;
    }

    public void setCapacity(AtomicLong capacity) {
        this.capacity = capacity;
    }

    public Long getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Long totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Long getRefillInterval() {
        return refillInterval;
    }

    public void setRefillInterval(Long refillInterval) {
        this.refillInterval = refillInterval;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Boolean getPermanentBlock() {
        return permanentBlock;
    }

    public void setPermanentBlock(Boolean permanentBlock) {
        this.permanentBlock = permanentBlock;
    }

    public Boolean getTemporarilyBlock() {
        return temporarilyBlock;
    }

    public void setTemporarilyBlock(Boolean temporarilyBlock) {
        this.temporarilyBlock = temporarilyBlock;
    }

    public Long getCountThreshold() {
        return countThreshold;
    }

    public void setCountThreshold(Long countThreshold) {
        this.countThreshold = countThreshold;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
