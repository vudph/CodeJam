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
		HashMap<Character, Set<Character>> translationMap = new HashMap<>();
		String nm[] = scanner.nextLine().split(" ");
		m = Integer.parseInt(nm[0]);
		n = Integer.parseInt(nm[1]);
		for (int i = 0; i < m; i++) {
			String ab[] = scanner.nextLine().split(" ");
			Character a = ab[0].charAt(0);
			Character b = ab[1].charAt(0);
			if (translationMap.containsKey(a)) {
				Set<Character> translatedCharSet = translationMap.get(a);
				translatedCharSet.add(b);
			} else {
				Set<Character> translatedCharSet = new HashSet<>();
				translatedCharSet.add(a);
				translatedCharSet.add(b);
				translationMap.put(a, translatedCharSet);
			}
		}
		for (int i = 0; i < n; i++) {
			
		}
		System.out.println();
	}

}
