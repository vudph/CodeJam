package leetcode;
/*
https://leetcode.com/problems/shifting-letters/

We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.

 */

public class ShiftingLetters {
	
	public String shiftingLetters(String S, int[] shifts) {
		//naive approach
//		char ch[] = S.toCharArray();
//		for (int i = 0; i < shifts.length; i++) {
//			int sh = shifts[i];
//			for (int j = 0; j <= i; j++) {
//				int c = ch[j] + sh;
//				while (c > 122) {
//					c = (c - 122 + 96);
//				}
//				ch[j] = (char) c;
//			}
//		}
//		return new String(ch);
		
		//prefix sum approach
		int len = shifts.length;
		int prefixSum[] = new int[len];
		prefixSum[len - 1] = shifts[len - 1] % 26;
		for (int i = len - 2; i >= 0; i--) {
			prefixSum[i] = (prefixSum[i+1] + shifts[i]) % 26; // 0(a) -> 25(z)
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			int idx = S.charAt(i) - 97; // convert to: 0(a) -> 25(z)
			char c = (char) (((idx + prefixSum[i]) % 26) + 97);
			sb.append(c);
		}
		
		return sb.toString();
    }

	public static void main(String[] args) {
		ShiftingLetters s = new ShiftingLetters();
		System.out.println(s.shiftingLetters("z", new int[] {52}));
		System.out.println(s.shiftingLetters("ruu", new int[] {26,9,17}));
		System.out.println(s.shiftingLetters("abc", new int[] {3,5,9}));
	}
}
