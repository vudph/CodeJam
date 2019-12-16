package leetcode.next1.easycollection;
/*
https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/

 */
public class BestTimeBuySellStockII {
	
	public int maxProfit(int[] prices) {
        int suffix[] = new int[prices.length - 1];
        
        for (int i = prices.length - 1; i >= 1; i--)
            suffix[i - 1] = prices[i] - prices[i - 1];
        int profit = 0;
        for (int i = 0; i < suffix.length; i++)
            if (suffix[i] > 0)
                profit += suffix[i];
        return profit;
    }

	public static void main(String[] args) {
		new BestTimeBuySellStockII().maxProfit(new int[] {7, 1, 5, 3, 6, 4});
	}

}
