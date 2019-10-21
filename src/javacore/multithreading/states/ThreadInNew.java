package javacore.multithreading.states;

public class ThreadInNew {

	public static void main(String[] args) {
		Thread t = new Thread();
		// Checking the state before starting the thread
		System.out.println(t.getState()); // Output : NEW
	}

}
