package com.guinong.lib_base.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.guinong.lib_base.R;
import com.guinong.lib_base.views.LoadingBox;
import com.guinong.net.callback.BaseActivityLifecycleCallbacks;
import com.guinong.net.request.IAsyncRequestState;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wangyu
 * @time 2017/8/4 0004 on 下午 14:09
 * @desc
 */
public abstract class BaseFragmentActivity<P extends BasePresenter, M extends BaseModel> extends FragmentActivity implements View.OnClickListener {

    public P mPresenter;
    public M mModel;
    protected Context mContext;
    private LoadingBox box;
    protected String thisActivityName = "BaseActivity";
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setThisActivityName();
        setContentView(getLayoutId());
        mContext = this;
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        if (findViewById(R.id.box) != null) {
            box = new LoadingBox(this, findViewById(R.id.box));
            box.setClickListener(this);
        }
        //GnwAppManager.getInstance(CoolBuyApplication.getApplicaContext()).addActivity(this);
        mUnbinder = ButterKnife.bind(this);
        this.initModel();
        this.initView();
        this.initPresenter();
    }


    /**
     * 设置layout前配置（设置无标题、竖屏或着色状态栏等）
     */
    private void doBeforeSetContentView() {
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 获取布局文件
     */
    public abstract int getLayoutId();

    /**
     * 初始化Model
     */
    public abstract void initModel();

    /**
     * 初始化Presenter
     */
    public abstract void initPresenter();

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 用于统计页面组件
     */
    protected abstract void setThisActivityName();

    /**
     * 添加网络请求到请求列表
     *
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        BaseActivityLifecycleCallbacks.putCall(this.getClass().getName(),state);
    }

    /**
     * 全覆盖加载框
     */
    public void showFillLoading() {
        box.showLoadingLayout();
    }

    /**
     * 显示透明加载框
     */
    public void showTransLoading() {
        box.showTransLoadingLayout();
    }

    /**
     * 显示无数据页面
     */
    public void showNoDataLayout() {
        box.showNoDataLayout();
    }

    /**
     * 显示无网络页面
     */
    public void showNetOffLayout() {
        box.showInternetOffLayout();
    }

    /**
     * 显示网络错误页面
     */
    public void showNetErrorLayout() {
        box.showExceptionLayout();
    }

    /**
     * 停止加载框
     */
    public void stopAll() {
        box.hideAll();
    }

    /**
     * 网络重载按钮监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        networkRetry();
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {
    }

    /**
     * 设置无数据信息
     * @param message
     */
    public void setNoDataMessage(String message) {
        box.setNoDataMessage(message);
    }

    /**
     * 设置无网络信息
     * @param message
     */
    public void setNetOffMessage(String message) {
        box.setInternetOffMessage(message);
    }

    /**
     * 设置网络错误信息
     * @param message
     */
    public void setNetErrorMessage(String message) {
        box.setExceptionMessage(message);
    }

    /**
     * TitleBar返回按钮和手机back键执行动作一致
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 判断view不为空并显示
     * @param view
     */
    public void emptyVisibity(View view){
        if(view != null){
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view不为空并隐藏
     * @param view
     */
    public void emptyGone(View view){
        if(view != null){
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 判断view不为空且是否获取控件
     * @param view
     * @param isEnabled
     */
    public void emptyEnabled(View view,boolean isEnabled){
        if(null != view){
            view.setEnabled(isEnabled);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv, String str){
        if(null != tv && null != str){
            tv.setText(str);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv,int str){
        if(null != tv){
            tv.setText(str);
        }
    }

    /**
     * 设置View背景颜色
     * @param view
     * @param color
     */
    public void emptyViewBackColor(View view ,int color){
        if(null != view){
            view.setBackgroundColor(color);
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this); //统计时长
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this); //统计时长
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (mPresenter != null)
            mPresenter.onDestroy();
        // 帧动画结束
        if (box != null) {
            box.stopFrameAnim();
        }
    }
}
