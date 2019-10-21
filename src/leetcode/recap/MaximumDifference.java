package leetcode.recap;

import java.util.Arrays;
import java.util.List;

public class MaximumDifference {
	
	public int maxDifference(int a[]) {
		int maxDiff = Integer.MIN_VALUE;
		int minEle =a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < minEle) {
				minEle = a[i];
			} else {
				maxDiff = Math.max(maxDiff, a[i] - minEle);
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		MaximumDifference d = new MaximumDifference();
		System.out.println(d.maxDifference(new int[]{7,1,5,3,6,4}));
	}

}
