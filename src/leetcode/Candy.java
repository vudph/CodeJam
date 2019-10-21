package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 https://leetcode.com/problems/candy/
 */
public class Candy {
	
	public int candy(int[] ratings) {
		int cnt = pairArrays(ratings);
		return cnt;
    }
	
	public int bruteforce(int[] ratings) {
		int candies[] = new int[ratings.length];
		Arrays.fill(candies, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1] + 1;
			} else if (ratings[i] < ratings[i-1]) {
				if (candies[i] == candies[i-1] && candies[i-1] == 1) {
					int j = i - 1;
					candies[j] = 2; 
					while (j >= 1 && ratings[j] < ratings[j-1]) {
						if (candies[j] + 1 > candies[j-1])
							candies[j-1] = candies[j] + 1;
						j--;
					}
				}
			}					
		}
		
		return IntStream.of(candies).sum();
	}
	
	private int pairArrays(int[] ratings) {
		int candiesL2R[] = new int[ratings.length];
		int candiesR2L[] = new int[ratings.length];
		
		int maxOf2[] = new int[ratings.length];
		Arrays.fill(candiesL2R, 1);
		Arrays.fill(candiesR2L, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				candiesL2R[i] = candiesL2R[i-1] + 1;
			}
		}
		for (int i = ratings.length - 1; i >= 1; i--) {
			if (ratings[i-1] > ratings[i]) {
				candiesR2L[i-1] = candiesR2L[i] + 1;
			}
				
		}
		for (int i = 0; i < candiesL2R.length; i++) {
			maxOf2[i] = Math.max(candiesL2R[i], candiesR2L[i]);
		}
		return IntStream.of(maxOf2).sum();
	}

	public static void main(String[] args) {
		System.out.println(new Candy().candy(new int[] {1,2,87,87,87,2,1}));
	}
}
