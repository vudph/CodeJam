package basic.multithread.pause;

public class CounterThread implements Runnable {
	private CounterWindow counterWindow;
	private Counter counter;
	
	public CounterThread(CounterWindow counterWindow, Counter counter) {
		this.counterWindow = counterWindow;
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			allowPause();
			counter.increaseCounter();
			counterWindow.writeCounter();
			sleep();
		}
		done();
	}
	
	private void allowPause() {
		synchronized (counter) {
			if (counterWindow.isPaused()) {
				try {
					counter.wait();
					System.out.println("Got notified!");
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	private void done() {
		counterWindow.getButton().setText("Done");
		counterWindow.getButton().setEnabled(false);
		counterWindow.setPaused(true);
	}

	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// nothing
		}
	}
}
