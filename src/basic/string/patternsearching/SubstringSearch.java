package basic.string.patternsearching;

import java.util.Scanner;

public class SubstringSearch {
	private static final Scanner scanner = new Scanner(System.in);

	private void bruteforce(String txt, String pat) {
		/*
		 txt="vuhellovudong", pat="vudong";
		 */
		int m = txt.length();
		int n = pat.length();
		for (int i = 0; i <= m - n; i++) {
			int j = 0;
			for (j = 0; j < n; j++) {
				if (pat.charAt(j) != txt.charAt(i + j))
					break;
			}
			if (j == n)
				System.out.print(i + ", ");
		}
	}
	
	
	public static void main(String[] args) {
		SubstringSearch ss = new SubstringSearch();
		String txt = "abcd efbcd bcdadfbcdbcdaaababcdaaeee";
		String pat = "bcd";
		ss.bruteforce(txt, pat);
	}
}
