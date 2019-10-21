package leetcode.next1.easycollection;
/*
https://leetcode.com/problems/maximum-subarray/
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {
	
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int currentMax = maxSum;
		for (int i = 1; i < nums.length; i++) {
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currentMax);
		}
		return maxSum;
    }

	public static void main(String[] args) {
		System.out.println(new MaxSubArray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4, 10}));
	}

}
