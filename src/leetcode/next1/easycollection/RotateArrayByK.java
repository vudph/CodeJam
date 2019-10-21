package leetcode.next1.easycollection;
/*
https://leetcode.com/problems/rotate-array/

Example 1:
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */

public class RotateArrayByK {

	public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
        	int lastEle = nums[nums.length - 1];
			for (int j = nums.length - 2; j >= 0; j--) {
				nums[j + 1] = nums[j];
			}
			nums[0] = lastEle;
			System.out.println();
		}
        System.out.println();
    }
	
	public void rotateByReverse(int nums[], int k) {
		if (k <= 0)
			return;
		k = k % nums.length;
		//reverse entire array: 1,2,3,4,5,6,7 -> 7,6,5,4,3,2,1
		reverse(nums, 0, nums.length - 1);
		
		//reverse k first ele: k=3 7,6,5,4,3,2,1 -> 5,6,7,4,3,2,1
		reverse(nums, 0, k - 1);
		
		//reverse n-k last ele: k=3, n=7 5,6,7,4,3,2,1 -> 5,6,7,1,2,3,4
		reverse(nums, k, nums.length - 1);
		System.out.println();
	}

	private void reverse(int[] nums, int l, int r) {
		while (l >= 0 && l <= r && r < nums.length) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		new RotateArrayByK().rotateByReverse(new int[] {1, 2}, 1);
	}

}
