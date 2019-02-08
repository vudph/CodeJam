package leetcode;
/*
 https://leetcode.com/problems/longest-increasing-subsequence/
 Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int finalLongest = 1;
		int dp[] = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int currLongest = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					currLongest = Math.max(currLongest, dp[j] + 1);
				}
			}
			dp[i] = currLongest;
			finalLongest = Math.max(finalLongest, currLongest);
		}
		
		return finalLongest;
    }

	public static void main(String[] args) {
		int nums[] = {7,2,2,2,2,1,3,0,4,2,5,7,6,8};//{10,9,2,5,3,4};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(nums));
	}

}
