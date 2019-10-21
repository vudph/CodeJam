package basic.graph;

import java.util.PriorityQueue;

public class DijkstraMatrix {
	static class Node implements Comparable<Node>{
		int v;
		int dist;
		
		public Node(int v, int dist) {
			this.v = v; this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return dist - o.dist;
		}
		
	}
	int prev[], dist[];
	int a[][];
	int n;
	static int INF = Integer.MAX_VALUE;
	
	public DijkstraMatrix(int a[][]) {
		this.a = a;
		this.n = a.length; //number of vertex;
		this.prev = new int[n];
		this.dist = new int[n];
	}
	
	private void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[s] = 0;
		for (int i = 0; i < n; i++) {
			if (i != s) {
				dist[i] = Integer.MAX_VALUE;
			}
			prev[i] = -1;
		}
		pq.add(new Node(s, dist[s]));
		
		while (!pq.isEmpty()) {
			Node u = pq.poll(); //vertex in q with min dist[u]
			for (int v = 0; v < a.length; v++) {
				if (a[u.v][v] != INF) {
					int alt = dist[u.v] + a[u.v][v];
					if (alt < dist[v]) {
						dist[v] = alt;
						prev[v] = u.v;
						pq.add(new Node(v, alt));
					}
				}
			}
			
		}
		printPath(s, 3);
	}
	
	private void printPath(int s, int t) {
		System.out.println("path " + s + " to " + t + ": " + dist[t]);
		if (prev[t] != -1) {
			System.out.print(t + "<-");
			int curr = prev[t];
			while (curr != s) {
				System.out.print(curr + "<-");
				curr = prev[curr];
			}
			System.out.print(s);
		}
	}

	public static void main(String[] args) {
		
		int a[][] = {{0,4,INF,INF,INF,INF,INF,8,INF},
					 {4,0,8,INF,INF,INF,INF,11,INF},
					 {INF,8,0,7,INF,4,INF,INF,2},
					 {INF,INF,7,0,9,14,INF,INF,INF},
					 {INF,INF,INF,9,0,10,INF,INF,INF},
					 {INF,INF,4,14,10,0,2,INF,INF},
					 {INF,INF,INF,INF,INF,2,0,1,6},
					 {8,11,INF,INF,INF,INF,1,0,7},
					 {INF,INF,2,INF,INF,INF,6,7,0}
					};
		DijkstraMatrix dj = new DijkstraMatrix(a);
		dj.dijkstra(0);
	}

}
