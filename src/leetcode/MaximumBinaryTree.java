package leetcode;
/*
https://leetcode.com/problems/maximum-binary-tree/
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 */
public class MaximumBinaryTree {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode node = contruct(nums, 0, nums.length - 1);
        return node;
    }
	
	private TreeNode contruct(int[] nums, int l, int r) {
		if (l < 0 || r < 0 || r < l)
			return null;
		int max = nums[l];
		int idxMax = l;
		for (int i = l; i <= r; i++) {
			if (nums[i] > max) {
				max = nums[i];
				idxMax = i;
			}
		}
//		System.out.println("(" + max + "," + idxMax + ")");
		TreeNode node = new TreeNode(max);
		node.left = contruct(nums, l, idxMax - 1);
		node.right = contruct(nums, idxMax + 1, r);
		return node;
	}

	public static void main(String[] args) {
		MaximumBinaryTree t = new MaximumBinaryTree();
		t.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
	}

}
