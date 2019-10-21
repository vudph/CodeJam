package javacore.multithreading.notify_notifyall;

public class SharedResource {
	synchronized void waitMethod() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " is releasing the lock and going to wait");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName() + " has been notified and acquired the lock back");
	}

	synchronized void notifyOneThread() {
		Thread t = Thread.currentThread();
		notify();
		System.out.println(t.getName() + " has notified one thread waiting for this object lock");
	}
	
	synchronized void notifyAllThread() {
		Thread t = Thread.currentThread();
		notifyAll();
		System.out.println(t.getName() + " has notified all threads waiting for this object lock");
	}
}
