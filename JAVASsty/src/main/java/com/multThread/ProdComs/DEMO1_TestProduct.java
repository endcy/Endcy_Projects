package com.multThread.ProdComs;

public class DEMO1_TestProduct implements Runnable{
	DEMO1_TestQueue obj;
	public DEMO1_TestProduct(DEMO1_TestQueue obj){
		this.obj=obj;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for(int i=0;i<10;i++){
		while(true){
			try {
				obj.product("test");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
