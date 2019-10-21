package leetcode.next1;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/365872/

A=[51,71,17,42] => return 93. There are 2 pairs of numbers whose digits add up to an equal sum: (51,42) and (17,71)
A=[42,33,60] => 102. Pair (42,60) digits of numbers add up to the same sum
A=[51,32,43] => -1. All numbers have digits that add up to different, unique sums.

 */
public class MaxSumOfPairDigits {

	public int getMaxSum(int a[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxSum = -1;
		for (int i = 0; i < a.length; i++) {
			int sumDigits = getSumDigits(a[i]);
			if (!map.containsKey(sumDigits)) {
				map.put(sumDigits, a[i]);
				continue;
			}
			maxSum = Math.max(maxSum, a[i] + map.get(sumDigits));
			map.put(sumDigits, Math.max(a[i], map.get(sumDigits)));
		}
		return maxSum;
	}
	
	private int getSumDigits(int n) {
		int s = 0;
		while (n != 0) {
			s += n % 10;
			n = n / 10;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSumOfPairDigits().getMaxSum(new int[] {51, 32, 43, 15}));
	}
}
