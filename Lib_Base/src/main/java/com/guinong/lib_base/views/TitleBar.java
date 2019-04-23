package com.guinong.lib_base.views;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guinong.lib_base.R;

/**
 * 页面顶部导航
 *
 * @author yangmbin
 * Create at 2018/2/7 9:43
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private LinearLayout mBackBtn;
    private TitleBarClickListener mListener;
    private TextView mTitle;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.title_bar, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mBackBtn = mView.findViewById(R.id.top_bar_back);
        mTitle = mView.findViewById(R.id.top_bar_title);

        mBackBtn.setOnClickListener(this);
    }

    public void setTitleText(String title) {
        mTitle.setText(title);
    }

    public void setTitleText(int titleResId) {
        mTitle.setText(titleResId);
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if (resId == R.id.top_bar_back) {
            mListener.clickTitleBarBack();
        }
    }

    public void setTitleBarClickListener(TitleBarClickListener listener) {
        mListener = listener;
    }

    public interface TitleBarClickListener {
        void clickTitleBarBack();

    }
}
