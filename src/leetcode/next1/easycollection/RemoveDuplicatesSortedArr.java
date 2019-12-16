package leetcode.next1.easycollection;

import java.util.Arrays;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, [0,1,2,3,4,*,*,*,*,*], e.g. [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]

0,1,1,1,1,2,2,3,3,4
0,1,2,1,1,2,2,3,3,4

 */
public class RemoveDuplicatesSortedArr {

	public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
        	if (nums[i] != nums[j]) {
        		nums[++i] = nums[j];
        	}
		}
        nums = Arrays.copyOf(nums, i + 1);
        return i + 1;
    }
	
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesSortedArr().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}

}
