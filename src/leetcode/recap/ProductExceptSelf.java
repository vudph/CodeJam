package leetcode.recap;

public class ProductExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
		int products[] = new int[nums.length];
		products[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			products[i] = products[i-1] * nums[i];
		}
		int x = 1;
		for (int i = nums.length - 1; i >= 1; i--) {
			products[i] = products[i-1] * x;
			x *= nums[i];
		}
		products[0] = x;
		for (int i = 0; i < products.length; i++) {
			System.out.print(products[i] + ",");
		}
		return products;
	}
	

	public static void main(String[] args) {
		int nums[] = {1, 2, 0, 3};
		new ProductExceptSelf().productExceptSelf(nums);
	}

}
