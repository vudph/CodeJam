package leetcode.dp;
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
		if (nums.length == 0)
			return 0;
		int dp[] = new int[nums.length];
		dp[0] = 1;
		int maxLen = 1;
		for(int i = 1; i < nums.length; i++) {
			int currMaxLen = 1;
			for (int j = i-1; j >= 0; j--) {
				if (nums[j] < nums[i])
					currMaxLen = Math.max(currMaxLen, dp[j] + 1);
			}
			dp[i] = currMaxLen;
			maxLen = Math.max(maxLen, currMaxLen);
		}
		return maxLen;
    }

	public static void main(String[] args) {
		int nums[] = {4,10,4,11,8,9};//{10,9,2,5,3,4};
//		7,2,2,2,2,1,3,0,4,2,5,7,6,8
//		1,1,1,1,1,1,2,2,3,3,4,5,5,6
		
//		4,10,4,11,8,9
//		1, 2,1, 3,3,4

//		4,10,4,3,8,9
//		1, 2,1,1,3,4
		
//		1,3,6,7,9,4,10,5,6
//		1,2,3,4,5,3, 6,4,5
		
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(nums));
	}

}
