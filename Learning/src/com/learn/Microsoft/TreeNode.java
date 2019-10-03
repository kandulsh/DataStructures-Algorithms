package com.learn.Microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.sun.org.apache.xml.internal.security.Init;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode next;

	TreeNode(int data) {
		this.data = data;
	}

	public static boolean isBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int min = Integer.MIN_VALUE;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.data < min) {
				return false;
			}
			min = root.data;
			root = root.right;

		}
		return true;
		// return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validateBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.data <= min || root.data > max) {
			return false;
		}
		return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
	}

	public static void InOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		InOrder(root.left, list);
		System.out.print(root.data + " ");
		list.add(root.data);
		InOrder(root.right, list);
	}

	public static void findSwapped(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		InOrder(root, list);
		int x = -1;
		int y = -1;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				y = list.get(i + 1);
				if (x == -1)
					x = list.get(i);

			}
		}
		swapNode(root, x, y, 2);
		InOrder(root, list);

	}

	public static void swapNode(TreeNode root, int x, int y, int count) {
		if (root == null)
			return;
		if (root.data == x || root.data == y) {
			root.data = root.data == x ? y : x;
			if (count-- == 0)
				return;
		}
		swapNode(root.left, x, y, count);
		swapNode(root.right, x, y, count);
	}

	public static void LevelOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode m = q.remove();
			if (m != null) {
				if (m.left != null) {
					q.add(m.left);
				}
				if (m.right != null) {
					q.add(m.right);
				}
				m.next = q.peek();
			} else if (!q.isEmpty()) {
				q.add(null);
			}

		}
	}

	public static TreeNode LCA(TreeNode root, int a, int b) {
		if (root == null)
			return null;
		if (root.data == a || root.data == b) {
			return root;
		}
		TreeNode left = LCA(root.left, a, b);
		TreeNode right = LCA(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		return left == null ? right : left;

	}

	public static void isHeightBalanced(TreeNode Node) {

	}

	public static boolean hasPathSum(TreeNode node, int target) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null) {
			if (node.data == target)
				return true;
			else {
				return false;
			}
		}
		boolean left = hasPathSum(node.left, target - node.data);
		boolean right = hasPathSum(node.right, target - node.data);
		return left || right;

	}
	
	public static void TopView(TreeNode root) {
		if(root==null) {
			return;
		}
		
		
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		root2.right.right.left = new TreeNode(8);

		System.out.println(isBST(root));
		// LevelOrderTraversal(root2);
		// findSwapped(root);

		System.out.println(hasPathSum(root, 8));
	}

}
