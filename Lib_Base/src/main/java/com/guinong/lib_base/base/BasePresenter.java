package com.guinong.lib_base.base;

import android.content.Context;

/**
 * 基类Presenter
 * @author ymb
 * Create at 2017/7/13 11:23
 */
public abstract class BasePresenter<V, M>{
    public Context mContext;
    public M mModel;
    public V mView;
    public String mTag;

    public BasePresenter(String mTag, Context mContext, M mModel, V mView) {
        this.mContext = mContext;
        this.mTag = mTag;
        setVM(mView, mModel);
    }

    public void setVM(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    public void onDestroy() {

    }
}
