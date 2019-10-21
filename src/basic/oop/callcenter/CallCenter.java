package basic.oop.callcenter;

import java.util.List;

public class CallCenter {
	List<Employee> employees;
	List<List<Call>> callsQueue;
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		handleCall(call);
	}
	
	public void handleCall(Call call) {
		Employee handler = getHandlerForCall(call);
		if (handler != null) {
			boolean ok = handler.receiveCall(call);
			if (!ok) {
				call.increaseRank();
				handler.escalateAndReassign();
			}
		} else {
			callsQueue.get(call.getRank().ordinal()).add(call);
		}
	}

	private Employee getHandlerForCall(Call call) {
		for (Employee employee : employees) {
			
		}
		return null;
	}
}
