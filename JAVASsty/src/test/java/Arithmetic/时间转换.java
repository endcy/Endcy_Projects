package Arithmetic;

import java.util.*;
public class 时间转换 {
	public static void main(String args[]) {
	Scanner scan=new Scanner(System.in);
	int a=scan.nextInt();
	int h=a/3600;
	int m=a%3600/60;
	int s=a-3600*h-60*m;
	System.out.print(h+":"+m+":"+s);
	}
}
