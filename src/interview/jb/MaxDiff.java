package interview.jb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDiff {

	public static int maxDifference(List<Integer> arr) {
		if (arr.isEmpty()) return -1;
		int minEle = arr.get(0);
		int maxDiff = -1;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) <= minEle) {
				minEle = arr.get(i);
			} else {
				maxDiff = Math.max(maxDiff, arr.get(i) - minEle);
			}
		}
		
		return maxDiff;
	}

	public static void main(String[] args) {
		System.out.println(maxDifference(Arrays.asList(new Integer[] {10,8,7,6,5})));
	}

}
