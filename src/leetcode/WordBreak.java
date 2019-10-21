package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while (!q.isEmpty()) {
            int start = q.remove();
            if (start == s.length())
                return true;
            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end))) {
                    q.add(end);
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		String[] l = new String[] {"cats", "dog", "sand", "and", "cat"};
		System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList(l)));
	}

}
