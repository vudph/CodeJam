package leetcode;

import java.util.ArrayList;
import java.util.List;

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
		int max[] = new int[1];
		max[0] = 0;
		return postorder(root, max);
	}
	
	private int postorder(TreeNode node, int max[]) {
		if (node != null) {
			int l = postorder(node.left, max);
			int r = postorder(node.right, max);
			max[0] = Math.max(node.val, (l + r));
//			System.out.print(max + ", ");
			return max[0];
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