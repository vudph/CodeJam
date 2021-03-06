package leetcode.next1.easycollection;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
Given linked list: 1->2->3->4->5->6, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->4->6.
 */

public class RemoveNthNodeFromEnd {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode p = removeHelper(head, new int[] {n});
		ListNode p = remove1Pass(head, n);
		return p;
    }

	private ListNode removeHelper(ListNode node, int[] n) {
		if (node != null) {
			ListNode next = removeHelper(node.next, n);
			n[0] = n[0] - 1;
			if (n[0] == 0) {
				return next;
			} else if (n[0] < 0) {
				node.next = next;
			}
			return node;
		}
		return null;
	}
	
	private ListNode remove1Pass(ListNode node, int n) {
		ListNode first = node;
		ListNode second = node;
		for (int i = 0; i < n; i++)
			first = first.next;
		if (first == null) { // for case n == len of list
			return second.next;
		}
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return node;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		new RemoveNthNodeFromEnd().removeNthFromEnd(head, 8);
	}

}
