package javacore.multithreading.synchronization;

public class SharedNoSynchronization {
	private int i;
	private int value = 0;
	public void sharedMethod() {
		String current = Thread.currentThread().getName();
		i = 10;
		System.out.println(current + ": " + i);
		i = 20;
		System.out.println(current + ": " + i);
	}
	
	public void nextValue() {
		value++;
		System.out.println(Thread.currentThread().getName() + ": " + value);
	}

	public int getValue() {
		return value;
	}
}
