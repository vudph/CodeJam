package basic.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MountainWalk {
	static class Cell {
		int x, y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	int dx[] = {1, 0, -1, 0};
	int dy[] = {0, -1, 0, 1};
	
	public int cellsVisited(String areaMap[], int heightDiff) {
		int x = 0, y = 0, cnt = 1;
		boolean visited[][] = new boolean[areaMap.length][areaMap[0].length()];
		visited[x][y] = true;
		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(x, y));
		while (!queue.isEmpty()) {
			Cell currCell = queue.poll();
			System.out.print(currCell.toString() + "->");
			for (int k = 0; k < 4; k++) {
				int nextX = currCell.x + dx[k];
				int nextY = currCell.y + dy[k];
				if (isValidCell(nextX, nextY, areaMap.length, areaMap[0].length()) 
						&& !visited[nextX][nextY]) {
					int currHeight = areaMap[currCell.x].charAt(currCell.y);
					int nextHeight = areaMap[nextX].charAt(nextY);
					if (Math.abs(currHeight - nextHeight) <= heightDiff) {
						visited[nextX][nextY] = true;
						queue.add(new Cell(nextX, nextY));
						cnt++;
						break;
					}
				}
			}		
		}
		return cnt;
	}

	private boolean isValidCell(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) {
		MountainWalk mw = new MountainWalk();
		System.out.println(mw.cellsVisited(new String[] {"0000",
				 "0000",
				 "0000",
				 "0000",
				 "9999",
				 "8888",
				 "7777",
				 "6666",
				 "5555",
				 "4444",
				 "3333",
				 "2222",
				 "1111",
				 "0000"}, 3));
	}

}
