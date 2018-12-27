package problem.icpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://hanoi18.kattis.com/problems/amazingadventures
 * 
 */

public class AmazingAdventures {
	static class Cell {
		int i, j;
		Cell prev = null;
		String direction = null;
		public Cell(int i, int j) {
			this.i = i; this.j = j;
		}
		
		public void setPrev(Cell cell) {
			this.prev = cell;
		}
		
		public void setDirection(String c) {
			this.direction = c;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Cell))
				return false;
			Cell cell = (Cell) obj;
			if (cell.i != this.i || cell.j != this.j)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "(" + i + "," + j + ")";
		}
	}
	
	private static Scanner scanner = new Scanner(System.in);
	private int n;
	private int m;
	private Cell b;
	private Cell c;
	private Cell g;
	private Cell u;
	private int di[] = {-1, 0, 1, 0};
	private int dj[] = {0, 1, 0, -1};
	private boolean visited[][];
	
	private String findShortestPath() {
		visited[u.i][u.j] = true;
		visited[g.i][g.j] = true;
		String b2c = findPath(b, c);
		if (b2c.equals("NO")) {
			return "NO";
		}
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(visited[i], false);
//		}
//		visited[u.i][u.j] = true;
		visited[g.i][g.j] = false;
		String c2g = findPath(c, g);
		String path = c2g.equals("NO") ? "NO" : (b2c + c2g);
		return path;
	}
	
	private String findPath(Cell x, Cell y) {
		visited[x.i][x.j] = true;
		Queue<Cell> q = new LinkedList<>();
		q.add(x);
		while (!q.isEmpty()) {
			Cell cell = q.poll();
			if (cell.equals(y)) {
//				LinkedList<Cell> pathList = new LinkedList<>();
//				while (prev != null) {
//					pathList.addFirst(prev);
//					prev = prev.prev;
//				}
				LinkedList<String> pathList = new LinkedList<>();
				while (cell.prev != null) {
					pathList.addFirst(cell.direction);
					cell = cell.prev;
				}
				StringBuilder sb = new StringBuilder();
				for (String c : pathList) {
					sb.append(c);
				}
				return sb.toString().equals("") ? "NO" : sb.toString();
			}
			for (int k = 0; k < 4; k++) {
				int i = di[k] + cell.i; // k = 0 | U, 1 | R, 2 | D, 3 | L
				int j = dj[k] + cell.j;
				if (isValidCell(i, j) && !visited[i][j]) {
					Cell next = new Cell(i, j);
					q.add(next);
					visited[i][j] = true;
					next.prev = cell;
					switch (k) {
					case 0:
						next.direction = "U";
						break;
					case 1:
						next.direction = "R";
						break;
					case 2:
						next.direction = "D";
						break;
					case 3:
						next.direction = "L";
						break;
					}
				}
			}
		}
		return "NO";
	}
	
	private boolean isValidCell(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m) 
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		AmazingAdventures aa = new AmazingAdventures();
		
		String nm[] = scanner.nextLine().split(" ");
		aa.n = Integer.parseInt(nm[0]);
		aa.m = Integer.parseInt(nm[1]);
		
		String rb[] = scanner.nextLine().split(" ");
		aa.b = new Cell(Integer.parseInt(rb[0]) - 1, Integer.parseInt(rb[1]) - 1);
		
		String rc[] = scanner.nextLine().split(" ");
		aa.c = new Cell(Integer.parseInt(rc[0]) - 1, Integer.parseInt(rc[1]) - 1);
		
		String rg[] = scanner.nextLine().split(" ");
		aa.g = new Cell(Integer.parseInt(rg[0]) - 1, Integer.parseInt(rg[1]) - 1);
		
		String ru[] = scanner.nextLine().split(" ");
		aa.u = new Cell(Integer.parseInt(ru[0]) - 1, Integer.parseInt(ru[1]) - 1);
		
		aa.adjustGrid(aa.b.i, aa.b);
		aa.adjustGrid(aa.c.i, aa.c);
		aa.adjustGrid(aa.g.i, aa.g);
		aa.adjustGrid(aa.u.i, aa.u);

		aa.visited = new boolean[aa.n][aa.m];
		for (int i = 0; i < aa.n; i++) {
			Arrays.fill(aa.visited[i], false);
		}
		
		System.out.println(aa.findShortestPath());
		scanner.close();
		
//		aa.n = 6;
//		System.out.println(aa.calculateOffset(0));
//		System.out.println(aa.calculateOffset(1));
//		System.out.println(aa.calculateOffset(2));
//		System.out.println(aa.calculateOffset(5));
//		System.out.println(aa.calculateOffset(4));
//		System.out.println(aa.calculateOffset(3));
	}
	
	private void adjustGrid(int i, Cell x) {
		int offset;
		offset = n - 1;
		if (i < n / 2) {
			for (int k = 0; k < i; k++) {
				offset = offset - 2;
			}
			x.i = x.i + offset;
		} else {
			for (int k = i; k < n - 1; k++) {
				offset = offset - 2;
			}
			x.i = x.i - offset;
		}
	}
}
/*
3 3
1 1
3 3
2 1
2 2

3 3
1 1
3 3
2 1
2 3

3 4
1 1
3 4
2 1
1 2

2 2
2 1
2 2
1 2
1 1
*/
