package com.gmself.bingobingo.util.date_tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by guomeng on 2018/6/11.
 *
 *
 * 时间工具类
 */

public class DateTools {

    public static Date getStringToDate(String dateString, DateStyles pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern.getValue());
        Date date = new Date();
        try{
            date = dateFormat.parse(dateString);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static long getSecond(String dateString, DateStyles pattern){
        Date date = getStringToDate(dateString, pattern);
        return getSecond(date);
    }

    public static long getSecond(Date date) {
        long ms = getMilliseconds(date);
        return ms/1000;
    }

    public static long getMilliseconds(Date date) {
        return date.getTime();
    }

    /**
     * 时间格式转换
     *
     * @param date
     * @return
     */
    public static String toFormatTime(Date date, DateStyles style) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat(style.getValue());               //
        return format.format(date);
    }

    public static Date getSystemCurrentDate(){
        return new Date(System.currentTimeMillis());
    }

    public static String getSystemCurrentTime(DateStyles style){
        return toFormatTime(getSystemCurrentDate(), style);
    }

    /****
     * 传入具体日期 ，以及日期格式和月份变量。
     * @param date 日期(2017-04-13)
     *  @param amount 取值为负时为减操作，为正时为加操作
     * @return
     */
    public static String subMonth(String date, DateStyles style, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(style.getValue());
        Date dt = null;
        try {
            dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH, amount);
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    /**
     * 按实际天数计算，如7月21日增加amount个月，结果为 8月20日
     * */
    public static String subMonth_inCycle(String date, DateStyles style, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(style.getValue());
        Date dt = null;
        try {
            dt = sdf.parse(date);
//            dt = date;
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH, amount);
            if (amount>0){
                rightNow.add(Calendar.DAY_OF_YEAR, -1);
            }else if (amount<0){
                rightNow.add(Calendar.DAY_OF_YEAR, 1);
            }
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    /****
     * 传入具体日期 ，以及日期格式和年份变量。
     * @param date 日期(2017-04-13)
     *  @param amount 取值为负时为减操作，为正时为加操作a
     * @return
     */
    public static String subYear(String date, DateStyles style, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(style.getValue());
        Date dt = null;
        try {
            dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.YEAR, amount);
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    /**
     * 按实际天数计算，如7月21日增加一年，结果为次年 7月20日
     * */
    public static String subYear_inCycle(String date, DateStyles style, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(style.getValue());
        Date dt = null;
        try {
            dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.YEAR, amount);
            if (amount>0){
                rightNow.add(Calendar.DAY_OF_YEAR, -1);
            }else if (amount<0){
                rightNow.add(Calendar.DAY_OF_YEAR, 1);
            }
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String subDays(String date, DateStyles style, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(style.getValue());
        Date dt = null;
        try {
            dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.DAY_OF_YEAR, amount);
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static Calendar getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getSystemCurrentDate());
        return calendar;
    }

    public static Calendar getSubYearTime(int amountYear){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getSystemCurrentDate());

        calendar.add(Calendar.YEAR, amountYear);
        return calendar;
    }

    public static Calendar getSubMonthTime(Date beginTime, int amountMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginTime);

        calendar.add(Calendar.MONTH, amountMonth);
        return calendar;
    }


}
