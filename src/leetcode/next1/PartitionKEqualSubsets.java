package leetcode.next1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

 */

public class PartitionKEqualSubsets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (k <= 0 || sum % k != 0)
			return false;

		boolean[] visited = new boolean[nums.length];
		return canPartition(nums, visited, 0, k, 0, sum / k);
	}

	private boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int target) {
		if (k == 1)
			return true;
		if (currentSum > target)
			return false;
		if (currentSum == target)
			return canPartition(nums, visited, 0, k - 1, 0, target);

		for (int i = startIndex; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// System.out.println(i);
				if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], target)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new PartitionKEqualSubsets()
				.canPartitionKSubsets(new int[] {1,2,1,1,3,3,4,5}, 4));// 4, 3, 2, 3, 5, 2, 1},
																								// 4));
	}

}
