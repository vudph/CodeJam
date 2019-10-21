package javacore.multithreading.states;

public class ThreadInWaiting {

	public static void main(String[] args) {
		final Thread t1 = new Thread() {
			public void run() {
				int i = 0;
				while (i < 999999L*21000) {
					i++;
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					t1.join(); //wait for t1 to die
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t2.start();

		t1.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Checking the state of t2 after it calls join() on t1
		System.out.println(t1.getState());
		System.out.println(t2.getState()); // Output : WAITING
	}

}
