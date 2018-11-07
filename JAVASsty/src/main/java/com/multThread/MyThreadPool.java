package com.multThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 2,
				TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(300));
		for (int i = 0; i < 300; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize()
					+ "，队列中等待执行的任务数目：" +
					executor.getQueue().size() + "，已执行玩别的任务数目："
					+ executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
//需要完成的任务操作（业务）
class MyTask implements Runnable {
	private int taskNum;
	public MyTask(int num) {
		this.taskNum = num;
	}
	@Override
	public void run() {
		System.out.println("正在执行task " + taskNum);
		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}
}
