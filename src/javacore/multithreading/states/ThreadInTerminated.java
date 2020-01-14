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
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Checking the state of thread after its sleeping done

		System.out.println(t.getState()); // Output : TERMINATED
	}

}
