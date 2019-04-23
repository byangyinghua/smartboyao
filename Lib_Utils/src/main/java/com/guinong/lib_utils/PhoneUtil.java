package com.guinong.lib_utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 与拨打电话有关的工具类
 *
 * @author lw
 * @time 2016-08-2
 */
public class PhoneUtil {

    /**
     * 该方法使用意图方式实现跳转至拨电话电话的界面，并且将电话号码显示在拨号界面，
     * 用户只需要点击拨号键即可实现拨打电话功能
     *
     * @param context  :上下文
     * @param phoneStr :电话号码
     */
    public static void dialerInterfaced(Context context, String phoneStr) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneStr));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 该方法使用意图方式直接实现拨打电话功能
     *
     * @param context  :上下文
     * @param phoneStr :电话号码
     */
    public static void callThePhone(Context context, String phoneStr) {

        Uri uri = Uri.parse("tel:" + phoneStr); // 拨打电话号码的URI格式
        Intent intent = new Intent(); // 实例化Intent
        intent.setAction(Intent.ACTION_CALL); // 指定Action
        intent.setData(uri); // 设置数据
        context.startActivity(intent);// 启动Acitivity
    }

    /**
     * 验证手机号：传入一个字符串，返回它是否为手机号码的判断结果
     *
     * @return Boolean类型的只
     */
    public static boolean isMobileNO(String phoneStr) {
        Pattern p = Pattern
                .compile("^1\\d{10}$");
        Matcher m = p.matcher(phoneStr);
        return m.matches();
    }

    /**
     * 把电话号码中间四位用*号代替
     * @param phoneStr
     * @return
     */
    public static String encriptMobileNo(String phoneStr) {
        if (phoneStr != null && phoneStr.length() == 11) {
            return phoneStr.substring(0, 3) + "****" + phoneStr.substring(7, 11);
        } else {
            return phoneStr;
        }
    }

    /**
     * 格式化手机号码 13512345678 -> 135-1234-5678
     * @param phoneStr
     * @return
     */
    public static String formatMobileNo(String phoneStr) {
        if (phoneStr != null && phoneStr.length() == 11) {
            return phoneStr.substring(0, 3) + "-" + phoneStr.substring(3, 7) + "-" + phoneStr.substring(7, 11);
        } else {
            return phoneStr;
        }
    }
}
