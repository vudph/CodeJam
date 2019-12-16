package leetcode.next1.easycollection;

import java.util.ArrayList;
import java.util.List;

public class BestTimeBuySellStockIII {
	
	public int maxProfit(int[] prices) {
//        int profit = 0;
//        List<Integer> candidates = new ArrayList<Integer>();
//        int sum = 0;
//        for (int i = 1; i < prices.length; i++) {
//			if (prices[i] >= prices[i - 1]) {
//				sum += prices[i] - prices[i - 1];
//			}
//			if (prices[i] < prices[i - 1] || i == prices.length - 1){
//				if (sum != 0) {
//					candidates.add(sum);
//				}
//				sum = 0;
//			}
//		}
//        if (candidates.size() > 2) {
//        	int max = candidates.get(0);        
//        	for (int i = 1; i < candidates.size(); i++) {
//        		profit = Math.max(profit, max + candidates.get(i));
//        		max = Math.max(max, candidates.get(i));
//			}
//        } else {
//        	profit = candidates.stream().reduce(0, (a, b) -> a + b);
//        }
//        return profit;
//        
////      3,3,5, 0,0,3, 1,4    
////      0,2,-5,0,3,-2,3
//    
////     1, 2, 3, 4, 5
////        1, 1, 1, 1   
//    
////     1, 2, 3, 6, 2, 7
////        1, 1, 3,-4, 5  
//	
////	 	1, 2, 4, 2, 5, 7, 2, 4, 9, 0
////      1, 2,-2, 3, 2,-5, 2, 5,-9  => 13 => failed
		int profit = 0;
		
//		1, 2, 4, 2, 5, 7, 2, 4, 9, 0
//		0, 1, 3, 3, 4, 6, 6, 6, 8, 8 => max diff from left -> right
//		8, 7, 7, 7, 7, 7, 7, 5, 0, 0 => max diff from right -> left
		
		return profit;
    }
    

	
	public static void main(String[] args) {
		System.out.println(new BestTimeBuySellStockIII().maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
	}

}
