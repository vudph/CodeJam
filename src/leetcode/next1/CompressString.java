package leetcode.next1;
/*
https://leetcode.com/discuss/interview-question/124996/Oracle-or-Phone-Screen-or-Run-length-Encoding

abcccddeeeeea => abc3d2e5a
 */
public class CompressString {
	
private String compress(String s) {
	char ch[] = s.toCharArray();
	StringBuilder sb = new StringBuilder();
	sb.append(ch[0]);
	int i = 1;
	int cnt = 1;
	while (i < ch.length) {
		if (ch[i] == ch[i - 1]) {
			cnt++;
		} else {
			if (cnt > 1)
				sb.append(cnt);
			sb.append(ch[i]);
			cnt = 1;
		}
		i++;
	}
	return sb.toString();
}

	public static void main(String[] args) {
		System.out.println(new CompressString().compress("abcdeed"));
	}

}
