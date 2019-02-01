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
		//brute force
		for (int i = 0; i < nums.length - 1; i++) {
			int currentLongest = 1;
			int maxTmp = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					if (nums[j] > maxTmp) {
						currentLongest++;
					} else {
						maxTmp = nums[j];
					}
				}
				finalLongest = Math.max(finalLongest, currentLongest);
			}
		}
		return finalLongest;
    }

	public static void main(String[] args) {
		int nums[] = {10,9,2,5,3,7,101,18};//{10,9,2,5,3,4};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(nums));
	}

}
