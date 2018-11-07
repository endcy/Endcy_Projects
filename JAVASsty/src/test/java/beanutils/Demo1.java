package beanutils;

import com.beanutils.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//使用beanutils操作bean的属性（第三方）
public class Demo1 {
	@Test
	public void test1() throws  Exception{
		Person p=new Person();
		BeanUtils.setProperty(p, "name", "cxx");
		System.out.println(p.getName());
	}
	
	@Test
	public void test2() throws  Exception{
		String name="aaaa";
		String password ="123";
		String age="34";
		Person p=new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//只支持8中基本数据类型，除非如上加上转换器		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
	}
	
	@Test
	public void test3() throws  Exception{
		String name="aaaa";
		String birthday = "1990-09-09";
		
		//为了让日期赋到bean的birthday属性上，需要给beanUtils注册一个日期转换器
		//可使用API已经写好的类型格式转换器，但Bug比较多建议重写
		//ConvertUtils.register(new DateLocaleConverter(),Date.class); 
		//下面如果不使用实现匿名内部类的方法（接口方法），那么就需要自己写转化器
		ConvertUtils.register(new Converter(){
			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				if(!(value instanceof String)){
					throw new ConversionException("只支持String类型的转换!");
				}
				String str=(String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e); //异常链不能断
				}
			}
		}, Date.class);
		
		Person p=new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "birthday", birthday);//加了转换器就可以设置封装
	
		System.out.println(p.getName());
		Date date=p.getBirthday();
		System.out.println(p.getBirthday());
	}
	@Test
	public void test4() throws Exception{
		Map map=new HashMap();
		map.put("name", "aaaa");
		map.put("password", "12345");
		map.put("age", "21");
		map.put("birthday", "1993-09-09");
		
		Person bean=new Person();
		ConvertUtils.register(new DateLocaleConverter(),Date.class); 
		BeanUtils.populate(bean, map);
		System.out.println(bean.getName());
		System.out.println(bean.getPassword());
		System.out.println(bean.getAge());
		System.out.println(bean.getBirthday());
	}
}
