package com.learn.arrays;

public class Problem6 {

	public static String stringCompression(String input) {
		StringBuilder compressedStr = new StringBuilder();
		int countCompressed = 0;
		for (int i = 0; i < input.length(); i++) {
			countCompressed++;
			if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
				compressedStr.append(input.charAt(i));
				compressedStr.append(countCompressed);
				countCompressed = 0;
			}
		}
		return compressedStr.length() >= input.length() ? input : compressedStr.toString();
	}

	public static void main(String[] args) {
		String input = "adda";
		System.out.println(stringCompression(input));
	}
}
