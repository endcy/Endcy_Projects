package com.multThread.ProdComs;

import java.util.ArrayList;
import java.util.List;

public class DEMO1_TestQueue {
	public static Object signal=new Object();
	boolean bfull=false;
	private List<String> ls=new ArrayList<String>();
//	private final ReentrantLock lock=new ReentrantLock(true);
//	BlockingQueue q=new ArrayBlockingQueue (10);
	/**
	 * 生产方法
	 */
	public void product(String thing) throws Exception{
		synchronized(signal){
			if(!bfull){
				bfull=true;
				//生产数据放到 ls 中
				int x=(int)(Math.random()*100);
				System.out.println("生产pruduct"+x);
				ls.add("pruduct"+x);
				signal.notify();	//通知消费者
			}
			signal.wait();	//进入待召队列
		}
	}
	/**
	 * 消费方法
	 */
	public String consumer() throws Exception{
		synchronized(signal){
			if(!bfull){
				signal.wait();	//待召等待通知
			}
			bfull=false;
			//读取资源并释放
			signal.notify();
		}
		String result="";
		while(ls.size()>0){
			result=ls.get(ls.size()-1);
			System.out.println("消费"+result);
			ls.remove(ls.size()-1);
		}
		System.out.println("消费完成，队列空，等待生产!");
		return result;
	}
}
