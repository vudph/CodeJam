package basic.windowsliding;

/*
https://www.geeksforgeeks.org/window-sliding-technique/
Given an array of integers of size ‘n’.
Our aim is to calculate the maximum sum of ‘k’ 
consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

*/
public class MaxSum {
	
	private static int findMaxSum(int a[], int k) {
		if (k > a.length)
			throw new IllegalArgumentException();
		int maxSum = 0;
		// brute force => O(n*k)
//		for (int i = 0; i < a.length - k + 1; i++) {
//			int sum = a[i];
//			for (int j = i + 1; j < i + k; j++) {
//				sum += a[j];
//			}
//			maxSum = Math.max(sum, maxSum);
//		}
		//window sliding => O(n)
		for (int i = 0; i < k; i++) {
			maxSum += a[i];
		}
		
		int windowsSum = maxSum; 
		for (int i = k; i < a.length; i++) {
			windowsSum = (windowsSum + a[i]) - a[i - k];
			maxSum = Math.max(windowsSum, maxSum);
		}
		
		return maxSum;
	}
	public static void main(String[] args) {
		int a[] = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(findMaxSum(a, 4));
	}

}
