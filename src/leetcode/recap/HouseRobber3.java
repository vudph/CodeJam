package leetcode.recap;

import java.util.HashMap;
import java.util.Map;

/*
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

 */
public class HouseRobber3 {

	public int rob(TreeNode root) {
		Map<TreeNode, Integer> cache = new HashMap<>();
		int r = helper(root, cache);
		return r;
	}

	private int helper(TreeNode node, Map<TreeNode, Integer> cache) {
		if (cache.containsKey(node)) {
			System.out.println("hit " + node.val + ": " + cache.get(node));
			return cache.get(node);
		}
		if (node != null) {
			int m1 = node.val;
			if (node.left != null) {
				m1 += helper(node.left.left, cache) + helper(node.left.right, cache);
			}
			if (node.right != null) {
				m1 += helper(node.right.left, cache) + helper(node.right.right, cache);
			}
			int m2 = helper(node.left, cache) + helper(node.right, cache);
			int m = Math.max(m1, m2);
			cache.put(node, m);
			return m;
		}
		return 0;
	}

	public static void main(String[] args) {
//		int a[] = {3,4,5,1,3,null,1};
		
		HouseRobber3 h = new HouseRobber3();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.right.right = new TreeNode(1);
		System.out.println(h.rob(root));

	}

}
