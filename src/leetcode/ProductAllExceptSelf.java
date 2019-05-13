package leetcode;
/*
 https://leetcode.com/problems/product-of-array-except-self/
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

 */
public class ProductAllExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int prod[] = new int[nums.length];
        prod[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
			prod[i] = prod[i-1] * nums[i];
		}	
        int tmp = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
			prod[i] = prod[i-1] * tmp;
			tmp = tmp * nums[i];
		}
        prod[0] = tmp;
        return prod;
    }

	public static void main(String[] args) {
		int nums[] = {2, 3, 0, 4};
		ProductAllExceptSelf p = new ProductAllExceptSelf();
		p.productExceptSelf(nums);
	}

}
