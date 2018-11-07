package com.communication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/10/11.
 * Version      : 1.0
 * ***************************************************************************
 */
public class HighConcurrencyTest {
    public static void main(String[] args) {
        //这里的Runnable知识一个执行接口，后续放到Tread中作为统一执行实体，所以变量counter共享
        Runnable runnable = new Runnable() {
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void run() {
                //do something
                for (int i = 0; i < 100; i++) {
                    System.out.println(System.nanoTime() + " Thread:" + Thread.currentThread().getName() + "  Count:" + counter.incrementAndGet());
                }
            }
        };
        System.out.println("******** cost[ns]:" + startAllInOne(10, runnable));
    }

    public static long startAllInOne(int num, final Runnable runnable) {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();  //等待开始门计数到0
                        try {
                            runnable.run();
                        } finally {
                            endGate.countDown(); //结束门计数减1，为最后所有线程结束后计时（或其它操作）做准备
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(System.nanoTime() + " All thread are reading starting");
        startGate.countDown();  //先通过第一道门 然后线程统一进入开始执行
        try {
            //开启结束门，基本执行到此处countDownLatch已经为0，如果线程或线程执行耗时足够多这里才会有作用，所有执行结果会统一通过结束门
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //结束门开启后这里的计时才会准确，因为所有线程都执行完毕
        return System.nanoTime() - startTime;
    }
}
