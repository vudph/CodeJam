package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadderII {
	static class Graph {
		Map<String, Set<String>> adj = new HashMap<>();
		Set<String> vertices;
		public Graph(Set<String> vertices) {
			this.vertices = vertices;
			for (String vertex : vertices) {
				adj.put(vertex, new HashSet<>());
			}
		}
		
		public void addEdge(String u, String v) {
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return new ArrayList<>();
		}
		Set<String> vertices = new HashSet<>(wordList);
		vertices.add(beginWord);
		vertices.add(endWord);
		Graph g = contructGraph(vertices);
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		Map<String, Integer> distance = new HashMap<>();
		for (String vertex : vertices) {
			distance.put(vertex, Integer.MAX_VALUE);
		}
		distance.put(beginWord, 0);
		
		Map<String, Set<String>> prev = new HashMap<>();
		prev.put(beginWord, new HashSet<>());
		while (!q.isEmpty()) {
			String u = q.poll();
			for (String v : g.adj.get(u)) {
				if (distance.get(v) == Integer.MAX_VALUE) {
					q.add(v);
					distance.put(v, distance.get(u) + 1);
					Set<String> pre = prev.get(v);
					if (pre == null) {
						pre = new HashSet<>();
					}
					pre.add(u);
					prev.put(v, pre);
				} else if (distance.get(v) == distance.get(u) + 1) {
					Set<String> pre = prev.get(v);
					if (pre == null) {
						pre = new HashSet<>();
					}
					pre.add(u);
					prev.put(v, pre);
				}
			}
		}
		List<List<String>> paths = new ArrayList<>();
		Stack<String> currPath = new Stack<>();
		dfs(paths, currPath, beginWord, endWord, prev);
		return paths;
    }
	
	private void dfs(List<List<String>> paths, Stack<String> currPath, String begin, String node, Map<String, Set<String>> prev) {
		currPath.push(node);
		if (node.equals(begin)) {
			List<String> l = new ArrayList<>(currPath);
			Collections.reverse(l);
			paths.add(l);
		}
		if (prev.get(node) != null) {
			for (String pre : prev.get(node)) {
				dfs(paths, currPath, begin, pre, prev);
			}
			currPath.pop();
		}
		
	}

	private Graph contructGraph(Set<String> vertices) {
		Graph g = new Graph(vertices);
		for (String word : vertices) {
			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a';  ch <= 'z'; ch++) {
					String newWord = changeCharAt(i, ch, word);
					if (!newWord.equals(word) && vertices.contains(newWord)) {
						g.addEdge(word, newWord);
					}
				}
			}
		}		
        return g;
	}

	private String changeCharAt(int i, char ch, String s) {
		return s.substring(0, i) + ch + s.substring(i + 1);
	}

	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		wl.findLadders("hot", "dog", Arrays.asList("hot","dog"));
	}

}
