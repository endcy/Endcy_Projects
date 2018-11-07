package com.Sysclass;

public class Btest extends Atest{

	int x=2;
	public Btest(){
//		Atest b=new Atest();
//		x=b.x;
		x=22;
		System.out.println(x);
	}
	@Override
	public String print(){
		return x + " it real copy";
	}
	public void uniqB(){
		System.out.println(x);
	}
	public static void main(String[] args) {
		System.out.println("Btest");
	}
}
