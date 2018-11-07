package com.multThread.TimerTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by cxx on 2016/9/28.
 */
public class ExecutorThread {
    public static void startExecutorTask() {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "******" + df.format(new Date()));//new Date()
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);
    }
}
