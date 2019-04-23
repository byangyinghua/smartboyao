package com.guinong.lib_utils.check;


import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 组件设置值工具类
 *
 * @author yangmbin
 * Create at 2017/12/4 16:39
 */
public class SetUtil {

    /**
     * 设置背景颜色
     *
     * @param view
     * @param color
     */
    public static void setBackgroundColor(View view, int color) {
        if (view == null)
            return;
        view.setBackgroundColor(color);
    }

    /**
     * 设置是否可见
     *
     * @param view
     * @param visibility
     */
    public static void setVisibility(View view, int visibility) {
        if (view == null)
            return;
        view.setVisibility(visibility);
    }

    /**
     * 设置文本
     *
     * @param view
     * @param text
     */
    public static void setText(View view, CharSequence text) {
        if (view == null)
            return;
        if (text == null)
            text = "";
        if (view instanceof TextView)
            ((TextView) view).setText(text);
        else if (view instanceof EditText)
            ((EditText) view).setText(text);
        else if (view instanceof CheckBox)
            ((CheckBox) view).setText(text);
    }

    public static String isEmpty(String text) {
        if (TextUtils.isEmpty(text)) {
            return "";
        } else {
            return text;
        }
    }

    /**
     * 设置文本
     *
     * @param view
     * @param text
     */
    public static void setText(View view, int text) {
        if (view == null)
            return;
        if (text == 0)
            return;
        if (view instanceof TextView)
            ((TextView) view).setText(text);
        else if (view instanceof EditText)
            ((EditText) view).setText(text);
        else if (view instanceof CheckBox)
            ((CheckBox) view).setText(text);
    }

    /**
     * 设置图片
     *
     * @param resId
     */
    public static void setImageResource(View view, int resId) {
        if (view == null)
            return;
        if (view instanceof ImageView)
            ((ImageView) view).setImageResource(resId);
    }

    /**
     * 设置背景
     *
     * @param view
     * @param background
     */
    public static void setBackground(View view, Drawable background) {
        if (view == null || background == null)
            return;
        view.setBackground(background);
    }

    /**
     * 设置背景
     *
     * @param view
     * @param resId
     */
    public static void setBackgroundResource(View view, int resId) {
        if (view == null)
            return;
        view.setBackgroundResource(resId);
    }

    public static Point getScreenMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        return new Point(w_screen, h_screen);
    }

    public static Boolean checkIsVisible(Context context, View view) {
        // 如果已经加载了，判断广告view是否显示出来，然后曝光
        int screenWidth = getScreenMetrics(context).x;
        int screenHeight = getScreenMetrics(context).y;
        Rect rect = new Rect(0, 0, screenWidth, screenHeight);
        int[] location = new int[2];
        view.getLocationInWindow(location);
        if (view.getLocalVisibleRect(rect)) {
            return true;
        } else {
            //view已不在屏幕可见区域;
            return false;
        }
    }
}
