package leetcode;
// https://leetcode.com/problems/subarray-sum-equals-k/
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
// 8, 5, 0, 3, 2, 0, 3, 6, 2, 1, 2, 0, 2, 9 => (5, 0), (0, 3, 2), (3, 2, 0),  (2, 0, 3), (2, 1, 2), (1, 2, 0, 2)
public class SubarraySumByK {

	public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
        	int s = 0;
			for (int j = i; j < nums.length; j++) {
				s += nums[j];
				if (s == k) {
					cnt++;
				}
			}
		}
        
        return cnt;
    }

	public static void main(String[] args) {
		int a[] = new int[]{8, 5, 0, 3, 2, 0, 3, 6, 2, 1, 2, 0, 2, 9};
		SubarraySumByK s = new SubarraySumByK();
		System.out.println(s.subarraySum(a, 0));
	}

}
