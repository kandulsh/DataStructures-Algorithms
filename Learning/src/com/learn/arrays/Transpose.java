package com.learn.arrays;

public class Transpose {

	public static void transpose(int[][] arr) {
		if (arr.length == 0 || arr.length != arr[0].length) {
			return;
		}
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i != j) {
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}

	}

	public static void reverseRows(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int col = arr[i].length;
			for (int j = 0; j < col / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][col - j - 1];
				arr[i][col - j - 1] = temp;
			}
		}
	}

	public static void reverseColumns(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			int row = arr.length;
			for (int j = 0; j < row / 2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[row - 1 - j][i];
				arr[row - 1 - j][i] = temp;
			}
		}
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[][] imageArr = { { 0, 1, 2, 3 }, { 1, 2, 3, 5 }, { 0, 0, 0, 1 }, { 1, 3, 4, 6 } };
		printMatrix(imageArr);
		transpose(imageArr);
		System.out.println("**********");
		printMatrix(imageArr);
		reverseRows(imageArr);
		System.out.println("**********");
		printMatrix(imageArr);
		reverseColumns(imageArr);
		System.out.println("**********");
		printMatrix(imageArr);
	}

}
