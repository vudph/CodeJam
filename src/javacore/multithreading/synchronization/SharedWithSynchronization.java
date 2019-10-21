package javacore.multithreading.synchronization;

public class SharedWithSynchronization {
	int i;
	private int value = 0;
	
//	public synchronized void sharedMethod() {
	public void sharedMethod() {
		synchronized (this) {
			String current = Thread.currentThread().getName();
			i = 10;
			System.out.println(current + ": " + i);
			i = 20;
			System.out.println(current + ": " + i);
		}
	}
	
	public synchronized void nextValue() {
		value++;
		System.out.println(Thread.currentThread().getName() + ": " + value);
	}
	
	public int getValue() {
		return value;
	}
}
