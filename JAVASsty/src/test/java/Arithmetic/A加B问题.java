package Arithmetic;

import java.util.Scanner;
public class A加B问题 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		String a=scan.nextLine();
		Scanner s = new Scanner(a).useDelimiter("\\s* \\s*");
		System.out.println(s.nextInt()+s.nextInt());
	}
}
