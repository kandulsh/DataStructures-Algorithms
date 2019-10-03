package com.learn.queue;

//It implements LIFO ordering
//One pointer to top (head node)
//Recursive implementations can be done using stack
public class Stack {
	Node top;

	static class Node {
		Node next;
		int data;

		Node(int val) {
			data = val;
		}
	}

	public void push(int n) {
		Node newNode = new Node(n);
		if (top != null) {
			newNode.next = top;
		}
		top = newNode;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("No elements in the Stack");
			return 0;
		}
		int removedElement = top.data;
		top = top.next;
		return removedElement;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return 0;
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void printS(Node top) {
		while (top != null) {
			System.out.print(top.data + " --> ");
			top = top.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		for (int i = 1; i < 6; i++) {
			s.push(i);
		}
		s.printS(s.top);
		for (int i = 1; i < 5; i++) {
			s.push(s.pop());
		}
		System.out.println(s.isEmpty());
		s.printS(s.top);
	}

}
