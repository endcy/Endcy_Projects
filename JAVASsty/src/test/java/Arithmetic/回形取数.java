package Arithmetic;

import java.util.*;
public class 回形取数{
	public static int count=0;
	public static void main(String args[]) {
		int arr[][]=new int[205][205];
		int brr[][]=new int[205][205];
		for(int i=0;i<205;i++) {
			for(int j=0;j<205;j++) {
				arr[i][j]=-1;brr[i][j]=-1;
			}
		}
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();

		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++)
			{
				arr[i][j]=scan.nextInt();
			}
		}
		int u=1,v=1;
		System.out.print(arr[u][v]);
		brr[u][v]=1;
		count++;
		do {
			while(arr[u+1][v]!=-1&&brr[u+1][v]==-1) {
				u++;System.out.print(" "+arr[u][v]);brr[u][v]=1;count++;
				}
			while(arr[u][v+1]!=-1&&brr[u][v+1]==-1) {
				v++;System.out.print(" "+arr[u][v]);brr[u][v]=1;count++;
				}
			while(arr[u-1][v]!=-1&&brr[u-1][v]==-1) {
				u--;System.out.print(" "+arr[u][v]);brr[u][v]=1;count++;
				}
			while(arr[u][v-1]!=-1&&brr[u][v-1]==-1) {
				v--;System.out.print(" "+arr[u][v]);brr[u][v]=1;count++;
				}
		}while(count!=x*y);
	}
}