package com.learn.dp;

// Time complextity would be O(m*n)

//Space complexity would be O(m*n)

public class LongestCommonSubSting {

	public static void answer(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] LCS = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);// for longest common subsequence
				}
			}
		}
		int index = LCS[m][n];
		System.out.println(index);
		StringBuilder sb = new StringBuilder();
		while (m > 0 && n > 0) {
			if (LCS[m][n] > Math.max(LCS[m - 1][n], LCS[m][n - 1])) {
				sb.append(s1.charAt(m - 1));
				m--;
				n--;
			} else if (LCS[m - 1][n] > LCS[m][n - 1]) {
				m--;
			} else {
				n--;
			}
		}
		System.out.println(sb.reverse().toString());
	}

	public static void main(String[] args) {
		String X = "OldSite:GeeksforGeeks.org";
		String Y = "Gemeks";
		answer(X, Y);
	}

}
