package basic.string;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RabinKarp {
	private static final Scanner scanner = new Scanner(System.in);
	/** Large prime **/         
    private static final long Q = longRandomPrime(); // a large prime, small enough to avoid long overflow
    /** radix **/         
    private static final int R = 256; // radix
    
    private int m; //length of pattern
    
    private String pat; //pattern
    
	private long hash(String key, int n) {
		long h = 0;
//		h = key[i]*R^(n-1) + key[i+1]*R^(n-2) + ... + key[i+n-1]*R^0
		/*
		 key = "abcd"
		 h = 'a' = 97
		 h = 256*'a' + 'b' = 24930
		 h = 256*(256*'a' + 'b') + 'c' = 256*256*'a' + 256*'b' + 'c' = 'a'*256^2 + 'b'*256^1 + 'c' = 6382179
		 h = 256*(256*256*'a' + 256*'b' + 'c') + 'd' = 256*256*256*'a' + 256*256*'b' + 256*'c' + 'd' = 'a'*256^3 + 'b'*256^2 + 'c'*256^1 + 'd' = 1633837924
		 */
//		for (int i = 0; i < n; i++) {
////			System.out.println(h);
//			h = R * h + key.charAt(i);
//		}
		
		//when text is large => h (in long) can overflow => modulo with prime number
		for (int i = 0; i < n; i++) {
//			System.out.println(h);
			h = (R * h + key.charAt(i)) % Q;
		}
		return h;
	}
	
	private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

	public void rabinKarp(String txt, String pat) {
		this.pat = pat;
		this.m = pat.length();
		int n = txt.length();
		long patHash = hash(pat, m);
		long txtHash = hash(txt, m);
		
		int limit = n - m + 1;
		
		// pre-compute Rm = R^(lenPat-1) <=> pow(R, lenPat-1)
		long Rm = 1;
		for (int i = 1; i <= m - 1; i++) {
//			Rm = Rm * R;
			Rm = (Rm * R) % Q;
		}
		
		for (int i = m; i < n; i++) {
			// Remove leading digit, add trailing digit, check for match. 
			// h = (h - txt[i-m]*Rm)*R + txt[i]*R^0; => 
			
//			txtHash = (txtHash - txt.charAt(i-m)*Rm)*R + txt.charAt(i);
			
			txtHash = txtHash - (txt.charAt(i-m)*Rm) % Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			
			int offset = i - m + 1;
			if (txtHash == patHash && check(txt, offset)) {
				System.out.print(offset + ", ");
			}
		}
	}
	
	private boolean check(String txt, int i) {
        for (int j = 0; j < m; j++) 
            if (pat.charAt(j) != txt.charAt(i + j)) 
                return false; 
        return true;
    }
	
	public static void main(String[] args) {
		RabinKarp ss = new RabinKarp();
		String txt = "abcd efbcd bcdadfbcdbcdaaababcdaaeee";
		String pat = "bcd";
//		System.out.println(ss.hash(txt, txt.length()));
		ss.rabinKarp(txt, pat);
	}
}
