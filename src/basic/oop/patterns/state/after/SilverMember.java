package basic.oop.patterns.state.after;

public class SilverMember extends Member {
	
	public SilverMember(NewFFAccount ffAccount) {
		super(ffAccount);
		setMemberType("Silver");
	}

	@Override
	public void addFlight(int newMiles) {
		ffAccount.setNumberOfMiles(ffAccount.getNumberOfMiles() + newMiles);
		ffAccount.setNumberOfFlights(ffAccount.getNumberOfFlights() + 1);
		checkForUpgrade();
	}

	private void checkForUpgrade() {
		if ((ffAccount.getNumberOfMiles() > 100000) || (ffAccount.getNumberOfFlights() > 95)) {
			ffAccount.setMember(new GoldMember(ffAccount));
		}
	}
	
}
