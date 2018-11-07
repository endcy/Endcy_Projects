package Arithmetic;

import java.util.*;
import java.io.*;
public class 删除数组零元素{
	public static void main(String[] args) throws IOException{
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int arr[]=new int[a];
		for(int i=0;i<a;i++)
			arr[i]=scan.nextInt();
		CompactIntegers(arr);	
	}
	public static int CompactIntegers(int arr[]){
		int j=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0)
				j++;
		}
		System.out.println(j);
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0)
				System.out.print(arr[i]+" ");
		}
		return j;
	}
}	

