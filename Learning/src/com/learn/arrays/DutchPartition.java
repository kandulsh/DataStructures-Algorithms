package com.learn.arrays;

public class DutchPartition {

	public static int[] partition(int[] arr, int pivot) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (mid <= end)
			if (arr[mid] < pivot) {
				int temp = arr[start];
				arr[start++] = arr[mid];
				arr[mid++] = temp;
			} else if (arr[mid] == pivot) {
				mid++;
			} else {
				int temp = arr[end];
				arr[end--] = arr[mid];
				arr[mid] = temp;
			}
		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, -1, -3, 5, -100, 10, 120, 9, 99, 0 };
		partition(arr, 5);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

}
