package com.datetime;

import java.math.BigDecimal;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/2.
 * Version      : 1.0
 * ***************************************************************************
 */
public class DateTest {
    public static void main(String[] args) {
//        Date date = new Date();
//        long times = (date.getTime()-1533173840936l)/1000;
//        System.out.println(times);
        System.out.println(Long.MAX_VALUE);
        long t = 1899102527875211l;
        t = System.nanoTime();
        System.out.println(t);
        BigDecimal time = new BigDecimal(t);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000000; j++) {
                ;
            }
        }
        long x = System.nanoTime();
        System.out.println(x);
        System.out.println("微秒：" + (new BigDecimal(x).subtract(time)).divide(new BigDecimal("1000")));
    }
}
