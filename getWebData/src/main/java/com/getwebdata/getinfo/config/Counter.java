package com.getwebdata.getinfo.config;

import java.util.concurrent.CountDownLatch;

/**
 * 饿汉单例（开销较小直接初始化，不用考虑懒汉双非空校验）
 */
public class Counter {
    public static final CountDownLatch endThreadCounter = new CountDownLatch(5);
    private int targetCounter = 0;
    private int ignoreCounter = 0;

    public int getTargetCounter() {
        return targetCounter;
    }

    public void addTargetCounter() {
        targetCounter++;
    }

    public int getIgnoreCounter() {
        return ignoreCounter;
    }

    public void addIgnoreCounter() {
        ignoreCounter++;
    }

    private static Counter counter = new Counter();

    private Counter() {
    }

    public static Counter getInstance() {
        return counter;
    }
}
