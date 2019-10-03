package com.learn.first;

import java.util.Stack;

public class LinkedList {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	void push(int nodeVal) {
		Node new_Node = new Node(nodeVal);
		new_Node.next = head;
		head = new_Node;
	}
	

	void pop(Node head) {
		Node prev=null;
		while(head.next!=null) {
			prev=head;
			head=head.next;
		}
		prev.next=null;
	}

	Node reverseLinkedList(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	void printLinkedlist(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	boolean isPalin(Node head) {
		if(head==null) return false;
		if(head.next==null)return true;
		Node temp=head;
		Stack<Node> s=new Stack<Node>();
		while(temp!=null) {
			s.push(temp);
			temp=temp.next;
		}
		while(head!=null) {
			Node n=s.pop();
			if(n.data!=head.data) return false;
			head=head.next;
		}
		return true;
		
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.push(2);
		list.push(3);
		list.printLinkedlist(list.head);
		//list.printLinkedlist(list.reverseLinkedList(list.head));
		//list.pop(list.head);
		System.out.println(" ");
		//list.printLinkedlist(list.head);
		System.out.println(list.isPalin(list.head));
		

	}

}
