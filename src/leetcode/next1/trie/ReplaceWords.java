package leetcode.next1.trie;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/replace-words/

Input: dict = ["cat", "bat", "rat", "ca"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 
 */
public class ReplaceWords {
	static class TrieNode {
		boolean end;
		TrieNode next[] = new TrieNode[26];
	}
	
	private TrieNode root = new TrieNode();
	
	private void buildTrie(List<String> dict) {
		for (String word : dict) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();
				}
				node = node.next[c - 'a'];
			}
			node.end = true;
		}
	}
	
	private String getRoot(String word) {
		TrieNode node = root;
		String ret = "";
		for (char c : word.toCharArray()) {
			if (node.next[c - 'a'] == null) {
				return word;
			}
			node = node.next[c - 'a'];
			ret += c;
			if (node.end) {
				break;
			}
		}
		return ret;
	}
	
	public String replaceWords(List<String> dict, String sentence) {
		buildTrie(dict);
        String words[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
//        for (String w : words) {
//        	int i = 0;
//        	String root = "";
//        	while (i < dict.size()) {
//        		if (w.startsWith(dict.get(i))) {
//        			if (!root.equals("") && dict.get(i).length() < root.length() || root.equals("")) {
//        				root = dict.get(i);
//        			}
//        		}
//        		i++;
//        	}
//        	if (i == dict.size() && root.equals("")) {
//        		sb.append(w);
//        	} else {
//        		sb.append(root);
//        	}
//        	sb.append(" ");
//        }
        for (String w : words) {
        	if (sb.length() > 0)
        		sb.append(" ");
        	String root = getRoot(w);
        	sb.append(root);
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat", "ca", "th", "the"), "the cattle was rattled by the battery"));
	}

}
