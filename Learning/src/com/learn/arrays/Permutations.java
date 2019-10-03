package com.learn.arrays;

public class Permutations {
	
	static void printPerm(String s,String ans) {
		if(s.length()==0) {
			System.out.print(ans+ " ** ");
			return ;
		}
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			String sub=s.substring(0,i)+s.substring(i+1);
			printPerm(sub, ans+ch);
		}
	}

	public static void main(String[] args) {
			String s="abc";
			printPerm(s, "");
			System.out.println(s.substring(3));
			}

}
