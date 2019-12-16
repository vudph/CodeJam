package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-well-performing-interval/

ref: https://leetcode.com/problems/contiguous-array/

 */

public class LongestWellPerformingInterval {

	public int longestWPIBruteforce(int[] hours) {
		int longest = 0;
        for (int i = 0; i < hours.length; i++) {
        	int greater8hr = 0, less8hr = 0;
			for (int j = i; j < hours.length; j++) {
				if (hours[j] > 8)
					greater8hr++;
				else
					less8hr++;
				int tmpLongest = 0;
				if (greater8hr > less8hr) {
					tmpLongest = j - i + 1;
				}
				longest = Math.max(longest, tmpLongest);
			}
		}
        return longest;
    }
	
	public int longestWPI(int[] hours) {
		int longest = 0;
		Map<Integer, Integer> seen = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < hours.length; i++) {
			sum += (hours[i] > 8) ? 1 : -1;
			if (sum > 0) {
				longest = i + 1;
			}
			if (!seen.containsKey(sum)) {
				seen.put(sum, i);
			} 
			// Why should we consider map.get(sum-1) ? not sum - 2 or sum - 3..? 
			// Because the interval would be the longest when the difference between number of tiring days and number of non-tiring days is 1
			// if finding the longest when the nr of tiring day equals the nr of non-tiring days => get(sum) like https://leetcode.com/problems/contiguous-array/ 
			if (seen.containsKey(sum - 1)) {
				longest = Math.max(longest, i - seen.get(sum - 1));
			}
		}
		return longest;
    }
	
	public int longestWellPerforming(int nums[]) {
		Map<Integer, Integer> seen = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		seen.put(sum, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] > 8 ? 1 : -1;
			if (sum > 0)
				maxLen = i + 1;
			if (!seen.containsKey(sum)) {
				seen.put(sum, i);
			}
			if (seen.containsKey(sum - 1)) {
				maxLen = Math.max(maxLen, i - seen.get(sum - 1));
			} 
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestWellPerformingInterval l = new LongestWellPerformingInterval();
		System.out.println(l.longestWellPerforming(new int[] {8,9,9,9,9}));
		
		
	}
}
