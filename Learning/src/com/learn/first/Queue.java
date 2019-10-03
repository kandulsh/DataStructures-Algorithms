package com.learn.first;

import java.util.Stack;

public class Queue {

	Stack s1=new Stack<Integer>();
	Stack s2=new Stack<Integer>();
	
	public void enQueue(int d) {
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(d);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int deQueue() {
		if(s1.isEmpty()) {
			return 0;
		}
		return (int) s1.pop();
		
	}
	
	public void printElements() {
		while(!s1.isEmpty()) {
			System.out.println(s1.pop());
			
		}
	}
	
	public static void main(String[] args) {
		Queue q=new Queue();
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		//System.out.print(q.deQueue());
		q.printElements();
	}
	
}
