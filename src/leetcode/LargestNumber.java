package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/largest-number/
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

 */

public class LargestNumber {
	static class LargerNumber implements Comparable<LargerNumber> {
		int value;
		public LargerNumber(int val) {
			this.value = val;
		}

		@Override
		public int compareTo(LargerNumber o) {
//			String num0 = Integer.toString(this.value);
//			String num1 = Integer.toString(o.value);
//			int len0 = num0.length();
//			int len1 = num1.length();
//			if (len0 == len1) {
//				return o.value - this.value;
//			}
//			
//			if (len0 > len1) {
//				char ch0 = num1.charAt(0);
//				for (int i = 0; i < len0 - len1; i++) {
//					num1 = num1 + ch0;
//				}
//			} else {
//				char ch0 = num0.charAt(0);
//				for (int i = 0; i < len1 - len0; i++) {
//					num0 = num0 + ch0;
//				}
//			}
//			int num00 = Integer.parseInt(num0);
//			int num11 = Integer.parseInt(num1);
//			if (num00 > num11)
//				return -1;
//			else if (num00 < num11)
//				return 1;
			long tmp0 = Long.parseLong(Integer.toString(this.value) + Integer.toString(o.value));
			long tmp1 = Long.parseLong(Integer.toString(o.value) + Integer.toString(this.value)); 
			return (int) (tmp1 - tmp0);
		}
		
		@Override
		public String toString() {
			return Integer.toString(value); 
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
		StringBuilder sb = new StringBuilder();
		List<LargerNumber> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(new LargerNumber(nums[i]));
		}
		Collections.sort(list);
		for (LargerNumber largerNumber : list) {
			sb.append(largerNumber.toString());
		}
		return sb.toString(); //[91, 901, 9, 80, 5, 34, 30, 3], [91, 901, 9, 80, 5, 34, 30, 3]
    }

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(new int[]{999999998,999999997,999999999}));
		
		
		//9609,938,824,8247,6973,5703,5607,4398,1399
		//9609,938,8247,824,6973,5703,5607,4398,1399
		
	}

}
