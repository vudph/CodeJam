package github.anitaa1990.array;

import java.util.HashMap;
import java.util.Map;

/* 
 https://www.hackerrank.com/challenges/minimum-distances/problem
 
 return the minimum distance between any two matching elements.
 
  7 1 3 4 1 7
  => 3
 */
public class MinDiffInArray {
	
	private int minimumDistances(int[] a) {
		Map<Integer, Integer> seen = new HashMap<>();
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (seen.containsKey(a[i])) {
				minDist = Math.min(minDist, Math.abs(i - seen.get(a[i])));
			}
			seen.put(a[i], i);
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

	public static void main(String[] args) {
		System.out.println(new MinDiffInArray().minimumDistances(new int[] {7, 1, 3, 4, 1, 7, 1, 3, 3}));
	}

}
