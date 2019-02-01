package leetcode;

import java.util.Arrays;

/*
 https://leetcode.com/problems/product-of-array-except-self/
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
 */
public class ProductExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		int tmp = 1;
	    for (int i = 0; i < nums.length; i++) {
	        result[i] = tmp;
	        tmp *= nums[i];
	    }
	    tmp = 1;
	    for (int i = nums.length - 1; i >= 0; i--) {
	        result[i] *= tmp;
	        tmp *= nums[i];
	    }
	    return result;
//		int products[] = new int[nums.length];
//		int k = 0;
//		while (k < nums.length && nums[k] == 0)
//			k++;
//		if (k == nums.length) {
//			Arrays.fill(products, 0);
//			return products;
//		}
//        int all = 1;
//        boolean hasZero = false;
//        for (int i = 0; i < nums.length; i++) {
//        	if (nums[i] != 0)
//        		all *= nums[i];
//        	else 
//        		hasZero = true;
//		}
//        for (int i = 0; i < nums.length; i++) {
//        	if (hasZero) {
//        		if (nums[i] != 0)
//        			products[i] = 0;
//        		else 
//        			products[i] = all;
//        	} else {
//        		products[i] = all / nums[i];
//        	}
//		}
//        return products;
    }

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4};
		ProductExceptSelf p = new ProductExceptSelf();
		p.productExceptSelf(a);
	}
}
