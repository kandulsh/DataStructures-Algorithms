package com.learn.queue;

class MultiStack {

	private int[] values;
	private int stackCapacity;
	private int numberOfStacks = 3;
	private int[] size;

	public MultiStack(int capacity) {
		stackCapacity = capacity;
		values = new int[numberOfStacks * capacity];
		size = new int[numberOfStacks];
	}

	public void push(int n, int stackNum) throws Exception {
		if (isFull(stackNum))
			throw new Exception();
		size[stackNum]++;
		int topIndex = topIndex(stackNum);
		values[topIndex] = n;
	}

	public int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum))
			throw new Exception();
		int val = values[topIndex(stackNum)];
		values[topIndex(stackNum)] = 0;
		size[stackNum]--;
		return val;

	}

	public boolean isEmpty(int stackNum) {
		return size[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return size[stackNum] == stackCapacity;
	}

	public int topIndex(int stackNum) {
		int offset = stackNum * stackCapacity;
		int currentSize = size[stackNum];
		return offset + currentSize - 1;
	}

	public void printValues(int stackNum) {
		int offset = stackNum * stackCapacity;
		int currsize = size[stackNum];
		for (int i = 0; i < currsize; i++) {
			System.out.print(values[offset + i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		MultiStack s = new MultiStack(4);
		s.push(1, 0);
		s.push(1, 0);
		s.push(1, 0);
		s.push(1, 0);
		s.pop(0);
		s.push(1, 1);
		s.push(2, 1);
		s.push(3, 1);
		
		s.printValues(1);
		System.out.println(s.topIndex(0));

	}

}
