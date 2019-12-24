package leetcode.next1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/group-anagrams/

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

 */

public class GroupAnagram {
	static class Anagram {
		int cnt[] = new int[26];
		
		public Anagram(int cnt[]) {
			this.cnt = cnt;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Anagram))
				return false;
			Anagram a = (Anagram) obj;
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] != a.cnt[i])
					return false;
			}
			return true;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
	        int result = 1;
	        int cntOne = 0;
	        for (int i : cnt) {
				if (i > 1)
					cntOne += i;
			} 
	        result = prime * result + cntOne;  
	        return result;
		}
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> group = new HashMap<>();
//        for (String word : strs) {
//			String key = hash(word);
//			group.putIfAbsent(key, new ArrayList<>());
//			group.get(key).add(word);
//		}
		
		Map<String, List<String>> group = Arrays.stream(strs).collect(Collectors.groupingBy(s -> hash(s))); // hash(s) becomes key of returned Map, and values is list of strings having same hash(s) value 
		
		return new ArrayList<>(group.values());
    }
	
	private String hash(String word) {
//		int cnt[] = new int[26];
//		for (char c : word.toCharArray()) {
//			cnt[c - 'a']++;
//		}
//		StringBuilder sb = new StringBuilder();
//		for (char c = 'a'; c <= 'z'; c++) {
//			sb.append(c).append(cnt[c - 'a']);
//		}
//		return sb.toString();
		char cnt[] = new char[26];
		for (char c : word.toCharArray()) {
			cnt[c - 'a']++;
		}
		return new String(cnt);
	}
	
	public static void main(String[] args) {
		List<List<String>> r = new GroupAnagram().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println();
	}

}
