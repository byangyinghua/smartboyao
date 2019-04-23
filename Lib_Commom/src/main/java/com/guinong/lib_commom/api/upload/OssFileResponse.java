package com.guinong.lib_commom.api.upload;

import java.io.Serializable;

/**
 * Created by wangyu on 2018/9/6 0006.
 */

public class OssFileResponse implements Serializable{


    /**
     * accessid : DwXs8JBGzDHsyTUR
     * policy : eyJleHBpcmF0aW9uIjoiMjAxOC0wOS0wNlQwNjowNzowNi42MDNaIiwiY29uZGl0aW9ucyI6W1siY29udGVudC1sZW5ndGgtcmFuZ2UiLDAsMTA0ODU3NjAwMF0sWyJzdGFydHMtd2l0aCIsIiRrZXkiLCJzdGF0aWMvMjAxODA5LyJdXX0=
     * signature : Cju4oEz72Ji46L4ho+bwlRUHtNY=
     * dir : static/201809/
     * host : http://guinongtest.oss-cn-shenzhen.aliyuncs.com
     * expire : 1536214026
     */

    private String accessid;
    private String policy;
    private String signature;
    private String dir;
    private String host;
    private String expire;

    public String getAccessid() {
        return accessid;
    }

    public void setAccessid(String accessid) {
        this.accessid = accessid;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }
}
