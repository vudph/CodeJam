package leetcode.next1.tree;

import java.util.Stack;

public class ExpressionTree {
	static class Node {
		char value;
		Node left, right;
		Node(char item) {
			value = item;
			left = right = null;
		}
		
		@Override
		public String toString() {
			return value + "";
		}
	}

	boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	// Utility function to do inorder traversal
	void inorder(Node t) {
		if (t != null) {
			if (isOperator(t.value))
				System.out.print("(");
			inorder(t.left);
			System.out.print(t.value + " ");
			inorder(t.right);
			if (isOperator(t.value))
				System.out.print(")");
		}
	}

	// Returns root of constructed tree for given
	// postfix expression
	Node constructTreeFromPoxtfix(char postfix[]) {
		Stack<Node> st = new Stack<>();

		for (int i = 0; i < postfix.length; i++) {
			if (!isOperator(postfix[i])) {
				st.push(new Node(postfix[i]));
			} else { // operator
				Node t = new Node(postfix[i]);
				t.right = st.pop();
				t.left = st.pop();

				st.push(t);
			}
		}
		return st.pop();
	}
	
	private Node constructTreeFromInfix(char infix[]) { // a-b/c+d*e^f^g
		Stack<Character> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        for (int i = 0; i < infix.length; i++) {
			if (infix[i] == '(') {
				s1.push(infix[i]);
			} else if (infix[i] == ')') {
				if (!(s1.pop() + ")").equals("()")) {
					return null;
				}
				Node r = s2.pop();
				Node op = s2.pop();
				Node l = s2.pop();
				op.left = l;
				op.right = r;
				s2.push(op);
			} else {
				s2.push(new Node(infix[i]));
			}
		}
        return s2.pop();
	}


	public static void main(String args[]) {

		ExpressionTree et = new ExpressionTree();
		String postfix = "abc/-defg^^*+";
		char[] charArray = postfix.toCharArray();
		Node root = et.constructTreeFromPoxtfix(charArray);
		
//		Node root = et.constructTreeFromInfix("((a-(b/c)))+(d*(e^(f^g))))".toCharArray());
		
		System.out.println("infix expression is");
		et.inorder(root);

	}

}
