package com.learn.linkedLists;

// Time complexity is O(list1.length+l2.length)
public class Problem5 {
	public static LinkedList l1 = null;
	public static LinkedList l2 = null;

	public static Node sum(Node l1, Node l2) {
		Node n1 = reverse(l1);
		Node n2 = reverse(l2);
		Node ans = new Node(0);
		Node dup = ans;
		int carry = 0;
		while (n1 != null || n2 != null) {
			int sum = ((n1 == null ? 0 : n1.data) + (n2 == null ? 0 : n2.data) + carry);
			carry = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			ans.next = new Node(sum);
			n1 = n1 == null ? n1 : n1.next;
			n2 = n2 == null ? n2 : n2.next;
			ans = ans.next;
		}

		if (carry > 0) {
			ans.next = new Node(1);
		}
		return reverse(dup.next);

	}

	public static Node reverse(Node listHead) {
		Node curr = listHead;
		Node next = null;
		Node prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		n2.next = new Node(8);
		n2.next.next = new Node(5);
		printList(l1.head);
		printList(l2.head);
		Node sumA = sum(l1.head, l2.head);
		printList(sumA);
	}

}
