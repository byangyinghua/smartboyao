package com.guinong.lib_base.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.guinong.lib_base.R;
import com.guinong.lib_base.views.LoadingBox;
import com.guinong.net.callback.BaseActivityLifecycleCallbacks;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.utils.SharedPreferencesUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.umeng.analytics.MobclickAgent;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Fragment抽象类
 *
 * @author ymb
 * Create at 2017/7/13 14:00
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment implements OnRefreshLoadMoreListener {
    public P mPresenter;
    public M mModel;
    protected Activity mContext;
    public View rootView;
    private LoadingBox box;
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
    protected AppCompatActivity mAdvantageActivity;
    private ImmersionBar mImmersionBar;
    private Unbinder mUnbinder;
    protected String thisFragmentName = "BaseFragment";
    protected DecimalFormat mFormat;
    protected VirtualLayoutManager layoutManager;
    protected DelegateAdapter delegateAdapter;
    protected List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
    protected SmartRefreshLayout mRefresh;
    protected String mUserId;
    protected int mIntUserId;
    protected int mShopid;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAdvantageActivity = (AppCompatActivity) this.getActivity();
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }

        mContext = this.getActivity();
        if (rootView.findViewById(R.id.box) != null) {
            box = new LoadingBox(mContext, rootView.findViewById(R.id.box));
            box.setClickListener(mReloadListener);
            box.setCustomClickListener(mCustomListener);
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        mFormat = new DecimalFormat("0.00");
        mUserId = SharedPreferencesUtils.getInstance(mContext).getUserId();
        mShopid = SharedPreferencesUtils.getInstance(mContext).getShopid();
        if (!TextUtils.isEmpty(mUserId))
            mIntUserId = Integer.valueOf(mUserId);
        initImmersionBar();
        initModel();
        initView();
        initListener();
        initPresenter();

        return rootView;
    }

    /**
     * 初始化Refresh
     */
    public void initRefresh() {
        if (rootView.findViewById(R.id.refreshLayout) != null) {
            mRefresh = rootView.findViewById(R.id.refreshLayout);
            mRefresh.setEnableAutoLoadMore(false);
            mRefresh.setEnableScrollContentWhenLoaded(true);
            mRefresh.setEnableLoadMoreWhenContentNotFull(true);
            mRefresh.setEnableFooterFollowWhenLoadFinished(true);
            mRefresh.setOnRefreshLoadMoreListener(this);
        }
    }

    public void initAdapter(RecyclerView mRecyler) {
        if (null != mRecyler) {
            final VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
            mRecyler.setLayoutManager(layoutManager);
            final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
            mRecyler.setRecycledViewPool(viewPool);
            viewPool.setMaxRecycledViews(0, 10);
            delegateAdapter = new DelegateAdapter(layoutManager, false);
            mRecyler.setAdapter(delegateAdapter);
            mRecyler.setHasFixedSize(true);
        }
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        /*mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(true).init();*/
    }

    /**
     * 用于统计页面组件
     */
    protected void setThisFragmentName() {

    }

    /**
     * 获取布局文件
     */
    protected abstract int getLayoutId();

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
    protected abstract void initView();

    /**
     * 添加网络请求到请求列表
     *
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        if (getActivity() != null && getActivity().getClass() != null && state != null) {
            BaseActivityLifecycleCallbacks.putCall(getActivity().getClass().getName(), state);
        }
    }

    /**
     * 未读消息
     **/
    public void readMessageSuccess() {
    }

    /**
     * 初始化监听器
     */
    public void initListener() {
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
        if (box != null)
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
        View customView = getActivity().getLayoutInflater().inflate(layoutId, null, false);
        box.addCustomView(customView, layoutId + "");
        box.showCustomView(layoutId + "");
    }

    /**
     * 停止加载框
     */
    public void stopAll() {
        if (box != null)
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && mImmersionBar != null)
            mImmersionBar.init();
    }

    /**************************************************************
     *  自定义的回调方法，子类可根据需求重写
     *************************************************************/

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作，因为配合fragment的view复用机制，你不用担心在对控件操作中会报 null 异常
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {

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
        MobclickAgent.onPageStart(thisFragmentName); //统计页面("MainScreen"为页面名称，可自定义)
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(thisFragmentName);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();

        // 帧动画结束
        if (box != null) {
            box.stopFrameAnim();
        }
    }

    /**
     * 隐藏软键盘
     *
     * @param
     */
    public void hideSoftKeyboard() {
        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void stopRefresh() {
        if (mRefresh != null) {
            mRefresh.finishRefresh();
            mRefresh.finishLoadMore();
        }
    }

    /**
     * 使用include的方式加载错误页面  一般出现在activity中嵌套fragment中  因为后台原因出现请求多次接口问题
     *
     * @param type
     * @return
     */
    public View initCoustomView(String type) {
        View view = null;
        if (type.equals("showNetErrorLayout")) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.loadingbox_failure, null);
        } else if (type.equals("showNoDataLayout")) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.loadingbox_no_data, null);
        } else if (type.equals("showNetOffLayout")) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.loadingbox_no_internet, null);
        }
        return view;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
}
