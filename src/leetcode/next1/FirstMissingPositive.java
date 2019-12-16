package leetcode.next1;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array, find the smallest missing positive integer.

Input: [1,2,0]
Output: 3

Input: [3,4,-1,1]
Output: 2

Input: [7,8,9,11,12]
Output: 1

Input: []
Output: 1

Input: [0]
Output: 1

Input: [1,2,2,11,12]
Output: 3

Input: [1,2,2,2,2]
Output: 3


3,4,-1,1

 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
//        Set<Integer> seen = new HashSet<>();
//        for (int i : nums) {
//			seen.add(i);
//		}
//        for (int i = 1; i <= nums.length + 1; i++) {
//        	if (!seen.contains(i))
//        		return i;
//        } 
//        return 1;
//		boolean seen[] = new boolean[nums.length];
//		for (int n : nums) {
//			if (n > 0 && n <= nums.length ) {
//				seen[n - 1] = true;
//			}
//		}
//		for (int i = 0; i < seen.length; i++) {
//			if (!seen[i]) {
//				return i + 1;
//			}
//		}
//		
//		return seen.length + 1;
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] <= 0 ? Integer.MAX_VALUE : nums[i];
		}
		for (int n : nums) {
			if (n != Integer.MAX_VALUE && n != (Integer.MAX_VALUE * (-1)) && Math.abs(n) <= nums.length) {
				nums[Math.abs(n) - 1] = Math.abs(nums[Math.abs(n) - 1]) * (-1);
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				return i + 1;
		}
		
		return nums.length + 1;
		
    }

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {3,4,2,1}));
	}

}
