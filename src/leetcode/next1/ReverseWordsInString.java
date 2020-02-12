package leetcode.next1;
/*
https://leetcode.com/problems/reverse-words-in-a-string-ii/

Given an input string , reverse the string word by word. 

Example:

Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

*/

public class ReverseWordsInString {

	public void reverseWords(char[] s) {
        // reverse whole string
		reverseWord(s, 0, s.length - 1);
		
		//reverse each word separated by space from left to right
		int l = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverseWord(s, l, i - 1);
				l = i + 1;
			}
		}
		//reverse last word
		reverseWord(s, l, s.length - 1);
		System.out.println();
    }
	
	private void reverseWord(char[] w, int i, int j) {
		while (i < j) {
			char tmp = w[i];
			w[i] = w[j];
			w[j] = tmp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		char s[] = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		new ReverseWordsInString().reverseWords(s);
	}

}
