package leetcode.next1.easycollection;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/plus-one/

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

in =   [9,9]


out= [1,0,0]

 */
public class PlusOne {
	
	public int[] plusOne(int[] digits) {
//		List<Integer> res = new ArrayList<Integer>();
//		int hold = 1;
//		for (int i = digits.length - 1; i >= 0; i--) {
//			if (digits[i] == 9 && hold == 1) {
//				res.add(0);
//				hold = 1;
//			} else {
//				if (i == digits.length - 1 || hold == 1) {
//					res.add(digits[i] + 1);
//					hold = 0;
//				} else 
//					res.add(digits[i]);
//			}
//		}
//		if (hold == 1)
//			res.add(hold);
//		int r[] = new int[res.size()];
//		int j = 0;
//		for (int i = res.size() - 1; i >= 0; i--) {
//			r[j++] = res.get(i);
//		}
//		return r;
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				return digits;
			}
		}
		
		int r[] = new int[digits.length + 1];
		System.arraycopy(digits, 0, r, 1, digits.length);
		r[0] = 1;
		return r;
    }

	public static void main(String[] args) {
		new PlusOne().plusOne(new int[] {9,9});
	}

}
