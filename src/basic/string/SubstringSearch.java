package basic.string;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/*
 http://kupaskode.blogspot.com/2015/09/seni-hashing.html
 S = "ayamxz", P="amxz"
 Hashing:  
         a       y       a       m       x       z
 hS[0]=  a*R^3 + y*R^2 + a*R^1 + m*R^0
 hS[1]=          y*R^3   a*R^2 + m*R^1 + x*R^0
 hS[2]=                  a*R^3 + m*R^2 + x*R^1 + z*R^0
 
 hS[1] = (h[0] - a*R^3)R + x*R^0
 
 hP= a*R^3 + m*R^2 + x*R^1 + z*R^0
 
Hash collision:
 S = "cbj", P = "cat"
 hS = c*R^2 + b*R^1 + j*R^0
 hP = c*R^2 + a*R^1 + t*R^0
 Assume that we use ASCII to represent the characters and R = 10 
 hS = 99*10^2 + 98*10^1 + 106*10^0 = 9900 + 980 + 106 = 10986
 hP = 99*10^2 + 97*10^1 + 116*10^0 = 9900 + 970 + 116 = 10986
 => different strings but have the same hash
 */

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
