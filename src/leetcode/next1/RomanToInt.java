package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

/*
 https://leetcode.com/problems/roman-to-integer/
 
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

 */

public class RomanToInt {

	public int romanToInt(String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return parseInt(s.charAt(0));
		}
		
		char ch[] = s.toCharArray();
		int sum = parseInt(s.charAt(0));
		char prev = ch[0]; 
//		"IV"
		for (int i = 1; i < ch.length; i++) {
			int a = parseInt(ch[i]);
			int b = parseInt(prev);
			if (a > b) {
				sum = (sum - b) + parseInt(prev + "" + ch[i] + "");
			} else {
				sum += a;
			}
			prev = ch[i];
		}
		
		return sum;
    }
	
	private int parseInt(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
	
	private int parseInt(String s) {
		switch (s) {
		case "IV":
			return 4;
		case "IX":
			return 9;
		case "XL":
			return 40;
		case "XC":
			return 90;
		case "CD":
			return 400;
		case "CM":
			return 900;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
	}

}
