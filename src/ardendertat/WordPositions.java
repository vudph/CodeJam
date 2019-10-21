package ardendertat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPositions {
	private Map<String, Set<Integer>> index = new HashMap<>();
	
	public WordPositions(String text) {
		createIndex(text);
	}

	private String[] getWords(String text) {
		String delims = "\\W+"; // split any non word 
		String words[] = text.toLowerCase().split(delims);
		return words;
	}
	
	private void createIndex(String text) {
		String words[] = getWords(text);
		for (int pos = 0; pos < words.length; pos++) {
			Set<Integer> positions = index.get(words[pos]);
			if (positions == null) {
				positions = new HashSet<>();
			}
			positions.add(pos);
			index.put(words[pos], positions);
		}
	}
	
	public Set<Integer> queryIndex(String word) {
		if (index.containsKey(word)) {
			return index.get(word);
		}
		return null;
	}

	public static void main(String[] args) {
		WordPositions wp = new WordPositions("us use uses used. User users using useful username user utah! we can go go there");
		System.out.println(wp.queryIndex("user"));
	}
}
