package leetcode.recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

 */
public class LargestNumber {

	static class LargerNumber implements Comparable<LargerNumber> {
		int val;

		public LargerNumber(int val) {
			this.val = val;
		}

		public int compareTo(LargerNumber obj) {
			long num1 = Long.parseLong(Integer.toString(val) + Integer.toString(obj.val));
			long num2 = Long.parseLong(Integer.toString(obj.val) + Integer.toString(val));
			return (int) (num2 - num1);
		}

		@Override
		public String toString() {
			return Integer.toString(val);
		}
	}

	public String largestNumber(int[] nums) {
		int j = 0;
		while (j < nums.length && nums[j] == 0) {
			j++;
		}
		if (j == nums.length) {
			return "0";
		}
		List<LargerNumber> listOfNums = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			listOfNums.add(new LargerNumber(nums[i]));
		}
		Collections.sort(listOfNums);
		StringBuilder sb = new StringBuilder();
		for (LargerNumber largerNumber : listOfNums) {
			sb.append(largerNumber);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new LargestNumber().largestNumber(new int[] {3,30,34,5,9}));
	}

}
