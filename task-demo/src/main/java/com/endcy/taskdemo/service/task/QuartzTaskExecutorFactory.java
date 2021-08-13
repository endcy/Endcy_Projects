package com.endcy.taskdemo.service.task;

import com.endcy.taskdemo.service.task.executor.QuartzATaskExecutor;
import com.endcy.taskdemo.service.task.executor.SpringATaskExecutor;
import com.endcy.taskdemo.service.task.executor.TaskExecutor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 创造多种基于TimerTask的执行器工厂
 *
 * @author cxx
 * @date 2021/6/28 23:49
 **/
@Component
public class QuartzTaskExecutorFactory extends StdSchedulerFactory implements TaskExecutorFactory {

    @Autowired
    private QuartzATaskExecutor quartzATaskExecutor;

    @Override
    public TaskExecutor newTaskExecutor(Class clazz) {
        if (SpringATaskExecutor.class.getSimpleName().equals(clazz.getSimpleName())) {
            System.out.println("QuartzTaskExecutorFactory has been offered in Factory");
        }
        return quartzATaskExecutor;
    }

    @Override
    public void schedule(TaskExecutor taskExecutor) {
        Scheduler scheduler = null;
        try {
            // 1、创建调度器Scheduler
            scheduler = this.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return;
        }
        if (scheduler == null || taskExecutor == null) {
            return;
        }
        // 2、创建JobDetail实例，并与执行类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(QuartzATaskExecutor.class)
                .usingJobData("jobDetail_demo", "Job测试")
                .withIdentity("job_demo", "job_group_demo").build();
        // 3、构建Trigger实例 设置开始结束时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime());
        Date endDate = new Date();
        endDate.setTime(Long.MAX_VALUE);

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger_demo", "job_group_demo")
                .usingJobData("trigger_demo", "这是jobDetail_demo的trigger")
                .startNow()
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .build();

        //4、执行
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
            System.out.println("--------quartz scheduler start ! ------------");
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
