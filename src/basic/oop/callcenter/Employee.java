package basic.oop.callcenter;

public abstract class Employee {
	protected Rank rank;
	private Call assignedCall;
	private Employee manager;

	public boolean receiveCall(Call call) {
		this.assignedCall = call;
		return false;
	}
	
	public void callCompleted() {
	}
	
	public boolean isFree() {
		return assignedCall != null;
	}

	public void escalateAndReassign() {
		manager.receiveCall(assignedCall);
	}
}
