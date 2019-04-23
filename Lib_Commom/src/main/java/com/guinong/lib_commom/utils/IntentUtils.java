package com.guinong.lib_commom.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.guinong.lib_utils.Constants;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/4/12 14:15
 * @desc activity跳转
 */
public class IntentUtils {

    //启动模式
    //Intent.FLAG_ACTIVITY_NEW_TASK;  是为Activity指定 “SingleTask”启动模式
    //Intent.FLAG_ACTIVITY_SINGLE_TOP  Activity指定 “SingleTop”启动模式
    //Intent.FLAG_ACTIVITY_CLEAR_TOP  启动时会将与该Activity在同一任务栈的其它Activity出栈，一般与SingleTask启动模式一起出现
    public static String TAB_INDEX = "index";
    public static String DATA = "data";
    public static String DATA1 = "data1";
    public static String ORDER_TYPE = "order_type";
    public static String EVENT = "event";
    public static String INFO = "info";
    public static String BOO = "boo";
    public static String POSTION = "POSTION";
    public static String BOO1 = "boo1";
    public static String CATEGORYTYPE = "TYPE";
    public static final int REQUEST_SEARCH = 1;
    public static String TYPE = "type";//区别进入某个界面的类型





    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data, String data1) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(DATA1, data1)));
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data, int type,int postion) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)).putExtra(DATA1, type).putExtra(INFO,postion));
    }
    public static void gotoActivity(Context context, Class<?> activity, int data, int type,String into) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)).putExtra(DATA1, type).putExtra(INFO,into));
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data, Serializable type) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)).putExtra(DATA1, type));
    }

    public static void gotoActivity(Context context, Class<?> activity, int data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }


    public static void gotoActivity(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity)));
    }

    public static void gotoActivity(Context context, Class<?> activity, long data, String info) {
        Bundle bundle = new Bundle();
        bundle.putLong(DATA, data);
        bundle.putString(INFO, info);
        Intent intent = new Intent(context, activity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<?> activity, int data, String info) {
        Bundle bundle = new Bundle();
        bundle.putInt(DATA, data);
        bundle.putString(INFO, info);
        Intent intent = new Intent(context, activity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, String data1) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(DATA1, data1)));
    }

    public static void gotoActivity(Context context, Class<?> activity, String data, boolean boo) {
        context.startActivity((new Intent(context, activity).putExtra(INFO, data).putExtra(BOO, boo)));
    }

    /**
     * 无参带singTask模式
     *
     * @param context
     * @param activity
     */
    public static void gotoActivitySingleTask(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
    }


    /**
     * 返回该Activity 指定Fragment视图
     * 该Activity一般为SingleTask  模式 MainActivity
     *
     * @param context
     * @param index
     */
    public static void gotoMainActivity(Context context, Class<?> activity, int index) {
        context.startActivity((new Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(TAB_INDEX, index)));
    }

    /**
     * 跳转到我的订单，带启动模式 MeOrderActivity
     *
     * @param context
     * @param type
     */
    public static void gotoMeOrderActivityWithClearTop(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void gotoMeOrderActivityWithClearTopPay(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 跳转到我的订单，带启动模式 PublicWelfareActivity
     *
     * @param context
     * @param type
     */
    public static void gotoSpringOrderActivityWithClearTop(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 我的订单
     *
     * @param context
     * @param type    ApplyForCustomerServiceListActivity  MeOrderActivity
     */
    public static void gotoMeOrderActivity(Context context, Class<?> activity1, Class<?> activity2, int type) {
        if (type == Constants.ORDER_TYPE_AFTERSALES)
            context.startActivity((new Intent(context, activity1)));
        else
            context.startActivity((new Intent(context, activity2).putExtra(ORDER_TYPE, type)));
    }

    /**
     * 带参需返回结果
     *
     * @param context
     * @param activity
     * @param data
     * @param request
     */
    public static void gotoStartActivity(Activity context, Class<?> activity, String data, int request) {
        context.startActivityForResult((new Intent(context, activity).putExtra(DATA, data)), request);
    }

    public static void gotoMainActivityPay(Context context, Class<?> activity, int index) {
        context.startActivity((new Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(TAB_INDEX, index)));
    }
}
