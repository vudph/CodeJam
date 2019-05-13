package leetcode.recap;
/*
https://www.geeksforgeeks.org/maximum-subarray-sum-using-prefix-sum/

 */
public class MaximumSubarray {
	
	public int maxSumSubarray(int a[]) {
		int currMax = a[0];
		int finalMax = currMax;
		for (int i = 1; i < a.length; i++) {
			currMax = Math.max(currMax + a[i], a[i]);
			finalMax = Math.max(finalMax, currMax);
		}
		return finalMax;
	}
	
	public int maxSumSubarrayByPrefixSumArray(int a[]) {
		int finalMax = Integer.MIN_VALUE;
		int prefixSum[] = new int[a.length];
		prefixSum[0] = a[0];
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i-1] + a[i];
		}
		//[-2, -5, -1, -2, -4, -3, 2, -1]
		int minPrefixSum = 0;
		for (int i = 0; i < a.length; i++) {
			finalMax = Math.max(finalMax, prefixSum[i] - minPrefixSum);
			minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
		}
		
		return finalMax;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSumSubarrayByPrefixSumArray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
	}

}
