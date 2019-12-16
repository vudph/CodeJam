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


2, 1, 4, 3

Count of all elements smaller than or equal to R: count(A, R) = count(A, 3) => number of all possible subarrays: 
Count of all elements smaller than L: count(A, L-1) = 1 => countSubarrays(1)=1*2/2=1

*/
public class NumSubarrayBoundedMax {

	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int count = 0;
		
		/* naive thinking
		for (int i = 0; i < A.length; i++) {
			int cnt = 0;
			for (int j = i; j < A.length; j++) {
				if (A[j] > R)
					break;
				if (cnt == 0 && A[j] < L) {
					continue;
				}
				if (A[j] <= R)
					cnt++;
			}
			if (i > 0)
				count += cnt;
			else 
				count = cnt;
		}
		int lp[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int cnt = 0;
			for (int j = i; j < A.length; j++) {
				if (A[j] > R)
					break;
				if (cnt == 0 && A[j] < L) {
					continue;
				}
				if (A[j] <= R)
					cnt++;
			}
			if (i > 0)
				lp[i] = lp[i-1] + cnt;
			else 
				lp[i] = cnt;
		}
		return lp[A.length-1];
		*/
		
		int prevHigh = 0, prevIn = 0, res = 0;
		int dp[] = new int[A.length + 1];
		for (int i = 1; i <= A.length; ++i) {
			if (A[i - 1] < L) {
				dp[i] = dp[prevIn];
			} else if (A[i - 1] > R) {
				prevHigh = prevIn = i;
			} else {
				dp[i] = i - prevHigh;
				prevIn = i;
			}
		}
		for (int e : dp) {
			res += e;
		}
		return res;
//		return count;
    }
	
	public int numSubarrayBoundedMax1(int[] A, int L, int R) {
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
	
    public int count0(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
            System.out.println(ans);
        }
        return ans;
    }
    
    public int count1(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            if (x <= bound) {
            	cur++;
            	int cntSubArray = countPossibleSubarray(cur);
           		ans += cntSubArray;
            } else {
            	cur = 0;
            }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		NumSubarrayBoundedMax c = new NumSubarrayBoundedMax();
		System.out.println(c.numSubarrayBoundedMax1(new int[] {3, 4, 1}, 2, 4));
//		System.out.println(c.numSubarrayBoundedMax(new int[] {73,55,36,5,55,14,9,7,72,52},32,69));
	}

}
