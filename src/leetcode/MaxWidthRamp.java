package leetcode;

import java.util.Arrays;

public class MaxWidthRamp {

	public int maxWidthRamp(int[] A) {
        int maxWidth = 0;
//        for (int i = A.length - 1; i >= 0; i--) {
//        	int currMaxWidth = 0;
//			for (int j = 0; j < i; j++) {
//				if (A[j] <= A[i]) {
//					currMaxWidth = Math.max(currMaxWidth, i - j);
//					break;
//				}
//			}
//			maxWidth = Math.max(maxWidth, currMaxWidth);
//		}
        
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));
        
        int minEle = B[0];
        for (int i = 1; i < B.length; i++) {
			if (B[i] < minEle)
				minEle = B[i];
			else 
				maxWidth = Math.max(maxWidth, B[i] - minEle);
		}
        
        return maxWidth;
    }

	public static void main(String[] args) {
		System.out.println(new MaxWidthRamp().maxWidthRamp(new int[] {9,8,1,0,1,9,4,0,4,1}));
	}

}
