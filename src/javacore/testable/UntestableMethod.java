package javacore.testable;

import java.time.LocalDateTime;

public class UntestableMethod {
	
	public static String getGreeting() {
		LocalDateTime dateTime = LocalDateTime.now();
		if (dateTime.getHour() > 5 && dateTime.getHour() < 12) {
			return "Good Morning";
		} else if (dateTime.getHour() >= 12 && dateTime.getHour() <= 17) {
			return "Good Afternoon";
		} else if (dateTime.getHour() > 17 && dateTime.getHour() <= 22) {
			return "Good Evening";
		}
		return "Good Night";
	}

	public static void main(String[] args) {
		System.out.println(getGreeting());
	}

}
