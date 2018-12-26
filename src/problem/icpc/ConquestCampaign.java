package problem.icpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://hanoi18.kattis.com/problems/conquestcampaign
 */
public class ConquestCampaign {
	static class Cell {
		int i, j;
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Cell))
				return false;
			Cell c = (Cell) obj;
			if (c.i != this.i || c.j != this.j)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "(" + i + "," + j + ")";
		}
	}
	private static Scanner scanner = new Scanner(System.in);
	private int r;
	private int c;
	private int n;
	private boolean visited[][];
	private Queue<Cell> queue = new LinkedList<>();
	private int dx[] = {-1, 0, 1, 0};
	private int dy[] = {0, 1, 0, -1};
	
	private void bfs() {
		Queue<Cell> dayQueue = new LinkedList<>();
		while (!queue.isEmpty()) {
			Cell cell = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = cell.i + dx[k];
				int j = cell.j + dy[k];
				if (isValidCell(i, j) && !visited[i][j]) {
					visited[i][j] = true;
					dayQueue.add(new Cell(i, j));
				}
			}
		}
		queue = dayQueue;
	}
	
	private int dayToConquer() {
		int count  = 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j]) {
					bfs();
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean isValidCell(int i, int j) {
		if (i < 0 || i >= r || j < 0 || j >= c)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		ConquestCampaign cc = new ConquestCampaign();
		
		String rcn[] = scanner.nextLine().split(" ");
		cc.r = Integer.parseInt(rcn[0]);
		cc.c = Integer.parseInt(rcn[1]);
		cc.n = Integer.parseInt(rcn[2]);
		cc.visited = new boolean[cc.r][cc.c];
		for (int i = 0; i < cc.n; i++) {
			String xy[] = scanner.nextLine().split(" ");
			int x = Integer.parseInt(xy[0]) - 1;
			int y = Integer.parseInt(xy[1]) - 1;
			if (!cc.visited[x][y]) {
				cc.visited[x][y] = true;
				cc.queue.add(new Cell(x, y));
			}
		}
		System.out.println(cc.dayToConquer());
		scanner.close();
	}

}
/*
3 4 3
2 2
2 2
3 4
*/