package javacore.multithreading.executor;

public class SharedResource {
	private int count1 = 0;
	private int count2 = 0;
	
	public void increment() {
    	count1 = count1 + 1;
    	String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + count1);
    }
	
	public synchronized void incrementSync() {
		count2 = count2 + 1;
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + count2);
    }

    public int getCount1() {
    	return count1;
    }
    
    public int getCount2() {
    	return count2;
    }
}
