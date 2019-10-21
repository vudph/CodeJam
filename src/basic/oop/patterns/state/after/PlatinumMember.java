package basic.oop.patterns.state.after;

public class PlatinumMember extends Member {

	public PlatinumMember(NewFFAccount ffAccount) {
		super(ffAccount);
		setMemberType("Platinum");
	}

	@Override
	protected void addFlight(int newMiles) {
		ffAccount.setNumberOfMiles(ffAccount.getNumberOfMiles() + (3 * newMiles));
		ffAccount.setNumberOfFlights(ffAccount.getNumberOfFlights() + 1);
		ffAccount.setNumberOfFlights(ffAccount.getNumberOfFlights() * 2);
	}
}
