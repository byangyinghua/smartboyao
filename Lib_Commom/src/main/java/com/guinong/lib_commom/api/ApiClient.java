package com.guinong.lib_commom.api;

import android.content.Context;

import com.guinong.lib_commom.GNCommonApplication;
import com.guinong.net.RequestClient;
import com.guinong.net.interceptor.LoginInterceptor;
import com.guinong.net.interceptor.RetryIntercepter;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * @author wangyu
 * @time 2017/7/31 0031 on 上午 10:05
 * @desc
 */
public class ApiClient extends RequestClient {
    protected static OkHttpClient mOkHttpClient = null;
    private static final int TIME_OUT = 60;
    public static String NEW_HOST1 = "http://apiservice.guinong.com/";

    public static String NEW_HOST ;
    public static String YNW_HOST = "http://182.140.144.77:9003/exInterface/thirdParty/userInfoGet.ac" ;
    /*http://app.guinong.com/guinong_web*/
    public static final String IMAGE_HOST = "http://guinongtest.oss-cn-shenzhen.aliyuncs.com/";
    public static final String IMAGEURL = "http://app.guinong.com/guinong_web";

    public static void contextInit(final Context context,boolean isDebug) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        if (isDebug){
            NEW_HOST = "http://test.guinong.com/guinong_fresh_web";
        }else {
            NEW_HOST ="http://app.guinong.com/guinong_web";
        }
        //  okHttpClientBuilder.dns(OkHttpDns.getInstance(GNCommonApplication.getApplicaContext()));
        if (context != null) {
            //okHttpClientBuilder.cookieJar(new CookierManager(context));
            baseContext = context;
        }
        okHttpClientBuilder.followRedirects(true); //设置重定向 其实默认也是true
        LoginInterceptor interceptor = new LoginInterceptor(GNCommonApplication.context);

        okHttpClientBuilder.networkInterceptors().add(interceptor);
        okHttpClientBuilder.addInterceptor(new RetryIntercepter(3));
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        mOkHttpClient = okHttpClientBuilder.build();
    }

    static {
        if (mOkHttpClient == null) {
            contextInit(null,false);
        }
    }

    public ApiClient() {
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return mOkHttpClient;
    }
}
