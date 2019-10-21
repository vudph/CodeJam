package interview.amz;

public class Demo2 {

	public int generalizedGCD(int num, int[] arr) {
		if (num == 1) {
			return Math.abs(arr[0]);
		}
		int tmp = Math.abs(arr[0]);
		for (int i = 0; i < num; i++) {
			tmp = gcd(tmp, arr[i]);
		}
		return tmp;
	}
	
	private int gcd(int a, int b) {
		if (a == b) return a;
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
	
	public static void main(String[] args) {
		System.out.println(new Demo2().generalizedGCD(5, new int[] {2,4,6,8,12}));
	}

}
