package javacore.multithreading.synchronization;

public class SynchronizationTest {

	public static void main(String[] args) {
		SharedWithSynchronization s = new SharedWithSynchronization();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
//				s.sharedMethod();
				for (int i = 0; i < 50000; i++) {
					s.nextValue();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
//				s.sharedMethod();
				for (int i = 0; i < 50000; i++) {
					s.nextValue();
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Expected: " + 50000*2 + ". Actual: " + s.getValue());
	}

}
