package com.guinong.net;/*
package com.guinong.net;

import android.content.Context;

import com.alibaba.sdk.android.httpdns.HttpDnsService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

*/
/**
 * @author wangyu
 * @time 2017/9/25 0025 on 上午 11:16
 * @desc
 *//*

public class OkHttpDns implements Dns {

    private static final Dns SYSTEM = Dns.SYSTEM;
    HttpDnsService httpdns;//httpdns 解析服务
    private static OkHttpDns instance = null;
    public static final String accountID = "179831";

    private OkHttpDns(Context context) {
        this.httpdns = com.alibaba.sdk.android.httpdns.HttpDns.getService(context, accountID);
        this.httpdns.setCachedIPEnabled(true);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("api.guinong.com");
        this.httpdns.setPreResolveHosts(arrayList);
    }
    public static OkHttpDns getInstance(Context context) {
        if(instance == null) {
            instance = new OkHttpDns(context);
        }
        return instance;
    }
    @Override
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        //通过异步解析接口获取ip
        //Log.e("OkHttpDns", "hostname:" + hostname);
        String ip = httpdns.getIpByHostAsync(hostname);
        if(ip != null) {
            List<InetAddress> inetAddresses = Arrays.asList(InetAddress.getAllByName(ip));
            //如果ip不为null，直接使用该ip进行网络请求
            //Log.e("OkHttpDns", "inetAddresses:" + inetAddresses);
            return inetAddresses;
        }
        //如果返回null，走系统DNS服务解析域名zd

        return Dns.SYSTEM.lookup(hostname);
    }
}
*/
