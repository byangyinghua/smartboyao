package com.guinong.lib_commom.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 带删除线的TextView
 * @author ymb
 * Create at 2017/4/28 9:33
 */
public class DeleteLineTextView extends TextView {
    public DeleteLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        this.getPaint().setAntiAlias(true); // 抗锯齿
    }
}
