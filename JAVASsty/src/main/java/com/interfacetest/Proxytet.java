package com.interfacetest;
abstract class Subject{
	abstract public void request();;
}
class RealSubject extends Subject{		//定义真实业务功能的子类
	public void request(){
		System.out.println("我是厂商");
	}
}
class ProxySubject extends Subject{		//完成真是业务操作
	private RealSubject realSub;	//外部接口类，空类。
	private void preRequest(){
		System.out.println("广告宣传");
	}
	private void postRequset(){
		System.out.println("付费购买");
	}
	public void request(){
		preRequest();
		if(realSub==null){
			realSub=new RealSubject();	//当代理调用时为接口实例化
		}
		realSub.request();
		postRequset();
	}
}

public class Proxytet {
	public static void main(String[] args) {
		Subject sub=new ProxySubject();	//客户找代理类，子类为接口实例化
		sub.request();
	}
}
