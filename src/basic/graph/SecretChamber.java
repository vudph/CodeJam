package basic.graph;

import java.util.ArrayList;
import java.util.List;

public class SecretChamber {
	
	public List<Boolean> canTranslate(int m, int n, List<char[]> dict, List<String[]> pairs) {
		int matrix[][] = new int[26][26];
		for (int i = 0; i < 26; i++) {
			matrix[i][i] = 1;
		}
		for (char[] ch : dict) {
			matrix[ch[0] - 97][ch[1] - 97] = 1;
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					if ((matrix[i][j] == 1 && matrix[j][k] == 1)) {
						matrix[i][k] = 1;
					}
				}
			}
		}
		List<Boolean> results = new ArrayList<>();
		for (String[] pair : pairs) {
			String word0 = pair[0];
			String word1 = pair[1];
			if (word0.length() != word1.length()) {
				results.add(false);
			} else if (word0.equals(word1)) {
				results.add(true);
			} else {
				int i = 0;
				while (i < word0.length() && matrix[word0.charAt(i) - 97][word1.charAt(i) - 97] == 1) {
					i++;
				}
				if (i < word0.length())
					results.add(false);
				else
					results.add(true);
			}
		}
		System.out.println();
		return results;
	}

	public static void main(String[] args) {
		List<char[]> dict = new ArrayList<>();
		dict.add(new char[] {'a', 'c'});
		dict.add(new char[] {'b', 'a'});
		dict.add(new char[] {'a', 'b'});
//		dict.add(new char[] {'o', 'c'});
//		dict.add(new char[] {'r', 'o'});
//		dict.add(new char[] {'t', 'e'});
//		dict.add(new char[] {'t', 'f'});
//		dict.add(new char[] {'u', 'h'});
//		dict.add(new char[] {'w', 'p'});
		
		List<String[]> pairs = new ArrayList<>();
		pairs.add(new String[] {"aaa", "abc"});
		pairs.add(new String[] {"abc", "aaa"});
		pairs.add(new String[] {"acm", "bcm"});
//		pairs.add(new String[] {"it", "of"});
//		pairs.add(new String[] {"out", "the"});
		
		new SecretChamber().canTranslate(9, 5, dict, pairs);
	}

}
