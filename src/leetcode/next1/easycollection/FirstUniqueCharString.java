package leetcode.next1.easycollection;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
public class FirstUniqueCharString {
	
	public int firstUniqChar(String s) {
        // Map<Character, Integer> seen = new HashMap<>();
        // char ch[] = s.toCharArray();
        // for (char c : ch) {
        //     seen.put(c, seen.getOrDefault(c, 0) + 1);
        // }
        // for (int i = 0; i < ch.length; i++) {
        //     if (seen.get(ch[i]) == 1)
        //         return i;
        // }
        int cnt[] = new int[256];
        char ch[] = s.toCharArray();
        for (char c : ch)
            cnt[c]++;
        for (int i = 0; i < ch.length; i++) {
            if (cnt[ch[i]] == 1)
                return i;
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
