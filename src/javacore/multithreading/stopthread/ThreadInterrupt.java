package javacore.multithreading.stopthread;

public class ThreadInterrupt extends Thread {
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("I am running....");
		}
		System.out.println("Stopped Running.....");
	}
}
