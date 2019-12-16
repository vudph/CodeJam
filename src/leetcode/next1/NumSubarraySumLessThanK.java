package leetcode.next1;

/*
https://www.geeksforgeeks.org/number-subarrays-sum-less-k/

Input : arr[] = {2, 5, 6}
        K = 10
Output : 4
The subarrays are {2}, {5}, {6} and {2, 5}

Input : arr[] = {1, 11, 2, 3, 15}
        K = 10
Output : 4
{1}, {2}, {3} and {2, 3}

 */
public class NumSubarraySumLessThanK {
	
	public int findNumSubarray(int A[], int k) {
		int count = 0;
		int start = 0;
		int end = 0;
		int sum = A[start];
		
		while (start < A.length && end < A.length) {
			if (sum < k) {
				end++;
				if (start <= end) {
					count += (end - start);
				}
				if (end < A.length) {
					sum += A[end];
				}
			} else {
				sum -= A[start];
				start++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new NumSubarraySumLessThanK().findNumSubarray(new int[] {1, 11, 2, 3, 15}, 10));
	}

}
