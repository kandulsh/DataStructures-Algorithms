package com.learn.first;

public class QuickSort2 {

	public static void sort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0: {
				int temp = arr[mid];
				arr[mid++] = arr[low];
				arr[low++] = temp;
				break;
			}
			case 1:
				mid++;
				break;
			case 2:
				int temp = arr[mid];
				arr[mid++] = arr[high];
				arr[high--] = temp;

			}
		}

	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sort(arr);
		for (int x : arr) {
			System.out.println(x);
		}
	}

}
