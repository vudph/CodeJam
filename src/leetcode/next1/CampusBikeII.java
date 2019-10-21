package leetcode.next1;

/*
https://leetcode.com/problems/campus-bikes-ii/
 

 */

public class CampusBikeII {
	int minSum = Integer.MAX_VALUE;
	public int assignBikes(int[][] workers, int[][] bikes) {
		int dist[][] = new int[workers.length][bikes.length];
		
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[0].length; j++) {
				dist[i][j] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
			}
		}
		
//		int distances[][] = new int[][] {{3,6,2},{4,2,1},{2,5,3}};
		boolean visitedBikes[] = new boolean[bikes.length];
		dfs(dist, visitedBikes, 0, 0);
        return minSum;
    }
	
	private void dfs(int[][] dist, boolean visitedBikes[], int worker, int sofar) {
		if (worker == dist.length) {
			minSum = Math.min(minSum, sofar);
			return;
		}
		for (int i = 0; i < visitedBikes.length; i++) {
			if (!visitedBikes[i]) {
				visitedBikes[i] = true;
				dfs(dist, visitedBikes, worker + 1, sofar + dist[worker][i]);
				visitedBikes[i] = false;
			}
		}
	}
    
	public static void main(String[] args) {
		System.out.println("====: " + new CampusBikeII().assignBikes(new int[][] {{0,0}, {2,1}}, new int[][] {{1,2}, {3,3}}));
	}
}
