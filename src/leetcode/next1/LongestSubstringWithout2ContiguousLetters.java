package leetcode.next1;
/*
https://leetcode.com/discuss/interview-question/398031/
Given a string s containing only a and b, find longest substring of s such that s does not contain more than two contiguous occurrences of a and b.

Example 1:

Input: "aabbaaaaabb"
Output: "aabbaa"

Example 2:
Input: "aabbaabbaabbaa"
Output: "aabbaabbaabbaa"

Ex3:
aaababbbaabbabbaabbabbbbaaba
=>bbaabbabbaabbabb

aaababbaabbabaaab
=>aababbaabbabaa
 */
public class LongestSubstringWithout2ContiguousLetters {

	public String longestSubstring(String s) {
		if (s.length() < 3)
			return s;
		char ch[] = s.toCharArray();
		char prevCh = ch[0];
		int cnt = 1;
		String res = s;
		int maxLen = 0;
		int l = 0;
		int i = 1;
		while (i < ch.length) {
			if (ch[i] != prevCh) {
				cnt = 1;
				prevCh = ch[i];
			} else {
				cnt++;
				if (cnt == 3) {
					if (maxLen < (i - l)) {
						maxLen = i - l;
						res = s.substring(l, i);
					}
					l = i - 1;
					cnt = 1;
				}
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithout2ContiguousLetters().longestSubstring("abbaabbaaabbaaa"));
	}

}
