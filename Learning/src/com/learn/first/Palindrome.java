package com.learn.first;

public class Palindrome {

	 void sum(int a,int b){System.out.println(a+b);}  
	  void sum(long a,int b){System.out.println(a+b+"k");}  

	public static void main(String[] args) {
		Palindrome p=new Palindrome();
		  p.sum(20,20);//now second int literal will be promoted to long  
		  p.sum(20,20);
		
	}

}
