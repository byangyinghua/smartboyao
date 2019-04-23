package com.guinong.net;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guinong.net.callback.AsyncEmptyCallbackHandle;
import com.guinong.net.callback.AsyncResultCallbackHandle;
import com.guinong.net.callback.AsyncTypeResultCallbackHandle;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncMessageCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.callback.NetworkJsonCallback;
import com.guinong.net.print.PrintRequest;
import com.guinong.net.request.AsyncRequestState;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.utils.SharedPreferencesUtils;
import com.guinong.net.verify.VerifyManager;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author csn
 * @date 2017/7/25 0025 18:42
 * @content
 */
public abstract class RequestClient {

    public static String TOKEN_TICKET = "Access-Token";
    public static String USERID = "User";
    public static String VERSION = "Api-Version";
    //获得context 拿到cookie
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    public static Context baseContext;

    private String token;
    private String userid;
    private String version = "100";
    /**
     *
     */
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * 益农网请求
     */
    public static final MediaType APPLICATION_JSON_YWN = MediaType.parse("application/x-www-form-urlencoded");

    /**
     * @return
     */
    protected abstract OkHttpClient getHttpClient();

    /**
     * @return
     */
    protected Gson createGson() {
        return new GsonBuilder().create();
    }

    private boolean isUnitTest;

    public boolean isUnitTest() {
        return isUnitTest;
    }

    public void setUnitTest(boolean unitTest) {
        isUnitTest = unitTest;
    }

    public RequestClient() {
        this.isUnitTest = false;
    }

    private Handler mHandler = new Handler();

    /**
     * api 调用请求
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState apiRequest(final Request request, final IAsyncMessageCallback callback, final Object userState) {
        if (!NetWorkUtil.isNetworkConnected(baseContext)) {
            mHandler.postDelayed(new Runnable() { //解决无网络情况下用户点击重试无反应的不良体验
                @Override
                public void run() {
                    NetworkException exception = new NetworkException(CodeContant.CODE_NET_UNAVAILABLE, "无网络");
                    callback.onError(exception, userState);
                }
            }, 800);
            return null;
        }
        ExceptionUtils.checkNotNull(request, "request");
        ExceptionUtils.checkNotNull(callback, "callback");
        OkHttpClient client = getHttpClient();
        Call call = client.newCall(request);
        AsyncRequestState state = new AsyncRequestState(call, userState);
        call.enqueue(new NetworkJsonCallback(isUnitTest(), createGson(), callback, userState));
        return state;
    }

    private boolean checkModel(Object model, IAsyncMessageCallback callBack, Object userState) {
        try {
            VerifyManager.validate(model);

            return true;
        } catch (Exception err) {
            callBack.onError(new NetworkException(CodeContant.CODE_PARMER_ERROR, err.getMessage(), null, err), userState);
            return false;
        }
    }

    private IAsyncRequestState defaultAsyncRequestState(final Object userState) {
        return new IAsyncRequestState() {
            @Override
            public boolean cancel() {
                return false;
            }

            @Override
            public Object getUserState() {
                return userState;
            }
        };
    }


    /**
     * 2018年12月4日16:35:36 这里的参数使用的方式key-value的  不是json传参数  所以需要拼接
     *
     * @param resultClass
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return
     */
    protected <TResult> IAsyncRequestState apiPostRequestYNW(final Class<TResult> resultClass, String url,
                                                             Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        PrintRequest request = (PrintRequest) model;
        String body = "appid=" + request.getAppid() +
                "&sign=" + request.getSign() +
                "&timestamp=" + request.getTimestamp() +
                "&deviceid=" + request.getDeviceid() +
                "&devicesecret=" + request.getDevicesecret() +
                "&printdata=" + request.getPrintdata();
        return apiRequest(createPostRequestYnw(url, body), msgCallBack, userState);
    }

    private Request createPostRequestYnw(String url, String params) {
        RequestBody body = RequestBody.create(APPLICATION_JSON_YWN, params);
        return new Request.Builder().url(url).post(body).build();
    }

    private Request createPost(String url, Map<String, String> params) {
        RequestBody body = setRequestBody(params);
        return new Request.Builder().url(url).post(body).build();
    }

    private RequestBody setRequestBody(Map<String, String> BodyParams) {
        RequestBody body = null;
        okhttp3.FormBody.Builder formEncodingBuilder = new okhttp3.FormBody.Builder();
        if (BodyParams != null) {
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
                Log.d("post http", "post_Params===" + key + "====" + BodyParams.get(key));
            }
        }

        body = formEncodingBuilder.build();
        return body;

    }


    private Request createPostRequest(Object model, String url, Gson gson) {
        token = SharedPreferencesUtils.getInstance(baseContext).getToken();
        userid = SharedPreferencesUtils.getInstance(baseContext).getUserId();
        if (model != null) {
            String json = gson.toJson(model);
            RequestBody body = RequestBody.create(APPLICATION_JSON, json);
            return new Request.Builder().url(url).post(body).addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();
        } else {
            RequestBody body = RequestBody.create(APPLICATION_JSON, "{}");
            return new Request.Builder().url(url).post(body).addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();
        }
    }

    private Request createDeleteRequest(Object model, String url, Gson gson) {

        if (model != null) {
            String json = gson.toJson(model);
            RequestBody body = RequestBody.create(APPLICATION_JSON, json);
            return new Request.Builder().url(url).delete(body).build();
        } else {
            RequestBody body = RequestBody.create(APPLICATION_JSON, "{}");
            // return new Request.Builder().url(url).delete(body).addHeader(TOKEN_TICKET, token).build();
            return new Request.Builder().url(url).delete(body).addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();
        }
    }

    /**
     * 图片上传
     *
     * @param files
     * @param url
     * @return
     */
    private Request createImagesPostRequest(List<String> files, String url) {
        String token = SharedPreferencesUtils.getInstance(baseContext).getToken();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (int i = 0; i < files.size(); i++) {
            File f = new File(files.get(i));
            if (f != null) {
                builder.addFormDataPart("img", f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
            }
        }
        MultipartBody requesBody = builder.build();
        Request request = new Request.Builder().url(url).post(requesBody).addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();
        return request;
    }

    /**
     * 创建get访问请求
     *
     * @param model
     * @param url
     * @param gson
     * @return
     */
    private Request createGetRequest(Object model, String url, Gson gson) {
        token = SharedPreferencesUtils.getInstance(baseContext).getToken();
        userid = SharedPreferencesUtils.getInstance(baseContext).getUserId();
        if (model != null) {
            StringBuilder urlBuilder = new StringBuilder(url).append("?");
            Class modelclass = model.getClass();
            String temp = "&";
            Field[] fields = modelclass.getDeclaredFields();
            List<Field> data = getNoStaticFiled(fields);
            for (int i = 0; i < data.size(); i++) {
                Field f = fields[i];
                f.setAccessible(true);
                Object val;
                if (i == fields.length - 1) {
                    temp = "";
                }
                try {

                    val = f.get(model);
                    if (val != null) {
                        urlBuilder.append(f.getName()).append("=")
                                .append(val)
                                .append(temp);
                        // 得到此属性的值
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            String urls = urlBuilder.substring(0, urlBuilder.length());
            if (urls.endsWith("&")) {
                urls = urls.substring(0, urls.length() - 1);
            }
            Log.e("url", urls);
            return new Request.Builder().url(urls).get().addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();

//            return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length())).get().build();
        } else {
            return new Request.Builder().url(url).get().addHeader(TOKEN_TICKET, token).addHeader(USERID, userid).addHeader(VERSION, version).build();
        }
    }

    public List<Field> getNoStaticFiled(Field[] fields) {
        List<Field> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            if (!Modifier.isStatic(fields[i].getModifiers())) {
                list.add(fields[i]);
            }
        }
        return list;
    }

    /**
     * @param url
     * @param callback
     * @param userState
     * @return 无参无返回值post请求
     */
    protected IAsyncRequestState apiPostRequest(String url, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultClass
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回对象post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Class<TResult> resultClass, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }


    /**
     * @param resultType
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回数组post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Type resultType, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @return 有参无返回值post请求
     */
    protected IAsyncRequestState apiPostRequest(String url, Object model, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }

    protected IAsyncRequestState apiDeleteRequest(String url, Object model, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createDeleteRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回数组post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Type resultType, String url,
                                                          Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * 图片上传
     *
     * @param resultType
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return
     */
    protected <TResult> IAsyncRequestState apiImagesPostRequest(final Type resultType, String url, List<String> model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createImagesPostRequest(model, url), msgCallBack, userState);
    }


    /**
     * @param resultClass
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回对象post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Class<TResult> resultClass, String url,
                                                          Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回数组get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Type resultType, String url,
                                                         Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回对象get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Class<TResult> resultClass, String url,
                                                         Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }


    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @return 有参无返回值get请求
     */
    protected IAsyncRequestState apiGetRequest(String url, Object model, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回数组get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Type resultType, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultClass
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回对象get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Class<TResult> resultClass, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param callback
     * @param userState
     * @return 无参无返回值get请求
     */
    protected IAsyncRequestState apiGetRequest(String url, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }
}
