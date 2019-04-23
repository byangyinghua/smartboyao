package com.guinong.lib_utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast {
    Toast toast;

    public MyToast(Context context, String msg) {
        View layout = LayoutInflater.from(context).inflate(R.layout.toast_layout_order, null);
        LinearLayout root = layout.findViewById(R.id.ll_root);
        TextView tv_msg = layout.findViewById(R.id.tv_msg);
        //设置控件的宽高
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(DensityUtils.dip2px(context, ViewGroup.LayoutParams.MATCH_PARENT),
                DensityUtils.dip2px(context, 50));
        root.setLayoutParams(lp);
        //设置数据
        if (msg == null) {
            tv_msg.setVisibility(View.GONE);
        } else {
            tv_msg.setText(msg);
        }
        //设置toast
        toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        //必须设置Gravity.FILL_HORIZONTAL 这个选项，布局文件的宽高才会正常显示
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(layout);
    }

    public void show() {
        toast.show();
    }


}
