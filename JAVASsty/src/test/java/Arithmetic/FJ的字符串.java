package Arithmetic;

import java.util.*;
public class FJ的字符串 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(dg(scanner.nextInt()));
	}	
	static String dg(int n)
	{
		if(n==1)
		{
			return "A";
		}
		else {
			return dg(n-1)+(char)('A'+n-1)+dg(n-1);
		}
	}
}
