package basic.oop.callcenter;

public class Call {
	private Caller caller;
	private Rank rank; // minimum handler can handle this call
	
	public Call(Caller caller) {
		this.rank = Rank.RESPONDER;
		this.caller = caller;
	}

	public void increaseRank() {
		
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public static void main(String[] args) {
		Rank r = Rank.DIRECTOR;
		System.out.println(r.ordinal());
	}
}
