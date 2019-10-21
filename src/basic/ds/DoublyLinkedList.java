package basic.ds;

public class DoublyLinkedList<E> {
	private Node<E> head = null; // header sentinel
	private Node<E> tail = null; // trailer sentinel
	private int size = 0; // number of elements in list

	static class Node<E> {
		E value; // reference to element stored at this node
		Node<E> prev; // reference to previous node in list
		Node<E> next; // reference to subsequent node in list

		public Node(E e) {
			value = e;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	public Node<E> removeFirst() {
		return null;
	}

	public Node<E> removeLast() {
		if (!isEmpty()) {
			Node<E> oldTail = tail;
			if (head == tail) {
				head = tail = null;
			} else {
				tail.prev.next = null;
				tail = tail.prev;
			}
			size--;
			return oldTail;
		}
		return null;
	}
	
	public DoublyLinkedList<E> deepCopy() {
//		DoublyLinkedList<E> other = new DoublyLinkedList<>();
//		if (size > 0) {
//			other.head = new Node<>(head.value);
//			other.tail = other.head;
//			Node<E> walk = head.next;
//			while (walk != null) {
//				Node<E> newest = new Node<>(walk.value);
//				Node<E> oldTail = other.tail;
//				other.tail.next = newest;
//				other.tail = newest;
//				other.tail.prev = oldTail;
//				walk = walk.next;
//			}
//		}
//		return other;
		DoublyLinkedList<E> other = new DoublyLinkedList<>();
		if (size > 0) {
			other.head = new Node<>(head.value);
			Node<E> curr = other.head;
			Node<E> walk = head.next;
			while (walk != null) {
				Node<E> p = new Node<>(walk.value);
				curr.next = p;
				p.prev = curr;
				curr = p;
				walk = walk.next;
			}
			other.tail = curr;
			other.size = size;
		}
		return other;
	}
	

	public static void main(String[] args) {
		DoublyLinkedList<String> myList = new DoublyLinkedList<>();
        myList.addFirst("USA");
        myList.addLast("Germany");
        myList.addFirst("France");
        myList.addLast("England");
        myList.addFirst("Belgium");
        
        DoublyLinkedList<String> clonedList = myList.deepCopy();
        Node<String> node = clonedList.removeLast();
        System.out.println(node.value);
	}

}
