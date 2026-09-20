package com.async.server;

import com.async.exception.HttpException;
import com.async.ratelimit.RateLimitType;
import com.async.ratelimit.dto.RateLimitConfigDto;

public class BusinessRateLimitManagerServlet extends RateLimitManagerServlet {

    @Override
    public void validateRequestParametersAndCreateKey(RateLimitConfigDto rateLimitConfigDto) throws HttpException {
        if (rateLimitConfigDto.getBusinessId() == null) {
            throw new HttpException("businessId is required");
        }
        rateLimitConfigDto.setLimitKey(String.valueOf(rateLimitConfigDto.getBusinessId()));
    }

    @Override
    public void validateRateLimitConfigDto(RateLimitConfigDto rateLimitConfigDto) {
        if (rateLimitConfigDto.getProvider() != null) {
            rateLimitConfigDto.setProvider(null);
        }
        if (rateLimitConfigDto.getService() != null) {
            rateLimitConfigDto.setService(null);
        }
        if (rateLimitConfigDto.getIp() != null) {
            rateLimitConfigDto.setIp(null);
        }
    }

    @Override
    public String getType(){
        return RateLimitType.BUSINESS.getValue();
    }
}
