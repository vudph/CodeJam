package leetcode.next1.easycollection.tree;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/balanced-binary-tree/

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

 */
public class IsBalancedBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
//      3
//     / \
//    9  20
//   /  /  \
//  1  15   7
//    /    / \
//   10   8   11
	
	// bottom up
	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}
	
	private int height(TreeNode node) {
		if (node == null)
			return 0;
		int h1 = height(node.left);
		if (h1 == -1)
			return -1;
		int h2 = height(node.right);
		if (h2 == -1)
			return -1;
		if (Math.abs(h1 - h2) > 1)
			return -1;
		int h = Math.max(h1, h2) + 1;
//		System.out.println("node " + node.val + ": " + h);
		return h;
	}
	
	Map<TreeNode, Integer> map = new HashMap<>();

	// top down O(nlogn) => recalculate height of node when tree is balanced 
	public boolean isBalancedTopDown(TreeNode root) {
		return balancedHelper(root);
    }

	private boolean balancedHelper(TreeNode node) {
		if (node == null) 
			return true;
		int lh = heightTopDown(node.left);
		int rh = heightTopDown(node.right);
		
		if (Math.abs(lh - rh) <= 1 && balancedHelper(node.left) && balancedHelper(node.right))
			return true;
		return false;
	}

	private int heightTopDown(TreeNode node) {
		return heightHelper(node);
	}

	private int heightHelper(TreeNode node) {
		if (node == null)
			return 0;
		if (map.containsKey(node)) {
//			System.out.println("hit -- node " + node.val + ": " + map.get(node));
			return map.get(node);
		}
		int h = Math.max(heightHelper(node.left) + 1, heightHelper(node.right) + 1);
		map.put(node, h);
//		System.out.println("node " + node.val + ": " + h);
		return h;
	}
	
	public static void main(String[] args) {
//	     3
//	    / \
//	   9  20
//	  /  /  \
//	 1  15   7
//	   /    / \
//	  10   8   11
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(10);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(11);
		System.out.println(new IsBalancedBinaryTree().isBalancedTopDown(root));
//		node 1: 1
//		node 9: 2
//		node 10: 1
//		node 15: 2
//		node 8: 1
//		node 11: 1
//		node 7: 2
//		node 20: 3
//		node 1: 1
//		node 10: 1
//		node 15: 2
//		node 8: 1
//		node 11: 1
//		node 7: 2
//		node 10: 1
//		node 8: 1
//		node 11: 1
		
//		System.out.println(new IsBalancedBinaryTree().isBalanced(root));
	}

}
