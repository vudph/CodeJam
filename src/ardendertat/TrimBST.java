package ardendertat;

import leetcode.TreeNode;

public class TrimBST {

	public TreeNode trimBST(TreeNode root, int min, int max) {
		return trim(root, min, max);
	}
	
	private TreeNode trim(TreeNode node, int min, int max) {
		if (node == null) return null;
		node.left = trim(node.left, min, max);
		node.right = trim(node.right, min, max);
		if (node.val < min) {
			return node.right;
		} else if (node.val > max) {
			return node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		TrimBST bst = new TrimBST();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		TreeNode t = bst.trim(root, 5, 13);
		System.out.println();
	}

}
