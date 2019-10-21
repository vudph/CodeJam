package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

s = "leetcode"
return 0.

s = "loveleetcode",
return 2

 */

public class FirstUniqueCharInString {
	
	public int firstUniqChar(String s) {
        int cnt[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
        for (int i = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i) - 'a'] == 1)
				return i;
		}
        return -1;
    }

	public static void main(String[] args) {
		System.out.println(new FirstUniqueCharInString().firstUniqChar("loveleetcode"));
	}

}
