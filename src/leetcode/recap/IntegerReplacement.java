package leetcode.recap;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
	
	public int integerReplacement(int n) {
		Map<Long, Integer> cache = new HashMap<>();
		int t = helper(n, cache);
		return t;
	}

	private int helper(long n) {
		if (n == 1) {
			return 0;
		}
		if (n % 2 == 0) {
			return helper(n/2) + 1;
		} else {
			return Math.min(helper(n + 1) + 1, helper(n - 1) + 1);
		}
	}
	
	private int helper(long n, Map<Long, Integer> cache) {
		if (cache.containsKey(n)) {
			System.out.println("hit: " + n + ", val= " + cache.get(n));
			return cache.get(n);
		}
		if (n == 1) {
			return 0;
		}
		int res;
		if (n % 2 == 0) {
			res = helper(n/2, cache) + 1;
		} else {
			res = Math.min(helper(n + 1, cache) + 1, helper(n - 1, cache) + 1);
		}
		cache.put(n, res);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new IntegerReplacement().integerReplacement(77777));
	}

}
