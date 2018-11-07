package Arithmetic;

import java.util.Scanner;
public class 字符串对比 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		String a=scan.nextLine();
		String b=scan.nextLine();
		int x=a.length(),y=b.length(),c=0;
		String d=a.toLowerCase();
		String e=b.toLowerCase();
		char arr1[]=d.toCharArray();
		char arr2[]=e.toCharArray();

		if(x==y) {
			for(int i=0;i<x;i++) {
				if(arr1[i]==arr2[i])
					c++;
			}
			if(a.equals(b))
				System.out.print(2);
			else if(c==x)
				System.out.print(3);
			else
				System.out.print(4);
		}
		else
			System.out.println(1);
		
	}

}
