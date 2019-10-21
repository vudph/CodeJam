package interview.jb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Closet {
	public static List<Integer> closest(String S, List<Integer> queries) {
		Map<Character, TreeSet<Integer>> appears = new HashMap<Character, TreeSet<Integer>>();
		for (int i = 0; i < S.length(); i++) {
			if (appears.containsKey(S.charAt(i))) {
				appears.get(S.charAt(i)).add(i);
			} else {
				TreeSet<Integer> indices = new TreeSet<>();
				indices.add(i);
				appears.put(S.charAt(i), indices);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int q : queries) {
			if (q >= 0 && q < S.length()) {
				char ch = S.charAt(q);
				TreeSet<Integer> indices = appears.get(ch);
				if (indices.size() == 1) {
					result.add(-1);
				} else {
					Integer lower = indices.lower(q);
					Integer higher = indices.higher(q);
					if (lower == null) {
						result.add(higher);
						continue;
					} else if (higher == null) {
						result.add(lower);
						continue;
					} else {
						if (q - lower > higher - q) {
							result.add(higher);
						} else {
							result.add(lower);
						}
					}
				}
			} else {
				result.add(-1);
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		closest("babab", Arrays.asList(new Integer[] {2}));
	}

}
