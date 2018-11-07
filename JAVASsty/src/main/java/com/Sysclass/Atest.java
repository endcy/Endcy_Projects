package com.Sysclass;

public class Atest {
	private Object retVO;

	public void setRetVO(Object retVO) {
		this.retVO = retVO;
	}

	public Object getRetVO() {
		return retVO;
	}

	int x=1;
	public Atest(){
		x=11;
		System.out.println(x);
	}
	public String print(){
		String str = x + " copy ok";
		return str;
	}
	public void uniqA(){
		System.out.println(x);
	}
	public static void main(String[] args) {
		System.out.println("Atest");
	}
}
