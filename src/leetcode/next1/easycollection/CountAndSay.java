package leetcode.next1.easycollection;
/*
https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/886/
1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211

 */
public class CountAndSay {

	public String countAndSay(int n) {
		if (n == 1) return "1";
		String s = "11";
		for (int i = 3; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int cnt = 1;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j - 1) == s.charAt(j)) {
					cnt++;
				} else {
					sb.append(cnt).append(s.charAt(j - 1));
					cnt = 1;
				}
				if (j == s.length() - 1) {
					sb.append(cnt).append(s.charAt(j));
				}
			}
			s = sb.toString();
		}
		return s;
    }

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(7));
	}

}
