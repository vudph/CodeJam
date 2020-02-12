package leetcode.next1;

public class DivisibleSumPairs {
	
	private static int divisibleSumPairs(int n, int k, int[] ar) {
        int bucket[] = new int[k];
        for (int i : ar) {
            bucket[i % k]++;
        }

        int count = 0;
        count += bucket[0] * (bucket[0] - 1)/2;
        if ( k % 2 == 0) {
            count += bucket[k/2] * (bucket[k/2] - 1)/2;
            for (int i = 1; i < k/2; i++) {
                count += bucket[i] * bucket[k - i];
            }
        } else {
        	for (int i = 1; i <= k/2; i++) {
                count += bucket[i] * bucket[k - i];
            }
        }
        
        return count;
    }

	public static void main(String[] args) {
		System.out.println(divisibleSumPairs(6, 3, new int[] {1, 3, 2, 6, 1, 2}));
	}

}
