package leetcode.next1;

/* Refer to https://leetcode.com/discuss/interview-question/365872/
	60,51,42,33,132 => (60 + 132) = 192

 */

public class LargestPairSum {
	
	public int sumPair(int nums[]) {
		int currentMax = nums[0];
		int maxSum = currentMax;
		for (int i = 1; i < nums.length; i++) {
			maxSum = Math.max(maxSum, currentMax + nums[i]);
			currentMax = Math.max(currentMax, nums[i]);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(new LargestPairSum().sumPair(new int[] {60,51,42,33,132}));
	}

}
