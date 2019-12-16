package leetcode.dp;

/*
https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {
	public int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	int k = 1; //1, 4, 9, 16, 25
        	int min = dp[i - 1] + 1;
			for (int j = 1; k <= i; j++, k = j * j) {				
				min = Math.min(min, dp[i - k] + 1);
			}
			dp[i] = min;
		}
        return dp[n];
		
//		Queue<Integer> q = new LinkedList<>();
//		Set<Integer> visited = new HashSet<>();
//		q.offer(n);
//		visited.add(n);
//		int depth = 0;
//		while (!q.isEmpty()) {
//			int size = q.size();
//			depth++;
//			while (size-- > 0) {
//				int v = q.poll();
//				for (int i = 1; i * i <= v; i++) {
//					int k = v - i * i;
//					if (k == 0) {
//						return depth;
//					}
//					if (!visited.contains(k)) {
//						q.offer(k);
//						visited.add(k);
//					}
//				}
//			}
//		}
//		return depth;
    }
	
	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(13));
	}
}
