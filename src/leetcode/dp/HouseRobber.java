package leetcode.dp;
/*
https://leetcode.com/problems/house-robber/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 4, 1, 1, 4
 4, 1, 5, 8
 
 2,7, 9, 3, 1
 2,7,11,10,12
 
 2,1,1,2,3,2, 5, 5, 8,10
 2,1,3,4,6,6,11,11,19,21
 */
public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];        
//        int max1 = nums[0];
//        int max2 = nums[1];
//        for (int i = 2; i < nums.length; i++) {
//        	int tmp = max2;
//			max2 = Math.max(max2 - nums[i - 1] + nums[i], max1 + nums[i]);
//			max1 = tmp;
//		}
//        System.out.println(Math.max(max1, max2));
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] - nums[i-1] + nums[i], dp[i-2] + nums[i]);
		}
        return Math.max(dp[dp.length-2], dp[dp.length-1]);
	}

	public int robdp(int nums[]) {
		if (nums.length == 0) return -1;
		if (nums.length == 1) return nums[0];
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1] - nums[i-1] + nums[i]);
		}
		return Math.max(dp[dp.length - 2], dp[dp.length - 1]);
	}
	
	public static void main(String[] args) {
		//2,1,1,3,4, 5,1, 1, 2, 2, 4, 5, 5, 3, 3, 1, 4
		//2,1,3,5,7,10,8,11,12,13,16,18,21,21,24,22,28
		System.out.println(new HouseRobber().robdp(new int[] {2,1,1,3,4, 5,1, 1, 2, 2, 4, 5, 5, 3, 3, 1, 4}));
	}

}
