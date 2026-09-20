package com.async.server;

import com.async.exception.HttpException;
import com.async.ratelimit.RateLimitType;
import com.async.ratelimit.dto.RateLimitConfigDto;

public class IpProviderRateLimitManagerServlet extends RateLimitManagerServlet {

    @Override
    public void validateRequestParametersAndCreateKey(RateLimitConfigDto rateLimitConfigDto) throws HttpException {
        if (rateLimitConfigDto.getIp() == null || rateLimitConfigDto.getIp().isEmpty()) {
            throw new HttpException("ip is required");
        }
        if (rateLimitConfigDto.getProvider() == null || rateLimitConfigDto.getProvider().isEmpty()) {
            throw new HttpException("provider is required");
        }
        rateLimitConfigDto.setLimitKey(rateLimitConfigDto.getIp() + "-" + rateLimitConfigDto.getProvider());
    }

    @Override
    public void validateRateLimitConfigDto(RateLimitConfigDto rateLimitConfigDto) {
        if (rateLimitConfigDto.getService() != null) {
            rateLimitConfigDto.setService(null);
        }
        if (rateLimitConfigDto.getBusinessId() != null) {
            rateLimitConfigDto.setBusinessId(null);
        }
    }

    @Override
    public String getType(){
        return RateLimitType.IP_PROVIDER.getValue();
    }
}
