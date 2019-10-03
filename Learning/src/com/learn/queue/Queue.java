package com.learn.queue;

import java.util.NoSuchElementException;

//Queue can be implemented using a linkedlist if insertion and deletion happen at opposite ends.
//It implements FIFO ordering
//Add elements to end and remove elements from front
//We maintain two references one to head and one to end
//add,remove,peek,isEmpty
//BFS & Implementing cache
public class Queue<T> {
	Node<T> head;
	Node<T> end;

	static class Node<T> {
		T data;
		Node<T> next;

		Node(T val) {
			data = val;
		}
	}

	public void add(T n) {
		Node<T> newNode = new Node<T>(n);
		if (end != null) {
			end.next = newNode;
		}
		end = newNode;
		if (head == null) {
			head = end;
		}

	}

	public T remove() {
		if (head == null) {
			System.out.println("Queue is empty");
			throw new NoSuchElementException();
		}
		T removedElement = head.data;
		head = head.next;
		if (head == null) {
			end = null;
		}
		return removedElement;

	}

	public boolean isEmpty() {
		return head == null;
	}

	public T peek() {
		if (head == null) {
			System.out.println("No element in queue");
			throw new NoSuchElementException();
		}
		return head.data;
	}

	public void printQ(Node<T> head) {
		while (head != null) {
			System.out.print(head.data + " --> ");
			head = head.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i < 6; i++) {
			q.add(i);
		}
		q.printQ(q.head);
		for (int i = 1; i < 5; i++) {
			q.add(q.remove());
		}
		System.out.println(q.isEmpty());
		q.printQ(q.head);

	}

}
