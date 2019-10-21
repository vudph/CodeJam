package basic.oop.patterns.decorator_strategy;

public class CheckingStrategy implements InterestStrategy {

	@Override
	public double calculate(double balance) {
		return balance * 0.01;
	}

}
