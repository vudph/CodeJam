package leetcode;

/*https://leetcode.com/problems/is-subsequence/
Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

 */

		
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
//		int j = 0;
//		for (int i = 0; i < t.length() && j < s.length(); i++) {
//			if (s.charAt(j) == t.charAt(i)) {
//				j++;
//				if (j == s.length())
//					return true;
//			}
//		}
		int idx = -1;
		for (int i = 0; i < s.length(); i++) {
			idx = t.indexOf(s.charAt(i), idx + 1);
			if (idx == -1)
				return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
	}

}
