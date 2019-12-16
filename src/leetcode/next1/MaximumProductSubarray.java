package leetcode.next1;
/*
https://leetcode.com/problems/maximum-product-subarray/
 [-2, -5, -2,  4,   3]
  -2, 10,-20,-80,-240
-240,120,-24, 12,   3

  
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        int prod1[] = new int[nums.length];
        int prod2[] = new int[nums.length];
        prod1[0] = nums[0];
        prod2[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (prod1[i-1] != 0) {
                prod1[i] = nums[i] * prod1[i-1];
            } else {
                prod1[i] = nums[i];
            }
        }
            
        for (int i = nums.length - 2; i >= 0; i--) {
            if (prod2[i+1] != 0) {
                prod2[i] = prod2[i+1] * nums[i];
            } else {
                prod2[i] = nums[i];
            }
        }
            
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxProd = Math.max(maxProd, Math.max(prod1[i], prod2[i]));
        }
        return maxProd;
    }
	
	public static void main(String[] args) {
		System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2,-5,-2,4,3}));
	}
}
