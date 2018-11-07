package Arithmetic;

import java.util.Scanner;
public class 阶乘计算{
	public static int maxn=3000;
	public static int jc[]=new int[maxn];
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int i,j;

		jc[0]=1;
		for(i=2;i<=a;i++) {
			int c=0;
			for(j=0;j<maxn;j++) {
				int s=jc[j]*i+c;
				jc[j]=s%10;
				c=s/10;
			}
		}
		for( j=maxn-1;j>=0;j--) {
			if(jc[j]!=0) break;
			}					//��һ���Ǵ����λ��ʼ�ضϣ��������λ����ݸ�λ��ʼ��ȥ������
		for(i=j;i>=0;i--)
			System.out.print(jc[i]);
		System.out.println();
	}
}
