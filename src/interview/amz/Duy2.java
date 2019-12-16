package interview.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Duy2 {
	
	List<List<String>> suggest(List<String> repo, String query) {
		List<List<String>> res = new ArrayList<>();
		if (query.length() < 2)
			return res;
		
		Collections.sort(repo);
		for (int i = 2; i <= query.length(); i++) {
			String key = query.substring(0, i);
			List<String> l = repo.stream().filter(w -> w.startsWith(key)).limit(3).collect(Collectors.toList());
			res.add(l);
		}
		return res;
	}
	
//	static class TrieNode {
//		Map<Character, TrieNode> next = new HashMap<>();
//		boolean end;
//		String word;
//	}
//
//	TrieNode root = new TrieNode();
//
//	List<String> suggest(List<String> respo, String query) {
//		if (query.length() < 2)
//			return new ArrayList<>();
//
//		for (String w : respo) {
//			insert(w);
//		}
//		List<String> l = new ArrayList<>();
//		l.addAll(search(query, 2));
//		for (int i = 3; i <= query.length(); i++) {
//			l.addAll(search(query, i));
//		}
//		return null;
//	}
//
//	private List<String> search(String query, int end) {
//		TrieNode node = root;
//		for (int i = 0; i < end; i++) {
//			if (node.next.containsKey(query.charAt(i))) {
//				node = node.next.get(query.charAt(i));
//			} else {
//				return null;
//			}
//		}
//		return null;
//	}
//
//	private void insert(String word) {
//		TrieNode node = root;
//		for (int i = 0; i < word.length(); i++) {
//			if (!node.next.containsKey(word.charAt(i))) {
//				node.next.put(word.charAt(i), new TrieNode());
//			}
//			node = node.next.get(word.charAt(i));
//		}
//		node.end = true;
//		node.word = word;
//	}

	public static void main(String[] args) {
		new Duy2().suggest(Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse");
        
        List<String> stringList = Arrays.asList("1","1");

        stringList.stream()
               .limit(3)
               .forEach(System.out::println);
	}
}
