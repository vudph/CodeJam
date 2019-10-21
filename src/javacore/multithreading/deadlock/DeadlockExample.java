package javacore.multithreading.deadlock;

import java.util.HashMap;
import java.util.Map;

public class DeadlockExample {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		Map m = new HashMap<>();
	      while (true)
	         for (int i = 0; i < 10000; i++)
	            if (!m.containsKey(new Key(i)))
	               m.put(new Key(i), "Number:" + i);
	}
	
 
	static class Key {
		Integer id;

		Key(Integer id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}
	
	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread1: holding lock1");
				System.out.println("Thread1: waiting for lock2");
				synchronized (lock2) {
					System.out.println("Thread1: holding lock1 & lock2");
				}
			}
		}
	}
	
	static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println("Thread2: holding lock2");
				System.out.println("Thread2: waiting for lock1");
				synchronized (lock1) {
					System.out.println("Thread2: holding lock2 & lock1");
				}
			}
		}
	}

}
