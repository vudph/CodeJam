package basic.windowsliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 https://leetcode.com/problems/minimum-window-substring/
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

 */

/*
 https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string
Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.

Input :  string = "geeksforgeeks"
         pattern = "ork" 
Output :  Minimum window is "ksfor"


 */
public class MinWindowContainsPattern {

	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) 
			return "";
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			if (!tmap.containsKey(t.charAt(i)))
				tmap.put(t.charAt(i), 1);
			else 
				tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
		}
		
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			Map<Character, Integer> copy = new HashMap<>();
			copy.putAll(tmap);
			int tmpStart = 0;
			int tmpEnd = s.length() - 1;
			boolean sf = false;
			for (int j = i; j < s.length(); j++) {
				if (copy.containsKey(s.charAt(j))) {
					int cnt = copy.get(s.charAt(j));
					if (cnt == 1) {
						copy.remove(s.charAt(j));
					} else {
						cnt = cnt - 1;
						copy.put(s.charAt(j), cnt);
					}
					if (copy.isEmpty()) {
						if (!sf) {
							tmpStart = tmpEnd = j;
						}
						tmpEnd = j;
						if (minLen > (tmpEnd - tmpStart + 1)) {
							minLen = tmpEnd - tmpStart + 1;
							start = tmpStart;
							end = tmpEnd;
						}
						break;
					}
					if (!sf) {
						tmpStart = j;
						sf = true;
					}
				}
			}
			
		}
		
		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

	public static void main(String[] args) {
		MinWindowContainsPattern m = new MinWindowContainsPattern();
		System.out.println(m.minWindow("this is a test string", "tist"));
		System.out.println(m.minWindow("geeksforgeeks", "ork"));
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(m.minWindow("ab", "b"));
	}

}
