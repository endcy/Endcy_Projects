package com.reflect;

import com.reflect.bean.Person;

public class Demo1 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	//三种反射方法（解析已存在的类，或者说将类中的组成部分加载到内存）
	public static void main(String[] args) throws ClassNotFoundException {
		//1 反射类内容 获取字节码文件
			Class clazz1=Class.forName("com.reflect.bean.Person");
		//2
			Class clazz2=new Person().getClass();
		//3
			Class clazz3=Person.class;
			
					
	}

}
