package javacore.multithreading.states;

public class ThreadInRunnable {

	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();

		// Checking the state after starting the thread
		System.out.println(t.getState()); // Output : RUNNABLE
	}

}
