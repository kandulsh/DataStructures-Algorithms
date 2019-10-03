package com.learn.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DepthList {

	public static ArrayList<LinkedList<TreeNode>> createListFromTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		curr.add(root);
		while (!curr.isEmpty()) {
			list.add(curr);
			LinkedList<TreeNode> parents = curr;
			curr = new LinkedList<TreeNode>();
			for (TreeNode n : parents) {
				if (n.left != null) {
					curr.add(n.left);
				}
				if (n.right != null) {
					curr.add(n.right);
				}
			}
		}
		return list;
	}

	public static void printList(ArrayList<LinkedList<TreeNode>> list) {
		int depth = 0;
		for (LinkedList<TreeNode> sublist : list) {
			Iterator<TreeNode> itr = sublist.iterator();
			System.out.print("List at depth " + depth + " ");
			while (itr.hasNext()) {
				System.out.print(" -->  "+ itr.next().val);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printList(createListFromTree(root));

	}

}
