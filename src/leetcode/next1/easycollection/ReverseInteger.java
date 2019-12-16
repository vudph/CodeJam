package leetcode.next1.easycollection;

public class ReverseInteger {
	public int reverse(int x) {
        int num = 0;
        int mod = 0;
        while (x != 0) {
            mod = x % 10;
            if (num > Integer.MAX_VALUE/10 || num < Integer.MIN_VALUE/10) return 0;
            num = num * 10 + mod;
            x = x / 10;
        }
        return num;
    }

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(1534236469));
		
//		2147483647 / 10 = 214748364
//		9646324351        964632435
	}

}
