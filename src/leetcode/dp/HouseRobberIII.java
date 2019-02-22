package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/house-robber-iii/
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
	
	
	public int rob(TreeNode root) {
		List<Integer> h = new ArrayList<>();
//		inorder(root, h);
//		System.out.println();
//		int max1 = h.get(0);
//		int max2 = h.get(1);
//		for (int i = 2; i < h.size(); i++) {
//			int tmp = max2;
//			max2 = Math.max(max1 + h.get(i), (max2 - h.get(i - 1)) + h.get(i));
//			max1 = tmp;
//		}
//		return max1 > max2 ? max1 : max2;

		return bruteForceMemorize(root, new HashMap<>());
	}
	
	private int bruteForce(TreeNode root) {
		if (root != null) {
			int val = 0;
			if (root.left != null) 
				val += bruteForce(root.left.left) + bruteForce(root.left.right);
			if (root.right != null)
				val += bruteForce(root.right.left) + bruteForce(root.right.right);

			return Math.max(root.val + val, bruteForce(root.left) + bruteForce(root.right));
		}
		return 0;
	}
	
	private int bruteForceMemorize(TreeNode root, Map<TreeNode, Integer> map) {
		if (root != null) {
			if (map.containsKey(root))
				return map.get(root);
			int val = 0;
			if (root.left != null) 
				val += bruteForceMemorize(root.left.left, map) + bruteForceMemorize(root.left.right, map);
			if (root.right != null)
				val += bruteForceMemorize(root.right.left, map) + bruteForceMemorize(root.right.right, map);

			int max = Math.max(root.val + val, bruteForceMemorize(root.left, map) + bruteForceMemorize(root.right, map));
			map.put(root, max);
			return max;
		}
		return 0;
	}

	public static void main(String[] args) {
//		int a[] = {3,4,5,1,3,null,1};
		
		HouseRobberIII h = new HouseRobberIII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.right.right = new TreeNode(1);
		System.out.println(h.rob(root));
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}