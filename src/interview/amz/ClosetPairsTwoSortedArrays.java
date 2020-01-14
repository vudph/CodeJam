package interview.amz;

import java.util.ArrayList;
import java.util.List;

public class ClosetPairsTwoSortedArrays {
	
	public List<List<Integer>> findClosestPairs(int ar1[], int ar2[], int x) {
		int diff = Integer.MAX_VALUE;
		int l = 0;
		int r = ar2.length - 1;
		int resl = 0;
		int resr = 0;
		List<List<Integer>> res = new ArrayList<>();
		while (l < ar1.length && r >= 0) {
			if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
				resl = l;
				resr = r;
				System.out.println("l=" + l + ", r=" + r);
				diff = Math.abs(ar1[l] + ar2[r] - x);
			}
			if (ar1[l] + ar2[r] < x)
				l++;
			else 
				r--;
		}
		
		return null;
	}

	public static void main(String[] args) {
		new ClosetPairsTwoSortedArrays().findClosestPairs(new int[] {3,3,5,7,10}, new int[] {0,2,3,4,5}, 10);
	}

}
