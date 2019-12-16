package leetcode.next1;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserializeBST {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = postorder(root, new StringBuilder());
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private StringBuilder postorder(TreeNode node, StringBuilder sb) {
		if (node != null) {
			postorder(node.left, sb);
			postorder(node.right, sb);
			sb.append(node.val + ",");
		}
		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;
		LinkedList<String> nums = new LinkedList<String>(Arrays.asList(data.split(",")));

		return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
	}

	public TreeNode helper(Integer lower, Integer upper, LinkedList<String> nums) {
		if (nums.isEmpty())
			return null;
		int val = Integer.valueOf(nums.getLast());
		if (val < lower || val > upper)
			return null;
		nums.removeLast();
		TreeNode root = new TreeNode(val);
		root.right = helper(val, upper, nums);
		root.left = helper(lower, val, nums);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.left.left = new TreeNode(2);
		root1.left.right = new TreeNode(4);
		root1.right = new TreeNode(7);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(8);
		root1.right.right.right = new TreeNode(9);

		SerializeDeserializeBST s = new SerializeDeserializeBST();
		System.out.println(s.serialize(root1));

		TreeNode r = s.deserialize("2,4,3,6,9,8,7,5");
		System.out.println();
	}

}
