package leetcode.next1;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

k=3
l = 0, r = 0, 
0,0,1,1,0,0,1,1,1,0, 1, 1, 0, 0, 0, 1, 1, 1, 1
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18

 */
public class MaxConsecutiveOnes {
	
	public int longestOnes(int[] A, int K) {
		int max = 0;
		int l = 0, r = 0;
		
		while (r < A.length) {
			if (K == 0 && A[r] == 0) {
				max = Math.max(max, r - l);
				if (A[l] == 0)
					K++;
				l++;
			} else {
				if (A[r] == 0)
					K--;
				r++;
			}
		}
		max = Math.max(max, r - l);
        return max;
    }

	public static void main(String[] args) {
		System.out.println(new MaxConsecutiveOnes().longestOnes(new int[] {0,0,0,0,0}, 3));
	}

}
