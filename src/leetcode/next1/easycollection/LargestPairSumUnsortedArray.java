package leetcode.next1.easycollection;

/*
https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/

{12,34,10,6,40} is 74
{60,51,42,33,132} is 192
 */

public class LargestPairSumUnsortedArray {
	
	private int maxSum(int nums[]) {
		int maxSum = 0;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSum = Math.max(maxSum, max + nums[i]);
			max = Math.max(max, nums[i]);
		}
		return maxSum;
	}
	

	public static void main(String[] args) {
		System.out.println(new LargestPairSumUnsortedArray().maxSum(new int[] {12,34,10,6,40}));
	}

}
