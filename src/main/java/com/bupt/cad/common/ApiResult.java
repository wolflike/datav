package com.bupt.cad.common;

public class ApiResult<T> {
    private int code;
    private String message;
    private T DATA;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDATA() {
        return DATA;
    }

    public void setDATA(T DATA) {
        this.DATA = DATA;
    }
}
