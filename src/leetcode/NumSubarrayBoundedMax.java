package leetcode;
/*
https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input: 
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

*/
public class NumSubarrayBoundedMax {

	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int count = 0;
		int lp[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				
			}
		}
		return count;
    }

	public static void main(String[] args) {
		NumSubarrayBoundedMax c = new NumSubarrayBoundedMax();
		System.out.println(c.numSubarrayBoundedMax(new int[] {2,9,1,5,6},2,8));
	}

}
