package com.learn.arrays;

public class Problem5 {

	public static boolean isOneAwayV1(String s1, String s2) {
		int[] freqCount = new int[26];
		int count = 0;
		String in = s1 + s2;
		for (char ch : in.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				freqCount[ch - 'a']++;
				if (freqCount[ch - 'a'] % 2 == 1) {
					count++;
				} else {
					count--;
				}
			}

		}

		return count <= 2;
	}

	public static boolean isOneEditReplace(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		boolean foundDiff = false;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
			index1++;
			index2++;
		}
		return true;
	}

	public static boolean isOneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		boolean result = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (result) {
					return false;
				}
				result=true;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static boolean isOneAwayV2(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return isOneEditReplace(s1, s2);
		} else if (s1.length() + 1 == s2.length()) {
			return isOneEditInsert(s1, s2);
		} else if (s1.length() - 1 == s2.length()) {
			return isOneEditInsert(s2, s1);
		}

		return false;
	}

	public static void main(String[] args) {
		String s1 = "park";
		String s2 = "per";
		System.out.println(isOneAwayV2(s1, s2));
	}

}
