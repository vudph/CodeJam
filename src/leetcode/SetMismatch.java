package leetcode;

/*
https://leetcode.com/problems/set-mismatch/

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Input: nums = [1,2,2,4]
Output: [2,3]

https://www.geeksforgeeks.org/cycle-sort/
 */

public class SetMismatch {
	
	public int[] findErrorNums(int[] nums) {
//		int bucket[] = new int[nums.length + 1];
//		for (int i = 0; i < nums.length; i++) {
//			bucket[nums[i]]++;
//		}
//		
//		int res[] = new int[2];
//		for (int i = 1; i < bucket.length; i++) {
//			if (bucket[i] == 2) {
//				res[0] = i;
//			} else if (bucket[i] == 0) {
//				res[1] = i;
//			}
//		}
//		return res;
		
		// cyclic sort
		int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }
	
	private void cycleSort(int[] nums) {
		int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        System.out.println();
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		SetMismatch sm = new SetMismatch();
//		sm.findErrorNums(new int[] {2,1,2,4,3});
		sm.cycleSort(new int[] {2,1,2,4,3});
	}

}
