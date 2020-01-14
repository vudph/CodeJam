package javacore.multithreading.wait_notify;

public class Notifier implements Runnable {
	private Message msg;
	
	public Notifier(Message msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " started");
		synchronized (msg) {
			msg.setMsg(threadName + " work done");
			for (int i = 0; i < 10; i++) {
				msg.increaseCounter();
			}
			msg.notify();
		}
	}

}
