package com.blanink.nextal.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理日期类型变量的工具类
 * @author donghai
 * @version v1.0
 * @since 2017/04/20
 */
public class DateUtil {

    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期字符串格式的集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 计算两个时间之间的分钟数
     * @param start
     * @param end
     * @return
     */
    public static Long getBetweenMinutes(Date start, Date end) {
        //long createTime = System.currentTimeMillis();//获取创建时间的时间戳
        long createTime = start.getTime();

        long currentTime = end.getTime();//获取当前时间的时间戳
        long diff = (currentTime - createTime) / 1000 / 60;//获取两个时间相差的分钟
        System.out.println("两个时间差为：" + diff + "分钟");
        return diff;
    }

    /**
     * 根据日期字符串返回日期
     * @param source
     * @param format
     * @return
     * @throws ParseException
     */
    public static final Date parse(String source,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(source);
    }

    /**
     * 根据日期获取格式化的日期字符串
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static final String format(Date date,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 根据日期获取格式化的日期字符串，指定默认格式为：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     * @throws ParseException
     */
    public static final String format(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    /***
     * 新增天数
     * @param sourceDate
     * @param days
     * @return
     */
    public static Date addDay(Date sourceDate,Integer days){
        Calendar calendar   =   new GregorianCalendar();
        calendar.setTime(sourceDate);
        calendar.add(calendar.DATE,days);
        return calendar.getTime();
    }
}
