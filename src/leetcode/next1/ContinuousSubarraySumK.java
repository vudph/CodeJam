package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Input:nums = [1,1,1], k = 2
Output: 2

 */
public class ContinuousSubarraySumK {
	
	public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        //brute force
//        for (int i = 0; i < nums.length; i++) { // array with 1 element is also subarray
//        	for (int j = i; j < nums.length; j++) {
//				int sum = 0;
//				for (int l = i; l <= j; l++) {
//					sum += nums[l];
//				}
//				if (sum == k) {
//					cnt++;
//				} 
//			}
//        }
        
        // brute force with cumulative
//        int sumUp[] = new int[nums.length];
//        sumUp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//			sumUp[i] = sumUp[i - 1] + nums[i];
//		}
//        for (int begin = 0; begin < nums.length; begin++) { // array with 1 element is also subarray
//			for (int end = begin; end < nums.length; end++) {
//				int s = sumUp[end] - sumUp[begin] + nums[begin];
//				if (s == k) {
//					cnt++;
//				}
//			}
//		}
        
        // hashmap => cumulative idea
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        seen.put(0, 1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
			int target = sum - k;
			if (seen.containsKey(target))
				cnt += seen.get(target);
			seen.put(sum, seen.getOrDefault(sum, 0) + 1);
		}
        return cnt;
    }

	public static void main(String[] args) {
		System.out.println(new ContinuousSubarraySumK().subarraySum(new int[] {1,2,3}, 3));
	}

}
