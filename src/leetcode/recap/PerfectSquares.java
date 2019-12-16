package leetcode.recap;
/*
Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


n = 14 => 3 (9 + 4 + 1)
 */
public class PerfectSquares {
	
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = dp[i - 1] + 1;
			for (int j = 1, k = 1; j <= i; k++, j = k * k) {
				min = Math.min(min, (i / j) + dp[i % j]);
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(15));
	}

}
