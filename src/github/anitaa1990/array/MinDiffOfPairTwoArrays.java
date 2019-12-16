package github.anitaa1990.array;

import java.util.Arrays;

/*
 https://www.geeksforgeeks.org/smallest-difference-pair-values-two-unsorted-arrays/
  
 Input : A[] = {1, 3, 15, 11, 2}
        B[] = {23, 127, 235, 19, 8} 
Output : 3  
That is, the pair (11, 8) 

Input : A[] = {10, 5, 40}
        B[] = {50, 90, 80} 
Output : 10
That is, the pair (40, 50)

 */
public class MinDiffOfPairTwoArrays {
	public static int findSmallestDifference(int A[], int B[]) {
		Arrays.sort(A);
		Arrays.sort(B);
		//1, 2, 3, 11, 15
		//8,19,23,127,235
		// i = 0, j = 0, B[j] - A[i] = 7, if increase j = 1, B[j] = 19 => bigger distance than 7 (19-1 = 18), so increase index of smaller item  
		int minDiff = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			minDiff = Math.min(minDiff, Math.abs(A[i] - B[j]));
			if (A[i] < B[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		return minDiff;
	}
	
	public static void main(String[] args) {
		System.out.println(findSmallestDifference(new int[] {1, 3, 15, 11, 2}, new int[] {23, 127, 235, 19, 8}));
	}

}
