package com.endcy.taskdemo.service.task.executor;

import com.endcy.taskdemo.param.ScheduleParams;
import com.endcy.taskdemo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * 基于TimerTask的执行器A
 *
 * @author cxx
 * @date 2021/6/27 15:44
 **/
@Component
public class SimpleTimerATaskExecutor extends TimerTask implements TaskExecutor {

    @Value("${timer.task.A.delay:5000}")
    private long delay;
    @Value("${timer.task.A.period:10000}")
    private long period;

    private static ScheduleParams scheduleParams;

    @Override
    public boolean execute() {
        run();
        return true;
    }

    @Override
    public void run() {
        System.out.println("SimpleTimerATaskExecutor execute in time_" + DateUtils.getNowDateTime());
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
