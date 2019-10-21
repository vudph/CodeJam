package leetcode.next1.easycollection;
/*
https://leetcode.com/problems/rotate-image/

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 */
public class RotateImage {
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// transpose matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
			System.out.println();
		}
		System.out.println();
    }

	public static void main(String[] args) {
		
		int[][] matrix = {
							{ 5, 1, 9,11},
							{ 2, 4, 8,10},
							{13, 3, 6, 7},
							{15,14,12,16}
						 };
		
		/*
		 * [ 5, 2,13,15] reverse: 15,13, 2, 5 
		 * [ 1, 4, 3,14]          14, 3, 4, 1  
		 * [ 9, 8, 6,12]          12, 6, 8, 9
		 * [11, 10,7,16]          16, 7,10,11 
		 * 
		 */
		new RotateImage().rotate(matrix );
	}

}
