package com.learn.first;

public class QuickSort {

	public int partition(int[] array, int low, int high) {
		int i = low;
		for (int j = low; j < high; j++) {
			if (array[j] < array[high]) {
				if (i != j) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
				i++;
			}

		}
		int temp=array[high];
		array[high]=array[i];
		array[i]=temp;
		return i;
	}

	public void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int index = partition(array, low, high);
			System.out.print(index+" ");
			 quickSort(array, low, index - 1);
			 quickSort(array, index + 1, high);

		}
	}

	public void printList(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int[] array = { 10, 90, 30, 30, 50, 50, 90 };
		QuickSort q = new QuickSort();
		q.quickSort(array, 0, array.length - 1);
		q.printList(array);
	}

}
