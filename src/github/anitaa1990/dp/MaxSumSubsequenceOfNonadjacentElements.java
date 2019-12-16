package github.anitaa1990.dp;

/*
https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
 */
public class MaxSumSubsequenceOfNonadjacentElements {
	//5, 5, 10, 100, 10, 5
	//5, 5, 15, 105, 
	private int findMaxSum(int arr[]) {
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[1];
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1] - arr[i - 1] + arr[i]);
		}
		
		return Math.max(dp[arr.length - 2], dp[arr.length - 1]);
	}

	public static void main(String[] args) {
		System.out.println(new MaxSumSubsequenceOfNonadjacentElements().findMaxSum(new int[] {2,1,1,3,4, 5,1, 1, 2, 2, 4, 5, 5, 3, 3, 1, 4}));
	}

}
