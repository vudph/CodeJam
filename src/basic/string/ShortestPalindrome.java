package basic.string;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	public static String shortestPalindromeRev(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.substring(0, n - i).equals(rev.substring(i))) {
				return rev.substring(0, i) + s;
			}
		}
		return "";
	}
	
	private static int[] computeLspTable(String pattern) { // the longest suffix-prefix
		//lsp[i] = longest proper prefix of P[i], and that is also a suffix of P[i]
		int lsp[] = new int[pattern.length()];
		lsp[0] = 0;
		for (int i = 1; i < pattern.length(); i++) {
			int j = lsp[i - 1];
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = lsp[j - 1]; // in worst case, this instruction will be called (pattern.length - 1) times
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
			}
			lsp[i] = j;
		}
		return lsp;
	}
	
	private static String shortestPalindromeKmp(String s) {
		//https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
		String rev = new StringBuilder(s).reverse().toString();
		
		String ss = s + "$" + rev;
		
		int lastPrefix = computeLspTable(ss)[ss.length() - 1];
		
		return rev.substring(0, rev.length() - lastPrefix) + s;
	}

	public static void main(String[] args) {
//		System.out.println(isPalindrome("abcdadcba"));
		String s = "aaaab";
		System.out.println(shortestPalindrome(s));
		System.out.println(shortestPalindromeRev(s));
		System.out.println(shortestPalindromeKmp(s));
		
	}

}
