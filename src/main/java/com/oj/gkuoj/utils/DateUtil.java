package com.oj.gkuoj.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**jdk8时间Util
 * @author m969130721@163.com
 * @date 18-6-20 下午4:39
 */
public class DateUtil {
    public static final String DEFAULT_DATE_FORMATTER = "yyyy-MM-dd HH:ss:mm";

    public static final String DATE_FORMATTER = "yyyyMMdd";

    public static final String CHINA_DATE_FORMATTER = "yyyy年MM月dd日 HH:mm:ss";


    /**
     * 获取当前日期时间字符串
     * @param formatter 格式化
     * @return
     */
    public static String getCurrentDateTimeAsString(DateTimeFormatter formatter){
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (null == formatter) {
            formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER);
        }
        return currentDateTime.format(formatter);
    }
    /**
     * 获取当前日期字符串
     * @param formatter 格式化
     * @return
     */
    public static String getCurrentDateAsString(DateTimeFormatter formatter){
        LocalDate currentDate = LocalDate.now();
        if (null == formatter){
            formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        }
        return currentDate.format(formatter);
    }

    /**
     * 获取当前日期时间
     * @param formatter
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime(DateTimeFormatter formatter){
        String text = getCurrentDateTimeAsString(null);
        if (null == formatter){
            formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER);
        }
        return LocalDateTime.parse(text,formatter);
    }

    /**
     * 获取当前日期
     * @param formatter
     * @return
     */
    public static LocalDate getCurrentLocalDate(DateTimeFormatter formatter){
        String text = getCurrentDateAsString(null);
        if (null == formatter){
            formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        }
        return LocalDate.parse(text,formatter);
    }

    /**
     * 获取当前日期
     * @param formatter
     * @return
     */
    public static Date getCurrentDate(DateTimeFormatter formatter){
        LocalDateTime localDateTime = getCurrentLocalDateTime(formatter);
        return convertLocalDateTimeToDate(localDateTime);
    }


    /**
     * 转换java8的LocalDatetime为Date对象
     * @param localDateTime
     * @return
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 在当前时间加秒数
     * @param second 秒(可为负数)
     * @return
     */
    public static Date plusSecondBaseOnCurrentDate(int second){
        LocalDateTime currentLocalDateTime = getCurrentLocalDateTime(null);
        LocalDateTime plusSeconds = currentLocalDateTime.plusSeconds(second);
        return convertLocalDateTimeToDate(plusSeconds);
    }

    /**
     * 在当前时间加分钟
     * @param min 分钟(可为负数)
     * @return
     */
    public static Date plusMinBaseOnCurrentDate(int min){
        LocalDateTime currentLocalDateTime = getCurrentLocalDateTime(null);
        LocalDateTime plusMinutes= currentLocalDateTime.plusMinutes(min);
        return convertLocalDateTimeToDate(plusMinutes);
    }

    /**
     * 在当前时间加小时
     * @param hours 小时(可为负数)
     * @return
     */
    public static Date plusHoursBaseOnCurrentDate(int hours){
        LocalDateTime currentLocalDateTime = getCurrentLocalDateTime(null);
        LocalDateTime plusHours = currentLocalDateTime.plusHours(hours);
        return convertLocalDateTimeToDate(plusHours);
    }

    /**
     * 计算两个日期的相差分钟
     * @param before
     * @param after
     * @return
     */
    public static Long getDifferMin(Date before,Date after){
        Duration duration = Duration.between(after.toInstant(),before.toInstant());
        return duration.toMinutes();
    }

    public static void main(String[] args) throws InterruptedException {


    }


}
