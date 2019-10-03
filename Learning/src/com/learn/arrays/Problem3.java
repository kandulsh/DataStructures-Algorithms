package com.learn.arrays;

public class Problem3 {

	public static void URLify(char[] s, int len) {
		int fullLen = s.length;
		for (int i = len - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[fullLen - 1] = '2';
				s[fullLen - 2] = '%';
				s[fullLen - 3] = '0';
				fullLen = fullLen - 3;
			} else {
				s[fullLen - 1] = s[i];
				fullLen--;
			}

		}
	}

	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] ch = str.toCharArray();
		URLify(ch, 13);
		for (char c : ch) {
			System.out.print(c);
		}

	}

}
