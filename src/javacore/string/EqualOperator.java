package javacore.string;

public class EqualOperator {

	public static void main(String[] args) {
		String one0 = "ONE";
		String one1 = "ONE";
		String one2 = new String("ONE");
		System.out.println(one0 == one1);
		System.out.println(one0 == one2);
		System.out.println(one0.equals(one1));
		System.out.println(one0.equals(one2));
		
		one0 = "TWO";
		System.out.println(one0);
		System.out.println(one1);
	}

}
