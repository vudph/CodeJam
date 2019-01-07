package basic.string.patternsearching;

import java.util.Scanner;

//http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/StringMatch/kuthMP.htm
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class KnuthMorrisPratt {
	private static Scanner scanner = new Scanner(System.in);
	
	private void search(String pattern, String text) {
	    int[] lsp = computeLspTable(pattern);
	    
	    int i = 0; // index for txt[]
	    int j = 0; // index for pat[] 
        while (i < text.length()) { 
            if (pattern.charAt(j) == text.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == pattern.length()) { 
                System.out.println("Found pattern at index " + (i - j)); 
                j = lsp[j - 1]; 
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) { // mismatch after j matches
            	if (j != 0) 
                    j = lsp[j - 1]; 
                else
                    i = i + 1; 
            } 
        }
//        abc abcdab abcdabcdabdabcdabdaef
//        abcdabda (i=3, j=3)
//           abcdabda (i=3, j=0)
//            abcdabda (i=4, j=0)
//		      abcdabda (i=10, j=6)
//                abcdabda (i=10, j=2)
//                 abcdabda (i=10, j=1)
//                  abcdabda (i=10, j=0)
//					 abcdabda (i=11, j=0)
//		             abcdabda (i=17, j=6)
//                       abcdabda (i=17, j=2)
//                       abcdabda (i=22, j=7) => matched

//        abc abcdab abcdabcdabdabcdabdaxzef
//                              abcdabda (i=22, j=0)
//                              abcdabda (i=29, j=7) => matched
//                                     abcdabda (i=29, j=0)
//                                     abcdabda (i=30, j=1)
//                                     abcdabda (i=30, j=0)
//                                       abcdabda (i=31, j=0)
//                                        abcdabda (i=32, j=0)
//                                         abcdabda (i=33, j=0)
//                                           abcdabda (i=34, j=0) => stop
//        a b c d a b d a
//        0 1 2 3 4 5 6 7
//        0 0 0 0 1 2 0 1
	}
	
	private int[] computeLspTable(String pattern) { // the longest suffix-prefix
		//lsp[i] = longest proper prefix of P[i], and that is also a suffix of P[i]
		int lsp[] = new int[pattern.length()];
		lsp[0] = 0;
		for (int i = 1; i < pattern.length(); i++) {
			int j = lsp[i - 1];
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = lsp[j - 1]; // in worst case, this instruction will be called (pattern.length - 1) times
//				System.out.print(j + ",");
			}
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
		kmp.search(pattern, text);

		
	}

}
