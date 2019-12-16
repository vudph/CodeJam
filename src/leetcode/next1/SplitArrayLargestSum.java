package leetcode.next1;

public class SplitArrayLargestSum {

	int m, n;
	int[] nums;

	public int splitArray(int[] nums, int m) {
		this.nums = nums;
		this.n = nums.length;
		this.m = m;

		// try binary search to arrive at min largest sum
		// min could be any one element - max element of array
		// if you use lowerbound to be min element - you will get incorrect results
		// since your numberOfPArts you can split into method would not yield correct
		// results
		// why - try it out - to understand
		// upper bounds of sum could be sum of all elements
		int l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			l = Math.max(nums[i], l);
			r += nums[i];
		}

		int rslt = Integer.MAX_VALUE;
		while (l <= r) {
			int midsum = l + (r - l) / 2;
			int numParts = findNumParts(midsum);
			if (numParts > m) {
				l = midsum + 1;
			} else if (numParts <= m) {
				r = midsum - 1;
				rslt = Math.min(rslt, midsum);
			}
		}
		return rslt;
	}

	// given a target sum see how many parts
	// you can split nums into
	public int findNumParts(int tgtsum) {
		int nparts = 1; // at least one
		int runsum = 0;
		for (int i = 0; i < n; i++) {
			if (runsum + nums[i] <= tgtsum) {
				runsum += nums[i];
			} else {
				runsum = nums[i];
				nparts++;
			}
		}
		return nparts;
	}

	public static void main(String[] args) {
		System.out.println(new SplitArrayLargestSum().splitArray(new int[] {7,2,5,10,8}, 2));
	}

}
