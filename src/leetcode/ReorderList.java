package leetcode;

import java.util.Objects;

import sun.awt.image.PNGImageDecoder.PNGException;

/*
https://leetcode.com/problems/reorder-list/
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5->6->7, reorder it to 1->5->2->4->3.

1->2->3 => 1->3->2

 */
public class ReorderList {
	
	public void reorderList(ListNode head) {
		if (head == null)
			return;
        ListNode pslow = head;
        ListNode pfast = pslow;
        while (pfast != null) {
        	pfast = pfast.next;
        	if (pfast != null) {
        		pfast = pfast.next;
        		pslow = pslow.next;
        	}
        }
        
        ListNode reverseHead = pslow.next;
        reverseHead = reverseList(reverseHead);
        pslow.next = null;
        
        ListNode curr0 = head;
        ListNode curr1 = reverseHead;
        while (curr0 != null && curr1 != null) {
        	ListNode next0 = curr0.next;
//        	ListNode next1 = curr1.next;
        	curr0.next = curr1;
        	curr0 = curr1;
        	curr1 = next0;
        }
        
        System.out.println(head);
    }

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
		ReorderList r = new ReorderList();
		r.reorderList(head);
	}

}
