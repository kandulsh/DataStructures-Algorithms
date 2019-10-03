package com.learn.linkedLists;

public class Problem4 {

	public static LinkedList l1 = null;

	public static Node partition(Node head, int pivot) {
		Node n1, n2, temp1, temp2;
		n1 = new Node(0);
		n2 = new Node(0);
		temp1 = n1;
		temp2 = n2;
		Node temp = head;
		while (temp != null) {
			if (temp.data < pivot) {
				n1.next = new Node(temp.data);
				n1 = n1.next;
			} else {
				n2.next = new Node(temp.data);
				n2 = n2.next;
			}
			temp = temp.next;
		}
		n1.next = temp2.next;
		return temp1.next;

	}

	public static void partition2(Node head, int pivot) {
		Node n1 = null;
		Node n2 = null;
		Node temp = head;
		while (temp != null) {
			Node nextNode = temp.next;
			if (temp.data < pivot) {
				temp.next = n1;
				n1 = temp;
			} else {
				temp.next = n2;
				n2 = temp;
			}
			temp = nextNode;
		}
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
		n1.next.next = new Node(6);
		n1.next.next.next = new Node(5);
		n1.next.next.next.next = new Node(10);
		n1.next.next.next.next.next = new Node(0);
		n1.next.next.next.next.next.next = new Node(8);

		printList(l1.head);
		Node ans = partition(l1.head, 5);
		printList(ans);
	}
}
