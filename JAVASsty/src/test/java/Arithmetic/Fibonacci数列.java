package Arithmetic;

import java.util.Scanner;
public class Fibonacci数列 {
//	public static int sum;
	public static void main(String[] args) {
		int i;
//		int sumb;
		Scanner ss=new Scanner(System.in); 
		int s=ss.nextInt();
//			sumb=d(s);
		if(s<2) 
		{System.out.print(1);} 
		else{
		int arr[]=new int[s];
		arr[0] = 1;
		arr[1]=1;
		for(i=2;i<arr.length;i++)
		{
			arr[i]=arr[i-1]%10007+arr[i-2]%10007;
			
		}
		System.out.print(arr[s-1]%10007);}		
	}
//	public  static int d(int n) {
/*		if(n==1) {
			sum=1;
			return 1;
			}
		if(n==2) {
			sum=1;
			return 1;
		}
		sum=d(n-1)+d(n-2);
*/		
	}

