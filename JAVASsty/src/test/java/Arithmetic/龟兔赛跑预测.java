package Arithmetic;

import java.util.*;
public class 龟兔赛跑预测 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int arr[]=new int[5];
		for(int i=0;i<5;i++) {
			arr[i]=scan.nextInt();
		}
		int l1,l2,t1,t2,time=0;
		l1=l2=0;
		t1=t2=0;
		while(l1<arr[4] && l2<arr[4]) {
			if(l1-l2>=arr[2]) {
				t2+=arr[3];
				l1=arr[0]*t1;
				l2=arr[1]*t2;
			}
			else {
				t1++;
				t2++;
				l1=arr[0]*t1;
				l2=arr[1]*t2;
			}
		}
		if(l1==l2) 
			System.out.print("D\n"+t2);
		else if(l1>l2)
			System.out.print("R\n"+t2);
		else
			System.out.print("T\n"+arr[4]/arr[1]);
		}
	}
