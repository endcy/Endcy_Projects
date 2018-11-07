package com.multThread.InterruptThread;

import java.util.InputMismatchException;

/**
 * Created by Administrator on 2016/10/11.
 */
class Mythread extends Thread {
    private int num;

    public Mythread(int i) {
        this.num = i;
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 1; i <= num; i++) {
                if (this.interrupted()) {
                    System.out.println("\n be setted thread interrupt……");
                    break;
                }
                System.out.printf(i + "\t");
                if (i % 40 == 0)
                    System.out.println();
            }
            throw new InterruptedException();
        } catch (InterruptedException e) {
            System.out.println("run method get Exception");
        }
    }
}

public class InterruptByExc {
    public static void main(String[] args) {
        try {
            Mythread t1 = new Mythread(50000);
            t1.setPriority(2);      //设置线程优先级
            t1.start();
//            t1.isDaemon();  //设置守护线程 主线程消失该线程结束
            t1.sleep(200);
            t1.interrupt();
        } catch (InterruptedException e) {
            System.out.println("stop by set Interrupt !");
        }
        System.out.println("End !");
    }
}
