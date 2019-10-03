package com.learn.arrays;

// It takes up space though time is 0(mXn)
public class Problem8 {

	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[row].length; j++) {
			matrix[row][j] = 0;
		}
	}

	public static void nullifyCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void zeroMatrix(int[][] arr) {
		boolean[] row = new boolean[arr.length];
		boolean[] col = new boolean[arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(arr, i);
			}
		}
		for (int j = 0; j < col.length; j++) {
			if (col[j]) {
				nullifyCol(arr, j);
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
		int[][] imageArr = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		printMatrix(imageArr);
		zeroMatrix(imageArr);
		System.out.println("*******************");
		printMatrix(imageArr);

	}

}
