package Arithmetic;

import java.util.*;
public class 动态数组使用 {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		int m=scan.nextInt();
		scan.nextLine();
		String l=scan.nextLine();
		String tem[]=l.split(" ");
		int arr[]=new int[m];
		for(int j=0;j<m;j++)
			arr[j]=Integer.valueOf(tem[j]);
		int temp=add(arr,m);
		System.out.print(temp+" ");
		System.out.print(chu(temp,m));
		
	}
	public static int add(int a[],int x){
		int add=0;
		for(int i=0;i<x;i++)
			add+=a[i];
		return add;
	}
	public static int chu(int i,int j){
		return (int)(i/j);
	}
}
