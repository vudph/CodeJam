package leetcode;

/*
https://leetcode.com/problems/trim-a-binary-search-tree/
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
       
Example 2:       
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
*/
public class TrimBinarySearchTree {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		TreeNode t = trim(root, L, R);
		return t;
	}

	private TreeNode trim(TreeNode node, int l, int r) {
		if (node != null) {
			node.left = trim(node.left, l, r);
			node.right = trim(node.right, l, r);
			if (node.val < l || node.val > r) {
				if (node.right != null)
					return node.right;
				else 
					return node.left;
			}
			return node;
		}
		return null;
	}

	public static void main(String[] args) {
		TrimBinarySearchTree bst = new TrimBinarySearchTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		TreeNode t = bst.trim(root, 1, 2);
		System.out.println();
	}
}
