package com.learn.first;

public class MergeSort {

	void merge(int[] arr, int l, int h, int m) {
		int n1 = m - l + 1;
		int n2 = h - m;
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			temp1[i] = arr[l + i];
		}
		for (int i = 0; i < n2; i++) {
			temp2[i] = arr[m + 1 + i];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (temp1[i] < temp2[j]) {
				arr[k++] = temp1[i++];
			} else {
				arr[k++] = temp2[j++];
			}
		}

		while (i < n1) {
			arr[k++] = temp1[i++];
		}

		while (j < n2) {
			arr[k++] = temp2[j++];
		}

	}

	void mergeSort(int[] arr, int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, h);
			merge(arr,l,h,m);

		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 90, 30, 30, 50, 50, 90 };
		MergeSort m = new MergeSort();
		m.mergeSort(arr, 0, arr.length - 1);
		for(int x:arr) {
			System.out.println(x);
		}
	}

}
