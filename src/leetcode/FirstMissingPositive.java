package leetcode;

/*
 * https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
            return 1;
//        boolean appears[] = new boolean[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//			if (nums[i] > 0 && nums[i] <= nums.length) {
//				appears[nums[i]] = true;
//			}
//		}
//        for (int i = 1; i < appears.length; i++) {
//			if (!appears[i])
//				return i;
//		}
//        return appears.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i]) > nums.length || Math.abs(nums[i]) == Integer.MAX_VALUE) 
				continue;
			if (nums[Math.abs(nums[i]) - 1] > 0)
				nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * (-1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				return i + 1;
		}
		return nums.length + 1;
    }

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 5, 1, -2, 7}));
		
	}

}
