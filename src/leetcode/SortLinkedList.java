package leetcode;

//https://leetcode.com/problems/sort-list/

public class SortLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {this.val = x;}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) 
			return head;
		ListNode mid = getMiddleElement(head);
		ListNode midNext = mid.next;
		mid.next = null;
		
		//sort left list
		ListNode left = sortList(head);
		//sort right list
		ListNode right = sortList(midNext);
		//merge left and right list
		ListNode merge = mergeTwoLists(left, right);
        return merge;
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
	
	private ListNode getMiddleElement(ListNode head) {
		if (head == null) 
			return head;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		
		}
		return slow;
	}

	public static void main(String[] args) {
		int val[] = {4, 3, 2, 1};
		ListNode l = new ListNode(val[0]);
		ListNode curr = l;
		for (int i = 1; i < val.length; i++) {
			ListNode tmp = new ListNode(val[i]);
			curr.next = tmp;
			curr = tmp;
		}
		
		SortLinkedList s = new SortLinkedList();
		ListNode tm2 = s.getMiddleElement(l);
		System.out.println(tm2.val);
//		ListNode nl = s.sortList(l);
		System.out.println();
	}

}
