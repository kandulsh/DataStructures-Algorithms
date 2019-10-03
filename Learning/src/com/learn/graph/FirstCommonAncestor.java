package com.learn.graph;

//In a BTree
//In a Binary search tree
//https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
public class FirstCommonAncestor {

	boolean v1 = false;
	boolean v2 = false;

	public TreeNode FCA(TreeNode a, TreeNode b, TreeNode root) {
		if (root == null)
			return null;
		TreeNode temp = null;
		if (root.val == a.val) {
			temp = root;
			v1 = true;
		}
		if (root.val == b.val) {
			temp = root;
			v2 = true;
		}
		if (temp != null)
			return temp;

		TreeNode left = FCA(a, b, root.left); // else iterate left
		TreeNode right = FCA(a, b, root.right); // iterate right
		if (left != null && right != null) { // If both are true then we found our partition
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		return left != null ? left : right;

	}

	public TreeNode FCABST(TreeNode a, TreeNode b, TreeNode root) {
		if (root == null)
			return null;
		int min = a.val < b.val ? a.val : b.val;
		int max = a.val < b.val ? b.val : a.val;
		if (root.val < min) { // If root is less than min, its less than both then iterate right
			return FCABST(a, b, root.right);
		} else if (root.val > max) { // If root is greater than than max its greater than both so iterate left
			return FCABST(a, b, root.left);
		} else {
			return root;
		}
	}

	public int LengthOfLargestBSTinBT(TreeNode root, Boolean isBst, int size, int min, int max) {
		if (root == null) {
			isBst = true;
			return 0;
		}
		int minV = 0;
		boolean left_flag = false; // Max of left tree must be less than root.
		boolean right_flag = false; // Min of right must be greater

		int ls, rs;// store the size of left and right subtrees
		max = Integer.MIN_VALUE;
		ls = LengthOfLargestBSTinBT(root.left, isBst, size, min, max);
		if (isBst && root.val > max) {
			left_flag = true;

		}
		minV = min;
		min = Integer.MAX_VALUE;
		rs = LengthOfLargestBSTinBT(root.right, isBst, size, min, max);
		if (isBst && root.val < min) {
			right_flag = true;
		}
		if (minV < min) {
			min = minV;
		}
		if (root.val < min) {
			min = root.val;
		}
		if (root.val > max) {
			max = root.val;
		}
		if (left_flag && right_flag) {
			if (ls + rs + 1 > size) {
				size = ls + rs + 1;
			}
			return size;
		} else {
			isBst = false;
			return 0;
		}

	}

}
