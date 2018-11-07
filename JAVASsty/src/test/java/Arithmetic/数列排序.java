package Arithmetic;

import java.util.Scanner;
public class 数列排序 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int i=scan.nextInt();
		int arr[]=new int[i];
		for(int j=0;j<i;j++)
		{
			arr[j]=scan.nextInt();
		}
		for(int j=0;j<i;j++)
		{
			for(int k=j;k<i;k++)
			{
				if(arr[j]>arr[k])
				{	int x=arr[j];
					arr[j]=arr[k];
					arr[k]=x;
				}	
			}
		}
		for(int j=0;j<i;j++)
			System.out.print(arr[j]+" ");
	}
}
