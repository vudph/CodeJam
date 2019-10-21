package leetcode.recap;

import java.util.HashSet;
import java.util.Set;

/*
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

edvcdfe
=> 5 (vcdfe)
 */
public class LongestSubstringNoRepeating {
	
	public int lengthOfLongestSubstring(String s) {
		Set<Character> chars = new HashSet<>();
		int longest = 0;
		int i = 0;
		int k = 0;
		while (i < s.length()) {
			if (!chars.contains(s.charAt(i))) {
				chars.add(s.charAt(i));
				longest = Math.max(longest, chars.size());
				i++;
			} else {
				chars.remove(s.charAt(k));
				k++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringNoRepeating().lengthOfLongestSubstring("edvcdfe"));
	}

}
