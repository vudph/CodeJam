package javacore.testable;

public class Greeting {
	private DateTimeProvider dateTimeProvider;
	public Greeting(DateTimeProvider dateTimeProvider) {
		this.dateTimeProvider = dateTimeProvider;
	}
	
	public String sayGreeting(String niceWord) {
		String time = dateTimeProvider.getTime();
		return niceWord + " " + time;
	}
}
