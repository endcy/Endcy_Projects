package com.endcy.taskdemo.service.task.executor;

import com.alibaba.fastjson.JSON;
import com.endcy.taskdemo.param.ScheduleParams;
import com.endcy.taskdemo.utils.DateUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 基于quartz的执行器A
 *
 * @author cxx
 * @date 2021/6/28 23:44
 **/
@Component
public class QuartzATaskExecutor implements TaskExecutor, Job {

    @Value("${timer.task.A.delay:5000}")
    private long delay;
    @Value("${timer.task.A.period:10000}")
    private long period;

    private static ScheduleParams scheduleParams;

    @Override
    public boolean execute() {
        return true;
    }

    @Override
    public ScheduleParams initExecutor() {
        if (scheduleParams == null) {
            scheduleParams = new ScheduleParams();
            scheduleParams.setDelay(delay);
            scheduleParams.setPeriod(period);
        }
        return scheduleParams;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("QuartzATaskExecutor execute in time_" + DateUtils.getNowDateTime());
        System.out.println(JSON.toJSONString(jobExecutionContext.getTrigger().getJobDataMap()));

    }
}
