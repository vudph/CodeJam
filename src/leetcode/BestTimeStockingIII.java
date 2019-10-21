package leetcode;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


1,2,3,6,2,7 => |2-6| + |2-7| = 9, |1-6| + |2-7| = 10
1,1,3,-4,5

1,2,3,6,2,7,1,2,9,4,1,4,9
1,1,3,-4,5,-6,1,7,-5,-3,3,5

1,3,4,6,9
2,1,2,3
 */

public class BestTimeStockingIII {
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		return twoPass(prices);
    }
	
	private int twoPass(int prices[]) {
//		prices: 1,2,4,2,5,7,2,4,9,0
//		trans1: 0,1,3,3,4,6,6,6,8,8
//		trans2: 8,7,7,7,7,7,7,5,0,0
		
//		prices: 1,2,3,4,5,6
//		trans1: 0,1,2,3,4,5
//		trans2: 5,4,3,2,1,0
		
		int[] trans1 = new int[prices.length];
		int min = Integer.MAX_VALUE;
		int maxTrans = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			maxTrans = Math.max(maxTrans, prices[i] - min);
			trans1[i] = maxTrans;
		}
		
		int[] trans2 = new int[prices.length];
		int max = Integer.MIN_VALUE;
		maxTrans = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			maxTrans = Math.max(maxTrans, max - prices[i]);
			trans2[i] = maxTrans;
		}
		int total = trans2[0];
		for (int i = 0; i < prices.length - 1; i++) {
			total = Math.max(total, trans1[i] + trans2[i+1]);
		}
        return total;
	}
	
	private int bruteforce(int prices[]) {
		int diff[] = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++) {
			diff[i - 1] = prices[i] - prices[i - 1];
		}
		int maxProfit = 0;
		int len = prices.length;
		for (int l = 1; l < len; l++) {
			int maxDiff1 = maxDifference(prices, 0, l + 1);
			int maxDiff2 = maxDifference(prices, l, len);
			maxProfit = Math.max(maxProfit, maxDiff1 + maxDiff2);
		}
		return maxProfit;
	}
	
	private int maxDifference(int nums[], int l, int r) {
		int maxDiff = 0;
		int min = nums[l];
		for (int i = l + 1; i < r; i++) {
			min = Math.min(min, nums[i]);
			maxDiff = Math.max(maxDiff, nums[i] - min);
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		System.out.println(new BestTimeStockingIII().maxProfit(new int[] {1,2,3,4,5}));
		System.out.println(new BestTimeStockingIII().maxDifference(new int[] {2,1,10,6,4,8,1}, 0, 7));
	}

}
