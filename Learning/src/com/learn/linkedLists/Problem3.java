package com.learn.linkedLists;

public class Problem3 {

	public static LinkedList l1 = null;

	public static void findMiddleDelete(Node head) {
		Node ptr1 = head;
		Node ptr2 = head;
		Node prev = null;
		while (ptr2 != null && ptr2.next != null) {
			prev = ptr1;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		prev.next = ptr1.next;
	}

	public static void delete(Node n) {
		if (n == null || n.next == null)
			return;
		Node temp = n.next;
		n.data = temp.data;
		n.next = temp.next;

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
		findMiddleDelete(l1.head.next.next);
		printList(l1.head);
	}
}
