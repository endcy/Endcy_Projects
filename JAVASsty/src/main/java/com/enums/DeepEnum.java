package com.enums;

enum NewColor {
	RED("红色", 4), GREEN("绿色", 5), BLUE("蓝色", 6);
	private String name;
	private int index;

	private NewColor(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static String GetName(int index) {
		for (NewColor c : NewColor.values()) {
			if (c.getIndex() == index)
				return c.name;
		}
		return null;
	}

	public String getName() {
		return name;
	}
	public static void setName(int index,String name){
		for(NewColor c:NewColor.values()){
			if(c.getIndex()==index){
				c.name=name;
				return ;
			}
		}
	}
	public int getIndex() {
		return index;
	}
	public static void setIndex(int index,String name){
		for(NewColor c:NewColor.values()){
			if(c.getName()==name){
				c.index=index;
				return ;
			}
		}
	}
}

public class DeepEnum {
	public static void main(String[] args) {
		System.out.println("-----------------");
		System.out.println(NewColor.RED.getIndex()+"------"+NewColor.RED.getName());
		System.out.println("----自定义后----");
		NewColor.setName(4, "黑色");
		System.out.println(NewColor.RED.getIndex()+"--"+NewColor.RED.getName());
		NewColor.setIndex(1, "蓝色");
		System.out.println(NewColor.BLUE.getIndex()+"--"+NewColor.BLUE.getName());
	}
}
