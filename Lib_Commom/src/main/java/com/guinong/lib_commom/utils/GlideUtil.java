package com.guinong.lib_commom.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Util;
import com.guinong.lib_commom.R;
import com.guinong.lib_utils.CommonUtils;
import com.guinong.net.utils.SharedPreferencesUtils;

/**
 * @author wangyu
 * @time 2017/4/12 14:11
 * @desc 图片处理工具类
 */
public class GlideUtil {


    public static void setUserIcon(int recose, ImageView imageView) {
        imageView.setImageResource(recose);
    }

    public static void setUserIcon2(Context context, final String subUrl, final ImageView imageView) {
        if (Util.isOnMainThread()) {
            if (subUrl == null || TextUtils.isEmpty(subUrl)) {
                return;
            } else if (subUrl.contains("http")) {
                if (context != null) {
                    Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(150)).into(imageView);
                }
            } else {
                if (context != null) {
                    Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl + CommonUtils.getImageNetSize(150)).into(imageView);
                }
            }
        }
    }

    public static void setPicNoHostCategory(Context context, final String subUrl, final ImageView imageView) {
        if (Util.isOnMainThread()) {
            if (subUrl == null || TextUtils.isEmpty(subUrl)) {
                return;
            }
            if (imageView == null) {
                return;
            } else if (subUrl.contains("http")) {
                if (context != null) {
                    Glide.with(context).load(subUrl).into(imageView);
                }
            } else {
                if (context != null) {
                    Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl).into(imageView);
                }
            }
        }
    }

    @SuppressLint("NewApi")
    public static void setImage_Crop(Activity context, final String subUrl, final ImageView imageView, int errorDrawable) {
        if (!context.isDestroyed()) {
            if (subUrl == null || TextUtils.isEmpty(subUrl)) {
                return;
            }
            if (imageView == null) {
                return;
            }
            if (subUrl.contains("http")) {
                if (context != null) {
                    Glide.with(context).load(subUrl).apply(getCorpOptions(errorDrawable)).into(imageView);
                }
            } else {
                if (context != null) {
                    Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl).apply(getCorpOptions(R.mipmap.icon_z_default1)).into(imageView);
                    Log.d("niu", SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl);
                }
            }
        }
    }

    @SuppressLint("NewApi")
    public static void setImage_fitCenter(Activity context, final String subUrl, final ImageView imageView, int errorDrawable) {
        if (!context.isDestroyed()) {
            if (subUrl == null || TextUtils.isEmpty(subUrl)) {
                return;
            }
            if (imageView == null) {
                return;
            }
            if (subUrl.contains("http")) {
                if (context != null) {
                    Glide.with(context).load(subUrl).apply(getFitCenterOptions(errorDrawable)).into(imageView);
                }
            } else {
                if (context != null) {
                    Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl).apply(getFitCenterOptions(R.mipmap.icon_z_default1)).into(imageView);
                }
            }
        }
    }

    public static void setImage_fitCenter_NoActivity(Context context, final String subUrl, final ImageView imageView, int errorDrawable) {
        if (subUrl == null || TextUtils.isEmpty(subUrl)) {
            return;
        }
        if (imageView == null) {
            return;
        }
        if (subUrl.contains("http")) {
            if (context != null) {
                Glide.with(context).load(subUrl).apply(getFitCenterOptions(errorDrawable)).into(imageView);
            }
        } else {
            if (context != null) {
                Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl).apply(getFitCenterOptions(R.mipmap.icon_z_default1)).into(imageView);
            }
        }
    }

    public static void setImage_centerCrop_NoActivity(Context context, final String subUrl, final ImageView imageView, int errorDrawable) {
        if (subUrl == null || TextUtils.isEmpty(subUrl)) {
            return;
        }
        if (imageView == null) {
            return;
        }
        if (subUrl.contains("http")) {
            if (context != null) {
                Glide.with(context).load(subUrl).apply(getCorpOptions(errorDrawable)).into(imageView);
            }
        } else {
            if (context != null) {
                Glide.with(context).load(SharedPreferencesUtils.getInstance(context).getPicConfig() + subUrl).apply(getCorpOptions(R.mipmap.icon_c_default_2)).into(imageView);
            }
        }
    }


    private static RequestOptions getCorpOptions(int drawable) {
        return new RequestOptions()
                .placeholder(drawable)    //加载成功之前占位图
                .error(drawable)    //加载错误之后的错误图
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);    //只缓存最终的图片
    }


    private static RequestOptions getFitCenterOptions(int drawable) {
        return new RequestOptions()
                .placeholder(drawable)    //加载成功之前占位图
                .error(drawable)    //加载错误之后的错误图
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);    //只缓存最终的图片
    }
}
