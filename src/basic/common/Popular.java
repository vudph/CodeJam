package basic.common;

public class Popular {
	
	public static int fibNth(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 2;
//		return fibNth(n-1) + fibNth(n-2);
		
//		int fib[] = new int[n + 1];
//		fib[0] = 1;
//		fib[1] = 2;
//		for (int i = 2; i <= n; i++) {
//			fib[i] = fib[i - 1] + fib[i - 2];
//		}
//		return fib[n];
		
		int a = 1;
		int b = 2;
		int c;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++) {
			System.out.print(fibNth(i) + " ");		
		}
	}
}
