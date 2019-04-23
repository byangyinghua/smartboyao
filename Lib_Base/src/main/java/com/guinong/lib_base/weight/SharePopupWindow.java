/*
package com.guinong.lib_base.weight;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.guinong.lib_base.R;
import com.guinong.lib_base.adapter.RShareAdapter;
import com.guinong.lib_base.bean.ShareDataBean;
import com.guinong.lib_base.bean.ShareModel;
import com.guinong.lib_base.utils.CheckAppUtils;

import java.text.DecimalFormat;
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;

public class SharePopupWindow {

    public static final int TYPE_QRE = 1;
    public static final int TYPE_NONEQRE = 2;
    private Context context;
    private ShareParams shareParams;
    private OnClickBackListener mListener = null;
    private ShareModel shareModel;
    private static String[] shareNames;
    private static String[] shareNamesOne;
    private int mType = TYPE_NONEQRE;
    private String commission;  //奖励最高比例
    private int[] shareIcons = new int[]{R.mipmap.icon_popupwindow_qrcodeon, R.mipmap.btn_wechaton, R.mipmap.btn_circleoffriendson, R.mipmap.btn_sinaon,
            R.mipmap.btn_qqon};
    private int[] shareIconsOne = new int[]{R.mipmap.btn_wechaton, R.mipmap.btn_circleoffriendson, R.mipmap.btn_sinaon, R.mipmap.btn_qqon};
    private Dialog dialog;
    private View view;
    private DelegateAdapter delegateAdapter;

    public SharePopupWindow(Context cx, Activity mActivity, int type, String commission) {
        this.context = cx;
        this.mType = type;
        this.commission = commission;
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        shareNamesOne = new String[]{context.getResources().getString(R.string.ssdk_wechat), context.getResources().getString(R.string.ssdk_wechatmoments), context.getResources().getString(R.string.ssdk_sinaweibo), context.getResources().getString(R.string.ssdk_qq)};
        shareNames = new String[]{context.getResources().getString(R.string.ssdk_erq), context.getResources().getString(R.string.ssdk_wechat), context.getResources().getString(R.string.ssdk_wechatmoments), context.getResources().getString(R.string.ssdk_sinaweibo), context.getResources().getString(R.string.ssdk_qq)};
        showShareWindow();
    }

    public void showBottomWindow() {
        dialog.show();
    }

    public void showShareWindow() {
        view = LayoutInflater.from(context).inflate(R.layout.sharedrawerone, null);
        TextView mTv = (TextView) view.findViewById(R.id.commission_ratio);
        RecyclerView gridView = (RecyclerView) view.findViewById(R.id.share_gridview);
        TextView cancel = (TextView) view.findViewById(R.id.cancel);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(context);
        gridView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        gridView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        gridView.setAdapter(delegateAdapter);
        GridLayoutHelper helper = new GridLayoutHelper(4);
        helper.setVGap(8);
        ShareDataBean mBean = new ShareDataBean();
        if (mType == TYPE_QRE) {
            mBean.setShareIcons(shareIcons);
            mBean.setShareNames(shareNames);
            mTv.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("");
            if (commission != null && !commission.equals("null") && !commission.equals("")) {
                mTv.setText("最高可获奖励" + (df.format(Double.parseDouble(commission))) + "%");
            }
        } else if (mType == TYPE_NONEQRE) {
            mBean.setShareIcons(shareIconsOne);
            mBean.setShareNames(shareNamesOne);
            mTv.setVisibility(View.GONE);
        }
        RShareAdapter adapter = new RShareAdapter(context, helper, mBean);
        delegateAdapter.addAdapter(adapter);
        setPopWindowStyle(context);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        adapter.setOnRecycleItemClickListener(new ShareItemClickListener());

    }

    private void setPopWindowStyle(Context context) {
        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
    }

    private class ShareItemClickListener implements RShareAdapter.OnRecycleItemClickListener {

        public ShareItemClickListener() {
        }

        @Override
        public void OnRecycleItemClick(int position) {
            if (mType == TYPE_QRE) {
                if (position == 1 || position == 2) {
                    if (!CheckAppUtils.isWeixinAvilible(context)) {
                        Toast.makeText(context, "检测到您未安装微信客户端或者版本较低", Toast.LENGTH_SHORT).show();
                    } else {
                        share(position);
                    }
                } else if (position == 3) {
                    if (!CheckAppUtils.checkSinaVersin(context)) {
                        Toast.makeText(context, "检测到您未安装微博客户端或者版本较低", Toast.LENGTH_SHORT).show();
                    } else {
                        share(position);
                    }
                } else {
                    share(position);
                }
            } else if (mType == TYPE_NONEQRE) {
                if (position == 0 || position == 1) {
                    if (!CheckAppUtils.isWeixinAvilible(context)) {
                        Toast.makeText(context, "检测到您未安装微信客户端或者版本较低", Toast.LENGTH_SHORT).show();
                    } else {
                        shareNone(position);
                    }
                } else if (position == 2) {
                    if (!CheckAppUtils.checkSinaVersin(context)) {
                        Toast.makeText(context, "检测到您未安装微博客户端或者版本较低", Toast.LENGTH_SHORT).show();
                    } else {
                        shareNone(position);
                    }
                } else {
                    shareNone(position);
                }
            }
            dialog.dismiss();
        }
    }


    */
/**
     * 分享
     *
     * @param position
     *//*

    private void share(int position) {
        switch (position) {
            case 0:
                play(0);
                break;
            case 1:
                play(1);
                break;
            case 2:
                play(2);
                break;
            case 3:
                play(3);
                break;
            case 4:
                play(4);
                break;
            default:
                break;
        }
    }

    public void play(int position) {
        Platform plat = null;
        plat = ShareSDK.getPlatform(context, getPlatform(position));
        switch (position) {
            case 0:
                if (mListener != null) {
                    mListener.OnQRQClicked();
                }
                break;
            case 1:
            case 2:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText());
                    shareParams.setUrl(shareModel.getUrl());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                }
                break;
            case 3:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText() + shareModel.getUrl());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                }
                break;
            case 4:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitleUrl(shareModel.getUrl());
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                }
                break;
        }
        if (position != 0) {
            plat.share(shareParams);
            plat.setPlatformActionListener(new PlatformActionListener() {
                @Override
                public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    if (mListener != null) {
                        mListener.OnShareSuccess();
                    }
                }

                @Override
                public void onError(Platform platform, int i, Throwable throwable) {
                    if (mListener != null) {
                        mListener.OnShareError();
                    }
                }

                @Override
                public void onCancel(Platform platform, int i) {
                    if (mListener != null) {
                        mListener.OnShareCancle();
                    }
                }
            });
        }
    }


    */
/**
     * 分享
     *
     * @param position
     *//*

    private void shareNone(int position) {
        switch (position) {
            case 0:
                playNone(0);
                break;
            case 1:
                playNone(1);
                break;
            case 2:
                playNone(2);
                break;
            case 3:
                playNone(3);
                break;
            default:
                break;
        }
    }

    public void playNone(int position) {
        Platform plat = null;
        plat = ShareSDK.getPlatform(context, getPlatformNone(position));
        switch (position) {
            case 0:
            case 1:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    //shareParams.setTitle("标题");
                    // shareParams.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
// shareParams.setText("我是分享文本");
//                    shareParams.setUrl("http://www.mob.com ");
//                    shareParams.setImageUrl("http://image.qiding.tv/upload/userHeadImg/liveUserHeadImg12345828_20170709130844.jpg");


                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText());
                    shareParams.setUrl(shareModel.getUrl());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                   */
/* Bitmap imageData = BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo_app);
                    shareParams.setImageData(imageData);*//*

                }
                break;
            case 2:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText() + shareModel.getUrl());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                    */
/*Bitmap imageData = BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo_app);
                    shareParams.setImageData(imageData);*//*

                }
                break;
            case 3:
                if (shareModel != null) {
                    shareParams = new ShareParams();
                    shareParams.setShareType(Platform.SHARE_WEBPAGE);
                    shareParams.setTitleUrl(shareModel.getUrl());
                    shareParams.setTitle(shareModel.getTitle());
                    shareParams.setText(shareModel.getText());
                    shareParams.setImageUrl(shareModel.getImageUrl());
                    */
/*Bitmap imageData = BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo_app);
                    shareParams.setImageData(imageData);*//*

                }
                break;
        }
        plat.share(shareParams);
        plat.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                if (mListener != null) {
                    mListener.OnShareSuccess();
                }
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                if (mListener != null) {
                    mListener.OnShareError();
                }
            }

            @Override
            public void onCancel(Platform platform, int i) {
                if (mListener != null) {
                    mListener.OnShareCancle();
                }
            }
        });
    }

    */
/**
     * 初始化分享参数
     *
     * @param shareModel
     *//*

    public void initShareParams(ShareModel shareModel) {
        this.shareModel = shareModel;
    }

    */
/**
     * 获取平台
     *
     * @param position
     * @return
     *//*

    private String getPlatform(int position) {
        String platform = "";
        switch (position) {
            case 0:
                break;
            case 1:
                platform = "Wechat";
                break;
            case 2:
                platform = "WechatMoments";
                break;
            case 3:
                platform = "SinaWeibo";
                break;
            case 4:
                platform = "QQ";
                break;
            default:
                break;
        }
        return platform;
    }

    */
/**
     * 获取平台
     *
     * @param position
     * @return
     *//*

    private String getPlatformNone(int position) {
        String platform = "";
        switch (position) {
            case 0:
                platform = "Wechat";
                break;
            case 1:
                platform = "WechatMoments";
                break;
            case 2:
                platform = "SinaWeibo";
                break;
            case 3:
                platform = "QQ";
                break;
            default:
                break;
        }
        return platform;
    }

    public void setOnClickBackListener(OnClickBackListener listener) {
        this.mListener = listener;
    }

    public interface OnClickBackListener {
        void OnShareSuccess();

        void OnShareError();

        void OnShareCancle();

        void OnQRQClicked();
    }
}
*/
