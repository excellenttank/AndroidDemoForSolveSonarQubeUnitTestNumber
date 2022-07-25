package com.excellent.myapplication;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhangzz on 15/5/18.
 */
public class TimeUtil {

    public static String getTimeStr(long date, String formatstr) {
        SimpleDateFormat format = new SimpleDateFormat(formatstr);
        String t = format.format(new Date(date));
        if (t == null) {
            return "";
        }
        return t;
    }

    /**
     * @param startTime
     * @param endTime
     * @return -1 比较错误    0-当前时间在两个时间中间  1-当前时间还没有到开始时间， 2- 当前时间大于结束时间
     */
    public static int compareDateReturnInt(String startTime, String endTime, String currenttime, String formatstr) {
        try {
            int startLong = Integer.valueOf(startTime.replaceAll(":", ""));
            int endLong = Integer.valueOf(endTime.replaceAll(":", ""));

            SimpleDateFormat format = new SimpleDateFormat(formatstr);
            int currentTime = Integer.valueOf(currenttime.replaceAll(":", ""));
            if (startLong > currentTime) {
                return 1;
            }
            if (startLong <= currentTime && currentTime < endLong) {
                return 0;
            }
            if (currentTime >= endLong) {
                return 2;
            }
        } catch (NumberFormatException e) {

        }

        return -1;
    }

    /**
     *
     * @param startTime
     * @param endTime
     * @param timeDiff
     * @param format
     * @return
     */
//    public static boolean compareDate(String startTime, String endTime, long timeDiff, String format){
//        SimpleDateFormat sd = new SimpleDateFormat(format);
//        ParsePosition pos = new ParsePosition(0);
//        Date startDate = (Date) sd.parse(startTime, pos);
//        ParsePosition pos1 = new ParsePosition(0);
//        Date endDate = (Date) sd.parse(endTime, pos1);
//        Date currentDate = new Date();
//        if(startDate == null || endDate == null){
//            return false;
//        }
//
//        Long startLong = startDate.getTime();
//        Long endLong = endDate.getTime();
//        Long currentTime = currentDate.getTime() + timeDiff;
//        if(startLong <= currentTime && currentTime < endLong){
//            return true;
//        }
//        return false;
//
//    }

    /**
     * 重写比较日期的方法，-1 比较错误    0-当前时间在两个时间中间  1-当前时间还没有到开始时间， 2- 当前时间大于结束时间
     *
     * @param startTime
     * @param endTime
     * @param currTime
     * @param format
     * @return
     */
    public static int compareDate(String startTime, String endTime, String currTime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format, Locale.CHINA);
        ParsePosition pos = new ParsePosition(0);
        Date startDate = (Date) sd.parse(startTime, pos);
        ParsePosition pos1 = new ParsePosition(0);
        Date endDate = (Date) sd.parse(endTime, pos1);
        ParsePosition pos2 = new ParsePosition(0);
        Date currentDate = (Date) sd.parse(currTime, pos2);
        if (startDate == null || endDate == null) {
            return -1;
        }
        Long startLong = startDate.getTime();
        Long endLong = endDate.getTime();
        Long currentTime = currentDate.getTime();
        if (startLong <= currentTime && currentTime < endLong) {
            return 0;
        }
        if (startLong > currentTime) {
            return 1;
        }
        if (currentTime >= endLong) {
            return 2;
        }
        return -1;

    }

    /**
     * 计算连个日期的差值
     *
     * @param startTime
     * @param endTime
     * @param format
     * @return
     */
    public static String compareDateDifference(String startTime, String endTime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date startDate = (Date) sd.parse(startTime, pos);
        ParsePosition pos1 = new ParsePosition(0);
        Date endDate = (Date) sd.parse(endTime, pos1);
        ParsePosition pos2 = new ParsePosition(0);
        if (startDate == null || endDate == null) {
            return "";
        }
        Long startLong = startDate.getTime();
        Long endLong = endDate.getTime();
        return formatTime(startLong - endLong);
    }

    /*
     * 毫秒转化时分秒毫秒
     */
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
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }
        return sb.toString();
    }

}
