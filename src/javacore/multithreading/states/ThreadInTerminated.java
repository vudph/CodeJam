package javacore.multithreading.states;

public class ThreadInTerminated {

	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Checking the state when thread is sleeping

		System.out.println(t.getState()); // Output : TERMINATED
	}

}
