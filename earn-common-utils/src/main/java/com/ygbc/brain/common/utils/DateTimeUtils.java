/**
 * Copyright (c) 2016-2017, ByteLee (bytelee@vip.sohu.net)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ygbc.brain.common.utils;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Date 处理函数
 *
 * @author ByteLee
 */

public class DateTimeUtils {

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_ONLY_DATE = "yyyyMMdd";
    public static final String FORMAT_DATE_ZN = "yyyy年MM月dd";
    public final static String FORMAT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SS";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FULL_DATE_24HR_STYLE = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd hh:mm:ss
     */
    public static final String FULL_DATE_12HR_STYLE = "yyyy-MM-dd hh:mm:ss";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_TIME_24HR_STYLE = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd hh:mm
     */
    public static final String DATE_TIME_12HR_STYLE = "yyyy-MM-dd hh:mm";
    /**
     * yyyy-MM-dd
     */
    public static final String DATE_STYLE = "yyyy-MM-dd";
    /**
     * HH:mm
     */
    public static final String TIME_24HR_STYLE = "HH:mm";
    /**
     * hh:mm
     */
    public static final String TIME_12HR_STYLE = "hh:mm";
    /**
     * Calendar
     */
    private static Calendar cal = Calendar.getInstance();

    /**
     * 如果填充ORACLE DATE类型字段，请使用该方法
     *
     * @return
     */
    public static java.sql.Timestamp getOracleDate() {
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }

    ;

    private static String formatDateToFULLHRStyle(HR hr, String spacer, Date date) {
        if (null == date) {
            return "";
        }
        if (null == spacer) {
            spacer = "-";
        }
        String hh = "HH";
        if (hr == HR.HR12) {
            hh = "hh";
        }
        return (new SimpleDateFormat("yyyy" + spacer + "MM" + spacer + "dd " + hh + ":mm:ss").format(date));
    }

    private static void setTime() {
        cal.setTime(now());
    }

    public static Date now() {
        return (new Date());
    }

    /**
     * 年
     *
     * @return
     */
    public static int year() {
        setTime();
        return cal.get(Calendar.YEAR);
    }

    /*=============================================TO int ===================*/

    /**
     * 月
     */
    public static int month() {
        setTime();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 某月的第几日
     *
     * @return
     */
    public static int dayOfMonth() {
        setTime();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 某年的第几天
     *
     * @return
     */
    public static int dayOfYear() {
        setTime();
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 某周的第几天
     * SUN	= 7 MON = 1	TUE = 2	WED = 3
     * THU = 4	FRI = 5	SAT = 6
     *
     * @return
     */
    public static int dayOfWeek() {
        setTime();
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0) {
            dayofweek = 7;
        }
        return dayofweek;
    }

    /**
     * 格式化时间
     *
     * @param style
     * @param date
     * @return
     * @see DateFormat
     */
    public static String formatDate(int style, Date date) {
        if (date == null) {
            return "";
        }
        if (style < 0) {
            style = DateFormat.DEFAULT;
        }
        return DateFormat.getDateInstance(style).format(date);
    }

    /*=============================================TO String===================*/

    /**
     * 格式化时间
     *
     * @param style
     * @return
     * @see DateFormat
     */
    public static String formatNow(int style) {
        return formatDate(style, now());
    }

    /**
     * 格式化时间为DateFormat.FULL风格的String => 2015年5月4日 星期一
     *
     * @param date
     * @return
     */
    public static String formatDateToFull(Date date) {
        return formatDate(DateFormat.FULL, date);
    }

    /**
     * 格式化当前时间为DateFormat.FULL风格的String => 2015年5月4日 星期一
     *
     * @return
     */
    public static String formatNowToFull() {
        return formatNow(DateFormat.FULL);
    }

    /**
     * 格式化时间为DateFormat.MEDIUM风格的String => 2015-5-4
     *
     * @param date
     * @return
     */
    public static String formatDateToMedium(Date date) {
        return formatDate(DateFormat.MEDIUM, date);
    }

    /**
     * 格式化当前时间为DateFormat.MEDIUM风格的String => 2015-5-4
     *
     * @return
     */
    public static String formatNowToMedium() {
        return formatNow(DateFormat.MEDIUM);
    }

    /**
     * 格式化时间为DateFormat.SHORT风格的String => 15-5-4
     *
     * @param date
     * @return
     */
    public static String formatDateToShort(Date date) {
        return formatDate(DateFormat.SHORT, date);
    }

    /**
     * 格式化当前时间为DateFormat.SHORT风格的String => 15-5-4
     *
     * @param date
     * @return
     */
    public static String formatNowToShort() {
        return formatNow(DateFormat.SHORT);
    }

    /**
     * 格式化时间
     *
     * @param style 格式风格
     * @param date
     * @return
     */
    public static String formatDateToStyle(String style, Date date) {
        if (null == date) {
            return "";
        }
        if (null == style) {
            style = FULL_DATE_24HR_STYLE;
        }
        return (new SimpleDateFormat(style).format(date));
    }

    /**
     * 格式化时间
     *
     * @param style 格式风格
     * @return
     */
    public static String formatNowToStyle(String style) {
        return formatDateToStyle(style, now());
    }

    /**
     * 格式化时间为Full24HR，使用spacer间隔。如：spacer为/，在return=> 2015/05/05 10:20:20
     *
     * @param spacer 间隔号
     * @param date
     * @return
     */
    public static String formatDateToFULL24HRStyle(String spacer, Date date) {
        return formatDateToFULLHRStyle(HR.HR24, spacer, date);
    }

    /**
     * 格式化当前时间为Full24HR，使用spacer间隔。如：spacer为/，在return=> 2015/05/05 10:20:20
     *
     * @param spacer 间隔号
     * @return
     */
    public static String formatNowToFULL24HRStyle(String spacer) {
        return formatDateToFULL24HRStyle(spacer, now());
    }

    /**
     * 格式化时间为Full12HR，使用spacer间隔。如：spacer为/，在return=> 2015/05/05 18:20:20
     *
     * @param spacer 间隔号
     * @param date
     * @return
     */
    public static String formatDateToFULL12HRStyle(String spacer, Date date) {
        return formatDateToFULLHRStyle(HR.HR12, spacer, date);
    }

    /**
     * 格式化当前时间为Full12HR，使用spacer间隔。如：spacer为/，在return=> 2015/05/05 18:20:20
     *
     * @param spacer 间隔号
     * @param date
     * @return
     */
    public static String formatNowToFULL12HRStyle(String spacer) {
        return formatDateToFULL12HRStyle(spacer, now());
    }

    /**
     * 格式化日期为时间格式
     *
     * @param hr
     * @param date
     * @return
     */
    public static String formatDateToHRStyle(HR hr, Date date) {
        if (null == date) {
            return "";
        }
        String style = TIME_24HR_STYLE;
        if (hr == HR.HR12) {
            style = TIME_12HR_STYLE;
        }
        return formatDateToStyle(style, date);
    }

    /**
     * 格式化当前日期为时间格式
     *
     * @param hr
     * @param date
     * @return
     */
    public static String formatNowToHRStyle(HR hr) {
        return formatDateToHRStyle(hr, now());
    }

    /**
     * 格式化时间戳为制定的style
     *
     * @param style
     * @param unixtime
     * @return
     */
    public static String formatUnixTime(String style, BigInteger unixtime) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        return sdf.format(unixtime);
    }

    /**
     * 格式化时间戳为制定的short 24hour style
     *
     * @param unixtime
     * @return
     */
    public static String formatUnixTimeToShort24HRStyle(BigInteger unixtime) {
        return formatUnixTime(DATE_TIME_24HR_STYLE, unixtime);
    }

    /**
     * 格式化时间戳为制定的24hour style
     *
     * @param unixtime
     * @return
     */
    public static String formatUnixTimeTo24HRStyle(BigInteger unixtime) {
        return formatUnixTime(FULL_DATE_24HR_STYLE, unixtime);
    }

    /**
     * 格式化时间戳为制定的short 12hour style
     *
     * @param unixtime
     * @return
     */
    public static String formatUnixTimeToShort12HRStyle(BigInteger unixtime) {
        return formatUnixTime(DATE_TIME_12HR_STYLE, unixtime);
    }

    /**
     * 格式化时间戳为制定的12hour style
     *
     * @param unixtime
     * @return
     */
    public static String formatUnixTimeTo12HRStyle(BigInteger unixtime) {
        return formatUnixTime(FULL_DATE_12HR_STYLE, unixtime);
    }

    /**
     * 时间转换
     *
     * @param style，     DateKit.FULL_DATE_24HR_STYLE etc
     * @param dateString
     * @return
     */
    public static Date dateStringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_DATE_24HR_STYLE);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
        }
        return date;
    }

    /*=============================================TO Date ===================*/

    /**
     * BigInteger 转Date
     *
     * @param style
     * @param unixtime
     * @return
     */
    public static Date formatUnixTimeToDate(BigInteger unixtime) {
        return dateStringToDate(formatUnixTime(FULL_DATE_24HR_STYLE, unixtime));
    }

    /**
     * 获取本月的第一天的时间戳
     *
     * @return
     */
    public static Long getMonth1stDay() {
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DATE, 1);
        return cal.getTimeInMillis();
    }

    /*=============================================TO long ===================*/

    /**
     * 获取本月的最后一天的时间戳
     *
     * @return
     */
    public static Long getMonthLastDay() {
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        return cal.getTimeInMillis();
    }

    /**
     * 获取给定时间的周一的长整形表示
     *
     * @return
     */
    public static Long getMonday() {
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.DATE, -dayOfWeek() + 1);
        return cal.getTimeInMillis();
    }

    /**
     * 获取给定时间的周日的长整形表示
     *
     * @return
     */
    public static Long getSunday() {
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.DATE, -dayOfWeek() + 7);
        return cal.getTimeInMillis();
    }

    /**
     * 获取day天之后的UnixTime
     *
     * @param day
     * @return
     */
    public static Long getUnixTimeAfterDay(int day) {
        return day * 24 * 60 * 60L + System.currentTimeMillis() / 1000;
    }

    /**
     * 获取day天之前的UnixTime
     *
     * @param day
     * @return
     */
    public static Long getUnixTimeBeforeDay(int day) {
        return System.currentTimeMillis() / 1000 - day * 24 * 60 * 60L;
    }

    /**
     * 获取当前的时间的UnixTime
     *
     * @return
     */
    public static Long getCurrentUnixTime() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 把time转为 unix time 到毫秒
     *
     * @param time
     * @return
     */
    public static BigInteger getUnixTimeMillis(BigInteger time) {
        return time.multiply(new BigInteger("1000"));
    }

    /**
     * 把time转为 unix time 到毫秒
     *
     * @param time
     * @return
     */
    public static BigInteger getUnixTimeMillis(Long time) {
        return new BigInteger(String.valueOf(time * 1000L));
    }

    /**
     * 时间转换
     *
     * @param style，     DateKit.FULL_DATE_24HR_STYLE etc
     * @param dateString
     * @return
     */
    public static Date dateStringToDate(String dateString, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
        }
        return date;
    }

    /**
     * 获取当前时间：2016-04-21 15:56:24
     *
     * @return
     */
    public static String getDateTime() {
        return formatDateToFULL24HRStyle("-", new Date());
    }

    /**
     * 获取当前日期： 默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @param style
     * @return
     */
    public static String getDateTime(String style) {
        return getDateTime(style, new Date());
    }

    /**
     * 获取指定日期
     *
     * @param style
     * @param date
     * @return
     */
    public static String getDateTime(String style, Date date) {
        return formatDateToStyle(style, date);
    }

    public static String getTomorrowDate() {
        Date date = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String formatDateTime(Date date) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    public static String formatDate(Date date, String format) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    public static String formatOnlyDate(Date date) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_ONLY_DATE);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    public static String formatDateTime(Date date, String style) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(date);
    }

    /**
     * 字符串转时间
     *
     * @param dateString
     * @param style
     * @return
     */
    public static Date string2Date(String dateString, String style) {
        if (CommonUtils.isEmpty(dateString)) return null;
        Date date = new Date();
        SimpleDateFormat strToDate = new SimpleDateFormat(style);
        try {
            date = strToDate.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 判断传入的时间是否在当前时间之后，返回boolean值
     * true: 过期
     * false: 还没过期
     *
     * @param date
     * @return
     */
    public static boolean isExpire(Date date) {
        if (date.before(new Date())) return true;
        return false;
    }

    public static Date getHourAfter(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.roll(11, hour);
        return calendar.getTime();
    }

    public static Date getHourBefore(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.roll(11, -hour);
        return calendar.getTime();
    }

    public static Date getDateBefore(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.roll(5, -day);
        return calendar.getTime();
    }

    public static Date today() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now());
        return calendar.getTime();
    }

    public static Date getDateAfter(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(5, now.get(5) + day);
        return now.getTime();
    }

    public static Date getMinuteAfter(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static Date getMinuteBefore(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -minute);
        return calendar.getTime();
    }

    public static String plusYear(String date) {
        return (Integer.parseInt(date.substring(0, 4)) + 1) + date.substring(4);
    }

    public static int getMonthSpace(String date1, String date2) {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_ONLY_DATE);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);

        int months = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        result = 12 * Math.abs(years) + Math.abs(months);

        return result;

    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void main(String[] args) {
        System.out.println(getMonthSpace("20140920", "20160328"));

        System.out.println(getWeekOfDate(new Date()));
    }

    /**
     * 时间进制
     *
     * @author 朱丛启  2015年5月4日 上午10:24:46
     */
    private enum HR {
        HR24,
        HR12,
    }
}
