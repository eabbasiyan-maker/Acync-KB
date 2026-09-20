package com.async.server;

import com.async.exception.HttpException;
import com.async.exception.ServerException;
import com.async.manager.AsyncManager;
import com.async.object.AsyncServer;
import com.async.ratelimit.RateLimitService;
import com.async.ratelimit.dto.RateLimitConfigDto;
import com.async.server.vo.RequestResultVO;
import com.async.server.vo.ResponseVO;
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

public class RateLimitServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RateLimitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ResponseVO<Object> rs;
        try {
            RateLimitService.checkToken(req);
            String type = req.getParameter("type");
            String ip = req.getParameter("ip");
            String provider = req.getParameter("provider");
            String service = req.getParameter("service");
            String businessId = req.getParameter("businessId");
            if (isActionValid(req.getPathInfo())) {
                Object resultList = RateLimitService.loadRateLimitConfig(type, ip, provider, service, businessId != null ? Long.valueOf(businessId) : null);
                rs = ResponseVO.ok(resultList);
            } else {
                rs = ResponseVO.error(HttpStatus.SC_BAD_REQUEST, "bad request path");
            }
        } catch (ServerException e) {
            logger.error("An ServerException occurred in RateLimitServlet", e);
            rs = ResponseVO.error(HttpStatus.SC_UNAUTHORIZED, e.getMessage());
        } catch (Exception e) {
            logger.error("An Exception occurred in RateLimitServlet", e);
            rs = ResponseVO.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
        resp.setStatus(rs.getCode());
        resp.getWriter().write(JsonUtil.getJson(rs));
        resp.getWriter().flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            logger.error("An ServerException occurred in RateLimitServlet", e);
            rs = new ResultVO(false, e.getMessage(), HttpStatus.SC_UNAUTHORIZED);
        } catch (HttpException e) {
            logger.error("An HttpException occurred in RateLimitServlet", e);
            rs = new ResultVO(false, e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            logger.error("An Exception occurred in RateLimitServlet", e);
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
            validateRequestParameterForDelete(rateLimitConfigDto);
            RateLimitService.deleteFromRateLimitConfigByKey(rateLimitConfigDto.getLimitKey());
            RateLimitService.deleteRateLimitConfig(rateLimitConfigDto.getLimitKey());
            logger.info("start action={} , method={} , type={} , key={}",
                    req.getPathInfo(), "delete", rateLimitConfigDto.getType(), rateLimitConfigDto.getLimitKey());
            result = AsyncManager.sendActionToAsyncServers("delete", rateLimitConfigDto, req.getHeader("Authorization"), asyncServers, "delete");
        } else {
            throw new HttpException("body is empty", HttpStatus.SC_BAD_REQUEST);
        }
        return result;
    }

    private void validateRequestParameterForDelete(RateLimitConfigDto rateLimitConfigDto) throws HttpException {
        if (rateLimitConfigDto.getLimitKey() == null || rateLimitConfigDto.getLimitKey().isEmpty()) {
            throw new HttpException("key is required");
        }
    }

    private boolean isActionValid(String pathInfo) {
        return pathInfo == null || pathInfo.isEmpty() || pathInfo.equals("/");
    }
}