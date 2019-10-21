package ardendertat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WorkTransformation {
	static class Graph {
		int v;
		Map<String, Set<String>> adj = new HashMap<>();
		public Graph(int v, List<String> dict) {
			this.v = v;
			for (String w : dict) {
				adj.put(w, new HashSet<>());
			}
		}
		
		public void addEdge(String u, String v) {
			adj.get(u).add(v);
		}
	}
	
	public List<String> transform(List<String> dict, String s, String e) {
		Graph g = constructGraph(dict.size(), dict);
		Queue<String> q = new LinkedList<>();
		q.add(s);
		Map<String, String> trace = new HashMap<>();
		while (!q.isEmpty()) {
			String v = q.poll();
			if (v.equals(e)) break;
			for (String u : g.adj.get(v)) {
				if (!trace.containsKey(u)) {
					trace.put(u, v);
					q.add(u);
				}
			}
		}
		if (!trace.containsKey(e))
			return null; //no path found
		String currWord = e;
		Stack<String> tempRes = new Stack<>();
		tempRes.push(currWord);
		while (currWord != s) {
			currWord = trace.get(currWord);
			tempRes.push(currWord);
		}
		String t = tempRes.pop();
		List<String> res = tempRes.subList(0, tempRes.size());
		return res;
	}

	private Graph constructGraph(int size, List<String> dict) {
		Graph g = new Graph(dict.size(), dict);
		for (String word : dict) {
			for (int i = 0; i < word.length(); i++) {
				// remove a char at index
				String newWord;
				newWord = removeCharAt(i, word);
				if (dict.contains(newWord)) {
					g.addEdge(word, newWord);
					g.addEdge(newWord, word);
				}
				for (char ch = 'a'; ch <= 'z'; ch++) {
					// change a char by another char at index
					newWord = changeCharAt(i, ch, word);
					if (!newWord.equals(word) && dict.contains(newWord)) {
						g.addEdge(word, newWord);
						g.addEdge(newWord, word);
					}
					// add a char by another char at index
					newWord = addCharAt(i, ch, word);
					if (dict.contains(newWord)) {
						g.addEdge(word, newWord);
						g.addEdge(newWord, word);
					}
				}
			}
		}
		return g;
	}

	private String addCharAt(int i, char ch, String word) {
		return word.substring(0, i) + ch + word.substring(i, word.length());
	}

	private String changeCharAt(int i, char ch, String word) {
		return word.substring(0, i) + ch + word.substring(i + 1, word.length());
	}

	private String removeCharAt(int i, String word) {
		return word.substring(0, i) + word.substring(i + 1, word.length());
	}

	public static void main(String[] args) {
		new WorkTransformation().transform(Arrays.asList("cat", "bat", "bet", "bed", "at", "ad", "ed"), "cat", "bed");
	}

}
