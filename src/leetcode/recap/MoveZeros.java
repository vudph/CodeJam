package leetcode.recap;

//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int nonzeroIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[nonzeroIdx++] = nums[i];
		}
		for (int i = nonzeroIdx; i < nums.length; i++) {
			nums[i] = 0;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		new MoveZeros().moveZeroes(new int[] {0,2,1,0,3});
	}
}
