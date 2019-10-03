package com.learn.recursionDP;

import java.util.Stack;

public class TowersOfHanoi {

	public static void moveStacks(int n, Stack<Integer> source, Stack<Integer> Destination, Stack<Integer> Buffer) {
		if (n <= 0)
			return;
		moveStacks(n - 1, source, Buffer, Destination);
		Destination.push(source.pop());
		moveStacks(n - 1, Buffer, Destination, source);
	}

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		for (int i = 10; i >= 1; i--) {
			s1.push(i);
		}
		Stack<Integer> destination = new Stack<Integer>();
		Stack<Integer> Buffer = new Stack<Integer>();
		moveStacks(10, s1, destination, Buffer);
		System.out.println(destination);
	}

}
