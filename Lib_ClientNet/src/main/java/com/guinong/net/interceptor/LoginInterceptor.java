package com.guinong.net.interceptor;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.guinong.net.NetworkMessage;
import com.guinong.net.listener.NetCallBackListener;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author wangyu
 * @time 2018/1/2 0002 on 下午 13:57
 * @desc
 */
public class LoginInterceptor implements Interceptor {

    private Context mContext;
    private Gson mGson = null;
    private NetCallBackListener mListener = null;
    private Handler mHandler = null;

    public LoginInterceptor(Context context) {
        this.mContext = context;
        mGson = new Gson();
        mHandler = new Handler();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        Response response = chain.proceed(request);
        try {
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String bodyString = "";
            Charset charset = Charset.forName("UTF-8");
            try {
                bodyString = buffer.clone().readString(charset);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if(bodyString != null){
                NetworkMessage msg = null;
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(bodyString);
                JsonObject jsonObject = (JsonObject) element;
                msg = mGson.fromJson(jsonObject, NetworkMessage.class);
                if (msg.getStatus().equals("NO_AUTH")) {
                    if(mListener != null){
                        mListener.onNotLogon(request);
                    }
                }
            }
            Log.e("wangyu","body---------->" + bodyString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void setNetCallBackListener(NetCallBackListener listener){
        this.mListener = listener;
    }
}
