package com.learn.linkedLists;

import java.util.HashSet;

public class DeleteDup {

	public static void deleteDup(Node head) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node temp = head;
		Node prev = null;
		while (temp != null) {
			if (set.contains(temp.data)) {
				prev.next = temp.next;
			} else {
				set.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}
	}
	
	
	public static void printList(Node list) {
		if (list == null) {
			System.out.println("List is empty");
			return;
		}
		while (list != null) {
			System.out.print(list.data + " -->");
			list = list.next;
		}
		System.out.println("NULL");

	}

	public static void main(String[] args) {
		Node n1 = new Node(0);
		Node head = n1; // Java is strictly pass by value
		for (int i = 1; i < 10; i++) {
			Node n = new Node(i % 2);
			n1.next = n;
			n1 = n1.next;
		}
		printList(head);
		deleteDup(head);
		printList(head);
	}

}
