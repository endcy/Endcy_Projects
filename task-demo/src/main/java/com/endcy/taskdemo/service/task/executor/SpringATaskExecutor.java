package com.endcy.taskdemo.service.task.executor;

import com.endcy.taskdemo.param.ScheduleParams;
import com.endcy.taskdemo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用于Spring task的执行器A
 *
 * @author cxx
 * @date 2021/6/27 21:44
 **/
@Component
public class SpringATaskExecutor implements TaskExecutor {

    @Value("${timer.task.A.delay:5000}")
    private long delay;
    @Value("${timer.task.A.period:10000}")
    private long period;

    private static ScheduleParams scheduleParams;

    @Override
    public boolean execute() {
        System.out.println("SpringATaskExecutor execute in time_" + DateUtils.getNowDateTime());
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
}
