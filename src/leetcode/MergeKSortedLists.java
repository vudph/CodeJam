package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* https://leetcode.com/problems/merge-k-sorted-lists/
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

public class MergeKSortedLists {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {this.val = x;}
	}

	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
			return null;
		ListNode tmp = lists[0];
        for (int i = 1; i < lists.length; i++) {
			tmp = mergeTwoLists(lists[i], tmp);
		}
        return tmp;
    }

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
        	l3 = new ListNode(l1.val);
        	l1 = l1.next;
        } else { 
        	l3 = new ListNode(l2.val);
        	l2 = l2.next;
        }
        ListNode curr = l3;
        while (l1 != null && l2 != null) {
        	ListNode tmp;
        	if (l1.val < l2.val) {
        		tmp = new ListNode(l1.val);
        		l1 = l1.next;
        	} else {
        		tmp = new ListNode(l2.val);
        		l2 = l2.next;
        	}
        	curr.next = tmp;
        	curr = tmp;
        }
        while (l1 != null) {
        	ListNode tmp = new ListNode(l1.val);
        	l1 = l1.next;
        	curr.next = tmp;
        	curr = tmp;
        }
        while (l2 != null) {
        	ListNode tmp = new ListNode(l2.val);
        	l2 = l2.next;
        	curr.next = tmp;
        	curr = tmp;
        }
        return l3;
    }
	
	public static void main(String[] args) {
		MergeKSortedLists merge = new MergeKSortedLists();
		int a1[] = {1, 4, 5, 8, 10, 11};
		int a2[] = {1, 3, 4};
		int a3[] = {2, 6};
		ListNode l1 = new ListNode(a1[0]);
		ListNode t1 = l1;
		for (int i = 1; i < a1.length; i++) {
			ListNode tmp = new ListNode(a1[i]);
			t1.next = tmp;
			t1 = tmp;
		}
		a2 = new int[]{1, 3, 4};
		ListNode l2 = new ListNode(a2[0]);
		ListNode t2 = l2;
		for (int i = 1; i < a2.length; i++) {
			ListNode tmp = new ListNode(a2[i]);
			t2.next = tmp;
			t2 = tmp;
		}
		
		ListNode l3 = new ListNode(a3[0]);
		ListNode t3 = l3;
		for (int i = 1; i < a3.length; i++) {
			ListNode tmp = new ListNode(a3[i]);
			t3.next = tmp;
			t3 = tmp;
		}
		ListNode list[] = new ListNode[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		merge.mergeKLists(list);
		System.out.println();
	}
}
