package javacore.multithreading.wait_notify;

public class Waiter implements Runnable {
	private Message msg;
	
	public Waiter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(threadName + " waiting!");
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " got notified");
			System.out.println(threadName + " processing: " + msg.getMsg());
		}
	}

}
