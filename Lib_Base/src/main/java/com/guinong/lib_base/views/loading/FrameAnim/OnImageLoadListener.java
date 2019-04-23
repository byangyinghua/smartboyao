package com.guinong.lib_base.views.loading.FrameAnim;

import android.graphics.drawable.BitmapDrawable;

/**
 * 图片加载监听
 *
 * @author haohao on 2017/6/27 14:25
 * @version v1.0
 */
public interface OnImageLoadListener {
    void onImageLoad(BitmapDrawable drawable);

    void onFinish();
}
