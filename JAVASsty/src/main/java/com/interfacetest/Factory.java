package com.interfacetest;
interface Fruit{
	public void eat();
}
class Apple implements Fruit{
	public void eat(){
		System.out.println("吃苹果");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("吃橘子");
	}
}
class Unk implements Fruit{
	public void eat(){
		System.out.println("未知接口对象");
	}
}
//设置接口类型
class Factoryset{
	public static Fruit getInstance(String className){
		if("apple".equals(className))
			return new Apple();
		if("orange".equals(className))
			return new Orange();
		return new Unk();
	}
}
public class Factory {
	public static void main(String args[]){
		//设置实例化的接口对象 不需要创建未知的实例化对象
		Fruit f=Factoryset.getInstance("orange");
		f.eat();
		//创建已知的接口对象，此过程必须知道具体实例化的接口对象
		Fruit fx=new Apple();
		fx.eat();
	}
}
