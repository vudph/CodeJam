package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 https://leetcode.com/problems/majority-element/
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
	
	public int majorityElement(int[] nums) {
//		int maj = nums[0];
//		Map<Integer, Integer> freq = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (freq.containsKey(nums[i])) {
//				freq.put(nums[i], freq.get(nums[i]) + 1);
//			} else {
//				freq.put(nums[i], 1);
//			}
//		}
//		Iterator<Entry<Integer, Integer>> iter = freq.entrySet().iterator();
//		int maxFreq = Integer.MIN_VALUE;
//		while (iter.hasNext()) {
//			Entry<Integer, Integer> e = iter.next();
//			if (e.getValue() > maxFreq) {
//				maxFreq = e.getValue();
//				maj = e.getKey();
//			}
//		}
//		return maj;
		int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        //check if candidate appears more than n/2 or not
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate) {
				cnt++;
			}
		}
        if (cnt <= nums.length/2)
        	throw new IllegalArgumentException("No Majority Element");
        
        return candidate;
    }

	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[] {1, 3, 3, 2, 3}));
	}

}
