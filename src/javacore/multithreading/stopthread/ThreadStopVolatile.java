package javacore.multithreading.stopthread;

public class ThreadStopVolatile extends Thread {
	private volatile boolean stop = false;
	
	public void stopThread() {
		stop = true;
	}
	
	@Override
	public void run() {
		while (!stop) {
			System.out.println("I am running....");
		}
		System.out.println("Stopped Running....");
	}

}
