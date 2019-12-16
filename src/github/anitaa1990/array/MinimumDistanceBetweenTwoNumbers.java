package github.anitaa1990.array;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

public class MinimumDistanceBetweenTwoNumbers {
	
	public int findMinimumDistance(int[] arr, int x, int y) {
		List<Integer> indicesX = new ArrayList<>();
		List<Integer> indicesY = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				indicesX.add(i);
			} else if (arr[i] == y) {
				indicesY.add(i);
			}
		}
		//[4, 6, 7, 9]
		//[2, 8, 11]
		// =>Smallest Difference pair of values between two sorted Arrays: using 2 pointers
		int minDst = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < indicesX.size() && j < indicesY.size()) {
			minDst = Math.min(minDst, Math.abs(indicesX.get(i) - indicesY.get(j)));
			if (indicesX.get(i) < indicesY.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		
		return minDst;
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 4, 6, 5, 6, 6, 2, 6, 5, 2};
        int x = 6;
        int y = 2;
//        => 1
        System.out.println(new MinimumDistanceBetweenTwoNumbers().findMinimumDistance(arr, x, y));
	}

}
