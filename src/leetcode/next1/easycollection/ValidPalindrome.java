package leetcode.next1.easycollection;
/*
https://leetcode.com/problems/valid-palindrome/

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int p1 = 0;
		int p2 = s.length() - 1;
		while (p1 < p2 && p1 < s.length() && p2 >= 0) {
			if (!Character.isLetterOrDigit(s.charAt(p1))) {
				p1++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(p2))) {
				p2--;
				continue;
			}
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else {
				return false;
			}
		}
		return true;
    }

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("0p"));
	}

}
