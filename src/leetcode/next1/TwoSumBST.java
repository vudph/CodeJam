package leetcode.next1;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/two-sum-bsts/

 */
public class TwoSumBST {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		Set<Integer> seen = new HashSet<>();
		fillSeen(seen, root1);
		return traverse(seen, root2, target);
	}

	private boolean traverse(Set<Integer> seen, TreeNode node, int target) {
		if (node == null)
			return false;
		if (seen.contains(target - node.val))
			return true;
		return traverse(seen, node.left, target) || traverse(seen, node.right, target);
		
//		if (node != null) {
//			if (!traverse(seen, node.left, target) && !traverse(seen, node.right, target)) {
//				return seen.contains(target - node.val);
//			} else {
//				return true;
//			}
//		}
//		return false;
	}

	private void fillSeen(Set<Integer> seen, TreeNode node) {
		if (node != null) {
			fillSeen(seen, node.left);
			fillSeen(seen, node.right);
			seen.add(node.val);
		}
	}

	public static void main(String[] args) {
		TwoSumBST t = new TwoSumBST();
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(0);
		root2.right = new TreeNode(3);
		
		System.out.println(t.twoSumBSTs(root1, root2, 7));
	}

}
