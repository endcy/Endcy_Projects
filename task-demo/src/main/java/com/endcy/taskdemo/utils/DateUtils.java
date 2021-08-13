package com.endcy.taskdemo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cxx
 * @date 2021/6/27 20:50
 **/
public class DateUtils {
    public static final DateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getNowDateTime() {
        return COMMON_DATE_FORMAT.format(new Date());
    }
}
