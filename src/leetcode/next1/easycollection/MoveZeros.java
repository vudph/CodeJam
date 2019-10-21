package leetcode.next1.easycollection;

/*
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

 */

public class MoveZeros {

	public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[j++] = nums[i];
		}
        for (int i = j; i < nums.length; i++) {
        	nums[i] = 0;
        }
        System.out.println();
    }

	public static void main(String[] args) {
		new MoveZeros().moveZeroes(new int[] {5,1,0,5,5});
	}

}
