package basic.oop.patterns.decorator_strategy;

public class SavingStrategy implements InterestStrategy {

	@Override
	public double calculate(double balance) {
		return balance * 0.02;
	}

}
