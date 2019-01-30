package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringNoRepeating {
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int lmax = 1;
//		brute force
//		for (int i = 0; i < s.length() - 1; i++) {
//			Set<Character> sub = new HashSet<>();
//			sub.add(s.charAt(i));
//			for (int j = i + 1; j < s.length(); j++) {
//				if (sub.contains(s.charAt(j))) {
//					break;
//				} else {
//					sub.add(s.charAt(j));
//					lmax = Math.max(lmax, sub.size());
//				}
//			}
//		}
		
		Set<Character> sub = new HashSet<>();
		int i = 0;
		int j = 0;
		while (i < s.length()) {
			if (!sub.contains(s.charAt(i))) {
				sub.add(s.charAt(i));
				lmax = Math.max(lmax, sub.size());
				i++;
			} else {
				sub.remove(s.charAt(j));
				j++;
			}
		}
		return lmax;
	}
	
	public static void main(String[] args) {
		LongestSubstringNoRepeating l = new LongestSubstringNoRepeating();
		System.out.println(l.lengthOfLongestSubstring("au"));
	}

}
