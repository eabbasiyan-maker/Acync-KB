package com.async.server.vo;

public class ResponseVO<T> {
    private int code;
    private String msg;
    private boolean success;
    private T data;

    public ResponseVO(int code, String msg, boolean success, T data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public static <T> ResponseVO<T> ok(T data) {
        return new ResponseVO<>(200, "success", true, data);
    }

    public static <T> ResponseVO<T> error(int code, String msg) {
        return new ResponseVO<>(code, msg, false, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
