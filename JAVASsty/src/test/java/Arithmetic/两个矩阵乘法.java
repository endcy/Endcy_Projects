package Arithmetic;

import java.util.*;
public class 两个矩阵乘法 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();int y=scan.nextInt();int z=scan.nextInt();
		int arr1[][]=new int[x][y];
		int arr2[][]=new int[y][z];
		int arr3[][]=new int[x][z];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				arr1[i][j]=scan.nextInt();
		for(int i=0;i<y;i++)
			for(int j=0;j<z;j++)
				arr2[i][j]=scan.nextInt();
		int matrixCopy[][]=new int[x][z];
		for(int i = 0 ;i < x; i++)
		{
			for(int k=0;k<x;k++){
			int temp=0;
			for(int j = 0; j < y; j++)
			{		
					temp+=arr1[i][j]*arr2[j][k];
			}
			System.out.print(temp+" ");
			}
			System.out.println();
		}
	}
}
