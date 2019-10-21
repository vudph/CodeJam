package leetcode.recap;

public class ShiftLetter {
	
	public String shift(String s, int sh[]) {
		int n = sh.length;
		int prefix[] = new int[n];
		prefix[n - 1] = sh[n - 1] % 26;
		for (int i = n - 2; i >= 0; i--) {
			prefix[i] = (prefix[i + 1] + sh[i]) % 26;
		} 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append((char)((s.charAt(i) - 97 + prefix[i]) % 26 + 97));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ShiftLetter().shift("ruu", new int[] {26,9,17}));
	}

}
