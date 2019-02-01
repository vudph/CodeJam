package leetcode;

import java.util.Arrays;

/*
 https://leetcode.com/problems/find-the-duplicate-number/
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
 */

public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length -1 && nums[i] != nums[i+1])
			i++;
		
		return nums[i];
    }
	
	public static void main(String[] args) {
		System.out.println(2 ^ 2 ^ 2);
	}
}
