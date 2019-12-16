package leetcode.next1;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 
 */
public class ConvertSortedArrayToBST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int l, int r) {
		if (l > r)
			return null;
		int mid = l + ((r - l) / 2);
		System.out.println(nums[mid]);
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, l, mid - 1);
		root.right = helper(nums, mid + 1, r);
		
		return root;
		
		/*
		 -10,-3,0,5,9
		       0
		      / \
		    -10  5
		      \   \
		      -3   9
		      
		  0,1,2,3,4,5,6,7,8,9,10
		              
		  5 2 0 1 3 4 8 6 7 9 10
		  
		              5
		            /   \
		           /     \ 
                  2       8
		         / \     / \   
		        0   3   6   9
		         \   \   \   \
		          1   4   7  10
		 
		 
		 
		 */
	}

	public static void main(String[] args) {
		TreeNode n = new ConvertSortedArrayToBST().sortedArrayToBST(new int[] {0,1,2,3,4,5,6,7,8,9,10});
		System.out.println();
	}

}
