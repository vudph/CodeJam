package interview.technosoft;

public class Problem2 {

	public static String winner(String erica, String bob) {
		int ericScore = toScore(erica);
		int bobScore = toScore(bob);
		System.out.println(ericScore + "," + bobScore);
		if (ericScore > bobScore)
			return "Erica";
		if (ericScore < bobScore)
			return "Bob";
		return "Tie";
	}
	
	private static int toScore(String s) {
		int score = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'E') {
				score += 1;
			} else if (ch == 'M') {
				score += 3;
			} else if (ch == 'H') {
				score += 5;
			}
		}
		return score;
	}

	public static void main(String[] args) {
		System.out.println(winner("EHH", "EME"));
		
		System.out.println((int)Math.ceil(4.242640687119285));
	}

}
