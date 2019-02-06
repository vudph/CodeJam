package leetcode;

/*
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

public class MaxSubArray {
	
	public int maxSubArray(int[] nums) {
		int maxS = nums[0];
		int currMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currMax = Math.max(currMax + nums[i], nums[i]);
			maxS = Math.max(maxS, currMax);
		}
        return maxS;
    }

	public static void main(String[] args) {
		System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

}
