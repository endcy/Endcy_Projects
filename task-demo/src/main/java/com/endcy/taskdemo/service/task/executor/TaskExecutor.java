package com.endcy.taskdemo.service.task.executor;

import com.endcy.taskdemo.param.ScheduleParams;

/**
 * @author cxx
 * @date 2021/6/27 15:41
 **/
public interface TaskExecutor {
    
    /**
     * @description .
     * @author cxx
     * @date 16:02 2021/6/27
     **/
    boolean execute();

    ScheduleParams initExecutor();
}
