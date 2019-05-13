package leetcode.recap;
/*
 
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

 */
public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int longestLength = 1;
		int dp[] = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int tmplen = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					tmplen = Math.max(tmplen, 1 + dp[j]);
				}
			}
			dp[i] = tmplen;
			longestLength = Math.max(tmplen, longestLength);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + ", ");
		}
		System.out.println();
		return longestLength;
	}

	public static void main(String[] args) {
		int nums[] = {10,9,2,5,3,7,101,18};
//		int nums[] = {10,9,2,5,3,4};
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}

}
