package com.introspector;

import org.junit.Test;

import java.beans.*;
import java.lang.reflect.Method;

//内省操作用来操作javabean数据属性，作用的应用点与反射类字段不同
public class Demo1 {
	// 得到bean的所有属性
	@Test
	public void test1() throws Exception {
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
		System.out.println();

		// 去除自有的class属性
		BeanInfo infox = Introspector.getBeanInfo(Person.class, Object.class);
		PropertyDescriptor[] pdsx = infox.getPropertyDescriptors();
		for (PropertyDescriptor pdx : pdsx) {
			System.out.println(pdx.getName());
		}
	}

	// 操作bean的指定属性
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// 得到属性的写方法 为属性赋值
		Method method = pd.getWriteMethod();
		method.invoke(p, 45);
		// System.out.println(p.getAge());
		// 获取属性的值
		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
	}

	// 获取当前操作的属性的类型
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
	}
}
