package basic.string;

//https://leetcode.com/problems/shortest-palindrome/
//Example 1:
//
//Input:  "aacecaaa"
//Output:"aaacecaaa"
//Example 2:
//
//Input: "abcd"
//Output: "dcbabcd"

public class ShortestPalindrome {
	
	public static String shortestPalindrome(String s) {
		if (isPalindrome(s)) 
			return s;
		StringBuilder res = new StringBuilder(s);
		for (int i = s.length() - 1; i >= 0; i--) {
			res.insert(s.length() - i - 1, s.charAt(i));
			if (isPalindrome(res.toString()))
				return res.toString();
		}
		return res.toString();
	}
	
	private static boolean isPalindrome(String s) {
		// abccba => 6
		// abcdcba => 7
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.println(isPalindrome("abcdadcba"));
		System.out.println(shortestPalindrome("abcd"));
	}

}
