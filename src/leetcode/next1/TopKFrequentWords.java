package leetcode.next1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/top-k-frequent-words/

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

public class TopKFrequentWords {
	static class WordCount implements Comparable<WordCount> {
		String word;
		int count = 1;
		
		public WordCount(String w, int c) {
			this.word = w;
			this.count = c;
		}
		
		@Override
		public int compareTo(WordCount other) {
			int r = other.count - this.count;
			if (r == 0) {
				return this.word.compareTo(other.word);
			}
			return r;
		}
		
		public String toString() {
			return "[" + word + ": " + count + "]";
		}
	}
	
	public List<String> topKFrequent(String[] words, int k) {
//		Map<String, WordCount> frequency = new HashMap<>();
//		for (String w : words) {
//			if (frequency.containsKey(w)) {
//				frequency.get(w).count++;
//			} else {
//				frequency.put(w, new WordCount(w, 1));
//			}
//		}
//		List<WordCount> res = new ArrayList<>(frequency.values());
//		Collections.sort(res);
//		
//		List<String> r = res.stream().limit(k).map(wc -> wc.word).collect(Collectors.toList());
//		return r;
		
		Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
	}

	public static void main(String[] args) {
		new TopKFrequentWords().topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 1);
	}

}
