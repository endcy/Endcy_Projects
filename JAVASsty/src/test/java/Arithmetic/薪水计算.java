package Arithmetic;

import java.util.*;
import java.text.*;
import java.text.*;
public class 薪水计算 {
	public static Scanner scan=new Scanner(System.in);
	public static double z=0.000;
	public static void main(String[] args) {
		double x=scan.nextDouble();
		double y=scan.nextDouble();
		DecimalFormat df1=new DecimalFormat("#0.00");
		if(x>50)
			z=40*y+10*1.5*y+(x-50)*2*y;
		else if(x>40)
			z=40*y+(x-40)*1.5*y;
		else
			z=x*y;
		String temx=String.format("%.2f", z);
		System.out.println(temx);
// ����������		System.out.println(z+" "+df1.format(z));
	}

}
