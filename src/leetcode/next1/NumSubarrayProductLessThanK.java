package leetcode.next1;

/*
https://leetcode.com/problems/subarray-product-less-than-k/

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 
 */

public class NumSubarrayProductLessThanK {
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        int product = nums[start];
        
        while (start < nums.length && end < nums.length) {
        	if (product < k) {
        		end++;
        		if (start <= end ) {
        			count += end - start;
        		}
        		if (end < nums.length) {
        			product *= nums[end];
        		}
        	} else {
        		product /= nums[start];
        		start++;
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
	}

}
