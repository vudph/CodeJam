package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/word-break-ii/
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

c a ts and dog
c at san ddog
c ats andd og
c atsa nddog
c atsan ddog
c atsand dog
c atsandd og
c atsanddo g
c atsanddog


c a t s a n d d o g
ca ts an dd og
c at sanddog
cat san ddo g


c atsanddog
 */
public class WordBreakII {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> l = backtracking(s, wordDict);
        System.out.println(l.size());
        return l;
    }

	private List<String> backtracking(String s, List<String> wordDict) {
		List<String> solutions = new ArrayList<>();
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				if (s.length() == word.length()) {
					solutions.add(s);
				} else {
					List<String> subSolutions = backtracking(s.substring(word.length()), wordDict);
					for (String sub : subSolutions) {
						StringBuilder sb = new StringBuilder();
						sb.append(word).append(" ").append(sub);
						solutions.add(sb.toString());
					}
				}
			}
		}
		
		return solutions;
	}

	public static void main(String[] args) {
		new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
	}

}
