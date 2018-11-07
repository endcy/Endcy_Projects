package com.multThread;
public class Task {
	//标识任务状态常量
	public static final int READY = 0;
	public static final int RUNNING = 1;
	public static final int FINISHED = 2;

	// 声明一个任务的自有业务含义的变量，用于标识任务
	private int status;

	private int taskId;

	/**
	* 任务初始化的构造方法，传入一个任务ID
	* @param taskId
	*/
	public Task(int taskId) {
	this.status = READY;
	this.taskId = taskId;
	}

	/**
	* 任务执行的方法
	*/
	public void execute() {
	// 设置状态为运行中
	setStatus(Task.RUNNING);
	System.out.println("当前线程 ID 是：" + Thread.currentThread().getName() + " | 任务 ID 是：" + this.taskId);
	// 附加一个延时
	try {
	Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	// 执行完成，改状态为完成
	setStatus(FINISHED);
	}

	public void setStatus(int status) {
	this.status = status;
	}

	public int getTaskId() {
	return taskId;
	}
	} 