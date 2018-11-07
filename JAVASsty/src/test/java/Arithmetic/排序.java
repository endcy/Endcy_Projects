package Arithmetic;

import java.io.*;
import java.util.*;
public class 排序{
	public static void main(String args[]) throws IOException {
		Scanner scan=new Scanner(System.in);
		int arr[]=new int[3];
		for(int i=0;i<3;i++) 
			arr[i]=scan.nextInt();
		Arrays.sort(arr);
		for(int i=2;i>=0;i--)
			System.out.print(arr[i]+" ");
	}
}
