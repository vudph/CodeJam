package leetcode.next1;
/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
	
	public List<Integer> findAnagrams(String s, String p) {
//		int countP[] = new int[26];
//		for (char c : p.toCharArray()) {
//			countP[c - 'a']++;
//		}
//		List<Integer> indices = new ArrayList<Integer>();
//		int l = 0;
//		int r = p.length() - 1;
//		for (l = 0; l <= s.length() - p.length(); l++, r++) {
//			if (isAnagram(l, r, s, countP.clone())) {
//				indices.add(l);
//			}
//		}
//		return indices;
		
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
			return result;
		int[] pcount = new int[26];
		int[] scount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pcount[p.charAt(i) - 'a']++;
			scount[s.charAt(i) - 'a']++;
		}

		if (Arrays.equals(scount, pcount)) {
			result.add(0);
		}
		for (int r = p.length(), l = 0; r < s.length(); r++, l++) {
			scount[s.charAt(r) - 'a']++;
			scount[s.charAt(l) - 'a']--;
			if (Arrays.equals(scount, pcount)) {
				result.add(l + 1);
			}
		}
		return result;
		
    }	
	
	private boolean isAnagram(int l, int r, String s, int cnt[]) {
		for (int i = l; i <= r; i++) {
			cnt[s.charAt(i) - 'a']--;
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new FindAllAnagrams().findAnagrams("abbaab", "ab"));
	}

}
