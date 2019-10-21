package leetcode.recap;

import leetcode.TreeNode;

public class BinaryTreePruning {
	
	public TreeNode pruneTree(TreeNode root) {
    	return prunning(root);
    }

	private TreeNode prunning(TreeNode node) {
		if (node != null) {
			node.left = prunning(node.left);
			node.right = prunning(node.right);
			if (node.val == 0 && (node.left == null && node.right == null)) {
				return null;
			}
			return node;
		}
		return null;
	}

	public static void main(String[] args) {
		BinaryTreePruning tree = new BinaryTreePruning();
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		TreeNode res = tree.pruneTree(root);
		System.out.println();
	}

}
