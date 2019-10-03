package com.learn.arrays;

import sun.font.CreatedFontTracker;

public class Problem4 {

	public static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int ch = Character.getNumericValue(c);
		if (ch >= a && ch <= z) {
			return ch - a;
		}
		return -1;

	}

	public static int[] createFreqTable(String s) {
		int[] freqCount = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : s.toCharArray()) {
			int index = getCharNumber(c);
			if (index != -1)
				freqCount[index]++;
		}
		return freqCount;
	}

	public static boolean isaPalindrome(String s) {
		int[] count = createFreqTable(s);
		boolean foundOdd = false;
		for (int n : count) {
			System.out.println(n);
			if (n % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isaPalindrome("Taco Cat"));
	}
}
