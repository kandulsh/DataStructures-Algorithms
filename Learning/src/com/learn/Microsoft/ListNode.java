package com.learn.Microsoft;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
	int data;
	ListNode next;
	ListNode random;

	ListNode(int data) {
		this.data = data;
		next = null;
		random = null;
	}

	public static ListNode clone(ListNode head) {
		ListNode ptr = head;
		ListNode clone = null;
		Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
		while (ptr != null) {
			if (!map.containsKey(ptr)) {
				map.put(ptr, new ListNode(ptr.data));
			}
			ptr = ptr.next;
		}
		ptr = head;
		while (ptr != null) {
			clone = map.get(ptr);
			clone.next = map.get(ptr.next);
			clone.random = map.get(ptr.random);
			ptr = ptr.next;
		}
		return map.get(head);
	}

	public static void detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			if (fast == slow)
				removeLoop(slow, head);
			slow = slow.next;
			fast = fast.next.next;
		}

	}

	public static void removeLoop(ListNode loop, ListNode head) {
		ListNode ptr1 = loop;
		int k = 1;
		while (ptr1.next != ptr1) {
			k++;
			ptr1 = ptr1.next; // count nodes
		}
		ptr1 = head; // fix head
		ListNode ptr2 = head;
		while (k-- > 0) {
			ptr2 = ptr2.next; // move k nodes
		}
		while (ptr1 != ptr2) { // move at the same pace
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		while (ptr1.next != ptr1) {
			ptr1 = ptr1.next;
		}
		ptr1.next = null; // make next of last node in loop to null

	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.data + "------->");
			if (!(head.random == null)) {
				System.out.print(head.random.data + " ");
			}
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n1.random = n3;
		n2.next = n3;
		n2.random = n4;
		n3.next = n4;
		n3.random = n1;
		n4.random = n2;
		printList(n1);
		printList(clone(n1));

	}

}
