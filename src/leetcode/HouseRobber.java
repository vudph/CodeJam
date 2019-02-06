package leetcode;
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
             
 */
public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];        

        int finalMax = nums[0];
        
        for (int offset = 2; offset < nums.length; offset++) {
			for (int i = 2; i < nums.length; i += offset) {
				
			}
		}
        
        for (int i = 2; i < nums.length; i++) {
        	int currMax = nums[0];
			for (int j = i; j < nums.length; j += i) {
				currMax += nums[j];
			}
			finalMax = Math.max(finalMax, currMax);
		}
        return finalMax;
	}

	public static void main(String[] args) {
		new HouseRobber().rob(new int[] {2,1,1,3,4,5,1,1,2,2,4,5,5,3,3,1,4});
	}

}
