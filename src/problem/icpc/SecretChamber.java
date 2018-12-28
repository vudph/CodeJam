package problem.icpc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * https://icpc.kattis.com/problems/secretchamber
 */
public class SecretChamber {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n, m;
//		Character chr = 'z';
//		System.out.println(chr - 97);
		String nm[] = scanner.nextLine().split(" ");
		m = Integer.parseInt(nm[0]);
		n = Integer.parseInt(nm[1]);
		
		int alphabet[][] = new int[26][26];
		
		for (int i = 0; i < m; i++) {
			String ab[] = scanner.nextLine().split(" ");
			Character a = ab[0].charAt(0);
			Character b = ab[1].charAt(0);
			alphabet[a - 97][b - 97] = 1;
		}
		
		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					alphabet[i][j] = alphabet[i][j] == 1 || (alphabet[i][k] == 1 && alphabet[k][j] == 1) ? 1 : 0;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			String pair[] = scanner.nextLine().split(" ");
			String word0 = pair[0];
			String word1 = pair[1];
			if (word0.equals(word1)) {
				System.out.println("yes");
				continue;
			}
			if (word0.length() != word1.length()) {
				System.out.println("no");
				continue;
			}
			boolean matched = true;
			for (int j = 0; j < word0.length(); j++) {
				int chi0 = word0.charAt(j) - 97;
				int chi1 = word1.charAt(j) - 97;
				if (chi0 != chi1 && alphabet[chi0][chi1] == 0) {
					matched = false;
					break;
				}
			}
			if (matched) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
/*
<==
9 5
c t
i r
k p
o c
r o
t e
t f
u h
w p
we we
can the
work people
it of
out the

==>
yes
no
no
yes
yes

<==
3 3
a c
b a
a b
aaa abc
abc aaa
acm bcm
==>
yes
no
yes
*/