package leetcode.next1.easycollection;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Input: [
		[2,1,1],
		[1,1,0],
		[0,1,1]
	   ]
Output: 4

2,1,1     2,2,1    2,2,2    2,2,2    2,2,2
1,1,0  -> 2,1,0 -> 2,2,0 -> 2,2,0 -> 2,2,0
0,1,1     0,1,1    0,1,1    0,2,1    0,2,2
=> 4

2,1,1    2,2,1    2,2,2
0,1,1 -> 0,1,1 -> 0,2,2
1,0,1    1,0,1    1,0,2
=> -1

 */
public class RottingOranges {
	static class Cell {
		int x, y, min;
		public Cell(int i, int j, int l) {
			this.x = i; this.y = j; this.min = l;
		}
	}

	public int orangesRotting(int[][] grid) {
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		int mins = 0;
		Queue<Cell> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2)
					q.add(new Cell(i, j, 0));
			}
		}
		while (!q.isEmpty()) {
			Cell u = q.poll();
			mins = Math.max(mins, u.min);
			for (int k = 0; k < 4; k++) {
				int x = u.x + dx[k];
				int y = u.y + dy[k];
				if (validCell(x, y, grid.length, grid[0].length) && grid[x][y] == 1) {
					grid[x][y] = 2;
					q.add(new Cell(x, y, u.min + 1));
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}
		return mins;
    }
	
//	static class Cell {
//		int x, y;
//		public Cell(int i, int j) {
//			this.x = i; this.y = j;
//		}
//	}
//
//	public int orangesRotting(int[][] grid) {
//		int dx[] = {-1, 0, 1, 0};
//		int dy[] = {0, 1, 0, -1};
//		int mins = 0;
//		Queue<Cell> q = new LinkedList<>();
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				if (grid[i][j] == 2)
//					q.add(new Cell(i, j));
//			}
//		}
//		while (!q.isEmpty()) {
//			int n = q.size();
//			boolean hasUpdated = false;
//			for (int i = 0; i < n; i++) {
//				Cell u = q.poll();
//				for (int k = 0; k < 4; k++) {
//					int x = u.x + dx[k];
//					int y = u.y + dy[k];
//					if (validCell(x, y, grid.length, grid[0].length) && grid[x][y] == 1) {
//						grid[x][y] = 2;
//						q.add(new Cell(x, y));
//						hasUpdated = true;
//					}
//				}
//			}
//			if (hasUpdated)
//				mins++;
//		}
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				if (grid[i][j] == 1)
//					return -1;
//			}
//		}
//		return mins;
//    }

	private boolean validCell(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new RottingOranges().orangesRotting(new int[][]{{0}}));
		System.out.println(Integer.MAX_VALUE);
	}

}
