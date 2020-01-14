package basic.multithread.pause;

public class Counter {
	private int count = 0;
	
	public void increaseCounter() {
		setCount(getCount() + 1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.count);
	}
}
