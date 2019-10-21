package leetcode.next1.easycollection;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    
 */
public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		Set<Character> rows[] = new HashSet[9];
		Set<Character> cols[] = new HashSet[9];
		Set<Character> boxes[] = new HashSet[9];
		
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					int boxIdx = (i/3)*3 + j/3;
					boolean x = rows[i].add(board[i][j]);
					boolean y = cols[j].add(board[i][j]);
					boolean z = boxes[boxIdx].add(board[i][j]);
					if (!x || !y || !z) {
						return false;
					}
				}
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}

}
