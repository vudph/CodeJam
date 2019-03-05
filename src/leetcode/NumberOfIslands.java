package leetcode;
/*
https://leetcode.com/problems/number-of-islands/
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class NumberOfIslands {
	int dx[] = {-1, 0, 1, 0};
	int dy[] = {0, 1, 0, -1};
	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					dfs(grid, n, m, visited, i, j);
					count++;
				}
			}
		}
        return count;
    }
	
	private void dfs(char[][] grid, int n, int m, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (isValidCell(n, m, x, y) && !visited[x][y] && grid[x][y] == '1') {
				dfs(grid, n, m, visited, x, y);
			}
		}
	}

	private boolean isValidCell(int n, int m, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		return true;
	}

	public static void main(String[] args) {
		NumberOfIslands ni = new NumberOfIslands();
		char grid[][] = {{'1','1','0','0','0'},
						 {'1','1','0','0','0'},
						 {'0','0','1','0','0'},
						 {'0','0','0','1','1'}};
		System.out.println(ni.numIslands(grid));
	}
}
