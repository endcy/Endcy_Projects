package Arithmetic;

import java.util.Scanner;
public class 报时助手 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		int i,j,k,l,m;
		String[] num= {"zero","one","two ","three"," four"," five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen ","sixteen","seventeen","eighteen","nineteen","twenty","twenty one","twenty two","twenty three"};
		String[] shi= {"zero","ten","twenty","thirty","forty","fifty"};
		for(i=0;i<x;)
			i++;
		if(y==0) {
			System.out.println(num[i]+" o'clock");
		}
		else {
			if(y<=20) {
				for(j=0;j<y;)
					j++;
				System.out.println(num[i]+" "+num[j]);
			}
			if(y>20) {
				k=y/10;//ȡ����ʮλ
				for(j=1;j<k;)
					j++;
				l=y%10;//ȡ���Ӹ�λ
				for(m=0;m<l;)
					m++;
				if(m==0)
					System.out.println(num[i]+" "+shi[j]);
				else
					System.out.println(num[i]+" "+shi[j]+" "+num[m]);
			}
		}
	}
}
/*switch (y/10){
				case 2:
					System.out.println(num[i]+" "+num[j]);
				}*/