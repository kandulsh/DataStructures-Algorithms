package com.learn.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//O(n+k) n is number of input elements and k is range of input
//Can't sort negative elements because of there are no negtive indices.

public class CountingSort {

	public static void sort(int[] arr) {
		int[] countArr = new int[10];
		int[] newArr = new int[arr.length];
		for (int x : arr) {
			countArr[x]++;
		}
		// for(int x:countArr) {
		// System.out.print(x+" ");
		// }
		// System.out.println();
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] = countArr[i] + countArr[i - 1];
		}
		// for(int x:countArr) {
		// System.out.print(x+" ");
		// }

		for (int i = 0; i < arr.length; i++) {
			int pos = countArr[arr[i]]--;
			newArr[pos - 1] = arr[i];

		}

		for (int j = 0; j < newArr.length; j++) {
			arr[j] = newArr[j];
		}

	}

	static void random(int max, int min, int count) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		int i = 0;
		while (i < count) {
			int x = random.nextInt(max - min) + min;
			list.add(x);
		}
	}

	static void power(int n) {
		if(n<0) {
			
		}if(n==1) {
			
		}
		int ans = 1;
		while (ans <= n) {
			System.out.println(ans);
			ans = ans * 2;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 0, 3, 4, 2, 2, 1, 1, 8, 7, 7, 5, 3, 2 };
//		sort(arr);
//		for (int x : arr) {
//			System.out.print(x + " ");
//		}
		power(50);

	}
}
