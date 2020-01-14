package javacore.multithreading.wait_notify;

public class Message {
	private String msg;
	private int counter = 0;
	
	public Message(String msg) {
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void increaseCounter() {
		counter++;
		System.out.println(Thread.currentThread().getName() + ": " + counter);
	}

	public int getCounter() {
		return counter;
	}
}
