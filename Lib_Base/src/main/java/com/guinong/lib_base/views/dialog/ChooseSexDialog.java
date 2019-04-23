package com.guinong.lib_base.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.guinong.lib_base.R;


/**
 * 自定义弹出对话框
 * @author ymb
 * Create at 2017/4/27 17:04
 */
public class ChooseSexDialog extends Dialog {

    private Context mContext;
    private ClickCallBack mCallBack;
    private TextView tv_sex_man;
    private TextView tv_sex_woman;
    private TextView tv_cancel;

    public ChooseSexDialog(Context context, ClickCallBack callBack) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mCallBack = callBack;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_choose_sex, null);
        setContentView(view);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        lp.width = (int) (dm.widthPixels); // 把对话框宽度设置为屏幕宽度的0.8
        dialogWindow.setAttributes(lp);



        // 设置按钮监听
        tv_sex_man = (TextView) view.findViewById(R.id.tv_sex_man);
        tv_sex_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onConfirm(tv_sex_man.getText().toString().trim());
                dismiss();
            }
        });
        // 设置按钮监听
        tv_sex_woman = (TextView) view.findViewById(R.id.tv_sex_woman);
        tv_sex_woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onConfirm(tv_sex_woman.getText().toString().trim());
                dismiss();
            }
        });
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    // 回调接口，执行具体的处理逻辑
    public interface ClickCallBack {
        void onConfirm(String sex);
    }





}
