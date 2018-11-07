package com.sortway;

import java.util.Random;

public class Sort {

	/**
	 * @param arr
	 */
	public static void Printarr(int arr[]) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] Creatarr(int arr[]) {
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(50);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] maopao = new int[10];
		maopao = Creatarr(maopao);
		Printarr(maopao);
		System.out.println("\n---after MPsort---");
		MPsort(maopao);
		Printarr(maopao);
		System.out.println("\n");

		int[] xuanze = new int[10];
		xuanze = Creatarr(xuanze);
		Printarr(xuanze);
		System.out.println("\n---after XZsort---");
		XZsort(xuanze);
		Printarr(xuanze);
		System.out.println();

	}

	private static void XZsort(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
	}

	private static void MPsort(int[] arr) {
		int temp = 0;
		for (int i = arr.length - 1; i > 0; --i) {
			for (int j = 0; j < i; j++) {
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
