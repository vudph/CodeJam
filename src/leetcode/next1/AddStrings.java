package leetcode.next1;

/*
https://leetcode.com/problems/add-strings/

1234
 177
----
1411

 */

public class AddStrings {
	
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        int carry = 0;
        int i = ch1.length - 1;
        int j = ch2.length - 1;
        while (i >= 0 && j >= 0) {
        	int sum = (ch1[i] - '0') + (ch2[j] - '0') + carry;
        	sb.append(sum % 10);
            carry = sum > 9 ? 1 : 0;
            i--;
        	j--;
        }
        for (int k = i; k >= 0; k--) {
        	int sum = (ch1[k] - '0') +  carry;
        	sb.append(sum % 10);
            carry = sum > 9 ? 1 : 0;
        }
        for (int k = j; k >= 0; k--) {
        	int sum = (ch2[k] - '0') +  carry;
        	sb.append(sum % 10);
            carry = sum > 9 ? 1 : 0;
		}
        if (carry == 1)
        	sb.append("1");
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		System.out.println(new AddStrings().addStrings("408", "5"));
	}

}
