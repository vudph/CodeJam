package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
//extends LinkedHashMap<Integer, Integer> {
//	private int capacity;
//	public LRUCache(int capacity) {
//		super(capacity, 1F, true);
//		this.capacity = capacity;
//	}
//    
//    public int get(int key) {
//    	return super.getOrDefault(key, -1);
//    }
//    
//
//	public void put(int key, int value) {
//		super.put(key, value);
//	}
//	
//	@Override
//	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
//		return size() > capacity;
//	}
	
	static class Node {
		int value;
		int key;
		Node next;
		Node prev;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return Integer.toString(this.key);
		}
	}
//
	private Map<Integer, Node> map = new HashMap<>();
	private Node head; //oldest unused
	private Node tail; //least used
	private int capacity;
	private Map<Integer, Integer> cache = new LinkedHashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		Node p = map.get(key);
            update(p);
            return p.value;
    	}
        return -1;
    }
    

	public void put(int key, int value) {
    	if (!map.containsKey(key)) {
    		if (map.size() == capacity) {
    			//remove the oldest unused node
    			Node oldest = removeHead();
   				map.remove(oldest.key);
    		} 
    		Node p = new Node(key, value);
    		addLast(p);
    		map.put(key, p);
    	} else {
    		Node p = map.get(key);
    		p.value = value;
    		update(p);
    	}
    }

	
	private void addLast(Node p) {
		if (head == null && tail == null) {
    		tail = head = p;
    	} else {
    		tail.next = p;
    		p.prev = tail;
    		tail = p;
    		tail.next = null;
    	}
	}
	
	private void update(Node p) {
		if (p != tail) {
			if (p == head) {
				head = head.next;
				head.prev = null;
			} else {
				p.prev.next = p.next;
				p.next.prev = p.prev;
			}
			addLast(p);
		}
		// p == tail -> no update
	}
	
	private Node removeHead() {
		Node oldHead = head;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		return oldHead;
	}
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
//		lru.put(1, 1);
//		lru.put(2, 2);
//		System.out.println(lru.get(1));
//		lru.put(3, 3);
//		System.out.println(lru.get(2));
//		lru.put(4, 4);
//		System.out.println(lru.get(1));
//		System.out.println(lru.get(3));
//		System.out.println(lru.get(4));
		lru.put(2, 1);
		lru.put(1, 1);
		lru.put(2, 3);
		lru.put(4, 1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));	
//		lru.put(3, 2);
//		System.out.println(lru.get(2));
//		System.out.println(lru.get(3));
	}

}
