package leetcode.recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/*
Input:
precursor steps: [["clean", "build"], ["metadata", "binary"], ["build", "link"], ["link", "binary"], ["clean", metadata"], ["build", "resources"]]

Output:
[["clean"], ["build", "metadata"], ["resources", "link"], ["binary"]]

          clean
         /     \
      build      metadata
      /   \          /        
resources  link     /
             \     /
              binary
              
 */

public class ParallelCourseII {

	public List<List<String>> parallelSteps(List<List<String>> relations) {
		Map<String, List<String>> adj = new HashMap<>();
		Map<String, Integer> indegree = new HashMap<>();
		for (List<String> rel : relations) {
			if (!adj.containsKey(rel.get(0))) {
				adj.put(rel.get(0), new ArrayList<>());
			}
			adj.get(rel.get(0)).add(rel.get(1));
			if (!indegree.containsKey(rel.get(0))) {
				indegree.put(rel.get(0), 0);
			}
			indegree.put(rel.get(1), indegree.getOrDefault(rel.get(1), 0) + 1);
		}
		Queue<String> q = new LinkedList<>();
		Iterator<Entry<String, Integer>> iter = indegree.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			if (entry.getValue() == 0) {
				q.offer(entry.getKey());
			}
		}
		List<List<String>> res = new ArrayList<>();
		while (!q.isEmpty()) {
			List<String> subres = new ArrayList<>();
			for (int i = q.size(); i > 0; i--) {
				String u = q.poll();
				if (adj.containsKey(u)) {
					for (String v : adj.get(u)) {
						indegree.put(v, indegree.get(v) - 1);
						if (indegree.get(v) == 0) {
							q.offer(v);
						}
					}
				}
				subres.add(u);
			}
			res.add(subres);					
		}
		return res;
	}
	
	public static void main(String[] args) {	
		new ParallelCourseII().parallelSteps(Arrays.asList(
												Arrays.asList("clean", "build"), 
												Arrays.asList("metadata", "binary"), 
												Arrays.asList("build", "link"), 
												Arrays.asList("link", "binary"), 
												Arrays.asList("clean", "metadata"), 
												Arrays.asList("build", "resources"), 
												Arrays.asList("test", "metadata")
											));
	}

}
