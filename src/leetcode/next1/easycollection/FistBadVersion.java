package leetcode.next1.easycollection;

/*
https://leetcode.com/problems/first-bad-version/

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
 */
public class FistBadVersion {

	public int firstBadVersion(int n) {
//		for (int i = 1; i < n; i++) {
//			if (isBadVersion(i)) {
//				return i;
//			}
//		}
//		return -1;
		int l = 1;
		int r = n - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (isBadVersion(mid)) {
				r = mid; 
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	
	private boolean isBadVersion(int i) {
		return i == 4 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new FistBadVersion().firstBadVersion(5));
	}

}
