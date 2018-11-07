package com.reflect;

import java.lang.reflect.Method;

import com.reflect.bean.Person;
import org.junit.Test;

public class Demo4 {
	//反射类中的main方法
	@Test
	public void  test6() throws Exception{
		Person p=new Person();
		Class clazz1=Class.forName("com.reflect.bean.Person");
		Method method= clazz1.getMethod("main",String[].class);
		//调用main方法非常特殊，加载参数并非从字面上理解
		method.invoke(null, new Object[]{new String[]{"aa","bb"}});
		//或者这样“欺骗”函数
		method.invoke(null, (Object)new String[]{"aa","bb"});
	}
}
