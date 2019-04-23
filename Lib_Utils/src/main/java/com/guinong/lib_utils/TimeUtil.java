package com.guinong.lib_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/6.
 */
public class TimeUtil {

    public static String changeTime(String data, long currentTime) {
        if (data == null) {
            return "今天";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = null;
        try {
            dateString = formatter.format(formatter.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String currentTime1 = formatter.format(new Date(currentTime));
        long time = stringToLong(dateString, "yyyy-MM-dd");
        long time2 = stringToLong(currentTime1, "yyyy-MM-dd");

        long finalTime = time2 - time;


        return getTime(finalTime, dateString);
    }


    public static String getTime(long currentTime) {
        Date date = new Date();
        date.setTime(currentTime);
        String str = "";
        if(currentTime > 0){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(date);
        }
        return str;
    }

    private static String getTime(long time, String dateString) {
        if (time <= 1) {
            return "今天";
        } else if (time > 1 && time <= 2) {

            return "昨天";
        } else {
            return dateString;
        }
    }


    public static long stringToLong(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
            if (date == null) {
                return 0;
            } else {
                long currentTime = date.getTime();
                return currentTime;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }


    public static boolean dateDiff(long startTime, long endTime) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff = startTime - endTime;
        long day = diff / nd;// 计算差多少天
        long hour = diff % nd / nh + day * 24;// 计算差多少小时
        long min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
        long sec = diff % nd % nh % nm / ns;// 计算差多少秒
        // 获得两个时间的毫秒时间差异
        if (day >= 2) {
            return true;
        } else {
            return false;
        }
    }


    public static long dateGetDay(long startTime, long endTime) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff = startTime - endTime;
        long day = diff / nd;// 计算差多少天
        long hour = diff % nd / nh + day * 24;// 计算差多少小时
        long min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
        long sec = diff % nd % nh % nm / ns;// 计算差多少秒
        // 获得两个时间的毫秒时间差异
        return hour;
    }

    public static String getCurrentyTime(long time) {
        long diff = time;
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffHours = (diff / (60 * 60 * 1000) % 24) + diffDays * 24;
        // 获得两个时间的毫秒时间差异
        String hour = "";
        String min = "";
        String second = "";
        if(diffMinutes < 10){
            min = "0" + diffMinutes;
        }else{
            min = diffMinutes + "";
        }
        if(diffHours < 10){
            hour = "0" + diffHours;
        }else{
            hour = "" + diffHours;
        }
        if(diffSeconds < 10){
            second = "0" + diffSeconds;
        }else {
            second = "" + diffSeconds;
        }
        return hour + ": " + min + ": " + second;
    }

    public static String getMinute(long ms){
        return ((ms % (1000 * 60 * 60)) / (1000 * 60)) + "";
    }

    public static long getHour(long ms){
        long diffDays = ms / (24 * 60 * 60 * 1000);
        long time = (ms / (60 * 60 * 1000) % 24) + diffDays * 24;
        return time;
    }

    public static long getDay(long ms){
        return ms / (24 * 60 * 60 * 1000);
    }
}
