package basic.string;

import java.util.Scanner;

//http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/StringMatch/kuthMP.htm
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class KnuthMorrisPratt {
	private static Scanner scanner = new Scanner(System.in);
	private String T; // text
	private String P; // pattern
	private int S[]; //suffix array
	
	private void computeSuffixArray() {
		S = new int[P.length() + 1];
		S[0] = -1;
		
	}
	
	void computeLPSArray() {
		// length of the previous longest prefix suffix
		S = new int[P.length()];
		S[0] = 0; // lps[0] is always 0

		int j = 0;
		int i = 1;
		
		// the loop calculates lps[i] for i = 1 to M-1
		while (i < P.length()) {
			if (P.charAt(i) == P.charAt(j)) {
				S[i] = j + 1;
				i = i + 1;
				j = j + 1;
			} else { // (pat[i] != pat[len])
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (j != 0) {
					j = S[j - 1];
					// Also, note that we do not increment
					// i here
				} else { // if (len == 0)
					S[i] = 0;
					i = i + 1;
				}
			}
		}
		for (i = 0; i < S.length; i++) {
			System.out.print(S[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		KnuthMorrisPratt kmp = new KnuthMorrisPratt();
//		kmp.T = scanner.nextLine(); //abc abcdab abcdabcdabdabcdabdaef
		kmp.P = scanner.nextLine(); // abcdabda  AAACAAAA
		kmp.computeLPSArray();
	}

}
