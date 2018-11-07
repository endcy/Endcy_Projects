package com.enums;

import java.util.Scanner;

public class isthirty {

	public int[] getarr(int jz) {
		int arxx[] = new int[8];
		String t = "";
		int arxr[] = new int[] { 1, 3, 5, 7, 9, 11, 13, 15 };
		for (int i = 0; i < 8; i++) {
			t = changex(arxr[i], jz);
			arxx[i] = Integer.parseInt(t);
		}
		return arxx;
	}

	public String changex(int n, int r) {
		String number = "";
		boolean flag = true;
		flag = true;
		if (n < 0) {
			flag = false;
			n = -n;
		}
		while (n != 0) {
			int f = n % r;
			if (f >= 10) {
				number += (char) (f - 10 + 'A');
			} else {
				number += (char) (f + '0');
			}
			n /= r;
		}
		StringBuffer sb = new StringBuffer(number);
		sb = sb.reverse();
		if (!flag)
			return "-";
		return sb.toString();
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 3, 5, 7, 9, 11, 13, 15 };
		int x = arr.length;
		for (int i = 0; i < x; i++)
			for (int j = 0; j < x; j++)
				for (int k = 0; k < x; k++) {
					if (arr[i] + arr[j] + arr[k] == 30) {
						System.out.println(arr[i] + "+" + arr[j] + "+" + arr[k]
								+ "=30");
						break;
					}
				}
		System.out.println("十进制无解！");
		
	}
}
