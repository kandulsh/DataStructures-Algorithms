package com.learn.linkedLists;

import java.util.Stack;

public class Problem6 {

	public static LinkedList l1;

	public static boolean isPalindrome(Node head) {
		Stack<Integer> s1 = new Stack<Integer>();
		Node n = head;
		while (head != null) {
			s1.push(head.data);
			head = head.next;
		}
		while (n != null) {
			if (n.data != s1.pop()) {
				return false;
			}
			n = n.next;
		}
		return true;

	}

	public static boolean isPalindrome2(Node head) {
		Stack<Integer> s1 = new Stack<Integer>();
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			s1.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != s1.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;

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
		Node n1 = new Node(9);
		l1.head = n1;
		n1.next = new Node(7);
		n1.next.next = new Node(9);
		printList(l1.head);
		System.out.println(isPalindrome2(l1.head));
	}
}
