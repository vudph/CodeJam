package leetcode.next1;

import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator/

"(2-(52-(53-1+12)))-1"=(2-(52-(64)))-1=(2-(-12))-1=14-1=13

" 2-1 + 2 " = 3

"(10+(10+15+20)-3)-(6+8)"

 */
public class BasicCalculator {
	public int calculate(String s) {
		int res = 0; //accumulate sum
		int lastSign = 1; // '+'
		int num = 0;
		Stack<Integer> stk = new Stack<>();
		char ch[] = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isDigit(ch[i])) {
				num = num * 10 + (ch[i] - '0');
			} else if (isOperator(ch[i])) {
				res += num * lastSign;
				lastSign = ch[i] == '+' ? 1 : -1;
				num = 0;
			} else if (ch[i] == '(') {
				stk.push(res);
				stk.push(lastSign);
				
				lastSign = 1;
				num = 0;
				res = 0;
			} else if (ch[i] == ')') {
				res += num * lastSign;
				int sign = stk.pop();
				int a = stk.pop();
				res = a + (sign * res);
				
				num = 0;
				lastSign = 1;
			}
		}
		return res + (lastSign * num);
	}
	
	boolean isOperator(char c) {
		if (c == '+' || c == '-') {
			return true;
		}
		return false;
	}
	
//	public int calculate(String s) {
//	s = "(" + s + ")";
//	Stack<String> st = new Stack<>();
//	char ch[] = s.toCharArray();
//	String num = "";
//	for (int i = 0; i < ch.length; i++) {
//		if (ch[i] == '(' || ch[i] == ')' || ch[i] == '+' || ch[i] == '-' || i == ch.length - 1) {
//			if (!num.equals("")) {
//				st.push(num);
//				num = "";
//			}
//			st.push(ch[i] + "");
//		} else if (ch[i] - '0' >= 0 && ch[i] - '0' <= 9) {
//			num += ch[i];
//		}
//		if (ch[i] == ')') {
//			st.pop();
//			String lastSign = "";
//			Stack<Integer> s1 = new Stack<>();
//			s1.push(Integer.parseInt(st.pop()));
//			while (!st.peek().equals("(")) {
//				String op = st.pop();
//				if (op.equals("+") || op.equals("-")) {
//					lastSign = op;
//					continue;
//				}
//				if (lastSign.equals("-")) {
//					s1.push(-s1.pop());
//				}
//				s1.push(Integer.parseInt(op));
//				
//			}
//			st.pop();
//			int sum = 0;
//			for (Integer it : s1) {
//				sum += it;
//			}
//			st.push(Integer.toString(sum));
//		} 
//	}
//	
//	int res = Integer.parseInt(st.pop());
//
//	return res;
//}

	public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate("(10+(10+15+20)-3)+(6+8)"));
	}

}
