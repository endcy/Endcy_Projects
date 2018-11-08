package com.virOperation.core;

import com.virOperation.awt.MoveMouse;
import com.virOperation.utils.PropertiesUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskThread {
    private static ScheduledExecutorService service = null;

    public void run() {
        if (service == null)
            getThread();
    }

    public void shutDown() {
        if (service != null)
            service.shutdownNow();
    }

    private ExecutorService getThread() {
        service = Executors.newScheduledThreadPool(1);
        long intervalTime = Long.valueOf(PropertiesUtil.properties.getProperty(PropertiesUtil.intervaTime));
        service.schedule(new operaThread(), intervalTime, TimeUnit.MINUTES);
        return service;
    }

}

class operaThread implements Runnable {
    public void run() {
        MoveMouse.move();
    }
}
