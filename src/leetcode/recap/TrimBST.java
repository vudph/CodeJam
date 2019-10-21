package leetcode.recap;

import leetcode.TreeNode;

/*
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
public class TrimBST {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		TreeNode t = trim(root, L, R);
		return t;
	}
	
	private TreeNode trim(TreeNode node, int L, int R) {
		if (node != null) {
			node.left = trim(node.left, L, R);
			node.right = trim(node.right, L, R);
			if (node.val < L) {
				return node.right;
			} else if (node.val > R) {
				return node.left;
			} else {
				return node;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TrimBST bst = new TrimBST();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		TreeNode t = bst.trim(root, 1, 3);
		System.out.println();
	}

}
