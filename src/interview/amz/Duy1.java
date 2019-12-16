package interview.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Duy1 {
	static class Cell {
		int x, y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	int minimumDays(int rows, int columns, List<List<Integer>> grid) {
		int days = 0;
		Queue<Cell> q = new LinkedList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid.get(i).get(j) == 1) {
					q.add(new Cell(i, j));
				}
			}
		}
		
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		while (!q.isEmpty()) {
			int qsize = q.size();
			boolean hasUpdated = false;
			for (int i = 0; i < qsize; i++) {
				Cell c = q.poll();
				for (int k = 0; k < 4; k++) {
					int x = c.x + dx[k];
					int y = c.y + dy[k];
					if (validCell(x, y, rows, columns) && grid.get(x).get(y) == 0) {
						grid.get(x).set(y, 1);
						q.add(new Cell(x, y));
						hasUpdated = true;
					}
				}
			}
			if (hasUpdated)
				days++;
		}
		
		return days;
	}
	
	private boolean validCell(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(0,1,1,0,1));
		grid.add(Arrays.asList(0,1,0,1,0));
		grid.add(Arrays.asList(0,0,0,0,1));
		grid.add(Arrays.asList(0,1,0,0,0));
		System.out.println(new Duy1().minimumDays(grid.size(), grid.get(0).size(), grid));
	}

}
