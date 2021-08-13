package com.endcy.taskdemo.service.impl;

import com.endcy.taskdemo.service.task.*;
import com.endcy.taskdemo.service.task.executor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cxx
 * @date 2021/6/26 20:14
 **/
@Component
public class TaskPortalService {

    @Autowired
    private SimpleTimerExecutorFactory timerExecutorFactory;
    @Autowired
    private ScheduledExecutorFactory scheduledExecutorFactory;
    @Autowired
    private SpringTaskExecutorFactory springTaskExecutorFactory;
    @Autowired
    private QuartzTaskExecutorFactory quartzTaskExecutorFactory;

    public boolean startTask(String type) {
        //简单的直接确定工厂
        TaskExecutorFactory taskExecutorFactory;
        TaskExecutor taskExecutor = null;
        type = String.valueOf(type);
        switch (type) {
            case "timer":
                taskExecutorFactory = timerExecutorFactory;
                taskExecutor = taskExecutorFactory.newTaskExecutor(SimpleTimerATaskExecutor.class);
                break;
            case "executor":
                taskExecutorFactory = scheduledExecutorFactory;
                taskExecutor = taskExecutorFactory.newTaskExecutor(ScheduledATaskExecutor.class);
                break;
            case "spring":
                taskExecutorFactory = springTaskExecutorFactory;
                taskExecutor = springTaskExecutorFactory.newTaskExecutor(SpringATaskExecutor.class);
                break;
            case "quartz":
                taskExecutorFactory = quartzTaskExecutorFactory;
                taskExecutor = quartzTaskExecutorFactory.newTaskExecutor(QuartzATaskExecutor.class);
                break;
            default:
                taskExecutorFactory = timerExecutorFactory;
                break;
        }
        if (taskExecutor == null) {
            return false;
        }
        taskExecutorFactory.schedule(taskExecutor);
        return true;
    }
}
