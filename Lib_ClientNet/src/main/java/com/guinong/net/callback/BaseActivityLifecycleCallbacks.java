package com.guinong.net.callback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import com.guinong.net.request.IAsyncRequestState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Activity声明周期回调
 *
 * @author zhousf
 */
public class BaseActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "ActivityLifecycle";

    /**
     * 是否显示ActivityLifecycle日志
     */
    private static boolean showLifecycleLog;

    /**
     * 请求集合: key=Activity value=Call集合
     */
    private static Map<String, SparseArray<IAsyncRequestState>> callsMap = new ConcurrentHashMap<>();

    /**
     * 保存请求集合
     *
     * @param tag  请求标识
     * @param call 请求
     */
    public static void putCall(String tag, IAsyncRequestState call) {
        if (call == null) {
            return;
        }
        if (!TextUtils.isEmpty(tag)) {
            SparseArray<IAsyncRequestState> callList = callsMap.get(tag);
            if (null == callList) {
                callList = new SparseArray<>();
            }
            callList.put(call.hashCode(), call);
            callsMap.put(tag, callList);
            showLog(false, tag);
        }
    }

    /**
     * 取消请求
     *
     * @param tag 请求标识
     */
    public static void cancelCallByActivityDestroy(String tag) {
        if (null == tag)
            return;
        SparseArray<IAsyncRequestState> callList = callsMap.get(tag);
        if (null != callList) {
            final int len = callList.size();
            for (int i = 0; i < len; i++) {
                IAsyncRequestState call = callList.valueAt(i);
                if (null != call)
                    call.cancel();
            }
            callList.clear();
            callsMap.remove(tag);
            showLog(true, tag);
        }
    }

    /**
     * 判断当前Activity是否已经销毁
     *
     * @param activity 请求标识
     * @return true 已经销毁  false 未销毁
     */
    public static boolean isActivityDestroyed(Activity activity) {
        String tag = activity.getClass().getName();
        return callsMap.get(tag) == null;
    }

    /**
     * 判断当前tat是否已经销毁
     *
     * @param tag 请求标识
     * @return true 已经销毁  false 未销毁
     */
    public static boolean isActivityDestroyed(String tag) {
        return !TextUtils.isEmpty(tag) && callsMap.get(tag) == null;
    }

    /**
     * 取消请求
     *
     * @param tag 请求标识
     */
    public static void cancel(String tag) {
        cancel(tag, null);
    }

    /**
     * 取消请求
     *
     * @param tag          请求标识
     * @param originalCall call
     */
    public static void cancel(String tag, IAsyncRequestState originalCall) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        if (null != originalCall) {
            SparseArray<IAsyncRequestState> callList = callsMap.get(tag);
            if (null != callList) {
                IAsyncRequestState c = callList.get(originalCall.hashCode());
                if (null != c)
                    c.cancel();
                callList.delete(originalCall.hashCode());
                if (callList.size() == 0)
                    callsMap.remove(tag);
                showLog(true, tag);
            }
        } else {
            SparseArray<IAsyncRequestState> callList = callsMap.get(tag);
            if (null != callList) {
                for (int i = 0; i < callList.size(); i++) {
                    IAsyncRequestState call = callList.valueAt(i);
                    if (null != call) {
                        call.cancel();
                        callList.delete(call.hashCode());
                    }
                    if (callList.size() == 0)
                        callsMap.remove(tag);
                    showLog(true, tag);
                }
            }
        }
    }

    private static void showLog(boolean isCancel, String tag) {
        if (!showLifecycleLog) {
            return;
        }
        String callDetail = isCancel ? "取消请求" : "增加请求";
        Log.d(TAG, callDetail + ": " + tag);
    }

    public static void setShowLifecycleLog(boolean showLifecycle) {
        showLifecycleLog = showLifecycle;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.e("onActivityCreated", activity.getLocalClassName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e("onActivityStarted", activity.getLocalClassName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.e("onActivityResumed", activity.getLocalClassName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e("onActivityPaused", activity.getLocalClassName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e("onActivityStopped", activity.getLocalClassName());
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.e("onActivitySaveInstanceState", activity.getLocalClassName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        cancelCallByActivityDestroy(activity.getClass().getName());
    }
}
