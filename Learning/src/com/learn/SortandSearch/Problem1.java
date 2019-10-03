package com.learn.SortandSearch;

public class Problem1 {

	public static void merge(int[] arr1, int[] arr2) {
		int total = arr1.length - 1;
		int b = arr2.length - 1;
		int a = total - b - 1;
		while (b >= 0) {
			if (a>=0 && arr1[a] > arr2[b]) {
				arr1[total] = arr1[a];
				a--;
			} else {
				arr1[total] = arr2[b];
				b--;
			}
			total--;
		}

	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 0, 0, 0 };
		int[] arr2 = { 1, 2, 3 };
		merge(arr1, arr2);
		for (int x : arr1) {
			System.out.println(x);
		}

	}

}
