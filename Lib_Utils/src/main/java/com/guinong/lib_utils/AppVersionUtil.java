package com.guinong.lib_utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by lw on 2017/6/10.
 * 版本更新的工具类
 *
 */

public class AppVersionUtil {

    /**
     * 获取当前程序版本号
     * @param context 上下文
     * @return 版本号
     */
    public static int getVersionCode(Context context){
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
    /**
     * 获取当前程序版本号
     * @param context 上下文
     * @return 版本名称
     */
    public static String getVersionName(Context context) {
        String version=null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);

            version= pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }

    /**
     * 判断当前版本是否为最新版本
     * @param context 上下文
     * @param netVersionCode 要进行比较的目标版本号
     * @return 是否为新版本
     */
    public static boolean isNewVersion(Context context,int netVersionCode){
        int nowVersionCode=getVersionCode(context);
        if (nowVersionCode!=-1&&netVersionCode>nowVersionCode) {
            return true;
        }else{
            return false;
        }
    }

}
