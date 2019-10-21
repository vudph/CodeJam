package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
// 8, 5, 0, 3, 2, 0, 3, 6, 2, 1, 2, 0, 2, 9 => (5, 0), (0, 3, 2), (3, 2, 0),  (2, 0, 3), (2, 1, 2), (1, 2, 0, 2)
public class SubarraySumByK {

	public int subarraySum(int[] nums, int k) {
        int cnt = 0;
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//        	int s = 0;
//			for (int j = i; j < nums.length; j++) {
//				s += nums[j];
//				if (s == k) {
//					cnt++;
//					res.add(i + "," + j);
//				}
//			}
//		}
        cnt = sumK(nums, k);
        return cnt;
    }
	
	private int sumK(int nums[], int k) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		int cnt = 0;
		sumMap.put(0, 1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];			
			int target = sum - k;
			if (sumMap.containsKey(target)) {
				cnt += sumMap.get(target);
			}
			sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		}
		return cnt;
	}

	
	public int countSubArrayByK(int nums[], int k) {
		int count = 0;
		Map<Integer, Integer> seen = new HashMap<>();
		int sum = 0;
		seen.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int target = sum - k;
			if (seen.containsKey(target)) {
				count += seen.get(target);
			}
			seen.put(sum, seen.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
	
	public int findLongestSubArrayByK(int nums[], int k) {
		int longest = 0;
		Map<Integer, Integer> seen = new HashMap<>();
		seen.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int target = sum - k;
			if (seen.containsKey(target)) {
				longest = Math.max(longest, i - seen.get(target));
			}
			seen.put(sum, seen.getOrDefault(sum, i));
		}
		return longest;
	}
	
	public int findShortestSubarrayByK(int[] nums, int k) {
        int shortest = Integer.MAX_VALUE;
		Map<Integer, Integer> seen = new HashMap<>();
		seen.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int target = sum - k;
			if (seen.containsKey(target)) {
				shortest = Math.min(shortest, i - seen.get(target));
			}
			seen.put(sum, seen.getOrDefault(sum, i));
		}
		return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
	
	public static void main(String[] args) {
		int a[] = new int[]{48,99,37,4,-31};
		SubarraySumByK s = new SubarraySumByK();
		System.out.println(s.findShortestSubarrayByK(a, 140));
	}

}
