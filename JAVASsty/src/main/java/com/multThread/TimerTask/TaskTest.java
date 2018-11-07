package com.multThread.TimerTask;

import java.util.Scanner;

/**
 * Created by cxx on 2016/9/28.
 */
public class TaskTest {
    public static void main(String[] args) {
        System.out.println("Select 1/2/3 for WhielThread/ItTimerThread/ExecutorThread");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        if (select == 1) {
            Thread wthread = new WhileThread();
            wthread.run();
        }
        if(select==2){
            ItTimerThread.startTimerTask();
        }
        if(select==3){
            ExecutorThread.startExecutorTask();
        }
        else
            TaskTest.main(new String[]{"start"});
    }
}
