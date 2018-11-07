package Arithmetic;

import java.util.*;
import java.io.*;
public class 前缀表达式{
	public static void main(String args[]) throws IOException{
		Scanner scan=new Scanner(System.in);
	int b;
		String arr[]=new String[3];
		for(int i=0;i<3;i++)
			arr[i]=scan.next();
		if(arr[0].equals("+"))
			b=Integer.parseInt(arr[1])+Integer.parseInt(arr[2]);
		else if(arr[0].equals("-"))
			b=Integer.parseInt(arr[1])-Integer.parseInt(arr[2]);
		else if(arr[0].equals("*"))
			b=Integer.parseInt(arr[1])*Integer.parseInt(arr[2]);
		else
			b=Integer.parseInt(arr[1])/Integer.parseInt(arr[2]);
		System.out.println(b);

/*//����
  		char a;
		int b,c,d;
		a=(char)System.in.read();
		b=scan.nextInt();
		c=scan.nextInt();
		if(a=='+')
			d=c+b;
		else if(a=='-')
			d=b-c;
		else if(a=='*')
			d=c*b;
		else
			d=b/c;
		System.out.print(d);*/
	}
}
