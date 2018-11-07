package com.multThread.TimerTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cxx on 2016/9/28.
 */
public class ItTimerThread {
   public static void startTimerTask(){
       TimerTask timerTask = new TimerTask() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName()+"******"+new Date());
           }
       };
       Timer timer = new Timer();
       long delay=0;
       long timeInterval = 5000;
       timer.scheduleAtFixedRate(timerTask,delay,timeInterval);
   }
}
