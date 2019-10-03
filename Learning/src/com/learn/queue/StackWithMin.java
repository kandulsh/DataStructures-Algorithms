package com.learn.queue;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
	Stack<Integer> s1;

	StackWithMin() {
		s1 = new Stack<Integer>();
	}

	public void push(int value) {
		super.push(value);
		if (value <= min()) {
			s1.push(value);
		}
	}

	public Integer pop() {
		int element = super.pop();
		if (element == min()) {
			s1.pop();
		}
		return element;
	}

	public int min() {
		if (s1.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s1.peek();
		}
	}

	public static void main(String[] args) {
	}

}
