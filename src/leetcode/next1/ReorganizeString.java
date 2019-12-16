package leetcode.next1;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/reorganize-string/
Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""

aabccc -> cccaab
cacacb
 */
public class ReorganizeString {
	static class CharCount implements Comparable<CharCount> {
		char ch;
		int count;
		
		public CharCount(char c, int cnt) {
			this.ch = c;
			this.count = cnt;
		}
		
		@Override
		public int compareTo(CharCount o) {
			return o.count - count;
		}
		
		@Override
		public String toString() {
			return ch + ":" + count;
		}
	}
	
	public String reorganizeString(String S) {
		int bucket[] = new int[26];
        for (char c : S.toCharArray()) {
        	bucket[c - 'a']++;
        }
        PriorityQueue<CharCount> pq = new PriorityQueue<>();
        
        for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] > 0) {
				if (bucket[i] > (S.length() + 1) / 2) // => impossible for reorganize, ex: aaab
					return "";
				pq.add(new CharCount((char)(i + 'a'), bucket[i]));
			}
		}
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
        	CharCount cc1 = pq.poll();
        	CharCount cc2 = pq.poll();
        	sb.append(cc1.ch);
        	sb.append(cc2.ch);
        	if (--cc1.count > 0)
        		pq.add(cc1);
        	if (--cc2.count > 0)
        		pq.add(cc2);
        }
        if (!pq.isEmpty())
        	sb.append(pq.poll().ch);
        return sb.toString(); 
    }

	public static void main(String[] args) {
		System.out.println(new ReorganizeString().reorganizeString("aabccc"));
//		abbabbaaab => aaaaabbbbb
//		ababababab
	}

}
