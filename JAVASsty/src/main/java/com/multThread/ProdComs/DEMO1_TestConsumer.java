package com.multThread.ProdComs;

public class DEMO1_TestConsumer implements Runnable {
	DEMO1_TestQueue obj;

	public DEMO1_TestConsumer(DEMO1_TestQueue obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 10; i++) {
			while(true){
			try {
				obj.consumer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
