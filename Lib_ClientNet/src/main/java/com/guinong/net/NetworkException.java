package com.guinong.net;

/**
 * @author csn
 * @date 2017/7/25 0025 18:15
 * @content
 */
public class NetworkException extends RuntimeException {

    private  int code;
    private  String detail;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public NetworkException(int code, String message) {
        this(code,message,null,null);
        setDetail(message);
    }

    public NetworkException(int code, String message, String detail, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.detail = detail;
    }
}
