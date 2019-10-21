package leetcode;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimeStockingI {
	
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxDiff = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            maxDiff = Math.max(maxDiff, prices[i] - buy);
        }
        return maxDiff;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
