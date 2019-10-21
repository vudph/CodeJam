package basic.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConquestCampaign {
	static class Cell {
		int i, j;
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (! (obj instanceof Cell)) return false;
			Cell c = (Cell) obj;
			if (i != c.i || j != c.j)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "(" + i + "," + j + ")";
		}
	}
	int n, m;
	int a[][];
	Queue<Cell> queue = new LinkedList<>();
	int dx[] = {-1, 0, 1, 0};
	int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		ConquestCampaign cc = new ConquestCampaign();
		Scanner sc = new Scanner(System.in);
		String readln[] = sc.nextLine().split(" ");
		cc.n = Integer.parseInt(readln[0]);
		cc.m = Integer.parseInt(readln[1]);
		int initialConqueredCells = Integer.parseInt(readln[2]);
		cc.a = new int[cc.n][cc.m];
		for(int i = 0; i < initialConqueredCells; i++) {
			readln = sc.nextLine().split(" ");
			int x = Integer.parseInt(readln[0]);
			int y = Integer.parseInt(readln[1]);
			Cell cell = new Cell(x, y);
			cc.a[x][y] = 1;
			cc.queue.add(cell);
		}
		sc.close();
		System.out.println(cc.calculateDayToConquer());
//		2 3 6
//		0 0
//		0 1
//		0 2
//		1 0
//		1 1
//		1 2
	}


	private int calculateDayToConquer() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			bfs();
		}
		return cnt;
	}
	
	private void bfs() {
		Queue<Cell> nextQueue = new LinkedList<>();
		while(!queue.isEmpty()) {
			Cell currCell = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = dx[k] + currCell.i;
				int j = dy[k] + currCell.j;
				if (isValidCell(i, j) && a[i][j] == 0) {
					nextQueue.add(new Cell(i, j));
					a[i][j] = 1;
				}
			}
		}
		queue = nextQueue;
	}


	private boolean isValidCell(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		return true;
	}
}
