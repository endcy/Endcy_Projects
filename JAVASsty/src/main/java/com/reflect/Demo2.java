package com.reflect;

import com.reflect.bean.Person;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

//反射类（解剖类）的构造函数，创建类的对象
public class Demo2 {
	//反射构造函数：public Person()
	@Test
	public void test1() throws Exception{
		Class clazz1 = Class.forName("com.reflect.bean.Person");
		Constructor c= clazz1.getConstructor(null);
		Person p=(Person) c.newInstance(null);
		System.out.println(p.name);
		//下面是非框架的做法
		Person px=new Person();
		System.out.println(px.name);
	}
	//反射构造函数：public Person(String name)
	public void test2() throws Exception{
		Class clazz2 = Class.forName("com.reflect.bean.Person");
		Constructor c=clazz2.getConstructor(String.class);
		Person p=(Person) c.newInstance("xxxxx");
		System.out.println(p.name);
	}
		
		
	//反射构造函数：public Person(String name,int password)	
	@Test
	public void test3() throws Exception{
		Class clazz3=Class.forName("com.reflect.bean.Person");
		Constructor c=clazz3.getConstructor(String.class,int.class);
		Person p=(Person)c.newInstance("xxxxx",12);
		System.out.println(p.name);
	}
	
	//反射构造函数：private Person(List List)
	@Test
	public void test4() throws Exception{
		Class clazz4=Class.forName("com.reflect.bean.Person");
		Constructor c=clazz4.getDeclaredConstructor(List.class);
		c.setAccessible(true);	//暴力反射
		Person p=(Person) c.newInstance(new ArrayList());
		System.out.println(p.name);
		
	}
	
	//创建对象的另外一种途径,等效于test1()方法
	@Test
	public void test5() throws Exception{
		Class clazz4=Class.forName("com.reflect.bean.Person");
		Person p=(Person) clazz4.newInstance();
		System.out.println(p);
	}
}
