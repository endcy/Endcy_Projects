package com.endcy.taskdemo.service.task;

import com.endcy.taskdemo.service.task.executor.SpringATaskExecutor;
import com.endcy.taskdemo.service.task.executor.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 创造多种基于TimerTask的执行器工厂
 *
 * @author cxx
 * @date 2021/6/27 18:59
 **/
@Component
@EnableScheduling
public class SpringTaskExecutorFactory implements TaskExecutorFactory {

    @Autowired
    private SpringATaskExecutor springATaskExecutor;

    private static final AtomicBoolean threadLock = new AtomicBoolean();

    @Override
    public TaskExecutor newTaskExecutor(Class clazz) {
        if (SpringATaskExecutor.class.getSimpleName().equals(clazz.getSimpleName())) {
            System.out.println("SpringATaskExecutor has been offered in Factory");
        }
        return springATaskExecutor;
    }

    @Override
    public void schedule(TaskExecutor taskExecutor) {
        if (taskExecutor == null){
            return;
        }
        threadLock.set(true);
        doSchedule();
    }

    //    @Scheduled(cron = "*/10 * * * * ?")
    @Scheduled(fixedDelay = 10000)
    public void doSchedule() {
        if (!threadLock.get()) {
            return;
        }
        springATaskExecutor.execute();
    }

}
