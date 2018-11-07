package Arithmetic;

import java.io.IOException;
import java.util.*;
public class 错误票据 {
	public static void main(String[] args) throws IOException{
		final int m=10000;int num=0,markd=0,marke=0,news=999;
		Scanner scan=new Scanner(System.in);
		int arr[]=new int[m];
		Arrays.fill(arr,-8);
		int line=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<line;i++){
			String l=scan.nextLine();
			String temp[]=l.split(" "); 
			for(int j=0;j<temp.length;j++)
				arr[num++]=Integer.valueOf(temp[j]);
		}	
		Arrays.sort(arr);
		for(int i=9998;arr[i]>0;i--){
				if(arr[i]+1!=arr[i+1]){
					if(arr[i]==arr[i+1])
						marke=arr[i];
					else
						markd=arr[i]+1;
				}
				System.out.print(arr[i]+" ");
		}

		System.out.print(markd+" "+marke);
	}
}
