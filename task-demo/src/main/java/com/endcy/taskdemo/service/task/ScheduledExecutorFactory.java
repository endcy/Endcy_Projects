package com.endcy.taskdemo.service.task;

import com.endcy.taskdemo.service.task.executor.ScheduledATaskExecutor;
import com.endcy.taskdemo.service.task.executor.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 创造多种基于TimerTask的执行器工厂
 *
 * @author cxx
 * @date 2021/6/27 18:59
 **/
@Component
public class ScheduledExecutorFactory implements TaskExecutorFactory {

    @Autowired
    private ScheduledATaskExecutor scheduledATaskExecutor;

    private static ScheduledExecutorService executorService;

    @Override
    public TaskExecutor newTaskExecutor(Class clazz) {
        if (ScheduledATaskExecutor.class.getSimpleName().equals(clazz.getSimpleName())) {
            System.out.println("SimpleTimerATaskExecutor has been offered in Factory");
        }
        return scheduledATaskExecutor;
    }

    @Override
    public void schedule(TaskExecutor taskExecutor) {
        if (!(taskExecutor instanceof Runnable)) {
            return;
        }
        if (executorService == null) {
            executorService = Executors.newScheduledThreadPool(10);
        }
        executorService.scheduleWithFixedDelay((Runnable) taskExecutor,
                taskExecutor.initExecutor().getDelay(),
                taskExecutor.initExecutor().getPeriod(),
                TimeUnit.MILLISECONDS);
    }

}
