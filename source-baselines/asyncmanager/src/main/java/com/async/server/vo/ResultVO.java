package com.async.server.vo;

/**
 * Created by h.mehrara on 1/27/2015.
 */
public class ResultVO {
    private boolean success;
    private String content;
    private int statusCode;

    public ResultVO() {
    }

    public ResultVO(boolean success, String content) {
        this.success = success;
        this.content = content;
    }

    public ResultVO(boolean success, String content, int statusCode) {
        this.success = success;
        this.content = content;
        this.statusCode = statusCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getContent() {
        return content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
