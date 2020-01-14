package javacore.multithreading.notify_notifyall;

// Before notification, the thread will be in WAITING state. Once it is notified, it will move to BLOCKED state. 
// It remains in BLOCKED state until it gets the lock. Once it gets the lock, it moves from BLOCKED state to RUNNING state.

public class NotifyTest {
	public static void main(String[] args) {
		final SharedResource s = new SharedResource();

		// Thread t1 will be waiting for lock of object 's'
		Thread t1 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t1.start();

		// Thread t2 will be waiting for lock of object 's'
		Thread t2 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t2.start();

		// Thread t3 will be waiting for lock of object 's'
		Thread t3 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t3.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Thread t4 will notify only one thread which is waiting for lock of
		// object 's'

		Thread t4 = new Thread() {
			@Override
			public void run() {
				s.notifyOneThread();
			}
		};
		t4.start();
		
		// after thread t1 got notified and process, the program sill hanging since there are other thread still waiting to be notified => use notifiyAll
	}
}
