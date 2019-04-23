package com.guinong.net.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


/**
 * @author chenshuangniu
 * @time 2016/5/31 22:02
 * @内容 sharedPreference工具 可以不使用 但可以创建
 * @版本
 */
public class SharedPreferencesUtils {
    public static final String KEY = "coolbuy.spkey";
    public static final String TOKEN = "token";
    public static final String REFRESH_TOLEN = "refreshToken";
    public static final String USERID = "userid";
    public static final String STATUS = "status";
    public static final String BASE_PIC_CONFIG = "basePicPrefix";
    public static final String USER_HEAD_IMAGE = "userHead";
    public static final String USER_NAME = "userName";
    public static final String USER_PHONE = "userPhone";
    public static final String CHAT_TOKEN = "chat_token";

    public static final String APP_USER_ID = "id";

    public static final String CAR_GOODS_NUM = "shopcar_num";

    public static final String ISFIRST_ENTER = "first_login";

    public static final String LOGIN_TYPE = "loginType";

    public static final String GENDER_TYPE = "gender";   //性别   MALE 男   FEMALE  女

    private static SharedPreferencesUtils mInstance;
    private static Context mContext;
    private SharedPreferences mPerference;
    private SharedPreferences.Editor mEditor;

    private SharedPreferencesUtils(Context context) {
        this.mContext = context;
    }

    public static synchronized SharedPreferencesUtils getInstance(Context context) {//单例
        if (mInstance == null) {
            mInstance = new SharedPreferencesUtils(context);
        }
        return mInstance;
    }

    /**
     * 清理所有的数据
     */
    public void clearAllData() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(USERID, "").commit();
        sp.edit().commit();
    }

    /**
     * 保存token 这里是由于
     *
     * @param token
     */
    public void saveToken(String token) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(TOKEN, token).commit();

    }

    /**
     * 获得token
     *
     * @return
     */
    public String getToken() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(TOKEN, "");
        return s;
    }

    public void saveRefreshToken(String refreshToken) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(REFRESH_TOLEN, refreshToken).commit();
    }

    public String getRefreshToken() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(REFRESH_TOLEN, "");
        return s;
    }


    public int getShopid() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getInt("shopid", 0);
    }

    public void saveOrderid(String order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("order", order).commit();
    }

    public void saveShopLogo(String order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("logo", order).commit();
    }

    public String getShopLogo() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getString("logo", "");
    }

    public void saveShopName(String order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("shopname", order).commit();
    }

    public String getShopName() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getString("shopname", "");
    }

    public void saveAliStatus(boolean order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putBoolean("ali", order).commit();
    }

    public boolean getAliStatus() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getBoolean("ali", false);
    }

    public void saveShopImg(String order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("shopimg", order).commit();
    }

    public String getShopImg() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getString("shopimg", "");
    }

    public void saveShopid(int order) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putInt("shopid", order).commit();
    }

    public void saveOrderNum(int num) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putInt("ordernum", num).commit();
    }

    public int getOrderNum() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        int s = sp.getInt("ordernum", 0);
        return s;
    }

    public void saveUserId(String id) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(USERID, id).commit();
    }

    public String getOrderid() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString("order", "");
        return s;
    }

    public void savePhone(String id) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("phone", id).commit();
    }

    public String getPhone() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString("phone", "");
        return s;
    }

    public void saveShopStatus(String status) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(STATUS, status).commit();
    }

    /**
     * 保存打印机编号
     *
     * @param status
     */
    public void savePrintdeviceid(String status) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("deviceid", status).commit();
    }

    /**
     * 保存打印机秘钥
     *
     * @param status
     */
    public void savePrintdevicesecret(String status) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString("devicesecret", status).commit();
    }

    public String getPrintdeviceid() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString("deviceid", "");
        return s;
    }

    public String getPrintdevicesecret() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString("devicesecret", "");
        return s;
    }

    public String getShopStatus() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(STATUS, "");
        return s;
    }


    public String getUserId() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(USERID, "");
        return s;
    }

    public void saveAppId(String id) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(APP_USER_ID, id).commit();
    }

    public String getAppId() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(APP_USER_ID, "");
        return s;
    }

    public int getUserIdInt() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(USERID, "");
        int id = 0;
        try {
            if (!TextUtils.isEmpty(s)) {
                id = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void savePicConfig(String pic) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(BASE_PIC_CONFIG, pic).commit();
    }

    public String getPicConfig() {
        String s = "http://guinongtest.oss-cn-shenzhen.aliyuncs.com/";
        return s;
    }

    public void saveUserPic(String pic) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(USER_HEAD_IMAGE, pic).commit();
    }

    public String getUserPic() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(USER_HEAD_IMAGE, "");
        return s;
    }

    public void saveUserName(String name) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(USER_NAME, name).commit();
    }

    public String getUserName() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(USER_NAME, "");
        return s;
    }

    public void saveUserPhone(String phone) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(USER_PHONE, phone).commit();
    }

    public String getUserPhone() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(USER_PHONE, "");
        return s;
    }

    public void saveUserChatToken(String phone) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(CHAT_TOKEN, phone).commit();
    }

    public String getUserChatToken() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(CHAT_TOKEN, "");
        return s;
    }

    public void saveLoginType(String loginType) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(LOGIN_TYPE, loginType).commit();
    }

    public String getLoginType() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(LOGIN_TYPE, "");
        return s;
    }


    public void saveShopCarNumber(int number) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putInt(CAR_GOODS_NUM, number).commit();
    }

    public int getShopCarNumber() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        int s = sp.getInt(CAR_GOODS_NUM, 0);
        return s;
    }


    public void saveFirstEnter(boolean isEnter) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putBoolean(ISFIRST_ENTER, isEnter).commit();
    }

    public boolean getFirstEnter() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        boolean s = sp.getBoolean(ISFIRST_ENTER, true);
        return s;
    }

    public void saveGendre(String gendre) {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(GENDER_TYPE, gendre).commit();
    }

    public String getGendre() {
        @SuppressLint("WrongConstant") SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(GENDER_TYPE, "MALE");
        return s;
    }


    public boolean getLoginStatus() {
        if (!TextUtils.isEmpty(getUserId())) {
            return true;
        }
        return false;
    }
}
