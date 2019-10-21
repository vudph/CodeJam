package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
	
	public String longestCommonPrefixNaive(String[] strs) {
		if (strs.length == 0) return "";
		String minS = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < minS.length()) {
				minS = strs[i];
			}
		}
		
		int lenPrefix = minS.length();
		while (lenPrefix > 0) {
			int i = 0;
			for (i = 0; i < strs.length; i++) {
				if (!strs[i].substring(0, lenPrefix).equals(minS.substring(0, lenPrefix)) ) {
					lenPrefix--;
					break;
				}
			}
			if (i == strs.length) {
				return minS.substring(0, lenPrefix);
			}
		}
		return "";
	}
	
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		boolean end;
	}
	
	public String longestCommonPrefix(String[] strs) {
		TrieNode root = new TrieNode();
		buildTrie(root, strs);
		StringBuilder sb = new StringBuilder();
		TrieNode node = root;
		while (node.children.size() == 1 && !node.end) {
			char ch = node.children.keySet().iterator().next();
			sb.append(ch);
			node = node.children.get(ch);
		}
		return sb.toString();
	}
	
	private void buildTrie(TrieNode root, String[] strs) {
		for (String str : strs) {
			TrieNode node = root;
			for (int i = 0; i < str.length(); i++) {
				if (!node.children.containsKey(str.charAt(i))) {
					node.children.put(str.charAt(i), new TrieNode());					
				}
				node = node.children.get(str.charAt(i));
			}
			node.end = true;
		}
	}

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(new String[] {"","b"}));
	}

}
