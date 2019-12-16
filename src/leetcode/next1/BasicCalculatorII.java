package leetcode.next1;

import java.util.Iterator;
import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator-ii/

The integer division should truncate toward zero

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

3+5/2*2 = 3+((5/2)*2) = 3 + 2*2 = 7

3+5*2/2 = 3+((5*2)/2) = 3 + 10/2 = 8

31+51*2-24/1*3*2 = 31+(51*2)-((24/1)*3)*2 = 31+102-((24*3)*2)=31+102-(72*2)=31+102-144=-11

31,102,-144
 */
public class BasicCalculatorII {

	public int calculate(String s) {
		Stack<Integer> st1 = new Stack<>();
		char ch[] = s.toCharArray();
		int num = 0;
		char lastSign = 0;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isDigit(ch[i])) {
				num = num * 10 + (ch[i] - '0');
			}
			if (isOperator(ch[i]) || i == ch.length - 1) {
				if (lastSign == '/') {
					st1.push(st1.pop() / num);
				} else if (lastSign == '*') {
					st1.push(st1.pop() * num);
				} else if (lastSign == '-') {
					st1.push(-num);
				} else {
					st1.push(num);
				}
				lastSign = ch[i];
				num = 0;
			}
		}
		int result = 0;
		for (int c : st1) {
			result += c; 
		}
		return result;
	}

	boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new BasicCalculatorII().calculate(" 2-1 + 2 "));
		
		System.out.println(Character.isLetter('/'));
	}

}
