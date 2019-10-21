package leetcode;

public class StrStr {
	
	public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

	public static void main(String[] args) {
		System.out.println(new StrStr().strStr("aaaaa", "bba"));
	}

}
