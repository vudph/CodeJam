package leetcode.next1.easycollection;

import leetcode.next1.easycollection.ReverseLinkedList.ListNode;

public class Merge2SortedLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;        
        if (l1.val >= l2.val) {
            head = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode l = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            if (l1.val >= l2.val) {
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            } 
            l.next = tmp;
            l = l.next;
        }
        while (l1 != null) {
            ListNode tmp = new ListNode(l1.val);
            l1 = l1.next;
            l.next = tmp;
            l = l.next;
        }
        while (l2 != null) {
            ListNode tmp = new ListNode(l2.val);
            l2 = l2.next;
            l.next = tmp;
            l = l.next;
        }
        
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
