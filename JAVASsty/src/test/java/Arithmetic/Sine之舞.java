package Arithmetic;

import java.util.*;
public class Sine之舞{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		sc.close();
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			// �������An
			StringBuilder A = new StringBuilder();
			for (int j = 1; j <= i; j++)
				A.append("sin(" + j + (j % 2 == 0 ? "+" : "-"));
			A.delete(A.length() - 1, A.length());
			for (int j = 1; j <= i; j++)
				A.append(")");
			// �������Sn
			result.append(A.toString() + "+" + (n - i + 1) + ")");
			if (i < n)
				result.insert(0, "(");
		}

		System.out.println(result.delete(result.length() - 1, result.length()));
	}
}