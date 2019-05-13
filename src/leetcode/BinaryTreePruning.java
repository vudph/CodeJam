package leetcode;
/*
https://leetcode.com/problems/binary-tree-pruning/

 */

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
    	return prunning(root);
    }

	private TreeNode prunning(TreeNode node) {
		if (node == null)
			return null;
		node.left = prunning(node.left);
		node.right = prunning(node.right);
		if (node.val == 0 && node.left == null && node.right == null)
			return null;
		return node;
	}
	
	public static void main(String[] args) {
		BinaryTreePruning tree = new BinaryTreePruning();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		TreeNode res = tree.pruneTree(root);
		System.out.println();
	}
}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//	
//	@Override
//	public String toString() {
//		return Integer.toString(val);
//	}
//}