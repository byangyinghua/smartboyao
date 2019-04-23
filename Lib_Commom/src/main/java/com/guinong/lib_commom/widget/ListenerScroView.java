package com.guinong.lib_commom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author wangyu
 * @time 2017/9/18 0018 on 上午 10:04
 * @desc
 */
public class ListenerScroView extends ScrollView{

    private OnScrollChanged mOnScrollChanged = null;

    public ListenerScroView(Context context) {
        this(context,null);
    }

    public ListenerScroView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ListenerScroView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChanged != null)
            mOnScrollChanged.onScroll(l, t, oldl, oldt);
    }

    public void setOnScrollChanged(OnScrollChanged onScrollChanged){
        this.mOnScrollChanged = onScrollChanged;
    }
    public interface OnScrollChanged{
        void onScroll(int l, int t, int oldl, int oldt);
    }


}
