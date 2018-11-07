package Arithmetic;

import java.util.Scanner;
public class 数字判断{
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		String x=scan.nextLine();
		String p;
		try{
			Integer.parseInt(x);
			if(true){
				p="yes";
			}
		}
			catch(NumberFormatException e){
				p="no";
			}
		System.out.print(p);
		}

}

