package leetcode.next1.easycollection;

import java.util.HashSet;
import java.util.Set;

/*
 https://leetcode.com/problems/contains-duplicate/

Input: [1,2,3,1]
Output: true

Input: [1,2,3,4]
Output: false

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class ContainsDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] == nums[j])
//					return true;
//			}
//		}
//		return false;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i]))
				return true;
//			if (set.size() < i + 1)
//				return false;
		}
		return false;
    }

	public static void main(String[] args) {
		System.out.println(new ContainsDuplicate().containsDuplicate(new int[] {1,2,3,4}));
	}

}
