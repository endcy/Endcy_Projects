package Arithmetic;/*��1�������Ҫ��һ��������n������ʽ���룬���� cin.nextBigInteger(n);
��2�������Ҫ��һ������ת����������Ƶ��ַ�����num.toString(n);����num��Ҫת���Ĵ���n��Ҫת���Ľ��ơ�
��3���������������ת��Ϊ���� BigInteger b = BigInteger.valueOf ( Type t );
��4��������ת��Ϊ����������ݣ���ת��Ϊint��ݣ��� int x =b.intValue();����bΪBigInteger������ݡ�*/
import java.math.*;
//import java.util.Calendar;
//import java.math.BigInteger;
import java.util.Scanner;
public class 序列求和 {
	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
		long s=ss.nextLong();
//		long s2 = Calendar.getInstance().getTimeInMillis();
					
/*		BigInteger a=BigInteger.valueOf(0);		//		BigInteger a =new BigInteger("0");
		for(int i=0;i<=s;i++)
		{
			BigInteger c=BigInteger.valueOf(i);
			a = a.add(c);
//			System.out.println(c);	//С��ʱ���
		}	
		System.out.println(a);
*/ //�˷�����ʱ���޶�1s��
		long r=s*(s+1)/2;
		System.out.println(r);
//		long s1 = Calendar.getInstance().getTimeInMillis();
//		System.out.println("\n������ʱ�����룩��"+(double)(s1-s2)/1000);
	}
}