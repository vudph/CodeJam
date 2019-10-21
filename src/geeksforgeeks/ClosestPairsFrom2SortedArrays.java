package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class ClosestPairsFrom2SortedArrays {

	void printClosest(int ar1[], int ar2[], int x) {
		int m = ar1.length;
		int n = ar2.length;
		// Initialize the diff between pair sum and x.
		int diff = Integer.MAX_VALUE;

		// res_l and res_r are result indexes from ar1[] and ar2[]
		// respectively
		int res_l = 0, res_r = 0;

		// Start from left side of ar1[] and right side of ar2[]
		int l = 0, r = n - 1;
		List<Pair> res = new ArrayList<>();
		while (l < m && r >= 0) {
			// If this pair is closer to x than the previously
			// found closest, then update res_l, res_r and diff
			if (Math.abs(ar1[l] + ar2[r] - x) <= diff) {
				res_l = l;
				res_r = r;
				
				if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
					// clear
					res.clear();
				}
				diff = Math.abs(ar1[l] + ar2[r] - x);
				res.add(new Pair(res_l, res_r));
			}

			// If sum of this pair is more than x, move to smaller
			// side
			if (ar1[l] + ar2[r] > x)
				r--;
			else // move to the greater side
				l++;
		}

		// Print the result
		System.out.print("The closest pair is [" + ar1[res_l] + ", " + ar2[res_r] + "]");
	}
	
	static class Pair {
		int l, r;
		public Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}

	public static void main(String[] args) {
		new ClosestPairsFrom2SortedArrays().printClosest(new int[] {3000,5000,7000,10000}, 
														 new int[] {2000,3000,4000,5000}, 10000);
	}
}
