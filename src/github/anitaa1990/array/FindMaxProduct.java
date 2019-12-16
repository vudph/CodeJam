package github.anitaa1990.array;

/*
 *  Find the 3 numbers in an array that produce the max product
 *  Input: {10, 3, 5, 6, 20}
 *  Output: 1200
 * */

public class FindMaxProduct {
	
	private long findMaxProduct(int arr[]) {
		if (arr.length < 3) {
			return -1;
		}
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int minNeg1 = Integer.MAX_VALUE, minNeg2 = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minNeg1) {
				minNeg2 = minNeg1;
				minNeg1 = arr[i];
			} else if (arr[i] < minNeg2) {
				minNeg2 = arr[i];
			}
			if (arr[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = arr[i];				
			} else if (arr[i] > max2) {
				max3 = max2;
				max2 = arr[i];
			} else if (arr[i] > max3) {
				max3 = arr[i];
			}
		}
		
		return Math.max(max1 * max2 * max3, max1 * minNeg1 * minNeg2);
		
//		int max = arr[0];
//		int maxProductOfTwo = max * arr[1];
//		for (int i = 2; i < arr.length; i++) {
//			maxProductOfTwo = Math.max(maxProductOfTwo, max * arr[i]);
//			max = Math.max(max, arr[i]);
//		}
//		System.out.println("---- " + maxProductOfTwo);
		
	}

	public static void main(String[] args) {
		System.out.println(new FindMaxProduct().findMaxProduct(new int[] {-4,-3,-2,-1,60})); // -60,-4,-3,-2,-1
	}

}
