package leetcode.recap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */

public class WordDictionary {
	
	static class TrieNode {
		Map<Character, TrieNode> next = new HashMap<>();
		boolean end;
	}
	
	TrieNode root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
    	root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
			if (!node.next.containsKey(word.charAt(i))) {
				node.next.put(word.charAt(i), new TrieNode());
			}
			node = node.next.get(word.charAt(i));
		}
    	node.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int idx, TrieNode node) {
    	for (int i = idx; i < word.length(); i++) {
    		if (word.charAt(i) != '.') {
    			if (node.next.containsKey(word.charAt(i))) {
    				node = node.next.get(word.charAt(i));
    			} else {
    				return false;
    			}
    		} else {
    			for (TrieNode tn : node.next.values()) {
					if (searchHelper(word, i + 1, tn)) {
						return true;
					}
				}
    			return false;
    		}
		}
    	return node.end;
	}

	public boolean searchPrefix(String word) {
    	TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
			if (!node.next.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.next.get(word.charAt(i));
		}
    	return node.end;
    }
    
    public String longestPrefix() {
    	TrieNode node = root;
    	StringBuilder sb = new StringBuilder();
    	while (node.next.size() == 1) {
    		char key = node.next.keySet().iterator().next();
    		sb.append(key);
    		node = node.next.get(key);
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("leet");
		dict.addWord("leave");
		dict.addWord("let");
		System.out.println(dict.longestPrefix());
/*
 
 root
 |
 l
 |
 e
 | \ \
 e  a t
 |  |
 t  v
    |
    e
   
 */
		System.out.println(dict.searchPrefix("let"));
		System.out.println(dict.search("let"));
	}
}
