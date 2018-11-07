package Arithmetic;

import java.util.Scanner;
public class 杨辉三角形{
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int s[][]=new int[a][a];
		s[0][0]=1;
		for(int i=0;i<a;i++){
			for(int j=0;j<i+1;j++) {
				if(j==0)
					s[i][j]=1;
				else {
					s[i][j]=s[i-1][j-1]+s[i-1][j];
				}
				System.out.print(s[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
