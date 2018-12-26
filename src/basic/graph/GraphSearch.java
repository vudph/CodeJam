package basic.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class GraphSearch {
	static class Graph {
		int v;
		int e;
		Set<Integer> adj[];
		public Graph(int v, int e) {
			this.v = v;
			this.e = e;
			this.adj = new HashSet[v];
			for (int i = 0; i < v; i++) {
				this.adj[i] = new HashSet<>();
			}
		}
		
		public Set<Integer> getAdj(int u) {
			return this.adj[u];
		}
		
		public void addEdge(int u, int v) {
			this.adj[u].add(v);
		}
	}
	
	private int n;
	private int m;
	private int s;
	private int e;
	private int trace[];
	private boolean visited[];
	
	private static final Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		String[] nmse = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nmse[0]);
		int m = Integer.parseInt(nmse[1]);
		int s = Integer.parseInt(nmse[2]);
		int e = Integer.parseInt(nmse[3]);
		
		int a[][] = new int[n][n];
		Graph g = new Graph(n, m);
		
		for (int i = 0; i < m; i++) {
			String edge[] = scanner.nextLine().split(" ");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			a[u][v] = 1;
			a[v][u] = 1;
			
			g.addEdge(u, v);
			g.addEdge(v, u);
		}
		GraphSearch gs = new GraphSearch();
		gs.n = n;
		gs.m = m;
		gs.s = s;
		gs.e = e;
		gs.visited = new boolean[n];
		Arrays.fill(gs.visited, false);
		gs.trace = new int[n];
		
		gs.visited[s] = true;
		gs.trace[s] = -1;
		
//		gs.bfs(a);
		gs.bfs(g);
		gs.print();

//		gs.dfs(g, s);
//		gs.dfs(a, s);
//		gs.print();
		
		scanner.close();
	}

	private void bfs(int[][] a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v = 0; v < n; v++) {
				if (!visited[v] && a[u][v] == 1 && a[v][u] == 1) {
					visited[v] = true;
					trace[v] = u;
					q.add(v);
				}
			}
		}
	}
	
	private void bfs(Graph g) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : g.getAdj(u)) {
				if (!visited[v]) {
					visited[v] = true;
					trace[v] = u;
					q.add(v);
				}
			}
		}
	}
	
	private void dfs(int a[][], int u) {
		visited[u] = true;
		for (int v = 0; v < n; v++) {
			if (!visited[v] && a[u][v] == 1 && a[v][u] == 1) {
				trace[v] = u;
				dfs(a, v);
			}
		}
	}
	
	private void dfs(Graph g, int u) {
		visited[u] = true;
		for(int v : g.adj[u]) {
			if (!visited[v]) {
				trace[v] = u;
				dfs(g, v);
			}
		}
	}
	
	private void print() {
		if (!visited[e]) {
			System.out.println("Not found");
			return;
		}
 		System.out.print(e + "<-");
		while (s != e) {
			e = trace[e];
			System.out.print(e + "<-");
		}
	}
}

/* input
8 7 0 4
0 1
0 2
1 2
1 3
2 4
3 5
6 7
*/
