package Arithmetic;

import java.util.Scanner;
public class 闰年判断 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int s=scan.nextInt();
		if((s%4==0&&s%100!=0)||s%400==0){
			System.out.print("yes");
		}
		else{
				System.out.print("no");
		}
	}
}
