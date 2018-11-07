package Arithmetic;

import java.util.*;
public class Huffman树{
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		int arr[]=new int[num];
		int x,j=0,i,count=0;
		for(i=0;i<num;i++)
			arr[i]=scan.nextInt();
		Arrays.sort(arr);
		for(i=0;i<num-1;i++) {
			while(arr[j]==-1) {
				j++;
			}
			x=arr[j]+arr[j+1];
			count+=x;
			arr[j]=arr[j+1]=-1;
			arr[0]=x;
			Arrays.sort(arr);
			j=0;
		}
		System.out.println(count);	
	}
}
