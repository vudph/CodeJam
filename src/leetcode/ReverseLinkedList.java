package leetcode;
//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {this.val = x;}
	}
	
	public ListNode reverseList(ListNode l) {
		if (l == null)
            return l;
		ListNode prev = l;
		ListNode curr = l.next;
		l.next = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		int val[] = {1, 2, 3, 4};
		ListNode l = new ListNode(val[0]);
		ListNode curr = l;
		for (int i = 1; i < val.length; i++) {
			ListNode tmp = new ListNode(val[i]);
			curr.next = tmp;
			curr = tmp;
		}
		ReverseLinkedList rl = new ReverseLinkedList();
		rl.reverseList(l);
	}

}
