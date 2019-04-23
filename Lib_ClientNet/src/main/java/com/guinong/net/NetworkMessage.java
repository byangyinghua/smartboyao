package com.guinong.net;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/7/25 0025 17:58
 * @content
 */
public class NetworkMessage implements Serializable {

    private String status;
    private String message;
    private boolean success;
    public boolean isSuccess() {
        return success;
    }
    private NetworkErrorInfo error;

    public NetworkErrorInfo getError() {
        return error;
    }

    public void setError(NetworkErrorInfo error) {
        this.error = error;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
