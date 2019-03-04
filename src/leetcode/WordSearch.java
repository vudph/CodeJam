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
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < word.length(); i++) {
			
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
			}
		}
		return false;
    }
	
	private boolean isValidCell(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
