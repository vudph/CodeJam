package leetcode;

public class ShiftingLetters {
	
	public String shiftingLetters(String S, int[] shifts) {
		//naive approach
		char ch[] = S.toCharArray();
		for (int i = 0; i < shifts.length; i++) {
			int sh = shifts[i];
			for (int j = 0; j <= i; j++) {
				int c = ch[j] + sh;
				while (c > 122) {
					c = (c - 122 + 96);
				}
				ch[j] = (char) c;
			}
		}
		return new String(ch);
    }

	public static void main(String[] args) {
		ShiftingLetters s = new ShiftingLetters();
		System.out.println(s.shiftingLetters("z", new int[] {52}));
	}
}
