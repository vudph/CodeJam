package basic.oop.patterns.state.after;

public class NewApplication {

	public static void main(String[] args) {
		NewFFAccount ffaccount = new NewFFAccount("213425");
		
		ffaccount.addFlight(13000);
		System.out.println("Accountnr =" + ffaccount.getAccountNumber());
		System.out.println("Account type =" + ffaccount.getMember().getMemberType());
		System.out.println("miles =" + ffaccount.getNumberOfMiles());
		
		ffaccount.addFlight(99000);
		System.out.println("Accountnr =" + ffaccount.getAccountNumber());
		System.out.println("Account type =" + ffaccount.getMember().getMemberType());
		System.out.println("miles =" + ffaccount.getNumberOfMiles());
		
		ffaccount.addFlight(99000);
		System.out.println("Accountnr =" + ffaccount.getAccountNumber());
		System.out.println("Account type =" + ffaccount.getMember().getMemberType());
		System.out.println("miles =" + ffaccount.getNumberOfMiles());

		ffaccount.addFlight(99000);
		System.out.println("Accountnr =" + ffaccount.getAccountNumber());
		System.out.println("Account type =" + ffaccount.getMember().getMemberType());
		System.out.println("miles =" + ffaccount.getNumberOfMiles());
	}
}
