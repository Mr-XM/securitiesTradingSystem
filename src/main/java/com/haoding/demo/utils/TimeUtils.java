package com.haoding.demo.utils;



import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeUtils {
    public static String getNowTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String str=format.format(new Date());
        return str;
    }
    public static String getNowTimeSimple(){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");//设置日期格式
        String str=format.format(new Date());
        return str;
    }
    public static String getTodayDate(){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");//设置日期格式
        String str=format.format(new Date());
        return str;
    }
}
