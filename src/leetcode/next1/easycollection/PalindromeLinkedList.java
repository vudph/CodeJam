package leetcode.next1.easycollection;

import leetcode.next1.easycollection.ReverseLinkedList.ListNode;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/

 */

public class PalindromeLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
        ListNode mid;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
       		fast = fast.next.next;
       		slow = slow.next;
        }
        mid = slow;
        // reverse from mid
        ListNode prev = null;
        ListNode walk = mid;
        while (walk != null) {
        	ListNode next = walk.next;
        	walk.next = prev;
        	prev = walk;
        	walk = next;
        }
		while (prev != null && head.val == prev.val) {
			prev = prev.next;
			head = head.next;
		}
		return prev == null ? true : false;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
	}

}
