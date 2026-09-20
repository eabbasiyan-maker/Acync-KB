package com.async.server;

import com.async.exception.HttpException;
import com.async.ratelimit.RateLimitType;
import com.async.ratelimit.dto.RateLimitConfigDto;

public class IpProviderServiceRateLimitManagerServlet extends RateLimitManagerServlet {

    @Override
    public void validateRequestParametersAndCreateKey(RateLimitConfigDto rateLimitConfigDto) throws HttpException {
        if (rateLimitConfigDto.getIp() == null || rateLimitConfigDto.getIp().isEmpty()) {
            throw new HttpException("ip is required");
        }
        if (rateLimitConfigDto.getProvider() == null || rateLimitConfigDto.getProvider().isEmpty()) {
            throw new HttpException("provider is required");
        }
        if (rateLimitConfigDto.getService() == null || rateLimitConfigDto.getService().isEmpty()) {
            throw new HttpException("service is required");
        }
        rateLimitConfigDto.setLimitKey(rateLimitConfigDto.getIp() + "-" + rateLimitConfigDto.getProvider() + "-" + rateLimitConfigDto.getService());
    }

    @Override
    public void validateRateLimitConfigDto(RateLimitConfigDto rateLimitConfigDto) {
        if (rateLimitConfigDto.getBusinessId() != null) {
            rateLimitConfigDto.setBusinessId(null);
        }
    }

    @Override
    public String getType(){
        return RateLimitType.IP_PROVIDER_SERVICE.getValue();
    }
}
