package basic.string;

import java.util.Scanner;

//http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/StringMatch/kuthMP.htm
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class KnuthMorrisPratt {
	private static Scanner scanner = new Scanner(System.in);
	
	private int search(String pattern, String text) {
	    int[] lsp = computeLspTable(pattern);
	    
	    int j = 0;  // Number of chars matched in pattern
	    for (int i = 0; i < text.length(); i++) {
	        while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
	            // Fall back in the pattern
	            j = lsp[j - 1];  // Strictly decreasing
	        }
	        if (text.charAt(i) == pattern.charAt(j)) {
	            // Next char matched, increment position
	            j++;
	            if (j == pattern.length()) {
	                int pos = i - (j - 1);
	                System.out.println(pos);
	                j = 0;
	            }
	            
	        }
	    }
	    
	    return -1;  // Not found
	}
	
	private int[] computeLspTable(String pattern) { // the longest suffix-prefix
		int lsp[] = new int[pattern.length()];
		lsp[0] = 0;
		for (int i = 1; i < pattern.length(); i++) {
			int j = lsp[i - 1];
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = lsp[j - 1];
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
			}
			lsp[i] = j;
		}
		return lsp;
		
//	    a a a a b
//	    0 1 2 3 0
	    
//	    a b c a b c a c a  //abcdbcddd
//	    0 0 0 1 2 3 4 0 1
	    
//	    a b c d b c d d d  //abcdbcddd
//	    0 0 0 0 0 0 0 0 0
//	    a b a b a b c
//	    0 0 1 2 3 4 0
	}
	
	public static void main(String[] args) {
		KnuthMorrisPratt kmp = new KnuthMorrisPratt();
		String text = scanner.nextLine(); //abc abcdab abcdabcdabdabcdabdaef
		String pattern = scanner.nextLine(); // abcdabda  AAACAAAA
		int pos = kmp.search(pattern, text);
		System.out.println(pos);

		
	}

}
