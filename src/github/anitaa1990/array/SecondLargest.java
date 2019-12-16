package github.anitaa1990.array;

public class SecondLargest {
	
	private int findSecondMax(int nums[]) {
		if (nums.length < 2)
			return -1;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max1) {
				max2 = max1;
				max1 = nums[i];
			} else if (nums[i] > max2 && nums[i] != max1) {
				max2 = nums[i];
			}
		}
		
		return max2;
	}

	public static void main(String[] args) {
		System.out.println(new SecondLargest().findSecondMax(new int[] {2, 3, 10, 6, 4, 8, 1, 10}));
	}

}
