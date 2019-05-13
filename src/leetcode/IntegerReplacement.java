package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerReplacement {
	public int integerReplacement0(int n) {
		Map<Long, Integer> cache = new HashMap<>();
		int cnt = count(n, cache);
		return cnt;
    }
	
	public int integerReplacement1(int n) {
		List<Integer> dp = new ArrayList<>();
		dp.add(0);
		dp.add(1);
		
		return 0;
    }
	
	private int count(long n, Map<Long, Integer> cache) {
		if (cache.containsKey(n)) {
			System.out.println("hit: " + n + ", val= " + cache.get(n));
			return cache.get(n);
		}
		if (n > 1) {
			int cnt = 1;
			if (n % 2 == 0) 
				cnt += count(n/2, cache);
			else
				cnt += Math.min(count(n-1, cache), count(n+1, cache));
			cache.put(n, cnt);
			return cnt;
		}
		return 0;
	}
	
	private int count(long n) {
		if (n == 1)
			return 1;

		if (n % 2 == 0) 
			return count(n/2) + 1;
		return Math.min(count(n-1) + 1, count(n+1) + 1);
	}
	
	private int helper(long n, Map<Long, Integer> cache) {
		if (cache.containsKey(n)) {
			System.out.println("hit: " + n + ", val= " + cache.get(n));
			return cache.get(n);
		}
		if (n > 1) {
			int cnt = 0;
			if (n % 2 == 0) {
				cnt = count(n/2, cache) + 1;
				cache.put(n, cnt);
				return cnt;
			} else {
				int cnt0 = 0, cnt1 = 1;
				cnt0 = count(n-1, cache) + 1;
				cnt1 = count(n+1, cache) + 1;
				cnt = Math.min(cnt0, cnt1);
				cache.put(n, cnt);
				return cnt;
			}
		}
		return 0;
	}
	
	public int integerReplacement2(int n) {
		int res = 0;
        long ln = (long) n;
        while(ln > 1) {
            if(ln % 2 == 0) {
                ln /= 2;
            } else if(ln == 3 || ln % 4 == 1) {
                ln--;
            } else if (ln % 4 == 3) {
                ln++;
            }
            res++;            
        }
        return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new IntegerReplacement().integerReplacement0(7));
	}

}
