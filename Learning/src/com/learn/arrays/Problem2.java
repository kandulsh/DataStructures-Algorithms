package com.learn.arrays;

import java.util.Arrays;

public class Problem2 {
	
	public static String sort(String s) {
		char[] charArr=s.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}

	public static boolean  isPermutation(String s1,String s2) {
		return sort(s1).contentEquals(sort(s2));
	}

	public static void main(String[] args) {
		String s1="abc";
		String s2="cba";
		System.out.println(isPermutation(s1,s2));
		
	}

}
