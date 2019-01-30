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
        
//        int i = 0;
//        while (i < nums.length && k < nums[i])
//        	i++;
//        int windowSum = k - nums[i];
//        int offset = 0;
//        int j = i + 1;
//        while (j < nums.length) {
//        	if (nums[j] == windowSum) {
//        		cnt++;
//        		i = j - offset;
//        		windowSum = k - nums[i];
//        		offset = 0;
//        		System.out.println(j);
//        		j = i + 1;
//        	} else {
//        		if (windowSum < 0) {
//        			i = j;
//        			offset = 0;
//        			windowSum = k - nums[i];
//        			j = i + 1;
//        		} else {
//        			windowSum -= nums[j];
//        			offset++;
//        			j++;
//        		}
//        	}
//        }
        
//        for (int j = i + 1; j < nums.length - 1; j++) {
//        	if (nums[j] == windowSum) {
//        		cnt++;
//        		i = j - offset;
//        		windowSum = k - nums[i];
//        		offset = 0;
//        		j--;
//        	} else {
//        		windowSum -= nums[j];
//        		offset++;
//        		if (windowSum < 0) {
//        			i = j + 1;
//        			offset = 0;
//        			windowSum = k - nums[i];
//        		}
//        	}
//		}
        return cnt;
    }

	public static void main(String[] args) {
		int a[] = new int[]{0,0,0,0,0};
		SubarraySumByK s = new SubarraySumByK();
		System.out.println(s.subarraySum(a, 0));
	}

}
