package com.multThread.fourThreadPool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by cxx on 2016/8/30.
 */
public class DealThreadPool {
    @Test   //单线程的线程池
    public void singleExecutor() {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        Thread[] tx = new Thread[5];
        for (int i = 0; i < 5; i++) {
            tx[i] = new DealThread();
        }
        for (int i = 0; i < 5; i++) {
            singlePool.execute(tx[i]);
        }
        singlePool.shutdown();
    }

    @Test   //可重用固定线程数的线程池
    public void fixedExecutor() {
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);    //固定线程4
        Thread[] tx = new Thread[5];
        for (int i = 0; i < 5; i++) {
            tx[i] = new DealThread();
        }
        for (int i = 0; i < 5; i++) {
            fixedPool.execute(tx[i]);
        }
        fixedPool.shutdown();
    }

    @Test   //可缓存的线程池
    public void cachedExecutor() {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        Thread[] tx = new Thread[5];
        for (int i = 0; i < 5; i++) {
            tx[i] = new DealThread();
        }
        for (int i = 0; i < 5; i++) {
            cachedPool.execute(tx[i]);
        }
        cachedPool.shutdown();
    }

    @Test   //大小无限的线程池
    public void scheduledExecutor() {
//        ExecutorService scheduledPool=Executors.newScheduledThreadPool(2);
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(3);
        schedulePool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("####");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        System.out.println(schedulePool.getActiveCount() + "  " + schedulePool.getCorePoolSize());

        schedulePool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                while (true)
                    System.out.println(System.nanoTime());
            }
        }, 1000, 4000, TimeUnit.MILLISECONDS);
        schedulePool.scheduleAtFixedRate(new DealThread(), 1000, 2000, TimeUnit.MILLISECONDS);
    }

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    @Test   //在1小时内每10秒钟蜂鸣一次
    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        DealThreadPool x=new DealThreadPool();
        x.beepForAnHour();
    }
}
