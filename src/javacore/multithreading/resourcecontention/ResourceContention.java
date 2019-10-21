package javacore.multithreading.resourcecontention;

public class ResourceContention implements Runnable {
	public int idx = 0;
	static Object obj = new Object(); 
	
	@Override
	public void run() {
		System.out.println("current thread: " + idx);
		synchronized (obj) {
			System.out.println("thread " + idx + " is processing");
			int i = 0;
			while (i < 1900000000L) {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		ResourceContention rc1 = new ResourceContention();
		rc1.idx = 1;
		ResourceContention rc2 = new ResourceContention();
		rc2.idx = 2;
		ResourceContention rc3 = new ResourceContention();
		rc3.idx = 3;
		Thread t1 = new Thread(rc1);
		Thread t2 = new Thread(rc2);
		Thread t3 = new Thread(rc3);
		t1.start();
		t2.start();
		t3.start();
	}
}
