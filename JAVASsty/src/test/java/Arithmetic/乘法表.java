package Arithmetic;

import java.util.*;
public class 乘法表 {
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		String s="";
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				s+=i+"*"+j+"="+i*j+"\t";
			}
			s+="\n";
		}
		System.out.print(s);

	}

}
