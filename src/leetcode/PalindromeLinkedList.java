package leetcode;
/*
https://leetcode.com/problems/palindrome-linked-list/
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

 */

public class PalindromeLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public boolean isPalindrome(ListNode head) {
    	ListNode prev = head;
    	ListNode curr = head.next;
    	prev.next = null;
    	while (curr != null) {
    		ListNode tmp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = tmp;
    	}
    	ListNode newHead = prev;
    	
        return true;
    }

	public static void main(String[] args) {
		int val[] = {1, 2, 3, 4};
		ListNode l = new ListNode(val[0]);
		ListNode curr = l;
		for (int i = 1; i < val.length; i++) {
			ListNode tmp = new ListNode(val[i]);
			curr.next = tmp;
			curr = tmp;
		}
		PalindromeLinkedList rl = new PalindromeLinkedList();
		rl.isPalindrome(l);
	}

}
