package com.reflect.bean;

import java.io.InputStream;
import java.util.List;

public class Person {
	public String name="xxxx";
	private int password=123;
	private static int age=23;
	public Person(){
		System.out.println("person");
	}
	public Person(String name){
		System.out.println("person name");
	}
	public Person(String name,int pwd){
		System.out.println("person name password:"+pwd);
	}
	private Person(List list){
		System.out.println("list");
	}
	
	
	public void aa1(){
		System.out.println("person name password:");
	}
	public void aa1(String name,int pwd){
		System.out.println(name+":"+pwd);
	}
	public Class[] aa1(String name,int[] pwd){
		return new Class[] {String.class};
	}
	private void aa1(InputStream in){
		System.out.println(in);
	}
	public static void aa1(int num){
		System.out.println(num);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("person");	
	}
}
