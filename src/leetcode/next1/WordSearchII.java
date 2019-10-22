package leetcode.next1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
https://leetcode.com/problems/word-search-ii/
Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

 */
public class WordSearchII {
	
	static class TrieNode {
		String word;
		TrieNode children[] = new TrieNode[26]; 
	}
	
	TrieNode root = new TrieNode();
	List<String> results = new ArrayList<String>();
	
	void buildTrie(String words[]) {
		for (int i = 0; i < words.length; i++) {
			TrieNode node = root;
			for (char ch : words[i].toCharArray()) {
				if (node.children[ch - 'a'] == null) {
					node.children[ch - 'a'] = new TrieNode();
				}
				node = node.children[ch - 'a'];
			}
			node.word = words[i];
		}
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children[board[i][j] - 'a'] != null)
					dfs(board, i, j, root.children[board[i][j] - 'a']);
			}
		}
        return results;
    }
	
	int dx[] = {-1, 0, 1, 0};
	int dy[] = {0, 1, 0, -1};

	private void dfs(char[][] board, int i, int j, TrieNode node) {
		if (node.word != null) {
			results.add(node.word);
			node.word = null;
		}
		char letter = board[i][j];
		board[i][j] = '#';
		for (int k = 0; k < 4; k++) {
			int x = dx[k] + i;
			int y = dy[k] + j;
			if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
				continue;
			if (board[x][y] != '#' && node.children[board[x][y] - 'a'] != null) {
				dfs(board, x, y, node.children[board[x][y] - 'a']);
			}
		}
		board[i][j] = letter;
	}

	public static void main(String[] args) {
		new WordSearchII().findWords(new char[][] {{'a'}}, 
												new String[] {"a"});
	}

}
