package com.guinong.lib_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyu on 2016/11/16.
 */
public class DateConversionUtils {

    public static final String FORMAT_TYPE_ALL = "yyyy-MM-dd HH:mm:ss";

    public static String getDateStr(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            return sdf.format(time);
        }
        return str;
    }

    public static long stringToLong(String strTime, String formatType){
        Date date = null; // String类型转成date类型
        try {
            date = stringToDate(strTime, formatType);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0;
        } else {
            long currentTime = date.getTime(); // date类型转成long类型
            return currentTime;
        }
    }


    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public static String getDateformate(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(time);
        }
        return str;
    }

    public static String getDatefor(Double time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(time);
        }
        return str;
    }


    public static String getTimeStr(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(time);
        }
        return str;
    }
    public static String getTimeS(Double time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(time);
        }
        return str;
    }

    public static String getDate(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            return sdf.format(time);
        }
        return str;
    }

    public static long getCurrenteDate(){
        Date date = new Date();
        long dt = date.getTime();
        return dt;
    }
    public static String getIntervalStr(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(time);
        }
        return str;
    }

    public static String getMinutes(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("HH时mm分ss秒");
            return sdf.format(time);
        }
        return str;
    }


    public static String getYear(long time){
        String str = "";
        if(time>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            return sdf.format(time);
        }
        return str;
    }

    public static String getHour(){
        Date date = new Date();
        long dt = date.getTime();
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(dt);
    }

    public static String getDrawerHour(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(time);
    }

    public static String getDrawerMimuts(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return sdf.format(time);
    }

    public static String getYears(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(time);
    }

    public static String getMouths(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(time);
    }

    public static String getMinute(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time);
    }

    public static String getMinutenoty(Double time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time);
    }

    public static String getMouthNoty(Double time){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(time);
    }

    public static String ouDateTime(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time);
    }

    public static String daySend(long time){
        int day = (int)((time - System.currentTimeMillis()) / 1000 / 60 / 60 / 24);
        if(day == 0){
            return 1+"";
        }else{
            return day + "";
        }
    }
    public static String hourMinute(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("HH时:mm分");
        return sdf.format(time);
    }


    public static String dateDiff(long startTime, long endTime) {
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
        if(day > 0){
            return day +"天";
        }else{
            return hour + "时" + min +  "分";
        }
    }

    public static String getMsgTime(Date date){
        String pattern = "";
        Date nowDate = new Date();
        if (date == null) {
            date = new Date();
        }
        if (nowDate.getYear() == date.getYear()) {
            if (nowDate.getMonth() == date.getMonth() && nowDate.getDay() == date.getDay()) {
                pattern = "HH:mm";
            } else {
                pattern = "MM-dd HH:mm";
            }
        } else {
            pattern = "yyyy-MM-dd HH:mm";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String timestr = simpleDateFormat.format(date);
        if (timestr == null) {
            timestr = "";
        }
        return timestr;

    }

}
