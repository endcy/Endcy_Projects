package com.Sysclass;
import java.util.*;

public class XunliehuaTest {
	ArrayList a1;
	public XunliehuaTest(int num,int mod){
		a1=new ArrayList(num);
		Random rand=new Random();
		System.out.println("排序之前");
		for(int i=0;i<num;i++){
			a1.add(new Integer(Math.abs(rand.nextInt())%mod+1));
			System.out.println("a1["+i+"]="+a1.get(i));
		}
	}
	public void Sortit(){
		Integer tempint;
		int MaxSize=1;
		for(int i=1;i<a1.size();i++){
			tempint=(Integer)a1.remove(i);
			if(tempint.intValue()>=((Integer)a1.get(MaxSize-1)).intValue()){
				a1.add(MaxSize, tempint);
				MaxSize++;
				System.out.println(a1.toString());
			}
			else{
				for(int j=0;j<MaxSize;j++){
					if(((Integer)a1.get(j)).intValue()>=tempint.intValue()){
						a1.add(j, tempint);
						MaxSize++;
						System.out.println(a1.toString());
						break;
					}
				}
			}
		}
		System.out.println("排序之后:");
		for(int i=0;i<a1.size();i++){
			System.out.println("a1["+i+"]="+a1.get(i));
		}
	}
	public static void main(String[] args) {
		XunliehuaTest XT=new XunliehuaTest(10,100);
		XT.Sortit();
	}

}
