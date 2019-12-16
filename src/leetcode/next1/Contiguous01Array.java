package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/contiguous-array/

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

  0 0 1 0 1 1 0 0 1 0 1 1
 -1-1 1-1 1 1-1-1 1-1 1 1
0-1-2-1-2-1 0-1-2-1-2-1 0 

  0 0 0 0 1 1 0 0 0 0 0 1
 -1-1-1-1 1 1-1-1-1-1-1 1
0-1-2-3-4-3-2-3-4-5-6-7-6

 */

public class Contiguous01Array {
	
	public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0; //accumulated sum
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 0 ? -1 : 1);
			
			if (!seen.containsKey(sum)) {
				seen.put(sum, i);
			} else {
				maxLen = Math.max(maxLen, i - seen.get(sum));
			}
		}
      
        return maxLen;
    }

	public static void main(String[] args) {
		System.out.println(new Contiguous01Array().findMaxLength(new int[] {0,1,1,1,0,0,0}));
	}

}
