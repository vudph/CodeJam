package basic.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
		@Override
		public String toString() {
			return "(" + u + "-" + v + "=" + w + ")";
		}
	}
	
	private int V, E;
	public List<Edge> adj[];
	
	public WeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int u, int v, int w) {
		Edge edge = new Edge(u, v, w);
		adj[u].add(edge);
	}
	
	public int V() {return V;}
	public int E() {return E;}
	
}
