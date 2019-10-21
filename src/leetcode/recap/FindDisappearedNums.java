package leetcode.recap;

import java.util.ArrayList;
import java.util.List;

/*
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */
public class FindDisappearedNums {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
//		boolean flags[] = new boolean[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			flags[nums[i] - 1] = true;
//		}
//		for (int i = 0; i < flags.length; i++) {
//			if (!flags[i])
//				res.add(i + 1);
//		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i]) - 1] > 0) {
				nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * (-1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		new FindDisappearedNums().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
	}
}
