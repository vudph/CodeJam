package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 https://leetcode.com/problems/contiguous-array/
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 
 ref: https://leetcode.com/problems/longest-well-performing-interval/
 */

public class ContinousSubArray01 {
	
	public int findMaxLengthBruteforce(int nums[]) {
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			int num0 = 0, num1 = 0, tmpLen = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0)
					num0++;
				else if (nums[j] == 1)
					num1++;
				if (num0 == num1)
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		return maxLen;
	}

	public int findMaxLength(int[] nums) {
		//  0, 1, 0, 0, 1, 1, 0, 0
		// -1, 1,-1,-1, 1, 1,-1,-1
		// -1, 0,-1,-2,-1, 0,-1,-2
		
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 1) ? 1 : -1;
			if (map.containsKey(sum)) {
				maxLen = Math.max(maxLen, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
        return maxLen;
    }
	
	public int longestSumK(int nums[], int k) {
		Map<Integer, Integer> seen = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		seen.put(sum, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (seen.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - seen.get(sum - k));
			} else {
				seen.put(sum, i);
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		ContinousSubArray01 l = new ContinousSubArray01();
		System.out.println(l.findMaxLength(new int[] {0,1}));//0,1,0,0,1,1,0,1
		
		System.out.println(l.longestSumK(new int[] {5,0,8,5,2,3,0,4,3,7,3,1,1,0,3,0,9}, 5));
	}

}
