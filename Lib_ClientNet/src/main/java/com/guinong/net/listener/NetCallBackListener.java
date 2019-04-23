package com.guinong.net.listener;

import okhttp3.Request;

/**
 * @author wangyu
 * @time 2018/1/2 0002 on 下午 14:01
 * @desc
 */
public interface NetCallBackListener {

    void onNotLogon(Request request);

}
