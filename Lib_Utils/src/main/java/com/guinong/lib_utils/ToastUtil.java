package com.guinong.lib_utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author wangyu
 * @time 2016/8/30 11:56
 * @desc Toast提示工具
 */
public class ToastUtil {
    private static Toast toast = null;
    private static int TOAST_DURATION = Toast.LENGTH_LONG;
    private static int TOAST_SHORT = Toast.LENGTH_SHORT;

    /**
     * 普通文本消息提示
     *
     * @param context
     * @param text
     * @param duration
     */
    public static void TextToast(Context context, String text, int duration) {
        //创建一个Toast提示消息
        View v = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        TextView tv = v.findViewById(R.id.message);
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(v);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            tv.setText(text);
            toast.setDuration(duration);
        } else {
            //设置Toast提示消息在屏幕上的位置
            toast.setView(v);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            tv.setText(text);
        }
        //显示消息
        toast.show();
    }

    public static void TextToastOrder(Context context, String text, int duration) {
        //创建一个Toast提示消息
        View v = LayoutInflater.from(context).inflate(R.layout.toast_layout_order, null);
        TextView tv = v.findViewById(R.id.message);
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(v);
            toast.setGravity(Gravity.TOP, 0, 0);
            tv.setText(text);
            toast.setDuration(duration);
        } else {
            //设置Toast提示消息在屏幕上的位置
            toast.setView(v);
            toast.setGravity(Gravity.TOP, 0, 0);
            tv.setText(text);
        }
        //显示消息
        toast.show();
    }

    /**
     * 普通文本消息提示
     *
     * @param context
     * @param text
     */
    public static void TextToast(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        TextToast(context, text, TOAST_SHORT);
        /*if (SystemBarHelper.isMIUI6Later()) {

        } else {
            com.guinong.up.widget.Toast.showShort(text);
        }*/
    }

    public static void TextToastOrder(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        TextToastOrder(context, text, TOAST_DURATION);
        /*if (SystemBarHelper.isMIUI6Later()) {

        } else {
            com.guinong.up.widget.Toast.showShort(text);
        }*/
    }

    public static void TextToast(Context context, int strResId) {
        TextToast(context, context.getString(strResId));
    }

    public static void ImageTextToast(Context context, String text, int drawable) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        ImageTextToast(context, text, drawable, TOAST_SHORT);
    }

    public static void ImageTextToast(Context context, String text, String drawable) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        ImageTextToast(context, text, drawable, TOAST_SHORT);
    }

    /**
     * 普通文本消息提示
     *
     * @param context
     * @param text
     * @param duration
     */
    public static void ImageTextToast(Context context, String text, int drawable, int duration) {
        //创建一个Toast提示消息
        View v = LayoutInflater.from(context).inflate(R.layout.image_toast_layout, null);
        CircleImageView mImage = v.findViewById(R.id.mImage);
        TextView tv = v.findViewById(R.id.message);
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(v);
            toast.setGravity(Gravity.LEFT | Gravity.TOP, 0, 0);
            tv.setText(text);
            mImage.setImageResource(drawable);
            toast.setDuration(duration);
        } else {
            //设置Toast提示消息在屏幕上的位置
            toast.setView(v);
            toast.setGravity(Gravity.LEFT | Gravity.TOP, 0, 0);
            tv.setText(text);
            mImage.setImageResource(drawable);
        }
        //显示消息
        toast.show();
    }

    /**
     * 普通文本消息提示
     *
     * @param context
     * @param text
     * @param duration
     */
    public static void ImageTextToast(Context context, String text, String drawable, int duration) {
        //创建一个Toast提示消息
        View v = LayoutInflater.from(context).inflate(R.layout.image_toast_layout, null);
        CircleImageView mImage = v.findViewById(R.id.mImage);
        TextView tv = v.findViewById(R.id.message);
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(v);
            toast.setGravity(Gravity.LEFT | Gravity.TOP, 0, 0);
            tv.setText(text);
            //mImage.setImageResource(drawable);
            toast.setDuration(duration);
        } else {
            //设置Toast提示消息在屏幕上的位置
            toast.setView(v);
            toast.setGravity(Gravity.LEFT | Gravity.TOP, 0, 0);
            tv.setText(text);
            //mImage.setImageResource(drawable);
        }
        //显示消息
        toast.show();
    }

}
