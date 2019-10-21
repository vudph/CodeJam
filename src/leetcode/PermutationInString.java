package leetcode;

/*
https://leetcode.com/problems/permutation-in-string/
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Input: s1 = "abc" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 */
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int count1[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			int count2[] = new int[26];
//			String s3 = s2.substring(i, i + s1.length());
//			System.out.println(s3);
//			for (int j = 0; j < s3.length(); j++) {
//				count2[s3.charAt(j) - 'a']++;
//			}
			for (int j = 0; j < s1.length(); j++) {
				count2[s2.charAt(i + j) - 'a']++;
			}
			if (matched(count1, count2))
				return true;
		}
		return false;
	}
	
	private boolean matched(int a[], int b[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
	}

}
