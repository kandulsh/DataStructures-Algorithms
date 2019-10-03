package com.learn.graph;

public class BuildTree {

	public static TreeNode buildTree(int[] arr, int l, int h) {
		if (l <= h) {
			int rootValIndex = (l + h) / 2;
			TreeNode root = new TreeNode(arr[rootValIndex]);
			root.left = buildTree(arr, l, rootValIndex - 1);
			root.right = buildTree(arr, rootValIndex + 1, h);
			return root;
		}
		return null;
	}

	public static void InOrder(TreeNode root) {
		if (root != null) {
			InOrder(root.left);
			System.out.print(root.val + " ");
			InOrder(root.right);
		}
	}

	public static boolean isBst(TreeNode root) {
		if (root.left != null) {
			if (root.val < root.left.val || !isBst(root.left)) {
				return false;
			}
		}

		if (root.right != null) {
			if (root.val > root.right.val || !isBst(root.right)) {
				return false;
			}
		}
		return true;
	}

	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	// Empty tree is height balanced
	// non empty tree is balanced if left and right are balanced and if the height
	// difference between heights left subtree and right subtree
	// not greater than 1
	public static int isBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isBalanced(root.left);
		if (left == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		int rightH = isBalanced(root.right);
		if (rightH == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		if (left - rightH > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(left, rightH) + 1;
	}

	public static int maxDepth(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left, max);
		int right = maxDepth(root.right, max);
		int depth = Math.max(left, right) + 1;
		if (depth > max) {
			max = depth;
		}
		return depth;
	}

	public static int depthorlevel(TreeNode root, int val) {
		if (root == null)
			return 0;
		if (root.val == val)
			return 1;
		int left = depthorlevel(root.left, val);
		int right = depthorlevel(root.right, val);
		if (left >= 1) {
			return left + 1;
		} else if (right >= 1) {
			return right + 1;
		}
		return 0;
	}

	public static boolean isPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				return true;
			}else {
				return false;
			}
		}
		if (isPathSum(root.left, sum - root.val)) {
			return true;
		}
		if (isPathSum(root.right, sum - root.val)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = buildTree(arr, 0, arr.length - 1);
		InOrder(root);
		System.out.println(isBst(root) + " " + root.val + " " + height(root));
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		root2.left.left.left = new TreeNode(4);
		root2.left.left.left.left = new TreeNode(5);
		root2.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		isBalanced(root2);
		System.out.println(isBalanced(root2) != Integer.MIN_VALUE);
		int max = maxDepth(root2, 0);
		System.out.println(height(root2));
		System.out.println(max);
		System.out.println(depthorlevel(root2, 1));
		System.out.println(isPathSum(root2, 13));
	}

}
