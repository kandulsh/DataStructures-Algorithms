package com.learn.graph;

public class Node {
	String value;
	Node[] adjacentNodes;
	int adjacentCount;
	boolean visited;

	public Node(String val, int adjC) {
		value = val;
		adjacentNodes = new Node[adjC];
		visited = false;
	}

	public void addAdjacent(Node n) {
		if (adjacentCount < adjacentNodes.length) {
			adjacentNodes[adjacentCount] = n;
			adjacentCount++;
		} else {
			System.out.println("No more neighbors can be added");
		}
	}

	public Node[] getNeighbors()
	{
		return adjacentNodes;
	}
}
