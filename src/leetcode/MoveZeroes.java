package leetcode;
/*
https://leetcode.com/problems/move-zeroes/

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */
public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
//		bubble sort approach => O(n)
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = 0; j < nums.length - i - 1; j++) {
//				if (nums[j] == 0) {
//					swap(j, j + 1, nums);
//				}
//			}
//		}
//		int lastNonZeroFoundAt = 0;
//	    for (int i = 0; i < nums.length; i++) {
//	        if (nums[i] != 0) {
//	            nums[lastNonZeroFoundAt++] = nums[i];
//	        }
//	    }
//	    for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
//			nums[i] = 0;
//		}
		int lastNonZeroFoundAt = 0;
		for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != 0) {
	            swap(lastNonZeroFoundAt++, i, nums);
	            System.out.println();
	        }
	    }
	    System.out.println();
    }
	
	public void bubble(int nums[]) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(j, j + 1, nums);
				}
			}
		}
		System.out.println();
	}

	private void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
//		m.bubble(new int[] {4, 1, 3, 5, 1, 7, 2});
		m.moveZeroes(new int[] {1,0,3,0,12});
	}

}
