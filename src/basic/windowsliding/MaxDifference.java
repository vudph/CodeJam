package basic.windowsliding;

/*
 https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
Input : arr = {2, 3, 10, 6, 4, 8, 1} => diff[] = {1, 7, -4, -2, 4, -7}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

{2, 3, 10, 0, 4, 9, 1} => 9
1, 7, -10, 4, 5, -8

*/

public class MaxDifference {
	
	private static int findMaxDiff(int a[]) {
		int maxDiff = Integer.MIN_VALUE;
//		//brute force => O(n*(n-1))
//		for (int i = 0; i < a.length - 1; i++) {
//			int s = a[i];
//			for (int j = i + 1; j < a.length; j++) {
//				s = a[j] - a[i];
//				maxDiff = Math.max(s, maxDiff);
//			}
//		}
		// hold min element and update max diff accordingly: O(n)
		int minEle = a[0];
		for (int i = 1; i < a.length; i++) {
			minEle = Math.min(minEle, a[i]);
			maxDiff = Math.max(maxDiff, a[i] - minEle);
		}
		return maxDiff == 0 ? -1 : maxDiff;
		
		//window sliding
//		int diff[] = new int[a.length - 1]; 
//        for (int i = 0; i < a.length - 1; i++) 
//            diff[i] = a[i + 1] - a[i]; 
//  
//        // Now find the maximum sum subarray in diff array 
//        int max_diff = diff[0]; 
//        for (int i = 1; i < a.length - 1; i++)  
//        { 
//            if (diff[i - 1] > 0)  
//                diff[i] += diff[i - 1]; 
//            if (max_diff < diff[i]) 
//                max_diff = diff[i]; 
//        } 
//        return max_diff; 
        //[1, 7, -10, 4, 5, -8]
        //[1, 8, -2, 4, 9, 1]
	}
	
	public static void main(String[] args) {
		int a[] = {10,8,7,6,-5};
		
		System.out.println(findMaxDiff(a));
	}
}
