package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/valid-anagram/
Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

 */
public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
            return false;
        int cnt[] = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			cnt[c - 'a']++;
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0)
				return false;
		}
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
