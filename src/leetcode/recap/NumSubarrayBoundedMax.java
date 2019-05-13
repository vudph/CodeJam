package leetcode.recap;

/*
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3]

(2,9,1,5,6} L=2, R=8
=> 2, 1-5, 1-5-6, 5, 5-6, 6

2, 9, 1, 5, 6
1, 1, 1, 3,  
*/

public class NumSubarrayBoundedMax {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int cnt = 0;
		int lp[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			if (A[i] >= L && A[i] <= R) {
				
			}
		}
		
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] > R)
//				continue;
//			if (A[i] >= L)
//				cnt++;
//			for (int j = i + 1; j < A.length; j++) {
//				if (A[j] > A[i] && (A[j] < L || A[j] > R))
//					break;
//				if (A[i] >= A[j] && (A[i] >= L && A[i] <= R))
//					cnt++;
//				else if (A[j] >= L && A[j] <= R)
//					cnt++;
//			}
//		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(new NumSubarrayBoundedMax().numSubarrayBoundedMax(new int[] {73,55,36,5,55,14,9,7,72,52},32,69));
	}

}
