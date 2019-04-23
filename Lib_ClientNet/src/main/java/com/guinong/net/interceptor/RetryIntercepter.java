package com.guinong.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author csn
 * @date 2017/8/18 0018 13:54
 * @content 重试连接拦截器  网络不好时
 */
public class RetryIntercepter implements Interceptor {

    public int maxRetry;
    private int retryNum = 0;

    public RetryIntercepter(int maRetry) {
        this.maxRetry = maRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        System.out.println("retryNum=" + retryNum);
        Response response = chain.proceed(request);
        while (!response.isSuccessful() && retryNum < maxRetry) {
            retryNum++;
            System.out.println("retryNum=" + retryNum);
            response = chain.proceed(request);
        }
        return response;
    }
}
