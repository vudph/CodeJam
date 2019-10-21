package javacore.multithreading.deadlock;

public class DeadLock implements Runnable {
	public int i = 0;
	static Object x = new Object();
	static Object y = new Object();

	@Override
	public void run() {
		System.out.println("current thread: " + i);
		if (i == 0) {
			synchronized (x) {
				System.out.println(x);
				synchronized (y) {
					System.out.println(y);
				}
			}
		}
		if (i == 1) {
			synchronized (y) {
				System.out.println(y);
				synchronized (x) {
					System.out.println(x);
				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLock d1 = new DeadLock();
		DeadLock d2 = new DeadLock();
		d1.i = 0;
		d2.i = 1;
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		t1.start();
		t2.start();
	}
}
