package com.guinong.lib_base.views.popwindow;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.guinong.lib_base.R;

public class SelectPicPopupWindow {

    private Dialog dialog;
    private TextView btn_take_photo, btn_pick_photo, btn_cancel;
    private View mView;

    public SelectPicPopupWindow(Context context, final ClickCallBack callBack) {
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.select_pic_pop_window, null);
        btn_take_photo = (TextView) mView.findViewById(R.id.btn_take_photo);
        btn_pick_photo = (TextView) mView.findViewById(R.id.btn_pick_photo);
        btn_cancel = (TextView) mView.findViewById(R.id.btn_cancel);
        // 照相
        btn_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onTake();
                dialog.dismiss();
            }
        });
        // 选图图片
        btn_pick_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onPick();
                dialog.dismiss();
            }
        });
        // 取消按钮
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        setPopWindowStyle();
    }

    public interface ClickCallBack {
        void onTake();
        void onPick();
    }

    public void showBottomWindow() {
        dialog.show();
    }

    private void setPopWindowStyle() {
        dialog.setContentView(mView);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        // mView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = mView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(y < height){
                        dialog.dismiss();
                    }
                }
                return true;
            }
        });
    }
}