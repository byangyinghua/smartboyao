package com.guinong.lib_utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/27.
 * 关于密码设置的工具类
 */
public class PasswordUtil {
    public static final int PWD_MIN_LENGTH=6;
    public static final int PWD_MAX_LENGTH=16;

    private static final String PASSWORD_MATCH_REGX_LOGIN = "^[0-9A-Za-z]{6,16}$";

    //密码规则
    private static final String PASSWORD_MATCH_REGX = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z" + "!@#$%\\^&*(){}\\[\\]+-=|;:'<,>.?/]{6,16}$";

//"^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,20}$";


            //Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z" + "!@#$%\\^&*(){}\\[\\]+-=|;:'<,>.?/]{6,16}$");
    /**
     * 判断是否是符合规则的密码
     *
     **/
    public static boolean isOkPwd(String password) {

        Pattern p = Pattern.compile(PASSWORD_MATCH_REGX);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    /**
     * 判断是否是符合规则的密码
     *
     **/
    public static boolean isOkPwd_UnLogin(String password) {

        Pattern p = Pattern.compile(PASSWORD_MATCH_REGX_LOGIN);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
