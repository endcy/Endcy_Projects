package com.InnerClass;
class StaticInnerClassTest{
	private int prop1=5;
	private static int prop2=9;
	void display(){
		StaticInnerCl in=new StaticInnerCl();
		in.display();
	}
	static class StaticInnerCl{
		private static int age;
		public void display(){
//			System.out.println(prop1); //error 静态内部类无法访问外部实例成员
			System.out.println(prop2); //可访问外部静态成员，静态类成员一体化	
		}
	}
}
public class StaticInnerClass {

	public static void main(String[] args) {
		StaticInnerClassTest outer=new StaticInnerClassTest();
		outer.display();
	}

}
