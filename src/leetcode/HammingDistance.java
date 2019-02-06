package leetcode;

public class HammingDistance {
	
	public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

	public static void main(String[] args) {
		System.out.println(new HammingDistance().hammingDistance(4, 10));
	}

}
