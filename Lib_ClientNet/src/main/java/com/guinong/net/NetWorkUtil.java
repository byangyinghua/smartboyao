package com.guinong.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author wangyu
 * @time 2016/8/30 11:36
 * @desc 全局的工具类
 */
public class NetWorkUtil {
    private static final String SETTINGS_3C_KEYBOARD_HEIGHT = "keyboardheight" ;

    /**
     * 检查是否有网络连接
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
