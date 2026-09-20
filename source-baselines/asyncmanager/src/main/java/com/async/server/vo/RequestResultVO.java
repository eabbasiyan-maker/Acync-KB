package com.async.server.vo;

/**
 * Created by h.mehrara on 1/27/2015.
 */
public class RequestResultVO {
    int serverId;
    private boolean success;
    private String response;
    private int statusCode;

    public RequestResultVO() {
    }

    public RequestResultVO(int serverId, boolean success, String response, int statusCode) {
        this.serverId = serverId;
        this.success = success;
        this.response = response;
        this.statusCode = statusCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResponse() {
        return response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
}
