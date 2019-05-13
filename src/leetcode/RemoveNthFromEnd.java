package leetcode;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

 */
public class RemoveNthFromEnd {
	ListNode newhead = null;
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = remove(head, n, new int[]{0});
        return node;
    }
	
	public ListNode removeNthFromEndIter(ListNode head, int n) {
		int len = 0;
		ListNode curr = head;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		
		int removeId = len - n;
		if (removeId > 0 && removeId < len) {
			ListNode dummy = head;
			int idx = 0;
			while (dummy != null) {
				if (idx == removeId - 1) {
					dummy.next = dummy.next.next;
				}
				dummy = dummy.next;
				idx++;
			}
		} else if (removeId == 0) {
			head = head.next;
		}
		return head;
	}
	
	private ListNode remove(ListNode node, int n, int[] idx) {
		if (node != null) {
			ListNode next = remove(node.next, n, idx);
			idx[0]++;
			if(idx[0] == n) {
				return next;
			} else if (idx[0] > n) {
				node.next = next;
			}
			return node;
		}
		return null;
	}
	
	public ListNode reverseList(ListNode head) {
		reverse(head);
		head.next = null;
		return newhead;
	}
	
	private ListNode reverse(ListNode node) {
		if (node != null) {
			ListNode next = reverse(node.next);
			if (next != null) {
				next.next = node;
			} else {
				newhead = node;
			}
			return node;
		} 
		return null;
	}
	
	public ListNode reverseListIter(ListNode head) {
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
		RemoveNthFromEnd t = new RemoveNthFromEnd();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		t.removeNthFromEnd(head, 6);
//		t.removeNthFromEndIter(head, 7);
		t.reverseList(head);
//		t.reverseListIter(head);
	}

}
