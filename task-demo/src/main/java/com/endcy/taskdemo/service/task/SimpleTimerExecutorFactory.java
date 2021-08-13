package com.endcy.taskdemo.service.task;

import com.endcy.taskdemo.service.task.executor.SimpleTimerATaskExecutor;
import com.endcy.taskdemo.service.task.executor.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 创造多种基于TimerTask的执行器工厂
 *
 * @author cxx
 * @date 2021/6/27 18:59
 **/
@Component
public class SimpleTimerExecutorFactory extends Timer implements TaskExecutorFactory {

    @Autowired
    private SimpleTimerATaskExecutor simpleTimerATaskExecutor;

    @Override
    public TaskExecutor newTaskExecutor(Class clazz) {
        if (SimpleTimerATaskExecutor.class.getSimpleName().equals(clazz.getSimpleName())) {
            System.out.println("SimpleTimerATaskExecutor has been offered in Factory");
        }
        return simpleTimerATaskExecutor;
    }

    @Override
    public void schedule(TaskExecutor taskExecutor) {
        if (taskExecutor instanceof TimerTask) {
            schedule((TimerTask) taskExecutor,
                    taskExecutor.initExecutor().getDelay(),
                    taskExecutor.initExecutor().getPeriod());
        }
    }

}
