package com.interfacetest;

interface A{
	public String getInfo();
}
class B implements A{
	public String getInfo(){
		return "OK";
	}
}
public class ObjectInterface {
	public static void main(String[] args) {
		A a=new B();	//向上转型，为接口实例化
		Object obj=a;	//Object类型接收，向上转型（所有类型都能向上转型成Object类）
		A x=(A)obj;		//向下转型便于实现方法
		System.out.println(x.getInfo());
	}
}
