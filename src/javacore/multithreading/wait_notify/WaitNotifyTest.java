package javacore.multithreading.wait_notify;

public class WaitNotifyTest {

	public static void main(String[] args) {
		Message msg = new Message("process me");
		Waiter w1 = new Waiter(msg);
		new Thread(w1, "WAITER1").start();
		
		Notifier n1 = new Notifier(msg);
		new Thread(n1, "NOTIFIER").start();
		System.out.println("All threads get started");
	}

}
