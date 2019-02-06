package leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];        
        int even = nums[0];
        for (int i = 2; i < nums.length; i++) {
        	for (int j = i; j < nums.length; j++) {
				
			}
        }
        for (int i = 2; i < nums.length; i+=2) {
			even += nums[i];
		}
        int odd = nums[1];
        
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
