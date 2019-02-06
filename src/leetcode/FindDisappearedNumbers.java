package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */
public class FindDisappearedNumbers {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        // need O(n) space
//        boolean appears[] = new boolean[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//			appears[nums[i] - 1] = true;
//		}
//        for (int i = 0; i < nums.length; i++) {
//			if (!appears[i])
//				res.add(i + 1);
//		}
        for (int i = 0; i < nums.length; i++) {
        	if (nums[Math.abs(nums[i]) - 1] > 0)
        		nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * (-1);
		}
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				res.add(i + 1);
		}
        return res;
    }

	public static void main(String[] args) {
		new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

}
