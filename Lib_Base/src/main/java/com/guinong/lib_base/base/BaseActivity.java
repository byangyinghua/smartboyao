package com.guinong.lib_base.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bumptech.glide.Glide;
import com.guinong.lib_base.R;
import com.guinong.lib_base.views.CustomProgressDialog;
import com.guinong.lib_base.views.LoadingBox;
import com.guinong.lib_base.views.SystemBarHelper;
import com.guinong.lib_base.views.TitleBar;
import com.guinong.net.callback.BaseActivityLifecycleCallbacks;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.utils.SharedPreferencesUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoLayoutActivity;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity抽象类
 *
 * @author ymb
 * Create at 2017/7/13 11:19
 */
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AutoLayoutActivity implements TitleBar.TitleBarClickListener, OnRefreshLoadMoreListener {
    public P mPresenter;
    public M mModel;
    protected Activity mContext;
    private LoadingBox box;
    protected String thisActivityName = "BaseActivity";
    protected Dialog progressDialog;
    protected DecimalFormat mFormat;
    private TitleBar mTitleBar;

    private View.OnClickListener mReloadListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            networkRetry();
        }
    };

    private View.OnClickListener mCustomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            customClick();
        }
    };

    protected ImmersionBar mImmersionBar;


    private Unbinder mUnbinder;
    protected VirtualLayoutManager layoutManager;
    protected DelegateAdapter delegateAdapter;
    protected List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    protected SmartRefreshLayout mRefresh;
    protected String mUserId;
    protected int mIntUserId;
    protected int mShopid;
    //地图使用
    protected Bundle mSavedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSavedInstanceState = savedInstanceState;
        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        doBeforeSetContentView();
        setThisActivityName();
        mContext = this;
        thisActivityName = this.getClass().getName();
        if (!thisActivityName.equals("StartActivity") && !thisActivityName.equals("QrqDialogActivity")) {
            SystemBarHelper.hideSystemUI(this);
        }
        setContentView(getLayoutId());
        AppManager.addActivity(this);
        mFormat = new DecimalFormat("0.00");
        initImmersionBar();
        mUserId = SharedPreferencesUtils.getInstance(mContext).getUserId();
        mShopid = SharedPreferencesUtils.getInstance(mContext).getShopid();
        if (!TextUtils.isEmpty(mUserId))
            mIntUserId = Integer.valueOf(mUserId);
        //mShopid = 2;//暂时设置为2有数据
        // mShopid = String.valueOf(SharedPreferencesUtils.getInstance(mContext).getShopid());
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        if (findViewById(R.id.box) != null) {
            box = new LoadingBox(this, findViewById(R.id.box));
            box.setClickListener(mReloadListener);
            box.setCustomClickListener(mCustomListener);
        }
        if (findViewById(R.id.title_bar) != null) {
            mTitleBar = (TitleBar) findViewById(R.id.title_bar);
            mTitleBar.setTitleBarClickListener(this);
        }
        mUnbinder = ButterKnife.bind(this);
        getActionBarToolbar();
        addActivity();
        this.initModel();
        this.initView();
        this.initPresenter();
    }

    public int getColors(int color){
        return  mContext.getResources().getColor(color);
    }
    /**
     * 初始化Refresh
     */
    public void initRefresh() {
        if (findViewById(R.id.refreshLayout) != null) {
            mRefresh = findViewById(R.id.refreshLayout);
            mRefresh.setEnableAutoLoadMore(false);
            mRefresh.setEnableScrollContentWhenLoaded(true);
            mRefresh.setEnableLoadMoreWhenContentNotFull(true);
            mRefresh.setEnableFooterFollowWhenLoadFinished(true);
            mRefresh.setOnRefreshLoadMoreListener(this);
        }
    }

    public void initAdapter(RecyclerView mRecyler) {
        if (null != mRecyler) {
            final VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
            mRecyler.setLayoutManager(layoutManager);
            final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
            mRecyler.setRecycledViewPool(viewPool);
            viewPool.setMaxRecycledViews(0, 10);
            delegateAdapter = new DelegateAdapter(layoutManager, false);
            mRecyler.setAdapter(delegateAdapter);
        }
    }

    protected void getActionBarToolbar() {
        LinearLayout mBack = findViewById(R.id.top_bar_back);
        if (mBack != null) {
            mBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
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

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.navigationBarEnable(true).keyboardEnable(true).navigationBarWithKitkatEnable(true).init();
    }

    public void clickRightTitleBack(View view) {

    }

    /**
     * 添加Activity进栈
     */
    public void addActivity() {
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
    protected void setThisActivityName() {

    }

    /**
     * 添加网络请求到请求列表
     *
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        BaseActivityLifecycleCallbacks.putCall(this.getClass().getName(), state);
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
     * 显示自定义页面
     */
    public void showCustomLayout(int layoutId) {
        View customView = getLayoutInflater().inflate(layoutId, null, false);
        box.addCustomView(customView, layoutId + "");
        box.showCustomView(layoutId + "");
    }

    /**
     * 停止加载框
     */
    public void stopAll() {
        box.hideAll();
        stopRefresh();
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {
    }

    /**
     * 自定义页面按钮
     */
    protected void customClick() {

    }

    /**
     * 设置无数据信息
     *
     * @param message
     */
    public void setNoDataMessage(String message) {
        box.setNoDataMessage(message);
    }

    /**
     * 设置无网络信息
     *
     * @param message
     */
    public void setNetOffMessage(String message) {
        box.setInternetOffMessage(message);
    }

    /**
     * 设置网络错误信息
     *
     * @param message
     */
    public void setNetErrorMessage(String message) {
        box.setExceptionMessage(message);
    }

    /**
     * 设置toolbar title
     *
     * @param title
     */
    public void setToolBarTitle(String title) {
        if (null != title) {
            TextView top_bar_title = (TextView) findViewById(R.id.top_bar_title);
            if (top_bar_title != null) {
                top_bar_title.setText(title);
            }
        }
    }

    /**
     * 设置toolbar title
     *
     * @param title
     */
    public void setToolBarTitle(String title, int color) {
        if (null != title) {
            TextView top_bar_title = (TextView) findViewById(R.id.top_bar_title);
            if (top_bar_title != null) {
                top_bar_title.setText(title);
                top_bar_title.setTextColor(getResources().getColor(color));
            }
        }
    }

    /**
     * 设置右标题的监听
     */
    private void setRightTitleLinster() {
        LinearLayout llRight = (LinearLayout) findViewById(R.id.top_bar_right_btn);
        if (llRight != null) {
            llRight.setVisibility(View.VISIBLE);
            llRight.setOnClickListener(mRightListener);
        }
    }


    private View.OnClickListener mRightListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clickRightTitleBack(v);
        }
    };

    /**
     * 设置右侧名称
     *
     * @param title
     */
    public void setRightTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            setRightTitleLinster();//显示添加监听作用
            TextView top_right_title = (TextView) findViewById(R.id.tv_top_right_title);
            if (top_right_title != null) {
                top_right_title.setText(title);
            }
        }
    }


    /**
     * 设置右侧名称
     *
     * @param imageSource
     */
    public void setRightImageSource(int imageSource) {
        setRightTitleLinster();//显示添加监听作用
        ImageView top_right_title = findViewById(R.id.mRightIv);
        if (top_right_title != null) {
            top_right_title.setImageResource(imageSource);
        }
    }


    /**
     * 设置toolbar title
     *
     * @param title
     */
    public void setToolBarTitle(int title, int color) {
        TextView top_bar_title = (TextView) findViewById(R.id.top_bar_title);
        if (top_bar_title != null) {
            top_bar_title.setText(title);
            top_bar_title.setTextColor(getResources().getColor(color));
        }
    }

    public void setToolBarTitle(int sed) {
        TextView top_bar_title = (TextView) findViewById(R.id.top_bar_title);
        if (top_bar_title != null) {
            top_bar_title.setText(sed);
        }
    }

    /**
     * 设置toolbar drawable
     *
     * @param drawable
     */
    protected void setToolBarDrawable(int drawable) {
        ImageView mBackIv = (ImageView) findViewById(R.id.ic_back);
        if (mBackIv != null) {
            mBackIv.setImageResource(drawable);
        }
    }

    /**
     * 设置TitleBar标题
     *
     * @param title
     */
    public void setTitle(String title) {
        mTitleBar.setTitleText(title);
    }


    /**
     * 设置TitleBar标题
     *
     * @param titleResId
     */
    public void setTitle(int titleResId) {
        if (mTitleBar != null && getResources().getText(titleResId) != null)
            mTitleBar.setTitleText(titleResId);
    }

    /**
     * TitleBar返回按钮
     */
    @Override
    public void clickTitleBarBack() {
        onBackPressed();
    }

    /**
     * 顶层等待框
     **/
    public void showTopLoading() {
        stopTopLoading();
        progressDialog = CustomProgressDialog.createDialog(mContext);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    /**
     * 停止顶层等待框
     **/
    public void stopTopLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void stopRefresh() {
        if (mRefresh != null) {
            mRefresh.finishRefresh();
            mRefresh.finishLoadMore();
        }
    }


    /**
     * 隐藏软键盘
     *
     * @param
     */
    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    /**
     * 判断view不为空并显示
     *
     * @param view
     */
    public void emptyVisibity(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view不为空并隐藏
     *
     * @param view
     */
    public void emptyGone(View view) {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 判断view不为空且是否获取控件
     *
     * @param view
     * @param isEnabled
     */
    public void emptyEnabled(View view, boolean isEnabled) {
        if (null != view) {
            view.setEnabled(isEnabled);
        }
    }

    /**
     * 设置TextView值
     *
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv, String str) {
        if (null != tv && null != str) {
            tv.setText(str);
        }
    }

    /**
     * 设置TextView值
     *
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv, int str) {
        if (null != tv) {
            tv.setText(str);
        }
    }

    /**
     * 设置View背景颜色
     *
     * @param view
     * @param color
     */
    public void emptyViewBackColor(View view, int color) {
        if (null != view) {
            view.setBackgroundColor(color);
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(thisActivityName); //手动统计页面("SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this); //统计时长
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(thisActivityName); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.finishActivity(this);
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
        if (mPresenter != null)
            mPresenter.onDestroy();
        mUnbinder.unbind();
        setContentView(R.layout.empyt_view);
        Glide.get(this).clearMemory();
        System.gc();
        // 帧动画结束
        if (box != null) {
            box.stopFrameAnim();
        }
        hideSoftKeyboard();
    }

    public View initCoustomView(String type) {
        View view = null;
        if (type.equals("showNetErrorLayout")) {
            view = LayoutInflater.from(this).inflate(R.layout.loadingbox_failure, null);
        } else if (type.equals("showNoDataLayout")) {
            view = LayoutInflater.from(this).inflate(R.layout.loadingbox_no_data, null);
        } else if (type.equals("showNetOffLayout")) {
            view = LayoutInflater.from(this).inflate(R.layout.loadingbox_no_internet, null);
        }
        return view;
    }


    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public String getResources(int stringid) {
        return getResources().getString(stringid);
    }

    /**
     * 需要刷新的自己添加
     *
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
    /**
     * 作用 有输入框是 点击软键盘外 关闭软键盘
     *
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
}
