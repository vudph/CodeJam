package javacore.multithreading.wait_notify;

public class Message {
	private String msg;
	
	public Message(String msg) {
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
