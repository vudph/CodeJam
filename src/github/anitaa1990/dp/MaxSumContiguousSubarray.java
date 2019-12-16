package github.anitaa1990.dp;

/*
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

{-2, -3, 4, -1, -2, 1, 5, -3} => 7 = 4 + (-1) + (-2) + 1 + 5

 */
public class MaxSumContiguousSubarray {
	
	private int findMaxSum(int nums[]) {
		int maxSum = nums[0];
		int currMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currMax = Math.max(currMax + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currMax);
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSumContiguousSubarray().findMaxSum(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
	}

}
