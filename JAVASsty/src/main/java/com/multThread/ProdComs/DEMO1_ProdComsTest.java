package com.multThread.ProdComs;
/*
 * 在queue里面的size没有线程同步，所以不能多线程去执行
 */
public class DEMO1_ProdComsTest {
	public static void main(String[] args) {
		DEMO1_TestQueue tq = new DEMO1_TestQueue();
		DEMO1_TestConsumer tc = new DEMO1_TestConsumer(tq);
		DEMO1_TestProduct tp = new DEMO1_TestProduct(tq);
		 Thread c=new Thread(tc);
		 Thread p=new Thread(tp);
		 p.start();
		 c.start();
//		for(int i=0;i<10;i++){
//			new Thread(new DEMO1_TestConsumer(tq)).start();
//		}
//		for(int i=0;i<4;i++){
//			new Thread(new DEMO1_TestProduct(tq)).start();
//		}
	}
}
