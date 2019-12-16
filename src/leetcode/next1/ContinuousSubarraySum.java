package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/continuous-subarray-sum/

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 */
public class ContinuousSubarraySum {
	
	public boolean checkSubarraySum(int[] nums, int k) {
		
		// brute force
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				int sum = 0;
//				for (int l = i; l <= j; l++) {
//					sum += nums[l];
//				}
//				if (sum == k || (k != 0 && sum % k == 0))
//					return true;
//			}
//		}
		
		//brute force with cumulative 
//		int sumUp[] = new int[nums.length + 1];
//		sumUp[0] = 0;
//		for (int i = 0; i < nums.length; i++) {
//			sumUp[i + 1] = sumUp[i] + nums[i];
//		}
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				int s = sumUp[j + 1] - sumUp[i];
//				if (s == k || (k != 0 && s % k == 0)) {
//					System.out.println(s);
//					return true;
//				}
//			}
//		}
		
//		int sumUp[] = new int[nums.length + 1];
//		sumUp[0] = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			sumUp[i] = sumUp[i - 1] + nums[i];
//		}
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				int s = sumUp[j] - sumUp[i] + nums[i];
//				if (s == k || (k != 0 && s % k == 0)) {
//					System.out.println(s);
//					return true;
//				}
//			}
//		}
		
		// hashmap => cumulative
		Map<Integer, Integer> seen = new HashMap<>();
		int sum = 0;
		seen.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
            int remain;
            if (k == 0) {
                remain = sum;
            } else {
                remain = sum % k;
            }
            Integer p = seen.get(remain);
            if (p != null) {
                if (i - p > 1) {
                    return true;
                }
            } else {
            	seen.put(remain, i);
            }
		}
		
        return false;
    }

	
	private boolean check(int nums[], int k) {
		Map<Integer, Integer> seen = new HashMap<>();
		seen.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int remain;
			if (k == 0)
				remain = 0;
			else 
				remain = sum % k;
					
			if (seen.containsKey(remain)) {
				int idx = seen.get(remain);
				if (i - idx > 1)
					return true;
			}
			
			seen.put(remain, seen.getOrDefault(remain, i));			
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new ContinuousSubarraySum().check(new int[] {23, 2, 6, 4, 7}, 6));
	}

}
