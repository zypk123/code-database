package com.zhang.utils.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期工具类
 *
 * @author zhagnyu
 */
public class DateUtil {

    /**
     * 仅显示年月日，例如 2015-08-11.
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 显示年月日时分秒，例如 2015-08-11 09:51:53.
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 仅显示时分秒，例如 09:51:53.
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 每天的毫秒数 8640000.
     */
    public static final long MILLISECONDS_PER_DAY = 86400000L;

    /**
     * 每周的天数.
     */
    public static final long DAYS_PER_WEEK = 7L;

    /**
     * 每小时毫秒数.
     */
    public static final long MILLISECONDS_PER_HOUR = 3600000L;

    /**
     * 每分钟秒数.
     */
    public static final long SECONDS_PER_MINUTE = 60L;

    /**
     * 每小时秒数.
     */
    public static final long SECONDS_PER_HOUR = 3600L;

    /**
     * 每天秒数.
     */
    public static final long SECONDS_PER_DAY = 86400L;

    /**
     * 每个月秒数，默认每月30天.
     */
    public static final long SECONDS_PER_MONTH = 2592000L;

    /**
     * 每年秒数，默认每年365天.
     */
    public static final long SECONDS_PER_YEAR = 31536000L;

    /**
     * 常用的时间格式.
     */
    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS Z",
            "yyyy/MM/dd HH:mm"};

    /**
     * 得到当前日期字符串.
     *
     * @return String 日期字符串，例如2015-08-11
     * @since 1.0
     */
    public static String getDate() {
        return getDate(DateUtil.DATE_FORMAT);
    }

    /**
     * 得到当前时间字符串.
     *
     * @return String 时间字符串，例如 09:51:53
     * @since 1.0
     */
    public static String getTime() {
        return formatDate(new Date(), DateUtil.TIME_FORMAT);
    }

    /**
     * 得到当前日期和时间字符串.
     *
     * @return String 日期和时间字符串，例如 2015-08-11 09:51:53
     * @since 1.0
     */
    public static String getDateTime() {
        return formatDate(new Date(), DateUtil.DATETIME_FORMAT);
    }

    /**
     * 获取当前时间指定格式下的字符串.
     *
     * @param pattern 转化后时间展示的格式，例如"yyyy-MM-dd"，"yyyy-MM-dd HH:mm:ss"等
     * @return String 格式转换之后的时间字符串.
     * @since 1.0
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 获取指定日期的字符串格式.
     *
     * @param date    需要格式化的时间，不能为空
     * @param pattern 时间格式，例如"yyyy-MM-dd"，"yyyy-MM-dd HH:mm:ss"等
     * @return String 格式转换之后的时间字符串.
     * @since 1.0
     */
    public static String getDate(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 格式化UTC时间
     *
     * @param date    UTC时间字符串
     * @param pattern 例如"yyyy-MM-dd"，"yyyy-MM-dd HH:mm:ss"等
     * @return
     */
    public static String formatUTCDate(String date, String pattern) {
        //注意是空格+UTC
        date = date.replace("Z", " UTC");

        //本地时区为+8
        String result = DateUtil.formatDate(DateUtil.parseDate(date), pattern);

        return result;
    }


    /**
     * 获取日期时间字符串，默认格式为（yyyy-MM-dd）.
     *
     * @param date    需要转化的日期时间
     * @param pattern 时间格式，例如"yyyy-MM-dd" "HH:mm:ss" "E"等
     * @return String 格式转换后的时间字符串
     * @since 1.0
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, DateUtil.DATE_FORMAT);
        }
        return formatDate;
    }

    /**
     * 获取当前年份字符串.
     *
     * @return String 当前年份字符串，例如 2015
     * @since 1.0
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 获取当前月份字符串.
     *
     * @return String 当前月份字符串，例如 08
     * @since 1.0
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 获取当前天数字符串.
     *
     * @return String 当前天数字符串，例如 11
     * @since 1.0
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 获取当前星期字符串.
     *
     * @return String 当前星期字符串，例如星期二
     * @since 1.0
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 将日期型字符串转换为日期格式.
     * <p>
     * 支持的日期字符串格式包括"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"
     * </p>
     *
     * @param str
     * @return Date
     * @since 1.0
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前日期与指定日期相隔的天数.
     *
     * @param date 给定的日期
     * @return long 日期间隔天数，正数表示给定日期在当前日期之前，负数表示在当前日期之后
     * @since 1.0
     */
    public static long pastDays(Date date) {
        // 将指定日期转换为yyyy-MM-dd格式
        date = DateUtil.parseDate(DateUtil.formatDate(date, DateUtil.DATE_FORMAT));
        // 当前日期转换为yyyy-MM-dd格式
        Date currentDate = DateUtil.parseDate(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT));
        long t = (currentDate.getTime() - date.getTime()) / DateUtil.MILLISECONDS_PER_DAY;
        return t;
    }

    /**
     * 获取当前日期指定天数之后的日期.
     *
     * @param num 相隔天数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextDay(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + num);
        return curr.getTime();
    }

    /**
     * 获取当前日期指定月数之后的日期.
     *
     * @param num 间隔月数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextMonth(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + num);
        return curr.getTime();
    }

    /**
     * 获取当前日期指定年数之后的日期.
     *
     * @param num 间隔年数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextYear(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + num);
        return curr.getTime();
    }

    /**
     * 将 Date 日期转化为 Calendar 类型日期.
     *
     * @param date 给定的时间，若为null，则默认为当前时间
     * @return Calendar Calendar对象
     * @since 1.0
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        // calendar.setFirstDayOfWeek(Calendar.SUNDAY);//每周从周日开始
        // calendar.setMinimalDaysInFirstWeek(1); // 设置每周最少为1天
        if (date != null) {
            calendar.setTime(date);
        }
        return calendar;
    }

    /**
     * 计算两个日期之间相差天数.
     *
     * @param start 计算开始日期
     * @param end   计算结束日期
     * @return long 相隔天数
     * @since 1.0
     */
    public static long getDaysBetween(Date start, Date end) {
        // 将指定日期转换为yyyy-MM-dd格式
        start = DateUtil.parseDate(DateUtil.formatDate(start, DateUtil.DATE_FORMAT));
        // 当前日期转换为yyyy-MM-dd格式
        end = DateUtil.parseDate(DateUtil.formatDate(end, DateUtil.DATE_FORMAT));
        long diff = (end.getTime() - start.getTime()) / DateUtil.MILLISECONDS_PER_DAY;
        return diff;
    }

    /**
     * 计算两个日期之前相隔多少周.
     *
     * @param start 计算开始时间
     * @param end   计算结束时间
     * @return long 相隔周数，向下取整
     * @since 1.0
     */
    public static long getWeeksBetween(Date start, Date end) {
        return getDaysBetween(start, end) / DateUtil.DAYS_PER_WEEK;
    }

    /**
     * 获取与指定日期间隔给定天数的日期.
     *
     * @param specifiedDay 给定的字符串格式日期，支持的日期字符串格式包括"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
     *                     "yyyy/MM/dd HH:mm"
     * @param num          间隔天数
     * @return String 间隔指定天数之后的日期
     * @since 1.0
     */
    public static String getSpecifiedDayAfter(String specifiedDay, int num) {
        Date specifiedDate = parseDate(specifiedDay);
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDate);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);
        String dayAfter = formatDate(c.getTime(), DateUtil.DATE_FORMAT);
        return dayAfter;
    }

    /**
     * 计算两个日期之前间隔的小时数.
     *
     * @param date1 结束时间
     * @param date2 开始时间
     * @return String 相差的小时数，保留一位小数
     * @since 1.0
     */
    public static String dateMinus(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return "0";
        }
        Long r = date1.getTime() - date2.getTime();
        DecimalFormat df = new DecimalFormat("#.0");
        double result = r * 1.0 / DateUtil.MILLISECONDS_PER_HOUR;
        return df.format(result);
    }

    /**
     * 获取当前季度 .
     *
     * @return Integer 当前季度数
     * @since 1.0
     */
    public static Integer getCurrentSeason() {
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH) + 1;
        int season = 0;
        if (month >= 1 && month <= 3) {
            season = 1;
        } else if (month >= 4 && month <= 6) {
            season = 2;
        } else if (month >= 7 && month <= 9) {
            season = 3;
        } else if (month >= 10 && month <= 12) {
            season = 4;
        }
        return season;
    }

    /**
     * 将以秒为单位的时间转换为其他单位.
     *
     * @param seconds 秒数
     * @return String 例如 16分钟前、2小时前、3天前、4月前、5年前等
     * @since 1.0
     */
    public static String getIntervalBySeconds(long seconds) {
        StringBuffer buffer = new StringBuffer();
        if (seconds < SECONDS_PER_MINUTE) {
            buffer.append(seconds).append("秒前");
        } else if (seconds < SECONDS_PER_HOUR) {
            buffer.append(seconds / SECONDS_PER_MINUTE).append("分钟前");
        } else if (seconds < SECONDS_PER_DAY) {
            buffer.append(seconds / SECONDS_PER_HOUR).append("小时前");
        } else if (seconds < SECONDS_PER_MONTH) {
            buffer.append(seconds / SECONDS_PER_DAY).append("天前");
        } else if (seconds < SECONDS_PER_YEAR) {
            buffer.append(seconds / SECONDS_PER_MONTH).append("月前");
        } else {
            buffer.append(seconds / DateUtil.SECONDS_PER_YEAR).append("年前");
        }
        return buffer.toString();
    }

    /**
     * getNowTimeBefore(记录时间相当于目前多久之前)
     *
     * @param seconds 秒
     * @return
     * @throws
     * @author rlliu
     * @since 1.0
     */
    public static String getNowTimeBefore(long seconds) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("上传于");
        if (seconds < 3600) {
            buffer.append((long) Math.floor(seconds / 60)).append("分钟前");
        } else if (seconds < 86400) {
            buffer.append((long) Math.floor(seconds / 3600)).append("小时前");
        } else if (seconds < 604800) {
            buffer.append((long) Math.floor(seconds / 86400)).append("天前");
        } else if (seconds < 2592000) {
            buffer.append((long) Math.floor(seconds / 604800)).append("周前");
        } else if (seconds < 31104000) {
            buffer.append((long) Math.floor(seconds / 2592000)).append("月前");
        } else {
            buffer.append((long) Math.floor(seconds / 31104000)).append("年前");
        }
        return buffer.toString();
    }

    /**
     * getMonthsBetween(查询两个日期相隔的月份)
     *
     * @param startDate 日期1 (格式yyyy-MM-dd)
     * @param endDate   日期2 (格式yyyy-MM-dd)
     * @return
     * @author mhli2
     * @since 3.3
     */
    public static int getMonthsBetween(String startDate, String endDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(DateUtil.parseDate(startDate));
        c2.setTime(DateUtil.parseDate(endDate));
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return Math.abs(year * 12 + month);
    }

    /**
     * getDayOfWeek(获取当前日期是星期几)
     *
     * @param dateStr 日期
     * @return 星期几
     * @throws
     * @author mhli2
     * @since 3.3
     */
    public static String getDayOfWeek(String dateStr) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Date date = parseDate(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekOfDays[num];
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }
}
