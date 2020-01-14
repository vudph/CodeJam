package interview.technosoft;

public class Problem1 {

	public static int addNumbers(float a, float b) {
		int floor = (int)Math.floor(a + b);
				return floor;
	    }

	public static void main(String[] args) {
		float a = (float)0.9;
		float b = (float)0.9;
		System.out.println(a + b);
		System.out.println(addNumbers(a, b));
	}

}
