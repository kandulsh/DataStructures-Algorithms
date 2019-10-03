package com.learn.SortandSearch;

public class SearchInRotatedSortedArray {

	public static int search(int[] arr, int low, int high, int val) {
		// if (low > high)
		// return -1;
		// int p = (low + high) / 2;
		// if (arr[p] > arr[p + 1])
		// return p + 1;
		// else if (arr[p] < arr[low]) {
		// return search(arr, low, p - 1);
		// } else {
		// return search(arr, p + 1, high);
		// }

		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == val)
			return mid;
		else if (arr[low] > arr[mid]) {
			if (val > arr[mid] && val <= arr[high]) {
				return search(arr, mid + 1, high, val);
			} else {
				return search(arr, low, mid - 1, val);
			}
		} else {
			if (val >= arr[low] && val < arr[mid]) {
				return search(arr, low, mid - 1, val);
			} else {
				return search(arr, mid + 1, high, val);
			}
		}

	}

	public static int findELement(int[] arr, int val) {
		int pivot = search(arr, 0, arr.length - 1, val);
		return pivot;
		// if (pivot == -1) {
		// binarySearch(arr, 0, arr.length - 1, val);
		// }
		// if (arr[pivot] == val)
		// return pivot;
		// if (val >= arr[0]) {
		// return binarySearch(arr, 0, pivot - 1, val);
		// } else {
		// return binarySearch(arr, pivot, arr.length - 1, val);
		// }

	}

	public static int binarySearch(int[] arr, int low, int high, int val) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == val)
			return mid;
		else if (val > arr[mid]) {
			return binarySearch(arr, mid + 1, high, val);
		} else {
			return binarySearch(arr, low, mid - 1, val);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		System.out.println(findELement(arr, 9));
	}

}
