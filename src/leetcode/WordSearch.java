package leetcode;
/*
https://leetcode.com/problems/word-search/
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		char ch = word.charAt(0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == ch) {
					boolean visited[][] = new boolean[n][m];
					Boolean found[] = new Boolean[1];
					found[0] = false;
					dfs(board, n, m, word, i, j, visited, 1, found);
					if (found[0])
						return true;
				}
			}
		}
		return false;
    }
	
	private void dfs(char[][] board, int n, int m, String word, int x, int y, boolean visited[][], int idx, Boolean found[]) {
		if (idx == word.length()) {
			found[0] = true;
			return;
		}
		visited[x][y] = true;
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		for (int k = 0; k < 4; k++) {
			int u = x + dx[k];
			int v = y + dy[k];
			if (isValidCell(u, v, n, m) && !visited[u][v] && board[u][v] == word.charAt(idx)) {
				int id = idx + 1;
				dfs(board, n, m, word, u, v, visited, id, found);
				visited[u][v] = false;
			}
		}
	}
	
	private boolean isValidCell(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char board[][] = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(ws.exist(board, word));
	}

}
