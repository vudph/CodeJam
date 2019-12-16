package leetcode.next1;

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


2, 1, 4, 3

Count of all elements smaller than or equal to R: count(A, R) = count(A, 3) => number of all possible subarrays: 
Count of all elements smaller than L: count(A, L-1) = 1 => countSubarrays(1)=1*2/2=1

 */

public class NumSubarrayBoundedMax {
	
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int a = count(A, R);
        int b = count(A, L-1);
		return a - b;
    }
	
	public int count(int A[], int bound) {
    	int cnt = 0;
    	int res = 0;
    	for (int i = 0; i < A.length; i++) {
			if (A[i] <= bound) {
				cnt++;
			} else {
				res += countPossibleSubarray(cnt);
				cnt = 0;
			}
		}    	
    	return res + countPossibleSubarray(cnt);
    }

	private int countPossibleSubarray(int n) {
    	return n * (n + 1)/2;
    }

	public static void main(String[] args) {
		NumSubarrayBoundedMax c = new NumSubarrayBoundedMax();
		System.out.println(c.numSubarrayBoundedMax(new int[] {3, 4, 1}, 2, 4));
	}

}
