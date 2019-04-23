package com.guinong.lib_base.views.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.guinong.lib_base.R;

/**
 * 菊花加载图
 * @author ymb
 * Create at 2017/5/26 19:02
 */
public class MumLoadingView extends ImageView {
    private AnimationDrawable mAnimationDrawable;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public MumLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_1), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_2), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_3), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_4), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_5), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_6), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_7), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_8), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_9), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_10), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_11), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.zebra_ic_list_view_loading_12), 40);
        mAnimationDrawable.setOneShot(false);
        this.setBackground(mAnimationDrawable);
        if (mAnimationDrawable != null && !mAnimationDrawable.isRunning())
            mAnimationDrawable.start();
    }
}
