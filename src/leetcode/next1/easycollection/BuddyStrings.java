package leetcode.next1.easycollection;

public class BuddyStrings {
	
	public boolean buddyStrings(String A, String B) {
        // abcdef
        // adcbef
		if (A.length() != B.length()) return false;
		if (A.equals(B)) {
//			for cases:
//			abcb
//			abcb
//			=> true
//			ab
//			ab
//			=> false
			int count[] = new int[26];
			for (char c : A.toCharArray()) {
				count[c - 'a']++;
			}
			for (int i : count) {
				if (i > 1)
					return true;
			}
			return false;
		}
//		abcedf
//		adcebf
		int lastDiffIndex = -1;
		boolean swapped = false;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				if (swapped) //2nd swap
					return false;
				if (lastDiffIndex == -1) {
					lastDiffIndex = i;
				} else {
					if (A.charAt(lastDiffIndex) == B.charAt(i) && A.charAt(i) == B.charAt(lastDiffIndex)) {
						swapped = true;
					} else {
						return false;
					}
				}
			}
		}
		return swapped;
	}

	private void swap(String A, char c, int i) {
		for (int j = i + 1; j < A.length(); j++) {
			if (A.charAt(j) == c) {
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new BuddyStrings().buddyStrings("abc", "abc"));
	}

}
