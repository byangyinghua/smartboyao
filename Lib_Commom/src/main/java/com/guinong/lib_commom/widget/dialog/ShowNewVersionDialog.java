/*
package com.guinong.lib_commom.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.guinong.lib_commom.R;
import com.guinong.lib_commom.api.guinong.goods.response.UpdateAppResponse;
import java.math.BigDecimal;

*/
/**
 * 自定义弹出对话框
 * @author ymb
 * Create at 2017/4/27 17:04
 *//*

public class ShowNewVersionDialog extends Dialog {

    private Context mContext;
    private ClickCallBack mCallBack;
    private ImageView iv_delete;
    private TextView tv_content;
    private TextView tv_version;
    private TextView tv_apk_size;
    private Button btn_update;
    private FlikerProgressBar flikerbar;
    private UpdateAppResponse updateAppResponse;
    public ShowNewVersionDialog(Context context, ClickCallBack callBack, UpdateAppResponse response) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mCallBack = callBack;
        updateAppResponse=response;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_show_new_version, null);
        setContentView(view);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        lp.width = (dm.widthPixels); // 把对话框宽度设置为屏幕宽度的0.8
        lp.height=dm.heightPixels;
        dialogWindow.setAttributes(lp);



        // 设置按钮监听
        iv_delete = (ImageView) view.findViewById(R.id.iv_delete);
        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        iv_delete.setVisibility(!updateAppResponse.isIsMustUpdate() ? View.VISIBLE : View.GONE);
        // 设置按钮监听
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(updateAppResponse.getDescription());
        tv_version = (TextView) view.findViewById(R.id.tv_version);
        tv_apk_size = (TextView) view.findViewById(R.id.tv_apk_size);
        tv_version.setText("最新版本:V"+updateAppResponse.getVision());
        tv_apk_size.setText("版本大小:"+updateAppResponse.getSize()+"M");
        btn_update = (Button) view.findViewById(R.id.btn_update);
        flikerbar = (FlikerProgressBar) view.findViewById(R.id.flikerbar);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onConfirm("");
                btn_update.setVisibility(View.GONE);
                flikerbar.setVisibility(View.VISIBLE);
                iv_delete.setVisibility(View.GONE);
            }
        });

    }

    // 回调接口，执行具体的处理逻辑
    public interface ClickCallBack {
        void onConfirm(String sex);
    }
public void setVisibleDeleteImageView(boolean isVisible){
    if (iv_delete!=null) {
        iv_delete.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}

    */
/**
     * 设置进度
     * @param aa
     *//*

    public void setProgressText(float aa){
        int bb= (int) aa;
        flikerbar.setProgress(bb);
        // tvProgress.isShowText();
    }

    */
/**
     * 设置app大小
     * @param size
     *//*

    public void setAppSizeText(float size){
        if (tv_apk_size!=null) {

            BigDecimal bigDecimal=new BigDecimal(size);
            //bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            tv_apk_size.setText("版本大小:"+ f1+"M");
            tv_apk_size.setVisibility(View.VISIBLE);
        }
        // tvProgress.isShowText();
    }
    */
/**
     * 设置app大小
     * @param size
     *//*

    public void setAppSizeText(String size){
        if (tv_apk_size!=null) {

            tv_apk_size.setText("版本大小:"+ size+"M");
            tv_apk_size.setVisibility(View.VISIBLE);
        }
        // tvProgress.isShowText();
    }
}
*/
