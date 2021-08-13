package com.endcy.taskdemo.service.task;

import com.endcy.taskdemo.service.task.executor.TaskExecutor;

/**
 * @author cxx
 * @date 2021/6/27 18:53
 **/
public interface TaskExecutorFactory {
    TaskExecutor newTaskExecutor(Class clazz);

    void schedule(TaskExecutor taskExecutor);

}
