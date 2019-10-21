package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 "2" -> "abc"
 "3" -> "def"
 "4" -> "ghi"
 "5" -> "jkl"
 "6" -> "mno"
 "7" -> "pqrs"
 "8" -> "tuv"
 "9" -> "wxyz"
 
 */
public class LetterCombinations {
	private char[] phone[] = {"".toCharArray(), "".toCharArray(), 
							  "abc".toCharArray(),
							  "def".toCharArray(),
							  "ghi".toCharArray(),
							  "jkl".toCharArray(),
							  "mno".toCharArray(),
							  "pqrs".toCharArray(),
							  "tuv".toCharArray(),
							  "wxyz".toCharArray()
			                 };

	public List<String> letterCombinations(String digits) {
//		for (int i = 0; i < digits.length() - 1; i++) {
//			char ch1[] = phone[Character.getNumericValue(digits.charAt(i))];
//			for (int ci = 0; ci < ch1.length; ci++) {
//				for (int j = i + 1; j < digits.length(); j++) {
//					char ch2[] = phone[Character.getNumericValue(digits.charAt(j))];
//					for (int cj = 0; cj < ch2.length; cj++) {
//						System.out.print((Character.toString(ch1[ci]) + Character.toString(ch2[cj])) + ",");
//					}
//				}
//				System.out.println();
//			}
//		}
		
		backtracking("", digits);
		return output;
    }
	
	private List<String> output = new ArrayList<>();

	private void backtracking(String combination, String digits) {
		if (digits.length() == 0) {
			output.add(combination);
			return;
		}
		String digit = digits.substring(0, 1);
		for (int i = 0; i < phone[Integer.parseInt(digit)].length; i++) {
			backtracking(combination + phone[Integer.parseInt(digit)][i], digits.substring(1));
		}
	}

	public static void main(String[] args) {
		List<String> res = new LetterCombinations().letterCombinations("234");
	}

}
