package basic.windowsliding;

/*
 https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

{2, 3, 10, 0, 4, 9, 1} => 9

*/

public class MaxDifference {
	
	private static int findMaxDiff(int a[]) {
		int maxDiff = 0;
		//brute force => O(n*(n-1))
//		for (int i = 0; i < a.length - 1; i++) {
//			int s = a[i];
//			for (int j = i + 1; j < a.length; j++) {
//				s = a[j] - a[i];
//				maxDiff = Math.max(s, maxDiff);
//			}
//		}
		// O(n)??
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		int a[] = {2, 3, 10, 0, 4, 9, 1};
		System.out.println(findMaxDiff(a));
	}
}
