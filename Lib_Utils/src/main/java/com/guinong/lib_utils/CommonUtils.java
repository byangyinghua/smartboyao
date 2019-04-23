package com.guinong.lib_utils;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.text.Selection;
import android.text.Spannable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RatingBar;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaoyu on 2016/3/9.
 * 工具类
 */
public class CommonUtils {
    public static List<View> loadmap = new ArrayList<>();
    // email匹配
    private static final String EMAIL_MATCH_REGX = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    //11位手机号
    private static final String MOBILE_MATCH_REGX = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}";// "[1]"代表第1位为数字1，"\\d{10}"代表后面是可以是0～9的数字，有10位。
    //车牌号
    private static final String LICENSENUM_MATCH_REGX = "[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";
    //18位身份证
    private static final String IDENTITY_MATCH_REGX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";

    /**
     * 判断是否是合法身份证
     **/
    public static boolean isID(String identity) {
        Pattern p = Pattern.compile(IDENTITY_MATCH_REGX);
        Matcher m = p.matcher(identity);
        return m.matches();
    }

    /***
     * 得到屏幕分辨率高
     */
    @SuppressWarnings("deprecation")
    public static int getDisplayHeight(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getHeight();

    }

    /***
     * 得到屏幕分辨率宽
     */
    @SuppressWarnings("deprecation")
    public static int getDisplayWidth(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * 判断是否是邮箱
     **/
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile(EMAIL_MATCH_REGX);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断是否是
     *
     * @param context
     * @return
     */
    public static boolean checkNetworkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isAvailable() || mobile.isAvailable())  //getState()方法是查询是否连接了数据网络
            return true;
        else
            return false;
    }

    /**
     * 判断上午(0)还是下午(1)
     *
     * @return
     */
    public static int checkAmorPm() {
        long time = System.currentTimeMillis();
        final Calendar mca = Calendar.getInstance();
        mca.setTimeInMillis(time);
        return mca.get(Calendar.AM_PM);
    }

    /**
     * 验证手机号码 1开头就行
     */
    public static boolean isMobileNO(String mobiles) {
        return mobiles.matches(MOBILE_MATCH_REGX);
    }

    /**
     * 判断String是否为空
     **/
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || string.equals("null") || string.equals("");
    }

    /**
     * 密码有效性检查
     **/
    public static boolean pwdCheck(String string,String type) {
        if (isEmpty(string)) {
            return false;
        }
        if (string.length() < 6) {
            return false;
        }
        switch (type){
            case "LOGIN":
                if (!PasswordUtil.isOkPwd_UnLogin(string)) {
                    return false;
                }
                break;
            case "UNLOGIN":
                if (!PasswordUtil.isOkPwd(string)) {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * 密码有效性检查
     **/
    public static String pwdCheckTwo(Context context, String string) {
        if (isEmpty(string)) {
            return context.getString(R.string.toast_set_pwd);
        }
        if (string.length() < 6) {
            return context.getString(R.string.toast_set_right_pwd);
        }
        return "密码无效";
    }

    /**
     * String null处理
     **/
    public static String stringNotNull(String string) {
        return (string == null || string.equals("null") ? "" : string);
    }

    /**
     * 获取设备唯一编码
     **/
    public static String getImieStatus(Context _context) {
        TelephonyManager tm = (TelephonyManager) _context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String deviceId = tm.getDeviceId();
        LogUtil.error("commonUtils", "deviceId ->" + deviceId);
        return deviceId;
    }

    /**
     * 去掉.00
     **/
    public static String getFloatWithoutZero(float price) {
        String priceStr = String.valueOf(price);
        if (priceStr.endsWith(".0")) {
            priceStr = priceStr.substring(0, priceStr.length() - 2);
        }
        return priceStr;
    }

    /**
     * 防止Button快速连点
     **/

    private static long lastClickTime;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    /**
     * 得到渠道名
     **/
    public static String getUmengChannelName(Context context) {
        String key = "UMENG_CHANNEL";
        String channelName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
//注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
//                        <span style = "white-space:pre" ></span >//key换成说需要的key
                        channelName = applicationInfo.metaData.getString(key);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        LogUtil.error("CommonUtils", channelName + "");
        return channelName;
    }

    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static String getTime() {
        SimpleDateFormat sf;
        long time = System.currentTimeMillis();
        Date data = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(data);
    }

    /**
     * 将光标移动到字符串末尾
     */
    public static void moveToLast(EditText editText) {
        CharSequence charSequence = editText.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    /**
     * 动态设置Ratingbar高度，解决图片在不同分辨率手机拉伸问题
     *
     * @param context
     * @param ratingBar
     * @param resourceId 本地图片资源Id
     */
    public static void setRatingBarHeight(Context context, RatingBar ratingBar, int resourceId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        int height = bitmap.getHeight();
        ViewGroup.LayoutParams params = ratingBar.getLayoutParams();
        params.height = height;
        ratingBar.setLayoutParams(params);
    }

   /* public static FrameLayout.LayoutParams getHW60(LoadingLayout layout) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width = CoolBuyApplication.context.getResources().getDimensionPixelOffset(R.dimen.divider_px80);
        layoutParams.height = CoolBuyApplication.context.getResources().getDimensionPixelOffset(R.dimen.divider_px80);
        layout.setDefineBackgroundColor(R.color.hint_color);
        return layoutParams;
    }*/

    public static void addLoadClick(String tag, View loadclick) {
        if (loadclick != null)
            loadmap.add(loadclick);
    }

    /**
     * 设置可以点击
     */
    /*public static void setLoadCliced(Boolean cliced) {
        boolean isClick = SharedPreferencesUtils.getInstance().getErrorOnClick();
        for (int i = 0; i < loadmap.size(); i++) {
            if (isClick) {
                loadmap.get(i).setClickable(false);
            } else {
                loadmap.get(i).setClickable(cliced);
            }
        }
    }*/

    /*public static FrameLayout.LayoutParams getHWM(LoadingLayout layout) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = FrameLayout.LayoutParams.MATCH_PARENT;
        layout.setDefineBackgroundColor(R.color.white);
        return layoutParams;
    }*/
    public static String getSystemTiem() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日- HH:mm:ss:SSS");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 判断微信是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断微博是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeiboAvailable(@NonNull Context context) {
        PackageManager pm;
        if ((pm = context.getApplicationContext().getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("com.sina.weibo".equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String getImageNetSize(int size) {
        return "";
        /*switch (size){
            case 50:
                return "?x-oss-process=style/50w";
            case 100:
                return "?x-oss-process=style/100w";
            case 150:
                return "?x-oss-process=style/150w";
            case 220:
                return "?x-oss-process=style/220w";
            case 250:
                return "?x-oss-process=style/250w";
            case 320:
                return "?x-oss-process=style/320w";
            case 350:
                return "?x-oss-process=style/350w";
            case 400:
                return "?x-oss-process=style/400w";
            case 500:
                return "?x-oss-process=style/500w";
            case 414:
                return "?x-oss-process=style/410w";
            case 621:
                return "?x-oss-process=style/621w";
            case 800:
                return "?x-oss-process=style/800w";
            default:
                return "";
        }*/
    }

    public static String getRectangleImageNetSize() {
        return "?x-oss-process=style/1x1_600";
    }

    /**
     * 复制内容到剪贴板
     *
     * @param text
     */
    public static void copyToClipBoard(Context context, String text) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clipData = ClipData.newPlainText("copy", text);
        cm.setPrimaryClip(clipData);
    }

    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            //   sb.append(second+"秒");
        }
        if (milliSecond > 0) {
            //    sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }

    public static String formatTimeMin(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            //    sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }


    public static String formatTime1(Long ms) {
        if (ms > 0) {
            Integer ss = 1000;
            Integer mi = ss * 60;
            Integer hh = mi * 60;
            Integer dd = hh * 24;

            Long day = ms / dd;
            Long hour = (ms - day * dd) / hh;
            Long minute = (ms - day * dd - hour * hh) / mi;
            Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
            Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

            StringBuffer sb = new StringBuffer();

            if (hour > 0) {
                if (day <= 0 && hour < 10) {
                    sb.append("0" + hour + ":");
                } else {
                    sb.append(hour + (day * 24) + ":");
                }
            } else {
                sb.append("00" + ":");
            }
            if (minute > 0) {
                if (minute < 10) {
                    sb.append("0" + minute + ":");
                } else {
                    sb.append(minute + ":");
                }
            } else {
                sb.append("00" + ":");
            }
            if (second > 0) {
                if (second < 10) {
                    sb.append("0" + second + "");
                } else {
                    sb.append(second + "");
                }
            } else {
                sb.append("00");
            }

            return sb.toString();
        }
        return "00:00:00";
    }

    /**
     * 三位数需要加逗号
     *
     * @param data
     * @return
     */
    public static String formatTosepara(int data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }
}
