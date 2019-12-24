package leetcode.next1.easycollection;

public class InsectionTwoLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a != null) {
                a = a.next;
            } else {
                headB = headB.next;
            }
            if (b != null) {
                b = b.next;
            } else {
                headA = headA.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);
		
		ListNode intersec = new ListNode(9);
		intersec.next = new ListNode(11);
		head1.next.next.next.next = intersec;
		
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = intersec;
		
		ListNode is = new InsectionTwoLinkedList().getIntersectionNode(head1, head2);
		System.out.println(is.val);
		
		
		
	}

}
