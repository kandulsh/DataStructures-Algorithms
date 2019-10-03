package com.learn.arrays;

public class Problem1 {

	public static boolean isUnique(String input) {
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(input.indexOf(charArray[i],i)!=-1)
					return false;
		}
		return true;

	}

	public static void main(String[] args) {
		String s = "abade";
		System.out.println(isUnique(s));
		String S="";
		System.out.println(S.length());

	}

}
