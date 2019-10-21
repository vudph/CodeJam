package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

public class BestTimeSellBuy {
	
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minEle = prices[0];
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minEle) {
				minEle = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minEle);
			}
		}
        return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(new BestTimeSellBuy().maxProfit(new int[] {7,6,4,3,1}));
	}

}
