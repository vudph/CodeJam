package javacore.multithreading.deadlock;

public class DeadlockTest {

	public static void main(String[] args) {
		SharedResource s1 = new SharedResource();
		SharedResource s2 = new SharedResource();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				s1.methodOne(s2);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				s2.methodTwo(s1);
			}
		});
		t1.start();
		t2.start();
	}

}
