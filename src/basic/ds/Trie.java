package basic.ds;

public class Trie {

	static class TrieNode {
		TrieNode children[] = new TrieNode[26];
		boolean end;
		
		public boolean contains(char ch) {
			return children[ch - 'a'] != null;
		}
		
		public void put(char ch, TrieNode node) {
			children[ch - 'a'] = node;
		}
		
		public TrieNode get(char ch) {
			return children[ch - 'a'];
		}
	}
	
	private void buildTrie(TrieNode root, String[] strs) {
		for (String str : strs) {
			TrieNode node = root;
			for (int i = 0; i < str.length(); i++) {
				if (!node.contains(str.charAt(i))) {
					node.put(str.charAt(i), new TrieNode());					
				}
				node = node.get(str.charAt(i));
			}
			node.end = true;
		}
	}
	
	public boolean search(String word, String[] strs) {
		TrieNode root = new TrieNode();
		buildTrie(root, strs);
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.contains(word.charAt(i))) {
				node = node.get(word.charAt(i));
			} else {
				return false;
			}
		}
		return node.end;
	}
	
	public static void main(String[] args) {
		System.out.println(new Trie().search("code", new String[] {"lee","leetcode","lead", "le", "cab", "abc", "code"}));
	}

}
