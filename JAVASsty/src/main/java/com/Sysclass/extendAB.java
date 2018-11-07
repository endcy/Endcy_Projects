package com.Sysclass;
public class extendAB{
	public extendAB(){
		Atest a=new Atest();
		Btest b=new Btest();
	}
	public static void main(String[] args) {
//		extendAB t=new extendAB();
		ObjAtest ax = new ObjAtest();
		ax.setAmt("100");
		ax.setStat("1");
		Atest x = new Atest();
		x.setRetVO(ax);
		ObjAtest ax2 =(ObjAtest) x.getRetVO();
		System.out.println(ax2.getAmt()+ax2.getStat());
	}
}