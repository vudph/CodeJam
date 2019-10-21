package ardendertat;

import leetcode.ListNode;

public class LinkedListRemoveNode {

	public void remove(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			if (next != null && next.val == val) {
				curr.next = next.next;
			} else {
				curr = next;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		ListNode head = new ListNode(5);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(5);
		
		LinkedListRemoveNode l = new LinkedListRemoveNode();
		l.remove(head, 5);
		System.out.println();
	}

}
