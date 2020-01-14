package interview.jb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class WhoCloset {
	
	public static List<Integer> closest(String S, List<Integer> queries) {
		Map<Character, TreeSet<Integer>> indicesMap = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			indicesMap.putIfAbsent(S.charAt(i), new TreeSet<>());
			indicesMap.get(S.charAt(i)).add(i);
		}
		List<Integer> res = new ArrayList<>();
		for (int i : queries) {
			if (i < 0 || i >= S.length()) {
				res.add(-1);
				continue;
			}
			TreeSet<Integer> indices = indicesMap.get(S.charAt(i));
			if (indices == null || indices.size() == 1) {
				res.add(-1);
			} else {
				Integer l = indices.lower(i);
				Integer r = indices.higher(i);
				if (l == null) {
					res.add(r);
				} else if (r == null) {
					res.add(l);
				} else { 
					if (i - l > r - i) {
						res.add(l);
					} else {
						res.add(r);
					}
				}
			}
		}
		return res;//[6, 8, 4, 1]
	}

	public static void main(String[] args) {
		closest("hackrerrank", Arrays.asList(4, 5, 1, 6, 8, 11));
	}

}
