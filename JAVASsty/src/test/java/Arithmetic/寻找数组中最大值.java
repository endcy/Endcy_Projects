package Arithmetic;

import java.util.*;
public class 寻找数组中最大值 {
	public static Scanner scan=new Scanner(System.in); 
	public static void main(String[] args) {
		int x=scan.nextInt();
		int arr[]=new int[x];
		for(int i=0;i<x;i++){
			arr[i]=scan.nextInt();
		}
		int tem=arr[0],temx=0;
		for(int j=1;j<x;j++){
			if(tem<arr[j]){
				tem=arr[j];
				temx=j;
			}
		}
		System.out.print(tem+" "+temx);

	}

}
