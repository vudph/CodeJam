package javacore.multithreading.join;

public class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		System.out.println("in run() method of MyRunnable2: " + Thread.currentThread().getName());
		for (int i = 0; i < 2; i++) {
			System.out.println("i=" + i + " ,ThreadName=" + Thread.currentThread().getName());
		}
	}

}
