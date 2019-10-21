package basic.oop.patterns.state.after;

public class NewFFAccount {
	private String accountNumber;
	private int numberOfMiles;
	private int numberOfFlights;
	private Member member;

	public NewFFAccount(String aNumber) {
		accountNumber = aNumber;
		member = new SilverMember(this);
	}

	public void addFlight(int newMiles) {
		member.addFlight(newMiles);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}
}
