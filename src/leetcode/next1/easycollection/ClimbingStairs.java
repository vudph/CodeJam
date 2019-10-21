package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/climbing-stairs/

Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/
public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1)
			return 1;
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
        	int tmp = b;
			b = a + b;
			a = tmp;
		}
        return b;
    }
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(5));
	}

}
