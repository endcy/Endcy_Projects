package Arithmetic;

import java.util.Scanner;
public class 芯片测试 {
	public static void main(String args[]) {
		int arr1[][]=new int[25][25];
		int n;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr1[i][j]=scan.nextInt();
			}
		}
		for(int j=0;j<n;j++) {
			int count=0;
			for(int i=0;i<n;i++) {
				count+=arr1[i][j];
			}
			if(count>n/2) {
				System.out.print(j+1+" ");
			}
		}
	}
}
