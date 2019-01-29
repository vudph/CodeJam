package leetcode;

public class MaximumProductSubarray {
	
	public int maxProduct(int[] a) {
		int currMax = a[0];
		int currMin = currMax;
		int max = currMax;
		for (int i = 1; i < a.length; i++) {
			int tmpMin = Math.min(Math.min(currMax*a[i], currMin*a[i]), a[i]);
			int tmpMax = Math.max(Math.max(currMax*a[i], currMin*a[i]), a[i]);
			
			currMin = tmpMin;
			currMax = tmpMax;
			
			max = Math.max(currMax, max);
//			tmpMax = Math.max(tmpMax*a[i], a[i]);
//			max = Math.max(max, tmpMax);
		}
		return max;
	}

	public static void main(String[] args) {
		int nums[] = {-2,3,4,-2};
		System.out.println(new MaximumProductSubarray().maxProduct(nums));
	}

}