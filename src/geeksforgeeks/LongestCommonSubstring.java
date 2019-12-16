package geeksforgeeks;

import java.util.Arrays;

/*
 https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 
 nput : X = “abcdxyz”, y = “xyzabcd”
Output : 4
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6

 */

public class LongestCommonSubstring {
	
	private int findLongest(String s1, String s2) {
		int longest = 0;
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 0);
		}
		char ch1[] = s1.toCharArray();
		char ch2[] = s2.toCharArray();
		for (int i = 0; i <= ch2.length; i++) {			
			for (int j = 0; j <= ch1.length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (ch1[j - 1] == ch2[i - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					longest = Math.max(longest, dp[i][j]);
				}
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonSubstring().findLongest("abcdxyz", "xyzabcd"));
	}

}
