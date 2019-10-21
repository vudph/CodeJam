package basic.oop.patterns.decorator_strategy;

public class ClientApp {
	public static void main(String[] args) {
		InterestStrategy is = new CheckingStrategy();
		InterestStrategy p1 = new InterestWithPromotion1(is);
		InterestStrategy p2 = new InterestWithPromotion2(p1);
		System.out.println(p2.calculate(10));
	}
}
