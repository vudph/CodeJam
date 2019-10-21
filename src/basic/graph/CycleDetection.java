package basic.graph;

import java.util.LinkedList;
import java.util.List;

public class CycleDetection {
	List<Integer> adj[];
	
	public boolean detectCycle(int n, int edge[][]) {
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			int src = edge[i][1];
			int dest = edge[i][0];
			adj[src].add(dest);
		}
		
		boolean recStack[] = new boolean[n];
		boolean visited[] = new boolean[n];
		
		for (int u = 0; u < n; u++) {
			if (!visited[u] && isCyclic(u, visited, recStack)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isCyclic(int u, boolean[] visited, boolean[] recStack) {
		if (recStack[u]) return true;
		
		visited[u] = true;
		recStack[u] = true;
		for (int v : adj[u]) {
			if (isCyclic(v, visited, recStack)) {
				return true;
			}
		}
		recStack[u] = false;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CycleDetection().detectCycle(3, new int[][] {{1,0}, {2,1}, {0,2}}));
	}

}
