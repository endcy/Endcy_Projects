package Arithmetic;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.math.*;
public class 高精度加法{
	public static void main(String args[]) throws IOException {
//		Scanner scan=new Scanner(System.in);
//		int x=scan.nextInt();
/*		int[] a=new int[100];
		int[] b=new int[100];
		int con1=0,con2=0,cin,cin2;
//��һ����洢
			while((cin=System.in.read())!=13) {
				a[con1]=cin-48;
				con1++;
			}
			for(int j=0;j<con1;j++) {
				System.out.print(a[j]);
			}
		System.out.println();
//�ڶ�����洢
			while((cin=System.in.read())!=13) {
				b[con2]=cin-48;
				con2++;
			}
			for(int k=0;k<con2;k++) {
				System.out.print(b[k]);
			}
*/
		Scanner cin=new Scanner(new BufferedInputStream(System.in));      
	    BigInteger a,b,c;                        
	    a=cin.nextBigInteger();                
	    b=cin.nextBigInteger();    	
	    c=a.add(b);             
	    System.out.println(c);    
	}
}
