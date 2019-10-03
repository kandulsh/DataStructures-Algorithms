package com.learn.queue;

import java.util.Stack;

public class SortStack {

	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		while (!r.isEmpty()) {
			s.push(r.pop());
		}

	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			st.push(i % 2);
		}
		sort(st);
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

}
