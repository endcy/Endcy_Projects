package com.endcy.taskdemo.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cxx
 * @date 2021/6/27 20:28
 **/
@Data
public class ScheduleParams implements Serializable {
    private Long delay;
    private Long period;

}
