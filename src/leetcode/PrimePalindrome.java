package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/prime-palindrome/
/*
Example 1:

Input: 6
Output: 7
Example 2:

Input: 8
Output: 11

Example 3:

Input: 13
Output: 101
 */
public class PrimePalindrome {
	
	private int primePalindrome(int N) {
		while (true) {
			if (isPrime(N) && isPalindrome(N)) {
				return N;
			}
			N++;
		}
	}
	
	private boolean isPalindrome(int n) {
		// 12321, 12345 => 54321
		int tmp = n;
		int sum = 0;
		while (tmp != 0) {
			sum = (sum * 10) + (tmp % 10);
			tmp = tmp / 10;
		}
		return sum == n ? true : false;
	}
	private boolean isPrime(int n) {
		if (n < 2) 
			return false;
		if (n == 2) 
			return true;
		int i = 2;
		while (n % i != 0) 
			i++;
		if (i == n) 
			return true;
		return false;
	}
	
	private static void sieveOfEratosthenes(int x, int y) {
		// initially assume all integers are prime
        boolean[] isPrime = new boolean[(y-x)+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = x; factor*factor <= y; factor++) {
            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider multiples factor, factor+1, ...,  n/factor
            if (isPrime[factor-x]) {
                for (int j = factor; factor*j <= y; j++) {
                    isPrime[factor*j-x] = false;
                }
            }
        }

        // count primes from x -> y
        int primes = 0;
        for (int i = x; i <= y; i++) {
            if (isPrime[i-x]) {
            	System.out.println(i);
            	primes++;
            }
        }
        System.out.println("The number of primes <= " + y + " is " + primes);
	}

	public static void main(String[] args) {
		PrimePalindrome pp = new PrimePalindrome();
//		System.out.println(pp.primePalindrome(3503054));

		pp.sieveOfEratosthenes(12, 21);
	}

}
