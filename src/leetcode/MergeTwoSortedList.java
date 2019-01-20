package leetcode;

//https://leetcode.com/problems/merge-two-sorted-lists/
/*
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {this.val = x;}
	}
	
	private int[] mergeTwoSortedArray(int a1[], int a2[]) {
		int n = a1.length;
		int m = a2.length;
		int a3[] = new int[n + m];
		int i = 0, j = 0, k = 0;
		while (i < n && j < m) {
			if (a1[i] < a2[j])
				a3[k++] = a1[i++];
			else
				a3[k++] = a2[j++];
		}
		while (i < n)
			a3[k++] = a1[i++];
		while (j < m)
			a3[k++] = a2[j++];
		return a3;
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
		MergeTwoSortedList merge = new MergeTwoSortedList();
		int a1[] = {1, 4, 5, 8, 10, 11};
		int a2[] = {1, 2, 3, 6, 7, 12};
		int a3[] = merge.mergeTwoSortedArray(a1, a2);
		System.out.println();
		
		a1 = new int[]{1, 2, 4};
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
		for (int i = 1; i < a1.length; i++) {
			ListNode tmp = new ListNode(a2[i]);
			t2.next = tmp;
			t2 = tmp;
		}
		ListNode l3 = merge.mergeTwoLists(l1, l2);
		System.out.println();
	}

}
