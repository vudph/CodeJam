package ardendertat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombineTwoStrings {
	
	public boolean validShuffle(String s1, String s2, String s3) {
//		boolean valid = recursive(s1, s2, s3); //=> false s1=ab, s2=ae, s3=aeab
		boolean valid = memorize(s1, s2, s3, new HashSet<>());
		return valid;
	}
	
	private boolean recursive(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
			if ((s1 + s2).equals(s3))
				return true;
			else 
				return false;
		}
		if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0))
			return false;
		if (s1.charAt(0) == s3.charAt(0) && recursive(s1.substring(1), s2, s3.substring(1))) {
			return true;
		}
		if (s2.charAt(0) == s3.charAt(0) && recursive(s1, s2.substring(1), s3.substring(1))) {
			return true;
		}
		return false;
	}
	
	private boolean memorize(String s1, String s2, String s3, Set<List<String>> cache) {
		if (cache.contains(Arrays.asList(s1, s2))) {
			System.out.println("cache hit (" + s1 + "," + s2 + ")");
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
			if ((s1 + s2).equals(s3))
				return true;
			else 
				return false;
		}
		if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0))
			return false;
		if (s1.charAt(0) == s3.charAt(0) && memorize(s1.substring(1), s2, s3.substring(1), cache)) {
			return true;
		}
		if (s2.charAt(0) == s3.charAt(0) && memorize(s1, s2.substring(1), s3.substring(1), cache)) {
			return true;
		}
		cache.add(Arrays.asList(s1, s2));
		return false;
	}

	private boolean naive(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		int i = 0, j = 0, k = 0;
		while (k < s3.length()) {
			char ch3 = s3.charAt(k);
			if (i < s1.length() && ch3 == s1.charAt(i)) {
				i++;
			} else if (j < s2.length() && ch3 == s2.charAt(j)) {
				j++;
			} else {
				return false;
			}
			k++;
		}

		return true;
	}

	public static void main(String[] args) {
//		String s1 = "abc", s2 = "def", s3 = "dabecf";
//		String s1 = "ab", s2 = "ae", s3 = "aeab";
//		String s1 = "dope", s2 = "dude", s3 = "duddopee";
		String s1 = "ab", s2 = "def", s3 = "defab";
//		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
//		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
//		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(new CombineTwoStrings().validShuffle(s1, s2, s3));
	}

}
