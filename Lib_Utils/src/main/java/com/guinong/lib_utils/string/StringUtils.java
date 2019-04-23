package com.guinong.lib_utils.string;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;

import com.guinong.lib_utils.LogUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyu
 * @time 2016/9/13 14:19
 * @desc string utils
 */
public class StringUtils {
    //根据汉字获取拼音
    public static String getSellingLetter(String sourceStr) {
        CharacterParser parser = new CharacterParser();
        String pinyin = parser.getSelling(sourceStr);
        return pinyin;
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 需要处理的字符串
     * @return 处理完之后的字符串
     */
    public static String addComma(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(",###");
        return decimalFormat.format(Double.parseDouble(str));
    }

    //获取首字母
    public static String getFirstUpCaseLetter(String sourceStr) {
        if (TextUtils.isEmpty(sourceStr)) {
            return "#";
        }
        String selling = getSellingLetter(sourceStr);
        String firstLetter = selling.substring(0, 1).toUpperCase();

        if (firstLetter.matches("[A-Z]")) {
            return firstLetter;
        } else {
            firstLetter = "#";
        }
        return firstLetter;
    }

    //用正则表达式判断字符串是否为数字（含负数）
    public static boolean isNumeric(String str) {
        String regEx = "^-?[0-9]+$";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 提取出城市或者县
     *
     * @param city
     * @param district
     * @return
     */
    public static String extractLocation(final String city, final String district) {
        return district.contains("县") ? district.substring(0, district.length() - 1) : city.substring(0, city.length() - 1);
    }

    public static Spanned getHtmlColorString(String completeStr, String filterStr) {
        return Html.fromHtml(getColorString(completeStr, filterStr));
    }

    //搜索文字替换蓝色
    public static String getColorString(String completeStr, String filterStr) {
        if (completeStr == null || completeStr.isEmpty()) {
            LogUtil.error("getColorString error", "completeStr is null");
            return "";
        }
        if (filterStr == null || filterStr.isEmpty()) {
            LogUtil.error("getColorString error", "filterStr is null");
            return "";
        }
        ;
        String newTerm = getBlueString(filterStr);
        String newCompleteStr = completeStr.replaceAll(filterStr, newTerm);
        return newCompleteStr;
    }

    ;

    //通用蓝色
    public static String getBlueString(String str) {
        return "<font color='#157efb'>" + str + "</font>";
    }

    //通用红色
    public static String getRedString(String str) {
        return "<font color='#ff0000'>" + str + "</font>";
    }

    public static boolean isPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        boolean matches = phone.matches("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$");
        return matches;
    }

    /**
     * 匹配短信验证码
     *
     * @param patternContent
     * @return
     */
    public static String patternCode(String patternContent) {
        if (TextUtils.isEmpty(patternContent)) {
            return null;
        }
        Pattern p = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");
        Matcher matcher = p.matcher(patternContent);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * 使用星号代替中
     *
     * @param mobile
     * @return
     */
    public static String getLingchatPhone(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            return "";
        }

        if (mobile.length() == 11 && isPhone(mobile)) {
            return mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
        }
        return mobile;
    }


    public static boolean isContainCode(String number) {
        if (number == null) {
            return false;
        }
        boolean b = number.startsWith("+86");
        return b;
    }

    public static String getPhoneFromCountyPhoneNum(String number) {
        if (isContainCode(number)) {
            StringBuffer buffer = new StringBuffer(number);
            String result = buffer.substring(3, number.length()).trim();
            return result;
        }
        return "";
    }

    /**
     * 笨方法：String s = "你要去除的字符串";
     * 1.去除空格：s = s.replace('\\s','');
     * 2.去除回车：s = s.replace('\n','');
     * 这样也可以把空格和回车去掉，其他也可以照这样做。
     * 注：\n 回车(\u000a)
     * \t 水平制表符(\u0009)
     * \s 空格(\u0008)
     * \r 换行(\u000d)
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /***
     * replaceAll,忽略大小写
     * @param input 原始字符串
     * @param regex 要被替换的字符串
     * @param replacement 要替换成的字符串
     * @return
     */
    public static StringBuffer replaceAllByFind(String input, String regex, String replacement) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        boolean result = m.find();
        while (result) {
            m.appendReplacement(sb, replacement);
            result = m.find();
        }
        m.appendTail(sb);
        return sb;
    }

    /***
     * replaceAll,忽略大小写
     *
     * @param input 原始字符串
     * @param regex 要被替换的字符串
     * @param replacement 要替换成的字符串
     * @return
     */
    public static String replaceAllByMatcher(String input, String regex, String replacement) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        String result = m.replaceAll(replacement);
        return result;
    }

    /**
     * 保留两位小数
     *
     * @param discountPrice
     * @return
     */
    public static String getSumPrice(String discountPrice) {
        if (discountPrice.indexOf(".") != -1) {
            String strIndex[] = discountPrice.split("\\.");
            if (strIndex[0].length() > 11) {
                strIndex[0] = strIndex[0].substring(0, 11);
            }
            if (strIndex[1].length() > 2) {
                strIndex[1] = strIndex[1].substring(0, 2);
            }
            return discountPrice = strIndex[0] + "." + strIndex[1];
        }
        return discountPrice;
    }

    /**
     * 取消科学计数法
     */
    public static String numberFormat(double sum) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(sum);
    }

    public static Calendar fromDateStringToLong(String inVal) {
        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long t = date.getTime() + 5 * 1000;//这里多加五秒是 为了在本地倒计时结束时延时等待服务器处理好了
        long e = System.currentTimeMillis();
        if (t - e > 0) {
            date.setTime(date.getTime() - e);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            return cl;
        } else {
            return null;
        }
    }


    /**
     * 保留2位有效数字
     *
     * @param num
     * @return
     */
    public static String keepTwoDecimalPoint(double num) {
        return String.format("%.2f", num);
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为1,英文字符长度为0.5
     *
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static double getLength(String s) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 1;
            } else {
                // 其他字符长度为0.5
                valueLength += 0.5;
            }
        }
        //进位取整
        return Math.ceil(valueLength);
    }

    public static int getDays(String data1) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int day = 0;
        try {
            Date date2 = format.parse(data1);
            Date date = new Date(System.currentTimeMillis());
            day = differentDaysByMillisecond(date, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        if (days < 1) {
            days = 1;
        }
        return days;
    }
}
