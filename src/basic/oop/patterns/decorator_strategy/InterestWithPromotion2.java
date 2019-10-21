package basic.oop.patterns.decorator_strategy;

public class InterestWithPromotion2 extends PromotionDecorator {

	public InterestWithPromotion2(InterestStrategy interestStrategy) {
		super(interestStrategy);
	}

	@Override
	protected double calculatePromotion(double balance) {
		return balance * 0.002;
	}

	
}
