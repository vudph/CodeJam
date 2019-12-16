package github.anitaa1990.array;

/*
 * Find the maximum difference between the values in an array such that the largest values always comes after the
 * smallest value
 * Input: {2, 3, 6, 4, 1, 8, 10}
 * Output: 8
 */
public class FindMaxDifference {
	
	private int findMaxDiff(int nums[]) {
		if (nums.length < 2)
			return -1;
		int minEle = nums[0];
		int maxDiff = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > minEle) {
				maxDiff = Math.max(maxDiff, nums[i] - minEle);
			} else {
				minEle = nums[i];
			}
		}
		return maxDiff;
	}
	
	public static void main(String[] args) {
		System.out.println(new FindMaxDifference().findMaxDiff(new int[]{10,8,7,6,-5}));
	}

}
