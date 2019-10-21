package leetcode;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

 */
public class LongestPalindrome {
	
	public String longestPalindrome0(String s) {
		if (s.length() == 1) 
			return s;
		int longestLength = 0;
		int start = 0, end = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			
			if (len > longestLength) {
				if (len % 2 != 0) {
					start = i - len/2;
				} else {
					start = i - len/2 + 1;
				}
				end = i + len/2 + 1;
				longestLength = len;
			}
		}
//		System.out.println(longestLength);
		return s.substring(start, end);
	}
	
	private int expandAroundCenter(String s, int left, int right) {
		int j = left;
		int k = right;
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--; k++;
		}
		return k - j - 1;
	}

	public static void main(String[] args) {
//		String s = "cadab"; // => abaaaba: 7
		String s = "ettygbbccbbghhgcxbaabxyaba"; // => bbccbb: 6
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalindrome0(s));
	}
}
