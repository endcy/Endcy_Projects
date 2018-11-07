package com.multThread.fourThreadPool;

import java.util.concurrent.Callable;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/16.
 * Version      : 1.0
 * ***************************************************************************
 */
public class CallableThread implements Callable<Integer> {
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public CallableThread(Integer num) {
        this.num = num;
    }

    ;

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is doing !");
        return new Integer(520 + num);
    }
}
