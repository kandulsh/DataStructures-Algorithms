package com.learn.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1IsPath {

	public static boolean findPath(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			return false;
		}
		if (n1.equals(n2)) {
			return true;
		}
		Queue<Node> q = new LinkedList<Node>();
		n1.visited = true;
		q.add(n1);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			Node[] adjList = temp.getNeighbors();
			for (Node n : adjList) {
				if (!n.visited) {
					n.visited = true;
					if (n.equals(n2)) {
						return true;
					}
					q.add(n);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		System.out.println(findPath(g.Nodes[0], g.Nodes[4]));
	}

}
