package com.guinong.lib_base.views.x5webview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.guinong.lib_base.R;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class X5WebView extends WebView {

    private Context mContext;
    private ProgressBar progressbar;  //进度条
    private int progressHeight = 6;  //进度条的高度，默认10px
    private onWebViewListener mListener;

    public X5WebView(Context arg0) {
        super(arg0);
        this.mContext = arg0;
      //  setBackgroundColor(85621);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
     requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public X5WebView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        this.mContext = arg0;
        //创建进度条
        progressbar = new ProgressBar(arg0, null, android.R.attr.progressBarStyleHorizontal);
        //设置加载进度条的高度
        progressbar.setLayoutParams(new AbsoluteLayout.LayoutParams(LayoutParams.MATCH_PARENT, progressHeight, 0, 0));
        Drawable drawable = arg0.getResources().getDrawable(R.drawable.progress_bar_states);
        progressbar.setProgressDrawable(drawable);
        //添加进度到WebView
        addView(progressbar);
        initWebViewSettings();
        this.getView().setClickable(true);
    }

    private void initWebViewSettings() {
        WebSettings webSetting = this.getSettings();
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setLoadsImagesAutomatically(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setTextSize(WebSettings.TextSize.NORMAL);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setBlockNetworkImage(false);
        webSetting.setBuiltInZoomControls(false);
        webSetting.setSupportZoom(false);
        webSetting.setUseWideViewPort(true);
        webSetting.setDisplayZoomControls(false);
        //不缓存
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        setWebChromeClient(new WVChromeClient());
        setWebViewClient(new WVClient());
    }

    //进度显示
    private class WVChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progressbar.setVisibility(GONE);
            } else {
                if (progressbar.getVisibility() == GONE)
                    progressbar.setVisibility(VISIBLE);
                progressbar.setProgress(newProgress);
            }
            if (mListener != null) {
                mListener.onProgressChange(view, newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView webView, String s) {
            super.onReceivedTitle(webView, s);
            if (mListener != null) {
                mListener.onFinishTitle(s);
            }
        }
    }

    private class WVClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            /**
             * 防止加载网页时调起系统浏览器
             */
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            //https忽略证书问题
            handler.proceed();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressbar.setVisibility(GONE);
            if (mListener != null) {
                mListener.onPageFinish(view);
            }
            super.onPageFinished(view, url);
        }
    }

    public void setOnWebViewListener(onWebViewListener listener) {
        this.mListener = listener;
    }

    //进度回调接口
    public interface onWebViewListener {

        void onProgressChange(WebView view, int newProgress);

        void onPageFinish(WebView view);

        void onFinishTitle(String title);
    }
}
