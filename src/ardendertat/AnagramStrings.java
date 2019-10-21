package ardendertat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramStrings {
	
	public boolean isAnagram(String s1, String s2) {
		boolean valid = isAnagramArrayOpt(s1, s2);
		return valid;
	}
	
	private boolean isAnagramSort(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		char ch1[] = s1.toCharArray();
		char ch2[] = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i])
				return false;
		}
		return true;
	}

	private boolean isAnagramHashMap(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		Map<Character, Integer> charCnt = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (charCnt.containsKey(s1.charAt(i))) {
				charCnt.computeIfPresent(s1.charAt(i), (k, v) -> v + 1);
			} else {
				charCnt.put(s1.charAt(i), 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (charCnt.containsKey(s2.charAt(i))) {
				int cnt = charCnt.get(s2.charAt(i));
				if (cnt == 1) {
					charCnt.remove(s2.charAt(i));
				} else {
					charCnt.put(s2.charAt(i), cnt - 1);
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	private boolean isAnagramArray(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int cnt1[] = new int[256];
		int cnt2[] = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			cnt1[s1.charAt(i)]++;
			cnt2[s2.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (cnt1[i] != cnt2[i]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isAnagramArrayOpt(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int cnt[] = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			cnt[s1.charAt(i)]++;
			cnt[s2.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++) {
			if (cnt[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "Eleven plus two 3", s2 = "Twelve plus one 2";
		System.out.println(new AnagramStrings().isAnagram(s1, s2));
	}

}
