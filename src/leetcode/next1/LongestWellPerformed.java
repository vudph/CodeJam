package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformed {

	public int longestWPI(int[] hours) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        int longest = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
				longest = i + 1;
			} else {
				seen.putIfAbsent(sum, i);
				if (seen.containsKey(sum - 1)) {
	            	longest = Math.max(longest, i - seen.get(sum - 1));
	            }
			}
        }
        return longest;
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestWellPerformed().longestWPI(new int[] {9,9,9}));
	}

}
