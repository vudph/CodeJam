package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/house-robber/
Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

	public int rob(int[] nums) {
//		int rob[] = new int[nums.length];
//		rob[0] = nums[0];
//		rob[1] = nums[1];
//		for (int i = 2; i < nums.length; i++) {
//			rob[i] = Math.max(rob[i - 2] + nums[i], rob[i - 1] - nums[i - 1] + nums[i]);
//		}
//		
//		return Math.max(rob[rob.length - 2], rob[rob.length - 1]);
		
		int prevMax = 0;
	    int currMax = 0;
	    for (int x : nums) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	    }
	    return currMax;
    }

	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {4,2,3,4}));
	}

}
