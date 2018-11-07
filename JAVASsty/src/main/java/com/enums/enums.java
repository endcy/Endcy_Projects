package com.enums;

import org.junit.Test;

public class enums {
	@Test
	public void test(){
		print(Grade.E);
	}
	public void print(Grade v){
		String value1=v.getValue();
		String value2=v.localValue();
		System.out.println(value1+":"+value2);
	}
	@Test
	public void testx(){
		System.out.println(Grade.D.name());
		System.out.println(Grade.B.ordinal());
		String str="A";				//可用于判断获取的str是否是枚举中的东西；
		Grade x=Grade.valueOf(str); 
		System.out.println(x.getValue());
		Grade gs[]=Grade.values();
		for(Grade xx:gs){
			System.out.println(xx);
		}
		
	}
	
	enum Grade{
		//define ，then use;
		A("90-100"){
			public String localValue(){
				return "优秀";
			}
		}
		,B("80-89"){
			public String localValue(){
				return "良好";
			}
		},
		C("70-79"){
			public String localValue(){
				return "一般";
			}
		},
		D("60-69"){
			public String localValue(){
				return "及格";
			}
		},
		E("0-59"){
			public String localValue(){
				return "不及格";
			}
		};
		private String value;
		private Grade(String value){
			this.value=value;
		}
		public String getValue(){
			return this.value;
		}
		public abstract String localValue();
	}
}
