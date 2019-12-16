package leetcode.next1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 https://leetcode.com/problems/surrounded-regions/
 
X X X X     X X X X
X O O X  -> X X X X
X X O X     X X X X
X O X X     X O X X

X X X X X    X X X X X
X O O O X    X X X X X
X X O X O -> X X X X O
X O X X X    X X X X X
X X X X X    X X X X X


X X X X X    X X X X X
X O O O X    X O O O X
X X O O O -> X X O O O
X O X X X    X X X X X
X X X X X    X X X X X

X X X X X    X X X X X
X O X O X    X X X X X
X X X O X -> X X X X X
X O X X X    X X X X X
X X X X X    X X X X X
 */
public class SurroundedRegions {
	static class Cell {
		int x, y;
		public Cell(int i, int j) {x = i; y = j;}
	}
	
	public void solve(char[][] board) {
		if (board.length <= 1 || board[0].length <= 1)
			return;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O') {
					spread(i, j, board);
				}
			}
		}
//		[X, 1, X, X, X]
//		[X, 1, 1, 1, X]
//		[X, X, 1, X, X]
//		[X, O, X, O, X]
//		[X, X, X, X, X]
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '1')
					board[i][j] = 'O';
				else 
					board[i][j] = 'X';
			}
		}
    }

	private void spread(int u, int v, char[][] board) {
		board[u][v] = '1';
		Queue<Cell> q = new LinkedList<>();
		q.add(new Cell(u, v));
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		while (!q.isEmpty()) {
			Cell c = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = c.x + dx[k];
				int y = c.y + dy[k];
				if (validCell(x, y, board.length, board[0].length) && board[x][y] == 'O') {
					q.add(new Cell(x, y));
					board[x][y] = '1';
				}
			}
		}
	}
	
	private boolean validCell(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new SurroundedRegions().solve(new char[][]{
													{'X', 'O', 'X', 'X', 'X'}, 
													{'X', 'O', 'O', 'O', 'X'},
													{'X', 'X', 'O', 'X', 'X'},
													{'X', 'O', 'X', 'O', 'X'},
													{'X', 'X', 'X', 'X', 'X'},
												});
	}

}
