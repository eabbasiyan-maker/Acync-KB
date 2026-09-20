package com.async.server;

import com.async.exception.HttpException;
import com.async.ratelimit.RateLimitType;
import com.async.ratelimit.dto.RateLimitConfigDto;

public class BusinessProviderRateLimitManagerServlet extends RateLimitManagerServlet {

    @Override
    public void validateRequestParametersAndCreateKey(RateLimitConfigDto rateLimitConfigDto) throws HttpException {
        if (rateLimitConfigDto.getBusinessId() == null) {
            throw new HttpException("businessId is required");
        }
        if (rateLimitConfigDto.getProvider() == null || rateLimitConfigDto.getProvider().isEmpty()) {
            throw new HttpException("provider is required");
        }
        rateLimitConfigDto.setLimitKey(rateLimitConfigDto.getBusinessId() + "-" + rateLimitConfigDto.getProvider());
    }

    @Override
    public void validateRateLimitConfigDto(RateLimitConfigDto rateLimitConfigDto) {
        if (rateLimitConfigDto.getService() != null) {
            rateLimitConfigDto.setService(null);
        }
        if (rateLimitConfigDto.getIp() != null) {
            rateLimitConfigDto.setIp(null);
        }
    }

    @Override
    public String getType(){
        return RateLimitType.BUSINESS_PROVIDER.getValue();
    }
}
