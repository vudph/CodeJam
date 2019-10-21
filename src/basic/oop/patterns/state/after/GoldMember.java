package basic.oop.patterns.state.after;

public class GoldMember extends Member {

	public GoldMember(NewFFAccount ffAccount) {
		super(ffAccount);
		setMemberType("Gold");
	}

	@Override
	public void addFlight(int newMiles) {
		ffAccount.setNumberOfMiles(ffAccount.getNumberOfMiles() + (2 * newMiles));
		ffAccount.setNumberOfFlights(ffAccount.getNumberOfFlights() + 1);
		checkForUpgrade();
	}

	private void checkForUpgrade() {
		if ((ffAccount.getNumberOfMiles() > 150000) || (ffAccount.getNumberOfFlights() > 145)) {
			ffAccount.setMember(new PlatinumMember(ffAccount));
		}
	}

}
