package leetcode.next1.easycollection;

/*
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

public class ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	ListNode newhead;
	public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode walk = head;
        // while (walk != null) {
        //     ListNode next = walk.next;
        //     walk.next = prev;
        //     prev = walk;                        
        //     walk = next;
        // }
        // return prev;
        reverse(head);
        head.next = null;
        return newhead;
    }
    
    private ListNode reverse(ListNode node) {
        if (node == null)
            return null;
        ListNode next = reverse(node.next);
        if (next != null) {
        	next.next = node;
        } else {
        	newhead = node;
        }
        return node;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode n = new ReverseLinkedList().reverseList(head);
		System.out.println();
	}

}
