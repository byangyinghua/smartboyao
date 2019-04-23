package com.guinong.lib_base.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.guinong.lib_base.R;
import com.guinong.lib_base.views.loading.DiamondLoadingView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * 无网络、无数据、加载中、网络错误等页面显示
 *
 * @author ymb
 *         Create at 2017/7/21 9:54
 */
public class LoadingBox {

    private View mTargetView;
    private View.OnClickListener mClickListener, mCustomClickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private RelativeLayout mContainer0, mContainer;
    private ArrayList<View> mCustomViews;
    private ArrayList<View> mDefaultViews;
    private ViewSwitcher mSwitcher;

    View mLayoutTransLoadingContent; // 用来处理当前页面加载中上层遮罩

    // Default Tags
    private final String TAG_INTERNET_OFF = "INTERNET_OFF";
    private final String TAG_LOADING_CONTENT = "LOADING_CONTENT";
    private final String TAG_TRANS_LOADING_CONTENT = "TRANS_LOADING_CONTENT";
    private final String TAG_OTHER_EXCEPTION = "OTHER_EXCEPTION";
    private final String TAG_NO_DATA = "NO_DATA";

    private final String[] mSupportedAbsListViews = new String[]{"listview", "gridview", "expandablelistview"};
    private final String[] mSupportedViews = new String[]{"linearlayout", "relativelayout", "framelayout", "scrollview", "recyclerview", "viewgroup"};

    public LoadingBox(Activity context, View targetView) {
        this.mContext = context;
        this.mInflater = ((Activity) mContext).getLayoutInflater();
        this.mTargetView = targetView;
        this.mContainer0 = new RelativeLayout(mContext);
        this.mContainer = new RelativeLayout(mContext);
        this.mCustomViews = new ArrayList<View>();
        this.mDefaultViews = new ArrayList<View>();

        Class viewClass = mTargetView.getClass();
        Class superViewClass = viewClass.getSuperclass();
        String viewType = viewClass.getName().substring(viewClass.getName().lastIndexOf('.') + 1).toLowerCase(Locale.getDefault());
        String superViewType = superViewClass.getName().substring(superViewClass.getName().lastIndexOf('.') + 1).toLowerCase(Locale.getDefault());

        if (Arrays.asList(mSupportedAbsListViews).contains(viewType) || Arrays.asList(mSupportedAbsListViews).contains(superViewType))
            initializeAbsListView();
        else if (Arrays.asList(mSupportedViews).contains(viewType) || Arrays.asList(mSupportedViews).contains(superViewType))
            initializeViewContainer();
        else
            throw new IllegalArgumentException("TargetView type [" + superViewType + "] is not supported !");

    }

    public LoadingBox(Activity context, int viewID) {
        this.mContext = context;
        this.mInflater = ((Activity) mContext).getLayoutInflater();
        this.mTargetView = mInflater.inflate(viewID, null, false);
        this.mContainer0 = new RelativeLayout(mContext);
        this.mContainer = new RelativeLayout(mContext);
        this.mCustomViews = new ArrayList<View>();
        this.mDefaultViews = new ArrayList<View>();

        Class viewClass = mTargetView.getClass();
        Class superViewClass = viewClass.getSuperclass();
        String viewType = viewClass.getName().substring(viewClass.getName().lastIndexOf('.') + 1).toLowerCase(Locale.getDefault());
        String superViewType = superViewClass.getName().substring(superViewClass.getName().lastIndexOf('.') + 1).toLowerCase(Locale.getDefault());

        if (Arrays.asList(mSupportedAbsListViews).contains(viewType) || Arrays.asList(mSupportedAbsListViews).contains(superViewType))
            initializeAbsListView();
        else if (Arrays.asList(mSupportedViews).contains(viewType) || Arrays.asList(mSupportedViews).contains(superViewType))
            initializeViewContainer();
        else
            throw new IllegalArgumentException("TargetView type [" + superViewType + "] is not supported !");

    }

    private void initializeViewContainer() {

        setDefaultViews();

        mSwitcher = new ViewSwitcher(mContext);
        ViewSwitcher.LayoutParams params = new ViewSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mSwitcher.setLayoutParams(params);

        ViewGroup group = (ViewGroup) mTargetView.getParent();
        int index = 0;
        Clonner target = new Clonner(mTargetView);
        if (group != null) {
            index = group.indexOfChild(mTargetView);
            group.removeView(mTargetView);
        }

        mContainer0.addView(target.getmView());
        mContainer0.addView(mLayoutTransLoadingContent);

        mSwitcher.addView(mContainer, 0);
        mSwitcher.addView(mContainer0, 1);
        mSwitcher.setDisplayedChild(1);

        if (group != null) {
            group.addView(mSwitcher, index);
        } else {
            ((Activity) mContext).setContentView(mSwitcher);
        }

    }

    private void setDefaultViews() {
        mLayoutTransLoadingContent = initView(R.layout.loadingbox_trans_loading, TAG_TRANS_LOADING_CONTENT);
        mLayoutTransLoadingContent.setVisibility(View.GONE);
        mLayoutTransLoadingContent.setOnClickListener(null);
        View mLayoutInternetOff = initView(R.layout.loadingbox_no_internet, TAG_INTERNET_OFF);
        View mLayoutLoadingContent = initView(R.layout.loadingbox_loading, TAG_LOADING_CONTENT);
        View mLayoutOther = initView(R.layout.loadingbox_failure, TAG_OTHER_EXCEPTION);
        View mLayoutNoData = initView(R.layout.loadingbox_no_data, TAG_NO_DATA);

        mDefaultViews.add(0, mLayoutInternetOff);
        mDefaultViews.add(1, mLayoutLoadingContent);
        mDefaultViews.add(2, mLayoutOther);
        mDefaultViews.add(3, mLayoutNoData);

        // Hide all layouts at first initialization
        mLayoutInternetOff.setVisibility(View.GONE);
        mLayoutLoadingContent.setVisibility(View.GONE);
        mLayoutOther.setVisibility(View.GONE);
        mLayoutNoData.setVisibility(View.GONE);

        // init Layout params
        RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        containerParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        containerParams.addRule(RelativeLayout.CENTER_VERTICAL);

        // init new RelativeLayout Wrapper
        mContainer0.setLayoutParams(containerParams);
        mContainer.setLayoutParams(containerParams);

        // Add default views
        mContainer.addView(mLayoutLoadingContent);
        mContainer.addView(mLayoutInternetOff);
        mContainer.addView(mLayoutOther);
        mContainer.addView(mLayoutNoData);
    }

    private void initializeAbsListView() {

        setDefaultViews();

        AbsListView abslistview = (AbsListView) mTargetView;
        abslistview.setVisibility(View.GONE);
        ViewGroup parent = (ViewGroup) abslistview.getParent();
        if (mContainer != null) {
            parent.addView(mLayoutTransLoadingContent);

            parent.addView(mContainer);
            abslistview.setEmptyView(mContainer);
        } else
            throw new IllegalArgumentException("mContainer is null !");

    }

    public void showLoadingLayout() {
        show(TAG_LOADING_CONTENT);
    }

    public void showInternetOffLayout() {
        show(TAG_INTERNET_OFF);
    }

    public void showExceptionLayout() {
        show(TAG_OTHER_EXCEPTION);
    }

    public void showNoDataLayout() {
        show(TAG_NO_DATA);
    }

    public void showCustomView(String tag) {
        show(tag);
    }

    public void showTransLoadingLayout() {
        hideAll();
        mLayoutTransLoadingContent.setVisibility(View.VISIBLE);
        // 帧动画开始
        if (mLayoutTransLoadingContent.findViewById(R.id.loadingview) != null)
            ((DiamondLoadingView) mLayoutTransLoadingContent.findViewById(R.id.loadingview)).start();
    }

    public void hideAll() {
        ArrayList<View> views = new ArrayList<View>(mDefaultViews);
        views.addAll(mCustomViews);
        views.add(mLayoutTransLoadingContent);
        for (View view : views) {
            view.setVisibility(View.GONE);
            // 帧动画结束
            if (view.findViewById(R.id.loadingview) != null)
                ((DiamondLoadingView) view.findViewById(R.id.loadingview)).stop();
        }
        if (mSwitcher != null) {
            mSwitcher.setDisplayedChild(1);
        }
//        mLayoutTransLoadingContent.setVisibility(View.GONE);
    }

    private void show(String tag) {
        ArrayList<View> views = new ArrayList<View>(mDefaultViews);
        views.addAll(mCustomViews);
        views.add(mLayoutTransLoadingContent);
        for (View view : views) {
            if (view.getTag() != null && view.getTag().toString().equals(tag)) {
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }

            // 帧动画结束
            if (view.findViewById(R.id.loadingview) != null)
                ((DiamondLoadingView) view.findViewById(R.id.loadingview)).stop();
        }

        for (View view : views) {
            // 帧动画开始
            if (view.findViewById(R.id.loadingview) != null) {
                if (view.getVisibility() == View.VISIBLE && view.getTag() != null && (view.getTag().toString().equals(TAG_LOADING_CONTENT) || view.getTag().toString().equals(TAG_TRANS_LOADING_CONTENT)))
                    ((DiamondLoadingView) view.findViewById(R.id.loadingview)).start();
            }
        }

        if (mSwitcher != null && mSwitcher.getDisplayedChild() != 0) {
            mSwitcher.setDisplayedChild(0);
        }
    }

    /**
     * Return a view based on layout id
     *
     * @param layout Layout Id
     * @param tag    Layout Tag
     * @return View
     */
    private View initView(int layout, String tag) {
        View view = mInflater.inflate(layout, null, false);

        view.setTag(tag);
        view.setVisibility(View.GONE);

        View buttonView = view.findViewById(R.id.exception_button);
        if (buttonView != null)
            buttonView.setOnClickListener(this.mClickListener);

        return view;
    }

    /**
     * @see <a href="http://developer.android.com/design/building-blocks/progress.html#activity">Android Design Guidelines for Activity Circles</a>
     * @deprecated This method has been deprecated because it does not adhere to the Android design guidelines. Activity circle's should not display any text.
     */

    /**
     * 设置无数据信息
     * @param message
     */
    public void setNoDataMessage(String message) {
        ((TextView) mDefaultViews.get(3).findViewById(R.id.exception_message)).setText(message);
    }

    /**
     * 设置无网络信息
     * @param message
     */
    public void setInternetOffMessage(String message) {
        ((TextView) mDefaultViews.get(0).findViewById(R.id.exception_message)).setText(message);
    }

    /**
     * 设置网络错误信息
     * @param message
     */
    public void setExceptionMessage(String message) {
        ((TextView) mDefaultViews.get(2).findViewById(R.id.exception_message)).setText(message);
    }

    public void setClickListener(View.OnClickListener clickListener) {

        this.mClickListener = clickListener;

        for (View view : mDefaultViews) {
            View buttonView = view.findViewById(R.id.exception_button);
            if (buttonView != null)
                buttonView.setOnClickListener(this.mClickListener);
        }


    }

    public void setCustomClickListener(View.OnClickListener clickListener) {

        this.mCustomClickListener = clickListener;

        for (View view : mCustomViews) {
            View buttonView = view.findViewById(R.id.custom_exception_button);
            if (buttonView != null)
                buttonView.setOnClickListener(this.mCustomClickListener);
        }
    }

    public void addCustomView(View customView, String tag) {

        // 判断tag是否存在，R.layout.id为tag，判断是否已经存在
        for (int i = 0; i < mCustomViews.size(); i++) {
            if (mCustomViews.get(i).getTag().equals(tag))
                return;
        }
        customView.setTag(tag);
        customView.setVisibility(View.GONE);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(params);
        mCustomViews.add(customView);
        mContainer.addView(customView);

        View buttonView = customView.findViewById(R.id.custom_exception_button);
        if (buttonView != null)
            buttonView.setOnClickListener(this.mCustomClickListener);
    }

    /**
     * 停止帧动画
     */
    public void stopFrameAnim() {
        ArrayList<View> views = new ArrayList<View>(mDefaultViews);
        views.addAll(mCustomViews);
        views.add(mLayoutTransLoadingContent);
        for (View view : views) {
            // 帧动画结束
            if (view.findViewById(R.id.loadingview) != null)
                ((DiamondLoadingView) view.findViewById(R.id.loadingview)).stop();
        }
    }

    private class Clonner {
        private View mView;

        public Clonner(View view) {
            this.setmView(view);
        }

        public View getmView() {
            return mView;
        }

        public void setmView(View mView) {
            this.mView = mView;
        }
    }
}