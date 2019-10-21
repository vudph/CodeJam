package leetcode.next1.trie;

import java.util.HashMap;
import java.util.Map;

import com.sun.jndi.toolkit.dir.SearchFilter;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

 */
public class PrefixTree {
//	static class TrieNode {
//		Map<Character, TrieNode> next = new HashMap<>();
//		boolean end;
//	}
//	
//	private TrieNode root = new TrieNode();
//	
//	/** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode node = root;
//        for(char c : word.toCharArray()) {
//        	if (!node.next.containsKey(c)) {
//        		node.next.put(c, new TrieNode());
//        	}
//        	node = node.next.get(c);
//        }
//        node.end = true;
//    }
//    
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
////    	TrieNode node = root;
////    	for(char c : word.toCharArray()) {
////    		if (node.next.containsKey(c)) {
////    			node = node.next.get(c);
////    		} else {
////    			return false;
////    		}
////    	}
////        return node.end;
//    	TrieNode node = searchPrefix(word);
//    	return node != null && node.end;
//    }
//    
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
////    	TrieNode node = root;
////    	for(char c : prefix.toCharArray()) {
////    		if (node.next.containsKey(c)) {
////    			node = node.next.get(c);
////    		} else {
////    			return false;
////    		}
////    	}
////        return true;
//    	return searchPrefix(prefix) != null;
//    }
//    
//    private TrieNode searchPrefix(String prefix) {
//    	TrieNode node = root;
//    	for(char c : prefix.toCharArray()) {
//    		if (node.next.containsKey(c)) {
//    			node = node.next.get(c);
//    		} else {
//    			return null;
//    		}
//    	}
//        return node;
//    }
	
	static class TrieNode {
		boolean end;
		TrieNode next[] = new TrieNode[26];
	}
	private TrieNode root = new TrieNode();
	
	public void insert(String word) {
		TrieNode node = root;
		for(char c : word.toCharArray()) {
			if (node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}
			node = node.next[c - 'a'];
		}
		node.end = true;
	}
	
	private TrieNode searchPrefix(String prefix) {
		TrieNode node = root;
		for(char c : prefix.toCharArray()) {
			if (node.next[c - 'a'] != null)
				node = node.next[c - 'a'];
			else
				return null;
		}
		return node;
	}

	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.end;
	}
	
	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}
	
	public static void main(String[] args) {
		PrefixTree trie = new PrefixTree();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}

}
