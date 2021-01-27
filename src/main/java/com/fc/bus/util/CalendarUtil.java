package com.fc.bus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Wan CC
 * @create 2021-01-27 15:59
 * @Description:
 */
public class CalendarUtil
{
//    public static void main(String[] args) {
//        String strDate = "2021年01月01日";// 定义日期字符串
//        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");// 定义日期格式
//        Date date = null;
//        try {
//            date = format.parse(strDate);// 将字符串转换为日期
//        } catch (ParseException e) {
//            System.out.println("输入的日期格式不合理！");
//        }
//        System.out.println(strDate + "是:" + getWeek(date));
//        System.out.println(strDate + "是一年的第:" + getWeekOfYear(date) + "周");
//        System.out.println(strDate + "是一年的" + (date.getMonth() + 1) + "月有:"
//                + getDaysOfMonth(date.getYear(), date.getMonth() + 1) + "天");
//        System.out.println(strDate + "距离" + (format.format(new Date())) + "还有"
//                + getDaysBetween(date, new Date()) + "天");
//
//    }

    // 根据日期取得星期几
    public static String getWeek(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");// 定义日期格式
        Date date = null;
        try {
            date = format.parse(strDate);// 将字符串转换为日期
        } catch (ParseException e) {
            System.out.println("输入的日期格式不合理！");
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        return week;
    }

    // 取得日期是某年的第几周
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
        return week_of_year;
    }

    // 取得某个月有多少天
    public static int getDaysOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        int days_of_month = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days_of_month;
    }

    // 取得两个日期之间的相差多少天
    public static long getDaysBetween(Date date0, Date date1) {
        long daysBetween = (date0.getTime() - date1.getTime() + 1000000) / 86400000;// 86400000=3600*24*1000  用立即数，减少乘法计算的开销
        return daysBetween;
    }

}
