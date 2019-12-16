package leetcode.next1;
/*
https://leetcode.com/problems/check-if-it-is-a-straight-line/

 */
public class CheckStraightLine {
	
	public boolean checkStraightLine(int[][] coordinates) {
		int nrow = coordinates.length;
		int x1 = coordinates[0][0], y1 = coordinates[0][1];
		int x2 = coordinates[1][0], y2 = coordinates[1][1];
		double slope = (double) (y2 - y1) / (x2 - x1);

		for (int row = 1; row < nrow - 1; row++) {

			x1 = coordinates[row][0];
			y1 = coordinates[row][1];
			x2 = coordinates[row + 1][0];
			y2 = coordinates[row + 1][1];
			double nextslope = (double) (y2 - y1) / (x2 - x1);

			if (slope != nextslope) {
				return false;
			}

		}

		return true;
    }

	public static void main(String[] args) {
		new CheckStraightLine().checkStraightLine(new int[][] {{1,2}, {1,3}, {1,4}});
	}

}
