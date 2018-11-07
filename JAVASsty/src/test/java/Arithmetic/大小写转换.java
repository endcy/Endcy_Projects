package Arithmetic;

import java.util.*;
public class 大小写转换 {
	public static void main(String args[]) throws Exception{
		Scanner scan=new Scanner(System.in);
		String s1=scan.nextLine();
		int x=s1.length();
		char arr[]=new char[x];
		char arrtemp[]=new char[x];
		char arrtemp2[]=new char[x];
		arr=s1.toCharArray();
		arrtemp=s1.toLowerCase().toCharArray();
		arrtemp2=s1.toUpperCase().toCharArray();
		for(int i=0;i<x;i++){
			if(arr[i]!=arrtemp[i])
				arr[i]=arrtemp[i];
			else if(arr[i]==arrtemp[i])
				arr[i]=arrtemp2[i];
			else
				;
			System.out.print(arr[i]);	
		}	
	}
}
