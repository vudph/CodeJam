package leetcode.next1;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

 */

public class LongestCommonSubarray {

	public int findLength(int[] A, int[] B) {
		int longest = 0;
//		int dp[][] = new int[A.length + 1][B.length + 1];
//		for (int i = 0; i < dp.length; i++) {
//			Arrays.fill(dp[i], 0);
//		}
//
//		for (int i = 1; i <= B.length; i++) {
//			for (int j = 1; j <= A.length; j++) {
//				if (A[j - 1] == B[i - 1]) {
//					dp[i][j] = dp[i - 1][j - 1] + 1;
//					longest = Math.max(longest, dp[i][j]);
//				}
//			}
//		}

		int dp[] = new int[A.length + 1];
		Arrays.fill(dp, 0);
		for (int i = 1; i <= B.length; i++) {
			for (int j = A.length; j >= 1; j--) {
				if (A[j - 1] == B[i - 1]) {
					dp[j] = dp[j - 1] + 1;
					longest = Math.max(longest, dp[j]);
				} else {
					dp[j] = 0;
				}
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(
				new LongestCommonSubarray().findLength(new int[] { 0, 1, 1, 1, 1 }, new int[] { 1, 0, 1, 0, 1 }));
	}

}
