package com.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import com.reflect.bean.Person;
import org.junit.Test;

//反射类的方法
public class Demo3 {
	
	@Test
	public void  test1() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getMethod("aa1",null);
		method.invoke(p, null);
	}
	@Test
	public void  test2() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getMethod("aa1",String.class,int.class);
		method.invoke(p, "老李",21);
	}
	@Test
	public void  test3() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getMethod("aa1",String.class,int[].class);
		Class cs[] =(Class[]) method.invoke(p, "老李",new int[]{1,2,3});
		System.out.println(cs[0]);
	}
	@Test
	public void  test4() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getDeclaredMethod("aa1",InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("c:\\1.txt"));//文件必须存在
		System.out.println();
	}
	@Test
	public void  test5() throws Exception{
		//Person p=new Person(); 访问类中的静态方法 新建类对象可有可无
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getMethod("aa1",int.class);
		method.invoke(null, 23);
	}

}
