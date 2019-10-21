package basic.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAdjList {
	static class Vertex implements Comparable<Vertex> {
		String v;
		List<Edge> adj;
		boolean visited;
		Vertex predecessor;
		double dist = Double.MAX_VALUE;

		public Vertex(String v) {
			this.v = v;
			this.adj = new ArrayList<>();
		}

		public void addNeighbour(Edge edge) {
			this.adj.add(edge);
		}

		@Override
		public String toString() {
			return v;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(dist, o.dist);
		}
	}

	static class Edge {
		double weight;
		Vertex src;
		Vertex dst;

		public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
			this.weight = weight;
			this.src = startVertex;
			this.dst = targetVertex;
		}
	}

	public void computeShortestPaths(Vertex src) {
		src.dist = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(src);
		src.visited = true;

		while (!pq.isEmpty()) {
			Vertex u = pq.poll(); // Getting the minimum distance vertex from priority queue
			for (Edge edge : u.adj) {
				Vertex v = edge.dst;
				if (!v.visited) {
					double newDist = u.dist + edge.weight;
					if (newDist < v.dist) {
						pq.remove(v);
						v.dist = newDist;
						v.predecessor = u;
						pq.add(v);
					}
				}
			}
			u.visited = true;
		}
	}

	public List<Vertex> getShortestPathTo(Vertex targetVertex) {
		List<Vertex> path = new ArrayList<>();
		for (Vertex v = targetVertex; v != null; v = v.predecessor) {
			path.add(v);
		}

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");

		vertexA.addNeighbour(new Edge(10, vertexA, vertexC));
		vertexA.addNeighbour(new Edge(17, vertexA, vertexB));
		vertexC.addNeighbour(new Edge(5, vertexC, vertexB));
		vertexC.addNeighbour(new Edge(9, vertexC, vertexD));
		vertexC.addNeighbour(new Edge(11, vertexC, vertexE));
		vertexB.addNeighbour(new Edge(1, vertexB, vertexD));
		vertexD.addNeighbour(new Edge(6, vertexD, vertexE));

		DijkstraAdjList shortestPath = new DijkstraAdjList();
		shortestPath.computeShortestPaths(vertexA);

		System.out.println("======================================");
		System.out.println("Calculating minimum distance");
		System.out.println("======================================");

		System.out.println("Minimum distance from A to B: " + vertexB.dist);
		System.out.println("Minimum distance from A to C: " + vertexC.dist);
		System.out.println("Minimum distance from A to D: " + vertexD.dist);
		System.out.println("Minimum distance from A to E: " + vertexE.dist);

		System.out.println("=====================	=================");
		System.out.println("Calculating Paths");
		System.out.println("======================================");

		System.out.println("Shortest Path from A to B: " + shortestPath.getShortestPathTo(vertexB));
		System.out.println("Shortest Path from A to C: " + shortestPath.getShortestPathTo(vertexC));
		System.out.println("Shortest Path from A to D: " + shortestPath.getShortestPathTo(vertexD));
		System.out.println("Shortest Path from A to E: " + shortestPath.getShortestPathTo(vertexE));
	}
}
