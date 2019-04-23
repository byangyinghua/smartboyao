package com.guinong.lib_base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;

import com.guinong.lib_base.R;

/**
 * 但在手机上运行后会发现可点击文本带有下划线，并点击后有点击点击背景

 1.取消下划线
 */

@SuppressLint("ParcelCreator")
public class NoUnderlineSpan extends UnderlineSpan {
    private Context context;
    public NoUnderlineSpan(Context mcontext){
       context= mcontext;
    }
    @Override

    public void updateDrawState(TextPaint ds) {

        ds.setColor(context.getResources().getColor(R.color.theme));

//设置可点击文本的字体颜色

        ds.setUnderlineText(false);

    }

}