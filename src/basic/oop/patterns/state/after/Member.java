package basic.oop.patterns.state.after;

public abstract class Member {
	protected NewFFAccount ffAccount;
	protected String memberType;
	
	public Member(NewFFAccount ffAccount) {
		this.ffAccount = ffAccount;
	}
	
	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	protected abstract void addFlight(int newMiles);

}
