package com.learn.graph;

public class Graph {

	int VertexNumber;
	Node[] Nodes;
	int count = 0;

	Graph(int n) {
		VertexNumber = n;
		Nodes = new Node[n];
	}

	public void addNode(Node newNode) {
		if (count < VertexNumber) {
			Nodes[count] = newNode;
			count++;
		} else {
			System.out.println("Graph is full");
		}
	}

	public Node[] getNodes()
	{
		return Nodes;
	}

}
