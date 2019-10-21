package leetcode;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

 */
public class BestTimeStockingII {
	
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int diff[] = new int[prices.length - 1];
        int k = 0;
        for(int i = 1; i < prices.length; i++) {
            diff[k++] = prices[i] - prices[i-1];
        }
        int maxProfit = 0;
        for(int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                maxProfit += diff[i];
            }
        }
        return maxProfit;
    }

	public static void main(String[] args) {
		System.out.println(new BestTimeStockingII().maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
	}

}
