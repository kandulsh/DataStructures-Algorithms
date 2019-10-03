package com.learn.linkedLists;

public class Problem7 {

	public static LinkedList l1;
	public static LinkedList l2;

	public static Node findIntersection(Node n1, Node n2) {
		int l1 = findLength(n1);
		int l2 = findLength(n2);
		int diff = l1 > l2 ? l1 - l2 : l2 - l1;
		Node longer = l1 > l2 ? n1 : n2;
		Node smaller = l1 > l2 ? n2 : n1;

		while (diff > 0) {
			longer = longer.next;
			diff--;
		}

		while (longer != smaller) {
			longer = longer.next;
			smaller = smaller.next;
		}
		return longer;

	}

	public static int findLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
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
		l2 = new LinkedList();
		Node n1 = new Node(9);
		l1.head = n1;
		n1.next = new Node(7);
		n1.next.next = new Node(8);
		Node n2 = new Node(6);
		l2.head = n2;
		n2.next = n1.next;

		printList(l1.head);
		printList(l2.head);
		Node intersection = findIntersection(l1.head, l2.head);
		printList(intersection);
	}

}
