package com.async.server;

import com.async.exception.HttpException;
import com.async.exception.ServerException;
import com.async.manager.AsyncManager;
import com.async.object.AsyncServer;
import com.async.ratelimit.RateLimitService;
import com.async.ratelimit.dto.RateLimitConfigDto;
import com.async.server.vo.RequestResultVO;
import com.async.server.vo.ResultVO;
import com.async.util.JsonUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class RateLimitManagerServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RateLimitManagerServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object rs;
        try {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            RateLimitService.checkToken(req);
            if (isActionValid(req.getPathInfo())) {
                rs = doAction(req);
            } else {
                rs = new ResultVO(false, "bad request path", HttpStatus.SC_BAD_REQUEST);
            }
        } catch (ServerException e) {
            logger.error("An ServerException occurred in RateLimitManagerServlet", e);
            rs = new ResultVO(false, e.getMessage(), HttpStatus.SC_UNAUTHORIZED);
        } catch (HttpException e) {
            logger.error("An HttpException occurred in RateLimitManagerServlet", e);
            rs = new ResultVO(false, e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            logger.error("An Exception occurred in RateLimitManagerServlet", e);
            rs = new ResultVO(false, e.getMessage(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        resp.setStatus(rs instanceof ResultVO ? ((ResultVO) rs).getStatusCode() : HttpStatus.SC_OK);
        resp.getWriter().write(JsonUtil.getJson(rs));
        resp.getWriter().flush();
    }

    private List<RequestResultVO> doAction(HttpServletRequest req) throws IOException, InterruptedException, HttpException, ServerException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        List<RequestResultVO> result;
        if (!body.isEmpty()) {
            List<AsyncServer> asyncServers = AsyncManager.getAsyncServers(req);
            RateLimitConfigDto rateLimitConfigDto = JsonUtil.getObject(body, RateLimitConfigDto.class);
            rateLimitConfigDto.setType(getType());
            validateRateLimitConfigDto(rateLimitConfigDto);
            validateGeneralRequestParameters(req, rateLimitConfigDto);
            validateRequestParametersAndCreateKey(rateLimitConfigDto);
            rateLimitConfigDto.setExpireTime(System.currentTimeMillis() + rateLimitConfigDto.getRefillInterval());
            rateLimitConfigDto.setTemporarilyBlock(Boolean.FALSE);
            RateLimitService.insertIntoRateLimitConfig(rateLimitConfigDto);
            logger.info("start action={} , method={} , type={} , key={}",
                    req.getPathInfo(), "post", rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey());
            result = AsyncManager.sendActionToAsyncServers("post", rateLimitConfigDto, req.getHeader("Authorization"), asyncServers, "insertOrUpdate");
        } else {
            throw new HttpException("body is empty", HttpStatus.SC_BAD_REQUEST);
        }
        return result;
    }

    public abstract void validateRateLimitConfigDto(RateLimitConfigDto rateLimitConfigDto);

    private void validateGeneralRequestParameters(HttpServletRequest req, RateLimitConfigDto rateLimitConfigDto) throws HttpException, ServerException {
        RateLimitService.checkToken(req);
        if (rateLimitConfigDto.getCapacity() == null) {
            throw new HttpException("capacity is required");
        }
        if (rateLimitConfigDto.getRefillInterval() == null) {
            throw new HttpException("refill interval is required");
        }
        if (rateLimitConfigDto.getPermanentBlock() == null) {
            throw new HttpException("permanent block is required");
        }
        if (rateLimitConfigDto.getCountThreshold() == null) {
            throw new HttpException("count threshold is required");
        }
    }

    public abstract void validateRequestParametersAndCreateKey(RateLimitConfigDto rateLimitConfigDto) throws HttpException;

    public abstract String getType() throws HttpException;

    private boolean isActionValid(String pathInfo) {
        return pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/");
    }
}