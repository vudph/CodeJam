package leetcode.recap;

import java.util.ArrayList;
import java.util.List;

/*
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */
public class FindDisappearedNumbers {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
//		boolean appeared[] = new boolean[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			appeared[nums[i]-1] = true;
//		}
//		for (int i = 0; i < appeared.length; i++) {
//			if (!appeared[i]) {
//				System.out.print((i + 1) + ", ");
//				res.add(i+1);
//			}
//		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i]) - 1] > 0)
				nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * (-1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				System.out.print((i + 1) + ", ");
				res.add(i + 1);
			}
		} 
		return res;
	}

	public static void main(String[] args) {
		new FindDisappearedNumbers().findDisappearedNumbers(new int[] {4,3,2,7,8,2,5,1});
	}

}
