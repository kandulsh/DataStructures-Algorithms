package com.learn.linkedLists;

public class Problem21 {

	public static LinkedList l1 = null;
	public static int index = 0;

	public static Node kthElement(Node head, int k) {
		if (head == null) {
			return null;
		}
		Node newNode = kthElement(head.next, k);
		index=index+1;
		if (index == k) {
			System.out.println(head.data);
		}
		return newNode;
	}

	public static void printList(Node list) {
		if (list == null) {
			System.out.println("List is empty");
			return;
		}
		while (list != null) {
			System.out.print(list.data + " --> ");
			list = list.next;
		}
		System.out.println("NULL");

	}

	public static void main(String[] args) {
		l1 = new LinkedList();
		Node n1 = new Node(1);
		l1.head = n1;
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next = new Node(4);
		n1.next.next.next = new Node(5);
		printList(l1.head);
		kthElement(l1.head, 3);
	}

}
