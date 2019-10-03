package com.learn.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BuildOrder {

	HashMap<Integer, List<Integer>> graph;

	public void buildGraph(int[] projects, int[][] dependencies) {
		graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < dependencies.length; i++) {
			int key = dependencies[i][0];
			int value = dependencies[i][1];
			if (graph.containsKey(key))
				graph.get(key).add(value);
			else {
				List<Integer> list = new LinkedList<Integer>();
				list.add(value);
				graph.put(key, list);
			}
		}
	}

	public boolean dfsUtil(int value, Stack<Integer> stack, Set<Integer> visited, boolean[] recSet) {
		if (recSet[value])
			return false;
		if (!visited.contains(value)) {
			recSet[value] = true;
			visited.add(value);
			List<Integer> children = graph.get(value);
			if (children != null) {
				for (int child : children) {
					if (!dfsUtil(child, stack, visited, recSet)) {
						return false;
					}
				}

			}
			recSet[value] = false;
			stack.push(value);
		}
		return true;
	}

	public Stack<Integer> findOrder(int[] projects) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		boolean[] recSet = new boolean[projects.length];
		for (int i = 0; i < projects.length; i++) {
			if (!visited.contains(i)) {
				if (!dfsUtil(projects[i], stack, visited, recSet)) {
					return null;
				}
			}

		}
		return stack;

	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.println(entry.getKey() + "----->" + entry.getValue());
		}
	}

	public static void main(String[] args) {
		BuildOrder b = new BuildOrder();
		int[] projects = { 0, 1, 2, 3, 4, 5 };
		int[][] dependencies = { { 0, 3 }, { 5, 1 }, { 1, 3 }, { 5, 0 }, { 3, 2 }, { 1, 0 }, { 0, 5 } };
		b.buildGraph(projects, dependencies);
		b.printGraph();
		Stack<Integer> s = b.findOrder(projects);
		int len = s.size();
		if (s == null)
			System.out.println("There is a cycle");
		for (int i = 0; i < len; i++) {
			System.out.print(s.pop() + " ");
		}

	}

}
