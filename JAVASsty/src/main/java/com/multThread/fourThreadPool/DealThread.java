package com.multThread.fourThreadPool;

/**
 * Created by cxx on 2016/8/30.
 */
public class DealThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is doing !");
    }
}
