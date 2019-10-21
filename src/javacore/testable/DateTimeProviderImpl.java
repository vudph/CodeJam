package javacore.testable;

import java.time.LocalDateTime;

public class DateTimeProviderImpl implements DateTimeProvider {
	private LocalDateTime dateTime;
	
	public DateTimeProviderImpl(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String getTime() {
		if (dateTime.getHour() > 5 && dateTime.getHour() < 12) {
			return "Morning";
		} else if (dateTime.getHour() >= 12 && dateTime.getHour() <= 17) {
			return "Afternoon";
		} else if (dateTime.getHour() > 17 && dateTime.getHour() <= 22) {
			return "Evening";
		}
		return "Night";
	}

}
