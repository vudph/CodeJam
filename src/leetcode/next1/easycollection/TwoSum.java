package leetcode.next1.easycollection;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			int tmp = target - nums[i];
			if (seen.containsKey(tmp)) {
				return new int[] {seen.get(tmp), i};
			}
			seen.put(nums[i], i);
		}
        return new int[2];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
