package leetcode.recap;
// 4, 1, 1, 4 => 8
// 2, 7, 9, 3, 1 => 12

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
//		dp[2] = Math.max(nums[2] + dp[0], dp[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(Math.max(nums[i] + dp[i-2], nums[i] + (dp[i-1] - nums[i-1])), dp[i-1]);
		}
		return Math.max(dp[nums.length-2], dp[nums.length-1]);
	}

	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[]{4, 1, 1, 4}));
	}

}
