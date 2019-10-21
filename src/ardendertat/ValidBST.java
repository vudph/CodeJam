package ardendertat;

import leetcode.TreeNode;
/*
      3
     / \
    2   5
   / \
  1   4
*/
public class ValidBST {
	
	public boolean isValidBST(TreeNode root) {
		boolean valid = check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return valid;
	}
	
	private boolean helper(TreeNode node, int min, int max) {
		if (node != null) {
			if (node.val < min || node.val > max) {
				return false;
			}
			boolean v1 = helper(node.left, min, node.val);
			boolean v2 = helper(node.right, node.val, max);
			return v1 && v2;
		}
		return true;
	}
	
	private boolean check(TreeNode node, int min, int max) {
		if (node == null) return true;
		if (node.val > min && node.val < max && check(node.left, min, node.val) && check(node.right, node.val, max)) 
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidBST bst = new ValidBST();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		System.out.println(bst.isValidBST(root));
	}

}
