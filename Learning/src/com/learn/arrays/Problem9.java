package com.learn.arrays;

public class Problem9 {
	
	public static boolean isSubString(String big,String small) {
		if(big.indexOf(small)>=0) {
			return true;
		}
		return false;
	}

	public static boolean isRotation(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return false;
		}
		if (s1.length() == s2.length()) {
			return isSubString(s1+s1, s2);
		}

		return false;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}

}
