package leetcode.next1.easycollection;

import java.util.Stack;

public class MinStack {
	static class Node {
		int data;
		Node next;
		int min;
		Node(int data, int min) {
			this.data = data;
			this.next = null;
			this.min = min;
		}
	}
	Node head;
	
	public MinStack() {
		this.head = null;
    }
    
    public void push(int x) {
    	if (head == null) {
    		head = new Node(x, x);
    	} else {
    		Node oldhead = head;
    		head = new Node(x, Math.min(x, oldhead.min));
    		head.next = oldhead;
    	}
    }
    
    public void pop() {
        if (head != null) {
        	head = head.next;
        }
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
	
//	private Stack<Integer> primary = new Stack<>();
//	private Stack<Integer> min = new Stack<>();
//    
//    public void push(int x) {
//        primary.push(x);
//        if (min.isEmpty() || x <= min.peek()) {
//        	min.push(x);
//        }
//    }
//    
//    public void pop() {
//        int item = primary.pop();
//        if (item == min.peek()) {
//        	min.pop();
//        }
//    }
//    
//    public int top() {
//        return primary.peek();
//    }
//    
//    public int getMin() {
//        return min.peek();
//    }

	public static void main(String[] args) {
		  MinStack obj = new MinStack();
		  obj.push(-2);
		  obj.push(0);
		  obj.push(-3);
		  int param_1 = obj.getMin();
		  obj.pop();
		  int param_2 = obj.top();
		  int param_3 = obj.getMin();
		  System.out.println(param_3);
		  String message = "AUTOTHROTTLE TRUE";
		  boolean in = Boolean.valueOf(message.split("AUTOTHROTTLE ")[1]);
		  System.out.println(in);
	}

}
