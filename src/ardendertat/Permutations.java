package ardendertat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 s = ABC
 s' = {A} => {BA,AB} => {{CBA,BCA,BAC},{CAB,ACB,ABC}}
 */

public class Permutations {
	
	public List<String> permutations(String s) {
		return perm(s, s.length());
	}

	private List<String> perm(String s, int len) {
		if (len == 1) {
			return Arrays.asList(s.substring(0, len));
		}
		List<String> res = perm(s, len-1);
		char ch = s.charAt(len-1);
		List<String> results = new ArrayList<>();
		for (String p : res) {
			for (int i = 0; i < len; i++) {
				String r = addCharAt(i, ch, p);
				results.add(r);
			}
		}
		return results;
	}

	private String addCharAt(int i, char ch, String s) {
		return s.substring(0, i) + ch + s.substring(i + 1, s.length());
	}

	public static void main(String[] args) {
		List<String> res = new Permutations().permuation1("ABC");
		System.out.println(res.size());
	}

	List<String> output = new ArrayList<>();
	
	public List<String> permuation1(String s) {
		backtracking(s, output);
		return output;
	}

	private void backtracking(String s, List<String> perm) {
		if (s.length() == 0) {
			output = perm;
			return;
		}
		String letter = s.substring(0, 1);
		List<String> newperm = new ArrayList<>();
		if (perm.isEmpty()) {
			newperm.add(letter);
		} else {
			for (String p : perm) {
				for (int i = 0; i <= p.length(); i++) {
					String q = insertCharAt(i, letter.charAt(0), p);
					newperm.add(q);
				}
			}
		}
		
		backtracking(s.substring(1), newperm);
	}
	
	private String insertCharAt(int i, char ch, String s) {
		return s.substring(0, i) + ch + s.substring(i, s.length());
	}
}
