package com.reflect;

import java.lang.reflect.Field;

import com.reflect.bean.Person;
import org.junit.Test;


//反射字段
public class Demo5 {
	@Test
	public void test1() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		//获取所包含的字段名
		Field f=clazz1.getField("name");
		//获取字段的值
		Object name=f.get(p);
		System.out.println(name);
		//获取字段的类型
		Class type =f.getType();
		System.out.println(type);
	}
	@Test
	public void test2() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Field f=clazz1.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	@Test
	public void test3() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Field f=clazz1.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
}
