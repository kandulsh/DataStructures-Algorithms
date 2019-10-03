package com.learn.queue;

import java.util.Stack;

public class MyQueue<T> {

	public Stack<T> oldStack, newStack;

	MyQueue() {
		oldStack = new Stack<T>();
		newStack = new Stack<T>();
	}

	public int size() {
		return oldStack.size() + newStack.size();
	}

	public void add(T n) {
		newStack.push(n);
	}

	public T remove() {
		shiftStacks();
		return oldStack.pop();
	}

	public T peek() {
		shiftStacks();
		return oldStack.peek();
	}

	public void shiftStacks() {
		if (oldStack.isEmpty()) {
			while (!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}

}
