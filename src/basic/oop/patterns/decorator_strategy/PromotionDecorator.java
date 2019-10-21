package basic.oop.patterns.decorator_strategy;

public abstract class PromotionDecorator implements InterestStrategy {
	protected InterestStrategy interestStrategy;
	
	public PromotionDecorator(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}
	
	@Override
	public double calculate(double balance) {
		double interest = interestStrategy.calculate(balance) + calculatePromotion(balance);
		return interest;
	}
	
	abstract protected double calculatePromotion(double balance);
}
