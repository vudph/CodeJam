package basic.graph;

import java.util.Scanner;

public class Warshall {
	private static Scanner scanner = new Scanner(System.in);
	private int v;
	private int e;
	private int a[][];
	
	private int[][] transitiveClosure() {
		int reach[][] = new int[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				reach[i][j] = a[i][j];
			}
		}
		for (int k = 0; k < v; k++) {
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					reach[i][j] = reach[i][j] == 1 || (reach[i][k] == 1 && reach[k][j] == 1) ? 1 : 0;
				}
			}
		}
		return reach;
	}
	
	public static void main(String[] args) {
		Warshall w = new Warshall();
		String ve[] = scanner.nextLine().split(" ");
		w.v = Integer.parseInt(ve[0]);
		w.e = Integer.parseInt(ve[1]);
		w.a = new int[w.v][w.v];
		for (int i = 0; i < w.v; i++) {
			w.a[i][i] = 1;
		}
		for (int i = 0; i < w.e; i++) {
			String adj[] = scanner.nextLine().split(" ");
			int u = Integer.parseInt(adj[0]);
			int v = Integer.parseInt(adj[1]);
			w.a[u][v] = 1;
		}
		int reach[][] = w.transitiveClosure();
		scanner.close();
	}

}
