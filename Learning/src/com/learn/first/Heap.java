package com.learn.first;

public class Heap {

	public static void buildHeap(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i+1]-arr[i]==2) {
				System.out.println(arr[i]+1);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 5 };
		buildHeap(arr);
	}

}
