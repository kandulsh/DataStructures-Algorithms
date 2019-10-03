package com.learn.linkedLists;

public class Problem2 {
	public static LinkedList l1 = null;

	public static int findLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static Node KthNode(Node head, int k) {
		Node temp = head;
		int len = findLength(head);
		if (k > len)
			return null;
		for (int i = 0; i < len - k; i++) {
			temp = temp.next;
		}
		return temp;
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

	public static void push(int val) {
		Node n = new Node(val);
		if (l1.head == null) {
			l1.head = n;
			return;
		}
		n.next = l1.head;
		l1.head = n;
	}

	public static void main(String[] args) {
		l1 = new LinkedList();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = arr.length - 1; i >= 0; i--) {
			push(arr[i]);
		}
		printList(l1.head);
		Node nodeK = KthNode(l1.head, 0);
		 System.out.println(nodeK.data);
	}

}
