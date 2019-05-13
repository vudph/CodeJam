package leetcode.recap;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
	public int rob(TreeNode root) {
		Map<TreeNode, Integer> cache = new HashMap<>();
		int max = grab(root, cache);
		return max;
	}
	
	private int grab(TreeNode node, Map<TreeNode, Integer> cache) {
		if (cache.containsKey(node)) {
			System.out.println("hit " + node.val + ", v: " + cache.get(node));
			cache.get(node);
		}
		if (node == null)
			return 0;
		int val = 0;
		if (node.left != null) {
			val += grab(node.left.left, cache) + grab(node.left.right, cache);
		}
		if (node.right != null) {
			val += grab(node.right.left, cache) + grab(node.right.right, cache);
		}
		int res = Math.max(node.val + val, grab(node.left, cache) + grab(node.right, cache));
		cache.put(node, res);
		return res;
	}

	public static void main(String[] args) {
		HouseRobberIII h = new HouseRobberIII();
		TreeNode root = new TreeNode(4);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(5);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
		
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
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
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}
	
}