package javacore.multithreading.notify_notifyall;


//When a thread calls notifyAll() method on a particular object, all threads which are waiting for the lock of that object are notified. 
//All notified threads will move from WAITING state to BLOCKED state. All these threads will get the lock of the object on a priority basis. 
//The thread which gets the lock of the object moves to RUNNING state. 
//The remaining threads will remain in BLOCKED state until they get the object lock.

public class NotifyAllTest {

	public static void main(String[] args) {
		final SharedResource s = new SharedResource();

		// Thread t1 will be waiting for lock of object 's'
		Thread t1 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t1.setName("Thread 1");
		t1.setPriority(3);
		t1.start();

		// Thread t2 will be waiting for lock of object 's'
		Thread t2 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t2.setName("Thread 2");
		t2.setPriority(1);
		t2.start();

		// Thread t3 will be waiting for lock of object 's'
		Thread t3 = new Thread() {
			@Override
			public void run() {
				s.waitMethod();
			}
		};
		t3.setName("Thread 3");
		t3.setPriority(4);
		t3.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Thread t4 will notify all threads which are waiting for lock of
		// object 's'
		Thread t4 = new Thread() {
			@Override
			public void run() {
				s.notifyAllThread();
			}
		};
		t4.setName("Thread 4");
		t4.start();
	}

}
