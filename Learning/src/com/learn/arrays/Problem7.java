package com.learn.arrays;

/**
 * 
 * 
 * @author Susmitha Kandula
 *
 *         Find transpose of matrix. Reverse columns of the transpose - For anti
 *         clock wise rotation of 90 degrees Reverse rows of the transpose -For
 *         clockwise rotation of 90 degrees
 */

public class Problem7 {

	public static void rotateClockWise(int[][] arr) {
		if (arr.length == 0 || arr.length != arr[0].length)
			return;
		int N = arr.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
       				int temp = arr[i][j]; // Save current element
				arr[i][j] = arr[N - j - 1][i]; // Left to top
				arr[N - j - 1][i] = arr[N - i - 1][N - j - 1]; // Bottom to left
				arr[N - i - 1][N - j - 1] = arr[j][N - i - 1]; // top to bottom
				arr[j][N - i - 1] = temp; // left to right

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
		rotateClockWise(imageArr);
		System.out.println("*******************");
		printMatrix(imageArr);

	}

}
