package github.anitaa1990.dp;

import java.util.Arrays;

public class TotalWayCoinChange {

	private int findTotalWay(int coins[], int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new TotalWayCoinChange().findTotalWay(new int[] {2, 5, 10 }, 13));
	}

}
