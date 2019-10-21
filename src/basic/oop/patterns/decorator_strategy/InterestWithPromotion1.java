package basic.oop.patterns.decorator_strategy;

public class InterestWithPromotion1 extends PromotionDecorator {
	
	public InterestWithPromotion1(InterestStrategy interestStrategy) {
		super(interestStrategy);
	}

	@Override
	protected double calculatePromotion(double balance) {
		double promotion = balance * 0.001;
		return promotion;
	}

}
