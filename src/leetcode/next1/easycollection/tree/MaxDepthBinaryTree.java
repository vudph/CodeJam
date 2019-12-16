package leetcode.next1.easycollection.tree;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

    3
   / \
  9  20
 /  /  \
2  15   7
       / \
      8   10 
 */
public class MaxDepthBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		return helper(root);
    }
	
	private int helper(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(helper(node.left) + 1, helper(node.right) + 1);
	}
	
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode node, long max, long min) {
        if (node == null) return true;
        if (node.val < max && node.val > min && helper(node.left, node.val, min) && helper(node.right, max, node.val)) {
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(10);
		
		System.out.println(new MaxDepthBinaryTree().maxDepth(root));
		System.out.println(Integer.MAX_VALUE);
//		2147483647
//		2147483647
	}

}
