package leetcode.next1.easycollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsDivisibleBy60 {

	public int numPairsDivisibleBy60(int[] time) {
//        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
//        int count = 0;
//        for (int t : time) {
//        	count += seen.getOrDefault((60 - (t % 60)) % 60, 0);
//        	System.out.println("t= " + t + ", count=" + count);
//        	seen.put(t % 60, seen.getOrDefault(t % 60, 0) + 1);
//        }
		
//		Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
//        int count = 0;
//        for (int t : time) {
//        	seen.put(t % 60, seen.getOrDefault(t % 60, 0) + 1);
//        }
//        List<Integer> keys = new ArrayList<>(seen.keySet());
//        for (int k : keys) {
//        	if (k == 0 || k == 30) {
//        		int v = seen.get(k);
//        		count += (v * (v - 1))/2;
//        	} else {
//        		int target = 60 - k;
//        		if (seen.containsKey(target)) {
//        			count += seen.get(k) * seen.get(target);
//        		}
//        		seen.remove(k);
//        		seen.remove(target);
//        	}
//        }
		int count = 0;
		int bucket[] = new int[60];
		for (int t : time)
			bucket[t % 60]++;
		count += ((bucket[0] * (bucket[0] - 1)) / 2) + ((bucket[30] * (bucket[30] - 1)) / 2);
		for (int i = 1; i < 30; i++) {
			count += bucket[i] * bucket[60 - i];
		}
        return count;
    }

	public static void main(String[] args) {
		System.out.println(new PairsDivisibleBy60().numPairsDivisibleBy60(new int[] {0,30,20,150,100,120,80,40,60,160}));
	}

}
