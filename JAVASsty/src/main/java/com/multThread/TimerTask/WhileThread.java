package com.multThread.TimerTask;

import java.util.Date;

/**
 * Created by cxx on 2016/9/28.
 */
public class WhileThread extends Thread {
    @Override
    public void run() {
        final long timeInterval = 5000; //5秒
        while (true) {
            // ------- code for task to run
            System.out.println(Thread.currentThread().getName() + "******" + new Date());
            // ------- ends here
            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
