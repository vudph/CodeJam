package leetcode;

public class NumMatrix {
	private int matrix[][];
	private int[][] dp;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
        System.out.println();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            for (int j = col1; j <= col2; j++) {
//                sum += matrix[i][j];
//            }
//        }
//        return sum;
    	int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }
    
    public static void main(String[] args) {
		NumMatrix num = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
		num.sumRegion(2,1,4,3);
	}
}
